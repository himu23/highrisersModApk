package com.applovin.impl.sdk.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class y {
    public static final y aWz = new y();
    protected String JN;
    protected final List<y> SG;
    private final y aWA;
    private final String aWB;
    private final Map<String, String> aWC;

    public String LI() {
        return this.aWB;
    }

    public Map<String, String> LJ() {
        return this.aWC;
    }

    public String LK() {
        return this.JN;
    }

    public y(String str, Map<String, String> map, y yVar) {
        this.aWA = yVar;
        this.aWB = str;
        this.aWC = Collections.unmodifiableMap(map);
        this.SG = new ArrayList();
    }

    private y() {
        this.aWA = null;
        this.aWB = "";
        this.aWC = Collections.emptyMap();
        this.JN = "";
        this.SG = Collections.emptyList();
    }

    public List<y> LL() {
        return Collections.unmodifiableList(this.SG);
    }

    public List<y> dJ(String str) {
        if (str != null) {
            ArrayList arrayList = new ArrayList(this.SG.size());
            for (y next : this.SG) {
                if (str.equalsIgnoreCase(next.LI())) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    public y dK(String str) {
        if (str != null) {
            for (y next : this.SG) {
                if (str.equalsIgnoreCase(next.LI())) {
                    return next;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    public y dL(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        } else if (this.SG.size() <= 0) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            while (!arrayList.isEmpty()) {
                y yVar = (y) arrayList.get(0);
                arrayList.remove(0);
                if (str.equalsIgnoreCase(yVar.LI())) {
                    return yVar;
                }
                arrayList.addAll(yVar.LL());
            }
            return null;
        }
    }

    public String toString() {
        return "XmlNode{elementName='" + this.aWB + "', text='" + this.JN + "', attributes=" + this.aWC + '}';
    }
}
