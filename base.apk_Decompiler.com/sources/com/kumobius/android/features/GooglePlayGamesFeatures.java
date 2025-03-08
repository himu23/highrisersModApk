package com.kumobius.android.features;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.games.AchievementsClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.kumobius.android.KumoAppActivity;
import com.kumobius.android.NativeInterface;
import com.kumobius.android.features.gamegoogleplay.R;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class GooglePlayGamesFeatures implements IAchievementsFeature, ICloudFeature {
    private static final String GAMEHELPER_SHARED_PREFS = "GAMEHELPER_SHARED_PREFS";
    private static final String KEY_SIGN_IN_CANCELLATIONS = "KEY_SIGN_IN_CANCELLATIONS";
    private static final int MAX_LOGIN_PROMPTS = 1;
    private static final int REQUEST_ACHIEVEMENTS = 2003;
    private static final int REQUEST_ERROR_DIALOG = 2004;
    private static final int REQUEST_LEADERBOARD = 2002;
    private static final int REQUEST_SIGNIN = 2001;
    private static final String s_SnapshotFileName = "game";
    private static final String s_TAG = "KumoJavaGooglePlay";
    private final HashMap<String, String> m_AchievementIds;
    private AchievementsClient m_AchievementsClient = null;
    /* access modifiers changed from: private */
    public final KumoAppActivity m_Activity;
    /* access modifiers changed from: private */
    public HashMap<String, String> m_CloudData;
    /* access modifiers changed from: private */
    public boolean m_CloudLoadingData;
    /* access modifiers changed from: private */
    public final Object m_CloudLock;
    private boolean m_CloudReady;
    /* access modifiers changed from: private */
    public Snapshot m_CloudSnapshot;
    private final CommitSnapshotResult m_CommitSnapshotResult;
    private GamesClient m_GamesClient = null;
    private int m_GoogleApiAvailability = 8;
    private boolean m_GoogleApiAvailabilityUserRecoverable = false;
    private GoogleSignInClient m_GoogleSignIn;
    private final HashMap<String, String> m_LeaderboardIds;
    private LeaderboardsClient m_LeaderboardsClient = null;
    /* access modifiers changed from: private */
    public final OpenSnapshotResult m_OpenSnapshotResult;
    private boolean m_PendClearAll;
    private final Vector<String> m_PendPushKeys;
    private final Vector<String> m_PendPushVals;
    private Runnable m_PostSignInAction = null;
    private SignInCompleteListener m_SignInCompleteListener = new SignInCompleteListener();
    /* access modifiers changed from: private */
    public boolean m_SignedIn = false;
    /* access modifiers changed from: private */
    public final Object m_SignedInLock = new Object();
    /* access modifiers changed from: private */
    public SnapshotsClient m_SnapshotsClient = null;

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
        return this.m_GoogleApiAvailability == 0 || this.m_GoogleApiAvailabilityUserRecoverable;
    }

    public void scoresOnStart() {
    }

    public void scoresOnStop() {
    }

    public void socialInit() {
    }

    public GooglePlayGamesFeatures(KumoAppActivity kumoAppActivity) {
        HashMap<String, String> hashMap = new HashMap<>();
        this.m_AchievementIds = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        this.m_LeaderboardIds = hashMap2;
        this.m_CloudLock = new Object();
        this.m_CloudReady = false;
        this.m_CloudSnapshot = null;
        this.m_CloudLoadingData = false;
        this.m_PendClearAll = false;
        this.m_PendPushKeys = new Vector<>();
        this.m_PendPushVals = new Vector<>();
        this.m_CloudData = null;
        this.m_CommitSnapshotResult = new CommitSnapshotResult();
        this.m_OpenSnapshotResult = new OpenSnapshotResult();
        this.m_Activity = kumoAppActivity;
        this.m_GoogleSignIn = createGoogleSignInClient();
        addAllMappings(hashMap, R.array.androidAchievementMappingKeys, R.array.androidAchievementMappingValues);
        addAllMappings(hashMap2, R.array.androidLeaderboardMappingKeys, R.array.androidLeaderboardMappingValues);
    }

    private GoogleSignInClient createGoogleSignInClient() {
        try {
            int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.m_Activity);
            this.m_GoogleApiAvailability = isGooglePlayServicesAvailable;
            if (isGooglePlayServicesAvailable == 0) {
                return GoogleSignIn.getClient((Activity) this.m_Activity, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN).requestScopes(Drive.SCOPE_APPFOLDER, new Scope[0]).build());
            }
            this.m_GoogleApiAvailabilityUserRecoverable = GoogleApiAvailability.getInstance().isUserResolvableError(this.m_GoogleApiAvailability);
            Log.w(s_TAG, String.format("Google Play unavailable: %s", new Object[]{GoogleApiAvailability.getInstance().getErrorString(this.m_GoogleApiAvailability)}));
            return null;
        } catch (Exception e) {
            this.m_GoogleApiAvailability = 8;
            Log.e(s_TAG, "Google Play Error", e);
            return null;
        }
    }

    private void showGoogleAvailabilityError(boolean z) {
        try {
            if (this.m_GoogleApiAvailability != 0) {
                if (z && this.m_GoogleApiAvailabilityUserRecoverable) {
                    GoogleApiAvailability.getInstance().getErrorDialog((Activity) this.m_Activity, this.m_GoogleApiAvailability, 2004).show();
                }
            }
        } catch (Exception e) {
            Log.e(s_TAG, "Google Play Error", e);
        }
    }

    private void addAllMappings(HashMap<String, String> hashMap, int i, int i2) {
        String[] stringArray = this.m_Activity.getResources().getStringArray(i);
        String[] stringArray2 = this.m_Activity.getResources().getStringArray(i2);
        if (stringArray.length == stringArray2.length) {
            for (int i3 = 0; i3 < stringArray.length; i3++) {
                addMapping(hashMap, stringArray[i3], stringArray2[i3]);
            }
        }
    }

    private void addMapping(HashMap<String, String> hashMap, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            hashMap.put(str, str2);
        }
    }

    public void scoresOnResume() {
        silentSignIn();
    }

    public void scoresOnPause() {
        markAsSignedOut();
    }

    public void scoresOnActivityResult(int i, int i2, Intent intent) {
        try {
            Log.v(s_TAG, String.format("onActivityResult(int %d, int %d, Intent data)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            if (i == 2001) {
                onGoogleSignInResult(Auth.GoogleSignInApi.getSignInResultFromIntent(intent));
            }
        } catch (Exception e) {
            Log.e(s_TAG, "Google Play Error", e);
        }
    }

    private void onGoogleSignInResult(GoogleSignInResult googleSignInResult) {
        GoogleSignInAccount signInAccount;
        if (googleSignInResult == null || !googleSignInResult.isSuccess() || (signInAccount = googleSignInResult.getSignInAccount()) == null) {
            onSignInFailed(false);
            showErrorDialog(googleSignInResult);
            return;
        }
        onSignInSucceeded(signInAccount);
    }

    private void showErrorDialog(GoogleSignInResult googleSignInResult) {
        String str;
        if (googleSignInResult != null) {
            int statusCode = googleSignInResult.getStatus().getStatusCode();
            if (statusCode != 16 && statusCode != 17 && statusCode != 12501) {
                str = googleSignInResult.getStatus().getStatusMessage();
            } else {
                return;
            }
        } else {
            str = null;
        }
        if (str == null || str.isEmpty()) {
            str = "Unknown error";
        }
        new AlertDialog.Builder(this.m_Activity).setMessage((CharSequence) str).setNeutralButton(17039370, (DialogInterface.OnClickListener) null).show();
    }

    public void scoreSubmit(final String[] strArr, final String[] strArr2, final long[] jArr) {
        this.m_Activity.runOnUiThread(new Runnable() {
            public void run() {
                GooglePlayGamesFeatures.this.doScoreSubmit(strArr, strArr2, jArr);
            }
        });
    }

    /* access modifiers changed from: private */
    public void doScoreSubmit(String[] strArr, String[] strArr2, long[] jArr) {
        try {
            if (this.m_AchievementsClient == null) {
                return;
            }
            if (this.m_LeaderboardsClient != null) {
                String[] strArr3 = new String[strArr.length];
                String[] strArr4 = new String[strArr2.length];
                long[] jArr2 = new long[jArr.length];
                int i = 0;
                for (String str : strArr) {
                    if (doSubmitAchievement(str)) {
                        strArr3[i] = str;
                        i++;
                    }
                }
                String[] strArr5 = (String[]) Arrays.copyOf(strArr3, i);
                int i2 = 0;
                for (int i3 = 0; i3 < strArr2.length; i3++) {
                    if (doSubmitScore(strArr2[i3], jArr[i3])) {
                        strArr4[i2] = strArr2[i3];
                        jArr2[i2] = jArr[i3];
                        i2++;
                    }
                }
                NativeInterface.scoresSubmitted(this.m_Activity, strArr5, (String[]) Arrays.copyOf(strArr4, i2), Arrays.copyOf(jArr2, i2));
            }
        } catch (Exception e) {
            Log.e(s_TAG, "Google Play Error", e);
        }
    }

    private boolean doSubmitAchievement(String str) {
        String achievementId = getAchievementId(str);
        if (achievementId != null) {
            this.m_AchievementsClient.unlock(achievementId);
            return true;
        }
        Log.w(s_TAG, "Unknown achievement: " + str);
        return false;
    }

    private boolean doSubmitScore(String str, long j) {
        String leaderboardId = getLeaderboardId(str);
        if (leaderboardId != null) {
            this.m_LeaderboardsClient.submitScore(leaderboardId, j);
            return true;
        }
        Log.w(s_TAG, "Unknown leaderboard: " + str);
        return false;
    }

    public void showAchievementUi() {
        this.m_Activity.runOnUiThread(new Runnable() {
            public void run() {
                GooglePlayGamesFeatures.this.doShowAchievementUi(true);
            }
        });
    }

    private void StartActivityForResultIfSuccess(Task<Intent> task, final int i) {
        task.addOnSuccessListener(new OnSuccessListener<Intent>() {
            public void onSuccess(Intent intent) {
                GooglePlayGamesFeatures.this.m_Activity.startActivityForResult(intent, i);
            }
        });
    }

    /* access modifiers changed from: private */
    public void doShowAchievementUi(boolean z) {
        try {
            if (isLoggedIn()) {
                AchievementsClient achievementsClient = this.m_AchievementsClient;
                if (achievementsClient == null) {
                    Log.w(s_TAG, "No achievements client.");
                } else {
                    StartActivityForResultIfSuccess(achievementsClient.getAchievementsIntent(), 2003);
                }
            } else if (z) {
                Log.v(s_TAG, "Logged out; logging back in...");
                signIn(true, new Runnable() {
                    public void run() {
                        GooglePlayGamesFeatures.this.doShowAchievementUi(false);
                    }
                });
            }
        } catch (Exception e) {
            Log.e(s_TAG, "Google Play Error", e);
        }
    }

    public void showScoreUi(final String str) {
        this.m_Activity.runOnUiThread(new Runnable() {
            public void run() {
                GooglePlayGamesFeatures.this.doShowScoreUi(str, true);
            }
        });
    }

    /* access modifiers changed from: private */
    public void doShowScoreUi(final String str, boolean z) {
        try {
            if (isLoggedIn()) {
                if (this.m_LeaderboardsClient == null) {
                    Log.w(s_TAG, "No leaderboards client.");
                    return;
                }
                String leaderboardId = getLeaderboardId(str);
                if (leaderboardId == null) {
                    StartActivityForResultIfSuccess(this.m_LeaderboardsClient.getAllLeaderboardsIntent(), 2002);
                } else {
                    StartActivityForResultIfSuccess(this.m_LeaderboardsClient.getLeaderboardIntent(leaderboardId), 2002);
                }
            } else if (z) {
                Log.v(s_TAG, "Logged out; logging back in...");
                signIn(true, new Runnable() {
                    public void run() {
                        GooglePlayGamesFeatures.this.doShowScoreUi(str, false);
                    }
                });
            }
        } catch (Exception e) {
            Log.e(s_TAG, "Google Play Error", e);
        }
    }

    private String getAchievementId(String str) {
        return this.m_AchievementIds.get(str);
    }

    private String getLeaderboardId(String str) {
        return this.m_LeaderboardIds.get(str);
    }

    public boolean isLoggedIn() {
        boolean z;
        synchronized (this.m_SignedInLock) {
            z = this.m_SignedIn;
        }
        return z;
    }

    public void logInOut() {
        this.m_Activity.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    synchronized (GooglePlayGamesFeatures.this.m_SignedInLock) {
                        if (GooglePlayGamesFeatures.this.m_SignedIn) {
                            GooglePlayGamesFeatures.this.signOut();
                        } else {
                            GooglePlayGamesFeatures.this.signIn(true, (Runnable) null);
                        }
                    }
                } catch (Exception e) {
                    Log.e(GooglePlayGamesFeatures.s_TAG, "Google Play Error", e);
                }
            }
        });
    }

    private class SignInCompleteListener implements OnSuccessListener<GoogleSignInAccount>, OnFailureListener {
        private SignInCompleteListener() {
        }

        public void onSuccess(GoogleSignInAccount googleSignInAccount) {
            GooglePlayGamesFeatures.this.onSignInSucceeded(googleSignInAccount);
        }

        public void onFailure(Exception exc) {
            GooglePlayGamesFeatures.this.onSignInFailed(true);
        }
    }

    /* access modifiers changed from: private */
    public void onSignInSucceeded(GoogleSignInAccount googleSignInAccount) {
        try {
            Log.v(s_TAG, "GooglePlayGamesFeatures.onSignInSucceeded");
            resetSignInCancellations();
            this.m_GamesClient = Games.getGamesClient((Activity) this.m_Activity, googleSignInAccount);
            this.m_AchievementsClient = Games.getAchievementsClient((Activity) this.m_Activity, googleSignInAccount);
            this.m_LeaderboardsClient = Games.getLeaderboardsClient((Activity) this.m_Activity, googleSignInAccount);
            this.m_SnapshotsClient = Games.getSnapshotsClient((Activity) this.m_Activity, googleSignInAccount);
            this.m_GamesClient.setViewForPopups(this.m_Activity.getGLSurfaceView());
            this.m_SnapshotsClient.getMaxDataSize().addOnSuccessListener(new OnSuccessListener<Integer>() {
                public void onSuccess(Integer num) {
                    Log.v(GooglePlayGamesFeatures.s_TAG, String.format("    Max Data = %d KiB", new Object[]{Integer.valueOf(num.intValue() / 1024)}));
                }
            });
            synchronized (this.m_SignedInLock) {
                this.m_SignedIn = true;
            }
            Runnable runnable = this.m_PostSignInAction;
            if (runnable != null) {
                runnable.run();
                this.m_PostSignInAction = null;
            }
            doPullData();
        } catch (Exception e) {
            Log.e(s_TAG, "Google Play Error", e);
            markAsSignedOut();
        }
    }

    /* access modifiers changed from: private */
    public void onSignInFailed(boolean z) {
        Log.v(s_TAG, "GooglePlayGamesFeatures.onSignInFailed");
        markAsSignedOut();
        this.m_PostSignInAction = null;
        doStopCloud();
        if (incrementSignInCancellations() < 1 && z && !this.m_Activity.isTestlab()) {
            signIn(false, (Runnable) null);
        }
    }

    private void silentSignIn() {
        try {
            this.m_PostSignInAction = null;
            if (this.m_GoogleSignIn == null) {
                this.m_GoogleSignIn = createGoogleSignInClient();
            }
            GoogleSignInClient googleSignInClient = this.m_GoogleSignIn;
            if (googleSignInClient != null) {
                googleSignInClient.silentSignIn().addOnSuccessListener(this.m_SignInCompleteListener).addOnFailureListener(this.m_SignInCompleteListener);
            }
        } catch (Exception e) {
            Log.e(s_TAG, "Google Play Error", e);
        }
    }

    private int incrementSignInCancellations() {
        SharedPreferences sharedPreferences = this.m_Activity.getSharedPreferences(GAMEHELPER_SHARED_PREFS, 0);
        int i = sharedPreferences.getInt(KEY_SIGN_IN_CANCELLATIONS, 0);
        if (i < 1) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(KEY_SIGN_IN_CANCELLATIONS, i + 1);
            edit.apply();
        }
        return i;
    }

    private void resetSignInCancellations() {
        SharedPreferences.Editor edit = this.m_Activity.getSharedPreferences(GAMEHELPER_SHARED_PREFS, 0).edit();
        edit.putInt(KEY_SIGN_IN_CANCELLATIONS, 0);
        edit.apply();
    }

    private void markAsSignedOut() {
        synchronized (this.m_SignedInLock) {
            this.m_SignedIn = false;
        }
        this.m_AchievementsClient = null;
        this.m_LeaderboardsClient = null;
        this.m_SnapshotsClient = null;
    }

    /* access modifiers changed from: private */
    public void signIn(boolean z, Runnable runnable) {
        try {
            this.m_PostSignInAction = runnable;
            if (this.m_GoogleSignIn == null) {
                this.m_GoogleSignIn = createGoogleSignInClient();
            }
            GoogleSignInClient googleSignInClient = this.m_GoogleSignIn;
            if (googleSignInClient != null) {
                this.m_Activity.startActivityForResult(googleSignInClient.getSignInIntent(), 2001);
            } else {
                showGoogleAvailabilityError(z);
            }
        } catch (Exception e) {
            Log.e(s_TAG, "Google Play Error", e);
        }
    }

    /* access modifiers changed from: private */
    public void signOut() {
        try {
            markAsSignedOut();
            GoogleSignInClient googleSignInClient = this.m_GoogleSignIn;
            if (googleSignInClient != null) {
                googleSignInClient.signOut();
            }
        } catch (Exception e) {
            Log.e(s_TAG, "Google Play Error", e);
        }
    }

    public void cloudReady() {
        this.m_Activity.runOnUiThread(new Runnable() {
            public void run() {
                GooglePlayGamesFeatures.this.doStartCloud();
            }
        });
    }

    /* access modifiers changed from: private */
    public void doStartCloud() {
        synchronized (this.m_CloudLock) {
            this.m_CloudReady = true;
        }
        doPullData();
    }

    public void cloudClearAll() {
        synchronized (this.m_CloudLock) {
            this.m_PendClearAll = true;
        }
        pushData();
    }

    public void cloudPushData(String[] strArr, String[] strArr2) {
        synchronized (this.m_CloudLock) {
            Collections.addAll(this.m_PendPushKeys, strArr);
            Collections.addAll(this.m_PendPushVals, strArr2);
        }
        pushData();
    }

    /* access modifiers changed from: private */
    public void pushData() {
        this.m_Activity.runOnUiThread(new Runnable() {
            public void run() {
                GooglePlayGamesFeatures.this.doPushData();
            }
        });
    }

    /* access modifiers changed from: private */
    public void doPushData() {
        try {
            if (this.m_SnapshotsClient != null) {
                synchronized (this.m_CloudLock) {
                    if (this.m_PendPushKeys.size() <= 0 && this.m_PendPushVals.size() <= 0 && !this.m_PendClearAll) {
                        return;
                    }
                    if (this.m_CloudReady) {
                        if (!this.m_CloudLoadingData) {
                            if (this.m_CloudSnapshot == null) {
                                doPullData();
                                return;
                            }
                            int i = 0;
                            for (int i2 = 0; i2 < this.m_PendPushKeys.size(); i2++) {
                                String str = this.m_PendPushVals.get(i2);
                                String put = this.m_CloudData.put(this.m_PendPushKeys.get(i2), str);
                                if (put == null || !put.equals(str)) {
                                    i++;
                                }
                            }
                            if (this.m_PendClearAll) {
                                this.m_CloudData.clear();
                                i++;
                            }
                            this.m_PendClearAll = false;
                            this.m_PendPushKeys.clear();
                            this.m_PendPushVals.clear();
                            if (i > 0) {
                                try {
                                    byte[] writeMap = writeMap(this.m_CloudData);
                                    if (writeMap != null) {
                                        Log.v(s_TAG, String.format("Writing %d changes to cloud (%d KiB)...", new Object[]{Integer.valueOf(i), Integer.valueOf(writeMap.length / 1024)}));
                                        this.m_CloudSnapshot.getSnapshotContents().writeBytes(writeMap);
                                        this.m_SnapshotsClient.commitAndClose(this.m_CloudSnapshot, SnapshotMetadataChange.EMPTY_CHANGE).addOnSuccessListener(this.m_CommitSnapshotResult).addOnFailureListener(this.m_CommitSnapshotResult);
                                        this.m_CloudSnapshot = null;
                                    }
                                } catch (Exception e) {
                                    Log.e(s_TAG, "GMS Exception", e);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            Log.e(s_TAG, "Google Play Error", e2);
        }
    }

    private class CommitSnapshotResult implements OnSuccessListener<SnapshotMetadata>, OnFailureListener {
        private CommitSnapshotResult() {
        }

        public void onSuccess(SnapshotMetadata snapshotMetadata) {
            Log.v(GooglePlayGamesFeatures.s_TAG, "Snapshot committed successfully.");
        }

        public void onFailure(Exception exc) {
            Log.v(GooglePlayGamesFeatures.s_TAG, "Snapshot failed to commit.", exc);
        }
    }

    private void doStopCloud() {
        synchronized (this.m_CloudLock) {
            this.m_CloudSnapshot = null;
            this.m_CloudLoadingData = false;
        }
    }

    private void doPullData() {
        try {
            if (this.m_SnapshotsClient != null) {
                synchronized (this.m_CloudLock) {
                    Log.v(s_TAG, "doPullData");
                    if (!this.m_CloudReady) {
                        Log.v(s_TAG, "    cloud system not yet ready");
                    } else if (this.m_CloudLoadingData) {
                        Log.v(s_TAG, "    data already pending");
                    } else {
                        this.m_SnapshotsClient.open(s_SnapshotFileName, true).addOnSuccessListener(this.m_OpenSnapshotResult).addOnFailureListener(this.m_OpenSnapshotResult);
                        this.m_CloudLoadingData = true;
                    }
                }
            }
        } catch (Exception e) {
            Log.e(s_TAG, "Google Play Error", e);
        }
    }

    private class OpenSnapshotResult implements OnSuccessListener<SnapshotsClient.DataOrConflict<Snapshot>>, OnFailureListener {
        private OpenSnapshotResult() {
        }

        public void onSuccess(SnapshotsClient.DataOrConflict<Snapshot> dataOrConflict) {
            try {
                if (dataOrConflict.isConflict()) {
                    SnapshotsClient.SnapshotConflict conflict = dataOrConflict.getConflict();
                    if (conflict != null) {
                        onConflict(conflict);
                        return;
                    }
                    return;
                }
                Snapshot data = dataOrConflict.getData();
                if (data != null) {
                    onLoaded(data);
                }
            } catch (Exception e) {
                Log.e(GooglePlayGamesFeatures.s_TAG, "GMS Exception", e);
            }
        }

        public void onFailure(Exception exc) {
            Log.v(GooglePlayGamesFeatures.s_TAG, "Failed to load/resolve snapshot.");
            synchronized (GooglePlayGamesFeatures.this.m_CloudLock) {
                Snapshot unused = GooglePlayGamesFeatures.this.m_CloudSnapshot = null;
                boolean unused2 = GooglePlayGamesFeatures.this.m_CloudLoadingData = false;
            }
        }

        private void onConflict(SnapshotsClient.SnapshotConflict snapshotConflict) {
            try {
                if (GooglePlayGamesFeatures.this.m_SnapshotsClient != null) {
                    GooglePlayGamesFeatures.this.m_SnapshotsClient.resolveConflict(snapshotConflict.getConflictId(), snapshotConflict.getSnapshot()).addOnSuccessListener(GooglePlayGamesFeatures.this.m_OpenSnapshotResult).addOnFailureListener(GooglePlayGamesFeatures.this.m_OpenSnapshotResult);
                    Log.v(GooglePlayGamesFeatures.s_TAG, String.format("Snapshot \"%s\" conflicted.", new Object[]{snapshotConflict.getSnapshot().getMetadata().getSnapshotId()}));
                }
            } catch (Exception e) {
                Log.e(GooglePlayGamesFeatures.s_TAG, "GMS Exception", e);
            }
        }

        private void onLoaded(Snapshot snapshot) {
            try {
                synchronized (GooglePlayGamesFeatures.this.m_CloudLock) {
                    boolean unused = GooglePlayGamesFeatures.this.m_CloudLoadingData = true;
                }
                GooglePlayGamesFeatures googlePlayGamesFeatures = GooglePlayGamesFeatures.this;
                HashMap unused2 = googlePlayGamesFeatures.m_CloudData = googlePlayGamesFeatures.onExternalData(snapshot.getSnapshotContents().readFully());
                synchronized (GooglePlayGamesFeatures.this.m_CloudLock) {
                    Snapshot unused3 = GooglePlayGamesFeatures.this.m_CloudSnapshot = snapshot;
                    boolean unused4 = GooglePlayGamesFeatures.this.m_CloudLoadingData = false;
                }
                GooglePlayGamesFeatures.this.pushData();
                Log.v(GooglePlayGamesFeatures.s_TAG, "Snapshot \"" + snapshot.getMetadata().getSnapshotId() + "\" loaded.");
            } catch (Exception e) {
                Log.e(GooglePlayGamesFeatures.s_TAG, "GMS Exception", e);
                synchronized (GooglePlayGamesFeatures.this.m_CloudLock) {
                    Snapshot unused5 = GooglePlayGamesFeatures.this.m_CloudSnapshot = null;
                    boolean unused6 = GooglePlayGamesFeatures.this.m_CloudLoadingData = false;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> onExternalData(byte[] bArr) {
        HashMap<String, String> readMap = readMap(bArr);
        if (readMap == null) {
            Log.v(s_TAG, "    data is null");
            readMap = new HashMap<>();
        } else {
            Log.v(s_TAG, "    data size: " + (bArr.length / 1024) + " KiB");
        }
        String[] strArr = new String[readMap.size()];
        String[] strArr2 = new String[readMap.size()];
        int i = 0;
        for (Map.Entry next : readMap.entrySet()) {
            strArr[i] = (String) next.getKey();
            strArr2[i] = (String) next.getValue();
            i++;
        }
        NativeInterface.pushCloudValues(this.m_Activity, strArr, strArr2);
        return readMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0021 A[SYNTHETIC, Splitter:B:14:0x0021] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002c A[SYNTHETIC, Splitter:B:22:0x002c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] writeMap(java.util.HashMap<java.lang.String, java.lang.String> r3) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x0028, all -> 0x001e }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0028, all -> 0x001e }
            r2.writeObject(r3)     // Catch:{ Exception -> 0x001c, all -> 0x0019 }
            byte[] r3 = r0.toByteArray()     // Catch:{ Exception -> 0x001c, all -> 0x0019 }
            r2.close()     // Catch:{ Exception -> 0x0018 }
            r0.close()     // Catch:{ Exception -> 0x0018 }
        L_0x0018:
            return r3
        L_0x0019:
            r3 = move-exception
            r1 = r2
            goto L_0x001f
        L_0x001c:
            goto L_0x002a
        L_0x001e:
            r3 = move-exception
        L_0x001f:
            if (r1 == 0) goto L_0x0024
            r1.close()     // Catch:{ Exception -> 0x0027 }
        L_0x0024:
            r0.close()     // Catch:{ Exception -> 0x0027 }
        L_0x0027:
            throw r3
        L_0x0028:
            r2 = r1
        L_0x002a:
            if (r2 == 0) goto L_0x002f
            r2.close()     // Catch:{ Exception -> 0x0032 }
        L_0x002f:
            r0.close()     // Catch:{ Exception -> 0x0032 }
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kumobius.android.features.GooglePlayGamesFeatures.writeMap(java.util.HashMap):byte[]");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x002b */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0026 A[Catch:{ Exception -> 0x0029 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.HashMap<java.lang.String, java.lang.String> readMap(byte[] r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r4)
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x002a, all -> 0x001d }
            r4.<init>(r1)     // Catch:{ Exception -> 0x002a, all -> 0x001d }
            java.lang.Object r2 = r4.readObject()     // Catch:{ Exception -> 0x002b, all -> 0x001b }
            java.util.HashMap r2 = (java.util.HashMap) r2     // Catch:{ Exception -> 0x002b, all -> 0x001b }
            r1.close()     // Catch:{ Exception -> 0x001a }
            r4.close()     // Catch:{ Exception -> 0x001a }
        L_0x001a:
            return r2
        L_0x001b:
            r0 = move-exception
            goto L_0x0021
        L_0x001d:
            r4 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
        L_0x0021:
            r1.close()     // Catch:{ Exception -> 0x0029 }
            if (r4 == 0) goto L_0x0029
            r4.close()     // Catch:{ Exception -> 0x0029 }
        L_0x0029:
            throw r0
        L_0x002a:
            r4 = r0
        L_0x002b:
            r1.close()     // Catch:{ Exception -> 0x0033 }
            if (r4 == 0) goto L_0x0033
            r4.close()     // Catch:{ Exception -> 0x0033 }
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kumobius.android.features.GooglePlayGamesFeatures.readMap(byte[]):java.util.HashMap");
    }
}
