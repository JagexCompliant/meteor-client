import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tg")
final class class514 implements class513 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;Lul;I)V",
		garbageValue = "-397863290"
	)
	@Export("vmethod8274")
	public void vmethod8274(Object var1, Buffer var2) {
		this.method2520((Integer)var1, var2);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)Ljava/lang/Object;",
		garbageValue = "-1456241929"
	)
	@Export("vmethod8273")
	public Object vmethod8273(Buffer var1) {
		return var1.readInt();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Integer;Lul;I)V",
		garbageValue = "1661995876"
	)
	void method2520(Integer var1, Buffer var2) {
		var2.writeInt(var1);
	}
}