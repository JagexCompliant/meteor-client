import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.applet.Applet;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.net.URL;

@ObfuscatedName("bm")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lih;"
	)
	@Export("taskHandler")
	protected static TaskHandler taskHandler;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lbm;"
	)
	@Export("gameEngine")
	static GameEngine gameEngine;
	@ObfuscatedName("ar")
	@Export("GameEngine_redundantStartThreadCount")
	static int GameEngine_redundantStartThreadCount;
	@ObfuscatedName("ao")
	@Export("stopTimeMs")
	static long stopTimeMs;
	@ObfuscatedName("ab")
	@Export("isKilled")
	static boolean isKilled;
	@ObfuscatedName("aa")
	@Export("gameCyclesToDo")
	static int gameCyclesToDo;
	@ObfuscatedName("ac")
	@Export("cycleDurationMillis")
	static int cycleDurationMillis;
	@ObfuscatedName("al")
	@Export("fiveOrOne")
	static int fiveOrOne;
	@ObfuscatedName("az")
	@Export("fps")
	protected static int fps;
	@ObfuscatedName("ax")
	@Export("graphicsTickTimes")
	static long[] graphicsTickTimes;
	@ObfuscatedName("as")
	static int field101;
	@ObfuscatedName("ay")
	@Export("clientTickTimes")
	static long[] clientTickTimes;
	@ObfuscatedName("ba")
	static int field102;
	@ObfuscatedName("by")
	@Export("volatileFocus")
	static volatile boolean volatileFocus;
	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "Laf;"
	)
	@Export("keyHandler")
	static KeyHandler keyHandler;
	@ObfuscatedName("bs")
	@Export("garbageCollectorLastCollectionTime")
	static long garbageCollectorLastCollectionTime;
	@ObfuscatedName("bx")
	@Export("garbageCollectorLastCheckTimeMs")
	static long garbageCollectorLastCheckTimeMs;
	@ObfuscatedName("au")
	@Export("hasErrored")
	boolean hasErrored;
	@ObfuscatedName("aj")
	@Export("contentWidth")
	protected int contentWidth;
	@ObfuscatedName("am")
	@Export("contentHeight")
	protected int contentHeight;
	@ObfuscatedName("aq")
	@Export("canvasX")
	int canvasX;
	@ObfuscatedName("ai")
	@Export("canvasY")
	int canvasY;
	@ObfuscatedName("an")
	int field116;
	@ObfuscatedName("ag")
	int field114;
	@ObfuscatedName("ad")
	@Export("maxCanvasWidth")
	int maxCanvasWidth;
	@ObfuscatedName("af")
	@Export("maxCanvasHeight")
	int maxCanvasHeight;
	@ObfuscatedName("be")
	protected boolean field122;
	@ObfuscatedName("bi")
	@Export("frame")
	Frame frame;
	@ObfuscatedName("bv")
	@Export("canvas")
	java.awt.Canvas canvas;
	@ObfuscatedName("bf")
	@Export("fullRedraw")
	volatile boolean fullRedraw;
	@ObfuscatedName("bm")
	@Export("resizeCanvasNextFrame")
	boolean resizeCanvasNextFrame;
	@ObfuscatedName("bp")
	@Export("isCanvasInvalid")
	volatile boolean isCanvasInvalid;
	@ObfuscatedName("bw")
	volatile long field127;
	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "Lae;"
	)
	@Export("mouseWheelHandler")
	MouseWheelHandler mouseWheelHandler;
	@ObfuscatedName("bt")
	@Export("clipboard")
	Clipboard clipboard;
	@ObfuscatedName("bu")
	@Export("eventQueue")
	final EventQueue eventQueue;

	static {
		gameEngine = null;
		GameEngine_redundantStartThreadCount = 0;
		stopTimeMs = 0L;
		isKilled = false;
		cycleDurationMillis = 20;
		fiveOrOne = 1;
		fps = 0;
		graphicsTickTimes = new long[32];
		clientTickTimes = new long[32];
		field102 = 500;
		volatileFocus = true;
		keyHandler = new KeyHandler();
		garbageCollectorLastCollectionTime = -1L;
		garbageCollectorLastCheckTimeMs = -1L;
	}

	protected GameEngine() {
		this.hasErrored = false;
		this.canvasX = 0;
		this.canvasY = 0;
		this.field122 = false;
		this.fullRedraw = true;
		this.resizeCanvasNextFrame = false;
		this.isCanvasInvalid = false;
		this.field127 = 0L;
		EventQueue var1 = null;

		try {
			var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable var3) {
		}

		this.eventQueue = var1;
		DevicePcmPlayerProvider var2 = new DevicePcmPlayerProvider();
		PcmPlayer.pcmPlayerProvider = var2;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "-49"
	)
	@Export("setMaxCanvasSize")
	protected final void setMaxCanvasSize(int var1, int var2) {
		if (this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
			this.method167();
		}

		this.maxCanvasWidth = var1;
		this.maxCanvasHeight = var2;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;I)V",
		garbageValue = "-1974837267"
	)
	@Export("post")
	final void post(Object var1) {
		if (this.eventQueue != null) {
			for (int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
				class219.method1104(1L);
			}

			if (var1 != null) {
				this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
			}

		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Lis;",
		garbageValue = "313158588"
	)
	@Export("mouseWheel")
	protected class212 mouseWheel() {
		if (this.mouseWheelHandler == null) {
			this.mouseWheelHandler = new MouseWheelHandler();
			this.mouseWheelHandler.addTo(this.canvas);
		}

		return this.mouseWheelHandler;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2071259913"
	)
	@Export("setUpClipboard")
	protected void setUpClipboard() {
		this.clipboard = this.getToolkit().getSystemClipboard();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "-117"
	)
	protected void method150(String var1) {
		this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/awt/datatransfer/Clipboard;",
		garbageValue = "88"
	)
	@Export("getClipboard")
	public Clipboard getClipboard() {
		return this.clipboard;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "57"
	)
	@Export("setUpKeyboard")
	protected final void setUpKeyboard() {
		if (TaskHandler.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
			class28.KeyHandler_keyCodes[186] = 57;
			class28.KeyHandler_keyCodes[187] = 27;
			class28.KeyHandler_keyCodes[188] = 71;
			class28.KeyHandler_keyCodes[189] = 26;
			class28.KeyHandler_keyCodes[190] = 72;
			class28.KeyHandler_keyCodes[191] = 73;
			class28.KeyHandler_keyCodes[192] = 58;
			class28.KeyHandler_keyCodes[219] = 42;
			class28.KeyHandler_keyCodes[220] = 74;
			class28.KeyHandler_keyCodes[221] = 43;
			class28.KeyHandler_keyCodes[222] = 59;
			class28.KeyHandler_keyCodes[223] = 28;
		} else {
			class28.KeyHandler_keyCodes[44] = 71;
			class28.KeyHandler_keyCodes[45] = 26;
			class28.KeyHandler_keyCodes[46] = 72;
			class28.KeyHandler_keyCodes[47] = 73;
			class28.KeyHandler_keyCodes[59] = 57;
			class28.KeyHandler_keyCodes[61] = 27;
			class28.KeyHandler_keyCodes[91] = 42;
			class28.KeyHandler_keyCodes[92] = 74;
			class28.KeyHandler_keyCodes[93] = 43;
			class28.KeyHandler_keyCodes[192] = 28;
			class28.KeyHandler_keyCodes[222] = 58;
			class28.KeyHandler_keyCodes[520] = 59;
		}

		keyHandler.method101(this.canvas);
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-379793759"
	)
	protected final void method153() {
		keyHandler.method103();
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Lbi;II)V",
		garbageValue = "1492984668"
	)
	protected void method154(class29 var1, int var2) {
		keyHandler.method99(var1, var2);
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-1"
	)
	protected final void method155() {
		java.awt.Canvas var1 = this.canvas;
		var1.addMouseListener(MouseHandler.MouseHandler_instance);
		var1.addMouseMotionListener(MouseHandler.MouseHandler_instance);
		var1.addFocusListener(MouseHandler.MouseHandler_instance);
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "27503"
	)
	@Export("resizeCanvas")
	final void resizeCanvas() {
		Container var1 = this.container();
		if (var1 != null) {
			Bounds var2 = this.getFrameContentBounds();
			this.contentWidth = Math.max(var2.highX, this.field116);
			this.contentHeight = Math.max(var2.highY, this.field114);
			if (this.contentWidth <= 0) {
				this.contentWidth = 1;
			}

			if (this.contentHeight <= 0) {
				this.contentHeight = 1;
			}

			Language.canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
			class47.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
			this.canvasX = (this.contentWidth - Language.canvasWidth) / 2;
			this.canvasY = 0;
			this.canvas.setSize(Language.canvasWidth, class47.canvasHeight);
			class338.rasterProvider = new RasterProvider(Language.canvasWidth, class47.canvasHeight, this.canvas, this.field122);
			if (var1 == this.frame) {
				Insets var3 = this.frame.getInsets();
				this.canvas.setLocation(var3.left + this.canvasX, this.canvasY + var3.top);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}

			this.fullRedraw = true;
			this.resizeGame();
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "101"
	)
	@Export("resizeGame")
	protected abstract void resizeGame();

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "103216408"
	)
	@Export("clearBackground")
	void clearBackground() {
		int var1 = this.canvasX;
		int var2 = this.canvasY;
		int var3 = this.contentWidth - Language.canvasWidth - var1;
		int var4 = this.contentHeight - class47.canvasHeight - var2;
		if (var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
			try {
				Container var5 = this.container();
				int var6 = 0;
				int var7 = 0;
				if (var5 == this.frame) {
					Insets var8 = this.frame.getInsets();
					var6 = var8.left;
					var7 = var8.top;
				}

				Graphics var10 = var5.getGraphics();
				var10.setColor(Color.black);
				if (var1 > 0) {
					var10.fillRect(var6, var7, var1, this.contentHeight);
				}

				if (var2 > 0) {
					var10.fillRect(var6, var7, this.contentWidth, var2);
				}

				if (var3 > 0) {
					var10.fillRect(var6 + this.contentWidth - var3, var7, var3, this.contentHeight);
				}

				if (var4 > 0) {
					var10.fillRect(var6, var7 + this.contentHeight - var4, this.contentWidth, var4);
				}
			} catch (Exception var9) {
			}
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1609680743"
	)
	@Export("replaceCanvas")
	final void replaceCanvas() {
		keyHandler.method102(this.canvas);
		class339.method1743(this.canvas);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.method79(this.canvas);
		}

		this.addCanvas();
		keyHandler.method101(this.canvas);
		java.awt.Canvas var1 = this.canvas;
		var1.addMouseListener(MouseHandler.MouseHandler_instance);
		var1.addMouseMotionListener(MouseHandler.MouseHandler_instance);
		var1.addFocusListener(MouseHandler.MouseHandler_instance);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.addTo(this.canvas);
		}

		this.method167();
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "958927213"
	)
	@Export("startThread")
	protected final void startThread(int var1, int var2, int var3, int var4) {
		try {
			if (gameEngine != null) {
				++GameEngine_redundantStartThreadCount;
				if (GameEngine_redundantStartThreadCount >= 3) {
					this.error("alreadyloaded");
					return;
				}

				this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
				return;
			}

			gameEngine = this;
			Language.canvasWidth = var1;
			class47.canvasHeight = var2;
			class145.RunException_revision = var3;
			RunException.field4318 = var4;
			RunException.RunException_applet = this;
			if (taskHandler == null) {
				taskHandler = new TaskHandler();
			}

			taskHandler.newThreadTask(this, 1);
		} catch (Exception var6) {
			GrandExchangeOfferWorldComparator.RunException_sendStackTrace((String)null, var6);
			this.error("crash");
		}

	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1184721348"
	)
	@Export("addCanvas")
	final synchronized void addCanvas() {
		Container var1 = this.container();
		if (this.canvas != null) {
			this.canvas.removeFocusListener(this);
			var1.remove(this.canvas);
		}

		Language.canvasWidth = Math.max(var1.getWidth(), this.field116);
		class47.canvasHeight = Math.max(var1.getHeight(), this.field114);
		Insets var2;
		if (this.frame != null) {
			var2 = this.frame.getInsets();
			Language.canvasWidth -= var2.left + var2.right;
			class47.canvasHeight -= var2.top + var2.bottom;
		}

		this.canvas = new Canvas(this);
		var1.setBackground(Color.BLACK);
		var1.setLayout((LayoutManager)null);
		var1.add(this.canvas);
		this.canvas.setSize(Language.canvasWidth, class47.canvasHeight);
		this.canvas.setVisible(true);
		this.canvas.setBackground(Color.BLACK);
		if (var1 == this.frame) {
			var2 = this.frame.getInsets();
			this.canvas.setLocation(this.canvasX + var2.left, var2.top + this.canvasY);
		} else {
			this.canvas.setLocation(this.canvasX, this.canvasY);
		}

		this.canvas.addFocusListener(this);
		this.canvas.requestFocus();
		this.fullRedraw = true;
		if (class338.rasterProvider != null && Language.canvasWidth == class338.rasterProvider.width && class47.canvasHeight == class338.rasterProvider.height) {
			((RasterProvider)class338.rasterProvider).setComponent(this.canvas);
			class338.rasterProvider.drawFull(0, 0);
		} else {
			class338.rasterProvider = new RasterProvider(Language.canvasWidth, class47.canvasHeight, this.canvas, this.field122);
		}

		this.isCanvasInvalid = false;
		this.field127 = SpotAnimationDefinition.method962();
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "1876817454"
	)
	protected void method161(boolean var1) {
		if (this.field122 != var1) {
			this.field122 = var1;
			class338.rasterProvider.method2663(var1);
			class338.rasterProvider.apply();
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1264805931"
	)
	@Export("checkHost")
	protected final boolean checkHost() {
		String var1 = this.getDocumentBase().getHost().toLowerCase();
		if (!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
			if (!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
				if (var1.endsWith("127.0.0.1")) {
					return true;
				} else {
					while (var1.length() > 0 && var1.charAt(var1.length() - 1) >= '0' && var1.charAt(var1.length() - 1) <= '9') {
						var1 = var1.substring(0, var1.length() - 1);
					}

					if (var1.endsWith("192.168.1.")) {
						return true;
					} else {
						this.error("invalidhost");
						return false;
					}
				}
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1012835334"
	)
	@Export("clientTick")
	void clientTick() {
		long var1 = SpotAnimationDefinition.method962();
		long var3 = clientTickTimes[class18.field54];
		clientTickTimes[class18.field54] = var1;
		class18.field54 = class18.field54 + 1 & 31;
		if (var3 != 0L && var1 > var3) {
		}

		synchronized(this) {
			class357.hasFocus = volatileFocus;
		}

		this.doCycle();
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "1"
	)
	protected final void method164() {
		this.fullRedraw = true;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1866404073"
	)
	@Export("graphicsTick")
	void graphicsTick() {
		Container var1 = this.container();
		long var2 = SpotAnimationDefinition.method962();
		long var4 = graphicsTickTimes[field101];
		graphicsTickTimes[field101] = var2;
		field101 = field101 + 1 & 31;
		if (var4 != 0L && var2 > var4) {
			int var6 = (int)(var2 - var4);
			fps = ((var6 >> 1) + 32000) / var6;
		}

		if (++field102 - 1 > 50) {
			field102 -= 50;
			this.fullRedraw = true;
			this.canvas.setSize(Language.canvasWidth, class47.canvasHeight);
			this.canvas.setVisible(true);
			if (var1 == this.frame) {
				Insets var7 = this.frame.getInsets();
				this.canvas.setLocation(var7.left + this.canvasX, this.canvasY + var7.top);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}
		}

		if (this.isCanvasInvalid) {
			this.replaceCanvas();
		}

		this.method166();
		this.draw(this.fullRedraw);
		if (this.fullRedraw) {
			this.clearBackground();
		}

		this.fullRedraw = false;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-992112857"
	)
	final void method166() {
		Bounds var1 = this.getFrameContentBounds();
		if (this.contentWidth != var1.highX || this.contentHeight != var1.highY || this.resizeCanvasNextFrame) {
			this.resizeCanvas();
			this.resizeCanvasNextFrame = false;
		}

	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-327763413"
	)
	final void method167() {
		this.resizeCanvasNextFrame = true;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "785770975"
	)
	@Export("kill")
	final synchronized void kill() {
		if (!isKilled) {
			isKilled = true;

			try {
				this.canvas.removeFocusListener(this);
			} catch (Exception var5) {
			}

			try {
				this.kill0();
			} catch (Exception var4) {
			}

			if (this.frame != null) {
				try {
					System.exit(0);
				} catch (Throwable var3) {
				}
			}

			if (taskHandler != null) {
				try {
					taskHandler.close();
				} catch (Exception var2) {
				}
			}

			this.vmethod1485();
		}
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-550390769"
	)
	@Export("setUp")
	protected abstract void setUp();

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "564244601"
	)
	@Export("doCycle")
	protected abstract void doCycle();

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-851092167"
	)
	@Export("draw")
	protected abstract void draw(boolean var1);

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1863199463"
	)
	@Export("kill0")
	protected abstract void kill0();

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;ZI)V",
		garbageValue = "1838069290"
	)
	@Export("drawInitial")
	protected final void drawInitial(int var1, String var2, boolean var3) {
		try {
			Graphics var4 = this.canvas.getGraphics();
			if (class28.fontHelvetica13 == null) {
				class28.fontHelvetica13 = new java.awt.Font("Helvetica", 1, 13);
				class6.loginScreenFontMetrics = this.canvas.getFontMetrics(class28.fontHelvetica13);
			}

			if (var3) {
				var4.setColor(Color.black);
				var4.fillRect(0, 0, Language.canvasWidth, class47.canvasHeight);
			}

			Color var5 = new Color(140, 17, 17);

			try {
				if (class151.field1359 == null) {
					class151.field1359 = this.canvas.createImage(304, 34);
				}

				Graphics var6 = class151.field1359.getGraphics();
				var6.setColor(var5);
				var6.drawRect(0, 0, 303, 33);
				var6.fillRect(2, 2, var1 * 3, 30);
				var6.setColor(Color.black);
				var6.drawRect(1, 1, 301, 31);
				var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
				var6.setFont(class28.fontHelvetica13);
				var6.setColor(Color.white);
				var6.drawString(var2, (304 - class6.loginScreenFontMetrics.stringWidth(var2)) / 2, 22);
				var4.drawImage(class151.field1359, Language.canvasWidth / 2 - 152, class47.canvasHeight / 2 - 18, (ImageObserver)null);
			} catch (Exception var9) {
				int var7 = Language.canvasWidth / 2 - 152;
				int var8 = class47.canvasHeight / 2 - 18;
				var4.setColor(var5);
				var4.drawRect(var7, var8, 303, 33);
				var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
				var4.setColor(Color.black);
				var4.drawRect(var7 + 1, var8 + 1, 301, 31);
				var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
				var4.setFont(class28.fontHelvetica13);
				var4.setColor(Color.white);
				var4.drawString(var2, var7 + (304 - class6.loginScreenFontMetrics.stringWidth(var2)) / 2, var8 + 22);
			}
		} catch (Exception var10) {
			this.canvas.repaint();
		}

	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "180057214"
	)
	protected final void method170() {
		class151.field1359 = null;
		class28.fontHelvetica13 = null;
		class6.loginScreenFontMetrics = null;
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "5"
	)
	@Export("error")
	protected void error(String var1) {
		if (!this.hasErrored) {
			this.hasErrored = true;
			System.out.println("error_game_" + var1);

			try {
				this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
			} catch (Exception var3) {
			}

		}
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(S)Ljava/awt/Container;",
		garbageValue = "15421"
	)
	@Export("container")
	Container container() {
		return (Container)(this.frame != null ? this.frame : this);
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(B)Lrv;",
		garbageValue = "95"
	)
	@Export("getFrameContentBounds")
	Bounds getFrameContentBounds() {
		Container var1 = this.container();
		int var2 = Math.max(var1.getWidth(), this.field116);
		int var3 = Math.max(var1.getHeight(), this.field114);
		if (this.frame != null) {
			Insets var4 = this.frame.getInsets();
			var2 -= var4.left + var4.right;
			var3 -= var4.bottom + var4.top;
		}

		return new Bounds(var2, var3);
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "50"
	)
	@Export("hasFrame")
	protected final boolean hasFrame() {
		return this.frame != null;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-94"
	)
	@Export("vmethod1485")
	protected abstract void vmethod1485();

	@Export("destroy")
	@ObfuscatedName("destroy")
	public final void destroy() {
		if (this == gameEngine && !isKilled) {
			stopTimeMs = SpotAnimationDefinition.method962();
			class219.method1104(5000L);
			this.kill();
		}
	}

	@Export("paint")
	@ObfuscatedName("paint")
	public final synchronized void paint(Graphics var1) {
		if (this == gameEngine && !isKilled) {
			this.fullRedraw = true;
			if (SpotAnimationDefinition.method962() - this.field127 > 1000L) {
				Rectangle var2 = var1.getClipBounds();
				if (var2 == null || var2.width >= Language.canvasWidth && var2.height >= class47.canvasHeight) {
					this.isCanvasInvalid = true;
				}
			}

		}
	}

	@Export("run")
	@ObfuscatedName("run")
	public void run() {
		try {
			if (TaskHandler.javaVendor != null) {
				String var1 = TaskHandler.javaVendor.toLowerCase();
				if (var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
					String var2 = TaskHandler.javaVersion;
					if (var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
						this.error("wrongjava");
						return;
					}

					if (var2.startsWith("1.6.0_")) {
						int var3;
						for (var3 = 6; var3 < var2.length() && Player.isDigit(var2.charAt(var3)); ++var3) {
						}

						String var4 = var2.substring(6, var3);
						if (ClientPacket.isNumber(var4) && Huffman.method1888(var4) < 10) {
							this.error("wrongjava");
							return;
						}
					}

					fiveOrOne = 5;
				}
			}

			this.setFocusCycleRoot(true);
			this.addCanvas();
			this.setUp();
			ArchiveDiskAction.clock = SoundSystem.method230();

			while (stopTimeMs == 0L || SpotAnimationDefinition.method962() < stopTimeMs) {
				gameCyclesToDo = ArchiveDiskAction.clock.wait(cycleDurationMillis, fiveOrOne);

				for (int var5 = 0; var5 < gameCyclesToDo; ++var5) {
					this.clientTick();
				}

				this.graphicsTick();
				this.post(this.canvas);
			}
		} catch (Exception var6) {
			GrandExchangeOfferWorldComparator.RunException_sendStackTrace((String)null, var6);
			this.error("crash");
		}

		this.kill();
	}

	@Export("start")
	@ObfuscatedName("start")
	public final void start() {
		if (this == gameEngine && !isKilled) {
			stopTimeMs = 0L;
		}
	}

	public final void stop() {
		if (this == gameEngine && !isKilled) {
			stopTimeMs = SpotAnimationDefinition.method962() + 4000L;
		}
	}

	@Export("update")
	@ObfuscatedName("update")
	public final void update(Graphics var1) {
		this.paint(var1);
	}

	@Export("focusGained")
	@ObfuscatedName("focusGained")
	public final void focusGained(FocusEvent var1) {
		volatileFocus = true;
		this.fullRedraw = true;
	}

	public final void focusLost(FocusEvent var1) {
		volatileFocus = false;
	}

	public final void windowActivated(WindowEvent var1) {
	}

	public final void windowClosed(WindowEvent var1) {
	}

	@Export("windowClosing")
	@ObfuscatedName("windowClosing")
	public final void windowClosing(WindowEvent var1) {
		this.destroy();
	}

	public final void windowDeactivated(WindowEvent var1) {
	}

	public final void windowDeiconified(WindowEvent var1) {
	}

	public final void windowIconified(WindowEvent var1) {
	}

	public final void windowOpened(WindowEvent var1) {
	}

	@ObfuscatedName("init")
	public abstract void init();

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "([BIIIIIIIII[Liw;B)V",
		garbageValue = "48"
	)
	static final void method146(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, CollisionMap[] var10) {
		int var12;
		for (int var11 = 0; var11 < 8; ++var11) {
			for (var12 = 0; var12 < 8; ++var12) {
				if (var11 + var2 > 0 && var11 + var2 < 103 && var3 + var12 > 0 && var3 + var12 < 103) {
					int[] var10000 = var10[var1].flags[var11 + var2];
					var10000[var12 + var3] &= -16777217;
				}
			}
		}

		Buffer var24 = new Buffer(var0);

		for (var12 = 0; var12 < 4; ++var12) {
			for (int var13 = 0; var13 < 64; ++var13) {
				for (int var14 = 0; var14 < 64; ++var14) {
					if (var12 == var4 && var13 >= var5 && var13 < var5 + 8 && var14 >= var6 && var14 < var6 + 8) {
						int var15 = var2 + class31.method135(var13 & 7, var14 & 7, var7);
						int var18 = var13 & 7;
						int var19 = var14 & 7;
						int var20 = var7 & 3;
						int var17;
						if (var20 == 0) {
							var17 = var19;
						} else if (var20 == 1) {
							var17 = 7 - var18;
						} else if (var20 == 2) {
							var17 = 7 - var19;
						} else {
							var17 = var18;
						}

						int var21 = var17 + var3;
						int var22 = (var13 & 7) + var8 + var2;
						int var23 = var3 + (var14 & 7) + var9;
						class14.loadTerrain(var24, var1, var15, var21, var22, var23, var7);
					} else {
						class14.loadTerrain(var24, 0, -1, -1, 0, 0, 0);
					}
				}
			}
		}

	}
}