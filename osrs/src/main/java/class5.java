import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@ObfuscatedName("au")
public class class5 implements class2 {
	@ObfuscatedName("at")
	final MessageDigest field5;

	@ObfuscatedSignature(
		descriptor = "(Lal;)V"
	)
	class5(class8 var1) {
		this.field5 = this.method12();
	}

	@ObfuscatedName("at")
	boolean method8(int var1, String var2, long var3) {
		byte[] var5 = this.method11(var2, var3);
		return method9(var5) >= var1;
	}

	@ObfuscatedName("ao")
	byte[] method11(String var1, long var2) {
		StringBuilder var4 = new StringBuilder();
		var4.append(var1).append(Long.toHexString(var2));
		this.field5.reset();

		try {
			this.field5.update(var4.toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException var6) {
			var6.printStackTrace();
		}

		return this.field5.digest();
	}

	@ObfuscatedName("ab")
	MessageDigest method12() {
		try {
			return MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException var2) {
			var2.printStackTrace();
			return null;
		}
	}

	@ObfuscatedName("ah")
	static int method9(byte[] var0) {
		int var1 = 0;
		byte[] var2 = var0;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			byte var4 = var2[var3];
			int var5 = method10(var4);
			var1 += var5;
			if (var5 != 8) {
				break;
			}
		}

		return var1;
	}

	@ObfuscatedName("ar")
	static int method10(byte var0) {
		int var1 = 0;
		if (var0 == 0) {
			var1 = 8;
		} else {
			for (int var2 = var0 & 255; (var2 & 128) == 0; var2 <<= 1) {
				++var1;
			}
		}

		return var1;
	}
}