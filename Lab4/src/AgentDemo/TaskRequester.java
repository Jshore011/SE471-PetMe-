package AgentDemo;

import Pool.ObjectPool;
import static java.lang.Thread.sleep;
public class TaskRequester implements  Runnable {
    private ObjectPool server;


    TaskRequester(ObjectPool p) {
        server = p;
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
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        agent.stopTask();
        server.release(agent);

    }



}
