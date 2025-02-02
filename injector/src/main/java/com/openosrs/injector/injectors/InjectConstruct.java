/*
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
 * All rights reserved.
 *
 * This code is licensed under GPL3, see the complete license in
 * the LICENSE file in the root directory of this submodule.
 *
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.openosrs.injector.injectors;

import com.openosrs.injector.InjectException;
import com.openosrs.injector.InjectUtil;
import com.openosrs.injector.injection.InjectData;
import com.openosrs.injector.rsapi.RSApiMethod;
import java.util.List;
import java.util.stream.Collectors;
import asm.Annotation;
import asm.ClassFile;
import asm.Type;
import asm.attributes.Code;
import asm.attributes.code.Instruction;
import asm.attributes.code.Instructions;
import asm.attributes.code.instructions.CheckCast;
import asm.attributes.code.instructions.Dup;
import asm.attributes.code.instructions.InvokeSpecial;
import asm.attributes.code.instructions.New;
import asm.attributes.code.instructions.Return;
import asm.pool.Class;
import asm.pool.Method;
import asm.signature.Signature;

import static com.openosrs.injector.Injector.report;
import static com.openosrs.injector.rsapi.RSApi.CONSTRUCT;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

public class InjectConstruct extends AbstractInjector
{
	private int injected = 0;

	public InjectConstruct(InjectData inject)
	{
		super(inject);
	}

	@Override
	public void inject()
	{
		for (RSApiMethod apiMethod : inject.getRsApi().getConstructs())
		{
			Annotation construct = apiMethod.findAnnotation(CONSTRUCT);
			if (construct == null)
			{
				continue;
			}

			final Method method = apiMethod.getMethod();
			final Class clazz = method.getClazz();
			final ClassFile deobClass = inject.toDeob(clazz.getName());
			final ClassFile vanillaClass = inject.toVanilla(deobClass);

			injectConstruct(vanillaClass, method);
			apiMethod.setInjected(true);
			injected++;
		}

		report.add("Injected " + injected + " constructors");
	}

	private void injectConstruct(ClassFile targetClass, Method apiMethod)
	{
		//log.error("[DEBUG] Injecting constructor for {} into {}", apiMethod, targetClass.getPoolClass());

		final Type returnval = apiMethod.getType().getReturnValue();
		//System.out.println(returnval.getInternalName());
		final ClassFile deobClass = inject.toDeob(returnval.getInternalName());
		//System.out.println(deobClass.getClassName());
		final ClassFile classToConstruct = inject.toVanilla(deobClass);

		Signature constr = new Signature.Builder()
			.addArguments(apiMethod.getType().getArguments().stream()
				.map(t -> InjectUtil.apiToDeob(inject, t))
				.map(t -> InjectUtil.deobToVanilla(inject, t))
				.collect(Collectors.toList()))
			.setReturnType(Type.VOID)
			.build();

		final asm.Method constructor = classToConstruct.findMethod("<init>", constr);
		if (constructor == null)
		{
			throw new InjectException("Unable to find constructor for " + classToConstruct.getName() + ".<init>" + constr);
		}


		asm.Method setterMethod = new asm.Method(targetClass, apiMethod.getName(), apiMethod.getType());
		setterMethod.setAccessFlags(ACC_PUBLIC);
		targetClass.addMethod(setterMethod);

		final Code code = new Code(setterMethod);
		setterMethod.setCode(code);

		final Instructions instructions = code.getInstructions();
		final List<Instruction> ins = instructions.getInstructions();

		ins.add(new New(instructions, classToConstruct.getPoolClass()));
		ins.add(new Dup(instructions));

		int idx = 1;
		int parameter = 0;

		for (Type type : constructor.getDescriptor().getArguments())
		{
			Instruction load = InjectUtil.createLoadForTypeIndex(instructions, type, idx);
			idx += type.getSize();
			ins.add(load);

			Type paramType = apiMethod.getType().getTypeOfArg(parameter);
			if (!type.equals(paramType))
			{
				CheckCast checkCast = new CheckCast(instructions);
				checkCast.setType(type);
				ins.add(checkCast);
			}

			++parameter;
		}

		ins.add(new InvokeSpecial(instructions, constructor.getPoolMethod()));
		ins.add(new Return(instructions));
	}
}
