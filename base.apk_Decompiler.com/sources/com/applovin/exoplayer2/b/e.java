package com.applovin.exoplayer2.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.provider.Settings;
import com.applovin.exoplayer2.ay$$ExternalSyntheticApiModelOutline0;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.common.b.c;
import com.applovin.exoplayer2.l.ai;
import com.ironsource.m2;
import java.util.Arrays;

public final class e {
    public static final e jJ = new e(new int[]{2}, 8);
    private static final e jK = new e(new int[]{2, 5, 6}, 8);
    /* access modifiers changed from: private */
    public static final int[] jL = {5, 6, 18, 17, 14, 7, 8};
    private final int[] jM;
    private final int jN;

    public int dC() {
        return this.jN;
    }

    public static e d(Context context) {
        return a(context, context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    static e a(Context context, Intent intent) {
        if (dD() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            return jK;
        }
        if (ai.acV < 29 || !ai.isTv(context)) {
            return (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? jJ : new e(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        }
        return new e(a.dF(), 8);
    }

    public e(int[] iArr, int i) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.jM = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.jM = new int[0];
        }
        this.jN = i;
    }

    public boolean av(int i) {
        return Arrays.binarySearch(this.jM, i) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!Arrays.equals(this.jM, eVar.jM) || this.jN != eVar.jN) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.jN + (Arrays.hashCode(this.jM) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.jN + ", supportedEncodings=" + Arrays.toString(this.jM) + m2.i.e;
    }

    private static boolean dD() {
        return ai.acV >= 17 && ("Amazon".equals(ai.acX) || "Xiaomi".equals(ai.acX));
    }

    private static final class a {
        public static int[] dF() {
            s.a gc = s.gc();
            for (int i : e.jL) {
                if (ay$$ExternalSyntheticApiModelOutline0.m(new AudioFormat.Builder().setChannelMask(12).setEncoding(i).setSampleRate(48000).build(), new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build())) {
                    gc.t(Integer.valueOf(i));
                }
            }
            gc.t(2);
            return c.f(gc.gd());
        }
    }
}
