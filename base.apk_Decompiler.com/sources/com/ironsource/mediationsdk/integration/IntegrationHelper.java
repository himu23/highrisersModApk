package com.ironsource.mediationsdk.integration;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.p;
import com.ironsource.mediationsdk.utils.IronSourceUtils;

public class IntegrationHelper {
    private static final String a = "IntegrationHelper";
    private static final String b = "4.1";
    private static final String c = "4.3";

    class a extends Thread {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        public void run() {
            try {
                Log.w(IntegrationHelper.a, "--------------- Google Play Services --------------");
                if (this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128).metaData.containsKey("com.google.android.gms.version")) {
                    Log.i(IntegrationHelper.a, "Google Play Services - VERIFIED");
                    String b = p.o().b(this.a);
                    if (!TextUtils.isEmpty(b)) {
                        Log.i(IntegrationHelper.a, "GAID is: " + b + " (use this for test devices)");
                        return;
                    }
                    return;
                }
                Log.e(IntegrationHelper.a, "Google Play Services - MISSING");
            } catch (Exception unused) {
                Log.e(IntegrationHelper.a, "Google Play Services - MISSING");
            }
        }
    }

    private static IntegrationData a(Context context, String str) {
        String str2;
        try {
            IntegrationData integrationData = (IntegrationData) Class.forName(str).getMethod("getIntegrationData", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
            Log.i(a, "Adapter " + integrationData.version + " - VERIFIED");
            return integrationData;
        } catch (ClassNotFoundException unused) {
            str2 = "Adapter - MISSING";
            Log.e(a, str2);
            return null;
        } catch (Exception unused2) {
            str2 = "Adapter version - NOT VERIFIED";
            Log.e(a, str2);
            return null;
        }
    }

    private static void a(Context context) {
        new a(context).start();
    }

    private static void a(String str) {
        try {
            Log.i(a, "SDK Version - " + ((String) Class.forName(str).getMethod("getAdapterSDKVersion", new Class[0]).invoke((Object) null, new Object[0])));
        } catch (Exception unused) {
            Log.w("validateSDKVersion", "Unable to get SDK version");
        }
    }

    private static boolean a(IntegrationData integrationData) {
        if (integrationData.version.startsWith(b) || integrationData.version.startsWith(c)) {
            Log.i(a, "Adapter - VERIFIED");
            return true;
        }
        Log.e(a, integrationData.name + " adapter " + integrationData.version + " is incompatible with SDK version " + IronSourceUtils.getSDKVersion() + ", please update your adapter to version 4.1.*");
        return false;
    }

    private static void b(Context context) {
        Log.i(a, "*** Permissions ***");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager.checkPermission("android.permission.INTERNET", context.getPackageName()) == 0) {
            Log.i(a, "android.permission.INTERNET - VERIFIED");
        } else {
            Log.e(a, "android.permission.INTERNET - MISSING");
        }
        if (packageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0) {
            Log.i(a, "android.permission.ACCESS_NETWORK_STATE - VERIFIED");
        } else {
            Log.e(a, "android.permission.ACCESS_NETWORK_STATE - MISSING");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042 A[Catch:{ Exception -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005e A[Catch:{ Exception -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0086 A[Catch:{ Exception -> 0x009a }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0087 A[Catch:{ Exception -> 0x009a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(android.content.Context r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "IntegrationHelper"
            java.lang.String r1 = "com.ironsource.adapters."
            java.lang.String r2 = "--------------- "
            r3 = 0
            java.lang.String r4 = com.ironsource.environment.StringUtils.toLowerCase(r10)     // Catch:{ Exception -> 0x009a }
            int r5 = r4.hashCode()     // Catch:{ Exception -> 0x009a }
            r6 = -1875652737(0xffffffff9033cf7f, float:-3.5461375E-29)
            r7 = 2
            r8 = 1
            if (r5 == r6) goto L_0x0035
            r6 = 92668925(0x58603fd, float:1.2602765E-35)
            if (r5 == r6) goto L_0x002b
            r6 = 497130182(0x1da19ac6, float:4.2776377E-21)
            if (r5 == r6) goto L_0x0021
            goto L_0x003f
        L_0x0021:
            java.lang.String r5 = "facebook"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x009a }
            if (r4 == 0) goto L_0x003f
            r4 = 1
            goto L_0x0040
        L_0x002b:
            java.lang.String r5 = "admob"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x009a }
            if (r4 == 0) goto L_0x003f
            r4 = 2
            goto L_0x0040
        L_0x0035:
            java.lang.String r5 = "supersonicads"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x009a }
            if (r4 == 0) goto L_0x003f
            r4 = 0
            goto L_0x0040
        L_0x003f:
            r4 = -1
        L_0x0040:
            if (r4 == 0) goto L_0x005e
            if (r4 == r8) goto L_0x005b
            if (r4 == r7) goto L_0x0058
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009a }
            r4.<init>(r2)     // Catch:{ Exception -> 0x009a }
            r4.append(r10)     // Catch:{ Exception -> 0x009a }
            java.lang.String r2 = " --------------"
            r4.append(r2)     // Catch:{ Exception -> 0x009a }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x009a }
            goto L_0x0060
        L_0x0058:
            java.lang.String r2 = "--------------- Google (AdMob and Ad Manager) --------------"
            goto L_0x0060
        L_0x005b:
            java.lang.String r2 = "--------------- Meta --------------"
            goto L_0x0060
        L_0x005e:
            java.lang.String r2 = "--------------- IronSource --------------"
        L_0x0060:
            android.util.Log.i(r0, r2)     // Catch:{ Exception -> 0x009a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009a }
            r2.<init>(r1)     // Catch:{ Exception -> 0x009a }
            java.lang.String r1 = com.ironsource.environment.StringUtils.toLowerCase(r10)     // Catch:{ Exception -> 0x009a }
            r2.append(r1)     // Catch:{ Exception -> 0x009a }
            java.lang.String r1 = "."
            r2.append(r1)     // Catch:{ Exception -> 0x009a }
            r2.append(r10)     // Catch:{ Exception -> 0x009a }
            java.lang.String r1 = "Adapter"
            r2.append(r1)     // Catch:{ Exception -> 0x009a }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x009a }
            com.ironsource.mediationsdk.IntegrationData r9 = a(r9, r1)     // Catch:{ Exception -> 0x009a }
            if (r9 != 0) goto L_0x0087
            return r3
        L_0x0087:
            java.lang.String r2 = "SupersonicAds"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x009a }
            if (r2 != 0) goto L_0x0096
            boolean r9 = a((com.ironsource.mediationsdk.IntegrationData) r9)     // Catch:{ Exception -> 0x009a }
            if (r9 != 0) goto L_0x0096
            return r3
        L_0x0096:
            a((java.lang.String) r1)     // Catch:{ Exception -> 0x009a }
            return r8
        L_0x009a:
            r9 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "isAdapterValid "
            r1.<init>(r2)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            android.util.Log.e(r0, r10, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.integration.IntegrationHelper.b(android.content.Context, java.lang.String):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b1, code lost:
        if (r6.equals("facebook") == false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e5, code lost:
        android.util.Log.e(a, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0068, code lost:
        if (r6.equals("facebook") == false) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void validateIntegration(android.content.Context r22) {
        /*
            java.lang.String r0 = "Verifying Integration:"
            java.lang.String r1 = "IntegrationHelper"
            android.util.Log.i(r1, r0)
            b(r22)
            java.lang.String r2 = "AdColony"
            java.lang.String r3 = "AppLovin"
            java.lang.String r4 = "APS"
            java.lang.String r5 = "BidMachine"
            java.lang.String r6 = "Chartboost"
            java.lang.String r7 = "Fyber"
            java.lang.String r8 = "AdMob"
            java.lang.String r9 = "HyprMX"
            java.lang.String r10 = "InMobi"
            java.lang.String r11 = "SupersonicAds"
            java.lang.String r12 = "Maio"
            java.lang.String r13 = "Facebook"
            java.lang.String r14 = "Mintegral"
            java.lang.String r15 = "MyTarget"
            java.lang.String r16 = "Pangle"
            java.lang.String r17 = "Smaato"
            java.lang.String r18 = "SuperAwesome"
            java.lang.String r19 = "Tapjoy"
            java.lang.String r20 = "UnityAds"
            java.lang.String r21 = "Vungle"
            java.lang.String[] r0 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}
            r2 = 0
            r3 = 0
        L_0x0038:
            r4 = 20
            if (r3 >= r4) goto L_0x00ec
            r4 = r0[r3]
            r5 = r22
            boolean r6 = b(r5, r4)
            java.lang.String r7 = ">>>> "
            r8 = 2
            java.lang.String r9 = "facebook"
            java.lang.String r10 = "admob"
            java.lang.String r11 = "supersonicads"
            r12 = -1
            r13 = 1
            if (r6 == 0) goto L_0x009a
            java.lang.String r6 = com.ironsource.environment.StringUtils.toLowerCase(r4)
            r6.hashCode()
            r6.hashCode()
            int r14 = r6.hashCode()
            switch(r14) {
                case -1875652737: goto L_0x0074;
                case 92668925: goto L_0x006b;
                case 497130182: goto L_0x0064;
                default: goto L_0x0062;
            }
        L_0x0062:
            r8 = -1
            goto L_0x007c
        L_0x0064:
            boolean r6 = r6.equals(r9)
            if (r6 != 0) goto L_0x007c
            goto L_0x0062
        L_0x006b:
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L_0x0072
            goto L_0x0062
        L_0x0072:
            r8 = 1
            goto L_0x007c
        L_0x0074:
            boolean r6 = r6.equals(r11)
            if (r6 != 0) goto L_0x007b
            goto L_0x0062
        L_0x007b:
            r8 = 0
        L_0x007c:
            switch(r8) {
                case 0: goto L_0x0097;
                case 1: goto L_0x0094;
                case 2: goto L_0x0091;
                default: goto L_0x007f;
            }
        L_0x007f:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r7)
            r6.append(r4)
            java.lang.String r4 = " - VERIFIED"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            goto L_0x00df
        L_0x0091:
            java.lang.String r4 = ">>>> Meta - VERIFIED"
            goto L_0x00df
        L_0x0094:
            java.lang.String r4 = ">>>> Google (AdMob and Ad Manager) - VERIFIED"
            goto L_0x00df
        L_0x0097:
            java.lang.String r4 = ">>>> IronSource - VERIFIED"
            goto L_0x00df
        L_0x009a:
            java.lang.String r6 = com.ironsource.environment.StringUtils.toLowerCase(r4)
            r6.hashCode()
            r6.hashCode()
            int r14 = r6.hashCode()
            switch(r14) {
                case -1875652737: goto L_0x00bd;
                case 92668925: goto L_0x00b4;
                case 497130182: goto L_0x00ad;
                default: goto L_0x00ab;
            }
        L_0x00ab:
            r8 = -1
            goto L_0x00c5
        L_0x00ad:
            boolean r6 = r6.equals(r9)
            if (r6 != 0) goto L_0x00c5
            goto L_0x00ab
        L_0x00b4:
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L_0x00bb
            goto L_0x00ab
        L_0x00bb:
            r8 = 1
            goto L_0x00c5
        L_0x00bd:
            boolean r6 = r6.equals(r11)
            if (r6 != 0) goto L_0x00c4
            goto L_0x00ab
        L_0x00c4:
            r8 = 0
        L_0x00c5:
            switch(r8) {
                case 0: goto L_0x00e3;
                case 1: goto L_0x00dd;
                case 2: goto L_0x00da;
                default: goto L_0x00c8;
            }
        L_0x00c8:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r7)
            r6.append(r4)
            java.lang.String r4 = " - NOT VERIFIED"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            goto L_0x00e5
        L_0x00da:
            java.lang.String r4 = ">>>> Meta - NOT VERIFIED"
            goto L_0x00df
        L_0x00dd:
            java.lang.String r4 = ">>>> Google (AdMob and Ad Manager) - NOT VERIFIED"
        L_0x00df:
            android.util.Log.i(r1, r4)
            goto L_0x00e8
        L_0x00e3:
            java.lang.String r4 = ">>>> IronSource - NOT VERIFIED"
        L_0x00e5:
            android.util.Log.e(r1, r4)
        L_0x00e8:
            int r3 = r3 + 1
            goto L_0x0038
        L_0x00ec:
            r5 = r22
            a((android.content.Context) r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.integration.IntegrationHelper.validateIntegration(android.content.Context):void");
    }
}
