package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.utils.p;
import java.util.Map;
import org.json.JSONObject;

public class i<T> extends c {
    private String aIv;
    private boolean aIx;

    public boolean IG() {
        return this.aIv != null;
    }

    public boolean Ix() {
        return this.aIx;
    }

    public String Iy() {
        return this.aIv;
    }

    protected i(a aVar) {
        super(aVar);
        this.aIv = aVar.aIv;
        this.aIx = aVar.aIx;
    }

    public static a E(n nVar) {
        return new a(nVar);
    }

    public static class a<T> extends c.a<T> {
        /* access modifiers changed from: private */
        public String aIv;
        /* access modifiers changed from: private */
        public boolean aIx;

        public a bb(boolean z) {
            this.aIx = z;
            return this;
        }

        public a di(String str) {
            this.aIv = str;
            return this;
        }

        public a(n nVar) {
            super(nVar);
            this.aHH = ((Integer) nVar.a(b.aND)).intValue();
            this.aHI = ((Integer) nVar.a(b.aNC)).intValue();
            this.aHJ = ((Integer) nVar.a(b.aNK)).intValue();
        }

        /* renamed from: df */
        public a cW(String str) {
            this.aHr = str;
            return this;
        }

        /* renamed from: dg */
        public a cY(String str) {
            this.aHF = str;
            return this;
        }

        /* renamed from: dh */
        public a cX(String str) {
            this.aHC = str;
            return this;
        }

        /* renamed from: L */
        public a K(JSONObject jSONObject) {
            this.aHE = jSONObject;
            return this;
        }

        /* renamed from: q */
        public a k(Map<String, String> map) {
            this.aHD = map;
            return this;
        }

        /* renamed from: r */
        public a l(Map<String, String> map) {
            this.awy = map;
            return this;
        }

        /* renamed from: ae */
        public a ad(T t) {
            this.aHt = t;
            return this;
        }

        /* renamed from: gK */
        public a gE(int i) {
            this.aHH = i;
            return this;
        }

        /* renamed from: gL */
        public a gF(int i) {
            this.aHI = i;
            return this;
        }

        /* renamed from: gM */
        public a gG(int i) {
            this.aHJ = i;
            return this;
        }

        /* renamed from: c */
        public a a(p.a aVar) {
            this.aHO = aVar;
            return this;
        }

        /* renamed from: aZ */
        public a aS(boolean z) {
            this.aHN = z;
            return this;
        }

        /* renamed from: ba */
        public a aU(boolean z) {
            this.aHQ = z;
            return this;
        }

        /* renamed from: IH */
        public i<T> Ig() {
            return new i<>(this);
        }
    }
}
