package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class h {
    public static final int c = -1;
    public static final int d = 0;
    private ConcurrentHashMap<String, ArrayList<a>> a = new ConcurrentHashMap<>();
    private int b;

    public enum a {
        ISAuctionPerformanceDidntAttemptToLoad,
        ISAuctionPerformanceFailedToLoad,
        ISAuctionPerformanceLoadedSuccessfully,
        ISAuctionPerformanceFailedToShow,
        ISAuctionPerformanceShowedSuccessfully,
        ISAuctionPerformanceNotPartOfWaterfall
    }

    public h(List<NetworkSettings> list, int i) {
        this.b = i;
        for (NetworkSettings providerName : list) {
            this.a.put(providerName.getProviderName(), new ArrayList());
        }
    }

    public String a(String str) {
        ArrayList arrayList = this.a.get(str);
        String str2 = "";
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            StringBuilder sb = new StringBuilder(str2);
            while (true) {
                sb.append(((a) it.next()).ordinal());
                str2 = sb.toString();
                if (!it.hasNext()) {
                    break;
                }
                sb = new StringBuilder();
                sb.append(str2 + ",");
            }
        }
        return str2;
    }

    public void a(ConcurrentHashMap<String, a> concurrentHashMap) {
        if (this.b != 0) {
            for (String next : this.a.keySet()) {
                a aVar = a.ISAuctionPerformanceNotPartOfWaterfall;
                if (concurrentHashMap.containsKey(next)) {
                    aVar = concurrentHashMap.get(next);
                }
                ArrayList arrayList = this.a.get(next);
                if (this.b != -1 && arrayList.size() == this.b) {
                    arrayList.remove(0);
                }
                arrayList.add(aVar);
            }
        }
    }
}
