package com.fyber.inneractive.sdk.model.vast;

import android.text.TextUtils;
import java.util.ArrayList;

public class u implements Comparable<u> {
    public Integer[] a = new Integer[0];
    public final String b;

    public static class a extends Exception {
    }

    public u(String str) throws a {
        b(str);
        a(str);
        this.b = str;
    }

    public final void a(String str) throws a {
        ArrayList arrayList = new ArrayList();
        for (String a2 : str.split("\\.")) {
            arrayList.add(Integer.valueOf(com.fyber.inneractive.sdk.util.u.a(a2, 0)));
        }
        this.a = (Integer[]) arrayList.toArray(new Integer[arrayList.size()]);
    }

    public final void b(String str) throws a {
        if (TextUtils.isEmpty(str) || !str.matches("^[0-9.]+$")) {
            throw new a();
        }
    }

    public String toString() {
        return this.b;
    }

    /* renamed from: a */
    public int compareTo(u uVar) {
        if (uVar == null) {
            return 1;
        }
        int max = Math.max(this.a.length, uVar.a.length);
        int i = 0;
        while (i < max) {
            Integer[] numArr = this.a;
            int intValue = numArr.length > i ? numArr[i].intValue() : 0;
            Integer[] numArr2 = uVar.a;
            int intValue2 = numArr2.length > i ? numArr2[i].intValue() : 0;
            if (intValue > intValue2) {
                return 1;
            }
            if (intValue2 > intValue) {
                return -1;
            }
            i++;
        }
        return 0;
    }
}
