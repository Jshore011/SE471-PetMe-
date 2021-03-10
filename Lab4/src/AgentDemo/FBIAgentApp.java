package AgentDemo;

import Pool.ObjectPool;

public class FBIAgentApp {
    public static void main(String[] args) throws InterruptedException {
        ObjectPool server = ObjectPool.getPoolInstance(new FBI_Agent_Creator(), 5);
        for(int i = 0; i <10; i++)
        {
            TaskRequester t1 = new TaskRequester(server);

            Thread client = new Thread(t1);
            t1.setTask(i);
            client.start();
        }
    }


}
