package com.fyber.inneractive.sdk.player.cache;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class a {
    public File a;
    public String b;
    public boolean c;
    public Object d = new Object();
    public Map<String, String> e = new HashMap();
    public volatile boolean f = false;

    public a(String str, String str2, File file, boolean z, String str3) {
        this.a = file;
        this.b = str2;
        this.c = z;
    }

    public File a() {
        File file;
        synchronized (this.d) {
            file = this.a;
        }
        return file;
    }
}
