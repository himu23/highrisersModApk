package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.audio.MediaCodecAudioRenderer;
import com.fyber.inneractive.sdk.player.exoplayer2.m;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.ironsource.m2;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

public final class c {
    public long A;
    public boolean B;
    public long C;
    public Method D;
    public int E;
    public long F;
    public long G;
    public int H;
    public long I;
    public long J;
    public int K;
    public int L;
    public long M;
    public long N;
    public long O;
    public float P;
    public b[] Q;
    public ByteBuffer[] R;
    public ByteBuffer S;
    public ByteBuffer T;
    public byte[] U;
    public int V;
    public int W;
    public boolean X;
    public boolean Y;
    public int Z;
    public final d a;
    public boolean a0;
    public final h b;
    public boolean b0;
    public final b[] c;
    public long c0;
    public final f d;
    public final ConditionVariable e = new ConditionVariable(true);
    public final long[] f;
    public final b g;
    public final LinkedList<g> h;
    public AudioTrack i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public long q;
    public m r;
    public m s;
    public long t;
    public long u;
    public ByteBuffer v;
    public int w;
    public int x;
    public int y;
    public long z;

    public class a extends Thread {
        public final /* synthetic */ AudioTrack a;

        public a(AudioTrack audioTrack) {
            this.a = audioTrack;
        }

        public void run() {
            try {
                this.a.flush();
                this.a.release();
            } finally {
                c.this.e.open();
            }
        }
    }

    public static class b {
        public AudioTrack a;
        public boolean b;
        public int c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;
        public long i;

        public b() {
        }

        public long b() {
            throw new UnsupportedOperationException();
        }

        public long c() {
            throw new UnsupportedOperationException();
        }

        public boolean d() {
            return false;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public void a(AudioTrack audioTrack, boolean z) {
            this.a = audioTrack;
            this.b = z;
            this.g = -9223372036854775807L;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            if (audioTrack != null) {
                this.c = audioTrack.getSampleRate();
            }
        }

        public long a() {
            if (this.g != -9223372036854775807L) {
                return Math.min(this.i, this.h + ((((SystemClock.elapsedRealtime() * 1000) - this.g) * ((long) this.c)) / 1000000));
            }
            int playState = this.a.getPlayState();
            if (playState == 1) {
                return 0;
            }
            long playbackHeadPosition = ((long) this.a.getPlaybackHeadPosition()) & 4294967295L;
            if (this.b) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.f = this.d;
                }
                playbackHeadPosition += this.f;
            }
            if (this.d > playbackHeadPosition) {
                this.e++;
            }
            this.d = playbackHeadPosition;
            return playbackHeadPosition + (this.e << 32);
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.player.exoplayer2.audio.c$c  reason: collision with other inner class name */
    public static class C0111c extends b {
        public final AudioTimestamp j = new AudioTimestamp();
        public long k;
        public long l;
        public long m;

        public C0111c() {
            super((a) null);
        }

        public void a(AudioTrack audioTrack, boolean z) {
            super.a(audioTrack, z);
            this.k = 0;
            this.l = 0;
            this.m = 0;
        }

        public long b() {
            return this.m;
        }

        public long c() {
            return this.j.nanoTime;
        }

        public boolean d() {
            boolean timestamp = this.a.getTimestamp(this.j);
            if (timestamp) {
                long j2 = this.j.framePosition;
                if (this.l > j2) {
                    this.k++;
                }
                this.l = j2;
                this.m = j2 + (this.k << 32);
            }
            return timestamp;
        }
    }

    public static final class d extends Exception {
        public d(Throwable th) {
            super(th);
        }

        public d(String str) {
            super(str);
        }
    }

    public static final class e extends Exception {
        public e(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
        }
    }

    public interface f {
    }

    public static final class g {
        public final m a;
        public final long b;
        public final long c;

        public g(m mVar, long j, long j2) {
            this.a = mVar;
            this.b = j;
            this.c = j2;
        }
    }

