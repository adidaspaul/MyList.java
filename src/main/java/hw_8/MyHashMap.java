package hw_8;

public class MyHashMap<K, V> {

    private class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;

        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }
        @Override
        public String toString() {
            Node<K, V> temp = this;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.key + " -> " + temp.value + ",");
                temp = temp.next;
            }
            return sb.toString();
        }

    }

    private final int SIZE = 5;

    private Node<K, V> table[];

    public MyHashMap() {
        table = new Node[SIZE];
    }

    public void put(K key, V value) {
        int hash = key.hashCode() % SIZE;
        Node<K, V> node = table[hash];
        if (node == null) {
            table[hash] = new Node<K, V>(key, value);
        } else {
            while (node.next != null) {
                if (node.getKey() == key) {
                    node.setValue(value);
                    return;
                }
                node = node.next;
            }
        }
        if (node.getKey() == key) {
            node.setValue(value);
            return;
        }
        node.next = new Node<K, V>(key, value);
    }

    public V get(K key) {
        int hash = key.hashCode() % SIZE;
        Node<K, V> node = table[hash];
        if (node == null) {
            return null;
        }
        while (node != null) {
            if (node.getKey() == key) {
                return node.getValue();
            }
            node = node.next;
        }
        return null;
    }

    public Node<K, V> remove(K key) {
        int hash = key.hashCode() % SIZE;
        Node<K, V> node = table[hash];
        if (node == null) {
            return null;
        }
        if (node.getKey() == key) {
            table[hash] = node.next;
            node.next = null;
            return node;
        }
        Node<K, V> prev = node;
        node = node.next;
        while (node != null) {
            if (node.getKey() == key) {
                prev.next = node.next;
                node.next = null;
                return node;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            if (table[i] != null) {
                sb.append(i + " " + table[i] + "\n");
            } else {
                sb.append(i + " " + "null" + "\n");
            }
        }

        return sb.toString();
    }
}
