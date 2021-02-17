import java.util.*;
import java.util.ArrayList;

public class SortingUtil implements SortingIF
{
    public static SortingIF bubbleSort;

    public SortingUtil()
    {

    }

    public void bubblesort(ArrayList<Product>products)
    {
        int n=products.size();
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(products.get(j) > products.get(j + 1)){
                    Product temp=products.get(j);
                    products.set(j,products.get(j+1));
                    products.set(j+1,temp);
                }
            }
        }
    }
    public void sort(List<Product>p){
        quickSort(p,0,p.size()-1);
    }
    private void quickSort(List<Product>p,int first,int last){
        if(first<last){
            int pivIndex=partition(p,first,last);
            quickSort(p,first,pivIndex-1);
            quickSort(p,pivIndex+1,last);

        }
    }
    private int partition(List<Product>p,int first,int last){
        sortMid(p,first,last);
        swap(p,first,(first+last)/2);
        Product pivot=p.get(first);
        int head=first;
        int tail=last;
        while(head<tail){
            while(head<last&&pivot.getID()>=p.get(head).getID()){
                head++;
            }
            while(pivot.getID()<p.get(tail).getID()){
                tail--;
            }
            if(head<tail){
                swap(p,head,tail);
            }
        }
        swap(p,first,tail);
        return tail;
    }
    private void sortMid(List<Product>p,int first,int last){
        int mid=(first+last)/2;
        if(p.get(mid).getID()<p.get(first).getID()){
            swap(p,first,mid);
        }
        if (p.get(last).getID()<p.get(mid).getID()){
            swap(p,mid,last);
        }
        if(p.get(mid).getID()<p.get(first).getID()){
            swap(p,first,mid);
        }
    }
    private void swap(List<Product>p, int index1,int index2){
        Product temp=p.get(index1);
        p.set(index1,p.get(index2));
        p.set(index2,temp);
    }




}
