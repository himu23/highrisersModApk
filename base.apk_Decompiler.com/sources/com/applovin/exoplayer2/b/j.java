package com.applovin.exoplayer2.b;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.work.WorkRequest;
import com.applovin.exoplayer2.h;
import com.applovin.exoplayer2.l.ai;
import java.lang.reflect.Method;

final class j {
    private long kA;
    private int kB;
    private int kC;
    private long kD;
    private long kE;
    private long kF;
    private long kG;
    private long kH;
    private long kI;
    private boolean kJ;
    private long kK;
    private long kL;
    private AudioTrack kc;
    private final a kh;
    private final long[] ki;
    private int kj;
    private int kk;
    private i kl;
    private int km;
    private boolean kn;
    private long ko;
    private float kp;
    private boolean kq;
    private long kr;
    private long ks;
    private Method kt;
    private long ku;
    private boolean kv;
    private boolean kw;
    private long kx;
    private long ky;
    private long kz;

    public interface a {
        void E(long j);

        void P(long j);

        void a(long j, long j2, long j3, long j4);

        void b(long j, long j2, long j3, long j4);

        void c(int i, long j);
    }

    private void ea() {
        this.kr = 0;
        this.kC = 0;
        this.kB = 0;
        this.ks = 0;
        this.kI = 0;
        this.kL = 0;
        this.kq = false;
    }

