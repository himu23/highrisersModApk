package com.ironsource.sdk.controller;

import com.ironsource.m2;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class FeaturesManager {
    private static volatile FeaturesManager c = null;
    private static final String d = "debugMode";
    private Map<String, ?> a;
    private final ArrayList<String> b = new a();

    class a extends ArrayList<String> {
        a() {
            add(m2.d.f);
            add(m2.d.e);
            add(m2.d.g);
            add(m2.d.h);
            add(m2.d.i);
            add(m2.d.j);
            add(m2.d.k);
            add(m2.d.l);
            add(m2.d.m);
        }
    }

    private FeaturesManager() {
        if (c == null) {
            this.a = new HashMap();
            return;
        }
        throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
    }

    public static FeaturesManager getInstance() {
        if (c == null) {
            synchronized (FeaturesManager.class) {
                if (c == null) {
                    c = new FeaturesManager();
                }
            }
        }
        return c;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> a() {
        return new ArrayList<>(this.b);
    }

    public JSONObject getDataManagerConfig() {
        JSONObject networkConfiguration = SDKUtils.getNetworkConfiguration();
        return networkConfiguration.has(m2.a.c) ? networkConfiguration.optJSONObject(m2.a.c) : new JSONObject();
    }

    public int getDebugMode() {
        Integer num = 0;
        try {
            if (this.a.containsKey("debugMode")) {
                num = (Integer) this.a.get("debugMode");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int getInitRecoverTrials() {
        JSONObject optJSONObject = SDKUtils.getNetworkConfiguration().optJSONObject(m2.a.e);
        if (optJSONObject != null) {
            return optJSONObject.optInt(m2.a.d, 0);
        }
        return 0;
    }

    public void updateDebugConfigurations(Map<String, Object> map) {
        if (map != null) {
            this.a = map;
        }
    }
}
