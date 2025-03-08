package com.fyber.inneractive.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import android.view.ViewTreeObserver;
import com.fyber.inneractive.sdk.util.m;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class d0 {
    public final Map<Context, Pair<ViewTreeObserver, ViewTreeObserver.OnPreDrawListener>> a = new WeakHashMap();
    public final WeakHashMap<Context, WeakHashMap<View, e>> b = new WeakHashMap<>();
    public final m<Rect> c = new m<>(16, new a(this));
    public final m<HashSet<View>> d = new m<>(16, new b(this));

    public class a implements m.a<Rect> {
        public a(d0 d0Var) {
        }

        public Object a() {
            return new Rect();
        }
    }

    public class b implements m.a<HashSet<View>> {
        public b(d0 d0Var) {
        }

        public Object a() {
            return new HashSet();
        }
    }

    public class c implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ Context a;

        public c(Context context) {
            this.a = context;
        }

        public boolean onPreDraw() {
            WeakHashMap weakHashMap;
            d0 d0Var = d0.this;
            Context context = this.a;
            d0Var.getClass();
            if (context == null || (weakHashMap = d0Var.b.get(context)) == null) {
                return true;
            }
            HashSet a2 = d0Var.d.a();
            a2.addAll(weakHashMap.keySet());
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                View view = (View) it.next();
                e eVar = (e) weakHashMap.get(view);
                if (eVar != null) {
                    Rect a3 = d0Var.c.a();
                    eVar.a(view, (view == null || view.getParent() == null || !view.isShown() || !view.getGlobalVisibleRect(a3)) ? 0.0f : ((float) (a3.height() * a3.width())) / ((float) (view.getHeight() * view.getWidth())), a3);
                    d0Var.c.a.offer(a3);
                }
            }
            a2.clear();
            d0Var.d.a.offer(a2);
            return true;
        }
    }

    public static class d {
        public static final d0 a = new d0();
    }

    public interface e {
        void a(View view, float f, Rect rect);
    }

    public static d0 a() {
        return d.a;
    }

    public final String b() {
        return "IAVisibilityTracker: ";
    }

    public final void c() {
        for (Context next : this.b.keySet()) {
            IAlog.a("%stracking context: %s", b(), next);
            WeakHashMap weakHashMap = this.b.get(next);
            if (weakHashMap != null) {
                for (View view : weakHashMap.keySet()) {
                    IAlog.a("%stracking view: %s", b(), view);
                }
            }
        }
    }

    public void a(Context context, View view, e eVar) {
        View view2;
        ViewTreeObserver viewTreeObserver;
        IAlog.a("%strackView called with context: %s view: %s", b(), context, view);
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            WeakHashMap weakHashMap = this.b.get(applicationContext);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap();
                this.b.put(applicationContext, weakHashMap);
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (activity.getWindow() != null) {
                        view2 = activity.getWindow().getDecorView();
                        viewTreeObserver = view2.getViewTreeObserver();
                        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                            c cVar = new c(applicationContext);
                            viewTreeObserver.addOnPreDrawListener(cVar);
                            this.a.put(applicationContext, new Pair(viewTreeObserver, cVar));
                        }
                    }
                }
                view2 = view.getRootView();
                viewTreeObserver = view2.getViewTreeObserver();
                c cVar2 = new c(applicationContext);
                viewTreeObserver.addOnPreDrawListener(cVar2);
                this.a.put(applicationContext, new Pair(viewTreeObserver, cVar2));
            }
            weakHashMap.put(view, eVar);
            c();
            return;
        }
        throw new IllegalStateException("View must be attached to an Activity context");
    }

    public void a(View view) {
        IAlog.a("%sunTrackView called with view", b());
        if (view == null) {
            IAlog.a("%sunTrackView called with a null view!", b());
            return;
        }
        Context context = view.getContext();
        if (context == null) {
            IAlog.a("%sview.getContext() returned null!", b());
            return;
        }
        Map map = this.b.get(context);
        if (map != null) {
            a(context, (Map<View, e>) map, view);
        } else {
            Iterator it = new HashSet(this.b.keySet()).iterator();
            while (it.hasNext()) {
                Context context2 = (Context) it.next();
                WeakHashMap weakHashMap = this.b.get(context2);
                if (weakHashMap != null) {
                    a(context2, (Map<View, e>) weakHashMap, view);
                }
            }
        }
        c();
    }

    public final void a(Context context, Map<View, e> map, View view) {
        if (map.remove(view) != null) {
            if (IAlog.a <= 2) {
                IAlog.d("removeViewFromContext found view for removal!", new Object[0]);
            }
            if (map.isEmpty()) {
                this.b.remove(context);
                Pair pair = this.a.get(context);
                if (pair != null) {
                    if (((ViewTreeObserver) pair.first).isAlive()) {
                        ((ViewTreeObserver) pair.first).removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) pair.second);
                    }
                    this.a.remove(context);
                }
            }
        }
    }
}
