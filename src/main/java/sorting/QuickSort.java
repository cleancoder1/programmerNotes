package sorting;

/*
One of the top 10 Algorithms of 20 th century
Inplace algorithm , with fastest performance, time complexity is  0 nlogn . Used widely .
complementary to merge sort, both rely on divide and conquer approach  ,merge tries to sort two halves and merges them
 */

public class QuickSort extends Sort {


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        Integer[] a = new Integer[5];
        a[0] = 5;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 1;

        quickSort.sort(a);
        quickSort.show(a);
    }


    @Override
    public void sort(Comparable[] a) {

        //shuffle and take first element as partition

        sort(a, 0, a.length - 1);


    }

    private void sort(Comparable[] a, int lo, int hi) {

        if (hi <= lo) { //single element nothing to sort
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);


    }

    // 52341  , 5  2341
    //1 2345
    private int partition(Comparable[] a, int lo, int hi) {
        Comparable partitionElement = a[lo];
        int i = lo;
        int j = hi + 1;


        while (true) {
            //scan right,scan left check for scan complete and exchange.
            while (less(a[++i], partitionElement)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(partitionElement, a[--j])) {
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
