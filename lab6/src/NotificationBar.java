public class NotificationBar {

    public void printNotifications(){
        NotificationIteratorIF iterator = notifications.createIterator();
        while(iterator.hasNext())
        {
            Notification n = iterator.next();
            System.out.println(n.getContent());
        }
    }
}
