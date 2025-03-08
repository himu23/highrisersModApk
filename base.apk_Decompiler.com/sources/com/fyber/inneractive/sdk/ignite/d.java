package com.fyber.inneractive.sdk.ignite;

import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.util.IAlog;

public class d implements w<IgniteResponseOuterClass$IgniteResponse> {
    public final /* synthetic */ c a;

    public d(c cVar) {
        this.a = cVar;
    }

    public void a(Object obj, Exception exc, boolean z) {
        IgniteResponseOuterClass$IgniteResponse igniteResponseOuterClass$IgniteResponse = (IgniteResponseOuterClass$IgniteResponse) obj;
        if (exc != null || !igniteResponseOuterClass$IgniteResponse.hasClientId() || !igniteResponseOuterClass$IgniteResponse.hasClientSecret()) {
            Object[] objArr = new Object[1];
            objArr[0] = exc != null ? exc.getMessage() : "";
            IAlog.a("Failed to fetch ignite client credentials with error: %s", objArr);
            if (this.a.a(exc)) {
                this.a.a(i.FAILED_TO_RETRIEVE_CREDENTIALS, exc != null ? exc.getMessage() : null);
                return;
            }
            return;
        }
        this.a.e = igniteResponseOuterClass$IgniteResponse.getClientId();
        this.a.f = igniteResponseOuterClass$IgniteResponse.getClientSecret();
        this.a.a();
    }
}
