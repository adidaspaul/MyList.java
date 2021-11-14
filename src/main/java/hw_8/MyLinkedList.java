package hw_8;

public class MyLinkedList extends List {

    private static class Node {
        Node previous;
        Object element;
        Node next;

        public Node(Node previous, Object element, Node next) {

            this.previous = previous;
            this.element = element;
            this.next = next;
        }
    }

    private int currentSize = 0;
    private Node currentHeadNode = null;
    private Node currentTailNode = null;

    public MyLinkedList() {
        currentHeadNode = new Node(null, null, null);
        currentTailNode = new Node(null, null, null);
    }
private Node nodeSearching(int index){
        return index > currentSize / 2 ? fromTailNodeSearching(index) : fromHeadNodeSearching(index);
}
private Node fromTailNodeSearching(int index) throws IllegalArgumentException {
        if (index > currentSize || index < 0){
            throw new IllegalArgumentException("Index out of list's bounds" + index);
        } else {
            Node searchingNode = currentTailNode;
            for(int i = currentSize - 1; i > index - 1; i--){
                searchingNode = searchingNode.previous;
            }
            return searchingNode;
        }
}
private Node fromHeadNodeSearching(int index) throws IllegalArgumentException {
        if (index > currentSize || index < 0){
            throw new IllegalArgumentException("Index is out of list's bounds" + index);
        }else {
            Node searchingNode = currentHeadNode;
            for(int i = 0; i < index; i++){
                searchingNode = searchingNode.next;
            }
            return searchingNode;
        }
}
    @Override
    boolean add(Object value) {
        if (value != null) {
            if (currentSize == 0) {
                Node newNode = new Node(null, value, null);
                currentHeadNode = newNode;
                currentTailNode = newNode;
            } else if (currentSize == 1) {
                currentTailNode = new Node(this.currentHeadNode, value, null);
            } else {
                currentTailNode = new Node(this.currentTailNode, value, null);
            }
            currentSize++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    Object remove(int index) throws IllegalArgumentException {
        if(index > currentSize || index < 0){
            throw new IllegalArgumentException("Index is out of list's bounds");
        }
        Object result;
        if(currentSize == 1){
            result = currentTailNode.element;
            new MyLinkedList();
        } else {
            Node removingNode = nodeSearching(index);
            result = removingNode.element;
            removingNode.previous.next = removingNode.next;
            removingNode.next.previous = removingNode.previous;
            currentSize--;
        }
        return result;
    }

    @Override
    void clear() {
currentHeadNode = new Node(null, null, null);
currentTailNode = new Node(null, null, null);
currentSize = 0;
    }

    @Override
    int size() {
        return currentSize;
    }

    @Override
    Object get(int index) {
        return nodeSearching(index).element;
    }
@Override
    public String toString(){
Node bufferNode = currentHeadNode;
StringBuilder result = new StringBuilder("MyLinkedList {size=" + currentSize + "; ");
for(int i = 0; i < currentSize; i++);{
    if(bufferNode.element != null){
        result.append(bufferNode.element.toString());
        result.append(", ");
        bufferNode = bufferNode.next;
    }
    }
    result.deleteCharAt(result.length() - 1);
        result.deleteCharAt(result.length() - 1);
        result.append("}");
        return result.toString();
}
}
