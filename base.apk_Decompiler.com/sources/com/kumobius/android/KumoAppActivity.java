package com.kumobius.android;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Process;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.LongSparseArray;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.webkit.internal.AssetHelper;
import com.applovin.sdk.AppLovinEventTypes;
import com.kumobius.android.features.IAchievementsFeature;
import com.kumobius.android.features.IAdsFeature;
import com.kumobius.android.features.IAnalyticsFeature;
import com.kumobius.android.features.ICloudFeature;
import com.kumobius.android.features.IFileAccessorFeature;
import com.kumobius.android.features.IIapFeature;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KumoAppActivity extends AppCompatActivity implements INativeResponder {
    private static boolean s_IsForeground = false;
    private static final String s_TAG = "KumoJava";
    private IAchievementsFeature m_AchievementsFeature;
    private IAdsFeature m_AdsFeature;
    private IAnalyticsFeature m_AnalyticsFeature;
    private ICloudFeature m_CloudFeature;
    /* access modifiers changed from: private */
    public IFileAccessorFeature m_FileAccessor;
    private KumoGLSurfaceView m_GLView;
    private boolean m_HasDpad = false;
    private boolean m_HasGamePad = false;
    private IIapFeature m_IapFeature;
    private boolean m_IsPlayingVideo = false;
    private boolean m_IsTV = false;
    /* access modifiers changed from: private */
    public MediaPlayer m_MediaPlayer;
    /* access modifiers changed from: private */
    public boolean m_MediaPlayerReady = false;
    /* access modifiers changed from: private */
    public float m_MediaPlayerVolume = -1.0f;
    /* access modifiers changed from: private */
    public boolean m_MusicEnabled = false;
    /* access modifiers changed from: private */
    public final Object m_MusicLock = new Object();
    /* access modifiers changed from: private */
    public boolean m_MusicPaused = false;
    private final ExecutorService m_MusicPlayerExecutor = Executors.newSingleThreadExecutor();
    private long m_NextPromptId = 1;
    private long m_NextStreamUserId = 1;
    /* access modifiers changed from: private */
    public int m_PauseCount = 1;
    /* access modifiers changed from: private */
    public final LongSparseArray<Integer> m_PromptMap = new LongSparseArray<>();
    private final HashMap<String, Integer> m_SoundIdMap = new HashMap<>();
    private final ExecutorService m_SoundLoadExecutor = Executors.newSingleThreadExecutor();
    private final Object m_SoundLock = new Object();
    private final ExecutorService m_SoundPlayExecutor = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public SoundPool m_SoundPool;
    private final LongSparseArray<Integer> m_StreamIdMap = new LongSparseArray<>();
    /* access modifiers changed from: private */
    public MediaPlayer m_VoicePlayer;

    private interface RunnableInt {
        void run(int i);
    }

    private boolean isAndroidKey(int i) {
        return i == 3 || i == 4 || i == 82 || i == 84;
    }

    public static boolean isForeground() {
        return s_IsForeground;
    }

    public KumoGLSurfaceView getGLSurfaceView() {
        return this.m_GLView;
    }

    public float getMusicSyncTime() {
        return -1.0f;
    }

    public float getSoundPitch(long j) {
        return 1.0f;
    }

    public boolean getSoundPlaying(long j) {
        return false;
    }

    public float getSoundVolume(long j) {
        return 1.0f;
    }

    public boolean hasDpad() {
        return this.m_IsTV || this.m_HasDpad || this.m_HasGamePad;
    }

    public boolean isPlayingVideo() {
        return this.m_IsPlayingVideo;
    }

    public String getOverrides() {
        String str;
        String string = getResources().getString(R.string.extraOverrides);
        if (this.m_IsTV) {
            str = string + ",console,controller";
        } else {
            String str2 = string + ",touch";
            if (Utils.isTablet(this)) {
                str = str2 + ",mobile,tablet";
            } else {
                str = str2 + ",mobile,phone";
            }
        }
        if (!isTestlab()) {
            return str;
        }
        Log.v(s_TAG, "Test Lab mode ON");
        return str + ",testlab";
    }

    public boolean isTestlab() {
        Intent intent = getIntent();
        if (intent == null || !Objects.equals(intent.getAction(), "com.google.intent.action.TEST_LOOP")) {
            return "true".equalsIgnoreCase(Settings.System.getString(getContentResolver(), "firebase.test.lab"));
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        if (r3.navigationHidden == 1) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onConfigurationChanged(android.content.res.Configuration r3) {
        /*
            r2 = this;
            super.onConfigurationChanged(r3)
            int r0 = r3.navigation
            r1 = 2
            if (r0 != r1) goto L_0x000e
            int r3 = r3.navigationHidden
            r0 = 1
            if (r3 != r0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            r2.setDpad(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kumobius.android.KumoAppActivity.onConfigurationChanged(android.content.res.Configuration):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x00a0, code lost:
        if (r4.navigationHidden == 1) goto L_0x00a4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r4) {
        /*
            r3 = this;
            com.savegame.SavesRestoring.DoSmth(r3)
            super.onCreate(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "App Version "
            r4.<init>(r0)
            java.lang.String r0 = com.kumobius.android.Utils.getVersionName(r3)
            r4.append(r0)
            java.lang.String r0 = " ("
            r4.append(r0)
            long r0 = com.kumobius.android.Utils.getVersionCode(r3)
            r4.append(r0)
            java.lang.String r0 = ")"
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            java.lang.String r0 = "KumoJava"
            android.util.Log.v(r0, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r1 = "Device is: "
            r4.<init>(r1)
            java.lang.String r1 = android.os.Build.MODEL
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            android.util.Log.v(r0, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r1 = "CPU is: "
            r4.<init>(r1)
            java.lang.String r1 = "os.arch"
            java.lang.String r1 = java.lang.System.getProperty(r1)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            android.util.Log.v(r0, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r1 = "Main thread priority = "
            r4.<init>(r1)
            int r1 = android.os.Process.myTid()
            int r1 = android.os.Process.getThreadPriority(r1)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            android.util.Log.v(r0, r4)
            com.kumobius.android.features.IFeatureFactory r4 = com.kumobius.android.KumoAppBase.getFileAccessorFeatureFactory()
            java.lang.Object r4 = r4.create(r3)
            com.kumobius.android.features.IFileAccessorFeature r4 = (com.kumobius.android.features.IFileAccessorFeature) r4
            r3.m_FileAccessor = r4
            r4.fileAccessInit()
            com.kumobius.android.Utils.setImmersiveMode(r3)
            com.kumobius.android.Utils.setRequestedOrientation(r3)
            r4 = 3
            r3.setVolumeControlStream(r4)
            boolean r4 = com.kumobius.android.Utils.isTvMode(r3)
            r3.m_IsTV = r4
            android.content.res.Resources r4 = r3.getResources()
            android.content.res.Configuration r4 = r4.getConfiguration()
            int r1 = r4.navigation
            r2 = 2
            if (r1 != r2) goto L_0x00a3
            int r4 = r4.navigationHidden
            r1 = 1
            if (r4 != r1) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r1 = 0
        L_0x00a4:
            r3.setDpad(r1)
            r3.detectGamePad()
            boolean r4 = com.kumobius.android.NativeInterface.getAvailable()
            java.lang.String r1 = "Install Error"
            if (r4 != 0) goto L_0x00bd
            java.lang.String r4 = "failed to load .so file"
            android.util.Log.e(r0, r4)
            java.lang.String r4 = "Unable to load libKumoGame. This can be caused by a faulty install. Uninstalling and re-installing the game will usually fix this problem."
            r3.onFatalError(r1, r4)
            return
        L_0x00bd:
            java.io.File r4 = com.kumobius.android.Utils.getUserDataDirFile(r3)
            if (r4 != 0) goto L_0x00ce
            java.lang.String r4 = "userDataDir is null, cannot proceed"
            android.util.Log.e(r0, r4)
            java.lang.String r4 = "Unable to access save-file directory. This can be caused by a faulty install. Uninstalling and re-installing the game will usually fix this problem."
            r3.onFatalError(r1, r4)
            return
        L_0x00ce:
            r4.mkdirs()
            r3.audioInit()
            com.kumobius.android.KumoGLSurfaceView r4 = new com.kumobius.android.KumoGLSurfaceView
            r4.<init>(r3)
            r3.m_GLView = r4
            r3.setContentView((android.view.View) r4)
            r3.iapInit()
            r3.analyticsInit()
            r3.achievementsInit()
            r3.cloudInit()
            r3.adsInit()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kumobius.android.KumoAppActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        IAnalyticsFeature iAnalyticsFeature = this.m_AnalyticsFeature;
        if (iAnalyticsFeature != null) {
            iAnalyticsFeature.analyticsOnStart();
        }
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        if (iAdsFeature != null) {
            iAdsFeature.adsOnStart();
        }
        IAchievementsFeature iAchievementsFeature = this.m_AchievementsFeature;
        if (iAchievementsFeature != null) {
            iAchievementsFeature.scoresOnStart();
        }
        IIapFeature iIapFeature = this.m_IapFeature;
        if (iIapFeature != null) {
            iIapFeature.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        IAnalyticsFeature iAnalyticsFeature = this.m_AnalyticsFeature;
        if (iAnalyticsFeature != null) {
            iAnalyticsFeature.analyticsOnStop();
        }
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        if (iAdsFeature != null) {
            iAdsFeature.adsOnStop();
        }
        IAchievementsFeature iAchievementsFeature = this.m_AchievementsFeature;
        if (iAchievementsFeature != null) {
            iAchievementsFeature.scoresOnStop();
        }
    }

    private void onFatalError(String str, String str2) {
        AlertDialog create = new AlertDialog.Builder(this).create();
        create.setButton(-1, (CharSequence) "Close", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        create.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                KumoAppActivity.this.finish();
            }
        });
        create.setTitle(str);
        create.setMessage(str2);
        create.show();
    }

    private void onError(String str, String str2) {
        AlertDialog create = new AlertDialog.Builder(this).create();
        create.setButton(-1, (CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        create.setTitle(str);
        create.setMessage(str2);
        create.show();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        IIapFeature iIapFeature = this.m_IapFeature;
        if (iIapFeature != null) {
            iIapFeature.onDestroy();
        }
        super.onDestroy();
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        if (iAdsFeature != null) {
            iAdsFeature.adsOnDestroy();
        }
        Process.killProcess(Process.myPid());
    }

    public void onBackPressed() {
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        if (iAdsFeature == null || !iAdsFeature.adsOnBackPressed()) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        IAchievementsFeature iAchievementsFeature = this.m_AchievementsFeature;
        if (iAchievementsFeature != null) {
            iAchievementsFeature.scoresOnActivityResult(i, i2, intent);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Utils.setImmersiveMode(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24 || i == 25 || i == 164) {
            return false;
        }
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0 && (i == 4 || i == 82)) {
            resumeMusic();
            NativeInterface.keyDownUp(this, i, true);
            NativeInterface.keyDownUp(this, i, false);
        } else if (keyEvent.getRepeatCount() == 0) {
            resumeMusic();
            NativeInterface.keyDownUp(this, i, true);
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 24 || i == 25 || i == 164) {
            return false;
        }
        if ((isAndroidKey(i) && keyEvent.getRepeatCount() == 0) || keyEvent.getRepeatCount() != 0) {
            return true;
        }
        NativeInterface.keyDownUp(this, i, false);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        pauseMusic();
        super.onPause();
        IAchievementsFeature iAchievementsFeature = this.m_AchievementsFeature;
        if (iAchievementsFeature != null) {
            iAchievementsFeature.scoresOnPause();
        }
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        if (iAdsFeature != null) {
            iAdsFeature.adsOnPause();
        }
        addPause();
        s_IsForeground = false;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        detectGamePad();
        IAchievementsFeature iAchievementsFeature = this.m_AchievementsFeature;
        if (iAchievementsFeature != null) {
            iAchievementsFeature.scoresOnResume();
        }
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        if (iAdsFeature != null) {
            iAdsFeature.adsOnResume();
        }
        IIapFeature iIapFeature = this.m_IapFeature;
        if (iIapFeature != null) {
            iIapFeature.onResume();
        }
        removePause();
        this.m_IsPlayingVideo = false;
        s_IsForeground = true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Utils.setImmersiveMode(this);
        resumeMusic();
        int action = motionEvent.getAction();
        int i = action & 255;
        int i2 = (action & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        for (int i3 = 0; i3 < motionEvent.getPointerCount(); i3++) {
            int pointerId = motionEvent.getPointerId(i3);
            float x = motionEvent.getX(i3);
            float y = motionEvent.getY(i3);
            float eventTime = ((float) motionEvent.getEventTime()) * 0.001f;
            if (pointerId >= 0 && pointerId < 5) {
                if (i == 0) {
                    NativeInterface.pointerDown(this, pointerId, x, y, eventTime);
                } else if (i == 1) {
                    NativeInterface.pointerUp(this, pointerId, x, y, eventTime);
                } else if (i == 2) {
                    NativeInterface.pointerMove(this, pointerId, x, y, eventTime);
                } else if (i == 3) {
                    NativeInterface.pointerCancel(this, pointerId, x, y, eventTime);
                } else if (i != 5) {
                    if (i == 6) {
                        if (i2 == i3) {
                            NativeInterface.pointerUp(this, pointerId, x, y, eventTime);
                        } else {
                            NativeInterface.pointerMove(this, pointerId, x, y, eventTime);
                        }
                    }
                } else if (i2 == i3) {
                    NativeInterface.pointerDown(this, pointerId, x, y, eventTime);
                } else {
                    NativeInterface.pointerMove(this, pointerId, x, y, eventTime);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void detectGamePad() {
        for (int device : InputDevice.getDeviceIds()) {
            InputDevice device2 = InputDevice.getDevice(device);
            if (!device2.isVirtual()) {
                int sources = device2.getSources();
                if ((sources & InputDeviceCompat.SOURCE_DPAD) == 513 || (sources & 1025) == 1025) {
                    Log.v(s_TAG, "Input Device: " + device2.getName());
                    this.m_HasGamePad = true;
                }
            }
        }
    }

    private void setDpad(boolean z) {
        boolean z2 = this.m_HasDpad;
        if (z2 && !z) {
            Log.v(s_TAG, "Device no longer has DPAD.");
        } else if (!z2 && z) {
            Log.v(s_TAG, "Device now has DPAD.");
        }
        this.m_HasDpad = z;
    }

    private boolean isIntentAvailable(Intent intent) {
        return getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public boolean getUseLoFi() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long totalMemory = getTotalMemory();
        Log.v(s_TAG, "Core Count = " + availableProcessors);
        Log.v(s_TAG, "Mem Total = " + ((totalMemory / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) + " MiB");
        boolean z = true;
        if (availableProcessors > 1 || totalMemory >= 268435456) {
            z = false;
        }
        if (z) {
            Log.v(s_TAG, "    Using LoFi textures.");
        } else {
            Log.v(s_TAG, "    Not using LoFi textures.");
        }
        return z;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|(3:6|7|8)(5:9|10|11|(2:13|42)(2:14|(1:43)(3:16|17|18))|41)) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
        if (r3[2].equalsIgnoreCase("kB") == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        r4 = r4 * android.support.v4.media.session.PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004e, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0057, code lost:
        if (r3[2].equalsIgnoreCase("MB") == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
        r4 = r4 * android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0061, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0062, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0065, code lost:
        return r4;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010 A[LOOP:0: B:3:0x0010->B:41:0x0010, LOOP_START, SYNTHETIC, Splitter:B:3:0x0010] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long getTotalMemory() {
        /*
            r9 = this;
            r0 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x006b }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "/proc/meminfo"
            r3.<init>(r4)     // Catch:{ Exception -> 0x006b }
            r4 = 8192(0x2000, float:1.14794E-41)
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x006b }
        L_0x0010:
            java.lang.String r3 = r2.readLine()     // Catch:{ all -> 0x0066 }
            if (r3 != 0) goto L_0x001a
            r2.close()     // Catch:{ Exception -> 0x006b }
            return r0
        L_0x001a:
            java.lang.String r4 = "\\s+"
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ all -> 0x0066 }
            int r4 = r3.length     // Catch:{ all -> 0x0066 }
            r5 = 3
            if (r4 == r5) goto L_0x0025
            goto L_0x0010
        L_0x0025:
            r4 = 0
            r4 = r3[r4]     // Catch:{ all -> 0x0066 }
            java.lang.String r5 = "MemTotal:"
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0066 }
            if (r4 != 0) goto L_0x0031
            goto L_0x0010
        L_0x0031:
            r4 = 1
            r4 = r3[r4]     // Catch:{ Exception -> 0x0010 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x0010 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x0010 }
            r6 = 2
            r7 = r3[r6]     // Catch:{ all -> 0x0066 }
            java.lang.String r8 = "kB"
            boolean r7 = r7.equalsIgnoreCase(r8)     // Catch:{ all -> 0x0066 }
            if (r7 == 0) goto L_0x004f
            r6 = 1024(0x400, double:5.06E-321)
            long r4 = r4 * r6
            r2.close()     // Catch:{ Exception -> 0x006b }
            return r4
        L_0x004f:
            r3 = r3[r6]     // Catch:{ all -> 0x0066 }
            java.lang.String r6 = "MB"
            boolean r3 = r3.equalsIgnoreCase(r6)     // Catch:{ all -> 0x0066 }
            if (r3 == 0) goto L_0x0062
            r6 = 1048576(0x100000, double:5.180654E-318)
            long r4 = r4 * r6
            r2.close()     // Catch:{ Exception -> 0x006b }
            return r4
        L_0x0062:
            r2.close()     // Catch:{ Exception -> 0x006b }
            return r4
        L_0x0066:
            r3 = move-exception
            r2.close()     // Catch:{ Exception -> 0x006b }
            throw r3     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kumobius.android.KumoAppActivity.getTotalMemory():long");
    }

    public void removePause() {
        int i = this.m_PauseCount - 1;
        this.m_PauseCount = i;
        if (i == 0) {
            KumoGLSurfaceView kumoGLSurfaceView = this.m_GLView;
            if (kumoGLSurfaceView != null) {
                kumoGLSurfaceView.onResume();
            }
            NativeInterface.activate(this);
            applyMusicState();
        }
    }

    public void addPause() {
        int i = this.m_PauseCount;
        this.m_PauseCount = i + 1;
        if (i == 0) {
            KumoGLSurfaceView kumoGLSurfaceView = this.m_GLView;
            if (kumoGLSurfaceView != null) {
                kumoGLSurfaceView.onPause();
            }
            NativeInterface.deactivate(this);
            applyMusicState();
        }
    }

    public long prompt(String str, String str2, String str3, String str4) {
        long j;
        synchronized (this.m_PromptMap) {
            j = this.m_NextPromptId;
            this.m_NextPromptId = 1 + j;
            this.m_PromptMap.put(j, -1);
        }
        final String str5 = str3;
        final long j2 = j;
        final String str6 = str4;
        final String str7 = str;
        final String str8 = str2;
        runOnUiThread(new Runnable() {
            public void run() {
                KumoAppActivity.this.addPause();
                AlertDialog create = new AlertDialog.Builder(KumoAppActivity.this).create();
                create.setButton(-1, (CharSequence) str5, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        synchronized (KumoAppActivity.this.m_PromptMap) {
                            KumoAppActivity.this.m_PromptMap.put(j2, 1);
                        }
                    }
                });
                create.setButton(-2, (CharSequence) str6, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        synchronized (KumoAppActivity.this.m_PromptMap) {
                            KumoAppActivity.this.m_PromptMap.put(j2, 0);
                        }
                    }
                });
                create.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        KumoAppActivity.this.removePause();
                    }
                });
                create.setTitle(str7);
                create.setMessage(str8);
                create.show();
            }
        });
        return j;
    }

    public int checkPrompt(long j) {
        synchronized (this.m_PromptMap) {
            Integer num = this.m_PromptMap.get(j);
            if (num == null) {
                return -2;
            }
            int intValue = num.intValue();
            return intValue;
        }
    }

    public void promptOpenURL(String str, String str2, String str3, String str4, String str5) {
        final String str6 = str3;
        final String str7 = str5;
        final String str8 = str4;
        final String str9 = str;
        final String str10 = str2;
        runOnUiThread(new Runnable() {
            public void run() {
                KumoAppActivity.this.addPause();
                AlertDialog create = new AlertDialog.Builder(KumoAppActivity.this).create();
                create.setButton(-1, (CharSequence) str6, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        KumoAppActivity.this.openUrl(str7);
                    }
                });
                create.setButton(-2, (CharSequence) str8, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                create.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        KumoAppActivity.this.removePause();
                    }
                });
                create.setTitle(str9);
                create.setMessage(str10);
                create.show();
            }
        });
    }

    public void openUrl(String str) {
        try {
            if (str.startsWith("share:")) {
                String substring = str.substring(6);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", substring);
                intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
                startActivity(Intent.createChooser(intent, "Share URL via..."));
                return;
            }
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            Log.w(s_TAG, "Couldn't open URI " + str, e);
        }
    }

    public boolean canOpenUrl(String str) {
        if (str.startsWith("http:") || str.startsWith("https:")) {
            return true;
        }
        return isIntentAvailable(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public boolean isAppInstalled(String str) {
        try {
            return getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public void exitGame() {
        runOnUiThread(new Runnable() {
            public void run() {
                KumoAppActivity.this.finish();
            }
        });
    }

    public void notificationCancelAll() {
        NotificationService.cancelAll(this);
    }

    public void notificationSchedule(long j, String str) {
        NotificationService.schedule(this, j, str);
    }

    public void startDownload(final long j, final String str) {
        try {
            new Thread(new Runnable() {
                public void run() {
                    KumoAppActivity.this.doDownload(j, str);
                }
            }).start();
        } catch (Exception e) {
            Log.w(s_TAG, "Failed to start download", e);
        }
    }

    /* access modifiers changed from: private */
    public void doDownload(long j, String str) {
        BufferedInputStream bufferedInputStream;
        try {
            Log.v(s_TAG, "Starting download: " + j + " " + str);
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setConnectTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
            openConnection.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
            bufferedInputStream = new BufferedInputStream(openConnection.getInputStream(), 8192);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read < 0) {
                    bufferedInputStream.close();
                    Log.v(s_TAG, "Download complete: " + str);
                    NativeInterface.downloadSuccess(this, j);
                    return;
                }
                NativeInterface.downloadData(this, j, bArr, read);
            }
        } catch (Exception e) {
            Log.w(s_TAG, "Failed to download file.", e);
            NativeInterface.downloadFailure(this, j);
        } catch (Throwable th) {
            bufferedInputStream.close();
            throw th;
        }
    }

    public void bragTwitter(String str, String str2) {
        IAchievementsFeature iAchievementsFeature = this.m_AchievementsFeature;
        if (iAchievementsFeature != null && iAchievementsFeature.canBragTwitter()) {
            this.m_AchievementsFeature.bragTwitter(str, str2);
        }
    }

    public void bragFacebook(String str, String str2) {
        IAchievementsFeature iAchievementsFeature = this.m_AchievementsFeature;
        if (iAchievementsFeature != null && iAchievementsFeature.canBragFacebook()) {
            this.m_AchievementsFeature.bragFacebook(str, str2);
        }
    }

    public void bragImage(final String str, ByteBuffer byteBuffer, int i, int i2) {
        try {
            final Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(byteBuffer);
            runOnUiThread(new Runnable() {
                public void run() {
                    KumoAppActivity.this.doBragImage(createBitmap, str);
                }
            });
        } catch (Exception e) {
            Log.w(s_TAG, "Failed to share image", e);
        }
    }

    /* access modifiers changed from: private */
    public void doBragImage(Bitmap bitmap, String str) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(getCacheDir(), "KumoShare.png");
            fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
            Uri uriForFile = FileProvider.getUriForFile(this, getApplication().getPackageName() + ".FileProvider", file);
            StringBuilder sb = new StringBuilder("Share image: ");
            sb.append(uriForFile);
            Log.v(s_TAG, sb.toString());
            if (uriForFile != null) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.addFlags(1);
                intent.setDataAndType(uriForFile, getContentResolver().getType(uriForFile));
                intent.putExtra("android.intent.extra.STREAM", uriForFile);
                intent.putExtra("android.intent.extra.TEXT", str);
                startActivity(Intent.createChooser(intent, AppLovinEventTypes.USER_SHARED_LINK));
            }
        } catch (Exception e) {
            Log.w(s_TAG, "Failed to share image", e);
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    private void audioInit() {
        this.m_MediaPlayer = Utils.createMediaPlayer();
        this.m_VoicePlayer = Utils.createMediaPlayer();
        this.m_SoundPool = Utils.createSoundPool();
    }

    private boolean tryPutSoundIndex(String str, int i) {
        synchronized (this.m_SoundLock) {
            if (this.m_SoundIdMap.containsKey(str)) {
                return false;
            }
            this.m_SoundIdMap.put(str, Integer.valueOf(i));
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void putSoundIndex(String str, int i) {
        synchronized (this.m_SoundLock) {
            this.m_SoundIdMap.put(str, Integer.valueOf(i));
        }
    }

    private int getSoundIndex(String str) {
        int i;
        synchronized (this.m_SoundLock) {
            Integer num = this.m_SoundIdMap.get(str);
            if (num == null) {
                i = -1;
            } else {
                i = num.intValue();
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    public int getAndRemoveSoundIndex(String str) {
        int i;
        synchronized (this.m_SoundLock) {
            Integer num = this.m_SoundIdMap.get(str);
            if (num == null) {
                i = -1;
            } else {
                i = num.intValue();
            }
            this.m_SoundIdMap.remove(str);
        }
        return i;
    }

    /* access modifiers changed from: private */
    public void putStreamId(long j, int i) {
        synchronized (this.m_SoundLock) {
            this.m_StreamIdMap.remove((long) i);
            this.m_StreamIdMap.put(j, Integer.valueOf(i));
        }
    }

    /* access modifiers changed from: private */
    public int getStreamId(long j) {
        int i;
        synchronized (this.m_SoundLock) {
            Integer num = this.m_StreamIdMap.get(j);
            if (num == null) {
                i = -1;
            } else {
                i = num.intValue();
            }
        }
        return i;
    }

    private void withStreamId(final long j, final RunnableInt runnableInt) {
        if (j > 0 && runnableInt != null) {
            this.m_SoundPlayExecutor.submit(new Runnable() {
                public void run() {
                    try {
                        int access$300 = KumoAppActivity.this.getStreamId(j);
                        if (access$300 >= 0) {
                            runnableInt.run(access$300);
                        }
                    } catch (Exception e) {
                        Log.w(KumoAppActivity.s_TAG, e);
                    }
                }
            });
        }
    }

    public void loadSound(final String str, final String str2) {
        if (tryPutSoundIndex(str, -1)) {
            this.m_SoundLoadExecutor.submit(new Runnable() {
                public void run() {
                    int i;
                    try {
                        AssetFileDescriptor openFd = KumoAppActivity.this.m_FileAccessor.openFd(str2);
                        if (openFd != null) {
                            i = KumoAppActivity.this.m_SoundPool.load(openFd, 1);
                        } else {
                            i = KumoAppActivity.this.m_SoundPool.load(str2, 1);
                        }
                        KumoAppActivity.this.putSoundIndex(str, i);
                    } catch (Exception e) {
                        Log.w(KumoAppActivity.s_TAG, "Failed to load sound " + str2, e);
                    }
                }
            });
        }
    }

    public void unloadSound(final String str) {
        this.m_SoundLoadExecutor.submit(new Runnable() {
            public void run() {
                try {
                    int access$700 = KumoAppActivity.this.getAndRemoveSoundIndex(str);
                    if (access$700 >= 0) {
                        KumoAppActivity.this.m_SoundPool.unload(access$700);
                    }
                } catch (Exception e) {
                    Log.w(KumoAppActivity.s_TAG, "Failed to unload sound " + str, e);
                }
            }
        });
    }

    public long playSound(String str, float f, float f2, int i) {
        if (f <= 0.0f) {
            return 0;
        }
        final int soundIndex = getSoundIndex(str);
        if (soundIndex < 0) {
            Log.w(s_TAG, "Failed to play sound " + str + " (not yet loaded)");
            return 0;
        }
        long j = this.m_NextStreamUserId;
        this.m_NextStreamUserId = 1 + j;
        final float f3 = f;
        final int i2 = i;
        final float f4 = f2;
        final long j2 = j;
        this.m_SoundPlayExecutor.submit(new Runnable() {
            public void run() {
                try {
                    SoundPool access$500 = KumoAppActivity.this.m_SoundPool;
                    int i = soundIndex;
                    float f = f3;
                    KumoAppActivity.this.putStreamId(j2, access$500.play(i, f, f, 0, i2, f4));
                } catch (Exception e) {
                    Log.w(KumoAppActivity.s_TAG, e);
                }
            }
        });
        return j;
    }

    public void stopSound(long j) {
        withStreamId(j, new RunnableInt() {
            public void run(int i) {
                KumoAppActivity.this.m_SoundPool.stop(i);
            }
        });
    }

    public void setSoundVolume(long j, final float f) {
        withStreamId(j, new RunnableInt() {
            public void run(int i) {
                SoundPool access$500 = KumoAppActivity.this.m_SoundPool;
                float f = f;
                access$500.setVolume(i, f, f);
            }
        });
    }

    public void setSoundPitch(long j, final float f) {
        withStreamId(j, new RunnableInt() {
            public void run(int i) {
                KumoAppActivity.this.m_SoundPool.setRate(i, f);
            }
        });
    }

    public void playMusic(final String str, final int i, final int i2) {
        this.m_MusicPlayerExecutor.submit(new Runnable() {
            public void run() {
                boolean z;
                try {
                    AssetFileDescriptor openFd = KumoAppActivity.this.m_FileAccessor.openFd(str);
                    if (openFd != null) {
                        synchronized (KumoAppActivity.this.m_MusicLock) {
                            z = false;
                            boolean unused = KumoAppActivity.this.m_MediaPlayerReady = false;
                            float unused2 = KumoAppActivity.this.m_MediaPlayerVolume = 1.0f;
                            boolean unused3 = KumoAppActivity.this.m_MusicEnabled = i2 != 0;
                        }
                        KumoAppActivity.this.m_MediaPlayer.reset();
                        KumoAppActivity.this.m_MediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        KumoAppActivity.this.m_MediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                synchronized (KumoAppActivity.this.m_MusicLock) {
                                    boolean unused = KumoAppActivity.this.m_MediaPlayerReady = true;
                                }
                                KumoAppActivity.this.applyMusicState();
                            }
                        });
                        MediaPlayer access$1300 = KumoAppActivity.this.m_MediaPlayer;
                        int i = i;
                        if (i < 0 || i > 1) {
                            z = true;
                        }
                        access$1300.setLooping(z);
                        KumoAppActivity.this.m_MediaPlayer.setVolume(KumoAppActivity.this.m_MediaPlayerVolume, KumoAppActivity.this.m_MediaPlayerVolume);
                        KumoAppActivity.this.m_MediaPlayer.prepareAsync();
                    }
                } catch (Exception e) {
                    Log.w(KumoAppActivity.s_TAG, e);
                }
            }
        });
    }

    public void setMusicEnabled(int i) {
        synchronized (this.m_MusicLock) {
            this.m_MusicEnabled = i != 0;
        }
        applyMusicState();
    }

    public void setMusicVolume(float f) {
        synchronized (this.m_MusicLock) {
            if (Math.abs(this.m_MediaPlayerVolume - f) > 0.01f) {
                this.m_MediaPlayerVolume = f;
                this.m_MusicPlayerExecutor.submit(new Runnable() {
                    public void run() {
                        try {
                            if (KumoAppActivity.this.m_MediaPlayer != null) {
                                KumoAppActivity.this.m_MediaPlayer.setVolume(KumoAppActivity.this.m_MediaPlayerVolume, KumoAppActivity.this.m_MediaPlayerVolume);
                            }
                        } catch (Exception e) {
                            Log.w(KumoAppActivity.s_TAG, e);
                        }
                    }
                });
            }
        }
    }

    public void stopMusic() {
        this.m_MusicPlayerExecutor.submit(new Runnable() {
            public void run() {
                try {
                    synchronized (KumoAppActivity.this.m_MusicLock) {
                        boolean unused = KumoAppActivity.this.m_MediaPlayerReady = false;
                        boolean unused2 = KumoAppActivity.this.m_MusicEnabled = false;
                    }
                    KumoAppActivity.this.m_MediaPlayer.reset();
                } catch (Exception e) {
                    Log.w(KumoAppActivity.s_TAG, e);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void applyMusicState() {
        this.m_MusicPlayerExecutor.submit(new Runnable() {
            public void run() {
                try {
                    if (KumoAppActivity.this.m_MediaPlayer != null && KumoAppActivity.this.m_MediaPlayerReady) {
                        if (!KumoAppActivity.this.m_MusicEnabled || KumoAppActivity.this.m_MusicPaused || KumoAppActivity.this.m_PauseCount != 0) {
                            if (KumoAppActivity.this.m_MediaPlayer.isPlaying()) {
                                KumoAppActivity.this.m_MediaPlayer.pause();
                            }
                        } else if (!KumoAppActivity.this.m_MediaPlayer.isPlaying()) {
                            KumoAppActivity.this.m_MediaPlayer.start();
                        }
                    }
                } catch (Exception e) {
                    Log.w(KumoAppActivity.s_TAG, e);
                }
            }
        });
    }

    private void pauseMusic() {
        synchronized (this.m_MusicLock) {
            if (!this.m_MusicPaused) {
                this.m_MusicPaused = true;
                applyMusicState();
            }
        }
    }

    private void resumeMusic() {
        synchronized (this.m_MusicLock) {
            if (this.m_MusicPaused) {
                this.m_MusicPaused = false;
                applyMusicState();
            }
        }
    }

    public void playVoice(final String str) {
        this.m_MusicPlayerExecutor.submit(new Runnable() {
            public void run() {
                try {
                    AssetFileDescriptor openFd = KumoAppActivity.this.m_FileAccessor.openFd(str);
                    if (openFd != null) {
                        KumoAppActivity.this.m_VoicePlayer.reset();
                        KumoAppActivity.this.m_VoicePlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        KumoAppActivity.this.m_VoicePlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                mediaPlayer.start();
                            }
                        });
                        KumoAppActivity.this.m_VoicePlayer.setLooping(false);
                        KumoAppActivity.this.m_VoicePlayer.setVolume(1.0f, 1.0f);
                        KumoAppActivity.this.m_VoicePlayer.prepareAsync();
                    }
                } catch (Exception e) {
                    Log.w(KumoAppActivity.s_TAG, e);
                }
            }
        });
    }

    public void playVideo(final String str) {
        this.m_IsPlayingVideo = true;
        runOnUiThread(new Runnable() {
            public void run() {
                Log.v(KumoAppActivity.s_TAG, "Playing video: " + str);
                Intent intent = new Intent(KumoAppActivity.this, VideoPlayer.class);
                intent.putExtra("fullPath", str);
                KumoAppActivity.this.startActivityForResult(intent, 0);
            }
        });
    }

    private void adsInit() {
        IAdsFeature create = KumoAppBase.getAdsFeatureFactory().create(this);
        this.m_AdsFeature = create;
        create.adsInit();
    }

    public String adsGetSystemName() {
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        return iAdsFeature != null ? iAdsFeature.adsGetSystemName() : "";
    }

    public void adsShowDebugUi() {
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        if (iAdsFeature != null) {
            iAdsFeature.adsShowDebugUi();
        }
    }

    public boolean adsGetVideoAdsEnabled() {
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        return iAdsFeature != null && iAdsFeature.adsGetVideoAdsEnabled();
    }

    public void adsSetVideoAdsEnabled(boolean z) {
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        if (iAdsFeature != null) {
            iAdsFeature.adsSetVideoAdsEnabled(z);
        }
    }

    public boolean adsGetVideoAdPlaying() {
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        return iAdsFeature != null && iAdsFeature.adsGetVideoAdPlaying();
    }

    public boolean adsGetVideoAdReady() {
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        return iAdsFeature != null && iAdsFeature.adsGetVideoAdReady();
    }

    public void adsRequestVideoAd() {
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        if (iAdsFeature != null) {
            iAdsFeature.adsRequestVideoAd();
        }
    }

    public boolean adsGetIncentivisedAdsEnabled() {
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        return iAdsFeature != null && iAdsFeature.adsGetIncentivisedAdsEnabled();
    }

    public void adsSetIncentivisedAdsEnabled(boolean z) {
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        if (iAdsFeature != null) {
            iAdsFeature.adsSetIncentivisedAdsEnabled(z);
        }
    }

    public boolean adsGetIncentivisedAdReady() {
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        return iAdsFeature != null && iAdsFeature.adsGetIncentivisedAdReady();
    }

    public boolean adsGetIncentivisedAdPlaying() {
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        return iAdsFeature != null && iAdsFeature.adsGetIncentivisedAdPlaying();
    }

    public void adsRequestIncentivisedAd() {
        IAdsFeature iAdsFeature = this.m_AdsFeature;
        if (iAdsFeature != null) {
            iAdsFeature.adsRequestIncentivisedAd();
        }
    }

    private void analyticsInit() {
        this.m_AnalyticsFeature = KumoAppBase.getAnalyticsFeatureFactory().create(this);
    }

    public void analyticsBeginEvent() {
        IAnalyticsFeature iAnalyticsFeature = this.m_AnalyticsFeature;
        if (iAnalyticsFeature != null) {
            iAnalyticsFeature.analyticsBeginEvent();
        }
    }

    public void analyticsAddEventParam(String str, String str2) {
        IAnalyticsFeature iAnalyticsFeature = this.m_AnalyticsFeature;
        if (iAnalyticsFeature != null) {
            iAnalyticsFeature.analyticsAddEventParam(str, str2);
        }
    }

    public void analyticsLogEvent(String str, boolean z) {
        IAnalyticsFeature iAnalyticsFeature = this.m_AnalyticsFeature;
        if (iAnalyticsFeature != null) {
            iAnalyticsFeature.analyticsLogEvent(str, z);
        }
    }

    public void analyticsLogEvent(String str, Map<String, String> map, boolean z) {
        IAnalyticsFeature iAnalyticsFeature = this.m_AnalyticsFeature;
        if (iAnalyticsFeature != null) {
            iAnalyticsFeature.analyticsLogEvent(str, map, z);
        }
    }

    public void analyticsEndTimedEvent(String str) {
        IAnalyticsFeature iAnalyticsFeature = this.m_AnalyticsFeature;
        if (iAnalyticsFeature != null) {
            iAnalyticsFeature.analyticsEndTimedEvent(str);
        }
    }

    private void achievementsInit() {
        IAchievementsFeature create = KumoAppBase.getAchievementsFeatureFactory().create(this);
        this.m_AchievementsFeature = create;
        create.socialInit();
    }

    public void scoreSubmit(String[] strArr, String[] strArr2, long[] jArr) {
        IAchievementsFeature iAchievementsFeature = this.m_AchievementsFeature;
        if (iAchievementsFeature != null) {
            iAchievementsFeature.scoreSubmit(strArr, strArr2, jArr);
        }
    }

    public void showAchievementUi() {
        IAchievementsFeature iAchievementsFeature = this.m_AchievementsFeature;
        if (iAchievementsFeature != null) {
            iAchievementsFeature.showAchievementUi();
        }
    }

    public void showScoreUi(String str) {
        IAchievementsFeature iAchievementsFeature = this.m_AchievementsFeature;
        if (iAchievementsFeature != null) {
            iAchievementsFeature.showScoreUi(str);
        }
    }

    public boolean scoreIsLoggedIn() {
        IAchievementsFeature iAchievementsFeature = this.m_AchievementsFeature;
        return iAchievementsFeature != null && iAchievementsFeature.isLoggedIn();
    }

    public boolean scoreCanLogInOut() {
        IAchievementsFeature iAchievementsFeature = this.m_AchievementsFeature;
        return iAchievementsFeature != null && iAchievementsFeature.canLogInOut();
    }

    public void scoreLogInOut() {
        IAchievementsFeature iAchievementsFeature = this.m_AchievementsFeature;
        if (iAchievementsFeature != null) {
            iAchievementsFeature.logInOut();
        }
    }

    private void cloudInit() {
        this.m_CloudFeature = KumoAppBase.getCloudFeatureFactory().create(this);
    }

    public void cloudReady() {
        ICloudFeature iCloudFeature = this.m_CloudFeature;
        if (iCloudFeature != null) {
            iCloudFeature.cloudReady();
        }
    }

    public void cloudPushData(String[] strArr, String[] strArr2) {
        ICloudFeature iCloudFeature = this.m_CloudFeature;
        if (iCloudFeature != null) {
            iCloudFeature.cloudPushData(strArr, strArr2);
        }
    }

    public void cloudClearAll() {
        ICloudFeature iCloudFeature = this.m_CloudFeature;
        if (iCloudFeature != null) {
            iCloudFeature.cloudClearAll();
        }
    }

    private void iapInit() {
        IIapFeature create = KumoAppBase.getIapFeatureFactory().create(this);
        this.m_IapFeature = create;
        create.iapInit();
    }

    public int iapGetStatus() {
        IIapFeature iIapFeature = this.m_IapFeature;
        if (iIapFeature != null) {
            return iIapFeature.iapGetStatus();
        }
        return 0;
    }

    public String iapGetError() {
        IIapFeature iIapFeature = this.m_IapFeature;
        return iIapFeature != null ? iIapFeature.iapGetError() : "";
    }

    public void iapLoadProducts(String[] strArr) {
        IIapFeature iIapFeature = this.m_IapFeature;
        if (iIapFeature != null) {
            iIapFeature.iapLoadProducts(strArr);
        }
    }

    public boolean iapCanPurchase(String str) {
        IIapFeature iIapFeature = this.m_IapFeature;
        return iIapFeature != null && iIapFeature.iapCanPurchase(str);
    }

    public void iapPurchase(String str) {
        IIapFeature iIapFeature = this.m_IapFeature;
        if (iIapFeature != null) {
            iIapFeature.iapPurchase(str);
        }
    }

    public void iapRestore() {
        IIapFeature iIapFeature = this.m_IapFeature;
        if (iIapFeature != null) {
            iIapFeature.iapRestore();
        }
    }

    public String iapGetName(String str) {
        IIapFeature iIapFeature = this.m_IapFeature;
        return iIapFeature != null ? iIapFeature.iapGetName(str) : "";
    }

    public String iapGetDescription(String str) {
        IIapFeature iIapFeature = this.m_IapFeature;
        return iIapFeature != null ? iIapFeature.iapGetDescription(str) : "";
    }

    public String iapGetPrice(String str) {
        IIapFeature iIapFeature = this.m_IapFeature;
        return iIapFeature != null ? iIapFeature.iapGetPrice(str) : "";
    }
}
