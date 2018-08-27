public class QuickSort extends Sort {


    @Override
    public void sort(Comparable[] a) {

        sort(a, 0, a.length - 1);

    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j);
        sort(a, j + 1, hi);

    }

    private int partition(Comparable[] a, int lo, int hi) {
        Comparable pivot = a[lo];
        int i = lo;
        int j = hi + 1;

        while (true) {
            //increment i count until it is greater than pivot
            while (less(a[++i], pivot)) {
                System.out.println(i);
                if (i == hi) {
                    break;
                }
            }
            //decrement j count until it is less than pivot
            while (less(pivot, a[--j])) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            exchange(a, i, j);


        }
        exchange(a, lo, j);

        return j;
    }
}
