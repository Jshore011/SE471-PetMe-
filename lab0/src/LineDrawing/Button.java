package LineDrawing;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Button extends Animator {
    private javax.swing.JButton stop;
    private boolean isStopped = false;

    public Button(LiningPanel apanel) {
        super(apanel);
        stop.addActionListener((ActionListener) this);
    }

    public void stopActionPerformed(java.awt.event.ActionEvent evt)
    {
        if (!isStopped)
        {
            isStopped = true;
            stop.setText("Resume");
            Animator.setStopped(true);
        }
        else
        {
            isStopped = false;
            stop.setText("Stop");
            Animator.setStopped(false);
        }
    }
}
