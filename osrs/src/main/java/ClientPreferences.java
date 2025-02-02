import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

@ObfuscatedName("dl")
@Implements("ClientPreferences")
public class ClientPreferences {
	@ObfuscatedName("ab")
	@Export("roofsHidden")
	boolean roofsHidden;
	@ObfuscatedName("au")
	@Export("hideUsername")
	boolean hideUsername;
	@ObfuscatedName("aa")
	@Export("titleMusicDisabled")
	boolean titleMusicDisabled;
	@ObfuscatedName("ac")
	@Export("displayFps")
	boolean displayFps;
	@ObfuscatedName("al")
	int field1070;
	@ObfuscatedName("az")
	@Export("brightness")
	double brightness;
	@ObfuscatedName("ap")
	@Export("musicVolume")
	int musicVolume;
	@ObfuscatedName("av")
	@Export("soundEffectsVolume")
	int soundEffectsVolume;
	@ObfuscatedName("ax")
	@Export("areaSoundEffectsVolume")
	int areaSoundEffectsVolume;
	@ObfuscatedName("as")
	int field1072;
	@ObfuscatedName("ay")
	@Export("rememberedUsername")
	String rememberedUsername;
	@ObfuscatedName("ak")
	@Export("windowMode")
	int windowMode;
	@ObfuscatedName("aj")
	@Export("parameters")
	final Map parameters;

	ClientPreferences() {
		this.hideUsername = false;
		this.displayFps = false;
		this.brightness = 0.8D;
		this.musicVolume = 127;
		this.soundEffectsVolume = 127;
		this.areaSoundEffectsVolume = 127;
		this.field1072 = -1;
		this.rememberedUsername = null;
		this.windowMode = 1;
		this.parameters = new LinkedHashMap();
		this.method537(true);
	}

