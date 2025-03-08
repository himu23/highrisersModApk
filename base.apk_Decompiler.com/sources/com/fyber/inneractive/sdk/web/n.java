package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.mraid.g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.q;
import com.fyber.inneractive.sdk.web.i;

public class n implements Runnable {
    public final /* synthetic */ i.e a;

    public n(i.e eVar) {
        this.a = eVar;
    }

    public void run() {
        i iVar = i.this;
        iVar.getClass();
        q.b.post(new m(iVar, "Image failed to download."));
        i.this.a(g.STORE_PICTURE, "Error downloading and saving image file.");
        IAlog.a("failed to download and save the image file.", new Object[0]);
    }
}
