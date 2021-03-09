package AgentDemo;

import Pool.ObjectCreation_IF;

public class CIA_AgentCreator implements ObjectCreation_IF {
    private int index;
    private final String[] footPrints ={"@", "#", "$", "*", ".", "?"};


    public Object create()
    {
        CIA_Agent agent = new CIA_Agent(footPrints[index++]);
        new Thread(agent).start();
        return agent;
    }
}
