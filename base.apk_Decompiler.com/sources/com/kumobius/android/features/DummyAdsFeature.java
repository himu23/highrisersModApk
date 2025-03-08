package com.kumobius.android.features;

import com.kumobius.android.KumoAppActivity;

public class DummyAdsFeature implements IAdsFeature {
    public boolean adsGetIncentivisedAdPlaying() {
        return false;
    }

    public boolean adsGetIncentivisedAdReady() {
        return false;
    }

    public boolean adsGetIncentivisedAdsEnabled() {
        return false;
    }

    public String adsGetSystemName() {
        return "Dummy";
    }

    public boolean adsGetVideoAdPlaying() {
        return false;
    }

    public boolean adsGetVideoAdReady() {
        return false;
    }

    public boolean adsGetVideoAdsEnabled() {
        return false;
    }

    public void adsInit() {
    }

    public boolean adsOnBackPressed() {
        return false;
    }

    public void adsOnDestroy() {
    }

    public void adsOnPause() {
    }

    public void adsOnResume() {
    }

    public void adsOnStart() {
    }

    public void adsOnStop() {
    }

    public void adsRequestIncentivisedAd() {
    }

    public void adsRequestVideoAd() {
    }

    public void adsSetIncentivisedAdsEnabled(boolean z) {
    }

    public void adsSetVideoAdsEnabled(boolean z) {
    }

    public void adsShowDebugUi() {
    }

    public DummyAdsFeature(KumoAppActivity kumoAppActivity) {
    }
}
