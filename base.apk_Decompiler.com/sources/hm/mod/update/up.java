package hm.mod.update;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;

public class up {
    public static void process(Context context) {
        HandlerThread handlerThread = new HandlerThread("check");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).postDelayed(new up1(context), 1000);
    }
}
