package com.fyber.inneractive.sdk.util;

public class d implements Runnable {
    public final /* synthetic */ Object[] a;
    public final /* synthetic */ b b;

    public d(b bVar, Object[] objArr) {
        this.b = bVar;
        this.a = objArr;
    }

    public void run() {
        Object a2 = this.b.a((Params[]) this.a);
        b bVar = this.b;
        if (!bVar.f) {
            bVar.c = new e(bVar, a2);
            bVar.a().post(this.b.c);
        }
    }
}
