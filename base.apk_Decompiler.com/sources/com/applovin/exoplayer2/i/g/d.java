package com.applovin.exoplayer2.i.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.l.a;
import com.ironsource.jc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

final class d {
    public final long Gi;
    public final String JN;
    private final String[] SA;
    public final String SB;
    public final String SC;
    public final d SD;
    private final HashMap<String, Integer> SE;
    private final HashMap<String, Integer> SF;
    private List<d> SG;
    public final boolean Sx;
    public final long Sy;
    public final g Sz;
    public final String tag;

    public boolean bh(long j) {
        long j2 = this.Gi;
        return (j2 == -9223372036854775807L && this.Sy == -9223372036854775807L) || (j2 <= j && this.Sy == -9223372036854775807L) || ((j2 == -9223372036854775807L && j < this.Sy) || (j2 <= j && j < this.Sy));
    }

    public String[] mG() {
        return this.SA;
    }

    public static d as(String str) {
        return new d((String) null, f.at(str), -9223372036854775807L, -9223372036854775807L, (g) null, (String[]) null, "", (String) null, (d) null);
    }

    public static d a(String str, long j, long j2, g gVar, String[] strArr, String str2, String str3, d dVar) {
        return new d(str, (String) null, j, j2, gVar, strArr, str2, str3, dVar);
    }

    private d(String str, String str2, long j, long j2, g gVar, String[] strArr, String str3, String str4, d dVar) {
        this.tag = str;
        this.JN = str2;
        this.SC = str4;
        this.Sz = gVar;
        this.SA = strArr;
        this.Sx = str2 != null;
        this.Gi = j;
        this.Sy = j2;
        this.SB = (String) a.checkNotNull(str3);
        this.SD = dVar;
        this.SE = new HashMap<>();
        this.SF = new HashMap<>();
    }

    public void a(d dVar) {
        if (this.SG == null) {
            this.SG = new ArrayList();
        }
        this.SG.add(dVar);
    }

