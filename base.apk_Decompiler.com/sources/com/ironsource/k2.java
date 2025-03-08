package com.ironsource;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class k2 {
    public static final String a = "3g";
    public static final String b = "wifi";
    public static final String c = "none";
    public static final String d = "bluetooth";
    public static final String e = "ethernet";
    public static final String f = "vpn";
    public static final String g = "cellular";
    public static final String h = "wifiAware";
    public static final String i = "lowpan";

    public static String a(Context context) {
        ConnectivityManager connectivityManager;
        String str;
        StringBuilder sb = new StringBuilder();
        if (!(context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null)) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    String typeName = activeNetworkInfo.getTypeName();
                    int type = activeNetworkInfo.getType();
                    if (type == 0) {
                        str = a;
                    } else if (type == 1) {
                        str = b;
                    } else {
                        sb.append(typeName);
                    }
                    sb.append(str);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static int b(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return context.getResources().getConfiguration().mcc;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static int c(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return context.getResources().getConfiguration().mnc;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int e(Context context) {
        if (context != null) {
            try {
                return ((TelephonyManager) context.getSystemService("phone")).getPhoneType();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return -1;
    }

    public static String f(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getSimOperator() : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean g(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r2 = (r2 = (android.net.ConnectivityManager) r2.getSystemService("connectivity")).getNetworkInfo(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean h(android.content.Context r2) {
        /*
            r0 = 0
            if (r2 == 0) goto L_0x001b
            java.lang.String r1 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r1)
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2
            if (r2 != 0) goto L_0x000e
            return r0
        L_0x000e:
            android.net.NetworkInfo r2 = r2.getNetworkInfo(r0)
            if (r2 == 0) goto L_0x001b
            boolean r2 = r2.isConnected()
            if (r2 == 0) goto L_0x001b
            r0 = 1
        L_0x001b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.k2.h(android.content.Context):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r2 = (r2 = (android.net.ConnectivityManager) r2.getSystemService("connectivity")).getNetworkInfo(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean i(android.content.Context r2) {
        /*
            r0 = 0
            if (r2 == 0) goto L_0x001c
            java.lang.String r1 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r1)
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2
            if (r2 != 0) goto L_0x000e
            return r0
        L_0x000e:
            r1 = 1
            android.net.NetworkInfo r2 = r2.getNetworkInfo(r1)
            if (r2 == 0) goto L_0x001c
            boolean r2 = r2.isConnected()
            if (r2 == 0) goto L_0x001c
            r0 = 1
        L_0x001c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.k2.i(android.content.Context):boolean");
    }
}
