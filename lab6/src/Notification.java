public class Notification {
    private Attachment attachment;

    Notification(Attachment attachment)
    {
        this.attachment=attachment;
    }

    public String getContent()
    {
        return attachment.toString();
    }
}
