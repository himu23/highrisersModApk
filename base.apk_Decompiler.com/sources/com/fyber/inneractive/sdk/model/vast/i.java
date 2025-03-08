package com.fyber.inneractive.sdk.model.vast;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public enum i {
    Jpeg("image/jpeg"),
    Jpg("image/jpg"),
    Gif("image/gif"),
    Png("image/png");
    
    private static final Map<String, i> sCreativeTypeMap = null;
    private String mMimeType;

    /* access modifiers changed from: public */
    static {
        int i;
        sCreativeTypeMap = new HashMap();
        for (i iVar : values()) {
            sCreativeTypeMap.put(iVar.mMimeType, iVar);
        }
    }

    /* access modifiers changed from: public */
    i(String str) {
        this.mMimeType = str;
    }

    public static i a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return sCreativeTypeMap.get(str.toLowerCase());
        }
        return null;
    }

    public String e() {
        return this.mMimeType;
    }
}
