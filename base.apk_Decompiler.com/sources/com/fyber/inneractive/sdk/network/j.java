package com.fyber.inneractive.sdk.network;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class j {
    public int a;
    public String b;
    public InputStream c;
    public Map<String, List<String>> d;
    public String e;
    public final List<String> f = new ArrayList();

    public void a(int i) {
        this.a = i;
    }

    public void a(InputStream inputStream) {
        this.c = inputStream;
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(Map<String, List<String>> map) {
        this.d = map;
    }

    public InputStream b() {
        return this.c;
    }

    public String c() {
        return this.e;
    }

    public Map<String, List<String>> d() {
        return this.d;
    }

    public int e() {
        return this.a;
    }

    public void a() throws IOException {
        InputStream inputStream = this.c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable unused) {
            }
        }
    }
}
