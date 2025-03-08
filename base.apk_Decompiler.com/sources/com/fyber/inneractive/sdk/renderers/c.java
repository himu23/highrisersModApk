package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.global.features.r;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.d0;
import com.fyber.inneractive.sdk.flow.e;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.flow.g0;
import com.fyber.inneractive.sdk.ignite.k;
import com.fyber.inneractive.sdk.player.c;
import com.fyber.inneractive.sdk.player.controller.b;
import com.fyber.inneractive.sdk.player.h;
import com.fyber.inneractive.sdk.player.ui.j;
import com.fyber.inneractive.sdk.response.g;

public class c extends n {
    public boolean d = false;

    public c(h hVar) {
        super(hVar);
    }

    public com.fyber.inneractive.sdk.player.ui.h a(Context context, s sVar) {
        boolean z;
        e eVar;
        f0 f0Var;
        k kVar;
        r rVar;
        if (this.b == null) {
            if (!(sVar == null || (rVar = (r) sVar.a(r.class)) == null)) {
                this.d = rVar.a("use_video_design", false);
            }
            com.fyber.inneractive.sdk.player.e eVar2 = this.c;
            if (eVar2 == null || (f0Var = eVar2.e) == null) {
                eVar = null;
                z = false;
            } else {
                e eVar3 = new e(f0Var.a, f0Var.b, sVar);
                com.fyber.inneractive.sdk.player.e eVar4 = this.c;
                T t = eVar4.e.b;
                if (t != null) {
                    kVar = ((g) t).F;
                } else {
                    kVar = k.NONE;
                }
                eVar = eVar3;
                z = eVar4.a(sVar, kVar);
            }
            if (this.d) {
                this.b = new j(context, eVar, new com.fyber.inneractive.sdk.player.ui.e(), sVar, z, b());
            } else {
                this.b = new com.fyber.inneractive.sdk.player.ui.k(context, eVar, new com.fyber.inneractive.sdk.player.ui.e(), sVar, z, b());
            }
        }
        return this.b;
    }

    public boolean c() {
        this.c.getClass();
        return false;
    }

    public b a(InneractiveAdSpot inneractiveAdSpot, f0 f0Var) {
        if (this.a == null) {
            InneractiveUnitController selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
            boolean isOverlayOutside = selectedUnitController instanceof g0 ? ((g0) selectedUnitController).isOverlayOutside() : false;
            Skip a = inneractiveAdSpot instanceof d0 ? ((d0) inneractiveAdSpot).a() : null;
            if (this.d) {
                this.a = new com.fyber.inneractive.sdk.player.controller.e(this.c, (j) this.b, inneractiveAdSpot.getAdContent().d, f0Var.c, false, isOverlayOutside, a, f0Var.h(), b(), a());
            } else {
                this.a = new com.fyber.inneractive.sdk.player.controller.e(this.c, (com.fyber.inneractive.sdk.player.ui.k) this.b, inneractiveAdSpot.getAdContent().d, f0Var.c, false, isOverlayOutside, a, f0Var.h(), b(), a());
            }
        }
        return this.a;
    }

    public void a(c.C0106c cVar) {
        com.fyber.inneractive.sdk.player.e eVar = this.c;
        eVar.getClass();
        cVar.a(eVar);
    }
}
