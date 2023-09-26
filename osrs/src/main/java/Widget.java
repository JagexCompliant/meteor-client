import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@ObfuscatedName("nm")
@Implements("Widget")
public class Widget extends Node {
	@ObfuscatedName("ad")
	public static boolean field2978;
	@ObfuscatedName("bn")
	@Export("isIf3")
	public boolean isIf3;
	@ObfuscatedName("bk")
	@Export("id")
	public int id;
	@ObfuscatedName("by")
	@Export("childIndex")
	public int childIndex;
	@ObfuscatedName("bd")
	String field2983;
	@ObfuscatedName("be")
	@Export("type")
	public int type;
	@ObfuscatedName("bv")
	@Export("buttonType")
	public int buttonType;
	@ObfuscatedName("ba")
	@Export("contentType")
	public int contentType;
	@ObfuscatedName("bz")
	@Export("xAlignment")
	public int xAlignment;
	@ObfuscatedName("bb")
	@Export("yAlignment")
	public int yAlignment;
	@ObfuscatedName("bo")
	@Export("widthAlignment")
	public int widthAlignment;
	@ObfuscatedName("bp")
	@Export("heightAlignment")
	public int heightAlignment;
	@ObfuscatedName("bt")
	@Export("rawX")
	public int rawX;
	@ObfuscatedName("bm")
	@Export("rawY")
	public int rawY;
	@ObfuscatedName("br")
	@Export("rawWidth")
	public int rawWidth;
	@ObfuscatedName("bs")
	@Export("rawHeight")
	public int rawHeight;
	@ObfuscatedName("bc")
	@Export("x")
	public int x;
	@ObfuscatedName("bu")
	@Export("y")
	public int y;
	@ObfuscatedName("bf")
	@Export("width")
	public int width;
	@ObfuscatedName("bh")
	@Export("height")
	public int height;
	@ObfuscatedName("bl")
	public int field3017;
	@ObfuscatedName("bg")
	public int field3012;
	@ObfuscatedName("bj")
	@Export("parentId")
	public int parentId;
	@ObfuscatedName("bx")
	@Export("isHidden")
	public boolean isHidden;
	@ObfuscatedName("bi")
	@Export("scrollX")
	public int scrollX;
	@ObfuscatedName("bq")
	@Export("scrollY")
	public int scrollY;
	@ObfuscatedName("bw")
	@Export("scrollWidth")
	public int scrollWidth;
	@ObfuscatedName("ce")
	@Export("scrollHeight")
	public int scrollHeight;
	@ObfuscatedName("cu")
	@Export("color")
	public int color;
	@ObfuscatedName("cw")
	@Export("color2")
	public int color2;
	@ObfuscatedName("co")
	@Export("mouseOverColor")
	public int mouseOverColor;
	@ObfuscatedName("cc")
	@Export("mouseOverColor2")
	public int mouseOverColor2;
	@ObfuscatedName("cg")
	@Export("fill")
	public boolean fill;
	@ObfuscatedName("cq")
	@ObfuscatedSignature(
		descriptor = "Luf;"
	)
	@Export("fillMode")
	public class541 fillMode;
	@ObfuscatedName("cy")
	@Export("transparencyTop")
	public int transparencyTop;
	@ObfuscatedName("cz")
	@Export("transparencyBot")
	public int transparencyBot;
	@ObfuscatedName("cp")
	@Export("lineWid")
	public int lineWid;
	@ObfuscatedName("cb")
	public boolean field2989;
	@ObfuscatedName("cn")
	@Export("spriteId2")
	public int spriteId2;
	@ObfuscatedName("ck")
	@Export("spriteId")
	public int spriteId;
	@ObfuscatedName("cr")
	public String field3119;
	@ObfuscatedName("cs")
	@Export("spriteAngle")
	public int spriteAngle;
	@ObfuscatedName("cm")
	@Export("spriteTiling")
	public boolean spriteTiling;
	@ObfuscatedName("cv")
	@Export("outline")
	public int outline;
	@ObfuscatedName("ci")
	@Export("spriteShadow")
	public int spriteShadow;
	@ObfuscatedName("cj")
	@Export("spriteFlipV")
	public boolean spriteFlipV;
	@ObfuscatedName("cx")
	@Export("spriteFlipH")
	public boolean spriteFlipH;
	@ObfuscatedName("ch")
	@Export("modelType")
	public int modelType;
	@ObfuscatedName("cd")
	@Export("modelId")
	public int modelId;
	@ObfuscatedName("ct")
	@Export("modelType2")
	int modelType2;
	@ObfuscatedName("cf")
	@Export("modelId2")
	int modelId2;
	@ObfuscatedName("cl")
	@Export("sequenceId")
	public int sequenceId;
	@ObfuscatedName("ca")
	@Export("sequenceId2")
	public int sequenceId2;
	@ObfuscatedName("dv")
	@Export("modelOffsetX")
	public int modelOffsetX;
	@ObfuscatedName("dm")
	@Export("modelOffsetY")
	public int modelOffsetY;
	@ObfuscatedName("ds")
	@Export("modelAngleX")
	public int modelAngleX;
	@ObfuscatedName("dx")
	@Export("modelAngleY")
	public int modelAngleY;
	@ObfuscatedName("dg")
	@Export("modelAngleZ")
	public int modelAngleZ;
	@ObfuscatedName("dq")
	@Export("modelZoom")
	public int modelZoom;
	@ObfuscatedName("dz")
	@Export("modelRotation")
	public int modelRotation;
	@ObfuscatedName("dn")
	@Export("rotationKey")
	public int rotationKey;
	@ObfuscatedName("dk")
	@ObfuscatedSignature(
		descriptor = "Lni;"
	)
	public PlayerComposition field3127;
	@ObfuscatedName("df")
	@Export("modelOrthog")
	public boolean modelOrthog;
	@ObfuscatedName("de")
	@Export("modelTransparency")
	public boolean modelTransparency;
	@ObfuscatedName("dl")
	@Export("itemQuantityMode")
	public int itemQuantityMode;
	@ObfuscatedName("dp")
	@Export("fontId")
	public int fontId;
	@ObfuscatedName("do")
	@Export("text")
	public String text;
	@ObfuscatedName("dh")
	@Export("text2")
	public String text2;
	@ObfuscatedName("dj")
	@Export("textLineHeight")
	public int textLineHeight;
	@ObfuscatedName("du")
	@Export("textXAlignment")
	public int textXAlignment;
	@ObfuscatedName("dr")
	@Export("textYAlignment")
	public int textYAlignment;
	@ObfuscatedName("dw")
	@Export("textShadowed")
	public boolean textShadowed;
	@ObfuscatedName("di")
	@ObfuscatedSignature(
		descriptor = "Lgr;"
	)
	class172 field2979;
	@ObfuscatedName("dt")
	int field2982;
	@ObfuscatedName("dd")
	HashMap field2984;
	@ObfuscatedName("dy")
	HashMap field2985;
	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	class342 field2986;
	@ObfuscatedName("da")
	@Export("flags")
	public int flags;
	@ObfuscatedName("eo")
	public boolean field2998;
	@ObfuscatedName("em")
	public byte[][] field3006;
	@ObfuscatedName("el")
	public byte[][] field3005;
	@ObfuscatedName("ec")
	public int[] field3074;
	@ObfuscatedName("eg")
	public int[] field3075;
	@ObfuscatedName("ez")
	@Export("dataText")
	public String dataText;
	@ObfuscatedName("en")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("es")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	@Export("parent")
	public Widget parent;
	@ObfuscatedName("eq")
	@Export("dragZoneSize")
	public int dragZoneSize;
	@ObfuscatedName("ej")
	@Export("dragThreshold")
	public int dragThreshold;
	@ObfuscatedName("et")
	@Export("isScrollBar")
	public boolean isScrollBar;
	@ObfuscatedName("eh")
	@Export("spellActionName")
	public String spellActionName;
	@ObfuscatedName("eb")
	@Export("hasListener")
	public boolean hasListener;
	@ObfuscatedName("ev")
	@Export("onLoad")
	public Object[] onLoad;
	@ObfuscatedName("ee")
	@Export("onClick")
	public Object[] onClick;
	@ObfuscatedName("ea")
	@Export("onClickRepeat")
	public Object[] onClickRepeat;
	@ObfuscatedName("eu")
	@Export("onRelease")
	public Object[] onRelease;
	@ObfuscatedName("ey")
	@Export("onHold")
	public Object[] onHold;
	@ObfuscatedName("ep")
	@Export("onMouseOver")
	public Object[] onMouseOver;
	@ObfuscatedName("ef")
	@Export("onMouseRepeat")
	public Object[] onMouseRepeat;
	@ObfuscatedName("ew")
	@Export("onMouseLeave")
	public Object[] onMouseLeave;
	@ObfuscatedName("ed")
	@Export("onDrag")
	public Object[] onDrag;
	@ObfuscatedName("fj")
	@Export("onDragComplete")
	public Object[] onDragComplete;
	@ObfuscatedName("fh")
	@Export("onTargetEnter")
	public Object[] onTargetEnter;
	@ObfuscatedName("fz")
	@Export("onTargetLeave")
	public Object[] onTargetLeave;
	@ObfuscatedName("fs")
	@Export("onVarTransmit")
	public Object[] onVarTransmit;
	@ObfuscatedName("fl")
	@Export("varTransmitTriggers")
	public int[] varTransmitTriggers;
	@ObfuscatedName("fe")
	@Export("onInvTransmit")
	public Object[] onInvTransmit;
	@ObfuscatedName("fo")
	@Export("invTransmitTriggers")
	public int[] invTransmitTriggers;
	@ObfuscatedName("fd")
	@Export("onStatTransmit")
	public Object[] onStatTransmit;
	@ObfuscatedName("fi")
	@Export("statTransmitTriggers")
	public int[] statTransmitTriggers;
	@ObfuscatedName("fk")
	@Export("onTimer")
	public Object[] onTimer;
	@ObfuscatedName("fy")
	@Export("onOp")
	public Object[] onOp;
	@ObfuscatedName("fn")
	public Object[] field3105;
	@ObfuscatedName("fb")
	@Export("onScroll")
	public Object[] onScroll;
	@ObfuscatedName("ft")
	@Export("onChatTransmit")
	public Object[] onChatTransmit;
	@ObfuscatedName("fa")
	@Export("onKey")
	public Object[] onKey;
	@ObfuscatedName("fg")
	public Object[] field3100;
	@ObfuscatedName("fm")
	public Object[] field3104;
	@ObfuscatedName("fv")
	@Export("onFriendTransmit")
	public Object[] onFriendTransmit;
	@ObfuscatedName("ff")
	@Export("onClanTransmit")
	public Object[] onClanTransmit;
	@ObfuscatedName("fw")
	public Object[] field3113;
	@ObfuscatedName("fc")
	public Object[] field3096;
	@ObfuscatedName("fr")
	@Export("onMiscTransmit")
	public Object[] onMiscTransmit;
	@ObfuscatedName("fq")
	@Export("onDialogAbort")
	public Object[] onDialogAbort;
	@ObfuscatedName("fp")
	@Export("onSubChange")
	public Object[] onSubChange;
	@ObfuscatedName("fu")
	@Export("onResize")
	public Object[] onResize;
	@ObfuscatedName("fx")
	@Export("onStockTransmit")
	public Object[] onStockTransmit;
	@ObfuscatedName("gi")
	public Object[] field3118;
	@ObfuscatedName("ge")
	public Object[] field3117;
	@ObfuscatedName("gj")
	@Export("cs1Instructions")
	public int[][] cs1Instructions;
	@ObfuscatedName("gl")
	@Export("cs1Comparisons")
	public int[] cs1Comparisons;
	@ObfuscatedName("gq")
	@Export("cs1ComparisonValues")
	public int[] cs1ComparisonValues;
	@ObfuscatedName("gt")
	@Export("mouseOverRedirect")
	public int mouseOverRedirect;
	@ObfuscatedName("gf")
	public String field3124;
	@ObfuscatedName("gk")
	@Export("buttonText")
	public String buttonText;
	@ObfuscatedName("gm")
	public int[] field3082;
	@ObfuscatedName("gb")
	public int[] field3079;
	@ObfuscatedName("gx")
	@Export("itemId")
	public int itemId;
	@ObfuscatedName("gp")
	@Export("itemQuantity")
	public int itemQuantity;
	@ObfuscatedName("gd")
	@Export("modelFrame")
	public int modelFrame;
	@ObfuscatedName("gz")
	@Export("modelFrameCycle")
	public int modelFrameCycle;
	@ObfuscatedName("gy")
	@ObfuscatedSignature(
		descriptor = "[Lnm;"
	)
	@Export("children")
	public Widget[] children;
	@ObfuscatedName("gn")
	public boolean field3000;
	@ObfuscatedName("gr")
	public boolean field3002;
	@ObfuscatedName("gw")
	public int field3071;
	@ObfuscatedName("gs")
	public int field3068;
	@ObfuscatedName("gv")
	public int field3070;
	@ObfuscatedName("gc")
	public int field3064;
	@ObfuscatedName("ga")
	@Export("rootIndex")
	public int rootIndex;
	@ObfuscatedName("gh")
	@Export("cycle")
	public int cycle;
	@ObfuscatedName("gg")
	public int[] field3080;
	@ObfuscatedName("gu")
	@Export("noClickThrough")
	public boolean noClickThrough;
	@ObfuscatedName("go")
	@Export("noScrollThrough")
	public boolean noScrollThrough;
	@ObfuscatedName("hi")
	@Export("prioritizeMenuEntry")
	public boolean prioritizeMenuEntry;

