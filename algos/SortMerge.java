import java.util.Random;
class SortMerge {
    public static void main (String [] args) {
        Random r = new Random();
        int [] array   = new int [10];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(100); // random number between 0 and 99
        } 
        System.out.println("Unsorted array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        MergeSort (array, 0, array.length - 1);

        System.out.println("Sorted array: ");
        for(int i=0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void MergeSort(int [] array, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            MergeSort(array, low, middle);
            MergeSort(array, middle + 1, high);
            Merge(array, low, middle, high);
        }
    }

    static void Merge(int [] array, int low, int middle, int high) {
        int [] helper = new int [array.length];
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                array[k] = helper[i];
                i++;
            } else {
                array[k] = helper[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            array[k] = helper[i];
            k++;
            i++;
        }
    }
}