package com.fyber.inneractive.sdk.click;

import com.fyber.inneractive.sdk.click.l;
import java.util.ArrayList;
import java.util.List;

public class b {
    public final l.d a;
    public final Throwable b;
    public final String c;
    public final String d;
    public long e;
    public List<i> f = new ArrayList();

    public b(String str, l.d dVar, String str2, Throwable th) {
        this.d = str;
        this.a = dVar;
        this.c = str2;
        this.b = th;
    }

    public String toString() {
        l.d dVar = this.a;
        if (dVar == l.d.FAILED) {
            Object[] objArr = new Object[1];
            Throwable th = this.b;
            objArr[0] = th != null ? th.getMessage() : "none";
            return String.format("Open result: Failed! error: %s", objArr);
        }
        return String.format("Open result: Success! target: %s method: %s", new Object[]{dVar, this.c});
    }
}
