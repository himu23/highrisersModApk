package com.ironsource;

import android.app.Activity;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.testSuite.TestSuiteActivity;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u001b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0005\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\t\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\fJ&\u0010\u0005\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u0005\u001a\u00020\fR\"\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00020\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010!¨\u0006&"}, d2 = {"Lcom/ironsource/qb;", "", "Lcom/ironsource/mediationsdk/testSuite/TestSuiteActivity;", "activity", "Landroid/widget/RelativeLayout;", "a", "", "marginPercentageFromTop", "Landroid/widget/FrameLayout$LayoutParams;", "b", "Lcom/ironsource/wb;", "loadAdConfig", "", "", "c", "e", "d", "f", "", "description", "", "width", "height", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "mTestSuiteActivityWeakReference", "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandler", "Landroid/widget/RelativeLayout;", "mBannerContainer", "Lcom/ironsource/mediationsdk/IronSourceBannerLayout;", "Lcom/ironsource/mediationsdk/IronSourceBannerLayout;", "mBannerLayout", "handler", "<init>", "(Lcom/ironsource/mediationsdk/testSuite/TestSuiteActivity;Landroid/os/Handler;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class qb {
    private final WeakReference<TestSuiteActivity> a;
    private final Handler b;
    private RelativeLayout c;
    private IronSourceBannerLayout d;

    public qb(TestSuiteActivity testSuiteActivity, Handler handler) {
        Intrinsics.checkNotNullParameter(testSuiteActivity, "activity");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.a = new WeakReference<>(testSuiteActivity);
        this.b = handler;
    }

    private final RelativeLayout a(TestSuiteActivity testSuiteActivity) {
        RelativeLayout relativeLayout = new RelativeLayout(testSuiteActivity);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        return relativeLayout;
    }

    /* access modifiers changed from: private */
    public static final void a(qb qbVar) {
        RelativeLayout container;
        Intrinsics.checkNotNullParameter(qbVar, "this$0");
        RelativeLayout relativeLayout = qbVar.c;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        TestSuiteActivity b2 = qbVar.b();
        if (!(b2 == null || (container = b2.getContainer()) == null)) {
            container.removeView(qbVar.c);
        }
        qbVar.c = null;
    }

    /* access modifiers changed from: private */
    public static final void a(qb qbVar, TestSuiteActivity testSuiteActivity) {
        Intrinsics.checkNotNullParameter(qbVar, "this$0");
        RelativeLayout relativeLayout = qbVar.c;
        if (relativeLayout != null) {
            relativeLayout.addView(qbVar.d);
        }
        testSuiteActivity.getContainer().addView(qbVar.c);
    }

    private final FrameLayout.LayoutParams b(double d2) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = (int) (((double) yb.a.a()) * d2);
        return layoutParams;
    }

    private final TestSuiteActivity b() {
        return this.a.get();
    }

    public final void a() {
        IronSourceBannerLayout ironSourceBannerLayout = this.d;
        if (ironSourceBannerLayout != null) {
            yb.a.a(ironSourceBannerLayout);
        }
        this.b.post(new qb$$ExternalSyntheticLambda1(this));
        this.d = null;
    }

    public final void a(double d2) {
        if (this.c == null) {
            IronSourceBannerLayout ironSourceBannerLayout = this.d;
            if (ironSourceBannerLayout != null) {
                ironSourceBannerLayout.setLayoutParams(b(d2));
            }
            TestSuiteActivity b2 = b();
            if (b2 != null) {
                this.c = a(b2);
                this.b.post(new qb$$ExternalSyntheticLambda0(this, b2));
            }
        }
    }

    public final void a(wb wbVar) {
        Intrinsics.checkNotNullParameter(wbVar, "loadAdConfig");
        yb ybVar = yb.a;
        ybVar.a(IronSource.AD_UNIT.INTERSTITIAL, wbVar);
        ybVar.g();
    }

    public final void a(wb wbVar, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(wbVar, "loadAdConfig");
        Intrinsics.checkNotNullParameter(str, "description");
        a();
        yb ybVar = yb.a;
        ybVar.a(IronSource.AD_UNIT.BANNER, wbVar);
        TestSuiteActivity b2 = b();
        if (b2 != null) {
            IronSourceBannerLayout a2 = ybVar.a((Activity) b2, ybVar.a(str, i, i2));
            this.d = a2;
            ybVar.b(a2);
        }
    }

    public final void b(wb wbVar) {
        Intrinsics.checkNotNullParameter(wbVar, "loadAdConfig");
        yb ybVar = yb.a;
        ybVar.a(IronSource.AD_UNIT.REWARDED_VIDEO, wbVar);
        ybVar.h();
    }

    public final boolean c() {
        return yb.a.e();
    }

    public final boolean d() {
        return yb.a.f();
    }

    public final void e() {
        yb.a.a((Activity) this.a.get());
    }

    public final void f() {
        yb.a.b((Activity) this.a.get());
    }
}
