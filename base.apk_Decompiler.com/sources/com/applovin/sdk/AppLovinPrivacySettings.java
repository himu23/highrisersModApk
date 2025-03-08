package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.privacy.a;
import com.applovin.impl.sdk.x;

public class AppLovinPrivacySettings {
    public static void setHasUserConsent(boolean z, Context context) {
        x.D("AppLovinPrivacySettings", "setHasUserConsent()");
        if (a.b(z, context)) {
            AppLovinSdk.reinitializeAll(Boolean.valueOf(z), (Boolean) null, (Boolean) null);
        }
    }

    public static boolean hasUserConsent(Context context) {
        x.D("AppLovinPrivacySettings", "hasUserConsent()");
        Boolean B = a.zP().B(context);
        if (B != null) {
            return B.booleanValue();
        }
        return false;
    }

    public static boolean isUserConsentSet(Context context) {
        x.D("AppLovinPrivacySettings", "isUserConsentSet()");
        return a.zP().B(context) != null;
    }

    public static void setIsAgeRestrictedUser(boolean z, Context context) {
        x.D("AppLovinPrivacySettings", "setIsAgeRestrictedUser()");
        if (a.a(z, context)) {
            AppLovinSdk.reinitializeAll((Boolean) null, Boolean.valueOf(z), (Boolean) null);
        }
    }

    public static boolean isAgeRestrictedUser(Context context) {
        x.D("AppLovinPrivacySettings", "isAgeRestrictedUser()");
        Boolean B = a.zO().B(context);
        if (B != null) {
            return B.booleanValue();
        }
        return false;
    }

    public static boolean isAgeRestrictedUserSet(Context context) {
        x.D("AppLovinPrivacySettings", "isAgeRestrictedUserSet()");
        return a.zO().B(context) != null;
    }

    public static void setDoNotSell(boolean z, Context context) {
        x.D("AppLovinPrivacySettings", "setDoNotSell()");
        if (a.c(z, context)) {
            AppLovinSdk.reinitializeAll((Boolean) null, (Boolean) null, Boolean.valueOf(z));
        }
    }

    public static boolean isDoNotSell(Context context) {
        x.D("AppLovinPrivacySettings", "isDoNotSell()");
        Boolean B = a.zQ().B(context);
        if (B != null) {
            return B.booleanValue();
        }
        return false;
    }

    public static boolean isDoNotSellSet(Context context) {
        x.D("AppLovinPrivacySettings", "isDoNotSellSet()");
        return a.zQ().B(context) != null;
    }
}
