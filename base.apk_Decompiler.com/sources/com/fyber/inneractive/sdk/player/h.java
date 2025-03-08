package com.fyber.inneractive.sdk.player;

import android.view.View;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveError;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.external.InneractiveVideoError;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.flow.m;
import com.fyber.inneractive.sdk.model.vast.o;
import com.fyber.inneractive.sdk.model.vast.t;
import com.fyber.inneractive.sdk.network.m0;
import com.fyber.inneractive.sdk.network.n0;
import com.fyber.inneractive.sdk.network.q;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.player.a;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.response.g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.c;
import java.util.Iterator;
import org.json.JSONObject;

public class h implements g {
    public a a;
    public InneractiveAdRequest b;
    public g c;
    public b d;
    public o e;
    public a.C0105a f;
    public boolean g = false;
    public s h;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.fyber.inneractive.sdk.external.InneractiveVideoError$Error[] r0 = com.fyber.inneractive.sdk.external.InneractiveVideoError.Error.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.fyber.inneractive.sdk.external.InneractiveVideoError$Error r1 = com.fyber.inneractive.sdk.external.InneractiveVideoError.Error.ERROR_NO_MEDIA_FILES     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fyber.inneractive.sdk.external.InneractiveVideoError$Error r1 = com.fyber.inneractive.sdk.external.InneractiveVideoError.Error.ERROR_FAILED_PLAYING_MEDIA_FILE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fyber.inneractive.sdk.external.InneractiveVideoError$Error r1 = com.fyber.inneractive.sdk.external.InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fyber.inneractive.sdk.external.InneractiveVideoError$Error r1 = com.fyber.inneractive.sdk.external.InneractiveVideoError.Error.ERROR_PRE_BUFFER_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fyber.inneractive.sdk.external.InneractiveVideoError$Error r1 = com.fyber.inneractive.sdk.external.InneractiveVideoError.Error.ERROR_BUFFER_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.h.a.<clinit>():void");
        }
    }

    public interface b {
    }

    public h(g gVar, InneractiveAdRequest inneractiveAdRequest, f0 f0Var, b bVar) {
        this.b = inneractiveAdRequest;
        this.c = gVar;
        this.d = bVar;
        this.h = f0Var.b();
        this.a = new a(f0Var);
    }

    public final q a(InneractiveVideoError.Error error) {
        int i = a.a[error.ordinal()];
        if (i == 1) {
            return q.VAST_ERROR_NO_MEDIA_FILES;
        }
        if (i == 2) {
            return q.VAST_ERROR_FAILED_PLAYING_MEDIA_FILE;
        }
        if (i == 3) {
            return q.VAST_ERROR_FAILED_PLAYING_ALL_MEDIA_FILES;
        }
        if (i == 4) {
            return q.VAST_ERROR_PRE_BUFFER_TIMEOUT;
        }
        if (i == 5) {
            return q.VAST_ERROR_BUFFER_TIMEOUT;
        }
        IAlog.a("IAReportError, Does not know player error " + error.getErrorString(), new Object[0]);
        return q.VAST_UNKNOWN_PLAYER_ERROR;
    }

    public final void b() {
        new s.a(a(new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES).getPlayerError()), this.b, (e) this.c, this.h.c()).a((String) null);
    }

    public a.C0105a c() {
        return this.f;
    }

    public final void e() {
        try {
            this.f = this.a.a();
        } catch (Throwable th) {
            b bVar = this.d;
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.g.COULD_NOT_CREATE_FLOW_MANAGER, th);
            com.fyber.inneractive.sdk.flow.o oVar = (com.fyber.inneractive.sdk.flow.o) bVar;
            oVar.a((InneractiveError) inneractiveInfrastructureError);
            oVar.a(inneractiveInfrastructureError);
        }
    }

    public final void d() {
        a.C0105a aVar = this.f;
        if (aVar != null) {
            o oVar = this.e;
            e eVar = (e) aVar;
            eVar.r = this;
            if (oVar != null) {
                String str = oVar.g;
                eVar.t = oVar;
                eVar.q++;
                eVar.n = false;
                eVar.p = false;
                eVar.c = str;
                IAlog.a("IAMediaPlayerFlowManager: playNextMediaFile - loading video url: %s", str);
                com.fyber.inneractive.sdk.util.s sVar = eVar.l;
                if (sVar != null) {
                    sVar.d();
                    eVar.m = null;
                }
                if (eVar.m == null) {
                    eVar.m = new b(eVar);
                }
                IAlog.a("IAMediaPlayerFlowManager: start - start fetching video frame", new Object[0]);
                if (!eVar.b.a()) {
                    com.fyber.inneractive.sdk.util.s sVar2 = new com.fyber.inneractive.sdk.util.s(eVar.a.getFilesDir(), eVar.m, eVar.c, (String) null, 81920);
                    eVar.l = sVar2;
                    sVar2.a().post(new c(sVar2, (Object[]) null));
                }
                if (!eVar.o) {
                    eVar.b.a(str, eVar.s);
                }
                m mVar = eVar.z;
                if (mVar != null) {
                    mVar.b();
                    return;
                }
                return;
            }
            return;
        }
        b bVar = this.d;
        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.g.COULD_NOT_LOAD_USING_FLOW_MANAGER, new Exception("loadNextMediaFile flowManager is null"));
        com.fyber.inneractive.sdk.flow.o oVar2 = (com.fyber.inneractive.sdk.flow.o) bVar;
        oVar2.a((InneractiveError) inneractiveInfrastructureError);
        oVar2.a(inneractiveInfrastructureError);
    }

    public void a() {
        a.C0105a aVar = this.a.b;
        if (aVar != null) {
            e eVar = (e) aVar;
            eVar.o = true;
            IAlog.a("IAMediaPlayerFlowManager: destroy", new Object[0]);
            View b2 = eVar.b();
            if (b2 != null && (b2 instanceof com.fyber.inneractive.sdk.web.g)) {
                ((com.fyber.inneractive.sdk.web.g) b2).destroy();
            }
            com.fyber.inneractive.sdk.util.s sVar = eVar.l;
            if (sVar != null) {
                sVar.d();
                eVar.m = null;
            }
            com.fyber.inneractive.sdk.player.controller.g gVar = eVar.b;
            if (gVar != null) {
                gVar.b();
                eVar.b = null;
            }
            eVar.k = null;
            eVar.r = null;
            m mVar = eVar.z;
            if (mVar != null) {
                Iterator<com.fyber.inneractive.sdk.flow.vast.a> it = mVar.l.iterator();
                while (it.hasNext()) {
                    com.fyber.inneractive.sdk.flow.vast.a next = it.next();
                    if (next.b != null && (next instanceof com.fyber.inneractive.sdk.flow.vast.e)) {
                        next.a();
                    }
                }
                mVar.m.a();
                n0 n0Var = mVar.h;
                if (n0Var != null) {
                    n0Var.a = true;
                }
                m0 m0Var = mVar.i;
                if (m0Var != null) {
                    m0Var.a = true;
                }
            }
            eVar.z = null;
        }
    }

    public void a(InneractiveVideoError inneractiveVideoError, InneractiveErrorCode inneractiveErrorCode, JSONObject jSONObject, boolean z) {
        com.fyber.inneractive.sdk.flow.g gVar;
        InneractiveErrorCode inneractiveErrorCode2;
        com.fyber.inneractive.sdk.model.vast.b bVar;
        if (jSONObject == null && inneractiveVideoError != null) {
            jSONObject = new JSONObject();
            ((e) this.f).b(inneractiveVideoError, jSONObject);
        }
        com.fyber.inneractive.sdk.flow.g gVar2 = com.fyber.inneractive.sdk.flow.g.UNSPECIFIED;
        if (inneractiveVideoError != null) {
            s.a aVar = new s.a(a(inneractiveVideoError.getPlayerError()), this.b, (e) this.c, this.h.c());
            if (jSONObject != null) {
                try {
                    aVar.f.put(new JSONObject(jSONObject.toString()));
                } catch (Exception unused) {
                }
            }
            aVar.a((String) null);
        }
        if (InneractiveErrorCode.NON_SECURE_CONTENT_DETECTED == null) {
            new s.a(q.VPAID_ERROR_UNSECURE_CONTENT, this.b, (e) this.c, this.h.c()).a((String) null);
        }
        if (inneractiveVideoError != null) {
            IAlog.a("got onMediaPlayerLoadError with: " + inneractiveVideoError.getPlayerError(), new Object[0]);
            if (z) {
                inneractiveErrorCode2 = InneractiveErrorCode.LOAD_TIMEOUT;
                gVar = com.fyber.inneractive.sdk.flow.g.VIDEO_AD_LOAD_TIMEOUT;
            } else {
                gVar = gVar2;
                inneractiveErrorCode2 = null;
            }
            IAlog.a("got onMediaPlayerLoadError with: " + inneractiveVideoError.description(), new Object[0]);
            if (inneractiveVideoError.getPlayerError().isFatal()) {
                inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
                gVar = com.fyber.inneractive.sdk.flow.g.VIDEO_FATAL_ERROR;
            }
            if (inneractiveErrorCode2 == null) {
                inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
                gVar = com.fyber.inneractive.sdk.flow.g.VIDEO_ERROR_UNSPECIFIED;
            }
        } else {
            gVar = gVar2;
            inneractiveErrorCode2 = null;
        }
        if (!z) {
            this.e = null;
            g gVar3 = this.c;
            if (!(gVar3 == null || (bVar = gVar3.K) == null)) {
                this.e = bVar.d.poll();
            }
            if (this.e == null) {
                b();
                b bVar2 = this.d;
                if (bVar2 != null) {
                    if (inneractiveVideoError != null) {
                        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(inneractiveErrorCode2, gVar, inneractiveVideoError.getCause());
                        com.fyber.inneractive.sdk.flow.o oVar = (com.fyber.inneractive.sdk.flow.o) bVar2;
                        oVar.a((InneractiveError) inneractiveInfrastructureError);
                        oVar.a(inneractiveInfrastructureError);
                    } else {
                        InneractiveInfrastructureError inneractiveInfrastructureError2 = new InneractiveInfrastructureError(inneractiveErrorCode2, com.fyber.inneractive.sdk.flow.g.VIDEO_ERROR_NULL);
                        com.fyber.inneractive.sdk.flow.o oVar2 = (com.fyber.inneractive.sdk.flow.o) bVar2;
                        oVar2.a((InneractiveError) inneractiveInfrastructureError2);
                        oVar2.a(inneractiveInfrastructureError2);
                    }
                    a();
                }
            } else if (!this.g) {
                e();
                d();
            }
        }
    }

    public void a(String str, String... strArr) {
        a.C0105a aVar = this.f;
        if (aVar != null) {
            e eVar = (e) aVar;
            eVar.getClass();
            if ("TRACKING_COMPLETED".equalsIgnoreCase(str)) {
                eVar.x = true;
            } else if ("EVENT_TRACKING".equalsIgnoreCase(str)) {
                for (String a2 : strArr) {
                    eVar.a(eVar.v, VideoClickOrigin.InvalidOrigin, t.a(a2));
                }
            }
        }
    }
}
