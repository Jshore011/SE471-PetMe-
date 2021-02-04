package LineDrawing;


public class Animator implements Runnable {
    private LiningPanel dpanel;
    private boolean stopped = false;

    public Animator(LiningPanel panel) {
        dpanel = panel;

    }
    //run method
    @Override
    public void run() {
        while (true) {

            if (!isStopped()) {
                dpanel.increaseCounter();
                dpanel.repaint();
            }
            try {

                Thread.sleep(300);
            } catch (Exception e) {
            }

        }

    }
    //returns whether it is stopped or not
    public boolean isStopped() {
        return stopped;
    }
    //sets the bool value to true/false dependent upon if stopped or not
    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

}
