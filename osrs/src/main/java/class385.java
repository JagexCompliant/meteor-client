import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nz")
public final class class385 implements Comparable {
   @ObfuscatedName("h")
   Object field4498;
   @ObfuscatedName("e")
   Object field4497;
   @ObfuscatedName("v")
   long field4496;
   @ObfuscatedName("x")
   long field4499;

   class385(Object var1, Object var2) {
      this.field4498 = var1;
      this.field4497 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lnz;I)I",
      garbageValue = "16470781"
   )
   int method7393(class385 var1) {
      if (this.field4499 < var1.field4499) {
         return -1;
      } else {
         return this.field4499 > var1.field4499 ? 1 : 0;
      }
   }

   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      if (var1 instanceof class385) {
         return this.field4497.equals(((class385)var1).field4497);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("hashCode")
   public int hashCode() {
      return this.field4497.hashCode();
   }

   @ObfuscatedName("compareTo")
   public int compareTo(Object var1) {
      return this.method7393((class385)var1);
   }
}
