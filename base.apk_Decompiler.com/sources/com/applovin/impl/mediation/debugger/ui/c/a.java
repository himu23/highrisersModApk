package com.applovin.impl.mediation.debugger.ui.c;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.mediation.debugger.b.c.b;
import com.applovin.impl.mediation.debugger.ui.c.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.b;
import com.applovin.impl.sdk.utils.u;
import com.applovin.mediation.MaxDebuggerMultiAdActivity;
import com.applovin.sdk.R;

public class a extends com.applovin.impl.mediation.debugger.ui.a {
    private ListView akx;
    /* access modifiers changed from: private */
    public b arY;

    public a() {
        this.communicatorTopics.add("adapter_initialization_status");
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    public void initialize(final b bVar) {
        setTitle(bVar.getDisplayName());
        b bVar2 = new b(bVar, this);
        this.arY = bVar2;
        bVar2.a(new d.a() {
            public void onClick(com.applovin.impl.mediation.debugger.ui.d.a aVar, c cVar) {
                if (aVar.wP() == b.a.TEST_ADS.ordinal()) {
                    n sdk = bVar.getSdk();
                    b.C0073b vn = bVar.vn();
                    if (!a.this.arY.a(aVar)) {
                        u.a(cVar.wk(), cVar.vQ(), (Context) a.this);
                    } else if (b.C0073b.READY == vn) {
                        com.applovin.impl.sdk.utils.b.a(a.this, MaxDebuggerMultiAdActivity.class, sdk.BM(), new b.a<MaxDebuggerMultiAdActivity>() {
                            /* renamed from: a */
                            public void onActivityCreated(MaxDebuggerMultiAdActivity maxDebuggerMultiAdActivity) {
                                maxDebuggerMultiAdActivity.initialize(bVar);
                            }
                        });
                    } else if (b.C0073b.DISABLED == vn) {
                        sdk.CE().xl();
                        u.a(cVar.wk(), cVar.vQ(), (Context) a.this);
                    } else {
                        u.a(cVar.wk(), cVar.vQ(), (Context) a.this);
                    }
                } else {
                    u.a(cVar.wk(), cVar.vQ(), (Context) a.this);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.akx = listView;
        listView.setAdapter(this.arY);
    }

    /* access modifiers changed from: protected */
    public n getSdk() {
        b bVar = this.arY;
        if (bVar != null) {
            return bVar.wA().getSdk();
        }
        return null;
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (this.arY.wA().vt().equals(appLovinCommunicatorMessage.getMessageData().getString("adapter_class", ""))) {
            this.arY.wI();
            this.arY.wZ();
        }
    }
}
