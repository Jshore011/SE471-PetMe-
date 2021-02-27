package AgentDemo;

import static java.lang.Thread.sleep;

public class CIA_Agent  implements Runnable {
    private boolean workingInProgress;
    private String myFootPrint;

    CIA_Agent(CIA_AgentCreator footprint)
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
        // TODO: 2/26/2021 not sure what this does yet
    }
    public void startTask(){workingInProgress=true;}
    public void stopTask(){workingInProgress=false;}
}
