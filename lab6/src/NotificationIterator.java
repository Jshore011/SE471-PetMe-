
public class NotificationIterator implements NotificationIteratorIF{
    private NotificationCollection collection;


    public boolean hasNext() {
        if(collection == null)
        {
            return false;
        }
        else
            return true;
    }

    public NotificationCollection next() {

        return collection;
    }
}
