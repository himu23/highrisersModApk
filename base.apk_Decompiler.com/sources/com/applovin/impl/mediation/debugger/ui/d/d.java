package com.applovin.impl.mediation.debugger.ui.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.applovin.impl.sdk.utils.g;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class d extends BaseAdapter implements View.OnClickListener {
    /* access modifiers changed from: protected */
    public Context E;
    private List<c> asJ = new ArrayList();
    private Map<Integer, Integer> asK = new HashMap();
    private a asL;

    public interface a {
        void onClick(a aVar, c cVar);
    }

    public void a(a aVar) {
        this.asL = aVar;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    /* access modifiers changed from: protected */
    public abstract int gg(int i);

    /* access modifiers changed from: protected */
    public abstract c gh(int i);

    /* access modifiers changed from: protected */
    public abstract List<c> gi(int i);

    /* access modifiers changed from: protected */
    public abstract int tM();

    /* access modifiers changed from: protected */
    public c xa() {
        return null;
    }

    protected d(Context context) {
        this.E = context.getApplicationContext();
    }

    public void wZ() {
        AppLovinSdkUtils.runOnUiThread(new d$$ExternalSyntheticLambda0(this));
    }

    public boolean isEnabled(int i) {
        return getItem(i).isEnabled();
    }

    public int getViewTypeCount() {
        return c.getViewTypeCount();
    }

    public int getItemViewType(int i) {
        return getItem(i).wS();
    }

    public int getCount() {
        return this.asJ.size();
    }

    /* renamed from: go */
    public c getItem(int i) {
        return this.asJ.get(i);
    }

    public void notifyDataSetChanged() {
        int i;
        this.asJ = new ArrayList();
        int tM = tM();
        this.asK = new HashMap(tM);
        c xa = xa();
        if (xa != null) {
            this.asJ.add(xa);
            i = 1;
        } else {
            i = 0;
        }
        for (int i2 = 0; i2 < tM; i2++) {
            int gg = gg(i2);
            if (gg != 0) {
                this.asJ.add(gh(i2));
                this.asJ.addAll(gi(i2));
                this.asK.put(Integer.valueOf(i2), Integer.valueOf(i));
                i += gg + 1;
            }
        }
        this.asJ.add(new e(""));
        super.notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        c go = getItem(i);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(go.wT(), viewGroup, false);
            bVar = new b();
            bVar.asq = (TextView) view.findViewById(16908308);
            bVar.asr = (TextView) view.findViewById(16908309);
            bVar.imageView = (ImageView) view.findViewById(R.id.imageView);
            bVar.ass = (ImageView) view.findViewById(R.id.detailImageView);
            view.setTag(bVar);
            view.setOnClickListener(this);
            view.setBackground(q(view));
        } else {
            bVar = (b) view.getTag();
        }
        bVar.fx(i);
        bVar.a(go);
        view.setEnabled(go.isEnabled());
        return view;
    }

    public void onClick(View view) {
        b bVar = (b) view.getTag();
        c wR = bVar.wR();
        a gp = gp(bVar.il());
        a aVar = this.asL;
        if (aVar != null && gp != null) {
            aVar.onClick(gp, wR);
        }
    }

    private a gp(int i) {
        for (int i2 = 0; i2 < tM(); i2++) {
            Integer num = this.asK.get(Integer.valueOf(i2));
            if (num != null) {
                if (i <= num.intValue() + gg(i2)) {
                    return new a(i2, i - (num.intValue() + 1));
                }
            }
        }
        return null;
    }

    private Drawable q(View view) {
        Drawable background = view.getBackground();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(g.a(R.color.applovin_sdk_highlightListItemColor, this.E));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable);
        stateListDrawable.addState(new int[0], background);
        return stateListDrawable;
    }
}
