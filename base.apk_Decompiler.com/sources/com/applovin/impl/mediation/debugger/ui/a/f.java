package com.applovin.impl.mediation.debugger.ui.a;

import android.os.Bundle;
import android.widget.ListView;
import com.applovin.impl.mediation.debugger.ui.a;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

public class f extends a {
    private String aqI;
    private d aqw;
    private n sdk;

    /* access modifiers changed from: protected */
    public n getSdk() {
        return this.sdk;
    }

    public void initialize(String str, List<String> list, n nVar) {
        this.aqI = str;
        this.sdk = nVar;
        final List<c> s = s(list);
        AnonymousClass1 r2 = new d(this) {
            /* access modifiers changed from: protected */
            public List<c> gi(int i) {
                return s;
            }

            /* access modifiers changed from: protected */
            public int tM() {
                return 1;
            }

            /* access modifiers changed from: protected */
            public int gg(int i) {
                return s.size();
            }

            /* access modifiers changed from: protected */
            public c gh(int i) {
                return new e("KEYWORDS");
            }
        };
        this.aqw = r2;
        r2.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle(this.aqI);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(this.aqw);
        listView.setDividerHeight(0);
    }

    private List<c> s(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String replace : list) {
            arrayList.add(c.a(c.b.DETAIL).bO(replace.replace("1:", "+").replace("0:", "-")).wX());
        }
        return arrayList;
    }
}
