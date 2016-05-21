public class HashMap {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private HashEntry[] table;
    private int size;
    private int initialCapacity;
    private double loadFactor;

    public HashMap() {
        this.size = 0;
        this.initialCapacity = DEFAULT_INITIAL_CAPACITY;
        this.loadFactor = DEFAULT_LOAD_FACTOR;

        table = new HashEntry[DEFAULT_INITIAL_CAPACITY];
        for (HashEntry he : table) {
            he = null;
        }
    }

    public HashMap(int initCapacity, double loadFactor) {
        this.size = 0;
        this.initialCapacity = initCapacity;
        this.loadFactor = loadFactor;

        table = new HashEntry[initCapacity];
        for (HashEntry he : table) {
            he = null;
        }
    }

    private int hash(int h) {
        // Defends against poorly implemented hash functions
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private static int indexFor(int h, int length) {
        return h & (length-1);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

//    public boolean containsKey(Object key) {
//        return false;
//    }
//
//    public boolean containsValue(Object value) {
//        return false;
//    }

    public Object get(Object key) {

        //Returns the 0 indexed element when key is null
        if(key == null) {
            return table[0].value;
        }
        int index = indexFor(hash(key.hashCode()), size);
        if (table[index].key == key) {
            return table[index].value;
        } else {
            HashEntry linkedEntry = table[index].next;
            while (linkedEntry != null) {
                if (linkedEntry.key == key) {
                    return linkedEntry.value;
                } else {
                    linkedEntry = linkedEntry.next;
                }
            }
        }
        return null;
    }

    public Object put(Object key, Object value) {

        int index = indexFor(hash(key.hashCode()), size);
        HashEntry hashEntry = new HashEntry(key, value);
        Object previousValue = null;
        if (table[index] == null) {
            table[index] = hashEntry;
        } else {
            HashEntry linkedEntry = table[index];
            while (linkedEntry.next != null) {
                if (linkedEntry.key == key) {
                    previousValue = linkedEntry.value;
                    linkedEntry.value = value;
                    break;
                } else {
                    linkedEntry = linkedEntry.next;
                }
            }
            if (linkedEntry.next == null) {
                if (linkedEntry.key != key) {
                    linkedEntry.next = hashEntry;
                }
            }
        }
        return previousValue;
    }
//
//    @Override
//    public Object remove(Object key) {
//        return null;
//    }
//
//    @Override
//    public void putAll(Map m) {
//
//    }
//
//    @Override
//    public void clear() {
//
//    }
//
//    @Override
//    public Set keySet() {
//        return null;
//    }
//
//    @Override
//    public Collection values() {
//        return null;
//    }
//
//    @Override
//    public Set<Entry> entrySet() {
//        return null;
//    }

    private class HashEntry {
        Object key;
        Object value;
        HashEntry next = null;

        public HashEntry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
