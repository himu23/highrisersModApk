package com.ironsource;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.sdk.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\r\u001a\u00020\u000b8\u0002XD¢\u0006\u0006\n\u0004\b\u0003\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/ironsource/q6;", "Landroid/widget/FrameLayout;", "Lcom/ironsource/wc;", "a", "Landroid/view/View;", "changedView", "", "visibility", "", "onVisibilityChanged", "onWindowVisibilityChanged", "", "Ljava/lang/String;", "logTag", "Lcom/ironsource/q6$a;", "b", "Lcom/ironsource/q6$a;", "getListener$mediationsdk_release", "()Lcom/ironsource/q6$a;", "setListener$mediationsdk_release", "(Lcom/ironsource/q6$a;)V", "listener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class q6 extends FrameLayout {
    private final String a = "ISNNativeAdContainer";
    private a b;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/ironsource/q6$a;", "", "Lcom/ironsource/wc;", "viewVisibilityParams", "", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public interface a {
        void a(wc wcVar);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q6(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final wc a() {
        boolean z = true;
        boolean z2 = getVisibility() == 0;
        if (getWindowVisibility() != 0) {
            z = false;
        }
        return new wc(z2, z, isShown());
    }

    public final a getListener$mediationsdk_release() {
        return this.b;
    }

    public void onVisibilityChanged(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "changedView");
        String str = this.a;
        Logger.i(str, "onVisibilityChanged: " + i);
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(a());
        }
    }

    public void onWindowVisibilityChanged(int i) {
        String str = this.a;
        Logger.i(str, "onWindowVisibilityChanged: " + i);
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(a());
        }
    }

    public final void setListener$mediationsdk_release(a aVar) {
        this.b = aVar;
    }
}
