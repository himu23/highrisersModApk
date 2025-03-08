package com.fyber.inneractive.sdk.player.mediaplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.q;
import java.util.Locale;

public final class a extends MediaPlayer implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
    public Context a;
    public volatile com.fyber.inneractive.sdk.player.enums.b b = com.fyber.inneractive.sdk.player.enums.b.Idle;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public Handler h;
    public k i;
    public Surface j;
    public SurfaceHolder k;
    public long l;
    public int m = 0;
    public HandlerThread n;
    public Handler o;
    public Runnable p;
    public Runnable q;
    public int r = 0;
    public int s = 0;
    public int t = 0;

    /* renamed from: com.fyber.inneractive.sdk.player.mediaplayer.a$a  reason: collision with other inner class name */
    public class C0129a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public C0129a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public void run() {
            if (a.this.i != null) {
                String format = String.format(Locale.ENGLISH, "Player Error: %d, %d", new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b)});
                ((com.fyber.inneractive.sdk.player.controller.g) a.this.i).a((Exception) new l(format));
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            a.a(a.this);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            IAlog.a("%sCannot wait for video size anymore", a.this.c());
            a aVar = a.this;
            if (aVar.r == 0) {
                IAlog.a("%sCannot wait for video size anymore. duration is still 0 - aborting", aVar.c());
                a aVar2 = a.this;
                aVar2.onError(aVar2, 0, 0);
                return;
            }
            IAlog.a("%sCannot wait for video size anymore. moving into ready", aVar.c());
            boolean unused = a.this.f = true;
            a.this.d();
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ SurfaceHolder a;

        public d(SurfaceHolder surfaceHolder) {
            this.a = surfaceHolder;
        }

        public void run() {
            a.a(a.this, this.a);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ Surface a;

        public e(Surface surface) {
            this.a = surface;
        }

        public void run() {
            a.a(a.this, this.a);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            a.b(a.this);
            Handler handler = a.this.o;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
                a.this.o = null;
            }
            a.this.n = null;
            Looper.myLooper().quit();
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            a.this.f();
        }
    }

    public class h implements Runnable {
        public h() {
        }

        public void run() {
            a.c(a.this);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            a.d(a.this);
        }
    }

    public class j implements Runnable {
        public j() {
        }

        public void run() {
            a aVar = a.this;
            String c = aVar.c();
            long currentTimeMillis = System.currentTimeMillis();
            aVar.setVolume(0.0f, 0.0f);
            IAlog.d(c + "timelog: mute took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
        }
    }

    public interface k {
    }

    public static class l extends Exception {
        public l(String str) {
            super(str);
        }

        public l(Throwable th, String str) {
            super(str, th);
        }
    }

    public a(Context context, k kVar, Handler handler) {
        this.a = context;
        this.i = kVar;
        this.h = handler;
        setOnPreparedListener(this);
        setOnErrorListener(this);
        setOnSeekCompleteListener(this);
        setOnVideoSizeChangedListener(this);
        super.setOnCompletionListener(this);
        a();
    }

    public static void c(a aVar) {
        String c2 = aVar.c();
        long currentTimeMillis = System.currentTimeMillis();
        com.fyber.inneractive.sdk.player.enums.b bVar = aVar.b;
        if (bVar == com.fyber.inneractive.sdk.player.enums.b.Paused || bVar == com.fyber.inneractive.sdk.player.enums.b.Prepared || bVar == com.fyber.inneractive.sdk.player.enums.b.Completed || bVar == com.fyber.inneractive.sdk.player.enums.b.Start_in_progress) {
            super.start();
            aVar.a(com.fyber.inneractive.sdk.player.enums.b.Playing);
        } else {
            IAlog.a("%s Start called in wrong mState! %s", aVar.c(), bVar);
            if (aVar.b == com.fyber.inneractive.sdk.player.enums.b.Seeking) {
                aVar.c = true;
            }
        }
        IAlog.d(c2 + "timelog: start took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
    }

    public static void d(a aVar) {
        String c2 = aVar.c();
        long currentTimeMillis = System.currentTimeMillis();
        if (super.isPlaying()) {
            super.pause();
        } else {
            IAlog.a("%s paused called cannot set to pause, canceled", aVar.c());
        }
        IAlog.d(c2 + "timelog: delayed pause took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
    }

    public boolean b() {
        return (this.b == com.fyber.inneractive.sdk.player.enums.b.Idle || this.b == com.fyber.inneractive.sdk.player.enums.b.Preparing) ? false : true;
    }

    public final void f() {
        String c2 = c();
        long currentTimeMillis = System.currentTimeMillis();
        com.fyber.inneractive.sdk.player.enums.b bVar = this.b;
        com.fyber.inneractive.sdk.player.enums.b bVar2 = com.fyber.inneractive.sdk.player.enums.b.Idle;
        if (bVar == bVar2) {
            IAlog.a("%s reset called, but player is already resetted. Do nothing", c());
            return;
        }
        a(bVar2);
        try {
            super.reset();
        } catch (Exception unused) {
        }
        IAlog.d(c2 + "timelog: reset took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
    }

    public int getCurrentPosition() {
        if (b()) {
            return super.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        return this.r;
    }

    public int getVideoHeight() {
        return this.t;
    }

    public int getVideoWidth() {
        return this.s;
    }

    public boolean isPlaying() {
        return b() && this.b != com.fyber.inneractive.sdk.player.enums.b.Paused && super.isPlaying();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        a(com.fyber.inneractive.sdk.player.enums.b.Completed);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        IAlog.e("%s onError code = %d code2 = %d", c(), Integer.valueOf(i2), Integer.valueOf(i3));
        f();
        this.h.post(new C0129a(i2, i3));
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        IAlog.a("%s onPrepared %s gotPrepared = %s", c(), this, Boolean.valueOf(this.g));
        IAlog.a("%sMedia prepare time took %d msec", c(), Long.valueOf(System.currentTimeMillis() - this.l));
        if (this.b != com.fyber.inneractive.sdk.player.enums.b.Preparing && this.b != com.fyber.inneractive.sdk.player.enums.b.Seeking) {
            IAlog.e("%s onPrepared: previous error encountered. Aborting", c());
        } else if (!this.g) {
            this.g = true;
            d();
        } else {
            IAlog.a("%s onPrepared called again??? We are already prepared", c());
        }
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        IAlog.a("%s onSeekComplete called current position = %d", c(), Integer.valueOf(mediaPlayer.getCurrentPosition()));
        if (this.b != com.fyber.inneractive.sdk.player.enums.b.Seeking) {
            IAlog.a("%s onSeekComplete called when Story is not seeking", c());
            return;
        }
        if (this.d) {
            e();
        }
        if (this.c) {
            IAlog.a("%s onSeekComplete mPlayAfterSeek = true", c());
            this.b = com.fyber.inneractive.sdk.player.enums.b.Paused;
            start();
            return;
        }
        IAlog.a("%s onSeekComplete mPlayAfterSeek = false", c());
        a(com.fyber.inneractive.sdk.player.enums.b.Paused);
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        IAlog.a("%s onVideoSizeChanged %d, %d", c(), Integer.valueOf(i2), Integer.valueOf(i3));
        if (!this.f) {
            Runnable runnable = this.p;
            if (runnable != null) {
                q.b.removeCallbacks(runnable);
                IAlog.a("%s onVideoSizeChanged cancelling prepared runnable", c());
            }
            this.f = true;
            if (i2 == 0 || i3 == 0) {
                IAlog.e("%s onVideoSizeChanged - Invalid video size!", c());
                onError(this, 0, 0);
                return;
            }
            IAlog.a("%sMedia got video size time took %d msec", c(), Long.valueOf(System.currentTimeMillis() - this.l));
            this.s = i2;
            this.t = i3;
            d();
        }
    }

    public void pause() {
        com.fyber.inneractive.sdk.player.enums.b bVar;
        if (this.b == com.fyber.inneractive.sdk.player.enums.b.Idle || this.b == com.fyber.inneractive.sdk.player.enums.b.Completed || this.b == (bVar = com.fyber.inneractive.sdk.player.enums.b.Paused) || this.b == com.fyber.inneractive.sdk.player.enums.b.Prepared) {
            IAlog.a("%s paused called when player is in mState: %s ignoring", c(), this.b);
            return;
        }
        a(bVar);
        if (b()) {
            a((Runnable) new i());
        } else {
            IAlog.a("%s paused called when player is not ready!", c());
        }
        IAlog.a("%s pause", c());
    }

    public void reset() {
        IAlog.a("%s reset called", c());
        Runnable runnable = this.p;
        if (runnable != null) {
            q.b.removeCallbacks(runnable);
        }
        a((Runnable) new g());
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        IAlog.a("%s setDisplay called", c());
        if (!b()) {
            IAlog.a("%s setDisplay called when player is not ready!", c());
            return;
        }
        SurfaceHolder surfaceHolder2 = this.k;
        if (surfaceHolder2 == null || !surfaceHolder2.equals(surfaceHolder)) {
            this.k = surfaceHolder;
            a((Runnable) new d(surfaceHolder));
            return;
        }
        IAlog.a("%s setDisplay called with existing surface. ignoring!", c());
    }

    public final void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        throw new IllegalAccessError("Please use IAplayerCallbacks to receive completion events");
    }

    public void setSurface(Surface surface) {
        IAlog.a("%s setSurface called", c());
        Surface surface2 = this.j;
        if (surface2 == null || !surface2.equals(surface)) {
            this.j = surface;
            a((Runnable) new e(surface));
            return;
        }
        IAlog.a("%s setSurface called with existing surface. ignoring!", c());
    }

    public void start() {
        IAlog.a("%s Start called", c());
        if (!b()) {
            IAlog.a("%s MediaPlayer: Start called when player is not ready! - mState = %s", c(), this.b);
        } else if (this.b == com.fyber.inneractive.sdk.player.enums.b.Seeking) {
            this.c = true;
        } else if (isPlaying()) {
            IAlog.a("%s MediaPlayer: Start called when player is already playing. do nothing", c());
        } else {
            a(com.fyber.inneractive.sdk.player.enums.b.Start_in_progress);
            a((Runnable) new h());
        }
    }

    public void stop() {
        String c2 = c();
        long currentTimeMillis = System.currentTimeMillis();
        if (b()) {
            super.stop();
        }
        IAlog.a("%s stop called", c());
        IAlog.d(c2 + "timelog: stop took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
    }

    public static void b(a aVar) {
        String c2 = aVar.c();
        long currentTimeMillis = System.currentTimeMillis();
        super.release();
        IAlog.d(c2 + "timelog: release took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
    }

    public void a(String str) {
        String c2 = c();
        long currentTimeMillis = System.currentTimeMillis();
        this.f = false;
        this.g = false;
        if (isPlaying()) {
            IAlog.a("%s loadUri stopping play before refresh", c());
            stop();
        }
        this.l = System.currentTimeMillis();
        f();
        IAlog.a("%s calling setDataSource with %s", c(), str);
        try {
            setDataSource(str);
            IAlog.a("%s setDataSource succeeded, calling prepareAsync", c());
            a(com.fyber.inneractive.sdk.player.enums.b.Preparing);
            try {
                prepareAsync();
            } catch (IllegalStateException e2) {
                IAlog.b("%s prepareAsync failed with illegal mState exception: %s", c(), e2.getMessage());
                this.m++;
                if (this.m < 5) {
                    a(str);
                }
                this.m = 0;
            }
            IAlog.d(c2 + "timelog: loadUri took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
        } catch (Exception e3) {
            IAlog.b("%s error setting data source %s", c(), str);
            IAlog.b("%s exception message: %s", c(), e3.getMessage());
        }
    }

    public void e() {
        this.d = true;
        if (b()) {
            a((Runnable) new j());
        } else {
            IAlog.a("%s mute called when player is not ready!", c());
        }
        IAlog.a("%s mute", c());
    }

    public void release() {
        if (!this.e) {
            a((Runnable) new f());
        }
        this.i = null;
        this.q = null;
        this.e = true;
        IAlog.a("%s release called", c());
    }

    public final void d() {
        if (!this.g) {
            return;
        }
        if (this.f) {
            IAlog.a("%sMedia load time took %d msec", c(), Long.valueOf(System.currentTimeMillis() - this.l));
            this.r = super.getDuration();
            a(com.fyber.inneractive.sdk.player.enums.b.Prepared);
            if (this.d) {
                e();
                return;
            }
            return;
        }
        IAlog.a("%sGot prepared only, waiting for video size", c());
        if (this.p == null) {
            this.p = new c();
        }
        q.b.postDelayed(this.p, 2000);
    }

    public final String c() {
        return "mp(" + this + "): T:" + Thread.currentThread().getId() + "-" + Thread.currentThread().getName() + ": ";
    }

    public final void a() {
        HandlerThread handlerThread = new HandlerThread("MP-Worker");
        this.n = handlerThread;
        handlerThread.start();
        this.o = new Handler(this.n.getLooper());
        this.q = new b();
    }

    public final void a(com.fyber.inneractive.sdk.player.enums.b bVar) {
        IAlog.a("%s updatePlayerState - %s", c(), bVar);
        if (this.b == bVar) {
            IAlog.a("%s updatePlayerState - mState didn't change!", c());
            return;
        }
        IAlog.a("%s updatePlayerState - changing from %s to %s", c(), this.b, bVar);
        this.b = bVar;
        this.h.post(new b(this, bVar));
    }

    public static void a(a aVar, Surface surface) {
        String c2 = aVar.c();
        long currentTimeMillis = System.currentTimeMillis();
        IAlog.a("%s setSurface called with %s", aVar.c(), surface);
        try {
            super.setSurface(surface);
            if (surface == null) {
                IAlog.a("%s setSurface with null! current surface cleared", aVar.c());
            } else {
                IAlog.a("%s setSurface - replacing surface!", aVar.c());
            }
            IAlog.d(c2 + "timelog: setSurface took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
        } catch (Exception unused) {
            IAlog.a("%s super.setSurface threw exception!", aVar.c());
        }
    }

    public static void a(a aVar, SurfaceHolder surfaceHolder) {
        String c2 = aVar.c();
        long currentTimeMillis = System.currentTimeMillis();
        IAlog.a("%s setDisplay called with %s", aVar.c(), surfaceHolder);
        try {
            super.setDisplay(surfaceHolder);
            if (surfaceHolder == null) {
                IAlog.a("%s setDisplay with null! current display cleared", aVar.c());
            } else {
                IAlog.a("%s setDisplay - replacing surface holder!", aVar.c());
            }
            IAlog.d(c2 + "timelog: setDisplayInternal took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
        } catch (Exception unused) {
            IAlog.a("%s super.setDisplay threw exception!", aVar.c());
        }
    }

    public final void a(Runnable runnable) {
        Handler handler;
        Handler handler2;
        HandlerThread handlerThread = this.n;
        if (handlerThread != null && handlerThread.isAlive() && !this.n.isInterrupted() && (handler2 = this.o) != null) {
            handler2.post(runnable);
        }
        if ((this.s == 0 || this.t == 0 || this.r == 0) && (handler = this.o) != null) {
            handler.post(this.q);
        }
    }

    public static void a(a aVar) {
        if (aVar.b()) {
            aVar.s = super.getVideoWidth();
            aVar.t = super.getVideoHeight();
            aVar.r = super.getDuration();
        }
    }
}
