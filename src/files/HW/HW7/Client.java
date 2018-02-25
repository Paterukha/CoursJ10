package ua.goit.java8.module7;

/**
 * Created by t.oleksiv on 05/09/2017.
 */
public class Client {
    private String name;
    private Fruit.Type fruitType;
    private int count;

    public Client(String name, Fruit.Type fruitType, int count){
        this.name = name;
        this.fruitType = fruitType;
        this.count = count;
    }

    public String getName(){
        return name;
    }

    public Fruit.Type getFruitType(){
        return fruitType;
    }

    public int getCount(){
        return count;
    }
}
