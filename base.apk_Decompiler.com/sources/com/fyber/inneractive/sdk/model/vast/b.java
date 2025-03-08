package com.fyber.inneractive.sdk.model.vast;

import com.fyber.inneractive.sdk.measurement.f;
import com.fyber.inneractive.sdk.response.i;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class b implements i {
    public String a;
    public String b;
    public Map<t, List<String>> c = new HashMap();
    public PriorityQueue<o> d;
    public final List<f> e = new ArrayList();
    public l f;
    public PriorityQueue<c> g;
    public c h = null;
    public int i = 0;
    public int j = 0;
    public final List<o> k = new ArrayList();
    public final List<c> l = new ArrayList();
    public final List<d> m = new ArrayList();

    public b(Comparator<o> comparator, Comparator<c> comparator2) {
        this.d = new PriorityQueue<>(1, comparator);
        this.g = new PriorityQueue<>(1, comparator2);
    }

    public List<o> b() {
        return new ArrayList(this.d);
    }

    public List<f> c() {
        return this.e;
    }

    public List<String> a(t tVar) {
        Map<t, List<String>> map = this.c;
        if (map == null) {
            return null;
        }
        return map.get(tVar);
    }

    public int a() {
        return this.d.size();
    }

    public void a(t tVar, String str) {
        List list = this.c.get(tVar);
        if (list == null) {
            list = new ArrayList();
            this.c.put(tVar, list);
        }
        list.add(str);
    }
}
