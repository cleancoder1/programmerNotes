/*Dynamically*/
public class MyStack<E> {

    private E[] elements = (E[]) new Object[1];
    int n;

    public void push(E element) {
        if (n == elements.length) {
            resize();
        }
        elements[n++] = element;
        System.out.println("value of n " + n);

    }

    private void resize() {
        System.out.println("i have resized , my internal array size is " + elements.length * 2);

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
        elements[n] = null; // this is still confusing to me visualize ,
        return element;
    }

    private void shrink() {
        System.out.println("i have shrunk, my internal array size is " + elements.length / 2);
        E[] resizedArray = (E[]) new Object[elements.length / 2];
        for (int i = 0; i < n; i++) {
            resizedArray[i] = elements[i];
        }
        elements = resizedArray;


    }

    public int size() {
        return n;
    }
}
