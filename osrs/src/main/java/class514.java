import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tu")
public class class514 implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Ltu;"
	)
	public static final class514 field4126;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Ltu;"
	)
	public static final class514 field4124;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Ltu;"
	)
	public static final class514 field4125;
	@ObfuscatedName("ft")
	@ObfuscatedSignature(
		descriptor = "Loh;"
	)
	@Export("archive6")
	static Archive archive6;
	@ObfuscatedName("ao")
	public final int field4129;
	@ObfuscatedName("ab")
	public final int field4128;
	@ObfuscatedName("au")
	public final Class field4130;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Ltc;"
	)
	public final class510 field4131;

	static {
		field4126 = new class514(0, 0, Integer.class, new class511());
		field4124 = new class514(1, 1, Long.class, new class513());
		field4125 = new class514(2, 2, String.class, new class515());
	}

	@ObfuscatedSignature(
		descriptor = "(IILjava/lang/Class;Ltc;)V"
	)
	class514(int var1, int var2, Class var3, class510 var4) {
		this.field4129 = var1;
		this.field4128 = var2;
		this.field4130 = var3;
		this.field4131 = var4;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field4128;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)Ljava/lang/Object;",
		garbageValue = "-2037622624"
	)
	public Object method2506(Buffer var1) {
		return this.field4131.vmethod8273(var1);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)[Ltu;",
		garbageValue = "-2123619619"
	)
	public static class514[] method2503() {
		return new class514[]{field4126, field4124, field4125};
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Class;B)Ltu;",
		garbageValue = "5"
	)
	public static class514 method2504(Class var0) {
		class514[] var1 = method2503();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			class514 var3 = var1[var2];
			if (var3.field4130 == var0) {
				return var3;
			}
		}

		return null;
	}

	@ObfuscatedName("ju")
	@ObfuscatedSignature(
		descriptor = "(IIIS)V",
		garbageValue = "-5207"
	)
	@Export("worldToScreen")
	static final void worldToScreen(int var0, int var1, int var2) {
		if (var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
			int var3 = WorldMapDecorationType.getTileHeight(var0, var1, ItemLayer.Client_plane) - var2;
			var0 -= ViewportMouse.cameraX;
			var3 -= SecureRandomFuture.cameraY;
			var1 -= class36.cameraZ;
			int var4 = Rasterizer3D.Rasterizer3D_sine[Varcs.cameraPitch];
			int var5 = Rasterizer3D.Rasterizer3D_cosine[Varcs.cameraPitch];
			int var6 = Rasterizer3D.Rasterizer3D_sine[class192.cameraYaw];
			int var7 = Rasterizer3D.Rasterizer3D_cosine[class192.cameraYaw];
			int var8 = var6 * var1 + var0 * var7 >> 16;
			var1 = var7 * var1 - var0 * var6 >> 16;
			var0 = var8;
			var8 = var3 * var5 - var4 * var1 >> 16;
			var1 = var5 * var1 + var4 * var3 >> 16;
			if (var1 >= 50) {
				Client.viewportTempX = var0 * Client.viewportZoom / var1 + Client.viewportWidth / 2;
				Client.viewportTempY = var8 * Client.viewportZoom / var1 + Client.viewportHeight / 2;
			} else {
				Client.viewportTempX = -1;
				Client.viewportTempY = -1;
			}

		} else {
			Client.viewportTempX = -1;
			Client.viewportTempY = -1;
		}
	}

	@ObfuscatedName("ky")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "38"
	)
	static final boolean method2508(int var0) {
		if (var0 < 0) {
			return false;
		} else {
			int var1 = Client.menuOpcodes[var0];
			if (var1 >= 2000) {
				var1 -= 2000;
			}

			return var1 == 1007;
		}
	}

	@ObfuscatedName("mv")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1571518188"
	)
	@Export("runIntfCloseListener")
	static final void runIntfCloseListener(int var0, int var1) {
		if (HealthBarDefinition.widgetDefinition.loadInterface(var0)) {
			UserComparator5.runComponentCloseListeners(HealthBarDefinition.widgetDefinition.Widget_interfaceComponents[var0], var1);
		}
	}
}