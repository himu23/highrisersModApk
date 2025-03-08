package com.fyber.inneractive.sdk.model.vast;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

public enum t {
    EVENT_FINAL_RETURN("finalReturn"),
    EVENT_IMPRESSION("impression"),
    EVENT_START("start"),
    EVENT_FIRSTQ("firstQuartile"),
    EVENT_MID("midpoint"),
    EVENT_THIRDQ("thirdQuartile"),
    EVENT_COMPLETE("complete"),
    EVENT_MUTE("mute"),
    EVENT_UNMUTE("unmute"),
    EVENT_PAUSE("pause"),
    EVENT_RESUME("resume"),
    EVENT_FULLSCREEN("fullscreen"),
    EVENT_EXIT_FULLSCREEN("exitFullscreen"),
    EVENT_CREATIVE_VIEW("creativeView"),
    EVENT_CLICK("click"),
    EVENT_ERROR("error"),
    EVENT_REWIND("rewind"),
    EVENT_CLOSE("close"),
    EVENT_VERIFICATION_NOT_EXECUTED("verificationNotExecuted"),
    EVENT_EXPAND("expand"),
    EVENT_COLLAPSE("collapse"),
    EVENT_CLOSE_LINEAR("closeLinear"),
    EVENT_PROGRESS(NotificationCompat.CATEGORY_PROGRESS),
    UNKNOWN("UnkownEvent");
    
    private static final Map<String, t> sEventsMap = null;
    private final String mKey;

    /* access modifiers changed from: public */
    static {
        sEventsMap = new HashMap();
        for (t tVar : values()) {
            sEventsMap.put(tVar.mKey, tVar);
        }
    }

    /* access modifiers changed from: public */
    t(String str) {
        this.mKey = str;
    }

    public static t a(String str) {
        Map<String, t> map = sEventsMap;
        return map.containsKey(str) ? map.get(str) : UNKNOWN;
    }

    public String e() {
        return this.mKey;
    }
}
