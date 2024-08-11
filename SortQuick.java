import java.util.Random;
public class SortQuick {
    public static void main(String []args) {
        int [] array = new int [10];
        Random r = new Random();
        for(int i=0; i<array.length; i++) {
            array[i] = r.nextInt(100);
        }
        System.out.println("Unsorted array: ");
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        quicksort(array, 0, array.length - 1);
        System.out.println("Sorted array: ");
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void quicksort(int [] array, int low, int high) {
        if (low < high) {
            int p = partition(array, low, high);
            quicksort(array, low, p - 1);
            quicksort(array, p + 1, high);
        }
    }

    public static int partition(int [] a, int low, int high) {
        int p = a[low];
        int i = low+1;
        int j = high;
        while(true) {
            while(i<=j && a[i] <= p)
                i++;
            while(j>=i && a[j] >= p)
                j--;
            if(i>j)
                break;
            swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }

    public static void swap(int [] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}