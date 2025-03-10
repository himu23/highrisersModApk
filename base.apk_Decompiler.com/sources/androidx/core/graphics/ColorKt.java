package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0019H\n\u001a\r\u0010\u0018\u001a\u00020\u0001*\u00020\u0001H\n\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0005H\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0019H\n\u001a\r\u0010\u001a\u001a\u00020\u0001*\u00020\u0001H\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0005H\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0019H\n\u001a\r\u0010\u001b\u001a\u00020\u0001*\u00020\u0001H\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0005H\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0019H\n\u001a\r\u0010\u001c\u001a\u00020\u0001*\u00020\u0001H\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0005H\n\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\f\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\u001eH\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\u001eH\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u001eH\f\u001a\u0015\u0010\u001f\u001a\u00020\u0019*\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0002\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0001H\b\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0005H\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020\u0005H\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020#H\b\u001a\r\u0010$\u001a\u00020\u0005*\u00020\u0001H\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0000\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u0016\u0010\t\u001a\u00020\n*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006\"\u0016\u0010\u000f\u001a\u00020\u0010*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u0010*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00018Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006\"\u0016\u0010\u0016\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0003\"\u0016\u0010\u0016\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006¨\u0006%"}, d2 = {"alpha", "", "getAlpha", "(I)I", "", "", "(J)F", "blue", "getBlue", "colorSpace", "Landroid/graphics/ColorSpace;", "getColorSpace", "(J)Landroid/graphics/ColorSpace;", "green", "getGreen", "isSrgb", "", "(J)Z", "isWideGamut", "luminance", "getLuminance", "(I)F", "red", "getRed", "component1", "Landroid/graphics/Color;", "component2", "component3", "component4", "convertTo", "Landroid/graphics/ColorSpace$Named;", "plus", "c", "toColor", "toColorInt", "", "toColorLong", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Color.kt */
public final class ColorKt {
    public static final int component1(int i) {
        return (i >> 24) & 255;
    }

    public static final int component2(int i) {
        return (i >> 16) & 255;
    }

    public static final int component3(int i) {
        return (i >> 8) & 255;
    }

    public static final int component4(int i) {
        return i & 255;
    }

    public static final int getAlpha(int i) {
        return (i >> 24) & 255;
    }

    public static final int getBlue(int i) {
        return i & 255;
    }

    public static final int getGreen(int i) {
        return (i >> 8) & 255;
    }

    public static final int getRed(int i) {
        return (i >> 16) & 255;
    }

    public static final float component1(Color color) {
        Intrinsics.checkNotNullParameter(color, "<this>");
        return color.getComponent(0);
    }

    public static final float component2(Color color) {
        Intrinsics.checkNotNullParameter(color, "<this>");
        return color.getComponent(1);
    }

    public static final float component3(Color color) {
        Intrinsics.checkNotNullParameter(color, "<this>");
        return color.getComponent(2);
    }

    public static final float component4(Color color) {
        Intrinsics.checkNotNullParameter(color, "<this>");
        return color.getComponent(3);
    }

    public static final Color plus(Color color, Color color2) {
        Intrinsics.checkNotNullParameter(color, "<this>");
        Intrinsics.checkNotNullParameter(color2, "c");
        Color compositeColors = ColorUtils.compositeColors(color2, color);
        Intrinsics.checkNotNullExpressionValue(compositeColors, "compositeColors(c, this)");
        return compositeColors;
    }

    public static final float getLuminance(int i) {
        return ColorKt$$ExternalSyntheticApiModelOutline0.m(i);
    }

    public static final Color toColor(int i) {
        Color m = ColorKt$$ExternalSyntheticApiModelOutline0.m(i);
        Intrinsics.checkNotNullExpressionValue(m, "valueOf(this)");
        return m;
    }

    public static final long toColorLong(int i) {
        return ColorKt$$ExternalSyntheticApiModelOutline0.m(i);
    }

    public static final float component1(long j) {
        return Color.red(j);
    }

    public static final float component2(long j) {
        return Color.green(j);
    }

    public static final float component3(long j) {
        return ColorKt$$ExternalSyntheticApiModelOutline0.m$1(j);
    }

    public static final float component4(long j) {
        return Color.alpha(j);
    }

    public static final float getAlpha(long j) {
        return Color.alpha(j);
    }

    public static final float getRed(long j) {
        return Color.red(j);
    }

    public static final float getGreen(long j) {
        return Color.green(j);
    }

    public static final float getBlue(long j) {
        return ColorKt$$ExternalSyntheticApiModelOutline0.m$1(j);
    }

    public static final float getLuminance(long j) {
        return ColorKt$$ExternalSyntheticApiModelOutline0.m(j);
    }

    public static final Color toColor(long j) {
        Color m = ColorKt$$ExternalSyntheticApiModelOutline0.m(j);
        Intrinsics.checkNotNullExpressionValue(m, "valueOf(this)");
        return m;
    }

    public static final int toColorInt(long j) {
        return ColorKt$$ExternalSyntheticApiModelOutline0.m(j);
    }

    public static final boolean isSrgb(long j) {
        return ColorKt$$ExternalSyntheticApiModelOutline0.m(j);
    }

    public static final boolean isWideGamut(long j) {
        return ColorKt$$ExternalSyntheticApiModelOutline0.m$1(j);
    }

    public static final ColorSpace getColorSpace(long j) {
        ColorSpace m = ColorKt$$ExternalSyntheticApiModelOutline0.m(j);
        Intrinsics.checkNotNullExpressionValue(m, "colorSpace(this)");
        return m;
    }

    public static final long convertTo(int i, ColorSpace.Named named) {
        Intrinsics.checkNotNullParameter(named, "colorSpace");
        return Color.convert(i, ColorSpace.get(named));
    }

    public static final long convertTo(int i, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        return Color.convert(i, colorSpace);
    }

    public static final long convertTo(long j, ColorSpace.Named named) {
        Intrinsics.checkNotNullParameter(named, "colorSpace");
        return Color.convert(j, ColorSpace.get(named));
    }

    public static final long convertTo(long j, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        return Color.convert(j, colorSpace);
    }

    public static final Color convertTo(Color color, ColorSpace.Named named) {
        Intrinsics.checkNotNullParameter(color, "<this>");
        Intrinsics.checkNotNullParameter(named, "colorSpace");
        Color m = color.convert(ColorSpace.get(named));
        Intrinsics.checkNotNullExpressionValue(m, "convert(ColorSpace.get(colorSpace))");
        return m;
    }

    public static final Color convertTo(Color color, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(color, "<this>");
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        Color m = color.convert(colorSpace);
        Intrinsics.checkNotNullExpressionValue(m, "convert(colorSpace)");
        return m;
    }

    public static final int toColorInt(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Color.parseColor(str);
    }
}
