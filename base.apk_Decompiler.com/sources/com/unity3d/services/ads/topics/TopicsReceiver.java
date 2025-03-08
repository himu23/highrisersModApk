package com.unity3d.services.ads.topics;

import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.os.OutcomeReceiver;
import com.ironsource.g$$ExternalSyntheticApiModelOutline0;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0003j\u0002`\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/unity3d/services/ads/topics/TopicsReceiver;", "Landroid/os/OutcomeReceiver;", "Landroid/adservices/topics/GetTopicsResponse;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "eventSender", "Lcom/unity3d/services/core/webview/bridge/IEventSender;", "(Lcom/unity3d/services/core/webview/bridge/IEventSender;)V", "formatTopic", "Lorg/json/JSONObject;", "topic", "Landroid/adservices/topics/Topic;", "onError", "", "error", "onResult", "result", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TopicsReceiver.kt */
public final class TopicsReceiver implements OutcomeReceiver<GetTopicsResponse, Exception> {
    private final IEventSender eventSender;

    public TopicsReceiver(IEventSender iEventSender) {
        Intrinsics.checkNotNullParameter(iEventSender, "eventSender");
        this.eventSender = iEventSender;
    }

    public /* bridge */ /* synthetic */ void onResult(Object obj) {
        onResult(g$$ExternalSyntheticApiModelOutline0.m(obj));
    }

    public void onResult(GetTopicsResponse getTopicsResponse) {
        Intrinsics.checkNotNullParameter(getTopicsResponse, "result");
        JSONArray jSONArray = new JSONArray();
        List<Object> m = getTopicsResponse.getTopics();
        Intrinsics.checkNotNullExpressionValue(m, "result.topics");
        for (Object m2 : m) {
            Topic m3 = g$$ExternalSyntheticApiModelOutline0.m(m2);
            Intrinsics.checkNotNullExpressionValue(m3, "it");
            jSONArray.put(formatTopic(m3));
        }
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "resultArray.toString()");
        this.eventSender.sendEvent(WebViewEventCategory.TOPICS, TopicsEvents.TOPICS_AVAILABLE, jSONArray2);
    }

    public void onError(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "error");
        DeviceLog.debug("GetTopics exception: " + exc);
        this.eventSender.sendEvent(WebViewEventCategory.TOPICS, TopicsEvents.NOT_AVAILABLE, TopicsErrors.ERROR_EXCEPTION, exc.toString());
    }

    public final JSONObject formatTopic(Topic topic) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("taxonomyVersion", topic.getTaxonomyVersion());
        jSONObject.put("modelVersion", g$$ExternalSyntheticApiModelOutline0.m(topic));
        jSONObject.put("topicId", g$$ExternalSyntheticApiModelOutline0.m(topic));
        return jSONObject;
    }
}
