public class Demo {

    public static void main(String[] args) {
        NotificationCollection nc = new NotificationCollection();
        NotificationBar nb = new NotificationBar(nc);

        Attachment media1 = new MediaAttachment("Media attachment contains video");
        nc.addItem("notification 1");
        nc.setAttachment(media1);

        Attachment file1 = new FileAttachment("File attachment contains sales document");
        nc.addItem("notification 2");
        nc.setAttachment(file1);

        Attachment media2 = new MediaAttachment("Media attachment contains video");
        nc.addItem("notification 3");
        nc.setAttachment(media2);

        Attachment file2 = new FileAttachment("File attachment contains grocery list");
        nc.addItem("notification 4");
        nc.setAttachment(file2);

        nb.printNotifications();


    }
}
