package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite;
import com.fyber.inneractive.sdk.protobuf.f;
import com.fyber.inneractive.sdk.protobuf.q;
import com.fyber.inneractive.sdk.protobuf.r1;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class s extends r<GeneratedMessageLite.d> {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.fyber.inneractive.sdk.protobuf.r1$b[] r0 = com.fyber.inneractive.sdk.protobuf.r1.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.FIXED32     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.BOOL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.UINT32     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.SINT32     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.ENUM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.STRING     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.GROUP     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.s.a.<clinit>():void");
        }
    }

    public boolean a(o0 o0Var) {
        return o0Var instanceof GeneratedMessageLite.ExtendableMessage;
    }

    public u<GeneratedMessageLite.d> b(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).ensureExtensionsAreMutable();
    }

    public void c(Object obj) {
        ((GeneratedMessageLite.ExtendableMessage) obj).extensions.g();
    }

    public u<GeneratedMessageLite.d> a(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).extensions;
    }

    public <UT, UB> UB a(c1 c1Var, Object obj, q qVar, u<GeneratedMessageLite.d> uVar, UB ub, k1<UT, UB> k1Var) throws IOException {
        Object obj2;
        Object a2;
        ArrayList arrayList;
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        GeneratedMessageLite.d dVar = eVar.d;
        int i = dVar.b;
        if (!dVar.d || !dVar.e) {
            r1.b bVar = dVar.c;
            if (bVar != r1.b.ENUM) {
                switch (a.a[bVar.ordinal()]) {
                    case 1:
                        obj2 = Double.valueOf(c1Var.h());
                        break;
                    case 2:
                        obj2 = Float.valueOf(c1Var.k());
                        break;
                    case 3:
                        obj2 = Long.valueOf(c1Var.o());
                        break;
                    case 4:
                        obj2 = Long.valueOf(c1Var.f());
                        break;
                    case 5:
                        obj2 = Integer.valueOf(c1Var.d());
                        break;
                    case 6:
                        obj2 = Long.valueOf(c1Var.g());
                        break;
                    case 7:
                        obj2 = Integer.valueOf(c1Var.q());
                        break;
                    case 8:
                        obj2 = Boolean.valueOf(c1Var.r());
                        break;
                    case 9:
                        obj2 = Integer.valueOf(c1Var.c());
                        break;
                    case 10:
                        obj2 = Integer.valueOf(c1Var.m());
                        break;
                    case 11:
                        obj2 = Long.valueOf(c1Var.t());
                        break;
                    case 12:
                        obj2 = Integer.valueOf(c1Var.j());
                        break;
                    case 13:
                        obj2 = Long.valueOf(c1Var.l());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        obj2 = c1Var.a();
                        break;
                    case 16:
                        obj2 = c1Var.n();
                        break;
                    case 17:
                        obj2 = c1Var.a(eVar.c.getClass(), qVar);
                        break;
                    case 18:
                        obj2 = c1Var.b(eVar.c.getClass(), qVar);
                        break;
                    default:
                        obj2 = null;
                        break;
                }
            } else {
                int d = c1Var.d();
                if (eVar.d.a.a(d) == null) {
                    Class<?> cls = f1.a;
                    if (ub == null) {
                        ub = k1Var.a();
                    }
                    k1Var.b(ub, i, (long) d);
                    return ub;
                }
                obj2 = Integer.valueOf(d);
            }
            GeneratedMessageLite.d dVar2 = eVar.d;
            if (dVar2.d) {
                uVar.a(dVar2, (Object) obj2);
            } else {
                int i2 = a.a[dVar2.c.ordinal()];
                if ((i2 == 17 || i2 == 18) && (a2 = uVar.a(eVar.d)) != null) {
                    obj2 = y.a(a2, (Object) obj2);
                }
                uVar.c(eVar.d, obj2);
            }
        } else {
            switch (a.a[dVar.c.ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    c1Var.j(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    c1Var.d(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    c1Var.k(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    c1Var.a(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    c1Var.o(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    c1Var.n(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    c1Var.e(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    c1Var.l(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    c1Var.i(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    c1Var.f(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    c1Var.m(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    c1Var.c(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    c1Var.g(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    c1Var.p(arrayList);
                    ub = f1.a(i, (List<Integer>) arrayList, eVar.d.a, ub, k1Var);
                    break;
                default:
                    StringBuilder sb = new StringBuilder("Type cannot be packed: ");
                    sb.append(eVar.d.c);
                    throw new IllegalStateException(sb.toString());
            }
            uVar.c(eVar.d, arrayList);
        }
        return ub;
    }

    public Object a(q qVar, o0 o0Var, int i) {
        return qVar.a.get(new q.a(o0Var, i));
    }

    public int a(Map.Entry<?, ?> entry) {
        return ((GeneratedMessageLite.d) entry.getKey()).b;
    }

    public void a(s1 s1Var, Map.Entry<?, ?> entry) throws IOException {
        GeneratedMessageLite.d dVar = (GeneratedMessageLite.d) entry.getKey();
        if (dVar.d) {
            switch (a.a[dVar.c.ordinal()]) {
                case 1:
                    f1.b(dVar.b, (List<Double>) (List) entry.getValue(), s1Var, dVar.e);
                    return;
                case 2:
                    f1.f(dVar.b, (List) entry.getValue(), s1Var, dVar.e);
                    return;
                case 3:
                    f1.h(dVar.b, (List) entry.getValue(), s1Var, dVar.e);
                    return;
                case 4:
                    f1.n(dVar.b, (List) entry.getValue(), s1Var, dVar.e);
                    return;
                case 5:
                    f1.g(dVar.b, (List) entry.getValue(), s1Var, dVar.e);
                    return;
                case 6:
                    f1.e(dVar.b, (List) entry.getValue(), s1Var, dVar.e);
                    return;
                case 7:
                    f1.d(dVar.b, (List) entry.getValue(), s1Var, dVar.e);
                    return;
                case 8:
                    f1.a(dVar.b, (List<Boolean>) (List) entry.getValue(), s1Var, dVar.e);
                    return;
                case 9:
                    f1.m(dVar.b, (List) entry.getValue(), s1Var, dVar.e);
                    return;
                case 10:
                    f1.i(dVar.b, (List) entry.getValue(), s1Var, dVar.e);
                    return;
                case 11:
                    f1.j(dVar.b, (List) entry.getValue(), s1Var, dVar.e);
                    return;
                case 12:
                    f1.k(dVar.b, (List) entry.getValue(), s1Var, dVar.e);
                    return;
                case 13:
                    f1.l(dVar.b, (List) entry.getValue(), s1Var, dVar.e);
                    return;
                case 14:
                    f1.g(dVar.b, (List) entry.getValue(), s1Var, dVar.e);
                    return;
                case 15:
                    f1.a(dVar.b, (List<i>) (List) entry.getValue(), s1Var);
                    return;
                case 16:
                    f1.b(dVar.b, (List<String>) (List) entry.getValue(), s1Var);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        f1.a(dVar.b, (List<?>) (List) entry.getValue(), s1Var, (d1) z0.c.a(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        f1.b(dVar.b, (List<?>) (List) entry.getValue(), s1Var, (d1) z0.c.a(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (a.a[dVar.c.ordinal()]) {
                case 1:
                    ((m) s1Var).a(dVar.b, ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    ((m) s1Var).a(dVar.b, ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    ((m) s1Var).a.g(dVar.b, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    ((m) s1Var).a.g(dVar.b, ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    ((m) s1Var).a.h(dVar.b, ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    ((m) s1Var).a.f(dVar.b, ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    ((m) s1Var).a.g(dVar.b, ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    ((m) s1Var).a.b(dVar.b, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    ((m) s1Var).a.j(dVar.b, ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    ((m) s1Var).a.g(dVar.b, ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    ((m) s1Var).a.f(dVar.b, ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    ((m) s1Var).a(dVar.b, ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    ((m) s1Var).a(dVar.b, ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    ((m) s1Var).a.h(dVar.b, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    ((m) s1Var).a.b(dVar.b, (i) entry.getValue());
                    return;
                case 16:
                    ((m) s1Var).a.b(dVar.b, (String) entry.getValue());
                    return;
                case 17:
                    ((m) s1Var).a(dVar.b, entry.getValue(), z0.c.a(entry.getValue().getClass()));
                    return;
                case 18:
                    ((m) s1Var).b(dVar.b, entry.getValue(), z0.c.a(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }

    public void a(c1 c1Var, Object obj, q qVar, u<GeneratedMessageLite.d> uVar) throws IOException {
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        uVar.c(eVar.d, c1Var.b(eVar.c.getClass(), qVar));
    }

    public void a(i iVar, Object obj, q qVar, u<GeneratedMessageLite.d> uVar) throws IOException {
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        GeneratedMessageLite b = ((GeneratedMessageLite.b) eVar.c.newBuilderForType()).b();
        ByteBuffer wrap = ByteBuffer.wrap(iVar.h());
        if (wrap.hasArray()) {
            f.b bVar = new f.b(wrap, true);
            z0 z0Var = z0.c;
            z0Var.getClass();
            z0Var.a(b.getClass()).a(b, bVar, qVar);
            uVar.c(eVar.d, b);
            if (bVar.s() != Integer.MAX_VALUE) {
                throw z.a();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
