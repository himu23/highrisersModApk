package com.ironsource;

import android.os.Handler;
import android.os.Message;
import com.ironsource.sdk.utils.IronSourceStorageUtils;

class mb implements Runnable {
    private final Handler a;
    private final n3 b;

    mb(n3 n3Var, Handler handler) {
        this.b = n3Var;
        this.a = handler;
    }

    /* access modifiers changed from: package-private */
    public Message a() {
        return new Message();
    }

    /* access modifiers changed from: package-private */
    public o4 a(n3 n3Var, String str, long j) {
        return new o4(n3Var, str, j);
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        return IronSourceStorageUtils.makeDir(str);
    }

    public void run() {
        int b2;
        n6 n6Var = new n6(this.b.b().getParent(), this.b.b().getName());
        Message a2 = a();
        a2.obj = n6Var;
        String a3 = a(n6Var.getParent());
        if (a3 == null) {
            b2 = 1020;
        } else {
            o3 a4 = a(new n3(n6Var, this.b.e(), this.b.a(), this.b.c(), this.b.d()), a3, 3).call();
            b2 = a4.b() == 200 ? 1016 : a4.b();
        }
        a2.what = b2;
        this.a.sendMessage(a2);
    }
}
