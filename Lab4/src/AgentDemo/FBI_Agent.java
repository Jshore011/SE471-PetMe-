package AgentDemo;

import static java.lang.Thread.sleep;

public class FBI_Agent implements  Agent_IF, Runnable{
    private boolean workingInProgress;
    private final String myFootPrint;
    private int taskID=0;

    public FBI_Agent(String footprint)
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
        System.out.println(myFootPrint + "TaskID: "+ taskID++);
    }
    public void startTask(){workingInProgress=true;}
    public void stopTask(){workingInProgress=false;}

    @Override
    public void setTaskID(int i) {
        taskID=i;

    }

}
