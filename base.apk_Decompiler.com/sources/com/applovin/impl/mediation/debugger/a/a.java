package com.applovin.impl.mediation.debugger.a;

import com.amazon.device.ads.AdError;
import com.amazon.device.ads.DTBAdCallback;
import com.amazon.device.ads.DTBAdRequest;
import com.amazon.device.ads.DTBAdResponse;
import com.amazon.device.ads.DTBAdSize;
import com.applovin.mediation.MaxAdFormat;
import java.util.Arrays;
import java.util.List;

public class a implements DTBAdCallback {
    private final C0072a aoh;
    private DTBAdRequest aoi;
    private final MaxAdFormat format;

    /* renamed from: com.applovin.impl.mediation.debugger.a.a$a  reason: collision with other inner class name */
    public interface C0072a {
        void onAdLoadFailed(AdError adError, MaxAdFormat maxAdFormat);

        void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat);
    }

    public a(b bVar, MaxAdFormat maxAdFormat, C0072a aVar) {
        this((List<?>) Arrays.asList(new DTBAdSize[]{bVar.uF()}), maxAdFormat, aVar);
    }

    public a(List<?> list, MaxAdFormat maxAdFormat, C0072a aVar) {
        this.format = maxAdFormat;
        this.aoh = aVar;
        try {
            DTBAdSize[] dTBAdSizeArr = new DTBAdSize[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                if (obj instanceof DTBAdSize) {
                    dTBAdSizeArr[i] = (DTBAdSize) obj;
                }
            }
            DTBAdRequest dTBAdRequest = new DTBAdRequest();
            this.aoi = dTBAdRequest;
            dTBAdRequest.setSizes(dTBAdSizeArr);
        } catch (Throwable unused) {
        }
    }

    public void loadAd() {
        DTBAdRequest dTBAdRequest = this.aoi;
        if (dTBAdRequest == null) {
            this.aoh.onAdLoadFailed((AdError) null, this.format);
        } else {
            dTBAdRequest.loadAd(this);
        }
    }

    public void onSuccess(DTBAdResponse dTBAdResponse) {
        this.aoh.onAdResponseLoaded(dTBAdResponse, this.format);
    }

    public void onFailure(AdError adError) {
        this.aoh.onAdLoadFailed(adError, this.format);
    }
}
