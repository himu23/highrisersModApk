package com.ironsource;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b!\b\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003JI\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0005\u0010\u0019R\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u0003\u0010\u001dR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u0003\u0010\u0019R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\u0003\u0010\"R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010#\u001a\u0004\b$\u0010%\"\u0004\b\u0005\u0010&R$\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010#\u001a\u0004\b'\u0010%\"\u0004\b\u0003\u0010&¨\u0006*"}, d2 = {"Lcom/ironsource/ea;", "", "", "a", "", "b", "c", "", "d", "", "e", "f", "pixelEventsEnabled", "pixelEventsUrl", "pixelEventsCompression", "pixelEventsCompressionLevel", "pixelOptOut", "pixelOptIn", "toString", "hashCode", "other", "equals", "Z", "i", "()Z", "(Z)V", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "g", "I", "h", "()I", "(I)V", "[I", "l", "()[I", "([I)V", "k", "<init>", "(ZLjava/lang/String;ZI[I[I)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class ea {
    private boolean a;
    private String b;
    private boolean c;
    private int d;
    private int[] e;
    private int[] f;

    public ea() {
        this(false, (String) null, false, 0, (int[]) null, (int[]) null, 63, (DefaultConstructorMarker) null);
    }

    public ea(boolean z, String str, boolean z2, int i, int[] iArr, int[] iArr2) {
        Intrinsics.checkNotNullParameter(str, "pixelEventsUrl");
        this.a = z;
        this.b = str;
        this.c = z2;
        this.d = i;
        this.e = iArr;
        this.f = iArr2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ea(boolean r5, java.lang.String r6, boolean r7, int r8, int[] r9, int[] r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0005
            r5 = 1
        L_0x0005:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x000b
            java.lang.String r6 = "https://outcome-ssp.supersonicads.com/mediation?adUnit=3"
        L_0x000b:
            r12 = r6
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0013
            r7 = 0
            r0 = 0
            goto L_0x0014
        L_0x0013:
            r0 = r7
        L_0x0014:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001b
            r8 = -1
            r1 = -1
            goto L_0x001c
        L_0x001b:
            r1 = r8
        L_0x001c:
            r6 = r11 & 16
            r7 = 0
            if (r6 == 0) goto L_0x0023
            r2 = r7
            goto L_0x0024
        L_0x0023:
            r2 = r9
        L_0x0024:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x002a
            r3 = r7
            goto L_0x002b
        L_0x002a:
            r3 = r10
        L_0x002b:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.ea.<init>(boolean, java.lang.String, boolean, int, int[], int[], int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ ea a(ea eaVar, boolean z, String str, boolean z2, int i, int[] iArr, int[] iArr2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = eaVar.a;
        }
        if ((i2 & 2) != 0) {
            str = eaVar.b;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            z2 = eaVar.c;
        }
        boolean z3 = z2;
        if ((i2 & 8) != 0) {
            i = eaVar.d;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            iArr = eaVar.e;
        }
        int[] iArr3 = iArr;
        if ((i2 & 32) != 0) {
            iArr2 = eaVar.f;
        }
        return eaVar.a(z, str2, z3, i3, iArr3, iArr2);
    }

    public final ea a(boolean z, String str, boolean z2, int i, int[] iArr, int[] iArr2) {
        Intrinsics.checkNotNullParameter(str, "pixelEventsUrl");
        return new ea(z, str, z2, i, iArr, iArr2);
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final void a(int[] iArr) {
        this.f = iArr;
    }

    public final boolean a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final void b(boolean z) {
        this.a = z;
    }

    public final void b(int[] iArr) {
        this.e = iArr;
    }

    public final boolean c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final int[] e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ea)) {
            return false;
        }
        ea eaVar = (ea) obj;
        return this.a == eaVar.a && Intrinsics.areEqual((Object) this.b, (Object) eaVar.b) && this.c == eaVar.c && this.d == eaVar.d && Intrinsics.areEqual((Object) this.e, (Object) eaVar.e) && Intrinsics.areEqual((Object) this.f, (Object) eaVar.f);
    }

    public final int[] f() {
        return this.f;
    }

    public final boolean g() {
        return this.c;
    }

    public final int h() {
        return this.d;
    }

    public int hashCode() {
        boolean z = this.a;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode = (((z ? 1 : 0) * true) + this.b.hashCode()) * 31;
        boolean z3 = this.c;
        if (!z3) {
            z2 = z3;
        }
        int i = (((hashCode + (z2 ? 1 : 0)) * 31) + this.d) * 31;
        int[] iArr = this.e;
        int i2 = 0;
        int hashCode2 = (i + (iArr == null ? 0 : Arrays.hashCode(iArr))) * 31;
        int[] iArr2 = this.f;
        if (iArr2 != null) {
            i2 = Arrays.hashCode(iArr2);
        }
        return hashCode2 + i2;
    }

    public final boolean i() {
        return this.a;
    }

    public final String j() {
        return this.b;
    }

    public final int[] k() {
        return this.f;
    }

    public final int[] l() {
        return this.e;
    }

    public String toString() {
        return "PixelSettings(pixelEventsEnabled=" + this.a + ", pixelEventsUrl=" + this.b + ", pixelEventsCompression=" + this.c + ", pixelEventsCompressionLevel=" + this.d + ", pixelOptOut=" + Arrays.toString(this.e) + ", pixelOptIn=" + Arrays.toString(this.f) + ')';
    }
}
