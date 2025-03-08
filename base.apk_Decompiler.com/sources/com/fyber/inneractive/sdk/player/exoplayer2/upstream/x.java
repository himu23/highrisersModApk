package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.util.s;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class x {
    public final ExecutorService a;
    public b<? extends c> b;
    public IOException c;

    public interface a<T extends c> {
        int a(T t, long j, long j2, IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    public final class b<T extends c> extends Handler implements Runnable {
        public final T a;
        public final a<T> b;
        public final int c;
        public final long d;
        public IOException e;
        public int f;
        public volatile Thread g;
        public volatile boolean h;

        public void run() {
            try {
                this.g = Thread.currentThread();
                if (!this.a.a()) {
                    s.a("load:" + this.a.getClass().getSimpleName());
                    this.a.load();
                    s.a();
                }
                if (!this.h) {
                    sendEmptyMessage(2);
                }
            } catch (IOException e2) {
                if (!this.h) {
                    obtainMessage(3, e2).sendToTarget();
                }
            } catch (InterruptedException unused) {
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.a.a());
                if (!this.h) {
                    sendEmptyMessage(2);
                }
            } catch (Exception e3) {
                Log.e("LoadTask", "Unexpected exception loading stream", e3);
                if (!this.h) {
                    obtainMessage(3, new d(e3)).sendToTarget();
                }
            } catch (OutOfMemoryError e4) {
                Log.e("LoadTask", "OutOfMemory error loading stream", e4);
                if (!this.h) {
                    obtainMessage(3, new d(e4)).sendToTarget();
                }
            } catch (Error e5) {
                Log.e("LoadTask", "Unexpected error loading stream", e5);
                if (!this.h) {
                    obtainMessage(4, e5).sendToTarget();
                }
                throw e5;
            } catch (Throwable th) {
                s.a();
                throw th;
            }
        }

        public b(Looper looper, T t, a<T> aVar, int i2, long j) {
            super(looper);
            this.a = t;
            this.b = aVar;
            this.c = i2;
            this.d = j;
        }

        public void a(long j) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(x.this.b == null);
            x xVar = x.this;
            xVar.b = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
                return;
            }
            this.e = null;
            xVar.a.execute(this);
        }

        public void handleMessage(Message message) {
            if (!this.h) {
                int i2 = message.what;
                if (i2 == 0) {
                    this.e = null;
                    x xVar = x.this;
                    xVar.a.execute(xVar.b);
                } else if (i2 != 4) {
                    x.this.b = null;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j = elapsedRealtime - this.d;
                    if (this.a.a()) {
                        this.b.a(this.a, elapsedRealtime, j, false);
                        return;
                    }
                    int i3 = message.what;
                    if (i3 == 1) {
                        this.b.a(this.a, elapsedRealtime, j, false);
                    } else if (i3 == 2) {
                        this.b.a(this.a, elapsedRealtime, j);
                    } else if (i3 == 3) {
                        IOException iOException = (IOException) message.obj;
                        this.e = iOException;
                        int a2 = this.b.a(this.a, elapsedRealtime, j, iOException);
                        if (a2 == 3) {
                            x.this.c = this.e;
                        } else if (a2 != 2) {
                            int i4 = a2 == 1 ? 1 : this.f + 1;
                            this.f = i4;
                            a((long) Math.min((i4 - 1) * 1000, 5000));
                        }
                    }
                } else {
                    throw ((Error) message.obj);
                }
            }
        }

        public void a(boolean z) {
            this.h = z;
            this.e = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.a.b();
                if (this.g != null) {
                    this.g.interrupt();
                }
            }
            if (z) {
                x.this.b = null;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.b.a(this.a, elapsedRealtime, elapsedRealtime - this.d, true);
            }
        }
    }

    public interface c {
        boolean a();

        void b();

        void load() throws IOException, InterruptedException;
    }

    public static final class d extends IOException {
        public d(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public x(String str) {
        this.a = u.b(str);
    }

    public <T extends c> long a(T t, a<T> aVar, int i) {
        Looper myLooper = Looper.myLooper();
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(myLooper, t, aVar, i, elapsedRealtime).a(0);
        return elapsedRealtime;
    }

    public boolean b() {
        return this.b != null;
    }

    public void d() {
        b<? extends c> bVar = this.b;
        if (bVar != null) {
            bVar.a(true);
        }
        this.a.shutdown();
    }

    public void a() {
        this.b.a(false);
    }

    public void c() throws IOException {
        IOException iOException = this.c;
        if (iOException == null) {
            b<? extends c> bVar = this.b;
            if (bVar != null) {
                int i = bVar.c;
                IOException iOException2 = bVar.e;
                if (iOException2 != null && bVar.f > i) {
                    throw iOException2;
                }
                return;
            }
            return;
        }
        throw iOException;
    }
}
