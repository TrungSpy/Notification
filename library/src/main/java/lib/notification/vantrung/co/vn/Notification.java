package lib.notification.vantrung.co.vn;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;

/**
 * Created by PhanVanTrung on 2016/02/27.
 */
public class Notification {

    public static void showNotification(Context context){

        // define sound URI, the sound to be played when there's a notification
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Toast.makeText(context, "Test nhe Trung", Toast.LENGTH_SHORT).show();

//        // intent triggered, you can add other intent for other actions
//        Intent intent = new Intent(context, NotificationReceiver.class);
//        PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent, 0);
//
//        // this is it, we'll build the notification!
//        // in the addAction method, if you don't want any icon, just set the first param to 0
//        Notification mNotification = new Notification.Builder(context)
//
//                .setContentTitle("New Post!")
//                .setContentText("Here's an awesome update for you!")
////                .setSmallIcon(R.drawable.ninja)
//                .setContentIntent(pIntent)
//                .setSound(soundUri)
//
////                .addAction(R.drawable.ninja, "View", pIntent)
//                .addAction(0, "Remind", pIntent)
//
//                .build();
//
//        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
//
//        // If you want to hide the notification after it was selected, do the code below
//        // myNotification.flags |= Notification.FLAG_AUTO_CANCEL;
//
//        notificationManager.notify(0, mNotification);
    }
}
