package AgentDemo;

import Pool.ObjectPool;

public class TaskRequester implements  Runnable {
    private final ObjectPool server;
    public int taskID;

    TaskRequester(ObjectPool p) {

        server=p;
    }

    public void run() {

        Agent_IF agent = null;
        try {
            agent = (Agent_IF) server.waitForObject();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (agent != null) {
            agent.startTask();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (agent != null) {
            agent.stopTask();
        }
        server.release(agent);
    }

    public void setTask(int i) {
        this.taskID = i;
    }

    public int getTaskID() {
        return taskID;
    }
}

