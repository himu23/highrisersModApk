package com.ironsource;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import org.json.JSONObject;

public class j9 implements a5 {
    private String a = "j9";
    private int b = 23;
    /* access modifiers changed from: private */
    public final b5 c;
    private ConnectivityManager.NetworkCallback d;

    class a extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        public void onAvailable(Network network) {
            if (network != null) {
                j9.this.c.a(l2.a(network, this.a), l2.a(this.a, network));
                return;
            }
            b5 a2 = j9.this.c;
            String b2 = l2.b(this.a);
            Context context = this.a;
            a2.a(b2, l2.a(context, l2.a(context)));
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (network != null) {
                j9.this.c.b(l2.a(network, this.a), l2.a(this.a, network));
            }
        }

        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            if (network != null) {
                j9.this.c.b(l2.a(network, this.a), l2.a(this.a, network));
            }
        }

        public void onLost(Network network) {
            if (l2.b(this.a).equals("none")) {
                j9.this.c.a();
            }
        }
    }

    public j9(b5 b5Var) {
        this.c = b5Var;
    }

    public void a() {
        this.d = null;
    }

    public void a(Context context) {
        ConnectivityManager connectivityManager;
        if (Build.VERSION.SDK_INT >= this.b && this.d != null && context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            try {
                connectivityManager.unregisterNetworkCallback(this.d);
            } catch (Exception unused) {
                Log.e(this.a, "NetworkCallback for was not registered or already unregistered");
            }
        }
    }

    public void b(Context context) {
        if (Build.VERSION.SDK_INT >= this.b) {
            a(context);
            if (l2.b(context).equals("none")) {
                this.c.a();
            }
            if (this.d == null) {
                this.d = new a(context);
            }
            NetworkRequest build = new NetworkRequest.Builder().addCapability(12).build();
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    connectivityManager.registerNetworkCallback(build, this.d);
                }
            } catch (Exception unused) {
                Log.e(this.a, "NetworkCallback was not able to register");
            }
        }
    }

    public JSONObject c(Context context) {
        return l2.a(context, l2.a(context));
    }
}
