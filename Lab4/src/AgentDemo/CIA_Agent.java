package AgentDemo;

import static java.lang.Thread.sleep;

public class CIA_Agent  implements Agent_IF,Runnable {
    private boolean workingInProgress;
    private String myFootPrint;
    private int taskID;

    CIA_Agent(String footprint)
    {
        workingInProgress = false;
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
        System.out.print(myFootPrint + "TaskID:" + taskID);
    }
    public void startTask(){workingInProgress=true;}
    public void stopTask(){workingInProgress=false;}

    @Override
    public void setTask(int id) {
        taskID=id;
    }
}
