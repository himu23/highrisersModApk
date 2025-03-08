package com.fyber.inneractive.sdk.config;

import android.app.Application;
import android.content.SharedPreferences;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;

public class d {
    public Boolean a = null;
    public String b = null;
    public InneractiveAdManager.GdprConsentSource c = null;
    public String d = null;
    public String e = null;
    public Boolean f = null;
    public Boolean g = null;
    public SharedPreferences h;

    public Boolean a() {
        if (p.a == null) {
            return null;
        }
        return this.a;
    }

    public void b() {
        Application application = p.a;
        if (this.h == null && application != null) {
            SharedPreferences sharedPreferences = application.getSharedPreferences("IAConfigurationPreferences", 0);
            this.h = sharedPreferences;
            if (sharedPreferences != null) {
                if (sharedPreferences.contains("IAGDPRBool")) {
                    this.a = Boolean.valueOf(sharedPreferences.getBoolean("IAGDPRBool", false));
                }
                if (sharedPreferences.contains("IAGdprConsentData")) {
                    this.b = sharedPreferences.getString("IAGdprConsentData", (String) null);
                }
                if (sharedPreferences.contains("IACCPAConsentData")) {
                    this.e = sharedPreferences.getString("IACCPAConsentData", (String) null);
                }
                if (sharedPreferences.contains("IAGdprSource")) {
                    try {
                        this.c = InneractiveAdManager.GdprConsentSource.valueOf(sharedPreferences.getString("IAGdprSource", InneractiveAdManager.GdprConsentSource.Internal.toString()));
                    } catch (Exception unused) {
                        this.c = InneractiveAdManager.GdprConsentSource.Internal;
                    }
                }
                if (sharedPreferences.contains("IALgpdConsentStatus")) {
                    this.f = Boolean.valueOf(sharedPreferences.getBoolean("IALgpdConsentStatus", false));
                }
                if (sharedPreferences.contains("keyUserID")) {
                    this.d = sharedPreferences.getString("keyUserID", (String) null);
                }
            }
        }
    }

    public final boolean a(String str, boolean z) {
        if (p.a == null) {
            return false;
        }
        b();
        SharedPreferences sharedPreferences = this.h;
        if (sharedPreferences == null) {
            return false;
        }
        sharedPreferences.edit().putBoolean(str, z).apply();
        return true;
    }

    public final boolean a(String str, String str2) {
        if (p.a == null) {
            return false;
        }
        b();
        if (this.h == null) {
            return false;
        }
        IAlog.a("Saving %s value = %s to sharedPrefs", str, str2);
        this.h.edit().putString(str, str2).apply();
        return true;
    }
}
