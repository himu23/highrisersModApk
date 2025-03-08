package com.fyber.inneractive.sdk.player.exoplayer2.decoder;

import android.media.MediaCodec;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.ironsource.g$$ExternalSyntheticApiModelOutline0;

public final class a {
    public byte[] a;
    public byte[] b;
    public int c;
    public int[] d;
    public int[] e;
    public int f;
    public final MediaCodec.CryptoInfo g;
    public final b h;

    public static final class b {
        public final MediaCodec.CryptoInfo a;
        public final MediaCodec.CryptoInfo.Pattern b;

        public b(MediaCodec.CryptoInfo cryptoInfo) {
            this.a = cryptoInfo;
            this.b = g$$ExternalSyntheticApiModelOutline0.m(0, 0);
        }
    }

    public a() {
        int i = u.a;
        b bVar = null;
        MediaCodec.CryptoInfo a2 = i >= 16 ? a() : null;
        this.g = a2;
        this.h = i >= 24 ? new b(a2) : bVar;
    }

    public final MediaCodec.CryptoInfo a() {
        return new MediaCodec.CryptoInfo();
    }
}
