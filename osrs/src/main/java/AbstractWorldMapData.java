import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.LinkedList;

@ObfuscatedName("jm")
@Implements("AbstractWorldMapData")
public abstract class AbstractWorldMapData {
	@ObfuscatedName("uk")
	static int field2045;
	@ObfuscatedName("ab")
	int field2051;
	@ObfuscatedName("au")
	int field2055;
	@ObfuscatedName("aa")
	@Export("regionX")
	int regionX;
	@ObfuscatedName("ac")
	@Export("regionY")
	int regionY;
	@ObfuscatedName("al")
	int field2053;
	@ObfuscatedName("az")
	@Export("planes")
	int planes;
	@ObfuscatedName("ap")
	@Export("groupId")
	int groupId;
	@ObfuscatedName("av")
	@Export("fileId")
	int fileId;
	@ObfuscatedName("ax")
	@Export("floorUnderlayIds")
	short[][][] floorUnderlayIds;
	@ObfuscatedName("as")
	@Export("floorOverlayIds")
	short[][][] floorOverlayIds;
	@ObfuscatedName("ay")
	byte[][][] field2049;
	@ObfuscatedName("ak")
	byte[][][] field2048;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "[[[[Ljs;"
	)
	@Export("decorations")
	WorldMapDecoration[][][][] decorations;
	@ObfuscatedName("am")
	boolean field2046;
	@ObfuscatedName("aq")
	boolean field2047;

	AbstractWorldMapData() {
		this.groupId = -1;
		this.fileId = -1;
		new LinkedList();
		this.field2046 = false;
		this.field2047 = false;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Luj;B)V",
		garbageValue = "7"
	)
	@Export("readGeography")
	abstract void readGeography(Buffer var1);

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "153115175"
	)
	@Export("isFullyLoaded")
	boolean isFullyLoaded() {
		return this.field2046 && this.field2047;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(Lol;I)V",
		garbageValue = "816077843"
	)
	@Export("loadGeography")
	void loadGeography(AbstractArchive var1) {
		if (!this.isFullyLoaded()) {
			byte[] var2 = var1.takeFile(this.groupId, this.fileId);
			if (var2 != null) {
				this.readGeography(new Buffer(var2));
				this.field2046 = true;
				this.field2047 = true;
			}

		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1929265244"
	)
	@Export("reset")
	void reset() {
		this.floorUnderlayIds = null;
		this.floorOverlayIds = null;
		this.field2049 = null;
		this.field2048 = null;
		this.decorations = null;
		this.field2046 = false;
		this.field2047 = false;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(IILuj;I)V",
		garbageValue = "-2036497889"
	)
	@Export("readTile")
	void readTile(int var1, int var2, Buffer var3) {
		int var4 = var3.readUnsignedByte();
		if (var4 != 0) {
			if ((var4 & 1) != 0) {
				this.method1319(var1, var2, var3, var4);
			} else {
				this.method1320(var1, var2, var3, var4);
			}

		}
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(IILuj;II)V",
		garbageValue = "-388208328"
	)
	void method1319(int var1, int var2, Buffer var3, int var4) {
		boolean var5 = (var4 & 2) != 0;
		if (var5) {
			this.floorOverlayIds[0][var1][var2] = (short)var3.readUnsignedShort();
		}

		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedShort();
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(IILuj;II)V",
		garbageValue = "1227555705"
	)
	void method1320(int var1, int var2, Buffer var3, int var4) {
		int var5 = ((var4 & 24) >> 3) + 1;
		boolean var6 = (var4 & 2) != 0;
		boolean var7 = (var4 & 4) != 0;
		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedShort();
		int var8;
		int var9;
		int var11;
		if (var6) {
			var8 = var3.readUnsignedByte();

			for (var9 = 0; var9 < var8; ++var9) {
				int var10 = var3.readUnsignedShort();
				if (var10 != 0) {
					this.floorOverlayIds[var9][var1][var2] = (short)var10;
					var11 = var3.readUnsignedByte();
					this.field2049[var9][var1][var2] = (byte)(var11 >> 2);
					this.field2048[var9][var1][var2] = (byte)(var11 & 3);
				}
			}
		}

		if (var7) {
			for (var8 = 0; var8 < var5; ++var8) {
				var9 = var3.readUnsignedByte();
				if (var9 != 0) {
					WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						int var12 = var3.readNullableLargeSmart();
						int var13 = var3.readUnsignedByte();
						var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
					}
				}
			}
		}

	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "908938497"
	)
	@Export("getRegionX")
	int getRegionX() {
		return this.regionX;
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "16"
	)
	@Export("getRegionY")
	int getRegionY() {
		return this.regionY;
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(Lnn;II)V",
		garbageValue = "1102490716"
	)
	public static void method1323(Widget var0, int var1) {
		ItemComposition var2 = class214.ItemDefinition_get(var1);
		var0.field3125.equipment[var2.maleModel] = var1 + 512;
		if (var2.maleModel1 != -1) {
			var0.field3125.equipment[var2.maleModel1] = 0;
		}

		if (var2.maleModel2 != -1) {
			var0.field3125.equipment[var2.maleModel2] = 0;
		}

		var0.field3125.method1756();
	}

	@ObfuscatedName("mn")
	@ObfuscatedSignature(
		descriptor = "([Lnn;IIIIIIIB)V",
		garbageValue = "-49"
	)
	@Export("updateInterface")
	static final void updateInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		for (int var8 = 0; var8 < var0.length; ++var8) {
			Widget var9 = var0[var8];
			if (var9 != null && var9.parentId == var1 && (var9.method1853() || class361.getWidgetFlags(var9) != 0 || var9 == Client.clickedWidgetParent)) {
				if (var9.isIf3) {
					if (class11.isComponentHidden(var9)) {
						continue;
					}
				} else if (var9.type == 0 && var9 != Interpreter.mousedOverWidgetIf1 && class11.isComponentHidden(var9)) {
					continue;
				}

				if (var9.type == 11) {
					if (var9.method1868(HealthBarDefinition.widgetDefinition, class60.urlRequester)) {
						if (var9.method1861()) {
							class159.invalidateWidget(var9);
							class132.revalidateWidgetScroll(var9.children, var9, true);
						}

						if (var9.field3116 != null) {
							ScriptEvent var10 = new ScriptEvent();
							var10.widget = var9;
							var10.args = var9.field3116;
							Client.scriptEvents.addFirst(var10);
						}
					}
				} else if (var9.type == 12 && var9.method1876(HealthBarDefinition.widgetDefinition)) {
					class159.invalidateWidget(var9);
				}

				int var26 = var9.x + var6;
				int var11 = var7 + var9.y;
				int var12;
				int var13;
				int var14;
				int var15;
				int var16;
				int var17;
				int var18;
				if (var9.type == 9) {
					var16 = var26;
					var17 = var11;
					var18 = var26 + var9.width;
					int var19 = var11 + var9.height;
					if (var18 < var26) {
						var16 = var18;
						var18 = var26;
					}

					if (var19 < var11) {
						var17 = var19;
						var19 = var11;
					}

					++var18;
					++var19;
					var12 = var16 > var2 ? var16 : var2;
					var13 = var17 > var3 ? var17 : var3;
					var14 = var18 < var4 ? var18 : var4;
					var15 = var19 < var5 ? var19 : var5;
				} else {
					var16 = var26 + var9.width;
					var17 = var11 + var9.height;
					var12 = var26 > var2 ? var26 : var2;
					var13 = var11 > var3 ? var11 : var3;
					var14 = var16 < var4 ? var16 : var4;
					var15 = var17 < var5 ? var17 : var5;
				}

				if (var9 == Client.clickedWidget) {
					Client.field397 = true;
					Client.field514 = var26;
					Client.field508 = var11;
				}

				boolean var34 = false;
				if (var9.field2995) {
					switch(Client.field505) {
					case 0:
						var34 = true;
					case 1:
					default:
						break;
					case 2:
						if (Client.field499 == var9.id >>> 16) {
							var34 = true;
						}
						break;
					case 3:
						if (var9.id == Client.field499) {
							var34 = true;
						}
					}
				}

				if (var34 || !var9.isIf3 || var12 < var14 && var13 < var15) {
					if (var9.isIf3) {
						ScriptEvent var27;
						if (var9.noClickThrough) {
							if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								for (var27 = (ScriptEvent)Client.scriptEvents.last(); var27 != null; var27 = (ScriptEvent)Client.scriptEvents.previous()) {
									if (var27.field866) {
										var27.remove();
										var27.widget.field3001 = false;
									}
								}

								Tile.method1412();
								if (class148.widgetDragDuration == 0) {
									Client.clickedWidget = null;
									Client.clickedWidgetParent = null;
								}

								if (!Client.isMenuOpen) {
									UserComparator10.addCancelMenuEntry();
								}
							}
						} else if (var9.noScrollThrough && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
							for (var27 = (ScriptEvent)Client.scriptEvents.last(); var27 != null; var27 = (ScriptEvent)Client.scriptEvents.previous()) {
								if (var27.field866 && var27.widget.onScroll == var27.args) {
									var27.remove();
								}
							}
						}
					}

					var17 = MouseHandler.MouseHandler_x;
					var18 = MouseHandler.MouseHandler_y;
					if (MouseHandler.MouseHandler_lastButton != 0) {
						var17 = MouseHandler.MouseHandler_lastPressedX;
						var18 = MouseHandler.MouseHandler_lastPressedY;
					}

					boolean var35 = var17 >= var12 && var18 >= var13 && var17 < var14 && var18 < var15;
					if (var9.contentType == 1337) {
						if (!Client.isLoading && !Client.isMenuOpen && var35) {
							PacketBufferNode.addSceneMenuOptions(var17, var18, var12, var13);
						}
					} else if (var9.contentType == 1338) {
						class18.checkIfMinimapClicked(var9, var26, var11);
					} else {
						if (var9.contentType == 1400) {
							NewShit.worldMap.onCycle(MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y, var35, var26, var11, var9.width, var9.height);
						}

						if (!Client.isMenuOpen && var35) {
							if (var9.contentType == 1400) {
								NewShit.worldMap.addElementMenuOptions(var26, var11, var9.width, var9.height, var17, var18);
							} else {
								class93.method502(var9);
							}
						}

						boolean var21;
						int var23;
						if (var34) {
							for (int var20 = 0; var20 < var9.field3003.length; ++var20) {
								var21 = false;
								boolean var22 = false;
								if (!var21 && var9.field3003[var20] != null) {
									for (var23 = 0; var23 < var9.field3003[var20].length; ++var23) {
										boolean var24 = false;
										if (var9.field3080 != null) {
											var24 = Client.keyHandlerInstance.getKeyPressed(var9.field3003[var20][var23]);
										}

										if (class163.method852(var9.field3003[var20][var23]) || var24) {
											var21 = true;
											if (var9.field3080 != null && var9.field3080[var20] > Client.cycle) {
												break;
											}

											byte var25 = var9.field3004[var20][var23];
											if (var25 == 0 || ((var25 & 8) == 0 || !Client.keyHandlerInstance.getKeyPressed(86) && !Client.keyHandlerInstance.getKeyPressed(82) && !Client.keyHandlerInstance.getKeyPressed(81)) && ((var25 & 2) == 0 || Client.keyHandlerInstance.getKeyPressed(86)) && ((var25 & 1) == 0 || Client.keyHandlerInstance.getKeyPressed(82)) && ((var25 & 4) == 0 || Client.keyHandlerInstance.getKeyPressed(81))) {
												var22 = true;
												break;
											}
										}
									}
								}

								if (var22) {
									if (var20 < 10) {
										FloorOverlayDefinition.widgetDefaultMenuAction(var20 + 1, var9.id, var9.childIndex, var9.itemId, "");
									} else if (var20 == 10) {
										class53.method308();
										FadeOutTask.method2154(var9.id, var9.childIndex, WorldMapData_0.Widget_unpackTargetMask(class361.getWidgetFlags(var9)), var9.itemId);
										Client.field599 = class89.Widget_getSpellActionName(var9);
										if (Client.field599 == null) {
											Client.field599 = "null";
										}

										Client.field598 = var9.dataText + class167.colorStartTag(16777215);
									}

									var23 = var9.field3073[var20];
									if (var9.field3080 == null) {
										var9.field3080 = new int[var9.field3003.length];
									}

									if (var9.field3072 == null) {
										var9.field3072 = new int[var9.field3003.length];
									}

									if (var23 != 0) {
										if (var9.field3080[var20] == 0) {
											var9.field3080[var20] = var23 + Client.cycle + var9.field3072[var20];
										} else {
											var9.field3080[var20] = var23 + Client.cycle;
										}
									} else {
										var9.field3080[var20] = Integer.MAX_VALUE;
									}
								}

								if (!var21 && var9.field3080 != null) {
									var9.field3080[var20] = 0;
								}
							}
						}

						if (var9.isIf3) {
							if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								var35 = true;
							} else {
								var35 = false;
							}

							boolean var36 = false;
							if ((MouseHandler.MouseHandler_currentButton == 1 || !class19.mouseCam && MouseHandler.MouseHandler_currentButton == 4) && var35) {
								var36 = true;
							}

							var21 = false;
							if ((MouseHandler.MouseHandler_lastButton == 1 || !class19.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15) {
								var21 = true;
							}

							if (var21) {
								HorizontalAlignment.clickWidget(var9, MouseHandler.MouseHandler_lastPressedX - var26, MouseHandler.MouseHandler_lastPressedY - var11);
							}

							if (var9.method1854()) {
								if (var21) {
									Client.field625.addFirst(new class222(0, MouseHandler.MouseHandler_x - var26, MouseHandler.MouseHandler_y - var11, var9));
								}

								if (var36) {
									Client.field625.addFirst(new class222(1, MouseHandler.MouseHandler_x - var26, MouseHandler.MouseHandler_y - var11, var9));
								}
							}

							if (var9.contentType == 1400) {
								NewShit.worldMap.method2400(var17, var18, var35 & var36, var35 & var21);
							}

							if (Client.clickedWidget != null && var9 != Client.clickedWidget && var35 && class12.method43(class361.getWidgetFlags(var9))) {
								Client.draggedOnWidget = var9;
							}

							if (var9 == Client.clickedWidgetParent) {
								Client.field396 = true;
								Client.field512 = var26;
								Client.field513 = var11;
							}

							if (var9.hasListener) {
								ScriptEvent var28;
								if (var35 && Client.mouseWheelRotation != 0 && var9.onScroll != null) {
									var28 = new ScriptEvent();
									var28.field866 = true;
									var28.widget = var9;
									var28.mouseY = Client.mouseWheelRotation;
									var28.args = var9.onScroll;
									Client.scriptEvents.addFirst(var28);
								}

								if (Client.clickedWidget != null || Client.isMenuOpen) {
									var21 = false;
									var36 = false;
									var35 = false;
								}

								if (!var9.field2999 && var21) {
									var9.field2999 = true;
									if (var9.onClick != null) {
										var28 = new ScriptEvent();
										var28.field866 = true;
										var28.widget = var9;
										var28.mouseX = MouseHandler.MouseHandler_lastPressedX - var26;
										var28.mouseY = MouseHandler.MouseHandler_lastPressedY - var11;
										var28.args = var9.onClick;
										Client.scriptEvents.addFirst(var28);
									}
								}

								if (var9.field2999 && var36 && var9.onClickRepeat != null) {
									var28 = new ScriptEvent();
									var28.field866 = true;
									var28.widget = var9;
									var28.mouseX = MouseHandler.MouseHandler_x - var26;
									var28.mouseY = MouseHandler.MouseHandler_y - var11;
									var28.args = var9.onClickRepeat;
									Client.scriptEvents.addFirst(var28);
								}

								if (var9.field2999 && !var36) {
									var9.field2999 = false;
									if (var9.onRelease != null) {
										var28 = new ScriptEvent();
										var28.field866 = true;
										var28.widget = var9;
										var28.mouseX = MouseHandler.MouseHandler_x - var26;
										var28.mouseY = MouseHandler.MouseHandler_y - var11;
										var28.args = var9.onRelease;
										Client.field628.addFirst(var28);
									}
								}

								if (var36 && var9.onHold != null) {
									var28 = new ScriptEvent();
									var28.field866 = true;
									var28.widget = var9;
									var28.mouseX = MouseHandler.MouseHandler_x - var26;
									var28.mouseY = MouseHandler.MouseHandler_y - var11;
									var28.args = var9.onHold;
									Client.scriptEvents.addFirst(var28);
								}

								if (!var9.field3001 && var35) {
									var9.field3001 = true;
									if (var9.onMouseOver != null) {
										var28 = new ScriptEvent();
										var28.field866 = true;
										var28.widget = var9;
										var28.mouseX = MouseHandler.MouseHandler_x - var26;
										var28.mouseY = MouseHandler.MouseHandler_y - var11;
										var28.args = var9.onMouseOver;
										Client.scriptEvents.addFirst(var28);
									}
								}

								if (var9.field3001 && var35 && var9.onMouseRepeat != null) {
									var28 = new ScriptEvent();
									var28.field866 = true;
									var28.widget = var9;
									var28.mouseX = MouseHandler.MouseHandler_x - var26;
									var28.mouseY = MouseHandler.MouseHandler_y - var11;
									var28.args = var9.onMouseRepeat;
									Client.scriptEvents.addFirst(var28);
								}

								if (var9.field3001 && !var35) {
									var9.field3001 = false;
									if (var9.onMouseLeave != null) {
										var28 = new ScriptEvent();
										var28.field866 = true;
										var28.widget = var9;
										var28.mouseX = MouseHandler.MouseHandler_x - var26;
										var28.mouseY = MouseHandler.MouseHandler_y - var11;
										var28.args = var9.onMouseLeave;
										Client.field628.addFirst(var28);
									}
								}

								if (var9.onTimer != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.onTimer;
									Client.field627.addFirst(var28);
								}

								ScriptEvent var29;
								int var37;
								int var38;
								if (var9.onVarTransmit != null && Client.changedVarpCount > var9.field3071) {
									if (var9.varTransmitTriggers != null && Client.changedVarpCount - var9.field3071 <= 32) {
										label647:
										for (var37 = var9.field3071; var37 < Client.changedVarpCount; ++var37) {
											var23 = Client.changedVarps[var37 & 31];

											for (var38 = 0; var38 < var9.varTransmitTriggers.length; ++var38) {
												if (var23 == var9.varTransmitTriggers[var38]) {
													var29 = new ScriptEvent();
													var29.widget = var9;
													var29.args = var9.onVarTransmit;
													Client.scriptEvents.addFirst(var29);
													break label647;
												}
											}
										}
									} else {
										var28 = new ScriptEvent();
										var28.widget = var9;
										var28.args = var9.onVarTransmit;
										Client.scriptEvents.addFirst(var28);
									}

									var9.field3071 = Client.changedVarpCount;
								}

								if (var9.onInvTransmit != null && Client.changedItemContainersCount > var9.field3069) {
									if (var9.invTransmitTriggers != null && Client.changedItemContainersCount - var9.field3069 <= 32) {
										label623:
										for (var37 = var9.field3069; var37 < Client.changedItemContainersCount; ++var37) {
											var23 = Client.changedItemContainers[var37 & 31];

											for (var38 = 0; var38 < var9.invTransmitTriggers.length; ++var38) {
												if (var23 == var9.invTransmitTriggers[var38]) {
													var29 = new ScriptEvent();
													var29.widget = var9;
													var29.args = var9.onInvTransmit;
													Client.scriptEvents.addFirst(var29);
													break label623;
												}
											}
										}
									} else {
										var28 = new ScriptEvent();
										var28.widget = var9;
										var28.args = var9.onInvTransmit;
										Client.scriptEvents.addFirst(var28);
									}

									var9.field3069 = Client.changedItemContainersCount;
								}

								if (var9.onStatTransmit != null && Client.changedSkillsCount > var9.field3062) {
									if (var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field3062 <= 32) {
										label599:
										for (var37 = var9.field3062; var37 < Client.changedSkillsCount; ++var37) {
											var23 = Client.changedSkills[var37 & 31];

											for (var38 = 0; var38 < var9.statTransmitTriggers.length; ++var38) {
												if (var23 == var9.statTransmitTriggers[var38]) {
													var29 = new ScriptEvent();
													var29.widget = var9;
													var29.args = var9.onStatTransmit;
													Client.scriptEvents.addFirst(var29);
													break label599;
												}
											}
										}
									} else {
										var28 = new ScriptEvent();
										var28.widget = var9;
										var28.args = var9.onStatTransmit;
										Client.scriptEvents.addFirst(var28);
									}

									var9.field3062 = Client.changedSkillsCount;
								}

								if (Client.chatCycle > var9.field3065 && var9.onChatTransmit != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.onChatTransmit;
									Client.scriptEvents.addFirst(var28);
								}

								if (Client.field524 > var9.field3065 && var9.onFriendTransmit != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.onFriendTransmit;
									Client.scriptEvents.addFirst(var28);
								}

								if (Client.field526 > var9.field3065 && var9.onClanTransmit != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.onClanTransmit;
									Client.scriptEvents.addFirst(var28);
								}

								if (Client.field520 > var9.field3065 && var9.field3099 != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.field3099;
									Client.scriptEvents.addFirst(var28);
								}

								if (Client.field525 > var9.field3065 && var9.field3114 != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.field3114;
									Client.scriptEvents.addFirst(var28);
								}

								if (Client.field519 > var9.field3065 && var9.onStockTransmit != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.onStockTransmit;
									Client.scriptEvents.addFirst(var28);
								}

								if (Client.field527 > var9.field3065 && var9.field3115 != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.field3115;
									Client.scriptEvents.addFirst(var28);
								}

								if (Client.field522 > var9.field3065 && var9.onMiscTransmit != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.onMiscTransmit;
									Client.scriptEvents.addFirst(var28);
								}

								var9.field3065 = Client.cycleCntr;
								if (var9.onKey != null) {
									for (var37 = 0; var37 < Client.field530; ++var37) {
										ScriptEvent var30 = new ScriptEvent();
										var30.widget = var9;
										var30.keyTyped = Client.field577[var37];
										var30.keyPressed = Client.field579[var37];
										var30.args = var9.onKey;
										Client.scriptEvents.addFirst(var30);
									}
								}

								ScriptEvent var31;
								int[] var39;
								if (var9.field3107 != null) {
									var39 = Client.keyHandlerInstance.method1132();

									for (var23 = 0; var23 < var39.length; ++var23) {
										var31 = new ScriptEvent();
										var31.widget = var9;
										var31.keyTyped = var39[var23];
										var31.args = var9.field3107;
										Client.scriptEvents.addFirst(var31);
									}
								}

								if (var9.field3108 != null) {
									var39 = Client.keyHandlerInstance.method1133();

									for (var23 = 0; var23 < var39.length; ++var23) {
										var31 = new ScriptEvent();
										var31.widget = var9;
										var31.keyTyped = var39[var23];
										var31.args = var9.field3108;
										Client.scriptEvents.addFirst(var31);
									}
								}
							}
						}

						if (!var9.isIf3) {
							if (Client.clickedWidget != null || Client.isMenuOpen) {
								continue;
							}

							if ((var9.mouseOverRedirect >= 0 || var9.mouseOverColor != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								if (var9.mouseOverRedirect >= 0) {
									Interpreter.mousedOverWidgetIf1 = var0[var9.mouseOverRedirect];
								} else {
									Interpreter.mousedOverWidgetIf1 = var9;
								}
							}

							if (var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								SwapSongTask.field3744 = var9;
							}

							if (var9.scrollHeight > var9.height) {
								class17.method63(var9, var26 + var9.width, var11, var9.height, var9.scrollHeight, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
							}
						}

						if (var9.type == 0) {
							updateInterface(var0, var9.id, var12, var13, var14, var15, var26 - var9.scrollX, var11 - var9.scrollY);
							if (var9.children != null) {
								updateInterface(var9.children, var9.id, var12, var13, var14, var15, var26 - var9.scrollX, var11 - var9.scrollY);
							}

							InterfaceParent var32 = (InterfaceParent)Client.interfaceParents.get((long)var9.id);
							if (var32 != null) {
								if (var32.type == 0 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15 && !Client.isMenuOpen) {
									for (ScriptEvent var33 = (ScriptEvent)Client.scriptEvents.last(); var33 != null; var33 = (ScriptEvent)Client.scriptEvents.previous()) {
										if (var33.field866) {
											var33.remove();
											var33.widget.field3001 = false;
										}
									}

									if (class148.widgetDragDuration == 0) {
										Client.clickedWidget = null;
										Client.clickedWidgetParent = null;
									}

									if (!Client.isMenuOpen) {
										UserComparator10.addCancelMenuEntry();
									}
								}

								class406.updateRootInterface(var32.group, var12, var13, var14, var15, var26, var11);
							}
						}
					}
				}
			}
		}

	}
}