    public d eC(int i) {
        List<d> list = this.SG;
        if (list != null) {
            return list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int mE() {
        List<d> list = this.SG;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public long[] mF() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        a((TreeSet<Long>) treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    private void a(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.tag);
        boolean equals2 = "div".equals(this.tag);
        if (z || equals || (equals2 && this.SC != null)) {
            long j = this.Gi;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.Sy;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.SG != null) {
            for (int i = 0; i < this.SG.size(); i++) {
                this.SG.get(i).a(treeSet, z || equals);
            }
        }
    }

    public List<com.applovin.exoplayer2.i.a> a(long j, Map<String, g> map, Map<String, e> map2, Map<String, String> map3) {
        ArrayList<Pair> arrayList = new ArrayList<>();
        a(j, this.SB, arrayList);
        TreeMap treeMap = new TreeMap();
        long j2 = j;
        a(j2, false, this.SB, (Map<String, a.C0050a>) treeMap);
        a(j2, map, map2, this.SB, (Map<String, a.C0050a>) treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                e eVar = (e) com.applovin.exoplayer2.l.a.checkNotNull(map2.get(pair.first));
                arrayList2.add(new a.C0050a().a(decodeByteArray).o(eVar.Od).eg(0).b(eVar.Oa, 0).ef(eVar.Oc).p(eVar.SH).q(eVar.SJ).ei(eVar.Ol).lU());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            e eVar2 = (e) com.applovin.exoplayer2.l.a.checkNotNull(map2.get(entry.getKey()));
            a.C0050a aVar = (a.C0050a) entry.getValue();
            a((SpannableStringBuilder) com.applovin.exoplayer2.l.a.checkNotNull(aVar.lQ()));
            aVar.b(eVar2.Oa, eVar2.Ob);
            aVar.ef(eVar2.Oc);
            aVar.o(eVar2.Od);
            aVar.p(eVar2.SH);
            aVar.c(eVar2.Ok, eVar2.Oj);
            aVar.ei(eVar2.Ol);
            arrayList2.add(aVar.lU());
        }
        return arrayList2;
    }

    private void a(long j, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.SB)) {
            str = this.SB;
        }
        if (!bh(j) || !"div".equals(this.tag) || this.SC == null) {
            for (int i = 0; i < mE(); i++) {
                eC(i).a(j, str, list);
            }
            return;
        }
        list.add(new Pair(str, this.SC));
    }

    private void a(long j, boolean z, String str, Map<String, a.C0050a> map) {
        this.SE.clear();
        this.SF.clear();
        if (!jc.l1.equals(this.tag)) {
            if (!"".equals(this.SB)) {
                str = this.SB;
            }
            if (this.Sx && z) {
                a(str, map).append((CharSequence) com.applovin.exoplayer2.l.a.checkNotNull(this.JN));
            } else if ("br".equals(this.tag) && z) {
                a(str, map).append(10);
            } else if (bh(j)) {
                for (Map.Entry next : map.entrySet()) {
                    this.SE.put((String) next.getKey(), Integer.valueOf(((CharSequence) com.applovin.exoplayer2.l.a.checkNotNull(((a.C0050a) next.getValue()).lQ())).length()));
                }
                boolean equals = "p".equals(this.tag);
                for (int i = 0; i < mE(); i++) {
                    eC(i).a(j, z || equals, str, map);
                }
                if (equals) {
                    f.b(a(str, map));
                }
                for (Map.Entry next2 : map.entrySet()) {
                    this.SF.put((String) next2.getKey(), Integer.valueOf(((CharSequence) com.applovin.exoplayer2.l.a.checkNotNull(((a.C0050a) next2.getValue()).lQ())).length()));
                }
            }
        }
    }

    private static SpannableStringBuilder a(String str, Map<String, a.C0050a> map) {
        if (!map.containsKey(str)) {
            a.C0050a aVar = new a.C0050a();
            aVar.m(new SpannableStringBuilder());
            map.put(str, aVar);
        }
        return (SpannableStringBuilder) com.applovin.exoplayer2.l.a.checkNotNull(map.get(str).lQ());
    }

    private void a(long j, Map<String, g> map, Map<String, e> map2, String str, Map<String, a.C0050a> map3) {
        int i;
        if (bh(j)) {
            String str2 = "".equals(this.SB) ? str : this.SB;
            Iterator<Map.Entry<String, Integer>> it = this.SF.entrySet().iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                String str3 = (String) next.getKey();
                int intValue = this.SE.containsKey(str3) ? this.SE.get(str3).intValue() : 0;
                int intValue2 = ((Integer) next.getValue()).intValue();
                if (intValue != intValue2) {
                    a(map, (a.C0050a) com.applovin.exoplayer2.l.a.checkNotNull(map3.get(str3)), intValue, intValue2, ((e) com.applovin.exoplayer2.l.a.checkNotNull(map2.get(str2))).Ol);
                } else {
                    Map<String, e> map4 = map2;
                    Map<String, a.C0050a> map5 = map3;
                }
            }
            Map<String, e> map6 = map2;
            Map<String, a.C0050a> map7 = map3;
            while (i < mE()) {
                eC(i).a(j, map, map2, str2, map3);
                i++;
                Map<String, e> map8 = map2;
            }
        }
    }

    private void a(Map<String, g> map, a.C0050a aVar, int i, int i2, int i3) {
        g a = f.a(this.Sz, this.SA, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) aVar.lQ();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            aVar.m(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (a != null) {
            f.a(spannableStringBuilder2, i, i2, a, this.SD, map, i3);
            if ("p".equals(this.tag)) {
                if (a.mP() != Float.MAX_VALUE) {
                    aVar.r((a.mP() * -90.0f) / 100.0f);
                }
                if (a.mT() != null) {
                    aVar.a(a.mT());
                }
                if (a.mU() != null) {
                    aVar.b(a.mU());
                }
            }
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder) {
        for (a aVar : (a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), a.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar), spannableStringBuilder.getSpanEnd(aVar), "");
        }
        for (int i = 0; i < spannableStringBuilder.length(); i++) {
            if (spannableStringBuilder.charAt(i) == ' ') {
                int i2 = i + 1;
                int i3 = i2;
                while (i3 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i3) == ' ') {
                    i3++;
                }
                int i4 = i3 - i2;
                if (i4 > 0) {
                    spannableStringBuilder.delete(i, i4 + i);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i5 = 0; i5 < spannableStringBuilder.length() - 1; i5++) {
            if (spannableStringBuilder.charAt(i5) == 10) {
                int i6 = i5 + 1;
                if (spannableStringBuilder.charAt(i6) == ' ') {
                    spannableStringBuilder.delete(i6, i5 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i7 = 0; i7 < spannableStringBuilder.length() - 1; i7++) {
            if (spannableStringBuilder.charAt(i7) == ' ') {
                int i8 = i7 + 1;
                if (spannableStringBuilder.charAt(i8) == 10) {
                    spannableStringBuilder.delete(i7, i8);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == 10) {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
    }
}
