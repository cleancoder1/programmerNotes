import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class WeightUF {

    private int[] parent;
    private int[] size;
    int count;


    WeightUF(int n) {
        parent = new int[n];
        size = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = i;
        }

    }

    void union(int p, int q) {
        int rootOfp = root(p);
        int rootOfq = root(q);

        if (rootOfp == rootOfq) {
            return; // they are already in the same connected component
        }
        if (size[rootOfp] < size[rootOfq]) {
            //p is smaller tree, make it to attach to larger tree
            parent[rootOfp] = rootOfq;
            size[q] = size[p] + size[q];
        } else {
            parent[rootOfq] = rootOfp;
            size[p] = size[p] + size[q];
        }

        count--;
    }

    int count() {
        return count;
    }


    int find(int p) {
        return root(p);
    }


    int root(int p) {
        //chase the pointer
        while (p != parent[p]) {
            p = parent[p];
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
        StdOut.println(uf.count() + " components");
        LocalDateTime end = LocalDateTime.now();

        StdOut.println("time spent is " + ChronoUnit.MILLIS.between(start, end) / 1000.0 + " seconds");
    }

}
