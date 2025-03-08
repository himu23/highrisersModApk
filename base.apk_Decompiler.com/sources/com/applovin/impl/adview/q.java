package com.applovin.impl.adview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.adview.AppLovinFullscreenAdViewObserver;
import com.applovin.adview.AppLovinFullscreenThemedActivity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.adview.activity.b.a;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.ad.h;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.d.f;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.drive.DriveFile;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class q implements AppLovinInterstitialAdDialog {
    /* access modifiers changed from: private */
    public volatile AppLovinAdDisplayListener agA;
    private volatile AppLovinAdClickListener agC;
    private volatile AppLovinAdVideoPlaybackListener agR;
    private final Map<String, Object> agg = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */
    public volatile e agq;
    private volatile AppLovinAdLoadListener agz;
    private final WeakReference<Context> ahT;
    protected final n sdk;

    public e getCurrentAd() {
        return this.agq;
    }

    public void rO() {
        this.agC = null;
        this.agz = null;
        this.agR = null;
        this.agA = null;
    }

    public Map<String, Object> rR() {
        return this.agg;
    }

    public AppLovinAdDisplayListener rS() {
        return this.agA;
    }

    public AppLovinAdVideoPlaybackListener rT() {
        return this.agR;
    }

    public AppLovinAdClickListener rU() {
        return this.agC;
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.agC = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.agA = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.agz = appLovinAdLoadListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.agR = appLovinAdVideoPlaybackListener;
    }

    public String toString() {
        return "AppLovinInterstitialAdDialog{}";
    }

    public q(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context != null) {
            this.sdk = appLovinSdk.a();
            this.ahT = new WeakReference<>(context);
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    public void show() {
        a((AppLovinAdLoadListener) new AppLovinAdLoadListener() {
            public void adReceived(AppLovinAd appLovinAd) {
                q.this.c(appLovinAd);
                q.this.showAndRender(appLovinAd);
            }

            public void failedToReceiveAd(int i) {
                q.this.gb(i);
            }
        });
    }

    public void showAndRender(AppLovinAd appLovinAd) {
        AppLovinAd a = u.a(appLovinAd, this.sdk);
        Context rQ = rQ();
        String a2 = a(a, appLovinAd, rQ);
        if (StringUtils.isValidString(a2)) {
            b(appLovinAd, a2);
        } else {
            a((e) a, rQ);
        }
    }

    public void showAndRender(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle) {
        if (viewGroup == null || lifecycle == null) {
            x.H("InterstitialAdDialogWrapper", "Failed to show interstitial: attempting to show ad with null container view or lifecycle object");
            b(appLovinAd, "Failed to show interstitial: attempting to show ad with null container view or lifecycle object");
            return;
        }
        AppLovinAd a = u.a(appLovinAd, this.sdk);
        Context rQ = rQ();
        String a2 = a(a, appLovinAd, rQ);
        if (StringUtils.isValidString(a2)) {
            b(appLovinAd, a2);
            return;
        }
        AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver = new AppLovinFullscreenAdViewObserver(lifecycle, this, this.sdk);
        lifecycle.addObserver(appLovinFullscreenAdViewObserver);
        a((e) a, viewGroup, appLovinFullscreenAdViewObserver, rQ);
    }

    public void setExtraInfo(String str, Object obj) {
        if (str != null) {
            this.agg.put(str, obj);
            return;
        }
        throw new IllegalArgumentException("No key specified");
    }

    public static void a(e eVar, AppLovinAdDisplayListener appLovinAdDisplayListener, String str, Throwable th, AppLovinFullscreenActivity appLovinFullscreenActivity) {
        x.e("InterstitialAdDialogWrapper", str, th);
        if (appLovinAdDisplayListener instanceof h) {
            m.a(appLovinAdDisplayListener, str);
        } else {
            m.b(appLovinAdDisplayListener, (AppLovinAd) eVar);
        }
        if (appLovinFullscreenActivity != null) {
            appLovinFullscreenActivity.dismiss();
        }
    }

    private void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.sdk.BD().loadNextAd(AppLovinAdSize.INTERSTITIAL, appLovinAdLoadListener);
    }

    private String a(AppLovinAd appLovinAd, AppLovinAd appLovinAd2, Context context) {
        if (context == null) {
            x.H("InterstitialAdDialogWrapper", "Failed to show interstitial: stale activity reference provided");
            return "Failed to show interstitial: stale activity reference provided";
        } else if (appLovinAd == null) {
            x.H("InterstitialAdDialogWrapper", "Unable to retrieve the loaded ad: " + appLovinAd2);
            return "Unable to retrieve the loaded ad";
        } else if (!((AppLovinAdImpl) appLovinAd).hasShown() || !((Boolean) this.sdk.a(b.aMJ)).booleanValue()) {
            return null;
        } else {
            x.H("InterstitialAdDialogWrapper", "Attempting to show ad again: " + appLovinAd);
            return "Attempting to show ad again";
        }
    }

    private void a(e eVar, Context context) {
        rP();
        this.sdk.Cb().a((g) eVar);
        this.agq = eVar;
        long max = Math.max(0, ((Long) this.sdk.a(b.aNa)).longValue());
        this.sdk.BN();
        if (x.Fn()) {
            x BN = this.sdk.BN();
            BN.f("InterstitialAdDialogWrapper", "Presenting ad with delay of " + max);
        }
        a(eVar, context, (Runnable) new q$$ExternalSyntheticLambda5(this, context, max));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Context context, long j) {
        new Handler(context.getMainLooper()).postDelayed(new q$$ExternalSyntheticLambda3(this, context), j);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u(Context context) {
        this.sdk.BN();
        if (x.Fn()) {
            this.sdk.BN().f("InterstitialAdDialogWrapper", "Presenting ad in a fullscreen activity");
        }
        t(context);
    }

    private void a(e eVar, ViewGroup viewGroup, AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver, Context context) {
        rP();
        this.sdk.Cb().a((g) eVar);
        this.agq = eVar;
        long max = Math.max(0, ((Long) this.sdk.a(b.aNa)).longValue());
        this.sdk.BN();
        if (x.Fn()) {
            x BN = this.sdk.BN();
            BN.f("InterstitialAdDialogWrapper", "Presenting ad with delay of " + max);
        }
        a(eVar, context, (Runnable) new q$$ExternalSyntheticLambda6(this, context, viewGroup, appLovinFullscreenAdViewObserver, max));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Context context, ViewGroup viewGroup, AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver, long j) {
        new Handler(context.getMainLooper()).postDelayed(new q$$ExternalSyntheticLambda0(this, viewGroup, context, appLovinFullscreenAdViewObserver), j);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(final ViewGroup viewGroup, final Context context, final AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver) {
        this.sdk.BN();
        if (x.Fn()) {
            x BN = this.sdk.BN();
            BN.f("InterstitialAdDialogWrapper", "Presenting ad in a containerView(" + viewGroup + ")");
        }
        viewGroup.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        a.a(this.agq, this.agC, this.agA, this.agR, this.agg, this.sdk, (Activity) context, new a.C0062a() {
            public void a(a aVar) {
                if (com.applovin.impl.sdk.utils.b.i((Activity) context)) {
                    x.H("InterstitialAdDialogWrapper", "Failed to show interstitial: attempting to show ad when parent activity is finishing");
                    q.a(q.this.agq, q.this.agA, "Failed to show interstitial: attempting to show ad when parent activity is finishing", (Throwable) null, (AppLovinFullscreenActivity) null);
                    return;
                }
                appLovinFullscreenAdViewObserver.setPresenter(aVar);
                try {
                    aVar.a(viewGroup);
                } catch (Throwable th) {
                    String str = "Failed to show interstitial: presenter threw exception " + th;
                    x.H("InterstitialAdDialogWrapper", str);
                    q.a(q.this.agq, q.this.agA, str, (Throwable) null, (AppLovinFullscreenActivity) null);
                }
            }

            public void a(String str, Throwable th) {
                q.a(q.this.agq, q.this.agA, str, th, (AppLovinFullscreenActivity) null);
            }
        });
    }

    private void rP() {
        if (this.sdk.BM().AA() == null) {
            this.sdk.BR().a(f.aTg);
        }
    }

    private Context rQ() {
        return (Context) this.ahT.get();
    }

    private void a(e eVar, Context context, Runnable runnable) {
        if (!TextUtils.isEmpty(eVar.GB()) || !eVar.GX() || i.aa(context) || !(context instanceof Activity)) {
            runnable.run();
            return;
        }
        AlertDialog create = new AlertDialog.Builder(context).setTitle(eVar.GY()).setMessage(eVar.GZ()).setPositiveButton(eVar.Ha(), (DialogInterface.OnClickListener) null).create();
        create.setOnDismissListener(new q$$ExternalSyntheticLambda4(runnable));
        create.show();
    }

    private void b(AppLovinAd appLovinAd, String str) {
        if (this.agA == null) {
            return;
        }
        if (this.agA instanceof h) {
            ((h) this.agA).onAdDisplayFailed(str);
        } else {
            this.agA.adHidden(appLovinAd);
        }
    }

    private void t(Context context) {
        Intent intent = new Intent(context, ((Boolean) this.sdk.a(b.aNz)).booleanValue() ? AppLovinFullscreenThemedActivity.class : AppLovinFullscreenActivity.class);
        intent.putExtra("com.applovin.interstitial.sdk_key", this.sdk.getSdkKey());
        AppLovinFullscreenActivity.parentInterstitialWrapper = this;
        if (this.sdk.BM().AA() == null && ((Boolean) this.sdk.a(b.aNu)).booleanValue()) {
            intent.addFlags(8388608);
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (context instanceof Activity) {
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(0, 0);
        } else {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            context.startActivity(intent);
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* access modifiers changed from: private */
    public void c(AppLovinAd appLovinAd) {
        AppLovinSdkUtils.runOnUiThread(new q$$ExternalSyntheticLambda2(this, appLovinAd));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(AppLovinAd appLovinAd) {
        if (this.agz != null) {
            this.agz.adReceived(appLovinAd);
        }
    }

    /* access modifiers changed from: private */
    public void gb(int i) {
        AppLovinSdkUtils.runOnUiThread(new q$$ExternalSyntheticLambda1(this, i));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gc(int i) {
        if (this.agz != null) {
            this.agz.failedToReceiveAd(i);
        }
    }
}
