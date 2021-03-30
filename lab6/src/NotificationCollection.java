

import java.util.ArrayList;

public class NotificationCollection implements NotificationCollectionIF {
    private Notification items;
    ArrayList<String> notifications;

    NotificationCollection()
    {
        notifications = new ArrayList<>();
    }
    public int getItem(int index)
    {
        return notifications.get(index);
        

    public int getLength()
    {
        return notifications.length();
    }


}
