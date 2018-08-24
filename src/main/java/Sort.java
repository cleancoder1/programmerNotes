import edu.princeton.cs.algs4.StdOut;

public abstract class Sort {

    public abstract void sort(Comparable a[]);


    protected void exchange(Comparable input[], int a, int b) {
        Comparable temp = input[a];
        input[a] = input[b];
        input[b] = temp;

    }

    protected boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public boolean isSorted(Comparable[] a) { // Test whether the array entries are in order.
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public void show(Comparable[] a) { // Print the array, on a single line.
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

}
