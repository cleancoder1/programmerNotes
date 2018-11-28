package sorting;

/*
A divide and conquer approach,
Performance is nlogn.
Additional Memory cost , not an inplace one like insertion sort
 */

public class MergeSort extends Sort {

    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    /*Given two sorted array from lo -mid inclusive , mid+1,hi  inclusive  how to do merge*/
    /* copy the array into aux from lo - hi ,  */
    private void merge(Comparable[] a, int lo, int mid, int hi) {

        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        /* maintain two pointer one for first sorted array , other for second sorted array */
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            /* left array is exhausted , copy all the right array elements */
            if (i > mid) {
                a[k] = aux[j++];
            }
            /* right array is exhausted, copy all the left array elements */
            else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }

        }
    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        Integer[] a = new Integer[5];
        a[0] = 5;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 1;

        mergeSort.sort(a);
        mergeSort.show(a);
    }


}
