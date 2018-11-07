package elementarySorts;

/*
 n^2/4 compares and exchanges on typical
 Faster in a partially sorted array, almost linear performance for best case performance
 Worst case performance for a reverse sorted array

 */

public class InsertionSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
//                if (less(a[j], a[j - 1])) { //inversion
                    exchange(a, j, j - 1);
//                } else {
//                    break;
//                }
            }

        }

    }


    public static void main(String[] args) {
        Integer[] a = new Integer[5];
        a[0] = 5;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 1;

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(a);
        boolean result = insertionSort.isSorted(a);
        System.out.println("the array is sorted " + result);
        insertionSort.show(a);
    }

}
