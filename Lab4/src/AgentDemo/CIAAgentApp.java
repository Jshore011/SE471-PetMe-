package AgentDemo;

import Pool.ObjectPool;

public class CIAAgentApp {

    public static void main(String arg[]) {
        ObjectPool server = ObjectPool.getPoolInstance(new CIA_AgentCreator(), 5);

        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(new TaskRequester(server));
            t1.start();
        }
    }
}