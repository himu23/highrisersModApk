package com.fyber.marketplace.fairbid.impl;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.dv.g;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.factories.b;
import com.fyber.inneractive.sdk.flow.h;
import com.fyber.inneractive.sdk.interfaces.a;
import com.fyber.inneractive.sdk.network.m;
import com.fyber.inneractive.sdk.network.n;
import com.fyber.inneractive.sdk.network.q;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.response.k;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadError;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadListener;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters;
import com.fyber.marketplace.fairbid.bridge.MarketplaceBridgeAd;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class a {
    public e adSpot;
    public MarketplaceAuctionParameters mMarketplaceAuctionParameters;
    private c mMarketplaceAuctionResponse;
    /* access modifiers changed from: private */
    public boolean mMuted;
    public String mPlacementId;
    public g mWrapperQueryInfo;

    /* renamed from: com.fyber.marketplace.fairbid.impl.a$a  reason: collision with other inner class name */
    public class C0141a implements Runnable {
        public final /* synthetic */ MarketplaceAdLoadListener a;
        public final /* synthetic */ com.fyber.inneractive.sdk.response.a b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ InneractiveUnitController e;

        public C0141a(MarketplaceAdLoadListener marketplaceAdLoadListener, com.fyber.inneractive.sdk.response.a aVar, String str, Map map, InneractiveUnitController inneractiveUnitController) {
            this.a = marketplaceAdLoadListener;
            this.b = aVar;
            this.c = str;
            this.d = map;
            this.e = inneractiveUnitController;
        }

        public void run() {
            a.this.loadParsedData(this.e, this.a, a.this.parseResponseData(this.a, this.b, this.c, this.d), a.this.getAdContentLoader(this.a, this.b));
        }
    }

    public class c implements n {
        public final /* synthetic */ Map a;
        public final /* synthetic */ String b;

        public c(a aVar, Map map, String str) {
            this.a = map;
            this.b = str;
        }

        public StringBuffer e() {
            return new StringBuffer(this.b);
        }

        public Map<String, String> t() {
            return this.a;
        }
    }

    public a(String str, JSONObject jSONObject, Map<String, String> map, boolean z, MarketplaceAuctionParameters marketplaceAuctionParameters) {
        Map<String, String> lowerCaseHeaders = lowerCaseHeaders(map);
        com.fyber.inneractive.sdk.response.a responseAdType = getResponseAdType(lowerCaseHeaders);
        this.mMarketplaceAuctionParameters = marketplaceAuctionParameters;
        this.mPlacementId = str;
        if (responseAdType != null) {
            this.mMarketplaceAuctionResponse = new c(jSONObject, responseAdType, lowerCaseHeaders);
        }
        this.mMuted = z;
    }

    private void fireAdLoadFailedEvent(MarketplaceAdLoadError marketplaceAdLoadError) {
        if (isFullscreen()) {
            IAlog.a("Firing Event 801 - AdLoadFailed - errorCode - %s", marketplaceAdLoadError.getErrorMessage());
            s.a aVar = new s.a(q.IA_AD_LOAD_FAILED, (InneractiveAdRequest) null, (e) null, (JSONArray) null);
            JSONObject jSONObject = new JSONObject();
            String str = marketplaceAdLoadError.toString();
            try {
                jSONObject.put("message", str);
            } catch (Exception unused) {
                IAlog.e("Got exception adding param to json object: %s, %s", "message", str);
            }
            String errorMessage = marketplaceAdLoadError.getErrorMessage();
            try {
                jSONObject.put("extra_description", errorMessage);
            } catch (Exception unused2) {
                IAlog.e("Got exception adding param to json object: %s, %s", "extra_description", errorMessage);
            }
            aVar.f.put(jSONObject);
            aVar.a((String) null);
        }
    }

    private com.fyber.inneractive.sdk.response.b generateParser(com.fyber.inneractive.sdk.response.a aVar, String str, Map<String, String> map) {
        com.fyber.inneractive.sdk.response.b a = b.a.a.a(aVar);
        IAlog.a("IA Exchange response handler: final headers: %s", map);
        if (a != null) {
            c cVar = new c(this, map, str);
            a.a = a.a();
            a.c = new k(cVar);
        }
        return a;
    }

    /* access modifiers changed from: private */
    public void loadParsedData(InneractiveUnitController<?> inneractiveUnitController, MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener, e eVar, com.fyber.inneractive.sdk.interfaces.a aVar) {
        if (eVar != null && aVar != null) {
            com.fyber.inneractive.sdk.util.q.b.post(new b(eVar, aVar, inneractiveUnitController, marketplaceAdLoadListener));
        }
    }

    public com.fyber.inneractive.sdk.interfaces.a getAdContentLoader(MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener, com.fyber.inneractive.sdk.response.a aVar) {
        b.C0096b bVar = b.a.a.a.get(aVar);
        com.fyber.inneractive.sdk.interfaces.a a = bVar != null ? bVar.a() : null;
        if (a != null) {
            return a;
        }
        notifyFailToListener(MarketplaceAdLoadError.UNSUPPORTED_AD_TYPE, marketplaceAdLoadListener);
        return null;
    }

    public com.fyber.inneractive.sdk.response.a getResponseAdType(Map<String, String> map) {
        String str = map.get(m.RETURNED_AD_TYPE.key.toLowerCase(Locale.ENGLISH));
        if (str == null) {
            return null;
        }
        try {
            return com.fyber.inneractive.sdk.response.a.a(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public abstract void internalOnAdLoaded(a aVar, e eVar);

    public abstract boolean isFullscreen();

    public boolean isMuted() {
        return this.mMuted;
    }

    public Map<String, String> lowerCaseHeaders(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (String next : map.keySet()) {
                hashMap.put(TextUtils.isEmpty(next) ? next : next.toLowerCase(Locale.ENGLISH), map.get(next));
            }
        }
        return hashMap;
    }

    public void notifyFailToListener(MarketplaceAdLoadError marketplaceAdLoadError, MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener) {
        fireAdLoadFailedEvent(marketplaceAdLoadError);
        marketplaceAdLoadListener.onAdLoadFailed(marketplaceAdLoadError);
    }

    public e parseResponseData(MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener, com.fyber.inneractive.sdk.response.a aVar, String str, Map<String, String> map) {
        try {
            e a = generateParser(aVar, str, map).a(str);
            g gVar = this.mWrapperQueryInfo;
            if (gVar != null) {
                a.s = gVar;
            }
            InneractiveErrorCode a2 = a.a((InneractiveAdRequest) null);
            if (a2 == null) {
                return a;
            }
            notifyFailToListener(MarketplaceAdLoadError.RESPONSE_VALIDATION_FAILED, marketplaceAdLoadListener);
            IAlog.a("failed parsing response data with error: %s", a2.toString());
            return null;
        } catch (Exception e) {
            notifyFailToListener(MarketplaceAdLoadError.FAILED_TO_PARSE_AD_CONTENT, marketplaceAdLoadListener);
            if (e.getMessage() != null) {
                IAlog.a("failed parsing response data with error: %s", e.getMessage());
            }
            return null;
        }
    }

    public void setQueryInfo(g gVar) {
        this.mWrapperQueryInfo = gVar;
    }

    public void loadAd(InneractiveUnitController<?> inneractiveUnitController, MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener) {
        c cVar = this.mMarketplaceAuctionResponse;
        if (cVar == null) {
            notifyFailToListener(MarketplaceAdLoadError.FAILED_TO_PARSE_AD_CONTENT, marketplaceAdLoadListener);
            return;
        }
        com.fyber.inneractive.sdk.response.a aVar = cVar.b;
        String str = cVar.a;
        Map<String, String> map = cVar.c;
        if (aVar == null || str == null || map.isEmpty()) {
            notifyFailToListener(MarketplaceAdLoadError.FAILED_TO_PARSE_AD_CONTENT, marketplaceAdLoadListener);
        } else {
            com.fyber.inneractive.sdk.util.q.a(new C0141a(marketplaceAdLoadListener, aVar, str, map, inneractiveUnitController));
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ e a;
        public final /* synthetic */ com.fyber.inneractive.sdk.interfaces.a b;
        public final /* synthetic */ InneractiveUnitController c;
        public final /* synthetic */ MarketplaceAdLoadListener d;

        public b(e eVar, com.fyber.inneractive.sdk.interfaces.a aVar, InneractiveUnitController inneractiveUnitController, MarketplaceAdLoadListener marketplaceAdLoadListener) {
            this.a = eVar;
            this.b = aVar;
            this.c = inneractiveUnitController;
            this.d = marketplaceAdLoadListener;
        }

        public void run() {
            a aVar = a.this;
            com.fyber.inneractive.sdk.config.global.s featureProvider = aVar.mMarketplaceAuctionParameters.getFeatureProvider(aVar.mPlacementId);
            if (featureProvider == null) {
                featureProvider = com.fyber.inneractive.sdk.config.global.s.b();
            }
            com.fyber.inneractive.sdk.config.global.s sVar = featureProvider;
            e eVar = this.a;
            com.fyber.inneractive.sdk.config.global.e eVar2 = new com.fyber.inneractive.sdk.config.global.e();
            ImpressionData impressionData = eVar.r;
            eVar2.a = impressionData != null ? impressionData.getDemandId() : null;
            try {
                eVar2.b = Long.valueOf(IAConfigManager.M.d);
            } catch (NumberFormatException unused) {
                IAlog.a("invalid publisherId", new Object[0]);
            }
            sVar.a(eVar2);
            com.fyber.inneractive.sdk.interfaces.a aVar2 = this.b;
            e eVar3 = this.a;
            boolean access$100 = a.this.mMuted;
            C0142a aVar3 = new C0142a();
            h hVar = (h) aVar2;
            hVar.h = access$100;
            hVar.a((InneractiveAdRequest) null, eVar3, sVar, aVar3, (a.b) null);
        }

        /* renamed from: com.fyber.marketplace.fairbid.impl.a$b$a  reason: collision with other inner class name */
        public class C0142a implements a.C0100a {
            public C0142a() {
            }

            public void a(InneractiveAdRequest inneractiveAdRequest) {
                b bVar = b.this;
                a.this.adSpot = new e(bVar.c, ((h) bVar.b).c);
                a aVar = a.this;
                aVar.internalOnAdLoaded(aVar, aVar.adSpot);
            }

            public void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
                b.this.d.onAdLoadFailed(MarketplaceAdLoadError.FAILED_TO_LOAD_AD);
            }
        }
    }
}
