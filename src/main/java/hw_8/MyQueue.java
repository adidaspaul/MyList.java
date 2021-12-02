package hw_8;

public class MyQueue<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return String.valueOf(item);
        }
    }

    public void add(E value) {
        Node<E> l = last;
        Node<E> newNode = new MyQueue.Node<>(value, null, l);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Provided index is out of bounds of the size " + size);
        }
        Node<E> previous = null;
        Node<E> nextious = null;
        Node<E> look = first;
        if (index == 0) {
            first = look.next;
        } else if (index == size - 1) {
            last = look.prev;
        } else {
            int counter = 0;
            while (counter <= index + 1) {
                if (counter == index - 1) {
                    previous = look;
                }
                if (counter == index + 1) {
                    nextious = look;
                }
                look = look.next;
                counter++;
            }
            previous.next = nextious;
            nextious.prev = previous;
        }
        size--;
        if (size == 0) {
            first = null;
            last = null;
        }
    }

    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    public int size() {
        return size;
    }

    public E peek(){
        return first.item;
    }

    public E poll(){
        if(size == 0){
            return null;
        }
        Node<E> newFirst = first.next;
        Node<E> removable = first;
        first = newFirst;
        size--;
        if(size == 0){
            last = null;
        }
        return removable.item;
    }

}
