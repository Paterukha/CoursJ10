package files.HW.HW6.collections;


public class MyQueue<T> extends MyLinkedList<T> {

    public MyQueue(){
        super();
    }


    public T peek(){
        return (size() > 0)?get(0):null;
    }


    public T poll(){
        T result = peek();
        if (size() > 0) remove(0);
        return result;
    }
}
