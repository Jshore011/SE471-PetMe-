package LineDrawing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animator implements Runnable {
    private LiningPanel dpanel;
    private boolean stopped = false;

    public Animator(LiningPanel apanel) {
        dpanel = apanel;

    }

    public void run() {
        while (true) {
            if (!isStopped()) {
                dpanel.repaint();
                dpanel.increaseCounter();
            }
            try {
                Thread.sleep(300);
            } catch (Exception e) {
            }
        }
    }

    public void setDpanel(LiningPanel dpanel) {
        this.dpanel = dpanel;
    }

    public boolean isStopped() {
        return stopped;
    }

    public static void setStopped(boolean stopped) {
        boolean stop = stopped;
    }



}
