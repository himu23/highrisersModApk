package com.fyber.inneractive.sdk.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.c0;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.enums.Vendor;
import com.fyber.inneractive.sdk.config.global.features.n;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveVideoError;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.ignite.k;
import com.fyber.inneractive.sdk.model.vast.o;
import com.fyber.inneractive.sdk.model.vast.t;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.player.controller.g;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.response.i;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.s;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class c implements g.f, g.e {
    public Context a;
    public g b;
    public String c;
    public final s d;
    public f0 e;
    public InneractiveAdRequest f;
    public com.fyber.inneractive.sdk.measurement.a g;
    public com.fyber.inneractive.sdk.measurement.d h;
    public f i = null;
    public boolean j = true;
    public Bitmap k;
    public com.fyber.inneractive.sdk.util.s l;
    public s.a m;
    public boolean n = false;
    public volatile boolean o = false;
    public boolean p = false;
    public int q = 0;
    public g r;
    public int s;
    public o t;
    public g.d u = new a();

    public class a implements g.d {
        public a() {
        }
    }

    public static /* synthetic */ class b {
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
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.c.b.<clinit>():void");
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.player.c$c  reason: collision with other inner class name */
    public interface C0106c {
        void a(c cVar);
    }

    public class d extends Exception {
    }

    public c(Context context, Set<Vendor> set, com.fyber.inneractive.sdk.config.global.s sVar) {
        this.a = context;
        this.d = sVar;
        a();
    }

    public void a(Bitmap bitmap) {
        IAlog.a("IAMediaPlayerFlowManager: saving snapshot %s", bitmap);
        this.k = bitmap;
    }

    public abstract void a(InneractiveVideoError inneractiveVideoError, JSONObject jSONObject);

    public abstract void a(i iVar, VideoClickOrigin videoClickOrigin, t... tVarArr);

    public void a(boolean z) {
        this.j = z;
    }

    public abstract View b();

    public abstract com.fyber.inneractive.sdk.model.vast.c c();

    public void d() {
        g gVar = this.b;
        if (gVar != null) {
            com.fyber.inneractive.sdk.player.enums.b bVar = gVar.e;
            if (bVar == com.fyber.inneractive.sdk.player.enums.b.Completed || bVar == com.fyber.inneractive.sdk.player.enums.b.Prepared) {
                gVar.a(1, true);
            } else {
                gVar.l();
            }
        }
    }

    public void e(boolean z) {
        JSONArray jSONArray;
        String str;
        try {
            f0 f0Var = this.e;
            com.fyber.inneractive.sdk.response.g gVar = f0Var != null ? (com.fyber.inneractive.sdk.response.g) f0Var.b : null;
            r rVar = r.VAST_MEDIA_LOAD_RETRY_ATTEMPTED;
            InneractiveAdRequest inneractiveAdRequest = this.f;
            f0 f0Var2 = this.e;
            if (f0Var2 == null) {
                jSONArray = null;
            } else {
                jSONArray = f0Var2.c.c();
            }
            s.a aVar = new s.a(rVar, inneractiveAdRequest, (e) gVar, jSONArray);
            if (!(this.t == null || gVar == null)) {
                s.b a2 = new s.b().a("waudio", String.valueOf(z)).a("url", this.t.g).a("bitrate", this.t.e);
                if (TextUtils.isEmpty(this.t.d)) {
                    str = "na";
                } else {
                    str = this.t.d;
                }
                aVar.f.put(a2.a("mime", str).a("delivery", this.t.a).a("media_file_index", Integer.valueOf(this.q)).a("player", this.b.f()).a);
            }
            aVar.a((String) null);
        } catch (Exception unused) {
        }
    }

    public void a(Exception exc) {
        JSONObject jSONObject;
        Object[] objArr = new Object[1];
        objArr[0] = exc != null ? exc.getMessage() : "no exception";
        IAlog.a("IMediaPlayerFlowManager: onPlayerError called with: %s", objArr);
        InneractiveVideoError inneractiveVideoError = new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_MEDIA_FILE, exc);
        if (exc instanceof d) {
            ((d) exc).getClass();
            jSONObject = null;
        } else {
            jSONObject = new JSONObject();
        }
        a(inneractiveVideoError, jSONObject);
        if (this.n) {
            IAlog.a("IMediaPlayerFlowManager: onPlayerError video was prepared. This is a critical error. Aborting!", new Object[0]);
            a(new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES, exc), new JSONObject());
        }
    }

    public final void a() {
        g gVar;
        boolean z;
        Context context = this.a;
        com.fyber.inneractive.sdk.config.global.s sVar = this.d;
        if (sVar != null) {
            try {
                z = ((com.fyber.inneractive.sdk.config.global.features.r) sVar.a(com.fyber.inneractive.sdk.config.global.features.r.class)).a("use_fmp_cache_mechanism", false);
            } catch (Throwable th) {
                if (IAlog.a <= 3) {
                    IAlog.a("Failed creating exo player", new Object[0]);
                    th.printStackTrace();
                }
                gVar = null;
            }
        } else {
            z = false;
        }
        gVar = new com.fyber.inneractive.sdk.player.controller.d(context, z, sVar);
        if (gVar == null) {
            gVar = new com.fyber.inneractive.sdk.player.controller.a(context);
        }
        this.b = gVar;
        if (!gVar.b.contains(this)) {
            gVar.b.add(this);
        }
        g gVar2 = this.b;
        if (!gVar2.c.contains(this)) {
            gVar2.c.add(this);
        }
        this.b.f = this.u;
    }

    public static boolean a(int i2, b0 b0Var, int i3) {
        if (i3 == 1 || InneractiveAdManager.isCurrentUserAChild()) {
            return true;
        }
        if (i2 <= 15999) {
            return false;
        }
        c0 c0Var = b0Var != null ? ((a0) b0Var).f : null;
        if (c0Var == null || c0Var.h == Skip.DEFAULT || c0Var.j == UnitDisplayType.REWARDED) {
            return false;
        }
        return true;
    }

    public static int a(c cVar) {
        T t2;
        f0 f0Var = cVar.e;
        if (f0Var == null || (t2 = f0Var.b) == null) {
            return -1;
        }
        return ((com.fyber.inneractive.sdk.response.g) t2).w;
    }

    public boolean a(com.fyber.inneractive.sdk.config.global.s sVar, k kVar) {
        if (!kVar.e() || !IAConfigManager.M.E.d() || sVar == null || sVar.a(n.class) == null || !((n) sVar.a(n.class)).a("enable_app_info_button", true)) {
            return false;
        }
        return true;
    }
}
