package com.unity3d.ads.adplayer;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b,\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.¨\u0006/"}, d2 = {"Lcom/unity3d/ads/adplayer/ExposedFunctionLocation;", "", "location", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getLocation", "()Ljava/lang/String;", "GET_AD_CONTEXT", "OPEN_AD_UNIT", "GET_SCREEN_HEIGHT", "GET_SCREEN_WIDTH", "GET_CONNECTION_TYPE", "GET_DEVICE_VOLUME", "GET_DEVICE_MAX_VOLUME", "LOAD_COMPLETE", "UPDATE_CAMPAIGN_STATE", "MARK_CAMPAIGN_STATE_SHOWN", "LOAD_ERROR", "SEND_OPERATIVE_EVENT", "OPEN_URL", "CANCEL_SHOW_TIMEOUT", "STARTED", "CLICKED", "COMPLETED", "FAILED", "STORAGE_READ", "STORAGE_WRITE", "STORAGE_CLEAR", "STORAGE_DELETE", "STORAGE_GET_KEYS", "STORAGE_GET", "STORAGE_SET", "GET_SESSION_TOKEN", "GET_PRIVACY_FSM", "SET_PRIVACY_FSM", "SET_PRIVACY", "GET_PRIVACY", "BROADCAST_EVENT", "GET_ALLOWED_PII", "SET_ALLOWED_PII", "REFRESH_AD_DATA", "UPDATE_TRACKING_TOKEN", "REQUEST_GET", "REQUEST_POST", "REQUEST_HEAD", "SEND_PRIVACY_UPDATE_REQUEST", "SEND_DIAGNOSTIC_EVENT", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedFunctionLocation.kt */
public enum ExposedFunctionLocation {
    GET_AD_CONTEXT("com.unity3d.services.ads.api.AdViewer.getAdContext"),
    OPEN_AD_UNIT("com.unity3d.services.ads.api.AdUnit.open"),
    GET_SCREEN_HEIGHT("com.unity3d.services.core.api.DeviceInfo.getScreenHeight"),
    GET_SCREEN_WIDTH("com.unity3d.services.core.api.DeviceInfo.getScreenWidth"),
    GET_CONNECTION_TYPE("com.unity3d.services.core.api.DeviceInfo.getConnectionType"),
    GET_DEVICE_VOLUME("com.unity3d.services.core.api.DeviceInfo.getDeviceVolume"),
    GET_DEVICE_MAX_VOLUME("com.unity3d.services.core.api.DeviceInfo.getDeviceMaxVolume"),
    LOAD_COMPLETE("com.unity3d.services.ads.api.AdViewer.loadComplete"),
    UPDATE_CAMPAIGN_STATE("com.unity3d.services.ads.api.AdViewer.updateCampaignState"),
    MARK_CAMPAIGN_STATE_SHOWN("com.unity3d.services.ads.api.AdViewer.markCampaignStateAsShown"),
    LOAD_ERROR("com.unity3d.services.ads.api.AdViewer.loadError"),
    SEND_OPERATIVE_EVENT("com.unity3d.services.ads.api.AdViewer.sendOperativeEvent"),
    OPEN_URL("com.unity3d.services.ads.api.AdViewer.openUrl"),
    CANCEL_SHOW_TIMEOUT("com.unity3d.services.ads.api.AdViewer.cancelShowTimeout"),
    STARTED("com.unity3d.services.ads.api.AdViewer.started"),
    CLICKED("com.unity3d.services.ads.api.AdViewer.clicked"),
    COMPLETED("com.unity3d.services.ads.api.AdViewer.completed"),
    FAILED("com.unity3d.services.ads.api.AdViewer.failed"),
    STORAGE_READ("com.unity3d.services.core.api.Storage.read"),
    STORAGE_WRITE("com.unity3d.services.core.api.Storage.write"),
    STORAGE_CLEAR("com.unity3d.services.core.api.Storage.clear"),
    STORAGE_DELETE("com.unity3d.services.core.api.Storage.delete"),
    STORAGE_GET_KEYS("com.unity3d.services.core.api.Storage.getKeys"),
    STORAGE_GET("com.unity3d.services.core.api.Storage.get"),
    STORAGE_SET("com.unity3d.services.core.api.Storage.set"),
    GET_SESSION_TOKEN("com.unity3d.services.ads.api.AdViewer.getSessionToken"),
    GET_PRIVACY_FSM("com.unity3d.services.ads.api.AdViewer.getPrivacyFsm"),
    SET_PRIVACY_FSM("com.unity3d.services.ads.api.AdViewer.setPrivacyFsm"),
    SET_PRIVACY("com.unity3d.services.ads.api.AdViewer.setPrivacyPayload"),
    GET_PRIVACY("com.unity3d.services.ads.api.AdViewer.getPrivacyPayload"),
    BROADCAST_EVENT("com.unity3d.services.ads.api.AdViewer.broadcastEvent"),
    GET_ALLOWED_PII("com.unity3d.services.ads.api.AdViewer.getPrivacyAllowedPii"),
    SET_ALLOWED_PII("com.unity3d.services.ads.api.AdViewer.setPrivacyAllowedPii"),
    REFRESH_AD_DATA("com.unity3d.services.ads.api.AdViewer.refreshAdData"),
    UPDATE_TRACKING_TOKEN("com.unity3d.services.ads.api.AdViewer.updateTrackingToken"),
    REQUEST_GET("com.unity3d.services.core.api.Request.get"),
    REQUEST_POST("com.unity3d.services.core.api.Request.post"),
    REQUEST_HEAD("com.unity3d.services.core.api.Request.head"),
    SEND_PRIVACY_UPDATE_REQUEST("com.unity3d.services.ads.api.AdViewer.sendPrivacyUpdateRequest"),
    SEND_DIAGNOSTIC_EVENT("com.unity3d.services.ads.api.AdViewer.sendDiagnosticEvent");
    
    private final String location;

    public final String getLocation() {
        return this.location;
    }

    private ExposedFunctionLocation(String str) {
        this.location = str;
    }
}
