import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sj")
public abstract class class469 implements class291 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Ltu;"
	)
	class514 field3930;

	class469(int var1) {
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;II)V",
		garbageValue = "-1867165172"
	)
	@Export("vmethod7769")
	abstract void vmethod7769(Buffer var1, int var2);

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Luj;B)V",
		garbageValue = "0"
	)
	public void method2343(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			class465 var3 = (class465)class12.findEnumerated(class129.method708(), var2);
			if (var3 != null) {
				switch(var3.field3927) {
				case 0:
					class12.findEnumerated(MilliClock.method1100(), var1.readUnsignedByte());
					break;
				case 1:
					int var4 = var1.readUnsignedByte();
					this.field3930 = class472.method2349(var4);
					if (this.field3930 != null) {
						break;
					}

					throw new IllegalStateException("Unknown ScriptVarType ID in VarType.decode: " + var4);
				case 2:
					var1.readStringCp1252NullCircumfixed();
					break;
				default:
					throw new IllegalStateException("Unrecognised VarTypeEncodingKey - " + var3);
				}
			} else {
				this.vmethod7769(var1, var2);
			}
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "984690534"
	)
	boolean method2345() {
		return this.field3930 != null;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/Object;",
		garbageValue = "1989421795"
	)
	Object method2346() {
		if (this.field3930 == class514.field4126) {
			return 0;
		} else if (this.field3930 == class514.field4124) {
			return -1L;
		} else {
			return this.field3930 == class514.field4125 ? "" : null;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Ltf;",
		garbageValue = "1997766495"
	)
	@Export("getDbRowType")
	public static DbRowType getDbRowType(int var0) {
		DbRowType var1 = (DbRowType)DbRowType.DBRowType_cache.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = DbRowType.field4140.takeFile(38, var0);
			var1 = new DbRowType();
			if (var2 != null) {
				var1.method2520(new Buffer(var2));
			}

			var1.method2523();
			DbRowType.DBRowType_cache.put(var1, (long)var0);
			return var1;
		}
	}
}