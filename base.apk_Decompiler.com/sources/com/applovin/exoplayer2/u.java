package com.applovin.exoplayer2;

public final class u extends RuntimeException {
    public final int dm;

    private static String A(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "Undefined timeout." : "Detaching surface timed out." : "Setting foreground mode timed out." : "Player release timed out.";
    }

    public u(int i) {
        super(A(i));
        this.dm = i;
    }
}
