package hw_8;

public class MyStack {
    public int length;
    int top = 0;
    public static Object[] stack;

    public void push(Object value) {
        stack[top] = value;
        top++;
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top <= 0;
    }

    public Object pop() {
        Object value = null;
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            top--;
            value = stack[top];
            stack[top] = 0;
        }
        return value;
    }

    public Object peek() {
        Object value = stack[top - 1];
        return value;
    }

    public void remove(int index) {
        try {
            int numMoved = top - index - 1;
            System.arraycopy(stack, index + 1, stack, index, numMoved);
            stack[--top] = null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Unable to remove element at index - " + index +
                    ". Index out of bounds or stack is empty.");
        }
    }

    public void clear() {
        for (int i = 0; i < top; i++) {
            stack[i] = 0;
        }
        top = 0;
    }
}

