public class main {
    public static void main(String[] args) {
        int[] x = {-10, -9, 0, 99, 100};
        int count = 0;
        for (int i =0; i < x.length; i++) {
            if (x[i]%2==1) {
                count++;
            }
        }

        System.out.println(count);
    }
}
/*
    public static int odd(int[] x) {
// Effects: if x==null throw NullPointerException,
// else return the number of elements in x that are odd
        int count = 0;
        for (int i =0; i < x.length; i++) {
            if (x[i]%2==1) {
                count++;
            }
        }
        return count;
    }
}
*/