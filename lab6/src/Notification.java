public class Notification {
    private Attachment attachment;
    private String text;
    private boolean hasAttachment = false;

    Notification(String text)
    {
        this.text=text;
    }
    public String getText()
    {
        return text;
    }
    public Object getContent()
    {
        if(hasAttachment)
        {
            return attachment.preview();
        }
        return "No Attachment Found!";
    }
    public void setAttachment(Attachment attachment)
    {
        this. attachment=attachment;
        hasAttachment=true;
    }
    public boolean hasAttachment()
    {
        return hasAttachment;
    }
}
