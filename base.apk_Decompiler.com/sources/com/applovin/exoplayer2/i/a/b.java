package com.applovin.exoplayer2.i.a;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.i.h;
import com.applovin.exoplayer2.i.j;
import com.applovin.exoplayer2.i.k;
import com.applovin.exoplayer2.l.e;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.x;
import com.applovin.exoplayer2.l.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.text.Typography;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public final class b extends c {
    private final y OO = new y();
    private List<com.applovin.exoplayer2.i.a> OV;
    private List<com.applovin.exoplayer2.i.a> OW;
    private final x Po = new x();
    private int Pp = -1;
    private final boolean Pq;
    private final int Pr;
    private final C0053b[] Ps;
    private C0053b Pt;
    private c Pu;
    private int Pv;

    /* access modifiers changed from: protected */
    public boolean mg() {
        return this.OV != this.OW;
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

    public /* bridge */ /* synthetic */ k lW() throws h {
        return super.hd();
    }

    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public b(int i, List<byte[]> list) {
        boolean z = true;
        this.Pr = i == -1 ? 1 : i;
        this.Pq = (list == null || !e.m(list)) ? false : z;
        this.Ps = new C0053b[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.Ps[i2] = new C0053b();
        }
        this.Pt = this.Ps[0];
    }

    public void dI() {
        super.dI();
        this.OV = null;
        this.OW = null;
        this.Pv = 0;
        this.Pt = this.Ps[0];
        mj();
        this.Pu = null;
    }

    /* access modifiers changed from: protected */
    public f mh() {
        List<com.applovin.exoplayer2.i.a> list = this.OV;
        this.OW = list;
        return new d((List) com.applovin.exoplayer2.l.a.checkNotNull(list));
    }

    /* access modifiers changed from: protected */
    public void b(j jVar) {
        ByteBuffer byteBuffer = (ByteBuffer) com.applovin.exoplayer2.l.a.checkNotNull(jVar.rH);
        this.OO.l(byteBuffer.array(), byteBuffer.limit());
        while (this.OO.pj() >= 3) {
            int po = this.OO.po();
            int i = po & 3;
            boolean z = false;
            boolean z2 = (po & 4) == 4;
            byte po2 = (byte) this.OO.po();
            byte po3 = (byte) this.OO.po();
            if ((i == 2 || i == 3) && z2) {
                if (i == 3) {
                    mp();
                    int i2 = (po2 & 192) >> 6;
                    int i3 = this.Pp;
                    if (!(i3 == -1 || i2 == (i3 + 1) % 4)) {
                        mj();
                        q.h("Cea708Decoder", "Sequence number discontinuity. previous=" + this.Pp + " current=" + i2);
                    }
                    this.Pp = i2;
                    byte b = po2 & 63;
                    if (b == 0) {
                        b = 64;
                    }
                    c cVar = new c(i2, b);
                    this.Pu = cVar;
                    byte[] bArr = cVar.Qf;
                    c cVar2 = this.Pu;
                    int i4 = cVar2.pS;
                    cVar2.pS = i4 + 1;
                    bArr[i4] = po3;
                } else {
                    if (i == 2) {
                        z = true;
                    }
                    com.applovin.exoplayer2.l.a.checkArgument(z);
                    c cVar3 = this.Pu;
                    if (cVar3 == null) {
                        q.i("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                    } else {
                        byte[] bArr2 = cVar3.Qf;
                        c cVar4 = this.Pu;
                        int i5 = cVar4.pS;
                        cVar4.pS = i5 + 1;
                        bArr2[i5] = po2;
                        byte[] bArr3 = this.Pu.Qf;
                        c cVar5 = this.Pu;
                        int i6 = cVar5.pS;
                        cVar5.pS = i6 + 1;
                        bArr3[i6] = po3;
                    }
                }
                if (this.Pu.pS == (this.Pu.Qe * 2) - 1) {
                    mp();
                }
            }
        }
    }

    private void mp() {
        if (this.Pu != null) {
            mq();
            this.Pu = null;
        }
    }

    private void mq() {
        if (this.Pu.pS != (this.Pu.Qe * 2) - 1) {
            q.f("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.Pu.Qe * 2) - 1) + ", but current index is " + this.Pu.pS + " (sequence number " + this.Pu.Qd + ");");
        }
        this.Po.l(this.Pu.Qf, this.Pu.pS);
        int bQ = this.Po.bQ(3);
        int bQ2 = this.Po.bQ(5);
        if (bQ == 7) {
            this.Po.bR(2);
            bQ = this.Po.bQ(6);
            if (bQ < 7) {
                q.h("Cea708Decoder", "Invalid extended service number: " + bQ);
            }
        }
        if (bQ2 == 0) {
            if (bQ != 0) {
                q.h("Cea708Decoder", "serviceNumber is non-zero (" + bQ + ") when blockSize is 0");
            }
        } else if (bQ == this.Pr) {
            boolean z = false;
            while (this.Po.pf() > 0) {
                int bQ3 = this.Po.bQ(8);
                if (bQ3 == 16) {
                    int bQ4 = this.Po.bQ(8);
                    if (bQ4 <= 31) {
                        ep(bQ4);
                    } else if (bQ4 <= 127) {
                        et(bQ4);
                    } else if (bQ4 <= 159) {
                        eq(bQ4);
                    } else if (bQ4 <= 255) {
                        eu(bQ4);
                    } else {
                        q.h("Cea708Decoder", "Invalid extended command: " + bQ4);
                    }
                } else if (bQ3 <= 31) {
                    en(bQ3);
                } else if (bQ3 <= 127) {
                    er(bQ3);
                } else if (bQ3 <= 159) {
                    eo(bQ3);
                } else if (bQ3 <= 255) {
                    es(bQ3);
                } else {
                    q.h("Cea708Decoder", "Invalid base command: " + bQ3);
                }
                z = true;
            }
            if (z) {
                this.OV = mi();
            }
        }
    }

    private void en(int i) {
        if (i == 0) {
            return;
        }
        if (i == 3) {
            this.OV = mi();
        } else if (i != 8) {
            switch (i) {
                case 12:
                    mj();
                    return;
                case 13:
                    this.Pt.a(10);
                    return;
                case 14:
                    return;
                default:
                    if (i >= 17 && i <= 23) {
                        q.h("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i);
                        this.Po.bR(8);
                        return;
                    } else if (i < 24 || i > 31) {
                        q.h("Cea708Decoder", "Invalid C0 command: " + i);
                        return;
                    } else {
                        q.h("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i);
                        this.Po.bR(16);
                        return;
                    }
            }
        } else {
            this.Pt.mm();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0090, code lost:
        if (r2 > 8) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0098, code lost:
        if (r4.Po.ik() == false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009a, code lost:
        r4.Ps[8 - r2].Y();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a3, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c2, code lost:
        if (r2 > 8) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ca, code lost:
        if (r4.Po.ik() == false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cc, code lost:
        r4.Ps[8 - r2].R(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d6, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f0, code lost:
        if (r2 > 8) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f8, code lost:
        if (r4.Po.ik() == false) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fa, code lost:
        r4.Ps[8 - r2].clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0103, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void eo(int r5) {
        /*
            r4 = this;
            r0 = 16
            r1 = 8
            r2 = 1
            switch(r5) {
                case 128: goto L_0x0106;
                case 129: goto L_0x0106;
                case 130: goto L_0x0106;
                case 131: goto L_0x0106;
                case 132: goto L_0x0106;
                case 133: goto L_0x0106;
                case 134: goto L_0x0106;
                case 135: goto L_0x0106;
                case 136: goto L_0x00f0;
                case 137: goto L_0x00d9;
                case 138: goto L_0x00c2;
                case 139: goto L_0x00a6;
                case 140: goto L_0x0090;
                case 141: goto L_0x0089;
                case 142: goto L_0x0114;
                case 143: goto L_0x0084;
                case 144: goto L_0x0070;
                case 145: goto L_0x005a;
                case 146: goto L_0x0046;
                case 147: goto L_0x0008;
                case 148: goto L_0x0008;
                case 149: goto L_0x0008;
                case 150: goto L_0x0008;
                case 151: goto L_0x0030;
                case 152: goto L_0x001d;
                case 153: goto L_0x001d;
                case 154: goto L_0x001d;
                case 155: goto L_0x001d;
                case 156: goto L_0x001d;
                case 157: goto L_0x001d;
                case 158: goto L_0x001d;
                case 159: goto L_0x001d;
                default: goto L_0x0008;
            }
        L_0x0008:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Invalid C1 command: "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "Cea708Decoder"
            com.applovin.exoplayer2.l.q.h(r0, r5)
            goto L_0x0114
        L_0x001d:
            int r5 = r5 + -152
            r4.ev(r5)
            int r0 = r4.Pv
            if (r0 == r5) goto L_0x0114
            r4.Pv = r5
            com.applovin.exoplayer2.i.a.b$b[] r0 = r4.Ps
            r5 = r0[r5]
            r4.Pt = r5
            goto L_0x0114
        L_0x0030:
            com.applovin.exoplayer2.i.a.b$b r5 = r4.Pt
            boolean r5 = r5.mw()
            if (r5 != 0) goto L_0x0041
            com.applovin.exoplayer2.l.x r5 = r4.Po
            r0 = 32
            r5.bR(r0)
            goto L_0x0114
        L_0x0041:
            r4.mu()
            goto L_0x0114
        L_0x0046:
            com.applovin.exoplayer2.i.a.b$b r5 = r4.Pt
            boolean r5 = r5.mw()
            if (r5 != 0) goto L_0x0055
            com.applovin.exoplayer2.l.x r5 = r4.Po
            r5.bR(r0)
            goto L_0x0114
        L_0x0055:
            r4.mt()
            goto L_0x0114
        L_0x005a:
            com.applovin.exoplayer2.i.a.b$b r5 = r4.Pt
            boolean r5 = r5.mw()
            if (r5 != 0) goto L_0x006b
            com.applovin.exoplayer2.l.x r5 = r4.Po
            r0 = 24
            r5.bR(r0)
            goto L_0x0114
        L_0x006b:
            r4.ms()
            goto L_0x0114
        L_0x0070:
            com.applovin.exoplayer2.i.a.b$b r5 = r4.Pt
            boolean r5 = r5.mw()
            if (r5 != 0) goto L_0x007f
            com.applovin.exoplayer2.l.x r5 = r4.Po
            r5.bR(r0)
            goto L_0x0114
        L_0x007f:
            r4.mr()
            goto L_0x0114
        L_0x0084:
            r4.mj()
            goto L_0x0114
        L_0x0089:
            com.applovin.exoplayer2.l.x r5 = r4.Po
            r5.bR(r1)
            goto L_0x0114
        L_0x0090:
            if (r2 > r1) goto L_0x0114
            com.applovin.exoplayer2.l.x r5 = r4.Po
            boolean r5 = r5.ik()
            if (r5 == 0) goto L_0x00a3
            com.applovin.exoplayer2.i.a.b$b[] r5 = r4.Ps
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.Y()
        L_0x00a3:
            int r2 = r2 + 1
            goto L_0x0090
        L_0x00a6:
            r5 = 1
        L_0x00a7:
            if (r5 > r1) goto L_0x0114
            com.applovin.exoplayer2.l.x r0 = r4.Po
            boolean r0 = r0.ik()
            if (r0 == 0) goto L_0x00bf
            com.applovin.exoplayer2.i.a.b$b[] r0 = r4.Ps
            int r3 = 8 - r5
            r0 = r0[r3]
            boolean r3 = r0.mx()
            r3 = r3 ^ r2
            r0.R(r3)
        L_0x00bf:
            int r5 = r5 + 1
            goto L_0x00a7
        L_0x00c2:
            if (r2 > r1) goto L_0x0114
            com.applovin.exoplayer2.l.x r5 = r4.Po
            boolean r5 = r5.ik()
            if (r5 == 0) goto L_0x00d6
            com.applovin.exoplayer2.i.a.b$b[] r5 = r4.Ps
            int r0 = 8 - r2
            r5 = r5[r0]
            r0 = 0
            r5.R(r0)
        L_0x00d6:
            int r2 = r2 + 1
            goto L_0x00c2
        L_0x00d9:
            r5 = 1
        L_0x00da:
            if (r5 > r1) goto L_0x0114
            com.applovin.exoplayer2.l.x r0 = r4.Po
            boolean r0 = r0.ik()
            if (r0 == 0) goto L_0x00ed
            com.applovin.exoplayer2.i.a.b$b[] r0 = r4.Ps
            int r3 = 8 - r5
            r0 = r0[r3]
            r0.R(r2)
        L_0x00ed:
            int r5 = r5 + 1
            goto L_0x00da
        L_0x00f0:
            if (r2 > r1) goto L_0x0114
            com.applovin.exoplayer2.l.x r5 = r4.Po
            boolean r5 = r5.ik()
            if (r5 == 0) goto L_0x0103
            com.applovin.exoplayer2.i.a.b$b[] r5 = r4.Ps
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.clear()
        L_0x0103:
            int r2 = r2 + 1
            goto L_0x00f0
        L_0x0106:
            int r5 = r5 + -128
            int r0 = r4.Pv
            if (r0 == r5) goto L_0x0114
            r4.Pv = r5
            com.applovin.exoplayer2.i.a.b$b[] r0 = r4.Ps
            r5 = r0[r5]
            r4.Pt = r5
        L_0x0114:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.a.b.eo(int):void");
    }

    private void ep(int i) {
        if (i > 7) {
            if (i <= 15) {
                this.Po.bR(8);
            } else if (i <= 23) {
                this.Po.bR(16);
            } else if (i <= 31) {
                this.Po.bR(24);
            }
        }
    }

    private void eq(int i) {
        if (i <= 135) {
            this.Po.bR(32);
        } else if (i <= 143) {
            this.Po.bR(40);
        } else if (i <= 159) {
            this.Po.bR(2);
            this.Po.bR(this.Po.bQ(6) * 8);
        }
    }

    private void er(int i) {
        if (i == 127) {
            this.Pt.a(9835);
        } else {
            this.Pt.a((char) (i & 255));
        }
    }

    private void es(int i) {
        this.Pt.a((char) (i & 255));
    }

    private void et(int i) {
        if (i == 32) {
            this.Pt.a(' ');
        } else if (i == 33) {
            this.Pt.a(Typography.nbsp);
        } else if (i == 37) {
            this.Pt.a(Typography.ellipsis);
        } else if (i == 42) {
            this.Pt.a(352);
        } else if (i == 44) {
            this.Pt.a(338);
        } else if (i == 63) {
            this.Pt.a(376);
        } else if (i == 57) {
            this.Pt.a(Typography.tm);
        } else if (i == 58) {
            this.Pt.a(353);
        } else if (i == 60) {
            this.Pt.a(339);
        } else if (i != 61) {
            switch (i) {
                case 48:
                    this.Pt.a(9608);
                    return;
                case 49:
                    this.Pt.a(Typography.leftSingleQuote);
                    return;
                case 50:
                    this.Pt.a(Typography.rightSingleQuote);
                    return;
                case 51:
                    this.Pt.a(Typography.leftDoubleQuote);
                    return;
                case 52:
                    this.Pt.a(Typography.rightDoubleQuote);
                    return;
                case 53:
                    this.Pt.a(Typography.bullet);
                    return;
                default:
                    switch (i) {
                        case 118:
                            this.Pt.a(8539);
                            return;
                        case 119:
                            this.Pt.a(8540);
                            return;
                        case 120:
                            this.Pt.a(8541);
                            return;
                        case 121:
                            this.Pt.a(8542);
                            return;
                        case 122:
                            this.Pt.a(9474);
                            return;
                        case 123:
                            this.Pt.a(9488);
                            return;
                        case 124:
                            this.Pt.a(9492);
                            return;
                        case 125:
                            this.Pt.a(9472);
                            return;
                        case 126:
                            this.Pt.a(9496);
                            return;
                        case WorkQueueKt.MASK /*127*/:
                            this.Pt.a(9484);
                            return;
                        default:
                            q.h("Cea708Decoder", "Invalid G2 character: " + i);
                            return;
                    }
            }
        } else {
            this.Pt.a(8480);
        }
    }

    private void eu(int i) {
        if (i == 160) {
            this.Pt.a(13252);
            return;
        }
        q.h("Cea708Decoder", "Invalid G3 character: " + i);
        this.Pt.a('_');
    }

    private void mr() {
        this.Pt.a(this.Po.bQ(4), this.Po.bQ(2), this.Po.bQ(2), this.Po.ik(), this.Po.ik(), this.Po.bQ(3), this.Po.bQ(3));
    }

    private void ms() {
        int b = C0053b.b(this.Po.bQ(2), this.Po.bQ(2), this.Po.bQ(2), this.Po.bQ(2));
        int b2 = C0053b.b(this.Po.bQ(2), this.Po.bQ(2), this.Po.bQ(2), this.Po.bQ(2));
        this.Po.bR(2);
        this.Pt.e(b, b2, C0053b.f(this.Po.bQ(2), this.Po.bQ(2), this.Po.bQ(2)));
    }

    private void mt() {
        this.Po.bR(4);
        int bQ = this.Po.bQ(4);
        this.Po.bR(2);
        this.Pt.G(bQ, this.Po.bQ(6));
    }

    private void mu() {
        int b = C0053b.b(this.Po.bQ(2), this.Po.bQ(2), this.Po.bQ(2), this.Po.bQ(2));
        int bQ = this.Po.bQ(2);
        int f = C0053b.f(this.Po.bQ(2), this.Po.bQ(2), this.Po.bQ(2));
        if (this.Po.ik()) {
            bQ |= 4;
        }
        boolean ik = this.Po.ik();
        int bQ2 = this.Po.bQ(2);
        int bQ3 = this.Po.bQ(2);
        int bQ4 = this.Po.bQ(2);
        this.Po.bR(8);
        this.Pt.a(b, f, ik, bQ, bQ2, bQ3, bQ4);
    }

    private void ev(int i) {
        C0053b bVar = this.Ps[i];
        this.Po.bR(2);
        boolean ik = this.Po.ik();
        boolean ik2 = this.Po.ik();
        boolean ik3 = this.Po.ik();
        int bQ = this.Po.bQ(3);
        boolean ik4 = this.Po.ik();
        int bQ2 = this.Po.bQ(7);
        int bQ3 = this.Po.bQ(8);
        int bQ4 = this.Po.bQ(4);
        int bQ5 = this.Po.bQ(4);
        this.Po.bR(2);
        int bQ6 = this.Po.bQ(6);
        this.Po.bR(2);
        bVar.a(ik, ik2, ik3, bQ, ik4, bQ2, bQ3, bQ5, bQ6, bQ4, this.Po.bQ(3), this.Po.bQ(3));
    }

    private List<com.applovin.exoplayer2.i.a> mi() {
        a mz;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.Ps[i].isEmpty() && this.Ps[i].mx() && (mz = this.Ps[i].mz()) != null) {
                arrayList.add(mz);
            }
        }
        Collections.sort(arrayList, a.Pw);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(((a) arrayList.get(i2)).Px);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void mj() {
        for (int i = 0; i < 8; i++) {
            this.Ps[i].Y();
        }
    }

    private static final class c {
        public final int Qd;
        public final int Qe;
        public final byte[] Qf;
        int pS = 0;

        public c(int i, int i2) {
            this.Qd = i;
            this.Qe = i2;
            this.Qf = new byte[((i2 * 2) - 1)];
        }
    }

    /* renamed from: com.applovin.exoplayer2.i.a.b$b  reason: collision with other inner class name */
    private static final class C0053b {
        public static final int PA;
        public static final int PB;
        private static final int[] PC = {0, 0, 0, 0, 0, 2, 0};
        private static final int[] PD = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] PE = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] PF = {false, false, false, true, true, true, false};
        private static final int[] PG;
        private static final int[] PH = {0, 1, 2, 3, 4, 3, 4};
        private static final int[] PI = {0, 0, 0, 0, 0, 3, 3};
        private static final int[] PJ;
        public static final int Pz = b(2, 2, 2, 0);
        private final SpannableStringBuilder PK = new SpannableStringBuilder();
        private boolean PL;
        private boolean PM;
        private boolean PN;
        private int PO;
        private int PP;
        private int PQ;
        private int PR;
        private boolean PS;
        private int PT;
        private int PU;
        private int PV;
        private int PW;
        private int PX;
        private int PY;
        private int PZ;
        private final List<SpannableString> Ph = new ArrayList();
        private int Pj;
        private int Py;
        private int Qa;
        private int Qb;
        private int Qc;

        public void R(boolean z) {
            this.PM = z;
        }

        public void a(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
            this.PW = i;
            this.PT = i6;
        }

        public boolean mw() {
            return this.PL;
        }

        public boolean mx() {
            return this.PM;
        }

        static {
            int b = b(0, 0, 0, 0);
            PA = b;
            int b2 = b(0, 0, 0, 3);
            PB = b2;
            PG = new int[]{b, b2, b, b, b2, b, b};
            PJ = new int[]{b, b, b, b, b, b2, b2};
        }

        public C0053b() {
            Y();
        }

        public boolean isEmpty() {
            return !mw() || (this.Ph.isEmpty() && this.PK.length() == 0);
        }

        public void Y() {
            clear();
            this.PL = false;
            this.PM = false;
            this.Py = 4;
            this.PN = false;
            this.PO = 0;
            this.PP = 0;
            this.PQ = 0;
            this.PR = 15;
            this.PS = true;
            this.PT = 0;
            this.PU = 0;
            this.PV = 0;
            int i = PA;
            this.PW = i;
            this.Qa = Pz;
            this.Qc = i;
        }

        public void clear() {
            this.Ph.clear();
            this.PK.clear();
            this.PX = -1;
            this.PY = -1;
            this.PZ = -1;
            this.Qb = -1;
            this.Pj = 0;
        }

        public void a(boolean z, boolean z2, boolean z3, int i, boolean z4, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            boolean z5 = z2;
            int i9 = i7;
            int i10 = i8;
            this.PL = true;
            this.PM = z;
            this.PS = z5;
            this.Py = i;
            this.PN = z4;
            this.PO = i2;
            this.PP = i3;
            this.PQ = i6;
            int i11 = i4 + 1;
            if (this.PR != i11) {
                this.PR = i11;
                while (true) {
                    if ((!z5 || this.Ph.size() < this.PR) && this.Ph.size() < 15) {
                        break;
                    }
                    this.Ph.remove(0);
                }
            }
            if (!(i9 == 0 || this.PU == i9)) {
                this.PU = i9;
                int i12 = i9 - 1;
                a(PG[i12], PB, PF[i12], 0, PD[i12], PE[i12], PC[i12]);
            }
            if (i10 != 0 && this.PV != i10) {
                this.PV = i10;
                int i13 = i10 - 1;
                a(0, 1, 1, false, false, PI[i13], PH[i13]);
                e(Pz, PJ[i13], PA);
            }
        }

        public void a(int i, int i2, int i3, boolean z, boolean z2, int i4, int i5) {
            if (this.PX != -1) {
                if (!z) {
                    this.PK.setSpan(new StyleSpan(2), this.PX, this.PK.length(), 33);
                    this.PX = -1;
                }
            } else if (z) {
                this.PX = this.PK.length();
            }
            if (this.PY != -1) {
                if (!z2) {
                    this.PK.setSpan(new UnderlineSpan(), this.PY, this.PK.length(), 33);
                    this.PY = -1;
                }
            } else if (z2) {
                this.PY = this.PK.length();
            }
        }

        public void e(int i, int i2, int i3) {
            if (!(this.PZ == -1 || this.Qa == i)) {
                this.PK.setSpan(new ForegroundColorSpan(this.Qa), this.PZ, this.PK.length(), 33);
            }
            if (i != Pz) {
                this.PZ = this.PK.length();
                this.Qa = i;
            }
            if (!(this.Qb == -1 || this.Qc == i2)) {
                this.PK.setSpan(new BackgroundColorSpan(this.Qc), this.Qb, this.PK.length(), 33);
            }
            if (i2 != PA) {
                this.Qb = this.PK.length();
                this.Qc = i2;
            }
        }

        public void G(int i, int i2) {
            if (this.Pj != i) {
                a(10);
            }
            this.Pj = i;
        }

        public void mm() {
            int length = this.PK.length();
            if (length > 0) {
                this.PK.delete(length - 1, length);
            }
        }

        public void a(char c) {
            if (c == 10) {
                this.Ph.add(my());
                this.PK.clear();
                if (this.PX != -1) {
                    this.PX = 0;
                }
                if (this.PY != -1) {
                    this.PY = 0;
                }
                if (this.PZ != -1) {
                    this.PZ = 0;
                }
                if (this.Qb != -1) {
                    this.Qb = 0;
                }
                while (true) {
                    if ((this.PS && this.Ph.size() >= this.PR) || this.Ph.size() >= 15) {
                        this.Ph.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.PK.append(c);
            }
        }

        public SpannableString my() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.PK);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.PX != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.PX, length, 33);
                }
                if (this.PY != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.PY, length, 33);
                }
                if (this.PZ != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.Qa), this.PZ, length, 33);
                }
                if (this.Qb != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.Qc), this.Qb, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x009b  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00a9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.applovin.exoplayer2.i.a.b.a mz() {
            /*
                r15 = this;
                boolean r0 = r15.isEmpty()
                if (r0 == 0) goto L_0x0008
                r0 = 0
                return r0
            L_0x0008:
                android.text.SpannableStringBuilder r2 = new android.text.SpannableStringBuilder
                r2.<init>()
                r0 = 0
                r1 = 0
            L_0x000f:
                java.util.List<android.text.SpannableString> r3 = r15.Ph
                int r3 = r3.size()
                if (r1 >= r3) goto L_0x002a
                java.util.List<android.text.SpannableString> r3 = r15.Ph
                java.lang.Object r3 = r3.get(r1)
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r2.append(r3)
                r3 = 10
                r2.append(r3)
                int r1 = r1 + 1
                goto L_0x000f
            L_0x002a:
                android.text.SpannableString r1 = r15.my()
                r2.append(r1)
                int r1 = r15.PT
                r3 = 2
                r4 = 3
                r5 = 1
                if (r1 == 0) goto L_0x005b
                if (r1 == r5) goto L_0x0058
                if (r1 == r3) goto L_0x0055
                if (r1 != r4) goto L_0x003f
                goto L_0x005b
            L_0x003f:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "Unexpected justification value: "
                r1.<init>(r2)
                int r2 = r15.PT
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0055:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER
                goto L_0x005d
            L_0x0058:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE
                goto L_0x005d
            L_0x005b:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL
            L_0x005d:
                r6 = r1
                boolean r1 = r15.PN
                if (r1 == 0) goto L_0x006d
                int r1 = r15.PP
                float r1 = (float) r1
                r7 = 1120272384(0x42c60000, float:99.0)
                float r1 = r1 / r7
                int r8 = r15.PO
                float r8 = (float) r8
                float r8 = r8 / r7
                goto L_0x007a
            L_0x006d:
                int r1 = r15.PP
                float r1 = (float) r1
                r7 = 1129381888(0x43510000, float:209.0)
                float r1 = r1 / r7
                int r7 = r15.PO
                float r7 = (float) r7
                r8 = 1116995584(0x42940000, float:74.0)
                float r8 = r7 / r8
            L_0x007a:
                r7 = 1063675494(0x3f666666, float:0.9)
                float r1 = r1 * r7
                r9 = 1028443341(0x3d4ccccd, float:0.05)
                float r10 = r1 + r9
                float r8 = r8 * r7
                float r7 = r8 + r9
                int r1 = r15.PQ
                int r8 = r1 / 3
                if (r8 != 0) goto L_0x0090
                r8 = 0
                goto L_0x0097
            L_0x0090:
                int r8 = r1 / 3
                if (r8 != r5) goto L_0x0096
                r8 = 1
                goto L_0x0097
            L_0x0096:
                r8 = 2
            L_0x0097:
                int r9 = r1 % 3
                if (r9 != 0) goto L_0x009d
                r9 = 0
                goto L_0x00a3
            L_0x009d:
                int r1 = r1 % r4
                if (r1 != r5) goto L_0x00a2
                r9 = 1
                goto L_0x00a3
            L_0x00a2:
                r9 = 2
            L_0x00a3:
                int r1 = r15.PW
                int r3 = PA
                if (r1 == r3) goto L_0x00aa
                r0 = 1
            L_0x00aa:
                com.applovin.exoplayer2.i.a.b$a r13 = new com.applovin.exoplayer2.i.a.b$a
                r5 = 0
                r11 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
                int r12 = r15.PW
                int r14 = r15.Py
                r1 = r13
                r3 = r6
                r4 = r7
                r6 = r8
                r7 = r10
                r8 = r9
                r9 = r11
                r10 = r0
                r11 = r12
                r12 = r14
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.a.b.C0053b.mz():com.applovin.exoplayer2.i.a.b$a");
        }

        public static int f(int i, int i2, int i3) {
            return b(i, i2, i3, 0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x002b  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x002e  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int b(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                com.applovin.exoplayer2.l.a.h(r4, r0, r1)
                com.applovin.exoplayer2.l.a.h(r5, r0, r1)
                com.applovin.exoplayer2.l.a.h(r6, r0, r1)
                com.applovin.exoplayer2.l.a.h(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L_0x0021
                if (r7 == r1) goto L_0x0021
                r3 = 2
                if (r7 == r3) goto L_0x001e
                r3 = 3
                if (r7 == r3) goto L_0x001c
                goto L_0x0021
            L_0x001c:
                r7 = 0
                goto L_0x0023
            L_0x001e:
                r7 = 127(0x7f, float:1.78E-43)
                goto L_0x0023
            L_0x0021:
                r7 = 255(0xff, float:3.57E-43)
            L_0x0023:
                if (r4 <= r1) goto L_0x0028
                r4 = 255(0xff, float:3.57E-43)
                goto L_0x0029
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r5 <= r1) goto L_0x002e
                r5 = 255(0xff, float:3.57E-43)
                goto L_0x002f
            L_0x002e:
                r5 = 0
            L_0x002f:
                if (r6 <= r1) goto L_0x0033
                r0 = 255(0xff, float:3.57E-43)
            L_0x0033:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.a.b.C0053b.b(int, int, int, int):int");
        }
    }

    private static final class a {
        /* access modifiers changed from: private */
        public static final Comparator<a> Pw = new b$a$$ExternalSyntheticLambda0();
        public final com.applovin.exoplayer2.i.a Px;
        public final int Py;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4, int i5) {
            a.C0050a p = new a.C0050a().m(charSequence).a(alignment).b(f, i).ef(i2).o(f2).eg(i3).p(f3);
            if (z) {
                p.eh(i4);
            }
            this.Px = p.lU();
            this.Py = i5;
        }
    }
}
