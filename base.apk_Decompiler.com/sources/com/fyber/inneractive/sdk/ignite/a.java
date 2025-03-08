package com.fyber.inneractive.sdk.ignite;

import android.os.RemoteException;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback;
import com.fyber.inneractive.sdk.util.IAlog;
import com.ironsource.adapters.ironsource.IronSourceAdapter;
import org.json.JSONObject;

public class a extends IIgniteServiceCallback.Stub {
    public final n a;

    public a(n nVar) {
        this.a = nVar;
    }

    public void onError(String str) throws RemoteException {
        IAlog.a("AuthenticationCallback onError %s", str);
        this.a.b(str);
    }

    public void onProgress(String str) throws RemoteException {
        IAlog.a("AuthenticationCallback onProgress %s", str);
    }

    public void onScheduled(String str) throws RemoteException {
        IAlog.a("AuthenticationCallback onScheduled %s", str);
    }

    public void onStart(String str) throws RemoteException {
        IAlog.a("AuthenticationCallback onStart %s", str);
    }

    public void onSuccess(String str) throws RemoteException {
        String str2;
        IAlog.a("AuthenticationCallback onSuccess %s", str);
        try {
            str2 = new JSONObject(str).getJSONObject("data").getString(IronSourceAdapter.IRONSOURCE_BIDDING_TOKEN_KEY);
        } catch (Exception unused) {
            IAlog.a("Failed to resolve ignite clientToken", new Object[0]);
            str2 = null;
        }
        this.a.d(str2);
    }
}
