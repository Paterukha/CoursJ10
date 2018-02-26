package files.HW.HW6.collections;


public class MyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;


    public MyLinkedList(){
        first = new Node<T>(null, null, null);
        last = first;
        size = 0;
    }


    public void add(T item) {
        Node<T> node = new Node<>(item, null, last);
        last.next = node;
        last = node;
        if (size == 0) {first = node;}
        size++;
    }


    public void print() {
        Node<T> iterator = first;
        if (iterator == null) return;

        do {
            System.out.print("" + iterator.item + " ");
            iterator = iterator.next;
        } while (iterator != null);
        System.out.println();
    }


    public void remove(int index){
        Node<T> nodeToRemove = getNode(index);
        if (nodeToRemove != first){
            nodeToRemove.prev.next = nodeToRemove.next;
        } else {
            first = nodeToRemove.next;
        }
        if (nodeToRemove != last){
            nodeToRemove.next.prev = nodeToRemove.prev;
        } else {
            last = nodeToRemove.prev;
        }
        nodeToRemove = null;
        size--;
    }


    public void clear(){
        int originalSize = size;
        for (int i = 0; i < originalSize; i++){
            remove(0);
        }
    }


    public Node<T> getNode(int index){
        if (index < size) {
            Node<T> iterator = first;
            if (iterator == null) return null;
            for (int i = 0; i < index; i++){
                iterator = iterator.next;
            }
            return iterator;
        } else {
            System.out.println("Index " + index + " is out of bound! It's impossible to get the element");
            return null;
        }
    }


    public T get(int index){
        return getNode(index).item;
    }


    public int size(){
        return size;
    }
}
