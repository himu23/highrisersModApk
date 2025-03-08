package com.fyber.inneractive.sdk.dv.banner;

import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.cache.session.enums.a;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.dv.f;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.flow.r;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;
import com.google.android.gms.ads.AdView;

public class b extends r<a, InneractiveAdViewEventsListener> implements com.fyber.inneractive.sdk.interfaces.b {
    public ViewGroup l;

    public void a() {
    }

    public void a(int i) {
    }

    public void a(ViewGroup viewGroup) {
        AdContent adcontent;
        if (this.a == null) {
            IAlog.e("%sYou must set the spot to render before calling renderAd", IAlog.a((Object) this));
        } else if (viewGroup != null && (adcontent = this.b) != null) {
            a aVar = (a) adcontent;
            if (aVar.i != null) {
                aVar.h = this;
                if (aVar.j) {
                    w();
                    aVar.j = false;
                }
                this.l = viewGroup;
                viewGroup.addView((View) ((a) this.b).i);
            }
        }
    }

    public void destroy() {
        AdContent adcontent = this.b;
        if (adcontent != null) {
            a aVar = (a) adcontent;
            if (aVar.i != null) {
                ((AdView) aVar.i).destroy();
            }
            ((a) this.b).a();
        }
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.l = null;
        }
        super.destroy();
    }

    public int f() {
        AdContent adcontent = this.b;
        if (adcontent == null) {
            return 0;
        }
        a aVar = (a) adcontent;
        if (aVar.i == null || ((AdView) aVar.i).getAdSize() == null) {
            return 0;
        }
        return p.a(((AdView) ((a) this.b).i).getAdSize().getWidth());
    }

    public void n() {
    }

    public int p() {
        AdContent adcontent = this.b;
        if (adcontent == null) {
            return 0;
        }
        a aVar = (a) adcontent;
        if (aVar.i == null || ((AdView) aVar.i).getAdSize() == null) {
            return 0;
        }
        return p.a(((AdView) ((a) this.b).i).getAdSize().getHeight());
    }

    public void r() {
    }

    public void w() {
        com.fyber.inneractive.sdk.cache.session.enums.b bVar;
        E();
        AdContent adcontent = this.b;
        if (adcontent != null) {
            a aVar = (a) adcontent;
            if (((f) aVar.b) != null) {
                b((e) (f) aVar.b);
                a aVar2 = (a) this.b;
                if (aVar2.d != null && ((a0) aVar2.d).c != null) {
                    a aVar3 = a.IMPRESSION;
                    if (((a0) aVar2.d).c.b == UnitDisplayType.MRECT) {
                        bVar = com.fyber.inneractive.sdk.cache.session.enums.b.RECTANGLE_DISPLAY;
                    } else {
                        bVar = com.fyber.inneractive.sdk.cache.session.enums.b.BANNER_DISPLAY;
                    }
                    a(aVar3, bVar);
                }
            }
        }
    }

    public View y() {
        return this.l;
    }

    public void u() {
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.l = null;
        }
    }

    public boolean a(q qVar) {
        return qVar instanceof com.fyber.inneractive.sdk.dv.a;
    }

    public boolean a(View view) {
        ViewGroup viewGroup = this.l;
        return viewGroup != null && viewGroup.equals(view);
    }
}
