package com.fyber.inneractive.sdk.web;

import android.content.Context;
import android.content.IntentFilter;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.i;

public class j implements Runnable {
    public final /* synthetic */ i a;

    public j(i iVar) {
        this.a = iVar;
    }

    public void run() {
        i iVar = this.a;
        if (iVar.W == null) {
            try {
                IAlog.a("%sregistering orientation broadcast receiver", IAlog.a((Object) iVar));
                this.a.W = new i.k();
                if (this.a.l() != null) {
                    i iVar2 = this.a;
                    i<T>.k kVar = iVar2.W;
                    Context l = iVar2.l();
                    i iVar3 = i.this;
                    iVar3.getClass();
                    IAlog.a("%sregister screen broadcast receiver", IAlog.a((Object) iVar3));
                    kVar.a = l;
                    l.registerReceiver(kVar, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
                }
            } catch (Exception e) {
                i iVar4 = this.a;
                iVar4.getClass();
                IAlog.e("%sfailed registering orientation broadcast recevier", IAlog.a((Object) iVar4));
                if (IAlog.a >= 3) {
                    e.printStackTrace();
                }
            }
        }
    }
}
