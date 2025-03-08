package com.fyber.inneractive.sdk.flow;

import android.os.Handler;
import android.os.HandlerThread;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveError;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.interfaces.a;
import com.fyber.inneractive.sdk.metrics.c;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.x0;
import com.ironsource.m2;
import com.unity3d.services.core.device.MimeTypes;
import org.json.JSONArray;

public abstract class h<Response extends e, Content extends q> implements com.fyber.inneractive.sdk.interfaces.a, a.b {
    public InneractiveAdRequest a;
    public Response b;
    public Content c;
    public a.C0100a d;
    public a.b e;
    public b0 f;
    public s g;
    public boolean h = false;
    public int i = 0;
    public com.fyber.inneractive.sdk.network.timeouts.content.a j;
    public b k = new b(this);
    public final Runnable l = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            h hVar = h.this;
            hVar.getClass();
            IAlog.a("%s : IAAdContentLoaderImpl : retry load ad task started execution", IAlog.a((Object) hVar));
            h.this.c();
        }
    }

    public void a() {
        this.k.a();
        d();
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public InneractiveInfrastructureError e() {
        g gVar = g.WEBVIEW_LOAD_TIMEOUT;
        Response response = this.b;
        if (MimeTypes.BASE_TYPE_VIDEO.equalsIgnoreCase((response == null || com.fyber.inneractive.sdk.response.a.a(response.g) != com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_VAST) ? m2.h.d : MimeTypes.BASE_TYPE_VIDEO)) {
            gVar = g.VIDEO_AD_LOAD_TIMEOUT;
        }
        return new InneractiveInfrastructureError(InneractiveErrorCode.LOAD_TIMEOUT, gVar);
    }

    public abstract String f();

    public b0 g() {
        InneractiveAdRequest inneractiveAdRequest = this.a;
        return inneractiveAdRequest == null ? this.f : inneractiveAdRequest.getSelectedUnitConfig();
    }

    public void h() {
        String str;
        this.k.a();
        InneractiveAdRequest inneractiveAdRequest = this.a;
        if (inneractiveAdRequest != null) {
            str = inneractiveAdRequest.b;
        } else {
            Response response = this.b;
            if (response == null || (str = response.z) == null) {
                str = null;
            }
        }
        c.d.a(str).i();
        Content content = this.c;
        if (content != null) {
            content.a(str);
        }
        a.C0100a aVar = this.d;
        if (aVar != null) {
            aVar.a(this.a);
        }
    }

    public abstract void j();

    public final void k() {
        int i2 = this.i;
        this.i = i2 + 1;
        int a2 = a(i2);
        IAlog.a("%s : IAAdContentLoaderImpl : Start timeout: %d, attempt number: %d", IAlog.a((Object) this), Integer.valueOf(a2), Integer.valueOf(this.i - 1));
        b bVar = this.k;
        if (bVar.a == null) {
            HandlerThread handlerThread = new HandlerThread("TimeoutHandlerThread");
            handlerThread.start();
            bVar.a = new Handler(handlerThread.getLooper());
        }
        bVar.a.postDelayed(bVar.d, (long) a2);
        j();
    }

    public void b() {
        InneractiveInfrastructureError inneractiveInfrastructureError;
        IAlog.a("%s : IAAdContentLoaderImpl : onTimeout() attempt: %d timeout: %d", IAlog.a((Object) this), Integer.valueOf(this.i - 1), Integer.valueOf(a(this.i - 1)));
        a.b bVar = this.e;
        if (bVar != null) {
            bVar.b();
        }
        if (i()) {
            inneractiveInfrastructureError = e();
        } else {
            inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.IN_FLIGHT_TIMEOUT, g.NO_TIME_TO_LOAD_AD_CONTENT);
        }
        a((InneractiveError) inneractiveInfrastructureError);
        a(inneractiveInfrastructureError);
    }

    public void c() {
        IAlog.a("%s : IAAdContentLoaderImpl : onRetry() attempt: %d timeout: %d", IAlog.a((Object) this), Integer.valueOf(this.i - 1), Integer.valueOf(a(this.i - 1)));
        a.b bVar = this.e;
        if (bVar != null) {
            bVar.c();
        }
        k();
    }

    public void d() {
        IAlog.a("%s: IAAdContentLoaderImpl : cancel load ad content retry task", IAlog.a((Object) this));
        com.fyber.inneractive.sdk.util.q.b.removeCallbacks(this.l);
    }

    public boolean i() {
        com.fyber.inneractive.sdk.network.timeouts.content.a aVar = this.j;
        return this.i <= (aVar != null ? aVar.a : 0);
    }

    public void a(InneractiveAdRequest inneractiveAdRequest, e eVar, s sVar, a.C0100a aVar, a.b bVar) {
        this.a = inneractiveAdRequest;
        this.b = eVar;
        this.d = aVar;
        this.e = bVar;
        this.k = new b(this);
        this.g = sVar;
        this.j = new com.fyber.inneractive.sdk.network.timeouts.content.a(x0.a(eVar), com.fyber.inneractive.sdk.response.a.a(eVar.g) == com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_VAST ? MimeTypes.BASE_TYPE_VIDEO : m2.h.d, (int) eVar.I, eVar.B, IAConfigManager.M.m, this.g);
        if (this.a == null) {
            this.f = com.fyber.inneractive.sdk.config.a.b(eVar.m);
        }
        try {
            k();
        } catch (Throwable th) {
            IAlog.e("Failed to start ContentLoader", IAlog.a((Object) this));
            t.a(th, inneractiveAdRequest, eVar);
            this.k.a();
            a(new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, g.CONTENT_LOADER_START_FAILED));
        }
    }

    public void a(InneractiveError inneractiveError) {
        com.fyber.inneractive.sdk.util.q.a(new c(new d(this.b, this.a, f(), this.g.c()), inneractiveError));
    }

    public int a(int i2) {
        com.fyber.inneractive.sdk.network.timeouts.content.a aVar = this.j;
        if (aVar != null) {
            return aVar.a(i2);
        }
        return 0;
    }

    public void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        IAlog.a("%s : IAAdContentLoaderImpl : Handle Retry for error: %s", IAlog.a((Object) this), inneractiveInfrastructureError.getErrorCode().toString());
        this.k.b();
        boolean i2 = i();
        IAlog.a("%s : IAAdContentLoaderImpl : should retry: %s", IAlog.a((Object) this), Boolean.valueOf(i2));
        JSONArray jSONArray = null;
        if (i2) {
            Content content = this.c;
            if (content != null) {
                content.a();
                this.c = null;
            }
            com.fyber.inneractive.sdk.network.timeouts.content.a aVar = this.j;
            int i3 = aVar != null ? aVar.e : 0;
            IAlog.a("%s : IAAdContentLoaderImpl : retryLoad : post load ad content retry task with delay: %d", IAlog.a((Object) this), Integer.valueOf(i3));
            com.fyber.inneractive.sdk.util.q.b.postDelayed(this.l, (long) i3);
            return;
        }
        a.C0100a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.a(inneractiveInfrastructureError);
        }
        a();
        InneractiveAdRequest inneractiveAdRequest = this.a;
        Response response = this.b;
        s sVar = this.g;
        if (sVar != null) {
            jSONArray = sVar.c();
        }
        a.a(inneractiveAdRequest, inneractiveInfrastructureError, this.c, response, jSONArray);
    }
}
