package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.l;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.a;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.u;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinUserService;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class m implements l.a, AppLovinWebViewActivity.EventListener {
    /* access modifiers changed from: private */
    public static final AtomicBoolean aAw = new AtomicBoolean();
    /* access modifiers changed from: private */
    public static WeakReference<AppLovinWebViewActivity> aAx;
    private AtomicBoolean aAA = new AtomicBoolean();
    private AppLovinUserService.OnConsentDialogDismissListener aAy;
    private l aAz;
    private a aiO;
    /* access modifiers changed from: private */
    public WeakReference<Activity> aiy = new WeakReference<>((Object) null);
    private final x logger;
    /* access modifiers changed from: private */
    public final n sdk;

    public void Bf() {
    }

    m(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
        if (nVar.BK() != null) {
            this.aiy = new WeakReference<>(nVar.BK());
        }
        n.E(n.getApplicationContext()).a(new a() {
            public void onActivityStarted(Activity activity) {
                WeakReference unused = m.this.aiy = new WeakReference(activity);
            }
        });
        this.aAz = new l(this, nVar);
    }

    public void preloadConsentDialog() {
        if (!this.aAA.getAndSet(true)) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda3(this, (String) this.sdk.a(b.aKT)));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void cy(String str) {
        WebView a = u.a(n.getApplicationContext(), "preloading consent dialog", true);
        if (a != null) {
            a.loadUrl(str);
        }
    }

    public void a(Activity activity, AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        activity.runOnUiThread(new m$$ExternalSyntheticLambda1(this, onConsentDialogDismissListener, activity));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener, Activity activity) {
        if (p(this.sdk) && !aAw.getAndSet(true)) {
            this.aiy = new WeakReference<>(activity);
            this.aAy = onConsentDialogDismissListener;
            this.aiO = new a() {
                public void onActivityStarted(Activity activity) {
                    if (activity instanceof AppLovinWebViewActivity) {
                        if (!m.this.Bg() || m.aAx.get() != activity) {
                            AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) activity;
                            WeakReference unused = m.aAx = new WeakReference(appLovinWebViewActivity);
                            appLovinWebViewActivity.loadUrl((String) m.this.sdk.a(b.aKT), m.this);
                        }
                        m.aAw.set(false);
                    }
                }
            };
            this.sdk.BM().a(this.aiO);
            Intent intent = new Intent(activity, AppLovinWebViewActivity.class);
            intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
            intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, (Serializable) this.sdk.a(b.aKU));
            activity.startActivity(intent);
        } else if (onConsentDialogDismissListener != null) {
            onConsentDialogDismissListener.onDismiss();
        }
    }

    public void bL(long j) {
        AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda2(this, j));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bM(long j) {
        if (x.Fn()) {
            this.logger.f("ConsentDialogManager", "Scheduling repeating consent alert");
        }
        this.aAz.a(j, this.sdk, (l.a) this);
    }

    public void onReceivedEvent(String str) {
        if ("accepted".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(true, n.getApplicationContext());
            Bh();
        } else if ("rejected".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(false, n.getApplicationContext());
            f(((Boolean) this.sdk.a(b.aKW)).booleanValue(), ((Long) this.sdk.a(b.aLb)).longValue());
        } else if ("closed".equalsIgnoreCase(str)) {
            f(((Boolean) this.sdk.a(b.aKX)).booleanValue(), ((Long) this.sdk.a(b.aLc)).longValue());
        } else if (AppLovinWebViewActivity.EVENT_DISMISSED_VIA_BACK_BUTTON.equalsIgnoreCase(str)) {
            f(((Boolean) this.sdk.a(b.aKY)).booleanValue(), ((Long) this.sdk.a(b.aLd)).longValue());
        }
    }

    private void f(boolean z, long j) {
        Bh();
        if (z) {
            bL(j);
        }
    }

    public void Be() {
        Activity activity = (Activity) this.aiy.get();
        if (activity != null) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new m$$ExternalSyntheticLambda0(this, activity), ((Long) this.sdk.a(b.aKV)).longValue());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(Activity activity) {
        a(activity, (AppLovinUserService.OnConsentDialogDismissListener) null);
    }

    /* access modifiers changed from: package-private */
    public boolean Bg() {
        WeakReference<AppLovinWebViewActivity> weakReference = aAx;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private boolean p(n nVar) {
        if (Bg()) {
            x.H("AppLovinSdk", "Consent dialog already showing");
            return false;
        } else if (!i.aa(n.getApplicationContext())) {
            x.H("AppLovinSdk", "No internet available, skip showing of consent dialog");
            return false;
        } else if (!((Boolean) nVar.a(b.aKS)).booleanValue()) {
            if (x.Fn()) {
                this.logger.i("ConsentDialogManager", "Blocked publisher from showing consent dialog");
            }
            return false;
        } else if (StringUtils.isValidString((String) nVar.a(b.aKT))) {
            return true;
        } else {
            if (x.Fn()) {
                this.logger.i("ConsentDialogManager", "AdServer returned empty consent dialog URL");
            }
            return false;
        }
    }

    private void Bh() {
        this.sdk.BM().b(this.aiO);
        if (Bg()) {
            AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) aAx.get();
            aAx = null;
            if (appLovinWebViewActivity != null) {
                appLovinWebViewActivity.finish();
                AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener = this.aAy;
                if (onConsentDialogDismissListener != null) {
                    onConsentDialogDismissListener.onDismiss();
                    this.aAy = null;
                }
            }
        }
    }
}
