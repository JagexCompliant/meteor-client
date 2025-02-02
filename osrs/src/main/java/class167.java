import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;

@ObfuscatedName("ga")
public class class167 extends class160 {
	@ObfuscatedName("fb")
	@ObfuscatedSignature(
		descriptor = "Lro;"
	)
	@Export("js5Socket")
	static AbstractSocket js5Socket;
	@ObfuscatedName("at")
	String field1427;
	@ObfuscatedName("ah")
	byte field1425;
	@ObfuscatedName("ar")
	byte field1426;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgi;"
	)
	final class161 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgi;)V"
	)
	class167(class161 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "1810249387"
	)
	@Export("vmethod3238")
	void vmethod3238(Buffer var1) {
		this.field1427 = var1.readStringCp1252NullTerminatedOrNull();
		if (this.field1427 != null) {
			var1.readUnsignedByte();
			this.field1425 = var1.readByte();
			this.field1426 = var1.readByte();
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lgn;B)V",
		garbageValue = "-75"
	)
	@Export("vmethod3239")
	void vmethod3239(ClanChannel var1) {
		var1.name = this.field1427;
		if (this.field1427 != null) {
			var1.field1417 = this.field1425;
			var1.field1418 = this.field1426;
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)Ljava/lang/String;",
		garbageValue = "-1882833719"
	)
	@Export("colorStartTag")
	static String colorStartTag(int var0) {
		return "<col=" + Integer.toHexString(var0) + ">";
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IIIIB)I",
		garbageValue = "21"
	)
	static final int method867(int var0, int var1, int var2, int var3) {
		return var3 * var0 + var2 * var1 >> 16;
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-139333947"
	)
	@Export("getGcDuration")
	protected static int getGcDuration() {
		int var0 = 0;
		if (UserComparator10.garbageCollector == null || !UserComparator10.garbageCollector.isValid()) {
			try {
				Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

				while (var1.hasNext()) {
					GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
					if (var2.isValid()) {
						UserComparator10.garbageCollector = var2;
						GameEngine.garbageCollectorLastCheckTimeMs = -1L;
						GameEngine.garbageCollectorLastCollectionTime = -1L;
					}
				}
			} catch (Throwable var11) {
			}
		}

		if (UserComparator10.garbageCollector != null) {
			long var9 = SpotAnimationDefinition.method962();
			long var3 = UserComparator10.garbageCollector.getCollectionTime();
			if (-1L != GameEngine.garbageCollectorLastCollectionTime) {
				long var5 = var3 - GameEngine.garbageCollectorLastCollectionTime;
				long var7 = var9 - GameEngine.garbageCollectorLastCheckTimeMs;
				if (var7 != 0L) {
					var0 = (int)(var5 * 100L / var7);
				}
			}

			GameEngine.garbageCollectorLastCollectionTime = var3;
			GameEngine.garbageCollectorLastCheckTimeMs = var9;
		}

		return var0;
	}
}