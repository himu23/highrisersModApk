package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.ga;
import com.ironsource.ha;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.Placement;
import java.util.Calendar;
import java.util.TimeZone;

public class b {
    private static final String a = "CappingManager.IS_DELIVERY_ENABLED";
    private static final String b = "CappingManager.IS_CAPPING_ENABLED";
    private static final String c = "CappingManager.IS_PACING_ENABLED";
    private static final String d = "CappingManager.MAX_NUMBER_OF_SHOWS";
    private static final String e = "CappingManager.CAPPING_TYPE";
    private static final String f = "CappingManager.SECONDS_BETWEEN_SHOWS";
    private static final String g = "CappingManager.CURRENT_NUMBER_OF_SHOWS";
    private static final String h = "CappingManager.CAPPING_TIME_THRESHOLD";
    private static final String i = "CappingManager.TIME_OF_THE_PREVIOUS_SHOW";

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.ironsource.ha[] r0 = com.ironsource.ha.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.ironsource.ha r1 = com.ironsource.ha.PER_DAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.ha r1 = com.ironsource.ha.PER_HOUR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.b.a.<clinit>():void");
        }
    }

    /* renamed from: com.ironsource.mediationsdk.utils.b$b  reason: collision with other inner class name */
    public enum C0017b {
        CAPPED_PER_DELIVERY,
        CAPPED_PER_COUNT,
        CAPPED_PER_PACE,
        NOT_CAPPED
    }

    private static long a(ha haVar) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        int i2 = a.a[haVar.ordinal()];
        if (i2 == 1) {
            instance.set(14, 0);
            instance.set(13, 0);
            instance.set(12, 0);
            instance.set(11, 0);
            instance.add(6, 1);
        } else if (i2 == 2) {
            instance.set(14, 0);
            instance.set(13, 0);
            instance.set(12, 0);
            instance.add(11, 1);
        }
        return instance.getTimeInMillis();
    }

    private static String a(IronSource.AD_UNIT ad_unit) {
        return ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO ? IronSourceConstants.REWARDED_VIDEO_AD_UNIT : ad_unit == IronSource.AD_UNIT.INTERSTITIAL ? "Interstitial" : ad_unit == IronSource.AD_UNIT.BANNER ? "Banner" : ad_unit == IronSource.AD_UNIT.NATIVE_AD ? IronSourceConstants.NATIVE_AD_UNIT : ad_unit.toString();
    }

    private static String a(String str, String str2, String str3) {
        return str + "_" + str2 + "_" + str3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r3, com.ironsource.g9 r4) {
        /*
            java.lang.Class<com.ironsource.mediationsdk.utils.b> r0 = com.ironsource.mediationsdk.utils.b.class
            monitor-enter(r0)
            if (r3 == 0) goto L_0x001e
            if (r4 != 0) goto L_0x0008
            goto L_0x001e
        L_0x0008:
            com.ironsource.ga r1 = r4.getPlacementAvailabilitySettings()     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0010
            monitor-exit(r0)
            return
        L_0x0010:
            java.lang.String r4 = r4.getPlacementName()     // Catch:{ all -> 0x001b }
            java.lang.String r2 = "Native Ad"
            a(r3, r2, r4, r1)     // Catch:{ all -> 0x001b }
            monitor-exit(r0)
            return
        L_0x001b:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        L_0x001e:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.b.a(android.content.Context, com.ironsource.g9):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r3, com.ironsource.m1 r4) {
        /*
            java.lang.Class<com.ironsource.mediationsdk.utils.b> r0 = com.ironsource.mediationsdk.utils.b.class
            monitor-enter(r0)
            if (r3 == 0) goto L_0x001e
            if (r4 != 0) goto L_0x0008
            goto L_0x001e
        L_0x0008:
            com.ironsource.ga r1 = r4.getPlacementAvailabilitySettings()     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0010
            monitor-exit(r0)
            return
        L_0x0010:
            java.lang.String r4 = r4.getPlacementName()     // Catch:{ all -> 0x001b }
            java.lang.String r2 = "Banner"
            a(r3, r2, r4, r1)     // Catch:{ all -> 0x001b }
            monitor-exit(r0)
            return
        L_0x001b:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        L_0x001e:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.b.a(android.content.Context, com.ironsource.m1):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r3, com.ironsource.mediationsdk.model.InterstitialPlacement r4) {
        /*
            java.lang.Class<com.ironsource.mediationsdk.utils.b> r0 = com.ironsource.mediationsdk.utils.b.class
            monitor-enter(r0)
            if (r3 == 0) goto L_0x001e
            if (r4 != 0) goto L_0x0008
            goto L_0x001e
        L_0x0008:
            com.ironsource.ga r1 = r4.getPlacementAvailabilitySettings()     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0010
            monitor-exit(r0)
            return
        L_0x0010:
            java.lang.String r4 = r4.getPlacementName()     // Catch:{ all -> 0x001b }
            java.lang.String r2 = "Interstitial"
            a(r3, r2, r4, r1)     // Catch:{ all -> 0x001b }
            monitor-exit(r0)
            return
        L_0x001b:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        L_0x001e:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.b.a(android.content.Context, com.ironsource.mediationsdk.model.InterstitialPlacement):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r3, com.ironsource.mediationsdk.model.Placement r4) {
        /*
            java.lang.Class<com.ironsource.mediationsdk.utils.b> r0 = com.ironsource.mediationsdk.utils.b.class
            monitor-enter(r0)
            if (r3 == 0) goto L_0x001e
            if (r4 != 0) goto L_0x0008
            goto L_0x001e
        L_0x0008:
            com.ironsource.ga r1 = r4.getPlacementAvailabilitySettings()     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0010
            monitor-exit(r0)
            return
        L_0x0010:
            java.lang.String r4 = r4.getPlacementName()     // Catch:{ all -> 0x001b }
            java.lang.String r2 = "Rewarded Video"
            a(r3, r2, r4, r1)     // Catch:{ all -> 0x001b }
            monitor-exit(r0)
            return
        L_0x001b:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        L_0x001e:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.b.a(android.content.Context, com.ironsource.mediationsdk.model.Placement):void");
    }

    public static synchronized void a(Context context, String str) {
        synchronized (b.class) {
            if (!TextUtils.isEmpty(str)) {
                a(context, "Banner", str);
            }
        }
    }

    public static synchronized void a(Context context, String str, IronSource.AD_UNIT ad_unit) {
        synchronized (b.class) {
            a(context, a(ad_unit), str);
        }
    }

    private static void a(Context context, String str, String str2) {
        ha haVar;
        int i2 = 0;
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, c, str2), false)) {
            IronSourceUtils.saveLongToSharedPrefs(context, a(str, i, str2), System.currentTimeMillis());
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, b, str2), false)) {
            IronSourceUtils.getIntFromSharedPrefs(context, a(str, d, str2), 0);
            String a2 = a(str, g, str2);
            int intFromSharedPrefs = IronSourceUtils.getIntFromSharedPrefs(context, a2, 0);
            if (intFromSharedPrefs == 0) {
                String stringFromSharedPrefs = IronSourceUtils.getStringFromSharedPrefs(context, a(str, e, str2), ha.PER_DAY.toString());
                ha[] values = ha.values();
                int length = values.length;
                while (true) {
                    if (i2 >= length) {
                        haVar = null;
                        break;
                    }
                    haVar = values[i2];
                    if (haVar.a.equals(stringFromSharedPrefs)) {
                        break;
                    }
                    i2++;
                }
                IronSourceUtils.saveLongToSharedPrefs(context, a(str, h, str2), a(haVar));
            }
            IronSourceUtils.saveIntToSharedPrefs(context, a2, intFromSharedPrefs + 1);
        }
    }

    private static void a(Context context, String str, String str2, ga gaVar) {
        boolean e2 = gaVar.e();
        IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, a, str2), e2);
        if (e2) {
            boolean d2 = gaVar.d();
            IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, b, str2), d2);
            if (d2) {
                IronSourceUtils.saveIntToSharedPrefs(context, a(str, d, str2), gaVar.b());
                IronSourceUtils.saveStringToSharedPrefs(context, a(str, e, str2), gaVar.a().toString());
            }
            boolean f2 = gaVar.f();
            IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, c, str2), f2);
            if (f2) {
                IronSourceUtils.saveIntToSharedPrefs(context, a(str, f, str2), gaVar.c());
            }
        }
    }

    private static C0017b b(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, a, str2), true)) {
            return C0017b.CAPPED_PER_DELIVERY;
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, c, str2), false)) {
            if (currentTimeMillis - IronSourceUtils.getLongFromSharedPrefs(context, a(str, i, str2), 0) < ((long) (IronSourceUtils.getIntFromSharedPrefs(context, a(str, f, str2), 0) * 1000))) {
                return C0017b.CAPPED_PER_PACE;
            }
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, b, str2), false)) {
            int intFromSharedPrefs = IronSourceUtils.getIntFromSharedPrefs(context, a(str, d, str2), 0);
            String a2 = a(str, g, str2);
            int intFromSharedPrefs2 = IronSourceUtils.getIntFromSharedPrefs(context, a2, 0);
            String a3 = a(str, h, str2);
            if (currentTimeMillis >= IronSourceUtils.getLongFromSharedPrefs(context, a3, 0)) {
                IronSourceUtils.saveIntToSharedPrefs(context, a2, 0);
                IronSourceUtils.saveLongToSharedPrefs(context, a3, 0);
            } else if (intFromSharedPrefs2 >= intFromSharedPrefs) {
                return C0017b.CAPPED_PER_COUNT;
            }
        }
        return C0017b.NOT_CAPPED;
    }

    public static synchronized void b(Context context, InterstitialPlacement interstitialPlacement) {
        synchronized (b.class) {
            if (interstitialPlacement != null) {
                a(context, "Interstitial", interstitialPlacement.getPlacementName());
            }
        }
    }

    public static synchronized void b(Context context, Placement placement) {
        synchronized (b.class) {
            if (placement != null) {
                a(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, placement.getPlacementName());
            }
        }
    }

    public static synchronized void b(Context context, String str) {
        synchronized (b.class) {
            a(context, "Interstitial", str);
        }
    }

    public static synchronized boolean b(Context context, String str, IronSource.AD_UNIT ad_unit) {
        boolean z;
        synchronized (b.class) {
            z = b(context, a(ad_unit), str) != C0017b.NOT_CAPPED;
        }
        return z;
    }

    public static synchronized C0017b c(Context context, InterstitialPlacement interstitialPlacement) {
        synchronized (b.class) {
            if (!(context == null || interstitialPlacement == null)) {
                if (interstitialPlacement.getPlacementAvailabilitySettings() != null) {
                    C0017b b2 = b(context, "Interstitial", interstitialPlacement.getPlacementName());
                    return b2;
                }
            }
            C0017b bVar = C0017b.NOT_CAPPED;
            return bVar;
        }
    }

    public static synchronized C0017b c(Context context, Placement placement) {
        synchronized (b.class) {
            if (!(context == null || placement == null)) {
                if (placement.getPlacementAvailabilitySettings() != null) {
                    C0017b b2 = b(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, placement.getPlacementName());
                    return b2;
                }
            }
            C0017b bVar = C0017b.NOT_CAPPED;
            return bVar;
        }
    }

    public static synchronized void c(Context context, String str) {
        synchronized (b.class) {
            a(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, str);
        }
    }

    public static synchronized boolean d(Context context, String str) {
        boolean z;
        synchronized (b.class) {
            z = b(context, "Banner", str) != C0017b.NOT_CAPPED;
        }
        return z;
    }

    public static synchronized boolean e(Context context, String str) {
        boolean z;
        synchronized (b.class) {
            z = b(context, "Interstitial", str) != C0017b.NOT_CAPPED;
        }
        return z;
    }

    public static synchronized boolean f(Context context, String str) {
        boolean z;
        synchronized (b.class) {
            z = b(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, str) != C0017b.NOT_CAPPED;
        }
        return z;
    }
}
