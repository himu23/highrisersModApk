package com.fyber.inneractive.sdk.util;

import com.fyber.inneractive.sdk.config.a;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.c0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.t;
import com.fyber.inneractive.sdk.config.z;
import com.fyber.inneractive.sdk.response.e;
import java.util.Locale;

public class x0 {
    public static String a(String str) {
        UnitDisplayType unitDisplayType;
        UnitDisplayType unitDisplayType2;
        z a = a.a(str);
        UnitDisplayType unitDisplayType3 = UnitDisplayType.BANNER;
        if (a == null) {
            return unitDisplayType3.name().toLowerCase(Locale.US);
        }
        for (int i = 0; i < a.a.size(); i++) {
            a0 c = a.c(i);
            if (!(c == null || (c.c == null && c.f == null))) {
                t tVar = c.c;
                if (tVar == null || (unitDisplayType2 = tVar.b) == null || unitDisplayType2.isDeprecated() || UnitDisplayType.DEFAULT == unitDisplayType2) {
                    c0 c0Var = c.f;
                    if (!(c0Var == null || (unitDisplayType = c0Var.j) == null || unitDisplayType.isDeprecated() || UnitDisplayType.DEFAULT == unitDisplayType)) {
                        unitDisplayType3 = c.f.j;
                    }
                } else {
                    unitDisplayType3 = c.c.b;
                }
                if (UnitDisplayType.MRECT == unitDisplayType3) {
                    unitDisplayType3 = UnitDisplayType.BANNER;
                }
                if (UnitDisplayType.REWARDED == unitDisplayType3 || UnitDisplayType.INTERSTITIAL == unitDisplayType3 || UnitDisplayType.BANNER == unitDisplayType3) {
                    return unitDisplayType3.name().toLowerCase(Locale.US);
                }
            }
        }
        return UnitDisplayType.BANNER.name().toLowerCase(Locale.US);
    }

    public static String a(e eVar) {
        UnitDisplayType unitDisplayType = eVar.n;
        if (unitDisplayType == UnitDisplayType.INTERSTITIAL || unitDisplayType == UnitDisplayType.REWARDED) {
            return unitDisplayType.name().toLowerCase(Locale.US);
        }
        return UnitDisplayType.BANNER.name().toLowerCase(Locale.US);
    }
}
