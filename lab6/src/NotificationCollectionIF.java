public interface NotificationCollectionIF {

    default NotificationIteratorIF createIterator() {
        return null;
    }
}
