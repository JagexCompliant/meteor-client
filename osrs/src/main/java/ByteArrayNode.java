import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("qc")
@Implements("ByteArrayNode")
public class ByteArrayNode extends Node {
   @ObfuscatedName("aj")
   @Export("byteArray")
   public byte[] byteArray;

   public ByteArrayNode(byte[] var1) {
      this.byteArray = var1;
   }
}
