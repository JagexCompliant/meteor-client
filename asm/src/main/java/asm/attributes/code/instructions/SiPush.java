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
import asm.attributes.code.instruction.types.IntInstruction;
import asm.attributes.code.instruction.types.PushConstantInstruction;
import asm.execution.*;
import org.objectweb.asm.MethodVisitor;

public class SiPush extends Instruction implements PushConstantInstruction, IntInstruction
{
	private short s;

	public SiPush(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}
	
	public SiPush(Instructions instructions, short value)
	{
		super(instructions, InstructionType.SIPUSH);

		s = value;
	}

	@Override
	public String toString()
	{
		return "sipush " + s;
	}

	@Override
	public void accept(MethodVisitor visitor)
	{
		visitor.visitIntInsn(this.getType().getCode(), s);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext ctx = new StackContext(ins, Type.INT, new Value((int) s)); // sign extend
		stack.push(ctx);
		
		ins.push(ctx);
		
		return ins;
	}

	@Override
	public Object getConstant()
	{
		return s;
	}

	@Override
	public Instruction setConstant(Object entry)
	{
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public int getOperand()
	{
		return s & 0xFFFF;
	}

	@Override
	public void setOperand(int operand)
	{
		s = (short) operand;
	}
}
