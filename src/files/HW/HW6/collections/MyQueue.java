package ua.goit.java8.module6.collections;

/**
 * Created by Taras on 18.08.2017.
 */
public class MyQueue<T> extends MyLinkedList<T> {

    public MyQueue(){
        super();
    }

    // get FIFO
    public T peek(){
        return (size() > 0)?get(0):null;
    }

    // get and remove FIFO
    public T poll(){
        T result = peek();
        if (size() > 0) remove(0);
        return result;
    }
}
