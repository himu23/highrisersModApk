package com.fyber.inneractive.sdk.protobuf;

public class b0 {
    public volatile o0 a;
    public volatile i b;

    static {
        q.a();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        o0 o0Var = this.a;
        o0 o0Var2 = b0Var.a;
        if (o0Var == null && o0Var2 == null) {
            return a().equals(b0Var.a());
        }
        if (o0Var != null && o0Var2 != null) {
            return o0Var.equals(o0Var2);
        }
        if (o0Var != null) {
            return o0Var.equals(b0Var.a(o0Var.getDefaultInstanceForType()));
        }
        return a(o0Var2.getDefaultInstanceForType()).equals(o0Var2);
    }

    public int hashCode() {
        return 1;
    }

    public i a() {
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b != null) {
                i iVar = this.b;
                return iVar;
            }
            if (this.a == null) {
                this.b = i.b;
            } else {
                this.b = this.a.toByteString();
            }
            i iVar2 = this.b;
            return iVar2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fyber.inneractive.sdk.protobuf.o0 a(com.fyber.inneractive.sdk.protobuf.o0 r2) {
        /*
            r1 = this;
            com.fyber.inneractive.sdk.protobuf.o0 r0 = r1.a
            if (r0 == 0) goto L_0x0005
            goto L_0x001a
        L_0x0005:
            monitor-enter(r1)
            com.fyber.inneractive.sdk.protobuf.o0 r0 = r1.a     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            goto L_0x001a
        L_0x000c:
            r1.a = r2     // Catch:{ z -> 0x0013 }
            com.fyber.inneractive.sdk.protobuf.i r0 = com.fyber.inneractive.sdk.protobuf.i.b     // Catch:{ z -> 0x0013 }
            r1.b = r0     // Catch:{ z -> 0x0013 }
            goto L_0x0019
        L_0x0013:
            r1.a = r2     // Catch:{ all -> 0x001d }
            com.fyber.inneractive.sdk.protobuf.i r2 = com.fyber.inneractive.sdk.protobuf.i.b     // Catch:{ all -> 0x001d }
            r1.b = r2     // Catch:{ all -> 0x001d }
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
        L_0x001a:
            com.fyber.inneractive.sdk.protobuf.o0 r2 = r1.a
            return r2
        L_0x001d:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.b0.a(com.fyber.inneractive.sdk.protobuf.o0):com.fyber.inneractive.sdk.protobuf.o0");
    }
}
