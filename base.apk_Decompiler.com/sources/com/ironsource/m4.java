package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;

public class m4 extends Handler {
    private final ConcurrentHashMap<String, y9> a = new ConcurrentHashMap<>();

    public m4(Looper looper) {
        super(looper);
    }

    private boolean a(int i) {
        return i == 1016 || i == 1015;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, y9 y9Var) {
        if (str != null && y9Var != null) {
            this.a.put(str, y9Var);
        }
    }

    public void handleMessage(Message message) {
        try {
            n6 n6Var = (n6) message.obj;
            String path = n6Var.getPath();
            y9 y9Var = this.a.get(path);
            if (y9Var != null) {
                if (a(message.what)) {
                    y9Var.a(n6Var);
                } else {
                    int i = message.what;
                    y9Var.a(n6Var, new f6(i, sc.a(i)));
                }
                this.a.remove(path);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
