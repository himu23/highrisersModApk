package com.fyber.inneractive.sdk.model.vast;

import com.unity3d.services.core.device.MimeTypes;
import java.util.HashMap;
import java.util.Map;

public enum q {
    MEDIA_TYPE_MP4("video/mp4"),
    MEDIA_TYPE_3GPP("video/3gpp"),
    MEDIA_TYPE_WEBM(MimeTypes.VIDEO_WEBM),
    MEDIA_TYPE_X_MPEG("application/x-mpegURL"),
    UNKNOWN("unknown");
    
    private static final Map<String, q> sMediaTypeMap = null;
    public final String mimeType;

    /* access modifiers changed from: public */
    static {
        int i;
        sMediaTypeMap = new HashMap();
        for (q qVar : values()) {
            sMediaTypeMap.put(qVar.mimeType, qVar);
        }
    }

    /* access modifiers changed from: public */
    q(String str) {
        this.mimeType = str;
    }

    public static q a(String str) {
        Map<String, q> map = sMediaTypeMap;
        return map.containsKey(str) ? map.get(str) : UNKNOWN;
    }
}
