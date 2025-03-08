package com.applovin.exoplayer2.i.i;

import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class i implements f {
    private final long[] Sc;
    private final List<e> TM;
    private final long[] TN;

    public i(List<e> list) {
        this.TM = Collections.unmodifiableList(new ArrayList(list));
        this.Sc = new long[(list.size() * 2)];
        for (int i = 0; i < list.size(); i++) {
            e eVar = list.get(i);
            int i2 = i * 2;
            this.Sc[i2] = eVar.Gi;
            this.Sc[i2 + 1] = eVar.Sy;
        }
        long[] jArr = this.Sc;
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        this.TN = copyOf;
        Arrays.sort(copyOf);
    }

    public int be(long j) {
        int b = ai.b(this.TN, j, false, false);
        if (b < this.TN.length) {
            return b;
        }
        return -1;
    }

    public int lX() {
        return this.TN.length;
    }

    public long ej(int i) {
        boolean z = true;
        a.checkArgument(i >= 0);
        if (i >= this.TN.length) {
            z = false;
        }
        a.checkArgument(z);
        return this.TN[i];
    }

    public List<com.applovin.exoplayer2.i.a> bf(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.TM.size(); i++) {
            long[] jArr = this.Sc;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                e eVar = this.TM.get(i);
                if (eVar.Px.Oa == -3.4028235E38f) {
                    arrayList2.add(eVar);
                } else {
                    arrayList.add(eVar.Px);
                }
            }
        }
        Collections.sort(arrayList2, new i$$ExternalSyntheticLambda0());
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            arrayList.add(((e) arrayList2.get(i3)).Px.lP().b((float) (-1 - i3), 1).lU());
        }
        return arrayList;
    }
}
