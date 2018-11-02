import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedListStack<E> implements Iterable<E> {

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


    @Override
    public Iterator<E> iterator() {
        return new LinkedListStackIterator<>();
    }

    private class LinkedListStackIterator<E> implements Iterator<E> {
        Node headCopy;

        public LinkedListStackIterator() {
            headCopy = head;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }

        @Override
        public boolean hasNext() {
            return headCopy != null;
        }

        @Override
        public E next() {
            E element = (E) headCopy.e;
            headCopy = headCopy.next;
            return element;
        }
    }
}
