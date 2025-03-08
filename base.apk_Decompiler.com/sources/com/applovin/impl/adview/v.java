package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

public class v extends View {
    private final p ain;
    private boolean aio;

    interface a {
        void onFailure();

        void rj();
    }

    public boolean sh() {
        return this.aio;
    }

    public v(p pVar, Context context) {
        super(context);
        this.ain = pVar;
        setClickable(false);
        setFocusable(false);
    }

    public void sg() {
        a((a) null);
    }

    public void a(a aVar) {
        if (!this.aio) {
            Drawable rM = this.ain.rM();
            if (rM != null) {
                setBackground(rM);
                this.aio = true;
                if (aVar != null) {
                    aVar.rj();
                }
            } else if (aVar != null) {
                aVar.onFailure();
            }
        } else if (aVar != null) {
            aVar.rj();
        }
    }

    public String getIdentifier() {
        return this.ain.getIdentifier();
    }
}
