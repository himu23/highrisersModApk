package com.applovin.impl.sdk.a;

import android.content.Context;
import android.util.Log;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.iab.omid.library.applovin.Omid;
import com.iab.omid.library.applovin.ScriptInjector;
import com.iab.omid.library.applovin.adsession.Partner;
import com.ironsource.m2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class f {
    private final Context E = n.getApplicationContext();
    private String aIE;
    private final n sdk;

    public String IT() {
        return this.aIE;
    }

    public f(n nVar) {
        this.sdk = nVar;
    }

    public void uB() {
        if (((Boolean) this.sdk.a(b.aKQ)).booleanValue()) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                BN.f("OpenMeasurementService", "Initializing Open Measurement SDK v" + getSdkVersion() + "...");
            }
            AppLovinSdkUtils.runOnUiThread(new f$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void IW() {
        long currentTimeMillis = System.currentTimeMillis();
        Omid.activate(this.E);
        this.sdk.BN();
        if (x.Fn()) {
            x BN = this.sdk.BN();
            StringBuilder sb = new StringBuilder("Init ");
            sb.append(isInitialized() ? "succeeded" : m2.h.t);
            sb.append(" and took ");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            sb.append("ms");
            BN.f("OpenMeasurementService", sb.toString());
        }
        IU();
    }

    public boolean isInitialized() {
        return Omid.isActive();
    }

    public String getSdkVersion() {
        return Omid.getVersion();
    }

    public Partner getPartner() {
        return Partner.createPartner((String) this.sdk.a(b.aKR), AppLovinSdk.VERSION);
    }

    private void IU() {
        this.sdk.BO().a((d) new ab(this.sdk, "OpenMeasurementService", new f$$ExternalSyntheticLambda1(this)), q.b.BACKGROUND);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void IV() {
        if (this.aIE == null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.E.getResources().openRawResource(R.raw.omsdk_v_1_0)));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            this.aIE = sb.toString();
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e) {
                                Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e);
                                return;
                            }
                        }
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e2);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                this.sdk.BN();
                if (x.Fn()) {
                    this.sdk.BN().c("OpenMeasurementService", "Failed to retrieve resource omsdk_v_1_0.js", th2);
                }
            }
        }
    }

    public String dl(String str) {
        try {
            return ScriptInjector.injectScriptContentIntoHtml(this.aIE, str);
        } catch (Throwable th) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().c("OpenMeasurementService", "Failed to inject JavaScript SDK into HTML", th);
            }
            return str;
        }
    }
}
