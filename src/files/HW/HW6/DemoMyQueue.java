package ua.goit.java8.module6;

import ua.goit.java8.module6.collections.MyQueue;

/**
 * Created by Taras on 18.08.2017.
 */
public class DemoMyQueue {
    private MyQueue<String> myQueue= new MyQueue<>();

    public DemoMyQueue(){
        showDemo();
    }

    private void showDemo(){

        System.out.println("Add elements to MyQueue:");
        myQueue.add("Lviv");
        myQueue.add("London");
        myQueue.add("Kiev");
        myQueue.add("Warsaw");
        myQueue.add("Paris");
        showInfo();

        int index = 2;
        System.out.println("Get element by index " + index + ":");
        Object arrayListElement = myQueue.get(index);
        if (arrayListElement != null) {
            System.out.println("Element " + index + " is " + arrayListElement);
        }
        System.out.println();

        index = 4;
        System.out.println("Remove element " + index + " from MyQueue:");
        myQueue.remove(index);
        showInfo();

        System.out.println("Peek (Get FIFO from MyQueue):");
        System.out.println("FIFO element: " + myQueue.peek());
        showInfo();

        System.out.println("Poll (Get and remove FIFO from MyQueue):");
        myQueue.poll();
        showInfo();

        System.out.println("Clear MyQueue:");
        myQueue.clear();
        showInfo();
    }

    private void showInfo(){
        myQueue.print();
        System.out.println("Size is " + myQueue.size());
        System.out.println();
    }
}
