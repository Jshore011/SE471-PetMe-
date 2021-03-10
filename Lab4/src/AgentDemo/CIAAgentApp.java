package AgentDemo;

import Pool.ObjectPool;

public class CIAAgentApp {
    public static void main(String args[]){
        ObjectPool server = ObjectPool.getPoolInstance(new CIA_AgentCreator(), 5);
        for(int i = 0; i < 10; i++){
            Thread client = new Thread(new TaskRequester(server));
            client.start();
        }
    }
}