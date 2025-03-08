package com.applovin.impl.mediation.debugger.ui.e;

import android.os.Bundle;
import android.widget.ListView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.privacy.b.c;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.b;
import com.applovin.mediation.MaxDebuggerCmpNetworksListActivity;
import com.applovin.mediation.MaxDebuggerTcfStringActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class c extends com.applovin.impl.mediation.debugger.ui.a {
    private d aqw;
    /* access modifiers changed from: private */
    public final Set<String> atf = new TreeSet();
    /* access modifiers changed from: private */
    public final Set<String> atg = new TreeSet();
    /* access modifiers changed from: private */
    public final Set<String> ath = new TreeSet();
    /* access modifiers changed from: private */
    public final Set<String> ati = new TreeSet();
    /* access modifiers changed from: private */
    public final Set<String> atj = new TreeSet();
    private n sdk;

    private enum a {
        CMP_SDK_ID,
        CMP_SDK_VERSION,
        INSTRUCTIONS,
        MISSING_NETWORKS
    }

    private enum b {
        GDPR_APPLIES,
        TC_STRING,
        AC_STRING
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.e.c$c  reason: collision with other inner class name */
    private enum C0078c {
        IAB_TCF_PARAMETERS,
        CMP_CONFIGURATION
    }

    /* access modifiers changed from: protected */
    public n getSdk() {
        return this.sdk;
    }

    public void initialize(final n nVar) {
        this.sdk = nVar;
        final com.applovin.impl.privacy.b.b Cm = nVar.Cm();
        A(Cm.Au());
        AnonymousClass1 r1 = new d(this) {
            /* access modifiers changed from: protected */
            public int tM() {
                return C0078c.values().length;
            }

            /* access modifiers changed from: protected */
            public int gg(int i) {
                if (i == C0078c.IAB_TCF_PARAMETERS.ordinal()) {
                    return b.values().length;
                }
                return a.values().length;
            }

            /* access modifiers changed from: protected */
            public com.applovin.impl.mediation.debugger.ui.d.c gh(int i) {
                if (i == C0078c.IAB_TCF_PARAMETERS.ordinal()) {
                    return new e("IAB TCF Parameters");
                }
                return new e("CMP CONFIGURATION");
            }

            /* access modifiers changed from: protected */
            public List<com.applovin.impl.mediation.debugger.ui.d.c> gi(int i) {
                if (i == C0078c.IAB_TCF_PARAMETERS.ordinal()) {
                    return c.this.xb();
                }
                return c.this.xc();
            }
        };
        this.aqw = r1;
        r1.a(new d.a() {
            public void onClick(com.applovin.impl.mediation.debugger.ui.d.a aVar, com.applovin.impl.mediation.debugger.ui.d.c cVar) {
                final String str;
                final String str2;
                if (aVar.wP() == C0078c.IAB_TCF_PARAMETERS.ordinal()) {
                    if (aVar.wQ() == b.TC_STRING.ordinal()) {
                        str2 = com.applovin.impl.sdk.c.d.aRx.getName();
                        str = Cm.As();
                    } else {
                        str2 = com.applovin.impl.sdk.c.d.aRy.getName();
                        str = Cm.At();
                    }
                    com.applovin.impl.sdk.utils.b.a(c.this, MaxDebuggerTcfStringActivity.class, nVar.BM(), new b.a<MaxDebuggerTcfStringActivity>() {
                        /* renamed from: a */
                        public void onActivityCreated(MaxDebuggerTcfStringActivity maxDebuggerTcfStringActivity) {
                            maxDebuggerTcfStringActivity.initialize(str2, str, nVar);
                        }
                    });
                    return;
                }
                com.applovin.impl.sdk.utils.b.a(c.this, MaxDebuggerCmpNetworksListActivity.class, nVar.BM(), new b.a<MaxDebuggerCmpNetworksListActivity>() {
                    /* renamed from: a */
                    public void onActivityCreated(MaxDebuggerCmpNetworksListActivity maxDebuggerCmpNetworksListActivity) {
                        maxDebuggerCmpNetworksListActivity.initialize(c.this.ath, c.this.ati, c.this.atf, c.this.atg, c.this.atj, nVar);
                    }
                });
            }
        });
        this.aqw.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("CMP (Consent Management Platform)");
        ((ListView) findViewById(R.id.listView)).setAdapter(this.aqw);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        d dVar = this.aqw;
        if (dVar != null) {
            dVar.a((d.a) null);
        }
    }

    private void A(List<com.applovin.impl.privacy.b.c> list) {
        for (com.applovin.impl.privacy.b.c next : list) {
            if (next.Av() == c.a.TCF_VENDOR) {
                if (Boolean.TRUE.equals(next.Ay())) {
                    this.atf.add(next.Ax());
                } else {
                    this.ath.add(next.Ax());
                }
            } else if (next.Av() != c.a.ATP_NETWORK) {
                this.atj.add(next.getDisplayName());
            } else if (!com.applovin.impl.privacy.b.d.ct(this.sdk.Cm().At())) {
                this.atj.add(next.getDisplayName());
            } else if (Boolean.TRUE.equals(next.Ay())) {
                this.atg.add(next.Ax());
            } else {
                this.ati.add(next.Ax());
            }
        }
    }

    /* access modifiers changed from: private */
    public List<com.applovin.impl.mediation.debugger.ui.d.c> xb() {
        ArrayList arrayList = new ArrayList(b.values().length);
        Integer Ar = this.sdk.Cm().Ar();
        String As = this.sdk.Cm().As();
        String At = this.sdk.Cm().At();
        arrayList.add(a(com.applovin.impl.sdk.c.d.aRw.getName(), Ar));
        arrayList.add(a(com.applovin.impl.sdk.c.d.aRx.getName(), As, !com.applovin.impl.privacy.b.d.cr(As)));
        arrayList.add(a(com.applovin.impl.sdk.c.d.aRy.getName(), At, false));
        return arrayList;
    }

    /* access modifiers changed from: private */
    public List<com.applovin.impl.mediation.debugger.ui.d.c> xc() {
        String str;
        ArrayList arrayList = new ArrayList(b.values().length);
        Integer Ap = this.sdk.Cm().Ap();
        Integer Aq = this.sdk.Cm().Aq();
        int size = this.ath.size() + this.ati.size();
        arrayList.add(a(com.applovin.impl.sdk.c.d.aRu.getName(), Ap));
        arrayList.add(a(com.applovin.impl.sdk.c.d.aRv.getName(), Aq));
        arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.a(c.b.DETAIL).bO("To check which of your integrated networks are missing from your CMP, first make sure that you have granted consent to all networks through your CMP flow. Then add the following networks to your CMP network list.").wX());
        c.a bO = com.applovin.impl.mediation.debugger.ui.d.c.a(c.b.RIGHT_DETAIL).bO("Configured CMP Networks");
        if (size > 0) {
            str = "Missing " + size + " network(s)";
        } else {
            str = "";
        }
        arrayList.add(bO.bP(str).gm(size > 0 ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK).y(this).aF(true).wX());
        return arrayList;
    }

    private com.applovin.impl.mediation.debugger.ui.d.c a(String str, Integer num) {
        return com.applovin.impl.mediation.debugger.ui.d.c.a(c.b.RIGHT_DETAIL).bO(str).bP(num != null ? num.toString() : "No value set").gm(num != null ? ViewCompat.MEASURED_STATE_MASK : SupportMenu.CATEGORY_MASK).wX();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c a(String str, String str2, boolean z) {
        boolean isValidString = StringUtils.isValidString(str2);
        if (isValidString && str2.length() > 35) {
            str2 = str2.substring(0, 35) + "...";
        }
        c.a bO = com.applovin.impl.mediation.debugger.ui.d.c.a(c.b.DETAIL).bO(str);
        if (!isValidString) {
            str2 = "No value set";
        }
        c.a aF = bO.bP(str2).gm(z ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK).aF(isValidString);
        if (isValidString) {
            aF.y(this);
        }
        return aF.wX();
    }
}
