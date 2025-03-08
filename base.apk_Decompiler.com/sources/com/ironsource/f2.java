package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

public class f2 {
    private boolean a = true;
    private IronSourceError b = null;

    public IronSourceError a() {
        return this.b;
    }

    public void a(IronSourceError ironSourceError) {
        this.a = false;
        this.b = ironSourceError;
    }

    public boolean b() {
        return this.a;
    }

    public void c() {
        this.a = true;
        this.b = null;
    }

    public String toString() {
        StringBuilder sb;
        if (b()) {
            sb = new StringBuilder("valid:");
            sb.append(this.a);
        } else {
            sb = new StringBuilder("valid:");
            sb.append(this.a);
            sb.append(", IronSourceError:");
            sb.append(this.b);
        }
        return sb.toString();
    }
}
