package com.applovin.exoplayer2.l;

import android.os.Looper;
import android.os.Message;
import com.applovin.exoplayer2.l.m;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class p<T> {
    private final b<T> acd;
    private final ArrayDeque<Runnable> ace;
    private final ArrayDeque<Runnable> acf;
    private final d bR;
    private final o cm;
    private boolean cw;
    private final CopyOnWriteArraySet<c<T>> hv;

    public interface a<T> {
        void invoke(T t);
    }

    public interface b<T> {
        void invoke(T t, m mVar);
    }

    public p(Looper looper, d dVar, b<T> bVar) {
        this(new CopyOnWriteArraySet(), looper, dVar, bVar);
    }

    private p(CopyOnWriteArraySet<c<T>> copyOnWriteArraySet, Looper looper, d dVar, b<T> bVar) {
        this.bR = dVar;
        this.hv = copyOnWriteArraySet;
        this.acd = bVar;
        this.ace = new ArrayDeque<>();
        this.acf = new ArrayDeque<>();
        this.cm = dVar.a(looper, new p$$ExternalSyntheticLambda0(this));
    }

    public p<T> a(Looper looper, b<T> bVar) {
        return new p<>(this.hv, looper, this.bR, bVar);
    }

    public void add(T t) {
        if (!this.cw) {
            a.checkNotNull(t);
            this.hv.add(new c(t));
        }
    }

    public void O(T t) {
        Iterator<c<T>> it = this.hv.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.acg.equals(t)) {
                next.a(this.acd);
                this.hv.remove(next);
            }
        }
    }

    public void a(int i, a<T> aVar) {
        this.acf.add(new p$$ExternalSyntheticLambda1(new CopyOnWriteArraySet(this.hv), i, aVar));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(CopyOnWriteArraySet copyOnWriteArraySet, int i, a aVar) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((c) it.next()).c(i, aVar);
        }
    }

    public void oZ() {
        if (!this.acf.isEmpty()) {
            if (!this.cm.fq(0)) {
                o oVar = this.cm;
                oVar.a(oVar.fr(0));
            }
            boolean z = !this.ace.isEmpty();
            this.ace.addAll(this.acf);
            this.acf.clear();
            if (!z) {
                while (!this.ace.isEmpty()) {
                    this.ace.peekFirst().run();
                    this.ace.removeFirst();
                }
            }
        }
    }

    public void b(int i, a<T> aVar) {
        a(i, aVar);
        oZ();
    }

    public void release() {
        Iterator<c<T>> it = this.hv.iterator();
        while (it.hasNext()) {
            it.next().a(this.acd);
        }
        this.hv.clear();
        this.cw = true;
    }

    /* access modifiers changed from: private */
    public boolean handleMessage(Message message) {
        Iterator<c<T>> it = this.hv.iterator();
        while (it.hasNext()) {
            it.next().b(this.acd);
            if (this.cm.fq(0)) {
                return true;
            }
        }
        return true;
    }

    private static final class c<T> {
        public final T acg;
        private boolean ach;
        private boolean cw;
        private m.a gJ = new m.a();

        public c(T t) {
            this.acg = t;
        }

        public void a(b<T> bVar) {
            this.cw = true;
            if (this.ach) {
                bVar.invoke(this.acg, this.gJ.oV());
            }
        }

        public void c(int i, a<T> aVar) {
            if (!this.cw) {
                if (i != -1) {
                    this.gJ.fo(i);
                }
                this.ach = true;
                aVar.invoke(this.acg);
            }
        }

        public void b(b<T> bVar) {
            if (!this.cw && this.ach) {
                m oV = this.gJ.oV();
                this.gJ = new m.a();
                this.ach = false;
                bVar.invoke(this.acg, oV);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.acg.equals(((c) obj).acg);
        }

        public int hashCode() {
            return this.acg.hashCode();
        }
    }
}
