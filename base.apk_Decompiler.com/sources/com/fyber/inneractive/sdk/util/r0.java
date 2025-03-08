package com.fyber.inneractive.sdk.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.fyber.inneractive.sdk.util.s0;

public class r0 implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ s0.a c;

    public class a implements Runnable {
        public final /* synthetic */ Bitmap a;

        public a(Bitmap bitmap) {
            this.a = bitmap;
        }

        public void run() {
            s0.a aVar = r0.this.c;
            if (aVar != null) {
                aVar.a(this.a);
            }
        }
    }

    public r0(View view, Context context, s0.a aVar) {
        this.a = view;
        this.b = context;
        this.c = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
            android.view.View r0 = r4.a
            if (r0 == 0) goto L_0x0034
            int r1 = r0.getWidth()     // Catch:{ all -> 0x0024 }
            int r1 = r1 / 4
            int r2 = r0.getHeight()     // Catch:{ all -> 0x0024 }
            int r2 = r2 / 4
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ all -> 0x0024 }
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r1, r2, r3)     // Catch:{ all -> 0x0024 }
            android.graphics.Canvas r2 = new android.graphics.Canvas     // Catch:{ all -> 0x0024 }
            r2.<init>(r1)     // Catch:{ all -> 0x0024 }
            r3 = 1048576000(0x3e800000, float:0.25)
            r2.scale(r3, r3)     // Catch:{ all -> 0x0024 }
            r0.draw(r2)     // Catch:{ all -> 0x0024 }
            goto L_0x0035
        L_0x0024:
            r0 = move-exception
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r0 = r0.getLocalizedMessage()
            r2 = 0
            r1[r2] = r0
            java.lang.String r0 = "Failed creating a bitmap with exception %s"
            com.fyber.inneractive.sdk.util.IAlog.a(r0, r1)
        L_0x0034:
            r1 = 0
        L_0x0035:
            if (r1 == 0) goto L_0x004a
            android.content.Context r0 = r4.b
            android.graphics.Bitmap r0 = com.fyber.inneractive.sdk.util.s0.a(r0, r1)
            r1.recycle()
            android.os.Handler r1 = com.fyber.inneractive.sdk.util.q.b
            com.fyber.inneractive.sdk.util.r0$a r2 = new com.fyber.inneractive.sdk.util.r0$a
            r2.<init>(r0)
            r1.post(r2)
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.util.r0.run():void");
    }
}
