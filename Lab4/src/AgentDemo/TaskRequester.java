package AgentDemo;

import Pool.ObjectPool;

public class TaskRequester implements Agent_IF,  Runnable {
    private final ObjectPool server;


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


    @Override
    public void startTask() {

    }


    @Override
    public void stopTask() {

    }

    @Override
    public void setTask(int i) {

    }
}

