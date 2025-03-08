package com.fyber.inneractive.sdk.util;

import android.net.Uri;
import java.util.List;

public class v0 implements Comparable<v0> {
    public a a;
    public Uri b;
    public List<String> c;

    public enum a {
        Primary(1),
        FallBack(2);
        
        public Integer mPriority;

        /* access modifiers changed from: public */
        a(Integer num) {
            this.mPriority = num;
        }
    }

    public v0(a aVar, Uri uri, List<String> list) {
        this.a = aVar;
        this.b = uri;
        this.c = list;
    }

    public int compareTo(Object obj) {
        return this.a.mPriority.compareTo(((v0) obj).a.mPriority);
    }
}
