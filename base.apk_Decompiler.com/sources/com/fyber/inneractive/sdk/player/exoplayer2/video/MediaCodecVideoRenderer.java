package com.fyber.inneractive.sdk.player.exoplayer2.video;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;
import com.fyber.inneractive.sdk.player.exoplayer2.drm.d;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c;
import com.fyber.inneractive.sdk.player.exoplayer2.util.s;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener;

public class MediaCodecVideoRenderer extends com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b {
    public static final int[] w0 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    public final d V;
    public final VideoRendererEventListener.EventDispatcher W;
    public final long X;
    public final int Y;
    public final boolean Z = A();
    public i[] a0;
    public a b0;
    public Surface c0;
    public int d0 = 1;
    public boolean e0;
    public long f0 = -9223372036854775807L;
    public long g0;
    public int h0;
    public int i0;
    public int j0;
    public float k0 = -1.0f;
    public int l0 = -1;
    public int m0 = -1;
    public int n0;
    public float o0 = -1.0f;
    public int p0;
    public int q0;
    public int r0;
    public float s0;
    public boolean t0;
    public int u0;
    public b v0;

    public static final class a {
        public final int a;
        public final int b;
        public final int c;

        public a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    public final class b implements MediaCodec.OnFrameRenderedListener {
        public b(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        public void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this == mediaCodecVideoRenderer.v0) {
                mediaCodecVideoRenderer.C();
            }
        }
    }

    public MediaCodecVideoRenderer(Context context, c cVar, long j, com.fyber.inneractive.sdk.player.exoplayer2.drm.c<d> cVar2, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        super(2, cVar, (com.fyber.inneractive.sdk.player.exoplayer2.drm.c<d>) null, z);
        this.X = j;
        this.Y = i;
        this.V = new d(context);
        this.W = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        z();
    }

