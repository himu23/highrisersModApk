package com.applovin.impl.sdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

public class d {
    private static boolean aVj = true;
    private static final Object aVk = new Object();
    private static final Collection<CountDownLatch> aVl = new HashSet();
    private static boolean aVm = false;
    private static a aVn = null;

    public static a U(Context context) {
        return V(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r2 == false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        r5 = W(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        aVm = true;
        aVn = r5;
        r5 = new java.util.HashSet(r1);
        r1.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        r5 = r5.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        if (r5.hasNext() == false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        ((java.util.concurrent.CountDownLatch) r5.next()).countDown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0051, code lost:
        if (r3.await(60, java.util.concurrent.TimeUnit.SECONDS) != false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0053, code lost:
        com.applovin.impl.sdk.x.H("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }: collection timeout");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005b, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005c, code lost:
        com.applovin.impl.sdk.x.e("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.applovin.impl.sdk.utils.d.a V(android.content.Context r5) {
        /*
            com.applovin.impl.sdk.utils.u.LE()
            java.lang.Object r0 = aVk
            monitor-enter(r0)
            boolean r1 = aVm     // Catch:{ all -> 0x006d }
            if (r1 == 0) goto L_0x000e
            com.applovin.impl.sdk.utils.d$a r5 = aVn     // Catch:{ all -> 0x006d }
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            return r5
        L_0x000e:
            java.util.Collection<java.util.concurrent.CountDownLatch> r1 = aVl     // Catch:{ all -> 0x006d }
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x006d }
            java.util.concurrent.CountDownLatch r3 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x006d }
            r4 = 1
            r3.<init>(r4)     // Catch:{ all -> 0x006d }
            r1.add(r3)     // Catch:{ all -> 0x006d }
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            if (r2 == 0) goto L_0x0049
            com.applovin.impl.sdk.utils.d$a r5 = W(r5)
            monitor-enter(r0)
            aVm = r4     // Catch:{ all -> 0x0046 }
            aVn = r5     // Catch:{ all -> 0x0046 }
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ all -> 0x0046 }
            r5.<init>(r1)     // Catch:{ all -> 0x0046 }
            r1.clear()     // Catch:{ all -> 0x0046 }
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            java.util.Iterator r5 = r5.iterator()
        L_0x0036:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0049
            java.lang.Object r0 = r5.next()
            java.util.concurrent.CountDownLatch r0 = (java.util.concurrent.CountDownLatch) r0
            r0.countDown()
            goto L_0x0036
        L_0x0046:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            throw r5
        L_0x0049:
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x005b }
            r0 = 60
            boolean r5 = r3.await(r0, r5)     // Catch:{ InterruptedException -> 0x005b }
            if (r5 != 0) goto L_0x0063
            java.lang.String r5 = "DataCollector"
            java.lang.String r0 = "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }: collection timeout"
            com.applovin.impl.sdk.x.H(r5, r0)     // Catch:{ InterruptedException -> 0x005b }
            goto L_0x0063
        L_0x005b:
            r5 = move-exception
            java.lang.String r0 = "DataCollector"
            java.lang.String r1 = "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }"
            com.applovin.impl.sdk.x.e(r0, r1, r5)
        L_0x0063:
            java.lang.Object r5 = aVk
            monitor-enter(r5)
            com.applovin.impl.sdk.utils.d$a r0 = aVn     // Catch:{ all -> 0x006a }
            monitor-exit(r5)     // Catch:{ all -> 0x006a }
            return r0
        L_0x006a:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x006a }
            throw r0
        L_0x006d:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.d.V(android.content.Context):com.applovin.impl.sdk.utils.d$a");
    }

    private static a W(Context context) {
        a collectGoogleAdvertisingInfo = collectGoogleAdvertisingInfo(context);
        if (collectGoogleAdvertisingInfo == null) {
            collectGoogleAdvertisingInfo = collectFireOSAdvertisingInfo(context);
        }
        return collectGoogleAdvertisingInfo == null ? new a() : collectGoogleAdvertisingInfo;
    }

    private static a collectGoogleAdvertisingInfo(Context context) {
        u.LE();
        if (KP()) {
            try {
                a aVar = new a();
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                boolean isLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
                aVar.bi(isLimitAdTrackingEnabled);
                aVar.a(isLimitAdTrackingEnabled ? a.C0084a.ON : a.C0084a.OFF);
                aVar.dx(advertisingIdInfo.getId());
                return aVar;
            } catch (Throwable th) {
                if (AppLovinSdkUtils.isFireOS(context)) {
                    return null;
                }
                x.e("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", th);
                return null;
            }
        } else if (AppLovinSdkUtils.isFireOS(context)) {
            return null;
        } else {
            x.H("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }");
            return null;
        }
    }

    public static boolean KP() {
        return u.dE("com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }

    private static a collectFireOSAdvertisingInfo(Context context) {
        a.C0084a aVar;
        if (aVj) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                a aVar2 = new a();
                aVar2.dx(StringUtils.emptyIfNull(Settings.Secure.getString(contentResolver, "advertising_id")));
                boolean z = Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 0;
                aVar2.bi(z);
                if (z) {
                    aVar = a.C0084a.ON;
                } else {
                    aVar = a.C0084a.OFF;
                }
                aVar2.a(aVar);
                return aVar2;
            } catch (Settings.SettingNotFoundException e) {
                x.e("DataCollector", "Unable to determine if Fire OS limited ad tracking is turned on", e);
            } catch (Throwable th) {
                x.e("DataCollector", "Unable to collect Fire OS IDFA", th);
            }
        }
        aVj = false;
        return null;
    }

    public static class a {
        private boolean aVo;
        private String aVp = "";
        private C0084a aVq = C0084a.NOT_SET;

        public boolean KQ() {
            return this.aVo;
        }

        public String KR() {
            return this.aVp;
        }

        public C0084a KS() {
            return this.aVq;
        }

        public void a(C0084a aVar) {
            this.aVq = aVar;
        }

        public void bi(boolean z) {
            this.aVo = z;
        }

        public void dx(String str) {
            this.aVp = str;
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
            if (!aVar.canEqual(this) || KQ() != aVar.KQ()) {
                return false;
            }
            String KR = KR();
            String KR2 = aVar.KR();
            if (KR != null ? !KR.equals(KR2) : KR2 != null) {
                return false;
            }
            C0084a KS = KS();
            C0084a KS2 = aVar.KS();
            return KS != null ? KS.equals(KS2) : KS2 == null;
        }

        public int hashCode() {
            int i = KQ() ? 79 : 97;
            String KR = KR();
            int i2 = 43;
            int hashCode = ((i + 59) * 59) + (KR == null ? 43 : KR.hashCode());
            C0084a KS = KS();
            int i3 = hashCode * 59;
            if (KS != null) {
                i2 = KS.hashCode();
            }
            return i3 + i2;
        }

        public String toString() {
            return "AdvertisingInfoCollector.AdvertisingIdInformation(adTrackingLimited=" + KQ() + ", advertisingId=" + KR() + ", dntCode=" + KS() + ")";
        }

        /* renamed from: com.applovin.impl.sdk.utils.d$a$a  reason: collision with other inner class name */
        public enum C0084a {
            NOT_SET("dnt_not_set"),
            ON("dnt_on"),
            OFF("dnt_off");
            
            private final String aVu;

            public String KT() {
                return this.aVu;
            }

            private C0084a(String str) {
                this.aVu = str;
            }
        }
    }
}
