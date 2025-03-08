package com.fyber.inneractive.sdk.flow.vast;

import android.view.View;
import java.util.Comparator;

public class a {
    public boolean a = false;
    public View b = null;
    public boolean c = false;
    public int d;
    public String e;
    public C0098a f = C0098a.HIGH;

    /* renamed from: com.fyber.inneractive.sdk.flow.vast.a$a  reason: collision with other inner class name */
    public enum C0098a {
        HIGH,
        LOW
    }

    public static class b implements Comparator<a> {
        public int compare(Object obj, Object obj2) {
            return ((a) obj).f.ordinal() - ((a) obj2).f.ordinal();
        }
    }

    public void a() {
        this.b = null;
        this.a = false;
    }

    public void a(View view) {
        this.b = view;
    }
}
