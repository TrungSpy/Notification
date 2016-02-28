package lib.notification.vantrung.co.vn;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by PhanVanTrung on 2016/02/27.
 */
public class Notification {
    private Context mContext;
    private int mIconId;
    private String mContentTitle;
    private String mContentText;
    private String mSubText;
    private String mInfo;
    private long mWhen;
    public static int NOTIFICATION_TEXT_ID = 103;

    public Notification(Context context) {
        this.mContext = context;
    }

    public void showNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);

        builder.setSmallIcon(getmIconId());

        if (!TextUtils.isEmpty(getmContentTitle())){
            builder.setContentTitle(getmContentTitle()); // 1行目
        }

        if (!TextUtils.isEmpty(getmContentText())){
            builder.setContentTitle(getmContentText()); // 2行目
        }

        if(!TextUtils.isEmpty(getmSubText())){
            builder.setSubText(getmSubText()); // 3行目
        }

        if(!TextUtils.isEmpty(getmInfo())){
            builder.setContentInfo(getmInfo()); // 右端
        }

        builder.setWhen(getmWhen()); // タイムスタンプ（現在時刻、メール受信時刻、カウントダウンなどに使用）

        builder.setTicker("Ticker"); // 通知到着時に通知バーに表示(4.4まで)
        // 5.0からは表示されない

        NotificationManagerCompat manager = NotificationManagerCompat.from(mContext);
        manager.notify(NOTIFICATION_TEXT_ID, builder.build());
    }

    public int getmIconId() {
        return mIconId;
    }

    public void setmIconId(int mIconId) {
        this.mIconId = mIconId;
    }

    public void setmContentTitle(String mContentTitle) {
        this.mContentTitle = mContentTitle;
    }

    public void setmContentText(String mContentText) {
        this.mContentText = mContentText;
    }

    public String getmContentTitle() {
        return mContentTitle;
    }

    public String getmContentText() {
        return mContentText;
    }

    public String getmInfo() {
        return mInfo;
    }

    public void setmInfo(String mInfo) {
        this.mInfo = mInfo;
    }

    public String getmSubText() {
        return mSubText;
    }

    public void setmSubText(String mSubText) {
        this.mSubText = mSubText;
    }

    public long getmWhen() {
        return mWhen;
    }

    public void setmWhen(long mWhen) {
        this.mWhen = mWhen;
    }
}
