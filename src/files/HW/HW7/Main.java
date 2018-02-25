package ua.goit.java8.module7;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import ua.goit.java8.module7.utils.CreateJson;
import ua.goit.java8.module7.utils.DateUtils;


/**
 * Created by t.oleksiv on 04/09/2017.
 */
public class Main {
    private static String file1 = "files/supply1.json";
    private static String file2 = "files/supply2.json";
    private static String file3 = "files/supply3.json";
    private static String file4 = "files/supply4.json";
    private static String fileDB = "files/DB.json";
    private static String fileOrder = "files/order.json";
    private static TradingShop tradingShop = new TradingShop();

    public static void main(String[] args) throws IOException, ParseException {

        // fill in json files
        CreateJson createJson = new CreateJson();

        task1();

        task2();

        task3();

        task4();

    }

    private static void task1() throws IOException, ParseException{
        System.out.println();
        System.out.println("Task1");

        // load 4 supplies
        tradingShop.addFruits(file1);
        tradingShop.addFruits(file2);
        tradingShop.addFruits(file3);
        tradingShop.addFruits(file4);

        // show DB info
        System.out.println("Checking current DB info:");
        tradingShop.showInfo(tradingShop.getFruits());

        // save DB to file
        tradingShop.save(fileDB);

        // load DB from file
        tradingShop.load(fileDB);

        // show DB info
        System.out.println("Checking current DB info:");
        tradingShop.showInfo(tradingShop.getFruits());
    }

    private static void task2() throws ParseException {
        Date date = DateUtils.convertStringToDate("15/08/2017");

        System.out.println();
        System.out.println("Task2");

        // get list of fruits spoiled on date
        List<Fruit> fruitsSpoiled = tradingShop.getSpoiledFruits(date);

        // show that list
        System.out.println();
        System.out.println("List of spoiled fruits:");
        tradingShop.showInfo(fruitsSpoiled);

        // get list of fruits available on date
        List<Fruit> fruitsAvailable = tradingShop.getAvailableFruits(date);

        // show that list
        System.out.println();
        System.out.println("List of available fruits:");
        tradingShop.showInfo(fruitsAvailable);
    }

    private static void task3() throws ParseException{
        String strDate = "20/08/2017";
        Date date = DateUtils.convertStringToDate(strDate);
        Fruit.Type fruitType = Fruit.Type.banana;

        System.out.println();
        System.out.println("Task3");

        // get list of bananas spoiled on date
        List<Fruit> fruitsSpoiled = tradingShop.getSpoiledFruits(date, fruitType);

        // show that list
        System.out.println();
        System.out.println("List of fruits \"" + fruitType + "\" spoiled on date " + strDate);
        tradingShop.showInfo(fruitsSpoiled);

        fruitType = Fruit.Type.mellon;
        // get list of mellon available on date
        List<Fruit> fruitsAvailable = tradingShop.getAvailableFruits(date,fruitType);

        // show that list
        System.out.println();
        System.out.println("List of fruits \"" + fruitType + "\" available on date " + strDate);
        tradingShop.showInfo(fruitsAvailable);

        // check supply on specific date
        strDate = "06/08/2017";
        date = DateUtils.convertStringToDate(strDate);
        List<Fruit> fruitsSupplied = tradingShop.getAddedFruits(date);

        // show that list
        System.out.println();
        System.out.println("List of fruits added on " + strDate);
        tradingShop.showInfo(fruitsSupplied);

        // check supply of specific fruit on specific date
        fruitType = Fruit.Type.watermelon;
        fruitsSupplied = tradingShop.getAddedFruits(date,fruitType);

        // show that list
        System.out.println();
        System.out.println("List of fruits \"" + fruitType + "\" added on " + strDate);
        tradingShop.showInfo(fruitsSupplied);
    }

    private static void task4() throws IOException, ParseException {
        System.out.println();
        System.out.println("Task4");

        // try to submit order stored in JSON file
        tradingShop.sell(fileOrder);

        // show current info on shop
        tradingShop.showInfo(tradingShop.getFruits());

        // show balance
        System.out.println();
        System.out.println("Shop MoneyBalance = " + tradingShop.getMoneyBalance());
    }

}
