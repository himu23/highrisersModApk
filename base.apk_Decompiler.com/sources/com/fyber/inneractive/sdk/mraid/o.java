package com.fyber.inneractive.sdk.mraid;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.util.u;
import com.fyber.inneractive.sdk.web.g;
import com.fyber.inneractive.sdk.web.i;
import java.util.Map;

public class o extends b {
    public o(Map<String, String> map, i iVar, p0 p0Var) {
        super(map, iVar, p0Var);
    }

    public void a() {
        int a = a("w");
        int a2 = a("h");
        int a3 = a("offsetX");
        int a4 = a("offsetY");
        boolean equals = "true".equals(this.b.get("allowOffscreen"));
        String str = this.b.get("customClosePosition");
        if (a <= 0) {
            a = this.c.a0;
        }
        if (a2 <= 0) {
            a2 = this.c.b0;
        }
        i iVar = this.c;
        g gVar = iVar.b;
        if (gVar != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) gVar.getRootView().findViewById(16908290);
                iVar.S = viewGroup;
                if (viewGroup == null) {
                    IAlog.e("Couldn't find content in the view tree", new Object[0]);
                    iVar.a(g.RESIZE, "Ad can be resized only if it's state is default or resized.");
                } else if (iVar.P != i.f.DISABLED) {
                    b0 b0Var = iVar.O;
                    if (b0Var != b0.DEFAULT && b0Var != b0.RESIZED) {
                        iVar.a(g.RESIZE, "Ad can be resized only if it's state is default or resized.");
                    } else if (a >= 0 || a2 >= 0) {
                        iVar.c(false);
                        i.j jVar = iVar.Q;
                        if (jVar == i.j.ALWAYS_VISIBLE || (!iVar.Y && jVar != i.j.ALWAYS_HIDDEN)) {
                            iVar.d(true);
                        }
                        iVar.e(false);
                        iVar.f0 = p.a(a2);
                        iVar.e0 = p.a(a);
                        if (!equals) {
                            int i = (a3 + a) - iVar.a0;
                            if (i > 0) {
                                a3 -= i;
                            }
                            if (a3 < 0) {
                                a3 = 0;
                            }
                            int i2 = (a4 + a2) - iVar.b0;
                            if (i2 > 0) {
                                a4 -= i2;
                            }
                            if (a4 < 0) {
                                a4 = 0;
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = iVar.b.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            RelativeLayout.LayoutParams a5 = u.a(p.a(a), p.a(a2), (a3 == 0 && a4 == 0) ? new int[]{13} : null);
                            a5.leftMargin = a3;
                            a5.topMargin = a4;
                            iVar.b.setLayoutParams(a5);
                        } else if (layoutParams instanceof FrameLayout.LayoutParams) {
                            iVar.b.setLayoutParams(new FrameLayout.LayoutParams(p.a(a), p.a(a2), 17));
                        }
                        b0 b0Var2 = iVar.O;
                        b0 b0Var3 = b0.RESIZED;
                        if (b0Var2 != b0Var3) {
                            iVar.O = b0Var3;
                            iVar.a((u) new z(b0Var3));
                            int i3 = iVar.e0;
                            if (!(i3 == -1 || iVar.f0 == -1)) {
                                iVar.a((u) new t(p.b(i3), p.b(iVar.f0)));
                            }
                        }
                        iVar.a(g.RESIZE);
                        RelativeLayout a6 = iVar.a((View) (ViewGroup) iVar.b.getParent());
                        g gVar2 = iVar.b;
                        if (!(gVar2 == null || a6 == null)) {
                            a6.setLayoutParams(gVar2.getLayoutParams());
                        }
                        L l = iVar.g;
                        if (l != null) {
                            ((i.h) l).b(iVar);
                        }
                    } else {
                        iVar.a(g.RESIZE, "Creative size passed to resize() was invalid.");
                    }
                }
            } catch (Exception unused) {
                IAlog.e("Couldn't find content in the view tree", new Object[0]);
                iVar.a(g.RESIZE, "Ad can be resized only if it's state is default or resized.");
            }
        }
    }

    public boolean b() {
        return true;
    }
}
