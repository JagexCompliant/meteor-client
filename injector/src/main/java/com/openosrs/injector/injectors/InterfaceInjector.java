/*
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
 * All rights reserved.
 *
 * This code is licensed under GPL3, see the complete license in
 * the LICENSE file in the root directory of this submodule.
 */
package com.openosrs.injector.injectors;

import com.openosrs.injector.injection.InjectData;
import asm.ClassFile;
import asm.Interfaces;
import asm.pool.Class;
import asm.DeobAnnotations;

import static com.openosrs.injector.Injector.report;
import static com.openosrs.injector.rsapi.RSApi.API_BASE;

public class InterfaceInjector extends AbstractInjector
{
	private int implemented = 0;

	public InterfaceInjector(InjectData inject)
	{
		super(inject);
	}

	public void inject()
	{
		// forEachPair performs actions on a deob-vanilla pair, which is what's needed here
		inject.forEachPair(this::injectInterface);

		report.add("Injected " + implemented + " class interfaces");
	}

	private void injectInterface(final ClassFile deobCf, final ClassFile vanillaCf)
	{
		final String impls = DeobAnnotations.getImplements(deobCf);

		if (impls == null)
		{
			return;
		}

		final String fullName = API_BASE + impls;
		if (!inject.getRsApi().hasClass(fullName))
		{
			if (!fullName.contains("JSON") && !deobCf.getName().contains("jagex"))
				log.error("[DEBUG] Class {} implements nonexistent interface {}, skipping interface injection",
					deobCf.getName(),
					fullName
				);

			return;
		}

		final Interfaces interfaces = vanillaCf.getInterfaces();
		interfaces.addInterface(new Class(fullName));
		implemented++;

		inject.addToDeob(fullName, deobCf);
	}
}
