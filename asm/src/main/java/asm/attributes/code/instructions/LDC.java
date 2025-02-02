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
package asm.attributes.code.instructions;

import asm.Type;
import asm.attributes.code.Instruction;
import asm.attributes.code.InstructionType;
import asm.attributes.code.Instructions;
import asm.attributes.code.instruction.types.PushConstantInstruction;
import asm.execution.*;
import asm.pool.Class;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class LDC extends Instruction implements PushConstantInstruction
{
	private Object value;

	public LDC(Instructions instructions, Object value)
	{
		super(instructions, InstructionType.LDC);

		this.value = value;
	}

	@Override
	public void accept(MethodVisitor visitor)
	{
		Object object = getConstant();
		if (object instanceof asm.pool.Class)
		{
			asm.pool.Class cl = (asm.pool.Class) object;
			org.objectweb.asm.Type type = org.objectweb.asm.Type.getType("L" + cl.getName() + ";");
			visitor.visitLdcInsn(type);
		}
		else if (object.equals(0d))
		{
			visitor.visitInsn(DCONST_0);
		}
		else if (object.equals(1d))
		{
			visitor.visitInsn(DCONST_1);
		}
		else if (object.equals(0f))
		{
			visitor.visitInsn(FCONST_0);
		}
		else if (object.equals(1f))
		{
			visitor.visitInsn(FCONST_1);
		}
		else if (object.equals(2f))
		{
			visitor.visitInsn(FCONST_2);
		}
		else if (object.equals(-1))
		{
			visitor.visitInsn(ICONST_M1);
		}
		else if (object.equals(0))
		{
			visitor.visitInsn(ICONST_0);
		}
		else if (object.equals(1))
		{
			visitor.visitInsn(ICONST_1);
		}
		else if (object.equals(2))
		{
			visitor.visitInsn(ICONST_2);
		}
		else if (object.equals(3))
		{
			visitor.visitInsn(ICONST_3);
		}
		else if (object.equals(4))
		{
			visitor.visitInsn(ICONST_4);
		}
		else if (object.equals(5))
		{
			visitor.visitInsn(ICONST_5);
		}
		else if (object.equals(0L))
		{
			visitor.visitInsn(LCONST_0);
		}
		else if (object.equals(1L))
		{
			visitor.visitInsn(LCONST_1);
		}
		else
		{
			visitor.visitLdcInsn(object);
		}
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();

		StackContext ctx = new StackContext(ins, Type.getType(value), new Value(value));
		stack.push(ctx);

		ins.push(ctx);

		return ins;
	}

	@Override
	public String toString()
	{
		return "ldc " + value;
	}

	@Override
	public Object getConstant()
	{
		return value;
	}

	@Override
	public Instruction setConstant(Object entry)
	{
		value = entry;

		return this;
	}

	public int getConstantAsInt()
	{
		return (int) value;
	}

	public long getConstantAsLong()
	{
		return (long) value;
	}

	public Number getNumber()
	{
		return (Number) value;
	}

	@Override
	public void renameClass(String oldName, String newName)
	{
		Object object = getConstant();
		if (object instanceof asm.pool.Class)
		{
			if (((Class) object).getName().equals(oldName))
			{
				value = new Class(newName);
			}
		}
	}
}
