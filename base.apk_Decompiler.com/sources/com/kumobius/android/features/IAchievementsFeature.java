package com.kumobius.android.features;

import android.content.Intent;

public interface IAchievementsFeature {
    void bragFacebook(String str, String str2);

    void bragTwitter(String str, String str2);

    boolean canBragFacebook();

    boolean canBragTwitter();

    boolean canLogInOut();

    boolean isLoggedIn();

    void logInOut();

    void scoreSubmit(String[] strArr, String[] strArr2, long[] jArr);

    void scoresOnActivityResult(int i, int i2, Intent intent);

    void scoresOnPause();

    void scoresOnResume();

    void scoresOnStart();

    void scoresOnStop();

    void showAchievementUi();

    void showScoreUi(String str);

    void socialInit();
}
