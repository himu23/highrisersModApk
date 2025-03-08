package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class m extends n {
    private final List<String> aUj;

    public m(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener, n nVar) {
        super(d.cQ(L(list)), appLovinAdLoadListener, "TaskFetchMultizoneAd", nVar);
        this.aUj = Collections.unmodifiableList(list);
    }

    private static String L(List<String> list) {
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        throw new IllegalArgumentException("No zone identifiers specified");
    }

    /* access modifiers changed from: protected */
    public Map<String, String> HI() {
        HashMap hashMap = new HashMap(1);
        List<String> list = this.aUj;
        hashMap.put("zone_ids", CollectionUtils.implode(list, list.size()));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public b getSource() {
        return b.APPLOVIN_MULTIZONE;
    }
}
