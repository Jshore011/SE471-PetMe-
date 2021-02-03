package LineDrawing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends javax.swing.JPanel implements ActionListener {
    private final String STOP = "Stop";
    private final String RESUME = "Resume";
    private Animator animator = null;
    private JButton button = null;
    private boolean animationIsStopped = false;

    public Button(Animator animator) {

        this.animator = animator;
        this.configButton();
    }

    private void configButton()
        {
            this.button = new JButton();
            this.button.setSize(50,50);
            this.button.setText(STOP);
            this.button.addActionListener(this);
            this.add(this.button);
        }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(!animationIsStopped)
        {
            animator.isStopped();
            animator.setStopped(true);
            button.setText(STOP);

        }
        else
            //animator.isStopped();
            animator.setStopped(false);
            button.setText(RESUME);

    }
}