    public j(a aVar) {
        this.kh = (a) com.applovin.exoplayer2.l.a.checkNotNull(aVar);
        if (ai.acV >= 18) {
            try {
                Class[] clsArr = null;
                this.kt = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.ki = new long[10];
    }

    public void a(AudioTrack audioTrack, boolean z, int i, int i2, int i3) {
        this.kc = audioTrack;
        this.kj = i2;
        this.kk = i3;
        this.kl = new i(audioTrack);
        this.km = audioTrack.getSampleRate();
        this.kn = z && ay(i);
        boolean fJ = ai.fJ(i);
        this.kw = fJ;
        this.ko = fJ ? O((long) (i3 / i2)) : -9223372036854775807L;
        this.ky = 0;
        this.kz = 0;
        this.kA = 0;
        this.kv = false;
        this.kD = -9223372036854775807L;
        this.kE = -9223372036854775807L;
        this.kx = 0;
        this.ku = 0;
        this.kp = 1.0f;
    }

    public void i(float f) {
        this.kp = f;
        i iVar = this.kl;
        if (iVar != null) {
            iVar.Y();
        }
    }

    public long F(boolean z) {
        long j;
        if (((AudioTrack) com.applovin.exoplayer2.l.a.checkNotNull(this.kc)).getPlayState() == 3) {
            dZ();
        }
        long nanoTime = System.nanoTime() / 1000;
        i iVar = (i) com.applovin.exoplayer2.l.a.checkNotNull(this.kl);
        boolean dU = iVar.dU();
        if (dU) {
            j = O(iVar.dW()) + ai.a(nanoTime - iVar.dV(), this.kp);
        } else {
            j = this.kC == 0 ? ec() : this.kr + nanoTime;
            if (!z) {
                j = Math.max(0, j - this.ku);
            }
        }
        if (this.kJ != dU) {
            this.kL = this.kI;
            this.kK = this.kH;
        }
        long j2 = nanoTime - this.kL;
        if (j2 < 1000000) {
            long j3 = (j2 * 1000) / 1000000;
            j = ((j * j3) + ((1000 - j3) * (this.kK + ai.a(j2, this.kp)))) / 1000;
        }
        if (!this.kq) {
            long j4 = this.kH;
            if (j > j4) {
                this.kq = true;
                this.kh.E(System.currentTimeMillis() - h.f(ai.b(h.f(j - j4), this.kp)));
            }
        }
        this.kI = nanoTime;
        this.kH = j;
        this.kJ = dU;
        return j;
    }

    public void start() {
        ((i) com.applovin.exoplayer2.l.a.checkNotNull(this.kl)).Y();
    }

    public boolean v() {
        return ((AudioTrack) com.applovin.exoplayer2.l.a.checkNotNull(this.kc)).getPlayState() == 3;
    }

    public boolean H(long j) {
        int playState = ((AudioTrack) com.applovin.exoplayer2.l.a.checkNotNull(this.kc)).getPlayState();
        if (this.kn) {
            if (playState == 2) {
                this.kv = false;
                return false;
            } else if (playState == 1 && ed() == 0) {
                return false;
            }
        }
        boolean z = this.kv;
        boolean M = M(j);
        this.kv = M;
        if (z && !M && playState != 1) {
            this.kh.c(this.kk, h.f(this.ko));
        }
        return true;
    }

    public int I(long j) {
        return this.kk - ((int) (j - (ed() * ((long) this.kj))));
    }

    public long J(long j) {
        return h.f(O(j - ed()));
    }

    public boolean K(long j) {
        return this.kE != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.kE >= 200;
    }

    public void L(long j) {
        this.kF = ed();
        this.kD = SystemClock.elapsedRealtime() * 1000;
        this.kG = j;
    }

    public boolean M(long j) {
        return j > ed() || eb();
    }

    public boolean dY() {
        ea();
        if (this.kD != -9223372036854775807L) {
            return false;
        }
        ((i) com.applovin.exoplayer2.l.a.checkNotNull(this.kl)).Y();
        return true;
    }

    public void Y() {
        ea();
        this.kc = null;
        this.kl = null;
    }

    private void dZ() {
        long ec = ec();
        if (ec != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.ks >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                long[] jArr = this.ki;
                int i = this.kB;
                jArr[i] = ec - nanoTime;
                this.kB = (i + 1) % 10;
                int i2 = this.kC;
                if (i2 < 10) {
                    this.kC = i2 + 1;
                }
                this.ks = nanoTime;
                this.kr = 0;
                int i3 = 0;
                while (true) {
                    int i4 = this.kC;
                    if (i3 >= i4) {
                        break;
                    }
                    this.kr += this.ki[i3] / ((long) i4);
                    i3++;
                }
            }
            if (!this.kn) {
                h(nanoTime, ec);
                N(nanoTime);
            }
        }
    }

    private void h(long j, long j2) {
        i iVar = (i) com.applovin.exoplayer2.l.a.checkNotNull(this.kl);
        if (iVar.G(j)) {
            long dV = iVar.dV();
            long dW = iVar.dW();
            if (Math.abs(dV - j) > 5000000) {
                this.kh.b(dW, dV, j, j2);
                iVar.dS();
            } else if (Math.abs(O(dW) - j2) > 5000000) {
                this.kh.a(dW, dV, j, j2);
                iVar.dS();
            } else {
                iVar.dT();
            }
        }
    }

    private void N(long j) {
        Method method;
        if (this.kw && (method = this.kt) != null && j - this.kx >= 500000) {
            try {
                long intValue = (((long) ((Integer) ai.R((Integer) method.invoke(com.applovin.exoplayer2.l.a.checkNotNull(this.kc), new Object[0]))).intValue()) * 1000) - this.ko;
                this.ku = intValue;
                long max = Math.max(intValue, 0);
                this.ku = max;
                if (max > 5000000) {
                    this.kh.P(max);
                    this.ku = 0;
                }
            } catch (Exception unused) {
                this.kt = null;
            }
            this.kx = j;
        }
    }

    private long O(long j) {
        return (j * 1000000) / ((long) this.km);
    }

    private boolean eb() {
        return this.kn && ((AudioTrack) com.applovin.exoplayer2.l.a.checkNotNull(this.kc)).getPlayState() == 2 && ed() == 0;
    }

    private static boolean ay(int i) {
        return ai.acV < 23 && (i == 5 || i == 6);
    }

    private long ec() {
        return O(ed());
    }

    private long ed() {
        AudioTrack audioTrack = (AudioTrack) com.applovin.exoplayer2.l.a.checkNotNull(this.kc);
        if (this.kD != -9223372036854775807L) {
            return Math.min(this.kG, this.kF + ((((SystemClock.elapsedRealtime() * 1000) - this.kD) * ((long) this.km)) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
        if (this.kn) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.kA = this.ky;
            }
            playbackHeadPosition += this.kA;
        }
        if (ai.acV <= 29) {
            if (playbackHeadPosition == 0 && this.ky > 0 && playState == 3) {
                if (this.kE == -9223372036854775807L) {
                    this.kE = SystemClock.elapsedRealtime();
                }
                return this.ky;
            }
            this.kE = -9223372036854775807L;
        }
        if (this.ky > playbackHeadPosition) {
            this.kz++;
        }
        this.ky = playbackHeadPosition;
        return playbackHeadPosition + (this.kz << 32);
    }
}
