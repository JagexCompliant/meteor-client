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

package asm.util;

import asm.pool.Class;
import asm.pool.Field;
import asm.pool.Method;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class NameMappings
{
	private final Map<Object, String> map = new HashMap<>();

	private final Map<Object, String[]> paramMap = new HashMap<>();

	@Getter
	@Setter
	private int fields, methods, classes;

	public void map(Class cf, String name)
	{
		map.put(cf, name);
	}
	
	public void map(Field field, String name)
	{
		map.put(field, name);
	}
	
	public void map(Method method, String name)
	{
		map.put(method, name);
	}

	public void map(Method method, String[] params)
	{
		paramMap.put(method, params);
	}
	
	public String get(Object object)
	{
		return map.get(object);
	}

	public String[] getP(Method method)
	{
		return paramMap.get(method);
	}

	public Map<Object, String> getMap()
	{
		return map;
	}
}
