package task9;

public class MyHashMap<K, V> {
    private int capacity = 15;
    private Entry<K, V>[] table;
    private int counter = 0;

    public MyHashMap(){
        table = new Entry[capacity];
    }
    public MyHashMap(int capacity){
        this.capacity = capacity;
        table = new Entry[capacity];
    }
    public class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;
        public Entry(K key, V value, Entry<K, V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public K getKey() {
            return key;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
        public Entry getNext() {
            return next;
        }
        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }
    private int index(K key){
        if(key == null){
            return 0;
        }
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(Object key, Object value){
        int index = index((K) key);
        Entry newEntry = new Entry(key, value, null);
        if(table[index] == null){
            table[index] = newEntry;
        }else {
            Entry<K, V> previousNode = null;
            Entry<K, V> currentNode = table[index];
            while(currentNode != null){
                if(currentNode.getKey().equals(key)){
                    currentNode.setValue((V) value);
                    counter--;
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            if(previousNode != null) {
                previousNode.setNext(newEntry);
                counter--;
            }
        }
        counter++;
    }
    public void remove(Object key){
        int index = index((K) key);
        Entry previous = null;
        Entry entry = table[index];
        while (entry != null){
            if(entry.getKey().equals(key)){
                if(previous == null){
                    entry = entry.getNext();
                    table[index] = entry;
                    return;
                }else {
                    previous.setNext(entry.getNext());
                    return;
                }
            }
            previous = entry;
            entry = entry.getNext();
        }
    }
    public void clear() {
        table = new Entry[capacity];
        counter = 0;
    }
    public int size() {
        return counter;
    }
    public V get(Object key){
        V value = null;
        int index = index((K) key);
        Entry<K, V> entry = table[index];
        while (entry != null){
            if(entry.getKey().equals(key)) {
                value = entry.getValue();
                break;
            }
            entry = entry.getNext();
        }
        return value;
    }
}
