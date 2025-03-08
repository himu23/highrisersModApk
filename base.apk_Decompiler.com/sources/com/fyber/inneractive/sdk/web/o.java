package com.fyber.inneractive.sdk.web;

import android.content.DialogInterface;

public class o implements DialogInterface.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ i b;

    public o(i iVar, String str) {
        this.b = iVar;
        this.a = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.a(this.a);
    }
}
