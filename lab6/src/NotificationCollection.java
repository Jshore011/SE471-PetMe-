

import java.util.ArrayList;

public class NotificationCollection implements NotificationCollectionIF {
    private Notification items;
    ArrayList<Notification> notifications;

    NotificationCollection()
    {
        notifications = new ArrayList<>();
        addItem("Notification 1");
        addItem("Notification 2");
        addItem("Notification 3");
    }
    public void getItem(int index) {
        notifications.get(index);
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

<<<<<<< HEAD
    
=======

    @Override
    public NotificationIteratorIF createIterator() {
        return null;
    }
>>>>>>> c3fe552f332296603286dfc8207846a3d8d7e53f
}
