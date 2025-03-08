package com.applovin.impl.sdk.nativeAd;

import android.net.Uri;
import com.applovin.impl.sdk.d.e;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import java.io.File;
import java.util.Collections;

public class a extends d {
    private final AppLovinNativeAdImpl aHe;
    private final e aHi = new e();
    private final C0082a aHj;

    /* renamed from: com.applovin.impl.sdk.nativeAd.a$a  reason: collision with other inner class name */
    public interface C0082a {
        void a(AppLovinNativeAdImpl appLovinNativeAdImpl);
    }

    public a(AppLovinNativeAdImpl appLovinNativeAdImpl, n nVar, C0082a aVar) {
        super("TaskCacheNativeAd", nVar);
        this.aHe = appLovinNativeAdImpl;
        this.aHj = aVar;
    }

    public void run() {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Begin caching ad #" + this.aHe.getAdIdNumber() + "...");
        }
        Uri p = p(this.aHe.getIconUri());
        if (p != null) {
            this.aHe.setIconUri(p);
        }
        Uri p2 = p(this.aHe.getMainImageUri());
        if (p2 != null) {
            this.aHe.setMainImageUri(p2);
        }
        Uri p3 = p(this.aHe.getPrivacyIconUri());
        if (p3 != null) {
            this.aHe.setPrivacyIconUri(p3);
        }
        x xVar3 = this.logger;
        if (x.Fn()) {
            x xVar4 = this.logger;
            String str2 = this.tag;
            xVar4.f(str2, "Finished caching ad #" + this.aHe.getAdIdNumber());
        }
        this.aHj.a(this.aHe);
    }

    private Uri p(Uri uri) {
        if (uri == null) {
            return null;
        }
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Attempting to cache resource: " + uri);
        }
        String a = this.sdk.Cc().a(rQ(), uri.toString(), this.aHe.getCachePrefix(), Collections.emptyList(), false, false, this.aHi);
        if (StringUtils.isValidString(a)) {
            File a2 = this.sdk.Cc().a(a, rQ());
            if (a2 != null) {
                Uri fromFile = Uri.fromFile(a2);
                if (fromFile != null) {
                    return fromFile;
                }
                x xVar3 = this.logger;
                if (x.Fn()) {
                    this.logger.i(this.tag, "Unable to extract Uri from image file");
                }
            } else {
                x xVar4 = this.logger;
                if (x.Fn()) {
                    x xVar5 = this.logger;
                    String str2 = this.tag;
                    xVar5.i(str2, "Unable to retrieve File from cached image filename = " + a);
                }
            }
        }
        return null;
    }
}
