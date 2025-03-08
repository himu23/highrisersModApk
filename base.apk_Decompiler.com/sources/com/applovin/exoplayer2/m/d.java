package com.applovin.exoplayer2.m;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.applovin.exoplayer2.l.j;
import com.applovin.exoplayer2.l.n;
import com.applovin.exoplayer2.l.q;

public final class d extends Surface {
    private static int ado;
    private static boolean adp;
    public final boolean Hu;
    private final a adq;
    private boolean adr;

    public static synchronized boolean p(Context context) {
        boolean z;
        synchronized (d.class) {
            z = true;
            if (!adp) {
                ado = q(context);
                adp = true;
            }
            if (ado == 0) {
                z = false;
            }
        }
        return z;
    }

    public static d c(Context context, boolean z) {
        int i = 0;
        com.applovin.exoplayer2.l.a.checkState(!z || p(context));
        a aVar = new a();
        if (z) {
            i = ado;
        }
        return aVar.fP(i);
    }

    private d(a aVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.adq = aVar;
        this.Hu = z;
    }

    public void release() {
        super.release();
        synchronized (this.adq) {
            if (!this.adr) {
                this.adq.release();
                this.adr = true;
            }
        }
    }

    private static int q(Context context) {
        if (n.j(context)) {
            return n.oW() ? 1 : 2;
        }
        return 0;
    }

    private static class a extends HandlerThread implements Handler.Callback {
        private j ads;
        private Error adt;
        private RuntimeException adu;
        private d adv;
        private Handler jS;

        public a() {
            super("ExoPlayer:DummySurface");
        }

        public d fP(int i) {
            boolean z;
            start();
            this.jS = new Handler(getLooper(), this);
            this.ads = new j(this.jS);
            synchronized (this) {
                z = false;
                this.jS.obtainMessage(1, i, 0).sendToTarget();
                while (this.adv == null && this.adu == null && this.adt == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.adu;
            if (runtimeException == null) {
                Error error = this.adt;
                if (error == null) {
                    return (d) com.applovin.exoplayer2.l.a.checkNotNull(this.adv);
                }
                throw error;
            }
            throw runtimeException;
        }

        public void release() {
            com.applovin.exoplayer2.l.a.checkNotNull(this.jS);
            this.jS.sendEmptyMessage(2);
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                try {
                    fQ(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e) {
                    q.c("DummySurface", "Failed to initialize dummy surface", e);
                    this.adu = e;
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e2) {
                    try {
                        q.c("DummySurface", "Failed to initialize dummy surface", e2);
                        this.adt = e2;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Throwable th) {
                        synchronized (this) {
                            notify();
                            throw th;
                        }
                    }
                }
                return true;
            } else if (i != 2) {
                return true;
            } else {
                try {
                    bt();
                } catch (Throwable th2) {
                    quit();
                    throw th2;
                }
                quit();
                return true;
            }
        }

        private void fQ(int i) {
            com.applovin.exoplayer2.l.a.checkNotNull(this.ads);
            this.ads.fm(i);
            this.adv = new d(this, this.ads.oR(), i != 0);
        }

        private void bt() {
            com.applovin.exoplayer2.l.a.checkNotNull(this.ads);
            this.ads.release();
        }
    }
}
