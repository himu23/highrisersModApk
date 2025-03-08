package com.fyber.inneractive.sdk.bidder;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.k0;
import com.fyber.inneractive.sdk.util.n;

public class b extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ a a;

    public b(a aVar) {
        this.a = aVar;
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        k0 k0Var = k0.UNKNOWN;
        if (networkCapabilities.hasTransport(3)) {
            k0Var = k0.ETHERNET;
        } else if (networkCapabilities.hasTransport(0)) {
            k0Var = n.j() == 13 ? k0.MOBILE_4G : k0.MOBILE_3G;
        } else if (networkCapabilities.hasTransport(1)) {
            k0Var = k0.WIFI;
        }
        if (!TextUtils.equals(this.a.c.q, k0Var.key)) {
            a aVar = this.a;
            aVar.c.q = k0Var.key;
            aVar.b();
        }
    }
}
