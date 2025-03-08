package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite;
import com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.b;
import com.fyber.inneractive.sdk.protobuf.a;
import com.fyber.inneractive.sdk.protobuf.e;
import com.fyber.inneractive.sdk.protobuf.o0;
import com.fyber.inneractive.sdk.protobuf.q;
import com.fyber.inneractive.sdk.protobuf.r1;
import com.fyber.inneractive.sdk.protobuf.u;
import com.fyber.inneractive.sdk.protobuf.y;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import sun.misc.Unsafe;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends a<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    public int memoizedSerializedSize = -1;
    public l1 unknownFields = l1.f;

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType> extends GeneratedMessageLite<MessageType, BuilderType> implements p0 {
        public u<d> extensions = u.b();

        public class a {
            public a(ExtendableMessage extendableMessage, boolean z) {
                Iterator<Map.Entry<d, Object>> f = extendableMessage.extensions.f();
                if (f.hasNext()) {
                    Map.Entry next = f.next();
                }
            }
        }

        private void eagerlyMergeMessageSetExtension(j jVar, e<?, ?> eVar, q qVar, int i) throws IOException {
            parseExtension(jVar, qVar, eVar, r1.a(i, 2), i);
        }

        private void mergeMessageSetExtensionFromBytes(i iVar, q qVar, e<?, ?> eVar) throws IOException {
            o0 o0Var = (o0) this.extensions.a(eVar.d);
            o0.a builder = o0Var != null ? o0Var.toBuilder() : null;
            if (builder == null) {
                builder = eVar.c.newBuilderForType();
            }
            a.C0130a aVar = (a.C0130a) builder;
            aVar.getClass();
            try {
                j g = iVar.g();
                ((b) aVar).a(g, qVar);
                g.a(0);
                ensureExtensionsAreMutable().c(eVar.d, eVar.b(((b) builder).a()));
            } catch (z e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading " + aVar.getClass().getName() + " from a ByteString threw an IOException (should never happen).", e2);
            }
        }

        private <MessageType extends o0> void mergeMessageSetExtensionFromCodedStream(MessageType messagetype, j jVar, q qVar) throws IOException {
            int i = 0;
            i iVar = null;
            e eVar = null;
            while (true) {
                int t = jVar.t();
                if (t == 0) {
                    break;
                } else if (t == r1.c) {
                    i = jVar.u();
                    if (i != 0) {
                        eVar = qVar.a.get(new q.a(messagetype, i));
                    }
                } else if (t == r1.d) {
                    if (i == 0 || eVar == null) {
                        iVar = jVar.e();
                    } else {
                        eagerlyMergeMessageSetExtension(jVar, eVar, qVar, i);
                        iVar = null;
                    }
                } else if (!jVar.e(t)) {
                    break;
                }
            }
            jVar.a(r1.b);
            if (iVar != null && i != 0) {
                if (eVar != null) {
                    mergeMessageSetExtensionFromBytes(iVar, qVar, eVar);
                } else {
                    mergeLengthDelimitedField(i, iVar);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c9, code lost:
            r9 = (com.fyber.inneractive.sdk.protobuf.o0) r5.extensions.a(r9);
         */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean parseExtension(com.fyber.inneractive.sdk.protobuf.j r6, com.fyber.inneractive.sdk.protobuf.q r7, com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.e<?, ?> r8, int r9, int r10) throws java.io.IOException {
            /*
                r5 = this;
                int r0 = com.fyber.inneractive.sdk.protobuf.r1.a
                r0 = r9 & 7
                r1 = 1
                r2 = 0
                if (r8 != 0) goto L_0x0009
                goto L_0x002f
            L_0x0009:
                com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r3 = r8.d
                com.fyber.inneractive.sdk.protobuf.r1$b r3 = r3.c
                int r3 = com.fyber.inneractive.sdk.protobuf.u.a((com.fyber.inneractive.sdk.protobuf.r1.b) r3, (boolean) r2)
                if (r0 != r3) goto L_0x0015
                r0 = 0
                goto L_0x0031
            L_0x0015:
                com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r3 = r8.d
                boolean r4 = r3.d
                if (r4 == 0) goto L_0x002f
                com.fyber.inneractive.sdk.protobuf.r1$b r3 = r3.c
                boolean r3 = r3.g()
                if (r3 == 0) goto L_0x002f
                com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r3 = r8.d
                com.fyber.inneractive.sdk.protobuf.r1$b r3 = r3.c
                int r3 = com.fyber.inneractive.sdk.protobuf.u.a((com.fyber.inneractive.sdk.protobuf.r1.b) r3, (boolean) r1)
                if (r0 != r3) goto L_0x002f
                r0 = 1
                goto L_0x0031
            L_0x002f:
                r0 = 0
                r2 = 1
            L_0x0031:
                if (r2 == 0) goto L_0x0038
                boolean r6 = r5.parseUnknownField(r9, r6)
                return r6
            L_0x0038:
                r5.ensureExtensionsAreMutable()
                if (r0 == 0) goto L_0x008d
                int r7 = r6.m()
                int r7 = r6.d(r7)
                com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r9 = r8.d
                com.fyber.inneractive.sdk.protobuf.r1$b r9 = r9.c
                com.fyber.inneractive.sdk.protobuf.r1$b r10 = com.fyber.inneractive.sdk.protobuf.r1.b.ENUM
                if (r9 != r10) goto L_0x006e
            L_0x004d:
                int r9 = r6.a()
                if (r9 <= 0) goto L_0x0088
                int r9 = r6.g()
                com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r10 = r8.d
                com.fyber.inneractive.sdk.protobuf.y$d<?> r10 = r10.a
                com.fyber.inneractive.sdk.protobuf.y$c r9 = r10.a(r9)
                if (r9 != 0) goto L_0x0062
                return r1
            L_0x0062:
                com.fyber.inneractive.sdk.protobuf.u<com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d> r10 = r5.extensions
                com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r0 = r8.d
                java.lang.Object r9 = r8.b(r9)
                r10.a(r0, (java.lang.Object) r9)
                goto L_0x004d
            L_0x006e:
                int r9 = r6.a()
                if (r9 <= 0) goto L_0x0088
                com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r9 = r8.d
                com.fyber.inneractive.sdk.protobuf.r1$b r9 = r9.c
                com.fyber.inneractive.sdk.protobuf.u r10 = com.fyber.inneractive.sdk.protobuf.u.d
                com.fyber.inneractive.sdk.protobuf.r1$d r10 = com.fyber.inneractive.sdk.protobuf.r1.d.LOOSE
                java.lang.Object r9 = com.fyber.inneractive.sdk.protobuf.r1.a(r6, r9, r10)
                com.fyber.inneractive.sdk.protobuf.u<com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d> r10 = r5.extensions
                com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r0 = r8.d
                r10.a(r0, (java.lang.Object) r9)
                goto L_0x006e
            L_0x0088:
                r6.c(r7)
                goto L_0x0111
            L_0x008d:
                int[] r9 = com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.a.a
                com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r0 = r8.d
                com.fyber.inneractive.sdk.protobuf.r1$b r0 = r0.c
                com.fyber.inneractive.sdk.protobuf.r1$c r0 = r0.e()
                int r0 = r0.ordinal()
                r9 = r9[r0]
                if (r9 == r1) goto L_0x00c3
                r7 = 2
                if (r9 == r7) goto L_0x00af
                com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r7 = r8.d
                com.fyber.inneractive.sdk.protobuf.r1$b r7 = r7.c
                com.fyber.inneractive.sdk.protobuf.u r9 = com.fyber.inneractive.sdk.protobuf.u.d
                com.fyber.inneractive.sdk.protobuf.r1$d r9 = com.fyber.inneractive.sdk.protobuf.r1.d.LOOSE
                java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.r1.a(r6, r7, r9)
                goto L_0x00f8
            L_0x00af:
                int r6 = r6.g()
                com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r7 = r8.d
                com.fyber.inneractive.sdk.protobuf.y$d<?> r7 = r7.a
                com.fyber.inneractive.sdk.protobuf.y$c r7 = r7.a(r6)
                if (r7 != 0) goto L_0x00c1
                r5.mergeVarintField(r10, r6)
                return r1
            L_0x00c1:
                r6 = r7
                goto L_0x00f8
            L_0x00c3:
                com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r9 = r8.d
                boolean r10 = r9.d
                if (r10 != 0) goto L_0x00d8
                com.fyber.inneractive.sdk.protobuf.u<com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d> r10 = r5.extensions
                java.lang.Object r9 = r10.a(r9)
                com.fyber.inneractive.sdk.protobuf.o0 r9 = (com.fyber.inneractive.sdk.protobuf.o0) r9
                if (r9 == 0) goto L_0x00d8
                com.fyber.inneractive.sdk.protobuf.o0$a r9 = r9.toBuilder()
                goto L_0x00d9
            L_0x00d8:
                r9 = 0
            L_0x00d9:
                if (r9 != 0) goto L_0x00e1
                com.fyber.inneractive.sdk.protobuf.o0 r9 = r8.c
                com.fyber.inneractive.sdk.protobuf.o0$a r9 = r9.newBuilderForType()
            L_0x00e1:
                com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r10 = r8.d
                com.fyber.inneractive.sdk.protobuf.r1$b r0 = r10.c
                com.fyber.inneractive.sdk.protobuf.r1$b r2 = com.fyber.inneractive.sdk.protobuf.r1.b.GROUP
                if (r0 != r2) goto L_0x00ef
                int r10 = r10.b
                r6.a(r10, r9, r7)
                goto L_0x00f2
            L_0x00ef:
                r6.a((com.fyber.inneractive.sdk.protobuf.o0.a) r9, (com.fyber.inneractive.sdk.protobuf.q) r7)
            L_0x00f2:
                com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$b r9 = (com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.b) r9
                com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite r6 = r9.a()
            L_0x00f8:
                com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r7 = r8.d
                boolean r9 = r7.d
                if (r9 == 0) goto L_0x0108
                com.fyber.inneractive.sdk.protobuf.u<com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d> r9 = r5.extensions
                java.lang.Object r6 = r8.b(r6)
                r9.a(r7, (java.lang.Object) r6)
                goto L_0x0111
            L_0x0108:
                com.fyber.inneractive.sdk.protobuf.u<com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d> r9 = r5.extensions
                java.lang.Object r6 = r8.b(r6)
                r9.c(r7, r6)
            L_0x0111:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.ExtendableMessage.parseExtension(com.fyber.inneractive.sdk.protobuf.j, com.fyber.inneractive.sdk.protobuf.q, com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$e, int, int):boolean");
        }

        private void verifyExtensionContainingType(e<MessageType, ?> eVar) {
            if (eVar.a != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.e();
        }

        public int extensionsSerializedSize() {
            return this.extensions.d();
        }

        public int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.c();
        }

        public /* bridge */ /* synthetic */ o0 getDefaultInstanceForType() {
            return GeneratedMessageLite.super.getDefaultInstanceForType();
        }

        public final <Type> Type getExtension(o<MessageType, Type> oVar) {
            e access$000 = GeneratedMessageLite.checkIsLite(oVar);
            verifyExtensionContainingType(access$000);
            Type a2 = this.extensions.a(access$000.d);
            if (a2 == null) {
                return access$000.b;
            }
            d dVar = access$000.d;
            if (!dVar.d) {
                return access$000.a(a2);
            }
            if (dVar.c.e() != r1.c.ENUM) {
                return a2;
            }
            Type arrayList = new ArrayList();
            for (Object a3 : (List) a2) {
                arrayList.add(access$000.a(a3));
            }
            return arrayList;
        }

        public final <Type> int getExtensionCount(o<MessageType, List<Type>> oVar) {
            e access$000 = GeneratedMessageLite.checkIsLite(oVar);
            verifyExtensionContainingType(access$000);
            u<d> uVar = this.extensions;
            d dVar = access$000.d;
            uVar.getClass();
            if (dVar.b()) {
                Object a2 = uVar.a(dVar);
                if (a2 == null) {
                    return 0;
                }
                return ((List) a2).size();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public final <Type> boolean hasExtension(o<MessageType, Type> oVar) {
            e access$000 = GeneratedMessageLite.checkIsLite(oVar);
            verifyExtensionContainingType(access$000);
            u<d> uVar = this.extensions;
            d dVar = access$000.d;
            uVar.getClass();
            if (!dVar.b()) {
                return uVar.a.get(dVar) != null;
            }
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }

        public /* bridge */ /* synthetic */ o0.a newBuilderForType() {
            return GeneratedMessageLite.super.newBuilderForType();
        }

        public ExtendableMessage<MessageType, BuilderType>.a newExtensionWriter() {
            return new a(this, false);
        }

        public ExtendableMessage<MessageType, BuilderType>.a newMessageSetExtensionWriter() {
            return new a(this, true);
        }

        public <MessageType extends o0> boolean parseUnknownField(MessageType messagetype, j jVar, q qVar, int i) throws IOException {
            int i2 = r1.a;
            int i3 = i >>> 3;
            return parseExtension(jVar, qVar, qVar.a.get(new q.a(messagetype, i3)), i, i3);
        }

        public <MessageType extends o0> boolean parseUnknownFieldAsMessageSet(MessageType messagetype, j jVar, q qVar, int i) throws IOException {
            if (i == r1.a) {
                mergeMessageSetExtensionFromCodedStream(messagetype, jVar, qVar);
                return true;
            } else if ((i & 7) == 2) {
                return parseUnknownField(messagetype, jVar, qVar, i);
            } else {
                return jVar.e(i);
            }
        }

        public /* bridge */ /* synthetic */ o0.a toBuilder() {
            return GeneratedMessageLite.super.toBuilder();
        }

        public u<d> ensureExtensionsAreMutable() {
            u<d> uVar = this.extensions;
            if (uVar.b) {
                this.extensions = uVar.clone();
            }
            return this.extensions;
        }

        public final void mergeExtensionFields(MessageType messagetype) {
            u<d> uVar = this.extensions;
            if (uVar.b) {
                this.extensions = uVar.clone();
            }
            this.extensions.a(messagetype.extensions);
        }

        public final <Type> Type getExtension(o<MessageType, List<Type>> oVar, int i) {
            e access$000 = GeneratedMessageLite.checkIsLite(oVar);
            verifyExtensionContainingType(access$000);
            u<d> uVar = this.extensions;
            d dVar = access$000.d;
            uVar.getClass();
            if (dVar.b()) {
                Object a2 = uVar.a(dVar);
                if (a2 != null) {
                    return access$000.a(((List) a2).get(i));
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.fyber.inneractive.sdk.protobuf.r1$c[] r0 = com.fyber.inneractive.sdk.protobuf.r1.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.fyber.inneractive.sdk.protobuf.r1$c r1 = com.fyber.inneractive.sdk.protobuf.r1.c.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fyber.inneractive.sdk.protobuf.r1$c r1 = com.fyber.inneractive.sdk.protobuf.r1.c.ENUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.a.<clinit>():void");
        }
    }

    public static abstract class b<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends a.C0130a<MessageType, BuilderType> {
        public final MessageType a;
        public MessageType b;
        public boolean c = false;

        public b(MessageType messagetype) {
            this.a = messagetype;
            this.b = (GeneratedMessageLite) messagetype.dynamicMethod(f.NEW_MUTABLE_INSTANCE);
        }

        public final void a(MessageType messagetype, MessageType messagetype2) {
            z0 z0Var = z0.c;
            z0Var.getClass();
            z0Var.a(messagetype.getClass()).a(messagetype, messagetype2);
        }

        public o0 getDefaultInstanceForType() {
            return this.a;
        }

        public final void c() {
            if (this.c) {
                MessageType messagetype = (GeneratedMessageLite) this.b.dynamicMethod(f.NEW_MUTABLE_INSTANCE);
                MessageType messagetype2 = this.b;
                z0 z0Var = z0.c;
                z0Var.getClass();
                z0Var.a(messagetype.getClass()).a(messagetype, messagetype2);
                this.b = messagetype;
                this.c = false;
            }
        }

        public Object clone() throws CloneNotSupportedException {
            b newBuilderForType = this.a.newBuilderForType();
            newBuilderForType.a(b());
            return newBuilderForType;
        }

        public final MessageType a() {
            MessageType b2 = b();
            if (b2.isInitialized()) {
                return b2;
            }
            throw new j1();
        }

        public MessageType b() {
            if (this.c) {
                return this.b;
            }
            this.b.makeImmutable();
            this.c = true;
            return this.b;
        }

        public BuilderType a(MessageType messagetype) {
            c();
            a(this.b, messagetype);
            return this;
        }

        public BuilderType a(j jVar, q qVar) throws IOException {
            c();
            try {
                z0 z0Var = z0.c;
                MessageType messagetype = this.b;
                z0Var.getClass();
                d1<?> a2 = z0Var.a(messagetype.getClass());
                MessageType messagetype2 = this.b;
                k kVar = jVar.d;
                if (kVar == null) {
                    kVar = new k(jVar);
                }
                a2.a(messagetype2, kVar, qVar);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }
    }

    public static class c<T extends GeneratedMessageLite<T, ?>> extends b<T> {
        public final T a;

        public c(T t) {
            this.a = t;
        }
    }

    public static final class d implements u.b<d> {
        public final y.d<?> a;
        public final int b;
        public final r1.b c;
        public final boolean d;
        public final boolean e;

        public d(y.d<?> dVar, int i, r1.b bVar, boolean z, boolean z2) {
            this.a = dVar;
            this.b = i;
            this.c = bVar;
            this.d = z;
            this.e = z2;
        }

        public int a() {
            return this.b;
        }

        public boolean b() {
            return this.d;
        }

        public r1.b c() {
            return this.c;
        }

        public int compareTo(Object obj) {
            return this.b - ((d) obj).b;
        }

        public r1.c d() {
            return this.c.e();
        }

        public boolean isPacked() {
            return this.e;
        }

        public o0.a a(o0.a aVar, o0 o0Var) {
            return ((b) aVar).a((GeneratedMessageLite) o0Var);
        }
    }

    public static class e<ContainingType extends o0, Type> extends o<ContainingType, Type> {
        public final ContainingType a;
        public final Type b;
        public final o0 c;
        public final d d;

        public e(o0 o0Var, Object obj, o0 o0Var2, d dVar) {
            if (o0Var == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (dVar.c() == r1.b.MESSAGE && o0Var2 == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.a = o0Var;
                this.b = obj;
                this.c = o0Var2;
                this.d = dVar;
            }
        }

        public Object a(Object obj) {
            return this.d.c.e() == r1.c.ENUM ? this.d.a.a(((Integer) obj).intValue()) : obj;
        }

        public Object b(Object obj) {
            return this.d.c.e() == r1.c.ENUM ? Integer.valueOf(((y.c) obj).a()) : obj;
        }
    }

    public enum f {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* access modifiers changed from: private */
    public static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType, T> e<MessageType, T> checkIsLite(o<MessageType, T> oVar) {
        oVar.getClass();
        return (e) oVar;
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T t) throws z {
        if (t == null || t.isInitialized()) {
            return t;
        }
        j1 newUninitializedMessageException = t.newUninitializedMessageException();
        newUninitializedMessageException.getClass();
        throw new z(newUninitializedMessageException.getMessage());
    }

    public static y.a emptyBooleanList() {
        return g.d;
    }

    public static y.b emptyDoubleList() {
        return n.d;
    }

    public static y.f emptyFloatList() {
        return v.d;
    }

    public static y.g emptyIntList() {
        return x.d;
    }

    public static y.i emptyLongList() {
        return f0.d;
    }

    public static <E> y.j<E> emptyProtobufList() {
        return a1.d;
    }

    private final void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == l1.f) {
            this.unknownFields = l1.c();
        }
    }

    public static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> cls) {
        T t = (GeneratedMessageLite) defaultInstanceMap.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (GeneratedMessageLite) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            Unsafe unsafe = p1.a;
            try {
                t = ((GeneratedMessageLite) p1.a.allocateInstance(cls)).getDefaultInstanceForType();
                if (t != null) {
                    defaultInstanceMap.put(cls, t);
                } else {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw new IllegalStateException(th);
            }
        }
        return t;
    }

    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e2);
        }
    }

    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static y.g mutableCopy(y.g gVar) {
        x xVar = (x) gVar;
        int i = xVar.c;
        return xVar.b(i == 0 ? 10 : i * 2);
    }

    public static Object newMessageInfo(o0 o0Var, String str, Object[] objArr) {
        return new b1(o0Var, str, objArr);
    }

    public static <ContainingType extends o0, Type> e<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, o0 o0Var, y.d<?> dVar, int i, r1.b bVar, boolean z, Class cls) {
        return new e<>(containingtype, Collections.emptyList(), o0Var, new d(dVar, i, bVar, true, z));
    }

    public static <ContainingType extends o0, Type> e<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, o0 o0Var, y.d<?> dVar, int i, r1.b bVar, Class cls) {
        return new e<>(containingtype, type, o0Var, new d(dVar, i, bVar, false, false));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream) throws z {
        return checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, q.a()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteBuffer byteBuffer, q qVar) throws z {
        return checkMessageInitialized(parseFrom(t, j.a(byteBuffer, false), qVar));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        if (r2 >= 64) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        r3 = r6.read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        if (r3 == -1) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0038, code lost:
        if ((r3 & 128) != 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
        r2 = r2 + 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
        throw com.fyber.inneractive.sdk.protobuf.z.i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0058, code lost:
        throw com.fyber.inneractive.sdk.protobuf.z.e();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T extends com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T r5, java.io.InputStream r6, com.fyber.inneractive.sdk.protobuf.q r7) throws com.fyber.inneractive.sdk.protobuf.z {
        /*
            int r0 = r6.read()     // Catch:{ IOException -> 0x0059 }
            r1 = -1
            if (r0 != r1) goto L_0x0009
            r5 = 0
            return r5
        L_0x0009:
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 != 0) goto L_0x000e
            goto L_0x003a
        L_0x000e:
            r0 = r0 & 127(0x7f, float:1.78E-43)
            r2 = 7
        L_0x0011:
            r3 = 32
            if (r2 >= r3) goto L_0x002c
            int r3 = r6.read()     // Catch:{ IOException -> 0x0059 }
            if (r3 == r1) goto L_0x0027
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r4 = r4 << r2
            r0 = r0 | r4
            r3 = r3 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x0024
            goto L_0x003a
        L_0x0024:
            int r2 = r2 + 7
            goto L_0x0011
        L_0x0027:
            com.fyber.inneractive.sdk.protobuf.z r5 = com.fyber.inneractive.sdk.protobuf.z.i()     // Catch:{ IOException -> 0x0059 }
            throw r5     // Catch:{ IOException -> 0x0059 }
        L_0x002c:
            r3 = 64
            if (r2 >= r3) goto L_0x0054
            int r3 = r6.read()     // Catch:{ IOException -> 0x0059 }
            if (r3 == r1) goto L_0x004f
            r3 = r3 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x004c
        L_0x003a:
            com.fyber.inneractive.sdk.protobuf.a$a$a r1 = new com.fyber.inneractive.sdk.protobuf.a$a$a
            r1.<init>(r6, r0)
            com.fyber.inneractive.sdk.protobuf.j r6 = com.fyber.inneractive.sdk.protobuf.j.a((java.io.InputStream) r1)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite r5 = parsePartialFrom(r5, (com.fyber.inneractive.sdk.protobuf.j) r6, (com.fyber.inneractive.sdk.protobuf.q) r7)
            r7 = 0
            r6.a((int) r7)
            return r5
        L_0x004c:
            int r2 = r2 + 7
            goto L_0x002c
        L_0x004f:
            com.fyber.inneractive.sdk.protobuf.z r5 = com.fyber.inneractive.sdk.protobuf.z.i()     // Catch:{ IOException -> 0x0059 }
            throw r5     // Catch:{ IOException -> 0x0059 }
        L_0x0054:
            com.fyber.inneractive.sdk.protobuf.z r5 = com.fyber.inneractive.sdk.protobuf.z.e()     // Catch:{ IOException -> 0x0059 }
            throw r5     // Catch:{ IOException -> 0x0059 }
        L_0x0059:
            r5 = move-exception
            com.fyber.inneractive.sdk.protobuf.z r6 = new com.fyber.inneractive.sdk.protobuf.z
            java.lang.String r5 = r5.getMessage()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.parsePartialDelimitedFrom(com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite, java.io.InputStream, com.fyber.inneractive.sdk.protobuf.q):com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite");
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, j jVar, q qVar) throws z {
        T t2 = (GeneratedMessageLite) t.dynamicMethod(f.NEW_MUTABLE_INSTANCE);
        try {
            z0 z0Var = z0.c;
            z0Var.getClass();
            d1<?> a2 = z0Var.a(t2.getClass());
            k kVar = jVar.d;
            if (kVar == null) {
                kVar = new k(jVar);
            }
            a2.a(t2, kVar, qVar);
            a2.c(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof z) {
                throw ((z) e2.getCause());
            }
            throw new z(e2.getMessage());
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof z) {
                throw ((z) e3.getCause());
            }
            throw e3;
        }
    }

    public static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> cls, T t) {
        defaultInstanceMap.put(cls, t);
    }

    public Object buildMessageInfo() throws Exception {
        return dynamicMethod(f.BUILD_MESSAGE_INFO);
    }

    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> BuilderType createBuilder() {
        return (b) dynamicMethod(f.NEW_BUILDER);
    }

    public Object dynamicMethod(f fVar, Object obj) {
        return dynamicMethod(fVar, obj, (Object) null);
    }

    public abstract Object dynamicMethod(f fVar, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        z0 z0Var = z0.c;
        z0Var.getClass();
        return z0Var.a(getClass()).b(this, (GeneratedMessageLite) obj);
    }

    public int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize;
    }

    public final w0<MessageType> getParserForType() {
        return (w0) dynamicMethod(f.GET_PARSER);
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        z0 z0Var = z0.c;
        z0Var.getClass();
        int d2 = z0Var.a(getClass()).d(this);
        this.memoizedHashCode = d2;
        return d2;
    }

    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    public void makeImmutable() {
        z0 z0Var = z0.c;
        z0Var.getClass();
        z0Var.a(getClass()).c(this);
    }

    public void mergeLengthDelimitedField(int i, i iVar) {
        ensureUnknownFieldsInitialized();
        l1 l1Var = this.unknownFields;
        l1Var.a();
        if (i != 0) {
            l1Var.a(r1.a(i, 2), (Object) iVar);
            return;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public final void mergeUnknownFields(l1 l1Var) {
        this.unknownFields = l1.a(this.unknownFields, l1Var);
    }

    public void mergeVarintField(int i, int i2) {
        ensureUnknownFieldsInitialized();
        l1 l1Var = this.unknownFields;
        l1Var.a();
        if (i != 0) {
            l1Var.a(r1.a(i, 0), (Object) Long.valueOf((long) i2));
            return;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public boolean parseUnknownField(int i, j jVar) throws IOException {
        int i2 = r1.a;
        if ((i & 7) == 4) {
            return false;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.a(i, jVar);
    }

    public void setMemoizedSerializedSize(int i) {
        this.memoizedSerializedSize = i;
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        q0.a(this, sb, 0);
        return sb.toString();
    }

    public void writeTo(l lVar) throws IOException {
        z0 z0Var = z0.c;
        z0Var.getClass();
        d1<?> a2 = z0Var.a(getClass());
        m mVar = lVar.a;
        if (mVar == null) {
            mVar = new m(lVar);
        }
        a2.a(this, (s1) mVar);
    }

    public static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T t, boolean z) {
        byte byteValue = ((Byte) t.dynamicMethod(f.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        z0 z0Var = z0.c;
        z0Var.getClass();
        boolean a2 = z0Var.a(t.getClass()).a(t);
        if (z) {
            t.dynamicMethod(f.SET_MEMOIZED_IS_INITIALIZED, a2 ? t : null);
        }
        return a2;
    }

    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> BuilderType createBuilder(MessageType messagetype) {
        BuilderType createBuilder = createBuilder();
        createBuilder.c();
        createBuilder.a(createBuilder.b, messagetype);
        return createBuilder;
    }

    public Object dynamicMethod(f fVar) {
        return dynamicMethod(fVar, (Object) null, (Object) null);
    }

    public final MessageType getDefaultInstanceForType() {
        return (GeneratedMessageLite) dynamicMethod(f.GET_DEFAULT_INSTANCE);
    }

    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            z0 z0Var = z0.c;
            z0Var.getClass();
            this.memoizedSerializedSize = z0Var.a(getClass()).b(this);
        }
        return this.memoizedSerializedSize;
    }

    public final BuilderType newBuilderForType() {
        return (b) dynamicMethod(f.NEW_BUILDER);
    }

    public final BuilderType toBuilder() {
        BuilderType buildertype = (b) dynamicMethod(f.NEW_BUILDER);
        buildertype.c();
        buildertype.a(buildertype.b, this);
        return buildertype;
    }

    public static y.i mutableCopy(y.i iVar) {
        f0 f0Var = (f0) iVar;
        int i = f0Var.c;
        return f0Var.b(i == 0 ? 10 : i * 2);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream, q qVar) throws z {
        return checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, qVar));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteBuffer byteBuffer) throws z {
        return parseFrom(t, byteBuffer, q.a());
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, i iVar) throws z {
        return checkMessageInitialized(parseFrom(t, iVar, q.a()));
    }

    public static y.f mutableCopy(y.f fVar) {
        v vVar = (v) fVar;
        int i = vVar.c;
        return vVar.b(i == 0 ? 10 : i * 2);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, i iVar, q qVar) throws z {
        return checkMessageInitialized(parsePartialFrom(t, iVar, qVar));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr) throws z {
        return checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, q.a()));
    }

    public static y.b mutableCopy(y.b bVar) {
        n nVar = (n) bVar;
        int i = nVar.c;
        return nVar.b(i == 0 ? 10 : i * 2);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr, q qVar) throws z {
        return checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, qVar));
    }

    public static y.a mutableCopy(y.a aVar) {
        g gVar = (g) aVar;
        int i = gVar.c;
        return gVar.b(i == 0 ? 10 : i * 2);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, InputStream inputStream) throws z {
        return checkMessageInitialized(parsePartialFrom(t, j.a(inputStream), q.a()));
    }

    public static <E> y.j<E> mutableCopy(y.j<E> jVar) {
        int size = jVar.size();
        return jVar.b(size == 0 ? 10 : size * 2);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, InputStream inputStream, q qVar) throws z {
        return checkMessageInitialized(parsePartialFrom(t, j.a(inputStream), qVar));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, j jVar) throws z {
        return parseFrom(t, jVar, q.a());
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, j jVar, q qVar) throws z {
        return checkMessageInitialized(parsePartialFrom(t, jVar, qVar));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, byte[] bArr, int i, int i2, q qVar) throws z {
        T t2 = (GeneratedMessageLite) t.dynamicMethod(f.NEW_MUTABLE_INSTANCE);
        try {
            z0 z0Var = z0.c;
            z0Var.getClass();
            d1<?> a2 = z0Var.a(t2.getClass());
            a2.a(t2, bArr, i, i + i2, new e.b(qVar));
            a2.c(t2);
            if (t2.memoizedHashCode == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof z) {
                throw ((z) e2.getCause());
            }
            throw new z(e2.getMessage());
        } catch (IndexOutOfBoundsException unused) {
            throw z.i();
        }
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, j jVar) throws z {
        return parsePartialFrom(t, jVar, q.a());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, i iVar, q qVar) throws z {
        j g = iVar.g();
        T parsePartialFrom = parsePartialFrom(t, g, qVar);
        g.a(0);
        return parsePartialFrom;
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, byte[] bArr, q qVar) throws z {
        return checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, qVar));
    }
}
