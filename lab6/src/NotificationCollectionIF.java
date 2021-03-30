<<<<<<< HEAD
public  interface NotificationCollectionIF {

     NotificationIteratorIF createIterator();


=======
import java.util.Iterator;

public interface NotificationCollectionIF {
    NotificationIteratorIF createIterator();
    Iterator iterator = notification.createIterator();
    while (iterator.hasNext()) {Notification notification = iterator.next();}
>>>>>>> c3fe552f332296603286dfc8207846a3d8d7e53f
}
