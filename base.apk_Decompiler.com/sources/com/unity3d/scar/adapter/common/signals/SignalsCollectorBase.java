package com.unity3d.scar.adapter.common.signals;

import android.content.Context;
import com.unity3d.scar.adapter.common.DispatchGroup;
import com.unity3d.scar.adapter.common.scarads.UnityAdFormat;
import java.util.Map;
import org.json.JSONObject;

public abstract class SignalsCollectorBase implements ISignalsCollector {
    public static final String SCAR_BAN_SIGNAL = "gmaScarBiddingBannerSignal";
    public static final String SCAR_INT_SIGNAL = "gmaScarBiddingInterstitialSignal";
    public static final String SCAR_RV_SIGNAL = "gmaScarBiddingRewardedSignal";

    public void getSCARSignal(Context context, String str, UnityAdFormat unityAdFormat, ISignalCollectionListener iSignalCollectionListener) {
        DispatchGroup dispatchGroup = new DispatchGroup();
        SignalsResult signalsResult = new SignalsResult();
        dispatchGroup.enter();
        getSCARSignal(context, str, unityAdFormat, dispatchGroup, signalsResult);
        dispatchGroup.notify(new GMAScarDispatchCompleted(iSignalCollectionListener, signalsResult));
    }

    public void getSCARBiddingSignals(Context context, boolean z, ISignalCollectionListener iSignalCollectionListener) {
        DispatchGroup dispatchGroup = new DispatchGroup();
        SignalsResult signalsResult = new SignalsResult();
        dispatchGroup.enter();
        getSCARSignalForHB(context, UnityAdFormat.INTERSTITIAL, dispatchGroup, signalsResult);
        dispatchGroup.enter();
        getSCARSignalForHB(context, UnityAdFormat.REWARDED, dispatchGroup, signalsResult);
        if (z) {
            dispatchGroup.enter();
            getSCARSignalForHB(context, UnityAdFormat.BANNER, dispatchGroup, signalsResult);
        }
        dispatchGroup.notify(new GMAScarDispatchCompleted(iSignalCollectionListener, signalsResult));
    }

    public void onOperationNotSupported(String str, DispatchGroup dispatchGroup, SignalsResult signalsResult) {
        signalsResult.setErrorMessage(String.format("Operation Not supported: %s.", new Object[]{str}));
        dispatchGroup.leave();
    }

    private class GMAScarDispatchCompleted implements Runnable {
        private ISignalCollectionListener _signalListener;
        private SignalsResult _signalsResult;

        public GMAScarDispatchCompleted(ISignalCollectionListener iSignalCollectionListener, SignalsResult signalsResult) {
            this._signalListener = iSignalCollectionListener;
            this._signalsResult = signalsResult;
        }

        public void run() {
            Map<String, String> signalsMap = this._signalsResult.getSignalsMap();
            if (signalsMap.size() > 0) {
                this._signalListener.onSignalsCollected(new JSONObject(signalsMap).toString());
            } else if (this._signalsResult.getErrorMessage() == null) {
                this._signalListener.onSignalsCollected("");
            } else {
                this._signalListener.onSignalsCollectionFailed(this._signalsResult.getErrorMessage());
            }
        }
    }

    /* renamed from: com.unity3d.scar.adapter.common.signals.SignalsCollectorBase$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$scar$adapter$common$scarads$UnityAdFormat;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.unity3d.scar.adapter.common.scarads.UnityAdFormat[] r0 = com.unity3d.scar.adapter.common.scarads.UnityAdFormat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$unity3d$scar$adapter$common$scarads$UnityAdFormat = r0
                com.unity3d.scar.adapter.common.scarads.UnityAdFormat r1 = com.unity3d.scar.adapter.common.scarads.UnityAdFormat.BANNER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$unity3d$scar$adapter$common$scarads$UnityAdFormat     // Catch:{ NoSuchFieldError -> 0x001d }
                com.unity3d.scar.adapter.common.scarads.UnityAdFormat r1 = com.unity3d.scar.adapter.common.scarads.UnityAdFormat.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$unity3d$scar$adapter$common$scarads$UnityAdFormat     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.unity3d.scar.adapter.common.scarads.UnityAdFormat r1 = com.unity3d.scar.adapter.common.scarads.UnityAdFormat.REWARDED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.scar.adapter.common.signals.SignalsCollectorBase.AnonymousClass1.<clinit>():void");
        }
    }

    public String getAdKey(UnityAdFormat unityAdFormat) {
        int i = AnonymousClass1.$SwitchMap$com$unity3d$scar$adapter$common$scarads$UnityAdFormat[unityAdFormat.ordinal()];
        if (i == 1) {
            return SCAR_BAN_SIGNAL;
        }
        if (i != 2) {
            return i != 3 ? "" : SCAR_RV_SIGNAL;
        }
        return SCAR_INT_SIGNAL;
    }
}
