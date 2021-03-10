package AgentDemo;

public class CIA_Agent  implements Agent_IF,Runnable {
    private boolean workingInProgress;
    private String myFootPrint;
    private int taskID;

    CIA_Agent(String footprint)
    {
        workingInProgress = false;
        myFootPrint=footprint;
    }
    public void startTask(){workingInProgress=true;}
    public void stopTask(){workingInProgress=false;}
    public void setTask(int i) {
        taskID=i;
    }
    private void processing()
    {
        System.out.println(myFootPrint + "TaskID: "+ taskID);
    }

    public void run()
    {
        while (true) {
            if (workingInProgress) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                processing();
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
