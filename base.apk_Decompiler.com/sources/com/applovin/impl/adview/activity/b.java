package com.applovin.impl.adview.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.WindowManager;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.utils.u;
import com.applovin.sdk.AppLovinSdkUtils;

public class b {
    private final Activity ahM;
    private final int aiH;
    private final int aiI;
    private final boolean aiJ;
    private final boolean aiK;

    private int p(int i, boolean z) {
        if (!z || !this.aiK) {
            if (i == 0) {
                return 1;
            }
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 9;
            }
            return i == 3 ? 8 : -1;
        } else if (i == 0) {
            return 0;
        } else {
            if (i == 1) {
                return 9;
            }
            if (i == 2) {
                return 8;
            }
            return i == 3 ? 1 : -1;
        }
    }

    public b(Activity activity) {
        this.ahM = activity;
        int ag = u.ag(activity);
        this.aiI = ag;
        boolean isTablet = AppLovinSdkUtils.isTablet(activity);
        this.aiJ = isTablet;
        this.aiH = p(ag, isTablet);
        this.aiK = isTablet && 2 == v(activity);
    }

    public void c(e eVar) {
        int i;
        if (!eVar.Gr() || (i = this.aiH) == -1) {
            a(eVar.Gb());
        } else {
            gd(i);
        }
    }

    private void a(e.b bVar) {
        int i = 1;
        if (bVar == e.b.ACTIVITY_PORTRAIT) {
            if (!this.aiJ || !this.aiK) {
                int i2 = this.aiI;
                if (i2 == 0 || i2 == 2) {
                    if (i2 != 0) {
                        i = 9;
                    }
                    gd(i);
                    return;
                }
                gd(1);
                return;
            }
            int i3 = this.aiI;
            if (i3 != 1 && i3 != 3) {
                gd(1);
            } else if (i3 == 1) {
                gd(9);
            } else {
                gd(1);
            }
        } else if (bVar == e.b.ACTIVITY_LANDSCAPE) {
            int i4 = 8;
            if (!this.aiJ || !this.aiK) {
                int i5 = this.aiI;
                if (i5 == 1 || i5 == 3) {
                    if (i5 == 1) {
                        i4 = 0;
                    }
                    gd(i4);
                    return;
                }
                gd(0);
                return;
            }
            int i6 = this.aiI;
            if (i6 == 0 || i6 == 2) {
                if (i6 != 2) {
                    i4 = 0;
                }
                gd(i4);
                return;
            }
            gd(0);
        }
    }

    private static int v(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) {
            return 2;
        }
        return 1;
    }

    private void gd(int i) {
        try {
            this.ahM.setRequestedOrientation(i);
        } catch (Throwable unused) {
        }
    }
}
