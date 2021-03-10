package AgentDemo;

import static java.lang.Thread.sleep;

public class FBI_Agent implements  Agent_IF, Runnable {
    private boolean workingInProgress =false;
    private final String myFootPrint;
    private int taskID;

    public FBI_Agent(String footprint)
    {
        this.myFootPrint=footprint;
    }

    public void setTask(int i) {
        this.taskID=i;
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
                processing();
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
        System.out.println("FBI Agent: " + myFootPrint +" | "  + "TaskID: "+ taskID);
    }
    public void startTask(){this.workingInProgress=true;}
    public void stopTask(){this.workingInProgress=false;}



}
