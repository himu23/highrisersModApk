package com.kumobius.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

public class Utils {
    private static final String s_TAG = "KumoJava";

    public static String getBundleAssetsPath(Activity activity) {
        return activity.getApplication().getPackageResourcePath() + "/assets";
    }

    public static String getAssetPath(Activity activity, String str) {
        String replaceFirst = str.replaceFirst("(?i)^.*\\.apk/assets/", "");
        if (replaceFirst == str) {
            return null;
        }
        return replaceFirst;
    }

    public static void setImmersiveMode(Activity activity) {
        int i = 1 | 2 | 5892;
        if (activity.getWindow().getDecorView().getSystemUiVisibility() != i) {
            activity.getWindow().getDecorView().setSystemUiVisibility(i);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            activity.getWindow().getAttributes().layoutInDisplayCutoutMode = 3;
        }
    }

    public static int getOrientationMode(Activity activity) {
        return activity.getResources().getInteger(R.integer.orientation);
    }

    public static boolean isTablet(Activity activity) {
        return activity.getResources().getBoolean(R.bool.isTablet);
    }

    public static void setRequestedOrientation(Activity activity) {
        int orientationMode = getOrientationMode(activity);
        if (orientationMode == 2) {
            activity.setRequestedOrientation(12);
        } else if (orientationMode != 3) {
            activity.setRequestedOrientation(11);
        } else {
            activity.setRequestedOrientation(13);
        }
    }

    public static String getUserDataDir(Activity activity) {
        File userDataDirFile = getUserDataDirFile(activity);
        if (userDataDirFile == null) {
            return null;
        }
        return userDataDirFile.getAbsolutePath();
    }

    public static File getUserDataDirFile(Activity activity) {
        File filesDir = activity.getFilesDir();
        if (filesDir == null) {
            return null;
        }
        return new File(filesDir, "userdata");
    }

    public static boolean isTvMode(Activity activity) {
        if (activity.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
            Log.v(s_TAG, "FEATURE_TELEVISION");
            return true;
        } else if (!activity.getPackageManager().hasSystemFeature("android.software.leanback")) {
            return false;
        } else {
            Log.v(s_TAG, "FEATURE_LEANBACK");
            return true;
        }
    }

    public static MediaPlayer createMediaPlayer() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(2).build());
        return mediaPlayer;
    }

    public static SoundPool createSoundPool() {
        AudioAttributes.Builder contentType = new AudioAttributes.Builder().setUsage(14).setContentType(4);
        SoundPool.Builder builder = new SoundPool.Builder();
        builder.setMaxStreams(10);
        builder.setAudioAttributes(contentType.build());
        return builder.build();
    }

    public static boolean hasPermission(Context context, String str) {
        if (context.checkCallingOrSelfPermission(str) == 0) {
            Log.v(s_TAG, str + " GRANTED");
            return true;
        }
        Log.v(s_TAG, str + " DENIED");
        return false;
    }

    public static boolean hasString(Context context, int i) {
        Resources resources = context.getResources();
        if (resources == null) {
            return false;
        }
        return !TextUtils.isEmpty(resources.getString(i));
    }

    public static String getString(Context context, int i) {
        Resources resources = context.getResources();
        if (resources == null) {
            return "";
        }
        String string = resources.getString(i);
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return string;
    }

    public static long getVersionCode(Context context) {
        try {
            return (long) context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            Log.e(s_TAG, "Couldn't get version code.", e);
            return -1;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            Log.e(s_TAG, "Couldn't get version name.", e);
            return "unknown";
        }
    }
}
