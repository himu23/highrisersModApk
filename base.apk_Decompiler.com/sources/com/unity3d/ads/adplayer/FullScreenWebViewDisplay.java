package com.unity3d.ads.adplayer;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0014J\b\u0010\u0014\u001a\u00020\u0006H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/unity3d/ads/adplayer/FullScreenWebViewDisplay;", "Landroidx/activity/ComponentActivity;", "()V", "opportunityId", "", "listenToAdPlayerEvents", "", "loadWebView", "webView", "Landroid/webkit/WebView;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FullScreenWebViewDisplay.kt */
public final class FullScreenWebViewDisplay extends ComponentActivity {
    /* access modifiers changed from: private */
    public String opportunityId = "";

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("opportunityId");
        if (stringExtra == null) {
            FullScreenWebViewDisplay fullScreenWebViewDisplay = this;
            setResult(0);
            finish();
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new FullScreenWebViewDisplay$onCreate$1$1(this, (Continuation<? super FullScreenWebViewDisplay$onCreate$1$1>) null), 3, (Object) null);
            return;
        }
        this.opportunityId = stringExtra;
        listenToAdPlayerEvents();
        Job unused2 = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new FullScreenWebViewDisplay$onCreate$2(this, (Continuation<? super FullScreenWebViewDisplay$onCreate$2>) null), 3, (Object) null);
    }

    private final void listenToAdPlayerEvents() {
        FlowKt.launchIn(FlowKt.onEach(new FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1(AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages(), this), new FullScreenWebViewDisplay$listenToAdPlayerEvents$2(this, (Continuation<? super FullScreenWebViewDisplay$listenToAdPlayerEvents$2>) null)), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* access modifiers changed from: private */
    public final void loadWebView(WebView webView) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new FullScreenWebViewDisplay$loadWebView$1(this, webView, (Continuation<? super FullScreenWebViewDisplay$loadWebView$1>) null), 3, (Object) null);
        Job unused2 = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new FullScreenWebViewDisplay$loadWebView$2(this, (Continuation<? super FullScreenWebViewDisplay$loadWebView$2>) null), 3, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new FullScreenWebViewDisplay$onResume$1(this, (Continuation<? super FullScreenWebViewDisplay$onResume$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new FullScreenWebViewDisplay$onPause$1(this, (Continuation<? super FullScreenWebViewDisplay$onPause$1>) null), 3, (Object) null);
    }
}
