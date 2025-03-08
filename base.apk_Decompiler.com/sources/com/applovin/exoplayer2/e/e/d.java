package com.applovin.exoplayer2.e.e;

import android.util.Pair;
import android.util.SparseArray;
import androidx.work.impl.Scheduler;
import com.applovin.exoplayer2.d.e;
import com.applovin.exoplayer2.e.h;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.l;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.k.g;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.r;
import com.applovin.exoplayer2.l.v;
import com.applovin.exoplayer2.l.y;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.games.GamesStatusCodes;
import com.unity3d.services.core.device.MimeTypes;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

public class d implements h {
    public static final l vq = new d$$ExternalSyntheticLambda0();
    private static final byte[] wR = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    /* access modifiers changed from: private */
    public static final byte[] wS = ai.bk("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] wT = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    /* access modifiers changed from: private */
    public static final UUID wU = new UUID(72057594037932032L, -9223371306706625679L);
    /* access modifiers changed from: private */
    public static final Map<String, Integer> wV;
    private long fH;
    private final y uO;
    private j vG;
    private final f wL;
    private final c wW;
    private final SparseArray<b> wX;
    private final boolean wY;
    private final y wZ;
    private final y wm;
    private final y wn;
    private int xA;
    private int xB;
    private int[] xC;
    private int xD;
    private int xE;
    private int xF;
    private int xG;
    private boolean xH;
    private int xI;
    private int xJ;
    private int xK;
    private boolean xL;
    private boolean xM;
    private boolean xN;
    private int xO;
    private byte xP;
    private boolean xQ;
    private final y xa;
    private final y xb;
    private final y xc;
    private final y xd;
    private final y xe;
    private final y xf;
    private ByteBuffer xg;
    private long xh;
    private long xi;
    private long xj;
    private long xk;
    private b xl;
    private boolean xm;
    private int xn;
    private long xo;
    private boolean xp;
    private long xq;
    private long xr;
    private long xs;
    private r xt;
    private r xu;
    private boolean xv;
    private boolean xw;
    private int xx;
    private long xy;
    private long xz;

    public final void a(j jVar) {
        this.vG = jVar;
    }

    /* access modifiers changed from: protected */
    public int bX(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: protected */
    public boolean bY(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    public final void release() {
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        wV = Collections.unmodifiableMap(hashMap);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ h[] ih() {
        return new h[]{new d()};
    }

    public d() {
        this(0);
    }

    public d(int i) {
        this(new a(), i);
    }

    d(c cVar, int i) {
        this.xi = -1;
        this.xj = -9223372036854775807L;
        this.xk = -9223372036854775807L;
        this.fH = -9223372036854775807L;
        this.xq = -1;
        this.xr = -1;
        this.xs = -9223372036854775807L;
        this.wW = cVar;
        cVar.a(new a());
        this.wY = (i & 1) == 0;
        this.wL = new f();
        this.wX = new SparseArray<>();
        this.uO = new y(4);
        this.wZ = new y(ByteBuffer.allocate(4).putInt(-1).array());
        this.xa = new y(4);
        this.wm = new y(v.abK);
        this.wn = new y(4);
        this.xb = new y();
        this.xc = new y();
        this.xd = new y(8);
        this.xe = new y();
        this.xf = new y();
        this.xC = new int[1];
    }

    public final boolean a(i iVar) throws IOException {
        return new e().a(iVar);
    }

    public void o(long j, long j2) {
        this.xs = -9223372036854775807L;
        this.xx = 0;
        this.wW.Y();
        this.wL.Y();
        ix();
        for (int i = 0; i < this.wX.size(); i++) {
            this.wX.valueAt(i).Y();
        }
    }

    public final int b(i iVar, u uVar) throws IOException {
        this.xw = false;
        boolean z = true;
        while (z && !this.xw) {
            z = this.wW.y(iVar);
            if (z && a(uVar, iVar.ie())) {
                return 1;
            }
        }
        if (z) {
            return 0;
        }
        for (int i = 0; i < this.wX.size(); i++) {
            b valueAt = this.wX.valueAt(i);
            valueAt.iD();
            valueAt.iB();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void f(int i, long j, long j2) throws com.applovin.exoplayer2.ai {
        io();
        if (i == 160) {
            this.xH = false;
        } else if (i == 174) {
            this.xl = new b();
        } else if (i == 187) {
            this.xv = false;
        } else if (i == 19899) {
            this.xn = -1;
            this.xo = -1;
        } else if (i == 20533) {
            cc(i).xX = true;
        } else if (i == 21968) {
            cc(i).yi = true;
        } else if (i == 408125543) {
            long j3 = this.xi;
            if (j3 == -1 || j3 == j) {
                this.xi = j;
                this.xh = j2;
                return;
            }
            throw com.applovin.exoplayer2.ai.c("Multiple Segment elements not supported", (Throwable) null);
        } else if (i == 475249515) {
            this.xt = new r();
            this.xu = new r();
        } else if (i != 524531317 || this.xm) {
        } else {
            if (!this.wY || this.xq == -1) {
                this.vG.a(new v.b(this.fH));
                this.xm = true;
                return;
            }
            this.xp = true;
        }
    }

    /* access modifiers changed from: protected */
    public void bZ(int i) throws com.applovin.exoplayer2.ai {
        io();
        if (i != 160) {
            if (i == 174) {
                b bVar = (b) com.applovin.exoplayer2.l.a.N(this.xl);
                if (bVar.xS != null) {
                    if (G(bVar.xS)) {
                        bVar.a(this.vG, bVar.xT);
                        this.wX.put(bVar.xT, bVar);
                    }
                    this.xl = null;
                    return;
                }
                throw com.applovin.exoplayer2.ai.c("CodecId is missing in TrackEntry element", (Throwable) null);
            } else if (i == 19899) {
                int i2 = this.xn;
                if (i2 != -1) {
                    long j = this.xo;
                    if (j != -1) {
                        if (i2 == 475249515) {
                            this.xq = j;
                            return;
                        }
                        return;
                    }
                }
                throw com.applovin.exoplayer2.ai.c("Mandatory element SeekID or SeekPosition not found", (Throwable) null);
            } else if (i == 25152) {
                ca(i);
                if (!this.xl.xX) {
                    return;
                }
                if (this.xl.xZ != null) {
                    this.xl.dC = new e(new e.a(com.applovin.exoplayer2.h.aj, MimeTypes.VIDEO_WEBM, this.xl.xZ.uV));
                    return;
                }
                throw com.applovin.exoplayer2.ai.c("Encrypted Track found but ContentEncKeyID was not found", (Throwable) null);
            } else if (i == 28032) {
                ca(i);
                if (this.xl.xX && this.xl.xY != null) {
                    throw com.applovin.exoplayer2.ai.c("Combining encryption and compression is not supported", (Throwable) null);
                }
            } else if (i == 357149030) {
                if (this.xj == -9223372036854775807L) {
                    this.xj = 1000000;
                }
                long j2 = this.xk;
                if (j2 != -9223372036854775807L) {
                    this.fH = ap(j2);
                }
            } else if (i != 374648427) {
                if (i == 475249515) {
                    if (!this.xm) {
                        this.vG.a(a(this.xt, this.xu));
                        this.xm = true;
                    }
                    this.xt = null;
                    this.xu = null;
                }
            } else if (this.wX.size() != 0) {
                this.vG.ig();
            } else {
                throw com.applovin.exoplayer2.ai.c("No valid tracks were found", (Throwable) null);
            }
        } else if (this.xx == 2) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.xB; i4++) {
                i3 += this.xC[i4];
            }
            b bVar2 = this.wX.get(this.xD);
            bVar2.iD();
            for (int i5 = 0; i5 < this.xB; i5++) {
                long j3 = ((long) ((bVar2.xU * i5) / 1000)) + this.xy;
                int i6 = this.xF;
                if (i5 == 0 && !this.xH) {
                    i6 |= 1;
                }
                int i7 = this.xC[i5];
                i3 -= i7;
                a(bVar2, j3, i6, i7, i3);
            }
            this.xx = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void e(int i, long j) throws com.applovin.exoplayer2.ai {
        if (i != 20529) {
            if (i != 20530) {
                boolean z = false;
                switch (i) {
                    case 131:
                        cc(i).bs = (int) j;
                        return;
                    case 136:
                        b cc = cc(i);
                        if (j == 1) {
                            z = true;
                        }
                        cc.yE = z;
                        return;
                    case 155:
                        this.xz = ap(j);
                        return;
                    case 159:
                        cc(i).dL = (int) j;
                        return;
                    case 176:
                        cc(i).dE = (int) j;
                        return;
                    case 179:
                        cb(i);
                        this.xt.bo(ap(j));
                        return;
                    case 186:
                        cc(i).height = (int) j;
                        return;
                    case 215:
                        cc(i).xT = (int) j;
                        return;
                    case 231:
                        this.xs = ap(j);
                        return;
                    case 238:
                        this.xG = (int) j;
                        return;
                    case 241:
                        if (!this.xv) {
                            cb(i);
                            this.xu.bo(j);
                            this.xv = true;
                            return;
                        }
                        return;
                    case 251:
                        this.xH = true;
                        return;
                    case 16871:
                        int unused = cc(i).xW = (int) j;
                        return;
                    case 16980:
                        if (j != 3) {
                            throw com.applovin.exoplayer2.ai.c("ContentCompAlgo " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 17029:
                        if (j < 1 || j > 2) {
                            throw com.applovin.exoplayer2.ai.c("DocTypeReadVersion " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 17143:
                        if (j != 1) {
                            throw com.applovin.exoplayer2.ai.c("EBMLReadVersion " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 18401:
                        if (j != 5) {
                            throw com.applovin.exoplayer2.ai.c("ContentEncAlgo " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 18408:
                        if (j != 1) {
                            throw com.applovin.exoplayer2.ai.c("AESSettingsCipherMode " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 21420:
                        this.xo = j + this.xi;
                        return;
                    case 21432:
                        int i2 = (int) j;
                        ca(i);
                        if (i2 == 0) {
                            this.xl.dJ = 0;
                            return;
                        } else if (i2 == 1) {
                            this.xl.dJ = 2;
                            return;
                        } else if (i2 == 3) {
                            this.xl.dJ = 1;
                            return;
                        } else if (i2 == 15) {
                            this.xl.dJ = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        cc(i).yb = (int) j;
                        return;
                    case 21682:
                        cc(i).yd = (int) j;
                        return;
                    case 21690:
                        cc(i).yc = (int) j;
                        return;
                    case 21930:
                        b cc2 = cc(i);
                        if (j == 1) {
                            z = true;
                        }
                        cc2.yD = z;
                        return;
                    case 21998:
                        cc(i).xV = (int) j;
                        return;
                    case 22186:
                        cc(i).yA = j;
                        return;
                    case 22203:
                        cc(i).yB = j;
                        return;
                    case 25188:
                        cc(i).yz = (int) j;
                        return;
                    case 30321:
                        ca(i);
                        int i3 = (int) j;
                        if (i3 == 0) {
                            this.xl.ye = 0;
                            return;
                        } else if (i3 == 1) {
                            this.xl.ye = 1;
                            return;
                        } else if (i3 == 2) {
                            this.xl.ye = 2;
                            return;
                        } else if (i3 == 3) {
                            this.xl.ye = 3;
                            return;
                        } else {
                            return;
                        }
                    case 2352003:
                        cc(i).xU = (int) j;
                        return;
                    case 2807729:
                        this.xj = j;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                ca(i);
                                int i4 = (int) j;
                                if (i4 == 1) {
                                    this.xl.yl = 2;
                                    return;
                                } else if (i4 == 2) {
                                    this.xl.yl = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                ca(i);
                                int fO = com.applovin.exoplayer2.m.b.fO((int) j);
                                if (fO != -1) {
                                    this.xl.yk = fO;
                                    return;
                                }
                                return;
                            case 21947:
                                ca(i);
                                this.xl.yi = true;
                                int fN = com.applovin.exoplayer2.m.b.fN((int) j);
                                if (fN != -1) {
                                    this.xl.yj = fN;
                                    return;
                                }
                                return;
                            case 21948:
                                cc(i).ym = (int) j;
                                return;
                            case 21949:
                                cc(i).yn = (int) j;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j != 1) {
                throw com.applovin.exoplayer2.ai.c("ContentEncodingScope " + j + " not supported", (Throwable) null);
            }
        } else if (j != 0) {
            throw com.applovin.exoplayer2.ai.c("ContentEncodingOrder " + j + " not supported", (Throwable) null);
        }
    }

    /* access modifiers changed from: protected */
    public void b(int i, double d) throws com.applovin.exoplayer2.ai {
        if (i == 181) {
            cc(i).dM = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    cc(i).yo = (float) d;
                    return;
                case 21970:
                    cc(i).yp = (float) d;
                    return;
                case 21971:
                    cc(i).yq = (float) d;
                    return;
                case 21972:
                    cc(i).yr = (float) d;
                    return;
                case 21973:
                    cc(i).ys = (float) d;
                    return;
                case 21974:
                    cc(i).yt = (float) d;
                    return;
                case 21975:
                    cc(i).yu = (float) d;
                    return;
                case 21976:
                    cc(i).yv = (float) d;
                    return;
                case 21977:
                    cc(i).yw = (float) d;
                    return;
                case 21978:
                    cc(i).yx = (float) d;
                    return;
                default:
                    switch (i) {
                        case 30323:
                            cc(i).yf = (float) d;
                            return;
                        case 30324:
                            cc(i).yg = (float) d;
                            return;
                        case 30325:
                            cc(i).yh = (float) d;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.xk = (long) d;
        }
    }

    /* access modifiers changed from: protected */
    public void b(int i, String str) throws com.applovin.exoplayer2.ai {
        if (i == 134) {
            cc(i).xS = str;
        } else if (i != 17026) {
            if (i == 21358) {
                cc(i).name = str;
            } else if (i == 2274716) {
                String unused = cc(i).dq = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            throw com.applovin.exoplayer2.ai.c("DocType " + str + " not supported", (Throwable) null);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0239, code lost:
        throw com.applovin.exoplayer2.ai.c("EBML lacing sample size out of range.", (java.lang.Throwable) null);
     */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x028a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r22, int r23, com.applovin.exoplayer2.e.i r24) throws java.io.IOException {
        /*
            r21 = this;
            r7 = r21
            r0 = r22
            r1 = r23
            r8 = r24
            r2 = 161(0xa1, float:2.26E-43)
            r3 = 163(0xa3, float:2.28E-43)
            r4 = 0
            r5 = 2
            r9 = 0
            r10 = 1
            if (r0 == r2) goto L_0x00ce
            if (r0 == r3) goto L_0x00ce
            r2 = 165(0xa5, float:2.31E-43)
            if (r0 == r2) goto L_0x00b8
            r2 = 16877(0x41ed, float:2.365E-41)
            if (r0 == r2) goto L_0x00af
            r2 = 16981(0x4255, float:2.3795E-41)
            if (r0 == r2) goto L_0x009d
            r2 = 18402(0x47e2, float:2.5787E-41)
            if (r0 == r2) goto L_0x008b
            r2 = 21419(0x53ab, float:3.0014E-41)
            if (r0 == r2) goto L_0x0067
            r2 = 25506(0x63a2, float:3.5742E-41)
            if (r0 == r2) goto L_0x0055
            r2 = 30322(0x7672, float:4.249E-41)
            if (r0 != r2) goto L_0x0042
            r21.ca(r22)
            com.applovin.exoplayer2.e.e.d$b r0 = r7.xl
            byte[] r2 = new byte[r1]
            r0.dI = r2
            com.applovin.exoplayer2.e.e.d$b r0 = r7.xl
            byte[] r0 = r0.dI
            r8.a(r0, r9, r1)
            goto L_0x02f0
        L_0x0042:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected id: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.applovin.exoplayer2.ai r0 = com.applovin.exoplayer2.ai.c(r0, r4)
            throw r0
        L_0x0055:
            r21.ca(r22)
            com.applovin.exoplayer2.e.e.d$b r0 = r7.xl
            byte[] r2 = new byte[r1]
            r0.ya = r2
            com.applovin.exoplayer2.e.e.d$b r0 = r7.xl
            byte[] r0 = r0.ya
            r8.a(r0, r9, r1)
            goto L_0x02f0
        L_0x0067:
            com.applovin.exoplayer2.l.y r0 = r7.xa
            byte[] r0 = r0.hO()
            java.util.Arrays.fill(r0, r9)
            com.applovin.exoplayer2.l.y r0 = r7.xa
            byte[] r0 = r0.hO()
            int r2 = 4 - r1
            r8.a(r0, r2, r1)
            com.applovin.exoplayer2.l.y r0 = r7.xa
            r0.fx(r9)
            com.applovin.exoplayer2.l.y r0 = r7.xa
            long r0 = r0.pv()
            int r1 = (int) r0
            r7.xn = r1
            goto L_0x02f0
        L_0x008b:
            byte[] r2 = new byte[r1]
            r8.a(r2, r9, r1)
            com.applovin.exoplayer2.e.e.d$b r0 = r21.cc(r22)
            com.applovin.exoplayer2.e.x$a r1 = new com.applovin.exoplayer2.e.x$a
            r1.<init>(r10, r2, r9, r9)
            r0.xZ = r1
            goto L_0x02f0
        L_0x009d:
            r21.ca(r22)
            com.applovin.exoplayer2.e.e.d$b r0 = r7.xl
            byte[] r2 = new byte[r1]
            r0.xY = r2
            com.applovin.exoplayer2.e.e.d$b r0 = r7.xl
            byte[] r0 = r0.xY
            r8.a(r0, r9, r1)
            goto L_0x02f0
        L_0x00af:
            com.applovin.exoplayer2.e.e.d$b r0 = r21.cc(r22)
            r7.a((com.applovin.exoplayer2.e.e.d.b) r0, (com.applovin.exoplayer2.e.i) r8, (int) r1)
            goto L_0x02f0
        L_0x00b8:
            int r0 = r7.xx
            if (r0 == r5) goto L_0x00bd
            return
        L_0x00bd:
            android.util.SparseArray<com.applovin.exoplayer2.e.e.d$b> r0 = r7.wX
            int r2 = r7.xD
            java.lang.Object r0 = r0.get(r2)
            com.applovin.exoplayer2.e.e.d$b r0 = (com.applovin.exoplayer2.e.e.d.b) r0
            int r2 = r7.xG
            r7.a(r0, r2, r8, r1)
            goto L_0x02f0
        L_0x00ce:
            int r2 = r7.xx
            r6 = 8
            if (r2 != 0) goto L_0x00f3
            com.applovin.exoplayer2.e.e.f r2 = r7.wL
            long r11 = r2.a(r8, r9, r10, r6)
            int r2 = (int) r11
            r7.xD = r2
            com.applovin.exoplayer2.e.e.f r2 = r7.wL
            int r2 = r2.iE()
            r7.xE = r2
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.xz = r11
            r7.xx = r10
            com.applovin.exoplayer2.l.y r2 = r7.uO
            r2.U(r9)
        L_0x00f3:
            android.util.SparseArray<com.applovin.exoplayer2.e.e.d$b> r2 = r7.wX
            int r11 = r7.xD
            java.lang.Object r2 = r2.get(r11)
            r11 = r2
            com.applovin.exoplayer2.e.e.d$b r11 = (com.applovin.exoplayer2.e.e.d.b) r11
            if (r11 != 0) goto L_0x010a
            int r0 = r7.xE
            int r0 = r1 - r0
            r8.bH(r0)
            r7.xx = r9
            return
        L_0x010a:
            r11.iD()
            int r2 = r7.xx
            if (r2 != r10) goto L_0x02a6
            r2 = 3
            r7.h(r8, r2)
            com.applovin.exoplayer2.l.y r12 = r7.uO
            byte[] r12 = r12.hO()
            byte r12 = r12[r5]
            r12 = r12 & 6
            int r12 = r12 >> r10
            r13 = 255(0xff, float:3.57E-43)
            if (r12 != 0) goto L_0x0138
            r7.xB = r10
            int[] r4 = r7.xC
            int[] r4 = a((int[]) r4, (int) r10)
            r7.xC = r4
            int r12 = r7.xE
            int r1 = r1 - r12
            int r1 = r1 - r2
            r4[r9] = r1
        L_0x0134:
            r18 = r11
            goto L_0x024e
        L_0x0138:
            r14 = 4
            r7.h(r8, r14)
            com.applovin.exoplayer2.l.y r15 = r7.uO
            byte[] r15 = r15.hO()
            byte r15 = r15[r2]
            r15 = r15 & r13
            int r15 = r15 + r10
            r7.xB = r15
            int[] r3 = r7.xC
            int[] r3 = a((int[]) r3, (int) r15)
            r7.xC = r3
            if (r12 != r5) goto L_0x015d
            int r2 = r7.xE
            int r1 = r1 - r2
            int r1 = r1 - r14
            int r2 = r7.xB
            int r1 = r1 / r2
            java.util.Arrays.fill(r3, r9, r2, r1)
            goto L_0x0134
        L_0x015d:
            if (r12 != r10) goto L_0x0194
            r2 = 0
            r3 = 0
        L_0x0161:
            int r4 = r7.xB
            int r12 = r4 + -1
            if (r2 >= r12) goto L_0x0189
            int[] r4 = r7.xC
            r4[r2] = r9
        L_0x016b:
            int r4 = r14 + 1
            r7.h(r8, r4)
            com.applovin.exoplayer2.l.y r12 = r7.uO
            byte[] r12 = r12.hO()
            byte r12 = r12[r14]
            r12 = r12 & r13
            int[] r14 = r7.xC
            r15 = r14[r2]
            int r15 = r15 + r12
            r14[r2] = r15
            if (r12 == r13) goto L_0x0187
            int r3 = r3 + r15
            int r2 = r2 + 1
            r14 = r4
            goto L_0x0161
        L_0x0187:
            r14 = r4
            goto L_0x016b
        L_0x0189:
            int[] r2 = r7.xC
            int r4 = r4 - r10
            int r12 = r7.xE
            int r1 = r1 - r12
            int r1 = r1 - r14
            int r1 = r1 - r3
            r2[r4] = r1
            goto L_0x0134
        L_0x0194:
            if (r12 != r2) goto L_0x0293
            r2 = 0
            r3 = 0
        L_0x0198:
            int r12 = r7.xB
            int r15 = r12 + -1
            if (r2 >= r15) goto L_0x0241
            int[] r12 = r7.xC
            r12[r2] = r9
            int r12 = r14 + 1
            r7.h(r8, r12)
            com.applovin.exoplayer2.l.y r15 = r7.uO
            byte[] r15 = r15.hO()
            byte r15 = r15[r14]
            if (r15 == 0) goto L_0x023a
            r15 = 0
        L_0x01b2:
            if (r15 >= r6) goto L_0x0207
            int r16 = 7 - r15
            int r5 = r10 << r16
            com.applovin.exoplayer2.l.y r9 = r7.uO
            byte[] r9 = r9.hO()
            byte r9 = r9[r14]
            r9 = r9 & r5
            if (r9 == 0) goto L_0x01fd
            int r12 = r12 + r15
            r7.h(r8, r12)
            com.applovin.exoplayer2.l.y r9 = r7.uO
            byte[] r9 = r9.hO()
            int r17 = r14 + 1
            byte r9 = r9[r14]
            r9 = r9 & r13
            int r5 = ~r5
            r5 = r5 & r9
            r18 = r11
            long r10 = (long) r5
            r5 = r17
        L_0x01d9:
            if (r5 >= r12) goto L_0x01ee
            long r10 = r10 << r6
            com.applovin.exoplayer2.l.y r14 = r7.uO
            byte[] r14 = r14.hO()
            int r17 = r5 + 1
            byte r5 = r14[r5]
            r5 = r5 & r13
            long r13 = (long) r5
            long r10 = r10 | r13
            r5 = r17
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x01d9
        L_0x01ee:
            if (r2 <= 0) goto L_0x020b
            int r15 = r15 * 7
            int r15 = r15 + 6
            r13 = 1
            long r19 = r13 << r15
            long r19 = r19 - r13
            long r10 = r10 - r19
            goto L_0x020b
        L_0x01fd:
            r18 = r11
            int r15 = r15 + 1
            r5 = 2
            r9 = 0
            r10 = 1
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x01b2
        L_0x0207:
            r18 = r11
            r10 = 0
        L_0x020b:
            r14 = r12
            r12 = -2147483648(0xffffffff80000000, double:NaN)
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 < 0) goto L_0x0233
            r12 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 > 0) goto L_0x0233
            int r5 = (int) r10
            int[] r10 = r7.xC
            if (r2 != 0) goto L_0x0220
            goto L_0x0225
        L_0x0220:
            int r11 = r2 + -1
            r11 = r10[r11]
            int r5 = r5 + r11
        L_0x0225:
            r10[r2] = r5
            int r3 = r3 + r5
            int r2 = r2 + 1
            r11 = r18
            r5 = 2
            r9 = 0
            r10 = 1
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x0198
        L_0x0233:
            java.lang.String r0 = "EBML lacing sample size out of range."
            com.applovin.exoplayer2.ai r0 = com.applovin.exoplayer2.ai.c(r0, r4)
            throw r0
        L_0x023a:
            java.lang.String r0 = "No valid varint length mask found"
            com.applovin.exoplayer2.ai r0 = com.applovin.exoplayer2.ai.c(r0, r4)
            throw r0
        L_0x0241:
            r18 = r11
            int[] r2 = r7.xC
            r4 = 1
            int r12 = r12 - r4
            int r4 = r7.xE
            int r1 = r1 - r4
            int r1 = r1 - r14
            int r1 = r1 - r3
            r2[r12] = r1
        L_0x024e:
            com.applovin.exoplayer2.l.y r1 = r7.uO
            byte[] r1 = r1.hO()
            r2 = 0
            byte r1 = r1[r2]
            int r1 = r1 << r6
            com.applovin.exoplayer2.l.y r2 = r7.uO
            byte[] r2 = r2.hO()
            r3 = 1
            byte r2 = r2[r3]
            r3 = 255(0xff, float:3.57E-43)
            r2 = r2 & r3
            r1 = r1 | r2
            long r2 = r7.xs
            long r4 = (long) r1
            long r4 = r7.ap(r4)
            long r2 = r2 + r4
            r7.xy = r2
            r10 = r18
            int r1 = r10.bs
            r2 = 2
            if (r1 == r2) goto L_0x028a
            r1 = 163(0xa3, float:2.28E-43)
            if (r0 != r1) goto L_0x0288
            com.applovin.exoplayer2.l.y r1 = r7.uO
            byte[] r1 = r1.hO()
            byte r1 = r1[r2]
            r3 = 128(0x80, float:1.794E-43)
            r1 = r1 & r3
            if (r1 != r3) goto L_0x0288
            goto L_0x028a
        L_0x0288:
            r1 = 0
            goto L_0x028b
        L_0x028a:
            r1 = 1
        L_0x028b:
            r7.xF = r1
            r7.xx = r2
            r1 = 0
            r7.xA = r1
            goto L_0x02a7
        L_0x0293:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unexpected lacing value: "
            r0.<init>(r1)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            com.applovin.exoplayer2.ai r0 = com.applovin.exoplayer2.ai.c(r0, r4)
            throw r0
        L_0x02a6:
            r10 = r11
        L_0x02a7:
            r1 = 163(0xa3, float:2.28E-43)
            if (r0 != r1) goto L_0x02d9
        L_0x02ab:
            int r0 = r7.xA
            int r1 = r7.xB
            if (r0 >= r1) goto L_0x02d5
            int[] r1 = r7.xC
            r0 = r1[r0]
            int r5 = r7.a((com.applovin.exoplayer2.e.i) r8, (com.applovin.exoplayer2.e.e.d.b) r10, (int) r0)
            long r0 = r7.xy
            int r2 = r7.xA
            int r3 = r10.xU
            int r2 = r2 * r3
            int r2 = r2 / 1000
            long r2 = (long) r2
            long r2 = r2 + r0
            int r4 = r7.xF
            r6 = 0
            r0 = r21
            r1 = r10
            r0.a(r1, r2, r4, r5, r6)
            int r0 = r7.xA
            r1 = 1
            int r0 = r0 + r1
            r7.xA = r0
            goto L_0x02ab
        L_0x02d5:
            r0 = 0
            r7.xx = r0
            goto L_0x02f0
        L_0x02d9:
            int r0 = r7.xA
            int r1 = r7.xB
            if (r0 >= r1) goto L_0x02f0
            int[] r1 = r7.xC
            r2 = r1[r0]
            int r2 = r7.a((com.applovin.exoplayer2.e.i) r8, (com.applovin.exoplayer2.e.e.d.b) r10, (int) r2)
            r1[r0] = r2
            int r0 = r7.xA
            r1 = 1
            int r0 = r0 + r1
            r7.xA = r0
            goto L_0x02d9
        L_0x02f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.e.d.a(int, int, com.applovin.exoplayer2.e.i):void");
    }

    /* access modifiers changed from: protected */
    public void a(b bVar, i iVar, int i) throws IOException {
        if (bVar.xW == 1685485123 || bVar.xW == 1685480259) {
            bVar.yy = new byte[i];
            iVar.a(bVar.yy, 0, i);
            return;
        }
        iVar.bH(i);
    }

    /* access modifiers changed from: protected */
    public void a(b bVar, int i, i iVar, int i2) throws IOException {
        if (i != 4 || !"V_VP9".equals(bVar.xS)) {
            iVar.bH(i2);
            return;
        }
        this.xf.U(i2);
        iVar.a(this.xf.hO(), 0, i2);
    }

    private void ca(int i) throws com.applovin.exoplayer2.ai {
        if (this.xl == null) {
            throw com.applovin.exoplayer2.ai.c("Element " + i + " must be in a TrackEntry", (Throwable) null);
        }
    }

    private void cb(int i) throws com.applovin.exoplayer2.ai {
        if (this.xt == null || this.xu == null) {
            throw com.applovin.exoplayer2.ai.c("Element " + i + " must be in a Cues", (Throwable) null);
        }
    }

    private b cc(int i) throws com.applovin.exoplayer2.ai {
        ca(i);
        return this.xl;
    }

    private void a(b bVar, long j, int i, int i2, int i3) {
        if (bVar.yC != null) {
            bVar.yC.b(bVar, j, i, i2, i3);
        } else {
            if ("S_TEXT/UTF8".equals(bVar.xS) || "S_TEXT/ASS".equals(bVar.xS)) {
                if (this.xB > 1) {
                    q.h("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else if (this.xz == -9223372036854775807L) {
                    q.h("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                } else {
                    a(bVar.xS, this.xz, this.xc.hO());
                    int il = this.xc.il();
                    while (true) {
                        if (il >= this.xc.pk()) {
                            break;
                        } else if (this.xc.hO()[il] == 0) {
                            this.xc.fA(il);
                            break;
                        } else {
                            il++;
                        }
                    }
                    x xVar = bVar.wl;
                    y yVar = this.xc;
                    xVar.c(yVar, yVar.pk());
                    i2 += this.xc.pk();
                }
            }
            if ((268435456 & i) != 0) {
                if (this.xB > 1) {
                    i &= -268435457;
                } else {
                    int pk = this.xf.pk();
                    bVar.wl.a(this.xf, pk, 2);
                    i2 += pk;
                }
            }
            bVar.wl.a(j, i, i2, i3, bVar.xZ);
        }
        this.xw = true;
    }

    private void h(i iVar, int i) throws IOException {
        if (this.uO.pk() < i) {
            if (this.uO.pl() < i) {
                y yVar = this.uO;
                yVar.bj(Math.max(yVar.pl() * 2, i));
            }
            iVar.a(this.uO.hO(), this.uO.pk(), i - this.uO.pk());
            this.uO.fA(i);
        }
    }

    private int a(i iVar, b bVar, int i) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(bVar.xS)) {
            a(iVar, wR, i);
            return iw();
        } else if ("S_TEXT/ASS".equals(bVar.xS)) {
            a(iVar, wT, i);
            return iw();
        } else {
            x xVar = bVar.wl;
            boolean z = true;
            if (!this.xL) {
                if (bVar.xX) {
                    this.xF &= -1073741825;
                    int i3 = 128;
                    if (!this.xM) {
                        iVar.a(this.uO.hO(), 0, 1);
                        this.xI++;
                        if ((this.uO.hO()[0] & ByteCompanionObject.MIN_VALUE) != 128) {
                            this.xP = this.uO.hO()[0];
                            this.xM = true;
                        } else {
                            throw com.applovin.exoplayer2.ai.c("Extension bit is set in signal byte", (Throwable) null);
                        }
                    }
                    byte b2 = this.xP;
                    if ((b2 & 1) == 1) {
                        boolean z2 = (b2 & 2) == 2;
                        this.xF |= 1073741824;
                        if (!this.xQ) {
                            iVar.a(this.xd.hO(), 0, 8);
                            this.xI += 8;
                            this.xQ = true;
                            byte[] hO = this.uO.hO();
                            if (!z2) {
                                i3 = 0;
                            }
                            hO[0] = (byte) (i3 | 8);
                            this.uO.fx(0);
                            xVar.a(this.uO, 1, 1);
                            this.xJ++;
                            this.xd.fx(0);
                            xVar.a(this.xd, 8, 1);
                            this.xJ += 8;
                        }
                        if (z2) {
                            if (!this.xN) {
                                iVar.a(this.uO.hO(), 0, 1);
                                this.xI++;
                                this.uO.fx(0);
                                this.xO = this.uO.po();
                                this.xN = true;
                            }
                            int i4 = this.xO * 4;
                            this.uO.U(i4);
                            iVar.a(this.uO.hO(), 0, i4);
                            this.xI += i4;
                            short s = (short) ((this.xO / 2) + 1);
                            int i5 = (s * 6) + 2;
                            ByteBuffer byteBuffer = this.xg;
                            if (byteBuffer == null || byteBuffer.capacity() < i5) {
                                this.xg = ByteBuffer.allocate(i5);
                            }
                            this.xg.position(0);
                            this.xg.putShort(s);
                            int i6 = 0;
                            int i7 = 0;
                            while (true) {
                                i2 = this.xO;
                                if (i6 >= i2) {
                                    break;
                                }
                                int pD = this.uO.pD();
                                if (i6 % 2 == 0) {
                                    this.xg.putShort((short) (pD - i7));
                                } else {
                                    this.xg.putInt(pD - i7);
                                }
                                i6++;
                                i7 = pD;
                            }
                            int i8 = (i - this.xI) - i7;
                            if (i2 % 2 == 1) {
                                this.xg.putInt(i8);
                            } else {
                                this.xg.putShort((short) i8);
                                this.xg.putInt(0);
                            }
                            this.xe.l(this.xg.array(), i5);
                            xVar.a(this.xe, i5, 1);
                            this.xJ += i5;
                        }
                    }
                } else if (bVar.xY != null) {
                    this.xb.l(bVar.xY, bVar.xY.length);
                }
                if (bVar.xV > 0) {
                    this.xF |= DriveFile.MODE_READ_ONLY;
                    this.xf.U(0);
                    this.uO.U(4);
                    this.uO.hO()[0] = (byte) ((i >> 24) & 255);
                    this.uO.hO()[1] = (byte) ((i >> 16) & 255);
                    this.uO.hO()[2] = (byte) ((i >> 8) & 255);
                    this.uO.hO()[3] = (byte) (i & 255);
                    xVar.a(this.uO, 4, 2);
                    this.xJ += 4;
                }
                this.xL = true;
            }
            int pk = i + this.xb.pk();
            if (!"V_MPEG4/ISO/AVC".equals(bVar.xS) && !"V_MPEGH/ISO/HEVC".equals(bVar.xS)) {
                if (bVar.yC != null) {
                    if (this.xb.pk() != 0) {
                        z = false;
                    }
                    com.applovin.exoplayer2.l.a.checkState(z);
                    bVar.yC.A(iVar);
                }
                while (true) {
                    int i9 = this.xI;
                    if (i9 >= pk) {
                        break;
                    }
                    int a2 = a(iVar, xVar, pk - i9);
                    this.xI += a2;
                    this.xJ += a2;
                }
            } else {
                byte[] hO2 = this.wn.hO();
                hO2[0] = 0;
                hO2[1] = 0;
                hO2[2] = 0;
                int i10 = bVar.wo;
                int i11 = 4 - bVar.wo;
                while (this.xI < pk) {
                    int i12 = this.xK;
                    if (i12 == 0) {
                        c(iVar, hO2, i11, i10);
                        this.xI += i10;
                        this.wn.fx(0);
                        this.xK = this.wn.pD();
                        this.wm.fx(0);
                        xVar.c(this.wm, 4);
                        this.xJ += 4;
                    } else {
                        int a3 = a(iVar, xVar, i12);
                        this.xI += a3;
                        this.xJ += a3;
                        this.xK -= a3;
                    }
                }
            }
            if ("A_VORBIS".equals(bVar.xS)) {
                this.wZ.fx(0);
                xVar.c(this.wZ, 4);
                this.xJ += 4;
            }
            return iw();
        }
    }

    private int iw() {
        int i = this.xJ;
        ix();
        return i;
    }

    private void ix() {
        this.xI = 0;
        this.xJ = 0;
        this.xK = 0;
        this.xL = false;
        this.xM = false;
        this.xN = false;
        this.xO = 0;
        this.xP = 0;
        this.xQ = false;
        this.xb.U(0);
    }

    private void a(i iVar, byte[] bArr, int i) throws IOException {
        int length = bArr.length + i;
        if (this.xc.pl() < length) {
            this.xc.I(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, this.xc.hO(), 0, bArr.length);
        }
        iVar.a(this.xc.hO(), bArr.length, i);
        this.xc.fx(0);
        this.xc.fA(length);
    }

    private static void a(String str, long j, byte[] bArr) {
        int i;
        byte[] bArr2;
        str.hashCode();
        if (str.equals("S_TEXT/ASS")) {
            bArr2 = a(j, "%01d:%02d:%02d:%02d", 10000);
            i = 21;
        } else if (str.equals("S_TEXT/UTF8")) {
            bArr2 = a(j, "%02d:%02d:%02d,%03d", 1000);
            i = 19;
        } else {
            throw new IllegalArgumentException();
        }
        System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
    }

    private static byte[] a(long j, String str, long j2) {
        com.applovin.exoplayer2.l.a.checkArgument(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - (((long) (i * 3600)) * 1000000);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (((long) (i2 * 60)) * 1000000);
        int i3 = (int) (j4 / 1000000);
        return ai.bk(String.format(Locale.US, str, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2))}));
    }

    private void c(i iVar, byte[] bArr, int i, int i2) throws IOException {
        int min = Math.min(i2, this.xb.pj());
        iVar.a(bArr, i + min, i2 - min);
        if (min > 0) {
            this.xb.r(bArr, i, min);
        }
    }

    private int a(i iVar, x xVar, int i) throws IOException {
        int pj = this.xb.pj();
        if (pj <= 0) {
            return xVar.a((g) iVar, i, false);
        }
        int min = Math.min(i, pj);
        xVar.c(this.xb, min);
        return min;
    }

    private com.applovin.exoplayer2.e.v a(r rVar, r rVar2) {
        int i;
        if (this.xi == -1 || this.fH == -9223372036854775807L || rVar == null || rVar.size() == 0 || rVar2 == null || rVar2.size() != rVar.size()) {
            return new v.b(this.fH);
        }
        int size = rVar.size();
        int[] iArr = new int[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        long[] jArr3 = new long[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            jArr3[i3] = rVar.fu(i3);
            jArr[i3] = this.xi + rVar2.fu(i3);
        }
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            int i4 = i2 + 1;
            iArr[i2] = (int) (jArr[i4] - jArr[i2]);
            jArr2[i2] = jArr3[i4] - jArr3[i2];
            i2 = i4;
        }
        iArr[i] = (int) ((this.xi + this.xh) - jArr[i]);
        long j = this.fH - jArr3[i];
        jArr2[i] = j;
        if (j <= 0) {
            q.h("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j);
            iArr = Arrays.copyOf(iArr, i);
            jArr = Arrays.copyOf(jArr, i);
            jArr2 = Arrays.copyOf(jArr2, i);
            jArr3 = Arrays.copyOf(jArr3, i);
        }
        return new com.applovin.exoplayer2.e.c(iArr, jArr, jArr2, jArr3);
    }

    private boolean a(u uVar, long j) {
        if (this.xp) {
            this.xr = j;
            uVar.uc = this.xq;
            this.xp = false;
            return true;
        }
        if (this.xm) {
            long j2 = this.xr;
            if (j2 != -1) {
                uVar.uc = j2;
                this.xr = -1;
                return true;
            }
        }
        return false;
    }

    private long ap(long j) throws com.applovin.exoplayer2.ai {
        long j2 = this.xj;
        if (j2 != -9223372036854775807L) {
            return ai.e(j, j2, 1000);
        }
        throw com.applovin.exoplayer2.ai.c("Can't scale timecode prior to timecodeScale being set.", (Throwable) null);
    }

    private static boolean G(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals("V_MPEG4/ISO/AP")) {
                    c2 = 0;
                    break;
                }
                break;
            case -2095575984:
                if (str.equals("V_MPEG4/ISO/SP")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1985379776:
                if (str.equals("A_MS/ACM")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1784763192:
                if (str.equals("A_TRUEHD")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1730367663:
                if (str.equals("A_VORBIS")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1482641358:
                if (str.equals("A_MPEG/L2")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1482641357:
                if (str.equals("A_MPEG/L3")) {
                    c2 = 6;
                    break;
                }
                break;
            case -1373388978:
                if (str.equals("V_MS/VFW/FOURCC")) {
                    c2 = 7;
                    break;
                }
                break;
            case -933872740:
                if (str.equals("S_DVBSUB")) {
                    c2 = 8;
                    break;
                }
                break;
            case -538363189:
                if (str.equals("V_MPEG4/ISO/ASP")) {
                    c2 = 9;
                    break;
                }
                break;
            case -538363109:
                if (str.equals("V_MPEG4/ISO/AVC")) {
                    c2 = 10;
                    break;
                }
                break;
            case -425012669:
                if (str.equals("S_VOBSUB")) {
                    c2 = 11;
                    break;
                }
                break;
            case -356037306:
                if (str.equals("A_DTS/LOSSLESS")) {
                    c2 = 12;
                    break;
                }
                break;
            case 62923557:
                if (str.equals("A_AAC")) {
                    c2 = 13;
                    break;
                }
                break;
            case 62923603:
                if (str.equals("A_AC3")) {
                    c2 = 14;
                    break;
                }
                break;
            case 62927045:
                if (str.equals("A_DTS")) {
                    c2 = 15;
                    break;
                }
                break;
            case 82318131:
                if (str.equals("V_AV1")) {
                    c2 = 16;
                    break;
                }
                break;
            case 82338133:
                if (str.equals("V_VP8")) {
                    c2 = 17;
                    break;
                }
                break;
            case 82338134:
                if (str.equals("V_VP9")) {
                    c2 = 18;
                    break;
                }
                break;
            case 99146302:
                if (str.equals("S_HDMV/PGS")) {
                    c2 = 19;
                    break;
                }
                break;
            case 444813526:
                if (str.equals("V_THEORA")) {
                    c2 = 20;
                    break;
                }
                break;
            case 542569478:
                if (str.equals("A_DTS/EXPRESS")) {
                    c2 = 21;
                    break;
                }
                break;
            case 635596514:
                if (str.equals("A_PCM/FLOAT/IEEE")) {
                    c2 = 22;
                    break;
                }
                break;
            case 725948237:
                if (str.equals("A_PCM/INT/BIG")) {
                    c2 = 23;
                    break;
                }
                break;
            case 725957860:
                if (str.equals("A_PCM/INT/LIT")) {
                    c2 = 24;
                    break;
                }
                break;
            case 738597099:
                if (str.equals("S_TEXT/ASS")) {
                    c2 = 25;
                    break;
                }
                break;
            case 855502857:
                if (str.equals("V_MPEGH/ISO/HEVC")) {
                    c2 = 26;
                    break;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    c2 = 27;
                    break;
                }
                break;
            case 1809237540:
                if (str.equals("V_MPEG2")) {
                    c2 = 28;
                    break;
                }
                break;
            case 1950749482:
                if (str.equals("A_EAC3")) {
                    c2 = 29;
                    break;
                }
                break;
            case 1950789798:
                if (str.equals("A_FLAC")) {
                    c2 = 30;
                    break;
                }
                break;
            case 1951062397:
                if (str.equals("A_OPUS")) {
                    c2 = 31;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
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
                return true;
            default:
                return false;
        }
    }

    private static int[] a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        if (iArr.length >= i) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i)];
    }

    private void io() {
        com.applovin.exoplayer2.l.a.N(this.vG);
    }

    private final class a implements b {
        private a() {
        }

        public int bX(int i) {
            return d.this.bX(i);
        }

        public boolean bY(int i) {
            return d.this.bY(i);
        }

        public void f(int i, long j, long j2) throws com.applovin.exoplayer2.ai {
            d.this.f(i, j, j2);
        }

        public void bZ(int i) throws com.applovin.exoplayer2.ai {
            d.this.bZ(i);
        }

        public void e(int i, long j) throws com.applovin.exoplayer2.ai {
            d.this.e(i, j);
        }

        public void b(int i, double d) throws com.applovin.exoplayer2.ai {
            d.this.b(i, d);
        }

        public void b(int i, String str) throws com.applovin.exoplayer2.ai {
            d.this.b(i, str);
        }

        public void a(int i, int i2, i iVar) throws IOException {
            d.this.a(i, i2, iVar);
        }
    }

    private static final class c {
        private final byte[] yF = new byte[10];
        private boolean yG;
        private int yH;
        private long yI;
        private int yJ;
        private int yK;
        private int yL;

        public void Y() {
            this.yG = false;
            this.yH = 0;
        }

        public void A(i iVar) throws IOException {
            if (!this.yG) {
                iVar.c(this.yF, 0, 10);
                iVar.ic();
                if (com.applovin.exoplayer2.b.b.d(this.yF) != 0) {
                    this.yG = true;
                }
            }
        }

        public void b(b bVar, long j, int i, int i2, int i3) {
            if (this.yG) {
                int i4 = this.yH;
                int i5 = i4 + 1;
                this.yH = i5;
                if (i4 == 0) {
                    this.yI = j;
                    this.yJ = i;
                    this.yK = 0;
                }
                this.yK += i2;
                this.yL = i3;
                if (i5 >= 16) {
                    c(bVar);
                }
            }
        }

        public void c(b bVar) {
            if (this.yH > 0) {
                bVar.wl.a(this.yI, this.yJ, this.yK, this.yL, bVar.xZ);
                this.yH = 0;
            }
        }
    }

    private static final class b {
        public int bs;
        public e dC;
        public int dE;
        public byte[] dI;
        public int dJ;
        public int dL;
        public int dM;
        /* access modifiers changed from: private */
        public String dq;
        public int height;
        public String name;
        public x wl;
        public int wo;
        public String xS;
        public int xT;
        public int xU;
        public int xV;
        /* access modifiers changed from: private */
        public int xW;
        public boolean xX;
        public byte[] xY;
        public x.a xZ;
        public long yA;
        public long yB;
        public c yC;
        public boolean yD;
        public boolean yE;
        public byte[] ya;
        public int yb;
        public int yc;
        public int yd;
        public int ye;
        public float yf;
        public float yg;
        public float yh;
        public boolean yi;
        public int yj;
        public int yk;
        public int yl;
        public int ym;
        public int yn;
        public float yo;
        public float yp;
        public float yq;
        public float yr;
        public float ys;
        public float yt;
        public float yu;
        public float yv;
        public float yw;
        public float yx;
        public byte[] yy;
        public int yz;

        private b() {
            this.dE = -1;
            this.height = -1;
            this.yb = -1;
            this.yc = -1;
            this.yd = 0;
            this.ye = -1;
            this.yf = 0.0f;
            this.yg = 0.0f;
            this.yh = 0.0f;
            this.dI = null;
            this.dJ = -1;
            this.yi = false;
            this.yj = -1;
            this.yk = -1;
            this.yl = -1;
            this.ym = 1000;
            this.yn = Scheduler.MAX_GREEDY_SCHEDULER_LIMIT;
            this.yo = -1.0f;
            this.yp = -1.0f;
            this.yq = -1.0f;
            this.yr = -1.0f;
            this.ys = -1.0f;
            this.yt = -1.0f;
            this.yu = -1.0f;
            this.yv = -1.0f;
            this.yw = -1.0f;
            this.yx = -1.0f;
            this.dL = 1;
            this.yz = -1;
            this.dM = GamesStatusCodes.STATUS_MILESTONE_CLAIMED_PREVIOUSLY;
            this.yA = 0;
            this.yB = 0;
            this.yE = true;
            this.dq = "eng";
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v12, resolved type: java.lang.String} */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x0288, code lost:
            r1 = null;
            r3 = null;
            r4 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x02de, code lost:
            r1 = null;
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x02e0, code lost:
            r4 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x02e1, code lost:
            r7 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x0333, code lost:
            r4 = -1;
            r7 = -1;
            r18 = r3;
            r3 = r1;
            r1 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x0367, code lost:
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x036f, code lost:
            r1 = null;
            r3 = null;
            r4 = 4096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x03c8, code lost:
            r1 = null;
            r3 = null;
            r16 = "audio/x-unknown";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x03db, code lost:
            r5 = r0.yy;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x03dd, code lost:
            if (r5 == null) goto L_0x03ee;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x03df, code lost:
            r5 = com.applovin.exoplayer2.m.c.au(new com.applovin.exoplayer2.l.y(r5));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x03e8, code lost:
            if (r5 == null) goto L_0x03ee;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x03ea, code lost:
            r3 = r5.dw;
            r16 = "video/dolby-vision";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x03ee, code lost:
            r5 = r16;
            r6 = r0.yE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x03f4, code lost:
            if (r0.yD == false) goto L_0x03f8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x03f6, code lost:
            r8 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x03f8, code lost:
            r8 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x03f9, code lost:
            r6 = r6 | r8;
            r8 = new com.applovin.exoplayer2.v.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x0403, code lost:
            if (com.applovin.exoplayer2.l.u.aW(r5) == false) goto L_0x0417;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x0405, code lost:
            r8.N(r0.dL).O(r0.dM).P(r7);
            r2 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x041b, code lost:
            if (com.applovin.exoplayer2.l.u.aX(r5) == false) goto L_0x04f0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x041f, code lost:
            if (r0.yd != 0) goto L_0x0431;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x0421, code lost:
            r2 = r0.yb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x0423, code lost:
            if (r2 != -1) goto L_0x0427;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x0425, code lost:
            r2 = r0.dE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x0427, code lost:
            r0.yb = r2;
            r2 = r0.yc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x042b, code lost:
            if (r2 != -1) goto L_0x042f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:0x042d, code lost:
            r2 = r0.height;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x042f, code lost:
            r0.yc = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x0431, code lost:
            r2 = r0.yb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x0433, code lost:
            if (r2 == -1) goto L_0x0445;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x0435, code lost:
            r7 = r0.yc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x0437, code lost:
            if (r7 == -1) goto L_0x0445;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x0439, code lost:
            r2 = ((float) (r0.height * r2)) / ((float) (r0.dE * r7));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:186:0x0445, code lost:
            r2 = -1.0f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x0449, code lost:
            if (r0.yi == false) goto L_0x045a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x044b, code lost:
            r15 = new com.applovin.exoplayer2.m.b(r0.yj, r0.yl, r0.yk, iC());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x045c, code lost:
            if (r0.name == null) goto L_0x047a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x0468, code lost:
            if (com.applovin.exoplayer2.e.e.d.iz().containsKey(r0.name) == false) goto L_0x047a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x046a, code lost:
            r10 = ((java.lang.Integer) com.applovin.exoplayer2.e.e.d.iz().get(r0.name)).intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:196:0x047c, code lost:
            if (r0.ye != 0) goto L_0x04ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x0485, code lost:
            if (java.lang.Float.compare(r0.yf, 0.0f) != 0) goto L_0x04ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:200:0x048d, code lost:
            if (java.lang.Float.compare(r0.yg, 0.0f) != 0) goto L_0x04ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:202:0x0495, code lost:
            if (java.lang.Float.compare(r0.yh, 0.0f) != 0) goto L_0x0498;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:204:0x04a0, code lost:
            if (java.lang.Float.compare(r0.yg, 90.0f) != 0) goto L_0x04a5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:205:0x04a2, code lost:
            r9 = 90;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:207:0x04ad, code lost:
            if (java.lang.Float.compare(r0.yg, -180.0f) == 0) goto L_0x04c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:209:0x04b7, code lost:
            if (java.lang.Float.compare(r0.yg, 180.0f) != 0) goto L_0x04ba;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:211:0x04c2, code lost:
            if (java.lang.Float.compare(r0.yg, -90.0f) != 0) goto L_0x04ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:212:0x04c4, code lost:
            r9 = 270;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:213:0x04c7, code lost:
            r9 = 180;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:214:0x04ca, code lost:
            r9 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:215:0x04cb, code lost:
            r8.J(r0.dE).K(r0.height).e(r2).L(r9).a(r0.dI).M(r0.dJ).a(r15);
            r2 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:217:0x04f4, code lost:
            if ("application/x-subrip".equals(r5) != false) goto L_0x0516;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:219:0x04fa, code lost:
            if ("text/x-ssa".equals(r5) != false) goto L_0x0516;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:221:0x0500, code lost:
            if ("application/vobsub".equals(r5) != false) goto L_0x0516;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:223:0x0506, code lost:
            if ("application/pgs".equals(r5) != false) goto L_0x0516;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:225:0x050c, code lost:
            if ("application/dvbsubs".equals(r5) == false) goto L_0x050f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:227:0x0515, code lost:
            throw com.applovin.exoplayer2.ai.c("Unexpected MIME type.", (java.lang.Throwable) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:228:0x0516, code lost:
            r2 = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:230:0x0519, code lost:
            if (r0.name == null) goto L_0x052c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:232:0x0525, code lost:
            if (com.applovin.exoplayer2.e.e.d.iz().containsKey(r0.name) != false) goto L_0x052c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:233:0x0527, code lost:
            r8.h(r0.name);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:234:0x052c, code lost:
            r1 = r8.D(r21).m(r5).I(r4).j(r0.dq).E(r6).c(r1).k(r3).a(r0.dC).bT();
            r2 = r20.y(r0.xT, r2);
            r0.wl = r2;
            r2.j(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:235:0x0563, code lost:
            return;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.applovin.exoplayer2.e.j r20, int r21) throws com.applovin.exoplayer2.ai {
            /*
                r19 = this;
                r0 = r19
                java.lang.String r1 = r0.xS
                r1.hashCode()
                int r2 = r1.hashCode()
                r3 = 16
                r6 = 8
                r7 = 4
                r8 = 3
                r9 = 0
                r10 = -1
                switch(r2) {
                    case -2095576542: goto L_0x01b4;
                    case -2095575984: goto L_0x01a8;
                    case -1985379776: goto L_0x019c;
                    case -1784763192: goto L_0x0190;
                    case -1730367663: goto L_0x0184;
                    case -1482641358: goto L_0x0178;
                    case -1482641357: goto L_0x016c;
                    case -1373388978: goto L_0x0160;
                    case -933872740: goto L_0x0152;
                    case -538363189: goto L_0x0144;
                    case -538363109: goto L_0x0136;
                    case -425012669: goto L_0x0128;
                    case -356037306: goto L_0x011a;
                    case 62923557: goto L_0x010c;
                    case 62923603: goto L_0x00fe;
                    case 62927045: goto L_0x00f0;
                    case 82318131: goto L_0x00e2;
                    case 82338133: goto L_0x00d4;
                    case 82338134: goto L_0x00c6;
                    case 99146302: goto L_0x00b8;
                    case 444813526: goto L_0x00aa;
                    case 542569478: goto L_0x009c;
                    case 635596514: goto L_0x008e;
                    case 725948237: goto L_0x0081;
                    case 725957860: goto L_0x0074;
                    case 738597099: goto L_0x0067;
                    case 855502857: goto L_0x005a;
                    case 1422270023: goto L_0x004d;
                    case 1809237540: goto L_0x0040;
                    case 1950749482: goto L_0x0033;
                    case 1950789798: goto L_0x0026;
                    case 1951062397: goto L_0x0019;
                    default: goto L_0x0016;
                }
            L_0x0016:
                r1 = -1
                goto L_0x01bf
            L_0x0019:
                java.lang.String r2 = "A_OPUS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0022
                goto L_0x0016
            L_0x0022:
                r1 = 31
                goto L_0x01bf
            L_0x0026:
                java.lang.String r2 = "A_FLAC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x002f
                goto L_0x0016
            L_0x002f:
                r1 = 30
                goto L_0x01bf
            L_0x0033:
                java.lang.String r2 = "A_EAC3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x003c
                goto L_0x0016
            L_0x003c:
                r1 = 29
                goto L_0x01bf
            L_0x0040:
                java.lang.String r2 = "V_MPEG2"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0049
                goto L_0x0016
            L_0x0049:
                r1 = 28
                goto L_0x01bf
            L_0x004d:
                java.lang.String r2 = "S_TEXT/UTF8"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0056
                goto L_0x0016
            L_0x0056:
                r1 = 27
                goto L_0x01bf
            L_0x005a:
                java.lang.String r2 = "V_MPEGH/ISO/HEVC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0063
                goto L_0x0016
            L_0x0063:
                r1 = 26
                goto L_0x01bf
            L_0x0067:
                java.lang.String r2 = "S_TEXT/ASS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0070
                goto L_0x0016
            L_0x0070:
                r1 = 25
                goto L_0x01bf
            L_0x0074:
                java.lang.String r2 = "A_PCM/INT/LIT"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x007d
                goto L_0x0016
            L_0x007d:
                r1 = 24
                goto L_0x01bf
            L_0x0081:
                java.lang.String r2 = "A_PCM/INT/BIG"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x008a
                goto L_0x0016
            L_0x008a:
                r1 = 23
                goto L_0x01bf
            L_0x008e:
                java.lang.String r2 = "A_PCM/FLOAT/IEEE"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0098
                goto L_0x0016
            L_0x0098:
                r1 = 22
                goto L_0x01bf
            L_0x009c:
                java.lang.String r2 = "A_DTS/EXPRESS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00a6
                goto L_0x0016
            L_0x00a6:
                r1 = 21
                goto L_0x01bf
            L_0x00aa:
                java.lang.String r2 = "V_THEORA"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00b4
                goto L_0x0016
            L_0x00b4:
                r1 = 20
                goto L_0x01bf
            L_0x00b8:
                java.lang.String r2 = "S_HDMV/PGS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00c2
                goto L_0x0016
            L_0x00c2:
                r1 = 19
                goto L_0x01bf
            L_0x00c6:
                java.lang.String r2 = "V_VP9"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00d0
                goto L_0x0016
            L_0x00d0:
                r1 = 18
                goto L_0x01bf
            L_0x00d4:
                java.lang.String r2 = "V_VP8"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00de
                goto L_0x0016
            L_0x00de:
                r1 = 17
                goto L_0x01bf
            L_0x00e2:
                java.lang.String r2 = "V_AV1"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00ec
                goto L_0x0016
            L_0x00ec:
                r1 = 16
                goto L_0x01bf
            L_0x00f0:
                java.lang.String r2 = "A_DTS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00fa
                goto L_0x0016
            L_0x00fa:
                r1 = 15
                goto L_0x01bf
            L_0x00fe:
                java.lang.String r2 = "A_AC3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0108
                goto L_0x0016
            L_0x0108:
                r1 = 14
                goto L_0x01bf
            L_0x010c:
                java.lang.String r2 = "A_AAC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0116
                goto L_0x0016
            L_0x0116:
                r1 = 13
                goto L_0x01bf
            L_0x011a:
                java.lang.String r2 = "A_DTS/LOSSLESS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0124
                goto L_0x0016
            L_0x0124:
                r1 = 12
                goto L_0x01bf
            L_0x0128:
                java.lang.String r2 = "S_VOBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0132
                goto L_0x0016
            L_0x0132:
                r1 = 11
                goto L_0x01bf
            L_0x0136:
                java.lang.String r2 = "V_MPEG4/ISO/AVC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0140
                goto L_0x0016
            L_0x0140:
                r1 = 10
                goto L_0x01bf
            L_0x0144:
                java.lang.String r2 = "V_MPEG4/ISO/ASP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x014e
                goto L_0x0016
            L_0x014e:
                r1 = 9
                goto L_0x01bf
            L_0x0152:
                java.lang.String r2 = "S_DVBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x015c
                goto L_0x0016
            L_0x015c:
                r1 = 8
                goto L_0x01bf
            L_0x0160:
                java.lang.String r2 = "V_MS/VFW/FOURCC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x016a
                goto L_0x0016
            L_0x016a:
                r1 = 7
                goto L_0x01bf
            L_0x016c:
                java.lang.String r2 = "A_MPEG/L3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0176
                goto L_0x0016
            L_0x0176:
                r1 = 6
                goto L_0x01bf
            L_0x0178:
                java.lang.String r2 = "A_MPEG/L2"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0182
                goto L_0x0016
            L_0x0182:
                r1 = 5
                goto L_0x01bf
            L_0x0184:
                java.lang.String r2 = "A_VORBIS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x018e
                goto L_0x0016
            L_0x018e:
                r1 = 4
                goto L_0x01bf
            L_0x0190:
                java.lang.String r2 = "A_TRUEHD"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x019a
                goto L_0x0016
            L_0x019a:
                r1 = 3
                goto L_0x01bf
            L_0x019c:
                java.lang.String r2 = "A_MS/ACM"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01a6
                goto L_0x0016
            L_0x01a6:
                r1 = 2
                goto L_0x01bf
            L_0x01a8:
                java.lang.String r2 = "V_MPEG4/ISO/SP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01b2
                goto L_0x0016
            L_0x01b2:
                r1 = 1
                goto L_0x01bf
            L_0x01b4:
                java.lang.String r2 = "V_MPEG4/ISO/AP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01be
                goto L_0x0016
            L_0x01be:
                r1 = 0
            L_0x01bf:
                java.lang.String r2 = "application/dvbsubs"
                java.lang.String r11 = "application/pgs"
                java.lang.String r12 = "application/vobsub"
                java.lang.String r13 = "text/x-ssa"
                java.lang.String r14 = "application/x-subrip"
                java.lang.String r4 = ". Setting mimeType to audio/x-unknown"
                java.lang.String r16 = "audio/raw"
                java.lang.String r5 = "MatroskaExtractor"
                java.lang.String r17 = "audio/x-unknown"
                r15 = 0
                switch(r1) {
                    case 0: goto L_0x03ce;
                    case 1: goto L_0x03ce;
                    case 2: goto L_0x0393;
                    case 3: goto L_0x0388;
                    case 4: goto L_0x0375;
                    case 5: goto L_0x036d;
                    case 6: goto L_0x036a;
                    case 7: goto L_0x034e;
                    case 8: goto L_0x033c;
                    case 9: goto L_0x03ce;
                    case 10: goto L_0x031a;
                    case 11: goto L_0x030d;
                    case 12: goto L_0x030a;
                    case 13: goto L_0x02ed;
                    case 14: goto L_0x02ea;
                    case 15: goto L_0x02e7;
                    case 16: goto L_0x02e4;
                    case 17: goto L_0x02dc;
                    case 18: goto L_0x02d9;
                    case 19: goto L_0x02d6;
                    case 20: goto L_0x02d3;
                    case 21: goto L_0x02e7;
                    case 22: goto L_0x02b4;
                    case 23: goto L_0x028d;
                    case 24: goto L_0x0268;
                    case 25: goto L_0x0256;
                    case 26: goto L_0x023b;
                    case 27: goto L_0x0237;
                    case 28: goto L_0x0233;
                    case 29: goto L_0x022f;
                    case 30: goto L_0x0221;
                    case 31: goto L_0x01dc;
                    default: goto L_0x01d5;
                }
            L_0x01d5:
                java.lang.String r1 = "Unrecognized codec identifier."
                com.applovin.exoplayer2.ai r1 = com.applovin.exoplayer2.ai.c(r1, r15)
                throw r1
            L_0x01dc:
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r8)
                java.lang.String r3 = r0.xS
                byte[] r3 = r0.H(r3)
                r1.add(r3)
                java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r6)
                java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN
                java.nio.ByteBuffer r3 = r3.order(r4)
                long r4 = r0.yA
                java.nio.ByteBuffer r3 = r3.putLong(r4)
                byte[] r3 = r3.array()
                r1.add(r3)
                java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r6)
                java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN
                java.nio.ByteBuffer r3 = r3.order(r4)
                long r4 = r0.yB
                java.nio.ByteBuffer r3 = r3.putLong(r4)
                byte[] r3 = r3.array()
                r1.add(r3)
                java.lang.String r16 = "audio/opus"
                r3 = 5760(0x1680, float:8.071E-42)
                r3 = r15
                r4 = 5760(0x1680, float:8.071E-42)
                goto L_0x02e1
            L_0x0221:
                java.lang.String r1 = r0.xS
                byte[] r1 = r0.H(r1)
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r16 = "audio/flac"
                goto L_0x0367
            L_0x022f:
                java.lang.String r16 = "audio/eac3"
                goto L_0x02de
            L_0x0233:
                java.lang.String r16 = "video/mpeg2"
                goto L_0x02de
            L_0x0237:
                r16 = r14
                goto L_0x02de
            L_0x023b:
                com.applovin.exoplayer2.l.y r1 = new com.applovin.exoplayer2.l.y
                java.lang.String r3 = r0.xS
                byte[] r3 = r0.H(r3)
                r1.<init>((byte[]) r3)
                com.applovin.exoplayer2.m.f r1 = com.applovin.exoplayer2.m.f.av(r1)
                java.util.List<byte[]> r3 = r1.dB
                int r4 = r1.wo
                r0.wo = r4
                java.lang.String r1 = r1.dw
                java.lang.String r16 = "video/hevc"
                goto L_0x0333
            L_0x0256:
                byte[] r1 = com.applovin.exoplayer2.e.e.d.wS
                java.lang.String r3 = r0.xS
                byte[] r3 = r0.H(r3)
                com.applovin.exoplayer2.common.a.s r1 = com.applovin.exoplayer2.common.a.s.k(r1, r3)
                r16 = r13
                goto L_0x0367
            L_0x0268:
                int r1 = r0.yz
                int r7 = com.applovin.exoplayer2.l.ai.fI(r1)
                if (r7 != 0) goto L_0x0288
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r3 = "Unsupported little endian PCM bit depth: "
                r1.<init>(r3)
                int r3 = r0.yz
                r1.append(r3)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                com.applovin.exoplayer2.l.q.h(r5, r1)
                goto L_0x03c8
            L_0x0288:
                r1 = r15
                r3 = r1
                r4 = -1
                goto L_0x03db
            L_0x028d:
                int r1 = r0.yz
                if (r1 != r6) goto L_0x0297
                r1 = r15
                r3 = r1
                r4 = -1
                r7 = 3
                goto L_0x03db
            L_0x0297:
                if (r1 != r3) goto L_0x029c
                r7 = 268435456(0x10000000, float:2.5243549E-29)
                goto L_0x0288
            L_0x029c:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r3 = "Unsupported big endian PCM bit depth: "
                r1.<init>(r3)
                int r3 = r0.yz
                r1.append(r3)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                com.applovin.exoplayer2.l.q.h(r5, r1)
                goto L_0x03c8
            L_0x02b4:
                int r1 = r0.yz
                r3 = 32
                if (r1 != r3) goto L_0x02bb
                goto L_0x0288
            L_0x02bb:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r3 = "Unsupported floating point PCM bit depth: "
                r1.<init>(r3)
                int r3 = r0.yz
                r1.append(r3)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                com.applovin.exoplayer2.l.q.h(r5, r1)
                goto L_0x03c8
            L_0x02d3:
                java.lang.String r16 = "video/x-unknown"
                goto L_0x02de
            L_0x02d6:
                r16 = r11
                goto L_0x02de
            L_0x02d9:
                java.lang.String r16 = "video/x-vnd.on2.vp9"
                goto L_0x02de
            L_0x02dc:
                java.lang.String r16 = "video/x-vnd.on2.vp8"
            L_0x02de:
                r1 = r15
                r3 = r1
            L_0x02e0:
                r4 = -1
            L_0x02e1:
                r7 = -1
                goto L_0x03db
            L_0x02e4:
                java.lang.String r16 = "video/av01"
                goto L_0x02de
            L_0x02e7:
                java.lang.String r16 = "audio/vnd.dts"
                goto L_0x02de
            L_0x02ea:
                java.lang.String r16 = "audio/ac3"
                goto L_0x02de
            L_0x02ed:
                java.lang.String r1 = r0.xS
                byte[] r1 = r0.H(r1)
                java.util.List r1 = java.util.Collections.singletonList(r1)
                byte[] r3 = r0.ya
                com.applovin.exoplayer2.b.a$a r3 = com.applovin.exoplayer2.b.a.b((byte[]) r3)
                int r4 = r3.js
                r0.dM = r4
                int r4 = r3.dL
                r0.dL = r4
                java.lang.String r3 = r3.dw
                java.lang.String r16 = "audio/mp4a-latm"
                goto L_0x02e0
            L_0x030a:
                java.lang.String r16 = "audio/vnd.dts.hd"
                goto L_0x02de
            L_0x030d:
                java.lang.String r1 = r0.xS
                byte[] r1 = r0.H(r1)
                com.applovin.exoplayer2.common.a.s r1 = com.applovin.exoplayer2.common.a.s.u(r1)
                r16 = r12
                goto L_0x0367
            L_0x031a:
                com.applovin.exoplayer2.l.y r1 = new com.applovin.exoplayer2.l.y
                java.lang.String r3 = r0.xS
                byte[] r3 = r0.H(r3)
                r1.<init>((byte[]) r3)
                com.applovin.exoplayer2.m.a r1 = com.applovin.exoplayer2.m.a.as(r1)
                java.util.List<byte[]> r3 = r1.dB
                int r4 = r1.wo
                r0.wo = r4
                java.lang.String r1 = r1.dw
                java.lang.String r16 = "video/avc"
            L_0x0333:
                r4 = -1
                r7 = -1
                r18 = r3
                r3 = r1
                r1 = r18
                goto L_0x03db
            L_0x033c:
                byte[] r1 = new byte[r7]
                java.lang.String r3 = r0.xS
                byte[] r3 = r0.H(r3)
                java.lang.System.arraycopy(r3, r9, r1, r9, r7)
                com.applovin.exoplayer2.common.a.s r1 = com.applovin.exoplayer2.common.a.s.u(r1)
                r16 = r2
                goto L_0x0367
            L_0x034e:
                com.applovin.exoplayer2.l.y r1 = new com.applovin.exoplayer2.l.y
                java.lang.String r3 = r0.xS
                byte[] r3 = r0.H(r3)
                r1.<init>((byte[]) r3)
                android.util.Pair r1 = n(r1)
                java.lang.Object r3 = r1.first
                r16 = r3
                java.lang.String r16 = (java.lang.String) r16
                java.lang.Object r1 = r1.second
                java.util.List r1 = (java.util.List) r1
            L_0x0367:
                r3 = r15
                goto L_0x02e0
            L_0x036a:
                java.lang.String r16 = "audio/mpeg"
                goto L_0x036f
            L_0x036d:
                java.lang.String r16 = "audio/mpeg-L2"
            L_0x036f:
                r1 = r15
                r3 = r1
                r4 = 4096(0x1000, float:5.74E-42)
                goto L_0x02e1
            L_0x0375:
                java.lang.String r1 = r0.xS
                byte[] r1 = r0.H(r1)
                java.util.List r1 = v(r1)
                java.lang.String r16 = "audio/vorbis"
                r3 = 8192(0x2000, float:1.14794E-41)
                r3 = r15
                r4 = 8192(0x2000, float:1.14794E-41)
                goto L_0x02e1
            L_0x0388:
                com.applovin.exoplayer2.e.e.d$c r1 = new com.applovin.exoplayer2.e.e.d$c
                r1.<init>()
                r0.yC = r1
                java.lang.String r16 = "audio/true-hd"
                goto L_0x02de
            L_0x0393:
                com.applovin.exoplayer2.l.y r1 = new com.applovin.exoplayer2.l.y
                java.lang.String r3 = r0.xS
                byte[] r3 = r0.H(r3)
                r1.<init>((byte[]) r3)
                boolean r1 = o(r1)
                if (r1 == 0) goto L_0x03c3
                int r1 = r0.yz
                int r7 = com.applovin.exoplayer2.l.ai.fI(r1)
                if (r7 != 0) goto L_0x0288
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r3 = "Unsupported PCM bit depth: "
                r1.<init>(r3)
                int r3 = r0.yz
                r1.append(r3)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                com.applovin.exoplayer2.l.q.h(r5, r1)
                goto L_0x03c8
            L_0x03c3:
                java.lang.String r1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown"
                com.applovin.exoplayer2.l.q.h(r5, r1)
            L_0x03c8:
                r1 = r15
                r3 = r1
                r16 = r17
                goto L_0x02e0
            L_0x03ce:
                byte[] r1 = r0.ya
                if (r1 != 0) goto L_0x03d4
                r1 = r15
                goto L_0x03d8
            L_0x03d4:
                java.util.List r1 = java.util.Collections.singletonList(r1)
            L_0x03d8:
                java.lang.String r16 = "video/mp4v-es"
                goto L_0x0367
            L_0x03db:
                byte[] r5 = r0.yy
                if (r5 == 0) goto L_0x03ee
                com.applovin.exoplayer2.l.y r6 = new com.applovin.exoplayer2.l.y
                r6.<init>((byte[]) r5)
                com.applovin.exoplayer2.m.c r5 = com.applovin.exoplayer2.m.c.au(r6)
                if (r5 == 0) goto L_0x03ee
                java.lang.String r3 = r5.dw
                java.lang.String r16 = "video/dolby-vision"
            L_0x03ee:
                r5 = r16
                boolean r6 = r0.yE
                boolean r8 = r0.yD
                if (r8 == 0) goto L_0x03f8
                r8 = 2
                goto L_0x03f9
            L_0x03f8:
                r8 = 0
            L_0x03f9:
                r6 = r6 | r8
                com.applovin.exoplayer2.v$a r8 = new com.applovin.exoplayer2.v$a
                r8.<init>()
                boolean r17 = com.applovin.exoplayer2.l.u.aW(r5)
                if (r17 == 0) goto L_0x0417
                int r2 = r0.dL
                com.applovin.exoplayer2.v$a r2 = r8.N(r2)
                int r9 = r0.dM
                com.applovin.exoplayer2.v$a r2 = r2.O(r9)
                r2.P(r7)
                r2 = 1
                goto L_0x0517
            L_0x0417:
                boolean r7 = com.applovin.exoplayer2.l.u.aX(r5)
                if (r7 == 0) goto L_0x04f0
                int r2 = r0.yd
                if (r2 != 0) goto L_0x0431
                int r2 = r0.yb
                if (r2 != r10) goto L_0x0427
                int r2 = r0.dE
            L_0x0427:
                r0.yb = r2
                int r2 = r0.yc
                if (r2 != r10) goto L_0x042f
                int r2 = r0.height
            L_0x042f:
                r0.yc = r2
            L_0x0431:
                int r2 = r0.yb
                if (r2 == r10) goto L_0x0445
                int r7 = r0.yc
                if (r7 == r10) goto L_0x0445
                int r11 = r0.height
                int r11 = r11 * r2
                float r2 = (float) r11
                int r11 = r0.dE
                int r11 = r11 * r7
                float r7 = (float) r11
                float r2 = r2 / r7
                goto L_0x0447
            L_0x0445:
                r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            L_0x0447:
                boolean r7 = r0.yi
                if (r7 == 0) goto L_0x045a
                byte[] r7 = r19.iC()
                com.applovin.exoplayer2.m.b r15 = new com.applovin.exoplayer2.m.b
                int r11 = r0.yj
                int r12 = r0.yl
                int r13 = r0.yk
                r15.<init>(r11, r12, r13, r7)
            L_0x045a:
                java.lang.String r7 = r0.name
                if (r7 == 0) goto L_0x047a
                java.util.Map r7 = com.applovin.exoplayer2.e.e.d.wV
                java.lang.String r11 = r0.name
                boolean r7 = r7.containsKey(r11)
                if (r7 == 0) goto L_0x047a
                java.util.Map r7 = com.applovin.exoplayer2.e.e.d.wV
                java.lang.String r10 = r0.name
                java.lang.Object r7 = r7.get(r10)
                java.lang.Integer r7 = (java.lang.Integer) r7
                int r10 = r7.intValue()
            L_0x047a:
                int r7 = r0.ye
                if (r7 != 0) goto L_0x04ca
                float r7 = r0.yf
                r11 = 0
                int r7 = java.lang.Float.compare(r7, r11)
                if (r7 != 0) goto L_0x04ca
                float r7 = r0.yg
                int r7 = java.lang.Float.compare(r7, r11)
                if (r7 != 0) goto L_0x04ca
                float r7 = r0.yh
                int r7 = java.lang.Float.compare(r7, r11)
                if (r7 != 0) goto L_0x0498
                goto L_0x04cb
            L_0x0498:
                float r7 = r0.yg
                r9 = 1119092736(0x42b40000, float:90.0)
                int r7 = java.lang.Float.compare(r7, r9)
                if (r7 != 0) goto L_0x04a5
                r9 = 90
                goto L_0x04cb
            L_0x04a5:
                float r7 = r0.yg
                r9 = -1020002304(0xffffffffc3340000, float:-180.0)
                int r7 = java.lang.Float.compare(r7, r9)
                if (r7 == 0) goto L_0x04c7
                float r7 = r0.yg
                r9 = 1127481344(0x43340000, float:180.0)
                int r7 = java.lang.Float.compare(r7, r9)
                if (r7 != 0) goto L_0x04ba
                goto L_0x04c7
            L_0x04ba:
                float r7 = r0.yg
                r9 = -1028390912(0xffffffffc2b40000, float:-90.0)
                int r7 = java.lang.Float.compare(r7, r9)
                if (r7 != 0) goto L_0x04ca
                r9 = 270(0x10e, float:3.78E-43)
                goto L_0x04cb
            L_0x04c7:
                r9 = 180(0xb4, float:2.52E-43)
                goto L_0x04cb
            L_0x04ca:
                r9 = r10
            L_0x04cb:
                int r7 = r0.dE
                com.applovin.exoplayer2.v$a r7 = r8.J(r7)
                int r10 = r0.height
                com.applovin.exoplayer2.v$a r7 = r7.K(r10)
                com.applovin.exoplayer2.v$a r2 = r7.e((float) r2)
                com.applovin.exoplayer2.v$a r2 = r2.L(r9)
                byte[] r7 = r0.dI
                com.applovin.exoplayer2.v$a r2 = r2.a((byte[]) r7)
                int r7 = r0.dJ
                com.applovin.exoplayer2.v$a r2 = r2.M(r7)
                r2.a((com.applovin.exoplayer2.m.b) r15)
                r2 = 2
                goto L_0x0517
            L_0x04f0:
                boolean r7 = r14.equals(r5)
                if (r7 != 0) goto L_0x0516
                boolean r7 = r13.equals(r5)
                if (r7 != 0) goto L_0x0516
                boolean r7 = r12.equals(r5)
                if (r7 != 0) goto L_0x0516
                boolean r7 = r11.equals(r5)
                if (r7 != 0) goto L_0x0516
                boolean r2 = r2.equals(r5)
                if (r2 == 0) goto L_0x050f
                goto L_0x0516
            L_0x050f:
                java.lang.String r1 = "Unexpected MIME type."
                com.applovin.exoplayer2.ai r1 = com.applovin.exoplayer2.ai.c(r1, r15)
                throw r1
            L_0x0516:
                r2 = 3
            L_0x0517:
                java.lang.String r7 = r0.name
                if (r7 == 0) goto L_0x052c
                java.util.Map r7 = com.applovin.exoplayer2.e.e.d.wV
                java.lang.String r9 = r0.name
                boolean r7 = r7.containsKey(r9)
                if (r7 != 0) goto L_0x052c
                java.lang.String r7 = r0.name
                r8.h((java.lang.String) r7)
            L_0x052c:
                r7 = r21
                com.applovin.exoplayer2.v$a r7 = r8.D((int) r7)
                com.applovin.exoplayer2.v$a r5 = r7.m((java.lang.String) r5)
                com.applovin.exoplayer2.v$a r4 = r5.I(r4)
                java.lang.String r5 = r0.dq
                com.applovin.exoplayer2.v$a r4 = r4.j((java.lang.String) r5)
                com.applovin.exoplayer2.v$a r4 = r4.E(r6)
                com.applovin.exoplayer2.v$a r1 = r4.c((java.util.List<byte[]>) r1)
                com.applovin.exoplayer2.v$a r1 = r1.k((java.lang.String) r3)
                com.applovin.exoplayer2.d.e r3 = r0.dC
                com.applovin.exoplayer2.v$a r1 = r1.a((com.applovin.exoplayer2.d.e) r3)
                com.applovin.exoplayer2.v r1 = r1.bT()
                int r3 = r0.xT
                r4 = r20
                com.applovin.exoplayer2.e.x r2 = r4.y(r3, r2)
                r0.wl = r2
                r2.j(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.e.d.b.a(com.applovin.exoplayer2.e.j, int):void");
        }

        public void iB() {
            c cVar = this.yC;
            if (cVar != null) {
                cVar.c(this);
            }
        }

        public void Y() {
            c cVar = this.yC;
            if (cVar != null) {
                cVar.Y();
            }
        }

        private byte[] iC() {
            if (this.yo == -1.0f || this.yp == -1.0f || this.yq == -1.0f || this.yr == -1.0f || this.ys == -1.0f || this.yt == -1.0f || this.yu == -1.0f || this.yv == -1.0f || this.yw == -1.0f || this.yx == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((int) ((this.yo * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.yp * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.yq * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.yr * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.ys * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.yt * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.yu * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.yv * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) (this.yw + 0.5f)));
            order.putShort((short) ((int) (this.yx + 0.5f)));
            order.putShort((short) this.ym);
            order.putShort((short) this.yn);
            return bArr;
        }

        private static Pair<String, List<byte[]>> n(y yVar) throws com.applovin.exoplayer2.ai {
            try {
                yVar.fz(16);
                long pw = yVar.pw();
                if (pw == 1482049860) {
                    return new Pair<>("video/divx", (Object) null);
                }
                if (pw == 859189832) {
                    return new Pair<>("video/3gpp", (Object) null);
                }
                if (pw == 826496599) {
                    byte[] hO = yVar.hO();
                    for (int il = yVar.il() + 20; il < hO.length - 4; il++) {
                        if (hO[il] == 0 && hO[il + 1] == 0 && hO[il + 2] == 1 && hO[il + 3] == 15) {
                            return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(hO, il, hO.length)));
                        }
                    }
                    throw com.applovin.exoplayer2.ai.c("Failed to find FourCC VC1 initialization data", (Throwable) null);
                }
                q.h("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>("video/x-unknown", (Object) null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw com.applovin.exoplayer2.ai.c("Error parsing FourCC private data", (Throwable) null);
            }
        }

        private static List<byte[]> v(byte[] bArr) throws com.applovin.exoplayer2.ai {
            byte b;
            byte b2;
            try {
                if (bArr[0] == 2) {
                    int i = 1;
                    int i2 = 0;
                    while (true) {
                        b = bArr[i];
                        if ((b & UByte.MAX_VALUE) != 255) {
                            break;
                        }
                        i2 += 255;
                        i++;
                    }
                    int i3 = i + 1;
                    int i4 = i2 + (b & UByte.MAX_VALUE);
                    int i5 = 0;
                    while (true) {
                        b2 = bArr[i3];
                        if ((b2 & UByte.MAX_VALUE) != 255) {
                            break;
                        }
                        i5 += 255;
                        i3++;
                    }
                    int i6 = i3 + 1;
                    int i7 = i5 + (b2 & UByte.MAX_VALUE);
                    if (bArr[i6] == 1) {
                        byte[] bArr2 = new byte[i4];
                        System.arraycopy(bArr, i6, bArr2, 0, i4);
                        int i8 = i6 + i4;
                        if (bArr[i8] == 3) {
                            int i9 = i8 + i7;
                            if (bArr[i9] == 5) {
                                byte[] bArr3 = new byte[(bArr.length - i9)];
                                System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw com.applovin.exoplayer2.ai.c("Error parsing vorbis codec private", (Throwable) null);
                        }
                        throw com.applovin.exoplayer2.ai.c("Error parsing vorbis codec private", (Throwable) null);
                    }
                    throw com.applovin.exoplayer2.ai.c("Error parsing vorbis codec private", (Throwable) null);
                }
                throw com.applovin.exoplayer2.ai.c("Error parsing vorbis codec private", (Throwable) null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw com.applovin.exoplayer2.ai.c("Error parsing vorbis codec private", (Throwable) null);
            }
        }

        private static boolean o(y yVar) throws com.applovin.exoplayer2.ai {
            try {
                int pq = yVar.pq();
                if (pq == 1) {
                    return true;
                }
                if (pq != 65534) {
                    return false;
                }
                yVar.fx(24);
                if (yVar.pz() == d.wU.getMostSignificantBits() && yVar.pz() == d.wU.getLeastSignificantBits()) {
                    return true;
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw com.applovin.exoplayer2.ai.c("Error parsing MS/ACM codec private", (Throwable) null);
            }
        }

        /* access modifiers changed from: private */
        public void iD() {
            com.applovin.exoplayer2.l.a.checkNotNull(this.wl);
        }

        private byte[] H(String str) throws com.applovin.exoplayer2.ai {
            byte[] bArr = this.ya;
            if (bArr != null) {
                return bArr;
            }
            throw com.applovin.exoplayer2.ai.c("Missing CodecPrivate for codec " + str, (Throwable) null);
        }
    }
}
