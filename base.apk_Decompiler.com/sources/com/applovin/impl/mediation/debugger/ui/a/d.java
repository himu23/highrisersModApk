package com.applovin.impl.mediation.debugger.ui.a;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.applovin.impl.mediation.debugger.ui.a;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.b;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.mediation.MaxDebuggerAdUnitWaterfallsListActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

public class d extends a {
    private ListView akx;
    /* access modifiers changed from: private */
    public List<c> aqC;
    private boolean aqD;
    private com.applovin.impl.mediation.debugger.ui.d.d aqw;
    private n sdk;

    /* access modifiers changed from: protected */
    public n getSdk() {
        return this.sdk;
    }

    public void initialize(final List<com.applovin.impl.mediation.debugger.b.a.a> list, boolean z, n nVar) {
        this.aqD = z;
        this.sdk = nVar;
        this.aqC = r(list);
        AnonymousClass1 r3 = new com.applovin.impl.mediation.debugger.ui.d.d(this) {
            /* access modifiers changed from: protected */
            public int tM() {
                return 1;
            }

            /* access modifiers changed from: protected */
            public int gg(int i) {
                return list.size();
            }

            /* access modifiers changed from: protected */
            public c gh(int i) {
                return new e("");
            }

            /* access modifiers changed from: protected */
            public List<c> gi(int i) {
                return d.this.aqC;
            }
        };
        this.aqw = r3;
        r3.a(new d$$ExternalSyntheticLambda2(this, list, nVar));
        this.aqw.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(List list, n nVar, com.applovin.impl.mediation.debugger.ui.d.a aVar, c cVar) {
        com.applovin.impl.mediation.debugger.b.a.a aVar2 = (com.applovin.impl.mediation.debugger.b.a.a) list.get(aVar.wQ());
        if (aVar2.uH().size() == 1) {
            b.a(this, MaxDebuggerAdUnitDetailActivity.class, nVar.BM(), new d$$ExternalSyntheticLambda0(aVar2, nVar));
        } else {
            b.a(this, MaxDebuggerAdUnitWaterfallsListActivity.class, nVar.BM(), new d$$ExternalSyntheticLambda1(aVar2, nVar));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle((this.aqD ? "Selective Init " : "").concat("Ad Units"));
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.akx = listView;
        listView.setAdapter(this.aqw);
    }

    private List<c> r(List<com.applovin.impl.mediation.debugger.b.a.a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (com.applovin.impl.mediation.debugger.b.a.a next : list) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ID\t\t\t\t\t\t", -7829368));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(next.mQ(), ViewCompat.MEASURED_STATE_MASK));
            spannableStringBuilder.append(new SpannedString("\n"));
            spannableStringBuilder.append(StringUtils.createListItemDetailSubSpannedString("FORMAT  ", -7829368));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(next.tG(), ViewCompat.MEASURED_STATE_MASK));
            arrayList.add(c.a(c.b.DETAIL).a(StringUtils.createSpannedString(next.getName(), ViewCompat.MEASURED_STATE_MASK, 18, 1)).b(new SpannedString(spannableStringBuilder)).y(this).aF(true).wX());
        }
        return arrayList;
    }
}
