package com.unity3d.scar.adapter.v2000.scarads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.unity3d.scar.adapter.common.GMAAdsError;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarFullScreenAd;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;

public class ScarRewardedAd extends ScarAdBase<RewardedAd> implements IScarFullScreenAd {
    public ScarRewardedAd(Context context, QueryInfo queryInfo, ScarAdMetadata scarAdMetadata, IAdsErrorHandler iAdsErrorHandler, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper) {
        super(context, scarAdMetadata, queryInfo, iAdsErrorHandler);
        this._scarAdListener = new ScarRewardedAdListener(iScarRewardedAdListenerWrapper, this);
    }

    /* access modifiers changed from: protected */
    public void loadAdInternal(AdRequest adRequest, IScarLoadListener iScarLoadListener) {
        RewardedAd.load(this._context, this._scarAdMetadata.getAdUnitId(), adRequest, ((ScarRewardedAdListener) this._scarAdListener).getAdLoadListener());
    }

    public void show(Activity activity) {
        if (this._adObj != null) {
            ((RewardedAd) this._adObj).show(activity, ((ScarRewardedAdListener) this._scarAdListener).getOnUserEarnedRewardListener());
        } else {
            this._adsErrorHandler.handleError(GMAAdsError.AdNotLoadedError(this._scarAdMetadata));
        }
    }
}
