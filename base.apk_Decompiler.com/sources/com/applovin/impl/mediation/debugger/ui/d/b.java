package com.applovin.impl.mediation.debugger.ui.d;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class b {
    public TextView asq;
    public TextView asr;
    public ImageView ass;
    private c ast;
    public ImageView imageView;
    private int oX;

    public void fx(int i) {
        this.oX = i;
    }

    public int il() {
        return this.oX;
    }

    public c wR() {
        return this.ast;
    }

    public void a(c cVar) {
        this.ast = cVar;
        this.asq.setText(cVar.wU());
        this.asq.setTextColor(cVar.getTextColor());
        if (this.asr != null) {
            if (!TextUtils.isEmpty(cVar.wG())) {
                this.asr.setTypeface((Typeface) null, 0);
                this.asr.setVisibility(0);
                this.asr.setText(cVar.wG());
                this.asr.setTextColor(cVar.vP());
                if (cVar.wH()) {
                    this.asr.setTypeface((Typeface) null, 1);
                }
            } else {
                this.asr.setVisibility(8);
            }
        }
        if (this.imageView != null) {
            if (cVar.wB() > 0) {
                this.imageView.setImageResource(cVar.wB());
                this.imageView.setColorFilter(cVar.wV());
                this.imageView.setVisibility(0);
            } else {
                this.imageView.setVisibility(8);
            }
        }
        if (this.ass == null) {
            return;
        }
        if (cVar.tO() > 0) {
            this.ass.setImageResource(cVar.tO());
            this.ass.setColorFilter(cVar.tP());
            this.ass.setVisibility(0);
            return;
        }
        this.ass.setVisibility(8);
    }
}
