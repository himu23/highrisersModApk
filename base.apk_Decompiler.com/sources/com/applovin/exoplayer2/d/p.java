package com.applovin.exoplayer2.d;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.a.u;
import com.applovin.exoplayer2.d.m;
import com.applovin.exoplayer2.h;
import com.applovin.exoplayer2.k.k;
import com.applovin.exoplayer2.k.l;
import com.applovin.exoplayer2.k.t;
import com.applovin.exoplayer2.k.z;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import com.ironsource.z3;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class p implements r {
    private final t.b ts;
    private final String tt;
    private final boolean tu;
    private final Map<String, String> tv;

    public p(String str, boolean z, t.b bVar) {
        a.checkArgument(!z || !TextUtils.isEmpty(str));
        this.ts = bVar;
        this.tt = str;
        this.tu = z;
        this.tv = new HashMap();
    }

    public void c(String str, String str2) {
        a.checkNotNull(str);
        a.checkNotNull(str2);
        synchronized (this.tv) {
            this.tv.put(str, str2);
        }
    }

    public byte[] a(UUID uuid, m.d dVar) throws s {
        return a(this.ts, dVar.hQ() + "&signedRequest=" + ai.J(dVar.hO()), (byte[]) null, Collections.emptyMap());
    }

    public byte[] a(UUID uuid, m.a aVar) throws s {
        String str;
        String hP = aVar.hP();
        if (this.tu || TextUtils.isEmpty(hP)) {
            hP = this.tt;
        }
        if (!TextUtils.isEmpty(hP)) {
            HashMap hashMap = new HashMap();
            if (h.an.equals(uuid)) {
                str = "text/xml";
            } else {
                str = h.al.equals(uuid) ? z3.J : "application/octet-stream";
            }
            hashMap.put(z3.I, str);
            if (h.an.equals(uuid)) {
                hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
            }
            synchronized (this.tv) {
                hashMap.putAll(this.tv);
            }
            return a(this.ts, hP, aVar.hO(), hashMap);
        }
        throw new s(new l.a().e(Uri.EMPTY).oj(), Uri.EMPTY, u.gi(), 0, new IllegalStateException("No license URL"));
    }

    private static byte[] a(t.b bVar, String str, byte[] bArr, Map<String, String> map) throws s {
        k kVar;
        z zVar = new z(bVar.ox());
        l oj = new l.a().aK(str).d(map).fh(2).G(bArr).fi(1).oj();
        int i = 0;
        l lVar = oj;
        while (true) {
            try {
                kVar = new k(zVar, lVar);
                byte[] a = ai.a((InputStream) kVar);
                ai.a((Closeable) kVar);
                return a;
            } catch (t.e e) {
                String a2 = a(e, i);
                if (a2 != null) {
                    i++;
                    lVar = lVar.oi().aK(a2).oj();
                    ai.a((Closeable) kVar);
                } else {
                    throw e;
                }
            } catch (Exception e2) {
                throw new s(oj, (Uri) a.checkNotNull(zVar.oI()), zVar.kT(), zVar.oH(), e2);
            } catch (Throwable th) {
                ai.a((Closeable) kVar);
                throw th;
            }
        }
    }

    private static String a(t.e eVar, int i) {
        Map<String, List<String>> map;
        List list;
        if ((eVar.aaC == 307 || eVar.aaC == 308) && i < 5 && (map = eVar.aaM) != null && (list = map.get("Location")) != null && !list.isEmpty()) {
            return (String) list.get(0);
        }
        return null;
    }
}
