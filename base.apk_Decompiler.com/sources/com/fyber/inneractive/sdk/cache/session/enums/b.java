package com.fyber.inneractive.sdk.cache.session.enums;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.unity3d.services.core.device.MimeTypes;

public enum b {
    REWARDED_VIDEO(r1, true),
    INTERSTITIAL_VIDEO(r5, true),
    RECTANGLE_DISPLAY(UnitDisplayType.MRECT, false),
    REWARDED_DISPLAY(r1, true),
    BANNER_DISPLAY(UnitDisplayType.BANNER, false),
    INTERSTITIAL_DISPLAY(r5, false),
    NONE(UnitDisplayType.DEFAULT, false);
    
    private boolean mShouldCountCompletion;
    private UnitDisplayType mType;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
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
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.MRECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.BANNER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.cache.session.enums.b.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: public */
    b(UnitDisplayType unitDisplayType, boolean z) {
        this.mType = unitDisplayType;
        this.mShouldCountCompletion = z;
    }

    public static b a(String str, String str2) {
        int i = a.a[UnitDisplayType.fromValue(str).ordinal()];
        if (i == 1) {
            return str2.contains(MimeTypes.BASE_TYPE_VIDEO) ? REWARDED_VIDEO : REWARDED_DISPLAY;
        }
        if (i == 2) {
            return RECTANGLE_DISPLAY;
        }
        if (i == 3) {
            return BANNER_DISPLAY;
        }
        if (i != 4) {
            return null;
        }
        return str2.contains(MimeTypes.BASE_TYPE_VIDEO) ? INTERSTITIAL_VIDEO : INTERSTITIAL_DISPLAY;
    }

    public UnitDisplayType e() {
        return this.mType;
    }

    public boolean f() {
        return this.mShouldCountCompletion;
    }
}
