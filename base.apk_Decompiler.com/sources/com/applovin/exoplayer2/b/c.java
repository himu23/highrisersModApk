package com.applovin.exoplayer2.b;

import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.d.e;
import com.applovin.exoplayer2.l.x;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import java.nio.ByteBuffer;
import kotlin.UByte;

public final class c {
    private static final int[] jB = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, CommonGatewayClient.CODE_400, CommonGatewayClient.CODE_400, 2048};

    public static final class a {
        public final int dL;
        public final int dM;
        public final int jA;
        public final int jC;
        public final int jz;

        private a(int i, int i2, int i3, int i4, int i5) {
            this.jC = i;
            this.dL = i2;
            this.dM = i3;
            this.jz = i4;
            this.jA = i5;
        }
    }

    public static v c(y yVar, String str, String str2, e eVar) {
        yVar.fz(1);
        return new v.a().g(str).m("audio/ac4").N(2).O(((yVar.po() & 32) >> 5) == 1 ? 48000 : 44100).a(eVar).j(str2).bT();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
        if (r11 != 11) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0089, code lost:
        if (r11 != 11) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008e, code lost:
        if (r11 != 8) goto L_0x0091;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.applovin.exoplayer2.b.c.a d(com.applovin.exoplayer2.l.x r11) {
        /*
            r0 = 16
            int r1 = r11.bQ(r0)
            int r0 = r11.bQ(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L_0x0018
            r0 = 24
            int r0 = r11.bQ(r0)
            r2 = 7
            goto L_0x0019
        L_0x0018:
            r2 = 4
        L_0x0019:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L_0x0021
            int r0 = r0 + 2
        L_0x0021:
            r8 = r0
            r0 = 2
            int r1 = r11.bQ(r0)
            r2 = 3
            if (r1 != r2) goto L_0x002f
            int r4 = a((com.applovin.exoplayer2.l.x) r11, (int) r0)
            int r1 = r1 + r4
        L_0x002f:
            r5 = r1
            r1 = 10
            int r1 = r11.bQ(r1)
            boolean r4 = r11.ik()
            if (r4 == 0) goto L_0x0045
            int r4 = r11.bQ(r2)
            if (r4 <= 0) goto L_0x0045
            r11.bR(r0)
        L_0x0045:
            boolean r4 = r11.ik()
            r6 = 48000(0xbb80, float:6.7262E-41)
            r7 = 44100(0xac44, float:6.1797E-41)
            if (r4 == 0) goto L_0x0055
            r9 = 48000(0xbb80, float:6.7262E-41)
            goto L_0x0058
        L_0x0055:
            r9 = 44100(0xac44, float:6.1797E-41)
        L_0x0058:
            int r11 = r11.bQ(r3)
            if (r9 != r7) goto L_0x0067
            r4 = 13
            if (r11 != r4) goto L_0x0067
            int[] r0 = jB
            r11 = r0[r11]
            goto L_0x0097
        L_0x0067:
            if (r9 != r6) goto L_0x0096
            int[] r4 = jB
            int r6 = r4.length
            if (r11 >= r6) goto L_0x0096
            r4 = r4[r11]
            int r1 = r1 % 5
            r6 = 8
            r7 = 1
            if (r1 == r7) goto L_0x008c
            r7 = 11
            if (r1 == r0) goto L_0x0087
            if (r1 == r2) goto L_0x008c
            if (r1 == r3) goto L_0x0080
            goto L_0x0091
        L_0x0080:
            if (r11 == r2) goto L_0x0093
            if (r11 == r6) goto L_0x0093
            if (r11 != r7) goto L_0x0091
            goto L_0x0093
        L_0x0087:
            if (r11 == r6) goto L_0x0093
            if (r11 != r7) goto L_0x0091
            goto L_0x0093
        L_0x008c:
            if (r11 == r2) goto L_0x0093
            if (r11 != r6) goto L_0x0091
            goto L_0x0093
        L_0x0091:
            r11 = r4
            goto L_0x0097
        L_0x0093:
            int r4 = r4 + 1
            goto L_0x0091
        L_0x0096:
            r11 = 0
        L_0x0097:
            com.applovin.exoplayer2.b.c$a r0 = new com.applovin.exoplayer2.b.c$a
            r6 = 2
            r10 = 0
            r4 = r0
            r7 = r9
            r9 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.b.c.d(com.applovin.exoplayer2.l.x):com.applovin.exoplayer2.b.c$a");
    }

    public static int b(byte[] bArr, int i) {
        int i2 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        byte b = ((bArr[2] & UByte.MAX_VALUE) << 8) | (bArr[3] & UByte.MAX_VALUE);
        if (b == 65535) {
            b = ((bArr[4] & UByte.MAX_VALUE) << Ascii.DLE) | ((bArr[5] & UByte.MAX_VALUE) << 8) | (bArr[6] & UByte.MAX_VALUE);
        } else {
            i2 = 4;
        }
        if (i == 44097) {
            i2 += 2;
        }
        return b + i2;
    }

    public static int c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return d(new x(bArr)).jA;
    }

    public static void a(int i, y yVar) {
        yVar.U(7);
        byte[] hO = yVar.hO();
        hO[0] = -84;
        hO[1] = 64;
        hO[2] = -1;
        hO[3] = -1;
        hO[4] = (byte) ((i >> 16) & 255);
        hO[5] = (byte) ((i >> 8) & 255);
        hO[6] = (byte) (i & 255);
    }

    private static int a(x xVar, int i) {
        int i2 = 0;
        while (true) {
            int bQ = i2 + xVar.bQ(i);
            if (!xVar.ik()) {
                return bQ;
            }
            i2 = (bQ + 1) << i;
        }
    }
}
