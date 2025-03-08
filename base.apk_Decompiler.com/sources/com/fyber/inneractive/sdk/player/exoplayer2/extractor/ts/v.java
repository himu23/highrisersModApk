package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.r;
import java.util.Collections;
import java.util.List;

public interface v {

    public static final class a {
        public final String a;
        public final byte[] b;

        public a(String str, int i, byte[] bArr) {
            this.a = str;
            this.b = bArr;
        }
    }

    public static final class b {
        public final String a;
        public final List<a> b;
        public final byte[] c;

        public b(int i, String str, List<a> list, byte[] bArr) {
            List<a> list2;
            this.a = str;
            if (list == null) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(list);
            }
            this.b = list2;
            this.c = bArr;
        }
    }

    public interface c {
        SparseArray<v> a();

        v a(int i, b bVar);
    }

    public static final class d {
        public final String a;
        public final int b;
        public final int c;
        public int d;
        public String e;

        public d(int i, int i2, int i3) {
            String str;
            if (i != Integer.MIN_VALUE) {
                str = i + "/";
            } else {
                str = "";
            }
            this.a = str;
            this.b = i2;
            this.c = i3;
            this.d = Integer.MIN_VALUE;
        }

        public void a() {
            int i = this.d;
            this.d = i == Integer.MIN_VALUE ? this.b : i + this.c;
            this.e = this.a + this.d;
        }

        public int c() {
            int i = this.d;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }

        public String b() {
            if (this.d != Integer.MIN_VALUE) {
                return this.e;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }

    void a();

    void a(k kVar, boolean z);

    void a(r rVar, h hVar, d dVar);
}
