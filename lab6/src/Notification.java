public class Notification {
    private Attachment attachment;
    private String text;
    private boolean hasAttachment = false;

    Notification(String text)
    {
        this.text=text;
    }


    public String getContent()
    {
        if(hasAttachment == true)
        {
            return attachment.preview();
        }
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
