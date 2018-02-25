package ua.goit.java8.module6;

import ua.goit.java8.module6.collections.MyStack;

/**
 * Created by Taras on 18.08.2017.
 */
public class DemoMyStack {
    private MyStack<Float> myStack = new MyStack<>();

    public DemoMyStack() {
        showDemo();
    }

    private void showDemo(){

        System.out.println("Add elements to MyStack:");
        myStack.push(9.8f);
        myStack.push(3.67f);
        myStack.push(-22.8f);
        myStack.push(100.6f);
        myStack.push(4.702f);
        showInfo();

        int index = 2;
        System.out.println("Get element by index " + index + ":");
        Object arrayListElement = myStack.get(index);
        if (arrayListElement != null) {
            System.out.println("Element " + index + " is " + arrayListElement);
        }
        System.out.println();

        index = 4;
        System.out.println("Remove element " + index + " from MyStack:");
        myStack.remove(index);
        showInfo();

        System.out.println("Peek (Get LIFO from MyStack):");
        System.out.println("LIFO element: " + myStack.peek());
        showInfo();

        System.out.println("Pop (Get and remove LIFO from MyStack):");
        myStack.pop();
        showInfo();

        System.out.println("Clear MyStack:");
        myStack.clear();
        showInfo();
    }

    private void showInfo(){
        myStack.print();
        System.out.println("Size is " + myStack.size());
        System.out.println();
    }
}
