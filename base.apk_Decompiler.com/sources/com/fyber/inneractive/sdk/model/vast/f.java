package com.fyber.inneractive.sdk.model.vast;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.c1;
import com.ironsource.w5;
import com.unity3d.ads.metadata.MediationMetaData;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

public class f {
    public String a;
    public List<String> b = new ArrayList();
    public List<k> c = new ArrayList();
    public List<com.fyber.inneractive.sdk.measurement.f> d = new ArrayList();
    public l e;

    public final void a(Node node) {
        com.fyber.inneractive.sdk.measurement.f fVar;
        Node d2 = c1.d(node, "AdVerifications");
        if (d2 != null) {
            Iterator it = ((ArrayList) c1.c(d2, "Verification")).iterator();
            while (it.hasNext()) {
                Node node2 = (Node) it.next();
                if (node2 == null) {
                    fVar = null;
                } else {
                    com.fyber.inneractive.sdk.measurement.f fVar2 = new com.fyber.inneractive.sdk.measurement.f();
                    fVar2.e = c1.b(node2, "vendor");
                    Node d3 = c1.d(node2, "JavaScriptResource");
                    if (d3 != null) {
                        fVar2.g = true;
                        try {
                            fVar2.f = c1.a(d3);
                            fVar2.b = c1.b(d3, "apiFramework");
                            fVar2.a = new URL(fVar2.f);
                        } catch (MalformedURLException unused) {
                        }
                    }
                    Node d4 = c1.d(node2, "TrackingEvents");
                    if (d4 != null) {
                        Iterator it2 = ((ArrayList) c1.c(d4, "Tracking")).iterator();
                        while (it2.hasNext()) {
                            Node node3 = (Node) it2.next();
                            s a2 = s.a(node3);
                            if (node3 != null && a2.a.equalsIgnoreCase("verificationNotExecuted")) {
                                fVar2.a(t.EVENT_VERIFICATION_NOT_EXECUTED, a2.b);
                            }
                        }
                    }
                    Node d5 = c1.d(node2, "VerificationParameters");
                    if (d5 != null) {
                        fVar2.d = c1.a(d5);
                    }
                    fVar = fVar2;
                }
                if (fVar != null) {
                    IAlog.a("Verification Found - %s", fVar.toString());
                    this.d.add(fVar);
                }
            }
        }
    }

