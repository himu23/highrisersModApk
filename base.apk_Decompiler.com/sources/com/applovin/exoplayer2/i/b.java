package com.applovin.exoplayer2.i;

import android.os.Bundle;
import android.os.Parcel;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.c;
import java.util.ArrayList;
import java.util.List;

public final class b {
    public s<a> F(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        Bundle readBundle = obtain.readBundle(Bundle.class.getClassLoader());
        obtain.recycle();
        return c.a(a.br, (List<Bundle>) (ArrayList) a.checkNotNull(readBundle.getParcelableArrayList("c")));
    }
}
