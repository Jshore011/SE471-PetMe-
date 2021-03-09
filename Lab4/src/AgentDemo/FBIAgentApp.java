package AgentDemo;

import Pool.ObjectPool;

public class FBIAgentApp {
    public static void main(String[] args){
        ObjectPool server = ObjectPool.getPoolInstance(new FBI_Agent_Creator(), 5);
        for(int i = 0; i <10; i++)
        {
            TaskRequester tr=new TaskRequester(server);
            tr.setTask(i);
            Thread client = new Thread(tr);
            client.start();
        }
    }


}
