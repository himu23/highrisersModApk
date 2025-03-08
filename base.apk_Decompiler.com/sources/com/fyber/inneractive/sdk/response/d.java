package com.fyber.inneractive.sdk.response;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.flow.vast.g;
import com.fyber.inneractive.sdk.flow.vast.i;
import com.fyber.inneractive.sdk.measurement.f;
import com.fyber.inneractive.sdk.model.vast.e;
import com.fyber.inneractive.sdk.model.vast.o;
import com.fyber.inneractive.sdk.model.vast.r;
import com.fyber.inneractive.sdk.model.vast.u;
import com.fyber.inneractive.sdk.model.vast.v;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.t;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class d extends b {
    public g e;
    public a0 f;
    public e g;
    public List<e> h = new ArrayList();
    public int i;
    public u j;

    public e a() {
        g gVar = new g();
        this.a = gVar;
        g gVar2 = gVar;
        this.e = gVar;
        return gVar;
    }

    public void b(String str) throws i, Exception {
        r rVar;
        try {
            String replaceFirst = str.replaceFirst("<\\?.*\\?>", "");
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setCoalescing(true);
            Document parse = newInstance.newDocumentBuilder().parse(new InputSource(new StringReader(replaceFirst)));
            if (parse != null) {
                Node firstChild = parse.getFirstChild();
                if (firstChild.getNodeName().equalsIgnoreCase("VAST")) {
                    rVar = r.a(firstChild);
                } else {
                    IAlog.a("XML does not contain a VAST tag as its first child!", new Object[0]);
                    throw new Exception("XML does not contain a VAST tag as its first child!");
                }
            } else {
                rVar = null;
            }
            try {
                if (this.j == null) {
                    this.j = new u(rVar.a);
                } else {
                    u uVar = new u(rVar.a);
                    if (uVar.compareTo(this.j) >= 0) {
                        this.j = uVar;
                    }
                }
            } catch (u.a unused) {
            }
            List<e> list = rVar.b;
            if (list == null || list.size() == 0) {
                IAlog.a("Vast response parser: no ads found in model. aborting", new Object[0]);
                throw new i("ErrorNoMediaFiles", "No ads found in model. Empty Vast?");
            }
            e eVar = list.get(0);
            v vVar = eVar.b;
            if (vVar != null) {
                IAlog.a("Vast response parser: found VAST wrapper #%d", Integer.valueOf(this.h.size()));
                int size = this.h.size();
                int i2 = this.i;
                if (size < i2) {
                    this.h.add(eVar);
                    String str2 = vVar.f;
                    if (TextUtils.isEmpty(str2)) {
                        IAlog.a("Vast response parser: found an empty tag uri in wrapper! aborting!", new Object[0]);
                        throw new i("VastErrorInvalidFile", "No ad tag URI for wrapper");
                    } else if (b0.f(str2)) {
                        String a = t.a(str2, 3000, 5000, 5);
                        if (!TextUtils.isEmpty(a)) {
                            this.e.O.put(str2, a);
                            b(a);
                            return;
                        }
                        throw new i("VastErrorInvalidFile", "Failed getting data from ad tag URI");
                    } else {
                        IAlog.a("Vast response parser: Unsecure Wrapper URL. Aborting! url: %s", str2);
                        throw new i("VastErrorUnsecure", "Unsecure ad tag URI for wrapper");
                    }
                } else {
                    IAlog.a("Vast response parser: too many vast wrappers! Only %dallowed. stopping", Integer.valueOf(i2));
                    throw new i("VastErrorTooManyWrappers", "More than " + this.i + " found");
                }
            } else if (eVar.c != null) {
                this.g = eVar;
            } else {
                throw new i("VastErrorInvalidFile", "A top level ad with no wrapper on inline found!");
            }
        } catch (Exception e2) {
            IAlog.a("Failed parsing Vast file! parsing error = %s", e2.getMessage());
            throw new i("VastErrorInvalidFile", e2.getMessage());
        }
    }

    public boolean b() {
        return true;
    }

    public void a(String str, a0 a0Var) throws Exception {
        this.f = a0Var;
        if (a0Var == null || a0Var.f == null) {
            this.a.i = "ErrorConfigurationMismatch";
            return;
        }
        this.e.J = System.currentTimeMillis();
        this.i = IAConfigManager.M.i.b;
        this.e.getClass();
        try {
            b(str);
            a(this.g, this.h);
        } catch (InterruptedException e2) {
            throw e2;
        } catch (i e3) {
            this.e.i = e3.getMessage();
            this.e.j = e3.getCause().getMessage();
        } catch (Exception e4) {
            this.e.j = String.format("%s", new Object[]{e4.getMessage()});
            g gVar = this.e;
            gVar.i = "VastErrorInvalidFile";
            gVar.x = e4;
            if (IAlog.a == 2) {
                e4.printStackTrace();
            }
        }
    }

    public void a(e eVar, List<e> list) throws i {
        com.fyber.inneractive.sdk.flow.vast.d dVar = new com.fyber.inneractive.sdk.flow.vast.d();
        int intValue = this.f.f.c.intValue();
        int intValue2 = this.f.f.b.intValue();
        int intValue3 = this.f.f.g.intValue();
        dVar.a = intValue;
        dVar.b = intValue2;
        dVar.c = intValue3;
        if (UnitDisplayType.VERTICAL.equals(this.f.f.j)) {
            dVar.d = true;
        }
        if (this.f.f.k.contains(2)) {
            dVar.e = true;
        }
        try {
            u uVar = this.j;
            this.e.K = dVar.a(eVar, list, uVar != null ? uVar.b : "");
        } catch (i e2) {
            g gVar = this.e;
            gVar.getClass();
            gVar.i = e2.getMessage();
        }
        g gVar2 = this.e;
        Map<o, g> map = dVar.f;
        gVar2.getClass();
        if (map != null) {
            gVar2.L.putAll(map);
        }
        g gVar3 = this.e;
        List<com.fyber.inneractive.sdk.model.vast.g> list2 = dVar.g;
        gVar3.getClass();
        if (list2 != null) {
            gVar3.M.addAll(list2);
        }
        g gVar4 = this.e;
        List<f> list3 = dVar.i;
        gVar4.getClass();
        if (list3 != null) {
            gVar4.N.addAll(list3);
        }
        if (IAlog.a == 2) {
            Map<o, g> map2 = dVar.f;
            if (map2.size() > 0) {
                IAlog.d(" VParser: Unsupported media files:", new Object[0]);
                for (o next : map2.keySet()) {
                    IAlog.d("VParser: %s", next);
                    IAlog.d("VParser: reason = %s", map2.get(next));
                }
                return;
            }
            IAlog.d("VParser: Unsupported media files: none", new Object[0]);
        }
    }
}
