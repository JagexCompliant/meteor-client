/*
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
package asm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import asm.attributes.Annotated;
import asm.attributes.Code;
import asm.attributes.Exceptions;
import asm.attributes.code.Instruction;
import asm.attributes.code.LocalVariable;
import asm.attributes.code.Parameter;
import asm.attributes.code.instruction.types.LVTInstruction;
import asm.signature.Signature;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_NATIVE;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACC_SYNCHRONIZED;

public class Method implements Annotated, Named
{
	public static final int ACCESS_MODIFIERS = ACC_PUBLIC | ACC_PRIVATE | ACC_PROTECTED;

	private final ClassFile classFile;

	private int accessFlags;
	private String name;
	private Signature arguments;
	private final Exceptions exceptions;
	@Getter
	private final Map<Type, Annotation> annotations = new LinkedHashMap<>();
	private List<Parameter> parameters;
	private Code code;

	public Method(ClassFile classFile, String name, Signature signature)
	{
		this.classFile = classFile;
		this.name = name;
		this.arguments = signature;
		exceptions = new Exceptions();
		parameters = new ArrayList<>();
	}

	public ClassFile getClassFile()
	{
		return classFile;
	}

	@Override
	public String toString()
	{
		return (this.isStatic() ? "static " : "") + classFile.getName() + "." + this.name + this.arguments;
	}

	public void accept(MethodVisitor visitor)
	{
		//This is required to name unused parameters
		for (Parameter p : parameters)
		{
			visitor.visitParameter(p.getName(), p.getAccess());
		}

		for (Annotation annotation : annotations.values())
		{
			annotation.accept(visitor.visitAnnotation(annotation.getType().toString(), true));
		}

		if (code != null)
		{
			code.getInstructions().rebuildLabels();

			visitor.visitCode();

			asm.attributes.code.Exceptions exceptions = code.getExceptions();
			for (asm.attributes.code.Exception exception : exceptions.getExceptions())
			{
				assert exception.getStart().getLabel() != null;
				assert exception.getEnd().getLabel() != null;
				assert exception.getHandler().getLabel() != null;

				int idxStart = code.getInstructions().getInstructions().indexOf(exception.getStart());
				int idxEnd = code.getInstructions().getInstructions().indexOf(exception.getEnd());

				assert idxStart != -1;
				assert idxEnd != -1;
				assert code.getInstructions().getInstructions().contains(exception.getHandler());

				assert idxEnd > idxStart;

				visitor.visitTryCatchBlock(
					exception.getStart().getLabel(),
					exception.getEnd().getLabel(),
					exception.getHandler().getLabel(),
					exception.getCatchType() != null ? exception.getCatchType().getName() : null
				);
			}

			for (Instruction i : code.getInstructions().getInstructions())
			{
				i.accept(visitor);
			}

			//Find first and last label for this method
			if (parameters.size() > 0)
			{
				Label startLabel = null;
				Label endLabel = null;
				for (Instruction i : code.getInstructions().getInstructions())
				{
					if (i instanceof asm.attributes.code.Label)
					{
						if (startLabel == null)
						{
							startLabel = ((asm.attributes.code.Label) i).getLabel();
						}
						endLabel = ((asm.attributes.code.Label) i).getLabel();
					}
				}

				for (Parameter p : parameters)
				{
					LocalVariable lv = p.getLocalVariable();
					if (lv != null)
					{
						visitor.visitLocalVariable(lv.getName(), lv.getDesc(), lv.getSignature(), startLabel, endLabel, lv.getIndex());
					}
				}
			}

			visitor.visitMaxs(code.getMaxStack(), code.getMaxLocals());
		}

		visitor.visitEnd();
	}

	public int getAccessFlags()
	{
		return accessFlags;
	}

	public void setAccessFlags(int accessFlags)
	{
		this.accessFlags = accessFlags;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Signature getDescriptor()
	{
		return arguments;
	}

	public void setDescriptor(Signature signature)
	{
		this.arguments = signature;
	}

	public Signature getObfuscatedSignature()
	{
		Signature sig = DeobAnnotations.getObfuscatedSignature(this);
		if (sig == null)
		{
			sig = arguments;
		}

		return sig;
	}

	public boolean isNative()
	{
		return (accessFlags & ACC_NATIVE) != 0;
	}

	public boolean isStatic()
	{
		return (accessFlags & ACC_STATIC) != 0;
	}

	public void setStatic(boolean s)
	{
		if (s)
		{
			accessFlags |= ACC_STATIC;
		}
		else
		{
			accessFlags &= ~ACC_STATIC;
		}
	}

	public boolean isSynchronized()
	{
		return (accessFlags & ACC_SYNCHRONIZED) != 0;
	}

	public boolean isFinal()
	{
		return (accessFlags & ACC_FINAL) != 0;
	}

	public void setFinal(boolean f)
	{
		if (f)
		{
			accessFlags |= ACC_FINAL;
		}
		else
		{
			accessFlags &= ~ACC_FINAL;
		}
	}

	public boolean isPrivate()
	{
		return (accessFlags & ACC_PRIVATE) != 0;
	}

	public void setPrivate()
	{
		accessFlags = (short) ((accessFlags & ~ACCESS_MODIFIERS) | ACC_PRIVATE);
	}

	public void setPublic()
	{
		accessFlags = (short) ((accessFlags & ~ACCESS_MODIFIERS) | ACC_PUBLIC);
	}

	public Exceptions getExceptions()
	{
		return exceptions;
	}

	public Code getCode()
	{
		return code;
	}

	public void setCode(Code code)
	{
		this.code = code;
	}

	@SuppressWarnings("unchecked")
	public <T extends Instruction & LVTInstruction> List<T> findLVTInstructionsForVariable(int index)
	{
		List<T> list = new ArrayList<>();

		if (getCode() == null)
		{
			return null;
		}

		for (Instruction ins : getCode().getInstructions().getInstructions())
		{
			if (ins instanceof LVTInstruction)
			{
				LVTInstruction lv = (LVTInstruction) ins;

				if (lv.getVariableIndex() != index)
				{
					continue;
				}

				list.add((T) ins);
			}
		}

		return list;
	}

	public asm.pool.Method getPoolMethod()
	{
		return new asm.pool.Method(
			classFile.getPoolClass(),
			name,
			arguments
		);
	}

	public List<Parameter> getParameters()
	{
		return parameters;
	}

	public void setParameters(List<Parameter> parameters)
	{
		this.parameters = parameters;
	}
}
