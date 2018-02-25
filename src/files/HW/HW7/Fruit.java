package ua.goit.java8.module7;

/**
 * Created by t.oleksiv on 04/09/2017.
 */
public class Fruit {
    public enum Type {banana, apple, pear, plum, peach, apricot, mellon, watermelon, grapefruit, tangerine};
    private Type type;
    private int shelfLife;
    private String dateSupply;
    private int price;

    public Fruit(Type type,int shelfLife, String dateSupply, int price){
        this.type = type;
        this.shelfLife = shelfLife;
        this.dateSupply = dateSupply;
        this.price = price;
    }

    public Type getType(){
        return type;
    }

    public int getShelfLife(){
        return shelfLife;
    }

    public String getDateSupply(){
        return dateSupply;
    }

    public int getPrice(){
        return price;
    }
}
