package com.unity3d.ads.adplayer;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/unity3d/ads/adplayer/WebViewEvent;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: WebViewAdPlayer.kt */
final class WebViewAdPlayer$onBroadcastEvent$2 extends Lambda implements Function0<WebViewEvent> {
    final /* synthetic */ JSONObject $event;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewAdPlayer$onBroadcastEvent$2(JSONObject jSONObject) {
        super(0);
        this.$event = jSONObject;
    }

    public final WebViewEvent invoke() {
        String string = this.$event.getString("eventType");
        String optString = this.$event.optString("data");
        Intrinsics.checkNotNullExpressionValue(string, "eventType");
        return new OnBroadcastEvent(string, optString);
    }
}
