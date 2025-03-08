package com.fyber.inneractive.sdk.web;

import android.util.LruCache;

public class v<K> extends LruCache<K, y> {
    public v(int i) {
        super(i);
    }

    public int sizeOf(Object obj, Object obj2) {
        String str;
        y yVar = (y) obj2;
        int i = 0;
        for (String next : yVar.b.keySet()) {
            if (!(next == null || (str = yVar.b.get(next)) == null)) {
                i += next.length() + str.length();
            }
        }
        return i + yVar.a.length;
    }
}
