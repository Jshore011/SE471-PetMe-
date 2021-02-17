import java.util.ArrayList;

public class SortingServiceProxy implements SortingIF {
    private SortingIF sortIF;

    public SortingServiceProxy()
    {
        this.sortIF = new SortingUtil();
    }


    public ArrayList<Product>sort(ArrayList<Product>products, int sortType)
    {
    sortIF.sort(products, sortType);
    if(sortType == 1)
    {
       // sortIF = SortingUtil.bubbleSort
    }
    }
}
