package com.applovin.impl.b;

import android.content.Context;
import android.net.Uri;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.l;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import java.util.HashSet;
import java.util.Set;

public class g {
    public final Set<k> aXE = new HashSet();
    private Uri aXF;
    private Uri aXG;
    public final Set<k> aXi = new HashSet();
    private int dE;
    private int height;

    public Set<k> Mp() {
        return this.aXi;
    }

    public Uri Mv() {
        return this.aXF;
    }

    public Uri Mw() {
        return this.aXG;
    }

    public Set<k> Mx() {
        return this.aXE;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.dE;
    }

    public static g a(y yVar, n nVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (nVar != null) {
            y dK = yVar.dK("StaticResource");
            if (dK == null || !URLUtil.isValidUrl(dK.LK())) {
                nVar.BN();
                if (!x.Fn()) {
                    return null;
                }
                nVar.BN().i("VastIndustryIcon", "Unable to create industry icon.  No valid image URL found.");
                return null;
            }
            g gVar = new g();
            gVar.aXF = Uri.parse(dK.LK());
            y dL = yVar.dL("IconClickThrough");
            if (dL != null && URLUtil.isValidUrl(dL.LK())) {
                gVar.aXG = Uri.parse(dL.LK());
            }
            String str = yVar.LJ().get("width");
            int i = 0;
            int parseInt = (str == null || Integer.parseInt(str) <= 0) ? 0 : Integer.parseInt(str);
            String str2 = yVar.LJ().get("height");
            if (str2 != null && Integer.parseInt(str2) > 0) {
                i = Integer.parseInt(str2);
            }
            int intValue = ((Integer) nVar.a(b.aPz)).intValue();
            if (parseInt <= 0 || i <= 0) {
                gVar.height = intValue;
                gVar.dE = intValue;
            } else {
                double d = (double) (((float) parseInt) / ((float) i));
                int min = Math.min(Math.max(parseInt, i), intValue);
                if (parseInt >= i) {
                    gVar.dE = min;
                    gVar.height = (int) (((double) min) / d);
                } else {
                    gVar.height = min;
                    gVar.dE = (int) (((double) min) * d);
                }
            }
            return gVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public static ImageView b(Uri uri, Context context, n nVar) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        imageView.setVisibility(8);
        l.a(imageView, uri.toString(), nVar);
        return imageView;
    }

    public String toString() {
        return "VastIndustryIcon{imageUri='" + Mv() + "', clickUri='" + Mw() + "', width=" + getWidth() + ", height=" + getHeight() + "}";
    }
}
