import java.util.Iterator;
import java.util.function.Consumer;

/*Stack implementation using dynamically growing array */
public class MyStack<E> implements Iterable<E> {

    private E[] elements = (E[]) new Object[1];
    int n;

    public void push(E element) {
        if (n == elements.length) {
            resize();
        }
        elements[n++] = element;

    }

    private void resize() {
        E[] resizedArray = (E[]) new Object[elements.length * 2];
        for (int i = 0; i < n; i++) {
            resizedArray[i] = elements[i];
        }
        elements = resizedArray;
    }

    public E pop() {
        if (n == elements.length / 4) {
            shrink();
        }

        E element = elements[--n]; //pre decrement n
        elements[n] = null; // this is still confusing to me visualize , avoids loitering
        return element;
    }

    private void shrink() {
        E[] resizedArray = (E[]) new Object[elements.length / 2];
        for (int i = 0; i < n; i++) {
            resizedArray[i] = elements[i];
        }
        elements = resizedArray;


    }

    public int size() {
        return n;
    }


    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {
        @Override
        public boolean hasNext() {
            return n > 0;
        }

        @Override
        public E next() {
            return pop();
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }
}