    public static final class h extends Exception {
        public h(int i) {
            super("AudioTrack write failed: " + i);
        }
    }

    public c(b[] bVarArr, f fVar) {
        this.d = fVar;
        if (u.a >= 18) {
            try {
                this.D = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (u.a >= 19) {
            this.g = new C0111c();
        } else {
            this.g = new b((a) null);
        }
        d dVar = new d();
        this.a = dVar;
        h hVar = new h();
        this.b = hVar;
        b[] bVarArr2 = new b[(bVarArr.length + 3)];
        this.c = bVarArr2;
        bVarArr2[0] = new f();
        bVarArr2[1] = dVar;
        System.arraycopy(bVarArr, 0, bVarArr2, 2, bVarArr.length);
        bVarArr2[bVarArr.length + 2] = hVar;
        this.f = new long[10];
        this.P = 1.0f;
        this.L = 0;
        this.n = 3;
        this.Z = 0;
        this.s = m.d;
        this.W = -1;
        this.Q = new b[0];
        this.R = new ByteBuffer[0];
        this.h = new LinkedList<>();
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x00cb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r10, int r11, int r12, int r13, int r14, int[] r15) throws com.fyber.inneractive.sdk.player.exoplayer2.audio.c.d {
        /*
            r9 = this;
            java.lang.String r0 = "audio/raw"
            boolean r0 = r0.equals(r10)
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x000f
            int r10 = a((java.lang.String) r10)
            goto L_0x0010
        L_0x000f:
            r10 = r13
        L_0x0010:
            r2 = 0
            if (r0 != 0) goto L_0x0049
            int r13 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.b(r13, r11)
            r9.E = r13
            com.fyber.inneractive.sdk.player.exoplayer2.audio.d r13 = r9.a
            r13.d = r15
            com.fyber.inneractive.sdk.player.exoplayer2.audio.b[] r13 = r9.c
            int r15 = r13.length
            r3 = 0
            r4 = 0
        L_0x0022:
            if (r3 >= r15) goto L_0x0043
            r5 = r13[r3]
            boolean r6 = r5.a(r12, r11, r10)     // Catch:{ a -> 0x003c }
            r4 = r4 | r6
            boolean r6 = r5.d()
            if (r6 == 0) goto L_0x0039
            int r11 = r5.f()
            int r10 = r5.e()
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x0022
        L_0x003c:
            r10 = move-exception
            com.fyber.inneractive.sdk.player.exoplayer2.audio.c$d r11 = new com.fyber.inneractive.sdk.player.exoplayer2.audio.c$d
            r11.<init>((java.lang.Throwable) r10)
            throw r11
        L_0x0043:
            if (r4 == 0) goto L_0x004a
            r9.i()
            goto L_0x004a
        L_0x0049:
            r4 = 0
        L_0x004a:
            r13 = 252(0xfc, float:3.53E-43)
            r15 = 12
            switch(r11) {
                case 1: goto L_0x007a;
                case 2: goto L_0x0077;
                case 3: goto L_0x0074;
                case 4: goto L_0x0071;
                case 5: goto L_0x006e;
                case 6: goto L_0x006b;
                case 7: goto L_0x0068;
                case 8: goto L_0x0065;
                default: goto L_0x0051;
            }
        L_0x0051:
            com.fyber.inneractive.sdk.player.exoplayer2.audio.c$d r10 = new com.fyber.inneractive.sdk.player.exoplayer2.audio.c$d
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "Unsupported channel count: "
            r12.<init>(r13)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            r10.<init>((java.lang.String) r11)
            throw r10
        L_0x0065:
            int r3 = com.fyber.inneractive.sdk.player.exoplayer2.b.a
            goto L_0x007b
        L_0x0068:
            r3 = 1276(0x4fc, float:1.788E-42)
            goto L_0x007b
        L_0x006b:
            r3 = 252(0xfc, float:3.53E-43)
            goto L_0x007b
        L_0x006e:
            r3 = 220(0xdc, float:3.08E-43)
            goto L_0x007b
        L_0x0071:
            r3 = 204(0xcc, float:2.86E-43)
            goto L_0x007b
        L_0x0074:
            r3 = 28
            goto L_0x007b
        L_0x0077:
            r3 = 12
            goto L_0x007b
        L_0x007a:
            r3 = 4
        L_0x007b:
            int r5 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a
            r6 = 23
            r7 = 5
            if (r5 > r6) goto L_0x00a2
            java.lang.String r6 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.b
            java.lang.String r8 = "foster"
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L_0x00a2
            java.lang.String r6 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.c
            java.lang.String r8 = "NVIDIA"
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L_0x00a2
            r6 = 3
            if (r11 == r6) goto L_0x00a3
            if (r11 == r7) goto L_0x00a3
            r13 = 7
            if (r11 == r13) goto L_0x009f
            goto L_0x00a2
        L_0x009f:
            int r13 = com.fyber.inneractive.sdk.player.exoplayer2.b.a
            goto L_0x00a3
        L_0x00a2:
            r13 = r3
        L_0x00a3:
            r3 = 25
            if (r5 > r3) goto L_0x00b6
            java.lang.String r3 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.b
            java.lang.String r5 = "fugu"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x00b6
            if (r0 == 0) goto L_0x00b6
            if (r11 != r1) goto L_0x00b6
            goto L_0x00b7
        L_0x00b6:
            r15 = r13
        L_0x00b7:
            if (r4 != 0) goto L_0x00cc
            boolean r13 = r9.e()
            if (r13 == 0) goto L_0x00cc
            int r13 = r9.l
            if (r13 != r10) goto L_0x00cc
            int r13 = r9.j
            if (r13 != r12) goto L_0x00cc
            int r13 = r9.k
            if (r13 != r15) goto L_0x00cc
            return
        L_0x00cc:
            r9.h()
            r9.l = r10
            r9.o = r0
            r9.j = r12
            r9.k = r15
            r13 = 2
            if (r0 == 0) goto L_0x00db
            goto L_0x00dc
        L_0x00db:
            r10 = 2
        L_0x00dc:
            r9.m = r10
            int r10 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.b(r13, r11)
            r9.H = r10
            if (r14 == 0) goto L_0x00e9
            r9.p = r14
            goto L_0x0135
        L_0x00e9:
            if (r0 == 0) goto L_0x00fe
            int r10 = r9.m
            if (r10 == r7) goto L_0x00f9
            r11 = 6
            if (r10 != r11) goto L_0x00f3
            goto L_0x00f9
        L_0x00f3:
            r10 = 49152(0xc000, float:6.8877E-41)
            r9.p = r10
            goto L_0x0135
        L_0x00f9:
            r10 = 20480(0x5000, float:2.8699E-41)
            r9.p = r10
            goto L_0x0135
        L_0x00fe:
            int r10 = r9.m
            int r10 = android.media.AudioTrack.getMinBufferSize(r12, r15, r10)
            r11 = -2
            if (r10 == r11) goto L_0x0108
            goto L_0x0109
        L_0x0108:
            r1 = 0
        L_0x0109:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r1)
            int r11 = r10 * 4
            r12 = 250000(0x3d090, double:1.235164E-318)
            long r12 = r9.a((long) r12)
            int r13 = (int) r12
            int r12 = r9.H
            int r13 = r13 * r12
            long r14 = (long) r10
            r1 = 750000(0xb71b0, double:3.70549E-318)
            long r1 = r9.a((long) r1)
            int r10 = r9.H
            long r3 = (long) r10
            long r1 = r1 * r3
            long r14 = java.lang.Math.max(r14, r1)
            int r10 = (int) r14
            if (r11 >= r13) goto L_0x0130
            r11 = r13
            goto L_0x0133
        L_0x0130:
            if (r11 <= r10) goto L_0x0133
            r11 = r10
        L_0x0133:
            r9.p = r11
        L_0x0135:
            if (r0 == 0) goto L_0x013d
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0147
        L_0x013d:
            int r10 = r9.p
            int r11 = r9.H
            int r10 = r10 / r11
            long r10 = (long) r10
            long r10 = r9.b(r10)
        L_0x0147:
            r9.q = r10
            com.fyber.inneractive.sdk.player.exoplayer2.m r10 = r9.s
            r9.a((com.fyber.inneractive.sdk.player.exoplayer2.m) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.audio.c.a(java.lang.String, int, int, int, int, int[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d7, code lost:
        if (r11 < r10) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0112  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(java.nio.ByteBuffer r9, long r10) throws com.fyber.inneractive.sdk.player.exoplayer2.audio.c.h {
        /*
            r8 = this;
            boolean r0 = r9.hasRemaining()
            r1 = 1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.nio.ByteBuffer r0 = r8.T
            r2 = 21
            r3 = 0
            if (r0 == 0) goto L_0x0018
            if (r0 != r9) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a((boolean) r0)
            goto L_0x003b
        L_0x0018:
            r8.T = r9
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a
            if (r0 >= r2) goto L_0x003b
            int r0 = r9.remaining()
            byte[] r4 = r8.U
            if (r4 == 0) goto L_0x0029
            int r4 = r4.length
            if (r4 >= r0) goto L_0x002d
        L_0x0029:
            byte[] r4 = new byte[r0]
            r8.U = r4
        L_0x002d:
            int r4 = r9.position()
            byte[] r5 = r8.U
            r9.get(r5, r3, r0)
            r9.position(r4)
            r8.V = r3
        L_0x003b:
            int r0 = r9.remaining()
            int r4 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a
            if (r4 >= r2) goto L_0x0079
            long r10 = r8.I
            com.fyber.inneractive.sdk.player.exoplayer2.audio.c$b r2 = r8.g
            long r4 = r2.a()
            int r2 = r8.H
            long r6 = (long) r2
            long r4 = r4 * r6
            long r10 = r10 - r4
            int r11 = (int) r10
            int r10 = r8.p
            int r10 = r10 - r11
            if (r10 <= 0) goto L_0x0076
            int r10 = java.lang.Math.min(r0, r10)
            android.media.AudioTrack r11 = r8.i
            byte[] r2 = r8.U
            int r4 = r8.V
            int r10 = r11.write(r2, r4, r10)
            if (r10 <= 0) goto L_0x00ef
            int r11 = r8.V
            int r11 = r11 + r10
            r8.V = r11
            int r11 = r9.position()
            int r11 = r11 + r10
            r9.position(r11)
            goto L_0x00ef
        L_0x0076:
            r10 = 0
            goto L_0x00ef
        L_0x0079:
            boolean r2 = r8.a0
            if (r2 == 0) goto L_0x00e9
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0088
            r2 = 1
            goto L_0x0089
        L_0x0088:
            r2 = 0
        L_0x0089:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r2)
            android.media.AudioTrack r2 = r8.i
            java.nio.ByteBuffer r4 = r8.v
            if (r4 != 0) goto L_0x00a7
            r4 = 16
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)
            r8.v = r4
            java.nio.ByteOrder r5 = java.nio.ByteOrder.BIG_ENDIAN
            r4.order(r5)
            java.nio.ByteBuffer r4 = r8.v
            r5 = 1431633921(0x55550001, float:1.46372496E13)
            r4.putInt(r5)
        L_0x00a7:
            int r4 = r8.w
            if (r4 != 0) goto L_0x00c3
            java.nio.ByteBuffer r4 = r8.v
            r5 = 4
            r4.putInt(r5, r0)
            java.nio.ByteBuffer r4 = r8.v
            r5 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 * r5
            r5 = 8
            r4.putLong(r5, r10)
            java.nio.ByteBuffer r10 = r8.v
            r10.position(r3)
            r8.w = r0
        L_0x00c3:
            java.nio.ByteBuffer r10 = r8.v
            int r10 = r10.remaining()
            if (r10 <= 0) goto L_0x00da
            java.nio.ByteBuffer r11 = r8.v
            int r11 = r2.write(r11, r10, r1)
            if (r11 >= 0) goto L_0x00d7
            r8.w = r3
            r10 = r11
            goto L_0x00ef
        L_0x00d7:
            if (r11 >= r10) goto L_0x00da
            goto L_0x0076
        L_0x00da:
            int r10 = r2.write(r9, r0, r1)
            if (r10 >= 0) goto L_0x00e3
            r8.w = r3
            goto L_0x00ef
        L_0x00e3:
            int r9 = r8.w
            int r9 = r9 - r10
            r8.w = r9
            goto L_0x00ef
        L_0x00e9:
            android.media.AudioTrack r10 = r8.i
            int r10 = r10.write(r9, r0, r1)
        L_0x00ef:
            long r4 = android.os.SystemClock.elapsedRealtime()
            r8.c0 = r4
            if (r10 < 0) goto L_0x0112
            boolean r9 = r8.o
            if (r9 != 0) goto L_0x0101
            long r4 = r8.I
            long r6 = (long) r10
            long r4 = r4 + r6
            r8.I = r4
        L_0x0101:
            if (r10 != r0) goto L_0x0111
            if (r9 == 0) goto L_0x010d
            long r9 = r8.J
            int r11 = r8.K
            long r2 = (long) r11
            long r9 = r9 + r2
            r8.J = r9
        L_0x010d:
            r9 = 0
            r8.T = r9
            return r1
        L_0x0111:
            return r3
        L_0x0112:
            com.fyber.inneractive.sdk.player.exoplayer2.audio.c$h r9 = new com.fyber.inneractive.sdk.player.exoplayer2.audio.c$h
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.audio.c.b(java.nio.ByteBuffer, long):boolean");
    }

    public final void c(long j2) throws h {
        ByteBuffer byteBuffer;
        int length = this.Q.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                byteBuffer = this.R[i2 - 1];
            } else {
                byteBuffer = this.S;
                if (byteBuffer == null) {
                    byteBuffer = b.a;
                }
            }
            if (i2 == length) {
                b(byteBuffer, j2);
            } else {
                b bVar = this.Q[i2];
                bVar.a(byteBuffer);
                ByteBuffer a2 = bVar.a();
                this.R[i2] = a2;
                if (a2.hasRemaining()) {
                    i2++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i2--;
            } else {
                return;
            }
        }
    }

    public boolean d() {
        return e() && (c() > this.g.a() || (f() && this.i.getPlayState() == 2 && this.i.getPlaybackHeadPosition() == 0));
    }

    public final boolean e() {
        return this.i != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.m;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f() {
        /*
            r2 = this;
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a
            r1 = 23
            if (r0 >= r1) goto L_0x0010
            int r0 = r2.m
            r1 = 5
            if (r0 == r1) goto L_0x000e
            r1 = 6
            if (r0 != r1) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.audio.c.f():boolean");
    }

    public void h() {
        if (e()) {
            this.F = 0;
            this.G = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            m mVar = this.r;
            if (mVar != null) {
                this.s = mVar;
                this.r = null;
            } else if (!this.h.isEmpty()) {
                this.s = this.h.getLast().a;
            }
            this.h.clear();
            this.t = 0;
            this.u = 0;
            this.S = null;
            this.T = null;
            int i2 = 0;
            while (true) {
                b[] bVarArr = this.Q;
                if (i2 >= bVarArr.length) {
                    break;
                }
                b bVar = bVarArr[i2];
                bVar.flush();
                this.R[i2] = bVar.a();
                i2++;
            }
            this.X = false;
            this.W = -1;
            this.v = null;
            this.w = 0;
            this.L = 0;
            this.O = 0;
            j();
            if (this.i.getPlayState() == 3) {
                this.i.pause();
            }
            AudioTrack audioTrack = this.i;
            this.i = null;
            this.g.a((AudioTrack) null, false);
            this.e.close();
            new a(audioTrack).start();
        }
    }

    public final void i() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.c) {
            if (bVar.d()) {
                arrayList.add(bVar);
            } else {
                bVar.flush();
            }
        }
        int size = arrayList.size();
        this.Q = (b[]) arrayList.toArray(new b[size]);
        this.R = new ByteBuffer[size];
        for (int i2 = 0; i2 < size; i2++) {
            b bVar2 = this.Q[i2];
            bVar2.flush();
            this.R[i2] = bVar2.a();
        }
    }

    public final void j() {
        this.z = 0;
        this.y = 0;
        this.x = 0;
        this.A = 0;
        this.B = false;
        this.C = 0;
    }

    public final void k() {
        if (e()) {
            if (u.a >= 21) {
                this.i.setVolume(this.P);
                return;
            }
            AudioTrack audioTrack = this.i;
            float f2 = this.P;
            audioTrack.setStereoVolume(f2, f2);
        }
    }

    public void g() {
        this.Y = true;
        if (e()) {
            this.N = System.nanoTime() / 1000;
            this.i.play();
        }
    }

    public final long c() {
        return this.o ? this.J : this.I / ((long) this.H);
    }

    public final long b(long j2) {
        return (j2 * 1000000) / ((long) this.j);
    }

    public final long b() {
        return this.o ? this.G : this.F / ((long) this.E);
    }

    public boolean a(ByteBuffer byteBuffer, long j2) throws e, h {
        int i2;
        int i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = j2;
        ByteBuffer byteBuffer3 = this.S;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(byteBuffer3 == null || byteBuffer2 == byteBuffer3);
        if (!e()) {
            this.e.block();
            if (this.a0) {
                this.i = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.k).setEncoding(this.m).setSampleRate(this.j).build(), this.p, 1, this.Z);
            } else if (this.Z == 0) {
                this.i = new AudioTrack(this.n, this.j, this.k, this.m, this.p, 1);
            } else {
                this.i = new AudioTrack(this.n, this.j, this.k, this.m, this.p, 1, this.Z);
            }
            int state = this.i.getState();
            if (state == 1) {
                int audioSessionId = this.i.getAudioSessionId();
                if (this.Z != audioSessionId) {
                    this.Z = audioSessionId;
                    MediaCodecAudioRenderer.b bVar = (MediaCodecAudioRenderer.b) this.d;
                    MediaCodecAudioRenderer.this.V.audioSessionId(audioSessionId);
                    MediaCodecAudioRenderer.this.getClass();
                }
                this.g.a(this.i, f());
                k();
                this.b0 = false;
                if (this.Y) {
                    g();
                }
            } else {
                try {
                    this.i.release();
                } catch (Exception unused) {
                } finally {
                    this.i = null;
                }
                throw new e(state, this.j, this.k, this.p);
            }
        }
        if (f()) {
            if (this.i.getPlayState() == 2) {
                this.b0 = false;
                return false;
            } else if (this.i.getPlayState() == 1 && this.g.a() != 0) {
                return false;
            }
        }
        boolean z2 = this.b0;
        boolean d2 = d();
        this.b0 = d2;
        if (z2 && !d2 && this.i.getPlayState() != 1) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.c0;
            MediaCodecAudioRenderer.b bVar2 = (MediaCodecAudioRenderer.b) this.d;
            MediaCodecAudioRenderer.this.V.audioTrackUnderrun(this.p, com.fyber.inneractive.sdk.player.exoplayer2.b.b(this.q), elapsedRealtime);
            MediaCodecAudioRenderer.this.getClass();
        }
        if (this.S == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.o && this.K == 0) {
                int i4 = this.m;
                int i5 = 6;
                if (i4 == 7 || i4 == 8) {
                    int position = byteBuffer.position();
                    i3 = ((((byteBuffer2.get(position + 5) & 252) >> 2) | ((byteBuffer2.get(position + 4) & 1) << 6)) + 1) * 32;
                } else if (i4 == 5) {
                    i3 = 1536;
                } else if (i4 == 6) {
                    if (((byteBuffer2.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
                        i5 = a.a[(byteBuffer2.get(byteBuffer.position() + 4) & 48) >> 4];
                    }
                    i3 = i5 * 256;
                } else {
                    throw new IllegalStateException("Unexpected audio encoding: " + i4);
                }
                this.K = i3;
            }
            if (this.r != null) {
                if (!a()) {
                    return false;
                }
                this.h.add(new g(this.r, Math.max(0, j3), b(c())));
                this.r = null;
                i();
            }
            if (this.L == 0) {
                this.M = Math.max(0, j3);
                this.L = 1;
            } else {
                long b2 = this.M + b(b());
                if (this.L != 1 || Math.abs(b2 - j3) <= 200000) {
                    i2 = 2;
                } else {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + b2 + ", got " + j3 + m2.i.e);
                    i2 = 2;
                    this.L = 2;
                }
                if (this.L == i2) {
                    this.M += j3 - b2;
                    this.L = 1;
                    MediaCodecAudioRenderer.b bVar3 = (MediaCodecAudioRenderer.b) this.d;
                    MediaCodecAudioRenderer.this.getClass();
                    boolean unused2 = MediaCodecAudioRenderer.this.b0 = true;
                }
            }
            if (this.o) {
                this.G += (long) this.K;
            } else {
                this.F += (long) byteBuffer.remaining();
            }
            this.S = byteBuffer2;
        }
        if (this.o) {
            b(this.S, j3);
        } else {
            c(j3);
        }
        if (this.S.hasRemaining()) {
            return false;
        }
        this.S = null;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() throws com.fyber.inneractive.sdk.player.exoplayer2.audio.c.h {
        /*
            r9 = this;
            int r0 = r9.W
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto L_0x0014
            boolean r0 = r9.o
            if (r0 == 0) goto L_0x000f
            com.fyber.inneractive.sdk.player.exoplayer2.audio.b[] r0 = r9.Q
            int r0 = r0.length
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            r9.W = r0
        L_0x0012:
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            int r4 = r9.W
            com.fyber.inneractive.sdk.player.exoplayer2.audio.b[] r5 = r9.Q
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x0038
            r4 = r5[r4]
            if (r0 == 0) goto L_0x0028
            r4.c()
        L_0x0028:
            r9.c(r7)
            boolean r0 = r4.b()
            if (r0 != 0) goto L_0x0032
            return r2
        L_0x0032:
            int r0 = r9.W
            int r0 = r0 + r1
            r9.W = r0
            goto L_0x0012
        L_0x0038:
            java.nio.ByteBuffer r0 = r9.T
            if (r0 == 0) goto L_0x0044
            r9.b(r0, r7)
            java.nio.ByteBuffer r0 = r9.T
            if (r0 == 0) goto L_0x0044
            return r2
        L_0x0044:
            r9.W = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.audio.c.a():boolean");
    }

    public m a(m mVar) {
        if (this.o) {
            m mVar2 = m.d;
            this.s = mVar2;
            return mVar2;
        }
        h hVar = this.b;
        float f2 = mVar.a;
        hVar.getClass();
        int i2 = u.a;
        float max = Math.max(0.1f, Math.min(f2, 8.0f));
        hVar.e = max;
        h hVar2 = this.b;
        float f3 = mVar.b;
        hVar2.getClass();
        hVar2.f = Math.max(0.1f, Math.min(f3, 8.0f));
        m mVar3 = new m(max, f3);
        m mVar4 = this.r;
        if (mVar4 == null) {
            mVar4 = !this.h.isEmpty() ? this.h.getLast().a : this.s;
        }
        if (!mVar3.equals(mVar4)) {
            if (e()) {
                this.r = mVar3;
            } else {
                this.s = mVar3;
            }
        }
        return this.s;
    }

    public final long a(long j2) {
        return (j2 * ((long) this.j)) / 1000000;
    }

    public static int a(String str) {
        str.getClass();
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c2 = 0;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 7;
            case 1:
                return 5;
            case 2:
                return 6;
            case 3:
                return 8;
            default:
                return 0;
        }
    }
}
