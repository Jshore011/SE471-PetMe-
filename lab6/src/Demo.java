public class Demo {

    public static void main(String[] args) {
        NotificationCollection nc = new NotificationCollection();
        NotificationBar nb = new NotificationBar(nc);

        for (int i = 0; i <10; i++) {
            nc.addItem("notification: "+ i);
        }

        Attachment media1 = new MediaAttachment("Media attachment contains video");
        nc.


        Attachment file1 = new FileAttachment("File attachment contains sales document");
        nc.setAttachment(file1);

        Attachment media2 = new MediaAttachment("Media attachment contains video");
        nc.setAttachment(media2);

        Attachment file2 = new FileAttachment("File attachment contains grocery list");
        nc.setAttachment(file2);

        nb.printNotifications();


    }
}
