public class FileAttachment extends Attachment{
    String type;
    public FileAttachment(String type) {
        super(type);
        this.type = type;
    }

    public String preview(){
        return type;
    }

    public FileAttachment returnAttachment(){
        return this;
    }
}
