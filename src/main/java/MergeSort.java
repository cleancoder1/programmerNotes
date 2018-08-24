/*Divide and Conquer approach*/
public class MergeSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2; //prevents weird overflow bug
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);

    }

    /*   sorted left array [lo,mid]  sorted right array [mid+1,hi] */
    private void merge(Comparable[] a, int lo, int mid, int hi) {
        Comparable aux[] = new Comparable[a.length];
        for (int i1 = lo; i1 <= hi; i1++) {
            aux[i1] = a[i1];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
                continue;
            }

            if (j > hi) {
                a[k] = aux[i++];
                continue;
            }

            if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }

        }


    }
}
