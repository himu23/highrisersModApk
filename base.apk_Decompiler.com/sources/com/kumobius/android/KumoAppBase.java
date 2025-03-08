package com.kumobius.android;

import android.app.Application;
import com.kumobius.android.features.DefaultFileAccessorFeature;
import com.kumobius.android.features.DummyAchievementsFeature;
import com.kumobius.android.features.DummyAdsFeature;
import com.kumobius.android.features.DummyAnalyticsFeature;
import com.kumobius.android.features.DummyCloudFeature;
import com.kumobius.android.features.DummyIapFeature;
import com.kumobius.android.features.IAchievementsFeature;
import com.kumobius.android.features.IAdsFeature;
import com.kumobius.android.features.IAnalyticsFeature;
import com.kumobius.android.features.ICloudFeature;
import com.kumobius.android.features.IFeatureFactory;
import com.kumobius.android.features.IFileAccessorFeature;
import com.kumobius.android.features.IIapFeature;
import java.util.HashSet;
import java.util.Set;

class KumoAppBase extends Application {
    private static IFeatureFactory<IAchievementsFeature> s_AchievementsFeatureFactory;
    private static IFeatureFactory<IAdsFeature> s_AdsFeatureFactory;
    private static IFeatureFactory<IAnalyticsFeature> s_AnalyticsFeatureFactory;
    private static IFeatureFactory<ICloudFeature> s_CloudFeatureFactory;
    private static IFeatureFactory<IFileAccessorFeature> s_FileAccessorFeatureFactory;
    private static IFeatureFactory<IIapFeature> s_IapFeatureFactory;
    private static final Set<String> s_Overrides = new HashSet();

    public static IFeatureFactory<IAchievementsFeature> getAchievementsFeatureFactory() {
        return s_AchievementsFeatureFactory;
    }

    public static IFeatureFactory<IAdsFeature> getAdsFeatureFactory() {
        return s_AdsFeatureFactory;
    }

    public static IFeatureFactory<IAnalyticsFeature> getAnalyticsFeatureFactory() {
        return s_AnalyticsFeatureFactory;
    }

    public static IFeatureFactory<ICloudFeature> getCloudFeatureFactory() {
        return s_CloudFeatureFactory;
    }

    public static IFeatureFactory<IFileAccessorFeature> getFileAccessorFeatureFactory() {
        return s_FileAccessorFeatureFactory;
    }

    public static IFeatureFactory<IIapFeature> getIapFeatureFactory() {
        return s_IapFeatureFactory;
    }

    public static Set<String> getOverrides() {
        return s_Overrides;
    }

    static void setAchievementsFeatureFactory(IFeatureFactory<IAchievementsFeature> iFeatureFactory) {
        s_AchievementsFeatureFactory = iFeatureFactory;
    }

    static void setAdsFeatureFactory(IFeatureFactory<IAdsFeature> iFeatureFactory) {
        s_AdsFeatureFactory = iFeatureFactory;
    }

    static void setAnalyticsFeatureFactory(IFeatureFactory<IAnalyticsFeature> iFeatureFactory) {
        s_AnalyticsFeatureFactory = iFeatureFactory;
    }

    static void setCloudFeatureFactory(IFeatureFactory<ICloudFeature> iFeatureFactory) {
        s_CloudFeatureFactory = iFeatureFactory;
    }

    static void setFileAccessorFeatureFactory(IFeatureFactory<IFileAccessorFeature> iFeatureFactory) {
        s_FileAccessorFeatureFactory = iFeatureFactory;
    }

    static void setIapFeatureFactory(IFeatureFactory<IIapFeature> iFeatureFactory) {
        s_IapFeatureFactory = iFeatureFactory;
    }

    KumoAppBase() {
    }

    public void onCreate() {
        super.onCreate();
        setAnalyticsFeatureFactory(new IFeatureFactory<IAnalyticsFeature>() {
            public IAnalyticsFeature create(KumoAppActivity kumoAppActivity) {
                return new DummyAnalyticsFeature(kumoAppActivity);
            }
        });
        setAchievementsFeatureFactory(new IFeatureFactory<IAchievementsFeature>() {
            public IAchievementsFeature create(KumoAppActivity kumoAppActivity) {
                return new DummyAchievementsFeature(kumoAppActivity);
            }
        });
        setAdsFeatureFactory(new IFeatureFactory<IAdsFeature>() {
            public IAdsFeature create(KumoAppActivity kumoAppActivity) {
                return new DummyAdsFeature(kumoAppActivity);
            }
        });
        setCloudFeatureFactory(new IFeatureFactory<ICloudFeature>() {
            public ICloudFeature create(KumoAppActivity kumoAppActivity) {
                return new DummyCloudFeature(kumoAppActivity);
            }
        });
        setIapFeatureFactory(new IFeatureFactory<IIapFeature>() {
            public IIapFeature create(KumoAppActivity kumoAppActivity) {
                return new DummyIapFeature(kumoAppActivity);
            }
        });
        setFileAccessorFeatureFactory(new IFeatureFactory<IFileAccessorFeature>() {
            public IFileAccessorFeature create(KumoAppActivity kumoAppActivity) {
                return new DefaultFileAccessorFeature(kumoAppActivity);
            }
        });
    }

    static void addOverride(String str) {
        s_Overrides.add(str);
    }
}
