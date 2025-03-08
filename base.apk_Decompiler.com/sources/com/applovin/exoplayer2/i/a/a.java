package com.applovin.exoplayer2.i.a;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.work.impl.Scheduler;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.i.h;
import com.applovin.exoplayer2.i.j;
import com.applovin.exoplayer2.i.k;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a extends c {
    private static final int[] OG = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] OH = {0, 4, 8, 12, 16, 20, 24, 28};
    /* access modifiers changed from: private */
    public static final int[] OI = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -65281};
    private static final int[] OJ = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, IronSourceConstants.INTERSTITIAL_DAILY_CAPPED, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] OK = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] OL = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, Scheduler.MAX_GREEDY_SCHEDULER_LIMIT, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] OM = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] ON = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    private final y OO = new y();
    private final int OP;
    private final int OQ;
    private final int OR;
    private final long OS;
    private final ArrayList<C0051a> OT = new ArrayList<>();
    private C0051a OU = new C0051a(0, 4);
    private List<com.applovin.exoplayer2.i.a> OV;
    private List<com.applovin.exoplayer2.i.a> OW;
    private int OX;
    private int OY;
    private boolean OZ;
    private boolean Pa;
    private byte Pb;
    private byte Pc;
    private int Pd = 0;
    private boolean Pe;
    private long Pf;

    private static boolean d(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 48;
    }

    private static boolean e(byte b, byte b2) {
        return (b & 246) == 18 && (b2 & 224) == 32;
    }

    private static boolean g(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 32;
    }

    private static boolean h(byte b) {
        return (b & 224) == 0;
    }

    private static boolean h(byte b, byte b2) {
        return (b & 240) == 16 && (b2 & 192) == 64;
    }

    private static int i(byte b) {
        return (b >> 3) & 1;
    }

    private static boolean i(byte b, byte b2) {
        return (b & 247) == 23 && b2 >= 33 && b2 <= 35;
    }

    private static boolean j(byte b) {
        return (b & 240) == 16;
    }

    private static boolean j(byte b, byte b2) {
        return (b & 246) == 20 && (b2 & 240) == 32;
    }

    private static boolean k(byte b) {
        return 1 <= b && b <= 15;
    }

    private static boolean l(byte b) {
        return (b & 247) == 20;
    }

    /* access modifiers changed from: protected */
    public boolean mg() {
        return this.OV != this.OW;
    }

    public void release() {
    }

    public /* bridge */ /* synthetic */ void a(j jVar) throws h {
        super.D(jVar);
    }

    public /* bridge */ /* synthetic */ void bd(long j) {
        super.bd(j);
    }

    public /* bridge */ /* synthetic */ j lV() throws h {
        return super.hc();
    }

    public a(String str, int i, long j) {
        this.OS = j > 0 ? j * 1000 : -9223372036854775807L;
        this.OP = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i == 1) {
            this.OR = 0;
            this.OQ = 0;
        } else if (i == 2) {
            this.OR = 1;
            this.OQ = 0;
        } else if (i == 3) {
            this.OR = 0;
            this.OQ = 1;
        } else if (i != 4) {
            q.h("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.OR = 0;
            this.OQ = 0;
        } else {
            this.OR = 1;
            this.OQ = 1;
        }
        ek(0);
        mj();
        this.Pe = true;
        this.Pf = -9223372036854775807L;
    }

    public void dI() {
        super.dI();
        this.OV = null;
        this.OW = null;
        ek(0);
        el(4);
        mj();
        this.OZ = false;
        this.Pa = false;
        this.Pb = 0;
        this.Pc = 0;
        this.Pd = 0;
        this.Pe = true;
        this.Pf = -9223372036854775807L;
    }

    /* renamed from: lW */
    public k hd() throws h {
        k mA;
        k lW = super.hd();
        if (lW != null) {
            return lW;
        }
        if (!mk() || (mA = mA()) == null) {
            return null;
        }
        this.OV = Collections.emptyList();
        this.Pf = -9223372036854775807L;
        k kVar = mA;
        kVar.a(au(), mh(), Long.MAX_VALUE);
        return mA;
    }

    /* access modifiers changed from: protected */
    public f mh() {
        List<com.applovin.exoplayer2.i.a> list = this.OV;
        this.OW = list;
        return new d((List) com.applovin.exoplayer2.l.a.checkNotNull(list));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0017 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.applovin.exoplayer2.i.j r10) {
        /*
            r9 = this;
            java.nio.ByteBuffer r10 = r10.rH
            java.lang.Object r10 = com.applovin.exoplayer2.l.a.checkNotNull(r10)
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10
            com.applovin.exoplayer2.l.y r0 = r9.OO
            byte[] r1 = r10.array()
            int r10 = r10.limit()
            r0.l(r1, r10)
            r10 = 0
            r0 = 0
        L_0x0017:
            com.applovin.exoplayer2.l.y r1 = r9.OO
            int r1 = r1.pj()
            int r2 = r9.OP
            r3 = 1
            if (r1 < r2) goto L_0x00f6
            r1 = 2
            if (r2 != r1) goto L_0x0027
            r1 = -4
            goto L_0x002e
        L_0x0027:
            com.applovin.exoplayer2.l.y r1 = r9.OO
            int r1 = r1.po()
            byte r1 = (byte) r1
        L_0x002e:
            com.applovin.exoplayer2.l.y r2 = r9.OO
            int r2 = r2.po()
            com.applovin.exoplayer2.l.y r4 = r9.OO
            int r4 = r4.po()
            r5 = r1 & 2
            if (r5 == 0) goto L_0x003f
            goto L_0x0017
        L_0x003f:
            r5 = r1 & 1
            int r6 = r9.OQ
            if (r5 == r6) goto L_0x0046
            goto L_0x0017
        L_0x0046:
            r5 = r2 & 127(0x7f, float:1.78E-43)
            byte r5 = (byte) r5
            r6 = r4 & 127(0x7f, float:1.78E-43)
            byte r6 = (byte) r6
            if (r5 != 0) goto L_0x0051
            if (r6 != 0) goto L_0x0051
            goto L_0x0017
        L_0x0051:
            boolean r7 = r9.OZ
            r1 = r1 & 4
            r8 = 4
            if (r1 != r8) goto L_0x0064
            boolean[] r1 = ON
            boolean r2 = r1[r2]
            if (r2 == 0) goto L_0x0064
            boolean r1 = r1[r4]
            if (r1 == 0) goto L_0x0064
            r1 = 1
            goto L_0x0065
        L_0x0064:
            r1 = 0
        L_0x0065:
            r9.OZ = r1
            boolean r1 = r9.a(r1, r5, r6)
            if (r1 == 0) goto L_0x006e
            goto L_0x0017
        L_0x006e:
            boolean r1 = r9.OZ
            if (r1 != 0) goto L_0x0079
            if (r7 == 0) goto L_0x0017
            r9.mj()
        L_0x0077:
            r0 = 1
            goto L_0x0017
        L_0x0079:
            r9.c(r5, r6)
            boolean r1 = r9.Pe
            if (r1 != 0) goto L_0x0081
            goto L_0x0017
        L_0x0081:
            boolean r1 = r9.a((byte) r5)
            if (r1 != 0) goto L_0x0088
            goto L_0x0017
        L_0x0088:
            boolean r0 = h(r5)
            if (r0 == 0) goto L_0x00df
            boolean r0 = d(r5, r6)
            if (r0 == 0) goto L_0x009e
            com.applovin.exoplayer2.i.a.a$a r0 = r9.OU
            char r1 = e(r6)
            r0.a((char) r1)
            goto L_0x0077
        L_0x009e:
            boolean r0 = e(r5, r6)
            if (r0 == 0) goto L_0x00b3
            com.applovin.exoplayer2.i.a.a$a r0 = r9.OU
            r0.mm()
            com.applovin.exoplayer2.i.a.a$a r0 = r9.OU
            char r1 = f(r5, r6)
            r0.a((char) r1)
            goto L_0x0077
        L_0x00b3:
            boolean r0 = g(r5, r6)
            if (r0 == 0) goto L_0x00bd
            r9.b((byte) r6)
            goto L_0x0077
        L_0x00bd:
            boolean r0 = h(r5, r6)
            if (r0 == 0) goto L_0x00c7
            r9.b(r5, r6)
            goto L_0x0077
        L_0x00c7:
            boolean r0 = i(r5, r6)
            if (r0 == 0) goto L_0x00d5
            com.applovin.exoplayer2.i.a.a$a r0 = r9.OU
            int r6 = r6 + -32
            int unused = r0.Pl = r6
            goto L_0x0077
        L_0x00d5:
            boolean r0 = j(r5, r6)
            if (r0 == 0) goto L_0x0077
            r9.c(r6)
            goto L_0x0077
        L_0x00df:
            com.applovin.exoplayer2.i.a.a$a r0 = r9.OU
            char r1 = d(r5)
            r0.a((char) r1)
            r0 = r6 & 224(0xe0, float:3.14E-43)
            if (r0 == 0) goto L_0x0077
            com.applovin.exoplayer2.i.a.a$a r0 = r9.OU
            char r1 = d(r6)
            r0.a((char) r1)
            goto L_0x0077
        L_0x00f6:
            if (r0 == 0) goto L_0x010b
            int r10 = r9.OX
            if (r10 == r3) goto L_0x00ff
            r0 = 3
            if (r10 != r0) goto L_0x010b
        L_0x00ff:
            java.util.List r10 = r9.mi()
            r9.OV = r10
            long r0 = r9.au()
            r9.Pf = r0
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.a.a.b(com.applovin.exoplayer2.i.j):void");
    }

    private boolean a(byte b) {
        if (h(b)) {
            this.Pd = i(b);
        }
        return this.Pd == this.OR;
    }

    private boolean a(boolean z, byte b, byte b2) {
        if (!z || !j(b)) {
            this.Pa = false;
        } else if (this.Pa && this.Pb == b && this.Pc == b2) {
            this.Pa = false;
            return true;
        } else {
            this.Pa = true;
            this.Pb = b;
            this.Pc = b2;
        }
        return false;
    }

    private void b(byte b) {
        this.OU.a(' ');
        this.OU.m((b >> 1) & 7, (b & 1) == 1);
    }

    private void b(byte b, byte b2) {
        int i = OG[b & 7];
        if ((b2 & 32) != 0) {
            i++;
        }
        if (i != this.OU.Pj) {
            if (this.OX != 1 && !this.OU.isEmpty()) {
                C0051a aVar = new C0051a(this.OX, this.OY);
                this.OU = aVar;
                this.OT.add(aVar);
            }
            int unused = this.OU.Pj = i;
        }
        boolean z = false;
        boolean z2 = (b2 & Ascii.DLE) == 16;
        if ((b2 & 1) == 1) {
            z = true;
        }
        int i2 = (b2 >> 1) & 7;
        this.OU.m(z2 ? 8 : i2, z);
        if (z2) {
            int unused2 = this.OU.Pk = OH[i2];
        }
    }

    private void c(byte b) {
        if (b == 32) {
            ek(2);
        } else if (b != 41) {
            switch (b) {
                case 37:
                    ek(1);
                    el(2);
                    return;
                case 38:
                    ek(1);
                    el(3);
                    return;
                case 39:
                    ek(1);
                    el(4);
                    return;
                default:
                    int i = this.OX;
                    if (i != 0) {
                        if (b != 33) {
                            switch (b) {
                                case 44:
                                    this.OV = Collections.emptyList();
                                    int i2 = this.OX;
                                    if (i2 == 1 || i2 == 3) {
                                        mj();
                                        return;
                                    }
                                    return;
                                case 45:
                                    if (i == 1 && !this.OU.isEmpty()) {
                                        this.OU.mn();
                                        return;
                                    }
                                    return;
                                case 46:
                                    mj();
                                    return;
                                case 47:
                                    this.OV = mi();
                                    mj();
                                    return;
                                default:
                                    return;
                            }
                        } else {
                            this.OU.mm();
                            return;
                        }
                    } else {
                        return;
                    }
            }
        } else {
            ek(3);
        }
    }

    private List<com.applovin.exoplayer2.i.a> mi() {
        int size = this.OT.size();
        ArrayList arrayList = new ArrayList(size);
        int i = 2;
        for (int i2 = 0; i2 < size; i2++) {
            com.applovin.exoplayer2.i.a em = this.OT.get(i2).em(Integer.MIN_VALUE);
            arrayList.add(em);
            if (em != null) {
                i = Math.min(i, em.Oe);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            com.applovin.exoplayer2.i.a aVar = (com.applovin.exoplayer2.i.a) arrayList.get(i3);
            if (aVar != null) {
                if (aVar.Oe != i) {
                    aVar = (com.applovin.exoplayer2.i.a) com.applovin.exoplayer2.l.a.checkNotNull(this.OT.get(i3).em(i));
                }
                arrayList2.add(aVar);
            }
        }
        return arrayList2;
    }

    private void ek(int i) {
        int i2 = this.OX;
        if (i2 != i) {
            this.OX = i;
            if (i == 3) {
                for (int i3 = 0; i3 < this.OT.size(); i3++) {
                    this.OT.get(i3).ek(i);
                }
                return;
            }
            mj();
            if (i2 == 3 || i == 1 || i == 0) {
                this.OV = Collections.emptyList();
            }
        }
    }

    private void el(int i) {
        this.OY = i;
        this.OU.el(i);
    }

    private void mj() {
        this.OU.U(this.OX);
        this.OT.clear();
        this.OT.add(this.OU);
    }

    private void c(byte b, byte b2) {
        if (k(b)) {
            this.Pe = false;
        } else if (l(b)) {
            if (!(b2 == 32 || b2 == 47)) {
                switch (b2) {
                    case 37:
                    case 38:
                    case 39:
                        break;
                    default:
                        switch (b2) {
                            case 41:
                                break;
                            case 42:
                            case 43:
                                this.Pe = false;
                                return;
                            default:
                                return;
                        }
                }
            }
            this.Pe = true;
        }
    }

    private static char d(byte b) {
        return (char) OJ[(b & Byte.MAX_VALUE) - 32];
    }

    private static char e(byte b) {
        return (char) OK[b & Ascii.SI];
    }

    private static char f(byte b, byte b2) {
        if ((b & 1) == 0) {
            return f(b2);
        }
        return g(b2);
    }

    private static char f(byte b) {
        return (char) OL[b & Ascii.US];
    }

    private static char g(byte b) {
        return (char) OM[b & Ascii.US];
    }

    /* renamed from: com.applovin.exoplayer2.i.a.a$a  reason: collision with other inner class name */
    private static final class C0051a {
        private int OX;
        private int OY;
        private final List<C0052a> Pg = new ArrayList();
        private final List<SpannableString> Ph = new ArrayList();
        private final StringBuilder Pi = new StringBuilder();
        /* access modifiers changed from: private */
        public int Pj;
        /* access modifiers changed from: private */
        public int Pk;
        /* access modifiers changed from: private */
        public int Pl;

        public void ek(int i) {
            this.OX = i;
        }

        public void el(int i) {
            this.OY = i;
        }

        public C0051a(int i, int i2) {
            U(i);
            this.OY = i2;
        }

        public void U(int i) {
            this.OX = i;
            this.Pg.clear();
            this.Ph.clear();
            this.Pi.setLength(0);
            this.Pj = 15;
            this.Pk = 0;
            this.Pl = 0;
        }

        public boolean isEmpty() {
            return this.Pg.isEmpty() && this.Ph.isEmpty() && this.Pi.length() == 0;
        }

        public void m(int i, boolean z) {
            this.Pg.add(new C0052a(i, z, this.Pi.length()));
        }

        public void mm() {
            int length = this.Pi.length();
            if (length > 0) {
                this.Pi.delete(length - 1, length);
                int size = this.Pg.size() - 1;
                while (size >= 0) {
                    C0052a aVar = this.Pg.get(size);
                    if (aVar.start == length) {
                        aVar.start--;
                        size--;
                    } else {
                        return;
                    }
                }
            }
        }

        public void a(char c) {
            if (this.Pi.length() < 32) {
                this.Pi.append(c);
            }
        }

        public void mn() {
            this.Ph.add(mo());
            this.Pi.setLength(0);
            this.Pg.clear();
            int min = Math.min(this.OY, this.Pj);
            while (this.Ph.size() >= min) {
                this.Ph.remove(0);
            }
        }

        public com.applovin.exoplayer2.i.a em(int i) {
            float f;
            int i2 = this.Pk + this.Pl;
            int i3 = 32 - i2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.Ph.size(); i4++) {
                spannableStringBuilder.append(ai.a((CharSequence) this.Ph.get(i4), i3));
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(ai.a((CharSequence) mo(), i3));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i3 - spannableStringBuilder.length();
            int i5 = i2 - length;
            if (i == Integer.MIN_VALUE) {
                i = (this.OX != 2 || (Math.abs(i5) >= 3 && length >= 0)) ? (this.OX != 2 || i5 <= 0) ? 0 : 2 : 1;
            }
            if (i != 1) {
                if (i == 2) {
                    i2 = 32 - length;
                }
                f = ((((float) i2) / 32.0f) * 0.8f) + 0.1f;
            } else {
                f = 0.5f;
            }
            int i6 = this.Pj;
            if (i6 > 7) {
                i6 -= 17;
            } else if (this.OX == 1) {
                i6 -= this.OY - 1;
            }
            return new a.C0050a().m(spannableStringBuilder).a(Layout.Alignment.ALIGN_NORMAL).b((float) i6, 1).o(f).eg(i).lU();
        }

        private SpannableString mo() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.Pi);
            int length = spannableStringBuilder.length();
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            boolean z = false;
            while (i < this.Pg.size()) {
                C0052a aVar = this.Pg.get(i);
                boolean z2 = aVar.Pn;
                int i7 = aVar.Pm;
                if (i7 != 8) {
                    boolean z3 = i7 == 7;
                    if (i7 != 7) {
                        i6 = a.OI[i7];
                    }
                    z = z3;
                }
                int i8 = aVar.start;
                i++;
                if (i8 != (i < this.Pg.size() ? this.Pg.get(i).start : length)) {
                    if (i2 != -1 && !z2) {
                        a(spannableStringBuilder, i2, i8);
                        i2 = -1;
                    } else if (i2 == -1 && z2) {
                        i2 = i8;
                    }
                    if (i3 != -1 && !z) {
                        b(spannableStringBuilder, i3, i8);
                        i3 = -1;
                    } else if (i3 == -1 && z) {
                        i3 = i8;
                    }
                    if (i6 != i5) {
                        a(spannableStringBuilder, i4, i8, i5);
                        i5 = i6;
                        i4 = i8;
                    }
                }
            }
            if (!(i2 == -1 || i2 == length)) {
                a(spannableStringBuilder, i2, length);
            }
            if (!(i3 == -1 || i3 == length)) {
                b(spannableStringBuilder, i3, length);
            }
            if (i4 != length) {
                a(spannableStringBuilder, i4, length, i5);
            }
            return new SpannableString(spannableStringBuilder);
        }

        private static void a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }

        private static void b(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i, i2, 33);
        }

        private static void a(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3) {
            if (i3 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
            }
        }

        /* renamed from: com.applovin.exoplayer2.i.a.a$a$a  reason: collision with other inner class name */
        private static class C0052a {
            public final int Pm;
            public final boolean Pn;
            public int start;

            public C0052a(int i, boolean z, int i2) {
                this.Pm = i;
                this.Pn = z;
                this.start = i2;
            }
        }
    }

    private boolean mk() {
        return (this.OS == -9223372036854775807L || this.Pf == -9223372036854775807L || au() - this.Pf < this.OS) ? false : true;
    }
}
