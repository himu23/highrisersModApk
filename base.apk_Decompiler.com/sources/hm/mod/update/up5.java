package hm.mod.update;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.LocaleList;
import com.ironsource.d1;
import java.util.Locale;

public class up5 {
    private static up5 prefsInstance;
    private static SharedPreferences sharedPreferences;

    public static void setUpdateShow(Context context) {
        with(context).writeBoolean(d1.u, true);
    }

    public static boolean isUpdateShowed(Context context) {
        return with(context).readBoolean(d1.u, false);
    }

    public static void setShowTimes(Context context) {
        with(context).writeInt("show_times", getShowTimes(context) + 1);
    }

    public static int getShowTimes(Context context) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return with(context).readInt("show_times", 0);
    }

    public static void setLastShow(Context context) {
        with(context).writeLong("last_show", System.currentTimeMillis() / 1000);
    }

    public static long getLastShow(Context context) {
        return with(context).readLong("last_show", 0).longValue();
    }

    private up5(Context context) {
        Context applicationContext = context.getApplicationContext();
        sharedPreferences = applicationContext.getSharedPreferences(context.getPackageName() + "_forceupdate", 0);
    }

    public static up5 with(Context context) {
        if (prefsInstance == null) {
            prefsInstance = new up5(context);
        }
        return prefsInstance;
    }

    public void writeLong(String str, long j) {
        sharedPreferences.edit().putLong(str, j).apply();
    }

    public Long readLong(String str, long j) {
        return Long.valueOf(sharedPreferences.getLong(str, j));
    }

    public void writeInt(String str, int i) {
        sharedPreferences.edit().putInt(str, i).apply();
    }

    public int readInt(String str, int i) {
        return sharedPreferences.getInt(str, i);
    }

    public void writeBoolean(String str, boolean z) {
        sharedPreferences.edit().putBoolean(str, z).apply();
    }

    public boolean readBoolean(String str, boolean z) {
        return sharedPreferences.getBoolean(str, z);
    }

    public static String getLang() {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = LocaleList.getDefault().get(0);
            } else {
                locale = Locale.getDefault();
            }
            if (locale != null) {
                return locale.getLanguage();
            }
            return "en";
        } catch (Exception e) {
            e.printStackTrace();
            return "en";
        }
    }

    public static String getCountry() {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = LocaleList.getDefault().get(0);
            } else {
                locale = Locale.getDefault();
            }
            if (locale != null) {
                return locale.getCountry();
            }
            return "US";
        } catch (Exception e) {
            e.printStackTrace();
            return "US";
        }
    }

    public static boolean isScreenLandscape(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
