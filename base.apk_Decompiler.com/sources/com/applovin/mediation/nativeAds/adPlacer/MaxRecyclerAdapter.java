package com.applovin.mediation.nativeAds.adPlacer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.applovin.impl.mediation.nativeAds.a.c;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacer;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.Collection;

public class MaxRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements MaxAdPlacer.Listener {
    private MaxAdPlacer.Listener aYX;
    /* access modifiers changed from: private */
    public final MaxAdPlacer aZc;
    /* access modifiers changed from: private */
    public final RecyclerView.Adapter aZd;
    private final a aZe;
    private RecyclerView aZf;
    private c aZg;
    /* access modifiers changed from: private */
    public int aZh = 8;
    /* access modifiers changed from: private */
    public AdPositionBehavior aZi = AdPositionBehavior.DYNAMIC_EXCEPT_ON_APPEND;

    public enum AdPositionBehavior {
        DYNAMIC_EXCEPT_ON_APPEND,
        DYNAMIC,
        FIXED
    }

    public MaxAdPlacer getAdPlacer() {
        return this.aZc;
    }

    public void setAdPositionBehavior(AdPositionBehavior adPositionBehavior) {
        this.aZi = adPositionBehavior;
    }

    public void setListener(MaxAdPlacer.Listener listener) {
        this.aYX = listener;
    }

    public void setLookAhead(int i) {
        this.aZh = i;
    }

    public MaxRecyclerAdapter(MaxAdPlacerSettings maxAdPlacerSettings, RecyclerView.Adapter adapter, Activity activity) {
        a aVar = new a();
        this.aZe = aVar;
        MaxAdPlacer maxAdPlacer = new MaxAdPlacer(maxAdPlacerSettings, activity);
        this.aZc = maxAdPlacer;
        maxAdPlacer.setListener(this);
        MaxRecyclerAdapter.super.setHasStableIds(adapter.hasStableIds());
        this.aZd = adapter;
        adapter.registerAdapterDataObserver(aVar);
    }

    public void destroy() {
        try {
            this.aZd.unregisterAdapterDataObserver(this.aZe);
        } catch (Exception unused) {
        }
        this.aZc.destroy();
        c cVar = this.aZg;
        if (cVar != null) {
            cVar.destroy();
        }
    }

    public void loadAds() {
        this.aZc.loadAds();
    }

    public int getAdjustedPosition(int i) {
        return this.aZc.getAdjustedPosition(i);
    }

