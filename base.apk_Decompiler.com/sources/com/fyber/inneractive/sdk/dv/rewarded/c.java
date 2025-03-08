package com.fyber.inneractive.sdk.dv.rewarded;

import android.app.Activity;
import com.fyber.inneractive.sdk.a;
import com.fyber.inneractive.sdk.cache.session.enums.b;
import com.fyber.inneractive.sdk.dv.f;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.flow.z;
import com.fyber.inneractive.sdk.interfaces.c;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;

public class c extends z<a, InneractiveFullscreenAdEventsListener> implements com.fyber.inneractive.sdk.dv.interstitial.a {
    public c.b x;
    public boolean y = false;

    public boolean J() {
        return false;
    }

    public int L() {
        return 0;
    }

    public int M() {
        return 0;
    }

    public long N() {
        return 0;
    }

    public boolean O() {
        return false;
    }

    public long a(long j) {
        return 0;
    }

    public void a(c.a aVar, Activity activity) throws InneractiveUnitController.AdDisplayError {
        super.a(aVar, activity);
        if (activity != null) {
            AdContent adcontent = this.b;
            if (adcontent != null) {
                a aVar2 = (a) adcontent;
                if (aVar2.i != null) {
                    aVar2.a(this, activity);
                    return;
                }
            }
            IAlog.e("%sad content is null aborting", IAlog.a((Object) this));
            throw new InneractiveUnitController.AdDisplayError("Ad content is null");
        }
        IAlog.e("%sYou must pass activity in order to show rewarded", IAlog.a((Object) this));
        throw new InneractiveUnitController.AdDisplayError("No activity context");
    }

    public void a(c.b bVar) {
        this.x = bVar;
    }

    public void b() {
    }

    public /* bridge */ /* synthetic */ boolean b(q qVar) {
        a aVar = (a) qVar;
        return false;
    }

    public void d() {
        AdContent adcontent = this.b;
        if (adcontent != null) {
            a aVar = (a) adcontent;
            if (((f) aVar.b) != null) {
                a((e) (f) aVar.b);
            }
        }
        a(com.fyber.inneractive.sdk.cache.session.enums.a.CLICK, b.REWARDED_VIDEO);
        D();
    }

    public void i() {
        EventsListener eventslistener;
        if (!this.y && (eventslistener = this.c) != null) {
            this.y = true;
            ((InneractiveFullscreenAdEventsListener) eventslistener).onAdDismissed(this.a);
        }
    }

    public void m() {
    }

    public boolean v() {
        return false;
    }

    public void w() {
        AdContent adcontent = this.b;
        if (adcontent != null) {
            b((e) (f) ((a) adcontent).b);
        }
        a(com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION, b.REWARDED_VIDEO);
        E();
    }

    public void onReward() {
        c.b bVar = this.x;
        if (bVar != null) {
            ((InneractiveFullscreenUnitController.a) bVar).a();
            I();
        }
        a(com.fyber.inneractive.sdk.cache.session.enums.a.COMPLETION, b.REWARDED_VIDEO);
    }
}
