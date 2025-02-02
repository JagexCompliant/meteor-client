import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
	@ObfuscatedName("at")
	int field236;
	@ObfuscatedName("ah")
	int field231;
	@ObfuscatedName("ar")
	int field234;
	@ObfuscatedName("ao")
	int field233;
	@ObfuscatedName("ab")
	int field229;
	@ObfuscatedName("au")
	int field237;
	@ObfuscatedName("aa")
	int field228;
	@ObfuscatedName("ac")
	@Export("numLoops")
	int numLoops;
	@ObfuscatedName("al")
	@Export("start")
	int start;
	@ObfuscatedName("az")
	@Export("end")
	int end;
	@ObfuscatedName("ap")
	boolean field227;
	@ObfuscatedName("av")
	int field238;
	@ObfuscatedName("ax")
	int field239;
	@ObfuscatedName("as")
	int field235;
	@ObfuscatedName("ay")
	int field240;

	@ObfuscatedSignature(
		descriptor = "(Lbt;III)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3, int var4) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field227 = var1.field165;
		this.field231 = var2;
		this.field234 = var3;
		this.field233 = var4;
		this.field236 = 0;
		this.method250();
	}

	@ObfuscatedSignature(
		descriptor = "(Lbt;II)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field227 = var1.field165;
		this.field231 = var2;
		this.field234 = var3;
		this.field233 = 8192;
		this.field236 = 0;
		this.method250();
	}

	@ObfuscatedName("ab")
	void method250() {
		this.field229 = this.field234;
		this.field237 = method245(this.field234, this.field233);
		this.field228 = method246(this.field234, this.field233);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "()Lbk;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return null;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "()Lbk;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("ac")
	@Export("vmethod5648")
	protected int vmethod5648() {
		return this.field234 == 0 && this.field238 == 0 ? 0 : 1;
	}

	@ObfuscatedName("al")
	@Export("fill")
	public synchronized void fill(int[] var1, int var2, int var3) {
		if (this.field234 == 0 && this.field238 == 0) {
			this.skip(var3);
		} else {
			RawSound var4 = (RawSound)super.sound;
			int var5 = this.start << 8;
			int var6 = this.end << 8;
			int var7 = var4.samples.length << 8;
			int var8 = var6 - var5;
			if (var8 <= 0) {
				this.numLoops = 0;
			}

			int var9 = var2;
			var3 += var2;
			if (this.field236 < 0) {
				if (this.field231 <= 0) {
					this.method259();
					this.remove();
					return;
				}

				this.field236 = 0;
			}

			if (this.field236 >= var7) {
				if (this.field231 >= 0) {
					this.method259();
					this.remove();
					return;
				}

				this.field236 = var7 - 1;
			}

			if (this.numLoops < 0) {
				if (this.field227) {
					if (this.field231 < 0) {
						var9 = this.method273(var1, var2, var5, var3, var4.samples[this.start]);
						if (this.field236 >= var5) {
							return;
						}

						this.field236 = var5 + var5 - 1 - this.field236;
						this.field231 = -this.field231;
					}

					while (true) {
						var9 = this.method272(var1, var9, var6, var3, var4.samples[this.end - 1]);
						if (this.field236 < var6) {
							return;
						}

						this.field236 = var6 + var6 - 1 - this.field236;
						this.field231 = -this.field231;
						var9 = this.method273(var1, var9, var5, var3, var4.samples[this.start]);
						if (this.field236 >= var5) {
							return;
						}

						this.field236 = var5 + var5 - 1 - this.field236;
						this.field231 = -this.field231;
					}
				} else if (this.field231 < 0) {
					while (true) {
						var9 = this.method273(var1, var9, var5, var3, var4.samples[this.end - 1]);
						if (this.field236 >= var5) {
							return;
						}

						this.field236 = var6 - 1 - (var6 - 1 - this.field236) % var8;
					}
				} else {
					while (true) {
						var9 = this.method272(var1, var9, var6, var3, var4.samples[this.start]);
						if (this.field236 < var6) {
							return;
						}

						this.field236 = var5 + (this.field236 - var5) % var8;
					}
				}
			} else {
				if (this.numLoops > 0) {
					if (this.field227) {
						label133: {
							if (this.field231 < 0) {
								var9 = this.method273(var1, var2, var5, var3, var4.samples[this.start]);
								if (this.field236 >= var5) {
									return;
								}

								this.field236 = var5 + var5 - 1 - this.field236;
								this.field231 = -this.field231;
								if (--this.numLoops == 0) {
									break label133;
								}
							}

							do {
								var9 = this.method272(var1, var9, var6, var3, var4.samples[this.end - 1]);
								if (this.field236 < var6) {
									return;
								}

								this.field236 = var6 + var6 - 1 - this.field236;
								this.field231 = -this.field231;
								if (--this.numLoops == 0) {
									break;
								}

								var9 = this.method273(var1, var9, var5, var3, var4.samples[this.start]);
								if (this.field236 >= var5) {
									return;
								}

								this.field236 = var5 + var5 - 1 - this.field236;
								this.field231 = -this.field231;
							} while(--this.numLoops != 0);
						}
					} else {
						int var10;
						if (this.field231 < 0) {
							while (true) {
								var9 = this.method273(var1, var9, var5, var3, var4.samples[this.end - 1]);
								if (this.field236 >= var5) {
									return;
								}

								var10 = (var6 - 1 - this.field236) / var8;
								if (var10 >= this.numLoops) {
									this.field236 += var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field236 += var8 * var10;
								this.numLoops -= var10;
							}
						} else {
							while (true) {
								var9 = this.method272(var1, var9, var6, var3, var4.samples[this.start]);
								if (this.field236 < var6) {
									return;
								}

								var10 = (this.field236 - var5) / var8;
								if (var10 >= this.numLoops) {
									this.field236 -= var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field236 -= var8 * var10;
								this.numLoops -= var10;
							}
						}
					}
				}

				if (this.field231 < 0) {
					this.method273(var1, var9, 0, var3, 0);
					if (this.field236 < 0) {
						this.field236 = -1;
						this.method259();
						this.remove();
					}
				} else {
					this.method272(var1, var9, var7, var3, 0);
					if (this.field236 >= var7) {
						this.field236 = var7;
						this.method259();
						this.remove();
					}
				}

			}
		}
	}

	@ObfuscatedName("az")
	@Export("setNumLoops")
	public synchronized void setNumLoops(int var1) {
		this.numLoops = var1;
	}

	@ObfuscatedName("ap")
	@Export("skip")
	public synchronized void skip(int var1) {
		if (this.field238 > 0) {
			if (var1 >= this.field238) {
				if (this.field234 == Integer.MIN_VALUE) {
					this.field234 = 0;
					this.field228 = 0;
					this.field237 = 0;
					this.field229 = 0;
					this.remove();
					var1 = this.field238;
				}

				this.field238 = 0;
				this.method250();
			} else {
				this.field229 += this.field239 * var1;
				this.field237 += this.field235 * var1;
				this.field228 += this.field240 * var1;
				this.field238 -= var1;
			}
		}

		RawSound var2 = (RawSound)super.sound;
		int var3 = this.start << 8;
		int var4 = this.end << 8;
		int var5 = var2.samples.length << 8;
		int var6 = var4 - var3;
		if (var6 <= 0) {
			this.numLoops = 0;
		}

		if (this.field236 < 0) {
			if (this.field231 <= 0) {
				this.method259();
				this.remove();
				return;
			}

			this.field236 = 0;
		}

		if (this.field236 >= var5) {
			if (this.field231 >= 0) {
				this.method259();
				this.remove();
				return;
			}

			this.field236 = var5 - 1;
		}

		this.field236 += this.field231 * var1;
		if (this.numLoops < 0) {
			if (!this.field227) {
				if (this.field231 < 0) {
					if (this.field236 >= var3) {
						return;
					}

					this.field236 = var4 - 1 - (var4 - 1 - this.field236) % var6;
				} else {
					if (this.field236 < var4) {
						return;
					}

					this.field236 = var3 + (this.field236 - var3) % var6;
				}

			} else {
				if (this.field231 < 0) {
					if (this.field236 >= var3) {
						return;
					}

					this.field236 = var3 + var3 - 1 - this.field236;
					this.field231 = -this.field231;
				}

				while (this.field236 >= var4) {
					this.field236 = var4 + var4 - 1 - this.field236;
					this.field231 = -this.field231;
					if (this.field236 >= var3) {
						return;
					}

					this.field236 = var3 + var3 - 1 - this.field236;
					this.field231 = -this.field231;
				}

			}
		} else {
			if (this.numLoops > 0) {
				if (this.field227) {
					label121: {
						if (this.field231 < 0) {
							if (this.field236 >= var3) {
								return;
							}

							this.field236 = var3 + var3 - 1 - this.field236;
							this.field231 = -this.field231;
							if (--this.numLoops == 0) {
								break label121;
							}
						}

						do {
							if (this.field236 < var4) {
								return;
							}

							this.field236 = var4 + var4 - 1 - this.field236;
							this.field231 = -this.field231;
							if (--this.numLoops == 0) {
								break;
							}

							if (this.field236 >= var3) {
								return;
							}

							this.field236 = var3 + var3 - 1 - this.field236;
							this.field231 = -this.field231;
						} while(--this.numLoops != 0);
					}
				} else {
					label153: {
						int var7;
						if (this.field231 < 0) {
							if (this.field236 >= var3) {
								return;
							}

							var7 = (var4 - 1 - this.field236) / var6;
							if (var7 >= this.numLoops) {
								this.field236 += var6 * this.numLoops;
								this.numLoops = 0;
								break label153;
							}

							this.field236 += var6 * var7;
							this.numLoops -= var7;
						} else {
							if (this.field236 < var4) {
								return;
							}

							var7 = (this.field236 - var3) / var6;
							if (var7 >= this.numLoops) {
								this.field236 -= var6 * this.numLoops;
								this.numLoops = 0;
								break label153;
							}

							this.field236 -= var6 * var7;
							this.numLoops -= var7;
						}

						return;
					}
				}
			}

			if (this.field231 < 0) {
				if (this.field236 < 0) {
					this.field236 = -1;
					this.method259();
					this.remove();
				}
			} else if (this.field236 >= var5) {
				this.field236 = var5;
				this.method259();
				this.remove();
			}

		}
	}

	@ObfuscatedName("av")
	public synchronized void method252(int var1) {
		this.method254(var1 << 6, this.method256());
	}

	@ObfuscatedName("ax")
	synchronized void method253(int var1) {
		this.method254(var1, this.method256());
	}

	@ObfuscatedName("as")
	synchronized void method254(int var1, int var2) {
		this.field234 = var1;
		this.field233 = var2;
		this.field238 = 0;
		this.method250();
	}

	@ObfuscatedName("ay")
	public synchronized int method255() {
		return this.field234 == Integer.MIN_VALUE ? 0 : this.field234;
	}

	@ObfuscatedName("ak")
	public synchronized int method256() {
		return this.field233 < 0 ? -1 : this.field233;
	}

	@ObfuscatedName("aj")
	public synchronized void method257(int var1) {
		int var2 = ((RawSound)super.sound).samples.length << 8;
		if (var1 < -1) {
			var1 = -1;
		}

		if (var1 > var2) {
			var1 = var2;
		}

		this.field236 = var1;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Z)V",
		garbageValue = "1"
	)
	public synchronized void method258() {
		this.field231 = (this.field231 ^ this.field231 >> 31) + (this.field231 >>> 31);
		this.field231 = -this.field231;
	}

	@ObfuscatedName("aq")
	void method259() {
		if (this.field238 != 0) {
			if (this.field234 == Integer.MIN_VALUE) {
				this.field234 = 0;
			}

			this.field238 = 0;
			this.method250();
		}

	}

	@ObfuscatedName("ai")
	public synchronized void method260(int var1, int var2) {
		this.method261(var1, var2, this.method256());
	}

	@ObfuscatedName("aw")
	public synchronized void method261(int var1, int var2, int var3) {
		if (var1 == 0) {
			this.method254(var2, var3);
		} else {
			int var4 = method245(var2, var3);
			int var5 = method246(var2, var3);
			if (var4 == this.field237 && var5 == this.field228) {
				this.field238 = 0;
			} else {
				int var6 = var2 - this.field229;
				if (this.field229 - var2 > var6) {
					var6 = this.field229 - var2;
				}

				if (var4 - this.field237 > var6) {
					var6 = var4 - this.field237;
				}

				if (this.field237 - var4 > var6) {
					var6 = this.field237 - var4;
				}

				if (var5 - this.field228 > var6) {
					var6 = var5 - this.field228;
				}

				if (this.field228 - var5 > var6) {
					var6 = this.field228 - var5;
				}

				if (var1 > var6) {
					var1 = var6;
				}

				this.field238 = var1;
				this.field234 = var2;
				this.field233 = var3;
				this.field239 = (var2 - this.field229) / var1;
				this.field235 = (var4 - this.field237) / var1;
				this.field240 = (var5 - this.field228) / var1;
			}
		}
	}

	@ObfuscatedName("ae")
	public synchronized void method262(int var1) {
		if (var1 == 0) {
			this.method253(0);
			this.remove();
		} else if (this.field237 == 0 && this.field228 == 0) {
			this.field238 = 0;
			this.field234 = 0;
			this.field229 = 0;
			this.remove();
		} else {
			int var2 = -this.field229;
			if (this.field229 > var2) {
				var2 = this.field229;
			}

			if (-this.field237 > var2) {
				var2 = -this.field237;
			}

			if (this.field237 > var2) {
				var2 = this.field237;
			}

			if (-this.field228 > var2) {
				var2 = -this.field228;
			}

			if (this.field228 > var2) {
				var2 = this.field228;
			}

			if (var1 > var2) {
				var1 = var2;
			}

			this.field238 = var1;
			this.field234 = Integer.MIN_VALUE;
			this.field239 = -this.field229 / var1;
			this.field235 = -this.field237 / var1;
			this.field240 = -this.field228 / var1;
		}
	}

	@ObfuscatedName("an")
	public synchronized void method263(int var1) {
		if (this.field231 < 0) {
			this.field231 = -var1;
		} else {
			this.field231 = var1;
		}

	}

	@ObfuscatedName("ag")
	public synchronized int method264() {
		return this.field231 < 0 ? -this.field231 : this.field231;
	}

	@ObfuscatedName("ad")
	public boolean method265() {
		return this.field236 < 0 || this.field236 >= ((RawSound)super.sound).samples.length << 8;
	}

	@ObfuscatedName("af")
	public boolean method266() {
		return this.field238 != 0;
	}

	@ObfuscatedName("bn")
	int method272(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field238 > 0) {
				int var6 = var2 + this.field238;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field238 += var2;
				if (this.field231 == 256 && (this.field236 & 255) == 0) {
					if (WorldMapRectangle.PcmPlayer_stereo) {
						var2 = method284(0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field237, this.field228, this.field235, this.field240, 0, var6, var3, this);
					} else {
						var2 = method283(((RawSound)super.sound).samples, var1, this.field236, var2, this.field229, this.field239, 0, var6, var3, this);
					}
				} else if (WorldMapRectangle.PcmPlayer_stereo) {
					var2 = method288(0, 0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field237, this.field228, this.field235, this.field240, 0, var6, var3, this, this.field231, var5);
				} else {
					var2 = method287(0, 0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field229, this.field239, 0, var6, var3, this, this.field231, var5);
				}

				this.field238 -= var2;
				if (this.field238 != 0) {
					return var2;
				}

				if (!this.method274()) {
					continue;
				}

				return var4;
			}

			if (this.field231 == 256 && (this.field236 & 255) == 0) {
				if (WorldMapRectangle.PcmPlayer_stereo) {
					return method276(0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field237, this.field228, 0, var4, var3, this);
				}

				return method275(((RawSound)super.sound).samples, var1, this.field236, var2, this.field229, 0, var4, var3, this);
			}

			if (WorldMapRectangle.PcmPlayer_stereo) {
				return method280(0, 0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field237, this.field228, 0, var4, var3, this, this.field231, var5);
			}

			return method279(0, 0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field229, 0, var4, var3, this, this.field231, var5);
		}
	}

	@ObfuscatedName("bo")
	int method273(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field238 > 0) {
				int var6 = var2 + this.field238;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field238 += var2;
				if (this.field231 == -256 && (this.field236 & 255) == 0) {
					if (WorldMapRectangle.PcmPlayer_stereo) {
						var2 = method286(0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field237, this.field228, this.field235, this.field240, 0, var6, var3, this);
					} else {
						var2 = method285(((RawSound)super.sound).samples, var1, this.field236, var2, this.field229, this.field239, 0, var6, var3, this);
					}
				} else if (WorldMapRectangle.PcmPlayer_stereo) {
					var2 = method290(0, 0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field237, this.field228, this.field235, this.field240, 0, var6, var3, this, this.field231, var5);
				} else {
					var2 = method289(0, 0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field229, this.field239, 0, var6, var3, this, this.field231, var5);
				}

				this.field238 -= var2;
				if (this.field238 != 0) {
					return var2;
				}

				if (!this.method274()) {
					continue;
				}

				return var4;
			}

			if (this.field231 == -256 && (this.field236 & 255) == 0) {
				if (WorldMapRectangle.PcmPlayer_stereo) {
					return method278(0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field237, this.field228, 0, var4, var3, this);
				}

				return method277(((RawSound)super.sound).samples, var1, this.field236, var2, this.field229, 0, var4, var3, this);
			}

			if (WorldMapRectangle.PcmPlayer_stereo) {
				return method282(0, 0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field237, this.field228, 0, var4, var3, this, this.field231, var5);
			}

			return method281(0, 0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field229, 0, var4, var3, this, this.field231, var5);
		}
	}

	@ObfuscatedName("bz")
	boolean method274() {
		int var1 = this.field234;
		int var2;
		int var3;
		if (var1 == Integer.MIN_VALUE) {
			var3 = 0;
			var2 = 0;
			var1 = 0;
		} else {
			var2 = method245(var1, this.field233);
			var3 = method246(var1, this.field233);
		}

		if (var1 == this.field229 && var2 == this.field237 && var3 == this.field228) {
			if (this.field234 == Integer.MIN_VALUE) {
				this.field234 = 0;
				this.field228 = 0;
				this.field237 = 0;
				this.field229 = 0;
				this.remove();
				return true;
			} else {
				this.method250();
				return false;
			}
		} else {
			if (this.field229 < var1) {
				this.field239 = 1;
				this.field238 = var1 - this.field229;
			} else if (this.field229 > var1) {
				this.field239 = -1;
				this.field238 = this.field229 - var1;
			} else {
				this.field239 = 0;
			}

			if (this.field237 < var2) {
				this.field235 = 1;
				if (this.field238 == 0 || this.field238 > var2 - this.field237) {
					this.field238 = var2 - this.field237;
				}
			} else if (this.field237 > var2) {
				this.field235 = -1;
				if (this.field238 == 0 || this.field238 > this.field237 - var2) {
					this.field238 = this.field237 - var2;
				}
			} else {
				this.field235 = 0;
			}

			if (this.field228 < var3) {
				this.field240 = 1;
				if (this.field238 == 0 || this.field238 > var3 - this.field228) {
					this.field238 = var3 - this.field228;
				}
			} else if (this.field228 > var3) {
				this.field240 = -1;
				if (this.field238 == 0 || this.field238 > this.field228 - var3) {
					this.field238 = this.field228 - var3;
				}
			} else {
				this.field240 = 0;
			}

			return false;
		}
	}

	@ObfuscatedName("bx")
	@Export("vmethod1019")
	int vmethod1019() {
		int var1 = this.field229 * 3 >> 6;
		var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
		if (this.numLoops == 0) {
			var1 -= var1 * this.field236 / (((RawSound)super.sound).samples.length << 8);
		} else if (this.numLoops >= 0) {
			var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
		}

		return var1 > 255 ? 255 : var1;
	}

	@ObfuscatedName("at")
	static int method245(int var0, int var1) {
		return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("ah")
	static int method246(int var0, int var1) {
		return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lbt;II)Lbb;"
	)
	@Export("createRawPcmStream")
	public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(PcmPlayer.field179 * 100)), var2 << 6) : null;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lbt;III)Lbb;"
	)
	public static RawPcmStream method249(RawSound var0, int var1, int var2, int var3) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIILbb;)I"
	)
	static int method275(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
		var2 >>= 8;
		var7 >>= 8;
		var4 <<= 2;
		if ((var5 = var3 + var7 - var2) > var6) {
			var5 = var6;
		}

		int var10001;
		for (var5 -= 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var10001 = var3++;
		}

		for (var5 += 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
			var10001 = var3++;
		}

		var8.field236 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIILbb;)I"
	)
	static int method276(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
		var3 >>= 8;
		var9 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		if ((var7 = var4 + var9 - var3) > var8) {
			var7 = var8;
		}

		var4 <<= 1;
		var7 <<= 1;

		int var10001;
		byte var11;
		for (var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
		}

		for (var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
		}

		var10.field236 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIILbb;)I"
	)
	static int method277(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
		var2 >>= 8;
		var7 >>= 8;
		var4 <<= 2;
		if ((var5 = var3 + var2 - (var7 - 1)) > var6) {
			var5 = var6;
		}

		int var10001;
		for (var5 -= 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var10001 = var3++;
		}

		for (var5 += 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
			var10001 = var3++;
		}

		var8.field236 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIILbb;)I"
	)
	static int method278(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
		var3 >>= 8;
		var9 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		if ((var7 = var3 + var4 - (var9 - 1)) > var8) {
			var7 = var8;
		}

		var4 <<= 1;
		var7 <<= 1;

		int var10001;
		byte var11;
		for (var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
		}

		for (var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
		}

		var10.field236 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIILbb;II)I"
	)
	static int method279(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
		if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
			var7 = var8;
		}

		byte var13;
		int var10001;
		while (var5 < var7) {
			var1 = var4 >> 8;
			var13 = var2[var1];
			var10001 = var5++;
			var3[var10001] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
			var4 += var11;
		}

		if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 1) / var11) > var8) {
			var7 = var8;
		}

		for (var1 = var12; var5 < var7; var4 += var11) {
			var13 = var2[var4 >> 8];
			var10001 = var5++;
			var3[var10001] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
		}

		var10.field236 = var4;
		return var5;
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILbb;II)I"
	)
	static int method280(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
			var8 = var9;
		}

		var5 <<= 1;

		byte var14;
		int var10001;
		for (var8 <<= 1; var5 < var8; var4 += var12) {
			var1 = var4 >> 8;
			var14 = var2[var1];
			var0 = (var14 << 8) + (var4 & 255) * (var2[var1 + 1] - var14);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
		}

		if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
			var8 = var9;
		}

		var8 <<= 1;

		for (var1 = var13; var5 < var8; var4 += var12) {
			var14 = var2[var4 >> 8];
			var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
		}

		var11.field236 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIILbb;II)I"
	)
	static int method281(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
		if (var11 == 0 || (var7 = var5 + (var11 + (var9 + 256 - var4)) / var11) > var8) {
			var7 = var8;
		}

		int var10001;
		while (var5 < var7) {
			var1 = var4 >> 8;
			byte var13 = var2[var1 - 1];
			var10001 = var5++;
			var3[var10001] += ((var13 << 8) + (var2[var1] - var13) * (var4 & 255)) * var6 >> 6;
			var4 += var11;
		}

		if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4)) / var11) > var8) {
			var7 = var8;
		}

		var0 = var12;

		for (var1 = var11; var5 < var7; var4 += var1) {
			var10001 = var5++;
			var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
		}

		var10.field236 = var4;
		return var5;
	}

	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILbb;II)I"
	)
	static int method282(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
			var8 = var9;
		}

		var5 <<= 1;

		int var10001;
		for (var8 <<= 1; var5 < var8; var4 += var12) {
			var1 = var4 >> 8;
			byte var14 = var2[var1 - 1];
			var0 = (var2[var1] - var14) * (var4 & 255) + (var14 << 8);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
		}

		if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
			var8 = var9;
		}

		var8 <<= 1;

		for (var1 = var13; var5 < var8; var4 += var12) {
			var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
		}

		var11.field236 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("cv")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIIILbb;)I"
	)
	static int method283(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var8 - var2) > var7) {
			var6 = var7;
		}

		var9.field237 += var9.field235 * (var6 - var3);
		var9.field228 += var9.field240 * (var6 - var3);

		int var10001;
		for (var6 -= 3; var3 < var6; var4 += var5) {
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
		}

		for (var6 += 3; var3 < var6; var4 += var5) {
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
		}

		var9.field229 = var4 >> 2;
		var9.field236 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("cx")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIIIILbb;)I"
	)
	static int method284(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var11 + var4 - var3) > var10) {
			var9 = var10;
		}

		var12.field229 += var12.field239 * (var9 - var4);
		var4 <<= 1;
		var9 <<= 1;

		byte var13;
		int var10001;
		for (var9 -= 6; var4 < var9; var6 += var8) {
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
		}

		for (var9 += 6; var4 < var9; var6 += var8) {
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
		}

		var12.field237 = var5 >> 2;
		var12.field228 = var6 >> 2;
		var12.field236 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("cp")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIIILbb;)I"
	)
	static int method285(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
			var6 = var7;
		}

		var9.field237 += var9.field235 * (var6 - var3);
		var9.field228 += var9.field240 * (var6 - var3);

		int var10001;
		for (var6 -= 3; var3 < var6; var4 += var5) {
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
		}

		for (var6 += 3; var3 < var6; var4 += var5) {
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
		}

		var9.field229 = var4 >> 2;
		var9.field236 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("ce")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIIIILbb;)I"
	)
	static int method286(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
			var9 = var10;
		}

		var12.field229 += var12.field239 * (var9 - var4);
		var4 <<= 1;
		var9 <<= 1;

		byte var13;
		int var10001;
		for (var9 -= 6; var4 < var9; var6 += var8) {
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
		}

		for (var9 += 6; var4 < var9; var6 += var8) {
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
		}

		var12.field237 = var5 >> 2;
		var12.field228 = var6 >> 2;
		var12.field236 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("ci")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILbb;II)I"
	)
	static int method287(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field237 -= var11.field235 * var5;
		var11.field228 -= var11.field240 * var5;
		if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
			var8 = var9;
		}

		byte var14;
		int var10001;
		while (var5 < var8) {
			var1 = var4 >> 8;
			var14 = var2[var1];
			var10001 = var5++;
			var3[var10001] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
			var6 += var7;
			var4 += var12;
		}

		if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
			var8 = var9;
		}

		for (var1 = var13; var5 < var8; var4 += var12) {
			var14 = var2[var4 >> 8];
			var10001 = var5++;
			var3[var10001] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
			var6 += var7;
		}

		var11.field237 += var11.field235 * var5;
		var11.field228 += var11.field240 * var5;
		var11.field229 = var6;
		var11.field236 = var4;
		return var5;
	}

	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIIIILbb;II)I"
	)
	static int method288(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field229 -= var5 * var13.field239;
		if (var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
			var10 = var11;
		}

		var5 <<= 1;

		byte var16;
		int var10001;
		for (var10 <<= 1; var5 < var10; var4 += var14) {
			var1 = var4 >> 8;
			var16 = var2[var1];
			var0 = (var16 << 8) + (var4 & 255) * (var2[var1 + 1] - var16);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var6 += var8;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
			var7 += var9;
		}

		if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
			var10 = var11;
		}

		var10 <<= 1;

		for (var1 = var15; var5 < var10; var4 += var14) {
			var16 = var2[var4 >> 8];
			var0 = (var16 << 8) + (var1 - var16) * (var4 & 255);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var6 += var8;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
			var7 += var9;
		}

		var5 >>= 1;
		var13.field229 += var13.field239 * var5;
		var13.field237 = var6;
		var13.field228 = var7;
		var13.field236 = var4;
		return var5;
	}

	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILbb;II)I"
	)
	static int method289(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field237 -= var11.field235 * var5;
		var11.field228 -= var11.field240 * var5;
		if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
			var8 = var9;
		}

		int var10001;
		while (var5 < var8) {
			var1 = var4 >> 8;
			byte var14 = var2[var1 - 1];
			var10001 = var5++;
			var3[var10001] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
			var6 += var7;
			var4 += var12;
		}

		if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
			var8 = var9;
		}

		var0 = var13;

		for (var1 = var12; var5 < var8; var4 += var1) {
			var10001 = var5++;
			var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
			var6 += var7;
		}

		var11.field237 += var11.field235 * var5;
		var11.field228 += var11.field240 * var5;
		var11.field229 = var6;
		var11.field236 = var4;
		return var5;
	}

	@ObfuscatedName("cq")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIIIILbb;II)I"
	)
	static int method290(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field229 -= var5 * var13.field239;
		if (var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
			var10 = var11;
		}

		var5 <<= 1;

		int var10001;
		for (var10 <<= 1; var5 < var10; var4 += var14) {
			var1 = var4 >> 8;
			byte var16 = var2[var1 - 1];
			var0 = (var2[var1] - var16) * (var4 & 255) + (var16 << 8);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var6 += var8;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
			var7 += var9;
		}

		if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
			var10 = var11;
		}

		var10 <<= 1;

		for (var1 = var15; var5 < var10; var4 += var14) {
			var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var6 += var8;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
			var7 += var9;
		}

		var5 >>= 1;
		var13.field229 += var13.field239 * var5;
		var13.field237 = var6;
		var13.field228 = var7;
		var13.field236 = var4;
		return var5;
	}
}