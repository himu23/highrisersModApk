package com.applovin.exoplayer2.ui;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.l.ai;

public final class c {
    public static final c VW = new c(-1, ViewCompat.MEASURED_STATE_MASK, 0, 0, -1, (Typeface) null);
    public final int Oi;
    public final int Qa;
    public final int Qc;
    public final int VX;
    public final int VY;
    public final Typeface VZ;

    public static c a(CaptioningManager.CaptionStyle captionStyle) {
        if (ai.acV >= 21) {
            return c(captionStyle);
        }
        return b(captionStyle);
    }

    public c(int i, int i2, int i3, int i4, int i5, Typeface typeface) {
        this.Qa = i;
        this.Qc = i2;
        this.Oi = i3;
        this.VX = i4;
        this.VY = i5;
        this.VZ = typeface;
    }

    private static c b(CaptioningManager.CaptionStyle captionStyle) {
        return new c(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    private static c c(CaptioningManager.CaptionStyle captionStyle) {
        return new c(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : VW.Qa, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : VW.Qc, captionStyle.hasWindowColor() ? captionStyle.windowColor : VW.Oi, captionStyle.hasEdgeType() ? captionStyle.edgeType : VW.VX, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : VW.VY, captionStyle.getTypeface());
    }
}
