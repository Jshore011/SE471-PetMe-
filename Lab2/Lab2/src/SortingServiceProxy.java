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
        System.out.format("%-20s%-20s%-13s\n","Name","ID","Price");
        for(Product products: p)
        {
            System.out.format("%-2s %10s %12s", products.getProdID(), products.getName(), products.getPrice() + "\n");
        }
    }

    public void quickdisplay(ArrayList<Product>p){
        System.out.println("Using QuickSort to sort the product list");
        System.out.format("%-20s%-20s%-13s\n","Name","ID","Price");
        for(Product item:p){
            System.out.format("%-2s%10s%13.2f",item.getName(),item.getProdID(),item.getPrice());
            System.out.println();
        }
    }


}

