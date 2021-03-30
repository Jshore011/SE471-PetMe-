public class Notification {
    private Attachment attachment;
    String notification;
    Notification(String notification)
    {
        this.notification = notification;
    }

    public String getContent()
    {
        return  notification;
    }
}
