

import java.util.ArrayList;

public class NotificationCollection implements NotificationCollectionIF {
    private Notification items;
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
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
        Notification notification = new Notification(str);
        if (numberOfItems >= MAX_ITEMS)
            System.err.println("Full");
        else
        {
            notifications.add(notification);
            numberOfItems = numberOfItems + 1;
        }
    }

    public int getLength()
    {
        return notifications.size();
    }


}
