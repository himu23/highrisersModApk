package com.fyber.inneractive.sdk.protobuf;

public class w implements n0 {
    public static final w a = new w();

    public boolean a(Class<?> cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fyber.inneractive.sdk.protobuf.m0 b(java.lang.Class<?> r5) {
        /*
            r4 = this;
            java.lang.Class<com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite> r0 = com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.class
            boolean r0 = r0.isAssignableFrom(r5)
            if (r0 == 0) goto L_0x0032
            java.lang.Class<com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite> r0 = com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.class
            java.lang.Class r0 = r5.asSubclass(r0)     // Catch:{ Exception -> 0x0019 }
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite r0 = com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.getDefaultInstance(r0)     // Catch:{ Exception -> 0x0019 }
            java.lang.Object r0 = r0.buildMessageInfo()     // Catch:{ Exception -> 0x0019 }
            com.fyber.inneractive.sdk.protobuf.m0 r0 = (com.fyber.inneractive.sdk.protobuf.m0) r0     // Catch:{ Exception -> 0x0019 }
            return r0
        L_0x0019:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unable to get message info for "
            r2.<init>(r3)
            java.lang.String r5 = r5.getName()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r1.<init>(r5, r0)
            throw r1
        L_0x0032:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unsupported message type: "
            r1.<init>(r2)
            java.lang.String r5 = r5.getName()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.w.b(java.lang.Class):com.fyber.inneractive.sdk.protobuf.m0");
    }
}
