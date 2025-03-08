package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.ironsource.aa;
import com.ironsource.d6;
import com.ironsource.e6;
import com.ironsource.f0;
import com.ironsource.g;
import com.ironsource.g1;
import com.ironsource.g6;
import com.ironsource.h;
import com.ironsource.hd;
import com.ironsource.l6;
import com.ironsource.m2;
import com.ironsource.m3;
import com.ironsource.r7;
import com.ironsource.sdk.controller.u;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.uc;
import com.ironsource.z3;
import com.ironsource.za;
import java.util.Map;

public class ControllerActivity extends Activity implements aa, uc {
    private static final String m = "ControllerActivity";
    private static final int n = 1;
    private static String o = "removeWebViewContainerView | mContainer is null";
    private static String p = "removeWebViewContainerView | view is null";
    private String a;
    private u b;
    private RelativeLayout c;
    public int currentRequestedRotation = -1;
    private FrameLayout d;
    /* access modifiers changed from: private */
    public boolean e = false;
    private String f;
    /* access modifiers changed from: private */
    public Handler g = new Handler();
    /* access modifiers changed from: private */
    public final Runnable h = new a();
    final RelativeLayout.LayoutParams i = new RelativeLayout.LayoutParams(-1, -1);
    private f0 j;
    private boolean k;
    private boolean l;

    class a implements Runnable {
        a() {
        }

        public void run() {
            ControllerActivity.this.getWindow().getDecorView().setSystemUiVisibility(SDKUtils.getActivityUIFlags(ControllerActivity.this.e));
        }
    }

    class b implements View.OnSystemUiVisibilityChangeListener {
        b() {
        }

        public void onSystemUiVisibilityChange(int i) {
            if ((i & InputDeviceCompat.SOURCE_TOUCHSCREEN) == 0) {
                ControllerActivity.this.g.removeCallbacks(ControllerActivity.this.h);
                ControllerActivity.this.g.postDelayed(ControllerActivity.this.h, 500);
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            ControllerActivity.this.getWindow().addFlags(128);
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            ControllerActivity.this.getWindow().clearFlags(128);
        }
    }

    private View a(ViewGroup viewGroup) {
        return d() ? viewGroup.findViewById(1) : d6.a().a(this.a).getPresentingView();
    }

    private FrameLayout a(String str) {
        return !b(str) ? this.b.getLayout() : hd.a(getApplicationContext(), d6.a().a(str).getPresentingView());
    }

    private void a() {
        runOnUiThread(new d());
    }

    private void a(String str, int i2) {
        int i3;
        if (str == null) {
            return;
        }
        if (m2.h.C.equalsIgnoreCase(str)) {
            g();
        } else if (m2.h.D.equalsIgnoreCase(str)) {
            h();
        } else {
            if (m2.h.G.equalsIgnoreCase(str)) {
                if (m3.H(this)) {
                    i3 = 1;
                } else {
                    return;
                }
            } else if (getRequestedOrientation() == -1) {
                i3 = 4;
            } else {
                return;
            }
            setRequestedOrientation(i3);
        }
    }

    private void b() {
        String str = m;
        Logger.i(str, "clearWebviewController");
        u uVar = this.b;
        if (uVar == null) {
            Logger.i(str, "clearWebviewController, null");
            return;
        }
        uVar.setState(u.y.Gone);
        this.b.o();
        this.b.p();
        this.b.e(this.f, "onDestroy");
    }

    private boolean b(String str) {
        return !TextUtils.isEmpty(str) && !str.equals(Integer.toString(1));
    }

    private void c() {
        Intent intent = getIntent();
        a(intent.getStringExtra(m2.h.A), intent.getIntExtra(m2.h.B, 0));
    }

    private boolean d() {
        return this.a == null;
    }

    private void e() {
        runOnUiThread(new c());
    }

    private void f() {
        ViewGroup viewGroup;
        try {
            if (this.c != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.d.getParent();
                View a2 = a(viewGroup2);
                if (a2 != null) {
                    if (isFinishing() && (viewGroup = (ViewGroup) a2.getParent()) != null) {
                        viewGroup.removeView(a2);
                    }
                    viewGroup2.removeView(this.d);
                    return;
                }
                throw new Exception(p);
            }
            throw new Exception(o);
        } catch (Exception e2) {
            l6.a(za.s, (Map<String, Object>) new g6().a(z3.z, e2.getMessage()).a());
            String str = m;
            Logger.i(str, "removeWebViewContainerView fail " + e2.getMessage());
        }
    }

    private void g() {
        String str;
        String str2;
        int g2 = m3.g(this);
        String str3 = m;
        Logger.i(str3, "setInitiateLandscapeOrientation");
        if (g2 == 0) {
            str = "ROTATION_0";
        } else {
            if (g2 == 2) {
                str2 = "ROTATION_180";
            } else if (g2 == 3) {
                str2 = "ROTATION_270 Right Landscape";
            } else if (g2 == 1) {
                str = "ROTATION_90 Left Landscape";
            } else {
                Logger.i(str3, "No Rotation");
                return;
            }
            Logger.i(str3, str2);
            setRequestedOrientation(8);
            return;
        }
        Logger.i(str3, str);
        setRequestedOrientation(0);
    }

