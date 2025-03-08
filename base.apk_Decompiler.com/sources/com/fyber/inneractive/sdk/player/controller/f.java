package com.fyber.inneractive.sdk.player.controller;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.fyber.inneractive.sdk.player.c;
import com.fyber.inneractive.sdk.player.controller.g;
import com.fyber.inneractive.sdk.player.enums.b;
import com.fyber.inneractive.sdk.util.IAlog;

public class f implements TextureView.SurfaceTextureListener {
    public final /* synthetic */ g a;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            g gVar = f.this.a;
            g.C0109g gVar2 = gVar.d;
            if (gVar2 != null) {
                TextureView textureView = gVar.j;
                m mVar = (m) gVar2;
                mVar.a.d.post(new l(mVar));
            }
        }
    }

    public f(g gVar) {
        this.a = gVar;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        g gVar = this.a;
        gVar.getClass();
        IAlog.a("%sonSurfaceTextureAvailable", IAlog.a((Object) gVar));
        g gVar2 = this.a;
        boolean z = !surfaceTexture.equals(gVar2.k);
        gVar2.k = surfaceTexture;
        if (gVar2.l == null || z) {
            gVar2.l = new Surface(gVar2.k);
        }
        gVar2.a(gVar2.l);
        g gVar3 = this.a;
        g.C0109g gVar4 = gVar3.d;
        if (gVar4 != null) {
            TextureView textureView = gVar3.j;
            n nVar = ((m) gVar4).a;
            nVar.getClass();
            IAlog.a("%sonSurfaceTextureAvailable", IAlog.a((Object) nVar));
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        g gVar = this.a;
        gVar.getClass();
        IAlog.a("%s onSurfaceTextureDestroyed", IAlog.a((Object) gVar));
        this.a.k();
        this.a.a((Surface) null);
        boolean unused = this.a.o = true;
        g gVar2 = this.a;
        b bVar = gVar2.e;
        if (bVar == b.Completed || bVar == b.Error || bVar == b.Idle) {
            gVar2.getClass();
            IAlog.a("%sReleasing surface texture", IAlog.a((Object) gVar2));
            this.a.k = null;
            return true;
        }
        gVar2.getClass();
        IAlog.a("%s caching surface texture", IAlog.a((Object) gVar2));
        g gVar3 = this.a;
        gVar3.k = surfaceTexture;
        gVar3.i.post(new a());
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Surface surface;
        c cVar;
        g gVar;
        g.C0109g gVar2 = this.a.d;
        if (!(gVar2 == null || (cVar = ((m) gVar2).a.a) == null || (gVar = cVar.b) == null)) {
            gVar.i.post(new i(gVar));
        }
        g gVar3 = this.a;
        if (gVar3.o && (surface = gVar3.l) != null) {
            gVar3.a(surface);
            boolean unused = this.a.o = false;
        }
    }
}
