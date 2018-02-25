package ua.goit.java8.module6.collections;


import java.util.Objects;

/**
 * Created by t.oleksiv on 21/08/2017.
 */
public class MyHashMap<K,V> {
    static final int MAXIMUM_CAPACITY = 100;        // limited table size

    private NodeMap<K,V>[] table;
    private int size;

    public MyHashMap(){
        table = new NodeMap[MAXIMUM_CAPACITY];
        size = 0;
    }

    private int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int indexFor(int h, int length) {
        return h & (length - 1);
    }

    private void addEntry(int hash, K key, V value, int index) {
        boolean found = false;
        NodeMap<K, V> e = table[index];

        while (e != null){
            if (replace(hash, key, value, e)) {
                found = true;
                break;
            }
            e = e.next;
        }

        if (!found) {
            e = table[index];
            table[index] = new NodeMap<K, V>(hash, key, value, e);
            size++;
        }

    }

    private boolean replace(int hash, K key, V value, NodeMap<K,V> e){
        if (e.hash == hash && (e.key == key || key.equals(e.key))) {
            e.value = value;
            return true;
        }
        return false;
    }

    private V getValue(int hash, K key, NodeMap<K,V> e){
        if (e != null && e.hash == hash && (e.key == key || key.equals(e.key))) {
            return e.value;
        }
        return null;
    }

    // methods

    // print hashmap
    public void print() {
        for (int i = 0; i < table.length; i++){
            NodeMap<K,V> iterator = table[i];
            if (iterator == null) continue;
            do {
                System.out.print("" + iterator.key + ":" + iterator.value + " ");
                iterator = iterator.next;
            } while (iterator != null);
        }
        System.out.println();
    }

    // add <key,value>
    public void put(K key, V value){
        int index;
        int hash;
        hash = hash(Objects.hashCode(key));
        index = indexFor(hash,MAXIMUM_CAPACITY);
        addEntry(hash,key,value,index);
    }

    // remove element by key
    public void remove(K key){
        int index;
        int hash;
        hash = hash(Objects.hashCode(key));
        index = indexFor(hash,MAXIMUM_CAPACITY);
        NodeMap<K,V> nodeMap = getNodeMap(key);
        NodeMap<K,V> nodeMapPrevious = getPreviousNodeMap(key);
        if (nodeMapPrevious != null) nodeMapPrevious.next = nodeMap.next;
        if (table[index] == nodeMap){
            table[index] = null;
        }
        nodeMap = null;
        size--;
    }

    public void clear() {
        NodeMap<K,V>[] tab;
        if ((tab = table) != null && size > 0) {
            size = 0;
            for (int i = 0; i < tab.length; ++i)
                tab[i] = null;
        }
    }

    // get element by key
    public V get(K key){
        V value = null;
        int index;
        int hash;
        hash = hash(Objects.hashCode(key));
        index = indexFor(hash,MAXIMUM_CAPACITY);
        NodeMap<K, V> e = table[index];
        while (e != null){
            value = getValue(hash,key,e);
            if (value != null) break;
            e = e.next;
        }
        return value;
    }


    private NodeMap<K,V> getPreviousNodeMap(K key){
        NodeMap<K,V> nodeMapPrevious = null;
        int index;
        int hash;
        hash = hash(Objects.hashCode(key));
        index = indexFor(hash,MAXIMUM_CAPACITY);
        NodeMap<K, V> e = table[index];
        while (e != null){
            if (e.hash == hash && (e.key == key || key.equals(e.key))) {
                break;
            }
            nodeMapPrevious = e;
            e = e.next;
        }
        return nodeMapPrevious;
    }

    private NodeMap<K,V> getNodeMap(K key){
        NodeMap<K,V> nodeMap = null;
        int index;
        int hash;
        hash = hash(Objects.hashCode(key));
        index = indexFor(hash,MAXIMUM_CAPACITY);
        NodeMap<K, V> e = table[index];
        while (e != null){
            nodeMap = e;
            if (e.hash == hash && (e.key == key || key.equals(e.key))) {
                break;
            }
            e = e.next;
        }
        return nodeMap;
    }

    // get size
    public int size(){
        return size;
    }
}
