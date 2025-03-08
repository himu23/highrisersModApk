package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.m1;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class l {
    public static final String a = "BANNER";
    public static final String b = "LARGE";
    public static final String c = "RECTANGLE";
    public static final String d = "LEADERBOARD";
    public static final String e = "SMART";
    public static final String f = "CUSTOM";
    public static final String g = "bannerAdSize";
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 5;
    public static final int l = 6;
    public static final String m = "Adaptive=true";

    class a implements Runnable {
        final /* synthetic */ IronSourceBannerLayout a;
        final /* synthetic */ View b;
        final /* synthetic */ FrameLayout.LayoutParams c;

        a(IronSourceBannerLayout ironSourceBannerLayout, View view, FrameLayout.LayoutParams layoutParams) {
            this.a = ironSourceBannerLayout;
            this.b = view;
            this.c = layoutParams;
        }

        public void run() {
            this.a.removeAllViews();
            ViewParent parent = this.b.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.b);
            }
            this.a.addView(this.b, 0, this.c);
        }
    }

    interface b {
        void a(Map<String, Object> map, List<String> list, StringBuilder sb);
    }

    interface c {
        void a();

        void a(String str);
    }

    static long a(long j2, long j3) {
        return j3 - (new Date().getTime() - j2);
    }

    public static ISBannerSize a() {
        return new ISBannerSize(d, 728, 90);
    }

    public static ISBannerSize a(String str, int i2, int i3) {
        return new ISBannerSize(str, i2, i3);
    }

    public static void a(IronSourceBannerLayout ironSourceBannerLayout) {
        if (ironSourceBannerLayout != null) {
            ironSourceBannerLayout.a();
        }
    }

    public static void a(IronSourceBannerLayout ironSourceBannerLayout, View view, FrameLayout.LayoutParams layoutParams) {
        if (ironSourceBannerLayout != null && view != null && layoutParams != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(ironSourceBannerLayout, view, layoutParams));
        }
    }

    static void a(IronSourceBannerLayout ironSourceBannerLayout, m1 m1Var, c cVar) {
        String str;
        if (!b(ironSourceBannerLayout)) {
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            str = String.format("can't load banner - %s", objArr);
        } else {
            str = null;
        }
        if (m1Var == null || TextUtils.isEmpty(m1Var.getPlacementName())) {
            Object[] objArr2 = new Object[1];
            objArr2[0] = m1Var == null ? "placement is null" : "placement name is empty";
            str = String.format("can't load banner - %s", objArr2);
        }
        if (!TextUtils.isEmpty(str)) {
            IronLog.INTERNAL.error(str);
            cVar.a(str);
            return;
        }
        cVar.a();
    }

    static void a(IronSourceBannerLayout ironSourceBannerLayout, c cVar) {
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            cVar.a(String.format("can't destroy banner - %s", objArr));
            return;
        }
        cVar.a();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009d A[Catch:{ Exception -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.util.Map<java.lang.String, java.lang.Object> r8, com.ironsource.mediationsdk.ISBannerSize r9) {
        /*
            java.lang.String r0 = "ext1"
            java.lang.String r1 = " , Adaptive=true"
            if (r9 == 0) goto L_0x00c6
            java.lang.String r2 = r9.getDescription()     // Catch:{ Exception -> 0x00bc }
            int r3 = r2.hashCode()     // Catch:{ Exception -> 0x00bc }
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            switch(r3) {
                case -387072689: goto L_0x003e;
                case 72205083: goto L_0x0034;
                case 79011241: goto L_0x002a;
                case 1951953708: goto L_0x0020;
                case 1999208305: goto L_0x0016;
                default: goto L_0x0015;
            }     // Catch:{ Exception -> 0x00bc }
        L_0x0015:
            goto L_0x0048
        L_0x0016:
            java.lang.String r3 = "CUSTOM"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x00bc }
            if (r2 == 0) goto L_0x0048
            r2 = 4
            goto L_0x0049
        L_0x0020:
            java.lang.String r3 = "BANNER"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x00bc }
            if (r2 == 0) goto L_0x0048
            r2 = 0
            goto L_0x0049
        L_0x002a:
            java.lang.String r3 = "SMART"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x00bc }
            if (r2 == 0) goto L_0x0048
            r2 = 3
            goto L_0x0049
        L_0x0034:
            java.lang.String r3 = "LARGE"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x00bc }
            if (r2 == 0) goto L_0x0048
            r2 = 1
            goto L_0x0049
        L_0x003e:
            java.lang.String r3 = "RECTANGLE"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x00bc }
            if (r2 == 0) goto L_0x0048
            r2 = 2
            goto L_0x0049
        L_0x0048:
            r2 = -1
        L_0x0049:
            java.lang.String r3 = "bannerAdSize"
            if (r2 == 0) goto L_0x0090
            if (r2 == r7) goto L_0x008b
            if (r2 == r6) goto L_0x0086
            if (r2 == r5) goto L_0x0080
            if (r2 == r4) goto L_0x0056
            goto L_0x0097
        L_0x0056:
            r2 = 6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00bc }
            r8.put(r3, r2)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r2 = "custom_banner_size"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bc }
            r3.<init>()     // Catch:{ Exception -> 0x00bc }
            int r4 = r9.getWidth()     // Catch:{ Exception -> 0x00bc }
            r3.append(r4)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r4 = "x"
            r3.append(r4)     // Catch:{ Exception -> 0x00bc }
            int r4 = r9.getHeight()     // Catch:{ Exception -> 0x00bc }
            r3.append(r4)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00bc }
            r8.put(r2, r3)     // Catch:{ Exception -> 0x00bc }
            goto L_0x0097
        L_0x0080:
            r2 = 5
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00bc }
            goto L_0x0094
        L_0x0086:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00bc }
            goto L_0x0094
        L_0x008b:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x00bc }
            goto L_0x0094
        L_0x0090:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x00bc }
        L_0x0094:
            r8.put(r3, r2)     // Catch:{ Exception -> 0x00bc }
        L_0x0097:
            boolean r9 = r9.isAdaptive()     // Catch:{ Exception -> 0x00bc }
            if (r9 == 0) goto L_0x00c6
            java.lang.String r9 = "Adaptive=true"
            boolean r2 = r8.containsKey(r0)     // Catch:{ Exception -> 0x00bc }
            if (r2 == 0) goto L_0x00b8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bc }
            r9.<init>()     // Catch:{ Exception -> 0x00bc }
            java.lang.Object r2 = r8.get(r0)     // Catch:{ Exception -> 0x00bc }
            r9.append(r2)     // Catch:{ Exception -> 0x00bc }
            r9.append(r1)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00bc }
        L_0x00b8:
            r8.put(r0, r9)     // Catch:{ Exception -> 0x00bc }
            goto L_0x00c6
        L_0x00bc:
            r8 = move-exception
            com.ironsource.mediationsdk.logger.IronLog r9 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r8 = android.util.Log.getStackTraceString(r8)
            r9.error(r8)
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.l.a(java.util.Map, com.ironsource.mediationsdk.ISBannerSize):void");
    }

    static boolean b(IronSourceBannerLayout ironSourceBannerLayout) {
        return ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed();
    }
}
