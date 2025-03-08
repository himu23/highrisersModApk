package com.applovin.impl.mediation.debugger.ui.testmode;

import android.os.Bundle;
import android.text.SpannedString;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.mediation.debugger.ui.a;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b extends a {
    private ListView akx;
    /* access modifiers changed from: private */
    public d aqw;
    private List<com.applovin.impl.mediation.debugger.b.c.b> are;
    /* access modifiers changed from: private */
    public List<c> auk;
    /* access modifiers changed from: private */
    public n sdk;

    /* access modifiers changed from: protected */
    public n getSdk() {
        return this.sdk;
    }

    public b() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    public void initialize(final List<com.applovin.impl.mediation.debugger.b.c.b> list, final n nVar) {
        this.sdk = nVar;
        this.are = list;
        this.auk = B(list);
        AnonymousClass1 r0 = new d(this) {
            /* access modifiers changed from: protected */
            public int tM() {
                return 1;
            }

            /* access modifiers changed from: protected */
            public c xa() {
                return new c.a(c.b.SECTION_CENTERED).bO("Select a network to load test ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").wX();
            }

            /* access modifiers changed from: protected */
            public int gg(int i) {
                return list.size();
            }

            /* access modifiers changed from: protected */
            public c gh(int i) {
                return new e("TEST MODE NETWORKS");
            }

            /* access modifiers changed from: protected */
            public List<c> gi(int i) {
                return b.this.auk;
            }
        };
        this.aqw = r0;
        r0.a(new d.a() {
            public void onClick(com.applovin.impl.mediation.debugger.ui.d.a aVar, c cVar) {
                List singletonList = Collections.singletonList(((com.applovin.impl.mediation.debugger.b.c.b) list.get(aVar.wQ())).getName());
                if (singletonList.equals(nVar.CE().xk())) {
                    nVar.CE().C((List<String>) null);
                } else {
                    nVar.CE().C(singletonList);
                }
                b.this.aqw.notifyDataSetChanged();
            }
        });
        this.aqw.notifyDataSetChanged();
    }

    private List<c> B(List<com.applovin.impl.mediation.debugger.b.c.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (final com.applovin.impl.mediation.debugger.b.c.b next : list) {
            arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.a(this, next) {
                public SpannedString wU() {
                    return StringUtils.createSpannedString(next.getDisplayName(), isEnabled() ? ViewCompat.MEASURED_STATE_MASK : -7829368, 18, 1);
                }

                public int tO() {
                    if (Collections.singletonList(next.getName()).equals(b.this.sdk.CE().xk())) {
                        return R.drawable.applovin_ic_check_mark_borderless;
                    }
                    return 0;
                }

                public int tP() {
                    if (Collections.singletonList(next.getName()).equals(b.this.sdk.CE().xk())) {
                        return -16776961;
                    }
                    return super.tP();
                }
            });
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Test Mode Network");
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.akx = listView;
        listView.setAdapter(this.aqw);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.auk = B(this.are);
        this.aqw.notifyDataSetChanged();
    }
}
