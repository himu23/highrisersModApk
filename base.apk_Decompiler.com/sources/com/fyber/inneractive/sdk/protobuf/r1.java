package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;

public final class r1 {
    public static final int a = a(1, 3);
    public static final int b = a(1, 4);
    public static final int c = a(2, 0);
    public static final int d = a(3, 2);

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
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.BYTES     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.UINT32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.SINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.SINT64     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.STRING     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.GROUP     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.ENUM     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.r1.a.<clinit>():void");
        }
    }

    public enum b {
        DOUBLE(c.DOUBLE, 1),
        FLOAT(c.FLOAT, 5),
        INT64(r5, 0),
        UINT64(r5, 0),
        INT32(r11, 0),
        FIXED64(r5, 1),
        FIXED32(r11, 5),
        BOOL(c.BOOLEAN, 0),
        STRING(c.STRING, 2) {
        },
        GROUP(r13, 3) {
            public boolean g() {
                return false;
            }
        },
        MESSAGE(r13, 2) {
            public boolean g() {
                return false;
            }
        },
        BYTES(c.BYTE_STRING, 2) {
            public boolean g() {
                return false;
            }
        },
        UINT32(r11, 0),
        ENUM(c.ENUM, 0),
        SFIXED32(r11, 5),
        SFIXED64(r5, 1),
        SINT32(r11, 0),
        SINT64(r5, 0);
        
        private final c javaType;
        private final int wireType;

        public c e() {
            return this.javaType;
        }

        public int f() {
            return this.wireType;
        }

        public boolean g() {
            return !(this instanceof a);
        }

        /* access modifiers changed from: public */
        b(c cVar, int i) {
            this.javaType = cVar;
            this.wireType = i;
        }
    }

    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(i.b),
        ENUM((String) null),
        MESSAGE((String) null);
        
        private final Object defaultDefault;

        /* access modifiers changed from: public */
        c(Object obj) {
            this.defaultDefault = obj;
        }
    }

    public enum d {
        LOOSE {
            public Object a(j jVar) throws IOException {
                return jVar.r();
            }
        },
        STRICT {
            public Object a(j jVar) throws IOException {
                return jVar.s();
            }
        },
        LAZY {
            public Object a(j jVar) throws IOException {
                return jVar.e();
            }
        };

        public abstract Object a(j jVar) throws IOException;
    }

    public static int a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static Object a(j jVar, b bVar, d dVar) throws IOException {
        switch (a.a[bVar.ordinal()]) {
            case 1:
                return Double.valueOf(jVar.f());
            case 2:
                return Float.valueOf(jVar.j());
            case 3:
                return Long.valueOf(jVar.l());
            case 4:
                return Long.valueOf(jVar.v());
            case 5:
                return Integer.valueOf(jVar.k());
            case 6:
                return Long.valueOf(jVar.i());
            case 7:
                return Integer.valueOf(jVar.h());
            case 8:
                return Boolean.valueOf(jVar.d());
            case 9:
                return jVar.e();
            case 10:
                return Integer.valueOf(jVar.u());
            case 11:
                return Integer.valueOf(jVar.n());
            case 12:
                return Long.valueOf(jVar.o());
            case 13:
                return Integer.valueOf(jVar.p());
            case 14:
                return Long.valueOf(jVar.q());
            case 15:
                return dVar.a(jVar);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
