package elementarySorts;

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



}
