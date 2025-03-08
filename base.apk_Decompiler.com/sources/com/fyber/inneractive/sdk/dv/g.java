package com.fyber.inneractive.sdk.dv;

import com.google.android.gms.ads.query.QueryInfo;

public class g {
    public QueryInfo a;

    public g(QueryInfo queryInfo) {
        this.a = queryInfo;
    }

    public String toString() {
        return this.a.getQuery();
    }
}
