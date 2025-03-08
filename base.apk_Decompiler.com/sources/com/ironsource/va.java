package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.u1;

public class va extends u1 {
    private static va R;
    private String P;
    private final w6 Q = w8.e().b();

    private va() {
        this.H = "outcome";
        this.G = 3;
        this.I = IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
        this.P = "";
    }

    public static synchronized va i() {
        va vaVar;
        synchronized (va.class) {
            if (R == null) {
                va vaVar2 = new va();
                R = vaVar2;
                vaVar2.e();
            }
            vaVar = R;
        }
        return vaVar;
    }

    /* access modifiers changed from: protected */
    public int c(y3 y3Var) {
        return this.Q.a(f(y3Var.c()) == u1.e.OFFERWALL.a() ? IronSource.AD_UNIT.OFFERWALL : IronSource.AD_UNIT.REWARDED_VIDEO);
    }

    /* access modifiers changed from: protected */
    public void d() {
        this.J.add(1000);
        this.J.add(1001);
        this.J.add(1002);
        this.J.add(1003);
        this.J.add(1200);
        this.J.add(Integer.valueOf(IronSourceConstants.RV_INSTANCE_SHOW_CHANCE));
        this.J.add(1210);
        this.J.add(1211);
        this.J.add(Integer.valueOf(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON));
        this.J.add(1213);
        this.J.add(Integer.valueOf(IronSourceConstants.RV_MEDIATION_LOAD_ERROR));
    }

    /* access modifiers changed from: protected */
    public boolean d(y3 y3Var) {
        int c = y3Var.c();
        return c == 14 || c == 514 || c == 305 || c == 1003 || c == 1005 || c == 1203 || c == 1010 || c == 1301 || c == 1302;
    }

    /* access modifiers changed from: protected */
    public String e(int i) {
        return (i == 15 || (i >= 300 && i < 400)) ? this.P : "";
    }

    /* access modifiers changed from: protected */
    public void f(y3 y3Var) {
        if (y3Var.c() == 15 || (y3Var.c() >= 300 && y3Var.c() < 400)) {
            this.P = y3Var.b().optString("placement");
        }
    }

    /* access modifiers changed from: protected */
    public boolean j(y3 y3Var) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean k(y3 y3Var) {
        return y3Var.c() == 305;
    }
}
