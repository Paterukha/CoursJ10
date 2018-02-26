package files.HW.HW6.collections;


public class NodeMap<K,V> {
    public int hash;
    public K key;
    public V value;
    public NodeMap<K, V> next;

    NodeMap(int hash,K key,V value,NodeMap<K, V> next){
        this.hash=hash;
        this.key=key;
        this.value=value;
        this.next=next;
    }
}
