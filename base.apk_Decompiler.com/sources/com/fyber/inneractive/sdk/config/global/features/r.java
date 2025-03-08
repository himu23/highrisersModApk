package com.fyber.inneractive.sdk.config.global.features;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;

public class r extends g {
    public static final b e = b.NONE;
    public static final c f = c.NONE;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType[] r0 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.REWARDED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.config.global.features.r.a.<clinit>():void");
        }
    }

    public enum b {
        NONE("none"),
        OPEN("open");
        
        public String mKey;

        /* access modifiers changed from: public */
        b(String str) {
            this.mKey = str;
        }
    }

    public enum c {
        NONE("none"),
        ZOOM_IN("endcard_zoom_in");
        
        public String mKey;

        /* access modifiers changed from: public */
        c(String str) {
            this.mKey = str;
        }
    }

    public enum d {
        LEGACY("legacy"),
        EXTRACTOR("extractor"),
        NONE("none");
        
        public String key;

        /* access modifiers changed from: public */
        d(String str) {
            this.key = str;
        }
    }

    public r() {
        super("video_player");
    }

    public int a(UnitDisplayType unitDisplayType) {
        if (unitDisplayType == UnitDisplayType.INTERSTITIAL) {
            Integer b2 = b("prebuffer_interstitial");
            if (b2 != null) {
                return b2.intValue();
            }
            return 3;
        }
        Integer b3 = b("prebuffer_rewarded");
        if (b3 != null) {
            return b3.intValue();
        }
        return 3;
    }

    public g b() {
        r rVar = new r();
        a((g) rVar);
        return rVar;
    }

    public boolean d() {
        return a("cta_text_all_caps", false);
    }

    public int e() {
        Integer b2 = b("dl_retries");
        if (b2 != null) {
            return b2.intValue();
        }
        return 10;
    }

    public int f() {
        Integer b2 = b("dl_retry_delay");
        if (b2 != null) {
            return b2.intValue();
        }
        return 500;
    }

    public int g() {
        Integer b2 = b("max_tries");
        if (b2 != null) {
            return b2.intValue();
        }
        return 0;
    }

    public int h() {
        Integer b2 = b("second_checkpoint");
        if (b2 != null) {
            return b2.intValue();
        }
        return 25;
    }
}
