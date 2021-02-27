package AgentDemo;

import Pool.ObjectCreation_IF;

public class FBI_Agent_Creator implements ObjectCreation_IF {
    int index;

    // TODO: 2/26/2021 unsure of the footprints data type so I did not implement
    public Object create()
    {
        FBI_Agent agent = new FBI_Agent(footPrints[index++]);
        new Thread(agent).start();
        return agent;
    }// TODO: 2/26/2021 not sure why its giving me issue with agent in this class, but not CIA_agent creator class
}
