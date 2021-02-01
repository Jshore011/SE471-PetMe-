package LineDrawing;

import javax.swing.JFrame;

public class LineDrawingTest {

    public static void main(String[] args) {

        JFrame application = new JFrame();
        LiningPanel panel = new LiningPanel();
        /*Runnable myRunnable = new Runnable() {
            @Override
            public void run() {

            }
        }*/
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(300, 300);
        application.setTitle("Lining Art");
        application.setVisible(true);
    }
}
