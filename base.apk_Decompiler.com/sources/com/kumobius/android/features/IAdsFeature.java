package com.kumobius.android.features;

public interface IAdsFeature {
    boolean adsGetIncentivisedAdPlaying();

    boolean adsGetIncentivisedAdReady();

    boolean adsGetIncentivisedAdsEnabled();

    String adsGetSystemName();

    boolean adsGetVideoAdPlaying();

    boolean adsGetVideoAdReady();

    boolean adsGetVideoAdsEnabled();

    void adsInit();

    boolean adsOnBackPressed();

    void adsOnDestroy();

    void adsOnPause();

    void adsOnResume();

    void adsOnStart();

    void adsOnStop();

    void adsRequestIncentivisedAd();

    void adsRequestVideoAd();

    void adsSetIncentivisedAdsEnabled(boolean z);

    void adsSetVideoAdsEnabled(boolean z);

    void adsShowDebugUi();
}
