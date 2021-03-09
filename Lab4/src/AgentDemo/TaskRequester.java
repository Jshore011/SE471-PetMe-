package AgentDemo;

import Pool.ObjectPool;

public class TaskRequester implements  Runnable {
    private ObjectPool server;


    TaskRequester(ObjectPool p) throws InterruptedException {
        server = p;
    }

    public void run() {

        Agent_IF agent = null;
        try {
            agent = (Agent_IF) server.waitForObject();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        agent.startTask();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        agent.stopTask();
        server.release(agent);
    }



    }
