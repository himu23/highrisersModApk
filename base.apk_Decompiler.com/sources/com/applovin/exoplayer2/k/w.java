package com.applovin.exoplayer2.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.applovin.exoplayer2.l.ah;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class w {
    public static final b aaV = c(false, -9223372036854775807L);
    public static final b aaW = c(true, -9223372036854775807L);
    public static final b aaX = new b(2, -9223372036854775807L);
    public static final b aaY = new b(3, -9223372036854775807L);
    /* access modifiers changed from: private */
    public final ExecutorService aaZ;
    /* access modifiers changed from: private */
    public c<? extends d> aba;
    /* access modifiers changed from: private */
    public IOException abb;

    public interface a<T extends d> {
        b a(T t, long j, long j2, IOException iOException, int i);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    public interface d {
        void lq();

        void lr() throws IOException;
    }

    public interface e {
        void ld();
    }

    public boolean kO() {
        return this.aba != null;
    }

    public void oA() {
        this.abb = null;
    }

    public boolean oz() {
        return this.abb != null;
    }

    public static final class g extends IOException {
        public g(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public static final class b {
        /* access modifiers changed from: private */
        public final long abc;
        /* access modifiers changed from: private */
        public final int bs;

        public boolean oC() {
            int i = this.bs;
            return i == 0 || i == 1;
        }

        private b(int i, long j) {
            this.bs = i;
            this.abc = j;
        }
    }

    public w(String str) {
        this.aaZ = ai.bi("ExoPlayer:Loader:" + str);
    }

    public static b c(boolean z, long j) {
        return new b(z ? 1 : 0, j);
    }

    public <T extends d> long a(T t, a<T> aVar, int i) {
        this.abb = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new c((Looper) com.applovin.exoplayer2.l.a.N(Looper.myLooper()), t, aVar, i, elapsedRealtime).bn(0);
        return elapsedRealtime;
    }

    public void oB() {
        ((c) com.applovin.exoplayer2.l.a.N(this.aba)).ar(false);
    }

    public void a(e eVar) {
        c<? extends d> cVar = this.aba;
        if (cVar != null) {
            cVar.ar(true);
        }
        if (eVar != null) {
            this.aaZ.execute(new f(eVar));
        }
        this.aaZ.shutdown();
    }

    public void dK(int i) throws IOException {
        IOException iOException = this.abb;
        if (iOException == null) {
            c<? extends d> cVar = this.aba;
            if (cVar != null) {
                if (i == Integer.MIN_VALUE) {
                    i = cVar.abd;
                }
                cVar.dK(i);
                return;
            }
            return;
        }
        throw iOException;
    }

    private final class c<T extends d> extends Handler implements Runnable {
        public final int abd;
        private final T abe;
        private a<T> abf;
        private IOException abg;
        private Thread abh;
        private boolean abi;
        private volatile boolean cw;
        private final long sC;
        private int sE;

        public c(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.abe = t;
            this.abf = aVar;
            this.abd = i;
            this.sC = j;
        }

        public void dK(int i) throws IOException {
            IOException iOException = this.abg;
            if (iOException != null && this.sE > i) {
                throw iOException;
            }
        }

        public void bn(long j) {
            com.applovin.exoplayer2.l.a.checkState(w.this.aba == null);
            c unused = w.this.aba = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                oD();
            }
        }

        public void ar(boolean z) {
            this.cw = z;
            this.abg = null;
            if (hasMessages(0)) {
                this.abi = true;
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.abi = true;
                    this.abe.lq();
                    Thread thread = this.abh;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ((a) com.applovin.exoplayer2.l.a.checkNotNull(this.abf)).a(this.abe, elapsedRealtime, elapsedRealtime - this.sC, true);
                this.abf = null;
            }
        }

        public void run() {
            boolean z;
            try {
                synchronized (this) {
                    z = !this.abi;
                    this.abh = Thread.currentThread();
                }
                if (z) {
                    ah.bg("load:" + this.abe.getClass().getSimpleName());
                    this.abe.lr();
                    ah.pV();
                }
                synchronized (this) {
                    this.abh = null;
                    Thread.interrupted();
                }
                if (!this.cw) {
                    sendEmptyMessage(1);
                }
            } catch (IOException e) {
                if (!this.cw) {
                    obtainMessage(2, e).sendToTarget();
                }
            } catch (Exception e2) {
                if (!this.cw) {
                    q.c("LoadTask", "Unexpected exception loading stream", e2);
                    obtainMessage(2, new g(e2)).sendToTarget();
                }
            } catch (OutOfMemoryError e3) {
                if (!this.cw) {
                    q.c("LoadTask", "OutOfMemory error loading stream", e3);
                    obtainMessage(2, new g(e3)).sendToTarget();
                }
            } catch (Error e4) {
                if (!this.cw) {
                    q.c("LoadTask", "Unexpected error loading stream", e4);
                    obtainMessage(3, e4).sendToTarget();
                }
                throw e4;
            } catch (Throwable th) {
                ah.pV();
                throw th;
            }
        }

        public void handleMessage(Message message) {
            long j;
            if (!this.cw) {
                if (message.what == 0) {
                    oD();
                } else if (message.what != 3) {
                    finish();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j2 = elapsedRealtime - this.sC;
                    a aVar = (a) com.applovin.exoplayer2.l.a.checkNotNull(this.abf);
                    if (this.abi) {
                        aVar.a(this.abe, elapsedRealtime, j2, false);
                        return;
                    }
                    int i = message.what;
                    if (i == 1) {
                        try {
                            aVar.a(this.abe, elapsedRealtime, j2);
                        } catch (RuntimeException e) {
                            q.c("LoadTask", "Unexpected exception handling load completed", e);
                            IOException unused = w.this.abb = new g(e);
                        }
                    } else if (i == 2) {
                        IOException iOException = (IOException) message.obj;
                        this.abg = iOException;
                        int i2 = this.sE + 1;
                        this.sE = i2;
                        b a = aVar.a(this.abe, elapsedRealtime, j2, iOException, i2);
                        if (a.bs == 3) {
                            IOException unused2 = w.this.abb = this.abg;
                        } else if (a.bs != 2) {
                            if (a.bs == 1) {
                                this.sE = 1;
                            }
                            if (a.abc != -9223372036854775807L) {
                                j = a.abc;
                            } else {
                                j = oE();
                            }
                            bn(j);
                        }
                    }
                } else {
                    throw ((Error) message.obj);
                }
            }
        }

        private void oD() {
            this.abg = null;
            w.this.aaZ.execute((Runnable) com.applovin.exoplayer2.l.a.checkNotNull(w.this.aba));
        }

        private void finish() {
            c unused = w.this.aba = null;
        }

        private long oE() {
            return (long) Math.min((this.sE - 1) * 1000, 5000);
        }
    }

    private static final class f implements Runnable {
        private final e abk;

        public f(e eVar) {
            this.abk = eVar;
        }

        public void run() {
            this.abk.ld();
        }
    }
}
