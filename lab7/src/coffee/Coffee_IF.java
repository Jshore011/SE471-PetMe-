package coffee;

import condiments.Condiment_IF;

import java.util.List;

public interface Coffee_IF {
    public double getPrice();
    public String getType();
    public List<Condiment_IF> getCondiment();

}
