package androidx.webkit.internal;

import android.content.pm.PackageInfo;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.exoplayer2.ay$$ExternalSyntheticApiModelOutline0;

public class ApiHelperForO {
    private ApiHelperForO() {
    }

    public static void setSafeBrowsingEnabled(WebSettings webSettings, boolean z) {
        webSettings.setSafeBrowsingEnabled(z);
    }

    public static boolean getSafeBrowsingEnabled(WebSettings webSettings) {
        return ay$$ExternalSyntheticApiModelOutline0.m(webSettings);
    }

    public static WebViewClient getWebViewClient(WebView webView) {
        return ay$$ExternalSyntheticApiModelOutline0.m(webView);
    }

    public static WebChromeClient getWebChromeClient(WebView webView) {
        return ay$$ExternalSyntheticApiModelOutline0.m(webView);
    }

    public static PackageInfo getCurrentWebViewPackage() {
        return ay$$ExternalSyntheticApiModelOutline0.m();
    }
}
