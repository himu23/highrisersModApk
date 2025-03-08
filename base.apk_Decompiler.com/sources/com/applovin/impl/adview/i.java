package com.applovin.impl.adview;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.applovin.impl.sdk.x;
import java.util.concurrent.atomic.AtomicReference;

public class i extends WebView {
    private static Boolean ahy;
    private final AtomicReference<MotionEvent> ahz = new AtomicReference<>();

    public i(Context context) {
        super(context);
        if (ahy == null) {
            try {
                WebView.class.getDeclaredMethod("onTouchEvent", new Class[]{MotionEvent.class});
                ahy = true;
            } catch (NoSuchMethodException unused) {
                x.H("AppLovinSdk", "WebView.onTouchEvent() not implemented");
                ahy = false;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.ahz.set(MotionEvent.obtain(motionEvent));
        if (ahy.booleanValue()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean rz() {
        return this.ahz.get() != null;
    }

    public MotionEvent getLastClickEvent() {
        return this.ahz.get();
    }

    public MotionEvent getAndClearLastClickEvent() {
        return this.ahz.getAndSet((Object) null);
    }
}
