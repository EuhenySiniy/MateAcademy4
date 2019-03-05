package Lists;

public class MyLinkedList<E> implements List<E> {

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private int size;
    private Node<E> first;
    private Node<E> last;

    @Override
    public void add(E e) {
        Node<E> node;
        if (size == 0) {
            node = new Node<>(null, e, null);
            first = node;
            last = node;
        } else {
            node = new Node<>(last, e, null);
            last.prev = node;
            last = node;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        Node<E> node = first;
        for (int j = 0; j < index; j++) {
            node = node.next;
        }

        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (node.prev == null) {
            prev = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (node.next == null) {
            next = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        size--;
    }

    @Override
    public void clear() {
        Node<E> node = first;

        do {
            Node<E> next = node.next;
            node.item = null;
            node.next = null;
            node.prev = null;
            node = next;
        } while (node != null);

        first = last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        Node<E> element = first;
        for (int j = 0; j < index; j++) {
            element = element.next;
        }
        return element.item;
    }
}
