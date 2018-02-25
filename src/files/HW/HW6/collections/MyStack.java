package ua.goit.java8.module6.collections;

/**
 * Created by Taras on 18.08.2017.
 */
public class MyStack<T> extends MyLinkedList<T> {

    public MyStack(){
        super();
    }

    // get LIFO
    public T peek(){
        return (size() > 0)?get(size() - 1):null;
    }

    // get and remove LIFO
    public T pop(){
        T result = peek();
        if (size() > 0) remove(size() - 1);
        return result;
    }

    public void push(T item){
        super.add(item);
    }
}
