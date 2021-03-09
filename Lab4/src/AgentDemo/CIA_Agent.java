package AgentDemo;

import static java.lang.Thread.sleep;

public class CIA_Agent  implements Runnable {
    private boolean workingInProgress;
    private String myFootPrint;

    CIA_Agent(String footprint)
    {
        this.myFootPrint=footprint;
    }

    public void run()
    {
        while(true)
        {
            if(workingInProgress)
            {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(myFootPrint);
            }
            else
            {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void processing()
    {
        System.out.print(myFootPrint);
    }
    public void startTask(){workingInProgress=true;}
    public void stopTask(){workingInProgress=false;}
}
