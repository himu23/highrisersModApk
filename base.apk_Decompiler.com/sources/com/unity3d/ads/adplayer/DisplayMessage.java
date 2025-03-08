package com.unity3d.ads.adplayer;

import android.webkit.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/unity3d/ads/adplayer/DisplayMessage;", "", "opportunityId", "", "(Ljava/lang/String;)V", "getOpportunityId", "()Ljava/lang/String;", "DisplayError", "DisplayFinishRequest", "DisplayReady", "VisibilityChanged", "WebViewInstanceRequest", "WebViewInstanceResponse", "Lcom/unity3d/ads/adplayer/DisplayMessage$DisplayError;", "Lcom/unity3d/ads/adplayer/DisplayMessage$DisplayFinishRequest;", "Lcom/unity3d/ads/adplayer/DisplayMessage$DisplayReady;", "Lcom/unity3d/ads/adplayer/DisplayMessage$VisibilityChanged;", "Lcom/unity3d/ads/adplayer/DisplayMessage$WebViewInstanceRequest;", "Lcom/unity3d/ads/adplayer/DisplayMessage$WebViewInstanceResponse;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DisplayMessage.kt */
public abstract class DisplayMessage {
    private final String opportunityId;

    public /* synthetic */ DisplayMessage(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String getOpportunityId() {
        return this.opportunityId;
    }

    private DisplayMessage(String str) {
        this.opportunityId = str;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/unity3d/ads/adplayer/DisplayMessage$DisplayReady;", "Lcom/unity3d/ads/adplayer/DisplayMessage;", "opportunityId", "", "(Ljava/lang/String;)V", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DisplayMessage.kt */
    public static final class DisplayReady extends DisplayMessage {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DisplayReady(String str) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "opportunityId");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/unity3d/ads/adplayer/DisplayMessage$WebViewInstanceRequest;", "Lcom/unity3d/ads/adplayer/DisplayMessage;", "opportunityId", "", "(Ljava/lang/String;)V", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DisplayMessage.kt */
    public static final class WebViewInstanceRequest extends DisplayMessage {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WebViewInstanceRequest(String str) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "opportunityId");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/unity3d/ads/adplayer/DisplayMessage$VisibilityChanged;", "Lcom/unity3d/ads/adplayer/DisplayMessage;", "opportunityId", "", "isVisible", "", "(Ljava/lang/String;Z)V", "()Z", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DisplayMessage.kt */
    public static final class VisibilityChanged extends DisplayMessage {
        private final boolean isVisible;

        public final boolean isVisible() {
            return this.isVisible;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VisibilityChanged(String str, boolean z) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "opportunityId");
            this.isVisible = z;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/unity3d/ads/adplayer/DisplayMessage$DisplayError;", "Lcom/unity3d/ads/adplayer/DisplayMessage;", "opportunityId", "", "reason", "(Ljava/lang/String;Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DisplayMessage.kt */
    public static final class DisplayError extends DisplayMessage {
        private final String reason;

        public final String getReason() {
            return this.reason;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DisplayError(String str, String str2) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "opportunityId");
            Intrinsics.checkNotNullParameter(str2, "reason");
            this.reason = str2;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/unity3d/ads/adplayer/DisplayMessage$WebViewInstanceResponse;", "Lcom/unity3d/ads/adplayer/DisplayMessage;", "opportunityId", "", "webView", "Landroid/webkit/WebView;", "(Ljava/lang/String;Landroid/webkit/WebView;)V", "getWebView", "()Landroid/webkit/WebView;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DisplayMessage.kt */
    public static final class WebViewInstanceResponse extends DisplayMessage {
        private final WebView webView;

        public final WebView getWebView() {
            return this.webView;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WebViewInstanceResponse(String str, WebView webView2) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "opportunityId");
            Intrinsics.checkNotNullParameter(webView2, "webView");
            this.webView = webView2;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/unity3d/ads/adplayer/DisplayMessage$DisplayFinishRequest;", "Lcom/unity3d/ads/adplayer/DisplayMessage;", "opportunityId", "", "(Ljava/lang/String;)V", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DisplayMessage.kt */
    public static final class DisplayFinishRequest extends DisplayMessage {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DisplayFinishRequest(String str) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "opportunityId");
        }
    }
}
