package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import android.content.res.Resources;
import com.fyber.inneractive.sdk.config.global.features.r;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.e;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.flow.g0;
import com.fyber.inneractive.sdk.ignite.k;
import com.fyber.inneractive.sdk.player.c;
import com.fyber.inneractive.sdk.player.controller.b;
import com.fyber.inneractive.sdk.player.h;
import com.fyber.inneractive.sdk.player.ui.j;
import com.fyber.inneractive.sdk.response.g;

public class a extends n {
    public boolean d = false;

    public a(h hVar) {
        super(hVar);
    }

    public com.fyber.inneractive.sdk.player.ui.h a(Context context, s sVar) throws Resources.NotFoundException {
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
                this.b = new j(context, eVar, new com.fyber.inneractive.sdk.player.ui.g(), sVar, z, b());
            } else {
                this.b = new com.fyber.inneractive.sdk.player.ui.k(context, eVar, new com.fyber.inneractive.sdk.player.ui.g(), sVar, z, b());
            }
        }
        return this.b;
    }

    public void a(c.C0106c cVar) {
    }

    public boolean c() {
        this.c.getClass();
        return false;
    }

    public b a(InneractiveAdSpot inneractiveAdSpot, f0 f0Var) {
        if (this.a == null) {
            InneractiveUnitController selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
            boolean isOverlayOutside = selectedUnitController instanceof g0 ? ((g0) selectedUnitController).isOverlayOutside() : false;
            if (this.d) {
                this.a = new com.fyber.inneractive.sdk.player.controller.j(this.c, (j) this.b, com.fyber.inneractive.sdk.config.a.b(inneractiveAdSpot.getAdContent().d().m), f0Var.c, isOverlayOutside, b(), a());
            } else {
                this.a = new com.fyber.inneractive.sdk.player.controller.j(this.c, (com.fyber.inneractive.sdk.player.ui.k) this.b, com.fyber.inneractive.sdk.config.a.b(inneractiveAdSpot.getAdContent().d().m), f0Var.c, isOverlayOutside, b(), a());
            }
        }
        return this.a;
    }
}
