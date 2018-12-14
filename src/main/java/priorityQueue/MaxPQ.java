package priorityQueue;


import sorting.Sort;

/*
 *  Ordered array
 *  Unordered array
 *  Binary Heap implementation
 * */
public class MaxPQ<Key extends Comparable<Key>> extends Sort {


    //sorted array
    private Key[] sortedArray;
    int size = 0;

    public MaxPQ(int n) {
        //generic array creation is not allowed, the cast is guaranteed to pass
        //noinspection unchecked
        sortedArray = (Key[]) new Comparable[n];
    }

    void insert(Key v) {

        //basic insertion sort ,in a sorted array how do you place the new element
        size++;
        sortedArray[size - 1] = v;
        for (int i = size - 1; i > 0 && less(sortedArray[i], sortedArray[i - 1]); i--) {
            exchange(sortedArray, i, i - 1);
        }

    }

    Key max() {
        return sortedArray[size - 1];

    }

    Key delMax() {

        Key result = sortedArray[size - 1];
        sortedArray[size - 1] = null; //avoid loitering
        size--;
        return result;

    }

    boolean isEmpty() {
        return size < 0;
    }

    int size() {
        return size;
    }

    public static void main(String[] args) {

        MaxPQ<String> strings = new MaxPQ<>(5);
        strings.insert("a");
        strings.insert("e");
        strings.insert("b");
//        strings.insert("c");
        strings.insert("d");
        strings.insert("s");
        strings.insert("r");


        String max = strings.max();
        System.out.println(max);


    }

}
