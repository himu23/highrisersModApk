package com.unity3d.ads.adplayer;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/unity3d/ads/adplayer/WebViewEvent;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: WebViewAdPlayer.kt */
final class WebViewAdPlayer$sendVolumeChange$2 extends Lambda implements Function0<WebViewEvent> {
    final /* synthetic */ double $volume;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewAdPlayer$sendVolumeChange$2(double d) {
        super(0);
        this.$volume = d;
    }

    public final WebViewEvent invoke() {
        return new OnVolumeChangeEvent(this.$volume);
    }
}
