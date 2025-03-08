package com.ironsource.mediationsdk.testSuite;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.ironsource.dc;
import com.ironsource.tb;
import com.ironsource.x6;
import com.ironsource.zb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0006\u0010\u0012\u001a\u00020\u0011R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\b\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/ironsource/mediationsdk/testSuite/TestSuiteActivity;", "Landroid/app/Activity;", "Lcom/ironsource/x6;", "Lorg/json/JSONObject;", "b", "", "a", "Landroid/widget/RelativeLayout$LayoutParams;", "c", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "onBackPressed", "onDestroy", "onUIReady", "onClosed", "Landroid/widget/RelativeLayout;", "getContainer", "Landroid/widget/RelativeLayout;", "mContainer", "Lcom/ironsource/dc;", "Lcom/ironsource/dc;", "mWebViewWrapper", "Lcom/ironsource/zb;", "Lcom/ironsource/zb;", "mNativeBridge", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class TestSuiteActivity extends Activity implements x6 {
    private RelativeLayout a;
    private dc b;
    private zb c;

    private final String a() {
        Bundle extras;
        if (getIntent() == null || getIntent().getExtras() == null || (extras = getIntent().getExtras()) == null) {
            return null;
        }
        return extras.getString(tb.b);
    }

    /* access modifiers changed from: private */
    public static final void a(TestSuiteActivity testSuiteActivity) {
        Intrinsics.checkNotNullParameter(testSuiteActivity, "this$0");
        testSuiteActivity.finish();
    }

    private final JSONObject b() {
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            Bundle extras = getIntent().getExtras();
            String string = extras != null ? extras.getString(tb.a) : null;
            if (!(string == null || string.length() == 0)) {
                return new JSONObject(string);
            }
        }
        return new JSONObject();
    }

    /* access modifiers changed from: private */
    public static final void b(TestSuiteActivity testSuiteActivity) {
        Intrinsics.checkNotNullParameter(testSuiteActivity, "this$0");
        dc dcVar = testSuiteActivity.b;
        dc dcVar2 = null;
        if (dcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
            dcVar = null;
        }
        if (dcVar.c().getParent() == null) {
            RelativeLayout relativeLayout = testSuiteActivity.a;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                relativeLayout = null;
            }
            dc dcVar3 = testSuiteActivity.b;
            if (dcVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
                dcVar3 = null;
            }
            relativeLayout.removeView(dcVar3.d());
            RelativeLayout relativeLayout2 = testSuiteActivity.a;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                relativeLayout2 = null;
            }
            dc dcVar4 = testSuiteActivity.b;
            if (dcVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
                dcVar4 = null;
            }
            relativeLayout2.addView(dcVar4.c(), testSuiteActivity.c());
            dc dcVar5 = testSuiteActivity.b;
            if (dcVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
            } else {
                dcVar2 = dcVar5;
            }
            dcVar2.b();
        }
    }

    private final RelativeLayout.LayoutParams c() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    public final RelativeLayout getContainer() {
        RelativeLayout relativeLayout = this.a;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        return null;
    }

    public void onBackPressed() {
    }

    public void onClosed() {
        runOnUiThread(new TestSuiteActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.a = relativeLayout;
        setContentView(relativeLayout, c());
        dc dcVar = new dc(this, this, b(), a());
        this.b = dcVar;
        zb zbVar = new zb(dcVar);
        this.c = zbVar;
        zbVar.d();
        RelativeLayout relativeLayout2 = this.a;
        dc dcVar2 = null;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            relativeLayout2 = null;
        }
        dc dcVar3 = this.b;
        if (dcVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
        } else {
            dcVar2 = dcVar3;
        }
        relativeLayout2.addView(dcVar2.d(), c());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        zb zbVar = this.c;
        dc dcVar = null;
        if (zbVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNativeBridge");
            zbVar = null;
        }
        zbVar.a();
        RelativeLayout relativeLayout = this.a;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            relativeLayout = null;
        }
        relativeLayout.removeAllViews();
        dc dcVar2 = this.b;
        if (dcVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
        } else {
            dcVar = dcVar2;
        }
        dcVar.a();
        super.onDestroy();
    }

    public void onUIReady() {
        runOnUiThread(new TestSuiteActivity$$ExternalSyntheticLambda0(this));
    }
}
