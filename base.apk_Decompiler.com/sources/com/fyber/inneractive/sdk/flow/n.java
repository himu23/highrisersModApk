package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.features.l;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveError;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.measurement.a;
import com.fyber.inneractive.sdk.measurement.tracker.c;
import com.fyber.inneractive.sdk.network.q;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.response.f;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.k;
import com.fyber.inneractive.sdk.web.d;
import com.fyber.inneractive.sdk.web.i;
import org.json.JSONArray;

public class n extends h<f, b0> {
    public IAmraidWebViewController m;
    public d.C0138d n = new a();

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType[] r0 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.REWARDED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.n.b.<clinit>():void");
        }
    }

    public void a() {
        l();
        super.a();
    }

    public void b() {
        l();
        super.b();
    }

    public InneractiveInfrastructureError e() {
        com.fyber.inneractive.sdk.network.timeouts.content.a aVar = this.j;
        int a2 = aVar != null ? aVar.a(this.i) : 0;
        return new InneractiveInfrastructureError(InneractiveErrorCode.LOAD_TIMEOUT, g.WEBVIEW_LOAD_TIMEOUT, new Exception("LoadTimeout after " + a2 + " ms"));
    }

    public String f() {
        return "send_failed_display_creatives";
    }

    public void j() {
        i.f fVar;
        String str;
        Content b0Var = new b0(g(), this.g);
        this.c = b0Var;
        f fVar2 = this.b;
        b0Var.b = fVar2;
        b0Var.f = this.h;
        com.fyber.inneractive.sdk.measurement.a aVar = null;
        UnitDisplayType unitDisplayType = fVar2 != null ? fVar2.n : null;
        i.C0139i iVar = i.C0139i.INLINE;
        if (unitDisplayType == null) {
            this.n.a((d) null, new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, g.EMPTY_UNIT_DISPLAY_TYPE, new Exception("Unit display type was not found")));
            return;
        }
        int i = b.a[unitDisplayType.ordinal()];
        boolean z = true;
        if (i == 1 || i == 2) {
            fVar = i.f.ENABLED;
            InneractiveAdRequest inneractiveAdRequest = this.a;
            if (inneractiveAdRequest == null || inneractiveAdRequest.getAllowFullscreen()) {
                iVar = i.C0139i.INTERSTITIAL;
            }
        } else {
            fVar = i.f.ENABLED;
        }
        i.C0139i iVar2 = iVar;
        i.f fVar3 = fVar;
        Response response = this.b;
        boolean z2 = (response == null || (str = ((f) response).J) == null || str.contains("iaNotifyLoadFinished")) ? false : true;
        IAConfigManager iAConfigManager = IAConfigManager.M;
        boolean a2 = k.a(unitDisplayType, iAConfigManager.u.b);
        try {
            i.j jVar = i.j.AD_CONTROLLED;
            s sVar = this.g;
            if (sVar != null) {
                if (((l) sVar.a(l.class)).d()) {
                    aVar = iAConfigManager.J;
                }
            }
            IAmraidWebViewController iAmraidWebViewController = new IAmraidWebViewController(a2, iVar2, fVar3, jVar, z2, aVar, this.g);
            this.m = iAmraidWebViewController;
            iAmraidWebViewController.setAdContent(this.c);
            this.m.setAdRequest(this.a);
            InneractiveAdRequest inneractiveAdRequest2 = this.a;
            if (!(inneractiveAdRequest2 == null || inneractiveAdRequest2.getSelectedUnitConfig() == null || ((a0) this.a.getSelectedUnitConfig()).c == null)) {
                this.m.setMuteMraidVideo(((b0) this.c).h() && ((a0) this.a.getSelectedUnitConfig()).c.b != UnitDisplayType.REWARDED);
            }
            ((b0) this.c).i = this.m;
            Response response2 = this.b;
            if (response2 != null) {
                UnitDisplayType unitDisplayType2 = ((f) response2).n;
                InneractiveAdRequest inneractiveAdRequest3 = this.a;
                if (inneractiveAdRequest3 != null && !inneractiveAdRequest3.getAllowFullscreen()) {
                    z = false;
                }
                StringBuilder sb = new StringBuilder();
                if (unitDisplayType2 != null && unitDisplayType2.isFullscreenUnit() && !z) {
                    sb.append("<script type=\"text/javascript\">  var IaCloseBtnHelper = (function initIaCloseBtnHelper(){    var styleContent = '.celtra-close-button {display:none !important;} .close-button {display:none !important;}';    function getStyle(doc){      var style = doc.createElement('style');      style.type = 'text/css';      if (style.styleSheet){        style.styleSheet.cssText = styleContent;      } else {        style.appendChild(doc.createTextNode(styleContent));      }      return style;    }    function onDomReady(){      var iframes = window.document.getElementsByTagName('iframe'),          i = 0,          len = iframes && iframes.length || 0;      for(; i < len; ++i){        if(!iframes[i].src){          try {            iframes[i].contentDocument.body.appendChild(getStyle(iframes[i].contentDocument));          }catch(e){          }}}}    function registerWindowEvents(){      window.addEventListener('load', function onWindowLoad(){        window.removeEventListener('load', onWindowLoad);        onDomReady();      });    }    return {      init: function init(){        if(window.document.readyState != 'complete'){          registerWindowEvents();        }else{          onDomReady();        }}}})();  IaCloseBtnHelper.init();</script>");
                }
                String sb2 = sb.toString();
                String a3 = a(unitDisplayType2);
                this.m.setAutoplayMRAIDVideos(unitDisplayType.isFullscreenUnit());
                IAmraidWebViewController iAmraidWebViewController2 = this.m;
                String a4 = com.fyber.inneractive.sdk.config.a.a();
                iAmraidWebViewController2.a(a4, "" + ((f) this.b).J, sb2, a3, this.n, true);
            }
        } catch (Throwable th) {
            a(new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, g.COULD_NOT_CREATE_WEBVIEW_CONTROLLER, th));
        }
    }

    public final void l() {
        IAmraidWebViewController iAmraidWebViewController;
        IAlog.a("%s : IAMraidContentLoader : destroyController", IAlog.a((Object) this));
        if (this.c != null && (iAmraidWebViewController = this.m) != null) {
            a.C0101a aVar = iAmraidWebViewController.J;
            if (aVar != null) {
                ((c) aVar).a(false);
            }
            this.m.c();
            this.m = null;
        }
    }

    public static String a(UnitDisplayType unitDisplayType) {
        StringBuilder sb = new StringBuilder();
        if (unitDisplayType != null && !unitDisplayType.isFullscreenUnit()) {
            if (unitDisplayType == UnitDisplayType.BANNER) {
                sb.append(" body {display: flex;} #iawrapper { position:unset !important; display: unset !important; } ");
            } else {
                sb.append(" #iawrapper { position:unset !important; display: unset !important; }");
            }
        }
        return sb.toString();
    }

    public class a implements d.C0138d {
        public a() {
        }

        public void a(d dVar) {
            n nVar = n.this;
            nVar.getClass();
            IAlog.a("%sweb view returned onReady!", IAlog.a((Object) nVar));
            Response response = n.this.b;
            UnitDisplayType unitDisplayType = response != null ? ((f) response).n : null;
            if (unitDisplayType != null && unitDisplayType.isFullscreenUnit()) {
                n nVar2 = n.this;
                nVar2.getClass();
                try {
                    r rVar = r.EVENT_READY_ON_CLIENT;
                    InneractiveAdRequest inneractiveAdRequest = nVar2.a;
                    Content content = nVar2.c;
                    new s.a(rVar, inneractiveAdRequest, (e) content != null ? (f) ((b0) content).b : null, (JSONArray) null).a((String) null);
                } catch (Exception unused) {
                }
            }
            n.this.h();
        }

        public void a(d dVar, InneractiveInfrastructureError inneractiveInfrastructureError) {
            n.this.a((InneractiveError) inneractiveInfrastructureError);
            n nVar = n.this;
            nVar.getClass();
            IAlog.a("%sweb view returned onFailedLoading!", IAlog.a((Object) nVar));
            n.this.a(inneractiveInfrastructureError);
            if (inneractiveInfrastructureError.getErrorCode() == InneractiveErrorCode.NON_SECURE_CONTENT_DETECTED) {
                q qVar = q.MRAID_ERROR_UNSECURE_CONTENT;
                n nVar2 = n.this;
                new s.a(qVar, nVar2.a, (e) nVar2.b, (JSONArray) null).a((String) null);
            }
        }
    }
}
