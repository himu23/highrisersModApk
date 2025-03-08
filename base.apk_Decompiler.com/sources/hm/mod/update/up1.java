package hm.mod.update;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.util.Log;
import com.applovin.sdk.AppLovinEventTypes;
import com.ironsource.i9;
import com.ironsource.m2;
import com.unity3d.ads.core.domain.HandleAndroidInvocationsUseCase;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class up1 implements Runnable {
    /* access modifiers changed from: private */
    public final Context context;

    public up1(Context context2) {
        this.context = context2;
    }

    public void run() {
        JSONObject jSONObject;
        JSONArray jSONArray;
        try {
            final String packageName = this.context.getPackageName();
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(packageName, 0);
            String str = packageInfo.versionName;
            int i = packageInfo.versionCode;
            String lang = up5.getLang();
            String country = up5.getCountry();
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://pop-up.apkomega.com/202307/api/popup.php?packageName=" + packageName + "&versionName=" + str + "&versionCode=" + i + "&lang=" + lang + "&country=" + country).openConnection();
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setRequestMethod(i9.a);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            Log.e("zjx", "data: " + sb.toString());
            JSONObject jSONObject2 = new JSONObject(sb.toString());
            if (jSONObject2.optBoolean("hasNewVersion", false)) {
                final String optString = jSONObject2.optString(m2.h.D0);
                String optString2 = jSONObject2.optString(m2.h.H0);
                String optString3 = jSONObject2.optString("author");
                String optString4 = jSONObject2.optString(AppLovinEventTypes.USER_VIEWED_CONTENT);
                final boolean optBoolean = jSONObject2.optBoolean("canClose", true);
                String optString5 = jSONObject2.optString("url", "https://spdn.poumod.com/HappyMod-2-9-7.apk");
                final String str2 = optString2;
                final String str3 = optString3;
                final String str4 = optString4;
                final String str5 = optString5;
                ((Activity) this.context).runOnUiThread(new Runnable() {
                    public void run() {
                        up2.show(up1.this.context, Uri.encode(optString), Uri.encode(str2), Uri.encode(str3), packageName, str4, str5, optBoolean);
                    }
                });
            } else if (jSONObject2.has("ad_info") && (jSONObject = jSONObject2.getJSONObject("ad_info")) != null && jSONObject.has("ad_list")) {
                long optLong = jSONObject.optLong("interval", 3600);
                int showTimes = up5.getShowTimes(this.context);
                long lastShow = up5.getLastShow(this.context);
                if ((showTimes < 2 || (System.currentTimeMillis() / 1000) - lastShow > optLong) && (jSONArray = jSONObject.getJSONArray("ad_list")) != null && jSONArray.length() != 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                        if (!isAppInstalled(jSONObject3.optString(HandleAndroidInvocationsUseCase.KEY_PACKAGE_NAME))) {
                            final String optString6 = jSONObject3.optString(m2.h.D0);
                            final String optString7 = jSONObject3.optString(m2.h.H0);
                            String optString8 = jSONObject3.optString("banner");
                            final String optString9 = jSONObject3.optString("desc");
                            final String optString10 = jSONObject3.optString("url");
                            final String optString11 = jSONObject3.optString(m2.h.h, "INSTALL");
                            final String str6 = optString8;
                            ((Activity) this.context).runOnUiThread(new Runnable() {
                                public void run() {
                                    up2.showAd(up1.this.context, optString6, optString7, str6, optString9, optString10, optString11);
                                    up5.setLastShow(up1.this.context);
                                    up5.setShowTimes(up1.this.context);
                                }
                            });
                            return;
                        }
                    }
                }
            }
        } catch (Exception e) {
            Log.e("zjx", "update: " + e.getLocalizedMessage());
        }
    }

    private boolean isAppInstalled(String str) {
        try {
            if (this.context.getPackageManager().getPackageInfo(str, 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }
}
