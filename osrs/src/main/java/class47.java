import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.locks.ReentrantLock;

@ObfuscatedName("bj")
public class class47 {
	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		descriptor = "[Lud;"
	)
	@Export("mapMarkerSprites")
	static SpritePixels[] mapMarkerSprites;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lcw;"
	)
	VorbisSample field228;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lbs;"
	)
	RawSound field227;
	@ObfuscatedName("ak")
	ReentrantLock field229;

	@ObfuscatedSignature(
		descriptor = "(Lcw;Lbs;)V"
	)
	class47(VorbisSample var1, RawSound var2) {
		this.field228 = var1;
		this.field227 = var2;
		this.field229 = new ReentrantLock();
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lom;III)Lud;",
		garbageValue = "1460191246"
	)
	@Export("SpriteBuffer_getSprite")
	public static SpritePixels SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2) {
		if (!class164.method862(var0, var1, var2)) {
			return null;
		} else {
			SpritePixels var4 = new SpritePixels();
			var4.width = class159.SpriteBuffer_spriteWidth;
			var4.height = class500.SpriteBuffer_spriteHeight;
			var4.xOffset = class326.SpriteBuffer_xOffsets[0];
			var4.yOffset = ModelData0.SpriteBuffer_yOffsets[0];
			var4.subWidth = class59.SpriteBuffer_spriteWidths[0];
			var4.subHeight = class544.SpriteBuffer_spriteHeights[0];
			int var5 = var4.subHeight * var4.subWidth;
			byte[] var6 = AddRequestTask.SpriteBuffer_pixels[0];
			var4.pixels = new int[var5];

			for (int var7 = 0; var7 < var5; ++var7) {
				var4.pixels[var7] = class372.SpriteBuffer_spritePalette[var6[var7] & 255];
			}

			class407.method2062();
			return var4;
		}
	}

	@ObfuscatedName("ja")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1083704336"
	)
	static boolean method238() {
		return (Client.drawPlayerNames & 2) != 0;
	}

	@ObfuscatedName("mt")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "117649211"
	)
	@Export("getTapToDrop")
	static boolean getTapToDrop() {
		return Client.tapToDrop;
	}
}