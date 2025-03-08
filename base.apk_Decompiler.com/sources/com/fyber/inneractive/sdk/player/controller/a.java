package com.fyber.inneractive.sdk.player.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.fyber.inneractive.sdk.player.controller.g;
import com.fyber.inneractive.sdk.player.enums.b;
import com.fyber.inneractive.sdk.player.mediaplayer.c;
import com.fyber.inneractive.sdk.player.mediaplayer.d;
import com.fyber.inneractive.sdk.util.IAlog;
import com.ironsource.m2;

public class a extends g {
    public com.fyber.inneractive.sdk.player.mediaplayer.a p;
    public int q = 0;
    public int r = 2;
    public int s = 0;
    public boolean t = false;

    public a(Context context) {
        super(context);
        IAlog.a("Creating IAAndroidMediaPlayerController", new Object[0]);
    }

    public boolean a() {
        return false;
    }

    public void d(boolean z) {
        c(false);
        if (i() || !this.n) {
            this.n = z;
            com.fyber.inneractive.sdk.player.mediaplayer.a aVar = this.p;
            if (aVar != null) {
                IAlog.a("%s unmute", aVar.c());
                aVar.d = false;
                if (aVar.b()) {
                    aVar.a((Runnable) new d(aVar));
                    return;
                }
                IAlog.a("%s unmute called when player is not ready!", aVar.c());
            }
        }
    }

    public Bitmap e() {
        return null;
    }

    public String f() {
        return m2.h.I0;
    }

    public void a(int i, boolean z) {
        com.fyber.inneractive.sdk.player.mediaplayer.a aVar = this.p;
        if (aVar != null) {
            IAlog.a("%s seek to called with = %d mPlayAfterSeek = %s", aVar.c(), Integer.valueOf(i), Boolean.valueOf(z));
            if (!aVar.b()) {
                IAlog.a("%s seek called when player is not ready!", aVar.c());
                return;
            }
            b bVar = aVar.b;
            b bVar2 = b.Seeking;
            if (bVar == bVar2) {
                IAlog.a("%s seek called when player is already seeking!", aVar.c());
                return;
            }
            aVar.a(bVar2);
            aVar.c = z;
            aVar.a((Runnable) new c(aVar, i));
        }
    }

    public void b() {
        com.fyber.inneractive.sdk.player.mediaplayer.a aVar = this.p;
        if (aVar != null) {
            aVar.reset();
            this.p.release();
            this.p = null;
        }
        super.b();
    }

    public int c() {
        com.fyber.inneractive.sdk.player.mediaplayer.a aVar = this.p;
        if (aVar != null) {
            return aVar.getCurrentPosition();
        }
        return 0;
    }

    public int g() {
        com.fyber.inneractive.sdk.player.mediaplayer.a aVar = this.p;
        if (aVar != null) {
            return aVar.t;
        }
        return 0;
    }

    public int h() {
        com.fyber.inneractive.sdk.player.mediaplayer.a aVar = this.p;
        if (aVar != null) {
            return aVar.s;
        }
        return 0;
    }

    public boolean i() {
        com.fyber.inneractive.sdk.player.mediaplayer.a aVar = this.p;
        if (aVar != null) {
            return aVar.d;
        }
        return false;
    }

    public void k() {
        com.fyber.inneractive.sdk.player.mediaplayer.a aVar = this.p;
        if (aVar != null) {
            aVar.pause();
        }
    }

    public void l() {
        com.fyber.inneractive.sdk.player.mediaplayer.a aVar = this.p;
        if (aVar != null) {
            aVar.start();
        }
    }

    public void b(boolean z) {
        c(true);
        if (!i() || !this.n) {
            this.n = z;
            com.fyber.inneractive.sdk.player.mediaplayer.a aVar = this.p;
            if (aVar != null) {
                aVar.e();
            }
        }
    }

    public void a(Surface surface) {
        com.fyber.inneractive.sdk.player.mediaplayer.a aVar = this.p;
        if (aVar != null) {
            aVar.setSurface(surface);
        }
    }

    public void a(boolean z) {
        if (this.p == null) {
            IAlog.a("MediaPlayerController: creating media player", new Object[0]);
            this.p = new com.fyber.inneractive.sdk.player.mediaplayer.a(this.a, this, this.i);
        }
    }

    public int d() {
        com.fyber.inneractive.sdk.player.mediaplayer.a aVar = this.p;
        if (aVar != null) {
            return aVar.r;
        }
        return 0;
    }

    public void a(String str, int i) {
        this.p.a(str);
    }

    public void a(int i) {
        this.i.post(new g.b(i));
        if (i >= d()) {
            a(b.Completed);
        } else if (i == this.q) {
            IAlog.a("%sVideo is stuck! Progress doesn't change", IAlog.a((Object) this));
            int i2 = this.s + 1;
            this.s = i2;
            if (i2 == this.r) {
                a(b.Buffering);
                this.t = true;
            }
        } else if (this.t) {
            IAlog.a("%sVideo progress was stuck! but now it goes forward. Remove buffering state", IAlog.a((Object) this));
            a(b.Playing);
            this.s = 0;
            this.t = false;
        }
        this.q = i;
    }
}
