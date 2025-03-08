package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.flow.t;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InneractiveAdSpotManager {
    public Map<String, InneractiveAdSpot> a = new ConcurrentHashMap();

    public static class a {
        public static InneractiveAdSpotManager a = new InneractiveAdSpotManager();
    }

    public static void destroy() {
        Map<String, InneractiveAdSpot> map = get().a;
        for (String str : map.keySet()) {
            InneractiveAdSpot inneractiveAdSpot = map.get(str);
            if (inneractiveAdSpot != null) {
                inneractiveAdSpot.destroy();
            }
        }
        map.clear();
    }

    public static InneractiveAdSpotManager get() {
        return a.a;
    }

    public void bindSpot(InneractiveAdSpot inneractiveAdSpot) {
        this.a.put(inneractiveAdSpot.getLocalUniqueId(), inneractiveAdSpot);
    }

    public InneractiveAdSpot createSpot() {
        t tVar = new t();
        this.a.put(tVar.a, tVar);
        return tVar;
    }

    public InneractiveAdSpot getSpot(String str) {
        return this.a.get(str);
    }

    public void removeSpot(InneractiveAdSpot inneractiveAdSpot) {
        Map<String, InneractiveAdSpot> map = this.a;
        if (map != null) {
            map.remove(inneractiveAdSpot.getLocalUniqueId());
        }
    }
}
