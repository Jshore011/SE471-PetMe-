import java.util.ArrayList;

public abstract class SortingServiceProxy implements SortingIF {
    private SortingUtil sort;

    public SortingServiceProxy(SortingUtil sort)
    {
        this.sort = sort;
    }

    @Override
    public ArrayList<Product>sort(ArrayList<Product> products, int sortType) {
        sort.sort(products, sortType);
        if (sortType == 1) {
            sort.bubblesort(products);
        }
        else if (sortType == 2)
        {
            sort(products);
        }
        return products;
    }
}
