package com.iab.omid.library.fyber.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.fyber.processor.a;
import com.iab.omid.library.fyber.utils.f;
import com.iab.omid.library.fyber.utils.h;
import com.iab.omid.library.fyber.walking.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class TreeWalker implements a.C0004a {
    private static TreeWalker i = new TreeWalker();
    private static Handler j = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static Handler k = null;
    /* access modifiers changed from: private */
    public static final Runnable l = new b();
    /* access modifiers changed from: private */
    public static final Runnable m = new c();
    private List<TreeWalkerTimeLogger> a = new ArrayList();
    private int b;
    private boolean c = false;
    private final List<com.iab.omid.library.fyber.weakreference.a> d = new ArrayList();
    private com.iab.omid.library.fyber.processor.b e = new com.iab.omid.library.fyber.processor.b();
    private a f = new a();
    /* access modifiers changed from: private */
    public b g = new b(new com.iab.omid.library.fyber.walking.async.c());
    private long h;

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i, long j);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i, long j);
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            TreeWalker.this.g.b();
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            TreeWalker.getInstance().l();
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            if (TreeWalker.k != null) {
                TreeWalker.k.post(TreeWalker.l);
                TreeWalker.k.postDelayed(TreeWalker.m, 200);
            }
        }
    }

    TreeWalker() {
    }

    private void a(long j2) {
        if (this.a.size() > 0) {
            for (TreeWalkerTimeLogger next : this.a) {
                next.onTreeProcessed(this.b, TimeUnit.NANOSECONDS.toMillis(j2));
                if (next instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) next).onTreeProcessedNano(this.b, j2);
                }
            }
        }
    }

    private void a(View view, com.iab.omid.library.fyber.processor.a aVar, JSONObject jSONObject, c cVar, boolean z) {
        aVar.a(view, jSONObject, this, cVar == c.PARENT_VIEW, z);
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.fyber.processor.a b2 = this.e.b();
        String b3 = this.f.b(str);
        if (b3 != null) {
            JSONObject a2 = b2.a(view);
            com.iab.omid.library.fyber.utils.c.a(a2, str);
            com.iab.omid.library.fyber.utils.c.b(a2, b3);
            com.iab.omid.library.fyber.utils.c.a(jSONObject, a2);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        a.C0006a c2 = this.f.c(view);
        if (c2 == null) {
            return false;
        }
        com.iab.omid.library.fyber.utils.c.a(jSONObject, c2);
        return true;
    }

    private boolean b(View view, JSONObject jSONObject) {
        String d2 = this.f.d(view);
        if (d2 == null) {
            return false;
        }
        com.iab.omid.library.fyber.utils.c.a(jSONObject, d2);
        com.iab.omid.library.fyber.utils.c.a(jSONObject, Boolean.valueOf(this.f.f(view)));
        this.f.d();
        return true;
    }

    private void d() {
        a(f.b() - this.h);
    }

    private void e() {
        this.b = 0;
        this.d.clear();
        this.c = false;
        Iterator<com.iab.omid.library.fyber.adsession.a> it = com.iab.omid.library.fyber.internal.c.c().a().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().e()) {
                    this.c = true;
                    break;
                }
            } else {
                break;
            }
        }
        this.h = f.b();
    }

    public static TreeWalker getInstance() {
        return i;
    }

    private void i() {
        if (k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            k = handler;
            handler.post(l);
            k.postDelayed(m, 200);
        }
    }

    private void k() {
        Handler handler = k;
        if (handler != null) {
            handler.removeCallbacks(m);
            k = null;
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        e();
        f();
        d();
    }

    public void a(View view, com.iab.omid.library.fyber.processor.a aVar, JSONObject jSONObject, boolean z) {
        c e2;
        if (h.d(view) && (e2 = this.f.e(view)) != c.UNDERLYING_VIEW) {
            JSONObject a2 = aVar.a(view);
            com.iab.omid.library.fyber.utils.c.a(jSONObject, a2);
            if (!b(view, a2)) {
                boolean z2 = z || a(view, a2);
                if (this.c && e2 == c.OBSTRUCTION_VIEW && !z2) {
                    this.d.add(new com.iab.omid.library.fyber.weakreference.a(view));
                }
                a(view, aVar, a2, e2, z2);
            }
            this.b++;
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (!this.a.contains(treeWalkerTimeLogger)) {
            this.a.add(treeWalkerTimeLogger);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f.e();
        long b2 = f.b();
        com.iab.omid.library.fyber.processor.a a2 = this.e.a();
        if (this.f.b().size() > 0) {
            Iterator<String> it = this.f.b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject a3 = a2.a((View) null);
                a(next, this.f.a(next), a3);
                com.iab.omid.library.fyber.utils.c.b(a3);
                HashSet hashSet = new HashSet();
                hashSet.add(next);
                this.g.a(a3, hashSet, b2);
            }
        }
        if (this.f.c().size() > 0) {
            JSONObject a4 = a2.a((View) null);
            a((View) null, a2, a4, c.PARENT_VIEW, false);
            com.iab.omid.library.fyber.utils.c.b(a4);
            this.g.b(a4, this.f.c(), b2);
            if (this.c) {
                for (com.iab.omid.library.fyber.adsession.a a5 : com.iab.omid.library.fyber.internal.c.c().a()) {
                    a5.a(this.d);
                }
            }
        } else {
            this.g.b();
        }
        this.f.a();
    }

    public void g() {
        k();
    }

    public void h() {
        i();
    }

    public void j() {
        g();
        this.a.clear();
        j.post(new a());
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.a.contains(treeWalkerTimeLogger)) {
            this.a.remove(treeWalkerTimeLogger);
        }
    }
}
