package com.applovin.impl.privacy.cmp;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.privacy.a.d;
import com.applovin.impl.privacy.cmp.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinCmpService;
import com.applovin.sdk.AppLovinSdkUtils;

public class CmpServiceImpl implements b.a, AppLovinCmpService {
    /* access modifiers changed from: private */
    public final a axw;
    /* access modifiers changed from: private */
    public b axx = zR();
    private a axy;
    private b axz;
    private final n sdk;

    public interface a {
        void c(AppLovinCmpError appLovinCmpError);
    }

    public interface b {
        void d(AppLovinCmpError appLovinCmpError);
    }

    public boolean hasSupportedCmp() {
        return this.axx != null;
    }

    public String toString() {
        return "[CmpService]";
    }

    public CmpServiceImpl(n nVar) {
        this.sdk = nVar;
        this.axw = new a(nVar.Cl().getDebugUserGeography());
    }

    public void showCmpForExistingUser(final Activity activity, final AppLovinCmpService.OnCompletedListener onCompletedListener) {
        this.sdk.BN();
        if (x.Fn()) {
            x BN = this.sdk.BN();
            BN.f("AppLovinCmpService", "showCmpForExistingUser(activity=" + activity + ", completedListener=" + onCompletedListener + ")");
        }
        if (!hasSupportedCmp()) {
            onCompletedListener.onCompleted(new CmpErrorImpl(AppLovinCmpError.Code.INTEGRATION_ERROR, "A supported CMP is not integrated"));
            return;
        }
        zS();
        loadCmp(activity, new a() {
            public void c(AppLovinCmpError appLovinCmpError) {
                if (appLovinCmpError != null) {
                    onCompletedListener.onCompleted(appLovinCmpError);
                } else {
                    CmpServiceImpl.this.showCmp(activity, new b() {
                        public void d(AppLovinCmpError appLovinCmpError) {
                            onCompletedListener.onCompleted(appLovinCmpError);
                        }
                    });
                }
            }
        });
    }

    public void loadCmp(final Activity activity, a aVar) {
        if (!hasSupportedCmp()) {
            aVar.c(new CmpErrorImpl(AppLovinCmpError.Code.INTEGRATION_ERROR, "A supported CMP is not integrated"));
            return;
        }
        this.axy = aVar;
        AnonymousClass2 r4 = new Runnable() {
            public void run() {
                CmpServiceImpl.this.axx.a(activity, CmpServiceImpl.this.axw, (b.a) CmpServiceImpl.this);
            }
        };
        if (this.axx.zU()) {
            AppLovinSdkUtils.runOnUiThread(r4);
        } else {
            r4.run();
        }
    }

    public void showCmp(final Activity activity, b bVar) {
        AnonymousClass3 r0 = new Runnable() {
            public void run() {
                CmpServiceImpl.this.axx.b(activity, CmpServiceImpl.this.axw, CmpServiceImpl.this);
            }
        };
        this.axz = bVar;
        if (this.axx.zV()) {
            AppLovinSdkUtils.runOnUiThread(r0);
        } else {
            r0.run();
        }
    }

    public void onFlowLoaded(Bundle bundle) {
        a((AppLovinCmpError) null);
    }

    public void onFlowLoadFailed(CmpErrorImpl cmpErrorImpl) {
        a((AppLovinCmpError) cmpErrorImpl);
        zT();
    }

    public void onFlowShowFailed(CmpErrorImpl cmpErrorImpl) {
        b((AppLovinCmpError) cmpErrorImpl);
        zT();
    }

    public void onFlowHidden(Bundle bundle) {
        b((AppLovinCmpError) null);
        zT();
    }

    private void a(AppLovinCmpError appLovinCmpError) {
        a aVar = this.axy;
        if (aVar != null) {
            aVar.c(appLovinCmpError);
            this.axy = null;
        }
    }

    private void b(AppLovinCmpError appLovinCmpError) {
        b bVar = this.axz;
        if (bVar != null) {
            bVar.d(appLovinCmpError);
            this.axz = null;
        }
    }

    private b zR() {
        if (u.dE("com.google.android.ump.ConsentForm")) {
            return new b(this.sdk);
        }
        if (!this.sdk.Cl().isEnabled() || this.sdk.Cl().zX() != d.a.UNIFIED) {
            return null;
        }
        x.H("AppLovinSdk", "Could not load Google UMP. Please add the Google User Messaging Platform SDK into your application. Instructions can be found here: https://dash.applovin.com/documentation/mediation/android/getting-started/terms-and-privacy-policy-flow#enabling-google-ump");
        return null;
    }

    private void zS() {
        if (hasSupportedCmp()) {
            this.axx.zS();
        }
    }

    private void zT() {
        b bVar = this.axx;
        if (bVar != null) {
            bVar.destroy();
        }
    }
}
