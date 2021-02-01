package LineDrawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class LiningPanel extends javax.swing.JPanel implements Runnable
{
    private boolean stop = false;
    @Override
    public void run() {
        while (resume())
        {
            System.out.println("Running");
            try {
                Thread.sleep(3L * 100L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public LiningPanel()
    {

    }

    //for button
    public synchronized void stop()
    {
        this.stop = true;
    }
    private synchronized boolean resume()
    {
        return this.stop == false;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //Runnable myRunnable = new Runnable();
        int w = getWidth();
        int h = getHeight();
        
        double lines = 15.0;

        for(int i = 0; i < lines; i++)
        {
            int w2 = (int)((i/lines)*w); 
            int h2 = (int)((i/lines)*h);
            Random random = new Random();
            Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            g.setColor(color);
            //bottom left
            g.drawLine(0,  h2, w2, h);
            //bottom right
            g.drawLine(w, h2, w - w2, h);
            //top left
            g.drawLine(0, h - h2, w2, 0);
            //top right
            g.drawLine(w, h - h2, w - w2, 0);
        }
    }
}
