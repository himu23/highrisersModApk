package com.ironsource;

import android.content.Context;
import com.ironsource.e6;
import com.ironsource.m2;
import com.ironsource.sdk.controller.FeaturesManager;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class fd {
    private final String a;
    private Context b;
    private nc c;
    private o2 d;
    private i3 e;
    private int f;
    private q3 g;
    private int h;
    private int i;
    private final String j = "fd";
    private a k;

    protected enum a {
        NOT_RECOVERED,
        RECOVERED,
        IN_RECOVERING,
        NOT_ALLOWED
    }

    public fd(Context context, o2 o2Var, nc ncVar, i3 i3Var, int i2, q3 q3Var, String str) {
        a h2 = h();
        this.k = h2;
        if (h2 != a.NOT_ALLOWED) {
            this.b = context;
            this.d = o2Var;
            this.c = ncVar;
            this.e = i3Var;
            this.f = i2;
            this.g = q3Var;
            this.h = 0;
        }
        this.a = str;
    }

    private a h() {
        this.i = FeaturesManager.getInstance().getInitRecoverTrials();
        String str = this.j;
        Logger.i(str, "getInitialState mMaxAllowedTrials: " + this.i);
        if (this.i > 0) {
            return a.NOT_RECOVERED;
        }
        Logger.i(this.j, "recovery is not allowed by config");
        return a.NOT_ALLOWED;
    }

    private void k() {
        if (this.h == this.i) {
            Logger.i(this.j, "handleRecoveringEndedFailed | Reached max trials");
            this.k = a.NOT_ALLOWED;
            a();
            return;
        }
        this.k = a.NOT_RECOVERED;
    }

    private void l() {
        a();
        this.k = a.RECOVERED;
    }

    public void a() {
        this.b = null;
        this.d = null;
        this.c = null;
        this.e = null;
        this.g = null;
    }

    public void a(boolean z) {
        if (this.k == a.IN_RECOVERING) {
            if (z) {
                l();
            } else {
                k();
            }
        }
    }

    public boolean a(e6.c cVar, e6.b bVar) {
        Logger.i(this.j, "shouldRecoverWebController: ");
        a aVar = this.k;
        if (aVar == a.NOT_ALLOWED) {
            Logger.i(this.j, "shouldRecoverWebController: false | recover is not allowed");
            return false;
        } else if (cVar != e6.c.Native) {
            String str = this.j;
            Logger.i(str, "shouldRecoverWebController: false | current controller type is: " + cVar);
            return false;
        } else if (bVar == e6.b.Loading || bVar == e6.b.None) {
            Logger.i(this.j, "shouldRecoverWebController: false | a Controller is currently loading");
            return false;
        } else if (aVar == a.RECOVERED) {
            Logger.i(this.j, "shouldRecoverWebController: false | already recovered");
            return false;
        } else if (aVar == a.IN_RECOVERING) {
            Logger.i(this.j, "shouldRecoverWebController: false | currently in recovering");
            return false;
        } else if (this.b == null || this.d == null || this.c == null || this.e == null) {
            Logger.i(this.j, "shouldRecoverWebController: false | missing mandatory param");
            return false;
        } else {
            Logger.i(this.j, "shouldRecoverWebController: true | allow recovering ");
            return true;
        }
    }

    public Context b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public o2 d() {
        return this.d;
    }

    public int e() {
        return this.f;
    }

    public i3 f() {
        return this.e;
    }

    public q3 g() {
        return this.g;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(m2.h.A0, n());
            jSONObject.put(m2.h.B0, this.h);
            jSONObject.put(m2.h.C0, this.i);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public nc j() {
        return this.c;
    }

    public boolean m() {
        return this.k == a.IN_RECOVERING;
    }

    public boolean n() {
        return this.k == a.RECOVERED;
    }

    public void o() {
        a aVar = this.k;
        a aVar2 = a.IN_RECOVERING;
        if (aVar != aVar2) {
            this.h++;
            Logger.i(this.j, "recoveringStarted - trial number " + this.h);
            this.k = aVar2;
        }
    }
}
