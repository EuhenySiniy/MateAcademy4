package Lists;

import java.util.Arrays;

public class MyArrayList<E> implements List<E> {
    private int capacity = 10;
    private Object[] array;
    private int indexLastElemet = -1;
    private int size;

    public MyArrayList() {
        array = new Object[capacity];
    }

    public MyArrayList(int size) {
        array = new Object[size];
    }

    @Override
    public void add(E e) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = e;
    }

    @Override
    public void remove(int index) {
        if (index > this.size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        int moved = size - index;
        if (moved > 0) {
            System.arraycopy(array, index, array, index - 1, moved);
        }
        array[size--] = null;
    }

    @Override
    public void clear() {
        for (int j = 0; j < size; j++) {
            array[j] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if (index > this.size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return (E) array[index];
    }
}
