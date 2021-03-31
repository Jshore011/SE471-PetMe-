public class Demo {

    public static void main(String[] args) {
        NotificationCollection nc = new NotificationCollection();
        nc.addItem("Item 1");
        nc.addItem("Item 2");
        NotificationBar nb = new NotificationBar(nc);
        nb.printNotifications();
    }
}
