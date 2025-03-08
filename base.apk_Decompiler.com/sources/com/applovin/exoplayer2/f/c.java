package com.applovin.exoplayer2.f;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import java.util.ArrayDeque;

final class c extends MediaCodec.Callback {
    private final HandlerThread GP;
    private final f GQ;
    private final f GR;
    private final ArrayDeque<MediaCodec.BufferInfo> GT;
    private final ArrayDeque<MediaFormat> GU;
    private MediaFormat GV;
    private MediaFormat GW;
    private MediaCodec.CodecException GX;
    private long GY;
    private boolean GZ;
    private IllegalStateException Ha;
    private Handler jS;
    private final Object rT = new Object();

    private boolean jN() {
        return this.GY > 0 || this.GZ;
    }

    c(HandlerThread handlerThread) {
        this.GP = handlerThread;
        this.GQ = new f();
        this.GR = new f();
        this.GT = new ArrayDeque<>();
        this.GU = new ArrayDeque<>();
    }

    public void a(MediaCodec mediaCodec) {
        a.checkState(this.jS == null);
        this.GP.start();
        Handler handler = new Handler(this.GP.getLooper());
        mediaCodec.setCallback(this, handler);
        this.jS = handler;
    }

    public void jG() {
        synchronized (this.rT) {
            this.GZ = true;
            this.GP.quit();
            jM();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int jD() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.rT
            monitor-enter(r0)
            boolean r1 = r3.jN()     // Catch:{ all -> 0x0020 }
            r2 = -1
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return r2
        L_0x000c:
            r3.hk()     // Catch:{ all -> 0x0020 }
            com.applovin.exoplayer2.f.f r1 = r3.GQ     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0018
            goto L_0x001e
        L_0x0018:
            com.applovin.exoplayer2.f.f r1 = r3.GQ     // Catch:{ all -> 0x0020 }
            int r2 = r1.jT()     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return r2
        L_0x0020:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.f.c.jD():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(android.media.MediaCodec.BufferInfo r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.rT
            monitor-enter(r0)
            boolean r1 = r9.jN()     // Catch:{ all -> 0x004a }
            r2 = -1
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return r2
        L_0x000c:
            r9.hk()     // Catch:{ all -> 0x004a }
            com.applovin.exoplayer2.f.f r1 = r9.GR     // Catch:{ all -> 0x004a }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0019
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return r2
        L_0x0019:
            com.applovin.exoplayer2.f.f r1 = r9.GR     // Catch:{ all -> 0x004a }
            int r1 = r1.jT()     // Catch:{ all -> 0x004a }
            if (r1 < 0) goto L_0x003b
            android.media.MediaFormat r2 = r9.GV     // Catch:{ all -> 0x004a }
            com.applovin.exoplayer2.l.a.N(r2)     // Catch:{ all -> 0x004a }
            java.util.ArrayDeque<android.media.MediaCodec$BufferInfo> r2 = r9.GT     // Catch:{ all -> 0x004a }
            java.lang.Object r2 = r2.remove()     // Catch:{ all -> 0x004a }
            android.media.MediaCodec$BufferInfo r2 = (android.media.MediaCodec.BufferInfo) r2     // Catch:{ all -> 0x004a }
            int r4 = r2.offset     // Catch:{ all -> 0x004a }
            int r5 = r2.size     // Catch:{ all -> 0x004a }
            long r6 = r2.presentationTimeUs     // Catch:{ all -> 0x004a }
            int r8 = r2.flags     // Catch:{ all -> 0x004a }
            r3 = r10
            r3.set(r4, r5, r6, r8)     // Catch:{ all -> 0x004a }
            goto L_0x0048
        L_0x003b:
            r10 = -2
            if (r1 != r10) goto L_0x0048
            java.util.ArrayDeque<android.media.MediaFormat> r10 = r9.GU     // Catch:{ all -> 0x004a }
            java.lang.Object r10 = r10.remove()     // Catch:{ all -> 0x004a }
            android.media.MediaFormat r10 = (android.media.MediaFormat) r10     // Catch:{ all -> 0x004a }
            r9.GV = r10     // Catch:{ all -> 0x004a }
        L_0x0048:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return r1
        L_0x004a:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.f.c.a(android.media.MediaCodec$BufferInfo):int");
    }

    public MediaFormat jE() {
        MediaFormat mediaFormat;
        synchronized (this.rT) {
            mediaFormat = this.GV;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public void a(Runnable runnable) {
        synchronized (this.rT) {
            this.GY++;
            ((Handler) ai.R(this.jS)).post(new c$$ExternalSyntheticLambda1(this, runnable));
        }
    }

    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.rT) {
            this.GQ.cR(i);
        }
    }

    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.rT) {
            MediaFormat mediaFormat = this.GW;
            if (mediaFormat != null) {
                a(mediaFormat);
                this.GW = null;
            }
            this.GR.cR(i);
            this.GT.add(bufferInfo);
        }
    }

    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.rT) {
            this.GX = codecException;
        }
    }

    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.rT) {
            a(mediaFormat);
            this.GW = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void d(Runnable runnable) {
        synchronized (this.rT) {
            c(runnable);
        }
    }

    private void c(Runnable runnable) {
        if (!this.GZ) {
            long j = this.GY - 1;
            this.GY = j;
            if (j <= 0) {
                if (j < 0) {
                    a(new IllegalStateException());
                    return;
                }
                jM();
                try {
                    runnable.run();
                } catch (IllegalStateException e) {
                    a(e);
                } catch (Exception e2) {
                    a(new IllegalStateException(e2));
                }
            }
        }
    }

    private void jM() {
        if (!this.GU.isEmpty()) {
            this.GW = this.GU.getLast();
        }
        this.GQ.clear();
        this.GR.clear();
        this.GT.clear();
        this.GU.clear();
        this.GX = null;
    }

    private void a(MediaFormat mediaFormat) {
        this.GR.cR(-2);
        this.GU.add(mediaFormat);
    }

    private void hk() {
        jO();
        jP();
    }

    private void jO() {
        IllegalStateException illegalStateException = this.Ha;
        if (illegalStateException != null) {
            this.Ha = null;
            throw illegalStateException;
        }
    }

    private void jP() {
        MediaCodec.CodecException codecException = this.GX;
        if (codecException != null) {
            this.GX = null;
            throw codecException;
        }
    }

    private void a(IllegalStateException illegalStateException) {
        synchronized (this.rT) {
            this.Ha = illegalStateException;
        }
    }
}
