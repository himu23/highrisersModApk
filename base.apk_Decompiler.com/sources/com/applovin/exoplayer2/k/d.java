package com.applovin.exoplayer2.k;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public interface d {
    void a(Handler handler, a aVar);

    void a(a aVar);

    aa od();

    public interface a {
        void b(int i, long j, long j2);

        /* renamed from: com.applovin.exoplayer2.k.d$a$a  reason: collision with other inner class name */
        public static final class C0059a {
            private final CopyOnWriteArrayList<C0060a> Zl = new CopyOnWriteArrayList<>();

            public void b(Handler handler, a aVar) {
                com.applovin.exoplayer2.l.a.checkNotNull(handler);
                com.applovin.exoplayer2.l.a.checkNotNull(aVar);
                b(aVar);
                this.Zl.add(new C0060a(handler, aVar));
            }

            public void b(a aVar) {
                Iterator<C0060a> it = this.Zl.iterator();
                while (it.hasNext()) {
                    C0060a next = it.next();
                    if (next.Zm == aVar) {
                        next.release();
                        this.Zl.remove(next);
                    }
                }
            }

            public void g(int i, long j, long j2) {
                Iterator<C0060a> it = this.Zl.iterator();
                while (it.hasNext()) {
                    C0060a next = it.next();
                    if (!next.cw) {
                        next.jS.post(new d$a$a$$ExternalSyntheticLambda0(next, i, j, j2));
                    }
                }
            }

            /* renamed from: com.applovin.exoplayer2.k.d$a$a$a  reason: collision with other inner class name */
            private static final class C0060a {
                /* access modifiers changed from: private */
                public final a Zm;
                /* access modifiers changed from: private */
                public boolean cw;
                /* access modifiers changed from: private */
                public final Handler jS;

                public void release() {
                    this.cw = true;
                }

                public C0060a(Handler handler, a aVar) {
                    this.jS = handler;
                    this.Zm = aVar;
                }
            }
        }
    }
}
