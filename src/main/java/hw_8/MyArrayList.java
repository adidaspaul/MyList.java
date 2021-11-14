package hw_8;

import java.util.Arrays;
import java.util.Objects;
public class MyArrayList {
        static int[] digits = new int [5];
        int size = 0;

/*
Add method;
*/
        public boolean add ( int value){
            if (size == digits.length) {
                resize();
            }
            digits[size] = value;
            size++;
            return true;
        }
 /*
to change the size when adding more elements;
*/
       public void resize() {
            digits = (int[]) Arrays.copyOf(digits, (size * 3 / 2 + 1));
        }
/*
Remove method;
*/
    public int remove(int index){
        Objects.checkIndex(index, size);
        int element = get(index);
        digits[index] = 0;
        for (int i = 0; i < size; i++) {
            digits[i] = digits[i + 1];
        }
        size--;
        return element;
    }
/*
Clear method;
*/
    public void clear() {
        for (int i = 0; i < size; i++) {
            digits[i] = 0;
        }
        size = 0;
    }
/*
Size method;
*/
    public int size(){
        return size;
    }
/*
Get method;
*/
    public int get(int index){
        Objects.checkIndex(index,size);
        return digits[index];
    }

}
