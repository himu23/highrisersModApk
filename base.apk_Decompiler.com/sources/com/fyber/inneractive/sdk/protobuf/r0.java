package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.e;
import com.fyber.inneractive.sdk.protobuf.h0;
import com.fyber.inneractive.sdk.protobuf.p1;
import com.fyber.inneractive.sdk.protobuf.y;
import com.google.android.gms.drive.DriveFile;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

public final class r0<T> implements d1<T> {
    public static final int[] r = new int[0];
    public static final Unsafe s;
    public final int[] a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final o0 e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int[] j;
    public final int k;
    public final int l;
    public final t0 m;
    public final e0 n;
    public final k1<?, ?> o;
    public final r<?> p;
    public final j0 q;

    public r0(int[] iArr, Object[] objArr, int i2, int i3, o0 o0Var, boolean z, boolean z2, int[] iArr2, int i4, int i5, t0 t0Var, e0 e0Var, k1<?, ?> k1Var, r<?> rVar, j0 j0Var) {
        this.a = iArr;
        this.b = objArr;
        this.c = i2;
        this.d = i3;
        this.g = o0Var instanceof GeneratedMessageLite;
        this.h = z;
        this.f = rVar != null && rVar.a(o0Var);
        this.i = z2;
        this.j = iArr2;
        this.k = i4;
        this.l = i5;
        this.m = t0Var;
        this.n = e0Var;
        this.o = k1Var;
        this.p = rVar;
        this.e = o0Var;
        this.q = j0Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:125:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0292  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> com.fyber.inneractive.sdk.protobuf.r0 a(com.fyber.inneractive.sdk.protobuf.m0 r33, com.fyber.inneractive.sdk.protobuf.t0 r34, com.fyber.inneractive.sdk.protobuf.e0 r35, com.fyber.inneractive.sdk.protobuf.k1 r36, com.fyber.inneractive.sdk.protobuf.r r37, com.fyber.inneractive.sdk.protobuf.j0 r38) {
        /*
            r0 = r33
            boolean r1 = r0 instanceof com.fyber.inneractive.sdk.protobuf.b1
            if (r1 == 0) goto L_0x0409
            com.fyber.inneractive.sdk.protobuf.b1 r0 = (com.fyber.inneractive.sdk.protobuf.b1) r0
            int r1 = r0.d
            r2 = 1
            r1 = r1 & r2
            if (r1 != r2) goto L_0x0011
            com.fyber.inneractive.sdk.protobuf.y0 r1 = com.fyber.inneractive.sdk.protobuf.y0.PROTO2
            goto L_0x0013
        L_0x0011:
            com.fyber.inneractive.sdk.protobuf.y0 r1 = com.fyber.inneractive.sdk.protobuf.y0.PROTO3
        L_0x0013:
            com.fyber.inneractive.sdk.protobuf.y0 r3 = com.fyber.inneractive.sdk.protobuf.y0.PROTO3
            r4 = 0
            if (r1 != r3) goto L_0x001a
            r11 = 1
            goto L_0x001b
        L_0x001a:
            r11 = 0
        L_0x001b:
            java.lang.String r1 = r0.b
            int r3 = r1.length()
            char r5 = r1.charAt(r4)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r6) goto L_0x0035
            r5 = 1
        L_0x002b:
            int r7 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x0036
            r5 = r7
            goto L_0x002b
        L_0x0035:
            r7 = 1
        L_0x0036:
            int r5 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x0055
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0042:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x0052
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r7 = r7 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x0042
        L_0x0052:
            int r5 = r5 << r9
            r7 = r7 | r5
            r5 = r10
        L_0x0055:
            if (r7 != 0) goto L_0x0062
            int[] r7 = r
            r14 = r7
            r7 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            goto L_0x0173
        L_0x0062:
            int r7 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x0081
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x006e:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x007e
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r5 = r5 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x006e
        L_0x007e:
            int r7 = r7 << r9
            r5 = r5 | r7
            r7 = r10
        L_0x0081:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x00a0
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x008d:
            int r12 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r6) goto L_0x009d
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r12
            goto L_0x008d
        L_0x009d:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r12
        L_0x00a0:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r6) goto L_0x00bf
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00ac:
            int r13 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r6) goto L_0x00bc
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r12
            r9 = r9 | r10
            int r12 = r12 + 13
            r10 = r13
            goto L_0x00ac
        L_0x00bc:
            int r10 = r10 << r12
            r9 = r9 | r10
            r10 = r13
        L_0x00bf:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r6) goto L_0x00de
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00cb:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r6) goto L_0x00db
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r10 = r10 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00cb
        L_0x00db:
            int r12 = r12 << r13
            r10 = r10 | r12
            r12 = r14
        L_0x00de:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r6) goto L_0x00fd
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00ea:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r6) goto L_0x00fa
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00ea
        L_0x00fa:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x00fd:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r6) goto L_0x011e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0109:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r6) goto L_0x011a
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x0109
        L_0x011a:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x011e:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r6) goto L_0x0141
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x012a:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x013c
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x012a
        L_0x013c:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0141:
            int r16 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0166
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r4 = r16
            r16 = 13
        L_0x014f:
            int r17 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r6) goto L_0x0161
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r16
            r15 = r15 | r4
            int r16 = r16 + 13
            r4 = r17
            goto L_0x014f
        L_0x0161:
            int r4 = r4 << r16
            r15 = r15 | r4
            r16 = r17
        L_0x0166:
            int r4 = r15 + r13
            int r4 = r4 + r14
            int[] r4 = new int[r4]
            int r14 = r5 * 2
            int r14 = r14 + r7
            r7 = r14
            r14 = r4
            r4 = r5
            r5 = r16
        L_0x0173:
            sun.misc.Unsafe r8 = s
            java.lang.Object[] r2 = r0.c
            com.fyber.inneractive.sdk.protobuf.o0 r6 = r0.a
            java.lang.Class r6 = r6.getClass()
            r19 = r5
            int r5 = r12 * 3
            int[] r5 = new int[r5]
            int r12 = r12 * 2
            java.lang.Object[] r12 = new java.lang.Object[r12]
            int r20 = r15 + r13
            r13 = r7
            r22 = r15
            r7 = r19
            r23 = r20
            r19 = 0
            r21 = 0
        L_0x0194:
            if (r7 >= r3) goto L_0x03db
            int r24 = r7 + 1
            char r7 = r1.charAt(r7)
            r25 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r7 < r3) goto L_0x01c8
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x01a9:
            int r26 = r3 + 1
            char r3 = r1.charAt(r3)
            r27 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r15) goto L_0x01c2
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r7 = r7 | r3
            int r24 = r24 + 13
            r3 = r26
            r15 = r27
            goto L_0x01a9
        L_0x01c2:
            int r3 = r3 << r24
            r7 = r7 | r3
            r3 = r26
            goto L_0x01cc
        L_0x01c8:
            r27 = r15
            r3 = r24
        L_0x01cc:
            int r15 = r3 + 1
            char r3 = r1.charAt(r3)
            r24 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r15) goto L_0x01fe
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r15 = r24
            r24 = 13
        L_0x01df:
            int r26 = r15 + 1
            char r15 = r1.charAt(r15)
            r28 = r10
            r10 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r10) goto L_0x01f8
            r10 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r24
            r3 = r3 | r10
            int r24 = r24 + 13
            r15 = r26
            r10 = r28
            goto L_0x01df
        L_0x01f8:
            int r10 = r15 << r24
            r3 = r3 | r10
            r15 = r26
            goto L_0x0202
        L_0x01fe:
            r28 = r10
            r15 = r24
        L_0x0202:
            r10 = r3 & 255(0xff, float:3.57E-43)
            r24 = r9
            r9 = r3 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x0210
            int r9 = r19 + 1
            r14[r19] = r21
            r19 = r9
        L_0x0210:
            r9 = 51
            r30 = r0
            if (r10 < r9) goto L_0x02a9
            int r9 = r15 + 1
            char r15 = r1.charAt(r15)
            r0 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r0) goto L_0x023f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r31 = 13
        L_0x0225:
            int r32 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r0) goto L_0x023a
            r0 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r0 = r0 << r31
            r15 = r15 | r0
            int r31 = r31 + 13
            r9 = r32
            r0 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0225
        L_0x023a:
            int r0 = r9 << r31
            r15 = r15 | r0
            r9 = r32
        L_0x023f:
            int r0 = r10 + -51
            r31 = r9
            r9 = 9
            if (r0 == r9) goto L_0x025f
            r9 = 17
            if (r0 != r9) goto L_0x024c
            goto L_0x025f
        L_0x024c:
            r9 = 12
            if (r0 != r9) goto L_0x026c
            if (r11 != 0) goto L_0x026c
            int r0 = r21 / 3
            int r0 = r0 * 2
            r9 = 1
            int r0 = r0 + r9
            int r9 = r13 + 1
            r13 = r2[r13]
            r12[r0] = r13
            goto L_0x026b
        L_0x025f:
            int r0 = r21 / 3
            int r0 = r0 * 2
            r9 = 1
            int r0 = r0 + r9
            int r9 = r13 + 1
            r13 = r2[r13]
            r12[r0] = r13
        L_0x026b:
            r13 = r9
        L_0x026c:
            int r15 = r15 * 2
            r0 = r2[r15]
            boolean r9 = r0 instanceof java.lang.reflect.Field
            if (r9 == 0) goto L_0x0277
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0
            goto L_0x027f
        L_0x0277:
            java.lang.String r0 = (java.lang.String) r0
            java.lang.reflect.Field r0 = a((java.lang.Class<?>) r6, (java.lang.String) r0)
            r2[r15] = r0
        L_0x027f:
            r9 = r4
            r32 = r5
            long r4 = r8.objectFieldOffset(r0)
            int r0 = (int) r4
            int r15 = r15 + 1
            r4 = r2[r15]
            boolean r5 = r4 instanceof java.lang.reflect.Field
            if (r5 == 0) goto L_0x0292
            java.lang.reflect.Field r4 = (java.lang.reflect.Field) r4
            goto L_0x029a
        L_0x0292:
            java.lang.String r4 = (java.lang.String) r4
            java.lang.reflect.Field r4 = a((java.lang.Class<?>) r6, (java.lang.String) r4)
            r2[r15] = r4
        L_0x029a:
            long r4 = r8.objectFieldOffset(r4)
            int r5 = (int) r4
            r4 = r1
            r29 = r13
            r15 = r31
            r13 = 0
            r17 = 1
            goto L_0x03a0
        L_0x02a9:
            r9 = r4
            r32 = r5
            int r0 = r13 + 1
            r4 = r2[r13]
            java.lang.String r4 = (java.lang.String) r4
            java.lang.reflect.Field r4 = a((java.lang.Class<?>) r6, (java.lang.String) r4)
            r5 = 9
            if (r10 == r5) goto L_0x031e
            r5 = 17
            if (r10 != r5) goto L_0x02bf
            goto L_0x031e
        L_0x02bf:
            r5 = 27
            if (r10 == r5) goto L_0x030e
            r5 = 49
            if (r10 != r5) goto L_0x02c8
            goto L_0x030e
        L_0x02c8:
            r5 = 12
            if (r10 == r5) goto L_0x02fd
            r5 = 30
            if (r10 == r5) goto L_0x02fd
            r5 = 44
            if (r10 != r5) goto L_0x02d5
            goto L_0x02fd
        L_0x02d5:
            r5 = 50
            if (r10 != r5) goto L_0x02fa
            int r5 = r22 + 1
            r14[r22] = r21
            int r22 = r21 / 3
            int r22 = r22 * 2
            int r26 = r13 + 2
            r0 = r2[r0]
            r12[r22] = r0
            r0 = r3 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x02f6
            int r22 = r22 + 1
            int r0 = r13 + 3
            r13 = r2[r26]
            r12[r22] = r13
            r22 = r5
            goto L_0x02fa
        L_0x02f6:
            r22 = r5
            r0 = r26
        L_0x02fa:
            r17 = 1
            goto L_0x032c
        L_0x02fd:
            if (r11 != 0) goto L_0x02fa
            int r5 = r21 / 3
            int r5 = r5 * 2
            r17 = 1
            int r5 = r5 + 1
            int r13 = r13 + 2
            r0 = r2[r0]
            r12[r5] = r0
            goto L_0x031c
        L_0x030e:
            r17 = 1
            int r5 = r21 / 3
            int r5 = r5 * 2
            int r5 = r5 + 1
            int r13 = r13 + 2
            r0 = r2[r0]
            r12[r5] = r0
        L_0x031c:
            r0 = r13
            goto L_0x032c
        L_0x031e:
            r17 = 1
            int r5 = r21 / 3
            int r5 = r5 * 2
            int r5 = r5 + 1
            java.lang.Class r13 = r4.getType()
            r12[r5] = r13
        L_0x032c:
            long r4 = r8.objectFieldOffset(r4)
            int r5 = (int) r4
            r4 = r3 & 4096(0x1000, float:5.74E-42)
            r13 = 4096(0x1000, float:5.74E-42)
            if (r4 != r13) goto L_0x0386
            r4 = 17
            if (r10 > r4) goto L_0x0386
            int r4 = r15 + 1
            char r13 = r1.charAt(r15)
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r13 < r15) goto L_0x0360
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r18 = 13
        L_0x034a:
            int r26 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r15) goto L_0x035c
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r18
            r13 = r13 | r4
            int r18 = r18 + 13
            r4 = r26
            goto L_0x034a
        L_0x035c:
            int r4 = r4 << r18
            r13 = r13 | r4
            goto L_0x0362
        L_0x0360:
            r26 = r4
        L_0x0362:
            int r4 = r9 * 2
            int r18 = r13 / 32
            int r4 = r4 + r18
            r15 = r2[r4]
            r29 = r0
            boolean r0 = r15 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0373
            java.lang.reflect.Field r15 = (java.lang.reflect.Field) r15
            goto L_0x037b
        L_0x0373:
            java.lang.String r15 = (java.lang.String) r15
            java.lang.reflect.Field r15 = a((java.lang.Class<?>) r6, (java.lang.String) r15)
            r2[r4] = r15
        L_0x037b:
            r4 = r1
            long r0 = r8.objectFieldOffset(r15)
            int r1 = (int) r0
            int r13 = r13 % 32
            r15 = r26
            goto L_0x0390
        L_0x0386:
            r29 = r0
            r4 = r1
            r0 = 55296(0xd800, float:7.7486E-41)
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r13 = 0
        L_0x0390:
            r0 = 18
            if (r10 < r0) goto L_0x039e
            r0 = 49
            if (r10 > r0) goto L_0x039e
            int r0 = r23 + 1
            r14[r23] = r5
            r23 = r0
        L_0x039e:
            r0 = r5
            r5 = r1
        L_0x03a0:
            int r1 = r21 + 1
            r32[r21] = r7
            int r7 = r21 + 2
            r26 = r2
            r2 = r3 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x03af
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03b0
        L_0x03af:
            r2 = 0
        L_0x03b0:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x03b7
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03b8
        L_0x03b7:
            r3 = 0
        L_0x03b8:
            r2 = r2 | r3
            int r3 = r10 << 20
            r2 = r2 | r3
            r0 = r0 | r2
            r32[r1] = r0
            int r21 = r21 + 3
            int r0 = r13 << 20
            r0 = r0 | r5
            r32[r7] = r0
            r1 = r4
            r4 = r9
            r7 = r15
            r9 = r24
            r3 = r25
            r2 = r26
            r15 = r27
            r10 = r28
            r13 = r29
            r0 = r30
            r5 = r32
            goto L_0x0194
        L_0x03db:
            r30 = r0
            r32 = r5
            r24 = r9
            r28 = r10
            r27 = r15
            com.fyber.inneractive.sdk.protobuf.r0 r0 = new com.fyber.inneractive.sdk.protobuf.r0
            r1 = r30
            com.fyber.inneractive.sdk.protobuf.o0 r10 = r1.a
            r1 = 0
            r2 = r32
            r5 = r0
            r6 = r2
            r7 = r12
            r8 = r24
            r9 = r28
            r12 = r1
            r13 = r14
            r14 = r27
            r15 = r20
            r16 = r34
            r17 = r35
            r18 = r36
            r19 = r37
            r20 = r38
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        L_0x0409:
            com.fyber.inneractive.sdk.protobuf.h1 r0 = (com.fyber.inneractive.sdk.protobuf.h1) r0
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.r0.a(com.fyber.inneractive.sdk.protobuf.m0, com.fyber.inneractive.sdk.protobuf.t0, com.fyber.inneractive.sdk.protobuf.e0, com.fyber.inneractive.sdk.protobuf.k1, com.fyber.inneractive.sdk.protobuf.r, com.fyber.inneractive.sdk.protobuf.j0):com.fyber.inneractive.sdk.protobuf.r0");
    }

    public static long d(int i2) {
        return (long) (i2 & 1048575);
    }

    public static l1 e(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        l1 l1Var = generatedMessageLite.unknownFields;
        if (l1Var != l1.f) {
            return l1Var;
        }
        l1 c2 = l1.c();
        generatedMessageLite.unknownFields = c2;
        return c2;
    }

    public static int f(int i2) {
        return (i2 & 267386880) >>> 20;
    }

    public boolean b(T t, T t2) {
        boolean z;
        int length = this.a.length;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int i3 = this.a[i2 + 1];
            long d2 = d(i3);
            switch (f(i3)) {
                case 0:
                    if (a(t, i2) != a(t2, i2)) {
                        break;
                    } else {
                        p1.d dVar = p1.e;
                        if (Double.doubleToLongBits(dVar.c(t, d2)) != Double.doubleToLongBits(dVar.c(t2, d2))) {
                            break;
                        } else {
                            continue;
                        }
                    }
                case 1:
                    if (a(t, i2) != a(t2, i2)) {
                        break;
                    } else {
                        p1.d dVar2 = p1.e;
                        if (Float.floatToIntBits(dVar2.d(t, d2)) != Float.floatToIntBits(dVar2.d(t2, d2))) {
                            break;
                        } else {
                            continue;
                        }
                    }
                case 2:
                    if (a(t, i2) == a(t2, i2) && p1.f(t, d2) == p1.f(t2, d2)) {
                        continue;
                    }
                case 3:
                    if (a(t, i2) == a(t2, i2) && p1.f(t, d2) == p1.f(t2, d2)) {
                        continue;
                    }
                case 4:
                    if (a(t, i2) == a(t2, i2) && p1.e(t, d2) == p1.e(t2, d2)) {
                        continue;
                    }
                case 5:
                    if (a(t, i2) == a(t2, i2) && p1.f(t, d2) == p1.f(t2, d2)) {
                        continue;
                    }
                case 6:
                    if (a(t, i2) == a(t2, i2) && p1.e(t, d2) == p1.e(t2, d2)) {
                        continue;
                    }
                case 7:
                    if (a(t, i2) != a(t2, i2)) {
                        break;
                    } else {
                        p1.d dVar3 = p1.e;
                        if (dVar3.a(t, d2) != dVar3.a(t2, d2)) {
                            break;
                        } else {
                            continue;
                        }
                    }
                case 8:
                    if (a(t, i2) == a(t2, i2) && f1.a(p1.g(t, d2), p1.g(t2, d2))) {
                        continue;
                    }
                case 9:
                    if (a(t, i2) == a(t2, i2) && f1.a(p1.g(t, d2), p1.g(t2, d2))) {
                        continue;
                    }
                case 10:
                    if (a(t, i2) == a(t2, i2) && f1.a(p1.g(t, d2), p1.g(t2, d2))) {
                        continue;
                    }
                case 11:
                    if (a(t, i2) == a(t2, i2) && p1.e(t, d2) == p1.e(t2, d2)) {
                        continue;
                    }
                case 12:
                    if (a(t, i2) == a(t2, i2) && p1.e(t, d2) == p1.e(t2, d2)) {
                        continue;
                    }
                case 13:
                    if (a(t, i2) == a(t2, i2) && p1.e(t, d2) == p1.e(t2, d2)) {
                        continue;
                    }
                case 14:
                    if (a(t, i2) == a(t2, i2) && p1.f(t, d2) == p1.f(t2, d2)) {
                        continue;
                    }
                case 15:
                    if (a(t, i2) == a(t2, i2) && p1.e(t, d2) == p1.e(t2, d2)) {
                        continue;
                    }
                case 16:
                    if (a(t, i2) == a(t2, i2) && p1.f(t, d2) == p1.f(t2, d2)) {
                        continue;
                    }
                case 17:
                    if (a(t, i2) == a(t2, i2) && f1.a(p1.g(t, d2), p1.g(t2, d2))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z = f1.a(p1.g(t, d2), p1.g(t2, d2));
                    break;
                case 50:
                    z = f1.a(p1.g(t, d2), p1.g(t2, d2));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long j2 = (long) (this.a[i2 + 2] & 1048575);
                    if (p1.e(t, j2) == p1.e(t2, j2) && f1.a(p1.g(t, d2), p1.g(t2, d2))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.o.b(t).equals(this.o.b(t2))) {
            return false;
        }
        if (this.f) {
            return this.p.a((Object) t).equals(this.p.a((Object) t2));
        }
        return true;
    }

    public final d1 c(int i2) {
        int i3 = (i2 / 3) * 2;
        Object[] objArr = this.b;
        d1 d1Var = (d1) objArr[i3];
        if (d1Var != null) {
            return d1Var;
        }
        d1 a2 = z0.c.a((Class) objArr[i3 + 1]);
        this.b[i3] = a2;
        return a2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c1, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x022b, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x022c, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int d(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.a
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x0230
            int r3 = r8.g(r1)
            int[] r4 = r8.a
            r4 = r4[r1]
            long r5 = d((int) r3)
            int r3 = f(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x021b;
                case 1: goto L_0x020e;
                case 2: goto L_0x0203;
                case 3: goto L_0x01f8;
                case 4: goto L_0x01f1;
                case 5: goto L_0x01e6;
                case 6: goto L_0x01df;
                case 7: goto L_0x01d2;
                case 8: goto L_0x01c5;
                case 9: goto L_0x01b7;
                case 10: goto L_0x01ab;
                case 11: goto L_0x01a3;
                case 12: goto L_0x019b;
                case 13: goto L_0x0193;
                case 14: goto L_0x0187;
                case 15: goto L_0x017f;
                case 16: goto L_0x0173;
                case 17: goto L_0x0168;
                case 18: goto L_0x015c;
                case 19: goto L_0x015c;
                case 20: goto L_0x015c;
                case 21: goto L_0x015c;
                case 22: goto L_0x015c;
                case 23: goto L_0x015c;
                case 24: goto L_0x015c;
                case 25: goto L_0x015c;
                case 26: goto L_0x015c;
                case 27: goto L_0x015c;
                case 28: goto L_0x015c;
                case 29: goto L_0x015c;
                case 30: goto L_0x015c;
                case 31: goto L_0x015c;
                case 32: goto L_0x015c;
                case 33: goto L_0x015c;
                case 34: goto L_0x015c;
                case 35: goto L_0x015c;
                case 36: goto L_0x015c;
                case 37: goto L_0x015c;
                case 38: goto L_0x015c;
                case 39: goto L_0x015c;
                case 40: goto L_0x015c;
                case 41: goto L_0x015c;
                case 42: goto L_0x015c;
                case 43: goto L_0x015c;
                case 44: goto L_0x015c;
                case 45: goto L_0x015c;
                case 46: goto L_0x015c;
                case 47: goto L_0x015c;
                case 48: goto L_0x015c;
                case 49: goto L_0x015c;
                case 50: goto L_0x0150;
                case 51: goto L_0x013a;
                case 52: goto L_0x0128;
                case 53: goto L_0x0116;
                case 54: goto L_0x0104;
                case 55: goto L_0x00f6;
                case 56: goto L_0x00e4;
                case 57: goto L_0x00d6;
                case 58: goto L_0x00c4;
                case 59: goto L_0x00b0;
                case 60: goto L_0x009e;
                case 61: goto L_0x008c;
                case 62: goto L_0x007e;
                case 63: goto L_0x0070;
                case 64: goto L_0x0062;
                case 65: goto L_0x0050;
                case 66: goto L_0x0042;
                case 67: goto L_0x0030;
                case 68: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x022c
        L_0x001e:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            java.lang.Object r3 = com.fyber.inneractive.sdk.protobuf.p1.g(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x022b
        L_0x0030:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.fyber.inneractive.sdk.protobuf.y.a((long) r3)
            goto L_0x022b
        L_0x0042:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x022b
        L_0x0050:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.fyber.inneractive.sdk.protobuf.y.a((long) r3)
            goto L_0x022b
        L_0x0062:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x022b
        L_0x0070:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x022b
        L_0x007e:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x022b
        L_0x008c:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            int r2 = r2 * 53
            java.lang.Object r3 = com.fyber.inneractive.sdk.protobuf.p1.g(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x022b
        L_0x009e:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            java.lang.Object r3 = com.fyber.inneractive.sdk.protobuf.p1.g(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x022b
        L_0x00b0:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            int r2 = r2 * 53
            java.lang.Object r3 = com.fyber.inneractive.sdk.protobuf.p1.g(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x022b
        L_0x00c4:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            int r2 = r2 * 53
            boolean r3 = a(r9, (long) r5)
            int r3 = com.fyber.inneractive.sdk.protobuf.y.a((boolean) r3)
            goto L_0x022b
        L_0x00d6:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x022b
        L_0x00e4:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.fyber.inneractive.sdk.protobuf.y.a((long) r3)
            goto L_0x022b
        L_0x00f6:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x022b
        L_0x0104:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.fyber.inneractive.sdk.protobuf.y.a((long) r3)
            goto L_0x022b
        L_0x0116:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.fyber.inneractive.sdk.protobuf.y.a((long) r3)
            goto L_0x022b
        L_0x0128:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            int r2 = r2 * 53
            float r3 = c(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x022b
        L_0x013a:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x022c
            int r2 = r2 * 53
            double r3 = b(r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.fyber.inneractive.sdk.protobuf.y.a((long) r3)
            goto L_0x022b
        L_0x0150:
            int r2 = r2 * 53
            java.lang.Object r3 = com.fyber.inneractive.sdk.protobuf.p1.g(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x022b
        L_0x015c:
            int r2 = r2 * 53
            java.lang.Object r3 = com.fyber.inneractive.sdk.protobuf.p1.g(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x022b
        L_0x0168:
            java.lang.Object r3 = com.fyber.inneractive.sdk.protobuf.p1.g(r9, r5)
            if (r3 == 0) goto L_0x01c1
            int r7 = r3.hashCode()
            goto L_0x01c1
        L_0x0173:
            int r2 = r2 * 53
            long r3 = com.fyber.inneractive.sdk.protobuf.p1.f(r9, r5)
            int r3 = com.fyber.inneractive.sdk.protobuf.y.a((long) r3)
            goto L_0x022b
        L_0x017f:
            int r2 = r2 * 53
            int r3 = com.fyber.inneractive.sdk.protobuf.p1.e(r9, r5)
            goto L_0x022b
        L_0x0187:
            int r2 = r2 * 53
            long r3 = com.fyber.inneractive.sdk.protobuf.p1.f(r9, r5)
            int r3 = com.fyber.inneractive.sdk.protobuf.y.a((long) r3)
            goto L_0x022b
        L_0x0193:
            int r2 = r2 * 53
            int r3 = com.fyber.inneractive.sdk.protobuf.p1.e(r9, r5)
            goto L_0x022b
        L_0x019b:
            int r2 = r2 * 53
            int r3 = com.fyber.inneractive.sdk.protobuf.p1.e(r9, r5)
            goto L_0x022b
        L_0x01a3:
            int r2 = r2 * 53
            int r3 = com.fyber.inneractive.sdk.protobuf.p1.e(r9, r5)
            goto L_0x022b
        L_0x01ab:
            int r2 = r2 * 53
            java.lang.Object r3 = com.fyber.inneractive.sdk.protobuf.p1.g(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x022b
        L_0x01b7:
            java.lang.Object r3 = com.fyber.inneractive.sdk.protobuf.p1.g(r9, r5)
            if (r3 == 0) goto L_0x01c1
            int r7 = r3.hashCode()
        L_0x01c1:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x022c
        L_0x01c5:
            int r2 = r2 * 53
            java.lang.Object r3 = com.fyber.inneractive.sdk.protobuf.p1.g(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x022b
        L_0x01d2:
            int r2 = r2 * 53
            com.fyber.inneractive.sdk.protobuf.p1$d r3 = com.fyber.inneractive.sdk.protobuf.p1.e
            boolean r3 = r3.a(r9, r5)
            int r3 = com.fyber.inneractive.sdk.protobuf.y.a((boolean) r3)
            goto L_0x022b
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.fyber.inneractive.sdk.protobuf.p1.e(r9, r5)
            goto L_0x022b
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.fyber.inneractive.sdk.protobuf.p1.f(r9, r5)
            int r3 = com.fyber.inneractive.sdk.protobuf.y.a((long) r3)
            goto L_0x022b
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.fyber.inneractive.sdk.protobuf.p1.e(r9, r5)
            goto L_0x022b
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.fyber.inneractive.sdk.protobuf.p1.f(r9, r5)
            int r3 = com.fyber.inneractive.sdk.protobuf.y.a((long) r3)
            goto L_0x022b
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.fyber.inneractive.sdk.protobuf.p1.f(r9, r5)
            int r3 = com.fyber.inneractive.sdk.protobuf.y.a((long) r3)
            goto L_0x022b
        L_0x020e:
            int r2 = r2 * 53
            com.fyber.inneractive.sdk.protobuf.p1$d r3 = com.fyber.inneractive.sdk.protobuf.p1.e
            float r3 = r3.d(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x022b
        L_0x021b:
            int r2 = r2 * 53
            com.fyber.inneractive.sdk.protobuf.p1$d r3 = com.fyber.inneractive.sdk.protobuf.p1.e
            double r3 = r3.c(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.fyber.inneractive.sdk.protobuf.y.a((long) r3)
        L_0x022b:
            int r2 = r2 + r3
        L_0x022c:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x0230:
            int r2 = r2 * 53
            com.fyber.inneractive.sdk.protobuf.k1<?, ?> r0 = r8.o
            java.lang.Object r0 = r0.b(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.f
            if (r0 == 0) goto L_0x0250
            int r2 = r2 * 53
            com.fyber.inneractive.sdk.protobuf.r<?> r0 = r8.p
            com.fyber.inneractive.sdk.protobuf.u r9 = r0.a((java.lang.Object) r9)
            com.fyber.inneractive.sdk.protobuf.g1<T, java.lang.Object> r9 = r9.a
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x0250:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.r0.d(java.lang.Object):int");
    }

    public final int g(int i2) {
        return this.a[i2 + 1];
    }

    public static <T> long e(T t, long j2) {
        return ((Long) p1.g(t, j2)).longValue();
    }

    public void c(T t) {
        int i2;
        int i3 = this.k;
        while (true) {
            i2 = this.l;
            if (i3 >= i2) {
                break;
            }
            long d2 = d(g(this.j[i3]));
            Object g2 = p1.g(t, d2);
            if (g2 != null) {
                p1.a((Object) t, d2, this.q.e(g2));
            }
            i3++;
        }
        int length = this.j.length;
        while (i2 < length) {
            this.n.a(t, (long) this.j[i2]);
            i2++;
        }
        this.o.e(t);
        if (this.f) {
            this.p.c(t);
        }
    }

    public final int e(int i2) {
        if (i2 < this.c || i2 > this.d) {
            return -1;
        }
        return a(i2, 0);
    }

    static {
        Unsafe unsafe;
        Unsafe unsafe2 = p1.a;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new o1());
        } catch (Throwable unused) {
            unsafe = null;
        }
        s = unsafe;
    }

    public static <T> float c(T t, long j2) {
        return ((Float) p1.g(t, j2)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0328, code lost:
        r4 = r4 + (r5 + r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0513, code lost:
        r4 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0515, code lost:
        r11 = r11 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x068f, code lost:
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:315:0x06bf, code lost:
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x06c2, code lost:
        r11 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x06e6, code lost:
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x0879, code lost:
        r3 = (r3 + r7) + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:412:0x08f8, code lost:
        r11 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:423:0x0966, code lost:
        r11 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:477:0x0a70, code lost:
        r11 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:484:0x0a90, code lost:
        r5 = r5 + r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:486:0x0a94, code lost:
        r4 = r4 + 3;
        r11 = r13;
        r6 = 1048575;
        r7 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int b(T r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r0.h
            r3 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            r7 = 1
            r8 = 0
            r10 = 0
            if (r2 == 0) goto L_0x0526
            sun.misc.Unsafe r2 = s
            r11 = 0
            r12 = 0
        L_0x0014:
            int[] r13 = r0.a
            int r13 = r13.length
            if (r11 >= r13) goto L_0x0519
            int r13 = r0.g(r11)
            int r14 = f(r13)
            int[] r15 = r0.a
            r15 = r15[r11]
            long r4 = d((int) r13)
            com.fyber.inneractive.sdk.protobuf.FieldType r13 = com.fyber.inneractive.sdk.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r13 = r13.id()
            if (r14 < r13) goto L_0x0041
            com.fyber.inneractive.sdk.protobuf.FieldType r13 = com.fyber.inneractive.sdk.protobuf.FieldType.SINT64_LIST_PACKED
            int r13 = r13.id()
            if (r14 > r13) goto L_0x0041
            int[] r13 = r0.a
            int r16 = r11 + 2
            r13 = r13[r16]
            r13 = r13 & r6
            goto L_0x0042
        L_0x0041:
            r13 = 0
        L_0x0042:
            switch(r14) {
                case 0: goto L_0x0507;
                case 1: goto L_0x04fc;
                case 2: goto L_0x04ed;
                case 3: goto L_0x04de;
                case 4: goto L_0x04cf;
                case 5: goto L_0x04c4;
                case 6: goto L_0x04b9;
                case 7: goto L_0x04ae;
                case 8: goto L_0x0490;
                case 9: goto L_0x047c;
                case 10: goto L_0x046a;
                case 11: goto L_0x045a;
                case 12: goto L_0x044a;
                case 13: goto L_0x043e;
                case 14: goto L_0x0432;
                case 15: goto L_0x0422;
                case 16: goto L_0x0412;
                case 17: goto L_0x03fc;
                case 18: goto L_0x03f0;
                case 19: goto L_0x03e4;
                case 20: goto L_0x03d8;
                case 21: goto L_0x03cc;
                case 22: goto L_0x03c0;
                case 23: goto L_0x03b4;
                case 24: goto L_0x03a8;
                case 25: goto L_0x039c;
                case 26: goto L_0x0390;
                case 27: goto L_0x0380;
                case 28: goto L_0x0374;
                case 29: goto L_0x0368;
                case 30: goto L_0x035c;
                case 31: goto L_0x0350;
                case 32: goto L_0x0344;
                case 33: goto L_0x0338;
                case 34: goto L_0x032c;
                case 35: goto L_0x030c;
                case 36: goto L_0x02ef;
                case 37: goto L_0x02d2;
                case 38: goto L_0x02b5;
                case 39: goto L_0x0297;
                case 40: goto L_0x0279;
                case 41: goto L_0x025b;
                case 42: goto L_0x023b;
                case 43: goto L_0x021d;
                case 44: goto L_0x01ff;
                case 45: goto L_0x01e1;
                case 46: goto L_0x01c3;
                case 47: goto L_0x01a5;
                case 48: goto L_0x0187;
                case 49: goto L_0x0177;
                case 50: goto L_0x0167;
                case 51: goto L_0x0159;
                case 52: goto L_0x014d;
                case 53: goto L_0x013d;
                case 54: goto L_0x012d;
                case 55: goto L_0x011d;
                case 56: goto L_0x0111;
                case 57: goto L_0x0105;
                case 58: goto L_0x00f9;
                case 59: goto L_0x00db;
                case 60: goto L_0x00c7;
                case 61: goto L_0x00b5;
                case 62: goto L_0x00a5;
                case 63: goto L_0x0095;
                case 64: goto L_0x0089;
                case 65: goto L_0x007d;
                case 66: goto L_0x006d;
                case 67: goto L_0x005d;
                case 68: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x0515
        L_0x0047:
            boolean r13 = r0.a(r1, (int) r15, (int) r11)
            if (r13 == 0) goto L_0x0515
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            com.fyber.inneractive.sdk.protobuf.o0 r4 = (com.fyber.inneractive.sdk.protobuf.o0) r4
            com.fyber.inneractive.sdk.protobuf.d1 r5 = r0.c((int) r11)
            int r4 = com.fyber.inneractive.sdk.protobuf.l.a(r15, r4, r5)
            goto L_0x0514
        L_0x005d:
            boolean r13 = r0.a(r1, (int) r15, (int) r11)
            if (r13 == 0) goto L_0x0515
            long r4 = e(r1, r4)
            int r4 = com.fyber.inneractive.sdk.protobuf.l.d((int) r15, (long) r4)
            goto L_0x0514
        L_0x006d:
            boolean r13 = r0.a(r1, (int) r15, (int) r11)
            if (r13 == 0) goto L_0x0515
            int r4 = d(r1, r4)
            int r4 = com.fyber.inneractive.sdk.protobuf.l.e((int) r15, (int) r4)
            goto L_0x0514
        L_0x007d:
            boolean r4 = r0.a(r1, (int) r15, (int) r11)
            if (r4 == 0) goto L_0x0515
            int r4 = com.fyber.inneractive.sdk.protobuf.l.c((int) r15, (long) r8)
            goto L_0x0514
        L_0x0089:
            boolean r4 = r0.a(r1, (int) r15, (int) r11)
            if (r4 == 0) goto L_0x0515
            int r4 = com.fyber.inneractive.sdk.protobuf.l.d((int) r15, (int) r10)
            goto L_0x0514
        L_0x0095:
            boolean r13 = r0.a(r1, (int) r15, (int) r11)
            if (r13 == 0) goto L_0x0515
            int r4 = d(r1, r4)
            int r4 = com.fyber.inneractive.sdk.protobuf.l.a((int) r15, (int) r4)
            goto L_0x0514
        L_0x00a5:
            boolean r13 = r0.a(r1, (int) r15, (int) r11)
            if (r13 == 0) goto L_0x0515
            int r4 = d(r1, r4)
            int r4 = com.fyber.inneractive.sdk.protobuf.l.f((int) r15, (int) r4)
            goto L_0x0514
        L_0x00b5:
            boolean r13 = r0.a(r1, (int) r15, (int) r11)
            if (r13 == 0) goto L_0x0515
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            com.fyber.inneractive.sdk.protobuf.i r4 = (com.fyber.inneractive.sdk.protobuf.i) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.l.a((int) r15, (com.fyber.inneractive.sdk.protobuf.i) r4)
            goto L_0x0514
        L_0x00c7:
            boolean r13 = r0.a(r1, (int) r15, (int) r11)
            if (r13 == 0) goto L_0x0515
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            com.fyber.inneractive.sdk.protobuf.d1 r5 = r0.c((int) r11)
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.a((int) r15, (java.lang.Object) r4, (com.fyber.inneractive.sdk.protobuf.d1) r5)
            goto L_0x0514
        L_0x00db:
            boolean r13 = r0.a(r1, (int) r15, (int) r11)
            if (r13 == 0) goto L_0x0515
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            boolean r5 = r4 instanceof com.fyber.inneractive.sdk.protobuf.i
            if (r5 == 0) goto L_0x00f1
            com.fyber.inneractive.sdk.protobuf.i r4 = (com.fyber.inneractive.sdk.protobuf.i) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.l.a((int) r15, (com.fyber.inneractive.sdk.protobuf.i) r4)
            goto L_0x0514
        L_0x00f1:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.l.a((int) r15, (java.lang.String) r4)
            goto L_0x0514
        L_0x00f9:
            boolean r4 = r0.a(r1, (int) r15, (int) r11)
            if (r4 == 0) goto L_0x0515
            int r4 = com.fyber.inneractive.sdk.protobuf.l.a((int) r15, (boolean) r7)
            goto L_0x0514
        L_0x0105:
            boolean r4 = r0.a(r1, (int) r15, (int) r11)
            if (r4 == 0) goto L_0x0515
            int r4 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15, (int) r10)
            goto L_0x0514
        L_0x0111:
            boolean r4 = r0.a(r1, (int) r15, (int) r11)
            if (r4 == 0) goto L_0x0515
            int r4 = com.fyber.inneractive.sdk.protobuf.l.a((int) r15, (long) r8)
            goto L_0x0514
        L_0x011d:
            boolean r13 = r0.a(r1, (int) r15, (int) r11)
            if (r13 == 0) goto L_0x0515
            int r4 = d(r1, r4)
            int r4 = com.fyber.inneractive.sdk.protobuf.l.c((int) r15, (int) r4)
            goto L_0x0514
        L_0x012d:
            boolean r13 = r0.a(r1, (int) r15, (int) r11)
            if (r13 == 0) goto L_0x0515
            long r4 = e(r1, r4)
            int r4 = com.fyber.inneractive.sdk.protobuf.l.e((int) r15, (long) r4)
            goto L_0x0514
        L_0x013d:
            boolean r13 = r0.a(r1, (int) r15, (int) r11)
            if (r13 == 0) goto L_0x0515
            long r4 = e(r1, r4)
            int r4 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15, (long) r4)
            goto L_0x0514
        L_0x014d:
            boolean r4 = r0.a(r1, (int) r15, (int) r11)
            if (r4 == 0) goto L_0x0515
            int r4 = com.fyber.inneractive.sdk.protobuf.l.a((int) r15, (float) r3)
            goto L_0x0514
        L_0x0159:
            boolean r4 = r0.a(r1, (int) r15, (int) r11)
            if (r4 == 0) goto L_0x0515
            r4 = 0
            int r13 = com.fyber.inneractive.sdk.protobuf.l.a((int) r15, (double) r4)
            goto L_0x0513
        L_0x0167:
            com.fyber.inneractive.sdk.protobuf.j0 r13 = r0.q
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.lang.Object r5 = r0.b((int) r11)
            int r4 = r13.a(r15, r4, r5)
            goto L_0x0514
        L_0x0177:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.d1 r5 = r0.c((int) r11)
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.a((int) r15, (java.util.List<com.fyber.inneractive.sdk.protobuf.o0>) r4, (com.fyber.inneractive.sdk.protobuf.d1) r5)
            goto L_0x0514
        L_0x0187:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.g(r4)
            if (r4 <= 0) goto L_0x0515
            boolean r5 = r0.i
            if (r5 == 0) goto L_0x019b
            long r13 = (long) r13
            r2.putInt(r1, r13, r4)
        L_0x019b:
            int r5 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15)
            int r13 = com.fyber.inneractive.sdk.protobuf.l.c((int) r4)
            goto L_0x0328
        L_0x01a5:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.f(r4)
            if (r4 <= 0) goto L_0x0515
            boolean r5 = r0.i
            if (r5 == 0) goto L_0x01b9
            long r13 = (long) r13
            r2.putInt(r1, r13, r4)
        L_0x01b9:
            int r5 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15)
            int r13 = com.fyber.inneractive.sdk.protobuf.l.c((int) r4)
            goto L_0x0328
        L_0x01c3:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.c(r4)
            if (r4 <= 0) goto L_0x0515
            boolean r5 = r0.i
            if (r5 == 0) goto L_0x01d7
            long r13 = (long) r13
            r2.putInt(r1, r13, r4)
        L_0x01d7:
            int r5 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15)
            int r13 = com.fyber.inneractive.sdk.protobuf.l.c((int) r4)
            goto L_0x0328
        L_0x01e1:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.b(r4)
            if (r4 <= 0) goto L_0x0515
            boolean r5 = r0.i
            if (r5 == 0) goto L_0x01f5
            long r13 = (long) r13
            r2.putInt(r1, r13, r4)
        L_0x01f5:
            int r5 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15)
            int r13 = com.fyber.inneractive.sdk.protobuf.l.c((int) r4)
            goto L_0x0328
        L_0x01ff:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.a((java.util.List<java.lang.Integer>) r4)
            if (r4 <= 0) goto L_0x0515
            boolean r5 = r0.i
            if (r5 == 0) goto L_0x0213
            long r13 = (long) r13
            r2.putInt(r1, r13, r4)
        L_0x0213:
            int r5 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15)
            int r13 = com.fyber.inneractive.sdk.protobuf.l.c((int) r4)
            goto L_0x0328
        L_0x021d:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.h(r4)
            if (r4 <= 0) goto L_0x0515
            boolean r5 = r0.i
            if (r5 == 0) goto L_0x0231
            long r13 = (long) r13
            r2.putInt(r1, r13, r4)
        L_0x0231:
            int r5 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15)
            int r13 = com.fyber.inneractive.sdk.protobuf.l.c((int) r4)
            goto L_0x0328
        L_0x023b:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            java.lang.Class<?> r5 = com.fyber.inneractive.sdk.protobuf.f1.a
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x0515
            boolean r5 = r0.i
            if (r5 == 0) goto L_0x0251
            long r13 = (long) r13
            r2.putInt(r1, r13, r4)
        L_0x0251:
            int r5 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15)
            int r13 = com.fyber.inneractive.sdk.protobuf.l.c((int) r4)
            goto L_0x0328
        L_0x025b:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.b(r4)
            if (r4 <= 0) goto L_0x0515
            boolean r5 = r0.i
            if (r5 == 0) goto L_0x026f
            long r13 = (long) r13
            r2.putInt(r1, r13, r4)
        L_0x026f:
            int r5 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15)
            int r13 = com.fyber.inneractive.sdk.protobuf.l.c((int) r4)
            goto L_0x0328
        L_0x0279:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.c(r4)
            if (r4 <= 0) goto L_0x0515
            boolean r5 = r0.i
            if (r5 == 0) goto L_0x028d
            long r13 = (long) r13
            r2.putInt(r1, r13, r4)
        L_0x028d:
            int r5 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15)
            int r13 = com.fyber.inneractive.sdk.protobuf.l.c((int) r4)
            goto L_0x0328
        L_0x0297:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.d(r4)
            if (r4 <= 0) goto L_0x0515
            boolean r5 = r0.i
            if (r5 == 0) goto L_0x02ab
            long r13 = (long) r13
            r2.putInt(r1, r13, r4)
        L_0x02ab:
            int r5 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15)
            int r13 = com.fyber.inneractive.sdk.protobuf.l.c((int) r4)
            goto L_0x0328
        L_0x02b5:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.i(r4)
            if (r4 <= 0) goto L_0x0515
            boolean r5 = r0.i
            if (r5 == 0) goto L_0x02c9
            long r13 = (long) r13
            r2.putInt(r1, r13, r4)
        L_0x02c9:
            int r5 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15)
            int r13 = com.fyber.inneractive.sdk.protobuf.l.c((int) r4)
            goto L_0x0328
        L_0x02d2:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.e(r4)
            if (r4 <= 0) goto L_0x0515
            boolean r5 = r0.i
            if (r5 == 0) goto L_0x02e6
            long r13 = (long) r13
            r2.putInt(r1, r13, r4)
        L_0x02e6:
            int r5 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15)
            int r13 = com.fyber.inneractive.sdk.protobuf.l.c((int) r4)
            goto L_0x0328
        L_0x02ef:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.b(r4)
            if (r4 <= 0) goto L_0x0515
            boolean r5 = r0.i
            if (r5 == 0) goto L_0x0303
            long r13 = (long) r13
            r2.putInt(r1, r13, r4)
        L_0x0303:
            int r5 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15)
            int r13 = com.fyber.inneractive.sdk.protobuf.l.c((int) r4)
            goto L_0x0328
        L_0x030c:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.c(r4)
            if (r4 <= 0) goto L_0x0515
            boolean r5 = r0.i
            if (r5 == 0) goto L_0x0320
            long r13 = (long) r13
            r2.putInt(r1, r13, r4)
        L_0x0320:
            int r5 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15)
            int r13 = com.fyber.inneractive.sdk.protobuf.l.c((int) r4)
        L_0x0328:
            int r5 = r5 + r13
            int r4 = r4 + r5
            goto L_0x0514
        L_0x032c:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.h(r15, r4, r10)
            goto L_0x0514
        L_0x0338:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.g(r15, r4, r10)
            goto L_0x0514
        L_0x0344:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.d(r15, r4, r10)
            goto L_0x0514
        L_0x0350:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.c(r15, r4, r10)
            goto L_0x0514
        L_0x035c:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.b((int) r15, (java.util.List<java.lang.Integer>) r4, (boolean) r10)
            goto L_0x0514
        L_0x0368:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.i(r15, r4, r10)
            goto L_0x0514
        L_0x0374:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.a((int) r15, (java.util.List<com.fyber.inneractive.sdk.protobuf.i>) r4)
            goto L_0x0514
        L_0x0380:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.d1 r5 = r0.c((int) r11)
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.b((int) r15, (java.util.List<?>) r4, (com.fyber.inneractive.sdk.protobuf.d1) r5)
            goto L_0x0514
        L_0x0390:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.b(r15, r4)
            goto L_0x0514
        L_0x039c:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.a((int) r15, (java.util.List<?>) r4, (boolean) r10)
            goto L_0x0514
        L_0x03a8:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.c(r15, r4, r10)
            goto L_0x0514
        L_0x03b4:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.d(r15, r4, r10)
            goto L_0x0514
        L_0x03c0:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.e(r15, r4, r10)
            goto L_0x0514
        L_0x03cc:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.j(r15, r4, r10)
            goto L_0x0514
        L_0x03d8:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.f(r15, r4, r10)
            goto L_0x0514
        L_0x03e4:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.c(r15, r4, r10)
            goto L_0x0514
        L_0x03f0:
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.d(r15, r4, r10)
            goto L_0x0514
        L_0x03fc:
            boolean r13 = r0.a(r1, (int) r11)
            if (r13 == 0) goto L_0x0515
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            com.fyber.inneractive.sdk.protobuf.o0 r4 = (com.fyber.inneractive.sdk.protobuf.o0) r4
            com.fyber.inneractive.sdk.protobuf.d1 r5 = r0.c((int) r11)
            int r4 = com.fyber.inneractive.sdk.protobuf.l.a(r15, r4, r5)
            goto L_0x0514
        L_0x0412:
            boolean r13 = r0.a(r1, (int) r11)
            if (r13 == 0) goto L_0x0515
            long r4 = com.fyber.inneractive.sdk.protobuf.p1.f(r1, r4)
            int r4 = com.fyber.inneractive.sdk.protobuf.l.d((int) r15, (long) r4)
            goto L_0x0514
        L_0x0422:
            boolean r13 = r0.a(r1, (int) r11)
            if (r13 == 0) goto L_0x0515
            int r4 = com.fyber.inneractive.sdk.protobuf.p1.e(r1, r4)
            int r4 = com.fyber.inneractive.sdk.protobuf.l.e((int) r15, (int) r4)
            goto L_0x0514
        L_0x0432:
            boolean r4 = r0.a(r1, (int) r11)
            if (r4 == 0) goto L_0x0515
            int r4 = com.fyber.inneractive.sdk.protobuf.l.c((int) r15, (long) r8)
            goto L_0x0514
        L_0x043e:
            boolean r4 = r0.a(r1, (int) r11)
            if (r4 == 0) goto L_0x0515
            int r4 = com.fyber.inneractive.sdk.protobuf.l.d((int) r15, (int) r10)
            goto L_0x0514
        L_0x044a:
            boolean r13 = r0.a(r1, (int) r11)
            if (r13 == 0) goto L_0x0515
            int r4 = com.fyber.inneractive.sdk.protobuf.p1.e(r1, r4)
            int r4 = com.fyber.inneractive.sdk.protobuf.l.a((int) r15, (int) r4)
            goto L_0x0514
        L_0x045a:
            boolean r13 = r0.a(r1, (int) r11)
            if (r13 == 0) goto L_0x0515
            int r4 = com.fyber.inneractive.sdk.protobuf.p1.e(r1, r4)
            int r4 = com.fyber.inneractive.sdk.protobuf.l.f((int) r15, (int) r4)
            goto L_0x0514
        L_0x046a:
            boolean r13 = r0.a(r1, (int) r11)
            if (r13 == 0) goto L_0x0515
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            com.fyber.inneractive.sdk.protobuf.i r4 = (com.fyber.inneractive.sdk.protobuf.i) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.l.a((int) r15, (com.fyber.inneractive.sdk.protobuf.i) r4)
            goto L_0x0514
        L_0x047c:
            boolean r13 = r0.a(r1, (int) r11)
            if (r13 == 0) goto L_0x0515
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            com.fyber.inneractive.sdk.protobuf.d1 r5 = r0.c((int) r11)
            int r4 = com.fyber.inneractive.sdk.protobuf.f1.a((int) r15, (java.lang.Object) r4, (com.fyber.inneractive.sdk.protobuf.d1) r5)
            goto L_0x0514
        L_0x0490:
            boolean r13 = r0.a(r1, (int) r11)
            if (r13 == 0) goto L_0x0515
            java.lang.Object r4 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r4)
            boolean r5 = r4 instanceof com.fyber.inneractive.sdk.protobuf.i
            if (r5 == 0) goto L_0x04a6
            com.fyber.inneractive.sdk.protobuf.i r4 = (com.fyber.inneractive.sdk.protobuf.i) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.l.a((int) r15, (com.fyber.inneractive.sdk.protobuf.i) r4)
            goto L_0x0514
        L_0x04a6:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.fyber.inneractive.sdk.protobuf.l.a((int) r15, (java.lang.String) r4)
            goto L_0x0514
        L_0x04ae:
            boolean r4 = r0.a(r1, (int) r11)
            if (r4 == 0) goto L_0x0515
            int r4 = com.fyber.inneractive.sdk.protobuf.l.a((int) r15, (boolean) r7)
            goto L_0x0514
        L_0x04b9:
            boolean r4 = r0.a(r1, (int) r11)
            if (r4 == 0) goto L_0x0515
            int r4 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15, (int) r10)
            goto L_0x0514
        L_0x04c4:
            boolean r4 = r0.a(r1, (int) r11)
            if (r4 == 0) goto L_0x0515
            int r4 = com.fyber.inneractive.sdk.protobuf.l.a((int) r15, (long) r8)
            goto L_0x0514
        L_0x04cf:
            boolean r13 = r0.a(r1, (int) r11)
            if (r13 == 0) goto L_0x0515
            int r4 = com.fyber.inneractive.sdk.protobuf.p1.e(r1, r4)
            int r4 = com.fyber.inneractive.sdk.protobuf.l.c((int) r15, (int) r4)
            goto L_0x0514
        L_0x04de:
            boolean r13 = r0.a(r1, (int) r11)
            if (r13 == 0) goto L_0x0515
            long r4 = com.fyber.inneractive.sdk.protobuf.p1.f(r1, r4)
            int r4 = com.fyber.inneractive.sdk.protobuf.l.e((int) r15, (long) r4)
            goto L_0x0514
        L_0x04ed:
            boolean r13 = r0.a(r1, (int) r11)
            if (r13 == 0) goto L_0x0515
            long r4 = com.fyber.inneractive.sdk.protobuf.p1.f(r1, r4)
            int r4 = com.fyber.inneractive.sdk.protobuf.l.b((int) r15, (long) r4)
            goto L_0x0514
        L_0x04fc:
            boolean r4 = r0.a(r1, (int) r11)
            if (r4 == 0) goto L_0x0515
            int r4 = com.fyber.inneractive.sdk.protobuf.l.a((int) r15, (float) r3)
            goto L_0x0514
        L_0x0507:
            boolean r4 = r0.a(r1, (int) r11)
            if (r4 == 0) goto L_0x0515
            r4 = 0
            int r13 = com.fyber.inneractive.sdk.protobuf.l.a((int) r15, (double) r4)
        L_0x0513:
            r4 = r13
        L_0x0514:
            int r12 = r12 + r4
        L_0x0515:
            int r11 = r11 + 3
            goto L_0x0014
        L_0x0519:
            com.fyber.inneractive.sdk.protobuf.k1<?, ?> r2 = r0.o
            java.lang.Object r1 = r2.b(r1)
            int r1 = r2.c(r1)
        L_0x0523:
            int r12 = r12 + r1
            goto L_0x0aba
        L_0x0526:
            sun.misc.Unsafe r2 = s
            r4 = 0
            r5 = 0
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x052e:
            int[] r13 = r0.a
            int r13 = r13.length
            if (r4 >= r13) goto L_0x0a9e
            int r13 = r0.g(r4)
            int[] r14 = r0.a
            r14 = r14[r4]
            int r15 = f(r13)
            r3 = 17
            if (r15 > r3) goto L_0x0558
            int[] r3 = r0.a
            int r17 = r4 + 2
            r3 = r3[r17]
            r10 = r3 & r6
            int r18 = r3 >>> 20
            int r18 = r7 << r18
            if (r10 == r11) goto L_0x0577
            long r11 = (long) r10
            int r12 = r2.getInt(r1, r11)
            r11 = r10
            goto L_0x0577
        L_0x0558:
            boolean r3 = r0.i
            if (r3 == 0) goto L_0x0574
            com.fyber.inneractive.sdk.protobuf.FieldType r3 = com.fyber.inneractive.sdk.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r3 = r3.id()
            if (r15 < r3) goto L_0x0574
            com.fyber.inneractive.sdk.protobuf.FieldType r3 = com.fyber.inneractive.sdk.protobuf.FieldType.SINT64_LIST_PACKED
            int r3 = r3.id()
            if (r15 > r3) goto L_0x0574
            int[] r3 = r0.a
            int r10 = r4 + 2
            r3 = r3[r10]
            r3 = r3 & r6
            goto L_0x0575
        L_0x0574:
            r3 = 0
        L_0x0575:
            r18 = 0
        L_0x0577:
            long r6 = d((int) r13)
            switch(r15) {
                case 0: goto L_0x0a82;
                case 1: goto L_0x0a73;
                case 2: goto L_0x0a61;
                case 3: goto L_0x0a51;
                case 4: goto L_0x0a41;
                case 5: goto L_0x0a35;
                case 6: goto L_0x0a29;
                case 7: goto L_0x0a16;
                case 8: goto L_0x09f9;
                case 9: goto L_0x09e6;
                case 10: goto L_0x09d5;
                case 11: goto L_0x09c6;
                case 12: goto L_0x09b7;
                case 13: goto L_0x09aa;
                case 14: goto L_0x099f;
                case 15: goto L_0x0990;
                case 16: goto L_0x0981;
                case 17: goto L_0x096c;
                case 18: goto L_0x095a;
                case 19: goto L_0x094d;
                case 20: goto L_0x0940;
                case 21: goto L_0x0933;
                case 22: goto L_0x0926;
                case 23: goto L_0x0919;
                case 24: goto L_0x090c;
                case 25: goto L_0x08ff;
                case 26: goto L_0x08ed;
                case 27: goto L_0x08dd;
                case 28: goto L_0x08d1;
                case 29: goto L_0x08c3;
                case 30: goto L_0x08b5;
                case 31: goto L_0x08a7;
                case 32: goto L_0x0899;
                case 33: goto L_0x088b;
                case 34: goto L_0x087d;
                case 35: goto L_0x085c;
                case 36: goto L_0x083e;
                case 37: goto L_0x0820;
                case 38: goto L_0x0802;
                case 39: goto L_0x07e3;
                case 40: goto L_0x07c4;
                case 41: goto L_0x07a5;
                case 42: goto L_0x0784;
                case 43: goto L_0x0765;
                case 44: goto L_0x0746;
                case 45: goto L_0x0727;
                case 46: goto L_0x0708;
                case 47: goto L_0x06e9;
                case 48: goto L_0x06c7;
                case 49: goto L_0x06b1;
                case 50: goto L_0x06a2;
                case 51: goto L_0x0694;
                case 52: goto L_0x0684;
                case 53: goto L_0x0675;
                case 54: goto L_0x0666;
                case 55: goto L_0x0657;
                case 56: goto L_0x064c;
                case 57: goto L_0x0640;
                case 58: goto L_0x0633;
                case 59: goto L_0x0615;
                case 60: goto L_0x0601;
                case 61: goto L_0x05ef;
                case 62: goto L_0x05df;
                case 63: goto L_0x05cf;
                case 64: goto L_0x05c2;
                case 65: goto L_0x05b6;
                case 66: goto L_0x05a6;
                case 67: goto L_0x0596;
                case 68: goto L_0x0580;
                default: goto L_0x057e;
            }
        L_0x057e:
            goto L_0x06e6
        L_0x0580:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            java.lang.Object r3 = r2.getObject(r1, r6)
            com.fyber.inneractive.sdk.protobuf.o0 r3 = (com.fyber.inneractive.sdk.protobuf.o0) r3
            com.fyber.inneractive.sdk.protobuf.d1 r6 = r0.c((int) r4)
            int r3 = com.fyber.inneractive.sdk.protobuf.l.a(r14, r3, r6)
            goto L_0x06bf
        L_0x0596:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            long r6 = e(r1, r6)
            int r3 = com.fyber.inneractive.sdk.protobuf.l.d((int) r14, (long) r6)
            goto L_0x06bf
        L_0x05a6:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            int r3 = d(r1, r6)
            int r3 = com.fyber.inneractive.sdk.protobuf.l.e((int) r14, (int) r3)
            goto L_0x06bf
        L_0x05b6:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            int r3 = com.fyber.inneractive.sdk.protobuf.l.c((int) r14, (long) r8)
            goto L_0x06bf
        L_0x05c2:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            r3 = 0
            int r6 = com.fyber.inneractive.sdk.protobuf.l.d((int) r14, (int) r3)
            goto L_0x068f
        L_0x05cf:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            int r3 = d(r1, r6)
            int r3 = com.fyber.inneractive.sdk.protobuf.l.a((int) r14, (int) r3)
            goto L_0x06bf
        L_0x05df:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            int r3 = d(r1, r6)
            int r3 = com.fyber.inneractive.sdk.protobuf.l.f((int) r14, (int) r3)
            goto L_0x06bf
        L_0x05ef:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            java.lang.Object r3 = r2.getObject(r1, r6)
            com.fyber.inneractive.sdk.protobuf.i r3 = (com.fyber.inneractive.sdk.protobuf.i) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.l.a((int) r14, (com.fyber.inneractive.sdk.protobuf.i) r3)
            goto L_0x06bf
        L_0x0601:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            java.lang.Object r3 = r2.getObject(r1, r6)
            com.fyber.inneractive.sdk.protobuf.d1 r6 = r0.c((int) r4)
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.a((int) r14, (java.lang.Object) r3, (com.fyber.inneractive.sdk.protobuf.d1) r6)
            goto L_0x06bf
        L_0x0615:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            java.lang.Object r3 = r2.getObject(r1, r6)
            boolean r6 = r3 instanceof com.fyber.inneractive.sdk.protobuf.i
            if (r6 == 0) goto L_0x062b
            com.fyber.inneractive.sdk.protobuf.i r3 = (com.fyber.inneractive.sdk.protobuf.i) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.l.a((int) r14, (com.fyber.inneractive.sdk.protobuf.i) r3)
            goto L_0x06bf
        L_0x062b:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.l.a((int) r14, (java.lang.String) r3)
            goto L_0x06bf
        L_0x0633:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            r3 = 1
            int r6 = com.fyber.inneractive.sdk.protobuf.l.a((int) r14, (boolean) r3)
            r13 = r11
            goto L_0x0691
        L_0x0640:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            r3 = 0
            int r6 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14, (int) r3)
            goto L_0x068f
        L_0x064c:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            int r3 = com.fyber.inneractive.sdk.protobuf.l.a((int) r14, (long) r8)
            goto L_0x06bf
        L_0x0657:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            int r3 = d(r1, r6)
            int r3 = com.fyber.inneractive.sdk.protobuf.l.c((int) r14, (int) r3)
            goto L_0x06bf
        L_0x0666:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            long r6 = e(r1, r6)
            int r3 = com.fyber.inneractive.sdk.protobuf.l.e((int) r14, (long) r6)
            goto L_0x06bf
        L_0x0675:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            long r6 = e(r1, r6)
            int r3 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14, (long) r6)
            goto L_0x06bf
        L_0x0684:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            r3 = 0
            int r6 = com.fyber.inneractive.sdk.protobuf.l.a((int) r14, (float) r3)
        L_0x068f:
            r13 = r11
            r3 = 1
        L_0x0691:
            r10 = 0
            goto L_0x0a70
        L_0x0694:
            boolean r3 = r0.a(r1, (int) r14, (int) r4)
            if (r3 == 0) goto L_0x06e6
            r6 = 0
            int r3 = com.fyber.inneractive.sdk.protobuf.l.a((int) r14, (double) r6)
            r13 = r11
            goto L_0x06c2
        L_0x06a2:
            com.fyber.inneractive.sdk.protobuf.j0 r3 = r0.q
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.lang.Object r7 = r0.b((int) r4)
            int r3 = r3.a(r14, r6, r7)
            goto L_0x06bf
        L_0x06b1:
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            com.fyber.inneractive.sdk.protobuf.d1 r6 = r0.c((int) r4)
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.a((int) r14, (java.util.List<com.fyber.inneractive.sdk.protobuf.o0>) r3, (com.fyber.inneractive.sdk.protobuf.d1) r6)
        L_0x06bf:
            r13 = r11
            r6 = 0
        L_0x06c2:
            r10 = 0
            r11 = r3
            r3 = 1
            goto L_0x0a90
        L_0x06c7:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.fyber.inneractive.sdk.protobuf.f1.g(r6)
            if (r6 <= 0) goto L_0x06e6
            boolean r7 = r0.i
            r13 = r11
            if (r7 == 0) goto L_0x06dc
            long r10 = (long) r3
            r2.putInt(r1, r10, r6)
        L_0x06dc:
            int r3 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14)
            int r7 = com.fyber.inneractive.sdk.protobuf.l.c((int) r6)
            goto L_0x0879
        L_0x06e6:
            r13 = r11
            goto L_0x0a23
        L_0x06e9:
            r13 = r11
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.fyber.inneractive.sdk.protobuf.f1.f(r6)
            if (r6 <= 0) goto L_0x0a23
            boolean r7 = r0.i
            if (r7 == 0) goto L_0x06fe
            long r10 = (long) r3
            r2.putInt(r1, r10, r6)
        L_0x06fe:
            int r3 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14)
            int r7 = com.fyber.inneractive.sdk.protobuf.l.c((int) r6)
            goto L_0x0879
        L_0x0708:
            r13 = r11
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.fyber.inneractive.sdk.protobuf.f1.c(r6)
            if (r6 <= 0) goto L_0x0a23
            boolean r7 = r0.i
            if (r7 == 0) goto L_0x071d
            long r10 = (long) r3
            r2.putInt(r1, r10, r6)
        L_0x071d:
            int r3 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14)
            int r7 = com.fyber.inneractive.sdk.protobuf.l.c((int) r6)
            goto L_0x0879
        L_0x0727:
            r13 = r11
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.fyber.inneractive.sdk.protobuf.f1.b(r6)
            if (r6 <= 0) goto L_0x0a23
            boolean r7 = r0.i
            if (r7 == 0) goto L_0x073c
            long r10 = (long) r3
            r2.putInt(r1, r10, r6)
        L_0x073c:
            int r3 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14)
            int r7 = com.fyber.inneractive.sdk.protobuf.l.c((int) r6)
            goto L_0x0879
        L_0x0746:
            r13 = r11
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.fyber.inneractive.sdk.protobuf.f1.a((java.util.List<java.lang.Integer>) r6)
            if (r6 <= 0) goto L_0x0a23
            boolean r7 = r0.i
            if (r7 == 0) goto L_0x075b
            long r10 = (long) r3
            r2.putInt(r1, r10, r6)
        L_0x075b:
            int r3 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14)
            int r7 = com.fyber.inneractive.sdk.protobuf.l.c((int) r6)
            goto L_0x0879
        L_0x0765:
            r13 = r11
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.fyber.inneractive.sdk.protobuf.f1.h(r6)
            if (r6 <= 0) goto L_0x0a23
            boolean r7 = r0.i
            if (r7 == 0) goto L_0x077a
            long r10 = (long) r3
            r2.putInt(r1, r10, r6)
        L_0x077a:
            int r3 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14)
            int r7 = com.fyber.inneractive.sdk.protobuf.l.c((int) r6)
            goto L_0x0879
        L_0x0784:
            r13 = r11
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            java.lang.Class<?> r7 = com.fyber.inneractive.sdk.protobuf.f1.a
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x0a23
            boolean r7 = r0.i
            if (r7 == 0) goto L_0x079b
            long r10 = (long) r3
            r2.putInt(r1, r10, r6)
        L_0x079b:
            int r3 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14)
            int r7 = com.fyber.inneractive.sdk.protobuf.l.c((int) r6)
            goto L_0x0879
        L_0x07a5:
            r13 = r11
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.fyber.inneractive.sdk.protobuf.f1.b(r6)
            if (r6 <= 0) goto L_0x0a23
            boolean r7 = r0.i
            if (r7 == 0) goto L_0x07ba
            long r10 = (long) r3
            r2.putInt(r1, r10, r6)
        L_0x07ba:
            int r3 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14)
            int r7 = com.fyber.inneractive.sdk.protobuf.l.c((int) r6)
            goto L_0x0879
        L_0x07c4:
            r13 = r11
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.fyber.inneractive.sdk.protobuf.f1.c(r6)
            if (r6 <= 0) goto L_0x0a23
            boolean r7 = r0.i
            if (r7 == 0) goto L_0x07d9
            long r10 = (long) r3
            r2.putInt(r1, r10, r6)
        L_0x07d9:
            int r3 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14)
            int r7 = com.fyber.inneractive.sdk.protobuf.l.c((int) r6)
            goto L_0x0879
        L_0x07e3:
            r13 = r11
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.fyber.inneractive.sdk.protobuf.f1.d(r6)
            if (r6 <= 0) goto L_0x0a23
            boolean r7 = r0.i
            if (r7 == 0) goto L_0x07f8
            long r10 = (long) r3
            r2.putInt(r1, r10, r6)
        L_0x07f8:
            int r3 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14)
            int r7 = com.fyber.inneractive.sdk.protobuf.l.c((int) r6)
            goto L_0x0879
        L_0x0802:
            r13 = r11
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.fyber.inneractive.sdk.protobuf.f1.i(r6)
            if (r6 <= 0) goto L_0x0a23
            boolean r7 = r0.i
            if (r7 == 0) goto L_0x0817
            long r10 = (long) r3
            r2.putInt(r1, r10, r6)
        L_0x0817:
            int r3 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14)
            int r7 = com.fyber.inneractive.sdk.protobuf.l.c((int) r6)
            goto L_0x0879
        L_0x0820:
            r13 = r11
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.fyber.inneractive.sdk.protobuf.f1.e(r6)
            if (r6 <= 0) goto L_0x0a23
            boolean r7 = r0.i
            if (r7 == 0) goto L_0x0835
            long r10 = (long) r3
            r2.putInt(r1, r10, r6)
        L_0x0835:
            int r3 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14)
            int r7 = com.fyber.inneractive.sdk.protobuf.l.c((int) r6)
            goto L_0x0879
        L_0x083e:
            r13 = r11
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.fyber.inneractive.sdk.protobuf.f1.b(r6)
            if (r6 <= 0) goto L_0x0a23
            boolean r7 = r0.i
            if (r7 == 0) goto L_0x0853
            long r10 = (long) r3
            r2.putInt(r1, r10, r6)
        L_0x0853:
            int r3 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14)
            int r7 = com.fyber.inneractive.sdk.protobuf.l.c((int) r6)
            goto L_0x0879
        L_0x085c:
            r13 = r11
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.fyber.inneractive.sdk.protobuf.f1.c(r6)
            if (r6 <= 0) goto L_0x0a23
            boolean r7 = r0.i
            if (r7 == 0) goto L_0x0871
            long r10 = (long) r3
            r2.putInt(r1, r10, r6)
        L_0x0871:
            int r3 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14)
            int r7 = com.fyber.inneractive.sdk.protobuf.l.c((int) r6)
        L_0x0879:
            int r3 = r3 + r7
            int r3 = r3 + r6
            goto L_0x08f8
        L_0x087d:
            r13 = r11
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            r10 = 0
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.h(r14, r3, r10)
            goto L_0x0966
        L_0x088b:
            r13 = r11
            r10 = 0
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.g(r14, r3, r10)
            goto L_0x0966
        L_0x0899:
            r13 = r11
            r10 = 0
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.d(r14, r3, r10)
            goto L_0x0966
        L_0x08a7:
            r13 = r11
            r10 = 0
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.c(r14, r3, r10)
            goto L_0x0966
        L_0x08b5:
            r13 = r11
            r10 = 0
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.b((int) r14, (java.util.List<java.lang.Integer>) r3, (boolean) r10)
            goto L_0x0966
        L_0x08c3:
            r13 = r11
            r10 = 0
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.i(r14, r3, r10)
            goto L_0x0966
        L_0x08d1:
            r13 = r11
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.a((int) r14, (java.util.List<com.fyber.inneractive.sdk.protobuf.i>) r3)
            goto L_0x08f8
        L_0x08dd:
            r13 = r11
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            com.fyber.inneractive.sdk.protobuf.d1 r6 = r0.c((int) r4)
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.b((int) r14, (java.util.List<?>) r3, (com.fyber.inneractive.sdk.protobuf.d1) r6)
            goto L_0x08f8
        L_0x08ed:
            r13 = r11
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.b(r14, r3)
        L_0x08f8:
            r11 = r3
        L_0x08f9:
            r3 = 1
        L_0x08fa:
            r6 = 0
            r10 = 0
            goto L_0x0a90
        L_0x08ff:
            r13 = r11
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            r10 = 0
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.a((int) r14, (java.util.List<?>) r3, (boolean) r10)
            goto L_0x0966
        L_0x090c:
            r13 = r11
            r10 = 0
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.c(r14, r3, r10)
            goto L_0x0966
        L_0x0919:
            r13 = r11
            r10 = 0
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.d(r14, r3, r10)
            goto L_0x0966
        L_0x0926:
            r13 = r11
            r10 = 0
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.e(r14, r3, r10)
            goto L_0x0966
        L_0x0933:
            r13 = r11
            r10 = 0
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.j(r14, r3, r10)
            goto L_0x0966
        L_0x0940:
            r13 = r11
            r10 = 0
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.f(r14, r3, r10)
            goto L_0x0966
        L_0x094d:
            r13 = r11
            r10 = 0
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.c(r14, r3, r10)
            goto L_0x0966
        L_0x095a:
            r13 = r11
            r10 = 0
            java.lang.Object r3 = r2.getObject(r1, r6)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.d(r14, r3, r10)
        L_0x0966:
            r11 = r3
            r3 = 1
        L_0x0968:
            r6 = 0
            goto L_0x0a90
        L_0x096c:
            r13 = r11
            r3 = r12 & r18
            if (r3 == 0) goto L_0x0a23
            java.lang.Object r3 = r2.getObject(r1, r6)
            com.fyber.inneractive.sdk.protobuf.o0 r3 = (com.fyber.inneractive.sdk.protobuf.o0) r3
            com.fyber.inneractive.sdk.protobuf.d1 r6 = r0.c((int) r4)
            int r3 = com.fyber.inneractive.sdk.protobuf.l.a(r14, r3, r6)
            goto L_0x08f8
        L_0x0981:
            r13 = r11
            r3 = r12 & r18
            if (r3 == 0) goto L_0x0a23
            long r6 = r2.getLong(r1, r6)
            int r3 = com.fyber.inneractive.sdk.protobuf.l.d((int) r14, (long) r6)
            goto L_0x08f8
        L_0x0990:
            r13 = r11
            r3 = r12 & r18
            if (r3 == 0) goto L_0x0a23
            int r3 = r2.getInt(r1, r6)
            int r3 = com.fyber.inneractive.sdk.protobuf.l.e((int) r14, (int) r3)
            goto L_0x08f8
        L_0x099f:
            r13 = r11
            r3 = r12 & r18
            if (r3 == 0) goto L_0x0a23
            int r3 = com.fyber.inneractive.sdk.protobuf.l.c((int) r14, (long) r8)
            goto L_0x08f8
        L_0x09aa:
            r13 = r11
            r3 = r12 & r18
            if (r3 == 0) goto L_0x0a23
            r3 = 0
            int r6 = com.fyber.inneractive.sdk.protobuf.l.d((int) r14, (int) r3)
            r11 = r6
            goto L_0x08f9
        L_0x09b7:
            r13 = r11
            r3 = r12 & r18
            if (r3 == 0) goto L_0x0a23
            int r3 = r2.getInt(r1, r6)
            int r3 = com.fyber.inneractive.sdk.protobuf.l.a((int) r14, (int) r3)
            goto L_0x08f8
        L_0x09c6:
            r13 = r11
            r3 = r12 & r18
            if (r3 == 0) goto L_0x0a23
            int r3 = r2.getInt(r1, r6)
            int r3 = com.fyber.inneractive.sdk.protobuf.l.f((int) r14, (int) r3)
            goto L_0x08f8
        L_0x09d5:
            r13 = r11
            r3 = r12 & r18
            if (r3 == 0) goto L_0x0a23
            java.lang.Object r3 = r2.getObject(r1, r6)
            com.fyber.inneractive.sdk.protobuf.i r3 = (com.fyber.inneractive.sdk.protobuf.i) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.l.a((int) r14, (com.fyber.inneractive.sdk.protobuf.i) r3)
            goto L_0x08f8
        L_0x09e6:
            r13 = r11
            r3 = r12 & r18
            if (r3 == 0) goto L_0x0a23
            java.lang.Object r3 = r2.getObject(r1, r6)
            com.fyber.inneractive.sdk.protobuf.d1 r6 = r0.c((int) r4)
            int r3 = com.fyber.inneractive.sdk.protobuf.f1.a((int) r14, (java.lang.Object) r3, (com.fyber.inneractive.sdk.protobuf.d1) r6)
            goto L_0x08f8
        L_0x09f9:
            r13 = r11
            r3 = r12 & r18
            if (r3 == 0) goto L_0x0a23
            java.lang.Object r3 = r2.getObject(r1, r6)
            boolean r6 = r3 instanceof com.fyber.inneractive.sdk.protobuf.i
            if (r6 == 0) goto L_0x0a0e
            com.fyber.inneractive.sdk.protobuf.i r3 = (com.fyber.inneractive.sdk.protobuf.i) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.l.a((int) r14, (com.fyber.inneractive.sdk.protobuf.i) r3)
            goto L_0x08f8
        L_0x0a0e:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.fyber.inneractive.sdk.protobuf.l.a((int) r14, (java.lang.String) r3)
            goto L_0x08f8
        L_0x0a16:
            r13 = r11
            r3 = r12 & r18
            if (r3 == 0) goto L_0x0a23
            r3 = 1
            int r6 = com.fyber.inneractive.sdk.protobuf.l.a((int) r14, (boolean) r3)
            r11 = r6
            goto L_0x08fa
        L_0x0a23:
            r3 = 1
            r6 = 0
            r10 = 0
            goto L_0x0a94
        L_0x0a29:
            r13 = r11
            r3 = 1
            r6 = r12 & r18
            r10 = 0
            if (r6 == 0) goto L_0x0a92
            int r6 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14, (int) r10)
            goto L_0x0a70
        L_0x0a35:
            r13 = r11
            r3 = 1
            r10 = 0
            r6 = r12 & r18
            if (r6 == 0) goto L_0x0a92
            int r6 = com.fyber.inneractive.sdk.protobuf.l.a((int) r14, (long) r8)
            goto L_0x0a70
        L_0x0a41:
            r13 = r11
            r3 = 1
            r10 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a92
            int r6 = r2.getInt(r1, r6)
            int r6 = com.fyber.inneractive.sdk.protobuf.l.c((int) r14, (int) r6)
            goto L_0x0a70
        L_0x0a51:
            r13 = r11
            r3 = 1
            r10 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a92
            long r6 = r2.getLong(r1, r6)
            int r6 = com.fyber.inneractive.sdk.protobuf.l.e((int) r14, (long) r6)
            goto L_0x0a70
        L_0x0a61:
            r13 = r11
            r3 = 1
            r10 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a92
            long r6 = r2.getLong(r1, r6)
            int r6 = com.fyber.inneractive.sdk.protobuf.l.b((int) r14, (long) r6)
        L_0x0a70:
            r11 = r6
            goto L_0x0968
        L_0x0a73:
            r13 = r11
            r3 = 1
            r10 = 0
            r6 = r12 & r18
            if (r6 == 0) goto L_0x0a92
            r6 = 0
            int r7 = com.fyber.inneractive.sdk.protobuf.l.a((int) r14, (float) r6)
            r11 = r7
            goto L_0x0968
        L_0x0a82:
            r13 = r11
            r3 = 1
            r6 = 0
            r10 = 0
            r7 = r12 & r18
            if (r7 == 0) goto L_0x0a92
            r6 = 0
            int r11 = com.fyber.inneractive.sdk.protobuf.l.a((int) r14, (double) r6)
        L_0x0a90:
            int r5 = r5 + r11
            goto L_0x0a94
        L_0x0a92:
            r6 = 0
        L_0x0a94:
            int r4 = r4 + 3
            r11 = r13
            r3 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            r7 = 1
            goto L_0x052e
        L_0x0a9e:
            com.fyber.inneractive.sdk.protobuf.k1<?, ?> r2 = r0.o
            java.lang.Object r3 = r2.b(r1)
            int r2 = r2.c(r3)
            int r12 = r5 + r2
            boolean r2 = r0.f
            if (r2 == 0) goto L_0x0aba
            com.fyber.inneractive.sdk.protobuf.r<?> r2 = r0.p
            com.fyber.inneractive.sdk.protobuf.u r1 = r2.a((java.lang.Object) r1)
            int r1 = r1.d()
            goto L_0x0523
        L_0x0aba:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.r0.b(java.lang.Object):int");
    }

    public static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public T a() {
        return this.m.a(this.e);
    }

    public void a(T t, T t2) {
        t2.getClass();
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i2 < iArr.length) {
                int i3 = iArr[i2 + 1];
                long d2 = d(i3);
                int i4 = this.a[i2];
                switch (f(i3)) {
                    case 0:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            p1.d dVar = p1.e;
                            dVar.a((Object) t, d2, dVar.c(t2, d2));
                            b(t, i2);
                            break;
                        }
                    case 1:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            p1.d dVar2 = p1.e;
                            dVar2.a((Object) t, d2, dVar2.d(t2, d2));
                            b(t, i2);
                            break;
                        }
                    case 2:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            p1.a((Object) t, d2, p1.f(t2, d2));
                            b(t, i2);
                            break;
                        }
                    case 3:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            p1.a((Object) t, d2, p1.f(t2, d2));
                            b(t, i2);
                            break;
                        }
                    case 4:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            p1.a((Object) t, d2, p1.e(t2, d2));
                            b(t, i2);
                            break;
                        }
                    case 5:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            p1.a((Object) t, d2, p1.f(t2, d2));
                            b(t, i2);
                            break;
                        }
                    case 6:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            p1.a((Object) t, d2, p1.e(t2, d2));
                            b(t, i2);
                            break;
                        }
                    case 7:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            p1.d dVar3 = p1.e;
                            dVar3.a((Object) t, d2, dVar3.a(t2, d2));
                            b(t, i2);
                            break;
                        }
                    case 8:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            p1.a((Object) t, d2, p1.g(t2, d2));
                            b(t, i2);
                            break;
                        }
                    case 9:
                        a(t, t2, i2);
                        break;
                    case 10:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            p1.a((Object) t, d2, p1.g(t2, d2));
                            b(t, i2);
                            break;
                        }
                    case 11:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            p1.a((Object) t, d2, p1.e(t2, d2));
                            b(t, i2);
                            break;
                        }
                    case 12:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            p1.a((Object) t, d2, p1.e(t2, d2));
                            b(t, i2);
                            break;
                        }
                    case 13:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            p1.a((Object) t, d2, p1.e(t2, d2));
                            b(t, i2);
                            break;
                        }
                    case 14:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            p1.a((Object) t, d2, p1.f(t2, d2));
                            b(t, i2);
                            break;
                        }
                    case 15:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            p1.a((Object) t, d2, p1.e(t2, d2));
                            b(t, i2);
                            break;
                        }
                    case 16:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            p1.a((Object) t, d2, p1.f(t2, d2));
                            b(t, i2);
                            break;
                        }
                    case 17:
                        a(t, t2, i2);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.n.a(t, t2, d2);
                        break;
                    case 50:
                        j0 j0Var = this.q;
                        Class<?> cls = f1.a;
                        p1.a((Object) t, d2, j0Var.a(p1.g(t, d2), p1.g(t2, d2)));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!a(t2, i4, i2)) {
                            break;
                        } else {
                            p1.a((Object) t, d2, p1.g(t2, d2));
                            b(t, i4, i2);
                            break;
                        }
                    case 60:
                        b(t, t2, i2);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!a(t2, i4, i2)) {
                            break;
                        } else {
                            p1.a((Object) t, d2, p1.g(t2, d2));
                            b(t, i4, i2);
                            break;
                        }
                    case 68:
                        b(t, t2, i2);
                        break;
                }
                i2 += 3;
            } else {
                k1<?, ?> k1Var = this.o;
                Class<?> cls2 = f1.a;
                k1Var.c(t, k1Var.a(k1Var.b(t), k1Var.b(t2)));
                if (this.f) {
                    r<?> rVar = this.p;
                    u<?> a2 = rVar.a((Object) t2);
                    if (!a2.a.isEmpty()) {
                        rVar.b(t).a(a2);
                        return;
                    }
                    return;
                }
                return;
            }
        }
    }

    public static <T> int d(T t, long j2) {
        return ((Integer) p1.g(t, j2)).intValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v121, resolved type: java.util.Map$Entry} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0604  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0650  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0b15  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(T r18, com.fyber.inneractive.sdk.protobuf.s1 r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r2
            com.fyber.inneractive.sdk.protobuf.m r3 = (com.fyber.inneractive.sdk.protobuf.m) r3
            r3.getClass()
            com.fyber.inneractive.sdk.protobuf.s1$a r4 = com.fyber.inneractive.sdk.protobuf.s1.a.ASCENDING
            com.fyber.inneractive.sdk.protobuf.s1$a r5 = com.fyber.inneractive.sdk.protobuf.s1.a.DESCENDING
            r7 = 1
            r8 = 0
            if (r4 != r5) goto L_0x0619
            com.fyber.inneractive.sdk.protobuf.k1<?, ?> r4 = r0.o
            java.lang.Object r5 = r4.b(r1)
            r4.b(r5, (com.fyber.inneractive.sdk.protobuf.s1) r2)
            boolean r4 = r0.f
            if (r4 == 0) goto L_0x0066
            com.fyber.inneractive.sdk.protobuf.r<?> r4 = r0.p
            com.fyber.inneractive.sdk.protobuf.u r4 = r4.a((java.lang.Object) r1)
            com.fyber.inneractive.sdk.protobuf.g1<T, java.lang.Object> r5 = r4.a
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0066
            boolean r5 = r4.c
            if (r5 == 0) goto L_0x004c
            com.fyber.inneractive.sdk.protobuf.a0$b r5 = new com.fyber.inneractive.sdk.protobuf.a0$b
            com.fyber.inneractive.sdk.protobuf.g1<T, java.lang.Object> r4 = r4.a
            com.fyber.inneractive.sdk.protobuf.g1<K, V>$c r9 = r4.g
            if (r9 != 0) goto L_0x0042
            com.fyber.inneractive.sdk.protobuf.g1$c r9 = new com.fyber.inneractive.sdk.protobuf.g1$c
            r9.<init>()
            r4.g = r9
        L_0x0042:
            com.fyber.inneractive.sdk.protobuf.g1<K, V>$c r4 = r4.g
            java.util.Iterator r4 = r4.iterator()
            r5.<init>(r4)
            goto L_0x005f
        L_0x004c:
            com.fyber.inneractive.sdk.protobuf.g1<T, java.lang.Object> r4 = r4.a
            com.fyber.inneractive.sdk.protobuf.g1<K, V>$c r5 = r4.g
            if (r5 != 0) goto L_0x0059
            com.fyber.inneractive.sdk.protobuf.g1$c r5 = new com.fyber.inneractive.sdk.protobuf.g1$c
            r5.<init>()
            r4.g = r5
        L_0x0059:
            com.fyber.inneractive.sdk.protobuf.g1<K, V>$c r4 = r4.g
            java.util.Iterator r5 = r4.iterator()
        L_0x005f:
            java.lang.Object r4 = r5.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            goto L_0x0068
        L_0x0066:
            r4 = 0
            r5 = 0
        L_0x0068:
            int[] r9 = r0.a
            int r9 = r9.length
            int r9 = r9 + -3
        L_0x006d:
            if (r9 < 0) goto L_0x0602
            int r10 = r0.g(r9)
            int[] r11 = r0.a
            r11 = r11[r9]
        L_0x0077:
            if (r4 == 0) goto L_0x0095
            com.fyber.inneractive.sdk.protobuf.r<?> r12 = r0.p
            int r12 = r12.a((java.util.Map.Entry<?, ?>) r4)
            if (r12 <= r11) goto L_0x0095
            com.fyber.inneractive.sdk.protobuf.r<?> r12 = r0.p
            r12.a(r2, r4)
            boolean r4 = r5.hasNext()
            if (r4 == 0) goto L_0x0093
            java.lang.Object r4 = r5.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            goto L_0x0077
        L_0x0093:
            r4 = 0
            goto L_0x0077
        L_0x0095:
            int r12 = f(r10)
            switch(r12) {
                case 0: goto L_0x05eb;
                case 1: goto L_0x05d7;
                case 2: goto L_0x05c3;
                case 3: goto L_0x05af;
                case 4: goto L_0x059b;
                case 5: goto L_0x0587;
                case 6: goto L_0x0572;
                case 7: goto L_0x055b;
                case 8: goto L_0x0548;
                case 9: goto L_0x0531;
                case 10: goto L_0x051a;
                case 11: goto L_0x0505;
                case 12: goto L_0x04f0;
                case 13: goto L_0x04db;
                case 14: goto L_0x04c6;
                case 15: goto L_0x04b3;
                case 16: goto L_0x04a0;
                case 17: goto L_0x0489;
                case 18: goto L_0x0476;
                case 19: goto L_0x0463;
                case 20: goto L_0x0450;
                case 21: goto L_0x043d;
                case 22: goto L_0x042a;
                case 23: goto L_0x0417;
                case 24: goto L_0x0404;
                case 25: goto L_0x03f1;
                case 26: goto L_0x03de;
                case 27: goto L_0x03c7;
                case 28: goto L_0x03b4;
                case 29: goto L_0x03a1;
                case 30: goto L_0x038e;
                case 31: goto L_0x037b;
                case 32: goto L_0x0368;
                case 33: goto L_0x0355;
                case 34: goto L_0x0342;
                case 35: goto L_0x032f;
                case 36: goto L_0x031c;
                case 37: goto L_0x0309;
                case 38: goto L_0x02f6;
                case 39: goto L_0x02e3;
                case 40: goto L_0x02d0;
                case 41: goto L_0x02bd;
                case 42: goto L_0x02aa;
                case 43: goto L_0x0297;
                case 44: goto L_0x0284;
                case 45: goto L_0x0271;
                case 46: goto L_0x025e;
                case 47: goto L_0x024b;
                case 48: goto L_0x0238;
                case 49: goto L_0x0221;
                case 50: goto L_0x0214;
                case 51: goto L_0x0201;
                case 52: goto L_0x01ee;
                case 53: goto L_0x01d9;
                case 54: goto L_0x01c4;
                case 55: goto L_0x01af;
                case 56: goto L_0x019a;
                case 57: goto L_0x0185;
                case 58: goto L_0x0170;
                case 59: goto L_0x015d;
                case 60: goto L_0x0146;
                case 61: goto L_0x012f;
                case 62: goto L_0x011a;
                case 63: goto L_0x0105;
                case 64: goto L_0x00f0;
                case 65: goto L_0x00db;
                case 66: goto L_0x00c8;
                case 67: goto L_0x00b5;
                case 68: goto L_0x009e;
                default: goto L_0x009c;
            }
        L_0x009c:
            goto L_0x05fe
        L_0x009e:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            com.fyber.inneractive.sdk.protobuf.d1 r12 = r0.c((int) r9)
            r3.a(r11, r10, r12)
            goto L_0x05fe
        L_0x00b5:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            long r12 = e(r1, r12)
            r3.a((int) r11, (long) r12)
            goto L_0x05fe
        L_0x00c8:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            int r10 = d(r1, r12)
            r3.a((int) r11, (int) r10)
            goto L_0x05fe
        L_0x00db:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            long r12 = e(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r10 = r3.a
            r10.f((int) r11, (long) r12)
            goto L_0x05fe
        L_0x00f0:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            int r10 = d(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r12 = r3.a
            r12.g((int) r11, (int) r10)
            goto L_0x05fe
        L_0x0105:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            int r10 = d(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r12 = r3.a
            r12.h(r11, r10)
            goto L_0x05fe
        L_0x011a:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            int r10 = d(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r12 = r3.a
            r12.j(r11, r10)
            goto L_0x05fe
        L_0x012f:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            com.fyber.inneractive.sdk.protobuf.i r10 = (com.fyber.inneractive.sdk.protobuf.i) r10
            com.fyber.inneractive.sdk.protobuf.l r12 = r3.a
            r12.b((int) r11, (com.fyber.inneractive.sdk.protobuf.i) r10)
            goto L_0x05fe
        L_0x0146:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            com.fyber.inneractive.sdk.protobuf.d1 r12 = r0.c((int) r9)
            r3.b(r11, r10, r12)
            goto L_0x05fe
        L_0x015d:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            r0.a((int) r11, (java.lang.Object) r10, (com.fyber.inneractive.sdk.protobuf.s1) r2)
            goto L_0x05fe
        L_0x0170:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            boolean r10 = a(r1, (long) r12)
            com.fyber.inneractive.sdk.protobuf.l r12 = r3.a
            r12.b((int) r11, (boolean) r10)
            goto L_0x05fe
        L_0x0185:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            int r10 = d(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r12 = r3.a
            r12.g((int) r11, (int) r10)
            goto L_0x05fe
        L_0x019a:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            long r12 = e(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r10 = r3.a
            r10.f((int) r11, (long) r12)
            goto L_0x05fe
        L_0x01af:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            int r10 = d(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r12 = r3.a
            r12.h(r11, r10)
            goto L_0x05fe
        L_0x01c4:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            long r12 = e(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r10 = r3.a
            r10.g((int) r11, (long) r12)
            goto L_0x05fe
        L_0x01d9:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            long r12 = e(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r10 = r3.a
            r10.g((int) r11, (long) r12)
            goto L_0x05fe
        L_0x01ee:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            float r10 = c(r1, r12)
            r3.a((int) r11, (float) r10)
            goto L_0x05fe
        L_0x0201:
            boolean r12 = r0.a(r1, (int) r11, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            double r12 = b(r1, (long) r12)
            r3.a((int) r11, (double) r12)
            goto L_0x05fe
        L_0x0214:
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            r0.a((com.fyber.inneractive.sdk.protobuf.s1) r2, (int) r11, (java.lang.Object) r10, (int) r9)
            goto L_0x05fe
        L_0x0221:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.d1 r12 = r0.c((int) r9)
            com.fyber.inneractive.sdk.protobuf.f1.a((int) r11, (java.util.List<?>) r10, (com.fyber.inneractive.sdk.protobuf.s1) r2, (com.fyber.inneractive.sdk.protobuf.d1) r12)
            goto L_0x05fe
        L_0x0238:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.l(r11, r10, r2, r7)
            goto L_0x05fe
        L_0x024b:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.k(r11, r10, r2, r7)
            goto L_0x05fe
        L_0x025e:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.j(r11, r10, r2, r7)
            goto L_0x05fe
        L_0x0271:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.i(r11, r10, r2, r7)
            goto L_0x05fe
        L_0x0284:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.c(r11, r10, r2, r7)
            goto L_0x05fe
        L_0x0297:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.m(r11, r10, r2, r7)
            goto L_0x05fe
        L_0x02aa:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.a((int) r11, (java.util.List<java.lang.Boolean>) r10, (com.fyber.inneractive.sdk.protobuf.s1) r2, (boolean) r7)
            goto L_0x05fe
        L_0x02bd:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.d(r11, r10, r2, r7)
            goto L_0x05fe
        L_0x02d0:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.e(r11, r10, r2, r7)
            goto L_0x05fe
        L_0x02e3:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.g(r11, r10, r2, r7)
            goto L_0x05fe
        L_0x02f6:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.n(r11, r10, r2, r7)
            goto L_0x05fe
        L_0x0309:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.h(r11, r10, r2, r7)
            goto L_0x05fe
        L_0x031c:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.f(r11, r10, r2, r7)
            goto L_0x05fe
        L_0x032f:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.b((int) r11, (java.util.List<java.lang.Double>) r10, (com.fyber.inneractive.sdk.protobuf.s1) r2, (boolean) r7)
            goto L_0x05fe
        L_0x0342:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.l(r11, r10, r2, r8)
            goto L_0x05fe
        L_0x0355:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.k(r11, r10, r2, r8)
            goto L_0x05fe
        L_0x0368:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.j(r11, r10, r2, r8)
            goto L_0x05fe
        L_0x037b:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.i(r11, r10, r2, r8)
            goto L_0x05fe
        L_0x038e:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.c(r11, r10, r2, r8)
            goto L_0x05fe
        L_0x03a1:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.m(r11, r10, r2, r8)
            goto L_0x05fe
        L_0x03b4:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.a((int) r11, (java.util.List<com.fyber.inneractive.sdk.protobuf.i>) r10, (com.fyber.inneractive.sdk.protobuf.s1) r2)
            goto L_0x05fe
        L_0x03c7:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.d1 r12 = r0.c((int) r9)
            com.fyber.inneractive.sdk.protobuf.f1.b((int) r11, (java.util.List<?>) r10, (com.fyber.inneractive.sdk.protobuf.s1) r2, (com.fyber.inneractive.sdk.protobuf.d1) r12)
            goto L_0x05fe
        L_0x03de:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.b((int) r11, (java.util.List<java.lang.String>) r10, (com.fyber.inneractive.sdk.protobuf.s1) r2)
            goto L_0x05fe
        L_0x03f1:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.a((int) r11, (java.util.List<java.lang.Boolean>) r10, (com.fyber.inneractive.sdk.protobuf.s1) r2, (boolean) r8)
            goto L_0x05fe
        L_0x0404:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.d(r11, r10, r2, r8)
            goto L_0x05fe
        L_0x0417:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.e(r11, r10, r2, r8)
            goto L_0x05fe
        L_0x042a:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.g(r11, r10, r2, r8)
            goto L_0x05fe
        L_0x043d:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.n(r11, r10, r2, r8)
            goto L_0x05fe
        L_0x0450:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.h(r11, r10, r2, r8)
            goto L_0x05fe
        L_0x0463:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.f(r11, r10, r2, r8)
            goto L_0x05fe
        L_0x0476:
            int[] r11 = r0.a
            r11 = r11[r9]
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            java.util.List r10 = (java.util.List) r10
            com.fyber.inneractive.sdk.protobuf.f1.b((int) r11, (java.util.List<java.lang.Double>) r10, (com.fyber.inneractive.sdk.protobuf.s1) r2, (boolean) r8)
            goto L_0x05fe
        L_0x0489:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            com.fyber.inneractive.sdk.protobuf.d1 r12 = r0.c((int) r9)
            r3.a(r11, r10, r12)
            goto L_0x05fe
        L_0x04a0:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            long r12 = com.fyber.inneractive.sdk.protobuf.p1.f(r1, r12)
            r3.a((int) r11, (long) r12)
            goto L_0x05fe
        L_0x04b3:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            int r10 = com.fyber.inneractive.sdk.protobuf.p1.e(r1, r12)
            r3.a((int) r11, (int) r10)
            goto L_0x05fe
        L_0x04c6:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            long r12 = com.fyber.inneractive.sdk.protobuf.p1.f(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r10 = r3.a
            r10.f((int) r11, (long) r12)
            goto L_0x05fe
        L_0x04db:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            int r10 = com.fyber.inneractive.sdk.protobuf.p1.e(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r12 = r3.a
            r12.g((int) r11, (int) r10)
            goto L_0x05fe
        L_0x04f0:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            int r10 = com.fyber.inneractive.sdk.protobuf.p1.e(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r12 = r3.a
            r12.h(r11, r10)
            goto L_0x05fe
        L_0x0505:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            int r10 = com.fyber.inneractive.sdk.protobuf.p1.e(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r12 = r3.a
            r12.j(r11, r10)
            goto L_0x05fe
        L_0x051a:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            com.fyber.inneractive.sdk.protobuf.i r10 = (com.fyber.inneractive.sdk.protobuf.i) r10
            com.fyber.inneractive.sdk.protobuf.l r12 = r3.a
            r12.b((int) r11, (com.fyber.inneractive.sdk.protobuf.i) r10)
            goto L_0x05fe
        L_0x0531:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            com.fyber.inneractive.sdk.protobuf.d1 r12 = r0.c((int) r9)
            r3.b(r11, r10, r12)
            goto L_0x05fe
        L_0x0548:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            java.lang.Object r10 = com.fyber.inneractive.sdk.protobuf.p1.g(r1, r12)
            r0.a((int) r11, (java.lang.Object) r10, (com.fyber.inneractive.sdk.protobuf.s1) r2)
            goto L_0x05fe
        L_0x055b:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            com.fyber.inneractive.sdk.protobuf.p1$d r10 = com.fyber.inneractive.sdk.protobuf.p1.e
            boolean r10 = r10.a(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r12 = r3.a
            r12.b((int) r11, (boolean) r10)
            goto L_0x05fe
        L_0x0572:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            int r10 = com.fyber.inneractive.sdk.protobuf.p1.e(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r12 = r3.a
            r12.g((int) r11, (int) r10)
            goto L_0x05fe
        L_0x0587:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            long r12 = com.fyber.inneractive.sdk.protobuf.p1.f(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r10 = r3.a
            r10.f((int) r11, (long) r12)
            goto L_0x05fe
        L_0x059b:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            int r10 = com.fyber.inneractive.sdk.protobuf.p1.e(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r12 = r3.a
            r12.h(r11, r10)
            goto L_0x05fe
        L_0x05af:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            long r12 = com.fyber.inneractive.sdk.protobuf.p1.f(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r10 = r3.a
            r10.g((int) r11, (long) r12)
            goto L_0x05fe
        L_0x05c3:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            long r12 = com.fyber.inneractive.sdk.protobuf.p1.f(r1, r12)
            com.fyber.inneractive.sdk.protobuf.l r10 = r3.a
            r10.g((int) r11, (long) r12)
            goto L_0x05fe
        L_0x05d7:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            com.fyber.inneractive.sdk.protobuf.p1$d r10 = com.fyber.inneractive.sdk.protobuf.p1.e
            float r10 = r10.d(r1, r12)
            r3.a((int) r11, (float) r10)
            goto L_0x05fe
        L_0x05eb:
            boolean r12 = r0.a(r1, (int) r9)
            if (r12 == 0) goto L_0x05fe
            long r12 = d((int) r10)
            com.fyber.inneractive.sdk.protobuf.p1$d r10 = com.fyber.inneractive.sdk.protobuf.p1.e
            double r12 = r10.c(r1, r12)
            r3.a((int) r11, (double) r12)
        L_0x05fe:
            int r9 = r9 + -3
            goto L_0x006d
        L_0x0602:
            if (r4 == 0) goto L_0x0b33
            com.fyber.inneractive.sdk.protobuf.r<?> r1 = r0.p
            r1.a(r2, r4)
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0617
            java.lang.Object r1 = r5.next()
            r4 = r1
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            goto L_0x0602
        L_0x0617:
            r4 = 0
            goto L_0x0602
        L_0x0619:
            boolean r4 = r0.h
            if (r4 == 0) goto L_0x0622
            r17.b(r18, (com.fyber.inneractive.sdk.protobuf.s1) r19)
            goto L_0x0b33
        L_0x0622:
            boolean r4 = r0.f
            if (r4 == 0) goto L_0x063f
            com.fyber.inneractive.sdk.protobuf.r<?> r4 = r0.p
            com.fyber.inneractive.sdk.protobuf.u r4 = r4.a((java.lang.Object) r1)
            com.fyber.inneractive.sdk.protobuf.g1<T, java.lang.Object> r5 = r4.a
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x063f
            java.util.Iterator r4 = r4.f()
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0641
        L_0x063f:
            r4 = 0
            r5 = 0
        L_0x0641:
            int[] r9 = r0.a
            int r9 = r9.length
            sun.misc.Unsafe r10 = s
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r14 = 0
        L_0x064e:
            if (r12 >= r9) goto L_0x0b10
            int r15 = r0.g(r12)
            int[] r6 = r0.a
            r6 = r6[r12]
            int r8 = f(r15)
            r7 = 17
            if (r8 > r7) goto L_0x067b
            int[] r7 = r0.a
            int r16 = r12 + 2
            r7 = r7[r16]
            r16 = r5
            r5 = r7 & r11
            if (r5 == r13) goto L_0x0672
            long r13 = (long) r5
            int r14 = r10.getInt(r1, r13)
            r13 = r5
        L_0x0672:
            int r5 = r7 >>> 20
            r7 = 1
            int r5 = r7 << r5
            r7 = r5
            r5 = r16
            goto L_0x067e
        L_0x067b:
            r16 = r5
            r7 = 0
        L_0x067e:
            if (r5 == 0) goto L_0x069f
            com.fyber.inneractive.sdk.protobuf.r<?> r11 = r0.p
            int r11 = r11.a((java.util.Map.Entry<?, ?>) r5)
            if (r11 > r6) goto L_0x069f
            com.fyber.inneractive.sdk.protobuf.r<?> r11 = r0.p
            r11.a(r2, r5)
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x069a
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x069b
        L_0x069a:
            r5 = 0
        L_0x069b:
            r11 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x067e
        L_0x069f:
            r11 = r4
            r16 = r5
            long r4 = d((int) r15)
            switch(r8) {
                case 0: goto L_0x0af6;
                case 1: goto L_0x0ae7;
                case 2: goto L_0x0ad8;
                case 3: goto L_0x0ac9;
                case 4: goto L_0x0aba;
                case 5: goto L_0x0aab;
                case 6: goto L_0x0a9c;
                case 7: goto L_0x0a8b;
                case 8: goto L_0x0a7d;
                case 9: goto L_0x0a6b;
                case 10: goto L_0x0a59;
                case 11: goto L_0x0a49;
                case 12: goto L_0x0a39;
                case 13: goto L_0x0a29;
                case 14: goto L_0x0a19;
                case 15: goto L_0x0a0b;
                case 16: goto L_0x09fd;
                case 17: goto L_0x09eb;
                case 18: goto L_0x09da;
                case 19: goto L_0x09c9;
                case 20: goto L_0x09b8;
                case 21: goto L_0x09a7;
                case 22: goto L_0x0996;
                case 23: goto L_0x0985;
                case 24: goto L_0x0974;
                case 25: goto L_0x0963;
                case 26: goto L_0x0952;
                case 27: goto L_0x093f;
                case 28: goto L_0x0930;
                case 29: goto L_0x0920;
                case 30: goto L_0x0910;
                case 31: goto L_0x0900;
                case 32: goto L_0x08f0;
                case 33: goto L_0x08e0;
                case 34: goto L_0x08cf;
                case 35: goto L_0x08bf;
                case 36: goto L_0x08af;
                case 37: goto L_0x089f;
                case 38: goto L_0x088f;
                case 39: goto L_0x087f;
                case 40: goto L_0x086f;
                case 41: goto L_0x085f;
                case 42: goto L_0x084f;
                case 43: goto L_0x083f;
                case 44: goto L_0x082f;
                case 45: goto L_0x081f;
                case 46: goto L_0x080f;
                case 47: goto L_0x07ff;
                case 48: goto L_0x07ef;
                case 49: goto L_0x07db;
                case 50: goto L_0x07d3;
                case 51: goto L_0x07c5;
                case 52: goto L_0x07b7;
                case 53: goto L_0x07a7;
                case 54: goto L_0x0797;
                case 55: goto L_0x0787;
                case 56: goto L_0x0777;
                case 57: goto L_0x0766;
                case 58: goto L_0x0755;
                case 59: goto L_0x0746;
                case 60: goto L_0x0733;
                case 61: goto L_0x0720;
                case 62: goto L_0x070f;
                case 63: goto L_0x06fe;
                case 64: goto L_0x06ed;
                case 65: goto L_0x06dc;
                case 66: goto L_0x06cd;
                case 67: goto L_0x06be;
                case 68: goto L_0x06ab;
                default: goto L_0x06a9;
            }
        L_0x06a9:
            goto L_0x07ec
        L_0x06ab:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            java.lang.Object r4 = r10.getObject(r1, r4)
            com.fyber.inneractive.sdk.protobuf.d1 r5 = r0.c((int) r12)
            r3.a(r6, r4, r5)
            goto L_0x07ec
        L_0x06be:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            long r4 = e(r1, r4)
            r3.a((int) r6, (long) r4)
            goto L_0x07ec
        L_0x06cd:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            int r4 = d(r1, r4)
            r3.a((int) r6, (int) r4)
            goto L_0x07ec
        L_0x06dc:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            long r4 = e(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r7 = r3.a
            r7.f((int) r6, (long) r4)
            goto L_0x07ec
        L_0x06ed:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            int r4 = d(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r5 = r3.a
            r5.g((int) r6, (int) r4)
            goto L_0x07ec
        L_0x06fe:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            int r4 = d(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r5 = r3.a
            r5.h(r6, r4)
            goto L_0x07ec
        L_0x070f:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            int r4 = d(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r5 = r3.a
            r5.j(r6, r4)
            goto L_0x07ec
        L_0x0720:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            java.lang.Object r4 = r10.getObject(r1, r4)
            com.fyber.inneractive.sdk.protobuf.i r4 = (com.fyber.inneractive.sdk.protobuf.i) r4
            com.fyber.inneractive.sdk.protobuf.l r5 = r3.a
            r5.b((int) r6, (com.fyber.inneractive.sdk.protobuf.i) r4)
            goto L_0x07ec
        L_0x0733:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            java.lang.Object r4 = r10.getObject(r1, r4)
            com.fyber.inneractive.sdk.protobuf.d1 r5 = r0.c((int) r12)
            r3.b(r6, r4, r5)
            goto L_0x07ec
        L_0x0746:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            java.lang.Object r4 = r10.getObject(r1, r4)
            r0.a((int) r6, (java.lang.Object) r4, (com.fyber.inneractive.sdk.protobuf.s1) r2)
            goto L_0x07ec
        L_0x0755:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            boolean r4 = a(r1, (long) r4)
            com.fyber.inneractive.sdk.protobuf.l r5 = r3.a
            r5.b((int) r6, (boolean) r4)
            goto L_0x07ec
        L_0x0766:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            int r4 = d(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r5 = r3.a
            r5.g((int) r6, (int) r4)
            goto L_0x07ec
        L_0x0777:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            long r4 = e(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r7 = r3.a
            r7.f((int) r6, (long) r4)
            goto L_0x07ec
        L_0x0787:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            int r4 = d(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r5 = r3.a
            r5.h(r6, r4)
            goto L_0x07ec
        L_0x0797:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            long r4 = e(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r7 = r3.a
            r7.g((int) r6, (long) r4)
            goto L_0x07ec
        L_0x07a7:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            long r4 = e(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r7 = r3.a
            r7.g((int) r6, (long) r4)
            goto L_0x07ec
        L_0x07b7:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            float r4 = c(r1, r4)
            r3.a((int) r6, (float) r4)
            goto L_0x07ec
        L_0x07c5:
            boolean r7 = r0.a(r1, (int) r6, (int) r12)
            if (r7 == 0) goto L_0x07ec
            double r4 = b(r1, (long) r4)
            r3.a((int) r6, (double) r4)
            goto L_0x07ec
        L_0x07d3:
            java.lang.Object r4 = r10.getObject(r1, r4)
            r0.a((com.fyber.inneractive.sdk.protobuf.s1) r2, (int) r6, (java.lang.Object) r4, (int) r12)
            goto L_0x07ec
        L_0x07db:
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.d1 r5 = r0.c((int) r12)
            com.fyber.inneractive.sdk.protobuf.f1.a((int) r6, (java.util.List<?>) r4, (com.fyber.inneractive.sdk.protobuf.s1) r2, (com.fyber.inneractive.sdk.protobuf.d1) r5)
        L_0x07ec:
            r8 = 1
            goto L_0x0960
        L_0x07ef:
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r8 = 1
            com.fyber.inneractive.sdk.protobuf.f1.l(r6, r4, r2, r8)
            goto L_0x0960
        L_0x07ff:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.k(r6, r4, r2, r8)
            goto L_0x0960
        L_0x080f:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.j(r6, r4, r2, r8)
            goto L_0x0960
        L_0x081f:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.i(r6, r4, r2, r8)
            goto L_0x0960
        L_0x082f:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.c(r6, r4, r2, r8)
            goto L_0x0960
        L_0x083f:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.m(r6, r4, r2, r8)
            goto L_0x0960
        L_0x084f:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.a((int) r6, (java.util.List<java.lang.Boolean>) r4, (com.fyber.inneractive.sdk.protobuf.s1) r2, (boolean) r8)
            goto L_0x0960
        L_0x085f:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.d(r6, r4, r2, r8)
            goto L_0x0960
        L_0x086f:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.e(r6, r4, r2, r8)
            goto L_0x0960
        L_0x087f:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.g(r6, r4, r2, r8)
            goto L_0x0960
        L_0x088f:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.n(r6, r4, r2, r8)
            goto L_0x0960
        L_0x089f:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.h(r6, r4, r2, r8)
            goto L_0x0960
        L_0x08af:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.f(r6, r4, r2, r8)
            goto L_0x0960
        L_0x08bf:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.b((int) r6, (java.util.List<java.lang.Double>) r4, (com.fyber.inneractive.sdk.protobuf.s1) r2, (boolean) r8)
            goto L_0x0960
        L_0x08cf:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r7 = 0
            com.fyber.inneractive.sdk.protobuf.f1.l(r6, r4, r2, r7)
            goto L_0x0960
        L_0x08e0:
            r7 = 0
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.k(r6, r4, r2, r7)
            goto L_0x0960
        L_0x08f0:
            r7 = 0
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.j(r6, r4, r2, r7)
            goto L_0x0960
        L_0x0900:
            r7 = 0
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.i(r6, r4, r2, r7)
            goto L_0x0960
        L_0x0910:
            r7 = 0
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.c(r6, r4, r2, r7)
            goto L_0x0960
        L_0x0920:
            r7 = 0
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.m(r6, r4, r2, r7)
            goto L_0x0960
        L_0x0930:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.a((int) r6, (java.util.List<com.fyber.inneractive.sdk.protobuf.i>) r4, (com.fyber.inneractive.sdk.protobuf.s1) r2)
            goto L_0x0960
        L_0x093f:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.d1 r5 = r0.c((int) r12)
            com.fyber.inneractive.sdk.protobuf.f1.b((int) r6, (java.util.List<?>) r4, (com.fyber.inneractive.sdk.protobuf.s1) r2, (com.fyber.inneractive.sdk.protobuf.d1) r5)
            goto L_0x0960
        L_0x0952:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.b((int) r6, (java.util.List<java.lang.String>) r4, (com.fyber.inneractive.sdk.protobuf.s1) r2)
        L_0x0960:
            r15 = 0
            goto L_0x0b04
        L_0x0963:
            r8 = 1
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r15 = 0
            com.fyber.inneractive.sdk.protobuf.f1.a((int) r6, (java.util.List<java.lang.Boolean>) r4, (com.fyber.inneractive.sdk.protobuf.s1) r2, (boolean) r15)
            goto L_0x0b04
        L_0x0974:
            r8 = 1
            r15 = 0
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.d(r6, r4, r2, r15)
            goto L_0x0b04
        L_0x0985:
            r8 = 1
            r15 = 0
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.e(r6, r4, r2, r15)
            goto L_0x0b04
        L_0x0996:
            r8 = 1
            r15 = 0
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.g(r6, r4, r2, r15)
            goto L_0x0b04
        L_0x09a7:
            r8 = 1
            r15 = 0
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.n(r6, r4, r2, r15)
            goto L_0x0b04
        L_0x09b8:
            r8 = 1
            r15 = 0
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.h(r6, r4, r2, r15)
            goto L_0x0b04
        L_0x09c9:
            r8 = 1
            r15 = 0
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.f(r6, r4, r2, r15)
            goto L_0x0b04
        L_0x09da:
            r8 = 1
            r15 = 0
            int[] r6 = r0.a
            r6 = r6[r12]
            java.lang.Object r4 = r10.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.fyber.inneractive.sdk.protobuf.f1.b((int) r6, (java.util.List<java.lang.Double>) r4, (com.fyber.inneractive.sdk.protobuf.s1) r2, (boolean) r15)
            goto L_0x0b04
        L_0x09eb:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            java.lang.Object r4 = r10.getObject(r1, r4)
            com.fyber.inneractive.sdk.protobuf.d1 r5 = r0.c((int) r12)
            r3.a(r6, r4, r5)
            goto L_0x0b04
        L_0x09fd:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            long r4 = r10.getLong(r1, r4)
            r3.a((int) r6, (long) r4)
            goto L_0x0b04
        L_0x0a0b:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            int r4 = r10.getInt(r1, r4)
            r3.a((int) r6, (int) r4)
            goto L_0x0b04
        L_0x0a19:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            long r4 = r10.getLong(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r7 = r3.a
            r7.f((int) r6, (long) r4)
            goto L_0x0b04
        L_0x0a29:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            int r4 = r10.getInt(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r5 = r3.a
            r5.g((int) r6, (int) r4)
            goto L_0x0b04
        L_0x0a39:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            int r4 = r10.getInt(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r5 = r3.a
            r5.h(r6, r4)
            goto L_0x0b04
        L_0x0a49:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            int r4 = r10.getInt(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r5 = r3.a
            r5.j(r6, r4)
            goto L_0x0b04
        L_0x0a59:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            java.lang.Object r4 = r10.getObject(r1, r4)
            com.fyber.inneractive.sdk.protobuf.i r4 = (com.fyber.inneractive.sdk.protobuf.i) r4
            com.fyber.inneractive.sdk.protobuf.l r5 = r3.a
            r5.b((int) r6, (com.fyber.inneractive.sdk.protobuf.i) r4)
            goto L_0x0b04
        L_0x0a6b:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            java.lang.Object r4 = r10.getObject(r1, r4)
            com.fyber.inneractive.sdk.protobuf.d1 r5 = r0.c((int) r12)
            r3.b(r6, r4, r5)
            goto L_0x0b04
        L_0x0a7d:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            java.lang.Object r4 = r10.getObject(r1, r4)
            r0.a((int) r6, (java.lang.Object) r4, (com.fyber.inneractive.sdk.protobuf.s1) r2)
            goto L_0x0b04
        L_0x0a8b:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            com.fyber.inneractive.sdk.protobuf.p1$d r7 = com.fyber.inneractive.sdk.protobuf.p1.e
            boolean r4 = r7.a(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r5 = r3.a
            r5.b((int) r6, (boolean) r4)
            goto L_0x0b04
        L_0x0a9c:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            int r4 = r10.getInt(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r5 = r3.a
            r5.g((int) r6, (int) r4)
            goto L_0x0b04
        L_0x0aab:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            long r4 = r10.getLong(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r7 = r3.a
            r7.f((int) r6, (long) r4)
            goto L_0x0b04
        L_0x0aba:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            int r4 = r10.getInt(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r5 = r3.a
            r5.h(r6, r4)
            goto L_0x0b04
        L_0x0ac9:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            long r4 = r10.getLong(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r7 = r3.a
            r7.g((int) r6, (long) r4)
            goto L_0x0b04
        L_0x0ad8:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            long r4 = r10.getLong(r1, r4)
            com.fyber.inneractive.sdk.protobuf.l r7 = r3.a
            r7.g((int) r6, (long) r4)
            goto L_0x0b04
        L_0x0ae7:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            com.fyber.inneractive.sdk.protobuf.p1$d r7 = com.fyber.inneractive.sdk.protobuf.p1.e
            float r4 = r7.d(r1, r4)
            r3.a((int) r6, (float) r4)
            goto L_0x0b04
        L_0x0af6:
            r8 = 1
            r15 = 0
            r7 = r7 & r14
            if (r7 == 0) goto L_0x0b04
            com.fyber.inneractive.sdk.protobuf.p1$d r7 = com.fyber.inneractive.sdk.protobuf.p1.e
            double r4 = r7.c(r1, r4)
            r3.a((int) r6, (double) r4)
        L_0x0b04:
            int r12 = r12 + 3
            r4 = r11
            r5 = r16
            r7 = 1
            r8 = 0
            r11 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x064e
        L_0x0b10:
            r11 = r4
            r16 = r5
        L_0x0b13:
            if (r5 == 0) goto L_0x0b2a
            com.fyber.inneractive.sdk.protobuf.r<?> r3 = r0.p
            r3.a(r2, r5)
            boolean r3 = r11.hasNext()
            if (r3 == 0) goto L_0x0b28
            java.lang.Object r3 = r11.next()
            r5 = r3
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0b13
        L_0x0b28:
            r5 = 0
            goto L_0x0b13
        L_0x0b2a:
            com.fyber.inneractive.sdk.protobuf.k1<?, ?> r3 = r0.o
            java.lang.Object r1 = r3.b(r1)
            r3.b(r1, (com.fyber.inneractive.sdk.protobuf.s1) r2)
        L_0x0b33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.r0.a(java.lang.Object, com.fyber.inneractive.sdk.protobuf.s1):void");
    }

    public final <K, V> void a(s1 s1Var, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            this.q.f(this.b[(i3 / 3) * 2]);
            Map<?, ?> a2 = this.q.a(obj);
            m mVar = (m) s1Var;
            mVar.a.getClass();
            Iterator<Map.Entry<?, ?>> it = a2.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry next = it.next();
                mVar.a.i(i2, 2);
                next.getKey();
                next.getValue();
                throw null;
            }
        }
    }

    public void a(T t, c1 c1Var, q qVar) throws IOException {
        qVar.getClass();
        a(this.o, this.p, t, c1Var, qVar);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final <UT, UB, ET extends com.fyber.inneractive.sdk.protobuf.u.b<ET>> void a(com.fyber.inneractive.sdk.protobuf.k1<UT, UB> r17, com.fyber.inneractive.sdk.protobuf.r<ET> r18, T r19, com.fyber.inneractive.sdk.protobuf.c1 r20, com.fyber.inneractive.sdk.protobuf.q r21) throws java.io.IOException {
        /*
            r16 = this;
            r8 = r16
            r9 = r17
            r10 = r19
            r0 = r20
            r11 = r21
            r12 = 0
            r13 = r12
            r14 = r13
        L_0x000d:
            int r1 = r20.s()     // Catch:{ all -> 0x0610 }
            int r3 = r8.e((int) r1)     // Catch:{ all -> 0x0610 }
            if (r3 >= 0) goto L_0x008d
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x0033
            int r0 = r8.k
        L_0x001e:
            int r1 = r8.l
            if (r0 >= r1) goto L_0x002d
            int[] r1 = r8.j
            r1 = r1[r0]
            java.lang.Object r13 = r8.a((java.lang.Object) r10, (int) r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x001e
        L_0x002d:
            if (r13 == 0) goto L_0x0032
            r9.b((java.lang.Object) r10, r13)
        L_0x0032:
            return
        L_0x0033:
            boolean r2 = r8.f     // Catch:{ all -> 0x0610 }
            if (r2 != 0) goto L_0x003b
            r15 = r18
            r3 = r12
            goto L_0x0044
        L_0x003b:
            com.fyber.inneractive.sdk.protobuf.o0 r2 = r8.e     // Catch:{ all -> 0x0610 }
            r15 = r18
            java.lang.Object r1 = r15.a(r11, r2, r1)     // Catch:{ all -> 0x0610 }
            r3 = r1
        L_0x0044:
            if (r3 == 0) goto L_0x005c
            if (r14 != 0) goto L_0x004c
            com.fyber.inneractive.sdk.protobuf.u r14 = r18.b(r19)     // Catch:{ all -> 0x0610 }
        L_0x004c:
            r1 = r18
            r2 = r20
            r4 = r21
            r5 = r14
            r6 = r13
            r7 = r17
            java.lang.Object r1 = r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0610 }
        L_0x005a:
            r13 = r1
            goto L_0x000d
        L_0x005c:
            boolean r1 = r9.a((com.fyber.inneractive.sdk.protobuf.c1) r0)     // Catch:{ all -> 0x0610 }
            if (r1 == 0) goto L_0x0069
            boolean r1 = r20.i()     // Catch:{ all -> 0x0610 }
            if (r1 == 0) goto L_0x0076
            goto L_0x000d
        L_0x0069:
            if (r13 != 0) goto L_0x006f
            java.lang.Object r13 = r9.a((java.lang.Object) r10)     // Catch:{ all -> 0x0610 }
        L_0x006f:
            boolean r1 = r9.a(r13, (com.fyber.inneractive.sdk.protobuf.c1) r0)     // Catch:{ all -> 0x0610 }
            if (r1 == 0) goto L_0x0076
            goto L_0x000d
        L_0x0076:
            int r0 = r8.k
        L_0x0078:
            int r1 = r8.l
            if (r0 >= r1) goto L_0x0087
            int[] r1 = r8.j
            r1 = r1[r0]
            java.lang.Object r13 = r8.a((java.lang.Object) r10, (int) r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x0078
        L_0x0087:
            if (r13 == 0) goto L_0x008c
            r9.b((java.lang.Object) r10, r13)
        L_0x008c:
            return
        L_0x008d:
            r15 = r18
            int r4 = r8.g(r3)     // Catch:{ all -> 0x0610 }
            int r2 = f(r4)     // Catch:{ a -> 0x05c9 }
            switch(r2) {
                case 0: goto L_0x059c;
                case 1: goto L_0x058c;
                case 2: goto L_0x057c;
                case 3: goto L_0x056c;
                case 4: goto L_0x055c;
                case 5: goto L_0x054c;
                case 6: goto L_0x053c;
                case 7: goto L_0x052c;
                case 8: goto L_0x0524;
                case 9: goto L_0x04ed;
                case 10: goto L_0x04dd;
                case 11: goto L_0x04cd;
                case 12: goto L_0x04aa;
                case 13: goto L_0x049a;
                case 14: goto L_0x048a;
                case 15: goto L_0x047a;
                case 16: goto L_0x046a;
                case 17: goto L_0x0433;
                case 18: goto L_0x0424;
                case 19: goto L_0x0415;
                case 20: goto L_0x0406;
                case 21: goto L_0x03f7;
                case 22: goto L_0x03e8;
                case 23: goto L_0x03d9;
                case 24: goto L_0x03ca;
                case 25: goto L_0x03bb;
                case 26: goto L_0x03b6;
                case 27: goto L_0x03a4;
                case 28: goto L_0x0395;
                case 29: goto L_0x0386;
                case 30: goto L_0x036f;
                case 31: goto L_0x0360;
                case 32: goto L_0x0351;
                case 33: goto L_0x0342;
                case 34: goto L_0x0333;
                case 35: goto L_0x0324;
                case 36: goto L_0x0315;
                case 37: goto L_0x0306;
                case 38: goto L_0x02f7;
                case 39: goto L_0x02e8;
                case 40: goto L_0x02d9;
                case 41: goto L_0x02ca;
                case 42: goto L_0x02bb;
                case 43: goto L_0x02ac;
                case 44: goto L_0x0295;
                case 45: goto L_0x0286;
                case 46: goto L_0x0277;
                case 47: goto L_0x0268;
                case 48: goto L_0x0259;
                case 49: goto L_0x0243;
                case 50: goto L_0x0232;
                case 51: goto L_0x021e;
                case 52: goto L_0x020a;
                case 53: goto L_0x01f6;
                case 54: goto L_0x01e2;
                case 55: goto L_0x01ce;
                case 56: goto L_0x01ba;
                case 57: goto L_0x01a6;
                case 58: goto L_0x0192;
                case 59: goto L_0x018a;
                case 60: goto L_0x0151;
                case 61: goto L_0x0141;
                case 62: goto L_0x012d;
                case 63: goto L_0x0106;
                case 64: goto L_0x00f2;
                case 65: goto L_0x00de;
                case 66: goto L_0x00ca;
                case 67: goto L_0x00b6;
                case 68: goto L_0x00a2;
                default: goto L_0x009a;
            }     // Catch:{ a -> 0x05c9 }
        L_0x009a:
            if (r13 != 0) goto L_0x05ac
            java.lang.Object r13 = r17.a()     // Catch:{ a -> 0x05c9 }
            goto L_0x05ac
        L_0x00a2:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.d1 r2 = r8.c((int) r3)     // Catch:{ a -> 0x05c9 }
            java.lang.Object r2 = r0.a(r2, (com.fyber.inneractive.sdk.protobuf.q) r11)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x00b6:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            long r6 = r20.l()     // Catch:{ a -> 0x05c9 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x00ca:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            int r2 = r20.j()     // Catch:{ a -> 0x05c9 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x00de:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            long r6 = r20.t()     // Catch:{ a -> 0x05c9 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x00f2:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            int r2 = r20.m()     // Catch:{ a -> 0x05c9 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0106:
            int r2 = r20.b()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.y$e r5 = r8.a((int) r3)     // Catch:{ a -> 0x05c9 }
            if (r5 == 0) goto L_0x011d
            boolean r5 = r5.a(r2)     // Catch:{ a -> 0x05c9 }
            if (r5 == 0) goto L_0x0117
            goto L_0x011d
        L_0x0117:
            java.lang.Object r1 = com.fyber.inneractive.sdk.protobuf.f1.a((int) r1, (int) r2, r13, r9)     // Catch:{ a -> 0x05c9 }
            goto L_0x005a
        L_0x011d:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x012d:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            int r2 = r20.c()     // Catch:{ a -> 0x05c9 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0141:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.i r2 = r20.a()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0151:
            boolean r2 = r8.a(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            if (r2 == 0) goto L_0x0173
            long r5 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.lang.Object r2 = com.fyber.inneractive.sdk.protobuf.p1.g(r10, r5)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.d1 r5 = r8.c((int) r3)     // Catch:{ a -> 0x05c9 }
            java.lang.Object r5 = r0.b(r5, (com.fyber.inneractive.sdk.protobuf.q) r11)     // Catch:{ a -> 0x05c9 }
            java.lang.Object r2 = com.fyber.inneractive.sdk.protobuf.y.a((java.lang.Object) r2, (java.lang.Object) r5)     // Catch:{ a -> 0x05c9 }
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            goto L_0x0185
        L_0x0173:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.d1 r2 = r8.c((int) r3)     // Catch:{ a -> 0x05c9 }
            java.lang.Object r2 = r0.b(r2, (com.fyber.inneractive.sdk.protobuf.q) r11)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
        L_0x0185:
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x018a:
            r8.a((java.lang.Object) r10, (int) r4, (com.fyber.inneractive.sdk.protobuf.c1) r0)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0192:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            boolean r2 = r20.r()     // Catch:{ a -> 0x05c9 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x01a6:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            int r2 = r20.q()     // Catch:{ a -> 0x05c9 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x01ba:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            long r6 = r20.g()     // Catch:{ a -> 0x05c9 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x01ce:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            int r2 = r20.d()     // Catch:{ a -> 0x05c9 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x01e2:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            long r6 = r20.f()     // Catch:{ a -> 0x05c9 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x01f6:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            long r6 = r20.o()     // Catch:{ a -> 0x05c9 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x020a:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            float r2 = r20.k()     // Catch:{ a -> 0x05c9 }
            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x021e:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            double r6 = r20.h()     // Catch:{ a -> 0x05c9 }
            java.lang.Double r2 = java.lang.Double.valueOf(r6)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r1, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0232:
            java.lang.Object r4 = r8.b((int) r3)     // Catch:{ a -> 0x05c9 }
            r1 = r16
            r2 = r19
            r5 = r21
            r6 = r20
            r1.a((java.lang.Object) r2, (int) r3, (java.lang.Object) r4, (com.fyber.inneractive.sdk.protobuf.q) r5, (com.fyber.inneractive.sdk.protobuf.c1) r6)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0243:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.d1 r6 = r8.c((int) r3)     // Catch:{ a -> 0x05c9 }
            r1 = r16
            r2 = r19
            r3 = r4
            r5 = r20
            r7 = r21
            r1.a((java.lang.Object) r2, (long) r3, (com.fyber.inneractive.sdk.protobuf.c1) r5, r6, (com.fyber.inneractive.sdk.protobuf.q) r7)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0259:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.g(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0268:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.c(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0277:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.m(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0286:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.f(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0295:
            com.fyber.inneractive.sdk.protobuf.e0 r2 = r8.n     // Catch:{ a -> 0x05c9 }
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r2 = r2.b(r10, r4)     // Catch:{ a -> 0x05c9 }
            r0.p(r2)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.y$e r3 = r8.a((int) r3)     // Catch:{ a -> 0x05c9 }
            java.lang.Object r1 = com.fyber.inneractive.sdk.protobuf.f1.a((int) r1, (java.util.List<java.lang.Integer>) r2, (com.fyber.inneractive.sdk.protobuf.y.e) r3, r13, r9)     // Catch:{ a -> 0x05c9 }
            goto L_0x005a
        L_0x02ac:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.i(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x02bb:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.l(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x02ca:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.e(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x02d9:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.n(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x02e8:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.o(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x02f7:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.a(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0306:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.k(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0315:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.d(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0324:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.j(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0333:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.g(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0342:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.c(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0351:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.m(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0360:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.f(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x036f:
            com.fyber.inneractive.sdk.protobuf.e0 r2 = r8.n     // Catch:{ a -> 0x05c9 }
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r2 = r2.b(r10, r4)     // Catch:{ a -> 0x05c9 }
            r0.p(r2)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.y$e r3 = r8.a((int) r3)     // Catch:{ a -> 0x05c9 }
            java.lang.Object r1 = com.fyber.inneractive.sdk.protobuf.f1.a((int) r1, (java.util.List<java.lang.Integer>) r2, (com.fyber.inneractive.sdk.protobuf.y.e) r3, r13, r9)     // Catch:{ a -> 0x05c9 }
            goto L_0x005a
        L_0x0386:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.i(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0395:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.h(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x03a4:
            com.fyber.inneractive.sdk.protobuf.d1 r5 = r8.c((int) r3)     // Catch:{ a -> 0x05c9 }
            r1 = r16
            r2 = r19
            r3 = r4
            r4 = r20
            r6 = r21
            r1.a((java.lang.Object) r2, (int) r3, (com.fyber.inneractive.sdk.protobuf.c1) r4, r5, (com.fyber.inneractive.sdk.protobuf.q) r6)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x03b6:
            r8.b((java.lang.Object) r10, (int) r4, (com.fyber.inneractive.sdk.protobuf.c1) r0)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x03bb:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.l(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x03ca:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.e(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x03d9:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.n(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x03e8:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.o(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x03f7:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.a(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0406:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.k(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0415:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.d(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0424:
            com.fyber.inneractive.sdk.protobuf.e0 r1 = r8.n     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.util.List r1 = r1.b(r10, r2)     // Catch:{ a -> 0x05c9 }
            r0.j(r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0433:
            boolean r1 = r8.a(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            if (r1 == 0) goto L_0x0456
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.lang.Object r1 = com.fyber.inneractive.sdk.protobuf.p1.g(r10, r1)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.d1 r2 = r8.c((int) r3)     // Catch:{ a -> 0x05c9 }
            java.lang.Object r2 = r0.a(r2, (com.fyber.inneractive.sdk.protobuf.q) r11)     // Catch:{ a -> 0x05c9 }
            java.lang.Object r1 = com.fyber.inneractive.sdk.protobuf.y.a((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r2, (java.lang.Object) r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0456:
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.d1 r4 = r8.c((int) r3)     // Catch:{ a -> 0x05c9 }
            java.lang.Object r4 = r0.a(r4, (com.fyber.inneractive.sdk.protobuf.q) r11)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r1, (java.lang.Object) r4)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x046a:
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            long r4 = r20.l()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r1, (long) r4)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x047a:
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            int r4 = r20.j()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r1, (int) r4)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x048a:
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            long r4 = r20.t()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r1, (long) r4)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x049a:
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            int r4 = r20.m()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r1, (int) r4)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x04aa:
            int r2 = r20.b()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.y$e r5 = r8.a((int) r3)     // Catch:{ a -> 0x05c9 }
            if (r5 == 0) goto L_0x04c1
            boolean r5 = r5.a(r2)     // Catch:{ a -> 0x05c9 }
            if (r5 == 0) goto L_0x04bb
            goto L_0x04c1
        L_0x04bb:
            java.lang.Object r1 = com.fyber.inneractive.sdk.protobuf.f1.a((int) r1, (int) r2, r13, r9)     // Catch:{ a -> 0x05c9 }
            goto L_0x005a
        L_0x04c1:
            long r4 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r4, (int) r2)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x04cd:
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            int r4 = r20.c()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r1, (int) r4)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x04dd:
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.i r4 = r20.a()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r1, (java.lang.Object) r4)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x04ed:
            boolean r1 = r8.a(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            if (r1 == 0) goto L_0x0510
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            java.lang.Object r1 = com.fyber.inneractive.sdk.protobuf.p1.g(r10, r1)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.d1 r2 = r8.c((int) r3)     // Catch:{ a -> 0x05c9 }
            java.lang.Object r2 = r0.b(r2, (com.fyber.inneractive.sdk.protobuf.q) r11)     // Catch:{ a -> 0x05c9 }
            java.lang.Object r1 = com.fyber.inneractive.sdk.protobuf.y.a((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ a -> 0x05c9 }
            long r2 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r2, (java.lang.Object) r1)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0510:
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.d1 r4 = r8.c((int) r3)     // Catch:{ a -> 0x05c9 }
            java.lang.Object r4 = r0.b(r4, (com.fyber.inneractive.sdk.protobuf.q) r11)     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r1, (java.lang.Object) r4)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x0524:
            r8.a((java.lang.Object) r10, (int) r4, (com.fyber.inneractive.sdk.protobuf.c1) r0)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x052c:
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            boolean r4 = r20.r()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r1, (boolean) r4)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x053c:
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            int r4 = r20.q()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r1, (int) r4)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x054c:
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            long r4 = r20.g()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r1, (long) r4)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x055c:
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            int r4 = r20.d()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r1, (int) r4)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x056c:
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            long r4 = r20.f()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r1, (long) r4)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x057c:
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            long r4 = r20.o()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r1, (long) r4)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x058c:
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            float r4 = r20.k()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r1, (float) r4)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x059c:
            long r1 = d((int) r4)     // Catch:{ a -> 0x05c9 }
            double r4 = r20.h()     // Catch:{ a -> 0x05c9 }
            com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r10, (long) r1, (double) r4)     // Catch:{ a -> 0x05c9 }
            r8.b(r10, (int) r3)     // Catch:{ a -> 0x05c9 }
            goto L_0x000d
        L_0x05ac:
            boolean r1 = r9.a(r13, (com.fyber.inneractive.sdk.protobuf.c1) r0)     // Catch:{ a -> 0x05c9 }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.k
        L_0x05b4:
            int r1 = r8.l
            if (r0 >= r1) goto L_0x05c3
            int[] r1 = r8.j
            r1 = r1[r0]
            java.lang.Object r13 = r8.a((java.lang.Object) r10, (int) r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05b4
        L_0x05c3:
            if (r13 == 0) goto L_0x05c8
            r9.b((java.lang.Object) r10, r13)
        L_0x05c8:
            return
        L_0x05c9:
            boolean r1 = r9.a((com.fyber.inneractive.sdk.protobuf.c1) r0)     // Catch:{ all -> 0x0610 }
            if (r1 == 0) goto L_0x05ec
            boolean r1 = r20.i()     // Catch:{ all -> 0x0610 }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.k
        L_0x05d7:
            int r1 = r8.l
            if (r0 >= r1) goto L_0x05e6
            int[] r1 = r8.j
            r1 = r1[r0]
            java.lang.Object r13 = r8.a((java.lang.Object) r10, (int) r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05d7
        L_0x05e6:
            if (r13 == 0) goto L_0x05eb
            r9.b((java.lang.Object) r10, r13)
        L_0x05eb:
            return
        L_0x05ec:
            if (r13 != 0) goto L_0x05f3
            java.lang.Object r1 = r9.a((java.lang.Object) r10)     // Catch:{ all -> 0x0610 }
            r13 = r1
        L_0x05f3:
            boolean r1 = r9.a(r13, (com.fyber.inneractive.sdk.protobuf.c1) r0)     // Catch:{ all -> 0x0610 }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.k
        L_0x05fb:
            int r1 = r8.l
            if (r0 >= r1) goto L_0x060a
            int[] r1 = r8.j
            r1 = r1[r0]
            java.lang.Object r13 = r8.a((java.lang.Object) r10, (int) r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05fb
        L_0x060a:
            if (r13 == 0) goto L_0x060f
            r9.b((java.lang.Object) r10, r13)
        L_0x060f:
            return
        L_0x0610:
            r0 = move-exception
            int r1 = r8.k
        L_0x0613:
            int r2 = r8.l
            if (r1 >= r2) goto L_0x0622
            int[] r2 = r8.j
            r2 = r2[r1]
            java.lang.Object r13 = r8.a((java.lang.Object) r10, (int) r2, r13, r9)
            int r1 = r1 + 1
            goto L_0x0613
        L_0x0622:
            if (r13 == 0) goto L_0x0627
            r9.b((java.lang.Object) r10, r13)
        L_0x0627:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.r0.a(com.fyber.inneractive.sdk.protobuf.k1, com.fyber.inneractive.sdk.protobuf.r, java.lang.Object, com.fyber.inneractive.sdk.protobuf.c1, com.fyber.inneractive.sdk.protobuf.q):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x0624  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(T r13, com.fyber.inneractive.sdk.protobuf.s1 r14) throws java.io.IOException {
        /*
            r12 = this;
            boolean r0 = r12.f
            r1 = 0
            if (r0 == 0) goto L_0x001e
            com.fyber.inneractive.sdk.protobuf.r<?> r0 = r12.p
            com.fyber.inneractive.sdk.protobuf.u r0 = r0.a((java.lang.Object) r13)
            com.fyber.inneractive.sdk.protobuf.g1<T, java.lang.Object> r2 = r0.a
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x001e
            java.util.Iterator r0 = r0.f()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0020
        L_0x001e:
            r0 = r1
            r2 = r0
        L_0x0020:
            int[] r3 = r12.a
            int r3 = r3.length
            r4 = 0
            r5 = 0
        L_0x0025:
            if (r5 >= r3) goto L_0x0622
            int r6 = r12.g(r5)
            int[] r7 = r12.a
            r7 = r7[r5]
        L_0x002f:
            if (r2 == 0) goto L_0x004d
            com.fyber.inneractive.sdk.protobuf.r<?> r8 = r12.p
            int r8 = r8.a((java.util.Map.Entry<?, ?>) r2)
            if (r8 > r7) goto L_0x004d
            com.fyber.inneractive.sdk.protobuf.r<?> r8 = r12.p
            r8.a(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004b
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x002f
        L_0x004b:
            r2 = r1
            goto L_0x002f
        L_0x004d:
            int r8 = f(r6)
            r9 = 1
            switch(r8) {
                case 0: goto L_0x0608;
                case 1: goto L_0x05f1;
                case 2: goto L_0x05da;
                case 3: goto L_0x05c3;
                case 4: goto L_0x05ac;
                case 5: goto L_0x0594;
                case 6: goto L_0x057c;
                case 7: goto L_0x0562;
                case 8: goto L_0x054f;
                case 9: goto L_0x0535;
                case 10: goto L_0x051b;
                case 11: goto L_0x0503;
                case 12: goto L_0x04eb;
                case 13: goto L_0x04d3;
                case 14: goto L_0x04bb;
                case 15: goto L_0x04a5;
                case 16: goto L_0x048f;
                case 17: goto L_0x0475;
                case 18: goto L_0x0462;
                case 19: goto L_0x044f;
                case 20: goto L_0x043c;
                case 21: goto L_0x0429;
                case 22: goto L_0x0416;
                case 23: goto L_0x0403;
                case 24: goto L_0x03f0;
                case 25: goto L_0x03dd;
                case 26: goto L_0x03ca;
                case 27: goto L_0x03b3;
                case 28: goto L_0x03a0;
                case 29: goto L_0x038d;
                case 30: goto L_0x037a;
                case 31: goto L_0x0367;
                case 32: goto L_0x0354;
                case 33: goto L_0x0341;
                case 34: goto L_0x032e;
                case 35: goto L_0x031b;
                case 36: goto L_0x0308;
                case 37: goto L_0x02f5;
                case 38: goto L_0x02e2;
                case 39: goto L_0x02cf;
                case 40: goto L_0x02bc;
                case 41: goto L_0x02a9;
                case 42: goto L_0x0296;
                case 43: goto L_0x0283;
                case 44: goto L_0x0270;
                case 45: goto L_0x025d;
                case 46: goto L_0x024a;
                case 47: goto L_0x0237;
                case 48: goto L_0x0224;
                case 49: goto L_0x020d;
                case 50: goto L_0x0200;
                case 51: goto L_0x01ea;
                case 52: goto L_0x01d4;
                case 53: goto L_0x01bc;
                case 54: goto L_0x01a4;
                case 55: goto L_0x018c;
                case 56: goto L_0x0174;
                case 57: goto L_0x015c;
                case 58: goto L_0x0144;
                case 59: goto L_0x0131;
                case 60: goto L_0x0117;
                case 61: goto L_0x00fd;
                case 62: goto L_0x00e5;
                case 63: goto L_0x00cd;
                case 64: goto L_0x00b5;
                case 65: goto L_0x009d;
                case 66: goto L_0x0087;
                case 67: goto L_0x0071;
                case 68: goto L_0x0057;
                default: goto L_0x0055;
            }
        L_0x0055:
            goto L_0x061e
        L_0x0057:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            com.fyber.inneractive.sdk.protobuf.d1 r8 = r12.c((int) r5)
            r9 = r14
            com.fyber.inneractive.sdk.protobuf.m r9 = (com.fyber.inneractive.sdk.protobuf.m) r9
            r9.a(r7, r6, r8)
            goto L_0x061e
        L_0x0071:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            long r8 = e(r13, r8)
            r6 = r14
            com.fyber.inneractive.sdk.protobuf.m r6 = (com.fyber.inneractive.sdk.protobuf.m) r6
            r6.a((int) r7, (long) r8)
            goto L_0x061e
        L_0x0087:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            int r6 = d(r13, r8)
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            r8.a((int) r7, (int) r6)
            goto L_0x061e
        L_0x009d:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            long r8 = e(r13, r8)
            r6 = r14
            com.fyber.inneractive.sdk.protobuf.m r6 = (com.fyber.inneractive.sdk.protobuf.m) r6
            com.fyber.inneractive.sdk.protobuf.l r6 = r6.a
            r6.f((int) r7, (long) r8)
            goto L_0x061e
        L_0x00b5:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            int r6 = d(r13, r8)
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            com.fyber.inneractive.sdk.protobuf.l r8 = r8.a
            r8.g((int) r7, (int) r6)
            goto L_0x061e
        L_0x00cd:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            int r6 = d(r13, r8)
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            com.fyber.inneractive.sdk.protobuf.l r8 = r8.a
            r8.h(r7, r6)
            goto L_0x061e
        L_0x00e5:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            int r6 = d(r13, r8)
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            com.fyber.inneractive.sdk.protobuf.l r8 = r8.a
            r8.j(r7, r6)
            goto L_0x061e
        L_0x00fd:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            com.fyber.inneractive.sdk.protobuf.i r6 = (com.fyber.inneractive.sdk.protobuf.i) r6
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            com.fyber.inneractive.sdk.protobuf.l r8 = r8.a
            r8.b((int) r7, (com.fyber.inneractive.sdk.protobuf.i) r6)
            goto L_0x061e
        L_0x0117:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            com.fyber.inneractive.sdk.protobuf.d1 r8 = r12.c((int) r5)
            r9 = r14
            com.fyber.inneractive.sdk.protobuf.m r9 = (com.fyber.inneractive.sdk.protobuf.m) r9
            r9.b(r7, r6, r8)
            goto L_0x061e
        L_0x0131:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            r12.a((int) r7, (java.lang.Object) r6, (com.fyber.inneractive.sdk.protobuf.s1) r14)
            goto L_0x061e
        L_0x0144:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            boolean r6 = a(r13, (long) r8)
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            com.fyber.inneractive.sdk.protobuf.l r8 = r8.a
            r8.b((int) r7, (boolean) r6)
            goto L_0x061e
        L_0x015c:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            int r6 = d(r13, r8)
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            com.fyber.inneractive.sdk.protobuf.l r8 = r8.a
            r8.g((int) r7, (int) r6)
            goto L_0x061e
        L_0x0174:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            long r8 = e(r13, r8)
            r6 = r14
            com.fyber.inneractive.sdk.protobuf.m r6 = (com.fyber.inneractive.sdk.protobuf.m) r6
            com.fyber.inneractive.sdk.protobuf.l r6 = r6.a
            r6.f((int) r7, (long) r8)
            goto L_0x061e
        L_0x018c:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            int r6 = d(r13, r8)
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            com.fyber.inneractive.sdk.protobuf.l r8 = r8.a
            r8.h(r7, r6)
            goto L_0x061e
        L_0x01a4:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            long r8 = e(r13, r8)
            r6 = r14
            com.fyber.inneractive.sdk.protobuf.m r6 = (com.fyber.inneractive.sdk.protobuf.m) r6
            com.fyber.inneractive.sdk.protobuf.l r6 = r6.a
            r6.g((int) r7, (long) r8)
            goto L_0x061e
        L_0x01bc:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            long r8 = e(r13, r8)
            r6 = r14
            com.fyber.inneractive.sdk.protobuf.m r6 = (com.fyber.inneractive.sdk.protobuf.m) r6
            com.fyber.inneractive.sdk.protobuf.l r6 = r6.a
            r6.g((int) r7, (long) r8)
            goto L_0x061e
        L_0x01d4:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            float r6 = c(r13, r8)
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            r8.a((int) r7, (float) r6)
            goto L_0x061e
        L_0x01ea:
            boolean r8 = r12.a(r13, (int) r7, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            double r8 = b(r13, (long) r8)
            r6 = r14
            com.fyber.inneractive.sdk.protobuf.m r6 = (com.fyber.inneractive.sdk.protobuf.m) r6
            r6.a((int) r7, (double) r8)
            goto L_0x061e
        L_0x0200:
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            r12.a((com.fyber.inneractive.sdk.protobuf.s1) r14, (int) r7, (java.lang.Object) r6, (int) r5)
            goto L_0x061e
        L_0x020d:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.d1 r8 = r12.c((int) r5)
            com.fyber.inneractive.sdk.protobuf.f1.a((int) r7, (java.util.List<?>) r6, (com.fyber.inneractive.sdk.protobuf.s1) r14, (com.fyber.inneractive.sdk.protobuf.d1) r8)
            goto L_0x061e
        L_0x0224:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r10 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.l(r7, r6, r14, r9)
            goto L_0x061e
        L_0x0237:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r10 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.k(r7, r6, r14, r9)
            goto L_0x061e
        L_0x024a:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r10 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.j(r7, r6, r14, r9)
            goto L_0x061e
        L_0x025d:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r10 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.i(r7, r6, r14, r9)
            goto L_0x061e
        L_0x0270:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r10 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.c(r7, r6, r14, r9)
            goto L_0x061e
        L_0x0283:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r10 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.m(r7, r6, r14, r9)
            goto L_0x061e
        L_0x0296:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r10 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.a((int) r7, (java.util.List<java.lang.Boolean>) r6, (com.fyber.inneractive.sdk.protobuf.s1) r14, (boolean) r9)
            goto L_0x061e
        L_0x02a9:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r10 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.d(r7, r6, r14, r9)
            goto L_0x061e
        L_0x02bc:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r10 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.e(r7, r6, r14, r9)
            goto L_0x061e
        L_0x02cf:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r10 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.g(r7, r6, r14, r9)
            goto L_0x061e
        L_0x02e2:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r10 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.n(r7, r6, r14, r9)
            goto L_0x061e
        L_0x02f5:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r10 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.h(r7, r6, r14, r9)
            goto L_0x061e
        L_0x0308:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r10 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.f(r7, r6, r14, r9)
            goto L_0x061e
        L_0x031b:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r10 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.b((int) r7, (java.util.List<java.lang.Double>) r6, (com.fyber.inneractive.sdk.protobuf.s1) r14, (boolean) r9)
            goto L_0x061e
        L_0x032e:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.l(r7, r6, r14, r4)
            goto L_0x061e
        L_0x0341:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.k(r7, r6, r14, r4)
            goto L_0x061e
        L_0x0354:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.j(r7, r6, r14, r4)
            goto L_0x061e
        L_0x0367:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.i(r7, r6, r14, r4)
            goto L_0x061e
        L_0x037a:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.c(r7, r6, r14, r4)
            goto L_0x061e
        L_0x038d:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.m(r7, r6, r14, r4)
            goto L_0x061e
        L_0x03a0:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.a((int) r7, (java.util.List<com.fyber.inneractive.sdk.protobuf.i>) r6, (com.fyber.inneractive.sdk.protobuf.s1) r14)
            goto L_0x061e
        L_0x03b3:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.d1 r8 = r12.c((int) r5)
            com.fyber.inneractive.sdk.protobuf.f1.b((int) r7, (java.util.List<?>) r6, (com.fyber.inneractive.sdk.protobuf.s1) r14, (com.fyber.inneractive.sdk.protobuf.d1) r8)
            goto L_0x061e
        L_0x03ca:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.b((int) r7, (java.util.List<java.lang.String>) r6, (com.fyber.inneractive.sdk.protobuf.s1) r14)
            goto L_0x061e
        L_0x03dd:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.a((int) r7, (java.util.List<java.lang.Boolean>) r6, (com.fyber.inneractive.sdk.protobuf.s1) r14, (boolean) r4)
            goto L_0x061e
        L_0x03f0:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.d(r7, r6, r14, r4)
            goto L_0x061e
        L_0x0403:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.e(r7, r6, r14, r4)
            goto L_0x061e
        L_0x0416:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.g(r7, r6, r14, r4)
            goto L_0x061e
        L_0x0429:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.n(r7, r6, r14, r4)
            goto L_0x061e
        L_0x043c:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.h(r7, r6, r14, r4)
            goto L_0x061e
        L_0x044f:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.f(r7, r6, r14, r4)
            goto L_0x061e
        L_0x0462:
            int[] r7 = r12.a
            r7 = r7[r5]
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.fyber.inneractive.sdk.protobuf.f1.b((int) r7, (java.util.List<java.lang.Double>) r6, (com.fyber.inneractive.sdk.protobuf.s1) r14, (boolean) r4)
            goto L_0x061e
        L_0x0475:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            com.fyber.inneractive.sdk.protobuf.d1 r8 = r12.c((int) r5)
            r9 = r14
            com.fyber.inneractive.sdk.protobuf.m r9 = (com.fyber.inneractive.sdk.protobuf.m) r9
            r9.a(r7, r6, r8)
            goto L_0x061e
        L_0x048f:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            long r8 = com.fyber.inneractive.sdk.protobuf.p1.f(r13, r8)
            r6 = r14
            com.fyber.inneractive.sdk.protobuf.m r6 = (com.fyber.inneractive.sdk.protobuf.m) r6
            r6.a((int) r7, (long) r8)
            goto L_0x061e
        L_0x04a5:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            int r6 = com.fyber.inneractive.sdk.protobuf.p1.e(r13, r8)
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            r8.a((int) r7, (int) r6)
            goto L_0x061e
        L_0x04bb:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            long r8 = com.fyber.inneractive.sdk.protobuf.p1.f(r13, r8)
            r6 = r14
            com.fyber.inneractive.sdk.protobuf.m r6 = (com.fyber.inneractive.sdk.protobuf.m) r6
            com.fyber.inneractive.sdk.protobuf.l r6 = r6.a
            r6.f((int) r7, (long) r8)
            goto L_0x061e
        L_0x04d3:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            int r6 = com.fyber.inneractive.sdk.protobuf.p1.e(r13, r8)
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            com.fyber.inneractive.sdk.protobuf.l r8 = r8.a
            r8.g((int) r7, (int) r6)
            goto L_0x061e
        L_0x04eb:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            int r6 = com.fyber.inneractive.sdk.protobuf.p1.e(r13, r8)
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            com.fyber.inneractive.sdk.protobuf.l r8 = r8.a
            r8.h(r7, r6)
            goto L_0x061e
        L_0x0503:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            int r6 = com.fyber.inneractive.sdk.protobuf.p1.e(r13, r8)
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            com.fyber.inneractive.sdk.protobuf.l r8 = r8.a
            r8.j(r7, r6)
            goto L_0x061e
        L_0x051b:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            com.fyber.inneractive.sdk.protobuf.i r6 = (com.fyber.inneractive.sdk.protobuf.i) r6
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            com.fyber.inneractive.sdk.protobuf.l r8 = r8.a
            r8.b((int) r7, (com.fyber.inneractive.sdk.protobuf.i) r6)
            goto L_0x061e
        L_0x0535:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            com.fyber.inneractive.sdk.protobuf.d1 r8 = r12.c((int) r5)
            r9 = r14
            com.fyber.inneractive.sdk.protobuf.m r9 = (com.fyber.inneractive.sdk.protobuf.m) r9
            r9.b(r7, r6, r8)
            goto L_0x061e
        L_0x054f:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            java.lang.Object r6 = com.fyber.inneractive.sdk.protobuf.p1.g(r13, r8)
            r12.a((int) r7, (java.lang.Object) r6, (com.fyber.inneractive.sdk.protobuf.s1) r14)
            goto L_0x061e
        L_0x0562:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            com.fyber.inneractive.sdk.protobuf.p1$d r6 = com.fyber.inneractive.sdk.protobuf.p1.e
            boolean r6 = r6.a(r13, r8)
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            com.fyber.inneractive.sdk.protobuf.l r8 = r8.a
            r8.b((int) r7, (boolean) r6)
            goto L_0x061e
        L_0x057c:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            int r6 = com.fyber.inneractive.sdk.protobuf.p1.e(r13, r8)
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            com.fyber.inneractive.sdk.protobuf.l r8 = r8.a
            r8.g((int) r7, (int) r6)
            goto L_0x061e
        L_0x0594:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            long r8 = com.fyber.inneractive.sdk.protobuf.p1.f(r13, r8)
            r6 = r14
            com.fyber.inneractive.sdk.protobuf.m r6 = (com.fyber.inneractive.sdk.protobuf.m) r6
            com.fyber.inneractive.sdk.protobuf.l r6 = r6.a
            r6.f((int) r7, (long) r8)
            goto L_0x061e
        L_0x05ac:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            int r6 = com.fyber.inneractive.sdk.protobuf.p1.e(r13, r8)
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            com.fyber.inneractive.sdk.protobuf.l r8 = r8.a
            r8.h(r7, r6)
            goto L_0x061e
        L_0x05c3:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            long r8 = com.fyber.inneractive.sdk.protobuf.p1.f(r13, r8)
            r6 = r14
            com.fyber.inneractive.sdk.protobuf.m r6 = (com.fyber.inneractive.sdk.protobuf.m) r6
            com.fyber.inneractive.sdk.protobuf.l r6 = r6.a
            r6.g((int) r7, (long) r8)
            goto L_0x061e
        L_0x05da:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            long r8 = com.fyber.inneractive.sdk.protobuf.p1.f(r13, r8)
            r6 = r14
            com.fyber.inneractive.sdk.protobuf.m r6 = (com.fyber.inneractive.sdk.protobuf.m) r6
            com.fyber.inneractive.sdk.protobuf.l r6 = r6.a
            r6.g((int) r7, (long) r8)
            goto L_0x061e
        L_0x05f1:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            com.fyber.inneractive.sdk.protobuf.p1$d r6 = com.fyber.inneractive.sdk.protobuf.p1.e
            float r6 = r6.d(r13, r8)
            r8 = r14
            com.fyber.inneractive.sdk.protobuf.m r8 = (com.fyber.inneractive.sdk.protobuf.m) r8
            r8.a((int) r7, (float) r6)
            goto L_0x061e
        L_0x0608:
            boolean r8 = r12.a(r13, (int) r5)
            if (r8 == 0) goto L_0x061e
            long r8 = d((int) r6)
            com.fyber.inneractive.sdk.protobuf.p1$d r6 = com.fyber.inneractive.sdk.protobuf.p1.e
            double r8 = r6.c(r13, r8)
            r6 = r14
            com.fyber.inneractive.sdk.protobuf.m r6 = (com.fyber.inneractive.sdk.protobuf.m) r6
            r6.a((int) r7, (double) r8)
        L_0x061e:
            int r5 = r5 + 3
            goto L_0x0025
        L_0x0622:
            if (r2 == 0) goto L_0x0638
            com.fyber.inneractive.sdk.protobuf.r<?> r3 = r12.p
            r3.a(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0636
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0622
        L_0x0636:
            r2 = r1
            goto L_0x0622
        L_0x0638:
            com.fyber.inneractive.sdk.protobuf.k1<?, ?> r0 = r12.o
            java.lang.Object r13 = r0.b(r13)
            r0.b(r13, (com.fyber.inneractive.sdk.protobuf.s1) r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.r0.b(java.lang.Object, com.fyber.inneractive.sdk.protobuf.s1):void");
    }

    public final Object b(int i2) {
        return this.b[(i2 / 3) * 2];
    }

    public final void b(Object obj, int i2, c1 c1Var) throws IOException {
        if ((536870912 & i2) != 0) {
            c1Var.b(this.n.b(obj, d(i2)));
        } else {
            c1Var.q(this.n.b(obj, d(i2)));
        }
    }

    public final void b(T t, T t2, int i2) {
        int[] iArr = this.a;
        int i3 = iArr[i2 + 1];
        int i4 = iArr[i2];
        long d2 = d(i3);
        if (a(t2, i4, i2)) {
            Object g2 = a(t, i4, i2) ? p1.g(t, d2) : null;
            Object g3 = p1.g(t2, d2);
            if (g2 != null && g3 != null) {
                p1.a((Object) t, d2, y.a(g2, g3));
                b(t, i4, i2);
            } else if (g3 != null) {
                p1.a((Object) t, d2, g3);
                b(t, i4, i2);
            }
        }
    }

    public final void b(T t, int i2) {
        int i3 = this.a[i2 + 2];
        long j2 = (long) (1048575 & i3);
        if (j2 != 1048575) {
            p1.a((Object) t, j2, (1 << (i3 >>> 20)) | p1.e(t, j2));
        }
    }

    public final void b(T t, int i2, int i3) {
        p1.a((Object) t, (long) (this.a[i3 + 2] & 1048575), i2);
    }

    public static <T> double b(T t, long j2) {
        return ((Double) p1.g(t, j2)).doubleValue();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0376 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0375 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0375 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01b7  */
    public final int a(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.fyber.inneractive.sdk.protobuf.e.b r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = s
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.fyber.inneractive.sdk.protobuf.y$j r12 = (com.fyber.inneractive.sdk.protobuf.y.j) r12
            boolean r13 = r12.d()
            r14 = 2
            if (r13 != 0) goto L_0x0034
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002b
            r13 = 10
            goto L_0x002d
        L_0x002b:
            int r13 = r13 * 2
        L_0x002d:
            com.fyber.inneractive.sdk.protobuf.y$j r12 = r12.b(r13)
            r11.putObject(r1, r9, r12)
        L_0x0034:
            r9 = 5
            r10 = 0
            r13 = 1
            switch(r26) {
                case 18: goto L_0x0346;
                case 19: goto L_0x0317;
                case 20: goto L_0x02ec;
                case 21: goto L_0x02ec;
                case 22: goto L_0x02d2;
                case 23: goto L_0x02a9;
                case 24: goto L_0x0280;
                case 25: goto L_0x0246;
                case 26: goto L_0x018f;
                case 27: goto L_0x0175;
                case 28: goto L_0x011b;
                case 29: goto L_0x02d2;
                case 30: goto L_0x00e5;
                case 31: goto L_0x0280;
                case 32: goto L_0x02a9;
                case 33: goto L_0x00b2;
                case 34: goto L_0x007f;
                case 35: goto L_0x0346;
                case 36: goto L_0x0317;
                case 37: goto L_0x02ec;
                case 38: goto L_0x02ec;
                case 39: goto L_0x02d2;
                case 40: goto L_0x02a9;
                case 41: goto L_0x0280;
                case 42: goto L_0x0246;
                case 43: goto L_0x02d2;
                case 44: goto L_0x00e5;
                case 45: goto L_0x0280;
                case 46: goto L_0x02a9;
                case 47: goto L_0x00b2;
                case 48: goto L_0x007f;
                case 49: goto L_0x003d;
                default: goto L_0x003b;
            }
        L_0x003b:
            goto L_0x0375
        L_0x003d:
            r1 = 3
            if (r6 != r1) goto L_0x0375
            com.fyber.inneractive.sdk.protobuf.d1 r1 = r15.c((int) r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.fyber.inneractive.sdk.protobuf.e.a((com.fyber.inneractive.sdk.protobuf.d1) r21, (byte[]) r22, (int) r23, (int) r24, (int) r25, (com.fyber.inneractive.sdk.protobuf.e.b) r26)
            java.lang.Object r8 = r7.c
            r12.add(r8)
        L_0x005d:
            if (r4 >= r5) goto L_0x0375
            int r8 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r4, r7)
            int r9 = r7.a
            if (r2 == r9) goto L_0x0069
            goto L_0x0375
        L_0x0069:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.fyber.inneractive.sdk.protobuf.e.a((com.fyber.inneractive.sdk.protobuf.d1) r21, (byte[]) r22, (int) r23, (int) r24, (int) r25, (com.fyber.inneractive.sdk.protobuf.e.b) r26)
            java.lang.Object r8 = r7.c
            r12.add(r8)
            goto L_0x005d
        L_0x007f:
            if (r6 != r14) goto L_0x0087
            int r1 = com.fyber.inneractive.sdk.protobuf.e.g(r3, r4, r12, r7)
            goto L_0x0376
        L_0x0087:
            if (r6 != 0) goto L_0x0375
            com.fyber.inneractive.sdk.protobuf.f0 r12 = (com.fyber.inneractive.sdk.protobuf.f0) r12
            int r1 = com.fyber.inneractive.sdk.protobuf.e.e(r3, r4, r7)
            long r8 = r7.b
            long r8 = com.fyber.inneractive.sdk.protobuf.j.a((long) r8)
            r12.a(r8)
        L_0x0098:
            if (r1 >= r5) goto L_0x0376
            int r4 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r1, r7)
            int r6 = r7.a
            if (r2 == r6) goto L_0x00a4
            goto L_0x0376
        L_0x00a4:
            int r1 = com.fyber.inneractive.sdk.protobuf.e.e(r3, r4, r7)
            long r8 = r7.b
            long r8 = com.fyber.inneractive.sdk.protobuf.j.a((long) r8)
            r12.a(r8)
            goto L_0x0098
        L_0x00b2:
            if (r6 != r14) goto L_0x00ba
            int r1 = com.fyber.inneractive.sdk.protobuf.e.f(r3, r4, r12, r7)
            goto L_0x0376
        L_0x00ba:
            if (r6 != 0) goto L_0x0375
            com.fyber.inneractive.sdk.protobuf.x r12 = (com.fyber.inneractive.sdk.protobuf.x) r12
            int r1 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r4, r7)
            int r4 = r7.a
            int r4 = com.fyber.inneractive.sdk.protobuf.j.b(r4)
            r12.c(r4)
        L_0x00cb:
            if (r1 >= r5) goto L_0x0376
            int r4 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r1, r7)
            int r6 = r7.a
            if (r2 == r6) goto L_0x00d7
            goto L_0x0376
        L_0x00d7:
            int r1 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r4, r7)
            int r4 = r7.a
            int r4 = com.fyber.inneractive.sdk.protobuf.j.b(r4)
            r12.c(r4)
            goto L_0x00cb
        L_0x00e5:
            if (r6 != r14) goto L_0x00ec
            int r2 = com.fyber.inneractive.sdk.protobuf.e.h(r3, r4, r12, r7)
            goto L_0x00fd
        L_0x00ec:
            if (r6 != 0) goto L_0x0375
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.fyber.inneractive.sdk.protobuf.e.a((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.fyber.inneractive.sdk.protobuf.y.j<?>) r6, (com.fyber.inneractive.sdk.protobuf.e.b) r7)
        L_0x00fd:
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite r1 = (com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite) r1
            com.fyber.inneractive.sdk.protobuf.l1 r3 = r1.unknownFields
            com.fyber.inneractive.sdk.protobuf.l1 r4 = com.fyber.inneractive.sdk.protobuf.l1.f
            if (r3 != r4) goto L_0x0106
            r3 = 0
        L_0x0106:
            com.fyber.inneractive.sdk.protobuf.y$e r4 = r15.a((int) r8)
            com.fyber.inneractive.sdk.protobuf.k1<?, ?> r5 = r0.o
            r6 = r21
            java.lang.Object r3 = com.fyber.inneractive.sdk.protobuf.f1.a((int) r6, (java.util.List<java.lang.Integer>) r12, (com.fyber.inneractive.sdk.protobuf.y.e) r4, r3, r5)
            com.fyber.inneractive.sdk.protobuf.l1 r3 = (com.fyber.inneractive.sdk.protobuf.l1) r3
            if (r3 == 0) goto L_0x0118
            r1.unknownFields = r3
        L_0x0118:
            r1 = r2
            goto L_0x0376
        L_0x011b:
            if (r6 != r14) goto L_0x0375
            int r1 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r4, r7)
            int r4 = r7.a
            if (r4 < 0) goto L_0x0170
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x016b
            if (r4 != 0) goto L_0x0131
            com.fyber.inneractive.sdk.protobuf.i r4 = com.fyber.inneractive.sdk.protobuf.i.b
            r12.add(r4)
            goto L_0x0139
        L_0x0131:
            com.fyber.inneractive.sdk.protobuf.i r6 = com.fyber.inneractive.sdk.protobuf.i.a((byte[]) r3, (int) r1, (int) r4)
            r12.add(r6)
        L_0x0138:
            int r1 = r1 + r4
        L_0x0139:
            if (r1 >= r5) goto L_0x0376
            int r4 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r1, r7)
            int r6 = r7.a
            if (r2 == r6) goto L_0x0145
            goto L_0x0376
        L_0x0145:
            int r1 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r4, r7)
            int r4 = r7.a
            if (r4 < 0) goto L_0x0166
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0161
            if (r4 != 0) goto L_0x0159
            com.fyber.inneractive.sdk.protobuf.i r4 = com.fyber.inneractive.sdk.protobuf.i.b
            r12.add(r4)
            goto L_0x0139
        L_0x0159:
            com.fyber.inneractive.sdk.protobuf.i r6 = com.fyber.inneractive.sdk.protobuf.i.a((byte[]) r3, (int) r1, (int) r4)
            r12.add(r6)
            goto L_0x0138
        L_0x0161:
            com.fyber.inneractive.sdk.protobuf.z r1 = com.fyber.inneractive.sdk.protobuf.z.i()
            throw r1
        L_0x0166:
            com.fyber.inneractive.sdk.protobuf.z r1 = com.fyber.inneractive.sdk.protobuf.z.f()
            throw r1
        L_0x016b:
            com.fyber.inneractive.sdk.protobuf.z r1 = com.fyber.inneractive.sdk.protobuf.z.i()
            throw r1
        L_0x0170:
            com.fyber.inneractive.sdk.protobuf.z r1 = com.fyber.inneractive.sdk.protobuf.z.f()
            throw r1
        L_0x0175:
            if (r6 != r14) goto L_0x0375
            com.fyber.inneractive.sdk.protobuf.d1 r1 = r15.c((int) r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.fyber.inneractive.sdk.protobuf.e.a(r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0376
        L_0x018f:
            if (r6 != r14) goto L_0x0375
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 != 0) goto L_0x01e4
            int r4 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r4, r7)
            int r6 = r7.a
            if (r6 < 0) goto L_0x01df
            if (r6 != 0) goto L_0x01aa
            r12.add(r1)
            goto L_0x01b5
        L_0x01aa:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.fyber.inneractive.sdk.protobuf.y.a
            r8.<init>(r3, r4, r6, r9)
            r12.add(r8)
        L_0x01b4:
            int r4 = r4 + r6
        L_0x01b5:
            if (r4 >= r5) goto L_0x0375
            int r6 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r4, r7)
            int r8 = r7.a
            if (r2 == r8) goto L_0x01c1
            goto L_0x0375
        L_0x01c1:
            int r4 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r6, r7)
            int r6 = r7.a
            if (r6 < 0) goto L_0x01da
            if (r6 != 0) goto L_0x01cf
            r12.add(r1)
            goto L_0x01b5
        L_0x01cf:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.fyber.inneractive.sdk.protobuf.y.a
            r8.<init>(r3, r4, r6, r9)
            r12.add(r8)
            goto L_0x01b4
        L_0x01da:
            com.fyber.inneractive.sdk.protobuf.z r1 = com.fyber.inneractive.sdk.protobuf.z.f()
            throw r1
        L_0x01df:
            com.fyber.inneractive.sdk.protobuf.z r1 = com.fyber.inneractive.sdk.protobuf.z.f()
            throw r1
        L_0x01e4:
            int r4 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r4, r7)
            int r6 = r7.a
            if (r6 < 0) goto L_0x0241
            if (r6 != 0) goto L_0x01f2
            r12.add(r1)
            goto L_0x0205
        L_0x01f2:
            int r8 = r4 + r6
            boolean r9 = com.fyber.inneractive.sdk.protobuf.q1.b(r3, r4, r8)
            if (r9 == 0) goto L_0x023c
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.fyber.inneractive.sdk.protobuf.y.a
            r9.<init>(r3, r4, r6, r10)
            r12.add(r9)
        L_0x0204:
            r4 = r8
        L_0x0205:
            if (r4 >= r5) goto L_0x0375
            int r6 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r4, r7)
            int r8 = r7.a
            if (r2 == r8) goto L_0x0211
            goto L_0x0375
        L_0x0211:
            int r4 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r6, r7)
            int r6 = r7.a
            if (r6 < 0) goto L_0x0237
            if (r6 != 0) goto L_0x021f
            r12.add(r1)
            goto L_0x0205
        L_0x021f:
            int r8 = r4 + r6
            boolean r9 = com.fyber.inneractive.sdk.protobuf.q1.b(r3, r4, r8)
            if (r9 == 0) goto L_0x0232
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.fyber.inneractive.sdk.protobuf.y.a
            r9.<init>(r3, r4, r6, r10)
            r12.add(r9)
            goto L_0x0204
        L_0x0232:
            com.fyber.inneractive.sdk.protobuf.z r1 = com.fyber.inneractive.sdk.protobuf.z.c()
            throw r1
        L_0x0237:
            com.fyber.inneractive.sdk.protobuf.z r1 = com.fyber.inneractive.sdk.protobuf.z.f()
            throw r1
        L_0x023c:
            com.fyber.inneractive.sdk.protobuf.z r1 = com.fyber.inneractive.sdk.protobuf.z.c()
            throw r1
        L_0x0241:
            com.fyber.inneractive.sdk.protobuf.z r1 = com.fyber.inneractive.sdk.protobuf.z.f()
            throw r1
        L_0x0246:
            if (r6 != r14) goto L_0x024e
            int r1 = com.fyber.inneractive.sdk.protobuf.e.a((byte[]) r3, (int) r4, (com.fyber.inneractive.sdk.protobuf.y.j<?>) r12, (com.fyber.inneractive.sdk.protobuf.e.b) r7)
            goto L_0x0376
        L_0x024e:
            if (r6 != 0) goto L_0x0375
            com.fyber.inneractive.sdk.protobuf.g r12 = (com.fyber.inneractive.sdk.protobuf.g) r12
            int r1 = com.fyber.inneractive.sdk.protobuf.e.e(r3, r4, r7)
            long r8 = r7.b
            r4 = 0
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x025f
            r6 = 1
            goto L_0x0260
        L_0x025f:
            r6 = 0
        L_0x0260:
            r12.a(r6)
        L_0x0263:
            if (r1 >= r5) goto L_0x0376
            int r6 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r1, r7)
            int r8 = r7.a
            if (r2 == r8) goto L_0x026f
            goto L_0x0376
        L_0x026f:
            int r1 = com.fyber.inneractive.sdk.protobuf.e.e(r3, r6, r7)
            long r8 = r7.b
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x027b
            r6 = 1
            goto L_0x027c
        L_0x027b:
            r6 = 0
        L_0x027c:
            r12.a(r6)
            goto L_0x0263
        L_0x0280:
            if (r6 != r14) goto L_0x0288
            int r1 = com.fyber.inneractive.sdk.protobuf.e.c(r3, r4, r12, r7)
            goto L_0x0376
        L_0x0288:
            if (r6 != r9) goto L_0x0375
            com.fyber.inneractive.sdk.protobuf.x r12 = (com.fyber.inneractive.sdk.protobuf.x) r12
            int r1 = com.fyber.inneractive.sdk.protobuf.e.a(r17, r18)
            r12.c(r1)
        L_0x0293:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0376
            int r4 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r1, r7)
            int r6 = r7.a
            if (r2 == r6) goto L_0x02a1
            goto L_0x0376
        L_0x02a1:
            int r1 = com.fyber.inneractive.sdk.protobuf.e.a(r3, r4)
            r12.c(r1)
            goto L_0x0293
        L_0x02a9:
            if (r6 != r14) goto L_0x02b1
            int r1 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r4, r12, r7)
            goto L_0x0376
        L_0x02b1:
            if (r6 != r13) goto L_0x0375
            com.fyber.inneractive.sdk.protobuf.f0 r12 = (com.fyber.inneractive.sdk.protobuf.f0) r12
            long r8 = com.fyber.inneractive.sdk.protobuf.e.b(r17, r18)
            r12.a(r8)
        L_0x02bc:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0376
            int r4 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r1, r7)
            int r6 = r7.a
            if (r2 == r6) goto L_0x02ca
            goto L_0x0376
        L_0x02ca:
            long r8 = com.fyber.inneractive.sdk.protobuf.e.b(r3, r4)
            r12.a(r8)
            goto L_0x02bc
        L_0x02d2:
            if (r6 != r14) goto L_0x02da
            int r1 = com.fyber.inneractive.sdk.protobuf.e.h(r3, r4, r12, r7)
            goto L_0x0376
        L_0x02da:
            if (r6 != 0) goto L_0x0375
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.fyber.inneractive.sdk.protobuf.e.a((int) r20, (byte[]) r21, (int) r22, (int) r23, (com.fyber.inneractive.sdk.protobuf.y.j<?>) r24, (com.fyber.inneractive.sdk.protobuf.e.b) r25)
            goto L_0x0376
        L_0x02ec:
            if (r6 != r14) goto L_0x02f4
            int r1 = com.fyber.inneractive.sdk.protobuf.e.i(r3, r4, r12, r7)
            goto L_0x0376
        L_0x02f4:
            if (r6 != 0) goto L_0x0375
            com.fyber.inneractive.sdk.protobuf.f0 r12 = (com.fyber.inneractive.sdk.protobuf.f0) r12
            int r1 = com.fyber.inneractive.sdk.protobuf.e.e(r3, r4, r7)
            long r8 = r7.b
            r12.a(r8)
        L_0x0301:
            if (r1 >= r5) goto L_0x0376
            int r4 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r1, r7)
            int r6 = r7.a
            if (r2 == r6) goto L_0x030d
            goto L_0x0376
        L_0x030d:
            int r1 = com.fyber.inneractive.sdk.protobuf.e.e(r3, r4, r7)
            long r8 = r7.b
            r12.a(r8)
            goto L_0x0301
        L_0x0317:
            if (r6 != r14) goto L_0x031e
            int r1 = com.fyber.inneractive.sdk.protobuf.e.e(r3, r4, r12, r7)
            goto L_0x0376
        L_0x031e:
            if (r6 != r9) goto L_0x0375
            com.fyber.inneractive.sdk.protobuf.v r12 = (com.fyber.inneractive.sdk.protobuf.v) r12
            int r1 = com.fyber.inneractive.sdk.protobuf.e.a(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.a(r1)
        L_0x032d:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0376
            int r4 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r1, r7)
            int r6 = r7.a
            if (r2 == r6) goto L_0x033a
            goto L_0x0376
        L_0x033a:
            int r1 = com.fyber.inneractive.sdk.protobuf.e.a(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.a(r1)
            goto L_0x032d
        L_0x0346:
            if (r6 != r14) goto L_0x034d
            int r1 = com.fyber.inneractive.sdk.protobuf.e.b(r3, r4, r12, r7)
            goto L_0x0376
        L_0x034d:
            if (r6 != r13) goto L_0x0375
            com.fyber.inneractive.sdk.protobuf.n r12 = (com.fyber.inneractive.sdk.protobuf.n) r12
            long r8 = com.fyber.inneractive.sdk.protobuf.e.b(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.a(r8)
        L_0x035c:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0376
            int r4 = com.fyber.inneractive.sdk.protobuf.e.d(r3, r1, r7)
            int r6 = r7.a
            if (r2 == r6) goto L_0x0369
            goto L_0x0376
        L_0x0369:
            long r8 = com.fyber.inneractive.sdk.protobuf.e.b(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.a(r8)
            goto L_0x035c
        L_0x0375:
            r1 = r4
        L_0x0376:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.r0.a(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.fyber.inneractive.sdk.protobuf.e$b):int");
    }

    public final <K, V> int a(T t, byte[] bArr, int i2, int i3, int i4, long j2, e.b bVar) throws IOException {
        Unsafe unsafe = s;
        Object obj = this.b[(i4 / 3) * 2];
        Object object = unsafe.getObject(t, j2);
        if (this.q.d(object)) {
            Object b2 = this.q.b(obj);
            this.q.a(b2, object);
            unsafe.putObject(t, j2, b2);
            object = b2;
        }
        this.q.f(obj);
        this.q.c(object);
        int d2 = e.d(bArr, i2, bVar);
        int i5 = bVar.a;
        if (i5 < 0 || i5 > i3 - d2) {
            throw z.i();
        }
        throw null;
    }

    public final int a(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, e.b bVar) throws IOException {
        T t2 = t;
        byte[] bArr2 = bArr;
        int i10 = i2;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        long j3 = j2;
        int i14 = i9;
        e.b bVar2 = bVar;
        Unsafe unsafe = s;
        long j4 = (long) (this.a[i14 + 2] & 1048575);
        switch (i8) {
            case 51:
                if (i13 == 1) {
                    unsafe.putObject(t2, j3, Double.valueOf(Double.longBitsToDouble(e.b(bArr, i2))));
                    int i15 = i10 + 8;
                    unsafe.putInt(t2, j4, i12);
                    return i15;
                }
                break;
            case 52:
                if (i13 == 5) {
                    unsafe.putObject(t2, j3, Float.valueOf(Float.intBitsToFloat(e.a(bArr, i2))));
                    int i16 = i10 + 4;
                    unsafe.putInt(t2, j4, i12);
                    return i16;
                }
                break;
            case 53:
            case 54:
                if (i13 == 0) {
                    int e2 = e.e(bArr2, i10, bVar2);
                    unsafe.putObject(t2, j3, Long.valueOf(bVar2.b));
                    unsafe.putInt(t2, j4, i12);
                    return e2;
                }
                break;
            case 55:
            case 62:
                if (i13 == 0) {
                    int d2 = e.d(bArr2, i10, bVar2);
                    unsafe.putObject(t2, j3, Integer.valueOf(bVar2.a));
                    unsafe.putInt(t2, j4, i12);
                    return d2;
                }
                break;
            case 56:
            case 65:
                if (i13 == 1) {
                    unsafe.putObject(t2, j3, Long.valueOf(e.b(bArr, i2)));
                    int i17 = i10 + 8;
                    unsafe.putInt(t2, j4, i12);
                    return i17;
                }
                break;
            case 57:
            case 64:
                if (i13 == 5) {
                    unsafe.putObject(t2, j3, Integer.valueOf(e.a(bArr, i2)));
                    int i18 = i10 + 4;
                    unsafe.putInt(t2, j4, i12);
                    return i18;
                }
                break;
            case 58:
                if (i13 == 0) {
                    int e3 = e.e(bArr2, i10, bVar2);
                    unsafe.putObject(t2, j3, Boolean.valueOf(bVar2.b != 0));
                    unsafe.putInt(t2, j4, i12);
                    return e3;
                }
                break;
            case 59:
                if (i13 == 2) {
                    int d3 = e.d(bArr2, i10, bVar2);
                    int i19 = bVar2.a;
                    if (i19 == 0) {
                        unsafe.putObject(t2, j3, "");
                    } else if ((i7 & DriveFile.MODE_WRITE_ONLY) == 0 || q1.b(bArr2, d3, d3 + i19)) {
                        unsafe.putObject(t2, j3, new String(bArr2, d3, i19, y.a));
                        d3 += i19;
                    } else {
                        throw z.c();
                    }
                    unsafe.putInt(t2, j4, i12);
                    return d3;
                }
                break;
            case 60:
                if (i13 == 2) {
                    int a2 = e.a(c(i14), bArr2, i10, i3, bVar2);
                    Object object = unsafe.getInt(t2, j4) == i12 ? unsafe.getObject(t2, j3) : null;
                    if (object == null) {
                        unsafe.putObject(t2, j3, bVar2.c);
                    } else {
                        unsafe.putObject(t2, j3, y.a(object, bVar2.c));
                    }
                    unsafe.putInt(t2, j4, i12);
                    return a2;
                }
                break;
            case 61:
                if (i13 == 2) {
                    int a3 = e.a(bArr2, i10, bVar2);
                    unsafe.putObject(t2, j3, bVar2.c);
                    unsafe.putInt(t2, j4, i12);
                    return a3;
                }
                break;
            case 63:
                if (i13 == 0) {
                    int d4 = e.d(bArr2, i10, bVar2);
                    int i20 = bVar2.a;
                    y.e a4 = a(i14);
                    if (a4 == null || a4.a(i20)) {
                        unsafe.putObject(t2, j3, Integer.valueOf(i20));
                        unsafe.putInt(t2, j4, i12);
                    } else {
                        e((Object) t).a(i11, (Object) Long.valueOf((long) i20));
                    }
                    return d4;
                }
                break;
            case 66:
                if (i13 == 0) {
                    int d5 = e.d(bArr2, i10, bVar2);
                    unsafe.putObject(t2, j3, Integer.valueOf(j.b(bVar2.a)));
                    unsafe.putInt(t2, j4, i12);
                    return d5;
                }
                break;
            case 67:
                if (i13 == 0) {
                    int e4 = e.e(bArr2, i10, bVar2);
                    unsafe.putObject(t2, j3, Long.valueOf(j.a(bVar2.b)));
                    unsafe.putInt(t2, j4, i12);
                    return e4;
                }
                break;
            case 68:
                if (i13 == 3) {
                    int a5 = e.a(c(i14), bArr, i2, i3, (i11 & -8) | 4, bVar);
                    Object object2 = unsafe.getInt(t2, j4) == i12 ? unsafe.getObject(t2, j3) : null;
                    if (object2 == null) {
                        unsafe.putObject(t2, j3, bVar2.c);
                    } else {
                        unsafe.putObject(t2, j3, y.a(object2, bVar2.c));
                    }
                    unsafe.putInt(t2, j4, i12);
                    return a5;
                }
                break;
        }
        return i10;
    }

    public final y.e a(int i2) {
        return (y.e) this.b[((i2 / 3) * 2) + 1];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v37, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02da, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02dc, code lost:
        r5 = r6 | r22;
        r8 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02e0, code lost:
        r12 = r7;
        r27 = r10;
        r2 = r11;
        r10 = r15;
        r6 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02e9, code lost:
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02ea, code lost:
        r20 = r6;
        r33 = r7;
        r2 = r8;
        r27 = r10;
        r19 = r11;
        r9 = r13;
        r22 = r25;
        r8 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x039b, code lost:
        if (r0 != r15) goto L_0x03eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x03e9, code lost:
        if (r0 != r15) goto L_0x03eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x03ff, code lost:
        r8 = r35;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0183, code lost:
        r8 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0255, code lost:
        r8 = r3;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(T r31, byte[] r32, int r33, int r34, int r35, com.fyber.inneractive.sdk.protobuf.e.b r36) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            sun.misc.Unsafe r10 = s
            r16 = 0
            r0 = r33
            r1 = -1
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            r17 = 0
            if (r0 >= r13) goto L_0x048f
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002c
            int r0 = com.fyber.inneractive.sdk.protobuf.e.a((int) r0, (byte[]) r12, (int) r3, (com.fyber.inneractive.sdk.protobuf.e.b) r9)
            int r3 = r9.a
            r4 = r3
            r3 = r0
            goto L_0x002d
        L_0x002c:
            r4 = r0
        L_0x002d:
            int r0 = r4 >>> 3
            r8 = r4 & 7
            r7 = 3
            if (r0 <= r1) goto L_0x0044
            int r2 = r2 / r7
            int r1 = r15.c
            if (r0 < r1) goto L_0x0042
            int r1 = r15.d
            if (r0 > r1) goto L_0x0042
            int r1 = r15.a((int) r0, (int) r2)
            goto L_0x0048
        L_0x0042:
            r1 = -1
            goto L_0x0048
        L_0x0044:
            int r1 = r15.e((int) r0)
        L_0x0048:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x005d
            r33 = r0
            r2 = r3
            r9 = r4
            r20 = r5
            r22 = r6
            r27 = r10
            r8 = r11
            r18 = -1
            r19 = 0
            goto L_0x0403
        L_0x005d:
            int[] r1 = r15.a
            int r20 = r2 + 1
            r1 = r1[r20]
            int r7 = f(r1)
            long r11 = d((int) r1)
            r20 = r4
            r4 = 17
            r21 = r1
            if (r7 > r4) goto L_0x02fa
            int[] r4 = r15.a
            int r22 = r2 + 2
            r4 = r4[r22]
            int r22 = r4 >>> 20
            r1 = 1
            int r22 = r1 << r22
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r13
            r18 = r2
            if (r4 == r6) goto L_0x0094
            if (r6 == r13) goto L_0x008c
            long r1 = (long) r6
            r10.putInt(r14, r1, r5)
        L_0x008c:
            long r1 = (long) r4
            int r5 = r10.getInt(r14, r1)
            r25 = r4
            goto L_0x0096
        L_0x0094:
            r25 = r6
        L_0x0096:
            r6 = r5
            r1 = 5
            switch(r7) {
                case 0: goto L_0x02b6;
                case 1: goto L_0x0296;
                case 2: goto L_0x0273;
                case 3: goto L_0x0273;
                case 4: goto L_0x0258;
                case 5: goto L_0x0233;
                case 6: goto L_0x0217;
                case 7: goto L_0x01ec;
                case 8: goto L_0x01c4;
                case 9: goto L_0x0189;
                case 10: goto L_0x0168;
                case 11: goto L_0x0258;
                case 12: goto L_0x0134;
                case 13: goto L_0x0217;
                case 14: goto L_0x0233;
                case 15: goto L_0x011a;
                case 16: goto L_0x00ef;
                case 17: goto L_0x00a7;
                default: goto L_0x009b;
            }
        L_0x009b:
            r12 = r32
            r7 = r0
            r8 = r3
            r11 = r18
            r13 = r20
            r18 = -1
            goto L_0x0184
        L_0x00a7:
            r2 = 3
            if (r8 != r2) goto L_0x00e3
            int r1 = r0 << 3
            r4 = r1 | 4
            r2 = r18
            com.fyber.inneractive.sdk.protobuf.d1 r1 = r15.c((int) r2)
            r7 = r0
            r0 = r1
            r18 = -1
            r1 = r32
            r8 = r2
            r2 = r3
            r3 = r34
            r5 = r20
            r13 = r5
            r5 = r36
            int r0 = com.fyber.inneractive.sdk.protobuf.e.a((com.fyber.inneractive.sdk.protobuf.d1) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.fyber.inneractive.sdk.protobuf.e.b) r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00d1
            java.lang.Object r1 = r9.c
            r10.putObject(r14, r11, r1)
            goto L_0x00de
        L_0x00d1:
            java.lang.Object r1 = r10.getObject(r14, r11)
            java.lang.Object r2 = r9.c
            java.lang.Object r1 = com.fyber.inneractive.sdk.protobuf.y.a((java.lang.Object) r1, (java.lang.Object) r2)
            r10.putObject(r14, r11, r1)
        L_0x00de:
            r12 = r32
            r11 = r8
            goto L_0x017e
        L_0x00e3:
            r7 = r0
            r8 = r18
            r13 = r20
            r18 = -1
            r12 = r32
            r11 = r8
            goto L_0x01bf
        L_0x00ef:
            r7 = r0
            r4 = r18
            r13 = r20
            r18 = -1
            if (r8 != 0) goto L_0x0115
            r1 = r11
            r12 = r32
            int r8 = com.fyber.inneractive.sdk.protobuf.e.e(r12, r3, r9)
            r19 = r1
            long r0 = r9.b
            long r23 = com.fyber.inneractive.sdk.protobuf.j.a((long) r0)
            r0 = r10
            r2 = r19
            r1 = r31
            r11 = r4
            r4 = r23
            r0.putLong(r1, r2, r4)
            r0 = r8
            goto L_0x017e
        L_0x0115:
            r12 = r32
            r11 = r4
            goto L_0x0183
        L_0x011a:
            r7 = r0
            r4 = r11
            r11 = r18
            r13 = r20
            r18 = -1
            r12 = r32
            if (r8 != 0) goto L_0x0183
            int r0 = com.fyber.inneractive.sdk.protobuf.e.d(r12, r3, r9)
            int r1 = r9.a
            int r1 = com.fyber.inneractive.sdk.protobuf.j.b(r1)
            r10.putInt(r14, r4, r1)
            goto L_0x017e
        L_0x0134:
            r7 = r0
            r4 = r11
            r11 = r18
            r13 = r20
            r18 = -1
            r12 = r32
            if (r8 != 0) goto L_0x0183
            int r0 = com.fyber.inneractive.sdk.protobuf.e.d(r12, r3, r9)
            int r1 = r9.a
            com.fyber.inneractive.sdk.protobuf.y$e r2 = r15.a((int) r11)
            if (r2 == 0) goto L_0x0164
            boolean r2 = r2.a(r1)
            if (r2 == 0) goto L_0x0153
            goto L_0x0164
        L_0x0153:
            com.fyber.inneractive.sdk.protobuf.l1 r2 = e((java.lang.Object) r31)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.a((int) r13, (java.lang.Object) r1)
            r8 = r35
            r5 = r6
            goto L_0x02e0
        L_0x0164:
            r10.putInt(r14, r4, r1)
            goto L_0x017e
        L_0x0168:
            r7 = r0
            r4 = r11
            r11 = r18
            r13 = r20
            r0 = 2
            r18 = -1
            r12 = r32
            if (r8 != r0) goto L_0x0183
            int r0 = com.fyber.inneractive.sdk.protobuf.e.a(r12, r3, r9)
            java.lang.Object r1 = r9.c
            r10.putObject(r14, r4, r1)
        L_0x017e:
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x02dc
        L_0x0183:
            r8 = r3
        L_0x0184:
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x02ea
        L_0x0189:
            r7 = r0
            r4 = r11
            r11 = r18
            r13 = r20
            r0 = 2
            r18 = -1
            r12 = r32
            if (r8 != r0) goto L_0x01bd
            com.fyber.inneractive.sdk.protobuf.d1 r0 = r15.c((int) r11)
            r2 = r34
            r19 = 1048575(0xfffff, float:1.469367E-39)
            int r0 = com.fyber.inneractive.sdk.protobuf.e.a((com.fyber.inneractive.sdk.protobuf.d1) r0, (byte[]) r12, (int) r3, (int) r2, (com.fyber.inneractive.sdk.protobuf.e.b) r9)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x01ae
            java.lang.Object r1 = r9.c
            r10.putObject(r14, r4, r1)
            goto L_0x02dc
        L_0x01ae:
            java.lang.Object r1 = r10.getObject(r14, r4)
            java.lang.Object r3 = r9.c
            java.lang.Object r1 = com.fyber.inneractive.sdk.protobuf.y.a((java.lang.Object) r1, (java.lang.Object) r3)
            r10.putObject(r14, r4, r1)
            goto L_0x02dc
        L_0x01bd:
            r2 = r34
        L_0x01bf:
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0255
        L_0x01c4:
            r2 = r34
            r7 = r0
            r4 = r11
            r11 = r18
            r13 = r20
            r0 = 2
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r32
            if (r8 != r0) goto L_0x0255
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r21 & r0
            if (r0 != 0) goto L_0x01e1
            int r0 = com.fyber.inneractive.sdk.protobuf.e.b(r12, r3, r9)
            goto L_0x01e5
        L_0x01e1:
            int r0 = com.fyber.inneractive.sdk.protobuf.e.c(r12, r3, r9)
        L_0x01e5:
            java.lang.Object r1 = r9.c
            r10.putObject(r14, r4, r1)
            goto L_0x02dc
        L_0x01ec:
            r2 = r34
            r7 = r0
            r4 = r11
            r11 = r18
            r13 = r20
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r32
            if (r8 != 0) goto L_0x0255
            int r0 = com.fyber.inneractive.sdk.protobuf.e.e(r12, r3, r9)
            r33 = r0
            long r0 = r9.b
            r20 = 0
            int r3 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r3 == 0) goto L_0x020d
            r1 = 1
            goto L_0x020e
        L_0x020d:
            r1 = 0
        L_0x020e:
            com.fyber.inneractive.sdk.protobuf.p1$d r0 = com.fyber.inneractive.sdk.protobuf.p1.e
            r0.a((java.lang.Object) r14, (long) r4, (boolean) r1)
            r0 = r33
            goto L_0x02dc
        L_0x0217:
            r2 = r34
            r7 = r0
            r4 = r11
            r11 = r18
            r13 = r20
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r32
            if (r8 != r1) goto L_0x0255
            int r0 = com.fyber.inneractive.sdk.protobuf.e.a(r12, r3)
            r10.putInt(r14, r4, r0)
            int r0 = r3 + 4
            goto L_0x02dc
        L_0x0233:
            r2 = r34
            r7 = r0
            r4 = r11
            r11 = r18
            r13 = r20
            r0 = 1
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r32
            if (r8 != r0) goto L_0x0255
            long r20 = com.fyber.inneractive.sdk.protobuf.e.b(r12, r3)
            r0 = r10
            r1 = r31
            r8 = r3
            r2 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
            goto L_0x02da
        L_0x0255:
            r8 = r3
            goto L_0x02ea
        L_0x0258:
            r7 = r0
            r2 = r3
            r4 = r11
            r11 = r18
            r13 = r20
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r32
            if (r8 != 0) goto L_0x02e9
            int r0 = com.fyber.inneractive.sdk.protobuf.e.d(r12, r2, r9)
            int r1 = r9.a
            r10.putInt(r14, r4, r1)
            goto L_0x02dc
        L_0x0273:
            r7 = r0
            r2 = r3
            r4 = r11
            r11 = r18
            r13 = r20
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r32
            if (r8 != 0) goto L_0x02e9
            int r8 = com.fyber.inneractive.sdk.protobuf.e.e(r12, r2, r9)
            long r2 = r9.b
            r0 = r10
            r1 = r31
            r20 = r2
            r2 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
            r0 = r8
            goto L_0x02dc
        L_0x0296:
            r7 = r0
            r2 = r3
            r4 = r11
            r11 = r18
            r13 = r20
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r32
            if (r8 != r1) goto L_0x02e9
            int r0 = com.fyber.inneractive.sdk.protobuf.e.a(r12, r2)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.fyber.inneractive.sdk.protobuf.p1$d r1 = com.fyber.inneractive.sdk.protobuf.p1.e
            r1.a((java.lang.Object) r14, (long) r4, (float) r0)
            int r0 = r2 + 4
            goto L_0x02dc
        L_0x02b6:
            r7 = r0
            r2 = r3
            r4 = r11
            r11 = r18
            r13 = r20
            r0 = 1
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r32
            if (r8 != r0) goto L_0x02e9
            long r0 = com.fyber.inneractive.sdk.protobuf.e.b(r12, r2)
            double r20 = java.lang.Double.longBitsToDouble(r0)
            com.fyber.inneractive.sdk.protobuf.p1$d r0 = com.fyber.inneractive.sdk.protobuf.p1.e
            r1 = r31
            r8 = r2
            r2 = r4
            r4 = r20
            r0.a((java.lang.Object) r1, (long) r2, (double) r4)
        L_0x02da:
            int r0 = r8 + 8
        L_0x02dc:
            r5 = r6 | r22
            r8 = r35
        L_0x02e0:
            r12 = r7
            r27 = r10
            r2 = r11
            r10 = r15
            r6 = r25
            goto L_0x0351
        L_0x02e9:
            r8 = r2
        L_0x02ea:
            r20 = r6
            r33 = r7
            r2 = r8
            r27 = r10
            r19 = r11
            r9 = r13
            r22 = r25
            r8 = r35
            goto L_0x0403
        L_0x02fa:
            r4 = r0
            r1 = r3
            r13 = r20
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r28 = r11
            r12 = r32
            r11 = r2
            r2 = r28
            r0 = 27
            if (r7 != r0) goto L_0x0365
            r0 = 2
            if (r8 != r0) goto L_0x0356
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.fyber.inneractive.sdk.protobuf.y$j r0 = (com.fyber.inneractive.sdk.protobuf.y.j) r0
            boolean r7 = r0.d()
            if (r7 != 0) goto L_0x032f
            int r7 = r0.size()
            if (r7 != 0) goto L_0x0326
            r7 = 10
            goto L_0x0328
        L_0x0326:
            int r7 = r7 * 2
        L_0x0328:
            com.fyber.inneractive.sdk.protobuf.y$j r0 = r0.b(r7)
            r10.putObject(r14, r2, r0)
        L_0x032f:
            r7 = r0
            com.fyber.inneractive.sdk.protobuf.d1 r0 = r15.c((int) r11)
            r3 = r1
            r1 = r13
            r2 = r32
            r8 = r4
            r4 = r34
            r20 = r5
            r5 = r7
            r22 = r6
            r6 = r36
            int r0 = com.fyber.inneractive.sdk.protobuf.e.a(r0, r1, r2, r3, r4, r5, r6)
            r12 = r8
            r27 = r10
            r2 = r11
            r10 = r15
            r5 = r20
            r6 = r22
            r8 = r35
        L_0x0351:
            r11 = r9
            r9 = r13
            r13 = r14
            goto L_0x0481
        L_0x0356:
            r20 = r5
            r22 = r6
            r15 = r1
            r33 = r4
            r27 = r10
            r19 = r11
            r24 = r13
            goto L_0x03b6
        L_0x0365:
            r20 = r5
            r22 = r6
            r6 = r1
            r5 = r4
            r0 = 49
            if (r7 > r0) goto L_0x039e
            r1 = r21
            long r0 = (long) r1
            r23 = r0
            r0 = r30
            r1 = r31
            r25 = r2
            r2 = r32
            r3 = r6
            r4 = r34
            r33 = r5
            r5 = r13
            r15 = r6
            r6 = r33
            r21 = r7
            r7 = r8
            r8 = r11
            r27 = r10
            r9 = r23
            r19 = r11
            r11 = r21
            r24 = r13
            r12 = r25
            r14 = r36
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.fyber.inneractive.sdk.protobuf.e.b) r14)
            if (r0 == r15) goto L_0x03ff
            goto L_0x03eb
        L_0x039e:
            r25 = r2
            r33 = r5
            r15 = r6
            r27 = r10
            r19 = r11
            r24 = r13
            r1 = r21
            r21 = r7
            r0 = 50
            r9 = r21
            if (r9 != r0) goto L_0x03cf
            r0 = 2
            if (r8 == r0) goto L_0x03bc
        L_0x03b6:
            r8 = r35
            r2 = r15
        L_0x03b9:
            r9 = r24
            goto L_0x0403
        L_0x03bc:
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r19
            r6 = r25
            r8 = r36
            r0.a(r1, r2, r3, r4, r5, r6, r8)
            throw r17
        L_0x03cf:
            r0 = r30
            r10 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r24
            r6 = r33
            r7 = r8
            r8 = r10
            r10 = r25
            r12 = r19
            r13 = r36
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.fyber.inneractive.sdk.protobuf.e.b) r13)
            if (r0 == r15) goto L_0x03ff
        L_0x03eb:
            r10 = r30
            r13 = r31
            r12 = r33
            r8 = r35
            r11 = r36
            r2 = r19
            r5 = r20
            r6 = r22
            r9 = r24
            goto L_0x0481
        L_0x03ff:
            r8 = r35
            r2 = r0
            goto L_0x03b9
        L_0x0403:
            if (r9 != r8) goto L_0x0413
            if (r8 == 0) goto L_0x0413
            r10 = r30
            r13 = r31
            r0 = r2
            r3 = r9
            r5 = r20
            r6 = r22
            goto L_0x0498
        L_0x0413:
            r10 = r30
            boolean r0 = r10.f
            if (r0 == 0) goto L_0x0466
            r11 = r36
            com.fyber.inneractive.sdk.protobuf.q r0 = r11.d
            com.fyber.inneractive.sdk.protobuf.q r1 = com.fyber.inneractive.sdk.protobuf.q.a()
            if (r0 == r1) goto L_0x0461
            com.fyber.inneractive.sdk.protobuf.o0 r0 = r10.e
            com.fyber.inneractive.sdk.protobuf.k1<?, ?> r6 = r10.o
            com.fyber.inneractive.sdk.protobuf.q r1 = r11.d
            java.util.Map<com.fyber.inneractive.sdk.protobuf.q$a, com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$e<?, ?>> r1 = r1.a
            com.fyber.inneractive.sdk.protobuf.q$a r3 = new com.fyber.inneractive.sdk.protobuf.q$a
            r12 = r33
            r3.<init>(r0, r12)
            java.lang.Object r0 = r1.get(r3)
            r5 = r0
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$e r5 = (com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.e) r5
            if (r5 != 0) goto L_0x044d
            com.fyber.inneractive.sdk.protobuf.l1 r4 = e((java.lang.Object) r31)
            r0 = r9
            r1 = r32
            r3 = r34
            r5 = r36
            int r0 = com.fyber.inneractive.sdk.protobuf.e.a((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.fyber.inneractive.sdk.protobuf.l1) r4, (com.fyber.inneractive.sdk.protobuf.e.b) r5)
            r13 = r31
            goto L_0x047b
        L_0x044d:
            r13 = r31
            r4 = r13
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$ExtendableMessage r4 = (com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.ExtendableMessage) r4
            r4.ensureExtensionsAreMutable()
            r0 = r9
            r1 = r32
            r3 = r34
            r7 = r36
            int r0 = com.fyber.inneractive.sdk.protobuf.e.a(r0, r1, r2, r3, r4, r5, r6, r7)
            goto L_0x047b
        L_0x0461:
            r13 = r31
            r12 = r33
            goto L_0x046c
        L_0x0466:
            r13 = r31
            r12 = r33
            r11 = r36
        L_0x046c:
            com.fyber.inneractive.sdk.protobuf.l1 r4 = e((java.lang.Object) r31)
            r0 = r9
            r1 = r32
            r3 = r34
            r5 = r36
            int r0 = com.fyber.inneractive.sdk.protobuf.e.a((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.fyber.inneractive.sdk.protobuf.l1) r4, (com.fyber.inneractive.sdk.protobuf.e.b) r5)
        L_0x047b:
            r2 = r19
            r5 = r20
            r6 = r22
        L_0x0481:
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r14 = r13
            r10 = r27
            r12 = r32
            r13 = r34
            r11 = r8
            goto L_0x0019
        L_0x048f:
            r20 = r5
            r22 = r6
            r27 = r10
            r8 = r11
            r13 = r14
            r10 = r15
        L_0x0498:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r1) goto L_0x04a3
            long r1 = (long) r6
            r4 = r27
            r4.putInt(r13, r1, r5)
        L_0x04a3:
            int r1 = r10.k
            r2 = r17
        L_0x04a7:
            int r4 = r10.l
            if (r1 >= r4) goto L_0x04ba
            int[] r4 = r10.j
            r4 = r4[r1]
            com.fyber.inneractive.sdk.protobuf.k1<?, ?> r5 = r10.o
            java.lang.Object r2 = r10.a((java.lang.Object) r13, (int) r4, r2, r5)
            com.fyber.inneractive.sdk.protobuf.l1 r2 = (com.fyber.inneractive.sdk.protobuf.l1) r2
            int r1 = r1 + 1
            goto L_0x04a7
        L_0x04ba:
            if (r2 == 0) goto L_0x04c1
            com.fyber.inneractive.sdk.protobuf.k1<?, ?> r1 = r10.o
            r1.b((java.lang.Object) r13, r2)
        L_0x04c1:
            if (r8 != 0) goto L_0x04cd
            r1 = r34
            if (r0 != r1) goto L_0x04c8
            goto L_0x04d3
        L_0x04c8:
            com.fyber.inneractive.sdk.protobuf.z r0 = com.fyber.inneractive.sdk.protobuf.z.g()
            throw r0
        L_0x04cd:
            r1 = r34
            if (r0 > r1) goto L_0x04d4
            if (r3 != r8) goto L_0x04d4
        L_0x04d3:
            return r0
        L_0x04d4:
            com.fyber.inneractive.sdk.protobuf.z r0 = com.fyber.inneractive.sdk.protobuf.z.g()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.r0.a(java.lang.Object, byte[], int, int, int, com.fyber.inneractive.sdk.protobuf.e$b):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v15, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02b2, code lost:
        if (r0 != r15) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0308, code lost:
        if (r0 != r15) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0311, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0102, code lost:
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01ec, code lost:
        r17 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x020b, code lost:
        r17 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x020d, code lost:
        r6 = r6 | r21;
        r28 = r10;
        r2 = r13;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0215, code lost:
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0216, code lost:
        r2 = r8;
        r28 = r10;
        r20 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(T r31, byte[] r32, int r33, int r34, com.fyber.inneractive.sdk.protobuf.e.b r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            boolean r0 = r15.h
            if (r0 == 0) goto L_0x0353
            sun.misc.Unsafe r9 = s
            r10 = -1
            r16 = 0
            r0 = r33
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001b:
            if (r0 >= r13) goto L_0x0336
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002d
            int r0 = com.fyber.inneractive.sdk.protobuf.e.a((int) r0, (byte[]) r12, (int) r3, (com.fyber.inneractive.sdk.protobuf.e.b) r11)
            int r3 = r11.a
            r4 = r0
            r17 = r3
            goto L_0x0030
        L_0x002d:
            r17 = r0
            r4 = r3
        L_0x0030:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x0047
            int r2 = r2 / 3
            int r0 = r15.c
            if (r5 < r0) goto L_0x0045
            int r0 = r15.d
            if (r5 > r0) goto L_0x0045
            int r0 = r15.a((int) r5, (int) r2)
            goto L_0x004b
        L_0x0045:
            r0 = -1
            goto L_0x004b
        L_0x0047:
            int r0 = r15.e((int) r5)
        L_0x004b:
            r2 = r0
            if (r2 != r10) goto L_0x0059
            r2 = r4
            r19 = r5
            r28 = r9
            r18 = -1
            r20 = 0
            goto L_0x0313
        L_0x0059:
            int[] r0 = r15.a
            int r1 = r2 + 1
            r1 = r0[r1]
            int r0 = f(r1)
            r18 = r9
            long r8 = d((int) r1)
            r10 = 17
            r33 = r5
            if (r0 > r10) goto L_0x021f
            int[] r10 = r15.a
            int r21 = r2 + 2
            r10 = r10[r21]
            int r21 = r10 >>> 20
            r5 = 1
            int r21 = r5 << r21
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r13
            r23 = r1
            r19 = r2
            if (r10 == r7) goto L_0x009c
            if (r7 == r13) goto L_0x008d
            long r1 = (long) r7
            r7 = r18
            r7.putInt(r14, r1, r6)
            goto L_0x008f
        L_0x008d:
            r7 = r18
        L_0x008f:
            if (r10 == r13) goto L_0x0096
            long r1 = (long) r10
            int r6 = r7.getInt(r14, r1)
        L_0x0096:
            r29 = r10
            r10 = r7
            r7 = r29
            goto L_0x009e
        L_0x009c:
            r10 = r18
        L_0x009e:
            r1 = 5
            switch(r0) {
                case 0: goto L_0x01ef;
                case 1: goto L_0x01d6;
                case 2: goto L_0x01bf;
                case 3: goto L_0x01bf;
                case 4: goto L_0x01ac;
                case 5: goto L_0x0192;
                case 6: goto L_0x017f;
                case 7: goto L_0x015f;
                case 8: goto L_0x013b;
                case 9: goto L_0x0108;
                case 10: goto L_0x00ed;
                case 11: goto L_0x01ac;
                case 12: goto L_0x00dd;
                case 13: goto L_0x017f;
                case 14: goto L_0x0192;
                case 15: goto L_0x00c9;
                case 16: goto L_0x00ac;
                default: goto L_0x00a2;
            }
        L_0x00a2:
            r8 = r4
            r13 = r19
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r33
            goto L_0x0216
        L_0x00ac:
            if (r3 != 0) goto L_0x00c4
            int r17 = com.fyber.inneractive.sdk.protobuf.e.e(r12, r4, r11)
            long r0 = r11.b
            long r4 = com.fyber.inneractive.sdk.protobuf.j.a((long) r0)
            r0 = r10
            r1 = r31
            r13 = r19
            r2 = r8
            r19 = r33
            r0.putLong(r1, r2, r4)
            goto L_0x00fd
        L_0x00c4:
            r13 = r19
            r19 = r33
            goto L_0x0102
        L_0x00c9:
            r13 = r19
            r19 = r33
            if (r3 != 0) goto L_0x0102
            int r17 = com.fyber.inneractive.sdk.protobuf.e.d(r12, r4, r11)
            int r0 = r11.a
            int r0 = com.fyber.inneractive.sdk.protobuf.j.b(r0)
            r10.putInt(r14, r8, r0)
            goto L_0x00fd
        L_0x00dd:
            r13 = r19
            r19 = r33
            if (r3 != 0) goto L_0x0102
            int r17 = com.fyber.inneractive.sdk.protobuf.e.d(r12, r4, r11)
            int r0 = r11.a
            r10.putInt(r14, r8, r0)
            goto L_0x00fd
        L_0x00ed:
            r13 = r19
            r0 = 2
            r19 = r33
            if (r3 != r0) goto L_0x0102
            int r17 = com.fyber.inneractive.sdk.protobuf.e.a(r12, r4, r11)
            java.lang.Object r0 = r11.c
            r10.putObject(r14, r8, r0)
        L_0x00fd:
            r18 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x020d
        L_0x0102:
            r8 = r4
            r18 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0216
        L_0x0108:
            r13 = r19
            r0 = 2
            r19 = r33
            if (r3 != r0) goto L_0x0134
            com.fyber.inneractive.sdk.protobuf.d1 r0 = r15.c((int) r13)
            r2 = r34
            r18 = 1048575(0xfffff, float:1.469367E-39)
            int r17 = com.fyber.inneractive.sdk.protobuf.e.a((com.fyber.inneractive.sdk.protobuf.d1) r0, (byte[]) r12, (int) r4, (int) r2, (com.fyber.inneractive.sdk.protobuf.e.b) r11)
            java.lang.Object r0 = r10.getObject(r14, r8)
            if (r0 != 0) goto L_0x0129
            java.lang.Object r0 = r11.c
            r10.putObject(r14, r8, r0)
            goto L_0x020d
        L_0x0129:
            java.lang.Object r1 = r11.c
            java.lang.Object r0 = com.fyber.inneractive.sdk.protobuf.y.a((java.lang.Object) r0, (java.lang.Object) r1)
            r10.putObject(r14, r8, r0)
            goto L_0x020d
        L_0x0134:
            r2 = r34
            r18 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0215
        L_0x013b:
            r2 = r34
            r13 = r19
            r0 = 2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r33
            if (r3 != r0) goto L_0x0215
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r23 & r0
            if (r0 != 0) goto L_0x0152
            int r0 = com.fyber.inneractive.sdk.protobuf.e.b(r12, r4, r11)
            goto L_0x0156
        L_0x0152:
            int r0 = com.fyber.inneractive.sdk.protobuf.e.c(r12, r4, r11)
        L_0x0156:
            r17 = r0
            java.lang.Object r0 = r11.c
            r10.putObject(r14, r8, r0)
            goto L_0x020d
        L_0x015f:
            r2 = r34
            r13 = r19
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r33
            if (r3 != 0) goto L_0x0215
            int r17 = com.fyber.inneractive.sdk.protobuf.e.e(r12, r4, r11)
            long r0 = r11.b
            r3 = 0
            int r22 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r22 == 0) goto L_0x0177
            goto L_0x0178
        L_0x0177:
            r5 = 0
        L_0x0178:
            com.fyber.inneractive.sdk.protobuf.p1$d r0 = com.fyber.inneractive.sdk.protobuf.p1.e
            r0.a((java.lang.Object) r14, (long) r8, (boolean) r5)
            goto L_0x020d
        L_0x017f:
            r2 = r34
            r13 = r19
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r33
            if (r3 != r1) goto L_0x0215
            int r0 = com.fyber.inneractive.sdk.protobuf.e.a(r12, r4)
            r10.putInt(r14, r8, r0)
            goto L_0x01ec
        L_0x0192:
            r2 = r34
            r13 = r19
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r33
            if (r3 != r5) goto L_0x0215
            long r22 = com.fyber.inneractive.sdk.protobuf.e.b(r12, r4)
            r0 = r10
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            goto L_0x020b
        L_0x01ac:
            r13 = r19
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r33
            if (r3 != 0) goto L_0x0215
            int r17 = com.fyber.inneractive.sdk.protobuf.e.d(r12, r4, r11)
            int r0 = r11.a
            r10.putInt(r14, r8, r0)
            goto L_0x020d
        L_0x01bf:
            r13 = r19
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r33
            if (r3 != 0) goto L_0x0215
            int r17 = com.fyber.inneractive.sdk.protobuf.e.e(r12, r4, r11)
            long r4 = r11.b
            r0 = r10
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
            goto L_0x020d
        L_0x01d6:
            r13 = r19
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r33
            if (r3 != r1) goto L_0x0215
            int r0 = com.fyber.inneractive.sdk.protobuf.e.a(r12, r4)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.fyber.inneractive.sdk.protobuf.p1$d r1 = com.fyber.inneractive.sdk.protobuf.p1.e
            r1.a((java.lang.Object) r14, (long) r8, (float) r0)
        L_0x01ec:
            int r17 = r4 + 4
            goto L_0x020d
        L_0x01ef:
            r13 = r19
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r33
            if (r3 != r5) goto L_0x0215
            long r0 = com.fyber.inneractive.sdk.protobuf.e.b(r12, r4)
            double r22 = java.lang.Double.longBitsToDouble(r0)
            com.fyber.inneractive.sdk.protobuf.p1$d r0 = com.fyber.inneractive.sdk.protobuf.p1.e
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r22
            r0.a((java.lang.Object) r1, (long) r2, (double) r4)
        L_0x020b:
            int r17 = r8 + 8
        L_0x020d:
            r6 = r6 | r21
            r28 = r10
            r2 = r13
            r0 = r17
            goto L_0x0267
        L_0x0215:
            r8 = r4
        L_0x0216:
            r2 = r8
            r28 = r10
            r20 = r13
            r18 = -1
            goto L_0x0313
        L_0x021f:
            r19 = r33
            r23 = r1
            r13 = r2
            r5 = r4
            r10 = r18
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r1 = 27
            if (r0 != r1) goto L_0x0278
            r1 = 2
            if (r3 != r1) goto L_0x026b
            java.lang.Object r0 = r10.getObject(r14, r8)
            com.fyber.inneractive.sdk.protobuf.y$j r0 = (com.fyber.inneractive.sdk.protobuf.y.j) r0
            boolean r1 = r0.d()
            if (r1 != 0) goto L_0x024f
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0246
            r1 = 10
            goto L_0x0248
        L_0x0246:
            int r1 = r1 * 2
        L_0x0248:
            com.fyber.inneractive.sdk.protobuf.y$j r0 = r0.b(r1)
            r10.putObject(r14, r8, r0)
        L_0x024f:
            r8 = r0
            com.fyber.inneractive.sdk.protobuf.d1 r0 = r15.c((int) r13)
            r1 = r17
            r2 = r32
            r3 = r5
            r4 = r34
            r5 = r8
            r8 = r6
            r6 = r35
            int r0 = com.fyber.inneractive.sdk.protobuf.e.a(r0, r1, r2, r3, r4, r5, r6)
            r6 = r8
            r28 = r10
            r2 = r13
        L_0x0267:
            r18 = -1
            goto L_0x0325
        L_0x026b:
            r15 = r5
            r24 = r6
            r25 = r7
            r28 = r10
            r20 = r13
            r18 = -1
            goto L_0x02d4
        L_0x0278:
            r1 = 49
            if (r0 > r1) goto L_0x02b6
            r1 = r23
            long r1 = (long) r1
            r4 = r0
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r33 = r3
            r3 = r5
            r23 = r4
            r4 = r34
            r15 = r5
            r5 = r17
            r24 = r6
            r6 = r19
            r25 = r7
            r7 = r33
            r26 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r13
            r28 = r10
            r18 = -1
            r9 = r21
            r11 = r23
            r20 = r13
            r12 = r26
            r14 = r35
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.fyber.inneractive.sdk.protobuf.e.b) r14)
            if (r0 == r15) goto L_0x0311
            goto L_0x030a
        L_0x02b6:
            r33 = r3
            r15 = r5
            r24 = r6
            r25 = r7
            r26 = r8
            r28 = r10
            r20 = r13
            r1 = r23
            r18 = -1
            r23 = r0
            r0 = 50
            r9 = r23
            if (r9 != r0) goto L_0x02ee
            r7 = r33
            r0 = 2
            if (r7 == r0) goto L_0x02da
        L_0x02d4:
            r2 = r15
        L_0x02d5:
            r6 = r24
            r7 = r25
            goto L_0x0313
        L_0x02da:
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r20
            r6 = r26
            r8 = r35
            r0.a(r1, r2, r3, r4, r5, r6, r8)
            r0 = 0
            throw r0
        L_0x02ee:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r19
            r10 = r26
            r12 = r20
            r13 = r35
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.fyber.inneractive.sdk.protobuf.e.b) r13)
            if (r0 == r15) goto L_0x0311
        L_0x030a:
            r2 = r20
            r6 = r24
            r7 = r25
            goto L_0x0325
        L_0x0311:
            r2 = r0
            goto L_0x02d5
        L_0x0313:
            com.fyber.inneractive.sdk.protobuf.l1 r4 = e((java.lang.Object) r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.fyber.inneractive.sdk.protobuf.e.a((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.fyber.inneractive.sdk.protobuf.l1) r4, (com.fyber.inneractive.sdk.protobuf.e.b) r5)
            r2 = r20
        L_0x0325:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r1 = r19
            r9 = r28
            r10 = -1
            goto L_0x001b
        L_0x0336:
            r24 = r6
            r28 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x0349
            long r1 = (long) r7
            r3 = r31
            r6 = r24
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x0349:
            r4 = r34
            if (r0 != r4) goto L_0x034e
            goto L_0x0365
        L_0x034e:
            com.fyber.inneractive.sdk.protobuf.z r0 = com.fyber.inneractive.sdk.protobuf.z.g()
            throw r0
        L_0x0353:
            r4 = r13
            r3 = r14
            r5 = 0
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r33
            r4 = r34
            r6 = r35
            r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.fyber.inneractive.sdk.protobuf.e.b) r6)
        L_0x0365:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.r0.a(java.lang.Object, byte[], int, int, com.fyber.inneractive.sdk.protobuf.e$b):void");
    }

    public final boolean a(T t) {
        int i2 = 1048575;
        int i3 = 0;
        for (int i4 = 0; i4 < this.k; i4++) {
            int i5 = this.j[i4];
            int i6 = this.a[i5];
            int g2 = g(i5);
            int i7 = this.a[i5 + 2];
            int i8 = i7 & 1048575;
            int i9 = 1 << (i7 >>> 20);
            if (i8 != i2) {
                if (i8 != 1048575) {
                    i3 = s.getInt(t, (long) i8);
                }
                i2 = i8;
            }
            if ((268435456 & g2) != 0) {
                if (i2 == 1048575) {
                    if (!a(t, i5)) {
                    }
                } else if ((i3 & i9) == 0) {
                }
                return false;
            }
            int f2 = f(g2);
            if (f2 == 9 || f2 == 17) {
                if (i2 == 1048575) {
                    if (!a(t, i5)) {
                        continue;
                    }
                } else if ((i9 & i3) == 0) {
                    continue;
                }
                if (!c(i5).a(p1.g(t, d(g2)))) {
                    return false;
                }
            } else {
                if (f2 != 27) {
                    if (f2 == 60 || f2 == 68) {
                        if (a(t, i6, i5) && !c(i5).a(p1.g(t, d(g2)))) {
                            return false;
                        }
                    } else if (f2 != 49) {
                        if (f2 == 50 && !this.q.a(p1.g(t, d(g2))).isEmpty()) {
                            this.q.f(this.b[(i5 / 3) * 2]);
                            throw null;
                        }
                    }
                }
                List list = (List) p1.g(t, d(g2));
                if (list.isEmpty()) {
                    continue;
                } else {
                    d1 c2 = c(i5);
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        if (!c2.a(list.get(i10))) {
                            return false;
                        }
                    }
                    continue;
                }
            }
        }
        return !this.f || this.p.a((Object) t).e();
    }

    public final void a(int i2, Object obj, s1 s1Var) throws IOException {
        if (obj instanceof String) {
            ((m) s1Var).a.b(i2, (String) obj);
            return;
        }
        ((m) s1Var).a.b(i2, (i) obj);
    }

    public final void a(Object obj, int i2, c1 c1Var) throws IOException {
        if ((536870912 & i2) != 0) {
            p1.a(obj, d(i2), (Object) c1Var.p());
        } else if (this.g) {
            p1.a(obj, d(i2), (Object) c1Var.n());
        } else {
            p1.a(obj, d(i2), (Object) c1Var.a());
        }
    }

    public final <E> void a(Object obj, int i2, c1 c1Var, d1<E> d1Var, q qVar) throws IOException {
        c1Var.b(this.n.b(obj, d(i2)), d1Var, qVar);
    }

    public final <E> void a(Object obj, long j2, c1 c1Var, d1<E> d1Var, q qVar) throws IOException {
        c1Var.a(this.n.b(obj, j2), d1Var, qVar);
    }

    public final <UT, UB> UB a(Object obj, int i2, UB ub, k1<UT, UB> k1Var) {
        y.e a2;
        int[] iArr = this.a;
        int i3 = iArr[i2];
        Object g2 = p1.g(obj, d(iArr[i2 + 1]));
        if (g2 == null || (a2 = a(i2)) == null) {
            return ub;
        }
        Map<?, ?> c2 = this.q.c(g2);
        this.q.f(this.b[(i2 / 3) * 2]);
        for (Map.Entry next : c2.entrySet()) {
            if (!a2.a(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    k1Var.a();
                }
                next.getKey();
                next.getValue();
                throw null;
            }
        }
        return ub;
    }

    public final <K, V> void a(Object obj, int i2, Object obj2, q qVar, c1 c1Var) throws IOException {
        long d2 = d(this.a[i2 + 1]);
        Object g2 = p1.g(obj, d2);
        if (g2 == null) {
            g2 = this.q.b(obj2);
            p1.a(obj, d2, g2);
        } else if (this.q.d(g2)) {
            Object b2 = this.q.b(obj2);
            this.q.a(b2, g2);
            p1.a(obj, d2, b2);
            g2 = b2;
        }
        Map<?, ?> c2 = this.q.c(g2);
        this.q.f(obj2);
        c1Var.a(c2, (h0.a) null, qVar);
    }

    public final void a(T t, T t2, int i2) {
        long d2 = d(this.a[i2 + 1]);
        if (a(t2, i2)) {
            Object g2 = p1.g(t, d2);
            Object g3 = p1.g(t2, d2);
            if (g2 != null && g3 != null) {
                p1.a((Object) t, d2, y.a(g2, g3));
                b(t, i2);
            } else if (g3 != null) {
                p1.a((Object) t, d2, g3);
                b(t, i2);
            }
        }
    }

    public final boolean a(T t, int i2) {
        int[] iArr = this.a;
        int i3 = iArr[i2 + 2];
        long j2 = (long) (1048575 & i3);
        if (j2 == 1048575) {
            int i4 = iArr[i2 + 1];
            long d2 = d(i4);
            switch (f(i4)) {
                case 0:
                    if (p1.e.c(t, d2) != 0.0d) {
                        return true;
                    }
                    return false;
                case 1:
                    if (p1.e.d(t, d2) != 0.0f) {
                        return true;
                    }
                    return false;
                case 2:
                    if (p1.f(t, d2) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (p1.f(t, d2) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (p1.e(t, d2) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (p1.f(t, d2) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (p1.e(t, d2) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return p1.e.a(t, d2);
                case 8:
                    Object g2 = p1.g(t, d2);
                    if (g2 instanceof String) {
                        return !((String) g2).isEmpty();
                    }
                    if (g2 instanceof i) {
                        return !i.b.equals(g2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (p1.g(t, d2) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    return !i.b.equals(p1.g(t, d2));
                case 11:
                    if (p1.e(t, d2) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (p1.e(t, d2) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (p1.e(t, d2) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (p1.f(t, d2) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (p1.e(t, d2) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (p1.f(t, d2) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (p1.g(t, d2) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            if ((p1.e(t, j2) & (1 << (i3 >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean a(T t, int i2, int i3) {
        return p1.e(t, (long) (this.a[i3 + 2] & 1048575)) == i2;
    }

    public static <T> boolean a(T t, long j2) {
        return ((Boolean) p1.g(t, j2)).booleanValue();
    }

    public final int a(int i2, int i3) {
        int length = (this.a.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.a[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }
}
