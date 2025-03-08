package com.applovin.exoplayer2.f;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.applovin.exoplayer2.c.c;
import com.applovin.exoplayer2.f.g;
import com.applovin.exoplayer2.l.ah;
import com.applovin.exoplayer2.l.ai;
import java.io.IOException;
import java.nio.ByteBuffer;

public class m implements g {
    private final Surface GB;
    private final MediaCodec Gw;
    private ByteBuffer[] IX;
    private ByteBuffer[] IY;

    public boolean jC() {
        return false;
    }

    public static class b implements g.b {
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.applovin.exoplayer2.f.g b(com.applovin.exoplayer2.f.g.a r8) throws java.io.IOException {
            /*
                r7 = this;
                r0 = 0
                android.media.MediaCodec r1 = r7.c(r8)     // Catch:{ IOException -> 0x004e, RuntimeException -> 0x004c }
                java.lang.String r2 = "configureCodec"
                com.applovin.exoplayer2.l.ah.bg(r2)     // Catch:{ IOException -> 0x004a, RuntimeException -> 0x0048 }
                android.media.MediaFormat r2 = r8.Hl     // Catch:{ IOException -> 0x004a, RuntimeException -> 0x0048 }
                android.view.Surface r3 = r8.Hm     // Catch:{ IOException -> 0x004a, RuntimeException -> 0x0048 }
                android.media.MediaCrypto r4 = r8.Hn     // Catch:{ IOException -> 0x004a, RuntimeException -> 0x0048 }
                int r5 = r8.jF     // Catch:{ IOException -> 0x004a, RuntimeException -> 0x0048 }
                r1.configure(r2, r3, r4, r5)     // Catch:{ IOException -> 0x004a, RuntimeException -> 0x0048 }
                com.applovin.exoplayer2.l.ah.pV()     // Catch:{ IOException -> 0x004a, RuntimeException -> 0x0048 }
                boolean r8 = r8.Ho     // Catch:{ IOException -> 0x004a, RuntimeException -> 0x0048 }
                if (r8 == 0) goto L_0x002f
                int r8 = com.applovin.exoplayer2.l.ai.acV     // Catch:{ IOException -> 0x004a, RuntimeException -> 0x0048 }
                r2 = 18
                if (r8 < r2) goto L_0x0027
                android.view.Surface r8 = com.applovin.exoplayer2.f.m.a.b(r1)     // Catch:{ IOException -> 0x004a, RuntimeException -> 0x0048 }
                goto L_0x0030
            L_0x0027:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x004a, RuntimeException -> 0x0048 }
                java.lang.String r2 = "Encoding from a surface is only supported on API 18 and up."
                r8.<init>(r2)     // Catch:{ IOException -> 0x004a, RuntimeException -> 0x0048 }
                throw r8     // Catch:{ IOException -> 0x004a, RuntimeException -> 0x0048 }
            L_0x002f:
                r8 = r0
            L_0x0030:
                java.lang.String r2 = "startCodec"
                com.applovin.exoplayer2.l.ah.bg(r2)     // Catch:{ IOException -> 0x0043, RuntimeException -> 0x0041 }
                r1.start()     // Catch:{ IOException -> 0x0043, RuntimeException -> 0x0041 }
                com.applovin.exoplayer2.l.ah.pV()     // Catch:{ IOException -> 0x0043, RuntimeException -> 0x0041 }
                com.applovin.exoplayer2.f.m r2 = new com.applovin.exoplayer2.f.m     // Catch:{ IOException -> 0x0043, RuntimeException -> 0x0041 }
                r2.<init>(r1, r8)     // Catch:{ IOException -> 0x0043, RuntimeException -> 0x0041 }
                return r2
            L_0x0041:
                r0 = move-exception
                goto L_0x0044
            L_0x0043:
                r0 = move-exception
            L_0x0044:
                r6 = r0
                r0 = r8
                r8 = r6
                goto L_0x0050
            L_0x0048:
                r8 = move-exception
                goto L_0x0050
            L_0x004a:
                r8 = move-exception
                goto L_0x0050
            L_0x004c:
                r8 = move-exception
                goto L_0x004f
            L_0x004e:
                r8 = move-exception
            L_0x004f:
                r1 = r0
            L_0x0050:
                if (r0 == 0) goto L_0x0055
                r0.release()
            L_0x0055:
                if (r1 == 0) goto L_0x005a
                r1.release()
            L_0x005a:
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.f.m.b.b(com.applovin.exoplayer2.f.g$a):com.applovin.exoplayer2.f.g");
        }

        /* access modifiers changed from: protected */
        public MediaCodec c(g.a aVar) throws IOException {
            com.applovin.exoplayer2.l.a.checkNotNull(aVar.Hk);
            String str = aVar.Hk.name;
            ah.bg("createCodec:" + str);
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            ah.pV();
            return createByCodecName;
        }
    }

    private m(MediaCodec mediaCodec, Surface surface) {
        this.Gw = mediaCodec;
        this.GB = surface;
        if (ai.acV < 21) {
            this.IX = mediaCodec.getInputBuffers();
            this.IY = mediaCodec.getOutputBuffers();
        }
    }

    public int jD() {
        return this.Gw.dequeueInputBuffer(0);
    }

    public int a(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.Gw.dequeueOutputBuffer(bufferInfo, 0);
            if (dequeueOutputBuffer == -3 && ai.acV < 21) {
                this.IY = this.Gw.getOutputBuffers();
                continue;
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    public MediaFormat jE() {
        return this.Gw.getOutputFormat();
    }

    public ByteBuffer cH(int i) {
        if (ai.acV >= 21) {
            return this.Gw.getInputBuffer(i);
        }
        return ((ByteBuffer[]) ai.R(this.IX))[i];
    }

    public ByteBuffer cI(int i) {
        if (ai.acV >= 21) {
            return this.Gw.getOutputBuffer(i);
        }
        return ((ByteBuffer[]) ai.R(this.IY))[i];
    }

    public void a(int i, int i2, int i3, long j, int i4) {
        this.Gw.queueInputBuffer(i, i2, i3, j, i4);
    }

    public void a(int i, int i2, c cVar, long j, int i3) {
        this.Gw.queueSecureInputBuffer(i, i2, cVar.hb(), j, i3);
    }

    public void l(int i, boolean z) {
        this.Gw.releaseOutputBuffer(i, z);
    }

    public void i(int i, long j) {
        this.Gw.releaseOutputBuffer(i, j);
    }

    public void dI() {
        this.Gw.flush();
    }

    public void release() {
        this.IX = null;
        this.IY = null;
        Surface surface = this.GB;
        if (surface != null) {
            surface.release();
        }
        this.Gw.release();
    }

    public void a(g.c cVar, Handler handler) {
        this.Gw.setOnFrameRenderedListener(new m$$ExternalSyntheticLambda0(this, cVar), handler);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(g.c cVar, MediaCodec mediaCodec, long j, long j2) {
        cVar.a(this, j, j2);
    }

    public void b(Surface surface) {
        this.Gw.setOutputSurface(surface);
    }

    public void u(Bundle bundle) {
        this.Gw.setParameters(bundle);
    }

    public void cJ(int i) {
        this.Gw.setVideoScalingMode(i);
    }

    private static final class a {
        public static Surface b(MediaCodec mediaCodec) {
            return mediaCodec.createInputSurface();
        }
    }
}
