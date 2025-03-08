package com.applovin.impl.mediation;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.unity3d.ads.metadata.MediationMetaData;
import org.json.JSONObject;

public class MaxMediatedNetworkInfoImpl implements MaxMediatedNetworkInfo {
    private final JSONObject alk;

    public MaxMediatedNetworkInfoImpl(JSONObject jSONObject) {
        this.alk = jSONObject;
    }

    public String getName() {
        return JsonUtils.getString(this.alk, "name", "");
    }

    public String getAdapterClassName() {
        return JsonUtils.getString(this.alk, "class", "");
    }

    public String getAdapterVersion() {
        return JsonUtils.getString(this.alk, MediationMetaData.KEY_VERSION, "");
    }

    public String getSdkVersion() {
        return JsonUtils.getString(this.alk, "sdk_version", "");
    }

    public String toString() {
        return "MaxMediatedNetworkInfo{name=" + getName() + ", adapterClassName=" + getAdapterClassName() + ", adapterVersion=" + getAdapterVersion() + ", sdkVersion=" + getSdkVersion() + '}';
    }
}
