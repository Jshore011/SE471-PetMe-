package LineDrawing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends javax.swing.JPanel implements ActionListener {
    private final String STOP = "Stop";
    private final String RESUME = "Resume";
    private Animator animator;
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
        Thread newThread = new Thread(animator);//i think we need to start a new thread and pass the panel
        if(animationIsStopped==true)
        {

            animationIsStopped = false;
            this.button.setText(STOP);
            animator.setStopped(false);


        }
        else

            animationIsStopped = true;
            this.button.setText(RESUME);
            animator.setStopped(true);
            newThread.start();

    }

}