    public void b(Node node) {
        Iterator it;
        k kVar;
        g gVar;
        Iterator it2;
        Iterator it3;
        o oVar;
        Node node2 = node;
        if (node2 != null) {
            Node d2 = c1.d(node2, "AdSystem");
            if (d2 != null) {
                c1.b(d2, MediationMetaData.KEY_VERSION);
                c1.a(d2);
            }
            Node d3 = c1.d(node2, "Error");
            if (d3 != null) {
                String a2 = c1.a(d3);
                if (!TextUtils.isEmpty(a2)) {
                    this.a = a2;
                }
            }
            Iterator it4 = ((ArrayList) c1.c(node2, "Impression")).iterator();
            while (it4.hasNext()) {
                String a3 = c1.a((Node) it4.next());
                if (!TextUtils.isEmpty(a3)) {
                    this.b.add(a3);
                }
            }
            Node d4 = c1.d(node2, "Creatives");
            if (d4 != null) {
                Iterator it5 = ((ArrayList) c1.c(d4, "Creative")).iterator();
                while (it5.hasNext()) {
                    Node node3 = (Node) it5.next();
                    if (node3 == null) {
                        it = it5;
                        kVar = null;
                    } else {
                        k kVar2 = new k();
                        c1.b(node3, "AdID");
                        c1.b(node3, w5.x);
                        c1.a(node3, "sequence");
                        Node d5 = c1.d(node3, "Linear");
                        if (d5 != null) {
                            n nVar = new n();
                            Node d6 = c1.d(d5, "MediaFiles");
                            if (d6 != null) {
                                ArrayList arrayList = (ArrayList) c1.c(d6, "MediaFile");
                                if (!arrayList.isEmpty()) {
                                    nVar.a = new ArrayList();
                                    Iterator it6 = arrayList.iterator();
                                    while (it6.hasNext()) {
                                        Node node4 = (Node) it6.next();
                                        if (node4 == null) {
                                            it3 = it5;
                                            it2 = it6;
                                            oVar = null;
                                        } else {
                                            it3 = it5;
                                            oVar = new o();
                                            it2 = it6;
                                            oVar.a = c1.b(node4, "delivery");
                                            oVar.b = c1.a(node4, "width");
                                            oVar.c = c1.a(node4, "height");
                                            oVar.d = c1.b(node4, "type");
                                            c1.b(node4, w5.x);
                                            oVar.f = c1.b(node4, "apiFramework");
                                            oVar.e = c1.a(node4, "bitrate");
                                            String b2 = c1.b(node4, "maintainAspectRatio");
                                            if (!TextUtils.isEmpty(b2)) {
                                                try {
                                                    Boolean.valueOf(b2);
                                                } catch (NumberFormatException unused) {
                                                }
                                            }
                                            String b3 = c1.b(node4, "scalable");
                                            if (!TextUtils.isEmpty(b3)) {
                                                try {
                                                    Boolean.valueOf(b3);
                                                } catch (NumberFormatException unused2) {
                                                }
                                            }
                                            oVar.g = c1.a(node4);
                                        }
                                        if (oVar != null) {
                                            nVar.a.add(oVar);
                                        }
                                        it5 = it3;
                                        it6 = it2;
                                    }
                                }
                            }
                            it = it5;
                            Node d7 = c1.d(d5, "VideoClicks");
                            if (d7 != null) {
                                nVar.c = c1.a(c1.d(d7, "ClickThrough"));
                                ArrayList arrayList2 = (ArrayList) c1.c(d7, "ClickTracking");
                                if (!arrayList2.isEmpty()) {
                                    nVar.d = new ArrayList();
                                    Iterator it7 = arrayList2.iterator();
                                    while (it7.hasNext()) {
                                        String a4 = c1.a((Node) it7.next());
                                        if (!TextUtils.isEmpty(a4)) {
                                            nVar.d.add(a4);
                                        }
                                    }
                                }
                            }
                            Node d8 = c1.d(d5, "TrackingEvents");
                            if (d8 != null) {
                                ArrayList arrayList3 = (ArrayList) c1.c(d8, "Tracking");
                                if (!arrayList3.isEmpty()) {
                                    nVar.b = new ArrayList();
                                    Iterator it8 = arrayList3.iterator();
                                    while (it8.hasNext()) {
                                        s a5 = s.a((Node) it8.next());
                                        if (a5 != null) {
                                            nVar.b.add(a5);
                                        }
                                    }
                                }
                            }
                            Node d9 = c1.d(d5, "Duration");
                            if (d9 != null) {
                                nVar.e = c1.a(d9);
                            }
                            kVar2.a = nVar;
                        } else {
                            it = it5;
                        }
                        Node d10 = c1.d(node3, "CompanionAds");
                        if (d10 != null) {
                            List<Node> c2 = c1.c(d10, "Companion");
                            kVar2.b = new ArrayList();
                            Iterator it9 = ((ArrayList) c2).iterator();
                            while (it9.hasNext()) {
                                Node node5 = (Node) it9.next();
                                if (node5 == null) {
                                    gVar = null;
                                } else {
                                    gVar = new g();
                                    gVar.a = c1.a(node5, "width");
                                    gVar.b = c1.a(node5, "height");
                                    gVar.c = c1.b(node5, w5.x);
                                    c1.b(node5, "apiFramework");
                                    c1.a(node5, "expandedWidth");
                                    c1.a(node5, "expandedHeight");
                                    Node d11 = c1.d(node5, "StaticResource");
                                    if (d11 != null) {
                                        j jVar = new j();
                                        jVar.a = c1.b(d11, "creativeType");
                                        jVar.b = c1.a(d11);
                                        gVar.d = jVar;
                                    }
                                    Node d12 = c1.d(node5, "HTMLResource");
                                    if (d12 != null) {
                                        gVar.f = c1.a(d12);
                                    }
                                    Node d13 = c1.d(node5, "IFrameResource");
                                    if (d13 != null) {
                                        gVar.e = c1.a(d13);
                                    }
                                    Node d14 = c1.d(node5, "CompanionClickThrough");
                                    if (d14 != null) {
                                        gVar.g = c1.a(d14);
                                    }
                                    ArrayList arrayList4 = (ArrayList) c1.c(node5, "CompanionClickTracking");
                                    if (arrayList4.size() > 0) {
                                        gVar.h = new ArrayList();
                                        Iterator it10 = arrayList4.iterator();
                                        while (it10.hasNext()) {
                                            String a6 = c1.a((Node) it10.next());
                                            if (!TextUtils.isEmpty(a6)) {
                                                gVar.h.add(a6);
                                            }
                                        }
                                    }
                                    Node d15 = c1.d(node5, "TrackingEvents");
                                    if (d15 != null) {
                                        ArrayList arrayList5 = (ArrayList) c1.c(d15, "Tracking");
                                        if (!arrayList5.isEmpty()) {
                                            gVar.j = new ArrayList();
                                            Iterator it11 = arrayList5.iterator();
                                            while (it11.hasNext()) {
                                                s a7 = s.a((Node) it11.next());
                                                if (a7 != null) {
                                                    gVar.j.add(a7);
                                                }
                                            }
                                        }
                                    }
                                }
                                if (gVar != null) {
                                    kVar2.b.add(gVar);
                                }
                            }
                        }
                        kVar = kVar2;
                    }
                    if (kVar != null) {
                        this.c.add(kVar);
                    }
                    it5 = it;
                }
            }
            Node d16 = c1.d(node2, "Extensions");
            if (d16 != null) {
                Iterator it12 = ((ArrayList) c1.c(d16, "Extension")).iterator();
                while (it12.hasNext()) {
                    Node node6 = (Node) it12.next();
                    if ("AdVerifications".equalsIgnoreCase(c1.b(node6, "type"))) {
                        a(node6);
                    }
                    if ("FMPCompanionAssets".equalsIgnoreCase(c1.b(node6, "type"))) {
                        IAlog.a("parseFMPCompanionAssetsTag", new Object[0]);
                        Node d17 = c1.d(node6, "FMPCompanionAssets");
                        if (d17 != null) {
                            l lVar = new l();
                            Node d18 = c1.d(d17, "Name");
                            if (d18 != null) {
                                lVar.a = c1.a(d18);
                            }
                            Node d19 = c1.d(d17, "Description");
                            if (d19 != null) {
                                lVar.b = c1.a(d19);
                            }
                            Node d20 = c1.d(d17, "Icons");
                            if (d20 != null) {
                                lVar.c = new ArrayList();
                                Iterator it13 = ((ArrayList) c1.c(d20, "Icon")).iterator();
                                while (it13.hasNext()) {
                                    lVar.c.add(c1.a((Node) it13.next()));
                                }
                            }
                            Node d21 = c1.d(d17, "Rating");
                            if (d21 != null) {
                                try {
                                    lVar.e = Float.parseFloat(c1.a(d21));
                                } catch (Exception unused3) {
                                }
                            }
                            Node d22 = c1.d(d17, "Screenshots");
                            if (d22 != null) {
                                lVar.f = new ArrayList();
                                Iterator it14 = ((ArrayList) c1.c(d22, "Screenshot")).iterator();
                                while (it14.hasNext()) {
                                    String a8 = c1.a((Node) it14.next());
                                    if (!TextUtils.isEmpty(a8)) {
                                        lVar.f.add(a8);
                                    }
                                }
                            }
                            this.e = lVar;
                        }
                    }
                }
            }
            a(node);
        }
    }
}
