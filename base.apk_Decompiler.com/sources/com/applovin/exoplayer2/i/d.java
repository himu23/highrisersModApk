package com.applovin.exoplayer2.i;

import com.applovin.exoplayer2.c.j;
import com.applovin.exoplayer2.l.a;
import java.nio.ByteBuffer;

public abstract class d extends j<j, k, h> implements g {
    private final String name;

    public void bd(long j) {
    }

    /* access modifiers changed from: protected */
    public abstract f c(byte[] bArr, int i, boolean z) throws h;

    protected d(String str) {
        super(new j[2], new k[2]);
        this.name = str;
        bA(1024);
    }

    /* access modifiers changed from: protected */
    /* renamed from: lY */
    public final j ho() {
        return new j();
    }

    /* access modifiers changed from: protected */
    /* renamed from: lZ */
    public final k hp() {
        return new e(new d$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public final h a(Throwable th) {
        return new h("Unexpected decode error", th);
    }

    /* access modifiers changed from: protected */
    public final h a(j jVar, k kVar, boolean z) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) a.checkNotNull(jVar.rH);
            k kVar2 = kVar;
            kVar2.a(jVar.rJ, c(byteBuffer.array(), byteBuffer.limit(), z), jVar.dD);
            kVar.bu(Integer.MIN_VALUE);
            return null;
        } catch (h e) {
            return e;
        }
    }
}
