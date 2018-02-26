package files.HW.HW6.collections;


public class MyStack<T> extends MyLinkedList<T> {

    public MyStack(){
        super();
    }


    public T peek(){
        return (size() > 0)?get(size() - 1):null;
    }


    public T pop(){
        T result = peek();
        if (size() > 0) remove(size() - 1);
        return result;
    }

    public void push(T item){
        super.add(item);
    }
}
