package com.fyber.inneractive.sdk.flow.vast;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.flow.vast.g;
import com.fyber.inneractive.sdk.measurement.f;
import com.fyber.inneractive.sdk.model.vast.b;
import com.fyber.inneractive.sdk.model.vast.c;
import com.fyber.inneractive.sdk.model.vast.e;
import com.fyber.inneractive.sdk.model.vast.g;
import com.fyber.inneractive.sdk.model.vast.h;
import com.fyber.inneractive.sdk.model.vast.i;
import com.fyber.inneractive.sdk.model.vast.j;
import com.fyber.inneractive.sdk.model.vast.k;
import com.fyber.inneractive.sdk.model.vast.l;
import com.fyber.inneractive.sdk.model.vast.n;
import com.fyber.inneractive.sdk.model.vast.o;
import com.fyber.inneractive.sdk.model.vast.q;
import com.fyber.inneractive.sdk.model.vast.s;
import com.fyber.inneractive.sdk.model.vast.t;
import com.fyber.inneractive.sdk.model.vast.v;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class d {
    public int a = -1;
    public int b = -1;
    public int c = -1;
    public boolean d = false;
    public boolean e = false;
    public Map<o, g> f = new LinkedHashMap();
    public List<g> g = new ArrayList();
    public final List<g> h = new ArrayList();
    public final List<f> i = new ArrayList();

    public class a extends Exception {
        public int a;

        public a(d dVar, String str, int i) {
            super(str);
            this.a = i;
        }
    }

    public void a(b bVar, g gVar, boolean z) throws a {
        Integer num;
        String str;
        List<s> list;
        String str2;
        Integer num2;
        g gVar2 = gVar;
        List<String> list2 = gVar2.h;
        if (list2 != null) {
            if (z) {
                this.h.add(gVar2);
            }
            for (String f2 : list2) {
                if (!b0.f(f2)) {
                    throw new a(this, "Found non secure click tracking url for companion: " + gVar2, 0);
                }
            }
        }
        String str3 = gVar2.g;
        if (b0.f(str3)) {
            Integer num3 = gVar2.a;
            Integer num4 = gVar2.b;
            if (num3 == null || num4 == null || num3.intValue() < 100 || num4.intValue() < 100) {
                throw new a(this, "Incompatible size: " + num3 + "," + num4, 16);
            }
            String str4 = gVar2.c;
            List<s> list3 = gVar2.j;
            if (list3 != null) {
                for (s next : list3) {
                    if (!b0.f(next.b)) {
                        throw new a(this, "Found non secure tracking event: " + next, 0);
                    }
                }
            }
            if (!TextUtils.isEmpty(gVar2.e) || !TextUtils.isEmpty(gVar2.f) || gVar2.d != null) {
                String str5 = gVar2.e;
                if (b0.f(str5)) {
                    j jVar = gVar2.d;
                    if (jVar != null) {
                        i a2 = i.a(jVar.a);
                        if (a2 != null) {
                            h hVar = h.Static;
                            int intValue = num3.intValue();
                            int intValue2 = num4.intValue();
                            str2 = str5;
                            list = list3;
                            str = str4;
                            num = num4;
                            String str6 = jVar.b;
                            num2 = num3;
                            a(bVar, hVar, z, intValue, intValue2, str4, str3, list2, list, str6, a2);
                        } else {
                            throw new a(this, "Found invalid creative type:" + jVar.a, 0);
                        }
                    } else {
                        str2 = str5;
                        list = list3;
                        str = str4;
                        num = num4;
                        num2 = num3;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        a(bVar, h.Iframe, z, num2.intValue(), num.intValue(), str, str3, list2, list, str2, (i) null);
                    }
                    String str7 = gVar2.f;
                    if (!TextUtils.isEmpty(str7)) {
                        a(bVar, h.Html, z, num2.intValue(), num.intValue(), str, str3, list2, list, str7, (i) null);
                        return;
                    }
                    return;
                }
                throw new a(this, "Found non secure iframe url:" + str5, 0);
            }
            throw new a(this, "None sources of companion avaliable", 0);
        }
        throw new a(this, "Found non secure click through url: " + str3, 0);
    }

    public b a(e eVar, List<e> list, String str) throws i {
        IAlog.a("%sprocess started", "VastProcessor: ");
        if (eVar == null || eVar.c == null) {
            IAlog.a("%sno inline found", "VastProcessor: ");
            throw new i("ErrorNoMediaFiles", "Empty inline ad found");
        }
        int f2 = p.f();
        int e2 = p.e();
        b bVar = new b(new h(this.c, f2, e2), new f(f2, e2));
        bVar.a = str;
        List<k> list2 = eVar.c.c;
        if (list2 == null || list2.isEmpty()) {
            throw new i("ErrorNoMediaFiles", "Empty inline with no creatives");
        }
        if (list != null) {
            for (e eVar2 : list) {
                v vVar = eVar2.b;
                if (vVar != null) {
                    a(bVar, (com.fyber.inneractive.sdk.model.vast.f) vVar, true);
                }
            }
        }
        a(bVar, (com.fyber.inneractive.sdk.model.vast.f) eVar.c, false);
        if (bVar.d.size() != 0) {
            if (IAlog.a == 2) {
                IAlog.d("%sLogging merged model media files: ", "VastProcessor: ");
                Iterator it = new ArrayList(bVar.d).iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    IAlog.d("%s(%d) %s", "VastProcessor: ", Integer.valueOf(i2), (o) it.next());
                    i2++;
                }
            }
            if (IAlog.a == 2) {
                IAlog.d("%sLogging merged model companion ads: ", "VastProcessor: ");
                ArrayList arrayList = new ArrayList(bVar.g);
                if (arrayList.size() > 0) {
                    Iterator it2 = arrayList.iterator();
                    int i3 = 0;
                    while (it2.hasNext()) {
                        IAlog.d("%s(%d) %s", "VastProcessor: ", Integer.valueOf(i3), ((c) it2.next()).a());
                        i3++;
                    }
                } else {
                    IAlog.d("%sNo companion ads found!", "VastProcessor: ");
                }
            }
            return bVar;
        } else if (this.f.size() == 0) {
            throw new i("ErrorNoMediaFiles", "No media files exist after merge");
        } else {
            throw new i("ErrorNoCompatibleMediaFile", "No compatible media files after filtering");
        }
    }

    public final void a(b bVar, com.fyber.inneractive.sdk.model.vast.f fVar, boolean z) {
        String[] split;
        g gVar;
        Integer num;
        Map<t, List<String>> map;
        List list;
        IAlog.a("%sprocessing ad element: %s", "VastProcessor: ", fVar);
        List<String> list2 = fVar.b;
        if (list2 != null) {
            for (String next : list2) {
                IAlog.a("%sadding impression url: %s", "VastProcessor: ", next);
                a((com.fyber.inneractive.sdk.response.i) bVar, t.EVENT_IMPRESSION, next);
            }
        }
        String str = fVar.a;
        if (!TextUtils.isEmpty(str)) {
            IAlog.a("%sadding error url: %s", "VastProcessor: ", str);
            bVar.a(t.EVENT_ERROR, str);
        }
        if (IAConfigManager.M.J != null) {
            for (f next2 : fVar.d) {
                if (next2.b()) {
                    bVar.e.add(next2);
                } else {
                    t tVar = t.EVENT_VERIFICATION_NOT_EXECUTED;
                    if (!(tVar == null || (map = next2.c) == null || (list = map.get(tVar)) == null || list.size() <= 0)) {
                        com.fyber.inneractive.sdk.player.e.a((com.fyber.inneractive.sdk.response.i) new com.fyber.inneractive.sdk.measurement.e(next2, next2.a(tVar), com.fyber.inneractive.sdk.measurement.g.VERIFICATION_NOT_SUPPORTED), tVar);
                    }
                    this.i.add(next2);
                }
            }
        }
        l lVar = fVar.e;
        if (lVar != null) {
            bVar.f = lVar;
        }
        for (k next3 : fVar.c) {
            n nVar = next3.a;
            if (nVar != null) {
                List<o> list3 = nVar.a;
                if (list3 != null) {
                    bVar.j = list3.size();
                    for (o next4 : list3) {
                        String str2 = next4.a;
                        com.fyber.inneractive.sdk.model.vast.p pVar = com.fyber.inneractive.sdk.model.vast.p.progressive;
                        if (!str2.equals(pVar.mValue)) {
                            gVar = new g(g.a.UNSUPPORTED_DELIVERY, pVar.mValue);
                        } else {
                            if (!(this.b <= -1 || (num = next4.e) == null || num.intValue() == 0)) {
                                int intValue = next4.e.intValue();
                                int i2 = this.a;
                                if (intValue < i2) {
                                    gVar = new g(g.a.BITRATE_NOT_IN_RANGE, Integer.valueOf(i2));
                                } else {
                                    int intValue2 = next4.e.intValue();
                                    int i3 = this.b;
                                    if (intValue2 > i3) {
                                        gVar = new g(g.a.BITRATE_NOT_IN_RANGE, Integer.valueOf(i3));
                                    }
                                }
                            }
                            if (q.a(next4.d) == q.UNKNOWN) {
                                gVar = new g(g.a.UNSUPPORTED_MIME_TYPE, (Object) null);
                            } else if (!this.d || next4.b.intValue() < next4.c.intValue()) {
                                String str3 = next4.f;
                                if (str3 != null && this.e && str3.equalsIgnoreCase("VPAID")) {
                                    gVar = new g(g.a.FILTERED_BY_APP_OR_UNIT, (Object) null);
                                } else if (TextUtils.isEmpty(next4.g)) {
                                    gVar = new g(g.a.NO_CONTENT, (Object) null);
                                } else if (!b0.f(next4.g)) {
                                    gVar = new g(g.a.UNSECURED_VIDEO_URL, (Object) null);
                                } else {
                                    gVar = null;
                                }
                            } else {
                                gVar = new g(g.a.VERTICAL_VIDEO_EXPECTED, (Object) null);
                            }
                        }
                        if (gVar != null) {
                            IAlog.a("%smedia file filtered!: %s", "VastProcessor: ", next4);
                            IAlog.a("%s-- %s", "VastProcessor: ", next4);
                            IAlog.a("%s-- %s", "VastProcessor: ", gVar);
                            this.f.put(next4, gVar);
                        } else {
                            IAlog.a("%sadding media file: %s", "VastProcessor: ", next4);
                            bVar.d.add(next4);
                            bVar.k.add(next4);
                            bVar.i++;
                        }
                    }
                }
                List<String> list4 = nVar.d;
                if (list4 != null) {
                    for (String a2 : list4) {
                        a((com.fyber.inneractive.sdk.response.i) bVar, t.EVENT_CLICK, a2);
                    }
                }
                List<s> list5 = nVar.b;
                if (list5 != null) {
                    for (s next5 : list5) {
                        t a3 = t.a(next5.a);
                        if (a3 != t.UNKNOWN) {
                            bVar.a(a3, next5.b);
                        }
                        if (a3 == t.EVENT_PROGRESS) {
                            String str4 = next5.b;
                            String str5 = next5.c;
                            com.fyber.inneractive.sdk.model.vast.d dVar = new com.fyber.inneractive.sdk.model.vast.d(str4, str5);
                            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5) && dVar.d != 0) {
                                bVar.m.add(dVar);
                            }
                        }
                    }
                }
                String str6 = nVar.c;
                if (str6 != null) {
                    bVar.b = str6;
                }
                String str7 = nVar.e;
                if (!TextUtils.isEmpty(str7) && (split = str7.split(":")) != null && split.length <= 3) {
                    if (split.length == 1) {
                        try {
                            Integer.parseInt(str7);
                        } catch (NumberFormatException unused) {
                        }
                    } else if (split.length == 2) {
                        Integer.parseInt(split[1]);
                        Integer.parseInt(split[0]);
                    } else {
                        Integer.parseInt(split[2]);
                        Integer.parseInt(split[1]);
                        Integer.parseInt(split[0]);
                    }
                }
            }
            List<com.fyber.inneractive.sdk.model.vast.g> list6 = next3.b;
            if (list6 != null) {
                for (com.fyber.inneractive.sdk.model.vast.g next6 : list6) {
                    try {
                        a(bVar, next6, z);
                    } catch (a e2) {
                        IAlog.a("Failed processing companion ad: %s error = %s", next6, e2.getMessage());
                        next6.i = e2;
                        this.g.add(next6);
                    }
                }
            }
        }
    }

    public final void a(com.fyber.inneractive.sdk.response.i iVar, t tVar, String str) throws i {
        if (b0.f(str)) {
            ((b) iVar).a(tVar, str);
            return;
        }
        throw new i("VastErrorUnsecure", "found unsecure tracking event: " + tVar.e());
    }

    public void a(b bVar, h hVar, boolean z, int i2, int i3, String str, String str2, List<String> list, List<s> list2, String str3, i iVar) {
        c cVar = new c(hVar, i2, i3, str);
        cVar.g = str2;
        if (list2 != null) {
            for (s next : list2) {
                cVar.a(t.a(next.a), next.b);
            }
        }
        if (list != null) {
            for (String a2 : list) {
                cVar.a(t.EVENT_CLICK, a2);
            }
        }
        a(cVar, z);
        cVar.f = str3;
        cVar.b = iVar;
        bVar.g.add(cVar);
        bVar.l.add(cVar);
    }

    public boolean a(c cVar, boolean z) {
        com.fyber.inneractive.sdk.model.vast.g gVar;
        boolean z2 = false;
        if (!this.h.isEmpty()) {
            if (z) {
                List<com.fyber.inneractive.sdk.model.vast.g> list = this.h;
                gVar = list.remove(list.size() - 1);
            } else {
                gVar = null;
            }
            String str = cVar.e;
            for (com.fyber.inneractive.sdk.model.vast.g next : this.h) {
                String str2 = next.c;
                if ((str != null && str.equals(str2)) || (str2 == null && cVar.c == next.a.intValue() && cVar.d == next.b.intValue())) {
                    List<String> list2 = next.h;
                    if (list2 != null) {
                        for (String next2 : list2) {
                            if (b0.f(next2)) {
                                cVar.a(t.EVENT_CLICK, next2);
                            }
                        }
                    }
                    z2 = true;
                }
            }
            if (gVar != null) {
                this.h.add(gVar);
            }
        }
        return z2;
    }
}
