package com.kumobius.android;

import java.nio.ByteBuffer;

interface INativeResponder {
    boolean adsGetIncentivisedAdPlaying();

    boolean adsGetIncentivisedAdReady();

    boolean adsGetIncentivisedAdsEnabled();

    String adsGetSystemName();

    boolean adsGetVideoAdPlaying();

    boolean adsGetVideoAdReady();

    boolean adsGetVideoAdsEnabled();

    void adsRequestIncentivisedAd();

    void adsRequestVideoAd();

    void adsSetIncentivisedAdsEnabled(boolean z);

    void adsSetVideoAdsEnabled(boolean z);

    void adsShowDebugUi();

    void analyticsAddEventParam(String str, String str2);

    void analyticsBeginEvent();

    void analyticsEndTimedEvent(String str);

    void analyticsLogEvent(String str, boolean z);

    void bragFacebook(String str, String str2);

    void bragImage(String str, ByteBuffer byteBuffer, int i, int i2);

    void bragTwitter(String str, String str2);

    boolean canOpenUrl(String str);

    int checkPrompt(long j);

    void cloudClearAll();

    void cloudPushData(String[] strArr, String[] strArr2);

    void cloudReady();

    void exitGame();

    float getMusicSyncTime();

    float getSoundPitch(long j);

    boolean getSoundPlaying(long j);

    float getSoundVolume(long j);

    boolean iapCanPurchase(String str);

    String iapGetDescription(String str);

    String iapGetError();

    String iapGetName(String str);

    String iapGetPrice(String str);

    int iapGetStatus();

    void iapLoadProducts(String[] strArr);

    void iapPurchase(String str);

    void iapRestore();

    boolean isAppInstalled(String str);

    boolean isPlayingVideo();

    void loadSound(String str, String str2);

    void notificationCancelAll();

    void notificationSchedule(long j, String str);

    void openUrl(String str);

    void playMusic(String str, int i, int i2);

    long playSound(String str, float f, float f2, int i);

    void playVideo(String str);

    void playVoice(String str);

    long prompt(String str, String str2, String str3, String str4);

    void promptOpenURL(String str, String str2, String str3, String str4, String str5);

    boolean scoreCanLogInOut();

    boolean scoreIsLoggedIn();

    void scoreLogInOut();

    void scoreSubmit(String[] strArr, String[] strArr2, long[] jArr);

    void setMusicEnabled(int i);

    void setMusicVolume(float f);

    void setSoundPitch(long j, float f);

    void setSoundVolume(long j, float f);

    void showAchievementUi();

    void showScoreUi(String str);

    void startDownload(long j, String str);

    void stopMusic();

    void stopSound(long j);

    void unloadSound(String str);
}
