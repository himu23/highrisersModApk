package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class na {
    private static na b;
    private ArrayList<NetworkSettings> a = new ArrayList<>();

    private na() {
    }

    public static synchronized na c() {
        na naVar;
        synchronized (na.class) {
            if (b == null) {
                b = new na();
            }
            naVar = b;
        }
        return naVar;
    }

    public HashSet<String> a(String str, String str2) {
        HashSet<String> hashSet = new HashSet<>();
        try {
            Iterator<NetworkSettings> it = this.a.iterator();
            while (it.hasNext()) {
                NetworkSettings next = it.next();
                if (next.getProviderTypeForReflection().equals(str)) {
                    if (next.getRewardedVideoSettings() != null && next.getRewardedVideoSettings().length() > 0 && !TextUtils.isEmpty(next.getRewardedVideoSettings().optString(str2))) {
                        hashSet.add(next.getRewardedVideoSettings().optString(str2));
                    }
                    if (next.getInterstitialSettings() != null && next.getInterstitialSettings().length() > 0 && !TextUtils.isEmpty(next.getInterstitialSettings().optString(str2))) {
                        hashSet.add(next.getInterstitialSettings().optString(str2));
                    }
                    if (next.getBannerSettings() != null && next.getBannerSettings().length() > 0 && !TextUtils.isEmpty(next.getBannerSettings().optString(str2))) {
                        hashSet.add(next.getBannerSettings().optString(str2));
                    }
                    if (next.getNativeAdSettings() != null && next.getNativeAdSettings().length() > 0 && !TextUtils.isEmpty(next.getNativeAdSettings().optString(str2))) {
                        hashSet.add(next.getNativeAdSettings().optString(str2));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return hashSet;
    }

    public void a() {
        Iterator<NetworkSettings> it = this.a.iterator();
        while (it.hasNext()) {
            NetworkSettings next = it.next();
            if (next.isMultipleInstances() && !TextUtils.isEmpty(next.getProviderTypeForReflection())) {
                NetworkSettings b2 = b(next.getProviderDefaultInstance());
                next.setApplicationSettings(IronSourceUtils.mergeJsons(next.getApplicationSettings(), b2.getApplicationSettings()));
                next.setInterstitialSettings(IronSourceUtils.mergeJsons(next.getInterstitialSettings(), b2.getInterstitialSettings()));
                next.setRewardedVideoSettings(IronSourceUtils.mergeJsons(next.getRewardedVideoSettings(), b2.getRewardedVideoSettings()));
                next.setBannerSettings(IronSourceUtils.mergeJsons(next.getBannerSettings(), b2.getBannerSettings()));
                next.setNativeAdSettings(IronSourceUtils.mergeJsons(next.getNativeAdSettings(), b2.getNativeAdSettings()));
            }
        }
    }

    public void a(NetworkSettings networkSettings) {
        if (networkSettings != null) {
            this.a.add(networkSettings);
        }
    }

    public boolean a(String str) {
        Iterator<NetworkSettings> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().getProviderName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public NetworkSettings b(String str) {
        Iterator<NetworkSettings> it = this.a.iterator();
        while (it.hasNext()) {
            NetworkSettings next = it.next();
            if (next.getProviderName().equals(str)) {
                return next;
            }
        }
        NetworkSettings networkSettings = new NetworkSettings(str);
        a(networkSettings);
        return networkSettings;
    }

    public ArrayList<NetworkSettings> b() {
        return this.a;
    }
}
