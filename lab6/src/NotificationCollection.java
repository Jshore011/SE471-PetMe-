

import java.util.ArrayList;

public class NotificationCollection implements NotificationCollectionIF {
    private Notification items;
    ArrayList<Notification> notifications ;

    NotificationCollection()
    {
        notifications = new ArrayList<>();
    }
    public Notification getItem(int index) {
        return notifications.get(index);
    }
    public void addItem(String str)
    {
        items = new Notification(str);
        notifications.add(items);
    }

    public int getLength()
    {
        return notifications.size();
    }

    @Override
    public NotificationIteratorIF createIterator() {
        return new NotificationIterator(this); // dependancy injection
    }
}
