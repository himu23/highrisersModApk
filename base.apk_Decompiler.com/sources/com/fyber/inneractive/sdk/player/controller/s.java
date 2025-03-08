package com.fyber.inneractive.sdk.player.controller;

import android.view.View;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.f0;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.model.vast.c;
import com.fyber.inneractive.sdk.model.vast.t;
import com.fyber.inneractive.sdk.player.e;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.web.b;
import com.fyber.inneractive.sdk.web.i;

public class s extends i.n {
    public final /* synthetic */ n a;

    public s(n nVar) {
        this.a = nVar;
    }

    public void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        n nVar = this.a;
        nVar.getClass();
        sb.append(IAlog.a((Object) nVar));
        sb.append("web view callback: onSuspiciousNoUserWebActionDetected");
        IAlog.a(sb.toString(), new Object[0]);
        ListenerT listenert = this.a.g;
        if (listenert != null) {
            listenert.a(str, str2);
        }
    }

    public void b() {
        ListenerT listenert = this.a.g;
        if (listenert != null) {
            listenert.j();
        }
    }

    public void c() {
        c c;
        n nVar = this.a;
        nVar.getClass();
        IAlog.a("%sweb view callback: onClickedAndOpen", IAlog.a((Object) nVar));
        this.a.a(f0.b.COMPANION.value);
        n nVar2 = this.a;
        if (nVar2.g != null) {
            com.fyber.inneractive.sdk.player.c cVar = nVar2.a;
            if (!(cVar == null || (c = cVar.c()) == null)) {
                this.a.a.a((com.fyber.inneractive.sdk.response.i) c, VideoClickOrigin.COMPANION, t.EVENT_CLICK);
            }
            int i = IAlog.a;
            IAlog.a(1, (Exception) null, "AD_CLICKED", new Object[0]);
            this.a.g.g();
        }
    }

    public void b(i iVar) {
        ListenerT listenert = this.a.g;
        if (listenert != null) {
            listenert.s();
        }
    }

    public b0.a a(String str, p0 p0Var, b.a aVar) {
        n nVar = this.a;
        nVar.getClass();
        IAlog.a("%sweb view callback: onClicked", IAlog.a((Object) nVar));
        this.a.a(f0.b.COMPANION.value);
        n nVar2 = this.a;
        if (nVar2.g == null) {
            return new b0.a(b0.d.FAILED, new Exception("mListener is null, internal SDK fatal error"), "null");
        }
        com.fyber.inneractive.sdk.player.c cVar = nVar2.a;
        if (cVar != null) {
            c c = cVar.c();
            if (c != null) {
                this.a.a.a((com.fyber.inneractive.sdk.response.i) c, VideoClickOrigin.COMPANION, t.EVENT_CLICK);
            } else if (n.a(this.a)) {
                com.fyber.inneractive.sdk.player.c cVar2 = this.a.a;
                e eVar = (e) cVar2;
                eVar.a(eVar.v, VideoClickOrigin.COMPANION, t.EVENT_CLICK);
            }
        }
        int i = IAlog.a;
        IAlog.a(1, (Exception) null, "AD_CLICKED", new Object[0]);
        this.a.m();
        return this.a.g.a(str, p0Var, aVar, false);
    }

    public boolean a(String str) {
        View endCardView = this.a.d.getEndCardView();
        ListenerT listenert = this.a.g;
        if (listenert == null) {
            return false;
        }
        listenert.a(endCardView, str);
        return true;
    }

    public void a(InneractiveUnitController.AdDisplayError adDisplayError) {
        ListenerT listenert = this.a.g;
        if (listenert != null) {
            listenert.onPlayerError();
        }
    }

    public void a(i iVar) {
        ListenerT listenert = this.a.g;
        if (listenert != null) {
            listenert.s();
        }
    }

    public void a(i iVar, com.fyber.inneractive.sdk.mraid.b0 b0Var) {
        ListenerT listenert = this.a.g;
        if (listenert != null) {
            listenert.k();
        }
    }

    public void a(i iVar, boolean z) {
        n nVar = this.a;
        nVar.getClass();
        IAlog.a("%sonCustomCloseButtonAvailableEnabled : %s", IAlog.a((Object) nVar), Boolean.valueOf(z));
        ListenerT listenert = this.a.g;
        if (listenert != null && z) {
            listenert.h();
        }
    }

    public void a(i iVar, boolean z, Orientation orientation) {
        n nVar = this.a;
        nVar.getClass();
        IAlog.a("%sonOrientationProperties: allowOrientationChange: %s, forceOrientationType: %s", IAlog.a((Object) nVar), Boolean.valueOf(z), orientation.toString());
        ListenerT listenert = this.a.g;
        if (listenert != null) {
            listenert.a(z, orientation);
        }
    }
}
