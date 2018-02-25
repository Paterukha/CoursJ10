package ua.goit.java8.module7;

import com.alibaba.fastjson.JSON;
import ua.goit.java8.module7.utils.DateUtils;
import ua.goit.java8.module7.utils.FileUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Taras on 04.09.2017.
 */
public class TradingShop {
    private List<Fruit> fruits = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    private int moneyBalance = 0;
    private static String pathToBalanceFile = "files/balance.json";

    public void addFruits(String pathToJsonFile) throws IOException {
        String json;
        json = FileUtils.readFromFile(pathToJsonFile);
        fruits.addAll(JSON.parseArray(json,Fruit.class));
        System.out.println("Fruits are loaded from " + pathToJsonFile);
    }

    public void showInfo(List<Fruit> fruitList) throws ParseException {
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("Fruit \t SupplyDate \t ShelfLife \t Price");
        System.out.println("--------------------------------------------------");
        for (Fruit fruit : fruitList) {
            String str = String.valueOf(fruit.getType()) + " \t" + fruit.getDateSupply() + " \t" + fruit.getShelfLife() + " \t" + fruit.getPrice();
            System.out.println(str);
        }
    }

    public void save(String pathToJsonFile){
        String json = JSON.toJSONString(fruits);
        try {
            FileUtils.writeToFile(json, pathToJsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveBalance();
        System.out.println();
        System.out.println("Finish saving DB to file");
    }

    private void saveBalance(){
        String json = JSON.toJSONString(moneyBalance);
        try {
            FileUtils.writeToFile(json, pathToBalanceFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String pathToJsonFile) throws IOException, ParseException {
        fruits.clear();
        showInfo(fruits);
        addFruits(pathToJsonFile);
        loadBalance();
    }

    private void loadBalance(){
        try {
            moneyBalance = Integer.parseInt(FileUtils.readFromFile(pathToBalanceFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Fruit> getSpoiledFruits(Date date) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            Date dateExpiration = DateUtils.getDateExpiration(fruit.getDateSupply(), fruit.getShelfLife());
            if (DateUtils.isSpoiled(dateExpiration, date)) {
                fruitList.add(fruit);
            }
        }
        return fruitList;
    }

    public List<Fruit> getSpoiledFruits(Date date, Fruit.Type fruitType) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getType().equals(fruitType)) {
                Date dateExpiration = DateUtils.getDateExpiration(fruit.getDateSupply(), fruit.getShelfLife());
                if (DateUtils.isSpoiled(dateExpiration, date)) {
                    fruitList.add(fruit);
                }
            }
        }
        return fruitList;
    }

    public List<Fruit> getAvailableFruits(Date date) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            Date dateExpiration = DateUtils.getDateExpiration(fruit.getDateSupply(), fruit.getShelfLife());
            if (!DateUtils.isSpoiled(dateExpiration, date)) {
                fruitList.add(fruit);
            }
        }
        return fruitList;
    }

    public List<Fruit> getAvailableFruits(Date date, Fruit.Type fruitType) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getType().equals(fruitType)) {
                Date dateExpiration = DateUtils.getDateExpiration(fruit.getDateSupply(), fruit.getShelfLife());
                if (!DateUtils.isSpoiled(dateExpiration, date)) {
                    fruitList.add(fruit);
                }
            }
        }
        return fruitList;
    }

    public List<Fruit> getAvailableFruits(Fruit.Type fruitType) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getType().equals(fruitType)) {
                fruitList.add(fruit);
            }
        }
        return fruitList;
    }

    public List<Fruit> getAddedFruits(Date date) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (DateUtils.convertStringToDate(fruit.getDateSupply()).equals(date)) {
                fruitList.add(fruit);
            }
        }
        return fruitList;
    }

    public List<Fruit> getAddedFruits(Date date, Fruit.Type fruitType) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getType().equals(fruitType)) {
                if (DateUtils.convertStringToDate(fruit.getDateSupply()).equals(date)) {
                    fruitList.add(fruit);
                }
            }
        }
        return fruitList;
    }

    public int getCountFruitType(Fruit.Type fruitType){
        int count = 0;
        for (Fruit fruit: fruits){
            if (fruit.getType().equals(fruitType)) {
                count++;
            }
        }
        return count;
    }

    public void addClients(String pathToJsonFile) throws IOException {
        String json;
        json = FileUtils.readFromFile(pathToJsonFile);
        clients.addAll(JSON.parseArray(json,Client.class));
        System.out.println("Orders are loaded from " + pathToJsonFile);
    }

    private int getIndex(Fruit fruitToFind){
        int index = -1;
        for (Fruit fruit: fruits){
            if (fruit.equals(fruitToFind)){
                index = fruits.indexOf(fruit);
                break;
            }
        }
        return index;
    }

    public void sell(String pathToJsonFile) throws IOException, ParseException {
        addClients(pathToJsonFile);
        System.out.println();
        System.out.println("Submitting the order ...");
        for (Client client: clients){
            if (client.getCount() <= getCountFruitType(client.getFruitType())){
                List<Fruit> clientFruits = getAvailableFruits(client.getFruitType());
                int i = 0;
                for (Fruit clientFruit: clientFruits){
                    moneyBalance += clientFruit.getPrice();
                    System.out.println("Selling " + clientFruit.getType() + " (price " + clientFruit.getPrice() + ") to " + client.getName());
                    int index = getIndex(clientFruit);
                    if (index != (-1)) {
                        fruits.remove(index);
                    }
                    i++;
                    if (i == client.getCount()) { break; }
                }
            } else {
                System.out.println("It's impossible to sell " + client.getCount() + " " + client.getFruitType() + " to " + client.getName());
                System.out.println("We have only " + getCountFruitType(client.getFruitType()) + " " + client.getFruitType() + " in the shop.");
            }
        }
    }

    public List<Fruit> getFruits(){
        return fruits;
    }

    public List<Client> getClients() { return clients; }

    public int getMoneyBalance(){
        return moneyBalance;
    }

}
