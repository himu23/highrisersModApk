package com.applovin.impl.sdk.e;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.mediation.h;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.d.e;
import com.applovin.impl.sdk.e.b;
import com.applovin.impl.sdk.e.c;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.t;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import com.ironsource.i9;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.text.Typography;

public abstract class f extends d implements h.a {
    private final t aBF;
    protected final e aHi;
    private AppLovinAdLoadListener aTG;
    private final Collection<Character> aTH;
    private boolean aTI;
    protected ExecutorService aTJ;
    protected List<a> aTK;
    protected String aTL;
    protected ExecutorService aTt;
    protected final com.applovin.impl.sdk.ad.e aiL;

    public interface a {
        void du(String str);
    }

    /* access modifiers changed from: protected */
    public boolean Kj() {
        return this.aTI;
    }

    f(String str, com.applovin.impl.sdk.ad.e eVar, n nVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super(str, nVar);
        if (eVar != null) {
            this.aiL = eVar;
            this.aTG = appLovinAdLoadListener;
            this.aBF = nVar.Cc();
            this.aTH = Kf();
            this.aHi = new e();
            if (((Boolean) nVar.a(b.aLQ)).booleanValue()) {
                this.aTL = StringUtils.isValidString(eVar.GB()) ? eVar.GB() : UUID.randomUUID().toString();
                q BO = nVar.BO();
                this.aTt = BO.f("com.applovin.sdk.caching." + this.aTL, ((Integer) nVar.a(b.aLR)).intValue());
                q BO2 = nVar.BO();
                this.aTJ = BO2.f("com.applovin.sdk.caching.html." + this.aTL, ((Integer) nVar.a(b.aLS)).intValue());
                return;
            }
            return;
        }
        throw new IllegalArgumentException("No ad specified.");
    }

