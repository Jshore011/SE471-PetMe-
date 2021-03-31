public class MediaAttachment extends Attachment{
    String type;
    public MediaAttachment(String type) {
        super(type);
        this.type = type;
    }

    public String preview(){
        return type;
    }

    public MediaAttachment returnAttachment(){
        return this;
    }

}
