package LineDrawing;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LineDrawingTest {

    public static void main(String[] args) {

        JFrame application = new JFrame();
        LiningPanel panel = new LiningPanel();
        JPanel fnButtonPanel = new JPanel();
        JButton pushbutton = new JButton();
        Animator animator = new Animator(panel);
        //Button stopButton = new Button(panel);

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.add(fnButtonPanel);
        fnButtonPanel.add(pushbutton);
        panel.setSize(300,300);
        panel.setLocation(0, 40);
        application.setLocationRelativeTo(null);
        pushbutton.setText("Start");
        pushbutton.setSize(50,50);
        application.setSize(315, 380);
        application.setTitle("Lining Art");
        application.setVisible(true);
        panel.setVisible(true);
        //stopButton.setDpanel(panel);

           animator.run();



    }
}
