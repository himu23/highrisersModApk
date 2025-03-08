package kele;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import hm.mod.update.up;

public class RemoveAD_by_xll extends Activity {
    public String GameActivity = "com.kumobius.android.KumoAppActivity";
    public String ToastContent = "Mod By:小明同学";

    public void onCreate(Bundle savedInstanceState) {
        up.process(this);
        super.onCreate(savedInstanceState);
        setAppHttpAndHttpsproxy(this);
        gotoGameActivity();
    }

    public void setAppHttpAndHttpsproxy(Context context) {
        System.setProperty("http.proxyHost", "0.0.0.0");
        System.setProperty("http.proxyPort", String.valueOf(88888));
        System.setProperty("https.proxyHost", "0.0.0.0");
        System.setProperty("https.proxyPort", String.valueOf(88888));
        System.setProperty("java.net.useSystemProxies", "true");
        if (!this.ToastContent.isEmpty()) {
            Toast.makeText(context, this.ToastContent, 1).show();
        }
    }

    public void gotoGameActivity() {
        try {
            startActivity(new Intent(this, Class.forName(this.GameActivity)));
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("xll", "报错了:" + e.getMessage());
            Toast.makeText(this, "报错了:" + e.getMessage(), 0).show();
        }
    }
}
