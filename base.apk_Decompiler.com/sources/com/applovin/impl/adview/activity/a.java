package com.applovin.impl.adview.activity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.adview.activity.b.a;
import com.applovin.impl.adview.q;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.r;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements ServiceConnection {
    /* access modifiers changed from: private */
    public Messenger aiA;
    /* access modifiers changed from: private */
    public final WeakReference<AppLovinFullscreenActivity> aiy;
    private final AtomicBoolean aiz = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final x logger;
    /* access modifiers changed from: private */
    public final n sdk;

    public a(AppLovinFullscreenActivity appLovinFullscreenActivity, n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
        this.aiy = new WeakReference<>(appLovinFullscreenActivity);
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.aiz.compareAndSet(false, true)) {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("AppLovinFullscreenActivity", "Fullscreen ad service connected to " + componentName);
            }
            this.aiA = new Messenger(iBinder);
            Message obtain = Message.obtain((Handler) null, FullscreenAdService.b.AD.getValue());
            obtain.replyTo = new Messenger(new b());
            try {
                if (x.Fn()) {
                    this.logger.f("AppLovinFullscreenActivity", "Requesting ad from FullscreenAdService...");
                }
                this.aiA.send(obtain);
            } catch (RemoteException e) {
                if (x.Fn()) {
                    this.logger.c("AppLovinFullscreenActivity", "Failed to send ad request message to FullscreenAdService", e);
                }
                dismiss();
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (this.aiz.compareAndSet(true, false) && x.Fn()) {
            x xVar = this.logger;
            xVar.f("AppLovinFullscreenActivity", "FullscreenAdService disconnected from " + componentName);
        }
    }

    /* access modifiers changed from: private */
    public void dismiss() {
        AppLovinFullscreenActivity appLovinFullscreenActivity = (AppLovinFullscreenActivity) this.aiy.get();
        if (appLovinFullscreenActivity != null) {
            if (x.Fn()) {
                this.logger.f("AppLovinFullscreenActivity", "Dismissing...");
            }
            appLovinFullscreenActivity.dismiss();
        } else if (x.Fn()) {
            this.logger.i("AppLovinFullscreenActivity", "Unable to dismiss parent Activity");
        }
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.sdk.ad.b bVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = JsonUtils.getString(jSONObject, "zone_id", "");
            if (!TextUtils.isEmpty(string)) {
                this.sdk.BO().b((d) new r(jSONObject, com.applovin.impl.sdk.ad.d.cQ(string), bVar, new AppLovinAdLoadListener() {
                    public void adReceived(final AppLovinAd appLovinAd) {
                        final AppLovinFullscreenActivity appLovinFullscreenActivity = (AppLovinFullscreenActivity) a.this.aiy.get();
                        if (appLovinFullscreenActivity != null) {
                            x unused = a.this.logger;
                            if (x.Fn()) {
                                a.this.logger.f("AppLovinFullscreenActivity", "Presenting ad...");
                            }
                            final C0061a aVar = new C0061a();
                            com.applovin.impl.adview.activity.b.a.a((e) appLovinAd, aVar, aVar, aVar, (Map<String, Object>) null, a.this.sdk, appLovinFullscreenActivity, new a.C0062a() {
                                public void a(com.applovin.impl.adview.activity.b.a aVar) {
                                    appLovinFullscreenActivity.setPresenter(aVar);
                                    aVar.sA();
                                }

                                public void a(String str, Throwable th) {
                                    q.a((e) appLovinAd, aVar, str, th, appLovinFullscreenActivity);
                                }
                            });
                            return;
                        }
                        x unused2 = a.this.logger;
                        if (x.Fn()) {
                            x b = a.this.logger;
                            b.i("AppLovinFullscreenActivity", "Unable to present ad, parent activity has been GC'd - " + appLovinAd);
                        }
                    }

                    public void failedToReceiveAd(int i) {
                        a.this.dismiss();
                    }
                }, this.sdk));
                return;
            }
            throw new IllegalStateException("No zone identifier found in ad response: " + jSONObject);
        } catch (JSONException e) {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.c("AppLovinFullscreenActivity", "Unable to process ad: " + str, e);
            }
            dismiss();
        }
    }

    private static class b extends Handler {
        private final WeakReference<a> aiG;

        private b(a aVar) {
            this.aiG = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            a aVar;
            if (message.what != FullscreenAdService.b.AD.getValue() || (aVar = (a) this.aiG.get()) == null) {
                super.handleMessage(message);
                return;
            }
            aVar.a(com.applovin.impl.sdk.ad.b.gB(message.getData().getInt(FullscreenAdService.DATA_KEY_AD_SOURCE)), message.getData().getString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE));
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.a$a  reason: collision with other inner class name */
    private class C0061a implements AppLovinAdClickListener, AppLovinAdDisplayListener, AppLovinAdVideoPlaybackListener {
        private C0061a() {
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            a(FullscreenAdService.b.AD_DISPLAYED);
        }

        public void adHidden(AppLovinAd appLovinAd) {
            a(FullscreenAdService.b.AD_HIDDEN);
        }

        public void adClicked(AppLovinAd appLovinAd) {
            a(FullscreenAdService.b.AD_CLICKED);
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            a(FullscreenAdService.b.AD_VIDEO_STARTED);
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            Bundle bundle = new Bundle();
            bundle.putDouble("percent_viewed", d);
            bundle.putBoolean("fully_watched", z);
            a(bundle, FullscreenAdService.b.AD_VIDEO_ENDED);
        }

        private void a(FullscreenAdService.b bVar) {
            a((Bundle) null, bVar);
        }

        private void a(Bundle bundle, FullscreenAdService.b bVar) {
            Message obtain = Message.obtain((Handler) null, bVar.getValue());
            if (bundle != null) {
                obtain.setData(bundle);
            }
            try {
                a.this.aiA.send(obtain);
            } catch (RemoteException e) {
                x unused = a.this.logger;
                if (x.Fn()) {
                    x b = a.this.logger;
                    b.c("AppLovinFullscreenActivity", "Failed to forward callback (" + bVar.getValue() + ")", e);
                }
            }
        }
    }
}
