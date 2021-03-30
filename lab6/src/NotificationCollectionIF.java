import java.util.Iterator;

public interface NotificationCollectionIF {
    NotificationIteratorIF createIterator();
    Iterator iterator = notification.createIterator();
    while (iterator.hasNext()) {Notification notification = iterator.next();}
}
