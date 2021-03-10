package AgentDemo;

import Pool.ObjectCreation_IF;

import java.util.Random;
public class CIA_AgentCreator implements ObjectCreation_IF {
    private String[] footPrints = {"@","#","$","*",".","?"};
    private int index = 0;
    private Random rand = new Random();

    public Object create() {
        if(index == 5){
            index = 0;
        }
        CIA_Agent cia_Agent = new CIA_Agent(footPrints[index], rand.nextInt(3000));
        index++;
        new Thread(cia_Agent).start();
        return cia_Agent;
    }
}

