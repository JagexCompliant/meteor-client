import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("Decimator")
public class Decimator {
	@ObfuscatedName("ao")
	@Export("inputRate")
	int inputRate;
	@ObfuscatedName("ab")
	@Export("outputRate")
	int outputRate;
	@ObfuscatedName("au")
	@Export("table")
	int[][] table;

	public Decimator(int var1, int var2) {
		if (var2 != var1) {
			int var4 = var1;
			int var5 = var2;
			if (var2 > var1) {
				var4 = var2;
				var5 = var1;
			}

			while (var5 != 0) {
				int var6 = var4 % var5;
				var4 = var5;
				var5 = var6;
			}

			var1 /= var4;
			var2 /= var4;
			this.inputRate = var1;
			this.outputRate = var2;
			this.table = new int[var1][14];

			for (int var7 = 0; var7 < var1; ++var7) {
				int[] var8 = this.table[var7];
				double var9 = (double)var7 / (double)var1 + 6.0D;
				int var11 = (int)Math.floor(1.0D + (var9 - 7.0D));
				if (var11 < 0) {
					var11 = 0;
				}

				int var12 = (int)Math.ceil(var9 + 7.0D);
				if (var12 > 14) {
					var12 = 14;
				}

				for (double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
					double var15 = 3.141592653589793D * ((double)var11 - var9);
					double var17 = var13;
					if (var15 < -1.0E-4D || var15 > 1.0E-4D) {
						var17 = var13 * (Math.sin(var15) / var15);
					}

					var17 *= 0.54D + 0.46D * Math.cos(((double)var11 - var9) * 0.2243994752564138D);
					var8[var11] = (int)Math.floor(65536.0D * var17 + 0.5D);
				}
			}

		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "([BI)[B",
		garbageValue = "2088613185"
	)
	@Export("resample")
	byte[] resample(byte[] var1) {
		if (this.table != null) {
			int var2 = (int)((long)this.outputRate * (long)var1.length / (long)this.inputRate) + 14;
			int[] var3 = new int[var2];
			int var4 = 0;
			int var5 = 0;

			int var6;
			for (var6 = 0; var6 < var1.length; ++var6) {
				byte var7 = var1[var6];
				int[] var8 = this.table[var5];

				int var9;
				for (var9 = 0; var9 < 14; ++var9) {
					var3[var4 + var9] += var7 * var8[var9];
				}

				var5 += this.outputRate;
				var9 = var5 / this.inputRate;
				var4 += var9;
				var5 -= var9 * this.inputRate;
			}

			var1 = new byte[var2];

			for (var6 = 0; var6 < var2; ++var6) {
				int var10 = var3[var6] + 32768 >> 16;
				if (var10 < -128) {
					var1[var6] = -128;
				} else if (var10 > 127) {
					var1[var6] = 127;
				} else {
					var1[var6] = (byte)var10;
				}
			}
		}

		return var1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "114"
	)
	@Export("scaleRate")
	int scaleRate(int var1) {
		if (this.table != null) {
			var1 = (int)((long)var1 * (long)this.outputRate / (long)this.inputRate);
		}

		return var1;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "-9"
	)
	@Export("scalePosition")
	int scalePosition(int var1) {
		if (this.table != null) {
			var1 = (int)((long)var1 * (long)this.outputRate / (long)this.inputRate) + 6;
		}

		return var1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lfm;FZI)F",
		garbageValue = "2138001774"
	)
	static float method321(class131 var0, float var1, boolean var2) {
		float var3 = 0.0F;
		if (var0 != null && var0.method722() != 0) {
			float var4 = (float)var0.field1258[0].field1217;
			float var5 = (float)var0.field1258[var0.method722() - 1].field1217;
			float var6 = var5 - var4;
			if (0.0D == (double)var6) {
				return var0.field1258[0].field1213;
			} else {
				float var7 = 0.0F;
				if (var1 > var5) {
					var7 = (var1 - var5) / var6;
				} else {
					var7 = (var1 - var4) / var6;
				}

				double var8 = (double)((int)var7);
				float var10 = Math.abs((float)((double)var7 - var8));
				float var11 = var10 * var6;
				var8 = Math.abs(var8 + 1.0D);
				double var12 = var8 / 2.0D;
				double var14 = (double)((int)var12);
				var10 = (float)(var12 - var14);
				float var16;
				float var17;
				if (var2) {
					if (var0.field1257 == class129.field1240) {
						if (0.0D != (double)var10) {
							var11 += var4;
						} else {
							var11 = var5 - var11;
						}
					} else if (var0.field1257 != class129.field1243 && var0.field1257 != class129.field1242) {
						if (var0.field1257 == class129.field1241) {
							var11 = var4 - var1;
							var16 = var0.field1258[0].field1215;
							var17 = var0.field1258[0].field1214;
							var3 = var0.field1258[0].field1213;
							if (0.0D != (double)var16) {
								var3 -= var17 * var11 / var16;
							}

							return var3;
						}
					} else {
						var11 = var5 - var11;
					}
				} else if (var0.field1256 == class129.field1240) {
					if (0.0D != (double)var10) {
						var11 = var5 - var11;
					} else {
						var11 += var4;
					}
				} else if (var0.field1256 != class129.field1243 && var0.field1256 != class129.field1242) {
					if (var0.field1256 == class129.field1241) {
						var11 = var1 - var5;
						var16 = var0.field1258[var0.method722() - 1].field1212;
						var17 = var0.field1258[var0.method722() - 1].field1216;
						var3 = var0.field1258[var0.method722() - 1].field1213;
						if (0.0D != (double)var16) {
							var3 += var11 * var17 / var16;
						}

						return var3;
					}
				} else {
					var11 += var4;
				}

				var3 = class404.method2045(var0, var11);
				float var18;
				if (var2 && var0.field1257 == class129.field1242) {
					var18 = var0.field1258[var0.method722() - 1].field1213 - var0.field1258[0].field1213;
					var3 = (float)((double)var3 - var8 * (double)var18);
				} else if (!var2 && var0.field1256 == class129.field1242) {
					var18 = var0.field1258[var0.method722() - 1].field1213 - var0.field1258[0].field1213;
					var3 = (float)((double)var3 + var8 * (double)var18);
				}

				return var3;
			}
		} else {
			return var3;
		}
	}

