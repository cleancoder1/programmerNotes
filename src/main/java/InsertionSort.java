public class InsertionSort {

    public void sort(Integer[] a) {
        for (int i = 1; i < a.length; i++) {

            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                //you need to put a[i] in correct order  from a left sorted array
                exchange(a, j, j - 1);
            }


        }
    }

    private void exchange(Comparable input[], int a, int b) {
        Comparable temp = input[a];
        input[a] = input[b];
        input[b] = temp;

    }

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
