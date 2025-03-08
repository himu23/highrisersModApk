package com.applovin.exoplayer2.k;

import java.io.IOException;

public class j extends IOException {
    public final int tA;

    public static boolean a(IOException iOException) {
        Throwable th;
        while (th != null) {
            if ((th instanceof j) && ((j) th).tA == 2008) {
                return true;
            }
            Throwable cause = th.getCause();
            th = iOException;
            th = cause;
        }
        return false;
    }

    public j(int i) {
        this.tA = i;
    }

    public j(Throwable th, int i) {
        super(th);
        this.tA = i;
    }

    public j(String str, int i) {
        super(str);
        this.tA = i;
    }

    public j(String str, Throwable th, int i) {
        super(str, th);
        this.tA = i;
    }
}
