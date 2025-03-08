package com.applovin.exoplayer2.h;

import android.os.Handler;
import com.applovin.exoplayer2.h;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.v;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public interface q {

    /* renamed from: com.applovin.exoplayer2.h.q$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$a(q _this, int i, p.a aVar, j jVar, m mVar) {
        }

        public static void $default$a(q _this, int i, p.a aVar, j jVar, m mVar, IOException iOException, boolean z) {
        }

        public static void $default$a(q _this, int i, p.a aVar, m mVar) {
        }

        public static void $default$b(q _this, int i, p.a aVar, j jVar, m mVar) {
        }

        public static void $default$c(q _this, int i, p.a aVar, j jVar, m mVar) {
        }
    }

    void a(int i, p.a aVar, j jVar, m mVar);

    void a(int i, p.a aVar, j jVar, m mVar, IOException iOException, boolean z);

    void a(int i, p.a aVar, m mVar);

    void b(int i, p.a aVar, j jVar, m mVar);

    void c(int i, p.a aVar, j jVar, m mVar);

    public static class a {
        private final long LN;
        public final int cN;
        public final p.a jj;
        private final CopyOnWriteArrayList<C0049a> tg;

        public a() {
            this(new CopyOnWriteArrayList(), 0, (p.a) null, 0);
        }

        private a(CopyOnWriteArrayList<C0049a> copyOnWriteArrayList, int i, p.a aVar, long j) {
            this.tg = copyOnWriteArrayList;
            this.cN = i;
            this.jj = aVar;
            this.LN = j;
        }

        public a b(int i, p.a aVar, long j) {
            return new a(this.tg, i, aVar, j);
        }

        public void a(Handler handler, q qVar) {
            com.applovin.exoplayer2.l.a.checkNotNull(handler);
            com.applovin.exoplayer2.l.a.checkNotNull(qVar);
            this.tg.add(new C0049a(handler, qVar));
        }

        public void a(q qVar) {
            Iterator<C0049a> it = this.tg.iterator();
            while (it.hasNext()) {
                C0049a next = it.next();
                if (next.LO == qVar) {
                    this.tg.remove(next);
                }
            }
        }

        public void a(j jVar, int i, int i2, v vVar, int i3, Object obj, long j, long j2) {
            j jVar2 = jVar;
            a(jVar, new m(i, i2, vVar, i3, obj, aW(j), aW(j2)));
        }

        public void a(j jVar, m mVar) {
            Iterator<C0049a> it = this.tg.iterator();
            while (it.hasNext()) {
                C0049a next = it.next();
                ai.a(next.jS, (Runnable) new q$a$$ExternalSyntheticLambda2(this, next.LO, jVar, mVar));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(q qVar, j jVar, m mVar) {
            qVar.a(this.cN, this.jj, jVar, mVar);
        }

        public void b(j jVar, int i, int i2, v vVar, int i3, Object obj, long j, long j2) {
            j jVar2 = jVar;
            b(jVar, new m(i, i2, vVar, i3, obj, aW(j), aW(j2)));
        }

        public void b(j jVar, m mVar) {
            Iterator<C0049a> it = this.tg.iterator();
            while (it.hasNext()) {
                C0049a next = it.next();
                ai.a(next.jS, (Runnable) new q$a$$ExternalSyntheticLambda4(this, next.LO, jVar, mVar));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(q qVar, j jVar, m mVar) {
            qVar.b(this.cN, this.jj, jVar, mVar);
        }

        public void c(j jVar, int i, int i2, v vVar, int i3, Object obj, long j, long j2) {
            j jVar2 = jVar;
            c(jVar, new m(i, i2, vVar, i3, obj, aW(j), aW(j2)));
        }

        public void c(j jVar, m mVar) {
            Iterator<C0049a> it = this.tg.iterator();
            while (it.hasNext()) {
                C0049a next = it.next();
                ai.a(next.jS, (Runnable) new q$a$$ExternalSyntheticLambda3(this, next.LO, jVar, mVar));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(q qVar, j jVar, m mVar) {
            qVar.c(this.cN, this.jj, jVar, mVar);
        }

        public void a(j jVar, int i, int i2, v vVar, int i3, Object obj, long j, long j2, IOException iOException, boolean z) {
            j jVar2 = jVar;
            a(jVar, new m(i, i2, vVar, i3, obj, aW(j), aW(j2)), iOException, z);
        }

        public void a(j jVar, m mVar, IOException iOException, boolean z) {
            Iterator<C0049a> it = this.tg.iterator();
            while (it.hasNext()) {
                C0049a next = it.next();
                ai.a(next.jS, (Runnable) new q$a$$ExternalSyntheticLambda0(this, next.LO, jVar, mVar, iOException, z));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(q qVar, j jVar, m mVar, IOException iOException, boolean z) {
            qVar.a(this.cN, this.jj, jVar, mVar, iOException, z);
        }

        public void a(int i, v vVar, int i2, Object obj, long j) {
            b(new m(1, i, vVar, i2, obj, aW(j), -9223372036854775807L));
        }

        public void b(m mVar) {
            Iterator<C0049a> it = this.tg.iterator();
            while (it.hasNext()) {
                C0049a next = it.next();
                ai.a(next.jS, (Runnable) new q$a$$ExternalSyntheticLambda1(this, next.LO, mVar));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(q qVar, m mVar) {
            qVar.a(this.cN, this.jj, mVar);
        }

        private long aW(long j) {
            long f = h.f(j);
            if (f == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.LN + f;
        }

        /* renamed from: com.applovin.exoplayer2.h.q$a$a  reason: collision with other inner class name */
        private static final class C0049a {
            public q LO;
            public Handler jS;

            public C0049a(Handler handler, q qVar) {
                this.jS = handler;
                this.LO = qVar;
            }
        }
    }
}
