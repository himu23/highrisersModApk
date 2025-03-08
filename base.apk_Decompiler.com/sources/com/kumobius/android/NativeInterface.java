package com.kumobius.android;

import android.graphics.Rect;
import android.util.Log;

public class NativeInterface {
    private static boolean s_Available = false;
    private static final String s_TAG = "KumoJava";

    private static native void NativeActivate(INativeResponder iNativeResponder);

    private static native void NativeBeginAtomic(INativeResponder iNativeResponder);

    private static native void NativeBundlePathChanged(INativeResponder iNativeResponder, String str);

    private static native void NativeContextLost(INativeResponder iNativeResponder);

    private static native void NativeDeactivate(INativeResponder iNativeResponder);

    private static native void NativeDownloadData(INativeResponder iNativeResponder, long j, byte[] bArr, int i);

    private static native void NativeDownloadFailure(INativeResponder iNativeResponder, long j);

    private static native void NativeDownloadSuccess(INativeResponder iNativeResponder, long j);

    private static native void NativeEndAtomic(INativeResponder iNativeResponder);

    private static native int NativeIapComplete(INativeResponder iNativeResponder, String str, String str2);

    private static native void NativeInit(INativeResponder iNativeResponder, String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, String str3, String str4, int i7);

    private static native void NativeKeyDownUp(INativeResponder iNativeResponder, int i, int i2);

    private static native void NativePointerCancel(INativeResponder iNativeResponder, int i, float f, float f2, float f3);

    private static native void NativePointerDown(INativeResponder iNativeResponder, int i, float f, float f2, float f3);

    private static native void NativePointerMove(INativeResponder iNativeResponder, int i, float f, float f2, float f3);

    private static native void NativePointerUp(INativeResponder iNativeResponder, int i, float f, float f2, float f3);

    private static native void NativePushAdReward(INativeResponder iNativeResponder, long j);

    private static native void NativePushCloudValues(INativeResponder iNativeResponder, String[] strArr, String[] strArr2);

    private static native void NativeRender(INativeResponder iNativeResponder, float f, int i);

    private static native void NativeResized(INativeResponder iNativeResponder, int i, int i2, int i3, int i4, int i5, int i6);

    private static native void NativeScoresSubmitted(INativeResponder iNativeResponder, String[] strArr, String[] strArr2, long[] jArr);

    public static boolean getAvailable() {
        return s_Available;
    }

    public static void activate(INativeResponder iNativeResponder) {
        try {
            NativeActivate(iNativeResponder);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void deactivate(INativeResponder iNativeResponder) {
        try {
            NativeDeactivate(iNativeResponder);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void beginAtomic(INativeResponder iNativeResponder) {
        try {
            NativeBeginAtomic(iNativeResponder);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void endAtomic(INativeResponder iNativeResponder) {
        try {
            NativeEndAtomic(iNativeResponder);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void init(INativeResponder iNativeResponder, String str, String str2, int i, int i2, Rect rect, String str3, String str4, boolean z) {
        Rect rect2 = rect;
        try {
            NativeInit(iNativeResponder, str, str2, i, i2, rect2.left, rect2.top, rect2.right, rect2.bottom, str3, str4, z ? 1 : 0);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void contextLost(INativeResponder iNativeResponder) {
        try {
            NativeContextLost(iNativeResponder);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void resized(INativeResponder iNativeResponder, int i, int i2, Rect rect) {
        try {
            NativeResized(iNativeResponder, i, i2, rect.left, rect.top, rect.right, rect.bottom);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void bundlePathChanged(INativeResponder iNativeResponder, String str) {
        try {
            NativeBundlePathChanged(iNativeResponder, str);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void render(INativeResponder iNativeResponder, float f, boolean z) {
        try {
            NativeRender(iNativeResponder, f, z ? 1 : 0);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void keyDownUp(INativeResponder iNativeResponder, int i, boolean z) {
        try {
            NativeKeyDownUp(iNativeResponder, i, z ? 1 : 0);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void pointerDown(INativeResponder iNativeResponder, int i, float f, float f2, float f3) {
        try {
            NativePointerDown(iNativeResponder, i, f, f2, f3);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void pointerUp(INativeResponder iNativeResponder, int i, float f, float f2, float f3) {
        try {
            NativePointerUp(iNativeResponder, i, f, f2, f3);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void pointerMove(INativeResponder iNativeResponder, int i, float f, float f2, float f3) {
        try {
            NativePointerMove(iNativeResponder, i, f, f2, f3);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void pointerCancel(INativeResponder iNativeResponder, int i, float f, float f2, float f3) {
        try {
            NativePointerCancel(iNativeResponder, i, f, f2, f3);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void scoresSubmitted(INativeResponder iNativeResponder, String[] strArr, String[] strArr2, long[] jArr) {
        try {
            NativeScoresSubmitted(iNativeResponder, strArr, strArr2, jArr);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void pushCloudValues(INativeResponder iNativeResponder, String[] strArr, String[] strArr2) {
        try {
            NativePushCloudValues(iNativeResponder, strArr, strArr2);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static int iapComplete(INativeResponder iNativeResponder, String str, String str2) {
        try {
            return NativeIapComplete(iNativeResponder, str, str2);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
            return 0;
        }
    }

    public static void pushAdReward(INativeResponder iNativeResponder, long j) {
        try {
            NativePushAdReward(iNativeResponder, j);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void downloadData(INativeResponder iNativeResponder, long j, byte[] bArr, int i) {
        try {
            NativeDownloadData(iNativeResponder, j, bArr, i);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void downloadSuccess(INativeResponder iNativeResponder, long j) {
        try {
            NativeDownloadSuccess(iNativeResponder, j);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    public static void downloadFailure(INativeResponder iNativeResponder, long j) {
        try {
            NativeDownloadFailure(iNativeResponder, j);
        } catch (UnsatisfiedLinkError e) {
            Log.e(s_TAG, "UnsatisfiedLinkError: ", e);
            s_Available = false;
        }
    }

    static {
        try {
            System.loadLibrary("KumoGame");
            s_Available = true;
        } catch (Throwable th) {
            Log.e(s_TAG, "Failed to load libKumoGame.so", th);
            s_Available = false;
        }
    }
}
