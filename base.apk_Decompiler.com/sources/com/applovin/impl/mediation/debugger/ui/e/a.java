package com.applovin.impl.mediation.debugger.ui.e;

import android.os.Bundle;
import android.widget.ListView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class a extends com.applovin.impl.mediation.debugger.ui.a {
    private d aqw;
    private n sdk;

    /* renamed from: com.applovin.impl.mediation.debugger.ui.e.a$a  reason: collision with other inner class name */
    private enum C0077a {
        MISSING_TC_NETWORKS,
        MISSING_AC_NETWORKS,
        LISTED_TC_NETWORKS,
        LISTED_AC_NETWORKS,
        OTHER_NETWORKS
    }

    /* access modifiers changed from: protected */
    public n getSdk() {
        return this.sdk;
    }

    public void initialize(Set<String> set, Set<String> set2, Set<String> set3, Set<String> set4, Set<String> set5, n nVar) {
        this.sdk = nVar;
        final Set<String> set6 = set;
        final Set<String> set7 = set2;
        final Set<String> set8 = set3;
        final Set<String> set9 = set4;
        final Set<String> set10 = set5;
        AnonymousClass1 r0 = new d(this) {
            /* access modifiers changed from: protected */
            public int tM() {
                return C0077a.values().length;
            }

            /* access modifiers changed from: protected */
            public int gg(int i) {
                if (i == C0077a.MISSING_TC_NETWORKS.ordinal()) {
                    return set6.size();
                }
                if (i == C0077a.MISSING_AC_NETWORKS.ordinal()) {
                    return set7.size();
                }
                if (i == C0077a.LISTED_TC_NETWORKS.ordinal()) {
                    return set8.size();
                }
                if (i == C0077a.LISTED_AC_NETWORKS.ordinal()) {
                    return set9.size();
                }
                return set10.size();
            }

            /* access modifiers changed from: protected */
            public c gh(int i) {
                if (i == C0077a.MISSING_TC_NETWORKS.ordinal()) {
                    return new e("MISSING TCF VENDORS (TC STRING)");
                }
                if (i == C0077a.MISSING_AC_NETWORKS.ordinal()) {
                    return new e("MISSING ATP NETWORKS (AC STRING)");
                }
                if (i == C0077a.LISTED_TC_NETWORKS.ordinal()) {
                    return new e("LISTED TCF VENDORS (TC STRING)");
                }
                if (i == C0077a.LISTED_AC_NETWORKS.ordinal()) {
                    return new e("LISTED ATP NETWORKS (AC STRING)");
                }
                return new e("NON-CONFIGURABLE NETWORKS");
            }

            /* access modifiers changed from: protected */
            public List<c> gi(int i) {
                Set<String> set;
                boolean z = true;
                if (i == C0077a.MISSING_TC_NETWORKS.ordinal()) {
                    set = set6;
                } else if (i == C0077a.MISSING_AC_NETWORKS.ordinal()) {
                    set = set7;
                } else {
                    z = false;
                    if (i == C0077a.LISTED_TC_NETWORKS.ordinal()) {
                        set = set8;
                    } else {
                        set = i == C0077a.LISTED_AC_NETWORKS.ordinal() ? set9 : set10;
                    }
                }
                ArrayList arrayList = new ArrayList(set.size());
                for (String a : set) {
                    arrayList.add(a.this.b(a, z));
                }
                return arrayList;
            }
        };
        this.aqw = r0;
        r0.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("Configured CMP Networks");
        ((ListView) findViewById(R.id.listView)).setAdapter(this.aqw);
    }

    /* access modifiers changed from: private */
    public c b(String str, boolean z) {
        return c.wW().bO(str).gl(z ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK).wX();
    }
}
