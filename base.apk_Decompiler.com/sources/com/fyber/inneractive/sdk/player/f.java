package com.fyber.inneractive.sdk.player;

import com.fyber.inneractive.sdk.measurement.d;
import com.fyber.inneractive.sdk.player.controller.g;
import com.fyber.inneractive.sdk.player.enums.b;
import com.fyber.inneractive.sdk.util.IAlog;

public class f implements g.f {
    public final d a;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.fyber.inneractive.sdk.player.enums.b[] r0 = com.fyber.inneractive.sdk.player.enums.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.fyber.inneractive.sdk.player.enums.b r1 = com.fyber.inneractive.sdk.player.enums.b.Prepared     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fyber.inneractive.sdk.player.enums.b r1 = com.fyber.inneractive.sdk.player.enums.b.Buffering     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fyber.inneractive.sdk.player.enums.b r1 = com.fyber.inneractive.sdk.player.enums.b.Playing     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fyber.inneractive.sdk.player.enums.b r1 = com.fyber.inneractive.sdk.player.enums.b.Paused     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fyber.inneractive.sdk.player.enums.b r1 = com.fyber.inneractive.sdk.player.enums.b.Completed     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.f.a.<clinit>():void");
        }
    }

    public f(d dVar) {
        this.a = dVar;
    }

    public void a(b bVar) {
        IAlog.a("MeasurementHelper onPlayerStateChanged=%s mBuffering=%s mPrepared=%s", bVar, String.valueOf(this.b), String.valueOf(this.d));
        if (this.a != null) {
            int i = a.a[bVar.ordinal()];
            if (i == 1) {
                this.d = true;
            } else if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        d dVar = this.a;
                        if (dVar.c != null) {
                            IAlog.a("%s pause", "OMVideo");
                            try {
                                dVar.c.pause();
                            } catch (Throwable th) {
                                dVar.a(th);
                            }
                        }
                        this.c = true;
                    } else if (i == 5) {
                        d dVar2 = this.a;
                        if (dVar2.c != null) {
                            IAlog.a("%s complete", "OMVideo");
                            try {
                                dVar2.c.complete();
                            } catch (Throwable th2) {
                                dVar2.a(th2);
                            }
                        }
                    }
                } else if (this.b) {
                    this.b = false;
                    d dVar3 = this.a;
                    if (dVar3.c != null) {
                        IAlog.a("%s bufferEnd", "OMVideo");
                        try {
                            dVar3.c.bufferFinish();
                        } catch (Throwable th3) {
                            dVar3.a(th3);
                        }
                    }
                } else if (this.c) {
                    d dVar4 = this.a;
                    if (dVar4.c != null) {
                        IAlog.a("%s resume", "OMVideo");
                        try {
                            dVar4.c.resume();
                        } catch (Throwable th4) {
                            dVar4.a(th4);
                        }
                    }
                    this.c = false;
                }
            } else if (this.d) {
                d dVar5 = this.a;
                if (dVar5.c != null) {
                    IAlog.a("%s bufferStart", "OMVideo");
                    try {
                        dVar5.c.bufferStart();
                    } catch (Throwable th5) {
                        dVar5.a(th5);
                    }
                }
                this.b = true;
            }
        }
    }

    public void a(Exception exc) {
    }

    public void e(boolean z) {
    }

    public void g() {
    }
}
