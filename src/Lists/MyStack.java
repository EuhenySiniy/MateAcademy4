package Lists;

import java.util.Arrays;

public class MyStack<E> {
    private int size;
    private Object[] array;

    MyStack(int capacity) {
        array = new Object[capacity];
    }

    public void push(E item) {
        if (size == 0) {
            array = Arrays.copyOf(array, 1);
        }
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }

        array[size++] = item;
    }

    public void remove() {
        array = Arrays.copyOf(array, --size);
    }

    public void clear() {
        array = Arrays.copyOf(array, 0);
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return (E) array[size - 1];
    }

    public E pop() {
        E upperArray = (E) array[size - 1];
        array = Arrays.copyOf(array, --size);
        return upperArray;
    }
}
