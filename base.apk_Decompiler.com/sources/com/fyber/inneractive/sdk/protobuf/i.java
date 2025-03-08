package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

public abstract class i implements Iterable<Byte>, Serializable {
    public static final i b = new h(y.b);
    public static final e c;
    public int a = 0;

    public static abstract class b implements f {
        public Object next() {
            return Byte.valueOf(a());
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class c implements e {
        public byte[] a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }
    }

    public static final class d extends h {
        private static final long serialVersionUID = 1;
        public final int e;
        public final int f;

        public d(byte[] bArr, int i, int i2) {
            super(bArr);
            i.a(i, i + i2, bArr.length);
            this.e = i;
            this.f = i2;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        public void a(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.d, this.e + i, bArr, i2, i3);
        }

        public byte d(int i) {
            return this.d[this.e + i];
        }

        public int j() {
            return this.e;
        }

        public int size() {
            return this.f;
        }

        public Object writeReplace() {
            return new h(h());
        }

        public byte c(int i) {
            i.a(i, this.f);
            return this.d[this.e + i];
        }
    }

    public interface e {
        byte[] a(byte[] bArr, int i, int i2);
    }

    public interface f extends Iterator<Byte> {
        byte a();
    }

    public static abstract class g extends i {
        public Iterator iterator() {
            return new a();
        }
    }

    public static class h extends g {
        private static final long serialVersionUID = 1;
        public final byte[] d;

        public h(byte[] bArr) {
            bArr.getClass();
            this.d = bArr;
        }

        public void a(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.d, i, bArr, i2, i3);
        }

        public final i b(int i, int i2) {
            int a = i.a(i, i2, size());
            if (a == 0) {
                return i.b;
            }
            return new d(this.d, j() + i, a);
        }

        public byte c(int i) {
            return this.d[i];
        }

        public byte d(int i) {
            return this.d[i];
        }

        public final boolean e() {
            int j = j();
            return q1.b(this.d, j, size() + j);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof i) || size() != ((i) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof h)) {
                return obj.equals(this);
            }
            h hVar = (h) obj;
            int i = this.a;
            int i2 = hVar.a;
            if (i == 0 || i2 == 0 || i == i2) {
                return a(hVar, 0, size());
            }
            return false;
        }

        public int j() {
            return 0;
        }

        public int size() {
            return this.d.length;
        }

        public final void a(h hVar) throws IOException {
            hVar.a(this.d, j(), size());
        }

        public final j g() {
            return j.a(this.d, j(), size(), true);
        }

        public final String a(Charset charset) {
            return new String(this.d, j(), size(), charset);
        }

        public final boolean a(i iVar, int i, int i2) {
            if (i2 <= iVar.size()) {
                int i3 = i + i2;
                if (i3 > iVar.size()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + iVar.size());
                } else if (!(iVar instanceof h)) {
                    return iVar.b(i, i3).equals(b(0, i2));
                } else {
                    h hVar = (h) iVar;
                    byte[] bArr = this.d;
                    byte[] bArr2 = hVar.d;
                    int j = j() + i2;
                    int j2 = j();
                    int j3 = hVar.j() + i;
                    while (j2 < j) {
                        if (bArr[j2] != bArr2[j3]) {
                            return false;
                        }
                        j2++;
                        j3++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i2 + size());
            }
        }

        public final int b(int i, int i2, int i3) {
            byte[] bArr = this.d;
            int j = j() + i2;
            Charset charset = y.a;
            for (int i4 = j; i4 < j + i3; i4++) {
                i = (i * 31) + bArr[i4];
            }
            return i;
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.protobuf.i$i  reason: collision with other inner class name */
    public static final class C0132i implements e {
        public byte[] a(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }
    }

    static {
        e eVar;
        if (d.a()) {
            eVar = new C0132i();
        } else {
            eVar = new c();
        }
        c = eVar;
    }

    public static i a(byte[] bArr, int i, int i2) {
        a(i, i + i2, bArr.length);
        return new h(c.a(bArr, i, i2));
    }

    public abstract String a(Charset charset);

    public abstract void a(h hVar) throws IOException;

    public abstract void a(byte[] bArr, int i, int i2, int i3);

    public abstract int b(int i, int i2, int i3);

    public abstract i b(int i, int i2);

    public abstract byte c(int i);

    public abstract byte d(int i);

    public abstract boolean e();

    public abstract boolean equals(Object obj);

    /* renamed from: f */
    public f iterator() {
        return new a();
    }

    public abstract j g();

    public final byte[] h() {
        int size = size();
        if (size == 0) {
            return y.b;
        }
        byte[] bArr = new byte[size];
        a(bArr, 0, 0, size);
        return bArr;
    }

    public final String i() {
        return size() == 0 ? "" : a(y.a);
    }

    public abstract int size();

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        if (size() <= 50) {
            str = i1.a(this);
        } else {
            str = i1.a(b(0, 47)) + "...";
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public static i a(String str) {
        return new h(str.getBytes(y.a));
    }

    public static void a(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }

    public final int hashCode() {
        int i = this.a;
        if (i == 0) {
            int size = size();
            i = b(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.a = i;
        }
        return i;
    }

    public class a extends b {
        public int a = 0;
        public final int b;

        public a() {
            this.b = i.this.size();
        }

        public boolean hasNext() {
            return this.a < this.b;
        }

        public byte a() {
            int i = this.a;
            if (i < this.b) {
                this.a = i + 1;
                return i.this.d(i);
            }
            throw new NoSuchElementException();
        }
    }

    public static int a(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
        }
    }
}