	static {
		field2978 = false;
	}

	public Widget() {
		this.isIf3 = false;
		this.id = -1;
		this.childIndex = -1;
		this.buttonType = 0;
		this.contentType = 0;
		this.xAlignment = 0;
		this.yAlignment = 0;
		this.widthAlignment = 0;
		this.heightAlignment = 0;
		this.rawX = 0;
		this.rawY = 0;
		this.rawWidth = 0;
		this.rawHeight = 0;
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.field3017 = 1;
		this.field3012 = 1;
		this.parentId = -1;
		this.isHidden = false;
		this.scrollX = 0;
		this.scrollY = 0;
		this.scrollWidth = 0;
		this.scrollHeight = 0;
		this.color = 0;
		this.color2 = 0;
		this.mouseOverColor = 0;
		this.mouseOverColor2 = 0;
		this.fill = false;
		this.fillMode = class541.SOLID;
		this.transparencyTop = 0;
		this.transparencyBot = 0;
		this.lineWid = 1;
		this.field2989 = false;
		this.spriteId2 = -1;
		this.spriteId = -1;
		this.spriteAngle = 0;
		this.spriteTiling = false;
		this.outline = 0;
		this.spriteShadow = 0;
		this.modelType = 1;
		this.modelId = -1;
		this.modelType2 = 1;
		this.modelId2 = -1;
		this.sequenceId = -1;
		this.sequenceId2 = -1;
		this.modelOffsetX = 0;
		this.modelOffsetY = 0;
		this.modelAngleX = 0;
		this.modelAngleY = 0;
		this.modelAngleZ = 0;
		this.modelZoom = 100;
		this.modelRotation = 0;
		this.rotationKey = 0;
		this.modelOrthog = false;
		this.modelTransparency = false;
		this.itemQuantityMode = 2;
		this.fontId = -1;
		this.text = "";
		this.text2 = "";
		this.textLineHeight = 0;
		this.textXAlignment = 0;
		this.textYAlignment = 0;
		this.textShadowed = false;
		this.field2982 = -1;
		this.flags = 0;
		this.field2998 = false;
		this.dataText = "";
		this.parent = null;
		this.dragZoneSize = 0;
		this.dragThreshold = 0;
		this.isScrollBar = false;
		this.spellActionName = "";
		this.hasListener = false;
		this.mouseOverRedirect = -1;
		this.field3124 = "";
		this.buttonText = "Ok";
		this.itemId = -1;
		this.itemQuantity = 0;
		this.modelFrame = 0;
		this.modelFrameCycle = 0;
		this.field3000 = false;
		this.field3002 = false;
		this.field3071 = -1;
		this.field3068 = 0;
		this.field3070 = 0;
		this.field3064 = 0;
		this.rootIndex = -1;
		this.cycle = -1;
		this.noClickThrough = false;
		this.noScrollThrough = false;
		this.prioritizeMenuEntry = false;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)V",
		garbageValue = "256698557"
	)
	@Export("decodeLegacy")
	void decodeLegacy(Buffer var1) {
		this.isIf3 = false;
		this.type = var1.readUnsignedByte();
		this.buttonType = var1.readUnsignedByte();
		this.contentType = var1.readUnsignedShort();
		this.rawX = var1.readShort();
		this.rawY = var1.readShort();
		this.rawWidth = var1.readUnsignedShort();
		this.rawHeight = var1.readUnsignedShort();
		this.transparencyTop = var1.readUnsignedByte();
		this.parentId = var1.readUnsignedShort();
		if (this.parentId == 65535) {
			this.parentId = -1;
		} else {
			this.parentId += this.id & -65536;
		}

		this.mouseOverRedirect = var1.readUnsignedShort();
		if (this.mouseOverRedirect == 65535) {
			this.mouseOverRedirect = -1;
		}

		int var2 = var1.readUnsignedByte();
		int var3;
		if (var2 > 0) {
			this.cs1Comparisons = new int[var2];
			this.cs1ComparisonValues = new int[var2];

			for (var3 = 0; var3 < var2; ++var3) {
				this.cs1Comparisons[var3] = var1.readUnsignedByte();
				this.cs1ComparisonValues[var3] = var1.readUnsignedShort();
			}
		}

		var3 = var1.readUnsignedByte();
		int var4;
		if (var3 > 0) {
			this.cs1Instructions = new int[var3][];

			for (var4 = 0; var4 < var3; ++var4) {
				int var5 = var1.readUnsignedShort();
				this.cs1Instructions[var4] = new int[var5];

				for (int var6 = 0; var6 < var5; ++var6) {
					this.cs1Instructions[var4][var6] = var1.readUnsignedShort();
					if (this.cs1Instructions[var4][var6] == 65535) {
						this.cs1Instructions[var4][var6] = -1;
					}
				}
			}
		}

		if (this.type == 0) {
			this.scrollHeight = var1.readUnsignedShort();
			this.isHidden = var1.readUnsignedByte() == 1;
		}

		if (this.type == 1) {
			var1.readUnsignedShort();
			var1.readUnsignedByte();
		}

		if (this.type == 3) {
			this.fill = var1.readUnsignedByte() == 1;
		}

		if (this.type == 4 || this.type == 1) {
			this.textXAlignment = var1.readUnsignedByte();
			this.textYAlignment = var1.readUnsignedByte();
			this.textLineHeight = var1.readUnsignedByte();
			this.fontId = var1.readUnsignedShort();
			if (this.fontId == 65535) {
				this.fontId = -1;
			}

			this.textShadowed = var1.readUnsignedByte() == 1;
		}

		if (this.type == 4) {
			this.text = var1.readStringCp1252NullTerminated();
			this.text2 = var1.readStringCp1252NullTerminated();
		}

		if (this.type == 1 || this.type == 3 || this.type == 4) {
			this.color = var1.readInt();
		}

		if (this.type == 3 || this.type == 4) {
			this.color2 = var1.readInt();
			this.mouseOverColor = var1.readInt();
			this.mouseOverColor2 = var1.readInt();
		}

		if (this.type == 5) {
			this.spriteId2 = var1.readInt();
			this.spriteId = var1.readInt();
		}

		if (this.type == 6) {
			this.modelType = 1;
			this.modelId = var1.readUnsignedShort();
			if (this.modelId == 65535) {
				this.modelId = -1;
			}

			this.modelType2 = 1;
			this.modelId2 = var1.readUnsignedShort();
			if (this.modelId2 == 65535) {
				this.modelId2 = -1;
			}

			this.sequenceId = var1.readUnsignedShort();
			if (this.sequenceId == 65535) {
				this.sequenceId = -1;
			}

			this.sequenceId2 = var1.readUnsignedShort();
			if (this.sequenceId2 == 65535) {
				this.sequenceId2 = -1;
			}

			this.modelZoom = var1.readUnsignedShort();
			this.modelAngleX = var1.readUnsignedShort();
			this.modelAngleY = var1.readUnsignedShort();
		}

		if (this.type == 8) {
			this.text = var1.readStringCp1252NullTerminated();
		}

		if (this.buttonType == 2) {
			this.spellActionName = var1.readStringCp1252NullTerminated();
			this.field3124 = var1.readStringCp1252NullTerminated();
			var4 = var1.readUnsignedShort() & 63;
			this.flags |= var4 << 11;
		}

		if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5 || this.buttonType == 6) {
			this.buttonText = var1.readStringCp1252NullTerminated();
			if (this.buttonText.length() == 0) {
				if (this.buttonType == 1) {
					this.buttonText = "Ok";
				}

				if (this.buttonType == 4) {
					this.buttonText = "Select";
				}

				if (this.buttonType == 5) {
					this.buttonText = "Select";
				}

				if (this.buttonType == 6) {
					this.buttonText = "Continue";
				}
			}
		}

		if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5) {
			this.flags |= 4194304;
		}

		if (this.buttonType == 6) {
			this.flags |= 1;
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)V",
		garbageValue = "1307379688"
	)
	@Export("decode")
	void decode(Buffer var1) {
		var1.readUnsignedByte();
		this.isIf3 = true;
		this.type = var1.readUnsignedByte();
		this.contentType = var1.readUnsignedShort();
		this.rawX = var1.readShort();
		this.rawY = var1.readShort();
		this.rawWidth = var1.readUnsignedShort();
		if (this.type == 9) {
			this.rawHeight = var1.readShort();
		} else {
			this.rawHeight = var1.readUnsignedShort();
		}

		this.widthAlignment = var1.readByte();
		this.heightAlignment = var1.readByte();
		this.xAlignment = var1.readByte();
		this.yAlignment = var1.readByte();
		this.parentId = var1.readUnsignedShort();
		if (this.parentId == 65535) {
			this.parentId = -1;
		} else {
			this.parentId += this.id & -65536;
		}

		this.isHidden = var1.readUnsignedByte() == 1;
		if (this.type == 0) {
			this.scrollWidth = var1.readUnsignedShort();
			this.scrollHeight = var1.readUnsignedShort();
			this.noClickThrough = var1.readUnsignedByte() == 1;
		}

		if (this.type == 5) {
			this.spriteId2 = var1.readInt();
			this.spriteAngle = var1.readUnsignedShort();
			this.spriteTiling = var1.readUnsignedByte() == 1;
			this.transparencyTop = var1.readUnsignedByte();
			this.outline = var1.readUnsignedByte();
			this.spriteShadow = var1.readInt();
			this.spriteFlipV = var1.readUnsignedByte() == 1;
			this.spriteFlipH = var1.readUnsignedByte() == 1;
		}

		if (this.type == 6) {
			this.modelType = 1;
			this.modelId = var1.readUnsignedShort();
			if (this.modelId == 65535) {
				this.modelId = -1;
			}

			this.modelOffsetX = var1.readShort();
			this.modelOffsetY = var1.readShort();
			this.modelAngleX = var1.readUnsignedShort();
			this.modelAngleY = var1.readUnsignedShort();
			this.modelAngleZ = var1.readUnsignedShort();
			this.modelZoom = var1.readUnsignedShort();
			this.sequenceId = var1.readUnsignedShort();
			if (this.sequenceId == 65535) {
				this.sequenceId = -1;
			}

			this.modelOrthog = var1.readUnsignedByte() == 1;
			var1.readUnsignedShort();
			if (this.widthAlignment != 0) {
				this.modelRotation = var1.readUnsignedShort();
			}

			if (this.heightAlignment != 0) {
				var1.readUnsignedShort();
			}
		}

		if (this.type == 4) {
			this.fontId = var1.readUnsignedShort();
			if (this.fontId == 65535) {
				this.fontId = -1;
			}

			this.text = var1.readStringCp1252NullTerminated();
			this.textLineHeight = var1.readUnsignedByte();
			this.textXAlignment = var1.readUnsignedByte();
			this.textYAlignment = var1.readUnsignedByte();
			this.textShadowed = var1.readUnsignedByte() == 1;
			this.color = var1.readInt();
		}

		if (this.type == 3) {
			this.color = var1.readInt();
			this.fill = var1.readUnsignedByte() == 1;
			this.transparencyTop = var1.readUnsignedByte();
		}

		if (this.type == 9) {
			this.lineWid = var1.readUnsignedByte();
			this.color = var1.readInt();
			this.field2989 = var1.readUnsignedByte() == 1;
		}

		this.flags = var1.readMedium();
		this.dataText = var1.readStringCp1252NullTerminated();
		int var2 = var1.readUnsignedByte();
		if (var2 > 0) {
			this.actions = new String[var2];

			for (int var3 = 0; var3 < var2; ++var3) {
				this.actions[var3] = var1.readStringCp1252NullTerminated();
			}
		}

		this.dragZoneSize = var1.readUnsignedByte();
		this.dragThreshold = var1.readUnsignedByte();
		this.isScrollBar = var1.readUnsignedByte() == 1;
		this.spellActionName = var1.readStringCp1252NullTerminated();
		this.onLoad = this.readListener(var1);
		this.onMouseOver = this.readListener(var1);
		this.onMouseLeave = this.readListener(var1);
		this.onTargetLeave = this.readListener(var1);
		this.onTargetEnter = this.readListener(var1);
		this.onVarTransmit = this.readListener(var1);
		this.onInvTransmit = this.readListener(var1);
		this.onStatTransmit = this.readListener(var1);
		this.onTimer = this.readListener(var1);
		this.onOp = this.readListener(var1);
		this.onMouseRepeat = this.readListener(var1);
		this.onClick = this.readListener(var1);
		this.onClickRepeat = this.readListener(var1);
		this.onRelease = this.readListener(var1);
		this.onHold = this.readListener(var1);
		this.onDrag = this.readListener(var1);
		this.onDragComplete = this.readListener(var1);
		this.onScroll = this.readListener(var1);
		this.varTransmitTriggers = this.readListenerTriggers(var1);
		this.invTransmitTriggers = this.readListenerTriggers(var1);
		this.statTransmitTriggers = this.readListenerTriggers(var1);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)V",
		garbageValue = "-474340220"
	)
	void method1847(Buffer var1) {
		this.field2983 = var1.readStringCp1252NullTerminated();
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)[Ljava/lang/Object;",
		garbageValue = "1937096505"
	)
	@Export("readListener")
	Object[] readListener(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 == 0) {
			return null;
		} else {
			Object[] var3 = new Object[var2];

			for (int var4 = 0; var4 < var2; ++var4) {
				int var5 = var1.readUnsignedByte();
				if (var5 == 0) {
					var3[var4] = new Integer(var1.readInt());
				} else if (var5 == 1) {
					var3[var4] = var1.readStringCp1252NullTerminated();
				}
			}

			this.hasListener = true;
			return var3;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)[I",
		garbageValue = "-1309902668"
	)
	@Export("readListenerTriggers")
	int[] readListenerTriggers(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 == 0) {
			return null;
		} else {
			int[] var3 = new int[var2];

			for (int var4 = 0; var4 < var2; ++var4) {
				var3[var4] = var1.readInt();
			}

			return var3;
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lnt;ZLen;B)Lud;",
		garbageValue = "-70"
	)
	@Export("getSprite")
	public SpritePixels getSprite(WidgetDefinition var1, boolean var2, UrlRequester var3) {
		field2978 = false;
		if (this.field3119 != null) {
			SpritePixels var4 = this.method1851(var1, var3);
			if (var4 != null) {
				return var4;
			}
		}

		int var8;
		if (var2) {
			var8 = this.spriteId;
		} else {
			var8 = this.spriteId2;
		}

		if (var8 == -1) {
			return null;
		} else {
			long var5 = (long)var8 + ((long)this.outline << 36) + ((this.spriteFlipV ? 1L : 0L) << 38) + ((this.spriteFlipH ? 1L : 0L) << 39) + ((long)this.spriteShadow << 40);
			SpritePixels var7 = (SpritePixels)var1.Widget_cachedSprites.get(var5);
			if (var7 != null) {
				return var7;
			} else {
				var7 = class47.SpriteBuffer_getSprite(var1.field2919, var8, 0);
				if (var7 == null) {
					field2978 = true;
					return null;
				} else {
					this.method1854(var7);
					var1.Widget_cachedSprites.put(var7, var5);
					return var7;
				}
			}
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lnt;Len;I)Lud;",
		garbageValue = "19328064"
	)
	SpritePixels method1851(WidgetDefinition var1, UrlRequester var2) {
		if (!this.method1853()) {
			return this.method1852(var1, var2);
		} else {
			String var3 = this.field3119 + (this.spriteFlipV ? 1 : 0) + (this.spriteFlipH ? 1 : 0) + this.outline + this.spriteShadow;
			SpritePixels var4 = (SpritePixels)var1.field2921.method2216(var3);
			if (var4 == null) {
				SpritePixels var5 = this.method1852(var1, var2);
				if (var5 != null) {
					var4 = var5.method2696();
					this.method1854(var4);
					var1.field2921.method2217(var3, var4);
				}
			}

			return var4;
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Lnt;Len;S)Lud;",
		garbageValue = "9140"
	)
	SpritePixels method1852(WidgetDefinition var1, UrlRequester var2) {
		if (this.field3119 != null && var2 != null) {
			class341 var3 = (class341)var1.field2920.method2216(this.field3119);
			if (var3 == null) {
				var3 = new class341(this.field3119, var2);
				var1.field2920.method2217(this.field3119, var3);
			}

			return var3.method1747();
		} else {
			return null;
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1213670035"
	)
	boolean method1853() {
		return this.spriteFlipV || this.spriteFlipH || this.outline != 0 || this.spriteShadow != 0;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Lud;B)V",
		garbageValue = "12"
	)
	void method1854(SpritePixels var1) {
		if (this.spriteFlipV) {
			var1.flipVertically();
		}

		if (this.spriteFlipH) {
			var1.flipHorizontally();
		}

		if (this.outline > 0) {
			var1.pad(this.outline);
		}

		if (this.outline >= 1) {
			var1.outline(1);
		}

		if (this.outline >= 2) {
			var1.outline(16777215);
		}

		if (this.spriteShadow != 0) {
			var1.shadow(this.spriteShadow);
		}

	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Lnt;I)Lpu;",
		garbageValue = "-729897431"
	)
	@Export("getFont")
	public Font getFont(WidgetDefinition var1) {
		field2978 = false;
		if (this.fontId == -1) {
			return null;
		} else {
			Font var2 = (Font)var1.Widget_cachedFonts.get((long)this.fontId);
			if (var2 != null) {
				return var2;
			} else {
				AbstractArchive var4 = var1.field2919;
				AbstractArchive var5 = var1.field2918;
				int var6 = this.fontId;
				Font var3;
				if (!class164.method862(var4, var6, 0)) {
					var3 = null;
				} else {
					byte[] var8 = var5.takeFile(var6, 0);
					Font var7;
					if (var8 == null) {
						var7 = null;
					} else {
						Font var9 = new Font(var8, class326.SpriteBuffer_xOffsets, ModelData0.SpriteBuffer_yOffsets, class59.SpriteBuffer_spriteWidths, class544.SpriteBuffer_spriteHeights, class372.SpriteBuffer_spritePalette, AddRequestTask.SpriteBuffer_pixels);
						class407.method2062();
						var7 = var9;
					}

					var3 = var7;
				}

				if (var3 != null) {
					var1.Widget_cachedFonts.put(var3, (long)this.fontId);
				} else {
					field2978 = true;
				}

				return var3;
			}
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Lnt;Lif;IZLni;Lhw;Lhe;B)Ljn;",
		garbageValue = "-104"
	)
	@Export("getModel" )
	public Model getModel(WidgetDefinition var1, SequenceDefinition var2, int var3, boolean var4, PlayerComposition var5, NPCComposition var6, NewShit var7) {
		field2978 = false;
		int var8;
		int var9;
		if (var4) {
			var8 = this.modelType2;
			var9 = this.modelId2;
		} else {
			var8 = this.modelType;
			var9 = this.modelId;
		}

		if (var8 == 6) {
			if (var6 == null) {
				return null;
			}

			var9 = var6.id;
		}

		if (var8 == 0) {
			return null;
		} else if (var8 == 1 && var9 == -1) {
			return null;
		} else {
			if (var7 != null && var7.field1593 && var8 == 6) {
				var8 = 3;
			}

			long var10 = (long)(var9 + (var8 << 16));
			if (var7 != null) {
				var10 |= var7.field1594 << 20;
			}

			Model var12 = (Model)var1.Widget_cachedModels.get(var10);
			if (var12 == null) {
				ModelData var13 = null;
				int var14 = 64;
				int var15 = 768;
				switch(var8) {
				case 1:
					var13 = ModelData.ModelData_get(var1.field2916, var9, 0);
					break;
				case 2:
					var13 = class190.getNpcDefinition(var9).method1012((NewShit)null);
					break;
				case 3:
					var13 = var5 != null ? var5.getModelData() : null;
					break;
				case 4:
					ItemComposition var16 = class214.ItemDefinition_get(var9);
					var13 = var16.getModelData(10);
					var14 += var16.field1811;
					var15 += var16.field1812;
				case 5:
				default:
					break;
				case 6:
					var13 = class190.getNpcDefinition(var9).method1012(var7);
				}

				if (var13 == null) {
					field2978 = true;
					return null;
				}

				var12 = var13.toModel(var14, var15, -50, -10, -50);
				var1.Widget_cachedModels.put(var12, var10);
			}

			if (var2 != null) {
				var12 = var2.transformWidgetModel(var12, var3);
			}

			return var12;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Lnt;ZI)Lmp;",
		garbageValue = "1153974487"
	)
	public SpriteMask method1857(WidgetDefinition var1, boolean var2) {
		if (this.spriteId == -1) {
			var2 = false;
		}

		int var3 = var2 ? this.spriteId * -1637135593 * -742351705 : this.spriteId2 * 1406466773 * -514691459;
		if (var3 == -1) {
			return null;
		} else {
			long var4 = ((long)this.spriteShadow << 40) + ((this.spriteFlipV ? 1L : 0L) << 38) + (long)var3 + ((long)this.outline << 36) + ((this.spriteFlipH ? 1L : 0L) << 39);
			SpriteMask var6 = (SpriteMask)var1.Widget_cachedSpriteMasks.get(var4);
			if (var6 != null) {
				return var6;
			} else {
				SpritePixels var7 = this.getSprite(var1, var2, (UrlRequester)null);
				if (var7 == null) {
					return null;
				} else {
					SpritePixels var8 = var7.copyNormalized();
					int[] var9 = new int[var8.subHeight];
					int[] var10 = new int[var8.subHeight];

					for (int var11 = 0; var11 < var8.subHeight; ++var11) {
						int var12 = 0;
						int var13 = var8.subWidth;

						int var14;
						for (var14 = 0; var14 < var8.subWidth; ++var14) {
							if (var8.pixels[var14 + var11 * var8.subWidth] == 0) {
								var12 = var14;
								break;
							}
						}

						for (var14 = var8.subWidth - 1; var14 >= var12; --var14) {
							if (var8.pixels[var14 + var11 * var8.subWidth] == 0) {
								var13 = var14 + 1;
								break;
							}
						}

						var9[var11] = var12;
						var10[var11] = var13 - var12;
					}

					var6 = new SpriteMask(var8.subWidth, var8.subHeight, var10, var9, var3);
					var1.Widget_cachedSpriteMasks.put(var6, var4);
					return var6;
				}
			}
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;I)V",
		garbageValue = "-1879897053"
	)
	@Export("setAction")
	public void setAction(int var1, String var2) {
		if (this.actions == null || this.actions.length <= var1) {
			String[] var3 = new String[var1 + 1];
			if (this.actions != null) {
				for (int var4 = 0; var4 < this.actions.length; ++var4) {
					var3[var4] = this.actions[var4];
				}
			}

			this.actions = var3;
		}

		this.actions[var1] = var2;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1501160732"
	)
	public boolean method1859() {
		return !this.isIf3 || this.type == 0 || this.type == 11 || this.hasListener || this.contentType == 1338 || this.type == 12;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1474529826"
	)
	public boolean method1860() {
		return this.type == 11 || this.type == 12;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Len;J)V"
	)
	public void method1861(String var1, UrlRequester var2, long var3) {
		if (this.type == 11 && var3 != -1L) {
			var1 = var1.replaceAll("%userid%", Long.toString(var3));
			this.field2979 = new class172();
			if (!this.field2979.method887(var1, var2)) {
				this.field2979 = null;
			} else {
				if (this.field2984 == null || this.field2985 == null) {
					this.method1863();
				}

			}
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Len;I)V",
		garbageValue = "2097031968"
	)
	public void method1862(String var1, UrlRequester var2) {
		if (this.type == 11 && var1 != null) {
			this.field2979 = new class172();
			this.field2979.method907(var1, var2);
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-296601660"
	)
	void method1863() {
		this.field2984 = new HashMap();
		this.field2985 = new HashMap();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-652704759"
	)
	public void method1864(int var1, int var2) {
		if (this.type == 11) {
			if (this.field2984 == null) {
				this.method1863();
			}

			this.field2984.put(var1, var2);
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;II)V",
		garbageValue = "-304469184"
	)
	public void method1865(String var1, int var2) {
		if (this.type == 11) {
			if (this.field2985 == null) {
				this.method1863();
			}

			this.field2985.put(var1, var2);
		}
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(IIIII)Z",
		garbageValue = "-282270797"
	)
	public boolean method1866(int var1, int var2, int var3, int var4) {
		if (this.type == 11 && this.field2979 != null && this.method1867()) {
			var1 -= var3;
			var2 -= var4;
			int var5 = (int)(this.field2979.method897()[0] * (float)this.width);
			int var6 = (int)(this.field2979.method897()[1] * (float)this.height);
			int var7 = var5 + (int)(this.field2979.method897()[2] * (float)this.width);
			int var8 = var6 + (int)(this.field2979.method897()[3] * (float)this.height);
			return var1 >= var5 && var2 >= var6 && var1 < var7 && var2 < var8;
		} else {
			return false;
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1033886288"
	)
	public boolean method1867() {
		return this.field2982 == 2;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)I",
		garbageValue = "2104948044"
	)
	public int method1868(String var1) {
		return this.type == 11 && this.field2979 != null && this.method1867() ? this.field2979.method891(var1) : -1;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-1855282224"
	)
	public String method1869(String var1) {
		return this.type == 11 && this.field2979 != null && this.method1867() ? this.field2979.method892(var1) : null;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1779226653"
	)
	public int method1870() {
		return this.field2985 != null && this.field2985.size() > 0 ? 1 : 0;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "1"
	)
	public int method1871() {
		if (this.type == 11 && this.field2979 != null && this.field2985 != null && !this.field2985.isEmpty()) {
			String var1 = this.field2979.method896();
			return var1 != null && this.field2985.containsKey(this.field2979.method896()) ? (Integer)this.field2985.get(var1) : -1;
		} else {
			return -1;
		}
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "-80"
	)
	public String method1872() {
		if (this.type == 11 && this.field2979 != null) {
			String var1 = this.field2979.method896();
			Iterator var2 = this.field2979.method898().iterator();

			while (var2.hasNext()) {
				class183 var3 = (class183)var2.next();
				String var4 = String.format("%%%S%%", var3.method940());
				if (var3.vmethod3379() == 0) {
					var1.replaceAll(var4, Integer.toString(var3.vmethod3378()));
				} else {
					var1.replaceAll(var4, var3.vmethod3380());
				}
			}

			return var1;
		} else {
			return null;
		}
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "1962423370"
	)
	public int[] method1873() {
		if (this.type == 11 && this.field2979 != null) {
			int[] var1 = new int[3];
			int var2 = 0;
			Iterator var3 = this.field2979.method898().iterator();

			while (var3.hasNext()) {
				class183 var4 = (class183)var3.next();
				if (!var4.method940().equals("user_id")) {
					if (var4.vmethod3379() != 0) {
						return null;
					}

					var1[var2++] = var4.vmethod3378();
					if (var2 > 3) {
						return null;
					}
				}
			}

			return var1;
		} else {
			return null;
		}
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(Lnt;Len;I)Z",
		garbageValue = "-1209602899"
	)
	public boolean method1874(WidgetDefinition var1, UrlRequester var2) {
		if (this.type == 11 && this.field2979 != null) {
			this.field2979.method888(var2);
			if (this.field2979.method890() != this.field2982) {
				this.field2982 = this.field2979.method890();
				if (this.field2982 >= 100) {
					return true;
				}

				if (this.field2982 == 2) {
					this.method1875(var1);
					return true;
				}
			}

			return false;
		} else {
			return false;
		}
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(Lnt;I)V",
		garbageValue = "2132169674"
	)
	void method1875(WidgetDefinition var1) {
		this.noClickThrough = true;
		ArrayList var2 = this.field2979.method893();
		ArrayList var3 = this.field2979.method894();
		int var4 = var2.size() + var3.size();
		this.children = new Widget[var4];
		int var5 = 0;

		Iterator var6;
		Widget var8;
		for (var6 = var2.iterator(); var6.hasNext(); this.children[var5++] = var8) {
			class178 var7 = (class178)var6.next();
			var8 = ViewportMouse.method1390(5, this, var5, 0, 0, 0, 0, var7.field1461);
			var8.field3119 = var7.field1460.method663();
			class341 var9 = new class341(var7.field1460);
			var1.field2920.method2217(var8.field3119, var9);
		}

		for (var6 = var3.iterator(); var6.hasNext(); this.children[var5++] = var8) {
			class179 var10 = (class179)var6.next();
			var8 = ViewportMouse.method1390(4, this, var5, 0, 0, 0, 0, var10.field1462);
			var8.text = var10.field1466;
			var8.fontId = (Integer)this.field2984.get(var10.field1463);
			var8.textXAlignment = var10.field1464;
			var8.textYAlignment = var10.field1465;
		}

	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "101274851"
	)
	public void method1876() {
		this.field2986 = new class342();

		for (int var1 = 1; var1 <= 12; ++var1) {
			this.field2986.field2930.method102(var1, 0);
		}

		for (char var2 = 0; var2 < ' '; ++var2) {
			this.field2986.field2930.method104(var2, 0);
		}

		this.field2986.field2930.method104('\u0080', 0);
		this.field2986.field2930.method102(82, 2);
		this.field2986.field2930.method102(81, 2);
		this.field2986.field2930.method102(86, 2);
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "(B)Lnz;",
		garbageValue = "5"
	)
	public class344 method1877() {
		return this.field2986 != null ? this.field2986.field2936 : null;
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(S)Lnx;",
		garbageValue = "4477"
	)
	public class339 method1878() {
		return this.field2986 != null ? this.field2986.field2931 : null;
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(I)Lbk;",
		garbageValue = "-1397060242"
	)
	public class27 method1879() {
		return this.field2986 != null ? this.field2986.field2930 : null;
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(I)Lno;",
		garbageValue = "-280848154"
	)
	public class342 method1880() {
		return this.field2986;
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(Lnz;I)Z",
		garbageValue = "2067973032"
	)
	boolean method1881(class344 var1) {
		boolean var2 = false;
		String var5;
		String var6;
		StringBuilder var7;
		int var8;
		int var9;
		int var10;
		char var11;
		String var12;
		if (this.text != null && !this.text.isEmpty()) {
			var6 = this.text;
			var7 = new StringBuilder(var6.length());
			var8 = 0;
			var9 = -1;

			for (var10 = 0; var10 < var6.length(); ++var10) {
				var11 = var6.charAt(var10);
				if (var11 == '<') {
					var7.append(var6.substring(var8, var10));
					var9 = var10;
				} else if (var11 == '>' && var9 != -1) {
					var12 = var6.substring(var9 + 1, var10);
					var9 = -1;
					if (var12.equals("lt")) {
						var7.append("<");
					} else if (var12.equals("gt")) {
						var7.append(">");
					} else if (var12.equals("br")) {
						var7.append("\n");
					}

					var8 = var10 + 1;
				}
			}

			if (var8 < var6.length()) {
				var7.append(var6.substring(var8, var6.length()));
			}

			var5 = var7.toString();
			var2 |= var1.method1765(var5);
			this.text = "";
		}

		if (this.text2 != null && !this.text2.isEmpty()) {
			var6 = this.text2;
			var7 = new StringBuilder(var6.length());
			var8 = 0;
			var9 = -1;

			for (var10 = 0; var10 < var6.length(); ++var10) {
				var11 = var6.charAt(var10);
				if (var11 == '<') {
					var7.append(var6.substring(var8, var10));
					var9 = var10;
				} else if (var11 == '>' && var9 != -1) {
					var12 = var6.substring(var9 + 1, var10);
					var9 = -1;
					if (var12.equals("lt")) {
						var7.append("<");
					} else if (var12.equals("gt")) {
						var7.append(">");
					} else if (var12.equals("br")) {
						var7.append("\n");
					}

					var8 = var10 + 1;
				}
			}

			if (var8 < var6.length()) {
				var7.append(var6.substring(var8, var6.length()));
			}

			var5 = var7.toString();
			var2 |= var1.method1766(var5);
			this.text2 = "";
		}

		return var2;
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(Lnt;I)Z",
		garbageValue = "-636872431"
	)
	public boolean method1882(WidgetDefinition var1) {
		class344 var2 = this.method1877();
		if (var2 == null) {
			return false;
		} else {
			boolean var3 = false;
			if (!var2.method1819() && this.fontId != -1) {
				int var4 = var2.method1820();
				int var5 = var2.method1821();
				int var6 = var2.method1818();
				int var7 = var2.method1817();
				Font var8 = this.getFont(var1);
				if (var8 != null) {
					var3 |= var2.method1767(var8);
					var3 |= this.method1881(var2);
					var3 |= var2.method1772(var4, var5);
					var3 |= var2.method1787(var6, var7);
				}
			} else if (var2.method1819()) {
				var3 |= this.method1881(var2);
			}

			var2.method1762();
			return var3;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(B)Lun;",
		garbageValue = "5"
	)
	static IndexedSprite method1844() {
		IndexedSprite var0 = new IndexedSprite();
		var0.width = class159.SpriteBuffer_spriteWidth;
		var0.height = class500.SpriteBuffer_spriteHeight;
		var0.xOffset = class326.SpriteBuffer_xOffsets[0];
		var0.yOffset = ModelData0.SpriteBuffer_yOffsets[0];
		var0.subWidth = class59.SpriteBuffer_spriteWidths[0];
		var0.subHeight = class544.SpriteBuffer_spriteHeights[0];
		var0.palette = class372.SpriteBuffer_spritePalette;
		var0.pixels = AddRequestTask.SpriteBuffer_pixels[0];
		class407.method2062();
		return var0;
	}
}