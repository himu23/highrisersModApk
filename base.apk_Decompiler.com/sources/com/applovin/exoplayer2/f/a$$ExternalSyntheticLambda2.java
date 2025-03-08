package com.applovin.exoplayer2.f;

import android.media.MediaCodec;
import com.applovin.exoplayer2.f.g;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class a$$ExternalSyntheticLambda2 implements MediaCodec.OnFrameRenderedListener {
    public final /* synthetic */ a f$0;
    public final /* synthetic */ g.c f$1;

    public /* synthetic */ a$$ExternalSyntheticLambda2(a aVar, g.c cVar) {
        this.f$0 = aVar;
        this.f$1 = cVar;
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        this.f$0.a(this.f$1, mediaCodec, j, j2);
    }
}
