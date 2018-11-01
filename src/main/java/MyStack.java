import java.util.Iterator;
import java.util.function.Consumer;

/*Stack implementation using dynamically growing array */
public class MyStack<E> implements Iterable<E> {

    private E[] elements = (E[]) new Object[1];
    private int n;

    public void push(E element) {
        if (n == elements.length) {
            resize(elements.length * 2);
        }
        elements[n++] = element;

    }

    private void resize(int capacity) {
        E[] resizedArray = (E[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            resizedArray[i] = elements[i];
        }
        elements = resizedArray;
    }

    public E pop() {

        E element = elements[--n]; //pre decrement n
        elements[n] = null; // this is still confusing to me visualize , avoids loitering

        if (n > 0 && n == elements.length / 4) {
            resize(elements.length / 2);
        }
        return element;
    }

    public int size() {
        return n;
    }


    @Override
    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<E> {

        private int current;

        public ReverseArrayIterator() {
            current = n;
        }

        @Override
        public boolean hasNext() {
            return current > 0;
        }

        @Override
        public E next() {
            return elements[--current];
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }
}
