package AgentDemo;

import Pool.ObjectPool;

public class FBIAgentApp {
    public static void main(){
        ObjectPool server = ObjectPoolgetPoolInstance(new_FBIAgent_Creator(), 5);
        for(int i = 0; i <10; i++)
        {
            Thread client = new Thread(new TaskRequester(server));
            client.start();
        }
    }


}
