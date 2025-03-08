package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.listener.RewardedVideoAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import java.util.UUID;
import org.json.JSONObject;

public class b0 extends a<RewardedVideoAdListener> implements RewardedVideoSmashListener {
    public b0(AbstractAdapter abstractAdapter, NetworkSettings networkSettings) {
        super(abstractAdapter, networkSettings, IronSource.AD_UNIT.REWARDED_VIDEO, (UUID) null);
    }

    private boolean a(IronSourceError ironSourceError) {
        return ironSourceError.getErrorCode() == 1057;
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject, JSONObject jSONObject2, AdData adData) {
        Integer num = adData.getInt("instanceType");
        if (num == null || num.intValue() != 1) {
            this.a.loadRewardedVideoForBidding(jSONObject, jSONObject2, adData.getServerData(), this);
        } else {
            this.a.loadRewardedVideo(jSONObject, jSONObject2, this);
        }
    }

    /* access modifiers changed from: protected */
    public IronSource.AD_UNIT b() {
        return IronSource.AD_UNIT.REWARDED_VIDEO;
    }

    /* access modifiers changed from: protected */
    public boolean b(IronSourceError ironSourceError) {
        return ironSourceError.getErrorCode() == 1058;
    }

    /* access modifiers changed from: protected */
    public boolean b(JSONObject jSONObject) {
        return this.a.isRewardedVideoAvailable(jSONObject);
    }

    /* access modifiers changed from: protected */
    public void c(JSONObject jSONObject) {
        this.a.showRewardedVideo(jSONObject, this);
    }

    public void onRewardedVideoAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdClicked();
        }
    }

    public void onRewardedVideoAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdClosed();
        }
    }

    public void onRewardedVideoAdEnded() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdEnded();
        }
    }

    public void onRewardedVideoAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdOpened();
        }
    }

    public void onRewardedVideoAdRewarded() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdRewarded();
        }
    }

    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(a("error = " + ironSourceError));
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdShowFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public void onRewardedVideoAdStarted() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdStarted();
        }
    }

    public void onRewardedVideoAdVisible() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdVisible();
        }
    }

    public void onRewardedVideoAvailabilityChanged(boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("available = " + z));
        if (this.b.get() == null) {
            return;
        }
        if (z) {
            ((RewardedVideoAdListener) this.b.get()).onAdLoadSuccess();
        } else {
            ((RewardedVideoAdListener) this.b.get()).onAdLoadFailed(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, 510, "");
        }
    }

    public void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
    }

    public void onRewardedVideoInitSuccess() {
    }

    public void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(a("error = " + ironSourceError));
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdLoadFailed(b(ironSourceError) ? AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL : a(ironSourceError) ? AdapterErrorType.ADAPTER_ERROR_TYPE_AD_EXPIRED : AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public void onRewardedVideoLoadSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdLoadSuccess();
        }
    }
}
