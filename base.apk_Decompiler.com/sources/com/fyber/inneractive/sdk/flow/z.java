package com.fyber.inneractive.sdk.flow;

import android.app.Activity;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.view.View;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.interfaces.c;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b1;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class z<AdContent extends q, EventsListener extends InneractiveUnitController.EventsListener> extends r<AdContent, EventsListener> implements c {
    public c.a l;
    public Runnable m;
    public b1 n;
    public Runnable o;
    public b1 p;
    public boolean q = false;
    public boolean r = false;
    public long s;
    public boolean t = false;
    public boolean u = false;
    public final com.fyber.inneractive.sdk.util.a v = new com.fyber.inneractive.sdk.util.a();
    public CountDownTimer w;

    public class a extends CountDownTimer {
        public a(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            CountDownTimer countDownTimer = z.this.w;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            z.this.e(false);
        }

        public void onTick(long j) {
            int i = ((int) j) / 1000;
            c.a aVar = z.this.l;
            if (aVar != null) {
                aVar.updateCloseCountdown(i);
            }
        }
    }

    public class b implements b1.b {
        public b() {
        }

        public void a(b1 b1Var) {
            com.fyber.inneractive.sdk.util.q.b.post(z.this.m);
            z zVar = z.this;
            b1 b1Var2 = zVar.n;
            if (b1Var2 != null) {
                b1Var2.e = null;
                zVar.n = null;
            }
            boolean unused = zVar.r = false;
        }
    }

    public int A() {
        c.a aVar = this.l;
        if (aVar == null || aVar.getLayout() == null) {
            return 1;
        }
        return this.l.getLayout().getWidth();
    }

    public void D() {
        super.D();
    }

    public abstract boolean J();

    public abstract int L();

    public abstract int M();

    public abstract long N();

    public abstract boolean O();

    public abstract long a(long j);

    public void b(boolean z) {
    }

    public abstract boolean b(AdContent adcontent);

    public void d(boolean z) {
        s.a aVar;
        if (this.b == null) {
            aVar = new s.a(r.MRAID_CUSTOM_CLOSE_DETECTED, (InneractiveAdRequest) null, (e) null, (JSONArray) null);
        } else {
            r rVar = r.MRAID_CUSTOM_CLOSE_DETECTED;
            AdContent adcontent = this.b;
            aVar = new s.a(rVar, adcontent.a, adcontent.d(), this.b.c.c());
        }
        JSONObject jSONObject = new JSONObject();
        Boolean valueOf = Boolean.valueOf(z);
        try {
            jSONObject.put("fyber_close_enabled", valueOf);
        } catch (Exception unused) {
            IAlog.e("Got exception adding param to json object: %s, %s", "fyber_close_enabled", valueOf);
        }
        aVar.f.put(jSONObject);
        aVar.a((String) null);
    }

    public void destroy() {
        P();
        c.a aVar = this.l;
        if (aVar != null) {
            aVar.destroy();
        }
        this.l = null;
        CountDownTimer countDownTimer = this.w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.w = null;
        }
        b1 b1Var = this.p;
        if (b1Var != null) {
            b1Var.e = null;
            this.p = null;
        }
        b1 b1Var2 = this.n;
        if (b1Var2 != null) {
            b1Var2.e = null;
            this.n = null;
        }
        super.destroy();
    }

    public void initialize(InneractiveAdSpot inneractiveAdSpot) {
        this.a = inneractiveAdSpot;
        this.b = inneractiveAdSpot.getAdContent();
        this.c = inneractiveAdSpot.getSelectedUnitController().getEventsListener();
        this.v.a = inneractiveAdSpot;
    }

    public View y() {
        c.a aVar = this.l;
        if (aVar != null) {
            return aVar.getLayout();
        }
        return null;
    }

    public int z() {
        c.a aVar = this.l;
        if (aVar == null || aVar.getLayout() == null) {
            return 1;
        }
        return this.l.getLayout().getHeight();
    }

    public void K() {
        if (this.m == null) {
            long N = N();
            this.s = N;
            this.m = new y(this, N);
            boolean z = false;
            IAlog.a("%senabling close with delay %d", IAlog.a((Object) this), Long.valueOf(this.s));
            AdContent adcontent = this.b;
            if (adcontent != null) {
                z = b(adcontent);
            }
            if (!z || J()) {
                Q();
            } else if (z) {
                c.a aVar = this.l;
                if (aVar != null) {
                    aVar.showCloseCountdown();
                }
                a aVar2 = new a(100 + this.s, 1000);
                this.w = aVar2;
                aVar2.start();
            }
        }
    }

    public void P() {
        Runnable runnable = this.m;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.q.b.removeCallbacks(runnable);
            this.m = null;
        }
        Runnable runnable2 = this.o;
        if (runnable2 != null) {
            com.fyber.inneractive.sdk.util.q.b.removeCallbacks(runnable2);
            this.o = null;
        }
    }

    public void a(c.a aVar, Activity activity) throws InneractiveUnitController.AdDisplayError, Resources.NotFoundException {
        if (this.a == null) {
            IAlog.e("%sYou must set the spot to render before calling renderAd", IAlog.a((Object) this));
            throw new InneractiveUnitController.AdDisplayError("No spot ad to render");
        } else if (aVar != null) {
            this.l = aVar;
        } else {
            IAlog.e("%srenderAd called with a null activity!", IAlog.a((Object) this));
            throw new InneractiveUnitController.AdDisplayError("Activity is null");
        }
    }

    public void e(boolean z) {
        s.a aVar;
        this.q = true;
        if (z) {
            if (this.b == null) {
                aVar = new s.a(r.FAIL_SAFE_ACTIVATED, (InneractiveAdRequest) null, (e) null, (JSONArray) null);
            } else {
                r rVar = r.FAIL_SAFE_ACTIVATED;
                AdContent adcontent = this.b;
                aVar = new s.a(rVar, adcontent.a, adcontent.d(), this.b.c.c());
            }
            JSONObject jSONObject = new JSONObject();
            Boolean valueOf = Boolean.valueOf(O());
            try {
                jSONObject.put("is_endcard", valueOf);
            } catch (Exception unused) {
                IAlog.e("Got exception adding param to json object: %s, %s", "is_endcard", valueOf);
            }
            aVar.f.put(jSONObject);
            aVar.a((String) null);
        }
        c.a aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.showCloseButton(z, M(), L());
            if (!z) {
                this.v.a();
                this.v.a(false);
            }
        }
    }

    public void o() {
        b1 b1Var = this.n;
        if (b1Var != null) {
            b1Var.b();
        }
        b1 b1Var2 = this.p;
        if (b1Var2 != null) {
            b1Var2.b();
        }
    }

    public void t() {
        b1 b1Var = this.n;
        if (b1Var != null) {
            b1Var.a();
        }
        b1 b1Var2 = this.p;
        if (b1Var2 != null) {
            b1Var2.a();
        }
    }

    public void Q() {
        if (!this.r) {
            this.r = true;
            b1 b1Var = new b1(TimeUnit.MILLISECONDS, this.s);
            this.n = b1Var;
            b1Var.e = new b();
            b1Var.c();
        }
    }
}
