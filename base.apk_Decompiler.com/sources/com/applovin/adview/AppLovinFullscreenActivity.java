package com.applovin.adview;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.window.OnBackInvokedCallback;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.adview.activity.b.a;
import com.applovin.impl.adview.activity.b.e;
import com.applovin.impl.adview.l;
import com.applovin.impl.adview.q;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.ironsource.m2;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppLovinFullscreenActivity extends Activity implements l {
    public static q parentInterstitialWrapper;
    /* access modifiers changed from: private */
    public com.applovin.impl.adview.activity.b.a p;
    private final AtomicBoolean q = new AtomicBoolean(true);
    private com.applovin.impl.adview.activity.a r;
    private a s;
    private n sdk;
    private boolean t;

    public void setPresenter(com.applovin.impl.adview.activity.b.a aVar) {
        this.p = aVar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null || parentInterstitialWrapper != null) {
            try {
                requestWindowFeature(1);
            } catch (Throwable th) {
                x.e("AppLovinFullscreenActivity", "Failed to request window feature", th);
            }
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(16777216);
            getWindow().addFlags(128);
            View findViewById = findViewById(16908290);
            findViewById.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            String stringExtra = getIntent().getStringExtra("com.applovin.interstitial.sdk_key");
            if (TextUtils.isEmpty(stringExtra)) {
                q qVar = parentInterstitialWrapper;
                if (!(qVar == null || qVar.getCurrentAd() == null)) {
                    q.a(parentInterstitialWrapper.getCurrentAd(), parentInterstitialWrapper.rS(), "Empty SDK key", (Throwable) null, this);
                }
                finish();
                return;
            }
            n a2 = AppLovinSdk.getInstance(stringExtra, new AppLovinSdkSettings(this), this).a();
            this.sdk = a2;
            this.t = ((Boolean) a2.a(b.aNs)).booleanValue();
            findViewById.setFitsSystemWindows(true);
            com.applovin.impl.sdk.utils.b.a(this.t, this);
            if (h.Lf() && ((Boolean) this.sdk.a(b.aQz)).booleanValue()) {
                this.s = new a(new AppLovinFullscreenActivity$$ExternalSyntheticLambda1(this));
                getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.s);
            }
            q qVar2 = parentInterstitialWrapper;
            if (qVar2 != null) {
                com.applovin.impl.adview.activity.b.a.a(qVar2.getCurrentAd(), parentInterstitialWrapper.rU(), parentInterstitialWrapper.rS(), parentInterstitialWrapper.rT(), parentInterstitialWrapper.rR(), this.sdk, this, new a.C0062a() {
                    public void a(com.applovin.impl.adview.activity.b.a aVar) {
                        com.applovin.impl.adview.activity.b.a unused = AppLovinFullscreenActivity.this.p = aVar;
                        aVar.sA();
                    }

                    public void a(String str, Throwable th) {
                        q.a(AppLovinFullscreenActivity.parentInterstitialWrapper.getCurrentAd(), AppLovinFullscreenActivity.parentInterstitialWrapper.rS(), str, th, AppLovinFullscreenActivity.this);
                    }
                });
                return;
            }
            Intent intent = new Intent(this, FullscreenAdService.class);
            com.applovin.impl.adview.activity.a aVar = new com.applovin.impl.adview.activity.a(this, this.sdk);
            this.r = aVar;
            bindService(intent, aVar, 1);
            if (h.Lb()) {
                String str = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.DISABLE_SET_DATA_DIRECTORY_SUFFIX);
                if (!StringUtils.isValidString(str) || !Boolean.parseBoolean(str)) {
                    try {
                        WebView.setDataDirectorySuffix(String.valueOf(Process.myPid()));
                    } catch (Throwable unused) {
                    }
                }
            }
        } else {
            x.F("AppLovinFullscreenActivity", "Dismissing ad. Activity was destroyed while in background.");
            dismiss();
        }
    }

    public void dismiss() {
        if (h.Lf() && this.s != null) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.s);
            this.s = null;
        }
        com.applovin.impl.adview.activity.b.a aVar = this.p;
        if (aVar != null) {
            aVar.dismiss();
        } else {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        com.applovin.impl.adview.activity.b.a aVar;
        try {
            super.onResume();
            if (!this.q.get() && (aVar = this.p) != null) {
                aVar.onResume();
            }
        } catch (IllegalArgumentException e) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().c("AppLovinFullscreenActivity", "Error was encountered in onResume().", e);
            }
            this.sdk.Cs().d("AppLovinFullscreenActivity", m2.h.u0, e);
            dismiss();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (this.p != null) {
            if (!this.q.getAndSet(false) || (this.p instanceof e)) {
                this.p.onWindowFocusChanged(z);
            }
            if (z) {
                com.applovin.impl.sdk.utils.b.a(this.t, this);
            }
        }
        super.onWindowFocusChanged(z);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        com.applovin.impl.adview.activity.b.a aVar = this.p;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.applovin.impl.adview.activity.b.a aVar = this.p;
        if (aVar != null) {
            aVar.onConfigurationChanged(configuration);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.applovin.impl.adview.activity.b.a aVar = this.p;
        if (aVar != null) {
            aVar.a(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        com.applovin.impl.adview.activity.b.a aVar = this.p;
        if (aVar != null) {
            aVar.onStop();
        }
    }

    public void onBackPressed() {
        onBackInvoked();
    }

    /* access modifiers changed from: private */
    public void onBackInvoked() {
        com.applovin.impl.adview.activity.b.a aVar = this.p;
        if (aVar != null) {
            aVar.onBackPressed();
        }
        if (u.ah(getApplicationContext())) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        parentInterstitialWrapper = null;
        com.applovin.impl.adview.activity.a aVar = this.r;
        if (aVar != null) {
            try {
                unbindService(aVar);
            } catch (Throwable unused) {
            }
        }
        com.applovin.impl.adview.activity.b.a aVar2 = this.p;
        if (aVar2 != null) {
            if (!aVar2.sB()) {
                this.p.dismiss();
            }
            this.p.onDestroy();
        }
        super.onDestroy();
    }

    private static class a implements OnBackInvokedCallback {
        private final Runnable v;

        protected a(Runnable runnable) {
            this.v = runnable;
        }

        public void onBackInvoked() {
            this.v.run();
        }
    }
}
