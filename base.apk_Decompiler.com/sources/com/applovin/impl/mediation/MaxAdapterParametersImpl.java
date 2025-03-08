package com.applovin.impl.mediation;

import android.os.Bundle;
import com.applovin.impl.mediation.b.a;
import com.applovin.impl.mediation.b.f;
import com.applovin.impl.mediation.b.h;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import java.util.Map;

public class MaxAdapterParametersImpl implements MaxAdapterInitializationParameters, MaxAdapterResponseParameters, MaxAdapterSignalCollectionParameters {
    private MaxAdFormat adFormat;
    private String adUnitId;
    private Bundle ala;
    private Bundle alb;
    private Boolean alc;
    private Boolean ald;
    private Boolean ale;
    private String alf;
    private boolean alg;
    private String alh;
    private String ali;
    private long alj;
    private Map<String, Object> localExtraParameters;

    public MaxAdFormat getAdFormat() {
        return this.adFormat;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public long getBidExpirationMillis() {
        return this.alj;
    }

    public String getBidResponse() {
        return this.ali;
    }

    public String getConsentString() {
        return this.alf;
    }

    public Bundle getCustomParameters() {
        return this.alb;
    }

    public Map<String, Object> getLocalExtraParameters() {
        return this.localExtraParameters;
    }

    public Bundle getServerParameters() {
        return this.ala;
    }

    public String getThirdPartyAdPlacementId() {
        return this.alh;
    }

    public Boolean hasUserConsent() {
        return this.alc;
    }

    public Boolean isAgeRestrictedUser() {
        return this.ald;
    }

    public Boolean isDoNotSell() {
        return this.ale;
    }

    public boolean isTesting() {
        return this.alg;
    }

    private MaxAdapterParametersImpl() {
    }

    static MaxAdapterParametersImpl a(a aVar) {
        MaxAdapterParametersImpl a = a((f) aVar);
        a.alh = aVar.getThirdPartyAdPlacementId();
        a.ali = aVar.getBidResponse();
        a.alj = aVar.getBidExpirationMillis();
        return a;
    }

    static MaxAdapterParametersImpl a(h hVar, String str, MaxAdFormat maxAdFormat) {
        MaxAdapterParametersImpl a = a((f) hVar);
        a.adUnitId = str;
        a.adFormat = maxAdFormat;
        return a;
    }

    static MaxAdapterParametersImpl a(f fVar) {
        MaxAdapterParametersImpl maxAdapterParametersImpl = new MaxAdapterParametersImpl();
        maxAdapterParametersImpl.adUnitId = fVar.getAdUnitId();
        maxAdapterParametersImpl.alc = fVar.hasUserConsent();
        maxAdapterParametersImpl.ald = fVar.isAgeRestrictedUser();
        maxAdapterParametersImpl.ale = fVar.isDoNotSell();
        maxAdapterParametersImpl.alf = fVar.getConsentString();
        maxAdapterParametersImpl.localExtraParameters = fVar.getLocalExtraParameters();
        maxAdapterParametersImpl.ala = fVar.getServerParameters();
        maxAdapterParametersImpl.alb = fVar.getCustomParameters();
        maxAdapterParametersImpl.alg = fVar.isTesting();
        return maxAdapterParametersImpl;
    }
}
