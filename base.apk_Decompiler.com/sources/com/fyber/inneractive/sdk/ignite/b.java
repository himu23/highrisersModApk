package com.fyber.inneractive.sdk.ignite;

import android.os.RemoteException;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback;
import com.fyber.inneractive.sdk.ignite.g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.r;

public class b extends IIgniteServiceCallback.Stub {
    public final g.b a;

    public b(g.b bVar) {
        this.a = bVar;
    }

    public void onError(String str) throws RemoteException {
        IAlog.a("CancelTaskCallback onError %s", str);
        ((r.e) this.a).a(false);
    }

    public void onProgress(String str) throws RemoteException {
        IAlog.a("CancelTaskCallback onProgress %s", str);
    }

    public void onScheduled(String str) throws RemoteException {
        IAlog.a("CancelTaskCallback onScheduled %s", str);
    }

    public void onStart(String str) throws RemoteException {
        IAlog.a("CancelTaskCallback onStart %s", str);
    }

    public void onSuccess(String str) throws RemoteException {
        IAlog.a("CancelTaskCallback onSuccess %s", str);
        ((r.e) this.a).a(true);
    }
}
