package com.applovin.exoplayer2.k;

import android.content.Context;
import android.net.Uri;
import com.applovin.exoplayer2.k.i;
import com.applovin.exoplayer2.k.q;
import com.applovin.exoplayer2.l.ai;
import com.applovin.sdk.AppLovinEventTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class o implements i {
    private final Context E;
    private i LR;
    private final List<aa> aaj = new ArrayList();
    private final i aak;
    private i aal;
    private i aam;
    private i aan;
    private i aao;
    private i aap;
    private i aaq;
    private i aar;

    public static final class a implements i.a {
        private final Context E;
        private aa MH;
        private final i.a aas;

        public a(Context context) {
            this(context, new q.a());
        }

        public a(Context context, i.a aVar) {
            this.E = context.getApplicationContext();
            this.aas = aVar;
        }

        /* renamed from: ou */
        public o of() {
            o oVar = new o(this.E, this.aas.of());
            aa aaVar = this.MH;
            if (aaVar != null) {
                oVar.c(aaVar);
            }
            return oVar;
        }
    }

    public o(Context context, i iVar) {
        this.E = context.getApplicationContext();
        this.aak = (i) com.applovin.exoplayer2.l.a.checkNotNull(iVar);
    }

    public void c(aa aaVar) {
        com.applovin.exoplayer2.l.a.checkNotNull(aaVar);
        this.aak.c(aaVar);
        this.aaj.add(aaVar);
        a(this.aal, aaVar);
        a(this.aam, aaVar);
        a(this.aan, aaVar);
        a(this.aao, aaVar);
        a(this.aap, aaVar);
        a(this.aaq, aaVar);
        a(this.aar, aaVar);
    }

    public long a(l lVar) throws IOException {
        com.applovin.exoplayer2.l.a.checkState(this.LR == null);
        String scheme = lVar.ef.getScheme();
        if (ai.h(lVar.ef)) {
            String path = lVar.ef.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.LR = oo();
            } else {
                this.LR = op();
            }
        } else if ("asset".equals(scheme)) {
            this.LR = op();
        } else if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(scheme)) {
            this.LR = oq();
        } else if ("rtmp".equals(scheme)) {
            this.LR = or();
        } else if ("udp".equals(scheme)) {
            this.LR = on();
        } else if ("data".equals(scheme)) {
            this.LR = os();
        } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
            this.LR = ot();
        } else {
            this.LR = this.aak;
        }
        return this.LR.a(lVar);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return ((i) com.applovin.exoplayer2.l.a.checkNotNull(this.LR)).read(bArr, i, i2);
    }

    public Uri getUri() {
        i iVar = this.LR;
        if (iVar == null) {
            return null;
        }
        return iVar.getUri();
    }

    public Map<String, List<String>> kT() {
        i iVar = this.LR;
        return iVar == null ? Collections.emptyMap() : iVar.kT();
    }

    public void close() throws IOException {
        i iVar = this.LR;
        if (iVar != null) {
            try {
                iVar.close();
            } finally {
                this.LR = null;
            }
        }
    }

    private i on() {
        if (this.aap == null) {
            ab abVar = new ab();
            this.aap = abVar;
            a((i) abVar);
        }
        return this.aap;
    }

    private i oo() {
        if (this.aal == null) {
            s sVar = new s();
            this.aal = sVar;
            a((i) sVar);
        }
        return this.aal;
    }

    private i op() {
        if (this.aam == null) {
            c cVar = new c(this.E);
            this.aam = cVar;
            a((i) cVar);
        }
        return this.aam;
    }

    private i oq() {
        if (this.aan == null) {
            f fVar = new f(this.E);
            this.aan = fVar;
            a((i) fVar);
        }
        return this.aan;
    }

    private i or() {
        if (this.aao == null) {
            try {
                i iVar = (i) Class.forName("com.applovin.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                this.aao = iVar;
                a(iVar);
            } catch (ClassNotFoundException unused) {
                com.applovin.exoplayer2.l.q.h("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating RTMP extension", e);
            }
            if (this.aao == null) {
                this.aao = this.aak;
            }
        }
        return this.aao;
    }

    private i os() {
        if (this.aaq == null) {
            h hVar = new h();
            this.aaq = hVar;
            a((i) hVar);
        }
        return this.aaq;
    }

    private i ot() {
        if (this.aar == null) {
            x xVar = new x(this.E);
            this.aar = xVar;
            a((i) xVar);
        }
        return this.aar;
    }

    private void a(i iVar) {
        for (int i = 0; i < this.aaj.size(); i++) {
            iVar.c(this.aaj.get(i));
        }
    }

    private void a(i iVar, aa aaVar) {
        if (iVar != null) {
            iVar.c(aaVar);
        }
    }
}
