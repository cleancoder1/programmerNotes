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

}
