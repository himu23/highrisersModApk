package com.applovin.exoplayer2.b;

import android.os.Handler;
import com.applovin.exoplayer2.c.e;
import com.applovin.exoplayer2.c.h;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.v;

public interface g {

    /* renamed from: com.applovin.exoplayer2.b.g$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$A(g _this, boolean z) {
        }

        public static void $default$a(g _this, int i, long j, long j2) {
        }

        public static void $default$b(g _this, v vVar, h hVar) {
        }

        public static void $default$b(g _this, Exception exc) {
        }

        public static void $default$b(g _this, String str, long j, long j2) {
        }

        public static void $default$c(g _this, e eVar) {
        }

        @Deprecated
        public static void $default$c(g _this, v vVar) {
        }

        public static void $default$c(g _this, Exception exc) {
        }

        public static void $default$d(g _this, e eVar) {
        }

        public static void $default$s(g _this, String str) {
        }

        public static void $default$z(g _this, long j) {
        }
    }

    void A(boolean z);

    void a(int i, long j, long j2);

    void b(v vVar, h hVar);

    void b(Exception exc);

    void b(String str, long j, long j2);

    void c(e eVar);

    @Deprecated
    void c(v vVar);

    void c(Exception exc);

    void d(e eVar);

    void s(String str);

    void z(long j);

    public static final class a {
        private final Handler jS;
        private final g jT;

        public a(Handler handler, g gVar) {
            this.jS = gVar != null ? (Handler) com.applovin.exoplayer2.l.a.checkNotNull(handler) : null;
            this.jT = gVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(e eVar) {
            ((g) ai.R(this.jT)).c(eVar);
        }

        public void e(e eVar) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new g$a$$ExternalSyntheticLambda9(this, eVar));
            }
        }

        public void c(String str, long j, long j2) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new g$a$$ExternalSyntheticLambda2(this, str, j, j2));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(String str, long j, long j2) {
            ((g) ai.R(this.jT)).b(str, j, j2);
        }

        public void c(v vVar, h hVar) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new g$a$$ExternalSyntheticLambda3(this, vVar, hVar));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(v vVar, h hVar) {
            ((g) ai.R(this.jT)).c(vVar);
            ((g) ai.R(this.jT)).b(vVar, hVar);
        }

        public void C(long j) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new g$a$$ExternalSyntheticLambda0(this, j));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void D(long j) {
            ((g) ai.R(this.jT)).z(j);
        }

        public void c(int i, long j, long j2) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new g$a$$ExternalSyntheticLambda1(this, i, j, j2));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(int i, long j, long j2) {
            ((g) ai.R(this.jT)).a(i, j, j2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void u(String str) {
            ((g) ai.R(this.jT)).s(str);
        }

        public void t(String str) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new g$a$$ExternalSyntheticLambda7(this, str));
            }
        }

        public void f(e eVar) {
            eVar.he();
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new g$a$$ExternalSyntheticLambda8(this, eVar));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g(e eVar) {
            eVar.he();
            ((g) ai.R(this.jT)).d(eVar);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void E(boolean z) {
            ((g) ai.R(this.jT)).A(z);
        }

        public void D(boolean z) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new g$a$$ExternalSyntheticLambda4(this, z));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g(Exception exc) {
            ((g) ai.R(this.jT)).b(exc);
        }

        public void d(Exception exc) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new g$a$$ExternalSyntheticLambda5(this, exc));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(Exception exc) {
            ((g) ai.R(this.jT)).c(exc);
        }

        public void e(Exception exc) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new g$a$$ExternalSyntheticLambda6(this, exc));
            }
        }
    }
}
