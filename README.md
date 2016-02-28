## Notification  
1.Create a widget  
2.Click on the button of the widget, the widget view will be refreshed and send the notification.   

<img src="https://github.com/TrungSpy/Notification/blob/master/device-2016-02-28-214719.png">


# How to add my maven repository to build.gradle

(1)Add maven url 

```
repositories {
//    flatDir {
//        dirs 'libs'
//    }
    maven { url 'http://raw.github.com/TrungSpy/Notification/master/repository/' }
}
``` 

(2) add dependencies

```
 compile 'lib.notification.vantrung.co.vn:notification-library:0.0.2'
```  

(3)add the below code to the AndroidManifest.xml file

```
<receiver
            android:icon="@mipmap/ic_launcher"
            android:label="Sample Widget"
            android:name="lib.notification.vantrung.co.vn.widget.WidgetProvider" >
            <intent-filter >
                <action android:name="android.appwidget.action.APPWIDGET_UPDATE" />
            </intent-filter>

            <meta-data
                android:name="android.appwidget.provider"
                android:resource="@xml/widget_info" />
        </receiver>
        <service android:name="lib.notification.vantrung.co.vn.widget.UpdateWidgetService"/>
```
