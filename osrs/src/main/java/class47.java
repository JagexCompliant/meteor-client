import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.locks.ReentrantLock;

@ObfuscatedName("bx")
public class class47 {
	@ObfuscatedName("ae")
	@Export("canvasHeight")
	public static int canvasHeight;
	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		descriptor = "Loh;"
	)
	@Export("archive12")
	static Archive archive12;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lcv;"
	)
	VorbisSample field225;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lbt;"
	)
	RawSound field224;
	@ObfuscatedName("ar")
	ReentrantLock field226;

	@ObfuscatedSignature(
		descriptor = "(Lcv;Lbt;)V"
	)
	class47(VorbisSample var1, RawSound var2) {
		this.field225 = var1;
		this.field224 = var2;
		this.field226 = new ReentrantLock();
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "1747596015"
	)
	static int method244(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == 100) {
			DbTableType.Interpreter_intStackSize -= 3;
			var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
			int var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
			if (var4 == 0) {
				throw new RuntimeException();
			} else {
				Widget var6 = HealthBarDefinition.widgetDefinition.method1733(var3);
				if (var6.children == null) {
					var6.children = new Widget[var5 + 1];
				}

				if (var6.children.length <= var5) {
					Widget[] var7 = new Widget[var5 + 1];

					for (int var8 = 0; var8 < var6.children.length; ++var8) {
						var7[var8] = var6.children[var8];
					}

					var6.children = var7;
				}

				if (var5 > 0 && var6.children[var5 - 1] == null) {
					throw new RuntimeException("" + (var5 - 1));
				} else {
					Widget var12 = new Widget();
					var12.type = var4;
					var12.parentId = var12.id = var6.id;
					var12.childIndex = var5;
					var12.isIf3 = true;
					if (var4 == 12) {
						var12.method1870();
						var12.method1871().method1806(new class105(var12));
						var12.method1871().method1805(new class106(var12));
					}

					var6.children[var5] = var12;
					if (var2) {
						Interpreter.scriptDotWidget = var12;
					} else {
						HealthBar.scriptActiveWidget = var12;
					}

					class159.invalidateWidget(var6);
					return 1;
				}
			}
		} else {
			Widget var9;
			if (var0 == 101) {
				var9 = var2 ? Interpreter.scriptDotWidget : HealthBar.scriptActiveWidget;
				Widget var10 = HealthBarDefinition.widgetDefinition.method1733(var9.id);
				var10.children[var9.childIndex] = null;
				class159.invalidateWidget(var10);
				return 1;
			} else if (var0 == 102) {
				var9 = HealthBarDefinition.widgetDefinition.method1733(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
				var9.children = null;
				class159.invalidateWidget(var9);
				return 1;
			} else if (var0 != 200) {
				if (var0 == 201) {
					var9 = HealthBarDefinition.widgetDefinition.method1733(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
					if (var9 != null) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 1;
						if (var2) {
							Interpreter.scriptDotWidget = var9;
						} else {
							HealthBar.scriptActiveWidget = var9;
						}
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else {
					return 2;
				}
			} else {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				Widget var11 = HealthBarDefinition.widgetDefinition.getWidgetChild(var3, var4);
				if (var11 != null && var4 != -1) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 1;
					if (var2) {
						Interpreter.scriptDotWidget = var11;
					} else {
						HealthBar.scriptActiveWidget = var11;
					}
				} else {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			}
		}
	}
}