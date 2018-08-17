public class InsertionSort extends Sort {


    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {

            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                //you need to put a[i] in correct order  from a left sorted array
                exchange(a, j, j - 1);
            }
        }
    }

}
