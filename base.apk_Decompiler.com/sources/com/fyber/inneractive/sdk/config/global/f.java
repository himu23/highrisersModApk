package com.fyber.inneractive.sdk.config.global;

import com.ironsource.t4;

public class f implements d {
    public String a;
    public boolean b;

    public f(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public String toString() {
        return String.format("%s - %s include: %b", new Object[]{t4.x, this.a, Boolean.valueOf(this.b)});
    }

    public boolean a(e eVar) {
        String str = this.a;
        if (str != null) {
            return str.equalsIgnoreCase("android") ? !this.b : this.b;
        }
        return false;
    }
}
