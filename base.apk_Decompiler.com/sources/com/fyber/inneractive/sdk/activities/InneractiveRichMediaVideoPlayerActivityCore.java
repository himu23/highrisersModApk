package com.fyber.inneractive.sdk.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.VideoView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.android.gms.drive.DriveFile;

public class InneractiveRichMediaVideoPlayerActivityCore extends Activity {
    public static final String VIDEO_CURRENT_POSITION = "video_current_position";
    public static final String VIDEO_URL = "video_url";
    public VideoView a;
    public int b = 0;
    public final MediaPlayer.OnPreparedListener c = new a();

    public class a implements MediaPlayer.OnPreparedListener {
        public a() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            IAlog.a("onPrepared", new Object[0]);
            InneractiveRichMediaVideoPlayerActivityCore inneractiveRichMediaVideoPlayerActivityCore = InneractiveRichMediaVideoPlayerActivityCore.this;
            inneractiveRichMediaVideoPlayerActivityCore.a.seekTo(inneractiveRichMediaVideoPlayerActivityCore.b);
            InneractiveRichMediaVideoPlayerActivityCore.this.a.start();
        }
    }

    public static boolean startRichMediaIntent(Context context, String str) {
        Intent intent = new Intent(context, InneractiveRichMediaVideoPlayerActivityCore.class);
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        intent.putExtra(VIDEO_URL, str);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            IAlog.a("Activity InneractiveRichMediaVideoPlayerActivityCore was not found. Did you declare it in your AndroidManifest.xml?", new Object[0]);
            return false;
        }
    }

    public void initWindowFeatures() {
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        getWindow().addFlags(128);
    }

    public void onCreate(Bundle bundle) {
        initWindowFeatures();
        super.onCreate(bundle);
        if (bundle != null) {
            this.b = bundle.getInt(VIDEO_CURRENT_POSITION, 0);
        }
        setContentView(R.layout.ia_rich_media_video);
        this.a = (VideoView) findViewById(R.id.mraid_video_view);
        Intent intent = getIntent();
        String stringExtra = (intent == null || !intent.hasExtra(VIDEO_URL)) ? null : intent.getStringExtra(VIDEO_URL);
        if (TextUtils.isEmpty(stringExtra)) {
            IAlog.a("Error: video can not be played.", new Object[0]);
            finish();
        } else {
            this.a.setVideoPath(stringExtra);
            this.a.setOnCompletionListener(new l(this));
            this.a.setOnErrorListener(new m(this));
            this.a.setOnPreparedListener(this.c);
        }
        findViewById(R.id.ia_iv_close_button).setOnClickListener(new k(this));
    }

    public void onPause() {
        super.onPause();
        this.b = this.a.getCurrentPosition();
        this.a.pause();
    }

    public void onSaveInstanceState(Bundle bundle) {
        int i;
        super.onSaveInstanceState(bundle);
        VideoView videoView = this.a;
        if (videoView == null) {
            i = 0;
        } else {
            i = videoView.getCurrentPosition();
        }
        bundle.putInt(VIDEO_CURRENT_POSITION, i);
    }
}
