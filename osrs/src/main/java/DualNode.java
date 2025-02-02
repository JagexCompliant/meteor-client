import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sn")
@Implements("DualNode")
public class DualNode extends Node {
	@ObfuscatedName("em")
	@Export("keyDual")
	public long keyDual;
	@ObfuscatedName("eo")
	@ObfuscatedSignature(
		descriptor = "Lsn;"
	)
	@Export("previousDual")
	public DualNode previousDual;
	@ObfuscatedName("ef")
	@ObfuscatedSignature(
		descriptor = "Lsn;"
	)
	@Export("nextDual")
	public DualNode nextDual;

	@ObfuscatedName("fd")
	@Export("removeDual")
	public void removeDual() {
		if (this.nextDual != null) {
			this.nextDual.previousDual = this.previousDual;
			this.previousDual.nextDual = this.nextDual;
			this.previousDual = null;
			this.nextDual = null;
		}
	}
}