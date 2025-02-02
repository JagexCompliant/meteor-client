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
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import asm.pool.Class;
import org.jetbrains.annotations.NotNull;

public class Interfaces implements Iterable<Class>
{
	private final ClassFile classFile;

	private final List<Class> interfaces = new ArrayList<>();

	Interfaces(ClassFile c)
	{
		classFile = c;
	}

	public boolean addInterface(Class clazz)
	{
		if (interfaces.stream().noneMatch((itf) -> itf.getName().equals(clazz.getName())))
		{
			interfaces.add(clazz);
			return true;
		}

		return false;
	}

	public List<Class> getInterfaces()
	{
		return interfaces;
	}

	public void clear()
	{
		interfaces.clear();
	}

	public List<ClassFile> getMyInterfaces()
	{
		List<ClassFile> l = new ArrayList<>();
		for (Class clazz : interfaces)
		{
			ClassFile iface = classFile.getGroup().findClass(clazz.getName());
			if (iface != null)
			{
				l.add(iface);
			}
		}
		return l;
	}

	public List<Class> getNonMyInterfaces()
	{
		return interfaces.stream().filter(clazz -> classFile.getGroup().findClass(clazz.getName()) == null).collect(Collectors.toList());
	}

	public boolean instanceOf(ClassFile cf)
	{
		for (Class clazz : interfaces)
		{
			ClassFile iface = classFile.getGroup().findClass(clazz.getName());
			if (iface.instanceOf(cf))
			{
				return true;
			}
		}
		return false;
	}

	public List<String> getIntfNames()
	{
		final List<String> names = new ArrayList<>();
		for (ClassFile c : getMyInterfaces())
		{
			String name = DeobAnnotations.getObfuscatedName(c);
			if (name == null)
			{
				continue;
			}

			names.add(name);
		}

		return names;
	}

	@NotNull
	public Iterator<Class> iterator()
	{
		return this.interfaces.iterator();
	}
}
