package LineDrawing;

import javax.swing.*;
import java.awt.*;

//added to test webhook
public class LineDrawingTest {

    public static void main(String[] args) {

        JFrame application = new JFrame();
        LiningPanel panel = new LiningPanel();
        Animator animator = new Animator(panel);
        Button cpanel = new Button(animator);




        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.getContentPane().add(cpanel, BorderLayout.NORTH);
        application.getContentPane().add(panel, BorderLayout.CENTER);
        application.pack();
        application.setLocationRelativeTo(null);
        application.setSize(425, 450);
        application.setTitle("Lining Art");
        application.setVisible(true);

        animator.run();



    }
}
