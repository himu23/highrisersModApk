package com.kumobius.android.features;

import android.content.Intent;
import com.kumobius.android.KumoAppActivity;

public class DummyAchievementsFeature implements IAchievementsFeature {
    public void bragFacebook(String str, String str2) {
    }

    public void bragTwitter(String str, String str2) {
    }

    public boolean canBragFacebook() {
        return false;
    }

    public boolean canBragTwitter() {
        return false;
    }

    public boolean canLogInOut() {
        return false;
    }

    public boolean isLoggedIn() {
        return false;
    }

    public void logInOut() {
    }

    public void scoreSubmit(String[] strArr, String[] strArr2, long[] jArr) {
    }

    public void scoresOnActivityResult(int i, int i2, Intent intent) {
    }

    public void scoresOnPause() {
    }

    public void scoresOnResume() {
    }

    public void scoresOnStart() {
    }

    public void scoresOnStop() {
    }

    public void showAchievementUi() {
    }

    public void showScoreUi(String str) {
    }

    public void socialInit() {
    }

    public DummyAchievementsFeature(KumoAppActivity kumoAppActivity) {
    }
}
