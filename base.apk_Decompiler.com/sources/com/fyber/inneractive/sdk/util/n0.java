package com.fyber.inneractive.sdk.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class n0 extends Handler {
    public final WeakReference<o0> a;

    public n0(Looper looper, o0 o0Var) {
        super(looper);
        this.a = new WeakReference<>(o0Var);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        o0 o0Var = (o0) u.a(this.a);
        if (o0Var != null) {
            o0Var.handleMessage(message);
        }
    }
}
