import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nq")
public class class360 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lnq;"
	)
	static final class360 field3179;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lnq;"
	)
	static final class360 field3180;
	@ObfuscatedName("ak")
	final int field3181;
	@ObfuscatedName("ax")
	final int field3182;

	static {
		field3179 = new class360(51, 27, 800, 0, 16, 16);
		field3180 = new class360(25, 28, 800, 656, 40, 40);
	}

	class360(int var1, int var2, int var3, int var4, int var5, int var6) {
		this.field3181 = var5;
		this.field3182 = var6;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1417914088"
	)
	public static int method1902(int var0) {
		return var0 != 0 && var0 != 1 ? -1 : 0;
	}

	@ObfuscatedName("lx")
	@ObfuscatedSignature(
		descriptor = "([Lnm;IIIZB)V",
		garbageValue = "50"
	)
	@Export("resizeInterface")
	static void resizeInterface(Widget[] var0, int var1, int var2, int var3, boolean var4) {
		for (int var5 = 0; var5 < var0.length; ++var5) {
			Widget var6 = var0[var5];
			if (var6 != null && var6.parentId == var1) {
				class140.alignWidgetSize(var6, var2, var3, var4);
				Username.alignWidgetPosition(var6, var2, var3);
				if (var6.scrollX > var6.scrollWidth - var6.width) {
					var6.scrollX = var6.scrollWidth - var6.width;
				}

				if (var6.scrollX < 0) {
					var6.scrollX = 0;
				}

				if (var6.scrollY > var6.scrollHeight - var6.height) {
					var6.scrollY = var6.scrollHeight - var6.height;
				}

				if (var6.scrollY < 0) {
					var6.scrollY = 0;
				}

				if (var6.type == 0) {
					PendingSpawn.revalidateWidgetScroll(var0, var6, var4);
				}
			}
		}

	}
}