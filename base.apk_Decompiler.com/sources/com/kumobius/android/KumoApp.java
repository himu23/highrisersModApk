package com.kumobius.android;

import android.content.Context;
import android.util.Log;
import com.kumobius.android.features.GooglePlayGamesFeatures;
import com.kumobius.android.features.IAchievementsFeature;
import com.kumobius.android.features.ICloudFeature;
import com.kumobius.android.highrisers.R;
import java.util.WeakHashMap;

public class KumoApp extends KumoAppBase {
    private static final WeakHashMap<KumoAppActivity, GooglePlayGamesFeatures> s_GooglePlayGamesFeatures = new WeakHashMap<>();
    private static final String s_TAG = "KumoJava";

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void onCreate() {
        super.onCreate();
        if (Utils.hasString(this, R.string.googlePlayAppId)) {
            Log.v(s_TAG, "Using Google Play services.");
            addOverride("googleplus");
            setAchievementsFeatureFactory(new KumoApp$$ExternalSyntheticLambda0());
            setCloudFeatureFactory(new KumoApp$$ExternalSyntheticLambda1());
        }
        Log.v(s_TAG, "Using Google Play billing.");
        setIapFeatureFactory(new KumoApp$$ExternalSyntheticLambda2());
        setAdsFeatureFactory(new KumoApp$$ExternalSyntheticLambda3());
    }

    static /* synthetic */ IAchievementsFeature lambda$onCreate$0(KumoAppActivity kumoAppActivity) {
        WeakHashMap<KumoAppActivity, GooglePlayGamesFeatures> weakHashMap = s_GooglePlayGamesFeatures;
        GooglePlayGamesFeatures googlePlayGamesFeatures = weakHashMap.get(kumoAppActivity);
        if (googlePlayGamesFeatures != null) {
            return googlePlayGamesFeatures;
        }
        GooglePlayGamesFeatures googlePlayGamesFeatures2 = new GooglePlayGamesFeatures(kumoAppActivity);
        weakHashMap.put(kumoAppActivity, googlePlayGamesFeatures2);
        return googlePlayGamesFeatures2;
    }

    static /* synthetic */ ICloudFeature lambda$onCreate$1(KumoAppActivity kumoAppActivity) {
        WeakHashMap<KumoAppActivity, GooglePlayGamesFeatures> weakHashMap = s_GooglePlayGamesFeatures;
        GooglePlayGamesFeatures googlePlayGamesFeatures = weakHashMap.get(kumoAppActivity);
        if (googlePlayGamesFeatures != null) {
            return googlePlayGamesFeatures;
        }
        GooglePlayGamesFeatures googlePlayGamesFeatures2 = new GooglePlayGamesFeatures(kumoAppActivity);
        weakHashMap.put(kumoAppActivity, googlePlayGamesFeatures2);
        return googlePlayGamesFeatures2;
    }
}