    public int getOriginalPosition(int i) {
        return this.aZc.getOriginalPosition(i);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != -42) {
            return this.aZd.onCreateViewHolder(viewGroup, i);
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.max_native_ad_recycler_view_item, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        RecyclerView.LayoutManager layoutManager = this.aZf.getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            layoutParams.width = -1;
            layoutParams.height = -2;
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        inflate.setLayoutParams(layoutParams);
        return new MaxAdRecyclerViewHolder(inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        int i3;
        this.aZg.a(viewHolder.itemView, i);
        if (this.aZc.isAdPosition(i)) {
            AppLovinSdkUtils.Size adSize = this.aZc.getAdSize(i, hc(i));
            ViewGroup containerView = ((MaxAdRecyclerViewHolder) viewHolder).getContainerView();
            ViewGroup.LayoutParams layoutParams = containerView.getLayoutParams();
            if (adSize != AppLovinSdkUtils.Size.ZERO) {
                if (adSize.getWidth() < 0) {
                    i2 = adSize.getWidth();
                } else {
                    i2 = AppLovinSdkUtils.dpToPx(containerView.getContext(), adSize.getWidth());
                }
                layoutParams.width = i2;
                if (adSize.getHeight() < 0) {
                    i3 = adSize.getHeight();
                } else {
                    i3 = AppLovinSdkUtils.dpToPx(containerView.getContext(), adSize.getHeight());
                }
                layoutParams.height = i3;
                containerView.setLayoutParams(layoutParams);
                this.aZc.renderAd(i, containerView);
                return;
            }
            layoutParams.width = -2;
            layoutParams.height = -2;
            containerView.setLayoutParams(layoutParams);
            return;
        }
        this.aZd.onBindViewHolder(viewHolder, this.aZc.getOriginalPosition(i));
    }

    public int getItemViewType(int i) {
        if (this.aZc.isAdPosition(i)) {
            return -42;
        }
        return this.aZd.getItemViewType(this.aZc.getOriginalPosition(i));
    }

    public void setHasStableIds(boolean z) {
        MaxRecyclerAdapter.super.setHasStableIds(z);
        this.aZd.unregisterAdapterDataObserver(this.aZe);
        this.aZd.setHasStableIds(z);
        this.aZd.registerAdapterDataObserver(this.aZe);
    }

    public long getItemId(int i) {
        if (!this.aZd.hasStableIds()) {
            return -1;
        }
        if (this.aZc.isFilledPosition(i)) {
            return this.aZc.getAdItemId(i);
        }
        return this.aZd.getItemId(this.aZc.getOriginalPosition(i));
    }

    public int getItemCount() {
        return this.aZc.getAdjustedCount(this.aZd.getItemCount());
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        MaxRecyclerAdapter.super.onAttachedToRecyclerView(recyclerView);
        this.aZf = recyclerView;
        c cVar = new c(recyclerView);
        this.aZg = cVar;
        cVar.a(new c.a() {
            public void S(int i, int i2) {
                MaxRecyclerAdapter.this.aZc.updateFillablePositions(i, Math.min(i2 + MaxRecyclerAdapter.this.aZh, MaxRecyclerAdapter.this.getItemCount() - 1));
            }
        });
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        MaxRecyclerAdapter.super.onDetachedFromRecyclerView(recyclerView);
        this.aZf = null;
        c cVar = this.aZg;
        if (cVar != null) {
            cVar.destroy();
            this.aZg = null;
        }
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        c cVar = this.aZg;
        if (cVar != null) {
            cVar.k(viewHolder.itemView);
        }
        if (viewHolder instanceof MaxAdRecyclerViewHolder) {
            if (this.aZc.isFilledPosition(viewHolder.getBindingAdapterPosition())) {
                ((MaxAdRecyclerViewHolder) viewHolder).getContainerView().removeAllViews();
            }
            MaxRecyclerAdapter.super.onViewRecycled(viewHolder);
            return;
        }
        this.aZd.onViewRecycled(viewHolder);
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MaxAdRecyclerViewHolder) {
            return MaxRecyclerAdapter.super.onFailedToRecycleView(viewHolder);
        }
        return this.aZd.onFailedToRecycleView(viewHolder);
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MaxAdRecyclerViewHolder) {
            MaxRecyclerAdapter.super.onViewAttachedToWindow(viewHolder);
        } else {
            this.aZd.onViewAttachedToWindow(viewHolder);
        }
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MaxAdRecyclerViewHolder) {
            MaxRecyclerAdapter.super.onViewDetachedFromWindow(viewHolder);
        } else {
            this.aZd.onViewDetachedFromWindow(viewHolder);
        }
    }

    public void onAdLoaded(int i) {
        notifyItemChanged(i);
        MaxAdPlacer.Listener listener = this.aYX;
        if (listener != null) {
            listener.onAdLoaded(i);
        }
    }

    public void onAdRemoved(int i) {
        MaxAdPlacer.Listener listener = this.aYX;
        if (listener != null) {
            listener.onAdRemoved(i);
        }
    }

    public void onAdClicked(MaxAd maxAd) {
        MaxAdPlacer.Listener listener = this.aYX;
        if (listener != null) {
            listener.onAdClicked(maxAd);
        }
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        MaxAdPlacer.Listener listener = this.aYX;
        if (listener != null) {
            listener.onAdRevenuePaid(maxAd);
        }
    }

    private int hc(int i) {
        int pxToDp = AppLovinSdkUtils.pxToDp(this.aZf.getContext(), this.aZf.getWidth());
        GridLayoutManager layoutManager = this.aZf.getLayoutManager();
        if (!(layoutManager instanceof GridLayoutManager)) {
            return layoutManager instanceof StaggeredGridLayoutManager ? pxToDp / ((StaggeredGridLayoutManager) layoutManager).getSpanCount() : pxToDp;
        }
        GridLayoutManager gridLayoutManager = layoutManager;
        return (pxToDp / gridLayoutManager.getSpanCount()) * gridLayoutManager.getSpanSizeLookup().getSpanSize(i);
    }

    private class a extends RecyclerView.AdapterDataObserver {
        private a() {
        }

        public void onChanged() {
            MaxRecyclerAdapter.this.notifyDataSetChanged();
        }

        public void onItemRangeChanged(int i, int i2) {
            int adjustedPosition = MaxRecyclerAdapter.this.aZc.getAdjustedPosition(i);
            MaxRecyclerAdapter.this.notifyItemRangeChanged(adjustedPosition, (MaxRecyclerAdapter.this.aZc.getAdjustedPosition((i + i2) - 1) - adjustedPosition) + 1);
        }

        public void onItemRangeInserted(int i, int i2) {
            boolean z = i + i2 >= MaxRecyclerAdapter.this.aZd.getItemCount();
            if (MaxRecyclerAdapter.this.aZi == AdPositionBehavior.FIXED || (MaxRecyclerAdapter.this.aZi == AdPositionBehavior.DYNAMIC_EXCEPT_ON_APPEND && z)) {
                MaxRecyclerAdapter.this.notifyDataSetChanged();
                return;
            }
            int adjustedPosition = MaxRecyclerAdapter.this.aZc.getAdjustedPosition(i);
            for (int i3 = 0; i3 < i2; i3++) {
                MaxRecyclerAdapter.this.aZc.insertItem(adjustedPosition);
            }
            MaxRecyclerAdapter.this.notifyItemRangeInserted(adjustedPosition, i2);
        }

        public void onItemRangeRemoved(int i, int i2) {
            int itemCount = MaxRecyclerAdapter.this.aZd.getItemCount();
            boolean z = i + i2 >= itemCount;
            if (MaxRecyclerAdapter.this.aZi == AdPositionBehavior.FIXED || (MaxRecyclerAdapter.this.aZi == AdPositionBehavior.DYNAMIC_EXCEPT_ON_APPEND && z)) {
                MaxRecyclerAdapter.this.notifyDataSetChanged();
                return;
            }
            int adjustedPosition = MaxRecyclerAdapter.this.aZc.getAdjustedPosition(i);
            int adjustedCount = MaxRecyclerAdapter.this.aZc.getAdjustedCount(itemCount + i2);
            for (int i3 = 0; i3 < i2; i3++) {
                MaxRecyclerAdapter.this.aZc.removeItem(adjustedPosition);
            }
            int adjustedCount2 = MaxRecyclerAdapter.this.aZc.getAdjustedCount(itemCount);
            int i4 = adjustedCount - adjustedCount2;
            Collection<Integer> clearTrailingAds = MaxRecyclerAdapter.this.aZc.clearTrailingAds(adjustedCount2 - 1);
            if (!clearTrailingAds.isEmpty()) {
                i4 += clearTrailingAds.size();
            }
            MaxRecyclerAdapter.this.notifyItemRangeRemoved(adjustedPosition - (i4 - i2), i4);
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            MaxRecyclerAdapter.this.notifyDataSetChanged();
        }
    }

    public static class MaxAdRecyclerViewHolder extends RecyclerView.ViewHolder {
        private final ViewGroup aZl;

        public ViewGroup getContainerView() {
            return this.aZl;
        }

        public MaxAdRecyclerViewHolder(View view) {
            super(view);
            this.aZl = (ViewGroup) view.findViewById(R.id.applovin_native_ad_view_container);
        }
    }
}
