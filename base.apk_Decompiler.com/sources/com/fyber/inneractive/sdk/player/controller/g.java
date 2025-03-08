package com.fyber.inneractive.sdk.player.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.player.mediaplayer.a;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class g implements a.k {
    public final Context a;
    public final List<f> b = new CopyOnWriteArrayList();
    public final List<e> c = new CopyOnWriteArrayList();
    public C0109g d;
    public com.fyber.inneractive.sdk.player.enums.b e = com.fyber.inneractive.sdk.player.enums.b.Idle;
    public d f;
    public boolean g;
    public com.fyber.inneractive.sdk.player.d h;
    public final Handler i;
    public TextureView j;
    public SurfaceTexture k;
    public Surface l;
    public TextureView.SurfaceTextureListener m;
    public boolean n = false;
    public boolean o;

    public class a implements Runnable {
        public final /* synthetic */ Exception a;

        public a(Exception exc) {
            this.a = exc;
        }

        public void run() {
            g gVar = g.this;
            if (!gVar.g) {
                try {
                    for (f a2 : gVar.b) {
                        a2.a(this.a);
                    }
                } catch (Exception e) {
                    if (IAlog.a <= 3) {
                        g gVar2 = g.this;
                        gVar2.getClass();
                        IAlog.a("%sonPlayerError callback threw an exception!", e, IAlog.a((Object) gVar2));
                    }
                }
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        public void run() {
            try {
                for (e a2 : g.this.c) {
                    a2.a(this.a);
                }
            } catch (Exception e) {
                if (IAlog.a <= 3) {
                    g gVar = g.this;
                    gVar.getClass();
                    IAlog.a("%sonPlayerProgress callback threw an exception!", e, IAlog.a((Object) gVar));
                }
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ com.fyber.inneractive.sdk.player.enums.b a;

        public c(com.fyber.inneractive.sdk.player.enums.b bVar) {
            this.a = bVar;
        }

        public void run() {
            g gVar;
            TextureView textureView;
            TextureView textureView2;
            TextureView textureView3;
            try {
                for (f a2 : g.this.b) {
                    a2.a(this.a);
                }
                com.fyber.inneractive.sdk.player.enums.b bVar = this.a;
                if (bVar == com.fyber.inneractive.sdk.player.enums.b.Idle || bVar == com.fyber.inneractive.sdk.player.enums.b.Error || bVar == com.fyber.inneractive.sdk.player.enums.b.Completed) {
                    g gVar2 = g.this;
                    if (!(gVar2.k == null || (textureView3 = gVar2.j) == null || textureView3.getParent() == null)) {
                        ((ViewGroup) g.this.j.getParent()).removeView(g.this.j);
                    }
                    gVar = g.this;
                    gVar.j = null;
                    gVar.k = null;
                }
            } catch (Exception e) {
                if (IAlog.a <= 3) {
                    g gVar3 = g.this;
                    gVar3.getClass();
                    IAlog.a("%sonPlayerStateChanged callback threw an exception!", e, IAlog.a((Object) gVar3));
                }
                com.fyber.inneractive.sdk.player.enums.b bVar2 = this.a;
                if (bVar2 == com.fyber.inneractive.sdk.player.enums.b.Idle || bVar2 == com.fyber.inneractive.sdk.player.enums.b.Error || bVar2 == com.fyber.inneractive.sdk.player.enums.b.Completed) {
                    g gVar4 = g.this;
                    if (!(gVar4.k == null || (textureView = gVar4.j) == null || textureView.getParent() == null)) {
                        ((ViewGroup) g.this.j.getParent()).removeView(g.this.j);
                    }
                    gVar = g.this;
                    gVar.j = null;
                }
            } catch (Throwable th) {
                com.fyber.inneractive.sdk.player.enums.b bVar3 = this.a;
                if (bVar3 == com.fyber.inneractive.sdk.player.enums.b.Idle || bVar3 == com.fyber.inneractive.sdk.player.enums.b.Error || bVar3 == com.fyber.inneractive.sdk.player.enums.b.Completed) {
                    g gVar5 = g.this;
                    if (!(gVar5.k == null || (textureView2 = gVar5.j) == null || textureView2.getParent() == null)) {
                        ((ViewGroup) g.this.j.getParent()).removeView(g.this.j);
                    }
                    g gVar6 = g.this;
                    gVar6.j = null;
                    gVar6.k = null;
                }
                throw th;
            }
        }
    }

    public interface d {
    }

    public interface e {
        void a(int i);
    }

    public interface f {
        void a(com.fyber.inneractive.sdk.player.enums.b bVar);

        void a(Exception exc);

        void e(boolean z);

        void g();
    }

    /* renamed from: com.fyber.inneractive.sdk.player.controller.g$g  reason: collision with other inner class name */
    public interface C0109g {
    }

    public g(Context context) {
        this.a = context.getApplicationContext();
        this.i = new Handler(context.getMainLooper());
        this.h = new com.fyber.inneractive.sdk.player.d(this);
        a(true);
    }

    public abstract void a(int i2, boolean z);

    public abstract void a(Surface surface);

    public abstract void a(String str, int i2);

    public abstract void a(boolean z);

    public abstract boolean a();

    public abstract void b(boolean z);

    public abstract int c();

    public abstract int d();

    public abstract void d(boolean z);

    public abstract Bitmap e();

    public abstract String f();

    public abstract int g();

    public abstract int h();

    public abstract boolean i();

    public boolean j() {
        return this.e == com.fyber.inneractive.sdk.player.enums.b.Playing;
    }

    public abstract void k();

    public abstract void l();

    public void a(Exception exc) {
        a(com.fyber.inneractive.sdk.player.enums.b.Error);
        IAlog.a("%sonPlayerError called with: %s for onPlayerError", IAlog.a((Object) this), exc);
        this.i.post(new a(exc));
        m();
    }

    public void b() {
        IAlog.a("%sdestroy started", IAlog.a((Object) this));
        m();
        this.h = null;
        this.i.removeCallbacksAndMessages((Object) null);
        this.b.clear();
        this.f = null;
        this.g = true;
        IAlog.a("%sdestroy finished", IAlog.a((Object) this));
    }

    public final void c(boolean z) {
        com.fyber.inneractive.sdk.measurement.d dVar;
        d dVar2 = this.f;
        if (dVar2 != null && (dVar = com.fyber.inneractive.sdk.player.c.this.h) != null) {
            if (z) {
                if (dVar.c != null) {
                    IAlog.a("%s mute", "OMVideo");
                    try {
                        dVar.c.volumeChange(0.0f);
                    } catch (Throwable th) {
                        dVar.a(th);
                    }
                }
            } else if (dVar.c != null) {
                IAlog.a("%s unMute", "OMVideo");
                try {
                    dVar.c.volumeChange(1.0f);
                } catch (Throwable th2) {
                    dVar.a(th2);
                }
            }
        }
    }

    public void m() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        com.fyber.inneractive.sdk.player.d dVar = this.h;
        if (dVar != null && (scheduledThreadPoolExecutor = dVar.b) != null) {
            scheduledThreadPoolExecutor.shutdownNow();
            dVar.b = null;
        }
    }

    public void a(int i2) {
        this.i.post(new b(i2));
    }

    public void a(com.fyber.inneractive.sdk.player.enums.b bVar) {
        if (bVar != this.e) {
            this.e = bVar;
            if (bVar == com.fyber.inneractive.sdk.player.enums.b.Playing) {
                com.fyber.inneractive.sdk.player.d dVar = this.h;
                if (dVar != null && dVar.b == null) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
                    dVar.b = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.scheduleAtFixedRate(dVar.c, (long) 100, (long) 1000, TimeUnit.MILLISECONDS);
                }
            } else if (bVar == com.fyber.inneractive.sdk.player.enums.b.Paused || bVar == com.fyber.inneractive.sdk.player.enums.b.Idle || bVar == com.fyber.inneractive.sdk.player.enums.b.Completed) {
                m();
            }
            this.i.post(new c(bVar));
        }
    }
}
