package com.fyber.inneractive.sdk.mraid;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.util.u;
import com.fyber.inneractive.sdk.web.g;
import com.fyber.inneractive.sdk.web.h;
import com.fyber.inneractive.sdk.web.i;
import com.fyber.inneractive.sdk.web.k;
import com.fyber.inneractive.sdk.web.l;
import java.util.Map;

public class e extends a {
    public e(Map<String, String> map, i iVar, p0 p0Var) {
        super(map, iVar, p0Var);
    }

    public void a() {
        int i;
        int a = a("w");
        int a2 = a("h");
        String str = this.b.get("url");
        boolean equals = "true".equals(this.b.get("shouldUseCustomClose"));
        boolean equals2 = "true".equals(this.b.get("lockOrientation"));
        if (a <= 0) {
            a = -1;
        }
        if (a2 <= 0) {
            a2 = -1;
        }
        i iVar = this.c;
        if (iVar.b != null && iVar.P != i.f.DISABLED && iVar.O == b0.DEFAULT) {
            if (str == null || URLUtil.isValidUrl(str)) {
                try {
                    ViewGroup viewGroup = (ViewGroup) iVar.b.getRootView().findViewById(16908290);
                    iVar.S = viewGroup;
                    if (viewGroup == null) {
                        IAlog.e("Couldn't find content in the view tree", new Object[0]);
                        iVar.a(g.RESIZE, "Ad can be resized only if it's state is default or resized.");
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 33) {
                        iVar.n0 = new k(iVar);
                        if (iVar.l() instanceof Activity) {
                            ((Activity) iVar.l()).getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, iVar.n0);
                        }
                    }
                    iVar.Y = equals;
                    L l = iVar.g;
                    if (l != null) {
                        ((i.h) l).a(iVar, equals);
                    }
                    iVar.e(equals2);
                    if (iVar.f0 >= 0) {
                        iVar.f0 = p.a(a2);
                    }
                    if (iVar.e0 >= 0) {
                        iVar.e0 = p.a(i);
                    }
                    g gVar = iVar.b;
                    RelativeLayout a3 = iVar.a((View) (ViewGroup) gVar.getParent());
                    if (str != null) {
                        g gVar2 = new g();
                        iVar.T = gVar2;
                        gVar2.setId(R.id.inneractive_webview_mraid);
                        iVar.T.loadUrl(str);
                        iVar.T.setWebChromeClient(iVar.c);
                        iVar.T.setWebViewClient(iVar.d);
                        gVar = iVar.T;
                        gVar.setOnKeyListener(new l(iVar));
                    } else {
                        ViewGroup viewGroup2 = (ViewGroup) iVar.b.getParent();
                        if (viewGroup2 != null) {
                            int childCount = viewGroup2.getChildCount();
                            int i2 = 0;
                            while (i2 < childCount && viewGroup2.getChildAt(i2) != iVar.b) {
                                i2++;
                            }
                            iVar.h0 = i2;
                            u.a((View) (RelativeLayout) viewGroup2.findViewById(R.id.ia_identifier_overlay));
                            u.a((View) iVar.i0);
                            viewGroup2.addView(iVar.i0, i2, u.a(iVar.b.getWidth(), iVar.b.getHeight(), 13));
                            viewGroup2.removeView(iVar.b);
                        }
                    }
                    float f = iVar.Z;
                    int i3 = (int) ((50.0f * f) + 0.5f);
                    if (a2 >= 0 && i >= 0) {
                        i = (int) (((float) i) * f);
                        a2 = (int) (((float) a2) * f);
                        if (i < i3) {
                            i = i3;
                        }
                        if (a2 < i3) {
                            a2 = i3;
                        }
                    }
                    View view = new View(iVar.l());
                    view.setBackgroundColor(iVar.l().getResources().getColor(R.color.ia_mraid_expanded_dimmed_bk));
                    view.setOnTouchListener(new h(iVar));
                    iVar.k0.addView(view, new RelativeLayout.LayoutParams(-1, -1));
                    u.a((View) gVar);
                    iVar.j0.addView(gVar, new RelativeLayout.LayoutParams(-1, -1));
                    u.a((View) iVar.j0);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, a2);
                    layoutParams.addRule(13);
                    iVar.k0.addView(iVar.j0, layoutParams);
                    u.a((View) iVar.k0);
                    iVar.S.addView(iVar.k0, new ViewGroup.LayoutParams(-1, -1));
                    if (!gVar.hasFocus()) {
                        gVar.requestFocus();
                    }
                    i.j jVar = iVar.Q;
                    if (jVar == i.j.ALWAYS_VISIBLE || (!iVar.Y && jVar != i.j.ALWAYS_HIDDEN)) {
                        iVar.d(true);
                    }
                    b0 b0Var = b0.EXPANDED;
                    iVar.O = b0Var;
                    iVar.a((u) new z(b0Var));
                    int i4 = iVar.e0;
                    if (!(i4 == -1 || iVar.f0 == -1)) {
                        iVar.a((u) new t(p.b(i4), p.b(iVar.f0)));
                    }
                    iVar.a(g.EXPAND);
                    if (a3 != null) {
                        int dimension = (int) a3.getContext().getResources().getDimension(R.dimen.identifier_padding);
                        a3.setPadding(dimension, 0, 0, dimension);
                        a3.setLayoutParams(iVar.S.getLayoutParams());
                        iVar.S.addView(a3);
                    }
                    L l2 = iVar.g;
                    if (l2 != null) {
                        ((i.h) l2).a(iVar);
                    }
                } catch (Exception unused) {
                    IAlog.e("Couldn't find content in the view tree", new Object[0]);
                    iVar.a(g.RESIZE, "Ad can be resized only if it's state is default or resized.");
                }
            } else {
                iVar.a(g.EXPAND, "URL passed to expand() was invalid.");
            }
        }
    }

    public String c() {
        return this.b.get("url");
    }
}
