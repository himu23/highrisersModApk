package com.fyber.inneractive.sdk.external;

import android.content.SharedPreferences;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.p;
import org.json.JSONArray;

public class b implements Runnable {
    public b(InneractiveAdManager inneractiveAdManager) {
    }

    public void run() {
        IAConfigManager iAConfigManager = IAConfigManager.M;
        SharedPreferences sharedPreferences = p.a.getSharedPreferences("IAConfigurationPreferences", 0);
        if (sharedPreferences == null || !sharedPreferences.contains("IAConfigFQE")) {
            SharedPreferences sharedPreferences2 = p.a.getSharedPreferences("IAConfigurationPreferences", 0);
            if (sharedPreferences2 != null) {
                sharedPreferences2.edit().putBoolean("IAConfigFQE", true).apply();
            }
            new s.a(r.FIRST_OPENED, (InneractiveAdRequest) null, (e) null, (JSONArray) null).a((String) null);
        }
    }
}
