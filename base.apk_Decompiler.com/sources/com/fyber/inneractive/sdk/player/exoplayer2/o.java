package com.fyber.inneractive.sdk.player.exoplayer2;

public final class o {
    public static final o b = new o(0);
    public final int a;

    public o(int i) {
        this.a = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass() && this.a == ((o) obj).a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.a;
    }
}
