package com.unity3d.scar.adapter.v2100.signals;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.DispatchGroup;
import com.unity3d.scar.adapter.common.scarads.UnityAdFormat;
import com.unity3d.scar.adapter.common.signals.ISignalsCollector;
import com.unity3d.scar.adapter.common.signals.SignalCallbackListener;
import com.unity3d.scar.adapter.common.signals.SignalsCollectorBase;
import com.unity3d.scar.adapter.common.signals.SignalsResult;
import com.unity3d.scar.adapter.v2100.requests.AdRequestFactory;

public class SignalsCollector extends SignalsCollectorBase implements ISignalsCollector {
    private AdRequestFactory _adRequestFactory;

    public SignalsCollector(AdRequestFactory adRequestFactory) {
        this._adRequestFactory = adRequestFactory;
    }

    public void getSCARSignal(Context context, String str, UnityAdFormat unityAdFormat, DispatchGroup dispatchGroup, SignalsResult signalsResult) {
        QueryInfo.generate(context, getAdFormat(unityAdFormat), this._adRequestFactory.buildAdRequest(), new QueryInfoCallback(str, new SignalCallbackListener(dispatchGroup, signalsResult)));
    }

    public void getSCARSignalForHB(Context context, UnityAdFormat unityAdFormat, DispatchGroup dispatchGroup, SignalsResult signalsResult) {
        getSCARSignal(context, getAdKey(unityAdFormat), unityAdFormat, dispatchGroup, signalsResult);
    }

    /* renamed from: com.unity3d.scar.adapter.v2100.signals.SignalsCollector$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.scar.adapter.v2100.signals.SignalsCollector.AnonymousClass1.<clinit>():void");
        }
    }

    public AdFormat getAdFormat(UnityAdFormat unityAdFormat) {
        int i = AnonymousClass1.$SwitchMap$com$unity3d$scar$adapter$common$scarads$UnityAdFormat[unityAdFormat.ordinal()];
        if (i == 1) {
            return AdFormat.BANNER;
        }
        if (i == 2) {
            return AdFormat.INTERSTITIAL;
        }
        if (i != 3) {
            return AdFormat.UNKNOWN;
        }
        return AdFormat.REWARDED;
    }
}
