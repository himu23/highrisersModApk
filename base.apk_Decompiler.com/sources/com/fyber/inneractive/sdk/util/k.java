package com.fyber.inneractive.sdk.util;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.i;

public class k {
    public static boolean a(UnitDisplayType unitDisplayType, i iVar) {
        return (unitDisplayType != null && !unitDisplayType.isFullscreenUnit()) || iVar.a("use_fraud_detection_fullscreen", true);
    }
}