	@ObfuscatedSignature(
		descriptor = "(Luj;)V"
	)
	ClientPreferences(Buffer var1) {
		this.hideUsername = false;
		this.displayFps = false;
		this.brightness = 0.8D;
		this.musicVolume = 127;
		this.soundEffectsVolume = 127;
		this.areaSoundEffectsVolume = 127;
		this.field1072 = -1;
		this.rememberedUsername = null;
		this.windowMode = 1;
		this.parameters = new LinkedHashMap();
		if (var1 != null && var1.array != null) {
			int var2 = var1.readUnsignedByte();
			if (var2 >= 0 && var2 <= 10) {
				if (var1.readUnsignedByte() == 1) {
					this.roofsHidden = true;
				}

				if (var2 > 1) {
					this.titleMusicDisabled = var1.readUnsignedByte() == 1;
				}

				if (var2 > 3) {
					this.windowMode = var1.readUnsignedByte();
				}

				if (var2 > 2) {
					int var3 = var1.readUnsignedByte();

					for (int var4 = 0; var4 < var3; ++var4) {
						int var5 = var1.readInt();
						int var6 = var1.readInt();
						this.parameters.put(var5, var6);
					}
				}

				if (var2 > 4) {
					this.rememberedUsername = var1.readStringCp1252NullTerminatedOrNull();
				}

				if (var2 > 5) {
					this.hideUsername = var1.readBoolean();
				}

				if (var2 > 6) {
					this.brightness = (double)var1.readUnsignedByte() / 100.0D;
					this.musicVolume = var1.readUnsignedByte();
					this.soundEffectsVolume = var1.readUnsignedByte();
					this.areaSoundEffectsVolume = var1.readUnsignedByte();
				}

				if (var2 > 7) {
					this.field1072 = var1.readUnsignedByte();
				}

				if (var2 > 8) {
					this.displayFps = var1.readUnsignedByte() == 1;
				}

				if (var2 > 9) {
					this.field1070 = var1.readInt();
				}
			} else {
				this.method537(true);
			}
		} else {
			this.method537(true);
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "65"
	)
	void method537(boolean var1) {
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)Luj;",
		garbageValue = "1617415071"
	)
	@Export("toBuffer")
	Buffer toBuffer() {
		Buffer var1 = new Buffer(417, true);
		var1.writeByte(10);
		var1.writeByte(this.roofsHidden ? 1 : 0);
		var1.writeByte(this.titleMusicDisabled ? 1 : 0);
		var1.writeByte(this.windowMode);
		var1.writeByte(this.parameters.size());
		Iterator var2 = this.parameters.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry)var2.next();
			var1.writeInt((Integer)var3.getKey());
			var1.writeInt((Integer)var3.getValue());
		}

		var1.writeStringCp1252NullTerminated(this.rememberedUsername != null ? this.rememberedUsername : "");
		var1.writeBoolean(this.hideUsername);
		var1.writeByte((int)(this.brightness * 100.0D));
		var1.writeByte(this.musicVolume);
		var1.writeByte(this.soundEffectsVolume);
		var1.writeByte(this.areaSoundEffectsVolume);
		var1.writeByte(this.field1072);
		var1.writeByte(this.displayFps ? 1 : 0);
		var1.writeInt(this.field1070);
		return var1;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-10"
	)
	@Export("setRoofsHidden")
	void setRoofsHidden(boolean var1) {
		this.roofsHidden = var1;
		TextureProvider.savePreferences();
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-194443239"
	)
	@Export("getRoofsHidden")
	boolean getRoofsHidden() {
		return this.roofsHidden;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-2140370030"
	)
	@Export("setIsUsernameHidden")
	void setIsUsernameHidden(boolean var1) {
		this.hideUsername = var1;
		TextureProvider.savePreferences();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "190376852"
	)
	@Export("getIsUsernameHidden")
	boolean getIsUsernameHidden() {
		return this.hideUsername;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(ZS)V",
		garbageValue = "-5895"
	)
	@Export("getTitleMusicDisabled")
	void getTitleMusicDisabled(boolean var1) {
		this.titleMusicDisabled = var1;
		TextureProvider.savePreferences();
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1853874202"
	)
	@Export("getTitleMusicDisabled")
	boolean getTitleMusicDisabled() {
		return this.titleMusicDisabled;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1108077215"
	)
	void method545(boolean var1) {
		this.displayFps = var1;
		TextureProvider.savePreferences();
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-482539852"
	)
	void method546() {
		this.method545(!this.displayFps);
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "682721054"
	)
	boolean method547() {
		return this.displayFps;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IS)V",
		garbageValue = "-12427"
	)
	void method548(int var1) {
		this.field1070 = var1;
		TextureProvider.savePreferences();
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "0"
	)
	int method549() {
		return this.field1070;
	}

	@ObfuscatedName("ay")
	@Export("setBrightness")
	void setBrightness(double var1) {
		this.brightness = var1;
		TextureProvider.savePreferences();
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)D",
		garbageValue = "-2063080274"
	)
	@Export("getBrightness")
	double getBrightness() {
		return this.brightness;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1063115901"
	)
	@Export("setCurrentMusicVolume")
	void setCurrentMusicVolume(int var1) {
		this.musicVolume = var1;
		TextureProvider.savePreferences();
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "2102721692"
	)
	@Export("getCurrentMusicVolume")
	int getCurrentMusicVolume() {
		return this.musicVolume;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(IS)V",
		garbageValue = "256"
	)
	@Export("setCurrentSoundEffectVolume")
	void setCurrentSoundEffectVolume(int var1) {
		this.soundEffectsVolume = var1;
		TextureProvider.savePreferences();
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "782450849"
	)
	@Export("getCurrentSoundEffectsVolume")
	int getCurrentSoundEffectsVolume() {
		return this.soundEffectsVolume;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-568127597"
	)
	@Export("setAreaSoundEffectsVolume")
	void setAreaSoundEffectsVolume(int var1) {
		this.areaSoundEffectsVolume = var1;
		TextureProvider.savePreferences();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1804486619"
	)
	@Export("getAreaSoundEffectsVolume")
	int getAreaSoundEffectsVolume() {
		return this.areaSoundEffectsVolume;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "1092362617"
	)
	@Export("setUsernameToRemember")
	void setUsernameToRemember(String var1) {
		this.rememberedUsername = var1;
		TextureProvider.savePreferences();
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "-25"
	)
	@Export("getUsernameToRemember")
	String getUsernameToRemember() {
		return this.rememberedUsername;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "608118295"
	)
	void method560(int var1) {
		this.field1072 = var1;
		TextureProvider.savePreferences();
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-12"
	)
	int method561() {
		return this.field1072;
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "32"
	)
	void method562(int var1) {
		this.windowMode = var1;
		TextureProvider.savePreferences();
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1248539592"
	)
	int method563() {
		return this.windowMode;
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;II)V",
		garbageValue = "-1748399566"
	)
	void method564(String var1, int var2) {
		int var3 = this.method567(var1);
		if (this.parameters.size() >= 10 && !this.parameters.containsKey(var3)) {
			Iterator var4 = this.parameters.entrySet().iterator();
			var4.next();
			var4.remove();
		}

		this.parameters.put(var3, var2);
		TextureProvider.savePreferences();
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Z",
		garbageValue = "-885731567"
	)
	boolean method565(String var1) {
		int var2 = this.method567(var1);
		return this.parameters.containsKey(var2);
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)I",
		garbageValue = "1978025457"
	)
	int method566(String var1) {
		int var2 = this.method567(var1);
		return !this.parameters.containsKey(var2) ? 0 : (Integer)this.parameters.get(var2);
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)I",
		garbageValue = "8"
	)
	int method567(String var1) {
		return Message.method354(var1.toLowerCase());
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Lht;",
		garbageValue = "1728806709"
	)
	@Export("getWidget")
	public static VarbitComposition getWidget(int var0) {
		VarbitComposition var1 = (VarbitComposition)VarbitComposition.VarbitDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = VarbitComposition.VarbitDefinition_archive.takeFile(14, var0);
			var1 = new VarbitComposition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			VarbitComposition.VarbitDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "2085182056"
	)
	static int method535(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return -1;
		} else {
			return var1 >= 0 && var1 < var2.ids.length ? var2.ids[var1] : -1;
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-77"
	)
	static void method568(boolean var0) {
		byte var1 = 0;
		if (!class4.method7()) {
			var1 = 12;
		} else if (SpriteMask.client.method364() || SpriteMask.client.method366() || SpriteMask.client.method365()) {
			var1 = 10;
		}

		UserComparator7.method674(var1);
		if (var0) {
			Login.Login_username = "";
			Login.Login_password = "";
			class53.field256 = 0;
			NewShit.otp = "";
		}

		Frames.method1519();
		class150.method785();
	}
}