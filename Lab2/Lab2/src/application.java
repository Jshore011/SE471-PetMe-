//main
import java.util.*;

public class application
{
    public static void main(String[] args) {

        //create Arraylist and add products to it
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product("Pencil", 25, 1.50));
        products.add(new Product("Backpack", 12, 25.00));
        products.add(new Product("notebook", 5, 5.25 ));
        products.add(new Product("Eraser", 7, 0.50));
        products.add(new Product("Ruler", 2, 1.00));
        products.add(new Product("Binder", 17, 9.99));
        products.add(new Product("Pen", 9, 2.50));
        products.add(new Product("Water", 3, 3.25));



    }
}
