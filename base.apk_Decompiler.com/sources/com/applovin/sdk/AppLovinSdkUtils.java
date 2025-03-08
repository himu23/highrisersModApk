package com.applovin.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.ImageView;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.c.e;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.l;
import com.applovin.impl.sdk.utils.u;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AppLovinSdkUtils {
    private static final Handler aZA = new Handler(Looper.getMainLooper());

    public static final class Size {
        public static final Size ZERO = new Size(0, 0);
        private int dE;
        private int height;

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.dE;
        }

        public int hashCode() {
            int i = this.height;
            int i2 = this.dE;
            return i ^ ((i2 >>> 16) | (i2 << 16));
        }

        private Size() {
        }

        public Size(int i, int i2) {
            this.dE = i;
            this.height = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Size)) {
                return false;
            }
            Size size = (Size) obj;
            if (this.dE == size.getWidth() && this.height == size.getHeight()) {
                return true;
            }
            return false;
        }

        public String toString() {
            return this.dE + "x" + this.height;
        }
    }

    public static int dpToPx(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    public static int pxToDp(Context context, int i) {
        return (int) Math.ceil((double) (((float) i) / context.getResources().getDisplayMetrics().density));
    }

    public static boolean isTablet(Context context) {
        Point Y = h.Y(context);
        return Math.min(Y.x, Y.y) >= dpToPx(context, 600);
    }

    public static boolean isEmulator() {
        return O(Build.DEVICE, "goldfish,vbox") || O(Build.HARDWARE, "ranchu,generic,vbox") || O(Build.MANUFACTURER, "Genymotion") || O(Build.MODEL, "Android SDK built for x86");
    }

    private static boolean O(String str, String str2) {
        return StringUtils.startsWithAtLeastOnePrefix(str, CollectionUtils.explode(str2));
    }

    public static int getOrientation(Context context) {
        Resources resources;
        Configuration configuration;
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return 0;
        }
        return configuration.orientation;
    }

    public static boolean isValidString(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(false, runnable);
    }

    public static void runOnUiThread(boolean z, Runnable runnable) {
        if (z || !u.Lx()) {
            aZA.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j) {
        runOnUiThreadDelayed(runnable, j, aZA);
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j, Handler handler) {
        if (j > 0) {
            handler.postDelayed(runnable, j);
        } else if (u.Lx()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public static Map<String, String> toMap(JSONObject jSONObject) throws JSONException {
        return JsonUtils.toStringMap(jSONObject);
    }

    public static boolean isSdkVersionGreaterThanOrEqualTo(String str) {
        return AppLovinSdk.VERSION_CODE >= u.dG(str);
    }

    public static boolean isFireOS(Context context) {
        return "amazon".equalsIgnoreCase(Build.MANUFACTURER) || isFireTv(context);
    }

    public static boolean isFireTv(Context context) {
        return context.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv");
    }

    public static boolean isTv(Context context) {
        if (isFireTv(context)) {
            return true;
        }
        PackageManager packageManager = context.getPackageManager();
        if (h.KX()) {
            return packageManager.hasSystemFeature("android.software.leanback");
        }
        return packageManager.hasSystemFeature("android.hardware.type.television");
    }

    public static void setImageUrl(String str, ImageView imageView, AppLovinSdk appLovinSdk) {
        l.a(imageView, str, appLovinSdk.a());
    }

    public static Boolean getTcfConsentStatus(int i, Context context) {
        String str = (String) e.a(d.aRz, null, PreferenceManager.getDefaultSharedPreferences(context), false);
        if (str != null) {
            return Boolean.valueOf(com.applovin.impl.privacy.b.d.e(str, i - 1));
        }
        return null;
    }

    public static Boolean getAdditionalConsentStatus(int i, Context context) {
        return com.applovin.impl.privacy.b.d.f(i, (String) e.a(d.aRy, null, PreferenceManager.getDefaultSharedPreferences(context), false));
    }
}
