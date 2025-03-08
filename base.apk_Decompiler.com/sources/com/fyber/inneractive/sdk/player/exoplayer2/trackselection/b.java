package com.fyber.inneractive.sdk.player.exoplayer2.trackselection;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

public class b extends d {
    public static final int[] e = new int[0];
    public final e.a c = null;
    public final AtomicReference<C0127b> d = new AtomicReference<>(new C0127b());

    /* renamed from: com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b$b  reason: collision with other inner class name */
    public static final class C0127b {
        public final String a;
        public final String b;
        public final boolean c;
        public final boolean d;
        public final int e;
        public final int f;
        public final int g;
        public final boolean h;
        public final boolean i;
        public final int j;
        public final int k;
        public final boolean l;

        public C0127b() {
            this((String) null, (String) null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0127b.class != obj.getClass()) {
                return false;
            }
            C0127b bVar = (C0127b) obj;
            if (this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f && this.h == bVar.h && this.i == bVar.i && this.l == bVar.l && this.j == bVar.j && this.k == bVar.k && this.g == bVar.g && TextUtils.equals(this.a, bVar.a) && TextUtils.equals(this.b, bVar.b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.l ? 1 : 0)) * 31) + this.j) * 31) + this.k;
        }

        public C0127b(String str, String str2, boolean z, boolean z2, int i2, int i3, int i4, boolean z3, boolean z4, int i5, int i6, boolean z5) {
            this.a = null;
            this.b = null;
            this.c = z;
            this.d = z2;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.h = z3;
            this.i = z4;
            this.j = i5;
            this.k = i6;
            this.l = z5;
        }
    }

    public b(e.a aVar) {
    }

    public static int a(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    public static boolean a(int i, boolean z) {
        int i2 = i & 3;
        return i2 == 3 || (z && i2 == 2);
    }

    public static boolean a(i iVar, String str, int i, int i2, int i3, int i4, int i5) {
        if (!a(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !u.a((Object) iVar.f, (Object) str)) {
            return false;
        }
        int i6 = iVar.j;
        if (i6 != -1 && i6 > i3) {
            return false;
        }
        int i7 = iVar.k;
        if (i7 != -1 && i7 > i4) {
            return false;
        }
        int i8 = iVar.b;
        if (i8 == -1 || i8 <= i5) {
            return true;
        }
        return false;
    }

    public static final class a {
        public final int a;
        public final int b;
        public final String c;

        public a(int i, int i2, String str) {
            this.a = i;
            this.b = i2;
            this.c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a == aVar.a && this.b == aVar.b && TextUtils.equals(this.c, aVar.c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = ((this.a * 31) + this.b) * 31;
            String str = this.c;
            return i + (str != null ? str.hashCode() : 0);
        }
    }

    public static boolean a(i iVar, int i, a aVar) {
        if (!a(i, false) || iVar.r != aVar.a || iVar.s != aVar.b) {
            return false;
        }
        String str = aVar.c;
        if (str == null || TextUtils.equals(str, iVar.f)) {
            return true;
        }
        return false;
    }

    public static boolean a(i iVar, String str) {
        String str2;
        if (str != null) {
            String str3 = iVar.y;
            int i = u.a;
            if (str3 == null) {
                str2 = null;
            } else {
                str2 = new Locale(str3).getLanguage();
            }
            if (TextUtils.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.Integer> a(com.fyber.inneractive.sdk.player.exoplayer2.source.r r12, int r13, int r14, boolean r15) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r12.a
            r0.<init>(r1)
            r1 = 0
            r2 = 0
        L_0x0009:
            int r3 = r12.a
            if (r2 >= r3) goto L_0x0017
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r0.add(r3)
            int r2 = r2 + 1
            goto L_0x0009
        L_0x0017:
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r13 == r2) goto L_0x00a6
            if (r14 != r2) goto L_0x0020
            goto L_0x00a6
        L_0x0020:
            r3 = 0
            r4 = 2147483647(0x7fffffff, float:NaN)
        L_0x0024:
            int r5 = r12.a
            r6 = 1
            if (r3 >= r5) goto L_0x0080
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r5 = r12.b
            r5 = r5[r3]
            int r7 = r5.j
            if (r7 <= 0) goto L_0x007d
            int r8 = r5.k
            if (r8 <= 0) goto L_0x007d
            if (r15 == 0) goto L_0x0045
            if (r7 <= r8) goto L_0x003b
            r9 = 1
            goto L_0x003c
        L_0x003b:
            r9 = 0
        L_0x003c:
            if (r13 <= r14) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r6 = 0
        L_0x0040:
            if (r9 == r6) goto L_0x0045
            r6 = r13
            r9 = r14
            goto L_0x0047
        L_0x0045:
            r9 = r13
            r6 = r14
        L_0x0047:
            int r10 = r7 * r6
            int r11 = r8 * r9
            if (r10 < r11) goto L_0x0057
            android.graphics.Point r6 = new android.graphics.Point
            int r7 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((int) r11, (int) r7)
            r6.<init>(r9, r7)
            goto L_0x0061
        L_0x0057:
            android.graphics.Point r7 = new android.graphics.Point
            int r8 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((int) r10, (int) r8)
            r7.<init>(r8, r6)
            r6 = r7
        L_0x0061:
            int r7 = r5.j
            int r5 = r5.k
            int r8 = r7 * r5
            int r9 = r6.x
            float r9 = (float) r9
            r10 = 1065017672(0x3f7ae148, float:0.98)
            float r9 = r9 * r10
            int r9 = (int) r9
            if (r7 < r9) goto L_0x007d
            int r6 = r6.y
            float r6 = (float) r6
            float r6 = r6 * r10
            int r6 = (int) r6
            if (r5 < r6) goto L_0x007d
            if (r8 >= r4) goto L_0x007d
            r4 = r8
        L_0x007d:
            int r3 = r3 + 1
            goto L_0x0024
        L_0x0080:
            if (r4 == r2) goto L_0x00a6
            int r13 = r0.size()
            int r13 = r13 - r6
        L_0x0087:
            if (r13 < 0) goto L_0x00a6
            java.lang.Object r14 = r0.get(r13)
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r15 = r12.b
            r14 = r15[r14]
            int r14 = r14.b()
            r15 = -1
            if (r14 == r15) goto L_0x00a0
            if (r14 <= r4) goto L_0x00a3
        L_0x00a0:
            r0.remove(r13)
        L_0x00a3:
            int r13 = r13 + -1
            goto L_0x0087
        L_0x00a6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(com.fyber.inneractive.sdk.player.exoplayer2.source.r, int, int, boolean):java.util.List");
    }
}
