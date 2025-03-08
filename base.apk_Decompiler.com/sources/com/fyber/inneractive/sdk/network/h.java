package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.util.IAlog;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class h {
    public InputStream a(InputStream inputStream, boolean z) {
        if (z) {
            try {
                IAlog.a("HttpExecutorBase: getInputStream found gzip encoding", new Object[0]);
                return new GZIPInputStream(inputStream);
            } catch (Exception unused) {
                return null;
            }
        } else {
            IAlog.a("HttpExecutorBase: getInputStream no gzip encoding", new Object[0]);
            return new BufferedInputStream(inputStream);
        }
    }

    public j a(InputStream inputStream, int i, String str, Map<String, List<String>> map, String str2) throws x0, b {
        try {
            j jVar = new j();
            jVar.c = inputStream;
            jVar.a = i;
            jVar.b = str;
            jVar.d = map;
            jVar.e = str2;
            if (i / 100 != 5) {
                return jVar;
            }
            throw new b(String.format("server returned error %d", new Object[]{Integer.valueOf(jVar.a)}));
        } catch (b e) {
            IAlog.a("failed executing network request", e, new Object[0]);
            throw new b((Throwable) e);
        } catch (Exception e2) {
            IAlog.a("failed reading network response", e2, new Object[0]);
            throw new x0((Throwable) e2);
        }
    }
}
