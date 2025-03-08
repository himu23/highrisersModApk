package com.unity3d.services.core.webview;

import com.unity3d.services.core.request.metrics.Metric;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0006\u0010\u0004\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"webMessageListenerDisabledMetric", "Lcom/unity3d/services/core/request/metrics/Metric;", "webMessageListenerEnabledMetric", "webMessageListenerSupportedMetric", "webMessageListenerUnsupportedMetric", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: WebViewMetric.kt */
public final class WebViewMetricKt {
    public static final Metric webMessageListenerSupportedMetric() {
        return new Metric("web_message_listener_supported", (Object) null, (Map) null, 6, (DefaultConstructorMarker) null);
    }

    public static final Metric webMessageListenerUnsupportedMetric() {
        return new Metric("web_message_listener_unsupported", (Object) null, (Map) null, 6, (DefaultConstructorMarker) null);
    }

    public static final Metric webMessageListenerDisabledMetric() {
        return new Metric("web_message_listener_disabled", (Object) null, (Map) null, 6, (DefaultConstructorMarker) null);
    }

    public static final Metric webMessageListenerEnabledMetric() {
        return new Metric("web_message_listener_enabled", (Object) null, (Map) null, 6, (DefaultConstructorMarker) null);
    }
}
