package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v;
import com.fyber.inneractive.sdk.player.exoplayer2.util.j;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.r;

public final class o implements v {
    public final h a;
    public final j b = new j(new byte[10]);
    public int c = 0;
    public int d;
    public r e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;
    public long l;

    public o(h hVar) {
        this.a = hVar;
    }

    public final void a(int i2) {
        this.c = i2;
        this.d = 0;
    }

    public void a(r rVar, h hVar, v.d dVar) {
        this.e = rVar;
        this.a.a(hVar, dVar);
    }

    public final void a() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.a.a();
    }

    public final void a(k kVar, boolean z) {
        k kVar2 = kVar;
        if (z) {
            int i2 = this.c;
            if (i2 == 2) {
                Log.w("PesReader", "Unexpected start indicator reading extended header");
            } else if (i2 == 3) {
                if (this.j != -1) {
                    Log.w("PesReader", "Unexpected start indicator: expected " + this.j + " more bytes");
                }
                this.a.b();
            }
            a(1);
        }
        while (kVar.a() > 0) {
            int i3 = this.c;
            if (i3 != 0) {
                int i4 = 0;
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (a(kVar2, this.b.a, Math.min(10, this.i)) && a(kVar2, (byte[]) null, this.i)) {
                            this.b.b(0);
                            this.l = -9223372036854775807L;
                            if (this.f) {
                                this.b.c(4);
                                this.b.c(1);
                                this.b.c(1);
                                long a2 = (((long) this.b.a(3)) << 30) | ((long) (this.b.a(15) << 15)) | ((long) this.b.a(15));
                                this.b.c(1);
                                if (!this.h && this.g) {
                                    this.b.c(4);
                                    this.b.c(1);
                                    this.b.c(1);
                                    long a3 = (((long) this.b.a(3)) << 30) | ((long) (this.b.a(15) << 15)) | ((long) this.b.a(15));
                                    this.b.c(1);
                                    this.e.b(a3);
                                    this.h = true;
                                }
                                this.l = this.e.b(a2);
                            }
                            this.a.a(this.l, this.k);
                            a(3);
                        }
                    } else if (i3 == 3) {
                        int a4 = kVar.a();
                        int i5 = this.j;
                        if (i5 != -1) {
                            i4 = a4 - i5;
                        }
                        if (i4 > 0) {
                            a4 -= i4;
                            kVar2.d(kVar2.b + a4);
                        }
                        this.a.a(kVar2);
                        int i6 = this.j;
                        if (i6 != -1) {
                            int i7 = i6 - a4;
                            this.j = i7;
                            if (i7 == 0) {
                                this.a.b();
                                a(1);
                            }
                        }
                    }
                } else if (a(kVar2, this.b.a, 9)) {
                    this.b.b(0);
                    int a5 = this.b.a(24);
                    if (a5 != 1) {
                        Log.w("PesReader", "Unexpected start code prefix: " + a5);
                        this.j = -1;
                    } else {
                        this.b.c(8);
                        int a6 = this.b.a(16);
                        this.b.c(5);
                        this.k = this.b.b();
                        this.b.c(2);
                        this.f = this.b.b();
                        this.g = this.b.b();
                        this.b.c(6);
                        int a7 = this.b.a(8);
                        this.i = a7;
                        if (a6 == 0) {
                            this.j = -1;
                        } else {
                            this.j = (a6 - 3) - a7;
                        }
                        i4 = 2;
                    }
                    a(i4);
                }
            } else {
                kVar2.f(kVar.a());
            }
        }
    }

    public final boolean a(k kVar, byte[] bArr, int i2) {
        int min = Math.min(kVar.a(), i2 - this.d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            kVar.f(min);
        } else {
            System.arraycopy(kVar.a, kVar.b, bArr, this.d, min);
            kVar.b += min;
        }
        int i3 = this.d + min;
        this.d = i3;
        if (i3 == i2) {
            return true;
        }
        return false;
    }
}