    public static boolean A() {
        return u.a <= 22 && "foster".equals(u.b) && "NVIDIA".equals(u.c);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c r18, com.fyber.inneractive.sdk.player.exoplayer2.i r19) throws com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.b {
        /*
            r17 = this;
            r0 = r19
            java.lang.String r1 = r0.f
            boolean r2 = com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(r1)
            r3 = 0
            if (r2 != 0) goto L_0x000c
            return r3
        L_0x000c:
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a r2 = r0.i
            if (r2 == 0) goto L_0x0023
            r4 = 0
            r5 = 0
        L_0x0012:
            int r6 = r2.c
            if (r4 >= r6) goto L_0x0020
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a$b[] r6 = r2.a
            r6 = r6[r4]
            boolean r6 = r6.e
            r5 = r5 | r6
            int r4 = r4 + 1
            goto L_0x0012
        L_0x0020:
            r2 = r18
            goto L_0x0026
        L_0x0023:
            r2 = r18
            r5 = 0
        L_0x0026:
            com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a r1 = r2.a(r1, r5)
            r2 = 1
            if (r1 != 0) goto L_0x002e
            return r2
        L_0x002e:
            java.lang.String r4 = r0.c
            r5 = 16
            r6 = 4
            r7 = 3
            r8 = 2
            if (r4 == 0) goto L_0x024e
            java.lang.String r9 = r1.d
            if (r9 != 0) goto L_0x003d
            goto L_0x024e
        L_0x003d:
            java.lang.String r9 = com.fyber.inneractive.sdk.player.exoplayer2.util.h.a(r4)
            if (r9 != 0) goto L_0x0045
            goto L_0x024e
        L_0x0045:
            java.lang.String r10 = r1.d
            boolean r10 = r10.equals(r9)
            java.lang.String r11 = ", "
            if (r10 != 0) goto L_0x0068
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r12 = "codec.mime "
            r10.<init>(r12)
            r10.append(r4)
            r10.append(r11)
            r10.append(r9)
            java.lang.String r4 = r10.toString()
            r1.a((java.lang.String) r4)
            goto L_0x024f
        L_0x0068:
            com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a r10 = com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.a
            java.lang.String r10 = "\\."
            java.lang.String[] r10 = r4.split(r10)
            r12 = r10[r3]
            r12.getClass()
            r12.hashCode()
            int r13 = r12.hashCode()
            r14 = -1
            switch(r13) {
                case 3006243: goto L_0x00a2;
                case 3006244: goto L_0x0097;
                case 3199032: goto L_0x008c;
                case 3214780: goto L_0x0081;
                default: goto L_0x0080;
            }
        L_0x0080:
            goto L_0x00ac
        L_0x0081:
            java.lang.String r13 = "hvc1"
            boolean r12 = r12.equals(r13)
            if (r12 != 0) goto L_0x008a
            goto L_0x00ac
        L_0x008a:
            r14 = 3
            goto L_0x00ac
        L_0x008c:
            java.lang.String r13 = "hev1"
            boolean r12 = r12.equals(r13)
            if (r12 != 0) goto L_0x0095
            goto L_0x00ac
        L_0x0095:
            r14 = 2
            goto L_0x00ac
        L_0x0097:
            java.lang.String r13 = "avc2"
            boolean r12 = r12.equals(r13)
            if (r12 != 0) goto L_0x00a0
            goto L_0x00ac
        L_0x00a0:
            r14 = 1
            goto L_0x00ac
        L_0x00a2:
            java.lang.String r13 = "avc1"
            boolean r12 = r12.equals(r13)
            if (r12 != 0) goto L_0x00ab
            goto L_0x00ac
        L_0x00ab:
            r14 = 0
        L_0x00ac:
            java.lang.String r13 = "MediaCodecUtil"
            switch(r14) {
                case 0: goto L_0x013f;
                case 1: goto L_0x013f;
                case 2: goto L_0x00b3;
                case 3: goto L_0x00b3;
                default: goto L_0x00b1;
            }
        L_0x00b1:
            goto L_0x0153
        L_0x00b3:
            int r14 = r10.length
            java.lang.String r15 = "Ignoring malformed HEVC codec string: "
            if (r14 >= r6) goto L_0x00c9
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r15)
            r10.append(r4)
            java.lang.String r10 = r10.toString()
            android.util.Log.w(r13, r10)
            goto L_0x0153
        L_0x00c9:
            java.util.regex.Pattern r14 = com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.b
            r12 = r10[r2]
            java.util.regex.Matcher r12 = r14.matcher(r12)
            boolean r14 = r12.matches()
            if (r14 != 0) goto L_0x00e7
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r15)
            r10.append(r4)
            java.lang.String r10 = r10.toString()
            android.util.Log.w(r13, r10)
            goto L_0x0153
        L_0x00e7:
            java.lang.String r14 = r12.group(r2)
            java.lang.String r15 = "1"
            boolean r15 = r15.equals(r14)
            if (r15 == 0) goto L_0x00f5
            r14 = 1
            goto L_0x00fe
        L_0x00f5:
            java.lang.String r15 = "2"
            boolean r15 = r15.equals(r14)
            if (r15 == 0) goto L_0x012d
            r14 = 2
        L_0x00fe:
            java.util.Map<java.lang.String, java.lang.Integer> r15 = com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.f
            r10 = r10[r7]
            java.util.HashMap r15 = (java.util.HashMap) r15
            java.lang.Object r10 = r15.get(r10)
            java.lang.Integer r10 = (java.lang.Integer) r10
            if (r10 != 0) goto L_0x0122
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r14 = "Unknown HEVC level string: "
            r10.<init>(r14)
            java.lang.String r12 = r12.group(r2)
            r10.append(r12)
            java.lang.String r10 = r10.toString()
            android.util.Log.w(r13, r10)
            goto L_0x0153
        L_0x0122:
            android.util.Pair r12 = new android.util.Pair
            java.lang.Integer r13 = java.lang.Integer.valueOf(r14)
            r12.<init>(r13, r10)
            goto L_0x0204
        L_0x012d:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r12 = "Unknown HEVC profile string: "
            r10.<init>(r12)
            r10.append(r14)
            java.lang.String r10 = r10.toString()
            android.util.Log.w(r13, r10)
            goto L_0x0153
        L_0x013f:
            int r12 = r10.length
            java.lang.String r14 = "Ignoring malformed AVC codec string: "
            if (r12 >= r8) goto L_0x0156
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r14)
            r10.append(r4)
            java.lang.String r10 = r10.toString()
            android.util.Log.w(r13, r10)
        L_0x0153:
            r12 = 0
            goto L_0x0204
        L_0x0156:
            r12 = r10[r2]     // Catch:{ NumberFormatException -> 0x01f3 }
            int r12 = r12.length()     // Catch:{ NumberFormatException -> 0x01f3 }
            r15 = 6
            if (r12 != r15) goto L_0x017c
            r12 = r10[r2]     // Catch:{ NumberFormatException -> 0x01f3 }
            java.lang.String r12 = r12.substring(r3, r8)     // Catch:{ NumberFormatException -> 0x01f3 }
            int r12 = java.lang.Integer.parseInt(r12, r5)     // Catch:{ NumberFormatException -> 0x01f3 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ NumberFormatException -> 0x01f3 }
            r10 = r10[r2]     // Catch:{ NumberFormatException -> 0x01f3 }
            java.lang.String r10 = r10.substring(r6)     // Catch:{ NumberFormatException -> 0x01f3 }
            int r10 = java.lang.Integer.parseInt(r10, r5)     // Catch:{ NumberFormatException -> 0x01f3 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ NumberFormatException -> 0x01f3 }
            goto L_0x0193
        L_0x017c:
            int r12 = r10.length     // Catch:{ NumberFormatException -> 0x01f3 }
            if (r12 < r7) goto L_0x01df
            r12 = r10[r2]     // Catch:{ NumberFormatException -> 0x01f3 }
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ NumberFormatException -> 0x01f3 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ NumberFormatException -> 0x01f3 }
            r10 = r10[r8]     // Catch:{ NumberFormatException -> 0x01f3 }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x01f3 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ NumberFormatException -> 0x01f3 }
        L_0x0193:
            android.util.SparseIntArray r14 = com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.d
            int r15 = r12.intValue()
            int r14 = r14.get(r15)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            if (r14 != 0) goto L_0x01b5
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r14 = "Unknown AVC profile: "
            r10.<init>(r14)
            r10.append(r12)
            java.lang.String r10 = r10.toString()
            android.util.Log.w(r13, r10)
            goto L_0x0153
        L_0x01b5:
            android.util.SparseIntArray r12 = com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.e
            int r15 = r10.intValue()
            int r12 = r12.get(r15)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            if (r12 != 0) goto L_0x01d8
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r14 = "Unknown AVC level: "
            r12.<init>(r14)
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            android.util.Log.w(r13, r10)
            goto L_0x0153
        L_0x01d8:
            android.util.Pair r10 = new android.util.Pair
            r10.<init>(r14, r12)
            r12 = r10
            goto L_0x0204
        L_0x01df:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01f3 }
            r10.<init>()     // Catch:{ NumberFormatException -> 0x01f3 }
            r10.append(r14)     // Catch:{ NumberFormatException -> 0x01f3 }
            r10.append(r4)     // Catch:{ NumberFormatException -> 0x01f3 }
            java.lang.String r10 = r10.toString()     // Catch:{ NumberFormatException -> 0x01f3 }
            android.util.Log.w(r13, r10)     // Catch:{ NumberFormatException -> 0x01f3 }
            goto L_0x0153
        L_0x01f3:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r14)
            r10.append(r4)
            java.lang.String r10 = r10.toString()
            android.util.Log.w(r13, r10)
            goto L_0x0153
        L_0x0204:
            if (r12 != 0) goto L_0x0207
            goto L_0x024e
        L_0x0207:
            android.media.MediaCodecInfo$CodecCapabilities r10 = r1.e
            if (r10 == 0) goto L_0x020f
            android.media.MediaCodecInfo$CodecProfileLevel[] r10 = r10.profileLevels
            if (r10 != 0) goto L_0x0211
        L_0x020f:
            android.media.MediaCodecInfo$CodecProfileLevel[] r10 = new android.media.MediaCodecInfo.CodecProfileLevel[r3]
        L_0x0211:
            int r13 = r10.length
            r14 = 0
        L_0x0213:
            if (r14 >= r13) goto L_0x0235
            r15 = r10[r14]
            int r2 = r15.profile
            java.lang.Object r3 = r12.first
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r2 != r3) goto L_0x0230
            int r2 = r15.level
            java.lang.Object r3 = r12.second
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r2 < r3) goto L_0x0230
            goto L_0x024e
        L_0x0230:
            int r14 = r14 + 1
            r2 = 1
            r3 = 0
            goto L_0x0213
        L_0x0235:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "codec.profileLevel, "
            r2.<init>(r3)
            r2.append(r4)
            r2.append(r11)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            r1.a((java.lang.String) r2)
            r3 = 0
            goto L_0x024f
        L_0x024e:
            r3 = 1
        L_0x024f:
            if (r3 == 0) goto L_0x02a3
            int r2 = r0.j
            if (r2 <= 0) goto L_0x02a3
            int r4 = r0.k
            if (r4 <= 0) goto L_0x02a3
            int r3 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a
            r9 = 21
            if (r3 < r9) goto L_0x0267
            float r0 = r0.l
            double r9 = (double) r0
            boolean r3 = r1.a(r2, r4, r9)
            goto L_0x02a3
        L_0x0267:
            int r2 = r2 * r4
            int r3 = com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.a()
            if (r2 > r3) goto L_0x0271
            r2 = 1
            goto L_0x0272
        L_0x0271:
            r2 = 0
        L_0x0272:
            if (r2 != 0) goto L_0x02a2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "FalseCheck [legacyFrameSize, "
            r3.<init>(r4)
            int r4 = r0.j
            r3.append(r4)
            java.lang.String r4 = "x"
            r3.append(r4)
            int r0 = r0.k
            r3.append(r0)
            java.lang.String r0 = "] ["
            r3.append(r0)
            java.lang.String r0 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.e
            r3.append(r0)
            java.lang.String r0 = "]"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r3 = "MediaCodecVideoRenderer"
            android.util.Log.d(r3, r0)
        L_0x02a2:
            r3 = r2
        L_0x02a3:
            boolean r0 = r1.b
            if (r0 == 0) goto L_0x02a9
            r6 = 8
        L_0x02a9:
            boolean r0 = r1.c
            if (r0 == 0) goto L_0x02b0
            r16 = 16
            goto L_0x02b2
        L_0x02b0:
            r16 = 0
        L_0x02b2:
            if (r3 == 0) goto L_0x02b5
            goto L_0x02b6
        L_0x02b5:
            r7 = 2
        L_0x02b6:
            r0 = r6 | r16
            r0 = r0 | r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.video.MediaCodecVideoRenderer.a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c, com.fyber.inneractive.sdk.player.exoplayer2.i):int");
    }

    public void a(i[] iVarArr) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        this.a0 = iVarArr;
    }

    public boolean isReady() {
        if ((this.e0 || super.x()) && super.isReady()) {
            this.f0 = -9223372036854775807L;
            return true;
        } else if (this.f0 == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.f0) {
                return true;
            }
            this.f0 = -9223372036854775807L;
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.c0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean x() {
        /*
            r1 = this;
            boolean r0 = super.x()
            if (r0 == 0) goto L_0x0012
            android.view.Surface r0 = r1.c0
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.isValid()
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.video.MediaCodecVideoRenderer.x():boolean");
    }

    public final void z() {
        this.p0 = -1;
        this.q0 = -1;
        this.s0 = -1.0f;
        this.r0 = -1;
    }

    public final void B() {
        if (this.h0 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.W.droppedFrames(this.h0, elapsedRealtime - this.g0);
            this.h0 = 0;
            this.g0 = elapsedRealtime;
        }
    }

    public final void E() {
        int i = this.p0;
        if (i != -1 || this.q0 != -1) {
            this.W.videoSizeChanged(i, this.q0, this.r0, this.s0);
        }
    }

    public final void F() {
        this.f0 = this.X > 0 ? SystemClock.elapsedRealtime() + this.X : -9223372036854775807L;
    }

    public void q() {
        this.h0 = 0;
        this.g0 = SystemClock.elapsedRealtime();
    }

    public void r() {
        this.f0 = -9223372036854775807L;
        B();
    }

    public void C() {
        if (!this.e0) {
            this.e0 = true;
            this.W.renderedFirstFrame(this.c0);
        }
    }

    public final void D() {
        int i = this.l0;
        if (i != -1 || this.m0 != -1) {
            if (this.p0 != i || this.q0 != this.m0 || this.r0 != this.n0 || this.s0 != this.o0) {
                this.W.videoSizeChanged(i, this.m0, this.n0, this.o0);
                this.p0 = this.l0;
                this.q0 = this.m0;
                this.r0 = this.n0;
                this.s0 = this.o0;
            }
        }
    }

    public void p() {
        this.l0 = -1;
        this.m0 = -1;
        this.o0 = -1.0f;
        this.k0 = -1.0f;
        z();
        y();
        d dVar = this.V;
        dVar.getClass();
        dVar.a.b.sendEmptyMessage(2);
        this.v0 = null;
        try {
            super.p();
        } finally {
            this.T.ensureUpdated();
            this.W.disabled(this.T);
        }
    }

    public final void y() {
        MediaCodec mediaCodec;
        this.e0 = false;
        if (u.a >= 23 && this.t0 && (mediaCodec = this.r) != null) {
            this.v0 = new b(mediaCodec);
        }
    }

    public void a(long j, boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        super.a(j, z);
        y();
        this.i0 = 0;
        if (z) {
            F();
        } else {
            this.f0 = -9223372036854775807L;
        }
    }

    public void a(int i, Object obj) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (this.c0 != surface) {
                this.c0 = surface;
                int i2 = this.d;
                if (i2 == 1 || i2 == 2) {
                    MediaCodec mediaCodec = this.r;
                    if (u.a < 23 || mediaCodec == null || surface == null) {
                        v();
                        t();
                    } else {
                        mediaCodec.setOutputSurface(surface);
                    }
                }
                if (surface != null) {
                    E();
                    y();
                    if (i2 == 2) {
                        F();
                        return;
                    }
                    return;
                }
                z();
                y();
            } else if (surface != null) {
                E();
                if (this.e0) {
                    this.W.renderedFirstFrame(this.c0);
                }
            }
        } else if (i == 4) {
            int intValue = ((Integer) obj).intValue();
            this.d0 = intValue;
            MediaCodec mediaCodec2 = this.r;
            if (mediaCodec2 != null) {
                mediaCodec2.setVideoScalingMode(intValue);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0137, code lost:
        r14 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00ff A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0129 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a r23, android.media.MediaCodec r24, com.fyber.inneractive.sdk.player.exoplayer2.i r25, android.media.MediaCrypto r26) throws com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.b {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r4 = r0.a0
            int r5 = r3.j
            int r6 = r3.k
            int r7 = r3.g
            r8 = -1
            if (r7 == r8) goto L_0x0014
            goto L_0x001a
        L_0x0014:
            java.lang.String r7 = r3.f
            int r7 = a((java.lang.String) r7, (int) r5, (int) r6)
        L_0x001a:
            int r9 = r4.length
            r10 = 1
            if (r9 != r10) goto L_0x0025
            com.fyber.inneractive.sdk.player.exoplayer2.video.MediaCodecVideoRenderer$a r1 = new com.fyber.inneractive.sdk.player.exoplayer2.video.MediaCodecVideoRenderer$a
            r1.<init>(r5, r6, r7)
            goto L_0x016c
        L_0x0025:
            int r9 = r4.length
            r13 = 0
            r14 = 0
        L_0x0028:
            if (r13 >= r9) goto L_0x0062
            r15 = r4[r13]
            boolean r12 = r1.b
            boolean r12 = a((boolean) r12, (com.fyber.inneractive.sdk.player.exoplayer2.i) r3, (com.fyber.inneractive.sdk.player.exoplayer2.i) r15)
            if (r12 == 0) goto L_0x005e
            int r12 = r15.j
            if (r12 == r8) goto L_0x003f
            int r10 = r15.k
            if (r10 != r8) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r10 = 0
            goto L_0x0040
        L_0x003f:
            r10 = 1
        L_0x0040:
            r14 = r14 | r10
            int r5 = java.lang.Math.max(r5, r12)
            int r10 = r15.k
            int r6 = java.lang.Math.max(r6, r10)
            int r10 = r15.g
            if (r10 == r8) goto L_0x0050
            goto L_0x005a
        L_0x0050:
            java.lang.String r10 = r15.f
            int r12 = r15.j
            int r15 = r15.k
            int r10 = a((java.lang.String) r10, (int) r12, (int) r15)
        L_0x005a:
            int r7 = java.lang.Math.max(r7, r10)
        L_0x005e:
            int r13 = r13 + 1
            r10 = 1
            goto L_0x0028
        L_0x0062:
            if (r14 == 0) goto L_0x0167
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r9 = "Resolutions unknown. Codec max resolution: "
            r4.<init>(r9)
            r4.append(r5)
            java.lang.String r9 = "x"
            r4.append(r9)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.String r10 = "MediaCodecVideoRenderer"
            android.util.Log.w(r10, r4)
            int r4 = r3.k
            int r12 = r3.j
            if (r4 <= r12) goto L_0x0087
            r13 = 1
            goto L_0x0088
        L_0x0087:
            r13 = 0
        L_0x0088:
            if (r13 == 0) goto L_0x008c
            r14 = r4
            goto L_0x008d
        L_0x008c:
            r14 = r12
        L_0x008d:
            if (r13 == 0) goto L_0x0090
            r4 = r12
        L_0x0090:
            float r12 = (float) r4
            float r15 = (float) r14
            float r12 = r12 / r15
            int[] r15 = w0
            int r11 = r15.length
            r8 = 0
        L_0x0097:
            if (r8 >= r11) goto L_0x0137
            r16 = r11
            r11 = r15[r8]
            r17 = r15
            float r15 = (float) r11
            float r15 = r15 * r12
            int r15 = (int) r15
            if (r11 <= r14) goto L_0x0137
            if (r15 > r4) goto L_0x00a9
            goto L_0x0137
        L_0x00a9:
            r18 = r4
            int r4 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a
            r19 = r12
            r12 = 21
            if (r4 < r12) goto L_0x0102
            if (r13 == 0) goto L_0x00b7
            r4 = r15
            goto L_0x00b8
        L_0x00b7:
            r4 = r11
        L_0x00b8:
            if (r13 == 0) goto L_0x00bb
            goto L_0x00bc
        L_0x00bb:
            r11 = r15
        L_0x00bc:
            android.media.MediaCodecInfo$CodecCapabilities r12 = r1.e
            if (r12 != 0) goto L_0x00c9
            java.lang.String r4 = "align.caps"
            r1.a((java.lang.String) r4)
        L_0x00c5:
            r20 = r14
            r14 = 0
            goto L_0x00f0
        L_0x00c9:
            android.media.MediaCodecInfo$VideoCapabilities r12 = r12.getVideoCapabilities()
            if (r12 != 0) goto L_0x00d5
            java.lang.String r4 = "align.vCaps"
            r1.a((java.lang.String) r4)
            goto L_0x00c5
        L_0x00d5:
            int r15 = r12.getWidthAlignment()
            int r12 = r12.getHeightAlignment()
            r20 = r14
            android.graphics.Point r14 = new android.graphics.Point
            int r4 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((int) r4, (int) r15)
            int r4 = r4 * r15
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((int) r11, (int) r12)
            int r11 = r11 * r12
            r14.<init>(r4, r11)
        L_0x00f0:
            float r4 = r3.l
            int r11 = r14.x
            int r12 = r14.y
            r21 = r14
            double r14 = (double) r4
            boolean r4 = r1.a(r11, r12, r14)
            if (r4 == 0) goto L_0x0129
            r14 = r21
            goto L_0x0138
        L_0x0102:
            r20 = r14
            r4 = 16
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((int) r11, (int) r4)
            int r11 = r11 * 16
            int r12 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((int) r15, (int) r4)
            int r12 = r12 * 16
            int r4 = r11 * r12
            int r14 = com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.a()
            if (r4 > r14) goto L_0x0129
            android.graphics.Point r14 = new android.graphics.Point
            if (r13 == 0) goto L_0x0120
            r1 = r12
            goto L_0x0121
        L_0x0120:
            r1 = r11
        L_0x0121:
            if (r13 == 0) goto L_0x0124
            goto L_0x0125
        L_0x0124:
            r11 = r12
        L_0x0125:
            r14.<init>(r1, r11)
            goto L_0x0138
        L_0x0129:
            int r8 = r8 + 1
            r11 = r16
            r15 = r17
            r4 = r18
            r12 = r19
            r14 = r20
            goto L_0x0097
        L_0x0137:
            r14 = 0
        L_0x0138:
            if (r14 == 0) goto L_0x0167
            int r1 = r14.x
            int r5 = java.lang.Math.max(r5, r1)
            int r1 = r14.y
            int r6 = java.lang.Math.max(r6, r1)
            java.lang.String r1 = r3.f
            int r1 = a((java.lang.String) r1, (int) r5, (int) r6)
            int r7 = java.lang.Math.max(r7, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "Codec max resolution adjusted to: "
            r1.<init>(r4)
            r1.append(r5)
            r1.append(r9)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r10, r1)
        L_0x0167:
            com.fyber.inneractive.sdk.player.exoplayer2.video.MediaCodecVideoRenderer$a r1 = new com.fyber.inneractive.sdk.player.exoplayer2.video.MediaCodecVideoRenderer$a
            r1.<init>(r5, r6, r7)
        L_0x016c:
            r0.b0 = r1
            boolean r4 = r0.Z
            int r5 = r0.u0
            android.media.MediaFormat r3 = r25.a()
            int r6 = r1.a
            java.lang.String r7 = "max-width"
            r3.setInteger(r7, r6)
            int r6 = r1.b
            java.lang.String r7 = "max-height"
            r3.setInteger(r7, r6)
            int r1 = r1.c
            r6 = -1
            if (r1 == r6) goto L_0x018e
            java.lang.String r6 = "max-input-size"
            r3.setInteger(r6, r1)
        L_0x018e:
            if (r4 == 0) goto L_0x0197
            java.lang.String r1 = "auto-frc"
            r4 = 0
            r3.setInteger(r1, r4)
            goto L_0x0198
        L_0x0197:
            r4 = 0
        L_0x0198:
            if (r5 == 0) goto L_0x01a5
            java.lang.String r1 = "tunneled-playback"
            r6 = 1
            r3.setFeatureEnabled(r1, r6)
            java.lang.String r1 = "audio-session-id"
            r3.setInteger(r1, r5)
        L_0x01a5:
            android.view.Surface r1 = r0.c0
            r5 = 0
            r2.configure(r3, r1, r5, r4)
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a
            r3 = 23
            if (r1 < r3) goto L_0x01bc
            boolean r1 = r0.t0
            if (r1 == 0) goto L_0x01bc
            com.fyber.inneractive.sdk.player.exoplayer2.video.MediaCodecVideoRenderer$b r1 = new com.fyber.inneractive.sdk.player.exoplayer2.video.MediaCodecVideoRenderer$b
            r1.<init>(r2)
            r0.v0 = r1
        L_0x01bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.video.MediaCodecVideoRenderer.a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a, android.media.MediaCodec, com.fyber.inneractive.sdk.player.exoplayer2.i, android.media.MediaCrypto):void");
    }

    public void a(String str, long j, long j2) {
        this.W.decoderInitialized(str, j, j2);
    }

    public void a(i iVar) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        super.a(iVar);
        this.W.inputFormatChanged(iVar);
        float f = iVar.n;
        if (f == -1.0f) {
            f = 1.0f;
        }
        this.k0 = f;
        int i = iVar.m;
        if (i == -1) {
            i = 0;
        }
        this.j0 = i;
    }

    public void a(com.fyber.inneractive.sdk.player.exoplayer2.decoder.b bVar) {
        if (u.a < 23 && this.t0) {
            C();
        }
    }

    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int i2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        this.l0 = i;
        if (z) {
            i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        this.m0 = i2;
        float f = this.k0;
        this.o0 = f;
        if (u.a >= 21) {
            int i3 = this.j0;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.l0;
                this.l0 = i2;
                this.m0 = i4;
                this.o0 = 1.0f / f;
            }
        } else {
            this.n0 = this.j0;
        }
        mediaCodec.setVideoScalingMode(this.d0);
    }

    public void a(boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.T = decoderCounters;
        int i = this.b.a;
        this.u0 = i;
        this.t0 = i != 0;
        this.W.enabled(decoderCounters);
        d dVar = this.V;
        dVar.g = false;
        dVar.a.b.sendEmptyMessage(1);
    }

    public boolean a(MediaCodec mediaCodec, boolean z, i iVar, i iVar2) {
        if (a(z, iVar, iVar2)) {
            int i = iVar2.j;
            a aVar = this.b0;
            return i <= aVar.a && iVar2.k <= aVar.b && iVar2.g <= aVar.c;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0124  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(long r20, long r22, android.media.MediaCodec r24, java.nio.ByteBuffer r25, int r26, int r27, long r28, boolean r30) {
        /*
            r19 = this;
            r0 = r19
            r1 = r24
            r2 = r26
            r3 = r28
            r5 = 0
            r6 = 1
            if (r30 == 0) goto L_0x001f
            java.lang.String r3 = "skipVideoBuffer"
            com.fyber.inneractive.sdk.player.exoplayer2.util.s.a(r3)
            r1.releaseOutputBuffer(r2, r5)
            com.fyber.inneractive.sdk.player.exoplayer2.util.s.a()
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters r1 = r0.T
            int r2 = r1.skippedOutputBufferCount
            int r2 = r2 + r6
            r1.skippedOutputBufferCount = r2
            return r6
        L_0x001f:
            boolean r7 = r0.e0
            r8 = 21
            if (r7 != 0) goto L_0x0035
            int r3 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a
            if (r3 < r8) goto L_0x0031
            long r3 = java.lang.System.nanoTime()
            r0.a((android.media.MediaCodec) r1, (int) r2, (long) r3)
            goto L_0x0034
        L_0x0031:
            r0.a((android.media.MediaCodec) r1, (int) r2)
        L_0x0034:
            return r6
        L_0x0035:
            int r7 = r0.d
            r9 = 2
            if (r7 == r9) goto L_0x003b
            return r5
        L_0x003b:
            long r9 = android.os.SystemClock.elapsedRealtime()
            r11 = 1000(0x3e8, double:4.94E-321)
            long r9 = r9 * r11
            long r9 = r9 - r22
            long r13 = r3 - r20
            long r13 = r13 - r9
            long r9 = java.lang.System.nanoTime()
            long r13 = r13 * r11
            long r13 = r13 + r9
            com.fyber.inneractive.sdk.player.exoplayer2.video.d r7 = r0.V
            r20 = r9
            long r8 = r3 * r11
            boolean r10 = r7.g
            if (r10 == 0) goto L_0x009c
            long r11 = r7.d
            int r10 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r10 == 0) goto L_0x006a
            long r10 = r7.j
            r15 = 1
            long r10 = r10 + r15
            r7.j = r10
            long r10 = r7.f
            r7.e = r10
        L_0x006a:
            long r10 = r7.j
            r15 = 6
            int r12 = (r10 > r15 ? 1 : (r10 == r15 ? 0 : -1))
            if (r12 < 0) goto L_0x0091
            long r5 = r7.i
            long r5 = r8 - r5
            long r5 = r5 / r10
            long r10 = r7.e
            long r10 = r10 + r5
            boolean r5 = r7.a(r10, r13)
            if (r5 == 0) goto L_0x0084
            r5 = 0
            r7.g = r5
            goto L_0x009c
        L_0x0084:
            long r5 = r7.h
            long r5 = r5 + r10
            r22 = r13
            long r12 = r7.i
            long r5 = r5 - r12
            r13 = r10
            r10 = r5
            r5 = r22
            goto L_0x009f
        L_0x0091:
            r5 = r13
            boolean r10 = r7.a(r8, r5)
            if (r10 == 0) goto L_0x009d
            r10 = 0
            r7.g = r10
            goto L_0x009d
        L_0x009c:
            r5 = r13
        L_0x009d:
            r10 = r5
            r13 = r8
        L_0x009f:
            boolean r12 = r7.g
            r0 = 0
            if (r12 != 0) goto L_0x00ae
            r7.i = r8
            r7.h = r5
            r7.j = r0
            r5 = 1
            r7.g = r5
        L_0x00ae:
            r7.d = r3
            r7.f = r13
            com.fyber.inneractive.sdk.player.exoplayer2.video.d$a r3 = r7.a
            if (r3 == 0) goto L_0x00e3
            long r3 = r3.a
            int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x00bd
            goto L_0x00e3
        L_0x00bd:
            com.fyber.inneractive.sdk.player.exoplayer2.video.d$a r0 = r7.a
            long r0 = r0.a
            long r3 = r7.b
            long r5 = r10 - r0
            long r5 = r5 / r3
            long r5 = r5 * r3
            long r0 = r0 + r5
            int r5 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r5 > 0) goto L_0x00d0
            long r3 = r0 - r3
            goto L_0x00d6
        L_0x00d0:
            long r3 = r3 + r0
            r17 = r0
            r0 = r3
            r3 = r17
        L_0x00d6:
            long r5 = r0 - r10
            long r10 = r10 - r3
            int r8 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r8 >= 0) goto L_0x00de
            goto L_0x00df
        L_0x00de:
            r0 = r3
        L_0x00df:
            long r3 = r7.c
            long r10 = r0 - r3
        L_0x00e3:
            r0 = r20
            long r0 = r10 - r0
            r3 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r3
            r3 = -30000(0xffffffffffff8ad0, double:NaN)
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0124
            java.lang.String r0 = "dropVideoBuffer"
            com.fyber.inneractive.sdk.player.exoplayer2.util.s.a(r0)
            r3 = r24
            r0 = 0
            r3.releaseOutputBuffer(r2, r0)
            com.fyber.inneractive.sdk.player.exoplayer2.util.s.a()
            r4 = r19
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters r0 = r4.T
            int r1 = r0.droppedOutputBufferCount
            r5 = 1
            int r1 = r1 + r5
            r0.droppedOutputBufferCount = r1
            int r1 = r4.h0
            int r1 = r1 + r5
            r4.h0 = r1
            int r1 = r4.i0
            int r1 = r1 + r5
            r4.i0 = r1
            int r2 = r0.maxConsecutiveDroppedOutputBufferCount
            int r1 = java.lang.Math.max(r1, r2)
            r0.maxConsecutiveDroppedOutputBufferCount = r1
            int r0 = r4.h0
            int r1 = r4.Y
            if (r0 != r1) goto L_0x0123
            r19.B()
        L_0x0123:
            return r5
        L_0x0124:
            r4 = r19
            r3 = r24
            r5 = 1
            int r6 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a
            r7 = 21
            if (r6 < r7) goto L_0x013a
            r6 = 50000(0xc350, double:2.47033E-319)
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x015c
            r4.a((android.media.MediaCodec) r3, (int) r2, (long) r10)
            return r5
        L_0x013a:
            r5 = 30000(0x7530, double:1.4822E-319)
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x015c
            r5 = 11000(0x2af8, double:5.4347E-320)
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0157
            r5 = 10000(0x2710, double:4.9407E-320)
            long r0 = r0 - r5
            r5 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r5
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0150 }
            goto L_0x0157
        L_0x0150:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0157:
            r4.a((android.media.MediaCodec) r3, (int) r2)
            r0 = 1
            return r0
        L_0x015c:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.video.MediaCodecVideoRenderer.a(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean):boolean");
    }

    public final void a(MediaCodec mediaCodec, int i) {
        D();
        s.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        s.a();
        this.T.renderedOutputBufferCount++;
        this.i0 = 0;
        C();
    }

    public final void a(MediaCodec mediaCodec, int i, long j) {
        D();
        s.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        s.a();
        this.T.renderedOutputBufferCount++;
        this.i0 = 0;
        C();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.String r5, int r6, int r7) {
        /*
            r0 = -1
            if (r6 == r0) goto L_0x0084
            if (r7 != r0) goto L_0x0007
            goto L_0x0084
        L_0x0007:
            r5.getClass()
            r5.hashCode()
            int r1 = r5.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            switch(r1) {
                case -1664118616: goto L_0x0050;
                case -1662541442: goto L_0x0045;
                case 1187890754: goto L_0x003a;
                case 1331836730: goto L_0x002f;
                case 1599127256: goto L_0x0024;
                case 1599127257: goto L_0x0019;
                default: goto L_0x0017;
            }
        L_0x0017:
            r5 = -1
            goto L_0x005a
        L_0x0019:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0022
            goto L_0x0017
        L_0x0022:
            r5 = 5
            goto L_0x005a
        L_0x0024:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x002d
            goto L_0x0017
        L_0x002d:
            r5 = 4
            goto L_0x005a
        L_0x002f:
            java.lang.String r1 = "video/avc"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0038
            goto L_0x0017
        L_0x0038:
            r5 = 3
            goto L_0x005a
        L_0x003a:
            java.lang.String r1 = "video/mp4v-es"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0043
            goto L_0x0017
        L_0x0043:
            r5 = 2
            goto L_0x005a
        L_0x0045:
            java.lang.String r1 = "video/hevc"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x004e
            goto L_0x0017
        L_0x004e:
            r5 = 1
            goto L_0x005a
        L_0x0050:
            java.lang.String r1 = "video/3gpp"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0059
            goto L_0x0017
        L_0x0059:
            r5 = 0
        L_0x005a:
            switch(r5) {
                case 0: goto L_0x007b;
                case 1: goto L_0x0078;
                case 2: goto L_0x007b;
                case 3: goto L_0x005e;
                case 4: goto L_0x007b;
                case 5: goto L_0x0078;
                default: goto L_0x005d;
            }
        L_0x005d:
            return r0
        L_0x005e:
            java.lang.String r5 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.d
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0069
            return r0
        L_0x0069:
            r5 = 16
            int r6 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((int) r6, (int) r5)
            int r5 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((int) r7, (int) r5)
            int r6 = r6 * r5
            int r6 = r6 * 256
            goto L_0x007d
        L_0x0078:
            int r6 = r6 * r7
            goto L_0x007e
        L_0x007b:
            int r6 = r6 * r7
        L_0x007d:
            r2 = 2
        L_0x007e:
            int r6 = r6 * 3
            int r2 = r2 * 2
            int r6 = r6 / r2
            return r6
        L_0x0084:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.video.MediaCodecVideoRenderer.a(java.lang.String, int, int):int");
    }

    public static boolean a(boolean z, i iVar, i iVar2) {
        if (!iVar.f.equals(iVar2.f)) {
            return false;
        }
        int i = iVar.m;
        if (i == -1) {
            i = 0;
        }
        int i2 = iVar2.m;
        if (i2 == -1) {
            i2 = 0;
        }
        if (i != i2) {
            return false;
        }
        if (z || (iVar.j == iVar2.j && iVar.k == iVar2.k)) {
            return true;
        }
        return false;
    }
}
