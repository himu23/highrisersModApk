package com.applovin.impl.mediation.debugger.ui.a;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.applovin.impl.mediation.debugger.b.a.e;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

class b extends d {
    private final com.applovin.impl.mediation.debugger.b.a.a apU;
    private final e apV;
    private final com.applovin.impl.mediation.debugger.b.a.b aql;
    private final List<c> aqm;
    private final List<c> aqn;
    private final List<c> aqo;
    private final String title;

    enum a {
        INFO,
        BIDDERS,
        WATERFALL,
        COUNT
    }

    public String getTitle() {
        return this.title;
    }

    public com.applovin.impl.mediation.debugger.b.a.b vV() {
        return this.aql;
    }

    b(com.applovin.impl.mediation.debugger.b.a.a aVar, com.applovin.impl.mediation.debugger.b.a.b bVar, e eVar, Context context) {
        super(context);
        com.applovin.impl.mediation.debugger.b.a.b bVar2;
        this.apU = aVar;
        this.apV = eVar;
        if (bVar != null) {
            bVar2 = bVar;
        } else {
            bVar2 = aVar.uG();
        }
        this.aql = bVar2;
        this.title = bVar != null ? bVar.getName() : aVar.getName();
        this.aqm = vW();
        this.aqn = vX();
        this.aqo = vY();
        notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public int tM() {
        return a.COUNT.ordinal();
    }

    /* access modifiers changed from: protected */
    public int gg(int i) {
        if (i == a.INFO.ordinal()) {
            return this.aqm.size();
        }
        if (i == a.BIDDERS.ordinal()) {
            return this.aqn.size();
        }
        return this.aqo.size();
    }

    /* access modifiers changed from: protected */
    public c gh(int i) {
        if (i == a.INFO.ordinal()) {
            return new com.applovin.impl.mediation.debugger.ui.d.e("INFO");
        }
        if (i == a.BIDDERS.ordinal()) {
            return new com.applovin.impl.mediation.debugger.ui.d.e("BIDDERS");
        }
        return new com.applovin.impl.mediation.debugger.ui.d.e("WATERFALL");
    }

    /* access modifiers changed from: protected */
    public List<c> gi(int i) {
        if (i == a.INFO.ordinal()) {
            return this.aqm;
        }
        return i == a.BIDDERS.ordinal() ? this.aqn : this.aqo;
    }

    private List<c> vW() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(vZ());
        arrayList.add(wa());
        if (this.aql.uJ() != null) {
            arrayList.add(wb());
        }
        if (this.apV != null) {
            arrayList.add(wc());
        }
        return arrayList;
    }

    private List<c> vX() {
        e eVar = this.apV;
        if (eVar != null && !eVar.uT()) {
            return new ArrayList();
        }
        List<e> uL = this.aql.uL();
        ArrayList arrayList = new ArrayList(uL.size());
        for (e next : uL) {
            e eVar2 = this.apV;
            if (eVar2 == null || eVar2.uR().getName().equals(next.uR().getName())) {
                arrayList.add(new C0075b(next, next.uS() != null ? next.uS().mQ() : "", this.apV == null));
            }
        }
        return arrayList;
    }

    private List<c> vY() {
        e eVar = this.apV;
        if (eVar != null && eVar.uT()) {
            return new ArrayList();
        }
        List<e> uM = this.aql.uM();
        ArrayList arrayList = new ArrayList(uM.size());
        for (e next : uM) {
            e eVar2 = this.apV;
            if (eVar2 == null || eVar2.uR().getName().equals(next.uR().getName())) {
                arrayList.add(new C0075b(next, (String) null, this.apV == null));
                for (com.applovin.impl.mediation.debugger.b.a.d next2 : next.uU()) {
                    arrayList.add(c.wW().bO(next2.mQ()).bP(next2.uQ()).aG(true).wX());
                }
            }
        }
        return arrayList;
    }

    private c vZ() {
        return c.wW().bO("ID").bP(this.apU.mQ()).wX();
    }

    private c wa() {
        return c.wW().bO("Ad Format").bP(this.apU.tG()).wX();
    }

    private c wb() {
        return c.wW().bO("AB Test Experiment Name").bP(vV().uJ()).wX();
    }

    private c wc() {
        return c.wW().bO("Selected Network").bP(this.apV.uR().getDisplayName()).wX();
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.a.b$b  reason: collision with other inner class name */
    class C0075b extends com.applovin.impl.mediation.debugger.ui.b.a.a {
        private final e aqu;

        public int vP() {
            return -12303292;
        }

        public e wd() {
            return this.aqu;
        }

        C0075b(e eVar, String str, boolean z) {
            super(eVar.uR().uP(), b.this.E);
            this.aqu = eVar;
            this.asv = StringUtils.createSpannedString(eVar.uR().getDisplayName(), ViewCompat.MEASURED_STATE_MASK, 18, 1);
            this.asw = !TextUtils.isEmpty(str) ? new SpannedString(str) : null;
            this.iV = z;
        }

        public boolean isEnabled() {
            return this.iV;
        }
    }
}
