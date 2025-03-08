package com.fyber.inneractive.sdk.player.controller;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.n;
import com.fyber.inneractive.sdk.flow.vast.b;
import com.fyber.inneractive.sdk.model.vast.h;
import com.fyber.inneractive.sdk.renderers.g;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.d0;
import com.fyber.inneractive.sdk.util.k;
import com.fyber.inneractive.sdk.util.q0;
import com.fyber.inneractive.sdk.web.a0;
import com.fyber.inneractive.sdk.web.d;
import com.fyber.inneractive.sdk.web.i;

public class c {
    public a0 a;
    public i.C0139i b = i.C0139i.INLINE;
    public UnitDisplayType c;
    public i.f d = i.f.ENABLED;
    public boolean e;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|5|6|7|8|(2:9|10)|11|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        static {
            /*
                com.fyber.inneractive.sdk.model.vast.h[] r0 = com.fyber.inneractive.sdk.model.vast.h.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b = r0
                r1 = 1
                com.fyber.inneractive.sdk.model.vast.h r2 = com.fyber.inneractive.sdk.model.vast.h.Static     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fyber.inneractive.sdk.model.vast.h r3 = com.fyber.inneractive.sdk.model.vast.h.Html     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fyber.inneractive.sdk.model.vast.h r3 = com.fyber.inneractive.sdk.model.vast.h.FMP_End_Card     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fyber.inneractive.sdk.model.vast.h r3 = com.fyber.inneractive.sdk.model.vast.h.Iframe     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType[] r2 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                a = r2
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r3 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r2 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.REWARDED     // Catch:{ NoSuchFieldError -> 0x004e }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.c.a.<clinit>():void");
        }
    }

    public c(Context context, b bVar, h hVar, com.fyber.inneractive.sdk.web.b bVar2) {
        a(bVar.c(), bVar.e());
        try {
            this.a = a(bVar2, hVar, k.a(bVar.c(), IAConfigManager.c().a()));
            a(hVar);
            if (this.a.e() != null) {
                d0.a().a(context, (View) this.a.e(), (d0.e) this.a);
            }
            this.a.i();
            q0 a2 = g.a(bVar.d(), bVar.a(), bVar.b());
            this.a.setAdDefaultSize(a2.a, a2.b);
        } catch (Throwable unused) {
            this.a = null;
        }
    }

    public final a0 a(com.fyber.inneractive.sdk.web.b bVar, h hVar, boolean z) {
        if (hVar == h.FMP_End_Card) {
            return new com.fyber.inneractive.sdk.web.c(bVar, z, false);
        }
        return new IAmraidWebViewController(z, this.b, this.d, i.j.AD_CONTROLLED, true, (com.fyber.inneractive.sdk.measurement.a) null, (s) null);
    }

    public View a() {
        a0 a0Var = this.a;
        if (a0Var == null) {
            return null;
        }
        return a0Var.b;
    }

    public void a(String str, d.C0138d dVar, boolean z) {
        if (this.a == null || TextUtils.isEmpty(str)) {
            dVar.a((d) null, new InneractiveInfrastructureError(InneractiveErrorCode.UNSPECIFIED, com.fyber.inneractive.sdk.flow.g.NO_WEBVIEW_CONTROLLER_AVAILABLE));
            return;
        }
        a0 a0Var = this.a;
        UnitDisplayType unitDisplayType = this.c;
        a0Var.setAutoplayMRAIDVideos(unitDisplayType != null && unitDisplayType.isFullscreenUnit());
        this.a.setCenteringTagsRequired(false);
        a0 a0Var2 = this.a;
        String a2 = com.fyber.inneractive.sdk.config.a.a();
        UnitDisplayType unitDisplayType2 = this.c;
        boolean z2 = this.e;
        StringBuilder sb = new StringBuilder();
        if (unitDisplayType2 != null && unitDisplayType2.isFullscreenUnit() && !z2) {
            sb.append("<script type=\"text/javascript\">  var IaCloseBtnHelper = (function initIaCloseBtnHelper(){    var styleContent = '.celtra-close-button {display:none !important;} .close-button {display:none !important;}';    function getStyle(doc){      var style = doc.createElement('style');      style.type = 'text/css';      if (style.styleSheet){        style.styleSheet.cssText = styleContent;      } else {        style.appendChild(doc.createTextNode(styleContent));      }      return style;    }    function onDomReady(){      var iframes = window.document.getElementsByTagName('iframe'),          i = 0,          len = iframes && iframes.length || 0;      for(; i < len; ++i){        if(!iframes[i].src){          try {            iframes[i].contentDocument.body.appendChild(getStyle(iframes[i].contentDocument));          }catch(e){          }}}}    function registerWindowEvents(){      window.addEventListener('load', function onWindowLoad(){        window.removeEventListener('load', onWindowLoad);        onDomReady();      });    }    return {      init: function init(){        if(window.document.readyState != 'complete'){          registerWindowEvents();        }else{          onDomReady();        }}}})();  IaCloseBtnHelper.init();</script>");
        }
        a0Var2.a(a2, str, sb.toString(), n.a(this.c), dVar, z);
    }

    public void a(UnitDisplayType unitDisplayType, boolean z) {
        this.c = unitDisplayType;
        this.e = z;
        int i = a.a[unitDisplayType.ordinal()];
        if (i == 1 || i == 2) {
            this.d = i.f.ENABLED;
            if (z) {
                this.b = i.C0139i.INTERSTITIAL;
                return;
            }
            return;
        }
        this.d = i.f.ENABLED;
    }

    public void a(h hVar) {
        a0 a0Var = this.a;
        com.fyber.inneractive.sdk.web.g gVar = a0Var != null ? a0Var.b : null;
        if (gVar != null) {
            int i = a.b[hVar.ordinal()];
            if (i == 1) {
                gVar.setId(R.id.inneractive_vast_endcard_gif);
            } else if (i == 2 || i == 3) {
                gVar.setId(R.id.inneractive_vast_endcard_html);
            } else if (i == 4) {
                gVar.setId(R.id.inneractive_vast_endcard_iframe);
            }
        }
    }
}
