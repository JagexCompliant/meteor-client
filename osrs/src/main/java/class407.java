import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("px")
public class class407 {
	@ObfuscatedName("at")
	int field3715;

	@ObfuscatedSignature(
		descriptor = "(IZ)V",
		garbageValue = "1"
	)
	class407(int var1, boolean var2) {
		this.field3715 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "6521"
	)
	public int method2094() {
		return this.field3715;
	}

	@ObfuscatedName("kx")
	@ObfuscatedSignature(
		descriptor = "(IIIIILjava/lang/String;Ljava/lang/String;IIB)V",
		garbageValue = "-45"
	)
	@Export("menuAction")
	static final void menuAction(int var0, int var1, int var2, int var3, int var4, String var5, String var6, int var7, int var8) {
		if (var2 >= 2000) {
			var2 -= 2000;
		}

		PacketBufferNode var9;
		if (var2 == 1004) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			var9 = class113.getPacketBufferNode(ClientPacket.OPOBJ2, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeShortAdd(var3);
			var9.packetBuffer.writeShort(class101.baseY + var1);
			var9.packetBuffer.writeShort(var0 + NewShit.baseX);
			Client.packetWriter.addNode(var9);
		}

		if (var2 == 26) {
			class520.method2526();
		}

		if (var2 == 22) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var9 = class113.getPacketBufferNode(ClientPacket.field2605, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeIntME(class101.baseY + var1);
			var9.packetBuffer.writeIntME(var3);
			var9.packetBuffer.writeIntME(var0 + NewShit.baseX);
			var9.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			Client.packetWriter.addNode(var9);
		}

		Widget var18;
		if (var2 == 25) {
			var18 = HealthBarDefinition.widgetDefinition.getWidgetChild(var1, var0);
			if (var18 != null) {
				class53.method308();
				FadeOutTask.method2154(var1, var0, WorldMapData_0.Widget_unpackTargetMask(class361.getWidgetFlags(var18)), var4);
				Client.isItemSelected = 0;
				Client.field599 = class89.Widget_getSpellActionName(var18);
				if (Client.field599 == null) {
					Client.field599 = "null";
				}

				if (var18.isIf3) {
					Client.field598 = var18.dataText + class167.colorStartTag(16777215);
				} else {
					Client.field598 = class167.colorStartTag(65280) + var18.field3122 + class167.colorStartTag(16777215);
				}
			}

		} else {
			if (var2 == 6) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var9 = class113.getPacketBufferNode(ClientPacket.OPLOC4, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var9.packetBuffer.writeIntME(class101.baseY + var1);
				var9.packetBuffer.writeShort(var3);
				var9.packetBuffer.writeShortAdd(var0 + NewShit.baseX);
				Client.packetWriter.addNode(var9);
			}

			PacketBufferNode var10;
			NPC var14;
			if (var2 == 11) {
				var14 = Client.npcs[var3];
				if (var14 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.OPNPC3, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeIntME(var3);
					var10.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 12) {
				var14 = Client.npcs[var3];
				if (var14 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.OPNPC4, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var10.packetBuffer.writeShort(var3);
					Client.packetWriter.addNode(var10);
				}
			}

			Player var15;
			if (var2 == 48) {
				var15 = Client.players[var3];
				if (var15 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.WIDGET_TYPE, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeIntME(var3);
					var10.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 3) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var9 = class113.getPacketBufferNode(ClientPacket.field2573, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var9.packetBuffer.writeShortLE(class101.baseY + var1);
				var9.packetBuffer.writeShort(var0 + NewShit.baseX);
				var9.packetBuffer.writeShortAdd(var3);
				Client.packetWriter.addNode(var9);
			}

			if (var2 == 17) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var9 = class113.getPacketBufferNode(ClientPacket.OPOBJ3, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeShortLE(var0 + NewShit.baseX);
				var9.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var9.packetBuffer.writeShortAdd(class101.baseY + var1);
				var9.packetBuffer.writeIntLE(class348.selectedSpellWidget);
				var9.packetBuffer.writeShort(Client.selectedSpellChildIndex);
				var9.packetBuffer.writeShort(Client.selectedSpellItemId);
				var9.packetBuffer.writeShortAdd(var3);
				Client.packetWriter.addNode(var9);
			}

			if (var2 == 20) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var9 = class113.getPacketBufferNode(ClientPacket.field2558, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeShortAdd(var0 + NewShit.baseX);
				var9.packetBuffer.writeShort(class101.baseY + var1);
				var9.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var9.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var9);
			}

			if (var2 == 51) {
				var15 = Client.players[var3];
				if (var15 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.OPPLAYER8, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var10.packetBuffer.writeShortLE(var3);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 30 && Client.meslayerContinueWidget == null) {
				class10.resumePauseWidget(var1, var0);
				Client.meslayerContinueWidget = HealthBarDefinition.widgetDefinition.getWidgetChild(var1, var0);
				class159.invalidateWidget(Client.meslayerContinueWidget);
			}

			if (var2 == 21) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var9 = class113.getPacketBufferNode(ClientPacket.field2546, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeIntME(class101.baseY + var1);
				var9.packetBuffer.writeShort(var3);
				var9.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var9.packetBuffer.writeIntME(var0 + NewShit.baseX);
				Client.packetWriter.addNode(var9);
			}

			if (var2 == 50) {
				var15 = Client.players[var3];
				if (var15 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.OPPLAYER7, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeShortLE(var3);
					var10.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 57 || var2 == 1007) {
				var18 = HealthBarDefinition.widgetDefinition.getWidgetChild(var1, var0);
				if (var18 != null) {
					FloorOverlayDefinition.widgetDefaultMenuAction(var3, var1, var0, var4, var6);
				}
			}

			int var11;
			Widget var16;
			if (var2 == 28) {
				var9 = class113.getPacketBufferNode(ClientPacket.WIDGET_TYPE5, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeInt(var1);
				Client.packetWriter.addNode(var9);
				var16 = HealthBarDefinition.widgetDefinition.method1733(var1);
				if (var16 != null && var16.cs1Instructions != null && var16.cs1Instructions[0][0] == 5) {
					var11 = var16.cs1Instructions[0][1];
					Varps.Varps_main[var11] = 1 - Varps.Varps_main[var11];
					Projectile.changeGameOptions(var11);
				}
			}

			PacketBufferNode var13;
			if (var2 == 24) {
				var18 = HealthBarDefinition.widgetDefinition.method1733(var1);
				if (var18 != null) {
					boolean var12 = true;
					if (var18.contentType > 0) {
						var12 = class101.method597(var18);
					}

					if (var12) {
						var13 = class113.getPacketBufferNode(ClientPacket.WIDGET_TYPE5, Client.packetWriter.isaacCipher);
						var13.packetBuffer.writeInt(var1);
						Client.packetWriter.addNode(var13);
					}
				}
			}

			if (var2 == 47) {
				var15 = Client.players[var3];
				if (var15 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.OPPLAYER4, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var10.packetBuffer.writeIntME(var3);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 2) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var9 = class113.getPacketBufferNode(ClientPacket.OPLOCT, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeShortAdd(var3);
				var9.packetBuffer.writeIntME(Client.selectedSpellItemId);
				var9.packetBuffer.writeShort(Client.selectedSpellChildIndex);
				var9.packetBuffer.writeShortLE(class101.baseY + var1);
				var9.packetBuffer.writeShortAdd(var0 + NewShit.baseX);
				var9.packetBuffer.writeIntIME(class348.selectedSpellWidget);
				var9.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}

			if (var2 == 1002) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				var9 = class113.getPacketBufferNode(ClientPacket.OPLOCE, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeIntME(var3);
				Client.packetWriter.addNode(var9);
			}

			if (var2 == 8) {
				var14 = Client.npcs[var3];
				if (var14 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.OPNPCT, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeInt(class348.selectedSpellWidget);
					var10.packetBuffer.writeShortLE(var3);
					var10.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var10.packetBuffer.writeShort(Client.selectedSpellChildIndex);
					var10.packetBuffer.writeShortAdd(Client.selectedSpellItemId);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 58) {
				var18 = HealthBarDefinition.widgetDefinition.getWidgetChild(var1, var0);
				if (var18 != null) {
					if (var18.field3098 != null) {
						ScriptEvent var17 = new ScriptEvent();
						var17.widget = var18;
						var17.opIndex = var3;
						var17.targetName = var6;
						var17.args = var18.field3098;
						class157.runScriptEvent(var17);
					}

					var10 = class113.getPacketBufferNode(ClientPacket.f6, Client.packetWriter.isaacCipher);
					var10.packetBuffer.method2613(class348.selectedSpellWidget);
					var10.packetBuffer.writeShortAdd(var0);
					var10.packetBuffer.writeShortAdd(Client.selectedSpellChildIndex);
					var10.packetBuffer.writeIntLE(var1);
					var10.packetBuffer.writeShortAdd(var4);
					var10.packetBuffer.writeIntME(Client.selectedSpellItemId);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 16) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var9 = class113.getPacketBufferNode(ClientPacket.f53, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeShortAdd(var0 + NewShit.baseX);
				var9.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var9.packetBuffer.writeShortAdd(class59.field302);
				var9.packetBuffer.writeIntME(var3);
				var9.packetBuffer.writeIntME(class221.field1877);
				var9.packetBuffer.writeShort(class101.baseY + var1);
				var9.packetBuffer.writeInt(class195.field1620);
				Client.packetWriter.addNode(var9);
			}

			if (var2 == 1001) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var9 = class113.getPacketBufferNode(ClientPacket.OPLOC5, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeShortAdd(var0 + NewShit.baseX);
				var9.packetBuffer.writeShortAdd(class101.baseY + var1);
				var9.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var9.packetBuffer.writeShortAdd(var3);
				Client.packetWriter.addNode(var9);
			}

			if (var2 == 10) {
				var14 = Client.npcs[var3];
				if (var14 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.OPNPC2, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var10.packetBuffer.writeShortLE(var3);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 9) {
				var14 = Client.npcs[var3];
				if (var14 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.OPNPC1, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeShort(var3);
					var10.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 15) {
				var15 = Client.players[var3];
				if (var15 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.OPPLAYERT, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var10.packetBuffer.writeIntME(Client.selectedSpellItemId);
					var10.packetBuffer.writeShortLE(var3);
					var10.packetBuffer.writeShortAdd(Client.selectedSpellChildIndex);
					var10.packetBuffer.writeIntLE(class348.selectedSpellWidget);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 1) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var9 = class113.getPacketBufferNode(ClientPacket.field2604, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeIntLE(class195.field1620);
				var9.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var9.packetBuffer.writeShortAdd(var0 + NewShit.baseX);
				var9.packetBuffer.writeShortLE(class221.field1877);
				var9.packetBuffer.writeShortAdd(var3);
				var9.packetBuffer.writeShortLE(class59.field302);
				var9.packetBuffer.writeShortAdd(class101.baseY + var1);
				Client.packetWriter.addNode(var9);
			}

			if (var2 == 1003) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				var14 = Client.npcs[var3];
				if (var14 != null) {
					NPCComposition var19 = var14.definition;
					if (var19.transforms != null) {
						var19 = var19.transform();
					}

					if (var19 != null) {
						var13 = class113.getPacketBufferNode(ClientPacket.CLOSE_MODAL, Client.packetWriter.isaacCipher);
						var13.packetBuffer.writeIntME(var19.id);
						Client.packetWriter.addNode(var13);
					}
				}
			}

			if (var2 == 4) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var9 = class113.getPacketBufferNode(ClientPacket.field2595, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeShort(class101.baseY + var1);
				var9.packetBuffer.writeShortAdd(var0 + NewShit.baseX);
				var9.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var9.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var9);
			}

			if (var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1011 || var2 == 1012) {
				NewShit.worldMap.worldMapMenuAction(var2, var3, new Coord(var0), new Coord(var1));
			}

			if (var2 == 49) {
				var15 = Client.players[var3];
				if (var15 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.OPPLAYER6, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var10.packetBuffer.writeShort(var3);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 23) {
				if (Client.isMenuOpen) {
					class36.scene.setViewportWalking();
				} else {
					class36.scene.menuOpen(ItemLayer.Client_plane, var0, var1, true);
				}
			}

			if (var2 == 44) {
				var15 = Client.players[var3];
				if (var15 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.OPPLAYER1, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeShort(var3);
					var10.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 45) {
				var15 = Client.players[var3];
				if (var15 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.OPPLAYER2, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var10.packetBuffer.writeShortAdd(var3);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 7) {
				var14 = Client.npcs[var3];
				if (var14 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.field2587, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeIntME(var3);
					var10.packetBuffer.writeShort(class59.field302);
					var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var10.packetBuffer.writeIntIME(class195.field1620);
					var10.packetBuffer.writeShort(class221.field1877);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 29) {
				var9 = class113.getPacketBufferNode(ClientPacket.WIDGET_TYPE5, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeInt(var1);
				Client.packetWriter.addNode(var9);
				var16 = HealthBarDefinition.widgetDefinition.method1733(var1);
				if (var16 != null && var16.cs1Instructions != null && var16.cs1Instructions[0][0] == 5) {
					var11 = var16.cs1Instructions[0][1];
					if (Varps.Varps_main[var11] != var16.cs1ComparisonValues[0]) {
						Varps.Varps_main[var11] = var16.cs1ComparisonValues[0];
						Projectile.changeGameOptions(var11);
					}
				}
			}

			if (var2 == 13) {
				var14 = Client.npcs[var3];
				if (var14 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.OPNPC5, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var10.packetBuffer.writeShort(var3);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 19) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var9 = class113.getPacketBufferNode(ClientPacket.OPLOC2, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var9.packetBuffer.writeShortAdd(var0 + NewShit.baseX);
				var9.packetBuffer.writeIntME(class101.baseY + var1);
				var9.packetBuffer.writeShortLE(var3);
				Client.packetWriter.addNode(var9);
			}

			if (var2 == 14) {
				var15 = Client.players[var3];
				if (var15 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.EVENT_MOUSE_CLICK, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeShort(class221.field1877);
					var10.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var10.packetBuffer.writeShortLE(class59.field302);
					var10.packetBuffer.writeShortLE(var3);
					var10.packetBuffer.writeInt(class195.field1620);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 5) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var9 = class113.getPacketBufferNode(ClientPacket.OPLOC3, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var9.packetBuffer.writeIntME(class101.baseY + var1);
				var9.packetBuffer.writeShortAdd(var0 + NewShit.baseX);
				var9.packetBuffer.writeShortAdd(var3);
				Client.packetWriter.addNode(var9);
			}

			if (var2 == 18) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var9 = class113.getPacketBufferNode(ClientPacket.OPLOC1, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeShort(class101.baseY + var1);
				var9.packetBuffer.writeShort(var0 + NewShit.baseX);
				var9.packetBuffer.writeShortLE(var3);
				var9.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}

			if (var2 == 46) {
				var15 = Client.players[var3];
				if (var15 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = class113.getPacketBufferNode(ClientPacket.OPPLAYER3, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var10.packetBuffer.writeShort(var3);
					Client.packetWriter.addNode(var10);
				}
			}

			if (Client.isItemSelected != 0) {
				Client.isItemSelected = 0;
				class159.invalidateWidget(HealthBarDefinition.widgetDefinition.method1733(class195.field1620));
			}

			if (Client.isSpellSelected) {
				class53.method308();
			}

		}
	}
}