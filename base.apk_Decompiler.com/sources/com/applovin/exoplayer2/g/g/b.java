package com.applovin.exoplayer2.g.g;

import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.v;

public abstract class b implements a.C0047a {
    public /* synthetic */ void F(ac.a aVar) {
        a.C0047a.CC.$default$F(this, aVar);
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ v kE() {
        return a.C0047a.CC.$default$kE(this);
    }

    public /* synthetic */ byte[] kF() {
        return a.C0047a.CC.$default$kF(this);
    }

    public String toString() {
        return "SCTE-35 splice command: type=" + getClass().getSimpleName();
    }
}
