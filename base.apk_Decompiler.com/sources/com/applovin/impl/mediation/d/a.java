package com.applovin.impl.mediation.d;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.b.f;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import java.util.List;

public class a extends d {
    private final Activity ahM;
    private final List<f> alZ;

    public a(List<f> list, Activity activity, n nVar) {
        super("TaskAutoInitAdapters", nVar, true);
        this.alZ = list;
        this.ahM = activity;
    }

    public void run() {
        if (this.alZ.size() > 0) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str = this.tag;
                StringBuilder sb = new StringBuilder("Auto-initing ");
                sb.append(this.alZ.size());
                sb.append(" adapters");
                sb.append(this.sdk.CE().isEnabled() ? " in test mode" : "");
                sb.append("...");
                xVar2.f(str, sb.toString());
            }
            if (TextUtils.isEmpty(this.sdk.getMediationProvider())) {
                this.sdk.setMediationProvider("max");
            } else if (!this.sdk.Br()) {
                x.H("AppLovinSdk", "Auto-initing adapters for non-MAX mediation provider: " + this.sdk.getMediationProvider());
            }
            if (this.ahM == null) {
                x.H("AppLovinSdk", "\n**********\nAttempting to init 3rd-party SDKs without an Activity instance.\n**********\n");
            }
            for (f a__externalsyntheticlambda0 : this.alZ) {
                this.sdk.BO().h(new a$$ExternalSyntheticLambda0(this, a__externalsyntheticlambda0));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(f fVar) {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Auto-initing adapter: " + fVar);
        }
        this.sdk.Cx().a(fVar, this.ahM);
    }
}
