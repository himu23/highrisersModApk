package com.ironsource;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class k0 {
    public static int a(Activity activity) {
        return activity.getRequestedOrientation();
    }

    static PackageInfo a(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(g(context), 0);
    }

    public static String a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && !TextUtils.isEmpty(str)) {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0)).toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static JSONObject a(Context context, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            int i = 0;
            if (jSONArray.length() == 0) {
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i >= strArr.length) {
                        break;
                    }
                    jSONObject.put(strArr[i], (packageInfo.requestedPermissionsFlags[i] & 2) != 0 ? "Granted" : "Rejected");
                    i++;
                }
            } else {
                List asList = Arrays.asList(packageInfo.requestedPermissions);
                while (i < jSONArray.length()) {
                    String string = jSONArray.getString(i);
                    int indexOf = asList.indexOf(string);
                    if (indexOf != -1) {
                        jSONObject.put(string, (packageInfo.requestedPermissionsFlags[indexOf] & 2) != 0 ? "Granted" : "Rejected");
                    } else {
                        jSONObject.put(string, "notFoundInManifest");
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean a() {
        try {
            Class.forName("kotlin.jvm.internal.Intrinsics");
            return true;
        } catch (Throwable unused) {
            Log.d("ApplicationContext", "Kotlin Intrinsics not found");
            return false;
        }
    }

    public static String b(Context context) {
        try {
            return a(context).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            return cacheDir.getPath();
        }
        return null;
    }

    public static boolean c(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static long d(Context context) {
        try {
            return a(context).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2, types: [int] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d(android.content.Context r4, java.lang.String r5) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 != 0) goto L_0x0033
            android.content.pm.PackageManager r0 = r4.getPackageManager()     // Catch:{ Exception -> 0x002f }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ Exception -> 0x002f }
            r2 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r4 = r0.getPackageInfo(r4, r2)     // Catch:{ Exception -> 0x002f }
            java.lang.String[] r0 = r4.requestedPermissions     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x0033
            r0 = 0
        L_0x001a:
            java.lang.String[] r2 = r4.requestedPermissions     // Catch:{ Exception -> 0x002c }
            int r3 = r2.length     // Catch:{ Exception -> 0x002c }
            if (r1 >= r3) goto L_0x002a
            if (r0 != 0) goto L_0x002a
            r2 = r2[r1]     // Catch:{ Exception -> 0x002c }
            boolean r0 = r5.equals(r2)     // Catch:{ Exception -> 0x002c }
            int r1 = r1 + 1
            goto L_0x001a
        L_0x002a:
            r1 = r0
            goto L_0x0033
        L_0x002c:
            r4 = move-exception
            r1 = r0
            goto L_0x0030
        L_0x002f:
            r4 = move-exception
        L_0x0030:
            r4.printStackTrace()
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.k0.d(android.content.Context, java.lang.String):boolean");
    }

    public static String e(Context context) {
        String str;
        try {
            str = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        } catch (Throwable unused) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static long f(Context context) {
        try {
            return a(context).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String g(Context context) {
        return context.getPackageName();
    }
}
