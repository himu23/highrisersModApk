package com.applovin.exoplayer2.i.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

final class b {
    private static final byte[] Qm = {0, 7, 8, Ascii.SI};
    private static final byte[] Qn = {0, 119, -120, -1};
    private static final byte[] Qo = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private Bitmap NZ;
    private final Paint Qp;
    private final Paint Qq;
    private final Canvas Qr = new Canvas();
    private final C0054b Qs = new C0054b(719, 575, 0, 719, 0, 575);
    private final a Qt = new a(0, mB(), mC(), mD());
    private final h Qu;

    private static int c(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    private static int[] mB() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    public b(int i, int i2) {
        Paint paint = new Paint();
        this.Qp = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect((PathEffect) null);
        Paint paint2 = new Paint();
        this.Qq = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect((PathEffect) null);
        this.Qu = new h(i, i2);
    }

    public void Y() {
        this.Qu.Y();
    }

    public List<com.applovin.exoplayer2.i.a> h(byte[] bArr, int i) {
        int i2;
        int i3;
        SparseArray<g> sparseArray;
        x xVar = new x(bArr, i);
        while (xVar.pf() >= 48 && xVar.bQ(8) == 15) {
            a(xVar, this.Qu);
        }
        d dVar = this.Qu.Rc;
        if (dVar == null) {
            return Collections.emptyList();
        }
        C0054b bVar = this.Qu.Rb != null ? this.Qu.Rb : this.Qs;
        if (!(this.NZ != null && bVar.dE + 1 == this.NZ.getWidth() && bVar.height + 1 == this.NZ.getHeight())) {
            Bitmap createBitmap = Bitmap.createBitmap(bVar.dE + 1, bVar.height + 1, Bitmap.Config.ARGB_8888);
            this.NZ = createBitmap;
            this.Qr.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray2 = dVar.QG;
        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
            this.Qr.save();
            e valueAt = sparseArray2.valueAt(i4);
            f fVar = this.Qu.QG.get(sparseArray2.keyAt(i4));
            int i5 = valueAt.QH + bVar.Qy;
            int i6 = valueAt.QI + bVar.QA;
            this.Qr.clipRect(i5, i6, Math.min(fVar.dE + i5, bVar.Qz), Math.min(fVar.height + i6, bVar.QB));
            a aVar = this.Qu.QX.get(fVar.QL);
            if (aVar == null && (aVar = this.Qu.QZ.get(fVar.QL)) == null) {
                aVar = this.Qt;
            }
            SparseArray<g> sparseArray3 = fVar.QP;
            int i7 = 0;
            while (i7 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i7);
                g valueAt2 = sparseArray3.valueAt(i7);
                c cVar = this.Qu.QY.get(keyAt);
                c cVar2 = cVar == null ? this.Qu.Ra.get(keyAt) : cVar;
                if (cVar2 != null) {
                    Paint paint = cVar2.QC ? null : this.Qp;
                    i3 = i7;
                    sparseArray = sparseArray3;
                    a(cVar2, aVar, fVar.Ju, valueAt2.QR + i5, i6 + valueAt2.QS, paint, this.Qr);
                } else {
                    i3 = i7;
                    sparseArray = sparseArray3;
                }
                i7 = i3 + 1;
                sparseArray3 = sparseArray;
            }
            if (fVar.QJ) {
                if (fVar.Ju == 3) {
                    i2 = aVar.Qx[fVar.QM];
                } else if (fVar.Ju == 2) {
                    i2 = aVar.Qw[fVar.QN];
                } else {
                    i2 = aVar.Qv[fVar.QO];
                }
                this.Qq.setColor(i2);
                this.Qr.drawRect((float) i5, (float) i6, (float) (fVar.dE + i5), (float) (fVar.height + i6), this.Qq);
            }
            arrayList.add(new a.C0050a().a(Bitmap.createBitmap(this.NZ, i5, i6, fVar.dE, fVar.height)).o(((float) i5) / ((float) bVar.dE)).eg(0).b(((float) i6) / ((float) bVar.height), 0).ef(0).p(((float) fVar.dE) / ((float) bVar.dE)).q(((float) fVar.height) / ((float) bVar.height)).lU());
            this.Qr.drawColor(0, PorterDuff.Mode.CLEAR);
            this.Qr.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void a(x xVar, h hVar) {
        f fVar;
        int bQ = xVar.bQ(8);
        int bQ2 = xVar.bQ(16);
        int bQ3 = xVar.bQ(16);
        int pg = xVar.pg() + bQ3;
        if (bQ3 * 8 > xVar.pf()) {
            q.h("DvbParser", "Data field length exceeds limit");
            xVar.bR(xVar.pf());
            return;
        }
        switch (bQ) {
            case 16:
                if (bQ2 == hVar.QV) {
                    d dVar = hVar.Rc;
                    d c2 = c(xVar, bQ3);
                    if (c2.Z == 0) {
                        if (!(dVar == null || dVar.mH == c2.mH)) {
                            hVar.Rc = c2;
                            break;
                        }
                    } else {
                        hVar.Rc = c2;
                        hVar.QG.clear();
                        hVar.QX.clear();
                        hVar.QY.clear();
                        break;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.Rc;
                if (bQ2 == hVar.QV && dVar2 != null) {
                    f d2 = d(xVar, bQ3);
                    if (dVar2.Z == 0 && (fVar = hVar.QG.get(d2.zD)) != null) {
                        d2.a(fVar);
                    }
                    hVar.QG.put(d2.zD, d2);
                    break;
                }
            case 18:
                if (bQ2 != hVar.QV) {
                    if (bQ2 == hVar.QW) {
                        a e2 = e(xVar, bQ3);
                        hVar.QZ.put(e2.zD, e2);
                        break;
                    }
                } else {
                    a e3 = e(xVar, bQ3);
                    hVar.QX.put(e3.zD, e3);
                    break;
                }
                break;
            case 19:
                if (bQ2 != hVar.QV) {
                    if (bQ2 == hVar.QW) {
                        c m = m(xVar);
                        hVar.Ra.put(m.zD, m);
                        break;
                    }
                } else {
                    c m2 = m(xVar);
                    hVar.QY.put(m2.zD, m2);
                    break;
                }
                break;
            case 20:
                if (bQ2 == hVar.QV) {
                    hVar.Rb = l(xVar);
                    break;
                }
                break;
        }
        xVar.fz(pg - xVar.pg());
    }

    private static C0054b l(x xVar) {
        int i;
        int i2;
        int i3;
        int i4;
        xVar.bR(4);
        boolean ik = xVar.ik();
        xVar.bR(3);
        int bQ = xVar.bQ(16);
        int bQ2 = xVar.bQ(16);
        if (ik) {
            int bQ3 = xVar.bQ(16);
            int bQ4 = xVar.bQ(16);
            int bQ5 = xVar.bQ(16);
            i = xVar.bQ(16);
            i3 = bQ4;
            i2 = bQ5;
            i4 = bQ3;
        } else {
            i3 = bQ;
            i = bQ2;
            i4 = 0;
            i2 = 0;
        }
        return new C0054b(bQ, bQ2, i4, i3, i2, i);
    }

    private static d c(x xVar, int i) {
        int bQ = xVar.bQ(8);
        int bQ2 = xVar.bQ(4);
        int bQ3 = xVar.bQ(2);
        xVar.bR(2);
        int i2 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int bQ4 = xVar.bQ(8);
            xVar.bR(8);
            i2 -= 6;
            sparseArray.put(bQ4, new e(xVar.bQ(16), xVar.bQ(16)));
        }
        return new d(bQ, bQ2, bQ3, sparseArray);
    }

    private static f d(x xVar, int i) {
        int i2;
        int i3;
        x xVar2 = xVar;
        int bQ = xVar2.bQ(8);
        xVar2.bR(4);
        boolean ik = xVar.ik();
        xVar2.bR(3);
        int i4 = 16;
        int bQ2 = xVar2.bQ(16);
        int bQ3 = xVar2.bQ(16);
        int bQ4 = xVar2.bQ(3);
        int bQ5 = xVar2.bQ(3);
        int i5 = 2;
        xVar2.bR(2);
        int bQ6 = xVar2.bQ(8);
        int bQ7 = xVar2.bQ(8);
        int bQ8 = xVar2.bQ(4);
        int bQ9 = xVar2.bQ(2);
        xVar2.bR(2);
        int i6 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i6 > 0) {
            int bQ10 = xVar2.bQ(i4);
            int bQ11 = xVar2.bQ(i5);
            int bQ12 = xVar2.bQ(i5);
            int bQ13 = xVar2.bQ(12);
            int i7 = bQ9;
            xVar2.bR(4);
            int bQ14 = xVar2.bQ(12);
            int i8 = i6 - 6;
            if (bQ11 != 1) {
                if (bQ11 != 2) {
                    i6 = i8;
                    i3 = 0;
                    i2 = 0;
                    sparseArray.put(bQ10, new g(bQ11, bQ12, bQ13, bQ14, i3, i2));
                    bQ9 = i7;
                    i5 = 2;
                    i4 = 16;
                }
            }
            i6 -= 8;
            i3 = xVar2.bQ(8);
            i2 = xVar2.bQ(8);
            sparseArray.put(bQ10, new g(bQ11, bQ12, bQ13, bQ14, i3, i2));
            bQ9 = i7;
            i5 = 2;
            i4 = 16;
        }
        return new f(bQ, ik, bQ2, bQ3, bQ4, bQ5, bQ6, bQ7, bQ8, bQ9, sparseArray);
    }

    private static a e(x xVar, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        x xVar2 = xVar;
        int i7 = 8;
        int bQ = xVar2.bQ(8);
        xVar2.bR(8);
        int i8 = 2;
        int i9 = i - 2;
        int[] mB = mB();
        int[] mC = mC();
        int[] mD = mD();
        while (i9 > 0) {
            int bQ2 = xVar2.bQ(i7);
            int bQ3 = xVar2.bQ(i7);
            int[] iArr = (bQ3 & 128) != 0 ? mB : (bQ3 & 64) != 0 ? mC : mD;
            if ((bQ3 & 1) != 0) {
                i5 = xVar2.bQ(i7);
                i4 = xVar2.bQ(i7);
                i3 = xVar2.bQ(i7);
                i2 = xVar2.bQ(i7);
                i6 = i9 - 6;
            } else {
                i3 = xVar2.bQ(4) << 4;
                i6 = i9 - 4;
                int bQ4 = xVar2.bQ(4) << 4;
                i2 = xVar2.bQ(i8) << 6;
                i5 = xVar2.bQ(6) << i8;
                i4 = bQ4;
            }
            if (i5 == 0) {
                i4 = 0;
                i3 = 0;
                i2 = 255;
            }
            double d2 = (double) i5;
            double d3 = (double) (i4 - 128);
            double d4 = (double) (i3 - 128);
            iArr[bQ2] = c((byte) (255 - (i2 & 255)), ai.k((int) (d2 + (1.402d * d3)), 0, 255), ai.k((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255), ai.k((int) (d2 + (d4 * 1.772d)), 0, 255));
            i9 = i6;
            bQ = bQ;
            i7 = 8;
            i8 = 2;
        }
        return new a(bQ, mB, mC, mD);
    }

    private static c m(x xVar) {
        int bQ = xVar.bQ(16);
        xVar.bR(4);
        int bQ2 = xVar.bQ(2);
        boolean ik = xVar.ik();
        xVar.bR(1);
        byte[] bArr = ai.ada;
        byte[] bArr2 = ai.ada;
        if (bQ2 == 1) {
            xVar.bR(xVar.bQ(8) * 16);
        } else if (bQ2 == 0) {
            int bQ3 = xVar.bQ(16);
            int bQ4 = xVar.bQ(16);
            if (bQ3 > 0) {
                bArr = new byte[bQ3];
                xVar.r(bArr, 0, bQ3);
            }
            if (bQ4 > 0) {
                bArr2 = new byte[bQ4];
                xVar.r(bArr2, 0, bQ4);
            } else {
                bArr2 = bArr;
            }
        }
        return new c(bQ, ik, bArr, bArr2);
    }

    private static int[] mC() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                iArr[i] = c(255, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                int i2 = i & 1;
                int i3 = WorkQueueKt.MASK;
                int i4 = i2 != 0 ? WorkQueueKt.MASK : 0;
                int i5 = (i & 2) != 0 ? WorkQueueKt.MASK : 0;
                if ((i & 4) == 0) {
                    i3 = 0;
                }
                iArr[i] = c(255, i4, i5, i3);
            }
        }
        return iArr;
    }

    private static int[] mD() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            int i2 = 255;
            if (i < 8) {
                int i3 = (i & 1) != 0 ? 255 : 0;
                int i4 = (i & 2) != 0 ? 255 : 0;
                if ((i & 4) == 0) {
                    i2 = 0;
                }
                iArr[i] = c(63, i3, i4, i2);
            } else {
                int i5 = i & 136;
                int i6 = 170;
                int i7 = 85;
                if (i5 == 0) {
                    int i8 = ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0);
                    int i9 = ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0);
                    if ((i & 4) == 0) {
                        i7 = 0;
                    }
                    if ((i & 64) == 0) {
                        i6 = 0;
                    }
                    iArr[i] = c(255, i8, i9, i7 + i6);
                } else if (i5 != 8) {
                    int i10 = 43;
                    if (i5 == 128) {
                        int i11 = ((i & 1) != 0 ? 43 : 0) + WorkQueueKt.MASK + ((i & 16) != 0 ? 85 : 0);
                        int i12 = ((i & 2) != 0 ? 43 : 0) + WorkQueueKt.MASK + ((i & 32) != 0 ? 85 : 0);
                        if ((i & 4) == 0) {
                            i10 = 0;
                        }
                        int i13 = i10 + WorkQueueKt.MASK;
                        if ((i & 64) == 0) {
                            i7 = 0;
                        }
                        iArr[i] = c(255, i11, i12, i13 + i7);
                    } else if (i5 == 136) {
                        int i14 = ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0);
                        int i15 = ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0);
                        if ((i & 4) == 0) {
                            i10 = 0;
                        }
                        if ((i & 64) == 0) {
                            i7 = 0;
                        }
                        iArr[i] = c(255, i14, i15, i10 + i7);
                    }
                } else {
                    int i16 = ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0);
                    int i17 = ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0);
                    if ((i & 4) == 0) {
                        i7 = 0;
                    }
                    if ((i & 64) == 0) {
                        i6 = 0;
                    }
                    iArr[i] = c(WorkQueueKt.MASK, i16, i17, i7 + i6);
                }
            }
        }
        return iArr;
    }

    private static void a(c cVar, a aVar, int i, int i2, int i3, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i == 3) {
            iArr = aVar.Qx;
        } else if (i == 2) {
            iArr = aVar.Qw;
        } else {
            iArr = aVar.Qv;
        }
        int[] iArr2 = iArr;
        int i4 = i;
        int i5 = i2;
        Paint paint2 = paint;
        Canvas canvas2 = canvas;
        a(cVar.QD, iArr2, i4, i5, i3, paint2, canvas2);
        a(cVar.QE, iArr2, i4, i5, i3 + 1, paint2, canvas2);
    }

    private static void a(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        int i4 = i;
        byte[] bArr5 = bArr;
        x xVar = new x(bArr);
        int i5 = i2;
        int i6 = i3;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        byte[] bArr8 = null;
        while (xVar.pf() != 0) {
            int bQ = xVar.bQ(8);
            if (bQ != 240) {
                switch (bQ) {
                    case 16:
                        if (i4 != 3) {
                            if (i4 != 2) {
                                bArr2 = null;
                                i5 = a(xVar, iArr, bArr2, i5, i6, paint, canvas);
                                xVar.pi();
                                break;
                            } else {
                                bArr3 = bArr8 == null ? Qm : bArr8;
                            }
                        } else {
                            bArr3 = bArr6 == null ? Qn : bArr6;
                        }
                        bArr2 = bArr3;
                        i5 = a(xVar, iArr, bArr2, i5, i6, paint, canvas);
                        xVar.pi();
                    case 17:
                        if (i4 == 3) {
                            bArr4 = bArr7 == null ? Qo : bArr7;
                        } else {
                            bArr4 = null;
                        }
                        i5 = b(xVar, iArr, bArr4, i5, i6, paint, canvas);
                        xVar.pi();
                        break;
                    case 18:
                        i5 = c(xVar, iArr, (byte[]) null, i5, i6, paint, canvas);
                        break;
                    default:
                        switch (bQ) {
                            case 32:
                                bArr8 = a(4, 4, xVar);
                                break;
                            case 33:
                                bArr6 = a(4, 8, xVar);
                                break;
                            case 34:
                                bArr7 = a(16, 8, xVar);
                                break;
                        }
                }
            } else {
                i6 += 2;
                i5 = i2;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0083 A[LOOP:0: B:1:0x0009->B:31:0x0083, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(com.applovin.exoplayer2.l.x r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 2
            int r4 = r13.bQ(r3)
            r5 = 1
            if (r4 == 0) goto L_0x0014
            r11 = r2
        L_0x0012:
            r12 = 1
            goto L_0x0061
        L_0x0014:
            boolean r4 = r13.ik()
            r6 = 3
            if (r4 == 0) goto L_0x0028
            int r4 = r13.bQ(r6)
            int r4 = r4 + r6
            int r3 = r13.bQ(r3)
        L_0x0024:
            r11 = r2
            r12 = r4
            r4 = r3
            goto L_0x0061
        L_0x0028:
            boolean r4 = r13.ik()
            if (r4 == 0) goto L_0x0031
            r11 = r2
            r4 = 0
            goto L_0x0012
        L_0x0031:
            int r4 = r13.bQ(r3)
            if (r4 == 0) goto L_0x005e
            if (r4 == r5) goto L_0x005a
            if (r4 == r3) goto L_0x004e
            if (r4 == r6) goto L_0x0041
            r11 = r2
            r4 = 0
        L_0x003f:
            r12 = 0
            goto L_0x0061
        L_0x0041:
            r4 = 8
            int r4 = r13.bQ(r4)
            int r4 = r4 + 29
            int r3 = r13.bQ(r3)
            goto L_0x0024
        L_0x004e:
            r4 = 4
            int r4 = r13.bQ(r4)
            int r4 = r4 + 12
            int r3 = r13.bQ(r3)
            goto L_0x0024
        L_0x005a:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L_0x0061
        L_0x005e:
            r4 = 0
            r11 = 1
            goto L_0x003f
        L_0x0061:
            if (r12 == 0) goto L_0x007f
            if (r8 == 0) goto L_0x007f
            if (r15 == 0) goto L_0x0069
            byte r4 = r15[r4]
        L_0x0069:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x007f:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x0083
            return r10
        L_0x0083:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.b.b.a(com.applovin.exoplayer2.l.x, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0090 A[LOOP:0: B:1:0x0009->B:34:0x0090, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int b(com.applovin.exoplayer2.l.x r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 4
            int r4 = r13.bQ(r3)
            r5 = 1
            if (r4 == 0) goto L_0x0015
            r11 = r2
        L_0x0012:
            r12 = 1
            goto L_0x006e
        L_0x0015:
            boolean r4 = r13.ik()
            r6 = 3
            if (r4 != 0) goto L_0x002b
            int r3 = r13.bQ(r6)
            if (r3 == 0) goto L_0x0028
            int r3 = r3 + 2
            r11 = r2
            r12 = r3
            r4 = 0
            goto L_0x006e
        L_0x0028:
            r4 = 0
            r11 = 1
            goto L_0x004d
        L_0x002b:
            boolean r4 = r13.ik()
            r7 = 2
            if (r4 != 0) goto L_0x003f
            int r4 = r13.bQ(r7)
            int r4 = r4 + r3
            int r3 = r13.bQ(r3)
        L_0x003b:
            r11 = r2
            r12 = r4
            r4 = r3
            goto L_0x006e
        L_0x003f:
            int r4 = r13.bQ(r7)
            if (r4 == 0) goto L_0x006b
            if (r4 == r5) goto L_0x0067
            if (r4 == r7) goto L_0x005c
            if (r4 == r6) goto L_0x004f
            r11 = r2
            r4 = 0
        L_0x004d:
            r12 = 0
            goto L_0x006e
        L_0x004f:
            r4 = 8
            int r4 = r13.bQ(r4)
            int r4 = r4 + 25
            int r3 = r13.bQ(r3)
            goto L_0x003b
        L_0x005c:
            int r4 = r13.bQ(r3)
            int r4 = r4 + 9
            int r3 = r13.bQ(r3)
            goto L_0x003b
        L_0x0067:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L_0x006e
        L_0x006b:
            r11 = r2
            r4 = 0
            goto L_0x0012
        L_0x006e:
            if (r12 == 0) goto L_0x008c
            if (r8 == 0) goto L_0x008c
            if (r15 == 0) goto L_0x0076
            byte r4 = r15[r4]
        L_0x0076:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x008c:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x0090
            return r10
        L_0x0090:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.b.b.b(com.applovin.exoplayer2.l.x, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int c(com.applovin.exoplayer2.l.x r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 8
            int r4 = r13.bQ(r3)
            r5 = 1
            if (r4 == 0) goto L_0x0015
            r11 = r2
            r12 = 1
            goto L_0x0035
        L_0x0015:
            boolean r4 = r13.ik()
            r6 = 7
            if (r4 != 0) goto L_0x002a
            int r3 = r13.bQ(r6)
            if (r3 == 0) goto L_0x0026
            r11 = r2
            r12 = r3
            r4 = 0
            goto L_0x0035
        L_0x0026:
            r4 = 0
            r11 = 1
            r12 = 0
            goto L_0x0035
        L_0x002a:
            int r4 = r13.bQ(r6)
            int r3 = r13.bQ(r3)
            r11 = r2
            r12 = r4
            r4 = r3
        L_0x0035:
            if (r12 == 0) goto L_0x0053
            if (r8 == 0) goto L_0x0053
            if (r15 == 0) goto L_0x003d
            byte r4 = r15[r4]
        L_0x003d:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0053:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x0057
            return r10
        L_0x0057:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.b.b.c(com.applovin.exoplayer2.l.x, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    private static byte[] a(int i, int i2, x xVar) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) xVar.bQ(i2);
        }
        return bArr;
    }

    private static final class h {
        public final SparseArray<f> QG = new SparseArray<>();
        public final int QV;
        public final int QW;
        public final SparseArray<a> QX = new SparseArray<>();
        public final SparseArray<c> QY = new SparseArray<>();
        public final SparseArray<a> QZ = new SparseArray<>();
        public final SparseArray<c> Ra = new SparseArray<>();
        public C0054b Rb;
        public d Rc;

        public h(int i, int i2) {
            this.QV = i;
            this.QW = i2;
        }

        public void Y() {
            this.QG.clear();
            this.QX.clear();
            this.QY.clear();
            this.QZ.clear();
            this.Ra.clear();
            this.Rb = null;
            this.Rc = null;
        }
    }

    /* renamed from: com.applovin.exoplayer2.i.b.b$b  reason: collision with other inner class name */
    private static final class C0054b {
        public final int QA;
        public final int QB;
        public final int Qy;
        public final int Qz;
        public final int dE;
        public final int height;

        public C0054b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.dE = i;
            this.height = i2;
            this.Qy = i3;
            this.Qz = i4;
            this.QA = i5;
            this.QB = i6;
        }
    }

    private static final class d {
        public final int QF;
        public final SparseArray<e> QG;
        public final int Z;
        public final int mH;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.QF = i;
            this.mH = i2;
            this.Z = i3;
            this.QG = sparseArray;
        }
    }

    private static final class e {
        public final int QH;
        public final int QI;

        public e(int i, int i2) {
            this.QH = i;
            this.QI = i2;
        }
    }

    private static final class f {
        public final int Ju;
        public final boolean QJ;
        public final int QK;
        public final int QL;
        public final int QM;
        public final int QN;
        public final int QO;
        public final SparseArray<g> QP;
        public final int dE;
        public final int height;
        public final int zD;

        public f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.zD = i;
            this.QJ = z;
            this.dE = i2;
            this.height = i3;
            this.QK = i4;
            this.Ju = i5;
            this.QL = i6;
            this.QM = i7;
            this.QN = i8;
            this.QO = i9;
            this.QP = sparseArray;
        }

        public void a(f fVar) {
            SparseArray<g> sparseArray = fVar.QP;
            for (int i = 0; i < sparseArray.size(); i++) {
                this.QP.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
            }
        }
    }

    private static final class g {
        public final int QQ;
        public final int QR;
        public final int QS;
        public final int QT;
        public final int QU;
        public final int bs;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.bs = i;
            this.QQ = i2;
            this.QR = i3;
            this.QS = i4;
            this.QT = i5;
            this.QU = i6;
        }
    }

    private static final class a {
        public final int[] Qv;
        public final int[] Qw;
        public final int[] Qx;
        public final int zD;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.zD = i;
            this.Qv = iArr;
            this.Qw = iArr2;
            this.Qx = iArr3;
        }
    }

    private static final class c {
        public final boolean QC;
        public final byte[] QD;
        public final byte[] QE;
        public final int zD;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.zD = i;
            this.QC = z;
            this.QD = bArr;
            this.QE = bArr2;
        }
    }
}
