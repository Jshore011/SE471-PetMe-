package AgentDemo;

import Pool.ObjectPool;

public class CIAAgentApp {

    public static void main(String args[]){
        ObjectPool server = ObjectPool.getPoolInstance(new CIA_AgentCreator(), 5);
        for(int i = 0; i <10; i++)
        {
            TaskRequester tr = new TaskRequester(server);

            Thread client = new Thread(tr);
            client.start();
        }
    }
}
