package elementarySorts;

/*
One of the top 10 alogithms of 20 th century
Inplace algorithm , with fastest perfomrance, time complexity is  0 nlogn . Used widely .
complemantary to merge sort, both rely on recursion to  ,merge tries to sort two halves and merges them
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

        sort(a, 0, a.length-1);


    }

    private void sort(Comparable[] a, int lo, int hi) {

        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j,hi);


    }

    private int partition(Comparable[] a, int lo, int hi) {
        Comparable  partitionElement = a[lo];
        int i= lo+1;
        int j= hi;


        while(i<j){ //you need to do until the pointers cross
            while(less(partitionElement,a[i])){
                i++;
            }
            while(less(a[j],partitionElement) ){
                if(j <= lo+1){
                    break;
                }
                j--;
            }
            exchange(a,i,j);
        }
        exchange(a,lo,j);
        return j;
    }
}
