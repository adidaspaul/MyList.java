package hw_8;

public class MyArrayList<T> {
    private final int capacity = 10;
    private Object[] digits = new Object[capacity];
    private int size = 0;


    public void resize(int i) {
        Object[] digits1 = new Object[i];
        System.arraycopy(digits, 0, digits1, 0, size);
        digits = digits1;
    }

    public boolean add(T value) {
        if (size == digits.length - 1) {
            resize(digits.length * 2);
        }
        digits[size++] = value;
        return true;
    }

    public void remove(int index) {
        int i = 0;
        while (i < size) {
            digits[i] = digits[i + 1];
            i++;
        }
        digits[size] = null;
        size--;
        if (digits.length > capacity && size < digits.length / 4) {
            resize(digits.length / 2);
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            digits[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException
                ("This Index is out of bounds of the current size " + size);
        return (T) digits[index];
    }

}
