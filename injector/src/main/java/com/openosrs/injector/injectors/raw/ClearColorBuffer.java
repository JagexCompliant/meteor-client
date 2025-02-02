/*
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
 * All rights reserved.
 *
 * This code is licensed under GPL3, see the complete license in
 * the LICENSE file in the root directory of this submodule.
 */
package com.openosrs.injector.injectors.raw;

import com.openosrs.injector.InjectUtil;
import com.openosrs.injector.injection.InjectData;
import com.openosrs.injector.injectors.AbstractInjector;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import asm.Method;
import asm.attributes.code.Instruction;
import asm.attributes.code.Instructions;
import asm.attributes.code.instruction.types.PushConstantInstruction;
import asm.attributes.code.instructions.ILoad;
import asm.attributes.code.instructions.InvokeStatic;
import asm.execution.Execution;
import asm.execution.InstructionContext;
import asm.execution.MethodContext;
import asm.execution.StackContext;

public class ClearColorBuffer extends AbstractInjector
{
	public ClearColorBuffer(InjectData inject)
	{
		super(inject);
	}

	public void inject()
	{

		/*
		 * This class stops the client from basically painting everything black before the scene is drawn
		 */
		final Execution exec = new Execution(inject.getVanilla());

		final asm.pool.Method clearBuffer = inject.getVanilla().findClass("Client").findMethod("clearColorBuffer").getPoolMethod();
		final asm.pool.Method fillRectPool = InjectUtil.findMethod(inject, "Rasterizer2D_fillRectangle", "Rasterizer2D", null).getPoolMethod();
		final Method drawEntities = InjectUtil.findMethod(inject, "drawEntities"); // XXX: should prob be called drawViewport?

		exec.addMethod(drawEntities);
		exec.noInvoke = true;

		final AtomicReference<MethodContext> pcontext = new AtomicReference<>(null);

		exec.addMethodContextVisitor(pcontext::set);
		exec.run();

		final MethodContext methodContext = pcontext.get();
		for (InstructionContext ic : methodContext.getInstructionContexts())
		{
			final Instruction instr = ic.getInstruction();
			if (!(instr instanceof InvokeStatic))
			{
				continue;
			}

			if (fillRectPool.equals(((InvokeStatic) instr).getMethod()))
			{
				List<StackContext> pops = ic.getPops();

				// Last pop is constant value 0, before that are vars in order
				assert pops.size() == 5 : "If this fails cause of this add in 1 for obfuscation, I don't think that happens here though";

				int i = 0;
				Instruction pushed = pops.get(i++).getPushed().getInstruction();
				assert (pushed instanceof PushConstantInstruction) && ((PushConstantInstruction) pushed).getConstant().equals(0);

				for (int varI = 3; i < 5; i++, varI--)
				{
					pushed = pops.get(i).getPushed().getInstruction();
					assert (pushed instanceof ILoad) && ((ILoad) pushed).getVariableIndex() == varI;
				}

				Instructions ins = instr.getInstructions();
				ins.replace(instr, new InvokeStatic(ins, clearBuffer));
				//log.debug("[DEBUG] Injected drawRectangle at {}", methodContext.getMethod().getPoolMethod());
			}
		}
	}
}
