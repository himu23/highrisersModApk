package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite;
import com.fyber.inneractive.sdk.protobuf.a;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public final class y {
    public static final Charset a = Charset.forName("UTF-8");
    public static final byte[] b;

    public interface a extends j<Boolean> {
    }

    public interface b extends j<Double> {
    }

    public interface c {
        int a();
    }

    public interface d<T extends c> {
        T a(int i);
    }

    public interface e {
        boolean a(int i);
    }

    public interface f extends j<Float> {
    }

    public interface g extends j<Integer> {
    }

    public static class h<F, T> extends AbstractList<T> {
        public final List<F> a;
        public final a<F, T> b;

        public interface a<F, T> {
        }

        public h(List<F> list, a<F, T> aVar) {
            this.a = list;
            this.b = aVar;
        }

        public T get(int i) {
            a<F, T> aVar = this.b;
            F f = this.a.get(i);
            ((TokenParametersOuterClass$TokenParameters.a) aVar).getClass();
            T a2 = TokenParametersOuterClass$TokenParameters.k.a(((Integer) f).intValue());
            return a2 == null ? TokenParametersOuterClass$TokenParameters.k.UNRECOGNIZED : a2;
        }

        public int size() {
            return this.a.size();
        }
    }

    public interface i extends j<Long> {
    }

    public interface j<E> extends List<E>, RandomAccess {
        j<E> b(int i);

        void b();

        boolean d();
    }

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        b = bArr;
        ByteBuffer.wrap(bArr);
        j.a(bArr, 0, 0, false);
    }

    public static int a(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static Object a(Object obj, Object obj2) {
        o0 o0Var = (o0) obj2;
        a.C0130a aVar = (a.C0130a) ((o0) obj).toBuilder();
        aVar.getClass();
        GeneratedMessageLite.b bVar = (GeneratedMessageLite.b) aVar;
        if (bVar.a.getClass().isInstance(o0Var)) {
            bVar.c();
            bVar.a(bVar.b, (GeneratedMessageLite) ((a) o0Var));
            return bVar.b();
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
