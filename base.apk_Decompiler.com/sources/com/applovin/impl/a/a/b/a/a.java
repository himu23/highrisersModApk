package com.applovin.impl.a.a.b.a;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.applovin.creative.MaxCreativeDebuggerDisplayedAdActivity;
import com.applovin.impl.a.a.b.a.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.sdk.utils.b;
import com.applovin.sdk.R;

public class a extends Activity {
    /* access modifiers changed from: private */
    public b akj;
    private FrameLayout akw;
    private ListView akx;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Creative Debugger");
        setContentView(R.layout.mediation_debugger_list_view);
        this.akw = (FrameLayout) findViewById(16908290);
        this.akx = (ListView) findViewById(R.id.listView);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        b bVar = this.akj;
        if (bVar == null) {
            finish();
            return;
        }
        this.akx.setAdapter(bVar);
        b bVar2 = this.akj;
        if (bVar2 == null || bVar2.getSdk().Co().isCreativeDebuggerEnabled()) {
            b bVar3 = this.akj;
            if (bVar3 != null && bVar3.tK()) {
                gf(R.string.applovin_creative_debugger_no_ads_text);
                return;
            }
            return;
        }
        gf(R.string.applovin_creative_debugger_disabled_text);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        b bVar = this.akj;
        if (bVar != null) {
            bVar.a((d.a) null);
            this.akj.tJ();
        }
    }

    public void a(b bVar, final com.applovin.impl.sdk.a aVar) {
        this.akj = bVar;
        bVar.a(new d.a() {
            public void onClick(final com.applovin.impl.mediation.debugger.ui.d.a aVar, c cVar) {
                if (aVar.wP() == b.a.RECENT_ADS.ordinal()) {
                    com.applovin.impl.sdk.utils.b.a(a.this, MaxCreativeDebuggerDisplayedAdActivity.class, aVar, new b.a<MaxCreativeDebuggerDisplayedAdActivity>() {
                        /* renamed from: a */
                        public void onActivityCreated(MaxCreativeDebuggerDisplayedAdActivity maxCreativeDebuggerDisplayedAdActivity) {
                            maxCreativeDebuggerDisplayedAdActivity.a(a.this.akj.tL().get(aVar.wQ()), a.this.akj.getSdk());
                        }
                    });
                }
            }
        });
    }

    private void gf(int i) {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        textView.setTextSize(18.0f);
        textView.setText(i);
        this.akw.addView(textView, new FrameLayout.LayoutParams(-1, -1, 17));
        this.akw.bringChildToFront(textView);
    }
}
