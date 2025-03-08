package com.fyber.inneractive.sdk.bidder;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;

public class f {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

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
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.BANNER     // Catch:{ NoSuchFieldError -> 0x0012 }
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
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.REWARDED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.MRECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.bidder.f.a.<clinit>():void");
        }
    }

    public static TokenParametersOuterClass$TokenParameters.NullableBool a(Boolean bool) {
        TokenParametersOuterClass$TokenParameters.NullableBool.a newBuilder = TokenParametersOuterClass$TokenParameters.NullableBool.newBuilder();
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            newBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableBool) newBuilder.b).setData(booleanValue);
        }
        return (TokenParametersOuterClass$TokenParameters.NullableBool) newBuilder.a();
    }

    public static TokenParametersOuterClass$TokenParameters.NullableUInt32 b(String str) {
        TokenParametersOuterClass$TokenParameters.NullableUInt32.a newBuilder = TokenParametersOuterClass$TokenParameters.NullableUInt32.newBuilder();
        if (!TextUtils.isEmpty(str)) {
            int parseInt = Integer.parseInt(str);
            newBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableUInt32) newBuilder.b).setData(parseInt);
        }
        return (TokenParametersOuterClass$TokenParameters.NullableUInt32) newBuilder.a();
    }

    public static TokenParametersOuterClass$TokenParameters.NullableString c(String str) {
        TokenParametersOuterClass$TokenParameters.NullableString.a newBuilder = TokenParametersOuterClass$TokenParameters.NullableString.newBuilder();
        if (!TextUtils.isEmpty(str)) {
            newBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableString) newBuilder.b).setData(str);
        }
        return (TokenParametersOuterClass$TokenParameters.NullableString) newBuilder.a();
    }

    public static TokenParametersOuterClass$TokenParameters.NullableUInt32 a(int i) {
        TokenParametersOuterClass$TokenParameters.NullableUInt32.a newBuilder = TokenParametersOuterClass$TokenParameters.NullableUInt32.newBuilder();
        if (i > 0) {
            newBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableUInt32) newBuilder.b).setData(i);
        }
        return (TokenParametersOuterClass$TokenParameters.NullableUInt32) newBuilder.a();
    }

    public static TokenParametersOuterClass$TokenParameters.k a(UnitDisplayType unitDisplayType) {
        int i = a.a[unitDisplayType.ordinal()];
        if (i == 1) {
            return TokenParametersOuterClass$TokenParameters.k.BANNER;
        }
        if (i == 2) {
            return TokenParametersOuterClass$TokenParameters.k.INTERSTITIAL;
        }
        if (i == 3) {
            return TokenParametersOuterClass$TokenParameters.k.REWARDED;
        }
        if (i != 4) {
            return TokenParametersOuterClass$TokenParameters.k.UNITDISPLAYTYPEUNKNOWN;
        }
        return TokenParametersOuterClass$TokenParameters.k.MRECT;
    }

    public static TokenParametersOuterClass$TokenParameters.d a(String str) {
        if (str.equals("native")) {
            return TokenParametersOuterClass$TokenParameters.d.NATIVE;
        }
        if (!str.equals("unity3d")) {
            return TokenParametersOuterClass$TokenParameters.d.UNRECOGNIZED;
        }
        return TokenParametersOuterClass$TokenParameters.d.UNITY3D;
    }
}
