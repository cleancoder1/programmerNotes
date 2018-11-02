public class LinkedListStack<E> {

    Node head;
    int n;

    /* add an element from beginning of the linked list */
    public void push(E element) {
        Node oldFirst = head;
        head = new Node();
        head.e = element;
        head.next = oldFirst;
        n++;
    }

    /* remove an element from beginning of the linked list */
    public E pop() {

        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        E element = head.e;
        head = head.next;
        n--;
        return element;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return head == null;
    }


    private class Node {
        Node next;
        E e;
    }
}
