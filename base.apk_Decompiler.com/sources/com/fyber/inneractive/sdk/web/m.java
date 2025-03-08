package com.fyber.inneractive.sdk.web;

import android.widget.Toast;
import com.fyber.inneractive.sdk.util.p;

public class m implements Runnable {
    public final /* synthetic */ String a;

    public m(i iVar, String str) {
        this.a = str;
    }

    public void run() {
        Toast.makeText(p.a, this.a, 0).show();
    }
}
