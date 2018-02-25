package ua.goit.java8.module7.utils;

import ua.goit.java8.module7.Client;
import ua.goit.java8.module7.Fruit;
import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateJson {
    private String[] dateSupply = {"04/08/2017", "05/08/2017", "06/08/2017", "07/08/2017"};

    public CreateJson() {
        generateSupplyFiles();
        generateOrder();
        System.out.println("Finish creating JSON files.");
    }

    private void generateSupplyFiles(){
        for (int i = 0; i < dateSupply.length; i++) {
            List<Fruit> fruits = new ArrayList<>();
            fruits.add(new Fruit(Fruit.Type.apple, 10, dateSupply[i], 25));
            fruits.add(new Fruit(Fruit.Type.tangerine, 5, dateSupply[i], 35));
            fruits.add(new Fruit(Fruit.Type.apricot, 12, dateSupply[i], 20));
            fruits.add(new Fruit(Fruit.Type.plum, 6, dateSupply[i], 30));
            fruits.add(new Fruit(Fruit.Type.banana, 15, dateSupply[i], 15));
            fruits.add(new Fruit(Fruit.Type.pear, 8, dateSupply[i], 45));
            fruits.add(new Fruit(Fruit.Type.grapefruit, 18, dateSupply[i], 55));
            fruits.add(new Fruit(Fruit.Type.peach, 9, dateSupply[i], 40));
            fruits.add(new Fruit(Fruit.Type.mellon, 20, dateSupply[i], 50));
            fruits.add(new Fruit(Fruit.Type.watermelon, 4, dateSupply[i], 10));
            String json = JSON.toJSONString(fruits);
            try {
                FileUtils.writeToFile(json, "files/supply" + (i+1) + ".json");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void generateOrder(){
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("John",Fruit.Type.grapefruit, 3));
        clients.add(new Client("John",Fruit.Type.apple, 2));
        clients.add(new Client("John",Fruit.Type.peach, 5));
        clients.add(new Client("Peter",Fruit.Type.apple, 3));
        clients.add(new Client("George",Fruit.Type.tangerine, 4));
        clients.add(new Client("Ann",Fruit.Type.banana, 7));
        String json = JSON.toJSONString(clients);
        try {
            FileUtils.writeToFile(json, "files/order.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
