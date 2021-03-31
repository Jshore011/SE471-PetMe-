
public class NotificationIterator implements NotificationIteratorIF{
    private NotificationCollection collection;
    //maintains current position
    private int pos;

    public NotificationIterator(NotificationCollection collection)
    {   this.collection = collection;
        pos = 0;
    }

    public boolean hasNext()
    {
        return pos < collection.getLength();
    }

    public Notification next()
    {
        Notification notification = collection.getItem(pos);
        pos++;
        return notification;
    }
}
