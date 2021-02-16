import java.util.ArrayList;

public class SortingServiceProxy implements SortingIF{
    private Sort sort;
    private SortingIF sortIF;

    public SortingServiceProxy()
    {
        this.sortIF = new SortingUtil();
    }
    enum sortType
    {
        BUBBLESORT,
        QUICKSORT
    }

    public ArrayList<Product>sort(ArrayList<Product>products, sortType sortingAlgorithm)
    {
        sortIF.sort(products, sortingAlgorithm);
        if(sortingAlgorithm == sortType.BUBBLESORT)
        {
            sort = new BubbleSort() {};
        }
        else if (sortingAlgorithm == sortType.QUICKSORT)
        {
            sort = new QuickSort() {};
        }
        return products;
    }
}
