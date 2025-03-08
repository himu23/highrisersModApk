package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;

public class r8 extends x3 {
    public r8(v vVar) {
        super(vVar);
    }

    public void a() {
        a(t.RELOAD_AD, new HashMap());
    }

    public void a(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("sessionDepth", Integer.valueOf(i));
        a(t.DESTROY_AD, hashMap);
    }

    public void a(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j));
        a(t.RELOAD_AD_SUCCESS, hashMap);
    }

    public void a(long j, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j));
        hashMap.put("errorCode", Integer.valueOf(i));
        a(t.LOAD_AD_FAILED, hashMap);
    }

    public void a(long j, int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j));
        hashMap.put("errorCode", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("reason", str);
        }
        a(t.LOAD_AD_FAILED_WITH_REASON, hashMap);
    }

    public void a(long j, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j));
        if (z) {
            hashMap.put(IronSourceConstants.EVENTS_PUBLISHER_LOAD, Boolean.TRUE);
        }
        a(t.LOAD_AD_SUCCESS, hashMap);
    }

    public void a(boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put(IronSourceConstants.EVENTS_PUBLISHER_LOAD, Boolean.TRUE);
        }
        a(t.LOAD_AD, hashMap);
    }

    public void a(boolean z, long j, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j));
        if (z2) {
            hashMap.put("errorCode", Integer.valueOf(IronSourceError.ERROR_RV_EXPIRED_ADS));
            hashMap.put("reason", "loaded ads are expired");
        }
        a(z ? t.AD_AVAILABILITY_CHANGED_TRUE : t.AD_AVAILABILITY_CHANGED_FALSE, hashMap);
    }

    public void b(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorCode", Integer.valueOf(i));
        a(t.SKIP_RELOAD_AD, hashMap);
    }

    public void b(long j, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j));
        hashMap.put("errorCode", Integer.valueOf(i));
        a(t.LOAD_AD_NO_FILL, hashMap);
    }

    public void b(long j, int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j));
        hashMap.put("errorCode", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("reason", str);
        }
        a(t.RELOAD_AD_FAILED_WITH_REASON, hashMap);
    }

    public void c(long j, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j));
        hashMap.put("errorCode", Integer.valueOf(i));
        a(t.RELOAD_AD_NO_FILL, hashMap);
    }
}
