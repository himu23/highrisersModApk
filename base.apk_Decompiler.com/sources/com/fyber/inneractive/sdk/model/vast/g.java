package com.fyber.inneractive.sdk.model.vast;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.flow.vast.d;
import java.util.List;

public class g {
    public Integer a;
    public Integer b;
    public String c;
    public j d;
    public String e;
    public String f;
    public String g;
    public List<String> h;
    public d.a i;
    public List<s> j;

    public String toString() {
        StringBuilder sb = new StringBuilder("Companion:  w:");
        sb.append(this.a);
        sb.append(" h:");
        sb.append(this.b);
        sb.append(" ctr:");
        sb.append(this.g);
        sb.append(" clt:");
        sb.append(this.h);
        if (!TextUtils.isEmpty(this.f)) {
            sb.append(" html:");
            sb.append(this.f);
        }
        if (this.d != null) {
            sb.append(" static:");
            sb.append(this.d.b);
            sb.append("creative:");
            sb.append(this.d.a);
        }
        if (!TextUtils.isEmpty(this.e)) {
            sb.append(" iframe:");
            sb.append(this.e);
        }
        sb.append(" events:");
        sb.append(this.j);
        if (this.i != null) {
            sb.append(" reason:");
            sb.append(this.i.a);
        }
        return sb.toString();
    }
}
