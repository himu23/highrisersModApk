package com.applovin.exoplayer2.f;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.applovin.exoplayer2.c.c;
import com.applovin.exoplayer2.common.base.Supplier;
import com.applovin.exoplayer2.f.g;
import com.applovin.exoplayer2.l.ah;
import java.nio.ByteBuffer;
import java.util.Objects;

final class a implements g {
    private boolean GA;
    private Surface GB;
    private final MediaCodec Gw;
    private final c Gx;
    private final b Gy;
    private final boolean Gz;
    private int Z;

    public boolean jC() {
        return false;
    }

    /* renamed from: com.applovin.exoplayer2.f.a$a  reason: collision with other inner class name */
    public static final class C0046a implements g.b {
        private final Supplier<HandlerThread> GC;
        private final Supplier<HandlerThread> GD;
        private final boolean GE;
        private final boolean Gz;

        public C0046a(int i, boolean z, boolean z2) {
            this(new a$a$$ExternalSyntheticLambda0(i), new a$a$$ExternalSyntheticLambda1(i), z, z2);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ HandlerThread cP(int i) {
            return new HandlerThread(a.cK(i));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ HandlerThread cO(int i) {
            return new HandlerThread(a.cL(i));
        }

        C0046a(Supplier<HandlerThread> supplier, Supplier<HandlerThread> supplier2, boolean z, boolean z2) {
            this.GC = supplier;
            this.GD = supplier2;
            this.GE = z;
            this.Gz = z2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.applovin.exoplayer2.f.a b(com.applovin.exoplayer2.f.g.a r11) throws java.io.IOException {
            /*
                r10 = this;
                java.lang.String r0 = "createCodec:"
                com.applovin.exoplayer2.f.i r1 = r11.Hk
                java.lang.String r1 = r1.name
                r2 = 0
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004f }
                r3.<init>(r0)     // Catch:{ Exception -> 0x004f }
                r3.append(r1)     // Catch:{ Exception -> 0x004f }
                java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x004f }
                com.applovin.exoplayer2.l.ah.bg(r0)     // Catch:{ Exception -> 0x004f }
                android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r1)     // Catch:{ Exception -> 0x004f }
                com.applovin.exoplayer2.f.a r1 = new com.applovin.exoplayer2.f.a     // Catch:{ Exception -> 0x004d }
                com.applovin.exoplayer2.common.base.Supplier<android.os.HandlerThread> r3 = r10.GC     // Catch:{ Exception -> 0x004d }
                java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x004d }
                r5 = r3
                android.os.HandlerThread r5 = (android.os.HandlerThread) r5     // Catch:{ Exception -> 0x004d }
                com.applovin.exoplayer2.common.base.Supplier<android.os.HandlerThread> r3 = r10.GD     // Catch:{ Exception -> 0x004d }
                java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x004d }
                r6 = r3
                android.os.HandlerThread r6 = (android.os.HandlerThread) r6     // Catch:{ Exception -> 0x004d }
                boolean r7 = r10.GE     // Catch:{ Exception -> 0x004d }
                boolean r8 = r10.Gz     // Catch:{ Exception -> 0x004d }
                r9 = 0
                r3 = r1
                r4 = r0
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x004d }
                com.applovin.exoplayer2.l.ah.pV()     // Catch:{ Exception -> 0x004a }
                android.media.MediaFormat r4 = r11.Hl     // Catch:{ Exception -> 0x004a }
                android.view.Surface r5 = r11.Hm     // Catch:{ Exception -> 0x004a }
                android.media.MediaCrypto r6 = r11.Hn     // Catch:{ Exception -> 0x004a }
                int r7 = r11.jF     // Catch:{ Exception -> 0x004a }
                boolean r8 = r11.Ho     // Catch:{ Exception -> 0x004a }
                r3 = r1
                r3.a((android.media.MediaFormat) r4, (android.view.Surface) r5, (android.media.MediaCrypto) r6, (int) r7, (boolean) r8)     // Catch:{ Exception -> 0x004a }
                return r1
            L_0x004a:
                r11 = move-exception
                r2 = r1
                goto L_0x0051
            L_0x004d:
                r11 = move-exception
                goto L_0x0051
            L_0x004f:
                r11 = move-exception
                r0 = r2
            L_0x0051:
                if (r2 != 0) goto L_0x0059
                if (r0 == 0) goto L_0x005c
                r0.release()
                goto L_0x005c
            L_0x0059:
                r2.release()
            L_0x005c:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.f.a.C0046a.b(com.applovin.exoplayer2.f.g$a):com.applovin.exoplayer2.f.a");
        }
    }

    private a(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z, boolean z2) {
        this.Gw = mediaCodec;
        this.Gx = new c(handlerThread);
        this.Gy = new b(mediaCodec, handlerThread2, z);
        this.Gz = z2;
        this.Z = 0;
    }

    /* access modifiers changed from: private */
    public void a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i, boolean z) {
        this.Gx.a(this.Gw);
        ah.bg("configureCodec");
        this.Gw.configure(mediaFormat, surface, mediaCrypto, i);
        ah.pV();
        if (z) {
            this.GB = this.Gw.createInputSurface();
        }
        this.Gy.start();
        ah.bg("startCodec");
        this.Gw.start();
        ah.pV();
        this.Z = 1;
    }

    public void a(int i, int i2, int i3, long j, int i4) {
        this.Gy.a(i, i2, i3, j, i4);
    }

    public void a(int i, int i2, c cVar, long j, int i3) {
        this.Gy.a(i, i2, cVar, j, i3);
    }

    public void l(int i, boolean z) {
        this.Gw.releaseOutputBuffer(i, z);
    }

    public void i(int i, long j) {
        this.Gw.releaseOutputBuffer(i, j);
    }

    public int jD() {
        return this.Gx.jD();
    }

    public int a(MediaCodec.BufferInfo bufferInfo) {
        return this.Gx.a(bufferInfo);
    }

    public MediaFormat jE() {
        return this.Gx.jE();
    }

    public ByteBuffer cH(int i) {
        return this.Gw.getInputBuffer(i);
    }

    public ByteBuffer cI(int i) {
        return this.Gw.getOutputBuffer(i);
    }

    public void dI() {
        this.Gy.dI();
        this.Gw.flush();
        c cVar = this.Gx;
        MediaCodec mediaCodec = this.Gw;
        Objects.requireNonNull(mediaCodec);
        cVar.a((Runnable) new a$$ExternalSyntheticLambda3(mediaCodec));
    }

    public void release() {
        try {
            if (this.Z == 1) {
                this.Gy.jG();
                this.Gx.jG();
            }
            this.Z = 2;
        } finally {
            Surface surface = this.GB;
            if (surface != null) {
                surface.release();
            }
            if (!this.GA) {
                this.Gw.release();
                this.GA = true;
            }
        }
    }

    public void a(g.c cVar, Handler handler) {
        jF();
        this.Gw.setOnFrameRenderedListener(new a$$ExternalSyntheticLambda2(this, cVar), handler);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(g.c cVar, MediaCodec mediaCodec, long j, long j2) {
        cVar.a(this, j, j2);
    }

    public void b(Surface surface) {
        jF();
        this.Gw.setOutputSurface(surface);
    }

    public void u(Bundle bundle) {
        jF();
        this.Gw.setParameters(bundle);
    }

    public void cJ(int i) {
        jF();
        this.Gw.setVideoScalingMode(i);
    }

    private void jF() {
        if (this.Gz) {
            try {
                this.Gy.jH();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static String cK(int i) {
        return c(i, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* access modifiers changed from: private */
    public static String cL(int i) {
        return c(i, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String c(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }
}
