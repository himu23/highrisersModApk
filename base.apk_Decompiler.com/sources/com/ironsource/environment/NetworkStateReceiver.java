package com.ironsource.environment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.l9;

public class NetworkStateReceiver extends BroadcastReceiver {
    private ConnectivityManager a;
    /* access modifiers changed from: private */
    public l9 b;
    /* access modifiers changed from: private */
    public boolean c = false;

    class a implements Runnable {
        a() {
        }

        public void run() {
            if (NetworkStateReceiver.this.b != null) {
                NetworkStateReceiver.this.b.a(NetworkStateReceiver.this.c);
            }
        }
    }

    public NetworkStateReceiver(Context context, l9 l9Var) {
        this.b = l9Var;
        if (context != null) {
            this.a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0021 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a() {
        /*
            r4 = this;
            boolean r0 = r4.c
            android.net.ConnectivityManager r1 = r4.a
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001a
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()     // Catch:{ Exception -> 0x001a }
            if (r1 == 0) goto L_0x0016
            boolean r1 = r1.isConnectedOrConnecting()     // Catch:{ Exception -> 0x001a }
            if (r1 == 0) goto L_0x0016
            r1 = 1
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            r4.c = r1     // Catch:{ Exception -> 0x001a }
            goto L_0x001c
        L_0x001a:
            r4.c = r3
        L_0x001c:
            boolean r1 = r4.c
            if (r0 == r1) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r2 = 0
        L_0x0022:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.environment.NetworkStateReceiver.a():boolean");
    }

    private void b() {
        IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a());
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getExtras() != null && a()) {
            b();
        }
    }
}
