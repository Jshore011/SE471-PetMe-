
public class NotificationIterator implements NotificationIteratorIF{
    private NotificationCollection collection;

    //maintains current position
    int pos=0;

    public NotificationIterator(NotificationCollectionIF n){ this.collection = (NotificationCollection) n; }

    public boolean hasNext() {
        return (pos >= collection.getLength() || collection.getLength() <= 0);
    }

    public Notification next() { return collection.getItem(pos ++ ); }
}
