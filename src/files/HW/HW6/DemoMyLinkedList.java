package ua.goit.java8.module6;

import ua.goit.java8.module6.collections.MyLinkedList;

/**
 * Created by t.oleksiv on 18/08/2017.
 */
public class DemoMyLinkedList {
    private MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

    public DemoMyLinkedList(){
        showDemo();
    }

    private void showDemo(){

        System.out.println("Add elements to MyLinkedList:");
        myLinkedList.add(2);
        myLinkedList.add(-2);
        myLinkedList.add(10);
        myLinkedList.add(4);
        myLinkedList.add(1);
        showInfo();

        int index = 2;
        System.out.println("Get element by index " + index + ":");;
        Object arrayListElement = myLinkedList.get(index);
        if (arrayListElement != null) {
            System.out.println("Element " + index + " is " + arrayListElement);
        }
        System.out.println();

        index = 4;
        System.out.println("Remove element " + index + " from MyLinkedlist:");
        myLinkedList.remove(index);
        showInfo();

        System.out.println("Clear MyLinkedList:");
        myLinkedList.clear();
        showInfo();
    }

    private void showInfo(){
        myLinkedList.print();
        System.out.println("Size is " + myLinkedList.size());
        System.out.println();
    }
}
