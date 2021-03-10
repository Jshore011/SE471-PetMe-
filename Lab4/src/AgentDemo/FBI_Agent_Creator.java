package AgentDemo;

import Pool.ObjectCreation_IF;

import java.util.Random;
public class FBI_Agent_Creator implements ObjectCreation_IF {
    private String[] footPrints = {"@","#","$","*",".","?"};
    private int index = 0;
    private Random rand = new Random();

    public Object create() {
        if(index == 5){
            index = 0;
        }
        FBI_Agent fbi_Agent = new FBI_Agent(footPrints[index], rand.nextInt(3000));
        index++;
        new Thread(fbi_Agent).start();
        return fbi_Agent;
    }
}