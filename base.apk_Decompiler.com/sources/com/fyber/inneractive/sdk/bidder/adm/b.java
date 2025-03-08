package com.fyber.inneractive.sdk.bidder.adm;

import android.util.Base64;
import com.fyber.inneractive.sdk.bidder.adm.f;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.flow.t;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.q;

public class b implements Runnable {
    public final /* synthetic */ f.a a;
    public final /* synthetic */ s b;
    public final /* synthetic */ f c;

    public class a implements Runnable {
        public final /* synthetic */ Exception a;

        public a(Exception exc) {
            this.a = exc;
        }

        public void run() {
            f.a aVar = b.this.a;
            if (aVar != null) {
                ((t.a) aVar).a(this.a, InneractiveErrorCode.INVALID_INPUT, new e[0]);
            }
        }
    }

    public b(f fVar, f.a aVar, s sVar) {
        this.c = fVar;
        this.a = aVar;
        this.b = sVar;
    }

    public void run() {
        f.a aVar;
        try {
            byte[] decode = Base64.decode(this.c.b, 0);
            this.c.a = AdmParametersOuterClass$AdmParameters.parseFrom(decode);
            if (!(this.c.a == null || (aVar = this.a) == null)) {
                ((t.a) aVar).a();
            }
            f.a(this.c, this.a, this.b);
        } catch (Exception e) {
            IAlog.e("failed to parse ad markup payload %s", e.getMessage());
            q.b.post(new a(e));
        }
    }
}
