package lib.notification.vantrung.co.vn.widget;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Random;

import lib.notification.vantrung.co.vn.BuildConfig;
import lib.notification.vantrung.co.vn.Notification;
import lib.notification.vantrung.co.vn.R;

/**
 * Created by PhanVanTrung on 2016/02/27.
 */
public class UpdateWidgetService  extends Service{
    private static final String LOG = "UpdateWidget";
    public  static final String APPWIDGET_UPDATE_INTENT = "APPWIDGET_UPDATE_INTENT";
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        // Create some random data
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.getApplicationContext());

        int[] allWidgetIds = intent.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS);

        ComponentName thisWidget = new ComponentName(getApplicationContext(), WidgetProvider.class);
        int[] allWidgetIds2 = appWidgetManager.getAppWidgetIds(thisWidget);


        if (BuildConfig.DEBUG) {
            Log.d(LOG, "From Intent" + String.valueOf(allWidgetIds.length));
            Log.d(LOG, "Direct" + String.valueOf(allWidgetIds2.length));
        }

        for (int widgetId : allWidgetIds) {
            // Create some random data
            int number = (new Random().nextInt(100));

            RemoteViews remoteViews = new RemoteViews(this.getApplicationContext().getPackageName(), R.layout.widget_layout);

            // Set the text
            String updateString = "Set random value : " + String.valueOf(number);
            remoteViews.setTextViewText(R.id.update, updateString);

            // Register an onClickListener
            Intent clickIntent = new Intent(this.getApplicationContext(), WidgetProvider.class);

            clickIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            clickIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, allWidgetIds);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);
            // ボタンイベントを登録
            remoteViews.setOnClickPendingIntent(R.id.launchButton, pendingIntent);
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
            showNotification(getApplicationContext(),updateString);
        }
        stopSelf();
    }

    private static void showNotification(Context context,String contentText){
        Notification notification = new Notification(context);
        notification.setmIconId(R.drawable.notification_icon);
        notification.setmContentTitle("WidgetLibrary title");
        notification.setmContentText(contentText);
        notification.setmSubText("Sub text.");
        notification.setmInfo("Information");

        long now = System.currentTimeMillis();
        long interval = 10000l;
        notification.setmWhen(now + interval);

        notification.showNotification();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
