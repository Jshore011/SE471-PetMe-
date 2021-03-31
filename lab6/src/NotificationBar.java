
public class NotificationBar {
    private NotificationCollectionIF notifications;

    public NotificationBar(NotificationCollection notificationcollection)
    {
        this.notifications = notificationcollection;
    }

    public void printNotifications(){
        NotificationIteratorIF iterator = notifications.createIterator();
        System.out.println("---------------------------");
        while(iterator.hasNext())
        {
            Notification n = iterator.next();
            System.out.println(n.getText());
            System.out.println(n.getContent());
            System.out.println("-----------------------");
        }
        iterator.resetCount();
    }
}
