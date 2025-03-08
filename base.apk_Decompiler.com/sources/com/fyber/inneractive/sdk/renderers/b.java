package com.fyber.inneractive.sdk.renderers;

import android.graphics.Rect;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.m;
import com.fyber.inneractive.sdk.util.q;

public class b {
    public m<Rect> a;
    public final e b;
    public final RelativeLayout c;
    public float d = 0.0f;
    public int e = 1;
    public float f = 0.0f;
    public long g = 0;
    public boolean h = false;
    public boolean i = false;
    public final c j;
    public final Runnable k = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            b.this.a();
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.renderers.b$b  reason: collision with other inner class name */
    public class C0134b implements m.a<Rect> {
        public C0134b(b bVar) {
        }

        public Object a() {
            return new Rect();
        }
    }

    public interface c {
    }

    public b(e eVar, RelativeLayout relativeLayout, c cVar) {
        this.b = eVar;
        this.c = relativeLayout;
        this.j = cVar;
        this.a = new m<>(4, new C0134b(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r10 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "IAVisibilityTracker: onCheckVisibility"
            com.fyber.inneractive.sdk.util.IAlog.a(r2, r1)
            int r1 = r10.e
            float r1 = (float) r1
            r2 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r2
            com.fyber.inneractive.sdk.util.m<android.graphics.Rect> r2 = r10.a
            java.lang.Object r2 = r2.a()
            android.graphics.Rect r2 = (android.graphics.Rect) r2
            android.widget.RelativeLayout r3 = r10.c
            android.view.ViewParent r4 = r3.getParent()
            if (r4 == 0) goto L_0x0048
            boolean r4 = r3.isShown()
            if (r4 == 0) goto L_0x0048
            boolean r4 = r3.hasWindowFocus()
            if (r4 == 0) goto L_0x0048
            boolean r4 = r3.getGlobalVisibleRect(r2)
            if (r4 == 0) goto L_0x0048
            int r4 = r2.height()
            int r5 = r2.width()
            int r4 = r4 * r5
            float r4 = (float) r4
            int r5 = r3.getHeight()
            int r3 = r3.getWidth()
            int r5 = r5 * r3
            float r3 = (float) r5
            float r4 = r4 / r3
            goto L_0x0049
        L_0x0048:
            r4 = 0
        L_0x0049:
            com.fyber.inneractive.sdk.util.m<android.graphics.Rect> r3 = r10.a
            java.util.Queue<T> r3 = r3.a
            r3.offer(r2)
            r10.d = r4
            r2 = 0
            r5 = 1
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 < 0) goto L_0x0071
            float r4 = r10.f
            r6 = 1148846080(0x447a0000, float:1000.0)
            float r4 = r4 * r6
            long r6 = java.lang.System.currentTimeMillis()
            long r8 = r10.g
            long r6 = r6 - r8
            float r6 = (float) r6
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x0071
            int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0071
            r4 = 1
            goto L_0x0072
        L_0x0071:
            r4 = 0
        L_0x0072:
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r4)
            r6[r0] = r7
            java.lang.Float r7 = java.lang.Float.valueOf(r1)
            r6[r5] = r7
            java.lang.String r7 = "BannerVisibilityTracker | visible = %s, minVis = %f"
            com.fyber.inneractive.sdk.util.IAlog.a(r7, r6)
            if (r4 == 0) goto L_0x00e0
            boolean r4 = r10.h
            if (r4 == 0) goto L_0x00e0
            com.fyber.inneractive.sdk.renderers.b$c r1 = r10.j
            if (r1 == 0) goto L_0x010b
            boolean r1 = r10.i
            if (r1 != 0) goto L_0x010b
            r10.i = r5
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "BannerVisibilityTracker | firing viewable"
            com.fyber.inneractive.sdk.util.IAlog.a(r2, r1)
            com.fyber.inneractive.sdk.renderers.b$c r1 = r10.j
            com.fyber.inneractive.sdk.renderers.d r1 = (com.fyber.inneractive.sdk.renderers.d) r1
            com.fyber.inneractive.sdk.renderers.g r1 = r1.a
            r1.getClass()
            AdContent r2 = r1.b     // Catch:{ Exception -> 0x010b }
            if (r2 == 0) goto L_0x010b
            r3 = r2
            com.fyber.inneractive.sdk.flow.b0 r3 = (com.fyber.inneractive.sdk.flow.b0) r3     // Catch:{ Exception -> 0x010b }
            T r3 = r3.b     // Catch:{ Exception -> 0x010b }
            if (r3 == 0) goto L_0x010b
            com.fyber.inneractive.sdk.flow.b0 r2 = (com.fyber.inneractive.sdk.flow.b0) r2     // Catch:{ Exception -> 0x010b }
            T r2 = r2.b     // Catch:{ Exception -> 0x010b }
            com.fyber.inneractive.sdk.response.f r2 = (com.fyber.inneractive.sdk.response.f) r2     // Catch:{ Exception -> 0x010b }
            java.lang.String r2 = r2.v     // Catch:{ Exception -> 0x010b }
            if (r2 == 0) goto L_0x010b
            java.lang.String r3 = r2.trim()     // Catch:{ Exception -> 0x010b }
            int r3 = r3.length()     // Catch:{ Exception -> 0x010b }
            if (r3 <= 0) goto L_0x010b
            java.lang.String r3 = "%sfiring banner mrc visibility impression!"
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x010b }
            java.lang.String r1 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r1)     // Catch:{ Exception -> 0x010b }
            r4[r0] = r1     // Catch:{ Exception -> 0x010b }
            com.fyber.inneractive.sdk.util.IAlog.d(r3, r4)     // Catch:{ Exception -> 0x010b }
            int r1 = com.fyber.inneractive.sdk.util.IAlog.a     // Catch:{ Exception -> 0x010b }
            java.lang.String r1 = "MRC_VISIBILITY_IMPRESSION"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x010b }
            r3 = 0
            com.fyber.inneractive.sdk.util.IAlog.a(r5, r3, r1, r0)     // Catch:{ Exception -> 0x010b }
            com.fyber.inneractive.sdk.network.j0.b(r2)     // Catch:{ Exception -> 0x010b }
            goto L_0x010b
        L_0x00e0:
            boolean r0 = r10.h
            if (r0 == 0) goto L_0x010b
            float r0 = r10.d
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00ed
            r10.g = r2
            goto L_0x00fd
        L_0x00ed:
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x00fd
            long r0 = r10.g
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00fd
            long r0 = java.lang.System.currentTimeMillis()
            r10.g = r0
        L_0x00fd:
            android.os.Handler r0 = com.fyber.inneractive.sdk.util.q.b
            java.lang.Runnable r1 = r10.k
            r0.removeCallbacks(r1)
            java.lang.Runnable r1 = r10.k
            r2 = 50
            r0.postDelayed(r1, r2)
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.b.a():void");
    }

    public void c() {
        this.h = false;
        q.b.removeCallbacks(this.k);
    }

    public void b() {
        if (!this.i && !this.h && this.g != 0) {
            this.g = 0;
            this.h = true;
            a();
        }
    }
}
