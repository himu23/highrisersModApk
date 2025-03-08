package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.services.ads.gmascar.GMA;
import com.unity3d.services.ads.gmascar.listeners.IBiddingSignalsListener;
import com.unity3d.services.ads.gmascar.models.BiddingSignals;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import com.unity3d.services.ads.gmascar.utils.ScarRequestHandler;
import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.ScarMetric;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BiddingBaseManager implements IBiddingManager {
    private final boolean _isAsyncTokenCall;
    private final boolean _isBannerEnabled;
    private final ScarRequestHandler _scarRequestHandler;
    protected final AtomicBoolean isUploadPermitted;
    private final AtomicReference<BiddingSignals> signals;
    private final String tokenIdentifier;
    private final IUnityAdsTokenListener unityAdsTokenListener;

    public String getTokenIdentifier() {
        return this.tokenIdentifier;
    }

    public abstract void start();

    public BiddingBaseManager(boolean z, IUnityAdsTokenListener iUnityAdsTokenListener) {
        this(z, iUnityAdsTokenListener, new ScarRequestHandler());
    }

    public BiddingBaseManager(boolean z, IUnityAdsTokenListener iUnityAdsTokenListener, ScarRequestHandler scarRequestHandler) {
        boolean z2 = false;
        this.isUploadPermitted = new AtomicBoolean(false);
        this.signals = new AtomicReference<>();
        this.tokenIdentifier = UUID.randomUUID().toString();
        this._isBannerEnabled = z;
        this.unityAdsTokenListener = iUnityAdsTokenListener;
        this._isAsyncTokenCall = iUnityAdsTokenListener != null ? true : z2;
        this._scarRequestHandler = scarRequestHandler;
    }

    public String getFormattedToken(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String tokenIdentifier2 = getTokenIdentifier();
        if (tokenIdentifier2 == null || tokenIdentifier2.isEmpty()) {
            return str;
        }
        return String.format(ScarConstants.TOKEN_WITH_SCAR_FORMAT, new Object[]{tokenIdentifier2, str});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onUnityAdsTokenReady$0$com-unity3d-services-ads-gmascar-managers-BiddingBaseManager  reason: not valid java name */
    public /* synthetic */ void m45lambda$onUnityAdsTokenReady$0$comunity3dservicesadsgmascarmanagersBiddingBaseManager(String str) {
        this.unityAdsTokenListener.onUnityAdsTokenReady(str);
    }

    public final void onUnityAdsTokenReady(String str) {
        if (this.unityAdsTokenListener != null) {
            Utilities.wrapCustomerListener(new BiddingBaseManager$$ExternalSyntheticLambda1(this, str));
        }
    }

    public void permitUpload() {
        this.isUploadPermitted.set(true);
    }

    public void permitSignalsUpload() {
        this.isUploadPermitted.set(true);
        attemptUpload();
    }

    public void fetchSignals() {
        getMetricSender().sendMetric(ScarMetric.hbSignalsFetchStart(this._isAsyncTokenCall));
        new Thread(new BiddingBaseManager$$ExternalSyntheticLambda0(this)).start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$fetchSignals$1$com-unity3d-services-ads-gmascar-managers-BiddingBaseManager  reason: not valid java name */
    public /* synthetic */ void m44lambda$fetchSignals$1$comunity3dservicesadsgmascarmanagersBiddingBaseManager() {
        GMA.getInstance().getSCARBiddingSignals(this._isBannerEnabled, new IBiddingSignalsListener() {
            public void onSignalsReady(BiddingSignals biddingSignals) {
                BiddingBaseManager.this.onSignalsReady(biddingSignals);
                BiddingBaseManager.this.sendFetchResult("");
            }

            public void onSignalsFailure(String str) {
                BiddingBaseManager.this.sendFetchResult(str);
            }
        });
    }

    public void sendFetchResult(String str) {
        if (str != "") {
            getMetricSender().sendMetric(ScarMetric.hbSignalsFetchFailure(this._isAsyncTokenCall, str));
        } else {
            getMetricSender().sendMetric(ScarMetric.hbSignalsFetchSuccess(this._isAsyncTokenCall));
        }
    }

    public void onSignalsReady(BiddingSignals biddingSignals) {
        this.signals.set(biddingSignals);
        attemptUpload();
    }

    private synchronized void attemptUpload() {
        if (this.signals.get() != null && this.isUploadPermitted.compareAndSet(true, false)) {
            uploadSignals();
        }
    }

    public void uploadSignals() {
        getMetricSender().sendMetric(ScarMetric.hbSignalsUploadStart(this._isAsyncTokenCall));
        BiddingSignals biddingSignals = this.signals.get();
        if (biddingSignals == null || biddingSignals.isEmpty()) {
            getMetricSender().sendMetric(ScarMetric.hbSignalsUploadFailure(this._isAsyncTokenCall, "null or empty signals"));
        } else {
            new Thread(new BiddingBaseManager$$ExternalSyntheticLambda2(this, biddingSignals)).start();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$uploadSignals$2$com-unity3d-services-ads-gmascar-managers-BiddingBaseManager  reason: not valid java name */
    public /* synthetic */ void m46lambda$uploadSignals$2$comunity3dservicesadsgmascarmanagersBiddingBaseManager(BiddingSignals biddingSignals) {
        try {
            this._scarRequestHandler.makeUploadRequest(this.tokenIdentifier, biddingSignals, new ConfigurationReader().getCurrentConfiguration().getScarBiddingUrl());
            getMetricSender().sendMetric(ScarMetric.hbSignalsUploadSuccess(this._isAsyncTokenCall));
        } catch (Exception e) {
            getMetricSender().sendMetric(ScarMetric.hbSignalsUploadFailure(this._isAsyncTokenCall, e.getLocalizedMessage()));
        }
    }

    public SDKMetricsSender getMetricSender() {
        return (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class);
    }
}
