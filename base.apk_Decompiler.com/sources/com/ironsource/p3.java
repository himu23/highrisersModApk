package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ironsource.sdk.utils.Logger;

public class p3 extends Handler {
    private static final String b = "DownloadHandler";
    y9 a;

    public p3(Looper looper) {
        super(looper);
    }

    public void a() {
        this.a = null;
    }

    public void a(y9 y9Var) {
        if (y9Var != null) {
            this.a = y9Var;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void handleMessage(Message message) {
        y9 y9Var = this.a;
        if (y9Var == null) {
            Logger.i(b, "OnPreCacheCompletion listener is null, msg: " + message.toString());
            return;
        }
        try {
            int i = message.what;
            if (i != 1016) {
                this.a.a((n6) message.obj, new f6(i, sc.a(i)));
                return;
            }
            y9Var.a((n6) message.obj);
        } catch (Throwable th) {
            Logger.i(b, "handleMessage | Got exception: " + th.getMessage());
            th.printStackTrace();
        }
    }
}
