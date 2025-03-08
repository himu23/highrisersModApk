package com.fyber.inneractive.sdk.click;

import android.net.Uri;

public class h implements a {
    public final String a;
    public boolean b;

    public h(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public boolean a(Uri uri, l lVar) {
        return "fybernativebrowser".equalsIgnoreCase(uri.getScheme()) || "fybernativebrowser".equalsIgnoreCase(this.a) || this.b;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d A[Catch:{ ActivityNotFoundException -> 0x005b, all -> 0x002d, all -> 0x0084, all -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c A[Catch:{ ActivityNotFoundException -> 0x005b, all -> 0x002d, all -> 0x0084, all -> 0x009a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fyber.inneractive.sdk.click.b a(android.content.Context r9, android.net.Uri r10, java.util.List<com.fyber.inneractive.sdk.click.i> r11) {
        /*
            r8 = this;
            java.lang.String r0 = r10.toString()
            com.fyber.inneractive.sdk.util.b0$c r1 = com.fyber.inneractive.sdk.util.b0.c.OPEN_EVERYTHING
            java.lang.Class r2 = r9.getClass()     // Catch:{ all -> 0x000f }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x000f }
            goto L_0x0011
        L_0x000f:
            java.lang.String r2 = "failed"
        L_0x0011:
            r3 = 1
            r4 = 0
            r5 = 0
            java.lang.String r6 = "IAJavaUtil - valid url found: '%s' opening browser"
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ all -> 0x009a }
            r7[r4] = r0     // Catch:{ all -> 0x009a }
            com.fyber.inneractive.sdk.util.IAlog.a(r6, r7)     // Catch:{ all -> 0x009a }
            android.content.Intent r6 = com.fyber.inneractive.sdk.util.b0.a((android.content.Context) r9, (java.lang.String) r0)     // Catch:{ ActivityNotFoundException -> 0x005b, all -> 0x002d }
            r9.startActivity(r6)     // Catch:{ ActivityNotFoundException -> 0x005b, all -> 0x002d }
            com.fyber.inneractive.sdk.util.b0$a r6 = new com.fyber.inneractive.sdk.util.b0$a     // Catch:{ ActivityNotFoundException -> 0x005b, all -> 0x002d }
            com.fyber.inneractive.sdk.util.b0$d r7 = com.fyber.inneractive.sdk.util.b0.d.OPEN_IN_EXTERNAL_BROWSER     // Catch:{ ActivityNotFoundException -> 0x005b, all -> 0x002d }
            r6.<init>(r7, r5, r2)     // Catch:{ ActivityNotFoundException -> 0x005b, all -> 0x002d }
            goto L_0x00ab
        L_0x002d:
            boolean r6 = com.fyber.inneractive.sdk.util.b0.e(r0)     // Catch:{ all -> 0x009a }
            if (r6 != 0) goto L_0x004c
            boolean r6 = com.fyber.inneractive.sdk.util.b0.d(r0)     // Catch:{ all -> 0x009a }
            if (r6 != 0) goto L_0x004c
            com.fyber.inneractive.sdk.util.b0$c r6 = com.fyber.inneractive.sdk.util.b0.c.DO_NOT_OPEN_IN_INTERNAL_BROWSER     // Catch:{ all -> 0x009a }
            if (r1 == r6) goto L_0x004c
            android.content.Intent r1 = com.fyber.inneractive.sdk.util.b0.a(r9, r0, r5)     // Catch:{ all -> 0x009a }
            r9.startActivity(r1)     // Catch:{ all -> 0x009a }
            com.fyber.inneractive.sdk.util.b0$a r6 = new com.fyber.inneractive.sdk.util.b0$a     // Catch:{ all -> 0x009a }
            com.fyber.inneractive.sdk.util.b0$d r9 = com.fyber.inneractive.sdk.util.b0.d.OPENED_IN_INTERNAL_BROWSER     // Catch:{ all -> 0x009a }
            r6.<init>(r9, r5, r2)     // Catch:{ all -> 0x009a }
            goto L_0x00ab
        L_0x004c:
            com.fyber.inneractive.sdk.util.b0$a r6 = new com.fyber.inneractive.sdk.util.b0$a     // Catch:{ all -> 0x009a }
            com.fyber.inneractive.sdk.util.b0$d r9 = com.fyber.inneractive.sdk.util.b0.d.FAILED     // Catch:{ all -> 0x009a }
            com.fyber.inneractive.sdk.util.b0$b r1 = new com.fyber.inneractive.sdk.util.b0$b     // Catch:{ all -> 0x009a }
            java.lang.String r7 = "canOpenInExternalBrowser has decided it cant be opened and shouldUseInternalBrowser was set to true"
            r1.<init>(r7)     // Catch:{ all -> 0x009a }
            r6.<init>(r9, r1, r2)     // Catch:{ all -> 0x009a }
            goto L_0x00ab
        L_0x005b:
            java.lang.String r1 = "googlechrome://navigate?url=%s"
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x0084 }
            r6[r4] = r0     // Catch:{ all -> 0x0084 }
            java.lang.String r1 = java.lang.String.format(r1, r6)     // Catch:{ all -> 0x0084 }
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ all -> 0x0084 }
            android.content.Intent r6 = new android.content.Intent     // Catch:{ all -> 0x0084 }
            java.lang.String r7 = "android.intent.action.VIEW"
            r6.<init>(r7, r1)     // Catch:{ all -> 0x0084 }
            boolean r1 = r9 instanceof android.app.Activity     // Catch:{ all -> 0x0084 }
            if (r1 != 0) goto L_0x0079
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r6.addFlags(r1)     // Catch:{ all -> 0x0084 }
        L_0x0079:
            r9.startActivity(r6)     // Catch:{ all -> 0x0084 }
            com.fyber.inneractive.sdk.util.b0$a r6 = new com.fyber.inneractive.sdk.util.b0$a     // Catch:{ all -> 0x009a }
            com.fyber.inneractive.sdk.util.b0$d r9 = com.fyber.inneractive.sdk.util.b0.d.OPENED_USING_CHROME_NAVIGATE     // Catch:{ all -> 0x009a }
            r6.<init>(r9, r5, r2)     // Catch:{ all -> 0x009a }
            goto L_0x00ab
        L_0x0084:
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x009a }
            java.lang.String r1 = "Failed opening chrome for a special uri."
            com.fyber.inneractive.sdk.util.IAlog.e(r1, r9)     // Catch:{ all -> 0x009a }
            com.fyber.inneractive.sdk.util.b0$a r6 = new com.fyber.inneractive.sdk.util.b0$a     // Catch:{ all -> 0x009a }
            com.fyber.inneractive.sdk.util.b0$d r9 = com.fyber.inneractive.sdk.util.b0.d.FAILED     // Catch:{ all -> 0x009a }
            com.fyber.inneractive.sdk.util.b0$b r1 = new com.fyber.inneractive.sdk.util.b0$b     // Catch:{ all -> 0x009a }
            java.lang.String r7 = "tryOpeningChromeGracefully has failed and couldn't open the url"
            r1.<init>(r7)     // Catch:{ all -> 0x009a }
            r6.<init>(r9, r1, r2)     // Catch:{ all -> 0x009a }
            goto L_0x00ab
        L_0x009a:
            r9 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r3]
            r1[r4] = r0
            java.lang.String r6 = "IAJavaUtil - could not open a browser for url: %s"
            com.fyber.inneractive.sdk.util.IAlog.a(r6, r1)
            com.fyber.inneractive.sdk.util.b0$a r6 = new com.fyber.inneractive.sdk.util.b0$a
            com.fyber.inneractive.sdk.util.b0$d r1 = com.fyber.inneractive.sdk.util.b0.d.FAILED
            r6.<init>(r1, r9, r2)
        L_0x00ab:
            if (r11 == 0) goto L_0x00c8
            java.lang.Throwable r9 = r6.b
            if (r9 == 0) goto L_0x00be
            com.fyber.inneractive.sdk.click.i r1 = new com.fyber.inneractive.sdk.click.i
            java.lang.String r9 = r9.toString()
            r1.<init>(r0, r4, r5, r9)
            r11.add(r1)
            goto L_0x00c8
        L_0x00be:
            com.fyber.inneractive.sdk.click.i r9 = new com.fyber.inneractive.sdk.click.i
            com.fyber.inneractive.sdk.click.l$d r1 = com.fyber.inneractive.sdk.click.l.d.OPENED_IN_EXTERNAL_BROWSER
            r9.<init>(r0, r3, r1, r5)
            r11.add(r9)
        L_0x00c8:
            com.fyber.inneractive.sdk.click.l$d r9 = com.fyber.inneractive.sdk.click.l.d.OPENED_IN_EXTERNAL_BROWSER
            java.lang.String r10 = r10.toString()
            java.lang.String r11 = "FyberNativeBrowser"
            com.fyber.inneractive.sdk.click.b r9 = com.fyber.inneractive.sdk.click.l.a((java.lang.String) r10, (com.fyber.inneractive.sdk.click.l.d) r9, (java.lang.String) r11)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.click.h.a(android.content.Context, android.net.Uri, java.util.List):com.fyber.inneractive.sdk.click.b");
    }
}
