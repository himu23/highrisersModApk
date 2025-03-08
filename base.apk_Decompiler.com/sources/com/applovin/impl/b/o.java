package com.applovin.impl.b;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import java.util.Locale;
import java.util.Map;

public class o {
    private Uri aYj;
    private Uri aYk;
    private a aYl;
    private String aYm;
    private long aYn;
    private int dE;
    private int height;

    public enum a {
        Progressive,
        Streaming
    }

    public Uri FI() {
        return this.aYk;
    }

    public Uri MI() {
        return this.aYj;
    }

    public String MJ() {
        return this.aYm;
    }

    public long MK() {
        return this.aYn;
    }

    public void j(Uri uri) {
        this.aYk = uri;
    }

    private o() {
    }

    public static o d(y yVar, n nVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (nVar != null) {
            try {
                String LK = yVar.LK();
                if (URLUtil.isValidUrl(LK)) {
                    Uri parse = Uri.parse(LK);
                    o oVar = new o();
                    oVar.aYj = parse;
                    oVar.aYk = parse;
                    oVar.aYn = f(yVar);
                    oVar.aYl = dS(yVar.LJ().get("delivery"));
                    oVar.height = StringUtils.parseInt(yVar.LJ().get("height"));
                    oVar.dE = StringUtils.parseInt(yVar.LJ().get("width"));
                    oVar.aYm = yVar.LJ().get("type").toLowerCase(Locale.ENGLISH);
                    return oVar;
                }
                nVar.BN();
                if (!x.Fn()) {
                    return null;
                }
                nVar.BN().i("VastVideoFile", "Unable to create video file. Could not find URL.");
                return null;
            } catch (Throwable th) {
                nVar.BN();
                if (x.Fn()) {
                    nVar.BN().c("VastVideoFile", "Error occurred while initializing", th);
                }
                nVar.Cs().g("VastVideoFile", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    private static a dS(String str) {
        if (StringUtils.isValidString(str)) {
            if ("progressive".equalsIgnoreCase(str)) {
                return a.Progressive;
            }
            if ("streaming".equalsIgnoreCase(str)) {
                return a.Streaming;
            }
        }
        return a.Progressive;
    }

    private static long f(y yVar) {
        Map<String, String> LJ = yVar.LJ();
        long parseLong = StringUtils.parseLong(LJ.get("bitrate"), 0);
        if (parseLong != 0) {
            return parseLong;
        }
        return (StringUtils.parseLong(LJ.get("minBitrate"), 0) + StringUtils.parseLong(LJ.get("maxBitrate"), 0)) / 2;
    }

    public String toString() {
        return "VastVideoFile{sourceVideoUri=" + this.aYj + ", videoUri=" + this.aYk + ", deliveryType=" + this.aYl + ", fileType='" + this.aYm + "', width=" + this.dE + ", height=" + this.height + ", bitrate=" + this.aYn + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.dE != oVar.dE || this.height != oVar.height || this.aYn != oVar.aYn) {
            return false;
        }
        Uri uri = this.aYj;
        if (uri == null ? oVar.aYj != null : !uri.equals(oVar.aYj)) {
            return false;
        }
        Uri uri2 = this.aYk;
        if (uri2 == null ? oVar.aYk != null : !uri2.equals(oVar.aYk)) {
            return false;
        }
        if (this.aYl != oVar.aYl) {
            return false;
        }
        String str = this.aYm;
        String str2 = oVar.aYm;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Uri uri = this.aYj;
        int i = 0;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.aYk;
        int hashCode2 = (hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        a aVar = this.aYl;
        int hashCode3 = (hashCode2 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str = this.aYm;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((((hashCode3 + i) * 31) + this.dE) * 31) + this.height) * 31) + Long.valueOf(this.aYn).hashCode();
    }
}
