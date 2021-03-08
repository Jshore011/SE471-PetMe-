package AgentDemo;

import Pool.ObjectCreation_IF;

public class CIA_AgentCreator implements ObjectCreation_IF {
    private int index;
    private String footPrints[]={"@", "#", "$", "*", ".", "?"};

    // TODO: 2/26/2021 add footprints[] not sure what the data type is
    public Object create()
    {
        CIA_Agent agent = new CIA_Agent(footPrints[index++]);
        new Thread(agent).start();
        return agent;
    }
}
