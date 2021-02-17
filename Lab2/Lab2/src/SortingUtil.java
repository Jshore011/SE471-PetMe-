import java.util.ArrayList;

public abstract class SortingUtil implements SortingIF
{
    //public static SortingUtil.SortingIF bubbleSort;

    public SortingUtil()
    {

    }

    public void bubblesort(ArrayList<Product>products)
    {
        int n=products.size();
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(products.get(j).getProdID() > products.get(j + 1).getProdID()){
                    Product temp=products.get(j);
                    products.set(j,products.get(j+1));
                    products.set(j+1,temp);
                }
            }
        }
    }
    @Override
    public ArrayList<Product>sort(ArrayList<Product>p, int t){
        quickSort(p,0,p.size()-1);
        return p;
    }
    private void quickSort(ArrayList<Product>p,int first,int last){
        if(first<last){
            int pivIndex=partition(p,first,last);
            quickSort(p,first,pivIndex-1);
            quickSort(p,pivIndex+1,last);

        }
    }
    private int partition(ArrayList<Product>p,int first,int last){
        sortMid(p,first,last);
        swap(p,first,(first+last)/2);
        Product pivot=p.get(first);
        int head=first;
        int tail=last;
        while(head<tail){
            while(head<last&&pivot.getProdID()>=p.get(head).getProdID()){
                head++;
            }
            while(pivot.getProdID()<p.get(tail).getProdID()){
                tail--;
            }
            if(head<tail){
                swap(p,head,tail);
            }
        }
        swap(p,first,tail);
        return tail;
    }
    private void sortMid(ArrayList<Product>p,int first,int last){
        int mid=(first+last)/2;
        if(p.get(mid).getProdID()<p.get(first).getProdID()){
            swap(p,first,mid);
        }
        if (p.get(last).getProdID()<p.get(mid).getProdID()){
            swap(p,mid,last);
        }
        if(p.get(mid).getProdID()<p.get(first).getProdID()){
            swap(p,first,mid);
        }
    }
    private void swap(ArrayList<Product>p, int index1,int index2){
        Product temp=p.get(index1);
        p.set(index1,p.get(index2));
        p.set(index2,temp);
    }

}
