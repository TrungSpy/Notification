# Notification
1.Create a widget
2.Click on the button of the widget, the widget view will be refreshed and send the notification.

https://github.com/TrungSpy/Notification/blob/master/device-2016-02-28-214719.png


# How to add my maven repository to build.gradle
1. Add maven url 
```
repositories {
//    flatDir {
//        dirs 'libs'
//    }
    maven { url 'http://raw.github.com/TrungSpy/Notification/master/repository/' }
}
```
2. add dependencies
```
 compile 'lib.notification.vantrung.co.vn:notification-library:0.0.2'
```
