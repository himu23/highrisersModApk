package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import com.applovin.exoplayer2.ab;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.ak;
import com.applovin.exoplayer2.am;
import com.applovin.exoplayer2.an;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.h.ad;
import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.j.h;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.m.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SubtitleView extends FrameLayout implements an.d {
    private List<com.applovin.exoplayer2.i.a> OV;
    private c VU;
    private float VV;
    private int YW;
    private float YX;
    private boolean YY;
    private boolean YZ;
    private int Za;
    private a Zb;
    private View Zc;

    interface a {
        void a(List<com.applovin.exoplayer2.i.a> list, c cVar, float f, int i, float f2);
    }

    public /* synthetic */ void A(boolean z) {
        an.d.CC.$default$A(this, z);
    }

    public /* synthetic */ void Z(int i) {
        an.d.CC.$default$Z(this, i);
    }

    public /* synthetic */ void a(ab abVar, int i) {
        an.d.CC.$default$a((an.d) this, abVar, i);
    }

    public /* synthetic */ void a(ac acVar) {
        an.d.CC.$default$a((an.d) this, acVar);
    }

    public /* synthetic */ void a(ak akVar) {
        an.d.CC.$default$a((an.d) this, akVar);
    }

    public /* synthetic */ void a(an.e eVar, an.e eVar2, int i) {
        an.d.CC.$default$a(this, eVar, eVar2, i);
    }

    public /* synthetic */ void a(an anVar, an.c cVar) {
        an.d.CC.$default$a((an.d) this, anVar, cVar);
    }

    public /* synthetic */ void a(com.applovin.exoplayer2.g.a aVar) {
        an.d.CC.$default$a((an.d) this, aVar);
    }

    public /* synthetic */ void a(ad adVar, h hVar) {
        an.d.CC.$default$a((an.d) this, adVar, hVar);
    }

    public /* synthetic */ void a(o oVar) {
        an.d.CC.$default$a((an.d) this, oVar);
    }

    public /* synthetic */ void a(com.applovin.exoplayer2.o oVar) {
        an.d.CC.$default$a((an.d) this, oVar);
    }

    public /* synthetic */ void aa(int i) {
        an.d.CC.$default$aa(this, i);
    }

    public /* synthetic */ void ab(int i) {
        an.d.CC.$default$ab(this, i);
    }

    public /* synthetic */ void ac(int i) {
        an.b.CC.$default$ac(this, i);
    }

    public /* synthetic */ void b(ak akVar) {
        an.d.CC.$default$b((an.d) this, akVar);
    }

    public /* synthetic */ void b(am amVar) {
        an.d.CC.$default$b((an.d) this, amVar);
    }

    public /* synthetic */ void b(ba baVar, int i) {
        an.d.CC.$default$b(this, baVar, i);
    }

    public /* synthetic */ void cD() {
        an.b.CC.$default$cD(this);
    }

    public /* synthetic */ void cE() {
        an.d.CC.$default$cE(this);
    }

    public /* synthetic */ void d(an.a aVar) {
        an.d.CC.$default$d(this, aVar);
    }

    public /* synthetic */ void d(boolean z, int i) {
        an.b.CC.$default$d(this, z, i);
    }

    public /* synthetic */ void e(int i, boolean z) {
        an.d.CC.$default$e((an.d) this, i, z);
    }

    public /* synthetic */ void e(boolean z, int i) {
        an.d.CC.$default$e((an.d) this, z, i);
    }

    public /* synthetic */ void f(int i, int i2) {
        an.d.CC.$default$f(this, i, i2);
    }

    public /* synthetic */ void g(float f) {
        an.d.CC.$default$g(this, f);
    }

    public /* synthetic */ void w(boolean z) {
        an.d.CC.$default$w(this, z);
    }

    public /* synthetic */ void x(boolean z) {
        an.b.CC.$default$x(this, z);
    }

    public /* synthetic */ void y(boolean z) {
        an.d.CC.$default$y(this, z);
    }

    public /* synthetic */ void z(boolean z) {
        an.d.CC.$default$z(this, z);
    }

    public SubtitleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OV = Collections.emptyList();
        this.VU = c.VW;
        this.YW = 0;
        this.YX = 0.0533f;
        this.VV = 0.08f;
        this.YY = true;
        this.YZ = true;
        b bVar = new b(context);
        this.Zb = bVar;
        this.Zc = bVar;
        addView(bVar);
        this.Za = 1;
    }

    public void e(List<com.applovin.exoplayer2.i.a> list) {
        setCues(list);
    }

    public void setCues(List<com.applovin.exoplayer2.i.a> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.OV = list;
        nY();
    }

    public void setViewType(int i) {
        if (this.Za != i) {
            if (i == 1) {
                setView(new b(getContext()));
            } else if (i == 2) {
                setView(new l(getContext()));
            } else {
                throw new IllegalArgumentException();
            }
            this.Za = i;
        }
    }

    private <T extends View & a> void setView(T t) {
        removeView(this.Zc);
        View view = this.Zc;
        if (view instanceof l) {
            ((l) view).destroy();
        }
        this.Zc = t;
        this.Zb = (a) t;
        addView(t);
    }

    public void nW() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setFractionalTextSize(float f) {
        a(f, false);
    }

    public void a(float f, boolean z) {
        c(z ? 1 : 0, f);
    }

    private void c(int i, float f) {
        this.YW = i;
        this.YX = f;
        nY();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        this.YY = z;
        nY();
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        this.YZ = z;
        nY();
    }

    public void nX() {
        setStyle(getUserCaptionStyle());
    }

    public void setStyle(c cVar) {
        this.VU = cVar;
        nY();
    }

    public void setBottomPaddingFraction(float f) {
        this.VV = f;
        nY();
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (ai.acV < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private c getUserCaptionStyle() {
        if (ai.acV < 19 || isInEditMode()) {
            return c.VW;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        if (captioningManager == null || !captioningManager.isEnabled()) {
            return c.VW;
        }
        return c.a(captioningManager.getUserStyle());
    }

    private void nY() {
        this.Zb.a(getCuesWithStylingPreferencesApplied(), this.VU, this.YX, this.YW, this.VV);
    }

    private List<com.applovin.exoplayer2.i.a> getCuesWithStylingPreferencesApplied() {
        if (this.YY && this.YZ) {
            return this.OV;
        }
        ArrayList arrayList = new ArrayList(this.OV.size());
        for (int i = 0; i < this.OV.size(); i++) {
            arrayList.add(b(this.OV.get(i)));
        }
        return arrayList;
    }

    private com.applovin.exoplayer2.i.a b(com.applovin.exoplayer2.i.a aVar) {
        a.C0050a lP = aVar.lP();
        if (!this.YY) {
            j.a(lP);
        } else if (!this.YZ) {
            j.b(lP);
        }
        return lP.lU();
    }
}
