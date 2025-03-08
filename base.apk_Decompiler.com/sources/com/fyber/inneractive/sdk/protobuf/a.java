package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.a;
import com.fyber.inneractive.sdk.protobuf.a.C0130a;
import com.fyber.inneractive.sdk.protobuf.i;
import com.fyber.inneractive.sdk.protobuf.l;
import com.fyber.inneractive.sdk.protobuf.o0;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0130a<MessageType, BuilderType>> implements o0 {
    public int memoizedHashCode = 0;

    @Deprecated
    public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        C0130a.a(iterable, (List) collection);
    }

    public static void checkByteStringIsUtf8(i iVar) throws IllegalArgumentException {
        if (!iVar.e()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String getSerializingExceptionMessage(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public int getMemoizedSerializedSize() {
        throw new UnsupportedOperationException();
    }

    public int getSerializedSize(d1 d1Var) {
        int memoizedSerializedSize = getMemoizedSerializedSize();
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int b = d1Var.b(this);
        setMemoizedSerializedSize(b);
        return b;
    }

    public j1 newUninitializedMessageException() {
        return new j1();
    }

    public void setMemoizedSerializedSize(int i) {
        throw new UnsupportedOperationException();
    }

    public byte[] toByteArray() {
        try {
            int serializedSize = getSerializedSize();
            byte[] bArr = new byte[serializedSize];
            Logger logger = l.b;
            l.c cVar = new l.c(bArr, 0, serializedSize);
            writeTo(cVar);
            if (cVar.a() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e);
        }
    }

    public i toByteString() {
        try {
            int serializedSize = getSerializedSize();
            i iVar = i.b;
            byte[] bArr = new byte[serializedSize];
            l a = l.a(bArr);
            writeTo(a);
            if (a.a() == 0) {
                return new i.h(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        int c = l.c(serializedSize) + serializedSize;
        if (c > 4096) {
            c = 4096;
        }
        l.e eVar = new l.e(outputStream, c);
        eVar.g(serializedSize);
        writeTo(eVar);
        if (eVar.f > 0) {
            eVar.b();
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        Logger logger = l.b;
        if (serializedSize > 4096) {
            serializedSize = 4096;
        }
        l.e eVar = new l.e(outputStream, serializedSize);
        writeTo(eVar);
        if (eVar.f > 0) {
            eVar.b();
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.protobuf.a$a  reason: collision with other inner class name */
    public static abstract class C0130a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0130a<MessageType, BuilderType>> implements o0.a {
        public static <T> void a(Iterable<T> iterable, List<? super T> list) {
            Charset charset = y.a;
            iterable.getClass();
            if (iterable instanceof d0) {
                List<?> c = ((d0) iterable).c();
                d0 d0Var = (d0) list;
                int size = list.size();
                for (Object next : c) {
                    if (next == null) {
                        String str = "Element at index " + (d0Var.size() - size) + " is null.";
                        for (int size2 = d0Var.size() - 1; size2 >= size; size2--) {
                            d0Var.remove(size2);
                        }
                        throw new NullPointerException(str);
                    } else if (next instanceof i) {
                        d0Var.a((i) next);
                    } else {
                        d0Var.add((String) next);
                    }
                }
            } else if (iterable instanceof x0) {
                list.addAll((Collection) iterable);
            } else {
                if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                    ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
                }
                int size3 = list.size();
                for (T next2 : iterable) {
                    if (next2 == null) {
                        String str2 = "Element at index " + (list.size() - size3) + " is null.";
                        for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                            list.remove(size4);
                        }
                        throw new NullPointerException(str2);
                    }
                    list.add(next2);
                }
            }
        }

        /* renamed from: com.fyber.inneractive.sdk.protobuf.a$a$a  reason: collision with other inner class name */
        public static final class C0131a extends FilterInputStream {
            public int a;

            public C0131a(InputStream inputStream, int i) {
                super(inputStream);
                this.a = i;
            }

            public int available() throws IOException {
                return Math.min(super.available(), this.a);
            }

            public long skip(long j) throws IOException {
                long skip = super.skip(Math.min(j, (long) this.a));
                if (skip >= 0) {
                    this.a = (int) (((long) this.a) - skip);
                }
                return skip;
            }

            public int read() throws IOException {
                if (this.a <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.a--;
                }
                return read;
            }

            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = this.a;
                if (i3 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i, Math.min(i2, i3));
                if (read >= 0) {
                    this.a -= read;
                }
                return read;
            }
        }
    }

    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        C0130a.a(iterable, list);
    }
}
