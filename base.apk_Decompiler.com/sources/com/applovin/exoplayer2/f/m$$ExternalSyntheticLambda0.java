package com.applovin.exoplayer2.f;

import android.media.MediaCodec;
import com.applovin.exoplayer2.f.g;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class m$$ExternalSyntheticLambda0 implements MediaCodec.OnFrameRenderedListener {
    public final /* synthetic */ m f$0;
    public final /* synthetic */ g.c f$1;

    public /* synthetic */ m$$ExternalSyntheticLambda0(m mVar, g.c cVar) {
        this.f$0 = mVar;
        this.f$1 = cVar;
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        this.f$0.a(this.f$1, mediaCodec, j, j2);
    }
}
