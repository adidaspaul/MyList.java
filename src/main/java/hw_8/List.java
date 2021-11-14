package hw_8;

public abstract class List {

    boolean add(Object value){

        return false;
    }
     abstract Object remove(int index);

    abstract void clear();
    abstract int size();
    abstract Object get(int index);
}
