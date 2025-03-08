package com.ironsource;

import android.util.Pair;
import java.util.ArrayList;

public class f4 implements Runnable {
    private static final String e = "Content-Type";
    private static final String f = "application/json";
    private e5 a;
    String b;
    String c;
    ArrayList<y3> d;

    public f4(e5 e5Var, String str, String str2, ArrayList<y3> arrayList) {
        this.a = e5Var;
        this.b = str;
        this.c = str2;
        this.d = arrayList;
    }

    public void run() {
        boolean z = false;
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair("Content-Type", "application/json"));
            pa b2 = t5.b(this.c, this.b, arrayList);
            if (b2 != null) {
                int i = b2.a;
                if (i == 200 || i == 204) {
                    z = true;
                }
            }
        } catch (Exception unused) {
        }
        e5 e5Var = this.a;
        if (e5Var != null) {
            e5Var.a(this.d, z);
        }
    }
}
