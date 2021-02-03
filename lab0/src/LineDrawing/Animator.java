package LineDrawing;


import javax.swing.*;

public class Animator implements Runnable {
    private LiningPanel dpanel;
    private boolean stopped = false;

    public Animator(LiningPanel panel) {
        dpanel = panel;

    }



    public void setDpanel(LiningPanel dpanel) {
        this.dpanel = dpanel;
    }

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }


    @Override
    public void run() {
        while (true) {
            if (!isStopped()) {
                dpanel.repaint();
                dpanel.increaseCounter();
            }
            else
                try {
                    Thread.sleep(300);
                } catch (Exception e) {
                }

        }
    }
}
