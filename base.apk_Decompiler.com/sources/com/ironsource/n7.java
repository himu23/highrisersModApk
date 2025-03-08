package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.u1;

public class n7 extends u1 {
    private static n7 R;
    private String P;
    private final w6 Q = w8.e().b();

    private n7() {
        this.H = "ironbeast";
        this.G = 2;
        this.I = IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
        this.P = "";
    }

    public static synchronized n7 i() {
        n7 n7Var;
        synchronized (n7.class) {
            if (R == null) {
                n7 n7Var2 = new n7();
                R = n7Var2;
                n7Var2.e();
            }
            n7Var = R;
        }
        return n7Var;
    }

    /* access modifiers changed from: protected */
    public int c(y3 y3Var) {
        w6 w6Var;
        IronSource.AD_UNIT ad_unit;
        int f = f(y3Var.c());
        if (f == u1.e.BANNER.a()) {
            w6Var = this.Q;
            ad_unit = IronSource.AD_UNIT.BANNER;
        } else if (f == u1.e.NATIVE_AD.a()) {
            w6Var = this.Q;
            ad_unit = IronSource.AD_UNIT.NATIVE_AD;
        } else {
            w6Var = this.Q;
            ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
        }
        return w6Var.a(ad_unit);
    }

    /* access modifiers changed from: protected */
    public void d() {
        this.J.add(2001);
        this.J.add(2002);
        this.J.add(2003);
        this.J.add(Integer.valueOf(IronSourceConstants.IS_CALLBACK_LOAD_SUCCESS));
        this.J.add(2200);
        this.J.add(2213);
        this.J.add(2211);
        this.J.add(2212);
        this.J.add(3001);
        this.J.add(Integer.valueOf(IronSourceConstants.BN_CALLBACK_LOAD_ERROR));
        this.J.add(Integer.valueOf(IronSourceConstants.BN_RELOAD));
        this.J.add(Integer.valueOf(IronSourceConstants.BN_CALLBACK_RELOAD_ERROR));
        this.J.add(Integer.valueOf(IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS));
        this.J.add(3002);
        this.J.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_RELOAD));
        this.J.add(3005);
        this.J.add(3300);
        this.J.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS));
        this.J.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_RELOAD_ERROR));
        this.J.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS));
        this.J.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS));
        this.J.add(3009);
        this.J.add(4001);
        this.J.add(Integer.valueOf(IronSourceConstants.NT_CALLBACK_LOAD_ERROR));
        this.J.add(4002);
        this.J.add(4005);
        this.J.add(Integer.valueOf(IronSourceConstants.NT_INSTANCE_LOAD_ERROR));
        this.J.add(Integer.valueOf(IronSourceConstants.NT_INSTANCE_SHOW));
    }

    /* access modifiers changed from: protected */
    public boolean d(y3 y3Var) {
        int c = y3Var.c();
        return c == 2004 || c == 2005 || c == 2204 || c == 2301 || c == 2300 || c == 3009 || c == 3502 || c == 3501 || c == 4005 || c == 4009 || c == 4502 || c == 4501;
    }

    /* access modifiers changed from: protected */
    public String e(int i) {
        return this.P;
    }

    /* access modifiers changed from: protected */
    public void f(y3 y3Var) {
        this.P = y3Var.b().optString("placement");
    }

    /* access modifiers changed from: protected */
    public boolean j(y3 y3Var) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean k(y3 y3Var) {
        return false;
    }
}
