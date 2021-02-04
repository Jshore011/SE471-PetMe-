package LineDrawing;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class LiningPanel extends javax.swing.JPanel  {
    private int counter;
    private int maxLines = 15;
    public LiningPanel()
    {
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

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
            g.drawLine(0,  h2, w2, h);//bottom left
            g.drawLine(w, h2, w - w2, h);//bottom right
            g.drawLine(0, h - h2, w2, 0);//top left
            g.drawLine(w, h - h2, w - w2, 0);//top right
        }
    }
    //method to increase counter
    public void increaseCounter()
    {
        if(this.counter == maxLines)
        {
            this.counter = 1;
        }
        else
            this.counter++;
    }
}
