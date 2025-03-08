package com.fyber.inneractive.sdk.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.ironsource.m2;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.UByte;
import kotlin.UByte$$ExternalSyntheticBackport0;

public class p {
    public static Application a;

    public static class a {
        public static Map<String, String> a = new HashMap();
    }

    public static Application a() {
        return a;
    }

    public static String g() {
        IAConfigManager iAConfigManager;
        int i = 0;
        while (true) {
            iAConfigManager = IAConfigManager.M;
            if (!iAConfigManager.y.c.compareAndSet(true, true) && i < 25) {
                IAlog.a("UserAgentProvider | waiting on user agent", new Object[0]);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException unused) {
                }
                i++;
            }
        }
        return iAConfigManager.y.a();
    }

    public static int a(int i) {
        return (int) ((((float) i) * b()) + 0.5f);
    }

    public static boolean b(String str) {
        try {
            return a.checkCallingOrSelfPermission(str) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Drawable c(int i) {
        return IAConfigManager.M.v.a().getDrawable(i);
    }

    public static int d() {
        Application application = a;
        int i = (application == null || application.getResources() == null || application.getResources().getConfiguration() == null) ? 1 : application.getResources().getConfiguration().orientation;
        try {
            if (Settings.System.getInt(application.getContentResolver(), "accelerometer_rotation", 0) != 1) {
                i = 1;
            }
        } catch (Throwable th) {
            IAlog.a("failed getOrientation. returning portrait orientation", th, new Object[0]);
        }
        Object[] objArr = new Object[1];
        objArr[0] = i == 1 ? m2.h.D : m2.h.C;
        IAlog.a("The device orientation: %s", objArr);
        return i;
    }

    public static int e() {
        int i;
        WindowManager windowManager;
        Display defaultDisplay;
        if (a == null || (windowManager = (WindowManager) IAConfigManager.M.v.a().getSystemService("window")) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            i = -1;
        } else {
            Point point = new Point();
            defaultDisplay.getSize(point);
            i = point.y;
        }
        if (i != -1) {
            return i;
        }
        try {
            DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
            if (displayMetrics != null) {
                i = displayMetrics.heightPixels;
            }
        } catch (Throwable unused) {
        }
        if (i == -1) {
            return 480;
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c A[SYNTHETIC, Splitter:B:12:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int f() {
        /*
            r0 = -1
            android.app.Application r1 = a     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0029
            com.fyber.inneractive.sdk.config.IAConfigManager r1 = com.fyber.inneractive.sdk.config.IAConfigManager.M     // Catch:{ all -> 0x0028 }
            com.fyber.inneractive.sdk.config.e r1 = r1.v     // Catch:{ all -> 0x0028 }
            android.content.Context r1 = r1.a()     // Catch:{ all -> 0x0028 }
            java.lang.String r2 = "window"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ all -> 0x0028 }
            android.view.WindowManager r1 = (android.view.WindowManager) r1     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0029
            android.view.Display r1 = r1.getDefaultDisplay()     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0029
            android.graphics.Point r2 = new android.graphics.Point     // Catch:{ all -> 0x0028 }
            r2.<init>()     // Catch:{ all -> 0x0028 }
            r1.getSize(r2)     // Catch:{ all -> 0x0028 }
            int r1 = r2.x     // Catch:{ all -> 0x0028 }
            goto L_0x002a
        L_0x0028:
        L_0x0029:
            r1 = -1
        L_0x002a:
            if (r1 != r0) goto L_0x003e
            android.content.res.Resources r2 = android.content.res.Resources.getSystem()     // Catch:{ all -> 0x0039 }
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x003a
            int r1 = r2.widthPixels     // Catch:{ all -> 0x0039 }
            goto L_0x003a
        L_0x0039:
        L_0x003a:
            if (r1 != r0) goto L_0x003e
            r1 = 320(0x140, float:4.48E-43)
        L_0x003e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.util.p.f():int");
    }

    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static int b(int i) {
        try {
            return (int) ((((float) i) / b()) + 0.5f);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static boolean a(String... strArr) {
        int i = 0;
        while (i < strArr.length) {
            try {
                Class.forName(strArr[i]);
                i++;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return true;
    }

    public static float b() {
        return ((float) IAConfigManager.M.v.a().getResources().getConfiguration().densityDpi) / 160.0f;
    }

    public static String c(String str) {
        String str2 = (String) ((HashMap) a.a).get(str);
        if (TextUtils.isEmpty(str2)) {
            IAlog.a("Assets cache: reading file: %s", str);
            try {
                InputStream open = a.getAssets().open(str, 3);
                StringBuffer stringBuffer = new StringBuffer();
                byte[] bArr = new byte[4096];
                for (int i = 0; i != -1; i = open.read(bArr)) {
                    stringBuffer.append(new String(bArr, 0, i));
                }
                open.close();
                str2 = stringBuffer.toString();
                IAlog.a("Assets cache: success - %s", str);
            } catch (IOException e) {
                IAlog.a("Assets cache: Could not read response from file", new Object[0]);
                IAlog.d(u.b((Throwable) e), new Object[0]);
            }
            if (!TextUtils.isEmpty(str2)) {
                ((HashMap) a.a).put(str, str2);
            }
        } else {
            IAlog.a("Assets cache: returning cached assets for %s", str);
        }
        return str2;
    }

    public static void a(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static int a(float f) {
        return (int) (TypedValue.applyDimension(1, f, IAConfigManager.M.v.a().getResources().getDisplayMetrics()) + 0.5f);
    }

    public static String a(String str, Collection<Integer> collection) {
        ArrayList arrayList = new ArrayList();
        for (Integer valueOf : collection) {
            arrayList.add(String.valueOf(valueOf));
        }
        return b(str, arrayList);
    }

    /* JADX INFO: finally extract failed */
    public static boolean a(String str, Context context, byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = context.openFileOutput(str, 0);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                u.a((Closeable) fileOutputStream);
                return true;
            } catch (Throwable unused) {
                try {
                    IAlog.a("writeFileWithContext failed writing %s", str);
                    u.a((Closeable) fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    u.a((Closeable) fileOutputStream);
                    throw th;
                }
            }
        } catch (Throwable unused2) {
            fileOutputStream = null;
            IAlog.a("writeFileWithContext failed writing %s", str);
            u.a((Closeable) fileOutputStream);
            return false;
        }
    }

    public static String b(String str, Collection<String> collection) {
        if (Build.VERSION.SDK_INT >= 26) {
            return UByte$$ExternalSyntheticBackport0.m((CharSequence) str, (Iterable) collection);
        }
        return TextUtils.join(str, collection);
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr.length <= 0) {
                return "";
            }
            Signature signature = signatureArr[0];
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(signature.toByteArray());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(View view, int i, int i2) {
        if (view != null && view.getLayoutParams() != null) {
            view.getLayoutParams().width = a(i);
            view.getLayoutParams().height = a(i2);
        }
    }

    public static int a(Context context) {
        Window window;
        Rect rect = new Rect();
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null) {
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
        }
        return rect.top;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = ((android.app.Activity) r1).getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r1, int r2) {
        /*
            boolean r0 = r1 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0014
            android.app.Activity r1 = (android.app.Activity) r1
            android.view.Window r1 = r1.getWindow()
            if (r1 == 0) goto L_0x0014
            r0 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r1.findViewById(r0)
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            if (r1 == 0) goto L_0x001d
            int r1 = r1.getTop()
            int r1 = r1 - r2
            goto L_0x001e
        L_0x001d:
            r1 = 0
        L_0x001e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.util.p.a(android.content.Context, int):int");
    }

    public static String c() {
        try {
            return Environment.getExternalStorageState();
        } catch (Throwable unused) {
            return "";
        }
    }
}
