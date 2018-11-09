package unionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UnionFind {
    private int[] id;
    int size;


    UnionFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        size = n;

    }

    void union(int p, int q) {
        int rootOfp = root(p);
        int rootOfq = root(q);

        if (rootOfp == rootOfq) {
            return; // they are already in the same connected component
        }

        id[rootOfp] = rootOfq;
        size--;
    }

    int count() {
        return size;
    }


    int find(int p) {
        return root(p);
    }


    int root(int p) {
        //chase the pointer
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }


    boolean connected(int p, int q) {
        return root(p) == root(q);
    }


    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();

        int N = StdIn.readInt();
        UnionFind uf = new UnionFind(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);

        }

        LocalDateTime end = LocalDateTime.now();

        StdOut.println(uf.count() + " components");
        StdOut.println("time spent is " + ChronoUnit.MILLIS.between(start, end) / 1000.0 + " seconds");
    }


}
