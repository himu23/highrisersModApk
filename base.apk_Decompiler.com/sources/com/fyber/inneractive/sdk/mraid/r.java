package com.fyber.inneractive.sdk.mraid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.n;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.util.q;
import com.fyber.inneractive.sdk.web.i;
import com.fyber.inneractive.sdk.web.m;
import com.fyber.inneractive.sdk.web.o;
import java.util.Map;

public class r extends a {
    public r(Map<String, String> map, i iVar, p0 p0Var) {
        super(map, iVar, p0Var);
    }

    public void a() {
        String str = this.b.get("uri");
        if (str == null || "".equals(str)) {
            this.c.a(g.STORE_PICTURE, "Image can't be stored with null or empty URL");
            IAlog.a("Mraid Store Picture -Invalid URI ", new Object[0]);
            return;
        }
        i iVar = this.c;
        Context l = iVar.l();
        if (!n.n()) {
            iVar.a(g.STORE_PICTURE, "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
            IAlog.a("Error downloading file. Please check if the Android permission is not granted, or maybe the device does not have an SD card mounted? ", new Object[0]);
        } else if (l instanceof Activity) {
            new AlertDialog.Builder(iVar.l()).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).setPositiveButton("Okay", new o(iVar, str)).setCancelable(true).show();
        } else {
            q.b.post(new m(iVar, "Downloading image to Picture gallery..."));
            iVar.a(str);
        }
    }

    public String c() {
        return this.b.get("uri");
    }
}
