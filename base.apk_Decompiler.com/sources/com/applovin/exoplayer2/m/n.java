package com.applovin.exoplayer2.m;

import android.os.Handler;
import android.os.SystemClock;
import com.applovin.exoplayer2.c.e;
import com.applovin.exoplayer2.c.h;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.v;

public interface n {

    /* renamed from: com.applovin.exoplayer2.m.n$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$a(n _this, long j, int i) {
        }

        public static void $default$a(n _this, e eVar) {
        }

        public static void $default$a(n _this, o oVar) {
        }

        public static void $default$a(n _this, v vVar, h hVar) {
        }

        public static void $default$a(n _this, Exception exc) {
        }

        public static void $default$a(n _this, Object obj, long j) {
        }

        public static void $default$a(n _this, String str, long j, long j2) {
        }

        public static void $default$b(n _this, int i, long j) {
        }

        public static void $default$b(n _this, e eVar) {
        }

        public static void $default$r(n _this, String str) {
        }

        @Deprecated
        public static void $default$y(n _this, v vVar) {
        }
    }

    void a(long j, int i);

    void a(e eVar);

    void a(o oVar);

    void a(v vVar, h hVar);

    void a(Exception exc);

    void a(Object obj, long j);

    void a(String str, long j, long j2);

    void b(int i, long j);

    void b(e eVar);

    void r(String str);

    @Deprecated
    void y(v vVar);

    public static final class a {
        private final n afj;
        private final Handler jS;

        public a(Handler handler, n nVar) {
            this.jS = nVar != null ? (Handler) com.applovin.exoplayer2.l.a.checkNotNull(handler) : null;
            this.afj = nVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(e eVar) {
            ((n) ai.R(this.afj)).a(eVar);
        }

        public void e(e eVar) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new n$a$$ExternalSyntheticLambda3(this, eVar));
            }
        }

        public void c(String str, long j, long j2) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new n$a$$ExternalSyntheticLambda7(this, str, j, j2));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(String str, long j, long j2) {
            ((n) ai.R(this.afj)).a(str, j, j2);
        }

        public void c(v vVar, h hVar) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new n$a$$ExternalSyntheticLambda1(this, vVar, hVar));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(v vVar, h hVar) {
            ((n) ai.R(this.afj)).y(vVar);
            ((n) ai.R(this.afj)).a(vVar, hVar);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(int i, long j) {
            ((n) ai.R(this.afj)).b(i, j);
        }

        public void l(int i, long j) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new n$a$$ExternalSyntheticLambda0(this, i, j));
            }
        }

        public void f(long j, int i) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new n$a$$ExternalSyntheticLambda9(this, j, i));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g(long j, int i) {
            ((n) ai.R(this.afj)).a(j, i);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(o oVar) {
            ((n) ai.R(this.afj)).a(oVar);
        }

        public void b(o oVar) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new n$a$$ExternalSyntheticLambda4(this, oVar));
            }
        }

        public void T(Object obj) {
            if (this.jS != null) {
                this.jS.post(new n$a$$ExternalSyntheticLambda2(this, obj, SystemClock.elapsedRealtime()));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(Object obj, long j) {
            ((n) ai.R(this.afj)).a(obj, j);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void bp(String str) {
            ((n) ai.R(this.afj)).r(str);
        }

        public void t(String str) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new n$a$$ExternalSyntheticLambda6(this, str));
            }
        }

        public void f(e eVar) {
            eVar.he();
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new n$a$$ExternalSyntheticLambda8(this, eVar));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void i(e eVar) {
            eVar.he();
            ((n) ai.R(this.afj)).b(eVar);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(Exception exc) {
            ((n) ai.R(this.afj)).a(exc);
        }

        public void k(Exception exc) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new n$a$$ExternalSyntheticLambda5(this, exc));
            }
        }
    }
}
