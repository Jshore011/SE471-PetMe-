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
    private LiningPanel panel;
    public Thread th = new Thread();
    public Button(Animator animator, LiningPanel panel) {

        this.panel=panel;
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

        if(animationIsStopped==true)
        {

            animationIsStopped = false;
            this.button.setText(this.STOP);
            animator.setStopped(false);
            th.start();

        }
        else

            animationIsStopped = true;
            this.button.setText(this.RESUME);
            animator.setStopped(true);


    }

}
