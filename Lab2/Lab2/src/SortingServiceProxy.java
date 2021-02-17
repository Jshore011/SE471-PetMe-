import java.util.ArrayList;

public abstract class SortingServiceProxy implements SortingIF {
    private SortingIF sortIF;

    public SortingServiceProxy()
    {
        sortIF = new SortingUtil() {
            @Override
            public ArrayList<Product> sort(ArrayList<Product> p) {
                return null;
            }
        };
    }

    @Override
    public ArrayList<Product>sort(ArrayList<Product> products, int sortType) {
        sortIF.sort(products, sortType);
        if (sortType == 1) {
            //sortIF = SortingUtil.bubbleSort;
        }
        return products;
    }
}
