package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ironsource.aa;
import com.ironsource.g1;
import com.ironsource.m2;
import com.ironsource.m3;
import com.ironsource.sdk.controller.u;

public class h extends FrameLayout implements aa {
    private Context a;
    private u b;

    class a implements Runnable {
        a() {
        }

        public void run() {
            ViewGroup a2 = h.this.getWindowDecorViewGroup();
            if (a2 != null) {
                a2.addView(h.this);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            ViewGroup a2 = h.this.getWindowDecorViewGroup();
            if (a2 != null) {
                a2.removeView(h.this);
            }
        }
    }

    public h(Context context) {
        super(context);
        this.a = context;
        setClickable(true);
    }

    private void a() {
        ((Activity) this.a).runOnUiThread(new a());
    }

    private void a(int i, int i2) {
        try {
            Context context = this.a;
            if (context != null) {
                int m = m3.m(context);
                if (m == 1) {
                    setPadding(0, i, 0, i2);
                } else if (m == 2) {
                    setPadding(0, i, i2, 0);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void b() {
        ((Activity) this.a).runOnUiThread(new b());
    }

    private int getNavigationBarPadding() {
        Activity activity = (Activity) this.a;
        try {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getDrawingRect(rect);
            Rect rect2 = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (m3.m(activity) == 1) {
                int i = rect.bottom - rect2.bottom;
                if (i > 0) {
                    return i;
                }
                return 0;
            }
            int i2 = rect.right - rect2.right;
            if (i2 > 0) {
                return i2;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    private int getStatusBarHeight() {
        int identifier;
        try {
            Context context = this.a;
            if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                return this.a.getResources().getDimensionPixelSize(identifier);
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private int getStatusBarPadding() {
        int statusBarHeight;
        if ((((Activity) this.a).getWindow().getAttributes().flags & 1024) == 0 && (statusBarHeight = getStatusBarHeight()) > 0) {
            return statusBarHeight;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public ViewGroup getWindowDecorViewGroup() {
        Activity activity = (Activity) this.a;
        if (activity != null) {
            return (ViewGroup) activity.getWindow().getDecorView();
        }
        return null;
    }

    public void a(u uVar) {
        this.b = uVar;
        uVar.setOnWebViewControllerChangeListener(this);
        this.b.requestFocus();
        this.a = this.b.getCurrentActivityContext();
        a(getStatusBarPadding(), getNavigationBarPadding());
        a();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.q();
        this.b.a(true, m2.h.Z);
    }

    public boolean onBackButtonPressed() {
        return g1.a().a((Activity) this.a);
    }

    public void onCloseRequested() {
        b();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.n();
        this.b.a(false, m2.h.Z);
        u uVar = this.b;
        if (uVar != null) {
            uVar.setState(u.y.Gone);
            this.b.o();
            this.b.p();
        }
        removeAllViews();
    }

    public void onOrientationChanged(String str, int i) {
    }
}
