package com.applovin.impl.mediation.debugger.ui.e;

import android.os.Bundle;
import android.widget.ListView;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.privacy.b.c;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

public class b extends com.applovin.impl.mediation.debugger.ui.a {
    private d aqw;
    private n sdk;

    private enum a {
        TC_NETWORKS,
        AC_NETWORKS
    }

    /* access modifiers changed from: protected */
    public n getSdk() {
        return this.sdk;
    }

    public void initialize(n nVar) {
        this.sdk = nVar;
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final boolean ct = com.applovin.impl.privacy.b.d.ct(nVar.Cm().At());
        if (!ct) {
            arrayList2.add(b("Has User Consent", AppLovinPrivacySettings.hasUserConsent(this)));
        }
        for (c next : nVar.Cm().Au()) {
            Boolean Ay = next.Ay();
            if (Ay != null) {
                if (next.Av() == c.a.TCF_VENDOR) {
                    arrayList.add(b(next.getDisplayName(), Ay.booleanValue()));
                } else if (next.Av() == c.a.ATP_NETWORK) {
                    arrayList2.add(b(next.getDisplayName(), Ay.booleanValue()));
                }
            } else if (ct && next.Av() == c.a.ATP_NETWORK) {
                arrayList2.add(b(next.getDisplayName(), AppLovinPrivacySettings.hasUserConsent(this)));
            }
        }
        AnonymousClass1 r0 = new d(this) {
            /* access modifiers changed from: protected */
            public int tM() {
                return a.values().length;
            }

            /* access modifiers changed from: protected */
            public int gg(int i) {
                if (i == a.TC_NETWORKS.ordinal()) {
                    return arrayList.size();
                }
                return arrayList2.size();
            }

            /* access modifiers changed from: protected */
            public com.applovin.impl.mediation.debugger.ui.d.c gh(int i) {
                if (i == a.TC_NETWORKS.ordinal()) {
                    return new e("TCF VENDORS (TC STRING)");
                }
                return new e(ct ? "ATP NETWORKS (AC STRING)" : "APPLOVIN PRIVACY SETTING");
            }

            /* access modifiers changed from: protected */
            public List<com.applovin.impl.mediation.debugger.ui.d.c> gi(int i) {
                return i == a.TC_NETWORKS.ordinal() ? arrayList : arrayList2;
            }
        };
        this.aqw = r0;
        r0.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("Network Consent Statuses");
        ((ListView) findViewById(R.id.listView)).setAdapter(this.aqw);
    }

    private com.applovin.impl.mediation.debugger.ui.d.c b(String str, boolean z) {
        return com.applovin.impl.mediation.debugger.ui.d.c.wW().bO(str).bP(String.valueOf(z)).wX();
    }
}
