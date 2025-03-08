package com.ironsource;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

public final class b4 {
    private String a;
    private boolean b;
    private String c;
    private g5 d;
    private boolean e = false;
    private ArrayList<Pair<String, String>> f;

    public static class a {
        /* access modifiers changed from: private */
        public String a = "";
        /* access modifiers changed from: private */
        public boolean b = false;
        /* access modifiers changed from: private */
        public String c = i9.b;
        /* access modifiers changed from: private */
        public g5 d;
        /* access modifiers changed from: private */
        public boolean e = false;
        /* access modifiers changed from: private */
        public ArrayList<Pair<String, String>> f = new ArrayList<>();

        public a(String str) {
            if (str != null && !str.isEmpty()) {
                this.a = str;
            }
        }

        public a a(Pair<String, String> pair) {
            this.f.add(pair);
            return this;
        }

        public a a(g5 g5Var) {
            this.d = g5Var;
            return this;
        }

        public a a(List<Pair<String, String>> list) {
            this.f.addAll(list);
            return this;
        }

        public a a(boolean z) {
            this.e = z;
            return this;
        }

        public b4 a() {
            return new b4(this);
        }

        public a b() {
            this.c = i9.a;
            return this;
        }

        public a b(boolean z) {
            this.b = z;
            return this;
        }

        public a c() {
            this.c = i9.b;
            return this;
        }
    }

    b4(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        if (aVar.f != null) {
            this.f = new ArrayList<>(aVar.f);
        }
    }

    public boolean a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public g5 c() {
        return this.d;
    }

    public ArrayList<Pair<String, String>> d() {
        return new ArrayList<>(this.f);
    }

    public String e() {
        return this.c;
    }

    public boolean f() {
        return this.e;
    }
}
