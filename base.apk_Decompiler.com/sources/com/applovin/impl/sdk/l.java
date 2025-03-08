package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.r;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class l implements AppLovinBroadcastManager.Receiver {
    private static AlertDialog aAu;
    private static final AtomicBoolean aAv = new AtomicBoolean();
    private final m aAt;
    private r ayU;

    public interface a {
        void Be();

        void Bf();
    }

    l(m mVar, n nVar) {
        this.aAt = mVar;
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    public void a(long j, n nVar, a aVar) {
        if (j > 0) {
            AlertDialog alertDialog = aAu;
            if (alertDialog == null || !alertDialog.isShowing()) {
                if (aAv.getAndSet(true)) {
                    if (j < this.ayU.AH()) {
                        nVar.BN();
                        if (x.Fn()) {
                            x BN = nVar.BN();
                            BN.f("ConsentAlertManager", "Scheduling consent alert earlier (" + j + "ms) than remaining scheduled time (" + this.ayU.AH() + "ms)");
                        }
                        this.ayU.tT();
                    } else {
                        nVar.BN();
                        if (x.Fn()) {
                            x BN2 = nVar.BN();
                            BN2.h("ConsentAlertManager", "Skip scheduling consent alert - one scheduled already with remaining time of " + this.ayU.AH() + " milliseconds");
                            return;
                        }
                        return;
                    }
                }
                nVar.BN();
                if (x.Fn()) {
                    x BN3 = nVar.BN();
                    BN3.f("ConsentAlertManager", "Scheduling consent alert for " + j + " milliseconds");
                }
                this.ayU = r.b(j, nVar, new l$$ExternalSyntheticLambda2(this, nVar, aVar));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(n nVar, a aVar) {
        if (this.aAt.Bg()) {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().i("ConsentAlertManager", "Consent dialog already showing, skip showing of consent alert");
                return;
            }
            return;
        }
        Activity Az = nVar.BM().Az();
        if (Az == null || !i.aa(n.getApplicationContext())) {
            if (Az == null) {
                nVar.BN();
                if (x.Fn()) {
                    nVar.BN().i("ConsentAlertManager", "No parent Activity found - rescheduling consent alert...");
                }
            } else {
                nVar.BN();
                if (x.Fn()) {
                    nVar.BN().i("ConsentAlertManager", "No internet available - rescheduling consent alert...");
                }
            }
            aAv.set(false);
            a(((Long) nVar.a(b.aLf)).longValue(), nVar, aVar);
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new l$$ExternalSyntheticLambda3(this, nVar, aVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(n nVar, a aVar) {
        AlertDialog create = new AlertDialog.Builder(nVar.BM().Az()).setTitle((CharSequence) nVar.a(b.aLg)).setMessage((CharSequence) nVar.a(b.aLh)).setCancelable(false).setPositiveButton((CharSequence) nVar.a(b.aLi), new l$$ExternalSyntheticLambda0(aVar)).setNegativeButton((CharSequence) nVar.a(b.aLj), new l$$ExternalSyntheticLambda1(this, aVar, nVar)).create();
        aAu = create;
        create.show();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, DialogInterface dialogInterface, int i) {
        aVar.Be();
        dialogInterface.dismiss();
        aAv.set(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(a aVar, n nVar, DialogInterface dialogInterface, int i) {
        aVar.Bf();
        dialogInterface.dismiss();
        aAv.set(false);
        a(((Long) nVar.a(b.aLe)).longValue(), nVar, aVar);
    }

    public void onReceive(Intent intent, Map<String, Object> map) {
        if (this.ayU != null) {
            String action = intent.getAction();
            if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
                this.ayU.pause();
            } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
                this.ayU.resume();
            }
        }
    }
}
