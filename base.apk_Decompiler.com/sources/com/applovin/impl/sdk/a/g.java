package com.applovin.impl.sdk.a;

import android.text.TextUtils;
import android.webkit.WebView;
import com.applovin.impl.b.a;
import com.applovin.impl.b.b;
import com.applovin.impl.b.f;
import com.applovin.impl.b.h;
import com.applovin.impl.b.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.iab.omid.library.applovin.adsession.media.InteractionType;
import com.iab.omid.library.applovin.adsession.media.MediaEvents;
import com.iab.omid.library.applovin.adsession.media.Position;
import com.iab.omid.library.applovin.adsession.media.VastProperties;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class g extends b {
    static final /* synthetic */ boolean aIM = true;
    private final AtomicBoolean aIF = new AtomicBoolean();
    private MediaEvents aIG;
    private final VastProperties aIH;
    private final AtomicBoolean aII = new AtomicBoolean();
    private final AtomicBoolean aIJ = new AtomicBoolean();
    private final AtomicBoolean aIK = new AtomicBoolean();
    private final AtomicBoolean aIL = new AtomicBoolean();
    private final a ajq;

    public g(a aVar) {
        super(aVar);
        this.ajq = aVar;
        float LP = (float) aVar.LP();
        if (aVar.LP() == -1) {
            this.aIH = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
        } else {
            this.aIH = VastProperties.createVastPropertiesForSkippableMedia(LP, true, Position.STANDALONE);
        }
    }

    /* access modifiers changed from: protected */
    public AdSessionContext h(WebView webView) {
        VerificationScriptResource verificationScriptResource;
        if (aIM || this.ajq.Mf() != null) {
            ArrayList arrayList = new ArrayList();
            for (b next : this.ajq.Mf().Mm()) {
                List<h> Mk = next.Mk();
                if (Mk.isEmpty()) {
                    m.a(next.Ml(), f.FAILED_TO_LOAD_RESOURCE, this.sdk);
                } else {
                    ArrayList<h> arrayList2 = new ArrayList<>();
                    for (h next2 : Mk) {
                        if ("omid".equalsIgnoreCase(next2.My())) {
                            arrayList2.add(next2);
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        m.a(next.Ml(), f.API_FRAMEWORK_OR_LANGUAGE_TYPE_NOT_SUPPORTED, this.sdk);
                    } else {
                        ArrayList<URL> arrayList3 = new ArrayList<>();
                        for (h Mz : arrayList2) {
                            try {
                                arrayList3.add(new URL(Mz.Mz()));
                            } catch (Throwable th) {
                                x xVar = this.logger;
                                if (x.Fn()) {
                                    this.logger.c(this.tag, "Failed to parse JavaScript resource url", th);
                                }
                            }
                        }
                        if (arrayList3.isEmpty()) {
                            m.a(next.Ml(), f.FAILED_TO_LOAD_RESOURCE, this.sdk);
                        } else {
                            String verificationParameters = next.getVerificationParameters();
                            String Mj = next.Mj();
                            if (!StringUtils.isValidString(verificationParameters) || StringUtils.isValidString(Mj)) {
                                for (URL url : arrayList3) {
                                    if (StringUtils.isValidString(verificationParameters)) {
                                        verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithParameters(Mj, url, verificationParameters);
                                    } else {
                                        verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url);
                                    }
                                    arrayList.add(verificationScriptResource);
                                }
                            } else {
                                m.a(next.Ml(), f.FAILED_TO_LOAD_RESOURCE, this.sdk);
                            }
                        }
                    }
                }
            }
            String IT = this.sdk.Cp().IT();
            if (TextUtils.isEmpty(IT)) {
                x xVar2 = this.logger;
                if (x.Fn()) {
                    this.logger.i(this.tag, "JavaScript SDK content not loaded successfully");
                }
                return null;
            }
            try {
                return AdSessionContext.createNativeAdSessionContext(this.sdk.Cp().getPartner(), IT, arrayList, this.ajq.getOpenMeasurementContentUrl(), this.ajq.getOpenMeasurementCustomReferenceData());
            } catch (Throwable th2) {
                x xVar3 = this.logger;
                if (!x.Fn()) {
                    return null;
                }
                this.logger.c(this.tag, "Failed to create ad session context", th2);
                return null;
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: protected */
    public AdSessionConfiguration II() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.VIDEO, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NATIVE, false);
        } catch (Throwable th) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.c(this.tag, "Failed to create ad session configuration", th);
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void a(AdSession adSession) {
        try {
            this.aIG = MediaEvents.createMediaEvents(adSession);
        } catch (Throwable th) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.c(this.tag, "Failed to create media events", th);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jr() {
        this.aIB.loaded(this.aIH);
    }

    public void IK() {
        b("track loaded", (Runnable) new g$$ExternalSyntheticLambda5(this));
    }

    public void b(float f, boolean z) {
        if (this.aII.compareAndSet(false, true)) {
            b("track started", (Runnable) new g$$ExternalSyntheticLambda8(this, f, z));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(float f, boolean z) {
        this.aIG.start(f, z ? 0.0f : 1.0f);
    }

    public void IX() {
        if (this.aIJ.compareAndSet(false, true)) {
            b("track first quartile", (Runnable) new g$$ExternalSyntheticLambda9(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jq() {
        this.aIG.firstQuartile();
    }

    public void IY() {
        if (this.aIK.compareAndSet(false, true)) {
            b("track midpoint", (Runnable) new g$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jp() {
        this.aIG.midpoint();
    }

    public void IZ() {
        if (this.aIL.compareAndSet(false, true)) {
            b("track third quartile", (Runnable) new g$$ExternalSyntheticLambda11(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jo() {
        this.aIG.thirdQuartile();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jn() {
        this.aIG.complete();
    }

    public void Ja() {
        b("track completed", (Runnable) new g$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jm() {
        this.aIG.pause();
    }

    public void Jb() {
        b("track paused", (Runnable) new g$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jl() {
        this.aIG.resume();
    }

    public void Jc() {
        b("track resumed", (Runnable) new g$$ExternalSyntheticLambda7(this));
    }

    public void Jd() {
        if (this.aIF.compareAndSet(false, true)) {
            b("buffer started", (Runnable) new g$$ExternalSyntheticLambda6(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jk() {
        this.aIG.bufferStart();
    }

    public void Je() {
        if (this.aIF.compareAndSet(true, false)) {
            b("buffer finished", (Runnable) new g$$ExternalSyntheticLambda12(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jj() {
        this.aIG.bufferFinish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bd(boolean z) {
        this.aIG.volumeChange(z ? 0.0f : 1.0f);
    }

    public void bc(boolean z) {
        b("track volume changed", (Runnable) new g$$ExternalSyntheticLambda4(this, z));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ji() {
        this.aIG.skipped();
    }

    public void Jf() {
        b("track skipped", (Runnable) new g$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jh() {
        this.aIG.adUserInteraction(InteractionType.CLICK);
    }

    public void Jg() {
        b("track clicked", (Runnable) new g$$ExternalSyntheticLambda10(this));
    }
}
