package com.applovin.exoplayer2.g.e;

import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.g.d;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.x;
import com.applovin.exoplayer2.l.y;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.UByte;

public final class g extends com.applovin.exoplayer2.g.g {
    public static final a JP = new g$$ExternalSyntheticLambda0();
    private final a JQ;

    public interface a {
        boolean evaluate(int i, int i2, int i3, int i4, int i5);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean c(int i, int i2, int i3, int i4, int i5) {
        return false;
    }

    private static String ds(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16";
    }

    private static int dt(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public g() {
        this((a) null);
    }

    public g(a aVar) {
        this.JQ = aVar;
    }

    /* access modifiers changed from: protected */
    public com.applovin.exoplayer2.g.a a(d dVar, ByteBuffer byteBuffer) {
        return f(byteBuffer.array(), byteBuffer.limit());
    }

    public com.applovin.exoplayer2.g.a f(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        y yVar = new y(bArr, i);
        b X = X(yVar);
        if (X == null) {
            return null;
        }
        int il = yVar.il();
        int i2 = X.JR == 2 ? 6 : 10;
        int b2 = X.JT;
        if (X.JS) {
            b2 = z(yVar, X.JT);
        }
        yVar.fA(il + b2);
        boolean z = false;
        if (!a(yVar, X.JR, i2, false)) {
            if (X.JR != 4 || !a(yVar, 4, i2, true)) {
                q.h("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + X.JR);
                return null;
            }
            z = true;
        }
        while (yVar.pj() >= i2) {
            h a2 = a(X.JR, yVar, z, i2, this.JQ);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return new com.applovin.exoplayer2.g.a((List<? extends a.C0047a>) arrayList);
    }

    private static b X(y yVar) {
        if (yVar.pj() < 10) {
            q.h("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int pt = yVar.pt();
        boolean z = false;
        if (pt != 4801587) {
            q.h("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", new Object[]{Integer.valueOf(pt)}));
            return null;
        }
        int po = yVar.po();
        yVar.fz(1);
        int po2 = yVar.po();
        int pC = yVar.pC();
        if (po == 2) {
            if ((po2 & 64) != 0) {
                q.h("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (po == 3) {
            if ((po2 & 64) != 0) {
                int px = yVar.px();
                yVar.fz(px);
                pC -= px + 4;
            }
        } else if (po == 4) {
            if ((po2 & 64) != 0) {
                int pC2 = yVar.pC();
                yVar.fz(pC2 - 4);
                pC -= pC2;
            }
            if ((po2 & 16) != 0) {
                pC -= 10;
            }
        } else {
            q.h("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + po);
            return null;
        }
        if (po < 4 && (po2 & 128) != 0) {
            z = true;
        }
        return new b(po, z, pC);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
        if ((r10 & 1) != 0) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0084, code lost:
        if ((r10 & 128) != 0) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.applovin.exoplayer2.l.y r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.il()
        L_0x0008:
            int r3 = r18.pj()     // Catch:{ all -> 0x00ad }
            r4 = 1
            r5 = r20
            if (r3 < r5) goto L_0x00a9
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0022
            int r7 = r18.px()     // Catch:{ all -> 0x00ad }
            long r8 = r18.pv()     // Catch:{ all -> 0x00ad }
            int r10 = r18.pp()     // Catch:{ all -> 0x00ad }
            goto L_0x002c
        L_0x0022:
            int r7 = r18.pt()     // Catch:{ all -> 0x00ad }
            int r8 = r18.pt()     // Catch:{ all -> 0x00ad }
            long r8 = (long) r8
            r10 = 0
        L_0x002c:
            r11 = 0
            if (r7 != 0) goto L_0x003a
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x003a
            if (r10 != 0) goto L_0x003a
            r1.fx(r2)
            return r4
        L_0x003a:
            r7 = 4
            if (r0 != r7) goto L_0x006b
            if (r21 != 0) goto L_0x006b
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L_0x004b
            r1.fx(r2)
            return r6
        L_0x004b:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L_0x006b:
            if (r0 != r7) goto L_0x0079
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0073
            r3 = 1
            goto L_0x0074
        L_0x0073:
            r3 = 0
        L_0x0074:
            r7 = r10 & 1
            if (r7 == 0) goto L_0x0088
            goto L_0x0089
        L_0x0079:
            if (r0 != r3) goto L_0x0087
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0081
            r3 = 1
            goto L_0x0082
        L_0x0081:
            r3 = 0
        L_0x0082:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0088
            goto L_0x0089
        L_0x0087:
            r3 = 0
        L_0x0088:
            r4 = 0
        L_0x0089:
            if (r4 == 0) goto L_0x008d
            int r3 = r3 + 4
        L_0x008d:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0096
            r1.fx(r2)
            return r6
        L_0x0096:
            int r3 = r18.pj()     // Catch:{ all -> 0x00ad }
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a3
            r1.fx(r2)
            return r6
        L_0x00a3:
            int r3 = (int) r8
            r1.fz(r3)     // Catch:{ all -> 0x00ad }
            goto L_0x0008
        L_0x00a9:
            r1.fx(r2)
            return r4
        L_0x00ad:
            r0 = move-exception
            r1.fx(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.g.e.g.a(com.applovin.exoplayer2.l.y, int, int, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0196, code lost:
        if (r14 == 67) goto L_0x0198;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.applovin.exoplayer2.g.e.h a(int r20, com.applovin.exoplayer2.l.y r21, boolean r22, int r23, com.applovin.exoplayer2.g.e.g.a r24) {
        /*
            r0 = r20
            r7 = r21
            java.lang.String r8 = "Failed to decode frame: id="
            int r9 = r21.po()
            int r10 = r21.po()
            int r11 = r21.po()
            r13 = 3
            if (r0 < r13) goto L_0x001b
            int r1 = r21.po()
            r14 = r1
            goto L_0x001c
        L_0x001b:
            r14 = 0
        L_0x001c:
            r15 = 4
            if (r0 != r15) goto L_0x003f
            int r1 = r21.pD()
            if (r22 != 0) goto L_0x003c
            r2 = r1 & 255(0xff, float:3.57E-43)
            int r3 = r1 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 7
            r2 = r2 | r3
            int r3 = r1 >> 16
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 14
            r2 = r2 | r3
            int r1 = r1 >> 24
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 21
            r1 = r1 | r2
        L_0x003c:
            r16 = r1
            goto L_0x004b
        L_0x003f:
            if (r0 != r13) goto L_0x0046
            int r1 = r21.pD()
            goto L_0x003c
        L_0x0046:
            int r1 = r21.pt()
            goto L_0x003c
        L_0x004b:
            if (r0 < r13) goto L_0x0053
            int r1 = r21.pp()
            r6 = r1
            goto L_0x0054
        L_0x0053:
            r6 = 0
        L_0x0054:
            r17 = 0
            if (r9 != 0) goto L_0x006a
            if (r10 != 0) goto L_0x006a
            if (r11 != 0) goto L_0x006a
            if (r14 != 0) goto L_0x006a
            if (r16 != 0) goto L_0x006a
            if (r6 != 0) goto L_0x006a
            int r0 = r21.pk()
            r7.fx(r0)
            return r17
        L_0x006a:
            int r1 = r21.il()
            int r5 = r1 + r16
            int r1 = r21.pk()
            java.lang.String r4 = "Id3Decoder"
            if (r5 <= r1) goto L_0x0085
            java.lang.String r0 = "Frame size exceeds remaining tag data"
            com.applovin.exoplayer2.l.q.h(r4, r0)
            int r0 = r21.pk()
            r7.fx(r0)
            return r17
        L_0x0085:
            if (r24 == 0) goto L_0x009d
            r1 = r24
            r2 = r20
            r3 = r9
            r12 = r4
            r4 = r10
            r15 = r5
            r5 = r11
            r19 = r6
            r6 = r14
            boolean r1 = r1.evaluate(r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x00a1
            r7.fx(r15)
            return r17
        L_0x009d:
            r12 = r4
            r15 = r5
            r19 = r6
        L_0x00a1:
            r1 = 1
            if (r0 != r13) goto L_0x00bf
            r2 = r19
            r3 = r2 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x00ac
            r3 = 1
            goto L_0x00ad
        L_0x00ac:
            r3 = 0
        L_0x00ad:
            r4 = r2 & 64
            if (r4 == 0) goto L_0x00b3
            r4 = 1
            goto L_0x00b4
        L_0x00b3:
            r4 = 0
        L_0x00b4:
            r2 = r2 & 32
            if (r2 == 0) goto L_0x00ba
            r2 = 1
            goto L_0x00bb
        L_0x00ba:
            r2 = 0
        L_0x00bb:
            r18 = r3
            r6 = 0
            goto L_0x00f5
        L_0x00bf:
            r2 = r19
            r3 = 4
            if (r0 != r3) goto L_0x00ef
            r3 = r2 & 64
            if (r3 == 0) goto L_0x00ca
            r3 = 1
            goto L_0x00cb
        L_0x00ca:
            r3 = 0
        L_0x00cb:
            r4 = r2 & 8
            if (r4 == 0) goto L_0x00d1
            r4 = 1
            goto L_0x00d2
        L_0x00d1:
            r4 = 0
        L_0x00d2:
            r5 = r2 & 4
            if (r5 == 0) goto L_0x00d8
            r5 = 1
            goto L_0x00d9
        L_0x00d8:
            r5 = 0
        L_0x00d9:
            r6 = r2 & 2
            if (r6 == 0) goto L_0x00df
            r6 = 1
            goto L_0x00e0
        L_0x00df:
            r6 = 0
        L_0x00e0:
            r2 = r2 & r1
            if (r2 == 0) goto L_0x00e6
            r18 = 1
            goto L_0x00e8
        L_0x00e6:
            r18 = 0
        L_0x00e8:
            r2 = r3
            r3 = r18
            r18 = r4
            r4 = r5
            goto L_0x00f5
        L_0x00ef:
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 0
            r18 = 0
        L_0x00f5:
            if (r18 != 0) goto L_0x022a
            if (r4 == 0) goto L_0x00fb
            goto L_0x022a
        L_0x00fb:
            if (r2 == 0) goto L_0x0102
            int r16 = r16 + -1
            r7.fz(r1)
        L_0x0102:
            if (r3 == 0) goto L_0x010a
            int r16 = r16 + -4
            r1 = 4
            r7.fz(r1)
        L_0x010a:
            r1 = r16
            if (r6 == 0) goto L_0x0112
            int r1 = z(r7, r1)
        L_0x0112:
            r13 = r1
            r1 = 84
            r2 = 2
            r3 = 88
            if (r9 != r1) goto L_0x0128
            if (r10 != r3) goto L_0x0128
            if (r11 != r3) goto L_0x0128
            if (r0 == r2) goto L_0x0122
            if (r14 != r3) goto L_0x0128
        L_0x0122:
            com.applovin.exoplayer2.g.e.l r1 = t(r7, r13)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            goto L_0x01fc
        L_0x0128:
            if (r9 != r1) goto L_0x0137
            java.lang.String r1 = b(r0, r9, r10, r11, r14)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            com.applovin.exoplayer2.g.e.l r1 = b(r7, r13, r1)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            goto L_0x01fc
        L_0x0134:
            r0 = move-exception
            goto L_0x0226
        L_0x0137:
            r4 = 87
            if (r9 != r4) goto L_0x0149
            if (r10 != r3) goto L_0x0149
            if (r11 != r3) goto L_0x0149
            if (r0 == r2) goto L_0x0143
            if (r14 != r3) goto L_0x0149
        L_0x0143:
            com.applovin.exoplayer2.g.e.m r1 = u(r7, r13)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            goto L_0x01fc
        L_0x0149:
            if (r9 != r4) goto L_0x0155
            java.lang.String r1 = b(r0, r9, r10, r11, r14)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            com.applovin.exoplayer2.g.e.m r1 = c(r7, r13, r1)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            goto L_0x01fc
        L_0x0155:
            r3 = 73
            r4 = 80
            if (r9 != r4) goto L_0x016b
            r5 = 82
            if (r10 != r5) goto L_0x016b
            if (r11 != r3) goto L_0x016b
            r5 = 86
            if (r14 != r5) goto L_0x016b
            com.applovin.exoplayer2.g.e.k r1 = v(r7, r13)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            goto L_0x01fc
        L_0x016b:
            r5 = 71
            r6 = 79
            if (r9 != r5) goto L_0x0183
            r5 = 69
            if (r10 != r5) goto L_0x0183
            if (r11 != r6) goto L_0x0183
            r5 = 66
            if (r14 == r5) goto L_0x017d
            if (r0 != r2) goto L_0x0183
        L_0x017d:
            com.applovin.exoplayer2.g.e.f r1 = w(r7, r13)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            goto L_0x01fc
        L_0x0183:
            r5 = 65
            r1 = 67
            if (r0 != r2) goto L_0x0190
            if (r9 != r4) goto L_0x019e
            if (r10 != r3) goto L_0x019e
            if (r11 != r1) goto L_0x019e
            goto L_0x0198
        L_0x0190:
            if (r9 != r5) goto L_0x019e
            if (r10 != r4) goto L_0x019e
            if (r11 != r3) goto L_0x019e
            if (r14 != r1) goto L_0x019e
        L_0x0198:
            com.applovin.exoplayer2.g.e.a r1 = g(r7, r13, r0)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            goto L_0x01fc
        L_0x019e:
            r3 = 77
            if (r9 != r1) goto L_0x01af
            if (r10 != r6) goto L_0x01af
            if (r11 != r3) goto L_0x01af
            if (r14 == r3) goto L_0x01aa
            if (r0 != r2) goto L_0x01af
        L_0x01aa:
            com.applovin.exoplayer2.g.e.e r1 = x(r7, r13)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            goto L_0x01fc
        L_0x01af:
            if (r9 != r1) goto L_0x01c9
            r2 = 72
            if (r10 != r2) goto L_0x01c9
            if (r11 != r5) goto L_0x01c9
            if (r14 != r4) goto L_0x01c9
            r1 = r21
            r2 = r13
            r3 = r20
            r4 = r22
            r5 = r23
            r6 = r24
            com.applovin.exoplayer2.g.e.c r1 = a(r1, r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            goto L_0x01fc
        L_0x01c9:
            if (r9 != r1) goto L_0x01e3
            r2 = 84
            if (r10 != r2) goto L_0x01e3
            if (r11 != r6) goto L_0x01e3
            if (r14 != r1) goto L_0x01e3
            r1 = r21
            r2 = r13
            r3 = r20
            r4 = r22
            r5 = r23
            r6 = r24
            com.applovin.exoplayer2.g.e.d r1 = b(r1, r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            goto L_0x01fc
        L_0x01e3:
            if (r9 != r3) goto L_0x01f4
            r1 = 76
            if (r10 != r1) goto L_0x01f4
            if (r11 != r1) goto L_0x01f4
            r1 = 84
            if (r14 != r1) goto L_0x01f4
            com.applovin.exoplayer2.g.e.j r1 = y(r7, r13)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            goto L_0x01fc
        L_0x01f4:
            java.lang.String r1 = b(r0, r9, r10, r11, r14)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            com.applovin.exoplayer2.g.e.b r1 = d(r7, r13, r1)     // Catch:{ UnsupportedEncodingException -> 0x021d }
        L_0x01fc:
            if (r1 != 0) goto L_0x0219
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x021d }
            r2.<init>(r8)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            java.lang.String r0 = b(r0, r9, r10, r11, r14)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            r2.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            java.lang.String r0 = ", frameSize="
            r2.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            r2.append(r13)     // Catch:{ UnsupportedEncodingException -> 0x021d }
            java.lang.String r0 = r2.toString()     // Catch:{ UnsupportedEncodingException -> 0x021d }
            com.applovin.exoplayer2.l.q.h(r12, r0)     // Catch:{ UnsupportedEncodingException -> 0x021d }
        L_0x0219:
            r7.fx(r15)
            return r1
        L_0x021d:
            java.lang.String r0 = "Unsupported character encoding"
            com.applovin.exoplayer2.l.q.h(r12, r0)     // Catch:{ all -> 0x0134 }
            r7.fx(r15)
            return r17
        L_0x0226:
            r7.fx(r15)
            throw r0
        L_0x022a:
            java.lang.String r0 = "Skipping unsupported compressed or encrypted frame"
            com.applovin.exoplayer2.l.q.h(r12, r0)
            r7.fx(r15)
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.g.e.g.a(int, com.applovin.exoplayer2.l.y, boolean, int, com.applovin.exoplayer2.g.e.g$a):com.applovin.exoplayer2.g.e.h");
    }

    private static l t(y yVar, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int po = yVar.po();
        String ds = ds(po);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        yVar.r(bArr, 0, i2);
        int j = j(bArr, 0, po);
        String str = new String(bArr, 0, j, ds);
        int dt = j + dt(po);
        return new l("TXXX", str, a(bArr, dt, j(bArr, dt, po), ds));
    }

    private static l b(y yVar, int i, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int po = yVar.po();
        String ds = ds(po);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        yVar.r(bArr, 0, i2);
        return new l(str, (String) null, new String(bArr, 0, j(bArr, 0, po), ds));
    }

    private static m u(y yVar, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int po = yVar.po();
        String ds = ds(po);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        yVar.r(bArr, 0, i2);
        int j = j(bArr, 0, po);
        String str = new String(bArr, 0, j, ds);
        int dt = j + dt(po);
        return new m("WXXX", str, a(bArr, dt, g(bArr, dt), "ISO-8859-1"));
    }

    private static m c(y yVar, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        yVar.r(bArr, 0, i);
        return new m(str, (String) null, new String(bArr, 0, g(bArr, 0), "ISO-8859-1"));
    }

    private static k v(y yVar, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        yVar.r(bArr, 0, i);
        int g = g(bArr, 0);
        return new k(new String(bArr, 0, g, "ISO-8859-1"), k(bArr, g + 1, i));
    }

    private static f w(y yVar, int i) throws UnsupportedEncodingException {
        int po = yVar.po();
        String ds = ds(po);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        yVar.r(bArr, 0, i2);
        int g = g(bArr, 0);
        String str = new String(bArr, 0, g, "ISO-8859-1");
        int i3 = g + 1;
        int j = j(bArr, i3, po);
        String a2 = a(bArr, i3, j, ds);
        int dt = j + dt(po);
        int j2 = j(bArr, dt, po);
        return new f(str, a2, a(bArr, dt, j2, ds), k(bArr, j2 + dt(po), i2));
    }

    private static a g(y yVar, int i, int i2) throws UnsupportedEncodingException {
        int i3;
        String str;
        int po = yVar.po();
        String ds = ds(po);
        int i4 = i - 1;
        byte[] bArr = new byte[i4];
        yVar.r(bArr, 0, i4);
        if (i2 == 2) {
            str = "image/" + Ascii.toLowerCase(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            i3 = 2;
        } else {
            i3 = g(bArr, 0);
            String lowerCase = Ascii.toLowerCase(new String(bArr, 0, i3, "ISO-8859-1"));
            if (lowerCase.indexOf(47) == -1) {
                str = "image/" + lowerCase;
            } else {
                str = lowerCase;
            }
        }
        byte b2 = bArr[i3 + 1] & UByte.MAX_VALUE;
        int i5 = i3 + 2;
        int j = j(bArr, i5, po);
        return new a(str, new String(bArr, i5, j - i5, ds), b2, k(bArr, j + dt(po), i4));
    }

    private static e x(y yVar, int i) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int po = yVar.po();
        String ds = ds(po);
        byte[] bArr = new byte[3];
        yVar.r(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        yVar.r(bArr2, 0, i2);
        int j = j(bArr2, 0, po);
        String str2 = new String(bArr2, 0, j, ds);
        int dt = j + dt(po);
        return new e(str, str2, a(bArr2, dt, j(bArr2, dt, po), ds));
    }

    private static c a(y yVar, int i, int i2, boolean z, int i3, a aVar) throws UnsupportedEncodingException {
        y yVar2 = yVar;
        int il = yVar.il();
        int g = g(yVar.hO(), il);
        String str = new String(yVar.hO(), il, g - il, "ISO-8859-1");
        yVar.fx(g + 1);
        int px = yVar.px();
        int px2 = yVar.px();
        long pv = yVar.pv();
        long j = pv == 4294967295L ? -1 : pv;
        long pv2 = yVar.pv();
        long j2 = pv2 == 4294967295L ? -1 : pv2;
        ArrayList arrayList = new ArrayList();
        int i4 = il + i;
        while (yVar.il() < i4) {
            h a2 = a(i2, yVar, z, i3, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return new c(str, px, px2, j, j2, (h[]) arrayList.toArray(new h[0]));
    }

    private static d b(y yVar, int i, int i2, boolean z, int i3, a aVar) throws UnsupportedEncodingException {
        y yVar2 = yVar;
        int il = yVar.il();
        int g = g(yVar.hO(), il);
        String str = new String(yVar.hO(), il, g - il, "ISO-8859-1");
        yVar2.fx(g + 1);
        int po = yVar.po();
        boolean z2 = (po & 2) != 0;
        boolean z3 = (po & 1) != 0;
        int po2 = yVar.po();
        String[] strArr = new String[po2];
        for (int i4 = 0; i4 < po2; i4++) {
            int il2 = yVar.il();
            int g2 = g(yVar.hO(), il2);
            strArr[i4] = new String(yVar.hO(), il2, g2 - il2, "ISO-8859-1");
            yVar2.fx(g2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = il + i;
        while (yVar.il() < i5) {
            h a2 = a(i2, yVar2, z, i3, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return new d(str, z2, z3, strArr, (h[]) arrayList.toArray(new h[0]));
    }

    private static j y(y yVar, int i) {
        int pp = yVar.pp();
        int pt = yVar.pt();
        int pt2 = yVar.pt();
        int po = yVar.po();
        int po2 = yVar.po();
        x xVar = new x();
        xVar.ar(yVar);
        int i2 = ((i - 10) * 8) / (po + po2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int bQ = xVar.bQ(po);
            int bQ2 = xVar.bQ(po2);
            iArr[i3] = bQ;
            iArr2[i3] = bQ2;
        }
        return new j(pp, pt, pt2, iArr, iArr2);
    }

    private static b d(y yVar, int i, String str) {
        byte[] bArr = new byte[i];
        yVar.r(bArr, 0, i);
        return new b(str, bArr);
    }

    private static int z(y yVar, int i) {
        byte[] hO = yVar.hO();
        int il = yVar.il();
        int i2 = il;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= il + i) {
                return i;
            }
            if ((hO[i2] & UByte.MAX_VALUE) == 255 && hO[i3] == 0) {
                System.arraycopy(hO, i2 + 2, hO, i3, (i - (i2 - il)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    private static String b(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    private static int j(byte[] bArr, int i, int i2) {
        int g = g(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return g;
        }
        while (g < bArr.length - 1) {
            if ((g - i) % 2 == 0 && bArr[g + 1] == 0) {
                return g;
            }
            g = g(bArr, g + 1);
        }
        return bArr.length;
    }

    private static int g(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static byte[] k(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return ai.ada;
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    private static String a(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    private static final class b {
        /* access modifiers changed from: private */
        public final int JR;
        /* access modifiers changed from: private */
        public final boolean JS;
        /* access modifiers changed from: private */
        public final int JT;

        public b(int i, boolean z, int i2) {
            this.JR = i;
            this.JS = z;
            this.JT = i2;
        }
    }
}
