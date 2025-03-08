package com.applovin.impl.mediation.d;

import android.net.Uri;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.b.a;
import com.applovin.impl.mediation.b.f;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.h;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.ironsource.i9;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends com.applovin.impl.sdk.e.d {
    private final f ami;
    private final String awv;
    private final String aww;
    private final Map<String, String> awx;
    private final Map<String, String> awy;
    private final MaxError awz;

    public d(String str, Map<String, String> map, MaxError maxError, f fVar, n nVar, boolean z) {
        super("TaskFireMediationPostbacks", nVar);
        MaxError maxError2;
        this.awv = str;
        this.aww = str + "_urls";
        this.awx = u.a(map, nVar);
        if (maxError != null) {
            maxError2 = maxError;
        } else {
            maxError2 = new MaxErrorImpl(-1);
        }
        this.awz = maxError2;
        this.ami = fVar;
        HashMap hashMap = new HashMap(7);
        hashMap.put("AppLovin-Event-Type", str);
        if (z) {
            hashMap.put("AppLovin-Ad-Network-Name", fVar.yA());
        }
        if (fVar instanceof a) {
            a aVar = (a) fVar;
            hashMap.put("AppLovin-Ad-Unit-Id", aVar.getAdUnitId());
            hashMap.put("AppLovin-Ad-Format", aVar.getFormat().getLabel());
            if (z) {
                hashMap.put("AppLovin-Third-Party-Ad-Placement-ID", aVar.getThirdPartyAdPlacementId());
            }
        }
        if (maxError != null) {
            hashMap.put("AppLovin-Error-Code", String.valueOf(maxError.getCode()));
            hashMap.put("AppLovin-Error-Message", maxError.getMessage());
        }
        this.awy = hashMap;
    }

    public void run() {
        List<String> bZ = this.ami.bZ(this.aww);
        Map<String, String> zG = zG();
        for (String c : bZ) {
            Uri parse = Uri.parse(c(c(c, this.awx), this.awz));
            Uri.Builder clearQuery = parse.buildUpon().clearQuery();
            HashMap hashMap = new HashMap(zG.size());
            for (String next : parse.getQueryParameterNames()) {
                String queryParameter = parse.getQueryParameter(next);
                if (zG.containsKey(queryParameter)) {
                    hashMap.put(next, this.ami.ca(zG.get(queryParameter)));
                } else {
                    clearQuery.appendQueryParameter(next, queryParameter);
                }
            }
            b(clearQuery.build().toString(), hashMap);
        }
    }

    private void b(String str, Map<String, Object> map) {
        getSdk().Cu().a(h.ID().dd(str).dc(i9.b).o(this.awy).aV(false).p(map).aW(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aKg)).booleanValue()).IF());
    }

    private Map<String, String> zG() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) this.sdk.a(com.applovin.impl.sdk.c.a.aJm)));
        } catch (JSONException unused) {
            return Collections.EMPTY_MAP;
        }
    }

    private String c(String str, Map<String, String> map) {
        for (String next : map.keySet()) {
            str = str.replace(next, StringUtils.emptyIfNull(map.get(next)));
        }
        return str;
    }

    private String c(String str, MaxError maxError) {
        int i;
        String str2;
        if (maxError instanceof MaxAdapterError) {
            MaxAdapterError maxAdapterError = (MaxAdapterError) maxError;
            i = maxAdapterError.getMediatedNetworkErrorCode();
            str2 = maxAdapterError.getMediatedNetworkErrorMessage();
        } else {
            i = 0;
            str2 = "";
        }
        return str.replace("{ERROR_CODE}", String.valueOf(maxError.getCode())).replace("{ERROR_MESSAGE}", StringUtils.encodeUriString(maxError.getMessage())).replace("{THIRD_PARTY_SDK_ERROR_CODE}", String.valueOf(i)).replace("{THIRD_PARTY_SDK_ERROR_MESSAGE}", StringUtils.encodeUriString(str2));
    }
}
