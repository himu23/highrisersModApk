package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.s1;
import java.io.IOException;

public class m1 extends k1<l1, l1> {
    public void a(Object obj, int i, int i2) {
        ((l1) obj).a(r1.a(i, 5), (Object) Integer.valueOf(i2));
    }

    public boolean a(c1 c1Var) {
        return false;
    }

    public void b(Object obj, int i, long j) {
        ((l1) obj).a(r1.a(i, 0), (Object) Long.valueOf(j));
    }

    public int c(Object obj) {
        return ((l1) obj).b();
    }

    public int d(Object obj) {
        l1 l1Var = (l1) obj;
        int i = l1Var.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < l1Var.a; i3++) {
            int i4 = l1Var.b[i3];
            int i5 = r1.a;
            i2 += (l.b(1) * 2) + l.f(2, i4 >>> 3) + l.a(3, (i) l1Var.c[i3]);
        }
        l1Var.d = i2;
        return i2;
    }

    public void e(Object obj) {
        ((GeneratedMessageLite) obj).unknownFields.e = false;
    }

    public Object f(Object obj) {
        l1 l1Var = (l1) obj;
        l1Var.e = false;
        return l1Var;
    }

    public void a(Object obj, int i, long j) {
        ((l1) obj).a(r1.a(i, 1), (Object) Long.valueOf(j));
    }

    public void b(Object obj, Object obj2) {
        ((GeneratedMessageLite) obj).unknownFields = (l1) obj2;
    }

    public void c(Object obj, Object obj2) {
        ((GeneratedMessageLite) obj).unknownFields = (l1) obj2;
    }

    public void a(Object obj, int i, Object obj2) {
        ((l1) obj).a(r1.a(i, 3), (Object) (l1) obj2);
    }

    public void b(Object obj, s1 s1Var) throws IOException {
        ((l1) obj).a(s1Var);
    }

    public void a(Object obj, int i, i iVar) {
        ((l1) obj).a(r1.a(i, 2), (Object) iVar);
    }

    public Object b(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    public Object a(Object obj, Object obj2) {
        l1 l1Var = (l1) obj;
        l1 l1Var2 = (l1) obj2;
        return l1Var2.equals(l1.f) ? l1Var : l1.a(l1Var, l1Var2);
    }

    public void a(Object obj, s1 s1Var) throws IOException {
        l1 l1Var = (l1) obj;
        l1Var.getClass();
        m mVar = (m) s1Var;
        mVar.getClass();
        if (s1.a.ASCENDING == s1.a.DESCENDING) {
            for (int i = l1Var.a - 1; i >= 0; i--) {
                int i2 = l1Var.b[i];
                int i3 = r1.a;
                mVar.a(i2 >>> 3, l1Var.c[i]);
            }
            return;
        }
        for (int i4 = 0; i4 < l1Var.a; i4++) {
            int i5 = l1Var.b[i4];
            int i6 = r1.a;
            mVar.a(i5 >>> 3, l1Var.c[i4]);
        }
    }

    public Object a() {
        return l1.c();
    }

    public Object a(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        l1 l1Var = generatedMessageLite.unknownFields;
        if (l1Var != l1.f) {
            return l1Var;
        }
        l1 c = l1.c();
        generatedMessageLite.unknownFields = c;
        return c;
    }
}
