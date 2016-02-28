package lib.notification.vantrung.co.vn.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import lib.notification.vantrung.co.vn.BuildConfig;

/**
 * Created by PhanVanTrung on 2016/02/27.
 */
public class WidgetProvider extends AppWidgetProvider {
    private static final String LOG = "WidgetProvider ";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        if (BuildConfig.DEBUG) {
            Log.d(LOG, "onUpdate method called");
        }
        // Get all ids
        ComponentName thisWidget = new ComponentName(context, WidgetProvider.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);

        // Build the intent to call the service
        Intent intent = new Intent(context.getApplicationContext(), UpdateWidgetService.class);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, allWidgetIds);

        // Update the widgets via the service
        context.startService(intent);
    }
}
