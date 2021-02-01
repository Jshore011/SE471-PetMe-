package LineDrawing;
import java.awt.Graphics;

public class Animator implements Runnable {
    private AnimatedLiningPanel dpanel;
    private boolean stopped = false;
    public Animator (AnimatedLiningPanel apanel)
    {
        dpanel = apanel;
    }
    public void run()
    {
        while(true)
        {
            if (!isStopped())
            {
                dpanel.repaint();
                dpanel.increaseCounter();
            }
            try { Thread.sleep(300);}
            catch (Exception e) {}
        }
    }
    public void setDpanel(AnimatedLiningPanel dpanel)
    {
        this.dpanel = dpanel;
    }
    public boolean isStopped()
    {
        return stopped;
    }
    public void setStopped(boolean stopped)
    {
        this.stopped = stopped;
    }
}
