

import java.util.ArrayList;

public class NotificationCollection implements NotificationCollectionIF {
    private Notification items;
    private int length = 0;
    private int index = 0;
    ArrayList<String> notifications = new ArrayList<String>();

    NotificationCollection()
    {
        notifications.addItem("Notification 1");
        notifications.addItem("Notification 2");
        notifications.addItem("Notification 3");
    }
    public Notification getItem(int index)
    {
        return this.items;
    }

    public void addItem(String str)
    {
        length = length + 1;

    }

    public int getLength ()
    {
        return this.length;
    }
}
