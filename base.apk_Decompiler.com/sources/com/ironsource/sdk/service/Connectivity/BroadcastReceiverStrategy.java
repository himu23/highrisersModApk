package com.ironsource.sdk.service.Connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.ironsource.a5;
import com.ironsource.b5;
import com.ironsource.l2;
import org.json.JSONObject;

public class BroadcastReceiverStrategy implements a5 {
    /* access modifiers changed from: private */
    public final b5 a;
    private BroadcastReceiver b = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String b = l2.b(context);
            if (b.equals("none")) {
                BroadcastReceiverStrategy.this.a.a();
            } else {
                BroadcastReceiverStrategy.this.a.a(b, new JSONObject());
            }
        }
    };

    public BroadcastReceiverStrategy(b5 b5Var) {
        this.a = b5Var;
    }

    public void a() {
        this.b = null;
    }

    public void a(Context context) {
        try {
            context.unregisterReceiver(this.b);
        } catch (IllegalArgumentException unused) {
        } catch (Exception e) {
            Log.e("ContentValues", "unregisterConnectionReceiver - " + e);
        }
    }

    public void b(Context context) {
        try {
            context.registerReceiver(this.b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject c(Context context) {
        return new JSONObject();
    }
}
