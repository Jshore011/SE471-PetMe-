package LineDrawing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends javax.swing.JPanel implements ActionListener {
    private final String STOP = "Stop";
    private final String RESUME = "Resume";
    private Animator animator;
    private javax.swing.JButton button;
    private boolean animationIsStopped = false;

    public Button(Animator animator1)
    {
        this.animator = animator1;
        this.configButton();
    }
    //method to configure the button
    private void configButton()
        {
            this.button = new JButton();
            this.button.setSize(50,50);
            this.button.setText(STOP);
            this.button.addActionListener(this);
            this.add(this.button);
        }
    //logic for when button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!animationIsStopped)
        {
            animationIsStopped = true;
            button.setText(RESUME);
            animator.setStopped(true);
        }
        else {
            animationIsStopped = false;
            button.setText(STOP);
            animator.setStopped(false);
        }
    }
}
