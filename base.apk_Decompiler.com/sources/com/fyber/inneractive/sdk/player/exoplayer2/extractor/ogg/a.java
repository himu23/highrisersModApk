package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import androidx.work.WorkRequest;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.b;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import java.io.EOFException;
import java.io.IOException;

public final class a implements f {
    public final e a = new e();
    public final long b;
    public final long c;
    public final h d;
    public int e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;

    /* renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.a$a  reason: collision with other inner class name */
    public class C0122a implements m {
        public C0122a() {
        }

        public boolean a() {
            return true;
        }

        public long a(long j) {
            if (j == 0) {
                return a.this.b;
            }
            a aVar = a.this;
            long j2 = aVar.b;
            long j3 = aVar.c;
            long j4 = (((((((long) aVar.d.i) * j) / 1000000) * (j3 - j2)) / aVar.f) - WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) + j2;
            if (j4 >= j2) {
                j2 = j4;
            }
            return j2 >= j3 ? j3 - 1 : j2;
        }

        public long c() {
            a aVar = a.this;
            return (aVar.f * 1000000) / ((long) aVar.d.i);
        }
    }

    public a(long j2, long j3, h hVar, int i2, long j4) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(j2 >= 0 && j3 > j2);
        this.d = hVar;
        this.b = j2;
        this.c = j3;
        if (((long) i2) == j3 - j2) {
            this.f = j4;
            this.e = 3;
            return;
        }
        this.e = 0;
    }

    public m b() {
        if (this.f != 0) {
            return new C0122a();
        }
        return null;
    }

    public long c(long j2) {
        long j3;
        int i2 = this.e;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(i2 == 3 || i2 == 2);
        if (j2 == 0) {
            j3 = 0;
        } else {
            j3 = (((long) this.d.i) * j2) / 1000000;
        }
        this.h = j3;
        this.e = 2;
        this.i = this.b;
        this.j = this.c;
        this.k = 0;
        this.l = this.f;
        return j3;
    }

    public long a(g gVar) throws IOException, InterruptedException {
        e eVar;
        long j2;
        long j3;
        g gVar2 = gVar;
        int i2 = this.e;
        if (i2 == 0) {
            long j4 = ((b) gVar2).c;
            this.g = j4;
            this.e = 1;
            long j5 = this.c - 65307;
            if (j5 > j4) {
                return j5;
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                long j6 = this.h;
                long j7 = 0;
                if (j6 != 0) {
                    long j8 = this.i;
                    long j9 = this.j;
                    if (j8 == j9) {
                        j2 = -(this.k + 2);
                    } else {
                        b bVar = (b) gVar2;
                        long j10 = bVar.c;
                        if (!a(gVar2, j9)) {
                            j2 = this.i;
                            if (j2 == j10) {
                                throw new IOException("No ogg page can be found.");
                            }
                        } else {
                            this.a.a(gVar2, false);
                            bVar.e = 0;
                            e eVar2 = this.a;
                            long j11 = eVar2.b;
                            long j12 = j6 - j11;
                            int i3 = eVar2.d + eVar2.e;
                            int i4 = (j12 > 0 ? 1 : (j12 == 0 ? 0 : -1));
                            if (i4 < 0 || j12 > 72000) {
                                if (i4 < 0) {
                                    this.j = j10;
                                    this.l = j11;
                                } else {
                                    long j13 = (long) i3;
                                    long j14 = bVar.c + j13;
                                    this.i = j14;
                                    this.k = j11;
                                    if ((this.j - j14) + j13 < 100000) {
                                        bVar.c(i3);
                                        j3 = this.k;
                                    }
                                }
                                long j15 = this.j;
                                long j16 = this.i;
                                long j17 = j15 - j16;
                                if (j17 < 100000) {
                                    this.j = j16;
                                    j2 = j16;
                                } else {
                                    j2 = Math.min(Math.max((bVar.c - ((long) (i3 * (i4 <= 0 ? 2 : 1)))) + ((j12 * j17) / (this.l - this.k)), j16), this.j - 1);
                                }
                            } else {
                                bVar.c(i3);
                                j3 = this.a.b;
                            }
                            j2 = -(j3 + 2);
                        }
                    }
                    if (j2 >= 0) {
                        return j2;
                    }
                    long j18 = this.h;
                    this.a.a(gVar2, false);
                    j7 = -(j2 + 2);
                    while (true) {
                        e eVar3 = this.a;
                        if (eVar3.b >= j18) {
                            break;
                        }
                        ((b) gVar2).c(eVar3.d + eVar3.e);
                        e eVar4 = this.a;
                        j7 = eVar4.b;
                        eVar4.a(gVar2, false);
                    }
                    ((b) gVar2).e = 0;
                }
                this.e = 3;
                return -(j7 + 2);
            } else if (i2 == 3) {
                return -1;
            } else {
                throw new IllegalStateException();
            }
        }
        if (a(gVar2, this.c)) {
            this.a.a();
            while (true) {
                eVar = this.a;
                if ((eVar.a & 4) == 4) {
                    break;
                }
                b bVar2 = (b) gVar2;
                if (bVar2.c >= this.c) {
                    break;
                }
                eVar.a(gVar2, false);
                e eVar5 = this.a;
                bVar2.c(eVar5.d + eVar5.e);
            }
            this.f = eVar.b;
            this.e = 3;
            return this.g;
        }
        throw new EOFException();
    }

    public boolean a(g gVar, long j2) throws IOException, InterruptedException {
        int i2;
        long min = Math.min(j2 + 3, this.c);
        int i3 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            b bVar = (b) gVar;
            int i4 = 0;
            if (bVar.c + ((long) i3) <= min || (i3 = (int) (min - bVar.c)) >= 4) {
                bVar.a(bArr, 0, i3, false);
                while (true) {
                    i2 = i3 - 3;
                    if (i4 >= i2) {
                        break;
                    } else if (bArr[i4] == 79 && bArr[i4 + 1] == 103 && bArr[i4 + 2] == 103 && bArr[i4 + 3] == 83) {
                        bVar.c(i4);
                        return true;
                    } else {
                        i4++;
                    }
                }
            } else {
                return false;
            }
            bVar.c(i2);
        }
    }
}
