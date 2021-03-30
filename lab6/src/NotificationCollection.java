

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
        notifications.add(str);
    }

    public int getLength()
    {
        return notifications.size();
    }


    @Override
    public NotificationIteratorIF createIterator() {
        return null;
    }
}
