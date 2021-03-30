

import java.util.ArrayList;

public class NotificationCollection implements NotificationCollectionIF {
    private Notification items;
    ArrayList<String> notifications;

    NotificationCollection()
    {
        notifications = new ArrayList<>();
    }
    public void getItem(int index) {
        notifications.get(index);
    }
    public void addItem(String str)
    {
        Notification notification = new Notification(str);
        notifications.add(notification);
    }

    public int getLength()
    {
        return notifications.size();
    }


}
