package com.applovin.exoplayer2;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import com.ironsource.g$$ExternalSyntheticApiModelOutline0;

public final class f extends Binder {
    private static final int ah = (ai.acV >= 30 ? g$$ExternalSyntheticApiModelOutline0.m() : 65536);
    private final s<Bundle> ai;

    /* access modifiers changed from: protected */
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        int i3 = 0;
        if (parcel2 == null) {
            return false;
        }
        int size = this.ai.size();
        int readInt = parcel.readInt();
        while (readInt < size && parcel2.dataSize() < ah) {
            parcel2.writeInt(1);
            parcel2.writeBundle((Bundle) this.ai.get(readInt));
            readInt++;
        }
        if (readInt < size) {
            i3 = 2;
        }
        parcel2.writeInt(i3);
        return true;
    }

    public static s<Bundle> a(IBinder iBinder) {
        int readInt;
        s.a gc = s.gc();
        int i = 1;
        int i2 = 0;
        while (i != 0) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInt(i2);
                iBinder.transact(1, obtain, obtain2, 0);
                while (true) {
                    readInt = obtain2.readInt();
                    if (readInt != 1) {
                        break;
                    }
                    gc.t((Bundle) a.checkNotNull(obtain2.readBundle()));
                    i2++;
                }
                obtain2.recycle();
                obtain.recycle();
                i = readInt;
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
        return gc.gd();
    }
}
