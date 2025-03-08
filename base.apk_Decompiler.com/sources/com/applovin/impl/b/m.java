package com.applovin.impl.b;

import android.net.Uri;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.h;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class m {
    private static final DateFormat aXW = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
    private static final Random aXX = new Random(System.currentTimeMillis());

    public static void a(e eVar, AppLovinAdLoadListener appLovinAdLoadListener, f fVar, int i, n nVar) {
        if (nVar != null) {
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(i);
            }
            a(a(eVar, nVar), fVar, nVar);
            return;
        }
        throw new IllegalArgumentException("Unable to handle failure. No sdk specified.");
    }

    public static f a(a aVar) {
        if (b(aVar) || c(aVar)) {
            return null;
        }
        return f.GENERAL_WRAPPER_ERROR;
    }

    public static boolean b(a aVar) {
        n LU;
        List<o> MG;
        if (aVar == null || (LU = aVar.LU()) == null || (MG = LU.MG()) == null || MG.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean c(a aVar) {
        d LX;
        i Mo;
        if (aVar == null || (LX = aVar.LX()) == null || (Mo = LX.Mo()) == null) {
            return false;
        }
        if (Mo.MB() != null || StringUtils.isValidString(Mo.MC())) {
            return true;
        }
        return false;
    }

    public static Uri a(String str, long j, Uri uri, f fVar, n nVar) {
        if (URLUtil.isValidUrl(str)) {
            try {
                String num = Integer.toString(fVar.getErrorCode());
                String replace = str.replace("[ERRORCODE]", num).replace("[REASON]", num);
                if (j >= 0) {
                    replace = replace.replace("[CONTENTPLAYHEAD]", cd(j));
                }
                if (uri != null) {
                    replace = replace.replace("[ASSETURI]", uri.toString());
                }
                return Uri.parse(replace.replace("[CACHEBUSTING]", ME()).replace("[TIMESTAMP]", MF()));
            } catch (Throwable th) {
                nVar.BN();
                if (x.Fn()) {
                    x BN = nVar.BN();
                    BN.c("VastUtils", "Unable to replace macros in URL string " + str, th);
                }
                nVar.Cs().g("VastUtils", th);
                return null;
            }
        } else {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().i("VastUtils", "Unable to replace macros in invalid URL string.");
            }
            return null;
        }
    }

    private static String cd(long j) {
        if (j <= 0) {
            return "00:00:00.000";
        }
        long hours = TimeUnit.SECONDS.toHours(j);
        long seconds = j % TimeUnit.MINUTES.toSeconds(1);
        return String.format(Locale.US, "%02d:%02d:%02d.000", new Object[]{Long.valueOf(hours), Long.valueOf(TimeUnit.SECONDS.toMinutes(j) % TimeUnit.MINUTES.toSeconds(1)), Long.valueOf(seconds)});
    }

    private static String ME() {
        return Integer.toString(aXX.nextInt(89999999) + 10000000);
    }

    private static String MF() {
        DateFormat dateFormat = aXW;
        dateFormat.setTimeZone(TimeZone.getDefault());
        return dateFormat.format(new Date());
    }

    public static void a(Set<k> set, n nVar) {
        a(set, -1, (Uri) null, f.UNSPECIFIED, nVar);
    }

    public static void a(Set<k> set, f fVar, n nVar) {
        a(set, -1, (Uri) null, fVar, nVar);
    }

    public static void a(Set<k> set, long j, Uri uri, f fVar, n nVar) {
        if (nVar == null) {
            throw new IllegalArgumentException("Unable to fire trackers. No sdk specified.");
        } else if (set != null && !set.isEmpty()) {
            for (k MD : set) {
                Uri a = a(MD.MD(), j, uri, fVar, nVar);
                if (a != null) {
                    nVar.Cu().a(h.ID().dd(a.toString()).aV(false).IF(), false);
                }
            }
        }
    }

    public static void a(y yVar, Map<String, Set<k>> map, e eVar, n nVar) {
        List<y> dJ;
        if (nVar == null) {
            throw new IllegalArgumentException("Unable to render event trackers. No sdk specified.");
        } else if (yVar == null) {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().i("VastUtils", "Unable to render event trackers; null node provided");
            }
        } else if (map == null) {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().i("VastUtils", "Unable to render event trackers; null event trackers provided");
            }
        } else {
            y dK = yVar.dK("TrackingEvents");
            if (dK != null && (dJ = dK.dJ("Tracking")) != null) {
                for (y next : dJ) {
                    String str = next.LJ().get(NotificationCompat.CATEGORY_EVENT);
                    if (StringUtils.isValidString(str)) {
                        k b = k.b(next, eVar, nVar);
                        if (b != null) {
                            Set set = map.get(str);
                            if (set != null) {
                                set.add(b);
                            } else {
                                HashSet hashSet = new HashSet();
                                hashSet.add(b);
                                map.put(str, hashSet);
                            }
                        }
                    } else {
                        nVar.BN();
                        if (x.Fn()) {
                            x BN = nVar.BN();
                            BN.i("VastUtils", "Could not find event for tracking node = " + next);
                        }
                    }
                }
            }
        }
    }

    public static void a(List<y> list, Set<k> set, e eVar, n nVar) {
        if (nVar == null) {
            throw new IllegalArgumentException("Unable to render trackers. No sdk specified.");
        } else if (list == null) {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().i("VastUtils", "Unable to render trackers; null nodes provided");
            }
        } else if (set == null) {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().i("VastUtils", "Unable to render trackers; null trackers provided");
            }
        } else {
            for (y b : list) {
                k b2 = k.b(b, eVar, nVar);
                if (b2 != null) {
                    set.add(b2);
                }
            }
        }
    }

    public static boolean d(y yVar) {
        if (yVar != null) {
            return yVar.dL("Wrapper") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains a wrapper response");
    }

    public static boolean e(y yVar) {
        if (yVar != null) {
            return yVar.dL("InLine") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains an inline response");
    }

    public static String a(e eVar) {
        y dL;
        if (eVar != null) {
            List<y> Ms = eVar.Ms();
            int size = eVar.Ms().size();
            if (size <= 0 || (dL = Ms.get(size - 1).dL("VASTAdTagURI")) == null) {
                return null;
            }
            return dL.LK();
        }
        throw new IllegalArgumentException("Unable to get resolution uri string for fetching the next wrapper or inline response in the chain");
    }

    public static String a(y yVar, String str, String str2) {
        y dK = yVar.dK(str);
        if (dK != null) {
            String LK = dK.LK();
            if (StringUtils.isValidString(LK)) {
                return LK;
            }
        }
        return str2;
    }

    private static Set<k> a(e eVar, n nVar) {
        if (eVar == null) {
            return null;
        }
        List<y> Ms = eVar.Ms();
        Set<k> hashSet = new HashSet<>(Ms.size());
        for (y next : Ms) {
            y dL = next.dL("Wrapper");
            if (dL == null) {
                dL = next.dL("InLine");
            }
            if (dL != null) {
                hashSet = a(hashSet, dL.dJ("Error"), eVar, nVar);
            } else {
                hashSet = a(hashSet, next.dJ("Error"), eVar, nVar);
            }
        }
        nVar.BN();
        if (x.Fn()) {
            x BN = nVar.BN();
            BN.f("VastUtils", "Retrieved " + hashSet.size() + " top level error trackers: " + hashSet);
        }
        return hashSet;
    }

    private static Set<k> a(Set<k> set, List<y> list, e eVar, n nVar) {
        if (list != null) {
            for (y b : list) {
                k b2 = k.b(b, eVar, nVar);
                if (b2 != null) {
                    set.add(b2);
                }
            }
        }
        return set;
    }
}
