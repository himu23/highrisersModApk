package com.applovin.exoplayer2.e.g;

import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.l.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class a {
    public final int bs;

    public static int cf(int i) {
        return (i >> 24) & 255;
    }

    public static int cg(int i) {
        return i & ViewCompat.MEASURED_SIZE_MASK;
    }

    public a(int i) {
        this.bs = i;
    }

    public String toString() {
        return ch(this.bs);
    }

    static final class b extends a {
        public final y zo;

        public b(int i, y yVar) {
            super(i);
            this.zo = yVar;
        }
    }

    /* renamed from: com.applovin.exoplayer2.e.g.a$a  reason: collision with other inner class name */
    static final class C0041a extends a {
        public final long zl;
        public final List<b> zm = new ArrayList();
        public final List<C0041a> zn = new ArrayList();

        public C0041a(int i, long j) {
            super(i);
            this.zl = j;
        }

        public void a(b bVar) {
            this.zm.add(bVar);
        }

        public void a(C0041a aVar) {
            this.zn.add(aVar);
        }

        public b ci(int i) {
            int size = this.zm.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.zm.get(i2);
                if (bVar.bs == i) {
                    return bVar;
                }
            }
            return null;
        }

        public C0041a cj(int i) {
            int size = this.zn.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0041a aVar = this.zn.get(i2);
                if (aVar.bs == i) {
                    return aVar;
                }
            }
            return null;
        }

        public String toString() {
            return ch(this.bs) + " leaves: " + Arrays.toString(this.zm.toArray()) + " containers: " + Arrays.toString(this.zn.toArray());
        }
    }

    public static String ch(int i) {
        return "" + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }
}
