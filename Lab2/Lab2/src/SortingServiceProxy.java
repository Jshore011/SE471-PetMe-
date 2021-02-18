import java.util.ArrayList;

public class SortingServiceProxy implements SortingIF {
    private SortingUtil sort = new SortingUtil() {
    };
    private ArrayList<Product> products;
    private int sortType;

    public SortingServiceProxy() {

    }

    @Override
    public ArrayList<Product> sort(ArrayList<Product> products, int sortType) {
        this.products = products;
        if (sortType == 1) {
            sort.bubblesort(products);
            bubbledisplay(products);
        } else if (sortType == 2) {
            sort.sort(products);
            quickdisplay(products);
        }
        return products;
    }


    public  void bubbledisplay(ArrayList<Product> p){
        System.out.println("Using BubbleSort to sort the product list");
        System.out.format("%-13s%15s%15s\n","ID","Name","Price");
        System.out.println("********************************************");
        for(Product products: p)
        {
            System.out.format("%-13s%15s%15s", products.getProdID(), products.getName(), products.getPrice() + "\n");
        }
    }

    public void quickdisplay(ArrayList<Product>p){
        System.out.println("Using QuickSort to sort the product list");
        System.out.format("%-13s%15s%15s\n","Name","ID","Price");
        System.out.println("********************************************");
        for(Product item:p){
            System.out.format("%-13s%15s%15.2f",item.getName(),item.getProdID(),item.getPrice());
            System.out.println();
        }
    }


}

