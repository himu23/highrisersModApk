package com.applovin.impl.mediation.debugger.ui.a;

import android.os.Bundle;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.applovin.impl.mediation.debugger.b.a.b;
import com.applovin.impl.mediation.debugger.b.a.f;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.mediation.MaxDebuggerWaterfallKeywordsActivity;
import com.applovin.sdk.R;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte$$ExternalSyntheticBackport0;

public class c extends com.applovin.impl.mediation.debugger.ui.a {
    private com.applovin.impl.mediation.debugger.b.a.a apU;
    private d aqw;
    private n sdk;

    public enum a {
        TARGETED_WATERFALL,
        OTHER_WATERFALLS
    }

    /* access modifiers changed from: protected */
    public n getSdk() {
        return this.sdk;
    }

    public void initialize(final com.applovin.impl.mediation.debugger.b.a.a aVar, n nVar) {
        this.apU = aVar;
        this.sdk = nVar;
        AnonymousClass1 r0 = new d(this) {
            /* access modifiers changed from: protected */
            public int tM() {
                return aVar.uH().size();
            }

            /* access modifiers changed from: protected */
            public int gg(int i) {
                b bVar = aVar.uH().get(i);
                int i2 = bVar.uJ() != null ? 1 : 0;
                f uK = bVar.uK();
                int i3 = (uK.uX() == null || uK.uY() == null) ? 2 : 3;
                if (uK.uZ() != null) {
                    i3++;
                }
                if (uK.getKeywords() != null) {
                    i3++;
                }
                return i2 + 1 + i3;
            }

            /* access modifiers changed from: protected */
            public com.applovin.impl.mediation.debugger.ui.d.c gh(int i) {
                if (i == a.TARGETED_WATERFALL.ordinal()) {
                    return new e("TARGETED WATERFALL FOR CURRENT DEVICE");
                }
                if (i == a.OTHER_WATERFALLS.ordinal()) {
                    return new e("OTHER WATERFALLS");
                }
                return new e("");
            }

            /* access modifiers changed from: protected */
            public List<com.applovin.impl.mediation.debugger.ui.d.c> gi(int i) {
                ArrayList arrayList = new ArrayList();
                b bVar = aVar.uH().get(i);
                arrayList.add(c.this.bJ(bVar.getName()));
                if (bVar.uJ() != null) {
                    arrayList.add(c.this.u("AB Test Experiment Name", bVar.uJ()));
                }
                f uK = bVar.uK();
                c cVar = c.this;
                arrayList.add(cVar.u("Device ID Targeting", cVar.bK(uK.uV())));
                c cVar2 = c.this;
                arrayList.add(cVar2.u("Device Type Targeting", cVar2.bL(uK.uW())));
                if (uK.uZ() != null) {
                    c cVar3 = c.this;
                    arrayList.add(cVar3.u("Gender", cVar3.p(uK.uZ())));
                }
                if (!(uK.uX() == null || uK.uY() == null)) {
                    c cVar4 = c.this;
                    arrayList.add(cVar4.u("Age", uK.uX() + "-" + uK.uY()));
                }
                if (uK.getKeywords() != null) {
                    arrayList.add(c.this.q(uK.getKeywords()));
                }
                return arrayList;
            }
        };
        this.aqw = r0;
        r0.a(new c$$ExternalSyntheticLambda2(this, nVar, aVar));
        this.aqw.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(n nVar, com.applovin.impl.mediation.debugger.b.a.a aVar, com.applovin.impl.mediation.debugger.ui.d.a aVar2, com.applovin.impl.mediation.debugger.ui.d.c cVar) {
        if (aVar2.wQ() == 0) {
            com.applovin.impl.sdk.utils.b.a(this, MaxDebuggerAdUnitDetailActivity.class, nVar.BM(), new c$$ExternalSyntheticLambda0(aVar, aVar2, nVar));
        } else if (cVar.wU().toString().equals("Keywords")) {
            com.applovin.impl.sdk.utils.b.a(this, MaxDebuggerWaterfallKeywordsActivity.class, nVar.BM(), new c$$ExternalSyntheticLambda1(aVar, aVar2, nVar));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(com.applovin.impl.mediation.debugger.b.a.a aVar, com.applovin.impl.mediation.debugger.ui.d.a aVar2, n nVar, MaxDebuggerWaterfallKeywordsActivity maxDebuggerWaterfallKeywordsActivity) {
        b bVar = aVar.uH().get(aVar2.wP());
        maxDebuggerWaterfallKeywordsActivity.initialize(bVar.getName(), bVar.uK().getKeywords(), nVar);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle(this.apU.getName());
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(this.aqw);
        listView.setDividerHeight(0);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        d dVar = this.aqw;
        if (dVar != null) {
            dVar.a((d.a) null);
        }
    }

    /* access modifiers changed from: private */
    public com.applovin.impl.mediation.debugger.ui.d.c bJ(String str) {
        return com.applovin.impl.mediation.debugger.ui.d.c.a(c.b.RIGHT_DETAIL).a(StringUtils.createSpannedString(str, ViewCompat.MEASURED_STATE_MASK, 18, 1)).y(this).aF(true).wX();
    }

    /* access modifiers changed from: private */
    public com.applovin.impl.mediation.debugger.ui.d.c u(String str, String str2) {
        return com.applovin.impl.mediation.debugger.ui.d.c.a(c.b.RIGHT_DETAIL).bO(str).bP(str2).wX();
    }

    /* access modifiers changed from: private */
    public String bK(String str) {
        if (str.equals("idfa")) {
            return "IDFA Only";
        }
        return str.equals("dnt") ? "No IDFA Only" : "All";
    }

    /* access modifiers changed from: private */
    public String bL(String str) {
        if (str.equals("phone")) {
            return "Phones";
        }
        return str.equals("tablet") ? "Tablets" : "All";
    }

    /* access modifiers changed from: private */
    public String p(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (next.equals(InneractiveMediationDefs.GENDER_MALE)) {
                arrayList.add("Male");
            } else if (next.equals(InneractiveMediationDefs.GENDER_FEMALE)) {
                arrayList.add("Female");
            } else {
                arrayList.add("Unknown");
            }
        }
        return UByte$$ExternalSyntheticBackport0.m((CharSequence) ", ", (Iterable) arrayList);
    }

    /* access modifiers changed from: private */
    public com.applovin.impl.mediation.debugger.ui.d.c q(List<String> list) {
        c.a bO = com.applovin.impl.mediation.debugger.ui.d.c.a(c.b.DETAIL).bO("Keywords");
        return bO.b(StringUtils.createSpannedString(list.size() + " keyword group(s)", -7829368, 14)).y(this).aF(true).wX();
    }
}
