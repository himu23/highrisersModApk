package com.applovin.exoplayer2.l;

import android.os.Handler;
import android.os.Message;
import com.applovin.exoplayer2.l.o;
import java.util.ArrayList;
import java.util.List;

final class ae implements o {
    private static final List<a> acO = new ArrayList(50);
    private final Handler jS;

    public ae(Handler handler) {
        this.jS = handler;
    }

    public boolean fq(int i) {
        return this.jS.hasMessages(i);
    }

    public o.a fr(int i) {
        return pP().a(this.jS.obtainMessage(i), this);
    }

    public o.a c(int i, Object obj) {
        return pP().a(this.jS.obtainMessage(i, obj), this);
    }

    public o.a j(int i, int i2, int i3) {
        return pP().a(this.jS.obtainMessage(i, i2, i3), this);
    }

    public o.a a(int i, int i2, int i3, Object obj) {
        return pP().a(this.jS.obtainMessage(i, i2, i3, obj), this);
    }

    public boolean a(o.a aVar) {
        return ((a) aVar).a(this.jS);
    }

    public boolean fs(int i) {
        return this.jS.sendEmptyMessage(i);
    }

    public boolean k(int i, long j) {
        return this.jS.sendEmptyMessageAtTime(i, j);
    }

    public void ft(int i) {
        this.jS.removeMessages(i);
    }

    public void Q(Object obj) {
        this.jS.removeCallbacksAndMessages(obj);
    }

    public boolean e(Runnable runnable) {
        return this.jS.post(runnable);
    }

    private static a pP() {
        a aVar;
        List<a> list = acO;
        synchronized (list) {
            if (list.isEmpty()) {
                aVar = new a();
            } else {
                aVar = list.remove(list.size() - 1);
            }
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public static void a(a aVar) {
        List<a> list = acO;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(aVar);
            }
        }
    }

    private static final class a implements o.a {
        private Message acP;
        private ae acQ;

        public a a(Message message, ae aeVar) {
            this.acP = message;
            this.acQ = aeVar;
            return this;
        }

        private a() {
        }

        public boolean a(Handler handler) {
            boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) a.checkNotNull(this.acP));
            recycle();
            return sendMessageAtFrontOfQueue;
        }

        public void oY() {
            ((Message) a.checkNotNull(this.acP)).sendToTarget();
            recycle();
        }

        private void recycle() {
            this.acP = null;
            this.acQ = null;
            ae.a(this);
        }
    }
}
