package com.applovin.impl.sdk.e;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.sdk.d.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import java.io.File;
import java.util.List;

public class c extends a {
    private final e aHi;
    private final String aTA;
    private final boolean aTB;
    private final a aTC;
    private final List<String> aTp;
    private final com.applovin.impl.sdk.ad.e aiL;
    private final n sdk;

    public interface a {
        void q(Uri uri);
    }

    public c(String str, com.applovin.impl.sdk.ad.e eVar, e eVar2, n nVar, a aVar) {
        this(str, eVar, eVar.Gx(), true, eVar2, nVar, aVar);
    }

    public c(String str, com.applovin.impl.sdk.ad.e eVar, List<String> list, boolean z, e eVar2, n nVar, a aVar) {
        super("AsyncTaskCacheResource", nVar);
        this.aTA = str;
        this.aiL = eVar;
        this.aTp = list;
        this.aTB = z;
        this.aHi = eVar2;
        this.sdk = nVar;
        this.aTC = aVar;
    }

    /* renamed from: Kc */
    public Boolean call() throws Exception {
        if (this.aTn.get()) {
            return false;
        }
        String a2 = this.sdk.Cc().a(rQ(), this.aTA, this.aiL.getCachePrefix(), this.aTp, this.aTB, this.aHi);
        if (TextUtils.isEmpty(a2)) {
            r((Uri) null);
            return false;
        } else if (this.aTn.get()) {
            return false;
        } else {
            File a3 = this.sdk.Cc().a(a2, rQ());
            if (a3 == null) {
                x xVar = this.logger;
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    String str = this.tag;
                    xVar2.i(str, "Unable to retrieve File for cached filename = " + a2);
                }
                r((Uri) null);
                return false;
            } else if (this.aTn.get()) {
                return false;
            } else {
                Uri fromFile = Uri.fromFile(a3);
                if (fromFile == null) {
                    x xVar3 = this.logger;
                    if (x.Fn()) {
                        this.logger.i(this.tag, "Unable to extract Uri from file");
                    }
                    r((Uri) null);
                    return false;
                } else if (this.aTn.get()) {
                    return false;
                } else {
                    r(fromFile);
                    return true;
                }
            }
        }
    }

    private void r(Uri uri) {
        a aVar;
        if (!this.aTn.get() && (aVar = this.aTC) != null) {
            aVar.q(uri);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.aTA.equals(((c) obj).aTA);
    }

    public int hashCode() {
        String str = this.aTA;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
