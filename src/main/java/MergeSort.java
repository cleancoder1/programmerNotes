import java.util.ArrayList;

/*Divide and Conquer approach*/
public class MergeSort extends Sort {
    @Override
    public void sort(Comparable[] a) {

        int lo = 0;
        int hi = a.length - 1;

        sort(a, lo, hi);

    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        System.out.println("sort(a," + lo + "," + mid + ")");
        sort(a, lo, mid);
        int x = mid + 1;
        System.out.println("sort(a," + x + "," + hi + ")");
        sort(a, mid + 1, hi);
        System.out.println("merge(a," + lo + "," + mid + "," + hi + ")");

        merge(a, lo, mid, hi);

    }

    /* assume in this array left half is already sorted , right half is already sorted , we are making the array sorted

     */
    private void merge(Comparable[] a, int lo, int mid, int hi) {
        Comparable aux[] = new Comparable[a.length];
        for (int i1 = lo; i1 <= hi; i1++) {
            aux[i1] = a[i1];
            if (i1 != hi) {
                System.out.print(aux[i1] + ",");
            } else {
                System.out.print(aux[i1]);
                System.out.println();
            }

        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j];
                j++;
                continue;
            }

            if (j > hi) {
                a[k] = aux[i];
                i++;
                continue;
            }

            if (less(aux[i], aux[j])) {
                a[k] = aux[i];
                i++;
            } else {
                a[k] = aux[j];
                j++;
            }


        }
        System.out.println("after merge");
        for (int i1 = lo; i1 <= hi; i1++) {
            if (i1 != hi) {
                System.out.print(a[i1] + ",");
            } else {
                System.out.print(a[i1]);
                System.out.println();
            }

        }


    }
}
