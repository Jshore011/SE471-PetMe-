package AgentDemo;

import Pool.ObjectPool;
import static java.lang.Thread.sleep;
public class TaskRequester implements Runnable{
    private ObjectPool server;
    public TaskRequester(ObjectPool server){
        this.server = server;
    }

    @Override
    public void run() {
        try {
            Agent_IF agent = (Agent_IF)server.waitForObject();
            agent.startTask();
            sleep(2000);
            agent.stopTask();
            server.release(agent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

