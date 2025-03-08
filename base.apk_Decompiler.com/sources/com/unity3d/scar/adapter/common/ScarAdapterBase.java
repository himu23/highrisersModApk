package com.unity3d.scar.adapter.common;

import android.app.Activity;
import android.content.Context;
import com.unity3d.scar.adapter.common.scarads.IScarFullScreenAd;
import com.unity3d.scar.adapter.common.scarads.UnityAdFormat;
import com.unity3d.scar.adapter.common.signals.ISignalCollectionListener;
import com.unity3d.scar.adapter.common.signals.ISignalsCollector;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ScarAdapterBase implements IScarAdapter {
    protected IAdsErrorHandler<WebViewAdsError> _adsErrorHandler;
    protected IScarFullScreenAd _currentAdReference;
    protected Map<String, IScarFullScreenAd> _loadedAds = new ConcurrentHashMap();
    protected ISignalsCollector _signalCollector;

    public ScarAdapterBase(IAdsErrorHandler<WebViewAdsError> iAdsErrorHandler) {
        this._adsErrorHandler = iAdsErrorHandler;
    }

    public void getSCARBiddingSignals(Context context, boolean z, ISignalCollectionListener iSignalCollectionListener) {
        this._signalCollector.getSCARBiddingSignals(context, z, iSignalCollectionListener);
    }

    public void getSCARSignal(Context context, String str, UnityAdFormat unityAdFormat, ISignalCollectionListener iSignalCollectionListener) {
        this._signalCollector.getSCARSignal(context, str, unityAdFormat, iSignalCollectionListener);
    }

    public void show(final Activity activity, String str, String str2) {
        IScarFullScreenAd iScarFullScreenAd = this._loadedAds.get(str2);
        if (iScarFullScreenAd == null) {
            IAdsErrorHandler<WebViewAdsError> iAdsErrorHandler = this._adsErrorHandler;
            iAdsErrorHandler.handleError(GMAAdsError.NoAdsError(str2, str, "Could not find ad for placement '" + str2 + "'."));
            return;
        }
        this._currentAdReference = iScarFullScreenAd;
        Utils.runOnUiThread(new Runnable() {
            public void run() {
                ScarAdapterBase.this._currentAdReference.show(activity);
            }
        });
    }
}