	@ObfuscatedName("kb")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "-17"
	)
	static void method322(int var0, int var1) {
		int var2 = GrandExchangeOfferTotalQuantityComparator.fontBold12.stringWidth("Choose Option");

		int var3;
		for (var3 = 0; var3 < Client.menuOptionsCount; ++var3) {
			Font var4 = GrandExchangeOfferTotalQuantityComparator.fontBold12;
			String var5;
			if (var3 < 0) {
				var5 = "";
			} else if (Client.menuTargets[var3].length() > 0) {
				var5 = Client.menuActions[var3] + " " + Client.menuTargets[var3];
			} else {
				var5 = Client.menuActions[var3];
			}

			int var6 = var4.stringWidth(var5);
			if (var6 > var2) {
				var2 = var6;
			}
		}

		var2 += 8;
		var3 = Client.menuOptionsCount * 15 + 22;
		int var7 = var0 - var2 / 2;
		if (var2 + var7 > Language.canvasWidth) {
			var7 = Language.canvasWidth - var2;
		}

		if (var7 < 0) {
			var7 = 0;
		}

		int var8 = var1;
		if (var1 + var3 > class47.canvasHeight) {
			var8 = class47.canvasHeight - var3;
		}

		if (var8 < 0) {
			var8 = 0;
		}

		FriendSystem.menuX = var7;
		class60.menuY = var8;
		class428.menuWidth = var2;
		class515.menuHeight = Client.menuOptionsCount * 15 + 22;
	}

	@ObfuscatedName("mh")
	@ObfuscatedSignature(
		descriptor = "(IS)V",
		garbageValue = "-14068"
	)
	static final void method323(int var0) {
		var0 = Math.min(Math.max(var0, 0), 255);
		if (var0 != WorldMapIcon_1.clientPreferences.getCurrentMusicVolume()) {
			label22: {
				if (WorldMapIcon_1.clientPreferences.getCurrentMusicVolume() == 0) {
					boolean var1 = !class316.field2787.isEmpty();
					if (var1) {
						class72.method433(class514.archive6, var0);
						Client.playingJingle = false;
						break label22;
					}
				}

				if (var0 == 0) {
					WorldMapManager.method1265(0, 0);
					Client.playingJingle = false;
				} else {
					class251.method1334(var0);
				}
			}

			WorldMapIcon_1.clientPreferences.setCurrentMusicVolume(var0);
		}

	}
}