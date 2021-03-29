public class NotificationCollection implements NotificationCollectionIF {
    private Notification items;
    private int length;
    private int index;

    NotificationCollection()
    {

    }
    public Notification getItem(int index)
    {
        return this.items;
    }

    public void addItem(String str)
    {

    }

    public int getLength ()
    {
        return this.length;
    }
}
