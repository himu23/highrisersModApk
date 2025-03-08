package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.Surface;
import androidx.work.WorkRequest;
import com.fyber.inneractive.sdk.player.exoplayer2.audio.AudioRendererEventListener;
import com.fyber.inneractive.sdk.player.exoplayer2.audio.c;
import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;
import com.fyber.inneractive.sdk.player.exoplayer2.drm.d;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.m;
import com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d;
import com.fyber.inneractive.sdk.player.exoplayer2.util.g;
import com.fyber.inneractive.sdk.player.exoplayer2.util.h;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.ironsource.m2;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class MediaCodecAudioRenderer extends com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b implements g {
    public final AudioRendererEventListener.EventDispatcher V;
    public final c W;
    public boolean X;
    public int Y;
    public int Z;
    public long a0;
    public boolean b0;

    public final class b implements c.f {
        public b() {
        }
    }

    public MediaCodecAudioRenderer(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c cVar, com.fyber.inneractive.sdk.player.exoplayer2.drm.c<d> cVar2, boolean z, Handler handler, AudioRendererEventListener audioRendererEventListener) {
        this(cVar, cVar2, z, (Handler) null, (AudioRendererEventListener) null, new b[0]);
    }

    public boolean b() {
        if (this.Q) {
            c cVar = this.W;
            if (!cVar.e() || (cVar.X && !cVar.d())) {
                return true;
            }
        }
        return false;
    }

    public boolean isReady() {
        return this.W.d() || super.isReady();
    }

    public g j() {
        return this;
    }

    public long o() {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        c cVar = this.W;
        boolean b2 = b();
        if (!cVar.e() || cVar.L == 0) {
            j2 = Long.MIN_VALUE;
            j = Long.MIN_VALUE;
        } else {
            if (cVar.i.getPlayState() == 3) {
                c.b bVar = cVar.g;
                long a2 = (bVar.a() * 1000000) / ((long) bVar.c);
                if (a2 != 0) {
                    long nanoTime = System.nanoTime() / 1000;
                    if (nanoTime - cVar.A >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                        long[] jArr = cVar.f;
                        int i = cVar.x;
                        jArr[i] = a2 - nanoTime;
                        cVar.x = (i + 1) % 10;
                        int i2 = cVar.y;
                        if (i2 < 10) {
                            cVar.y = i2 + 1;
                        }
                        cVar.A = nanoTime;
                        cVar.z = 0;
                        int i3 = 0;
                        while (true) {
                            int i4 = cVar.y;
                            if (i3 >= i4) {
                                break;
                            }
                            cVar.z += cVar.f[i3] / ((long) i4);
                            i3++;
                        }
                    }
                    if (!cVar.f() && nanoTime - cVar.C >= 500000) {
                        boolean d = cVar.g.d();
                        cVar.B = d;
                        if (d) {
                            long c = cVar.g.c() / 1000;
                            long b3 = cVar.g.b();
                            if (c < cVar.N) {
                                cVar.B = false;
                            } else if (Math.abs(c - nanoTime) > 5000000) {
                                Log.w("AudioTrack", "Spurious audio timestamp (system clock mismatch): " + b3 + ", " + c + ", " + nanoTime + ", " + a2 + ", " + cVar.b() + ", " + cVar.c());
                                cVar.B = false;
                            } else if (Math.abs(cVar.b(b3) - a2) > 5000000) {
                                Log.w("AudioTrack", "Spurious audio timestamp (frame position mismatch): " + b3 + ", " + c + ", " + nanoTime + ", " + a2 + ", " + cVar.b() + ", " + cVar.c());
                                cVar.B = false;
                            }
                        }
                        Method method = cVar.D;
                        if (method != null && !cVar.o) {
                            try {
                                long intValue = (((long) ((Integer) method.invoke(cVar.i, (Object[]) null)).intValue()) * 1000) - cVar.q;
                                cVar.O = intValue;
                                long max = Math.max(intValue, 0);
                                cVar.O = max;
                                if (max > 5000000) {
                                    Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + cVar.O);
                                    cVar.O = 0;
                                }
                            } catch (Exception unused) {
                                cVar.D = null;
                            }
                        }
                        cVar.C = nanoTime;
                    }
                }
            }
            long nanoTime2 = System.nanoTime() / 1000;
            if (cVar.B) {
                j3 = cVar.b(cVar.g.b() + cVar.a(nanoTime2 - (cVar.g.c() / 1000)));
            } else {
                if (cVar.y == 0) {
                    c.b bVar2 = cVar.g;
                    j5 = (bVar2.a() * 1000000) / ((long) bVar2.c);
                } else {
                    j5 = nanoTime2 + cVar.z;
                }
                j3 = !b2 ? j5 - cVar.O : j5;
            }
            long j6 = cVar.M;
            while (!cVar.h.isEmpty() && j3 >= cVar.h.getFirst().c) {
                c.g remove = cVar.h.remove();
                cVar.s = remove.a;
                cVar.u = remove.c;
                cVar.t = remove.b - cVar.M;
            }
            if (cVar.s.a == 1.0f) {
                j4 = (j3 + cVar.t) - cVar.u;
            } else {
                if (cVar.h.isEmpty()) {
                    h hVar = cVar.b;
                    long j7 = hVar.k;
                    if (j7 >= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                        j4 = cVar.t + u.a(j3 - cVar.u, hVar.j, j7);
                    }
                }
                j4 = cVar.t + ((long) (((double) cVar.s.a) * ((double) (j3 - cVar.u))));
            }
            j = j6 + j4;
            j2 = Long.MIN_VALUE;
        }
        if (j != j2) {
            if (!this.b0) {
                j = Math.max(this.a0, j);
            }
            this.a0 = j;
            this.b0 = false;
        }
        return this.a0;
    }

    public void q() {
        this.W.g();
    }

    public MediaCodecAudioRenderer(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c cVar, com.fyber.inneractive.sdk.player.exoplayer2.drm.c cVar2, boolean z, Handler handler, AudioRendererEventListener audioRendererEventListener, b... bVarArr) {
        super(1, cVar, cVar2, z);
        this.W = new c(bVarArr, new b());
        this.V = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
    }

    public int a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c cVar, i iVar) throws d.b {
        int i;
        String str = iVar.f;
        if (!h.d(str)) {
            return 0;
        }
        int i2 = u.a;
        int i3 = 16;
        int i4 = i2 >= 21 ? 16 : 0;
        this.W.getClass();
        com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a a2 = cVar.a(str, false);
        if (a2 == null) {
            return 1;
        }
        if (i2 >= 21) {
            int i5 = iVar.s;
            if (i5 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = a2.e;
                if (codecCapabilities == null) {
                    a2.a("sampleRate.caps");
                } else {
                    MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
                    if (audioCapabilities == null) {
                        a2.a("sampleRate.aCaps");
                    } else if (!audioCapabilities.isSampleRateSupported(i5)) {
                        a2.a("sampleRate.support, " + i5);
                    }
                }
                i = 2;
                return i | i4 | 4;
            }
            int i6 = iVar.r;
            if (i6 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities2 = a2.e;
                if (codecCapabilities2 == null) {
                    a2.a("channelCount.caps");
                } else {
                    MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
                    if (audioCapabilities2 == null) {
                        a2.a("channelCount.aCaps");
                    } else {
                        String str2 = a2.a;
                        String str3 = a2.d;
                        int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                        if (maxInputChannelCount <= 1 && ((i2 < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str3) && !"audio/3gpp".equals(str3) && !"audio/amr-wb".equals(str3) && !"audio/mp4a-latm".equals(str3) && !"audio/vorbis".equals(str3) && !"audio/opus".equals(str3) && !"audio/raw".equals(str3) && !"audio/flac".equals(str3) && !"audio/g711-alaw".equals(str3) && !"audio/g711-mlaw".equals(str3) && !"audio/gsm".equals(str3))) {
                            if ("audio/ac3".equals(str3)) {
                                i3 = 6;
                            } else if (!"audio/eac3".equals(str3)) {
                                i3 = 30;
                            }
                            Log.w("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str2 + ", [" + maxInputChannelCount + " to " + i3 + m2.i.e);
                            maxInputChannelCount = i3;
                        }
                        if (maxInputChannelCount < i6) {
                            a2.a("channelCount.support, " + i6);
                        }
                    }
                }
                i = 2;
                return i | i4 | 4;
            }
        }
        i = 3;
        return i | i4 | 4;
    }

    public m i() {
        return this.W.s;
    }

    public void p() {
        try {
            c cVar = this.W;
            cVar.h();
            for (b g : cVar.c) {
                g.g();
            }
            cVar.Z = 0;
            cVar.Y = false;
            try {
                super.p();
            } finally {
                this.T.ensureUpdated();
                this.V.disabled(this.T);
            }
        } catch (Throwable th) {
            super.p();
            throw th;
        } finally {
            this.T.ensureUpdated();
            this.V.disabled(this.T);
        }
    }

    public void r() {
        c cVar = this.W;
        cVar.Y = false;
        if (cVar.e()) {
            cVar.j();
            c.b bVar = cVar.g;
            if (bVar.g == -9223372036854775807L) {
                bVar.a.pause();
            }
        }
    }

    public void w() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        try {
            c cVar = this.W;
            if (cVar.X) {
                return;
            }
            if (cVar.e()) {
                if (cVar.a()) {
                    c.b bVar = cVar.g;
                    long c = cVar.c();
                    bVar.h = bVar.a();
                    bVar.g = SystemClock.elapsedRealtime() * 1000;
                    bVar.i = c;
                    bVar.a.stop();
                    cVar.w = 0;
                    cVar.X = true;
                }
            }
        } catch (c.h e) {
            throw com.fyber.inneractive.sdk.player.exoplayer2.d.a(e, this.c);
        }
    }

    public com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c cVar, i iVar, boolean z) throws d.b {
        String str = iVar.f;
        this.W.getClass();
        return cVar.a(iVar.f, z);
    }

    public void a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, i iVar, MediaCrypto mediaCrypto) {
        boolean z;
        String str = aVar.a;
        if (u.a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(u.c)) {
            String str2 = u.b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                z = true;
                this.X = z;
                mediaCodec.configure(iVar.a(), (Surface) null, (MediaCrypto) null, 0);
            }
        }
        z = false;
        this.X = z;
        mediaCodec.configure(iVar.a(), (Surface) null, (MediaCrypto) null, 0);
    }

    public void a(String str, long j, long j2) {
        this.V.decoderInitialized(str, j, j2);
    }

    public void a(i iVar) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        super.a(iVar);
        this.V.inputFormatChanged(iVar);
        this.Y = "audio/raw".equals(iVar.f) ? iVar.t : 2;
        this.Z = iVar.r;
    }

    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        int[] iArr;
        int i;
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.X || integer != 6 || (i = this.Z) >= 6) {
            iArr = null;
        } else {
            iArr = new int[i];
            for (int i2 = 0; i2 < this.Z; i2++) {
                iArr[i2] = i2;
            }
        }
        try {
            this.W.a("audio/raw", integer, integer2, this.Y, 0, iArr);
        } catch (c.d e) {
            throw com.fyber.inneractive.sdk.player.exoplayer2.d.a(e, this.c);
        }
    }

    public void a(long j, boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        super.a(j, z);
        this.W.h();
        this.a0 = j;
        this.b0 = true;
    }

    public m a(m mVar) {
        return this.W.a(mVar);
    }

    public boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.T.skippedOutputBufferCount++;
            c cVar = this.W;
            if (cVar.L == 1) {
                cVar.L = 2;
            }
            return true;
        }
        try {
            if (!this.W.a(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.T.renderedOutputBufferCount++;
            return true;
        } catch (c.e | c.h e) {
            throw com.fyber.inneractive.sdk.player.exoplayer2.d.a(e, this.c);
        }
    }

    public void a(boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.T = decoderCounters;
        this.V.enabled(decoderCounters);
        int i = this.b.a;
        boolean z2 = false;
        if (i != 0) {
            c cVar = this.W;
            cVar.getClass();
            if (u.a >= 21) {
                z2 = true;
            }
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z2);
            if (!cVar.a0 || cVar.Z != i) {
                cVar.a0 = true;
                cVar.Z = i;
                cVar.h();
                return;
            }
            return;
        }
        c cVar2 = this.W;
        if (cVar2.a0) {
            cVar2.a0 = false;
            cVar2.Z = 0;
            cVar2.h();
        }
    }

    public void a(int i, Object obj) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        if (i == 2) {
            c cVar = this.W;
            float floatValue = ((Float) obj).floatValue();
            if (cVar.P != floatValue) {
                cVar.P = floatValue;
                cVar.k();
            }
        } else if (i == 3) {
            int intValue = ((Integer) obj).intValue();
            c cVar2 = this.W;
            if (cVar2.n != intValue) {
                cVar2.n = intValue;
                if (!cVar2.a0) {
                    cVar2.h();
                    cVar2.Z = 0;
                }
            }
        }
    }
}
