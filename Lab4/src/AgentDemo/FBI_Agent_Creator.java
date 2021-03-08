package AgentDemo;

import Pool.ObjectCreation_IF;

public class FBI_Agent_Creator implements ObjectCreation_IF {
    int index;
    private String footPrints[] ={"͞@͞3", "͞#͞3", "͞$͞3", "͞*͞3", "͞.͞3", "͞?͞3"};


    public Object create()
    {
        FBI_Agent agent = new FBI_Agent(footPrints[index++]);
        new Thread(agent).start();
        return agent;
    }
}
