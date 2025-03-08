package com.kumobius.android;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;

public class NotificationService extends IntentService {
    private static final String EXTRA_CONTENT_TEXT = "TEXT";
    private static final String s_ChannelId = "kumoChannel";
    private static final String s_TAG = "KumoNotification";

    public NotificationService() {
        super("Deferred Notifications");
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
                if (notificationManager != null) {
                    String string = getResources().getString(R.string.notificationCategory);
                    Utils$$ExternalSyntheticApiModelOutline0.m();
                    NotificationChannel m = Utils$$ExternalSyntheticApiModelOutline0.m(s_ChannelId, string, 2);
                    m.setDescription(string);
                    notificationManager.createNotificationChannel(m);
                }
            } catch (Exception e) {
                Log.e(s_TAG, "Failed to create notification channel.", e);
            }
        }
    }

    public static void cancelAll(Context context) {
        Log.v(s_TAG, "Cancelling all notifications.");
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (alarmManager != null) {
                alarmManager.cancel(PendingIntent.getService(context, 0, new Intent(context, NotificationService.class), 201326592));
            }
            if (notificationManager != null) {
                notificationManager.cancelAll();
            }
        } catch (Exception e) {
            Log.e(s_TAG, "Failed to cancel notifications.", e);
        }
    }

    public static void schedule(Context context, long j, String str) {
        Log.v(s_TAG, "Schedulting notification at " + j + " for: " + str);
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                Intent intent = new Intent(context, NotificationService.class);
                intent.putExtra(EXTRA_CONTENT_TEXT, str);
                alarmManager.set(1, j * 1000, PendingIntent.getService(context, 0, intent, 201326592));
            }
        } catch (Exception e) {
            Log.e(s_TAG, "Failed to schedule notification.", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (KumoAppActivity.isForeground()) {
            Log.v(s_TAG, "Skipping notification: already foreground.");
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (notificationManager != null) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder((Context) this, s_ChannelId);
                builder.setAutoCancel(true);
                builder.setCategory(NotificationCompat.CATEGORY_PROMO);
                builder.setContentTitle(getString(R.string.appName));
                builder.setContentText(intent.getStringExtra(EXTRA_CONTENT_TEXT));
                builder.setTicker(intent.getStringExtra(EXTRA_CONTENT_TEXT));
                builder.setLocalOnly(true);
                builder.setSmallIcon(R.drawable.notification);
                builder.setDefaults(1);
                builder.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, KumoAppActivity.class), 0));
                notificationManager.notify(0, builder.build());
                Log.v(s_TAG, "Notification presented.");
            }
        } catch (Exception e) {
            Log.e(s_TAG, "Failed to show notification.", e);
        }
    }
}
