package AgentDemo;

import static java.lang.Thread.sleep;

public class FBI_Agent implements Runnable, Agent_IF{
    private boolean workingInProgress;
    private String myFootPrint;
    private int taskID;
    public FBI_Agent(String myFootPrint, int taskID){
        this.myFootPrint = myFootPrint;
        this.taskID = taskID;
    }
    @Override
    public void run() {
        while (true) {
            try {
                if (workingInProgress) {
                    sleep(100);
                    System.out.println("Agent:" + myFootPrint + " | " + "TaskID: " + taskID);
                }else{
                    sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("HERE");
                e.printStackTrace();
            }
        }
    }
    @Override
    public void startTask() { workingInProgress = true; }

    @Override
    public void stopTask() { workingInProgress = false; }

    @Override
    public void setTask(int i) { taskID=i; }

    public int getTaskID() { return this.taskID; }
}
