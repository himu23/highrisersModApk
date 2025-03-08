package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.RoundedCorner;
import android.view.WindowManager;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;

public class h {
    private static final Map<Integer, Point> aVC = new HashMap(2);

    public static boolean KV() {
        return true;
    }

    public static boolean KW() {
        return true;
    }

    public static boolean KX() {
        return true;
    }

    public static boolean KY() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean KZ() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean La() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean Lb() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean Lc() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean Ld() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean Le() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public static boolean Lf() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public static boolean Lg() {
        return Build.VERSION.SDK_INT >= 34;
    }

    public static class a {
        int aVD;
        int aVE;
        int aVF;
        int aVG;

        public int Lh() {
            return this.aVD;
        }

        public int Li() {
            return this.aVE;
        }

        public int Lj() {
            return this.aVF;
        }

        public int Lk() {
            return this.aVG;
        }

        /* renamed from: com.applovin.impl.sdk.utils.h$a$a  reason: collision with other inner class name */
        public static class C0085a {
            private int aVD;
            private int aVE;
            private int aVF;
            private int aVG;

            public C0085a gQ(int i) {
                this.aVD = i;
                return this;
            }

            public C0085a gR(int i) {
                this.aVE = i;
                return this;
            }

            public C0085a gS(int i) {
                this.aVF = i;
                return this;
            }

            public C0085a gT(int i) {
                this.aVG = i;
                return this;
            }

            C0085a() {
            }

            public a Ll() {
                return new a(this.aVD, this.aVE, this.aVF, this.aVG);
            }

            public String toString() {
                return "CompatibilityUtils.ScreenCornerRadii.ScreenCornerRadiiBuilder(topLeft=" + this.aVD + ", topRight=" + this.aVE + ", bottomLeft=" + this.aVF + ", bottomRight=" + this.aVG + ")";
            }
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object obj) {
            return obj instanceof a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return aVar.canEqual(this) && Lh() == aVar.Lh() && Li() == aVar.Li() && Lj() == aVar.Lj() && Lk() == aVar.Lk();
        }

        public int hashCode() {
            return ((((((Lh() + 59) * 59) + Li()) * 59) + Lj()) * 59) + Lk();
        }

        public String toString() {
            return "CompatibilityUtils.ScreenCornerRadii(topLeft=" + Lh() + ", topRight=" + Li() + ", bottomLeft=" + Lj() + ", bottomRight=" + Lk() + ")";
        }

        a(int i, int i2, int i3, int i4) {
            this.aVD = i;
            this.aVE = i2;
            this.aVF = i3;
            this.aVG = i4;
        }
    }

    public static void KU() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        } catch (Throwable unused) {
        }
    }

    public static Point Y(Context context) {
        int orientation = AppLovinSdkUtils.getOrientation(context);
        Map<Integer, Point> map = aVC;
        if (map.containsKey(Integer.valueOf(orientation))) {
            return map.get(Integer.valueOf(orientation));
        }
        Point point = new Point();
        point.x = 480;
        point.y = 320;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (Ld()) {
                Rect m = windowManager.getMaximumWindowMetrics().getBounds();
                point = new Point(m.width(), m.height());
            } else if (KV()) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
        }
        StrictMode.setVmPolicy(vmPolicy);
        map.put(Integer.valueOf(orientation), point);
        return point;
    }

    public static Point Z(Context context) {
        Point point;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (Ld()) {
            Rect m = windowManager.getCurrentWindowMetrics().getBounds();
            point = new Point(m.width(), m.height());
        } else {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            point = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        StrictMode.setVmPolicy(vmPolicy);
        return point;
    }

    public static a a(Context context, n nVar) {
        a aVar = null;
        if (((Boolean) nVar.a(b.aOO)).booleanValue() && Le()) {
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                try {
                    Display defaultDisplay = windowManager.getDefaultDisplay();
                    aVar = new a.C0085a().gQ(a(0, defaultDisplay)).gR(a(1, defaultDisplay)).gS(a(3, defaultDisplay)).gT(a(2, defaultDisplay)).Ll();
                } catch (Throwable unused) {
                }
            }
            StrictMode.setVmPolicy(vmPolicy);
        }
        return aVar;
    }

    private static int a(int i, Display display) {
        RoundedCorner m = display.getRoundedCorner(i);
        if (m != null) {
            return m.getRadius();
        }
        return -1;
    }

    public static boolean d(String str, Context context) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
