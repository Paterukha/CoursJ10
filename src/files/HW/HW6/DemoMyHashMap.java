package ua.goit.java8.module6;

import ua.goit.java8.module6.collections.MyHashMap;

/**
 * Created by t.oleksiv on 22/08/2017.
 */
public class DemoMyHashMap {
    private MyHashMap<String,String> myHashMap= new MyHashMap<>();

    public DemoMyHashMap(){
        showDemo();
    }

    private void showDemo(){
        myHashMap.put("taras","oleksiv");
        myHashMap.put("taras1","oleksiv1");
        myHashMap.put("taras2","oleksiv2");
        showInfo();

        String key = "taras1";
        System.out.println("Get element by key \"" + key + "\":");;
        System.out.println("Element with key \"" + key + "\" has value \"" + myHashMap.get(key) + "\"");
        System.out.println();

        key = "taras";
        System.out.println("Remove element with key \"" + key + "\" from MyHashMap:");
        myHashMap.remove(key);
        showInfo();

        System.out.println("Clear MyHashMap:");
        myHashMap.clear();
        showInfo();

    }

    private void showInfo(){
        myHashMap.print();
        System.out.println("Size is " + myHashMap.size());
        System.out.println();
    }
}
