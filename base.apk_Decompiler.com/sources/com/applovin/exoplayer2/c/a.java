package com.applovin.exoplayer2.c;

import com.google.android.gms.drive.DriveFile;

public abstract class a {
    private int jF;

    public final void bs(int i) {
        this.jF = i;
    }

    public final void bt(int i) {
        this.jF = i | this.jF;
    }

    public final void bu(int i) {
        this.jF = (~i) & this.jF;
    }

    /* access modifiers changed from: protected */
    public final boolean bv(int i) {
        return (this.jF & i) == i;
    }

    public void clear() {
        this.jF = 0;
    }

    public final boolean gX() {
        return bv(Integer.MIN_VALUE);
    }

    public final boolean gY() {
        return bv(4);
    }

    public final boolean gZ() {
        return bv(1);
    }

    public final boolean ha() {
        return bv(DriveFile.MODE_READ_ONLY);
    }
}
