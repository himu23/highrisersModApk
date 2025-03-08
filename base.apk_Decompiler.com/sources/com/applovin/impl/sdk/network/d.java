package com.applovin.impl.sdk.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class d extends BroadcastReceiver {
    private final List<a> amM = Collections.synchronizedList(new ArrayList());

    public interface a {
        void CQ();

        void CR();
    }

    public d(Context context) {
        context.getApplicationContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void a(a aVar) {
        this.amM.add(aVar);
    }

    public void b(a aVar) {
        this.amM.remove(aVar);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && !isInitialStickyBroadcast()) {
            ArrayList<a> arrayList = new ArrayList<>(this.amM);
            if (b(intent)) {
                for (a CQ : arrayList) {
                    CQ.CQ();
                }
                return;
            }
            for (a CR : arrayList) {
                CR.CR();
            }
        }
    }

    private static boolean b(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return false;
        }
        Object obj = extras.get("networkInfo");
        if (obj instanceof NetworkInfo) {
            return ((NetworkInfo) obj).isConnected();
        }
        return false;
    }
}
