package com.fyber.inneractive.sdk.util;

import android.content.Intent;
import android.os.Build;
import android.telephony.TelephonyManager;

public class n extends p {
    public static final /* synthetic */ int b = 0;

    public static boolean a(Intent intent) {
        try {
            if (p.a.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String h() {
        try {
            return ((TelephonyManager) p.a.getSystemService("phone")).getNetworkCountryIso();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String i() {
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    public static int j() {
        try {
            if (!p.b("android.permission.READ_PHONE_STATE")) {
                return 0;
            }
            TelephonyManager telephonyManager = (TelephonyManager) p.a.getSystemService("phone");
            return Build.VERSION.SDK_INT >= 24 ? telephonyManager.getDataNetworkType() : telephonyManager.getNetworkType();
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r0 = (android.telephony.TelephonyManager) com.fyber.inneractive.sdk.util.p.a.getSystemService("phone");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String k() {
        /*
            java.lang.String r0 = "phone"
            android.app.Application r1 = com.fyber.inneractive.sdk.util.p.a     // Catch:{ Exception -> 0x002b }
            java.lang.Object r1 = r1.getSystemService(r0)     // Catch:{ Exception -> 0x002b }
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch:{ Exception -> 0x002b }
            java.lang.String r2 = r1.getNetworkOperator()     // Catch:{ Exception -> 0x002b }
            int r3 = r1.getPhoneType()     // Catch:{ Exception -> 0x002b }
            r4 = 2
            if (r3 != r4) goto L_0x002a
            android.app.Application r3 = com.fyber.inneractive.sdk.util.p.a     // Catch:{ Exception -> 0x002b }
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch:{ Exception -> 0x002b }
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ Exception -> 0x002b }
            if (r0 == 0) goto L_0x002a
            int r0 = r0.getSimState()     // Catch:{ Exception -> 0x002b }
            r3 = 5
            if (r0 != r3) goto L_0x002a
            java.lang.String r2 = r1.getSimOperator()     // Catch:{ Exception -> 0x002b }
        L_0x002a:
            return r2
        L_0x002b:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.util.n.k():java.lang.String");
    }

    public static String l() {
        return p.a.getPackageName();
    }

    public static String m() {
        try {
            return p.a.getPackageManager().getPackageInfo(p.a.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean n() {
        return "mounted".equals(p.c()) && p.a.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static boolean o() {
        boolean z = (p.a.getResources().getConfiguration().screenLayout & 15) == 4;
        IAlog.d("This device has a tablet resolution? %s", Boolean.valueOf(z));
        return z;
    }
}
