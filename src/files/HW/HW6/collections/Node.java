package files.HW.HW6.collections;

public class Node<T> {
    public T item;
    public Node<T> next;
    public Node<T> prev;

    public Node(T item, Node<T> next, Node<T> prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }
}
