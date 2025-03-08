package com.applovin.impl.sdk.e;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.sdk.d.e;
import com.applovin.impl.sdk.e.c;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.text.Typography;

public class b extends a {
    /* access modifiers changed from: private */
    public final e aHi;
    /* access modifiers changed from: private */
    public final String aTo;
    private final List<String> aTp;
    /* access modifiers changed from: private */
    public final a aTq;
    /* access modifiers changed from: private */
    public StringBuffer aTr;
    /* access modifiers changed from: private */
    public final Object aTs = new Object();
    private final ExecutorService aTt;
    private List<c> aTu;
    /* access modifiers changed from: private */
    public final com.applovin.impl.sdk.ad.e aiL;

    public interface a {
        void d(String str, boolean z);
    }

    public b(String str, com.applovin.impl.sdk.ad.e eVar, List<String> list, e eVar2, ExecutorService executorService, n nVar, a aVar) {
        super("AsyncTaskCacheHTMLResources", nVar);
        this.aTo = str;
        this.aiL = eVar;
        this.aTp = list;
        this.aHi = eVar2;
        this.aTt = executorService;
        this.aTq = aVar;
        this.aTr = new StringBuffer(str);
    }

    /* renamed from: Kc */
    public Boolean call() throws Exception {
        HashSet<c> Kd;
        if (this.aTn.get()) {
            return false;
        }
        if (TextUtils.isEmpty(this.aTo)) {
            dp(this.aTo);
            return false;
        } else if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aLM)).booleanValue()) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Resource caching is disabled, skipping cache...");
            }
            dp(this.aTo);
            return false;
        } else {
            HashSet hashSet = new HashSet();
            HashSet<c> Ke = Ke();
            if (Ke != null) {
                hashSet.addAll(Ke);
            }
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPJ)).booleanValue() && (Kd = Kd()) != null) {
                hashSet.addAll(Kd);
            }
            this.aTu = new ArrayList(hashSet);
            if (this.aTn.get()) {
                return false;
            }
            List<c> list = this.aTu;
            if (list == null || list.isEmpty()) {
                dp(this.aTo);
                return false;
            }
            x xVar2 = this.logger;
            if (x.Fn()) {
                x xVar3 = this.logger;
                String str = this.tag;
                xVar3.f(str, "Executing " + this.aTu.size() + " caching operations...");
            }
            this.aTt.invokeAll(this.aTu);
            synchronized (this.aTs) {
                dp(this.aTr.toString());
            }
            return true;
        }
    }

    private void dp(String str) {
        a aVar;
        if (!this.aTn.get() && (aVar = this.aTq) != null) {
            aVar.d(str, false);
        }
    }

    private HashSet<c> Kd() {
        HashSet<c> hashSet = new HashSet<>();
        for (final String next : StringUtils.getRegexMatches(StringUtils.match(this.aTo, (String) this.sdk.a(com.applovin.impl.sdk.c.b.aPK)), 1)) {
            if (this.aTn.get()) {
                return null;
            }
            if (!StringUtils.isValidString(next)) {
                x xVar = this.logger;
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    String str = this.tag;
                    xVar2.f(str, "Skip caching of non-resource " + next);
                }
            } else {
                hashSet.add(new c(next, this.aiL, Collections.emptyList(), false, this.aHi, this.sdk, new c.a() {
                    public void q(Uri uri) {
                        if (uri != null) {
                            synchronized (b.this.aTs) {
                                int indexOf = b.this.aTr.indexOf(next);
                                b.this.aTr.replace(indexOf, next.length() + indexOf, uri.toString());
                            }
                            b.this.aiL.k(uri);
                            b.this.aHi.JT();
                            return;
                        }
                        x xVar = b.this.logger;
                        if (x.Fn()) {
                            x xVar2 = b.this.logger;
                            String str = b.this.tag;
                            xVar2.f(str, "Failed to cache JavaScript resource " + next);
                        }
                        if (b.this.aTq != null) {
                            b.this.aTq.d(b.this.aTo, true);
                        }
                        b.this.aHi.JU();
                    }
                }));
            }
        }
        return hashSet;
    }

    private HashSet<c> Ke() {
        HashSet<c> hashSet = new HashSet<>();
        Collection<Character> Kf = Kf();
        for (final String next : this.aTp) {
            int i = 0;
            int i2 = 0;
            while (i < this.aTo.length()) {
                if (this.aTn.get()) {
                    return null;
                }
                i = this.aTo.indexOf(next, i2);
                if (i == -1) {
                    continue;
                    break;
                }
                int length = this.aTo.length();
                int i3 = i;
                while (!Kf.contains(Character.valueOf(this.aTo.charAt(i3))) && i3 < length) {
                    i3++;
                }
                if (i3 <= i || i3 == length) {
                    x xVar = this.logger;
                    if (x.Fn()) {
                        this.logger.i(this.tag, "Unable to cache resource; ad HTML is invalid.");
                    }
                    return null;
                }
                final String substring = this.aTo.substring(next.length() + i, i3);
                if (StringUtils.isValidString(substring)) {
                    if (this.aiL.Hz()) {
                        if (this.aiL.FD().equals(next + substring)) {
                            x xVar2 = this.logger;
                            if (x.Fn()) {
                                this.logger.f(this.tag, "Postponing caching for \"" + substring + "\" video resource");
                            }
                        }
                    }
                    final String str = next + substring;
                    hashSet.add(new c(str, this.aiL, Arrays.asList(new String[]{next}), true, this.aHi, this.sdk, new c.a() {
                        public void q(Uri uri) {
                            if (uri != null) {
                                synchronized (b.this.aTs) {
                                    int indexOf = b.this.aTr.indexOf(str);
                                    b.this.aTr.replace(indexOf, str.length() + indexOf, uri.toString());
                                }
                                b.this.aiL.k(uri);
                                b.this.aHi.JT();
                                return;
                            }
                            List<String> Gw = b.this.aiL.Gw();
                            if (Gw.contains(next + substring) && b.this.aTq != null) {
                                b.this.aTq.d(b.this.aTo, true);
                            }
                            b.this.aHi.JU();
                        }
                    }));
                } else {
                    x xVar3 = this.logger;
                    if (x.Fn()) {
                        this.logger.f(this.tag, "Skip caching of non-resource " + substring);
                    }
                }
                i2 = i3;
            }
        }
        return hashSet;
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
