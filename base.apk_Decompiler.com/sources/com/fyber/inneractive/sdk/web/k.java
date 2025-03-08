package com.fyber.inneractive.sdk.web;

import android.window.OnBackInvokedCallback;
import com.fyber.inneractive.sdk.util.IAlog;

public class k implements OnBackInvokedCallback {
    public final /* synthetic */ i a;

    public k(i iVar) {
        this.a = iVar;
    }

    public void onBackInvoked() {
        i iVar = this.a;
        if (iVar.o()) {
            IAlog.d("back button pressed while ad is expanded, ad will be collapsed.", new Object[0]);
            iVar.r();
        }
    }
}
