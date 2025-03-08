package com.applovin.impl.sdk.e;

import android.content.Context;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.r;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import java.util.Map;

public abstract class d implements Runnable {
    private final Context E;
    private String aTD;
    private boolean aTE;
    /* access modifiers changed from: protected */
    public final x logger;
    /* access modifiers changed from: protected */
    public final n sdk;
    /* access modifiers changed from: protected */
    public final String tag;

    public String Kg() {
        return this.tag;
    }

    public boolean Kh() {
        return this.aTE;
    }

    public void bf(boolean z) {
        this.aTE = z;
    }

    public void dq(String str) {
        this.aTD = str;
    }

    public n getSdk() {
        return this.sdk;
    }

    public Context rQ() {
        return this.E;
    }

    public d(String str, n nVar) {
        this(str, nVar, false, (String) null);
    }

    public d(String str, n nVar, boolean z) {
        this(str, nVar, z, (String) null);
    }

    public d(String str, n nVar, String str2) {
        this(str, nVar, false, str2);
    }

    public d(String str, n nVar, boolean z, String str2) {
        this.tag = str;
        this.sdk = nVar;
        this.logger = nVar.BN();
        this.E = n.getApplicationContext();
        this.aTE = z;
        this.aTD = str2;
    }

    public void q(Throwable th) {
        Map map = CollectionUtils.map("source", this.tag);
        map.put("top_main_method", th.toString());
        map.put("details", StringUtils.emptyIfNull(this.aTD));
        this.sdk.Cs().a(r.a.TASK_EXCEPTION, (Map<String, String>) map);
    }
}
