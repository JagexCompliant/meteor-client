import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ny")
public class class350 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lnh;"
	)
	@Export("huffman")
	static Huffman huffman;

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "-857536144"
	)
	static int method1890(int var0, Script var1, boolean var2) {
		if (var0 == 3600) {
			if (class12.friendSystem.friendListStatus == 0) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -2;
			} else if (class12.friendSystem.friendListStatus == 1) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
			} else {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class12.friendSystem.friendsList.getSize();
			}

			return 1;
		} else {
			int var3;
			if (var0 == 3601) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				if (class12.friendSystem.method408() && var3 >= 0 && var3 < class12.friendSystem.friendsList.getSize()) {
					Friend var8 = (Friend)class12.friendSystem.friendsList.get(var3);
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var8.getName();
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var8.getPreviousName();
				} else {
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == 3602) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				if (class12.friendSystem.method408() && var3 >= 0 && var3 < class12.friendSystem.friendsList.getSize()) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = ((Buddy)class12.friendSystem.friendsList.get(var3)).world;
				} else {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else if (var0 == 3603) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				if (class12.friendSystem.method408() && var3 >= 0 && var3 < class12.friendSystem.friendsList.getSize()) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = ((Buddy)class12.friendSystem.friendsList.get(var3)).rank;
				} else {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else {
				String var5;
				if (var0 == 3604) {
					var5 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
					int var9 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					class12.setFriendsRank(var5, var9);
					return 1;
				} else if (var0 == 3605) {
					var5 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
					class12.friendSystem.addFriend(var5);
					return 1;
				} else if (var0 == 3606) {
					var5 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
					class12.friendSystem.removeFriend(var5);
					return 1;
				} else if (var0 == 3607) {
					var5 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
					class12.friendSystem.addIgnore(var5);
					return 1;
				} else if (var0 == 3608) {
					var5 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
					boolean var6 = true;
					class12.friendSystem.removeIgnore(var5, var6);
					return 1;
				} else if (var0 == 3609) {
					var5 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
					var5 = UserComparator7.method675(var5);
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class12.friendSystem.isFriended(new Username(var5, class89.loginType), false) ? 1 : 0;
					return 1;
				} else if (var0 == 3611) {
					if (class20.friendsChat != null) {
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = class20.friendsChat.name;
					} else {
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == 3612) {
					if (class20.friendsChat != null) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class20.friendsChat.getSize();
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3613) {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					if (class20.friendsChat != null && var3 < class20.friendsChat.getSize()) {
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = class20.friendsChat.get(var3).getUsername().getName();
					} else {
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == 3614) {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					if (class20.friendsChat != null && var3 < class20.friendsChat.getSize()) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = ((Buddy)class20.friendsChat.get(var3)).getWorld();
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3615) {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					if (class20.friendsChat != null && var3 < class20.friendsChat.getSize()) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = ((Buddy)class20.friendsChat.get(var3)).rank;
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3616) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class20.friendsChat != null ? class20.friendsChat.minKick : 0;
					return 1;
				} else if (var0 == 3617) {
					var5 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
					InvDefinition.clanKickUser(var5);
					return 1;
				} else if (var0 == 3618) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class20.friendsChat != null ? class20.friendsChat.rank  : 0;
					return 1;
				} else if (var0 == 3619) {
					var5 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
					class138.Clan_joinChat(var5);
					return 1;
				} else if (var0 == 3620) {
					WorldMapSectionType.Clan_leaveChat();
					return 1;
				} else if (var0 == 3621) {
					if (!class12.friendSystem.method408()) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class12.friendSystem.ignoreList.getSize();
					}

					return 1;
				} else if (var0 == 3622) {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					if (class12.friendSystem.method408() && var3 >= 0 && var3 < class12.friendSystem.ignoreList.getSize()) {
						Ignored var4 = (Ignored)class12.friendSystem.ignoreList.get(var3);
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var4.getName();
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var4.getPreviousName();
					} else {
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == 3623) {
					var5 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
					var5 = UserComparator7.method675(var5);
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class12.friendSystem.isIgnored(new Username(var5, class89.loginType)) ? 1 : 0;
					return 1;
				} else if (var0 == 3624) {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					if (class20.friendsChat != null && var3 < class20.friendsChat.getSize() && class20.friendsChat.get(var3).getUsername().equals(class229.localPlayer.username)) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3625) {
					if (class20.friendsChat != null && class20.friendsChat.owner != null) {
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = class20.friendsChat.owner;
					} else {
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == 3626) {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					if (class20.friendsChat != null && var3 < class20.friendsChat.getSize() && ((ClanMate)class20.friendsChat.get(var3)).isFriend()) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 != 3627) {
					if (var0 == 3628) {
						class12.friendSystem.friendsList.removeComparator();
						return 1;
					} else {
						boolean var7;
						if (var0 == 3629) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							class12.friendSystem.friendsList.addComparator(new UserComparator1(var7));
							return 1;
						} else if (var0 == 3630) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							class12.friendSystem.friendsList.addComparator(new UserComparator2(var7));
							return 1;
						} else if (var0 == 3631) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							class12.friendSystem.friendsList.addComparator(new UserComparator3(var7));
							return 1;
						} else if (var0 == 3632) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							class12.friendSystem.friendsList.addComparator(new UserComparator4(var7));
							return 1;
						} else if (var0 == 3633) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							class12.friendSystem.friendsList.addComparator(new UserComparator5(var7));
							return 1;
						} else if (var0 == 3634) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							class12.friendSystem.friendsList.addComparator(new UserComparator6(var7));
							return 1;
						} else if (var0 == 3635) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							class12.friendSystem.friendsList.addComparator(new UserComparator7(var7));
							return 1;
						} else if (var0 == 3636) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							class12.friendSystem.friendsList.addComparator(new UserComparator8(var7));
							return 1;
						} else if (var0 == 3637) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							class12.friendSystem.friendsList.addComparator(new UserComparator9(var7));
							return 1;
						} else if (var0 == 3638) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							class12.friendSystem.friendsList.addComparator(new UserComparator10(var7));
							return 1;
						} else if (var0 == 3639) {
							class12.friendSystem.friendsList.sort();
							return 1;
						} else if (var0 == 3640) {
							class12.friendSystem.ignoreList.removeComparator();
							return 1;
						} else if (var0 == 3641) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							class12.friendSystem.ignoreList.addComparator(new UserComparator1(var7));
							return 1;
						} else if (var0 == 3642) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							class12.friendSystem.ignoreList.addComparator(new UserComparator2(var7));
							return 1;
						} else if (var0 == 3643) {
							class12.friendSystem.ignoreList.sort();
							return 1;
						} else if (var0 == 3644) {
							if (class20.friendsChat != null) {
								class20.friendsChat.removeComparator();
							}

							return 1;
						} else if (var0 == 3645) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							if (class20.friendsChat != null) {
								class20.friendsChat.addComparator(new UserComparator1(var7));
							}

							return 1;
						} else if (var0 == 3646) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							if (class20.friendsChat != null) {
								class20.friendsChat.addComparator(new UserComparator2(var7));
							}

							return 1;
						} else if (var0 == 3647) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							if (class20.friendsChat != null) {
								class20.friendsChat.addComparator(new UserComparator3(var7));
							}

							return 1;
						} else if (var0 == 3648) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							if (class20.friendsChat != null) {
								class20.friendsChat.addComparator(new UserComparator4(var7));
							}

							return 1;
						} else if (var0 == 3649) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							if (class20.friendsChat != null) {
								class20.friendsChat.addComparator(new UserComparator5(var7));
							}

							return 1;
						} else if (var0 == 3650) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							if (class20.friendsChat != null) {
								class20.friendsChat.addComparator(new UserComparator6(var7));
							}

							return 1;
						} else if (var0 == 3651) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							if (class20.friendsChat != null) {
								class20.friendsChat.addComparator(new UserComparator7(var7));
							}

							return 1;
						} else if (var0 == 3652) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							if (class20.friendsChat != null) {
								class20.friendsChat.addComparator(new UserComparator8(var7));
							}

							return 1;
						} else if (var0 == 3653) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							if (class20.friendsChat != null) {
								class20.friendsChat.addComparator(new UserComparator9(var7));
							}

							return 1;
						} else if (var0 == 3654) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							if (class20.friendsChat != null) {
								class20.friendsChat.addComparator(new UserComparator10(var7));
							}

							return 1;
						} else if (var0 == 3655) {
							if (class20.friendsChat != null) {
								class20.friendsChat.sort();
							}

							return 1;
						} else if (var0 == 3656) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							class12.friendSystem.friendsList.addComparator(new BuddyRankComparator(var7));
							return 1;
						} else if (var0 == 3657) {
							var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							if (class20.friendsChat != null) {
								class20.friendsChat.addComparator(new BuddyRankComparator(var7));
							}

							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					if (class20.friendsChat != null && var3 < class20.friendsChat.getSize() && ((ClanMate)class20.friendsChat.get(var3)).isIgnored()) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				}
			}
		}
	}
}