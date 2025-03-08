package com.applovin.exoplayer2.m;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.ironsource.m2;

public final class m {
    private boolean GL;
    private Surface Hm;
    private float TU;
    private final e aeN = new e();
    private final b aeO;
    private final e aeP;
    private float aeQ;
    private float aeR;
    private float aeS;
    private int aeT;
    private long aeU;
    private long aeV;
    private long aeW;
    private long aeX;
    private long aeY;
    private long aeZ;
    private long afa;

    private interface b {

        public interface a {
            void onDefaultDisplayChanged(Display display);
        }

        void a(a aVar);

        void qB();
    }

    private void qy() {
        this.aeW = 0;
        this.aeZ = -1;
        this.aeX = -1;
    }

    public m(Context context) {
        b r = r(context);
        this.aeO = r;
        this.aeP = r != null ? e.qD() : null;
        this.aeU = -9223372036854775807L;
        this.aeV = -9223372036854775807L;
        this.aeQ = -1.0f;
        this.TU = 1.0f;
        this.aeT = 0;
    }

    public void fS(int i) {
        if (this.aeT != i) {
            this.aeT = i;
            at(true);
        }
    }

    public void qw() {
        if (this.aeO != null) {
            ((e) com.applovin.exoplayer2.l.a.checkNotNull(this.aeP)).qE();
            this.aeO.a(new m$$ExternalSyntheticLambda0(this));
        }
    }

    public void aa() {
        this.GL = true;
        qy();
        at(false);
    }

    public void c(Surface surface) {
        if (surface instanceof d) {
            surface = null;
        }
        if (this.Hm != surface) {
            qA();
            this.Hm = surface;
            at(true);
        }
    }

    public void qx() {
        qy();
    }

    public void v(float f) {
        this.TU = f;
        qy();
        at(false);
    }

    public void y(float f) {
        this.aeQ = f;
        this.aeN.Y();
        qz();
    }

    public void bw(long j) {
        long j2 = this.aeX;
        if (j2 != -1) {
            this.aeZ = j2;
            this.afa = this.aeY;
        }
        this.aeW++;
        this.aeN.bw(j * 1000);
        qz();
    }

    public void ab() {
        this.GL = false;
        qA();
    }

