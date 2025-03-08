package com.fyber.inneractive.sdk.activities;

import android.media.MediaPlayer;

public class l implements MediaPlayer.OnCompletionListener {
    public final /* synthetic */ InneractiveRichMediaVideoPlayerActivityCore a;

    public l(InneractiveRichMediaVideoPlayerActivityCore inneractiveRichMediaVideoPlayerActivityCore) {
        this.a = inneractiveRichMediaVideoPlayerActivityCore;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.a.finish();
    }
}
