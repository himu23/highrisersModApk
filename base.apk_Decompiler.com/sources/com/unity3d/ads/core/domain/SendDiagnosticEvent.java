package com.unity3d.ads.core.domain;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJU\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH¦Bø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "", "invoke", "", "event", "", "value", "", "tags", "", "intTags", "", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SendDiagnosticEvent.kt */
public interface SendDiagnosticEvent {
    public static final String AD_LOAD_TYPE = "type";
    public static final String BRIDGE_SEND_EVENT_FAILED = "bridge_send_event_failed";
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String INIT_FAILURE = "native_initialize_task_failure_time";
    public static final String INIT_STARTED = "native_initialization_started";
    public static final String INIT_SUCCESS = "native_initialize_task_success_time";
    public static final String LOAD_FAILURE = "native_load_failure_time";
    public static final String LOAD_STARTED = "native_load_started";
    public static final String LOAD_SUCCESS = "native_load_success_time";
    public static final String LOAD_TIMEOUT = "native_load_timeout";
    public static final String NETWORK_CLIENT = "network_client";
    public static final String NETWORK_FAILURE = "native_network_failure_time";
    public static final String NETWORK_SUCCESS = "native_network_success_time";
    public static final String OPERATION = "operation";
    public static final String PROTOCOL = "protocol";
    public static final String REASON = "reason";
    public static final String REASON_ALREADY_SHOWING = "already_showing";
    public static final String REASON_GATEWAY = "gateway";
    public static final String REASON_INIT_FAILED = "init_failed";
    public static final String REASON_INTERNAL = "internal";
    public static final String REASON_INVALID = "invalid";
    public static final String REASON_NETWORK = "network";
    public static final String REASON_NOT_READY = "not_ready";
    public static final String REASON_NO_CONNECTION = "no_connection";
    public static final String REASON_NO_FILL = "no_fill";
    public static final String REASON_TIMEOUT = "timeout";
    public static final String REASON_UNKNOWN = "unknown";
    public static final String REASON_VIDEO_PLAYER = "player";
    public static final String RETRIES = "retries";
    public static final String SHOW_CANCEL_TIMEOUT = "native_show_cancel_timeout";
    public static final String SHOW_CLICKED = "native_show_clicked";
    public static final String SHOW_FAILURE = "native_show_failure_time";
    public static final String SHOW_STARTED = "native_show_started";
    public static final String SHOW_SUCCESS = "native_show_success_time";
    public static final String SHOW_WV_STARTED = "native_show_wv_started";
    public static final String SYSTEM_CRONET_FAILURE = "native_cronet_failure_time";
    public static final String SYSTEM_CRONET_SUCCESS = "native_cronet_success_time";
    public static final String UNKNOWN = "unknown";
    public static final String WEBVIEW_ERROR = "webview_error";
    public static final String WEBVIEW_ERROR_CODE = "webview_error_code";
    public static final String WEBVIEW_URL = "webview_url";

    Object invoke(String str, Long l, Map<String, String> map, Map<String, Integer> map2, Continuation<? super Unit> continuation);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SendDiagnosticEvent.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object invoke$default(SendDiagnosticEvent sendDiagnosticEvent, String str, Long l, Map map, Map map2, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                return sendDiagnosticEvent.invoke(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : map2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b(\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/unity3d/ads/core/domain/SendDiagnosticEvent$Companion;", "", "()V", "AD_LOAD_TYPE", "", "BRIDGE_SEND_EVENT_FAILED", "INIT_FAILURE", "INIT_STARTED", "INIT_SUCCESS", "LOAD_FAILURE", "LOAD_STARTED", "LOAD_SUCCESS", "LOAD_TIMEOUT", "NETWORK_CLIENT", "NETWORK_FAILURE", "NETWORK_SUCCESS", "OPERATION", "PROTOCOL", "REASON", "REASON_ALREADY_SHOWING", "REASON_GATEWAY", "REASON_INIT_FAILED", "REASON_INTERNAL", "REASON_INVALID", "REASON_NETWORK", "REASON_NOT_READY", "REASON_NO_CONNECTION", "REASON_NO_FILL", "REASON_TIMEOUT", "REASON_UNKNOWN", "REASON_VIDEO_PLAYER", "RETRIES", "SHOW_CANCEL_TIMEOUT", "SHOW_CLICKED", "SHOW_FAILURE", "SHOW_STARTED", "SHOW_SUCCESS", "SHOW_WV_STARTED", "SYSTEM_CRONET_FAILURE", "SYSTEM_CRONET_SUCCESS", "UNKNOWN", "WEBVIEW_ERROR", "WEBVIEW_ERROR_CODE", "WEBVIEW_URL", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SendDiagnosticEvent.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String AD_LOAD_TYPE = "type";
        public static final String BRIDGE_SEND_EVENT_FAILED = "bridge_send_event_failed";
        public static final String INIT_FAILURE = "native_initialize_task_failure_time";
        public static final String INIT_STARTED = "native_initialization_started";
        public static final String INIT_SUCCESS = "native_initialize_task_success_time";
        public static final String LOAD_FAILURE = "native_load_failure_time";
        public static final String LOAD_STARTED = "native_load_started";
        public static final String LOAD_SUCCESS = "native_load_success_time";
        public static final String LOAD_TIMEOUT = "native_load_timeout";
        public static final String NETWORK_CLIENT = "network_client";
        public static final String NETWORK_FAILURE = "native_network_failure_time";
        public static final String NETWORK_SUCCESS = "native_network_success_time";
        public static final String OPERATION = "operation";
        public static final String PROTOCOL = "protocol";
        public static final String REASON = "reason";
        public static final String REASON_ALREADY_SHOWING = "already_showing";
        public static final String REASON_GATEWAY = "gateway";
        public static final String REASON_INIT_FAILED = "init_failed";
        public static final String REASON_INTERNAL = "internal";
        public static final String REASON_INVALID = "invalid";
        public static final String REASON_NETWORK = "network";
        public static final String REASON_NOT_READY = "not_ready";
        public static final String REASON_NO_CONNECTION = "no_connection";
        public static final String REASON_NO_FILL = "no_fill";
        public static final String REASON_TIMEOUT = "timeout";
        public static final String REASON_UNKNOWN = "unknown";
        public static final String REASON_VIDEO_PLAYER = "player";
        public static final String RETRIES = "retries";
        public static final String SHOW_CANCEL_TIMEOUT = "native_show_cancel_timeout";
        public static final String SHOW_CLICKED = "native_show_clicked";
        public static final String SHOW_FAILURE = "native_show_failure_time";
        public static final String SHOW_STARTED = "native_show_started";
        public static final String SHOW_SUCCESS = "native_show_success_time";
        public static final String SHOW_WV_STARTED = "native_show_wv_started";
        public static final String SYSTEM_CRONET_FAILURE = "native_cronet_failure_time";
        public static final String SYSTEM_CRONET_SUCCESS = "native_cronet_success_time";
        public static final String UNKNOWN = "unknown";
        public static final String WEBVIEW_ERROR = "webview_error";
        public static final String WEBVIEW_ERROR_CODE = "webview_error_code";
        public static final String WEBVIEW_URL = "webview_url";

        private Companion() {
        }
    }
}