    public void ac() {
        b bVar = this.aeO;
        if (bVar != null) {
            bVar.qB();
            ((e) com.applovin.exoplayer2.l.a.checkNotNull(this.aeP)).qF();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long bD(long r11) {
        /*
            r10 = this;
            long r0 = r10.aeZ
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0030
            com.applovin.exoplayer2.m.e r0 = r10.aeN
            boolean r0 = r0.qd()
            if (r0 == 0) goto L_0x0030
            com.applovin.exoplayer2.m.e r0 = r10.aeN
            long r0 = r0.qg()
            long r2 = r10.afa
            long r4 = r10.aeW
            long r6 = r10.aeZ
            long r4 = r4 - r6
            long r0 = r0 * r4
            float r0 = (float) r0
            float r1 = r10.TU
            float r0 = r0 / r1
            long r0 = (long) r0
            long r2 = r2 + r0
            boolean r0 = D(r11, r2)
            if (r0 == 0) goto L_0x002d
            r4 = r2
            goto L_0x0031
        L_0x002d:
            r10.qy()
        L_0x0030:
            r4 = r11
        L_0x0031:
            long r11 = r10.aeW
            r10.aeX = r11
            r10.aeY = r4
            com.applovin.exoplayer2.m.m$e r11 = r10.aeP
            if (r11 == 0) goto L_0x0058
            long r0 = r10.aeU
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0047
            goto L_0x0058
        L_0x0047:
            long r6 = r11.afe
            int r11 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r11 != 0) goto L_0x004e
            return r4
        L_0x004e:
            long r8 = r10.aeU
            long r11 = f(r4, r6, r8)
            long r0 = r10.aeV
            long r11 = r11 - r0
            return r11
        L_0x0058:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.m.m.bD(long):long");
    }

    private static boolean D(long j, long j2) {
        return Math.abs(j - j2) <= 20000000;
    }

    private void qz() {
        if (ai.acV >= 30 && this.Hm != null) {
            float qh = this.aeN.qd() ? this.aeN.qh() : this.aeQ;
            float f = this.aeR;
            if (qh != f) {
                int i = (qh > -1.0f ? 1 : (qh == -1.0f ? 0 : -1));
                if (i != 0 && f != -1.0f) {
                    if (Math.abs(qh - this.aeR) < ((!this.aeN.qd() || this.aeN.qf() < 5000000000L) ? 1.0f : 0.02f)) {
                        return;
                    }
                } else if (i == 0 && this.aeN.qe() < 30) {
                    return;
                }
                this.aeR = qh;
                at(false);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void at(boolean r4) {
        /*
            r3 = this;
            int r0 = com.applovin.exoplayer2.l.ai.acV
            r1 = 30
            if (r0 < r1) goto L_0x0031
            android.view.Surface r0 = r3.Hm
            if (r0 == 0) goto L_0x0031
            int r1 = r3.aeT
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r2) goto L_0x0011
            goto L_0x0031
        L_0x0011:
            boolean r1 = r3.GL
            if (r1 == 0) goto L_0x0022
            float r1 = r3.aeR
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0022
            float r2 = r3.TU
            float r1 = r1 * r2
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            if (r4 != 0) goto L_0x002c
            float r4 = r3.aeS
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 != 0) goto L_0x002c
            return
        L_0x002c:
            r3.aeS = r1
            com.applovin.exoplayer2.m.m.a.a(r0, r1)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.m.m.at(boolean):void");
    }

    private void qA() {
        Surface surface;
        if (ai.acV >= 30 && (surface = this.Hm) != null && this.aeT != Integer.MIN_VALUE && this.aeS != 0.0f) {
            this.aeS = 0.0f;
            a.a(surface, 0.0f);
        }
    }

    /* access modifiers changed from: private */
    public void a(Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.aeU = refreshRate;
            this.aeV = (refreshRate * 80) / 100;
            return;
        }
        q.h("VideoFrameReleaseHelper", "Unable to query display refresh rate");
        this.aeU = -9223372036854775807L;
        this.aeV = -9223372036854775807L;
    }

    private static long f(long j, long j2, long j3) {
        long j4;
        long j5 = j2 + (((j - j2) / j3) * j3);
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            long j6 = j5;
            j5 = j3 + j5;
            j4 = j6;
        }
        return j5 - j < j - j4 ? j5 : j4;
    }

    private static b r(Context context) {
        b bVar = null;
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (ai.acV >= 17) {
            bVar = d.s(applicationContext);
        }
        return bVar == null ? c.s(applicationContext) : bVar;
    }

    private static final class a {
        public static void a(Surface surface, float f) {
            try {
                surface.setFrameRate(f, f == 0.0f ? 0 : 1);
            } catch (IllegalStateException e) {
                q.c("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
            }
        }
    }

    private static final class c implements b {
        private final WindowManager afb;

        public void qB() {
        }

        public static b s(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new c(windowManager);
            }
            return null;
        }

        private c(WindowManager windowManager) {
            this.afb = windowManager;
        }

        public void a(b.a aVar) {
            aVar.onDefaultDisplayChanged(this.afb.getDefaultDisplay());
        }
    }

    private static final class d implements DisplayManager.DisplayListener, b {
        private final DisplayManager afc;
        private b.a afd;

        public void onDisplayAdded(int i) {
        }

        public void onDisplayRemoved(int i) {
        }

        public static b s(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService(m2.h.d);
            if (displayManager != null) {
                return new d(displayManager);
            }
            return null;
        }

        private d(DisplayManager displayManager) {
            this.afc = displayManager;
        }

        public void a(b.a aVar) {
            this.afd = aVar;
            this.afc.registerDisplayListener(this, ai.pX());
            aVar.onDefaultDisplayChanged(qC());
        }

        public void qB() {
            this.afc.unregisterDisplayListener(this);
            this.afd = null;
        }

        public void onDisplayChanged(int i) {
            b.a aVar = this.afd;
            if (aVar != null && i == 0) {
                aVar.onDefaultDisplayChanged(qC());
            }
        }

        private Display qC() {
            return this.afc.getDisplay(0);
        }
    }

    private static final class e implements Handler.Callback, Choreographer.FrameCallback {
        private static final e aff = new e();
        public volatile long afe = -9223372036854775807L;
        private final HandlerThread afg;
        private Choreographer afh;
        private int afi;
        private final Handler jS;

        public static e qD() {
            return aff;
        }

        private e() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.afg = handlerThread;
            handlerThread.start();
            Handler b = ai.b(handlerThread.getLooper(), (Handler.Callback) this);
            this.jS = b;
            b.sendEmptyMessage(0);
        }

        public void qE() {
            this.jS.sendEmptyMessage(1);
        }

        public void qF() {
            this.jS.sendEmptyMessage(2);
        }

        public void doFrame(long j) {
            this.afe = j;
            ((Choreographer) com.applovin.exoplayer2.l.a.checkNotNull(this.afh)).postFrameCallbackDelayed(this, 500);
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                qG();
                return true;
            } else if (i == 1) {
                qH();
                return true;
            } else if (i != 2) {
                return false;
            } else {
                qI();
                return true;
            }
        }

        private void qG() {
            this.afh = Choreographer.getInstance();
        }

        private void qH() {
            int i = this.afi + 1;
            this.afi = i;
            if (i == 1) {
                ((Choreographer) com.applovin.exoplayer2.l.a.checkNotNull(this.afh)).postFrameCallback(this);
            }
        }

        private void qI() {
            int i = this.afi - 1;
            this.afi = i;
            if (i == 0) {
                ((Choreographer) com.applovin.exoplayer2.l.a.checkNotNull(this.afh)).removeFrameCallback(this);
                this.afe = -9223372036854775807L;
            }
        }
    }
}
