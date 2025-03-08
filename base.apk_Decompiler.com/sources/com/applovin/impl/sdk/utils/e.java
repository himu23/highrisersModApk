package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import com.applovin.impl.sdk.x;
import com.ironsource.m2;

public class e {
    private static e aVw;
    private static final Object aVx = new Object();
    private final boolean aVA;
    private final Bundle aVy;
    private final int aVz;

    public static e X(Context context) {
        e eVar;
        synchronized (aVx) {
            if (aVw == null) {
                aVw = new e(context);
            }
            eVar = aVw;
        }
        return eVar;
    }

    private e(Context context) {
        boolean z;
        Bundle bundle = null;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            x.e("AndroidManifest", "Failed to get meta data.", e);
        } catch (Throwable th) {
            this.aVy = null;
            throw th;
        }
        this.aVy = bundle;
        int i = 0;
        try {
            XmlResourceParser openXmlResourceParser = context.getAssets().openXmlResourceParser("AndroidManifest.xml");
            int eventType = openXmlResourceParser.getEventType();
            int i2 = 0;
            z = false;
            do {
                if (2 == eventType) {
                    try {
                        if (openXmlResourceParser.getName().equals(m2.h.F)) {
                            for (int i3 = 0; i3 < openXmlResourceParser.getAttributeCount(); i3++) {
                                String attributeName = openXmlResourceParser.getAttributeName(i3);
                                String attributeValue = openXmlResourceParser.getAttributeValue(i3);
                                if (attributeName.equals("networkSecurityConfig")) {
                                    i2 = Integer.valueOf(attributeValue.substring(1)).intValue();
                                } else if (attributeName.equals("usesCleartextTraffic")) {
                                    z = Boolean.valueOf(attributeValue).booleanValue();
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i = i2;
                        try {
                            x.e("AndroidManifest", "Failed to parse AndroidManifest.xml.", th);
                            this.aVz = i;
                            this.aVA = z;
                        } catch (Throwable th3) {
                            this.aVz = i;
                            this.aVA = z;
                            throw th3;
                        }
                    }
                }
                eventType = openXmlResourceParser.next();
            } while (eventType != 1);
            this.aVz = i2;
        } catch (Throwable th4) {
            th = th4;
            z = false;
            x.e("AndroidManifest", "Failed to parse AndroidManifest.xml.", th);
            this.aVz = i;
            this.aVA = z;
        }
        this.aVA = z;
    }

    public boolean dy(String str) {
        Bundle bundle = this.aVy;
        if (bundle != null) {
            return bundle.containsKey(str);
        }
        return false;
    }

    public String L(String str, String str2) {
        Bundle bundle = this.aVy;
        return bundle != null ? bundle.getString(str, str2) : str2;
    }

    public boolean e(String str, boolean z) {
        Bundle bundle = this.aVy;
        return bundle != null ? bundle.getBoolean(str, z) : z;
    }
}
