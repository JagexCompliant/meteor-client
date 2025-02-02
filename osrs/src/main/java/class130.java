import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.Callable;

@ObfuscatedName("fd")
public class class130 implements Callable {
	@ObfuscatedName("du")
	@ObfuscatedSignature(
		descriptor = "[Lup;"
	)
	@Export("worldSelectFlagSprites")
	static IndexedSprite[] worldSelectFlagSprites;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lfm;"
	)
	final class131 field1249;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lfa;"
	)
	final class132 field1248;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lfq;"
	)
	final class133 field1250;
	@ObfuscatedName("ao")
	final int field1251;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfo;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class139 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfo;Lfm;Lfa;Lfq;I)V"
	)
	class130(class139 var1, class131 var2, class132 var3, class133 var4, int var5) {
		this.this$0 = var1;
		this.field1249 = var2;
		this.field1248 = var3;
		this.field1250 = var4;
		this.field1251 = var5;
	}

	@Export("call")
	@ObfuscatedName("call")
	public Object call() {
		this.field1249.method715();
		class131[][] var1;
		if (this.field1248 == class132.field1276) {
			var1 = this.this$0.field1311;
		} else {
			var1 = this.this$0.field1316;
		}

		var1[this.field1251][this.field1250.method729()] = this.field1249;
		return null;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IIII)Luz;",
		garbageValue = "587580140"
	)
	static SpritePixels method712(int var0, int var1, int var2) {
		DemotingHashTable var3 = WorldMapRegion.WorldMapRegion_cachedSprites;
		long var4 = (long)(var2 << 16 | var0 << 8 | var1);
		return (SpritePixels)var3.get(var4);
	}

	@ObfuscatedName("mt")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "888688994"
	)
	static final void method713(int var0) {
		if (HealthBarDefinition.widgetDefinition.loadInterface(var0)) {
			Widget[] var1 = HealthBarDefinition.widgetDefinition.Widget_interfaceComponents[var0];

			for (int var2 = 0; var2 < var1.length; ++var2) {
				Widget var3 = var1[var2];
				if (var3 != null) {
					var3.modelFrame = 0;
					var3.modelFrameCycle = 0;
				}
			}

		}
	}
}