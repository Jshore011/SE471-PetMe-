public class Demo {

    public static void main(String[] args) {
        NotificationCollection nc = new NotificationCollection() {

        }
        NotificationBar nb = new NotificationBar(nc);
        nb.printNotifications();
    }
}
