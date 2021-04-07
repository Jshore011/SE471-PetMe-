package condiments;

import java.util.List;

public class Coffee implements Coffee_IF{
    private List<Condiment_IF> condiments;
    private String type;
    private double price;

    @Override
    public double getPrice(){
        return price;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public List<Condiment_IF> getCondiment() {
        return condiments;
    }
}
