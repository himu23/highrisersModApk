package com.fyber.inneractive.sdk.network;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.g;
import com.fyber.inneractive.sdk.metrics.c;
import com.fyber.inneractive.sdk.network.c0;
import com.fyber.inneractive.sdk.network.k;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.FileNotFoundException;

public class p extends k {
    public final InneractiveAdRequest e;
    public final d0 f;

    public class a implements w<e> {
        public a() {
        }

        public void a(Object obj, Exception exc, boolean z) {
            InneractiveErrorCode inneractiveErrorCode;
            k.a aVar;
            e eVar = (e) obj;
            if (exc == null) {
                p pVar = p.this;
                pVar.a(pVar.e, eVar);
                return;
            }
            p.this.getClass();
            if (exc instanceof t0) {
                if (((t0) exc).a == 204) {
                    inneractiveErrorCode = InneractiveErrorCode.NO_FILL;
                } else {
                    inneractiveErrorCode = InneractiveErrorCode.SERVER_INTERNAL_ERROR;
                }
            } else if (exc instanceof FileNotFoundException) {
                inneractiveErrorCode = InneractiveErrorCode.CONNECTION_ERROR;
            } else if (exc instanceof a0) {
                inneractiveErrorCode = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            } else {
                inneractiveErrorCode = InneractiveErrorCode.CONNECTION_ERROR;
            }
            p pVar2 = p.this;
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(inneractiveErrorCode, g.NETWORK_ERROR, exc);
            InneractiveAdRequest inneractiveAdRequest = pVar2.e;
            if (pVar2.a != null) {
                if (pVar2.b) {
                    IAlog.d("IARemoteAdFetcher: ignoring response. Previous request was cancelled", new Object[0]);
                } else if (!pVar2.b && (aVar = pVar2.a) != null) {
                    ((com.fyber.inneractive.sdk.flow.k) aVar).b(inneractiveAdRequest, eVar, inneractiveInfrastructureError);
                }
            }
        }
    }

    public class b implements c0.a {
        public b() {
        }

        public void a(String str) {
            str.getClass();
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1392135285:
                    if (str.equals("sdkInitNetworkRequest")) {
                        c = 0;
                        break;
                    }
                    break;
                case 740780854:
                    if (str.equals("sdkGotServerResponse")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1745989196:
                    if (str.equals("sdkParsedResponse")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    c.d.a(p.this.d).f();
                    return;
                case 1:
                    c.d.a(p.this.d).g();
                    return;
                case 2:
                    c.d.a(p.this.d).d();
                    return;
                default:
                    return;
            }
        }
    }

    public p(InneractiveAdRequest inneractiveAdRequest, String str, s sVar, k.a aVar) {
        super(sVar, str, aVar);
        this.e = inneractiveAdRequest;
        this.f = new d0(new a(), inneractiveAdRequest, sVar);
        c();
    }

    public void a() {
        super.a();
        this.f.a = true;
    }

    public String b() {
        return this.f.a();
    }

    public final void c() {
        this.f.d = new b();
    }

    public boolean d() {
        k.a aVar;
        this.b = false;
        IAlog.a("IARemoteAdFetcher: requestAd called", new Object[0]);
        InneractiveAdRequest inneractiveAdRequest = this.e;
        if (inneractiveAdRequest != null && TextUtils.isEmpty(inneractiveAdRequest.getSpotId())) {
            IAlog.b("appID is null or empty. Please provide a valid appID and re-try.", new Object[0]);
        } else if (!com.fyber.inneractive.sdk.util.p.b("android.permission.INTERNET")) {
            IAlog.b("INTERNET permission is missing. Please add it to the Manifest and re-try, otherwise ads will not be requested and displayed! ", new Object[0]);
        } else {
            if (!com.fyber.inneractive.sdk.util.p.b("android.permission.ACCESS_NETWORK_STATE")) {
                IAlog.b("It is recommended to add ACCESS_NETWORK_STATE permission to the Manifest for better targetting", new Object[0]);
            }
            if (!com.fyber.inneractive.sdk.util.p.b("android.permission.READ_PHONE_STATE")) {
                IAlog.e("It is recomended to add the READ_PHONE_STATE permission to the manifest for better targetting", new Object[0]);
            }
            IAConfigManager.M.s.b(this.f);
            return true;
        }
        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.INVALID_INPUT, g.VALIDATE_PARAMS_FAILED, new Exception("appID is null or empty or INTERNET permission is missing"));
        InneractiveAdRequest inneractiveAdRequest2 = this.e;
        if (!this.b && (aVar = this.a) != null) {
            ((com.fyber.inneractive.sdk.flow.k) aVar).b(inneractiveAdRequest2, (e) null, inneractiveInfrastructureError);
        }
        return false;
    }
}
