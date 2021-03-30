

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

    
}
