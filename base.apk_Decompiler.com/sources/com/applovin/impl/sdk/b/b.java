package com.applovin.impl.sdk.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinSdkUtils;

public class b {
    private final Activity aIZ;
    private AlertDialog aJa;
    private a aJb;
    private final n sdk;

    public interface a {
        void sR();

        void sS();
    }

    public void a(a aVar) {
        this.aJb = aVar;
    }

    public b(Activity activity, n nVar) {
        this.sdk = nVar;
        this.aIZ = activity;
    }

    public void Jw() {
        this.aIZ.runOnUiThread(new b$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void JA() {
        AlertDialog alertDialog = this.aJa;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jz() {
        this.aJa = new AlertDialog.Builder(this.aIZ).setTitle((CharSequence) this.sdk.a(com.applovin.impl.sdk.c.b.aMh)).setMessage((CharSequence) this.sdk.a(com.applovin.impl.sdk.c.b.aMi)).setCancelable(false).setPositiveButton((CharSequence) this.sdk.a(com.applovin.impl.sdk.c.b.aMk), new b$$ExternalSyntheticLambda4(this)).setNegativeButton((CharSequence) this.sdk.a(com.applovin.impl.sdk.c.b.aMj), new b$$ExternalSyntheticLambda5(this)).show();
    }

    public void Jx() {
        this.aIZ.runOnUiThread(new b$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(DialogInterface dialogInterface, int i) {
        this.aJb.sR();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
        this.aJb.sS();
    }

    public void a(e eVar, Runnable runnable) {
        this.aIZ.runOnUiThread(new b$$ExternalSyntheticLambda0(this, eVar, runnable));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(e eVar, Runnable runnable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.aIZ);
        builder.setTitle(eVar.Hd());
        String He = eVar.He();
        if (AppLovinSdkUtils.isValidString(He)) {
            builder.setMessage(He);
        }
        builder.setPositiveButton(eVar.Hf(), new b$$ExternalSyntheticLambda3(runnable));
        builder.setCancelable(false);
        this.aJa = builder.show();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Runnable runnable, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public boolean Jy() {
        AlertDialog alertDialog = this.aJa;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }
}
