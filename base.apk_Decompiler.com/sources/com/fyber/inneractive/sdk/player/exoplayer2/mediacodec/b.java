package com.fyber.inneractive.sdk.player.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;
import com.fyber.inneractive.sdk.player.exoplayer2.drm.c;
import com.fyber.inneractive.sdk.player.exoplayer2.drm.d;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.j;
import com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d;
import com.fyber.inneractive.sdk.player.exoplayer2.util.s;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public abstract class b extends com.fyber.inneractive.sdk.player.exoplayer2.a {
    public static final byte[] U;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public ByteBuffer[] E;
    public ByteBuffer[] F;
    public long G;
    public int H;
    public int I;
    public boolean J;
    public boolean K;
    public int L;
    public int M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public DecoderCounters T;
    public final c i;
    public final c<d> j;
    public final boolean k;
    public final com.fyber.inneractive.sdk.player.exoplayer2.decoder.b l;
    public final com.fyber.inneractive.sdk.player.exoplayer2.decoder.b m;
    public final j n;
    public final List<Long> o;
    public final MediaCodec.BufferInfo p;
    public i q;
    public MediaCodec r;
    public com.fyber.inneractive.sdk.player.exoplayer2.drm.b<d> s;
    public com.fyber.inneractive.sdk.player.exoplayer2.drm.b<d> t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    static {
        int i2 = u.a;
        byte[] bArr = new byte[38];
        for (int i3 = 0; i3 < 38; i3++) {
            int i4 = i3 * 2;
            bArr[i3] = (byte) ((Character.digit("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78".charAt(i4), 16) << 4) + Character.digit("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78".charAt(i4 + 1), 16));
        }
        U = bArr;
    }

    public b(int i2, c cVar, c<d> cVar2, boolean z2) {
        super(i2);
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(u.a >= 16);
        this.i = (c) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(cVar);
        this.j = cVar2;
        this.k = z2;
        this.l = new com.fyber.inneractive.sdk.player.exoplayer2.decoder.b(0);
        this.m = com.fyber.inneractive.sdk.player.exoplayer2.decoder.b.b();
        this.n = new j();
        this.o = new ArrayList();
        this.p = new MediaCodec.BufferInfo();
        this.L = 0;
        this.M = 0;
    }

    public abstract int a(c cVar, i iVar) throws d.b;

    public a a(c cVar, i iVar, boolean z2) throws d.b {
        return cVar.a(iVar.f, z2);
    }

    public abstract void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws com.fyber.inneractive.sdk.player.exoplayer2.d;

    public void a(com.fyber.inneractive.sdk.player.exoplayer2.decoder.b bVar) {
    }

    public abstract void a(a aVar, MediaCodec mediaCodec, i iVar, MediaCrypto mediaCrypto) throws d.b;

    public abstract void a(String str, long j2, long j3);

    public abstract boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z2) throws com.fyber.inneractive.sdk.player.exoplayer2.d;

    public boolean a(MediaCodec mediaCodec, boolean z2, i iVar, i iVar2) {
        return false;
    }

    public boolean b() {
        return this.Q;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0165  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        /*
            r14 = this;
            java.lang.String r0 = "createCodec:"
            java.lang.String r1 = "Drm session requires secure decoder for "
            boolean r2 = r14.x()
            if (r2 != 0) goto L_0x000b
            return
        L_0x000b:
            com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> r2 = r14.t
            r14.s = r2
            com.fyber.inneractive.sdk.player.exoplayer2.i r3 = r14.q
            java.lang.String r3 = r3.f
            r4 = 0
            r5 = 0
            if (r2 == 0) goto L_0x0041
            int r2 = r2.a()
            if (r2 == 0) goto L_0x0035
            r6 = 3
            if (r2 == r6) goto L_0x0025
            r6 = 4
            if (r2 != r6) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            return
        L_0x0025:
            com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> r2 = r14.s
            com.fyber.inneractive.sdk.player.exoplayer2.drm.d r2 = r2.b()
            r2.getClass()
            com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> r2 = r14.s
            boolean r2 = r2.a(r3)
            goto L_0x0042
        L_0x0035:
            com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> r0 = r14.s
            r0.c()
            int r0 = r14.c
            com.fyber.inneractive.sdk.player.exoplayer2.d r0 = com.fyber.inneractive.sdk.player.exoplayer2.d.a(r4, r0)
            throw r0
        L_0x0041:
            r2 = 0
        L_0x0042:
            com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c r6 = r14.i     // Catch:{ b -> 0x0211 }
            com.fyber.inneractive.sdk.player.exoplayer2.i r7 = r14.q     // Catch:{ b -> 0x0211 }
            com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a r6 = r14.a((com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c) r6, (com.fyber.inneractive.sdk.player.exoplayer2.i) r7, (boolean) r2)     // Catch:{ b -> 0x0211 }
            if (r6 != 0) goto L_0x0078
            if (r2 == 0) goto L_0x0078
            com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c r6 = r14.i     // Catch:{ b -> 0x0211 }
            com.fyber.inneractive.sdk.player.exoplayer2.i r7 = r14.q     // Catch:{ b -> 0x0211 }
            com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a r6 = r14.a((com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c) r6, (com.fyber.inneractive.sdk.player.exoplayer2.i) r7, (boolean) r5)     // Catch:{ b -> 0x0211 }
            if (r6 == 0) goto L_0x0078
            java.lang.String r7 = "MediaCodecRenderer"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ b -> 0x0211 }
            r8.<init>(r1)     // Catch:{ b -> 0x0211 }
            r8.append(r3)     // Catch:{ b -> 0x0211 }
            java.lang.String r1 = ", but no secure decoder available. Trying to proceed with "
            r8.append(r1)     // Catch:{ b -> 0x0211 }
            java.lang.String r1 = r6.a     // Catch:{ b -> 0x0211 }
            r8.append(r1)     // Catch:{ b -> 0x0211 }
            java.lang.String r1 = "."
            r8.append(r1)     // Catch:{ b -> 0x0211 }
            java.lang.String r1 = r8.toString()     // Catch:{ b -> 0x0211 }
            android.util.Log.w(r7, r1)     // Catch:{ b -> 0x0211 }
        L_0x0078:
            if (r6 == 0) goto L_0x0200
            java.lang.String r1 = r6.a
            boolean r3 = r6.b
            r14.u = r3
            com.fyber.inneractive.sdk.player.exoplayer2.i r3 = r14.q
            int r7 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a
            r8 = 21
            r13 = 1
            if (r7 >= r8) goto L_0x009b
            java.util.List<byte[]> r3 = r3.h
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x009b
            java.lang.String r3 = "OMX.MTK.VIDEO.DECODER.AVC"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x009b
            r3 = 1
            goto L_0x009c
        L_0x009b:
            r3 = 0
        L_0x009c:
            r14.v = r3
            r3 = 19
            r9 = 18
            if (r7 < r9) goto L_0x00d5
            if (r7 != r9) goto L_0x00b6
            java.lang.String r10 = "OMX.SEC.avc.dec"
            boolean r10 = r10.equals(r1)
            if (r10 != 0) goto L_0x00d5
            java.lang.String r10 = "OMX.SEC.avc.dec.secure"
            boolean r10 = r10.equals(r1)
            if (r10 != 0) goto L_0x00d5
        L_0x00b6:
            if (r7 != r3) goto L_0x00d3
            java.lang.String r10 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.d
            java.lang.String r11 = "SM-G800"
            boolean r10 = r10.startsWith(r11)
            if (r10 == 0) goto L_0x00d3
            java.lang.String r10 = "OMX.Exynos.avc.dec"
            boolean r10 = r10.equals(r1)
            if (r10 != 0) goto L_0x00d5
            java.lang.String r10 = "OMX.Exynos.avc.dec.secure"
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x00d3
            goto L_0x00d5
        L_0x00d3:
            r10 = 0
            goto L_0x00d6
        L_0x00d5:
            r10 = 1
        L_0x00d6:
            r14.w = r10
            r10 = 24
            if (r7 >= r10) goto L_0x0110
            java.lang.String r10 = "OMX.Nvidia.h264.decode"
            boolean r10 = r10.equals(r1)
            if (r10 != 0) goto L_0x00ec
            java.lang.String r10 = "OMX.Nvidia.h264.decode.secure"
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x0110
        L_0x00ec:
            java.lang.String r10 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.b
            java.lang.String r11 = "flounder"
            boolean r11 = r11.equals(r10)
            if (r11 != 0) goto L_0x010e
            java.lang.String r11 = "flounder_lte"
            boolean r11 = r11.equals(r10)
            if (r11 != 0) goto L_0x010e
            java.lang.String r11 = "grouper"
            boolean r11 = r11.equals(r10)
            if (r11 != 0) goto L_0x010e
            java.lang.String r11 = "tilapia"
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x0110
        L_0x010e:
            r10 = 1
            goto L_0x0111
        L_0x0110:
            r10 = 0
        L_0x0111:
            r14.x = r10
            r10 = 17
            if (r7 > r10) goto L_0x0129
            java.lang.String r10 = "OMX.rk.video_decoder.avc"
            boolean r10 = r10.equals(r1)
            if (r10 != 0) goto L_0x0127
            java.lang.String r10 = "OMX.allwinner.video.decoder.avc"
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x0129
        L_0x0127:
            r10 = 1
            goto L_0x012a
        L_0x0129:
            r10 = 0
        L_0x012a:
            r14.y = r10
            r10 = 23
            if (r7 > r10) goto L_0x0138
            java.lang.String r10 = "OMX.google.vorbis.decoder"
            boolean r10 = r10.equals(r1)
            if (r10 != 0) goto L_0x0154
        L_0x0138:
            if (r7 > r3) goto L_0x0156
            java.lang.String r3 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.b
            java.lang.String r10 = "hb2000"
            boolean r3 = r10.equals(r3)
            if (r3 == 0) goto L_0x0156
            java.lang.String r3 = "OMX.amlogic.avc.decoder.awesome"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0154
            java.lang.String r3 = "OMX.amlogic.avc.decoder.awesome.secure"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0156
        L_0x0154:
            r3 = 1
            goto L_0x0157
        L_0x0156:
            r3 = 0
        L_0x0157:
            r14.z = r3
            if (r7 != r8) goto L_0x0165
            java.lang.String r3 = "OMX.google.aac.decoder"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0165
            r3 = 1
            goto L_0x0166
        L_0x0165:
            r3 = 0
        L_0x0166:
            r14.A = r3
            com.fyber.inneractive.sdk.player.exoplayer2.i r3 = r14.q
            if (r7 > r9) goto L_0x0179
            int r3 = r3.r
            if (r3 != r13) goto L_0x0179
            java.lang.String r3 = "OMX.MTK.AUDIO.DECODER.MP3"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0179
            r5 = 1
        L_0x0179:
            r14.B = r5
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x01f1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f1 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x01f1 }
            r3.append(r1)     // Catch:{ Exception -> 0x01f1 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x01f1 }
            com.fyber.inneractive.sdk.player.exoplayer2.util.s.a(r0)     // Catch:{ Exception -> 0x01f1 }
            android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r1)     // Catch:{ Exception -> 0x01f1 }
            r14.r = r0     // Catch:{ Exception -> 0x01f1 }
            com.fyber.inneractive.sdk.player.exoplayer2.util.s.a()     // Catch:{ Exception -> 0x01f1 }
            java.lang.String r0 = "configureCodec"
            com.fyber.inneractive.sdk.player.exoplayer2.util.s.a(r0)     // Catch:{ Exception -> 0x01f1 }
            android.media.MediaCodec r0 = r14.r     // Catch:{ Exception -> 0x01f1 }
            com.fyber.inneractive.sdk.player.exoplayer2.i r3 = r14.q     // Catch:{ Exception -> 0x01f1 }
            r14.a((com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a) r6, (android.media.MediaCodec) r0, (com.fyber.inneractive.sdk.player.exoplayer2.i) r3, (android.media.MediaCrypto) r4)     // Catch:{ Exception -> 0x01f1 }
            com.fyber.inneractive.sdk.player.exoplayer2.util.s.a()     // Catch:{ Exception -> 0x01f1 }
            java.lang.String r0 = "startCodec"
            com.fyber.inneractive.sdk.player.exoplayer2.util.s.a(r0)     // Catch:{ Exception -> 0x01f1 }
            android.media.MediaCodec r0 = r14.r     // Catch:{ Exception -> 0x01f1 }
            r0.start()     // Catch:{ Exception -> 0x01f1 }
            com.fyber.inneractive.sdk.player.exoplayer2.util.s.a()     // Catch:{ Exception -> 0x01f1 }
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x01f1 }
            long r11 = r9 - r7
            r7 = r14
            r8 = r1
            r7.a((java.lang.String) r8, (long) r9, (long) r11)     // Catch:{ Exception -> 0x01f1 }
            android.media.MediaCodec r0 = r14.r     // Catch:{ Exception -> 0x01f1 }
            java.nio.ByteBuffer[] r0 = r0.getInputBuffers()     // Catch:{ Exception -> 0x01f1 }
            r14.E = r0     // Catch:{ Exception -> 0x01f1 }
            android.media.MediaCodec r0 = r14.r     // Catch:{ Exception -> 0x01f1 }
            java.nio.ByteBuffer[] r0 = r0.getOutputBuffers()     // Catch:{ Exception -> 0x01f1 }
            r14.F = r0     // Catch:{ Exception -> 0x01f1 }
            int r0 = r14.d
            r1 = 2
            if (r0 != r1) goto L_0x01db
            long r0 = android.os.SystemClock.elapsedRealtime()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 + r2
            goto L_0x01e0
        L_0x01db:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x01e0:
            r14.G = r0
            r0 = -1
            r14.H = r0
            r14.I = r0
            r14.S = r13
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters r0 = r14.T
            int r1 = r0.decoderInitCount
            int r1 = r1 + r13
            r0.decoderInitCount = r1
            return
        L_0x01f1:
            r0 = move-exception
            com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b$a r3 = new com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b$a
            com.fyber.inneractive.sdk.player.exoplayer2.i r4 = r14.q
            r3.<init>((com.fyber.inneractive.sdk.player.exoplayer2.i) r4, (java.lang.Throwable) r0, (boolean) r2, (java.lang.String) r1)
            int r0 = r14.c
            com.fyber.inneractive.sdk.player.exoplayer2.d r0 = com.fyber.inneractive.sdk.player.exoplayer2.d.a(r3, r0)
            throw r0
        L_0x0200:
            com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b$a r0 = new com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b$a
            com.fyber.inneractive.sdk.player.exoplayer2.i r1 = r14.q
            r3 = -49999(0xffffffffffff3cb1, float:NaN)
            r0.<init>((com.fyber.inneractive.sdk.player.exoplayer2.i) r1, (java.lang.Throwable) r4, (boolean) r2, (int) r3)
            int r1 = r14.c
            com.fyber.inneractive.sdk.player.exoplayer2.d r0 = com.fyber.inneractive.sdk.player.exoplayer2.d.a(r0, r1)
            throw r0
        L_0x0211:
            r0 = move-exception
            com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b$a r1 = new com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b$a
            com.fyber.inneractive.sdk.player.exoplayer2.i r3 = r14.q
            r4 = -49998(0xffffffffffff3cb2, float:NaN)
            r1.<init>((com.fyber.inneractive.sdk.player.exoplayer2.i) r3, (java.lang.Throwable) r0, (boolean) r2, (int) r4)
            int r0 = r14.c
            com.fyber.inneractive.sdk.player.exoplayer2.d r0 = com.fyber.inneractive.sdk.player.exoplayer2.d.a(r1, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b.t():void");
    }

    public void w() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
    }

    public boolean x() {
        return this.r == null && this.q != null;
    }

    public boolean isReady() {
        if (this.q != null && !this.R) {
            if ((this.g ? this.h : this.e.isReady()) || this.I >= 0 || (this.G != -9223372036854775807L && SystemClock.elapsedRealtime() < this.G)) {
                return true;
            }
        }
        return false;
    }

    public static class a extends Exception {
        public a(i iVar, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + iVar, th);
            String str = iVar.f;
            a(i);
        }

        public static String a(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        public static String a(int i) {
            String str = i < 0 ? "neg_" : "";
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + str + Math.abs(i);
        }

        public a(i iVar, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + iVar, th);
            String str2 = iVar.f;
            if (u.a >= 21) {
                a(th);
            }
        }
    }

    public void p() {
        this.q = null;
        try {
            v();
            try {
                com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar = this.s;
                if (bVar != null) {
                    this.j.a(bVar);
                }
                try {
                    com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar2 = this.t;
                    if (!(bVar2 == null || bVar2 == this.s)) {
                        this.j.a(bVar2);
                    }
                } finally {
                    this.s = null;
                    this.t = null;
                }
            } catch (Throwable th) {
                com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar3 = this.t;
                if (!(bVar3 == null || bVar3 == this.s)) {
                    this.j.a(bVar3);
                }
                throw th;
            } finally {
                this.s = null;
                this.t = null;
            }
        } catch (Throwable th2) {
            try {
                com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar4 = this.t;
                if (!(bVar4 == null || bVar4 == this.s)) {
                    this.j.a(bVar4);
                }
                throw th2;
            } finally {
                this.s = null;
                this.t = null;
            }
        } finally {
        }
    }

    public final void u() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        if (this.M == 2) {
            v();
            t();
            return;
        }
        this.Q = true;
        w();
    }

    public void v() {
        if (this.r != null) {
            this.G = -9223372036854775807L;
            this.H = -1;
            this.I = -1;
            this.R = false;
            this.J = false;
            this.o.clear();
            this.E = null;
            this.F = null;
            this.K = false;
            this.N = false;
            this.u = false;
            this.v = false;
            this.w = false;
            this.x = false;
            this.y = false;
            this.z = false;
            this.B = false;
            this.C = false;
            this.D = false;
            this.O = false;
            this.L = 0;
            this.M = 0;
            this.T.decoderReleaseCount++;
            this.l.c = null;
            try {
                this.r.stop();
                try {
                    this.r.release();
                    this.r = null;
                    com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar = this.s;
                    if (bVar != null && this.t != bVar) {
                        try {
                            this.j.a(bVar);
                        } finally {
                            this.s = null;
                        }
                    }
                } catch (Throwable th) {
                    this.r = null;
                    com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar2 = this.s;
                    if (!(bVar2 == null || this.t == bVar2)) {
                        this.j.a(bVar2);
                    }
                    throw th;
                } finally {
                    this.s = null;
                }
            } catch (Throwable th2) {
                this.r = null;
                com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar3 = this.s;
                if (!(bVar3 == null || this.t == bVar3)) {
                    try {
                        this.j.a(bVar3);
                    } finally {
                        this.s = null;
                    }
                }
                throw th2;
            } finally {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x0139 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean s() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        /*
            r15 = this;
            android.media.MediaCodec r0 = r15.r
            r1 = 0
            if (r0 == 0) goto L_0x0208
            int r2 = r15.M
            r3 = 2
            if (r2 == r3) goto L_0x0208
            boolean r2 = r15.P
            if (r2 == 0) goto L_0x0010
            goto L_0x0208
        L_0x0010:
            int r2 = r15.H
            if (r2 >= 0) goto L_0x002a
            r4 = 0
            int r0 = r0.dequeueInputBuffer(r4)
            r15.H = r0
            if (r0 >= 0) goto L_0x001f
            return r1
        L_0x001f:
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r2 = r15.l
            java.nio.ByteBuffer[] r4 = r15.E
            r0 = r4[r0]
            r2.c = r0
            r2.a()
        L_0x002a:
            int r0 = r15.M
            r2 = -1
            r4 = 1
            if (r0 != r4) goto L_0x0048
            boolean r0 = r15.y
            if (r0 == 0) goto L_0x0035
            goto L_0x0045
        L_0x0035:
            r15.O = r4
            android.media.MediaCodec r5 = r15.r
            int r6 = r15.H
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r15.H = r2
        L_0x0045:
            r15.M = r3
            return r1
        L_0x0048:
            boolean r0 = r15.C
            if (r0 == 0) goto L_0x0068
            r15.C = r1
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r0 = r15.l
            java.nio.ByteBuffer r0 = r0.c
            byte[] r1 = U
            r0.put(r1)
            android.media.MediaCodec r5 = r15.r
            int r6 = r15.H
            int r8 = r1.length
            r7 = 0
            r9 = 0
            r11 = 0
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r15.H = r2
            r15.N = r4
            return r4
        L_0x0068:
            boolean r0 = r15.R
            if (r0 == 0) goto L_0x006f
            r0 = -4
            r5 = 0
            goto L_0x00a7
        L_0x006f:
            int r0 = r15.L
            if (r0 != r4) goto L_0x0094
            r0 = 0
        L_0x0074:
            com.fyber.inneractive.sdk.player.exoplayer2.i r5 = r15.q
            java.util.List<byte[]> r5 = r5.h
            int r5 = r5.size()
            if (r0 >= r5) goto L_0x0092
            com.fyber.inneractive.sdk.player.exoplayer2.i r5 = r15.q
            java.util.List<byte[]> r5 = r5.h
            java.lang.Object r5 = r5.get(r0)
            byte[] r5 = (byte[]) r5
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r6 = r15.l
            java.nio.ByteBuffer r6 = r6.c
            r6.put(r5)
            int r0 = r0 + 1
            goto L_0x0074
        L_0x0092:
            r15.L = r3
        L_0x0094:
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r0 = r15.l
            java.nio.ByteBuffer r0 = r0.c
            int r0 = r0.position()
            com.fyber.inneractive.sdk.player.exoplayer2.j r5 = r15.n
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r6 = r15.l
            int r5 = r15.a((com.fyber.inneractive.sdk.player.exoplayer2.j) r5, (com.fyber.inneractive.sdk.player.exoplayer2.decoder.b) r6, (boolean) r1)
            r14 = r5
            r5 = r0
            r0 = r14
        L_0x00a7:
            r6 = -3
            if (r0 != r6) goto L_0x00ab
            return r1
        L_0x00ab:
            r6 = -5
            if (r0 != r6) goto L_0x00c1
            int r0 = r15.L
            if (r0 != r3) goto L_0x00b9
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r0 = r15.l
            r0.a()
            r15.L = r4
        L_0x00b9:
            com.fyber.inneractive.sdk.player.exoplayer2.j r0 = r15.n
            com.fyber.inneractive.sdk.player.exoplayer2.i r0 = r0.a
            r15.a((com.fyber.inneractive.sdk.player.exoplayer2.i) r0)
            return r4
        L_0x00c1:
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r0 = r15.l
            r6 = 4
            boolean r0 = r0.b(r6)
            if (r0 == 0) goto L_0x00fd
            int r0 = r15.L
            if (r0 != r3) goto L_0x00d5
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r0 = r15.l
            r0.a()
            r15.L = r4
        L_0x00d5:
            r15.P = r4
            boolean r0 = r15.N
            if (r0 != 0) goto L_0x00df
            r15.u()
            return r1
        L_0x00df:
            boolean r0 = r15.y     // Catch:{ CryptoException -> 0x00f5 }
            if (r0 == 0) goto L_0x00e4
            goto L_0x00f4
        L_0x00e4:
            r15.O = r4     // Catch:{ CryptoException -> 0x00f5 }
            android.media.MediaCodec r5 = r15.r     // Catch:{ CryptoException -> 0x00f5 }
            int r6 = r15.H     // Catch:{ CryptoException -> 0x00f5 }
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)     // Catch:{ CryptoException -> 0x00f5 }
            r15.H = r2     // Catch:{ CryptoException -> 0x00f5 }
        L_0x00f4:
            return r1
        L_0x00f5:
            r0 = move-exception
            int r1 = r15.c
            com.fyber.inneractive.sdk.player.exoplayer2.d r0 = com.fyber.inneractive.sdk.player.exoplayer2.d.a(r0, r1)
            throw r0
        L_0x00fd:
            boolean r0 = r15.S
            if (r0 == 0) goto L_0x0115
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r0 = r15.l
            boolean r0 = r0.b(r4)
            if (r0 != 0) goto L_0x0115
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r0 = r15.l
            r0.a()
            int r0 = r15.L
            if (r0 != r3) goto L_0x0114
            r15.L = r4
        L_0x0114:
            return r4
        L_0x0115:
            r15.S = r1
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r0 = r15.l
            r3 = 1073741824(0x40000000, float:2.0)
            boolean r0 = r0.b(r3)
            com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> r3 = r15.s
            if (r3 != 0) goto L_0x0124
            goto L_0x0134
        L_0x0124:
            int r3 = r3.a()
            if (r3 == 0) goto L_0x01fb
            if (r3 == r6) goto L_0x0134
            if (r0 != 0) goto L_0x0132
            boolean r3 = r15.k
            if (r3 != 0) goto L_0x0134
        L_0x0132:
            r3 = 1
            goto L_0x0135
        L_0x0134:
            r3 = 0
        L_0x0135:
            r15.R = r3
            if (r3 == 0) goto L_0x013a
            return r1
        L_0x013a:
            boolean r3 = r15.v
            if (r3 == 0) goto L_0x018f
            if (r0 != 0) goto L_0x018f
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r3 = r15.l
            java.nio.ByteBuffer r3 = r3.c
            byte[] r6 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a
            int r6 = r3.position()
            r7 = 0
            r8 = 0
        L_0x014c:
            int r9 = r7 + 1
            if (r9 >= r6) goto L_0x017f
            byte r10 = r3.get(r7)
            r10 = r10 & 255(0xff, float:3.57E-43)
            r11 = 3
            if (r8 != r11) goto L_0x0176
            if (r10 != r4) goto L_0x017a
            byte r12 = r3.get(r9)
            r12 = r12 & 31
            r13 = 7
            if (r12 != r13) goto L_0x017a
            java.nio.ByteBuffer r8 = r3.duplicate()
            int r7 = r7 - r11
            r8.position(r7)
            r8.limit(r6)
            r3.position(r1)
            r3.put(r8)
            goto L_0x0182
        L_0x0176:
            if (r10 != 0) goto L_0x017a
            int r8 = r8 + 1
        L_0x017a:
            if (r10 == 0) goto L_0x017d
            r8 = 0
        L_0x017d:
            r7 = r9
            goto L_0x014c
        L_0x017f:
            r3.clear()
        L_0x0182:
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r3 = r15.l
            java.nio.ByteBuffer r3 = r3.c
            int r3 = r3.position()
            if (r3 != 0) goto L_0x018d
            return r4
        L_0x018d:
            r15.v = r1
        L_0x018f:
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r3 = r15.l     // Catch:{ CryptoException -> 0x01f3 }
            long r10 = r3.d     // Catch:{ CryptoException -> 0x01f3 }
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            boolean r3 = r3.b(r6)     // Catch:{ CryptoException -> 0x01f3 }
            if (r3 == 0) goto L_0x01a4
            java.util.List<java.lang.Long> r3 = r15.o     // Catch:{ CryptoException -> 0x01f3 }
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ CryptoException -> 0x01f3 }
            r3.add(r6)     // Catch:{ CryptoException -> 0x01f3 }
        L_0x01a4:
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r3 = r15.l     // Catch:{ CryptoException -> 0x01f3 }
            java.nio.ByteBuffer r3 = r3.c     // Catch:{ CryptoException -> 0x01f3 }
            r3.flip()     // Catch:{ CryptoException -> 0x01f3 }
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r3 = r15.l     // Catch:{ CryptoException -> 0x01f3 }
            r15.a((com.fyber.inneractive.sdk.player.exoplayer2.decoder.b) r3)     // Catch:{ CryptoException -> 0x01f3 }
            if (r0 == 0) goto L_0x01d4
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r0 = r15.l     // Catch:{ CryptoException -> 0x01f3 }
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.a r0 = r0.b     // Catch:{ CryptoException -> 0x01f3 }
            android.media.MediaCodec$CryptoInfo r9 = r0.g     // Catch:{ CryptoException -> 0x01f3 }
            if (r5 != 0) goto L_0x01bb
            goto L_0x01ca
        L_0x01bb:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01f3 }
            if (r0 != 0) goto L_0x01c3
            int[] r0 = new int[r4]     // Catch:{ CryptoException -> 0x01f3 }
            r9.numBytesOfClearData = r0     // Catch:{ CryptoException -> 0x01f3 }
        L_0x01c3:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01f3 }
            r3 = r0[r1]     // Catch:{ CryptoException -> 0x01f3 }
            int r3 = r3 + r5
            r0[r1] = r3     // Catch:{ CryptoException -> 0x01f3 }
        L_0x01ca:
            android.media.MediaCodec r6 = r15.r     // Catch:{ CryptoException -> 0x01f3 }
            int r7 = r15.H     // Catch:{ CryptoException -> 0x01f3 }
            r8 = 0
            r12 = 0
            r6.queueSecureInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01f3 }
            goto L_0x01e5
        L_0x01d4:
            android.media.MediaCodec r6 = r15.r     // Catch:{ CryptoException -> 0x01f3 }
            int r7 = r15.H     // Catch:{ CryptoException -> 0x01f3 }
            r8 = 0
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r0 = r15.l     // Catch:{ CryptoException -> 0x01f3 }
            java.nio.ByteBuffer r0 = r0.c     // Catch:{ CryptoException -> 0x01f3 }
            int r9 = r0.limit()     // Catch:{ CryptoException -> 0x01f3 }
            r12 = 0
            r6.queueInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01f3 }
        L_0x01e5:
            r15.H = r2     // Catch:{ CryptoException -> 0x01f3 }
            r15.N = r4     // Catch:{ CryptoException -> 0x01f3 }
            r15.L = r1     // Catch:{ CryptoException -> 0x01f3 }
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters r0 = r15.T     // Catch:{ CryptoException -> 0x01f3 }
            int r1 = r0.inputBufferCount     // Catch:{ CryptoException -> 0x01f3 }
            int r1 = r1 + r4
            r0.inputBufferCount = r1     // Catch:{ CryptoException -> 0x01f3 }
            return r4
        L_0x01f3:
            r0 = move-exception
            int r1 = r15.c
            com.fyber.inneractive.sdk.player.exoplayer2.d r0 = com.fyber.inneractive.sdk.player.exoplayer2.d.a(r0, r1)
            throw r0
        L_0x01fb:
            com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> r0 = r15.s
            r0.c()
            int r0 = r15.c
            r1 = 0
            com.fyber.inneractive.sdk.player.exoplayer2.d r0 = com.fyber.inneractive.sdk.player.exoplayer2.d.a(r1, r0)
            throw r0
        L_0x0208:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b.s():boolean");
    }

    public void a(long j2, boolean z2) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        this.P = false;
        this.Q = false;
        if (this.r != null) {
            this.G = -9223372036854775807L;
            this.H = -1;
            this.I = -1;
            this.S = true;
            this.R = false;
            this.J = false;
            this.o.clear();
            this.C = false;
            this.D = false;
            if (this.w || (this.z && this.O)) {
                v();
                t();
            } else if (this.M != 0) {
                v();
                t();
            } else {
                this.r.flush();
                this.N = false;
            }
            if (this.K && this.q != null) {
                this.L = 1;
            }
        }
    }

    public void a(long j2, long j3) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        int i2;
        boolean z2;
        boolean z3;
        if (this.Q) {
            w();
            return;
        }
        boolean z4 = true;
        if (this.q == null) {
            this.m.a();
            int a2 = a(this.n, this.m, true);
            if (a2 == -5) {
                a(this.n.a);
            } else if (a2 == -4) {
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.m.b(4));
                this.P = true;
                u();
                return;
            } else {
                return;
            }
        }
        t();
        if (this.r != null) {
            s.a("drainAndFeed");
            while (true) {
                if (this.I < 0) {
                    if (!this.A || !this.O) {
                        this.I = this.r.dequeueOutputBuffer(this.p, 0);
                    } else {
                        try {
                            this.I = this.r.dequeueOutputBuffer(this.p, 0);
                        } catch (IllegalStateException unused) {
                            u();
                            if (this.Q) {
                                v();
                            }
                        }
                    }
                    int i3 = this.I;
                    if (i3 < 0) {
                        if (i3 == -2) {
                            MediaFormat outputFormat = this.r.getOutputFormat();
                            if (this.x && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                                this.D = z4;
                            } else {
                                if (this.B) {
                                    outputFormat.setInteger("channel-count", z4 ? 1 : 0);
                                }
                                a(this.r, outputFormat);
                            }
                        } else if (i3 == -3) {
                            this.F = this.r.getOutputBuffers();
                        } else if (this.y && (this.P || this.M == 2)) {
                            u();
                        }
                        z4 = true;
                    } else if (this.D) {
                        this.D = false;
                        this.r.releaseOutputBuffer(i3, false);
                        this.I = -1;
                        z4 = true;
                    } else {
                        MediaCodec.BufferInfo bufferInfo = this.p;
                        if ((bufferInfo.flags & 4) != 0) {
                            u();
                            this.I = -1;
                            break;
                        }
                        ByteBuffer byteBuffer = this.F[i3];
                        if (byteBuffer != null) {
                            byteBuffer.position(bufferInfo.offset);
                            MediaCodec.BufferInfo bufferInfo2 = this.p;
                            byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                        }
                        long j4 = this.p.presentationTimeUs;
                        int size = this.o.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size) {
                                z3 = false;
                                break;
                            } else if (this.o.get(i4).longValue() == j4) {
                                this.o.remove(i4);
                                z3 = true;
                                break;
                            } else {
                                i4++;
                            }
                        }
                        this.J = z3;
                    }
                }
                if (!this.A || !this.O) {
                    i2 = -1;
                    MediaCodec mediaCodec = this.r;
                    ByteBuffer[] byteBufferArr = this.F;
                    int i5 = this.I;
                    ByteBuffer byteBuffer2 = byteBufferArr[i5];
                    MediaCodec.BufferInfo bufferInfo3 = this.p;
                    z2 = a(j2, j3, mediaCodec, byteBuffer2, i5, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.J);
                } else {
                    try {
                        MediaCodec mediaCodec2 = this.r;
                        ByteBuffer[] byteBufferArr2 = this.F;
                        int i6 = this.I;
                        ByteBuffer byteBuffer3 = byteBufferArr2[i6];
                        MediaCodec.BufferInfo bufferInfo4 = this.p;
                        i2 = -1;
                        z2 = a(j2, j3, mediaCodec2, byteBuffer3, i6, bufferInfo4.flags, bufferInfo4.presentationTimeUs, this.J);
                    } catch (IllegalStateException unused2) {
                        u();
                        if (this.Q) {
                            v();
                        }
                    }
                }
                if (!z2) {
                    break;
                }
                long j5 = this.p.presentationTimeUs;
                this.I = i2;
                z4 = true;
            }
            do {
            } while (s());
            s.a();
        } else {
            this.e.a(j2 - this.f);
            this.m.a();
            int a3 = a(this.n, this.m, false);
            if (a3 == -5) {
                a(this.n.a);
            } else if (a3 == -4) {
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.m.b(4));
                this.P = true;
                u();
            }
        }
        this.T.ensureUpdated();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006f, code lost:
        if (r5.k == r0.k) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.i r5) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        /*
            r4 = this;
            com.fyber.inneractive.sdk.player.exoplayer2.i r0 = r4.q
            r4.q = r5
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a r5 = r5.i
            r1 = 0
            if (r0 != 0) goto L_0x000b
            r2 = r1
            goto L_0x000d
        L_0x000b:
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a r2 = r0.i
        L_0x000d:
            boolean r5 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((java.lang.Object) r5, (java.lang.Object) r2)
            r2 = 1
            r5 = r5 ^ r2
            if (r5 == 0) goto L_0x0047
            com.fyber.inneractive.sdk.player.exoplayer2.i r5 = r4.q
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a r5 = r5.i
            if (r5 == 0) goto L_0x0045
            com.fyber.inneractive.sdk.player.exoplayer2.drm.c<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> r5 = r4.j
            if (r5 == 0) goto L_0x0037
            android.os.Looper r1 = android.os.Looper.myLooper()
            com.fyber.inneractive.sdk.player.exoplayer2.i r3 = r4.q
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a r3 = r3.i
            com.fyber.inneractive.sdk.player.exoplayer2.drm.b r5 = r5.a(r1, r3)
            r4.t = r5
            com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> r1 = r4.s
            if (r5 != r1) goto L_0x0047
            com.fyber.inneractive.sdk.player.exoplayer2.drm.c<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> r1 = r4.j
            r1.a(r5)
            goto L_0x0047
        L_0x0037:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r5.<init>(r0)
            int r0 = r4.c
            com.fyber.inneractive.sdk.player.exoplayer2.d r5 = com.fyber.inneractive.sdk.player.exoplayer2.d.a(r5, r0)
            throw r5
        L_0x0045:
            r4.t = r1
        L_0x0047:
            com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> r5 = r4.t
            com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> r1 = r4.s
            if (r5 != r1) goto L_0x0076
            android.media.MediaCodec r5 = r4.r
            if (r5 == 0) goto L_0x0076
            boolean r1 = r4.u
            com.fyber.inneractive.sdk.player.exoplayer2.i r3 = r4.q
            boolean r5 = r4.a((android.media.MediaCodec) r5, (boolean) r1, (com.fyber.inneractive.sdk.player.exoplayer2.i) r0, (com.fyber.inneractive.sdk.player.exoplayer2.i) r3)
            if (r5 == 0) goto L_0x0076
            r4.K = r2
            r4.L = r2
            boolean r5 = r4.x
            if (r5 == 0) goto L_0x0072
            com.fyber.inneractive.sdk.player.exoplayer2.i r5 = r4.q
            int r1 = r5.j
            int r3 = r0.j
            if (r1 != r3) goto L_0x0072
            int r5 = r5.k
            int r0 = r0.k
            if (r5 != r0) goto L_0x0072
            goto L_0x0073
        L_0x0072:
            r2 = 0
        L_0x0073:
            r4.C = r2
            goto L_0x0083
        L_0x0076:
            boolean r5 = r4.N
            if (r5 == 0) goto L_0x007d
            r4.M = r2
            goto L_0x0083
        L_0x007d:
            r4.v()
            r4.t()
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b.a(com.fyber.inneractive.sdk.player.exoplayer2.i):void");
    }
}
