package com.fyber.inneractive.sdk.player.exoplayer2.video;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.WindowManager;
import com.fyber.inneractive.sdk.config.IAConfigManager;

public final class d {
    public final a a;
    public final long b;
    public final long c;
    public long d;
    public long e;
    public long f;
    public boolean g;
    public long h;
    public long i;
    public long j;

    public static final class a implements Choreographer.FrameCallback, Handler.Callback {
        public static final a e = new a();
        public volatile long a;
        public final Handler b;
        public Choreographer c;
        public int d;

        public a() {
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper(), this);
            this.b = handler;
            handler.sendEmptyMessage(0);
        }

        public static a a() {
            return e;
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.c = Choreographer.getInstance();
                return true;
            } else if (i == 1) {
                int i2 = this.d + 1;
                this.d = i2;
                if (i2 == 1) {
                    this.c.postFrameCallback(this);
                }
                return true;
            } else if (i != 2) {
                return false;
            } else {
                int i3 = this.d - 1;
                this.d = i3;
                if (i3 == 0) {
                    this.c.removeFrameCallback(this);
                    this.a = 0;
                }
                return true;
            }
        }

        public void doFrame(long j) {
            this.a = j;
            this.c.postFrameCallbackDelayed(this, 500);
        }
    }

    public d(Context context) {
        this((double) a(), true);
    }

    public d(double d2, boolean z) {
        if (z) {
            this.a = a.a();
            long j2 = (long) (1.0E9d / d2);
            this.b = j2;
            this.c = (j2 * 80) / 100;
            return;
        }
        this.a = null;
        this.b = -1;
        this.c = -1;
    }

    public final boolean a(long j2, long j3) {
        return Math.abs((j3 - this.h) - (j2 - this.i)) > 20000000;
    }

    public static float a() {
        return ((WindowManager) IAConfigManager.M.v.a().getSystemService("window")).getDefaultDisplay().getRefreshRate();
    }
}
