package sorting;

/* Takes ~ n^2 /2 compares and n exchanges

   No movement in left side of pointer after it is sorted
   Visual trace of algorithm

 */

public class SelectionSort extends Sort {


    public void sort(Comparable[] comparables) {
        for (int i = 0; i < comparables.length; i++) {
            int min = i;

            for (int j = i + 1; j < comparables.length; j++) {
                if (less(comparables[j], comparables[min])) {
                    min = j;
                }
            }

            exchange(comparables, i, min);
        }

    }



    public static void main(String[] args) {
        Integer[] a = new Integer[5];
        a[0] = 5;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 1;

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(a);
        boolean result = selectionSort.isSorted(a);
        System.out.println("the array is sorted " + result);

    }
}
