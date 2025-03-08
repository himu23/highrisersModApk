package com.fyber.inneractive.sdk.web;

import android.view.KeyEvent;
import android.view.View;
import com.fyber.inneractive.sdk.util.IAlog;

public class l implements View.OnKeyListener {
    public final /* synthetic */ i a;

    public l(i iVar) {
        this.a = iVar;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 4 || !this.a.o()) {
            return false;
        }
        IAlog.d("back button pressed while ad is expanded, ad will be collapsed.", new Object[0]);
        this.a.r();
        return true;
    }
}
