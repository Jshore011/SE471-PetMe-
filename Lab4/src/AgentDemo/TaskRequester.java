package AgentDemo;

import Pool.ObjectPool;
import static java.lang.Thread.sleep;
public class TaskRequester implements Runnable{
    private ObjectPool server;

    TaskRequester(ObjectPool p)
    {
        this.server=p;
    }

    public void run()
    {
        Agent_IF agent = (Agent_IF)server.waitForObject();
        agent.startTask();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        agent.stopTask();
        server.release(agent);
    }
}
