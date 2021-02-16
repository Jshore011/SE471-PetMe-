import java.util.ArrayList;

public class Company {
    public String name;
    private ArrayList<Product> products;
    private SortingIF si;

    Company(String name, ArrayList<Product>products, SortingIF si)
    {
        this.name = name;
        this.products = new ArrayList<>(products);
        this.si = si;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    //check this
    public void setSi(SortingIF si, String sortAlgorithm) {
        this.si = si;
        sortAlgorithm = "";
    }


}
