package com.applovin.impl.sdk.network;

import android.text.TextUtils;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.t;
import com.applovin.impl.sdk.x;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class g extends d {
    private final f aIl;
    private AtomicBoolean aIm = new AtomicBoolean();
    private boolean aIn = false;
    private final x logger;

    g(f fVar, n nVar) {
        super("PersistentPostbackQueueSaveTask", nVar);
        this.aIl = fVar;
        this.logger = nVar.BN();
    }

    public void run() {
        J(this.aIl.Ir());
    }

    public List<h> gJ(int i) {
        ArrayList arrayList = new ArrayList();
        t Cc = this.sdk.Cc();
        if (!Cc.c("persistent_postback_cache.json", n.getApplicationContext())) {
            x.H("PersistentPostbackQueueSaveTask", "Postbacks queue file does not exist.");
            return arrayList;
        }
        String a = Cc.a(Cc.a("persistent_postback_cache.json", n.getApplicationContext()));
        if (TextUtils.isEmpty(a)) {
            x.H("PersistentPostbackQueueSaveTask", "Postbacks queue file has no content.");
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONObject(a).getJSONArray("pb");
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("PersistentPostbackQueueSaveTask", "Deserializing " + jSONArray.length() + " postback(s)...");
            }
            arrayList.ensureCapacity(Math.max(1, jSONArray.length()));
            Integer num = (Integer) this.sdk.a(b.aNE);
            for (int i2 = 0; i2 < jSONArray.length() && arrayList.size() < i; i2++) {
                h hVar = new h(jSONArray.getJSONObject(i2), this.sdk);
                if (hVar.Iz() < num.intValue()) {
                    arrayList.add(hVar);
                } else {
                    x.H("PersistentPostbackQueueSaveTask", "Skipping deserialization because maximum attempt count exceeded for postback: " + hVar);
                }
            }
            if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.f("PersistentPostbackQueueSaveTask", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
            }
        } catch (Throwable th) {
            x.e("PersistentPostbackQueueSaveTask", "Failed to load postback queue", th);
            this.sdk.Cs().d("PersistentPostbackQueueSaveTask", "deserializePostbackQueue", th);
        }
        this.aIn = arrayList.isEmpty();
        return arrayList;
    }

    private void J(List<h> list) {
        if ((!this.aIn || !list.isEmpty()) && this.aIm.compareAndSet(false, true)) {
            JSONArray jSONArray = new JSONArray();
            for (h next : list) {
                try {
                    jSONArray.put(next.IC());
                } catch (Throwable th) {
                    x.e("PersistentPostbackQueueSaveTask", "Unable to serialize postback to JSON: " + next, th);
                    this.sdk.Cs().d("PersistentPostbackQueueSaveTask", "serializePostback", th);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pb", jSONArray);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(jSONObject.toString().getBytes("UTF-8"));
                t Cc = this.sdk.Cc();
                Cc.a((InputStream) byteArrayInputStream, Cc.a("persistent_postback_cache.json", n.getApplicationContext()), true);
                if (x.Fn()) {
                    this.logger.f("PersistentPostbackQueueSaveTask", "Exported postback queue to disk.");
                }
            } catch (Throwable th2) {
                x.e("PersistentPostbackQueueSaveTask", "Unable to export postbacks to disk: " + jSONArray, th2);
                this.sdk.Cs().d("PersistentPostbackQueueSaveTask", "serializePostbackQueue", th2);
            }
            this.aIm.set(false);
        }
    }
}
