import java.util.Iterator;

public interface NotificationCollectionIF {
    //-----------
    Iterator iterator = notificationList.createIterator();

    while (iterator.hasNext()) {Notification notification = iterator.next();}
}
