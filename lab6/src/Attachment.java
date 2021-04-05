public abstract class Attachment {
    private String type;
    public Attachment(String type){
        this.type = type;
    }

    public String preview() {
        return type;
    }

    public Attachment returnAttachment(){ return this; }



}