    public void run() {
        if (this.aiL.GA()) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Subscribing to timeout events...");
            }
            this.sdk.CA().a(this);
        }
    }

    public void f(com.applovin.impl.mediation.b.a aVar) {
        if (aVar.xA().equalsIgnoreCase(this.aiL.GB())) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.i(this.tag, "Updating flag for timeout...");
            }
            Kk();
        }
        this.sdk.CA().b(this);
    }

    /* access modifiers changed from: protected */
    public void Ki() {
        this.sdk.CA().b(this);
        ExecutorService executorService = this.aTt;
        if (executorService != null) {
            executorService.shutdown();
            this.aTt = null;
        }
        ExecutorService executorService2 = this.aTJ;
        if (executorService2 != null) {
            executorService2.shutdown();
            this.aTJ = null;
        }
    }

    /* access modifiers changed from: protected */
    public void Kk() {
        this.aTI = true;
        List<a> list = this.aTK;
        if (list != null && !list.isEmpty()) {
            for (a be : this.aTK) {
                be.be(true);
            }
        }
        ExecutorService executorService = this.aTt;
        if (executorService != null) {
            executorService.shutdown();
            this.aTt = null;
        }
        ExecutorService executorService2 = this.aTJ;
        if (executorService2 != null) {
            executorService2.shutdown();
            this.aTJ = null;
        }
    }

    /* access modifiers changed from: protected */
    public List<Future<Boolean>> K(List<a> list) {
        this.aTK = list;
        return this.sdk.BO().a(list, this.aTt);
    }

    /* access modifiers changed from: protected */
    public c a(String str, c.a aVar) {
        return new c(str, this.aiL, this.aHi, this.sdk, aVar);
    }

    /* access modifiers changed from: protected */
    public List<a> Kl() {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Caching mute images...");
        }
        ArrayList arrayList = new ArrayList();
        if (this.aiL.Hv() != null) {
            arrayList.add(a(this.aiL.Hv().toString(), new c.a() {
                public void q(Uri uri) {
                    f.this.aiL.n(uri);
                    x xVar = f.this.logger;
                    if (x.Fn()) {
                        x xVar2 = f.this.logger;
                        String str = f.this.tag;
                        xVar2.f(str, "Ad updated with muteImageUri = " + uri);
                    }
                }
            }));
        }
        if (this.aiL.Hw() != null) {
            arrayList.add(a(this.aiL.Hw().toString(), new c.a() {
                public void q(Uri uri) {
                    f.this.aiL.o(uri);
                    x xVar = f.this.logger;
                    if (x.Fn()) {
                        x xVar2 = f.this.logger;
                        String str = f.this.tag;
                        xVar2.f(str, "Ad updated with unmuteImageUri = " + uri);
                    }
                }
            }));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public c b(String str, c.a aVar) {
        return a(str, this.aiL.Gx(), true, aVar);
    }

    /* access modifiers changed from: protected */
    public c a(String str, List<String> list, boolean z, final c.a aVar) {
        if (TextUtils.isEmpty(str)) {
            x xVar = this.logger;
            if (!x.Fn()) {
                return null;
            }
            this.logger.f(this.tag, "No video to cache, skipping...");
            return null;
        }
        x xVar2 = this.logger;
        if (x.Fn()) {
            x xVar3 = this.logger;
            String str2 = this.tag;
            xVar3.f(str2, "Caching video " + str + "...");
        }
        return new c(str, this.aiL, list, z, this.aHi, this.sdk, new c.a() {
            public void q(Uri uri) {
                if (uri != null) {
                    x xVar = f.this.logger;
                    if (x.Fn()) {
                        x xVar2 = f.this.logger;
                        String str = f.this.tag;
                        xVar2.f(str, "Finish caching video for ad #" + f.this.aiL.getAdIdNumber() + ". Updating ad with cachedVideoURL = " + uri);
                    }
                    aVar.q(uri);
                    return;
                }
                x xVar3 = f.this.logger;
                if (x.Fn()) {
                    f.this.logger.i(f.this.tag, "Failed to cache video");
                }
                f.this.Kn();
            }
        });
    }

    /* access modifiers changed from: protected */
    public b a(String str, List<String> list, final a aVar) {
        return new b(str, this.aiL, list, this.aHi, this.aTJ, this.sdk, new b.a() {
            public void d(String str, boolean z) {
                if (z) {
                    f.this.Kn();
                    return;
                }
                a aVar = aVar;
                if (aVar != null) {
                    aVar.du(str);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void Km() {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Caching mute images...");
        }
        Uri c = c(this.aiL.Hv(), "mute");
        if (c != null) {
            this.aiL.n(c);
        }
        Uri c2 = c(this.aiL.Hw(), "unmute");
        if (c2 != null) {
            this.aiL.o(c2);
        }
        x xVar2 = this.logger;
        if (x.Fn()) {
            x xVar3 = this.logger;
            String str = this.tag;
            xVar3.f(str, "Ad updated with muteImageFilename = " + this.aiL.Hv() + ", unmuteImageFilename = " + this.aiL.Hw());
        }
    }

    /* access modifiers changed from: package-private */
    public Uri dr(String str) {
        return a(str, this.aiL.Gx(), true);
    }

    /* access modifiers changed from: package-private */
    public Uri a(String str, List<String> list, boolean z) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str2 = this.tag;
            xVar2.f(str2, "Caching video " + str + "...");
        }
        String a2 = this.aBF.a(rQ(), str, this.aiL.getCachePrefix(), list, z, this.aHi);
        if (StringUtils.isValidString(a2)) {
            File a3 = this.aBF.a(a2, rQ());
            if (a3 != null) {
                Uri fromFile = Uri.fromFile(a3);
                if (fromFile != null) {
                    x xVar3 = this.logger;
                    if (x.Fn()) {
                        x xVar4 = this.logger;
                        String str3 = this.tag;
                        xVar4.f(str3, "Finish caching video for ad #" + this.aiL.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + a2);
                    }
                    return fromFile;
                }
                x xVar5 = this.logger;
                if (!x.Fn()) {
                    return null;
                }
                x xVar6 = this.logger;
                String str4 = this.tag;
                xVar6.i(str4, "Unable to create URI from cached video file = " + a3);
                return null;
            }
            x xVar7 = this.logger;
            if (!x.Fn()) {
                return null;
            }
            x xVar8 = this.logger;
            String str5 = this.tag;
            xVar8.i(str5, "Unable to cache video = " + str + "Video file was missing or null");
            return null;
        }
        x xVar9 = this.logger;
        if (x.Fn()) {
            this.logger.i(this.tag, "Failed to cache video");
        }
        Kn();
        return null;
    }

    /* access modifiers changed from: protected */
    public Uri c(Uri uri, String str) {
        if (uri == null) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str2 = this.tag;
                xVar2.f(str2, "No " + str + " image to cache");
            }
            return null;
        }
        String uri2 = uri.toString();
        if (TextUtils.isEmpty(uri2)) {
            x xVar3 = this.logger;
            if (x.Fn()) {
                x xVar4 = this.logger;
                String str3 = this.tag;
                xVar4.f(str3, "Failed to cache " + str + " image");
            }
            return null;
        }
        x xVar5 = this.logger;
        if (x.Fn()) {
            x xVar6 = this.logger;
            String str4 = this.tag;
            xVar6.f(str4, "Caching " + str + " image...");
        }
        return ds(uri2);
    }

    /* access modifiers changed from: protected */
    public Uri ds(String str) {
        return b(str, this.aiL.Gx(), true);
    }

    /* access modifiers changed from: package-private */
    public Uri b(String str, List<String> list, boolean z) {
        try {
            String a2 = this.aBF.a(rQ(), str, this.aiL.getCachePrefix(), list, z, this.aHi);
            if (!StringUtils.isValidString(a2)) {
                return null;
            }
            File a3 = this.aBF.a(a2, rQ());
            if (a3 != null) {
                Uri fromFile = Uri.fromFile(a3);
                if (fromFile != null) {
                    return fromFile;
                }
                x xVar = this.logger;
                if (!x.Fn()) {
                    return null;
                }
                this.logger.i(this.tag, "Unable to extract Uri from image file");
                return null;
            }
            x xVar2 = this.logger;
            if (!x.Fn()) {
                return null;
            }
            x xVar3 = this.logger;
            String str2 = this.tag;
            xVar3.i(str2, "Unable to retrieve File from cached image filename = " + a2);
            return null;
        } catch (Throwable th) {
            x xVar4 = this.logger;
            if (!x.Fn()) {
                return null;
            }
            x xVar5 = this.logger;
            String str3 = this.tag;
            xVar5.c(str3, "Failed to cache image at url = " + str, th);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String c(String str, List<String> list) {
        InputStream inputStream;
        if (StringUtils.isValidString(str)) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                x xVar = this.logger;
                if (x.Fn()) {
                    this.logger.f(this.tag, "Nothing to cache, skipping...");
                }
                return null;
            }
            try {
                File a2 = this.aBF.a(u.a(parse, this.aiL.getCachePrefix(), this.sdk), rQ());
                if (this.aBF.g(a2)) {
                    return this.aBF.a(a2);
                }
                inputStream = this.aBF.a(str, list, true, this.aHi);
                if (inputStream != null) {
                    try {
                        this.aBF.a(inputStream, a2);
                    } catch (Throwable th) {
                        th = th;
                    }
                }
                u.a((Closeable) inputStream, this.sdk);
                return this.aBF.a(a2);
            } catch (Throwable th2) {
                x xVar2 = this.logger;
                if (x.Fn()) {
                    this.logger.c(this.tag, "Resource at " + str + " failed to load.", th2);
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public String a(String str, List<String> list, com.applovin.impl.sdk.ad.e eVar) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aLM)).booleanValue()) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Resource caching is disabled, skipping cache...");
            }
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        boolean shouldCancelHtmlCachingIfShown = eVar.shouldCancelHtmlCachingIfShown();
        boolean Hz = eVar.Hz();
        List<String> Gw = eVar.Gw();
        for (String next : list) {
            int i = 0;
            int i2 = 0;
            while (i < sb.length()) {
                if (Kj()) {
                    return str;
                }
                i = sb.indexOf(next, i2);
                if (i == -1) {
                    continue;
                    break;
                }
                int length = sb.length();
                int i3 = i;
                while (!this.aTH.contains(Character.valueOf(sb.charAt(i3))) && i3 < length) {
                    i3++;
                }
                if (i3 <= i || i3 == length) {
                    x xVar2 = this.logger;
                    if (x.Fn()) {
                        this.logger.i(this.tag, "Unable to cache resource; ad HTML is invalid.");
                    }
                    return str;
                }
                String substring = sb.substring(next.length() + i, i3);
                if (!StringUtils.isValidString(substring)) {
                    x xVar3 = this.logger;
                    if (x.Fn()) {
                        x xVar4 = this.logger;
                        String str2 = this.tag;
                        xVar4.f(str2, "Skip caching of non-resource " + substring);
                    }
                } else if (!shouldCancelHtmlCachingIfShown || !eVar.hasShown()) {
                    if (Hz) {
                        String FD = eVar.FD();
                        if (FD.equals(next + substring)) {
                            x xVar5 = this.logger;
                            if (x.Fn()) {
                                x xVar6 = this.logger;
                                String str3 = this.tag;
                                xVar6.f(str3, "Postponing caching for \"" + substring + "\" video resource");
                            }
                        }
                    }
                    Uri K = K(next, substring);
                    if (K != null) {
                        sb.replace(i, i3, K.toString());
                        eVar.k(K);
                        this.aHi.JT();
                    } else {
                        if (Gw.contains(next + substring)) {
                            Kn();
                            this.aTI = true;
                        }
                        this.aHi.JU();
                    }
                } else {
                    x xVar7 = this.logger;
                    if (x.Fn()) {
                        this.logger.f(this.tag, "Cancelling HTML caching due to ad being shown already");
                    }
                    this.aHi.JS();
                    return str;
                }
                i2 = i3;
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void b(AppLovinAdBase appLovinAdBase) {
        d.a(this.aHi, appLovinAdBase, this.sdk);
    }

    private Uri K(String str, String str2) {
        String str3;
        String cachePrefix = this.aiL.getCachePrefix();
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aLY)).booleanValue()) {
            str3 = u.a(Uri.parse(str2), cachePrefix, this.sdk);
        } else {
            String replace = str2.replace("/", "_");
            if (StringUtils.isValidString(cachePrefix)) {
                str3 = cachePrefix + replace;
            } else {
                str3 = replace;
            }
        }
        File a2 = this.aBF.a(str3, n.getApplicationContext());
        if (a2 == null) {
            return null;
        }
        if (this.aBF.g(a2)) {
            this.aHi.bX(a2.length());
            return Uri.parse("file://" + a2.getAbsolutePath());
        }
        if (!this.aBF.a(a2, str + str2, (List<String>) Arrays.asList(new String[]{str}), this.aHi)) {
            return null;
        }
        return Uri.parse("file://" + a2.getAbsolutePath());
    }

    /* access modifiers changed from: package-private */
    public String dt(final String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.applovin.impl.sdk.network.c Ig = com.applovin.impl.sdk.network.c.D(this.sdk).cW(str).cX(i9.a).ad("").gE(0).Ig();
        final AtomicReference atomicReference = new AtomicReference((Object) null);
        this.sdk.BQ().a(Ig, new b.a(), new b.d<String>() {
            /* renamed from: c */
            public void d(String str, int i) {
                atomicReference.set(str);
            }

            public void a(int i, String str, String str2) {
                x xVar = f.this.logger;
                if (x.Fn()) {
                    x xVar2 = f.this.logger;
                    String str3 = f.this.tag;
                    xVar2.i(str3, "Failed to load resource from '" + str + "'");
                }
            }
        });
        String str2 = (String) atomicReference.get();
        if (str2 != null) {
            this.aHi.bW((long) str2.length());
        }
        return str2;
    }

    /* access modifiers changed from: package-private */
    public void Kn() {
        AppLovinAdLoadListener appLovinAdLoadListener = this.aTG;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            this.aTG = null;
        }
        Kk();
    }

    /* access modifiers changed from: package-private */
    public void Ko() {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Rendered new ad:" + this.aiL);
        }
        AppLovinSdkUtils.runOnUiThread(new f$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Kp() {
        AppLovinAdLoadListener appLovinAdLoadListener = this.aTG;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(this.aiL);
            this.aTG = null;
        }
    }

    private Collection<Character> Kf() {
        HashSet hashSet = new HashSet();
        for (char valueOf : ((String) this.sdk.a(com.applovin.impl.sdk.c.b.aLL)).toCharArray()) {
            hashSet.add(Character.valueOf(valueOf));
        }
        hashSet.add(Character.valueOf(Typography.quote));
        return hashSet;
    }
}
