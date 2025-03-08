package com.applovin.impl.a.a.b.a;

import android.app.Activity;
import android.content.Context;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class b extends d {
    private List<com.applovin.impl.a.a.a.a> akC;
    private final AtomicBoolean akD = new AtomicBoolean();
    private List<c> akE = new ArrayList();
    private n sdk;

    public enum a {
        RECENT_ADS,
        COUNT
    }

    public n getSdk() {
        return this.sdk;
    }

    /* access modifiers changed from: protected */
    public List<c> gi(int i) {
        return this.akE;
    }

    public List<com.applovin.impl.a.a.a.a> tL() {
        return this.akC;
    }

    public b(Context context) {
        super(context);
    }

    public void tJ() {
        this.akD.compareAndSet(true, false);
    }

    public boolean tK() {
        return this.akE.size() == 0;
    }

    public void initialize(List<com.applovin.impl.a.a.a.a> list, n nVar) {
        Activity CF;
        this.sdk = nVar;
        this.akC = list;
        if (!(this.E instanceof Activity) && (CF = nVar.CF()) != null) {
            this.E = CF;
        }
        if (list != null && this.akD.compareAndSet(false, true)) {
            this.akE = n(this.akC);
        }
        AppLovinSdkUtils.runOnUiThread(new b$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: protected */
    public int tM() {
        return a.COUNT.ordinal();
    }

    /* access modifiers changed from: protected */
    public int gg(int i) {
        return this.akE.size();
    }

    /* access modifiers changed from: protected */
    public c gh(int i) {
        return new e("RECENT ADS");
    }

    private List<c> n(List<com.applovin.impl.a.a.a.a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (com.applovin.impl.a.a.a.a aVar : list) {
            arrayList.add(new com.applovin.impl.a.a.b.a.a.a(aVar, this.E));
        }
        return arrayList;
    }

    public String toString() {
        return "CreativeDebuggerListAdapter{isInitialized=" + this.akD.get() + "}";
    }
}
