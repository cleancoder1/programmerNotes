package searching;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {


    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value value;         // associated data
        private Node left, right;  // left and right subtrees

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree<String, Integer> st = new BinarySearchTree<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        StdOut.println("last occurrence of E  " + st.get("A"));
    }

    private Value get(Key key) {
        Node x = root;

        while (x != null) {
            int cmp = key.compareTo(x.key);
            System.out.println("value of i" + cmp);
            if (cmp == 0) {
                return x.value;
            } else if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            }

        }
        return null;
    }

    /* if it is there update value or else create a new node
     * We will do recursively */
    private void put(Key key, Value value) {
        root = put(root, key, value);

    }

    private Node put(Node x, Key key, Value value) {

        if (x == null) {
            System.out.println("created a new node" + key + " value " + value);
            return new Node(key, value);
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            System.out.println("Tree is updated with new value for key " + key);

            x.value = value;
        } else if (cmp < 0) {
            System.out.println("Left sub tree needs to be  updated" + key);
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            System.out.println("Right sub tree needs to be  updated" + key);
            x.right = put(x.right, key, value);
        }
        System.out.println("tree is  updated" + key);
        return x; // not sure if this is dead code

    }


}
