package coffee;

import coffee.Coffee_IF;
import condiments.Condiment_IF;

import java.util.List;

public class Coffee implements Coffee_IF {
    private final String type;


    public Coffee(String type) {
        this.type = type;
    }


    @Override
    public String getType() {
        return type + " -";
    }


    @Override
    public double getPrice() {
        return 0.00;
    }

}
