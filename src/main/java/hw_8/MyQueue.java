package hw_8;

//create queue
public class MyQueue {
    public static int size;
    public static Object[] queue;
    private static int length;
    private static int MAX_SIZE = Integer.MAX_VALUE;

    public boolean add(Object value) {
        try {
            if (size >= length - 1) {
                grow();
            }
            queue[size] = value;
            size++;
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int size() {

        return size;
    }

    public static Object remove(int index) {
        if (index < 0 || size <= 0) {
            return null;
        }
        Object result = queue[index];
        if (length - index >= 0) System.arraycopy(queue, index + 1, queue, index, length - index - 1);
        size--;
        if (size <= length / 2) {
            grow();
        }
        return result;
    }

    public void clear() {
        this.queue = new Object[10];
        this.length = 10;
        this.size = 0;
    }

    public Object peek() {
        return queue[0];
    }

    public Object poll(){
        Object result;
        result = MyQueue.remove(0);
        size--;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("MyQueue {size=" + size + "; length=" + length + "; ");
        for (int i = 0; i < size; i++) {
            result.append(queue[i].toString());
            result.append(", ");
        }
        result.deleteCharAt(result.length() - 1);
        result.deleteCharAt(result.length() - 1);
        result.append("}");
        return result.toString();
    }

    private static void grow() throws IllegalArgumentException {
        if (size >= MAX_SIZE) {
            throw new IllegalArgumentException("It can't grow anymore.");
        }
        length = size + size / 2 + 1;
        if (length < size) {
            length = MAX_SIZE;
        }
        Object[] newArray = new Object[length];
        System.arraycopy(queue, 0, newArray, 0, size);
        queue = newArray;
    }
}
