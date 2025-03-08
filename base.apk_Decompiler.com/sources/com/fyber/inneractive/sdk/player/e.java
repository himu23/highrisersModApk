package com.fyber.inneractive.sdk.player;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.c0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.features.r;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveVideoError;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.flow.m;
import com.fyber.inneractive.sdk.measurement.d;
import com.fyber.inneractive.sdk.model.vast.d;
import com.fyber.inneractive.sdk.model.vast.o;
import com.fyber.inneractive.sdk.model.vast.t;
import com.fyber.inneractive.sdk.network.j0;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.player.a;
import com.fyber.inneractive.sdk.player.c;
import com.fyber.inneractive.sdk.player.controller.g;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.player.h;
import com.fyber.inneractive.sdk.response.i;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.adsession.media.Position;
import com.iab.omid.library.fyber.adsession.media.VastProperties;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class e extends c implements a.C0105a {
    public static final HashMap<String, c> B = new a();
    public boolean A;
    public final com.fyber.inneractive.sdk.model.vast.b v;
    public com.fyber.inneractive.sdk.player.enums.a w;
    public boolean x;
    public b0 y;
    public m z;

    public class a extends HashMap<String, c> {

        /* renamed from: com.fyber.inneractive.sdk.player.e$a$a  reason: collision with other inner class name */
        public class C0110a implements c {
            public C0110a(a aVar) {
            }

            public String a(g gVar, VideoClickOrigin videoClickOrigin) {
                return videoClickOrigin.name().toLowerCase();
            }
        }

        public class b implements c {
            public b(a aVar) {
            }

            public String a(g gVar, VideoClickOrigin videoClickOrigin) {
                int c;
                if (gVar == null || (c = gVar.c()) <= 0) {
                    return "00:00:00.000";
                }
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                long j = (long) c;
                long hours = timeUnit.toHours(j);
                TimeUnit timeUnit2 = TimeUnit.HOURS;
                long minutes = timeUnit.toMinutes(j - timeUnit2.toMillis(hours));
                TimeUnit timeUnit3 = TimeUnit.MINUTES;
                long seconds = timeUnit.toSeconds((j - timeUnit2.toMillis(hours)) - timeUnit3.toMillis(minutes));
                return String.format("%02d:%02d:%02d.%03d", new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds), Long.valueOf(timeUnit.toMillis(((j - timeUnit2.toMillis(hours)) - timeUnit3.toMillis(minutes)) - TimeUnit.SECONDS.toMillis(seconds)))});
            }
        }

        public a() {
            put("[CLICKAREA]", new C0110a(this));
            put("[ADPLAYHEAD]", new b(this));
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19|20|21|22|23|24|25|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007f */
        static {
            /*
                com.fyber.inneractive.sdk.player.enums.a[] r0 = com.fyber.inneractive.sdk.player.enums.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                c = r0
                r1 = 1
                com.fyber.inneractive.sdk.player.enums.a r2 = com.fyber.inneractive.sdk.player.enums.a.Uninitialized     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fyber.inneractive.sdk.player.enums.a r3 = com.fyber.inneractive.sdk.player.enums.a.Started     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fyber.inneractive.sdk.player.enums.a r4 = com.fyber.inneractive.sdk.player.enums.a.FirstQuarter     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = c     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fyber.inneractive.sdk.player.enums.a r4 = com.fyber.inneractive.sdk.player.enums.a.MidPoint     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = c     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fyber.inneractive.sdk.player.enums.a r4 = com.fyber.inneractive.sdk.player.enums.a.ThirdPQuarter     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = c     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.fyber.inneractive.sdk.player.enums.a r4 = com.fyber.inneractive.sdk.player.enums.a.Completed     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                com.fyber.inneractive.sdk.player.enums.b[] r3 = com.fyber.inneractive.sdk.player.enums.b.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                b = r3
                com.fyber.inneractive.sdk.player.enums.b r4 = com.fyber.inneractive.sdk.player.enums.b.Prepared     // Catch:{ NoSuchFieldError -> 0x005a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.fyber.inneractive.sdk.player.enums.b r4 = com.fyber.inneractive.sdk.player.enums.b.Playing     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x006e }
                com.fyber.inneractive.sdk.player.enums.b r4 = com.fyber.inneractive.sdk.player.enums.b.Completed     // Catch:{ NoSuchFieldError -> 0x006e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.fyber.inneractive.sdk.model.vast.h[] r2 = com.fyber.inneractive.sdk.model.vast.h.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                a = r2
                com.fyber.inneractive.sdk.model.vast.h r3 = com.fyber.inneractive.sdk.model.vast.h.Default_End_Card     // Catch:{ NoSuchFieldError -> 0x007f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.fyber.inneractive.sdk.model.vast.h r2 = com.fyber.inneractive.sdk.model.vast.h.FMP_End_Card     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.e.b.<clinit>():void");
        }
    }

    public interface c {
        String a(g gVar, VideoClickOrigin videoClickOrigin);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Context context, com.fyber.inneractive.sdk.response.g gVar, b0 b0Var, InneractiveAdRequest inneractiveAdRequest, f0 f0Var, com.fyber.inneractive.sdk.measurement.a aVar) {
        super(context, b0Var == null ? null : ((a0) b0Var).b().c(), f0Var != null ? f0Var.b() : null);
        this.w = com.fyber.inneractive.sdk.player.enums.a.Uninitialized;
        this.A = false;
        if (gVar == null || gVar.e() == null) {
            throw new IllegalArgumentException("IAVastMediaPlayerFlowManager ctor - vastData can't be null");
        }
        this.g = aVar;
        this.e = f0Var;
        this.v = gVar.e();
        this.f = inneractiveAdRequest;
        m mVar = new m(context, gVar, inneractiveAdRequest, this.e.b(), a(gVar, b0Var));
        this.z = mVar;
        mVar.d();
        if (IAlog.a <= 3) {
            IAlog.d("IAVastMediaPlayerFlowManager:ctor - got media files: ", new Object[0]);
            for (int i = 0; i < this.v.a(); i++) {
                o oVar = (o) ((ArrayList) this.v.b()).get(i);
                if (oVar != null) {
                    IAlog.a("IAVastMediaPlayerFlowManager(%d): %s", Integer.valueOf(i), oVar.a());
                }
            }
        }
        if (b0Var != null) {
            a(b0Var);
            a0 a0Var = (a0) b0Var;
            if (a0Var.a() != null) {
                a(((c0) a0Var.a()).b().booleanValue());
            }
        }
        if (f0Var == null || f0Var.b() == null) {
            this.s = IAConfigManager.c().a().a(gVar.a() == UnitDisplayType.INTERSTITIAL ? "prebuffer_interstitial" : "prebuffer_rewarded", 10, 0);
        } else {
            this.s = ((r) f0Var.b().a(r.class)).a(gVar.a());
        }
    }

    public final com.fyber.inneractive.sdk.flow.vast.b a(com.fyber.inneractive.sdk.response.g gVar, b0 b0Var) {
        UnitDisplayType unitDisplayType = gVar.n;
        InneractiveAdRequest inneractiveAdRequest = this.f;
        return new com.fyber.inneractive.sdk.flow.vast.b(unitDisplayType, inneractiveAdRequest == null || inneractiveAdRequest.getAllowFullscreen(), gVar.e, gVar.f, b0Var);
    }

    public void a(b0 b0Var) {
        this.y = b0Var;
    }

    public void g() {
    }

    public View b() {
        PriorityQueue<com.fyber.inneractive.sdk.flow.vast.a> priorityQueue;
        com.fyber.inneractive.sdk.flow.vast.a peek;
        m mVar = this.z;
        if (mVar == null || (priorityQueue = mVar.l) == null || priorityQueue.size() <= 0 || (peek = this.z.l.peek()) == null || !peek.a) {
            return null;
        }
        if (peek instanceof com.fyber.inneractive.sdk.flow.vast.e) {
            this.z.n = ((com.fyber.inneractive.sdk.flow.vast.e) peek).g;
        }
        return peek.b;
    }

    public com.fyber.inneractive.sdk.model.vast.c c() {
        com.fyber.inneractive.sdk.model.vast.b bVar = this.v;
        if (bVar != null) {
            return bVar.h;
        }
        return null;
    }

    public void a(com.fyber.inneractive.sdk.player.enums.b bVar) {
        boolean z2;
        JSONArray jSONArray;
        s.a aVar;
        int i;
        String str;
        T t;
        T t2;
        T t3;
        b0 b0Var;
        VastProperties vastProperties;
        com.fyber.inneractive.sdk.player.enums.b bVar2 = bVar;
        int i2 = 0;
        IAlog.a("IAMediaPlayerFlowManager: onPlayerStateChanged with - %s", bVar2);
        f fVar = this.i;
        if (fVar != null && bVar2 != com.fyber.inneractive.sdk.player.enums.b.Prepared) {
            fVar.a(bVar2);
        } else if (bVar2 == com.fyber.inneractive.sdk.player.enums.b.Prepared && fVar != null) {
            fVar.d = true;
        }
        int i3 = c.b.a[bVar.ordinal()];
        if (i3 == 1) {
            IAlog.a("IAMediaPlayerFlowManager: onPlayerPrepared called", new Object[0]);
            if (this.o) {
                IAlog.a("IMediaPlayerFlowManager: onPlayerPrepared is called, but object is already destroyed?? ignore", new Object[0]);
            } else {
                if (this.b.a() && this.b.e() != null) {
                    a(this.b.e());
                }
                this.n = true;
                if (!(this.h == null || this.e == null || (b0Var = this.y) == null)) {
                    int intValue = ((a0) b0Var).f.h.value().intValue();
                    boolean a2 = c.a(this.b.d(), this.y, ((com.fyber.inneractive.sdk.response.g) this.e.b).w);
                    boolean booleanValue = ((a0) this.y).f.a.booleanValue();
                    d dVar = this.h;
                    if (!a2) {
                        intValue = 0;
                    }
                    if (dVar.b != null) {
                        if (a2) {
                            try {
                                vastProperties = VastProperties.createVastPropertiesForSkippableMedia((float) intValue, booleanValue, Position.STANDALONE);
                            } catch (Throwable th) {
                                dVar.a(th);
                            }
                        } else {
                            vastProperties = VastProperties.createVastPropertiesForNonSkippableMedia(booleanValue, Position.STANDALONE);
                        }
                        dVar.b.loaded(vastProperties);
                    }
                }
                if (this.r != null) {
                    f0 f0Var = this.e;
                    if (f0Var == null || (t3 = f0Var.b) == null) {
                        z2 = false;
                    } else {
                        z2 = c.a(this.b.d(), this.y, t3.w);
                        t3.r.setVideo(new ImpressionData.Video(z2, (long) ((int) TimeUnit.MILLISECONDS.toSeconds((long) this.b.d()))));
                    }
                    try {
                        f0 f0Var2 = this.e;
                        com.fyber.inneractive.sdk.response.g gVar = f0Var2 != null ? (com.fyber.inneractive.sdk.response.g) f0Var2.b : null;
                        com.fyber.inneractive.sdk.network.r rVar = com.fyber.inneractive.sdk.network.r.EVENT_READY_ON_CLIENT;
                        InneractiveAdRequest inneractiveAdRequest = this.f;
                        f0 f0Var3 = this.e;
                        if (f0Var3 == null) {
                            jSONArray = null;
                        } else {
                            jSONArray = f0Var3.c.c();
                        }
                        s.a aVar2 = new s.a(rVar, inneractiveAdRequest, (com.fyber.inneractive.sdk.response.e) gVar, jSONArray);
                        if (this.t == null || gVar == null) {
                            aVar = aVar2;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis() - gVar.J;
                            IAlog.a("Video content loader: Vast load took: " + currentTimeMillis + " msec", new Object[0]);
                            String str2 = "";
                            f0 f0Var4 = this.e;
                            if (f0Var4 == null || (t2 = f0Var4.b) == null || ((com.fyber.inneractive.sdk.response.g) t2).K == null) {
                                i = 0;
                            } else {
                                i2 = ((com.fyber.inneractive.sdk.response.g) t2).K.i;
                                int i4 = ((com.fyber.inneractive.sdk.response.g) t2).K.j;
                                String str3 = ((com.fyber.inneractive.sdk.response.g) t2).K.a;
                                i = i4;
                                str2 = str3;
                            }
                            String str4 = "0";
                            if (!(f0Var4 == null || (t = f0Var4.b) == null || TextUtils.isEmpty(((com.fyber.inneractive.sdk.response.g) t).C))) {
                                str4 = ((com.fyber.inneractive.sdk.response.g) this.e.b).C;
                            }
                            s.b bVar3 = new s.b();
                            s.b a3 = bVar3.a(IronSourceConstants.EVENTS_DURATION, Integer.valueOf(this.b.d() / 1000)).a("url", this.t.g).a("bitrate", this.t.e);
                            if (TextUtils.isEmpty(this.t.d)) {
                                str = "na";
                            } else {
                                str = this.t.d;
                            }
                            s.a aVar3 = aVar2;
                            a3.a("mime", str).a("delivery", this.t.a).a("load_time", Long.valueOf(System.currentTimeMillis() - gVar.J)).a("media_file_index", Integer.valueOf(this.q)).a("player", this.b.f()).a("is_video_skippable", Boolean.valueOf(z2)).a("supported_media_files", Integer.valueOf(i2)).a("total_media_files", Integer.valueOf(i)).a("vast_version", str2);
                            if (str4 != null && str4.equals("1")) {
                                bVar3.a("hide_endcard", str4);
                            }
                            aVar = aVar3;
                            aVar.f.put(bVar3.a);
                        }
                        aVar.a((String) null);
                    } catch (Exception unused) {
                    }
                    h hVar = (h) this.r;
                    if (!hVar.g) {
                        hVar.g = true;
                        h.b bVar4 = hVar.d;
                        if (bVar4 != null) {
                            ((com.fyber.inneractive.sdk.flow.o) bVar4).h();
                        }
                    }
                }
            }
        } else if (i3 == 2) {
            IAlog.a("IAMediaPlayerFlowManager: onPlayerBuffering", new Object[0]);
        } else if (i3 == 3) {
            this.b.c();
        }
        int i5 = b.b[bVar.ordinal()];
        if (i5 == 1) {
            com.fyber.inneractive.sdk.model.vast.b bVar5 = this.v;
            if (bVar5 != null && bVar5.m.size() != 0) {
                int d = this.b.d();
                for (com.fyber.inneractive.sdk.model.vast.d next : this.v.m) {
                    if (next.c == -1) {
                        next.c = (next.b() * d) / 100;
                    }
                }
                Collections.sort(this.v.m, new d.a());
            }
        } else if (i5 != 2) {
            if (i5 == 3) {
                b(this.b.d());
                a(com.fyber.inneractive.sdk.player.enums.a.Completed);
            }
        } else if (this.w.equals(com.fyber.inneractive.sdk.player.enums.a.Completed)) {
            a(com.fyber.inneractive.sdk.player.enums.a.Restarted);
        }
    }

    public final void b(int i) {
        com.fyber.inneractive.sdk.model.vast.b bVar = this.v;
        if (bVar != null && !bVar.m.isEmpty()) {
            while (this.v.m.size() > 0 && i >= this.v.m.get(0).c) {
                com.fyber.inneractive.sdk.model.vast.d dVar = this.v.m.get(0);
                String str = dVar.a;
                if (!TextUtils.isEmpty(str)) {
                    IAlog.a("IAVastMediaPlayerFlowManager: Firing event for type: progress", new Object[0]);
                    j0.b(str);
                }
                this.v.m.remove(dVar);
            }
        }
    }

    public void b(InneractiveVideoError inneractiveVideoError, JSONObject jSONObject) {
        try {
            if (!(this.t == null || inneractiveVideoError.getPlayerError() == InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES)) {
                jSONObject.put("url", this.t.g);
                jSONObject.put("bitrate", this.t.e);
                jSONObject.put("mime", this.t.d);
                jSONObject.put("delivery", this.t.a);
            }
            g gVar = this.b;
            jSONObject.put("player", gVar != null ? gVar.f() : "");
            if (inneractiveVideoError.getCause() != null) {
                jSONObject.put("exception", inneractiveVideoError.getCause().getClass().getName());
                jSONObject.put("message", inneractiveVideoError.getCause().getMessage() == null ? "empty" : inneractiveVideoError.getCause().getMessage());
            }
        } catch (Exception unused) {
            IAlog.a("onReportError: Failed creating Json object from media file!", new Object[0]);
        }
    }

    public void a(int i) {
        int d = this.b.d();
        b(i);
        int i2 = b.c[this.w.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4 && i > (d / 4) * 3) {
                        a(com.fyber.inneractive.sdk.player.enums.a.ThirdPQuarter);
                        com.fyber.inneractive.sdk.measurement.d dVar = this.h;
                        if (dVar != null && dVar.c != null) {
                            IAlog.a("%s thirdQuartile", "OMVideo");
                            try {
                                dVar.c.thirdQuartile();
                            } catch (Throwable th) {
                                dVar.a(th);
                            }
                        }
                    }
                } else if (i > d / 2) {
                    a(com.fyber.inneractive.sdk.player.enums.a.MidPoint);
                    com.fyber.inneractive.sdk.measurement.d dVar2 = this.h;
                    if (dVar2 != null && dVar2.c != null) {
                        IAlog.a("%s midpoint", "OMVideo");
                        try {
                            dVar2.c.midpoint();
                        } catch (Throwable th2) {
                            dVar2.a(th2);
                        }
                    }
                }
            } else if (i > d / 4) {
                a(com.fyber.inneractive.sdk.player.enums.a.FirstQuarter);
                com.fyber.inneractive.sdk.measurement.d dVar3 = this.h;
                if (dVar3 != null && dVar3.c != null) {
                    IAlog.a("%s firstQuartile", "OMVideo");
                    try {
                        dVar3.c.firstQuartile();
                    } catch (Throwable th3) {
                        dVar3.a(th3);
                    }
                }
            }
        } else if (this.b.e != com.fyber.inneractive.sdk.player.enums.b.Buffering) {
            a(com.fyber.inneractive.sdk.player.enums.a.Started);
            com.fyber.inneractive.sdk.measurement.d dVar4 = this.h;
            if (dVar4 != null) {
                if (dVar4.b != null && !dVar4.e) {
                    IAlog.a("%s impression", "OMVideo");
                    dVar4.e = true;
                    try {
                        dVar4.b.impressionOccurred();
                    } catch (Throwable th4) {
                        dVar4.a(th4);
                    }
                }
                com.fyber.inneractive.sdk.measurement.d dVar5 = this.h;
                long d2 = (long) this.b.d();
                float f = this.b.i() ? 0.0f : 1.0f;
                if (dVar5.c != null && !dVar5.d) {
                    dVar5.d = true;
                    IAlog.a("%s start", "OMVideo");
                    try {
                        dVar5.c.start((float) d2, f);
                    } catch (Throwable th5) {
                        dVar5.a(th5);
                    }
                }
            }
        }
    }

    public void a(InneractiveVideoError inneractiveVideoError, JSONObject jSONObject) {
        a(this.v, VideoClickOrigin.InvalidOrigin, t.EVENT_ERROR);
        b(inneractiveVideoError, jSONObject);
        IAlog.e("IAMediaPlayerFlowManager: reporting error to listeners: %s", inneractiveVideoError.getPlayerError().toString());
        g gVar = this.r;
        if (gVar != null) {
            try {
                ((h) gVar).a(inneractiveVideoError, (InneractiveErrorCode) null, jSONObject, false);
            } catch (Exception e) {
                if (IAlog.a <= 3) {
                    e.printStackTrace();
                }
            }
        }
        com.fyber.inneractive.sdk.util.s sVar = this.l;
        if (sVar != null) {
            sVar.d();
            this.m = null;
        }
    }

    public void a(i iVar, VideoClickOrigin videoClickOrigin, t... tVarArr) {
        if (tVarArr.length == 0) {
            IAlog.e("IAVastMediaPlayerFlowManager: eventTypes array is empty", new Object[0]);
        } else if (iVar == null) {
            IAlog.e("IAVastMediaPlayerFlowManager: parser is null", new Object[0]);
        } else {
            ArrayList arrayList = new ArrayList();
            for (t tVar : tVarArr) {
                String e = tVar.e();
                IAlog.a("IAVastMediaPlayerFlowManager: Firing events for type: %s", e);
                List<String> a2 = iVar.a(tVar);
                if (a2 == null || a2.size() == 0) {
                    IAlog.a("IAVastMediaPlayerFlowManager: no events for type: %s", e);
                } else {
                    arrayList.addAll(a2);
                    IAlog.a("found %d events for type: %s, url: %s", Integer.valueOf(a2.size()), e, a2.get(0));
                    a(a2, tVar);
                }
                if (tVar == t.EVENT_CLICK) {
                    for (Map.Entry next : B.entrySet()) {
                        String str = (String) next.getKey();
                        String a3 = ((c) next.getValue()).a(this.b, videoClickOrigin);
                        for (int i = 0; i < arrayList.size(); i++) {
                            String str2 = (String) arrayList.get(i);
                            if (str2.contains(str)) {
                                arrayList.set(i, str2.replace(str, a3));
                            }
                        }
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                if (!TextUtils.isEmpty(str3)) {
                    j0.b(str3);
                }
            }
        }
    }

    public static void a(i iVar, t... tVarArr) {
        ArrayList arrayList = new ArrayList();
        for (t tVar : tVarArr) {
            String e = tVar.e();
            IAlog.a("IAVastMediaPlayerFlowManager: Firing events for type: %s", e);
            List<String> a2 = ((com.fyber.inneractive.sdk.measurement.e) iVar).a(tVar);
            if (a2 == null || a2.size() == 0) {
                IAlog.a("IAVastMediaPlayerFlowManager: no events for type: %s", e);
            } else {
                arrayList.addAll(a2);
                IAlog.a("found %d events for type: %s", Integer.valueOf(a2.size()), e);
                a(a2, tVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!TextUtils.isEmpty(str)) {
                j0.b(str);
            }
        }
    }

    public static void a(List<String> list, t tVar) {
        for (String next : list) {
            IAlog.a("   event url: %s", next);
            if (!TextUtils.isEmpty(next)) {
                int i = IAlog.a;
                IAlog.a(1, (Exception) null, "%s %s %s", "VAST_EVENT", tVar.e(), next);
                IAlog.a(1, (Exception) null, "Tracking URLs array: %s", "VPAID", next);
            }
        }
    }

    public final void a(com.fyber.inneractive.sdk.player.enums.a aVar) {
        if (this.w != aVar) {
            if (aVar == com.fyber.inneractive.sdk.player.enums.a.Started) {
                this.x = false;
                a(this.v, VideoClickOrigin.InvalidOrigin, t.EVENT_IMPRESSION, t.EVENT_START);
            } else if (aVar == com.fyber.inneractive.sdk.player.enums.a.FirstQuarter) {
                a(this.v, VideoClickOrigin.InvalidOrigin, t.EVENT_FIRSTQ);
            } else if (aVar == com.fyber.inneractive.sdk.player.enums.a.MidPoint) {
                a(this.v, VideoClickOrigin.InvalidOrigin, t.EVENT_MID);
            } else if (aVar == com.fyber.inneractive.sdk.player.enums.a.ThirdPQuarter) {
                a(this.v, VideoClickOrigin.InvalidOrigin, t.EVENT_THIRDQ);
            } else if (aVar == com.fyber.inneractive.sdk.player.enums.a.Completed && !this.x) {
                this.x = true;
                a(this.v, VideoClickOrigin.InvalidOrigin, t.EVENT_COMPLETE);
            } else if (aVar == com.fyber.inneractive.sdk.player.enums.a.Restarted) {
                a(this.v, VideoClickOrigin.InvalidOrigin, t.EVENT_REWIND);
            } else if (aVar == com.fyber.inneractive.sdk.player.enums.a.Progress) {
                a(this.v, VideoClickOrigin.InvalidOrigin, t.EVENT_PROGRESS);
            }
            this.w = aVar;
        }
    }
}
