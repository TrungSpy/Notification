# Notification
Test maven project

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
 compile 'lib.notification.vantrung.co.vn:notification-library:0.0.1'
```
