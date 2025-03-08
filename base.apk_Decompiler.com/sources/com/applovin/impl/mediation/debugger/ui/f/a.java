package com.applovin.impl.mediation.debugger.ui.f;

import android.os.Bundle;
import android.text.SpannedString;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

public class a extends com.applovin.impl.mediation.debugger.ui.a {
    private ListView akx;
    /* access modifiers changed from: private */
    public List<c> aqn;
    /* access modifiers changed from: private */
    public List<c> aqo;
    private d aqw;
    private List<com.applovin.impl.mediation.debugger.b.a.c> atC;
    private List<com.applovin.impl.mediation.debugger.b.a.c> atD;
    /* access modifiers changed from: private */
    public n sdk;

    /* renamed from: com.applovin.impl.mediation.debugger.ui.f.a$a  reason: collision with other inner class name */
    enum C0079a {
        BIDDERS,
        WATERFALL,
        COUNT
    }

    /* access modifiers changed from: protected */
    public n getSdk() {
        return this.sdk;
    }

    public a() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    public void initialize(List<com.applovin.impl.mediation.debugger.b.a.c> list, List<com.applovin.impl.mediation.debugger.b.a.c> list2, n nVar) {
        this.sdk = nVar;
        this.atC = list;
        this.atD = list2;
        this.aqn = B(list);
        this.aqo = B(list2);
        AnonymousClass1 r1 = new d(this) {
            /* access modifiers changed from: protected */
            public c xa() {
                return new c.a(c.b.SECTION_CENTERED).bO("Select a network to load ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").wX();
            }

            /* access modifiers changed from: protected */
            public int tM() {
                return C0079a.COUNT.ordinal();
            }

            /* access modifiers changed from: protected */
            public int gg(int i) {
                if (i == C0079a.BIDDERS.ordinal()) {
                    return a.this.aqn.size();
                }
                return a.this.aqo.size();
            }

            /* access modifiers changed from: protected */
            public c gh(int i) {
                if (i == C0079a.BIDDERS.ordinal()) {
                    return new e("BIDDERS");
                }
                return new e("WATERFALL");
            }

            /* access modifiers changed from: protected */
            public List<c> gi(int i) {
                if (i == C0079a.BIDDERS.ordinal()) {
                    return a.this.aqn;
                }
                return a.this.aqo;
            }
        };
        this.aqw = r1;
        r1.a(new a$$ExternalSyntheticLambda0(this, nVar));
        this.aqw.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(n nVar, com.applovin.impl.mediation.debugger.ui.d.a aVar, c cVar) {
        List<String> uO = b(aVar).uO();
        if (uO.equals(nVar.CE().xk())) {
            nVar.CE().C((List<String>) null);
        } else {
            nVar.CE().C(uO);
        }
        this.aqw.notifyDataSetChanged();
    }

    private List<c> B(List<com.applovin.impl.mediation.debugger.b.a.c> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (final com.applovin.impl.mediation.debugger.b.a.c next : list) {
            arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.a(next.uP(), this) {
                public SpannedString wU() {
                    return StringUtils.createSpannedString(next.getDisplayName(), isEnabled() ? ViewCompat.MEASURED_STATE_MASK : -7829368, 18, 1);
                }

                public int tO() {
                    if (a.this.sdk.CE().xk() == null || !a.this.sdk.CE().xk().equals(next.uO())) {
                        return 0;
                    }
                    return R.drawable.applovin_ic_check_mark_borderless;
                }

                public int tP() {
                    if (a.this.sdk.CE().xk() == null || !a.this.sdk.CE().xk().equals(next.uO())) {
                        return super.tP();
                    }
                    return -16776961;
                }
            });
        }
        return arrayList;
    }

    private com.applovin.impl.mediation.debugger.b.a.c b(com.applovin.impl.mediation.debugger.ui.d.a aVar) {
        if (aVar.wP() == C0079a.BIDDERS.ordinal()) {
            return this.atC.get(aVar.wQ());
        }
        return this.atD.get(aVar.wQ());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Live Network");
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.akx = listView;
        listView.setAdapter(this.aqw);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.aqn = B(this.atC);
        this.aqo = B(this.atD);
        this.aqw.wZ();
    }
}
