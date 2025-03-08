package com.applovin.impl.adview.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.q;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAd;

public class FullscreenAdService extends Service {
    public static final String DATA_KEY_AD_SOURCE = "ad_source";
    public static final String DATA_KEY_RAW_FULL_AD_RESPONSE = "raw_full_ad_response";
    private static final String TAG = "FullscreenAdService";

    public enum b {
        AD(0),
        AD_DISPLAYED(1),
        AD_CLICKED(2),
        AD_VIDEO_STARTED(3),
        AD_VIDEO_ENDED(4),
        AD_HIDDEN(5);
        
        private final int ahF;

        public int getValue() {
            return this.ahF;
        }

        private b(int i) {
            this.ahF = i;
        }
    }

    public IBinder onBind(Intent intent) {
        return new Messenger(new a()).getBinder();
    }

    private static class a extends Handler {
        private a() {
        }

        public void handleMessage(Message message) {
            try {
                q qVar = AppLovinFullscreenActivity.parentInterstitialWrapper;
                if (qVar != null) {
                    e currentAd = qVar.getCurrentAd();
                    if (message.what == b.AD.getValue()) {
                        Bundle bundle = new Bundle();
                        bundle.putString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE, currentAd.getRawFullResponse());
                        bundle.putInt(FullscreenAdService.DATA_KEY_AD_SOURCE, currentAd.getSource().getValue());
                        Message obtain = Message.obtain((Handler) null, b.AD.getValue());
                        obtain.setData(bundle);
                        message.replyTo.send(obtain);
                    } else if (message.what == b.AD_DISPLAYED.getValue()) {
                        m.a(qVar.rS(), (AppLovinAd) currentAd);
                    } else if (message.what == b.AD_CLICKED.getValue()) {
                        m.a(qVar.rU(), (AppLovinAd) currentAd);
                    } else if (message.what == b.AD_VIDEO_STARTED.getValue()) {
                        m.a(qVar.rT(), (AppLovinAd) currentAd);
                    } else if (message.what == b.AD_VIDEO_ENDED.getValue()) {
                        Bundle data = message.getData();
                        m.a(qVar.rT(), (AppLovinAd) currentAd, data.getDouble("percent_viewed"), data.getBoolean("fully_watched"));
                    } else if (message.what == b.AD_HIDDEN.getValue()) {
                        m.b(qVar.rS(), (AppLovinAd) currentAd);
                    } else {
                        super.handleMessage(message);
                    }
                } else if (!u.gY(1)) {
                    super.handleMessage(message);
                } else {
                    throw new RuntimeException("parentWrapper is null for " + message.what);
                }
            } catch (RemoteException e) {
                x.e(FullscreenAdService.TAG, "Failed to respond to Fullscreen Activity in another process with ad", e);
            } catch (Throwable unused) {
            }
        }
    }
}
