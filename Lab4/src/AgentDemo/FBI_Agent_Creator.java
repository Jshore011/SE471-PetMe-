package AgentDemo;
import Pool.ObjectCreation_IF;


public class FBI_Agent_Creator implements ObjectCreation_IF {
    int index;
    private final String[] footPrints ={"@", "#", "$", "*", ".", "?"};


    public Object create()
    {
        FBI_Agent agent = new FBI_Agent(footPrints[index++]);
        new Thread(agent).start();
        return agent;
    }
}
