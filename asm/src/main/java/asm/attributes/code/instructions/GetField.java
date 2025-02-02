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

import asm.ClassFile;
import asm.Method;
import asm.attributes.code.Instruction;
import asm.attributes.code.InstructionType;
import asm.attributes.code.Instructions;
import asm.attributes.code.instruction.types.GetFieldInstruction;
import asm.execution.*;
import asm.pool.Class;
import asm.pool.Field;
import org.objectweb.asm.MethodVisitor;

public class GetField extends Instruction implements GetFieldInstruction
{
	private Field field;
	private asm.Field myField;

	public GetField(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}

	public GetField(Instructions instructions, Field field)
	{
		super(instructions, InstructionType.GETFIELD);

		this.field = field;
	}

	public GetField(Instructions instructions, asm.Field field)
	{
		super(instructions, InstructionType.GETFIELD);
		this.field = field.getPoolField();
		this.myField = field;
	}

	@Override
	public String toString()
	{
		Method m = this.getInstructions().getCode().getMethod();
		return "getfield " + myField + " in " + m;// + " at pc 0x" + Integer.toHexString(this.getPc());
	}

	@Override
	public void accept(MethodVisitor visitor)
	{
		visitor.visitFieldInsn(this.getType().getCode(),
			field.getClazz().getName(),
			field.getName(),
			field.getType().toString()
		);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();

		StackContext object = stack.pop();
		ins.pop(object);

		StackContext ctx = new StackContext(ins, field.getType(), Value.UNKNOWN);
		stack.push(ctx);

		ins.push(ctx);

		if (myField != null)
		{
			frame.getExecution().order(frame, myField);
		}

		return ins;
	}

	@Override
	public Field getField()
	{
		return field;
	}

	@Override
	public asm.Field getMyField()
	{
		asm.pool.Class clazz = field.getClazz();

		ClassFile cf = this.getInstructions().getCode().getMethod().getClassFile().getGroup().findClass(clazz.getName());
		if (cf == null)
		{
			return null;
		}

		asm.Field f2 = cf.findFieldDeep(field.getName(), field.getType());
		return f2;
	}

	@Override
	public void lookup()
	{
		myField = getMyField();
	}

	@Override
	public void regeneratePool()
	{
		if (myField != null)
		{
			// only rebuild field info if the field has changed.
			// otherwise it will rewrite the pool field into to something
			// different if the field was deep
			if (getMyField() != myField)
			{
				field = myField.getPoolField();
			}
		}
	}

	@Override
	public void setField(Field field)
	{
		this.field = field;
	}
}
