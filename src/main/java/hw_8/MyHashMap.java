package hw_8;

public class MyHashMap<K, V> {

    private static final int CAPACITY = 10;
    private int size;
    private Node<K, V>[] table;

    static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;
        private int hashCode;

        public Node(K key, V value, int hashCode, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
            this.next = next;
        }

        public K getKey() {

            return this.key;
        }

        public V getValue() {

            return this.value;
        }

        public V setValue(V value) {
            this.value = value;
            return value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

    }

    public MyHashMap() {
        table = new Node[CAPACITY];
    }

    public int hash(Object key) {
        return key == null ? 0 : key.hashCode() >>> 10;
    }

    public int lookIndex(int hashCode) {
        int index = Math.abs(hashCode) % CAPACITY;
        return index;
    }


    public V put(K key, V value) {
        int hashCode = hash(key);
        int index = lookIndex(hashCode);
        Node<K, V> node = table[index];
        if (node == null) {
            table[index] = new Node(key, value, hashCode, null);
        } else {
            for (Node<K, V> n = node; n != null; n = n.next) {
                K nodeKey = n.getKey();
                if ((key == null && null == nodeKey) || (key != null && key.equals(nodeKey))) {
                    V oldValue = n.getValue();
                    n.setValue(value);
                    return oldValue;
                }
                if (n.next == null) {
                    n.next = new Node<>(key, value, hashCode, null);
                    break;
                }
            }
        }
        size++;
        return null;
    }

    public int size() {
        return size;
    }

    public V remove(K key) {
        if (size > 0) {
            Node<K, V> first, n;
            K k;
            int i = getIndex(key), hash = hash(key);
            if ((first = table[i]) != null) {
                if ((k = (K) first.key) == key || k.equals(key) && hash == first.hashCode) {
                    table[i] = first.next;
                    size--;
                    return first.value == null ? null : (V) first.value;
                }
                if (first.next != null) {
                    for (n = first.next; n != null; n = n.next, first = first.next) {
                        if ((k = (K) n.key) == key || k.equals(key) && hash == n.hashCode) {
                            first.next = n.next;
                            size--;
                            return n.value == null ? null : (V) n.value;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void clear() {
        table = new Node[CAPACITY];
        size = 0;
    }

    public V get(Object key) {
        int index = lookIndex(hash(key));
        Node<K, V> node = table[index];
        for (Node<K, V> n = node; n != null; n = n.next) {
            if ((key == null && null == n.getKey()) || (key != null && key.equals(n.getKey()))) {
                return n.value;
            }
        }
        return null;
    }

    public int getIndex(K key) {
        if (key == null) {
            return 0;
        }
        int hash = hash(key);
        return ((table.length - 1) & hash);
    }


}
