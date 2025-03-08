package com.kumobius.android;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.ironsource.m2;

public class VideoPlayer extends Activity implements SurfaceHolder.Callback, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener {
    private static final String s_TAG = "KumoVideo";
    private boolean m_Active = false;
    private MediaPlayer m_MediaPlayer;
    private boolean m_Prepared = false;
    private boolean m_Started = false;
    private SurfaceView m_SurfaceView;

    private boolean canPlay() {
        return this.m_Active && this.m_Prepared;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Log.v(s_TAG, "onCreate");
        super.onCreate(bundle);
        try {
            Utils.setImmersiveMode(this);
            Utils.setRequestedOrientation(this);
            SurfaceView surfaceView = new SurfaceView(this);
            this.m_SurfaceView = surfaceView;
            surfaceView.getHolder().addCallback(this);
            this.m_SurfaceView.setBackgroundColor(0);
            setContentView(this.m_SurfaceView);
            MediaPlayer createMediaPlayer = Utils.createMediaPlayer();
            this.m_MediaPlayer = createMediaPlayer;
            createMediaPlayer.setOnCompletionListener(this);
            this.m_MediaPlayer.setOnPreparedListener(this);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                playFullPath(extras.getString("fullPath"));
            }
            this.m_MediaPlayer.prepareAsync();
        } catch (Exception e) {
            Log.w(s_TAG, "Failed to play video.", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        Log.v(s_TAG, m2.h.t0);
        super.onPause();
        this.m_Active = false;
        applyState();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Log.v(s_TAG, m2.h.u0);
        super.onResume();
        this.m_Active = true;
        applyState();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Log.v(s_TAG, "onDestroy");
        this.m_SurfaceView.getHolder().removeCallback(this);
        this.m_MediaPlayer.reset();
        this.m_MediaPlayer.release();
        super.onDestroy();
    }

    private void playFullPath(String str) {
        try {
            Log.v(s_TAG, "Loading video " + str);
            String assetPath = Utils.getAssetPath(this, str);
            if (assetPath != null) {
                AssetFileDescriptor openFd = getAssets().openFd(assetPath);
                this.m_MediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            }
        } catch (Exception e) {
            Log.w(s_TAG, "Failed to load video " + str, e);
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.m_Prepared = true;
        applyState();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        finish();
    }

    private void applyState() {
        if (this.m_Started) {
            if (canPlay()) {
                this.m_MediaPlayer.start();
            } else {
                this.m_MediaPlayer.pause();
            }
        } else if (canPlay()) {
            this.m_MediaPlayer.start();
            this.m_Started = true;
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.m_MediaPlayer.setDisplay(this.m_SurfaceView.getHolder());
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.m_MediaPlayer.setDisplay((SurfaceHolder) null);
    }
}
