package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.utils.IronSourceConstants;

public class ISBannerSize {
    public static final ISBannerSize BANNER = l.a(l.a, 320, 50);
    public static final ISBannerSize LARGE = l.a(l.b, 320, 90);
    public static final ISBannerSize RECTANGLE = l.a(l.c, 300, (int) IronSourceConstants.INTERSTITIAL_DAILY_CAPPED);
    public static final ISBannerSize SMART = l.a(l.e, 0, 0);
    protected static final ISBannerSize e = l.a();
    private final int a;
    private final int b;
    private final String c;
    private boolean d;

    public ISBannerSize(int i, int i2) {
        this(l.f, i, i2);
    }

    public ISBannerSize(String str, int i, int i2) {
        this.c = str;
        this.a = i;
        this.b = i2;
    }

    public String getDescription() {
        return this.c;
    }

    public int getHeight() {
        return this.b;
    }

    public int getWidth() {
        return this.a;
    }

    public boolean isAdaptive() {
        return this.d;
    }

    public boolean isSmart() {
        return this.c.equals(l.e);
    }

    public void setAdaptive(boolean z) {
        this.d = z;
    }
}