    private void h() {
        String str;
        int g2 = m3.g(this);
        String str2 = m;
        Logger.i(str2, "setInitiatePortraitOrientation");
        if (g2 == 0) {
            str = "ROTATION_0";
        } else if (g2 == 2) {
            Logger.i(str2, "ROTATION_180");
            setRequestedOrientation(9);
            return;
        } else if (g2 == 1) {
            str = "ROTATION_270 Right Landscape";
        } else if (g2 == 3) {
            str = "ROTATION_90 Left Landscape";
        } else {
            Logger.i(str2, "No Rotation");
            return;
        }
        Logger.i(str2, str);
        setRequestedOrientation(1);
    }

    public boolean onBackButtonPressed() {
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        Logger.i(m, "onBackPressed");
        if (!g1.a().a(this)) {
            super.onBackPressed();
        }
    }

    public void onCloseRequested() {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            new h(this).a();
            new g(this).a();
            u uVar = (u) r7.b((Context) this).a().i();
            this.b = uVar;
            uVar.getLayout().setId(1);
            this.b.setOnWebViewControllerChangeListener(this);
            this.b.setVideoEventsListener(this);
            Intent intent = getIntent();
            this.f = intent.getStringExtra(m2.h.m);
            this.e = intent.getBooleanExtra(m2.h.v, false);
            this.a = intent.getStringExtra("adViewId");
            this.k = false;
            this.l = intent.getBooleanExtra(m2.h.z0, false);
            if (this.e) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new b());
                runOnUiThread(this.h);
            }
            if (!TextUtils.isEmpty(this.f) && e6.e.OfferWall.toString().equalsIgnoreCase(this.f)) {
                if (bundle != null) {
                    f0 f0Var = (f0) bundle.getParcelable("state");
                    if (f0Var != null) {
                        this.j = f0Var;
                        this.b.a(f0Var);
                    }
                    finish();
                } else {
                    this.j = this.b.getSavedState();
                }
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.c = relativeLayout;
            setContentView(relativeLayout, this.i);
            this.d = a(this.a);
            if (this.c.findViewById(1) == null && this.d.getParent() != null) {
                finish();
            }
            c();
            this.c.addView(this.d, this.i);
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        String str = m;
        Logger.i(str, "onDestroy");
        f();
        if (!this.k) {
            Logger.i(str, "onDestroy | destroyedFromBackground");
            b();
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !this.b.k()) {
            if (this.e && (i2 == 25 || i2 == 24)) {
                this.g.removeCallbacks(this.h);
                this.g.postDelayed(this.h, 500);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        this.b.j();
        return true;
    }

    public void onOrientationChanged(String str, int i2) {
        a(str, i2);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        String str = m;
        Logger.i(str, "onPause, isFinishing=" + isFinishing());
        s.a((Activity) this);
        u uVar = this.b;
        if (uVar != null) {
            uVar.a((Context) this);
            if (!this.l) {
                this.b.n();
            }
            this.b.a(false, m2.h.Z);
            this.b.e(this.f, m2.h.t0);
        }
        if (isFinishing()) {
            this.k = true;
            b();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Logger.i(m, m2.h.u0);
        u uVar = this.b;
        if (uVar != null) {
            uVar.b((Context) this);
            if (!this.l) {
                this.b.q();
            }
            this.b.a(true, m2.h.Z);
            this.b.e(this.f, m2.h.u0);
        }
        s.b((Activity) this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!TextUtils.isEmpty(this.f) && e6.e.OfferWall.toString().equalsIgnoreCase(this.f)) {
            this.j.c(true);
            bundle.putParcelable("state", this.j);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Logger.i(m, "onStart");
        u uVar = this.b;
        if (uVar != null) {
            uVar.e(this.f, "onStart");
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        Logger.i(m, "onStop");
        u uVar = this.b;
        if (uVar != null) {
            uVar.e(this.f, "onStop");
        }
    }

    /* access modifiers changed from: protected */
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Logger.i(m, "onUserLeaveHint");
        u uVar = this.b;
        if (uVar != null) {
            uVar.e(this.f, "onUserLeaveHint");
        }
    }

    public void onVideoEnded() {
        toggleKeepScreen(false);
    }

    public void onVideoPaused() {
        toggleKeepScreen(false);
    }

    public void onVideoResumed() {
        toggleKeepScreen(true);
    }

    public void onVideoStarted() {
        toggleKeepScreen(true);
    }

    public void onVideoStopped() {
        toggleKeepScreen(false);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.e && z) {
            runOnUiThread(this.h);
        }
    }

    public void setRequestedOrientation(int i2) {
        if (this.currentRequestedRotation != i2) {
            String str = m;
            Logger.i(str, "Rotation: Req = " + i2 + " Curr = " + this.currentRequestedRotation);
            this.currentRequestedRotation = i2;
            super.setRequestedOrientation(i2);
        }
    }

    public void toggleKeepScreen(boolean z) {
        if (z) {
            e();
        } else {
            a();
        }
    }
}
