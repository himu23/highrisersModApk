package com.google.android.gms.internal.drive;

import java.lang.reflect.Type;

public enum zzke {
    DOUBLE(0, zzkg.SCALAR, zzks.DOUBLE),
    FLOAT(1, zzkg.SCALAR, zzks.FLOAT),
    INT64(2, zzkg.SCALAR, zzks.LONG),
    UINT64(3, zzkg.SCALAR, zzks.LONG),
    INT32(4, zzkg.SCALAR, zzks.INT),
    FIXED64(5, zzkg.SCALAR, zzks.LONG),
    FIXED32(6, zzkg.SCALAR, zzks.INT),
    BOOL(7, zzkg.SCALAR, zzks.BOOLEAN),
    STRING(8, zzkg.SCALAR, zzks.STRING),
    MESSAGE(9, zzkg.SCALAR, zzks.MESSAGE),
    BYTES(10, zzkg.SCALAR, zzks.BYTE_STRING),
    UINT32(11, zzkg.SCALAR, zzks.INT),
    ENUM(12, zzkg.SCALAR, zzks.ENUM),
    SFIXED32(13, zzkg.SCALAR, zzks.INT),
    SFIXED64(14, zzkg.SCALAR, zzks.LONG),
    SINT32(15, zzkg.SCALAR, zzks.INT),
    SINT64(16, zzkg.SCALAR, zzks.LONG),
    GROUP(17, zzkg.SCALAR, zzks.MESSAGE),
    DOUBLE_LIST(18, zzkg.VECTOR, zzks.DOUBLE),
    FLOAT_LIST(19, zzkg.VECTOR, zzks.FLOAT),
    INT64_LIST(20, zzkg.VECTOR, zzks.LONG),
    UINT64_LIST(21, zzkg.VECTOR, zzks.LONG),
    INT32_LIST(22, zzkg.VECTOR, zzks.INT),
    FIXED64_LIST(23, zzkg.VECTOR, zzks.LONG),
    FIXED32_LIST(24, zzkg.VECTOR, zzks.INT),
    BOOL_LIST(25, zzkg.VECTOR, zzks.BOOLEAN),
    STRING_LIST(26, zzkg.VECTOR, zzks.STRING),
    MESSAGE_LIST(27, zzkg.VECTOR, zzks.MESSAGE),
    BYTES_LIST(28, zzkg.VECTOR, zzks.BYTE_STRING),
    UINT32_LIST(29, zzkg.VECTOR, zzks.INT),
    ENUM_LIST(30, zzkg.VECTOR, zzks.ENUM),
    SFIXED32_LIST(31, zzkg.VECTOR, zzks.INT),
    SFIXED64_LIST(32, zzkg.VECTOR, zzks.LONG),
    SINT32_LIST(33, zzkg.VECTOR, zzks.INT),
    SINT64_LIST(34, zzkg.VECTOR, zzks.LONG),
    DOUBLE_LIST_PACKED(35, zzkg.PACKED_VECTOR, zzks.DOUBLE),
    FLOAT_LIST_PACKED(36, zzkg.PACKED_VECTOR, zzks.FLOAT),
    INT64_LIST_PACKED(37, zzkg.PACKED_VECTOR, zzks.LONG),
    UINT64_LIST_PACKED(38, zzkg.PACKED_VECTOR, zzks.LONG),
    INT32_LIST_PACKED(39, zzkg.PACKED_VECTOR, zzks.INT),
    FIXED64_LIST_PACKED(40, zzkg.PACKED_VECTOR, zzks.LONG),
    FIXED32_LIST_PACKED(41, zzkg.PACKED_VECTOR, zzks.INT),
    BOOL_LIST_PACKED(42, zzkg.PACKED_VECTOR, zzks.BOOLEAN),
    UINT32_LIST_PACKED(43, zzkg.PACKED_VECTOR, zzks.INT),
    ENUM_LIST_PACKED(44, zzkg.PACKED_VECTOR, zzks.ENUM),
    SFIXED32_LIST_PACKED(45, zzkg.PACKED_VECTOR, zzks.INT),
    SFIXED64_LIST_PACKED(46, zzkg.PACKED_VECTOR, zzks.LONG),
    SINT32_LIST_PACKED(47, zzkg.PACKED_VECTOR, zzks.INT),
    SINT64_LIST_PACKED(48, zzkg.PACKED_VECTOR, zzks.LONG),
    GROUP_LIST(49, zzkg.VECTOR, zzks.MESSAGE),
    MAP(50, zzkg.MAP, zzks.VOID);
    
    private static final zzke[] zzrb = null;
    private static final Type[] zzrc = null;
    private final int id;
    private final zzks zzqx;
    private final zzkg zzqy;
    private final Class<?> zzqz;
    private final boolean zzra;

    public final int id() {
        return this.id;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r1 = com.google.android.gms.internal.drive.zzkf.zzrf[r5.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzke(int r3, com.google.android.gms.internal.drive.zzkg r4, com.google.android.gms.internal.drive.zzks r5) {
        /*
            r0 = this;
            r0.<init>(r1, r2)
            r0.id = r3
            r0.zzqy = r4
            r0.zzqx = r5
            int[] r1 = com.google.android.gms.internal.drive.zzkf.zzre
            int r2 = r4.ordinal()
            r1 = r1[r2]
            r2 = 2
            r3 = 1
            if (r1 == r3) goto L_0x0022
            if (r1 == r2) goto L_0x001b
            r1 = 0
            r0.zzqz = r1
            goto L_0x0028
        L_0x001b:
            java.lang.Class r1 = r5.zzdo()
            r0.zzqz = r1
            goto L_0x0028
        L_0x0022:
            java.lang.Class r1 = r5.zzdo()
            r0.zzqz = r1
        L_0x0028:
            com.google.android.gms.internal.drive.zzkg r1 = com.google.android.gms.internal.drive.zzkg.SCALAR
            if (r4 != r1) goto L_0x003c
            int[] r1 = com.google.android.gms.internal.drive.zzkf.zzrf
            int r4 = r5.ordinal()
            r1 = r1[r4]
            if (r1 == r3) goto L_0x003c
            if (r1 == r2) goto L_0x003c
            r2 = 3
            if (r1 == r2) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r3 = 0
        L_0x003d:
            r0.zzra = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzke.<init>(java.lang.String, int, int, com.google.android.gms.internal.drive.zzkg, com.google.android.gms.internal.drive.zzks):void");
    }

    static {
        int i;
        zzrc = new Type[0];
        zzke[] values = values();
        zzrb = new zzke[values.length];
        for (zzke zzke : values) {
            zzrb[zzke.id] = zzke;
        }
    }
}
