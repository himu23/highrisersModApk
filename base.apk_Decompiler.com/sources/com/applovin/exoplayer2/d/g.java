package com.applovin.exoplayer2.d;

import android.os.Handler;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.l.ai;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public interface g {

    /* renamed from: com.applovin.exoplayer2.d.g$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$a(g _this, int i, p.a aVar) {
        }

        public static void $default$a(g _this, int i, p.a aVar, int i2) {
        }

        public static void $default$a(g _this, int i, p.a aVar, Exception exc) {
        }

        public static void $default$b(g _this, int i, p.a aVar) {
        }

        public static void $default$c(g _this, int i, p.a aVar) {
        }

        public static void $default$d(g _this, int i, p.a aVar) {
        }

        @Deprecated
        public static void $default$g(g _this, int i, p.a aVar) {
        }
    }

    void a(int i, p.a aVar);

    void a(int i, p.a aVar, int i2);

    void a(int i, p.a aVar, Exception exc);

    void b(int i, p.a aVar);

    void c(int i, p.a aVar);

    void d(int i, p.a aVar);

    @Deprecated
    void g(int i, p.a aVar);

    public static class a {
        public final int cN;
        public final p.a jj;
        private final CopyOnWriteArrayList<C0037a> tg;

        public a() {
            this(new CopyOnWriteArrayList(), 0, (p.a) null);
        }

        private a(CopyOnWriteArrayList<C0037a> copyOnWriteArrayList, int i, p.a aVar) {
            this.tg = copyOnWriteArrayList;
            this.cN = i;
            this.jj = aVar;
        }

        public a h(int i, p.a aVar) {
            return new a(this.tg, i, aVar);
        }

        public void a(Handler handler, g gVar) {
            com.applovin.exoplayer2.l.a.checkNotNull(handler);
            com.applovin.exoplayer2.l.a.checkNotNull(gVar);
            this.tg.add(new C0037a(handler, gVar));
        }

        public void a(g gVar) {
            Iterator<C0037a> it = this.tg.iterator();
            while (it.hasNext()) {
                C0037a next = it.next();
                if (next.th == gVar) {
                    this.tg.remove(next);
                }
            }
        }

        public void bF(int i) {
            Iterator<C0037a> it = this.tg.iterator();
            while (it.hasNext()) {
                C0037a next = it.next();
                ai.a(next.jS, (Runnable) new g$a$$ExternalSyntheticLambda2(this, next.th, i));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(g gVar, int i) {
            gVar.g(this.cN, this.jj);
            gVar.a(this.cN, this.jj, i);
        }

        public void hG() {
            Iterator<C0037a> it = this.tg.iterator();
            while (it.hasNext()) {
                C0037a next = it.next();
                ai.a(next.jS, (Runnable) new g$a$$ExternalSyntheticLambda4(this, next.th));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(g gVar) {
            gVar.a(this.cN, this.jj);
        }

        public void j(Exception exc) {
            Iterator<C0037a> it = this.tg.iterator();
            while (it.hasNext()) {
                C0037a next = it.next();
                ai.a(next.jS, (Runnable) new g$a$$ExternalSyntheticLambda1(this, next.th, exc));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(g gVar, Exception exc) {
            gVar.a(this.cN, this.jj, exc);
        }

        public void hH() {
            Iterator<C0037a> it = this.tg.iterator();
            while (it.hasNext()) {
                C0037a next = it.next();
                ai.a(next.jS, (Runnable) new g$a$$ExternalSyntheticLambda5(this, next.th));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(g gVar) {
            gVar.b(this.cN, this.jj);
        }

        public void hI() {
            Iterator<C0037a> it = this.tg.iterator();
            while (it.hasNext()) {
                C0037a next = it.next();
                ai.a(next.jS, (Runnable) new g$a$$ExternalSyntheticLambda0(this, next.th));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(g gVar) {
            gVar.c(this.cN, this.jj);
        }

        public void hJ() {
            Iterator<C0037a> it = this.tg.iterator();
            while (it.hasNext()) {
                C0037a next = it.next();
                ai.a(next.jS, (Runnable) new g$a$$ExternalSyntheticLambda3(this, next.th));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(g gVar) {
            gVar.d(this.cN, this.jj);
        }

        /* renamed from: com.applovin.exoplayer2.d.g$a$a  reason: collision with other inner class name */
        private static final class C0037a {
            public Handler jS;
            public g th;

            public C0037a(Handler handler, g gVar) {
                this.jS = handler;
                this.th = gVar;
            }
        }
    }
}
