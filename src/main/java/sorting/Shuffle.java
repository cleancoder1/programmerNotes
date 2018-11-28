package sorting;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
 A linear type shuffle program
 Common mistakes is not  swapping 0 to i or i to n-1 and using 0 to n-1
 Online texas poker bug ,where it was predictable after 5 moves , clock syncing,  seed
 */

public class Shuffle {


    public void shuffle(Comparable[] comparables) {
        for (int i = 0; i < comparables.length; i++) {
            int random = StdRandom.uniform(i + 1);
            exchange(comparables, i, random);
        }
    }

    void exchange(Comparable input[], int a, int b) {
        Comparable temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    void show(Comparable[] a) { // Print the array, on a single line.
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }


    public static void main(String[] args) {
        //TODO run the simulation for million experiments and see if it is uniformly shuffled
        Shuffle shuffle = new Shuffle();
        Integer[] a = new Integer[5];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;
        shuffle.shuffle(a);
        shuffle.show(a);

    }


}
