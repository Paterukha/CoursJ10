package files.HW.HW7;

import files.HW.HW7.utils.CreateJson;
import files.HW.HW7.utils.DateUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;





public class Main {
    private static String file1 = "files/supply1.json";
    private static String file2 = "files/supply2.json";
    private static String file3 = "files/supply3.json";
    private static String file4 = "files/supply4.json";
    private static String fileDB = "files/DB.json";
    private static String fileOrder = "files/order.json";
    private static TradingShop tradingShop = new TradingShop();

    public static void main(String[] args) throws IOException, ParseException {


        CreateJson createJson = new CreateJson();

        task1();

        task2();

        task3();

        task4();

    }

    private static void task1() throws IOException, ParseException{
        System.out.println();
        System.out.println("Task1");


        tradingShop.addFruits(file1);
        tradingShop.addFruits(file2);
        tradingShop.addFruits(file3);
        tradingShop.addFruits(file4);


        System.out.println("Checking current DB info:");
        tradingShop.showInfo(tradingShop.getFruits());


        tradingShop.save(fileDB);


        tradingShop.load(fileDB);


        System.out.println("Checking current DB info:");
        tradingShop.showInfo(tradingShop.getFruits());
    }

    private static void task2() throws ParseException {
        Date date = DateUtils.convertStringToDate("15/08/2017");

        System.out.println();
        System.out.println("Task2");


        List<Fruit> fruitsSpoiled = tradingShop.getSpoiledFruits(date);


        System.out.println();
        System.out.println("List of spoiled fruits:");
        tradingShop.showInfo(fruitsSpoiled);


        List<Fruit> fruitsAvailable = tradingShop.getAvailableFruits(date);


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


        List<Fruit> fruitsSpoiled = tradingShop.getSpoiledFruits(date, fruitType);


        System.out.println();
        System.out.println("List of fruits \"" + fruitType + "\" spoiled on date " + strDate);
        tradingShop.showInfo(fruitsSpoiled);

        fruitType = Fruit.Type.mellon;

        List<Fruit> fruitsAvailable = tradingShop.getAvailableFruits(date,fruitType);


        System.out.println();
        System.out.println("List of fruits \"" + fruitType + "\" available on date " + strDate);
        tradingShop.showInfo(fruitsAvailable);


        strDate = "06/08/2017";
        date = DateUtils.convertStringToDate(strDate);
        List<Fruit> fruitsSupplied = tradingShop.getAddedFruits(date);


        System.out.println();
        System.out.println("List of fruits added on " + strDate);
        tradingShop.showInfo(fruitsSupplied);


        fruitType = Fruit.Type.watermelon;
        fruitsSupplied = tradingShop.getAddedFruits(date,fruitType);


        System.out.println();
        System.out.println("List of fruits \"" + fruitType + "\" added on " + strDate);
        tradingShop.showInfo(fruitsSupplied);
    }

    private static void task4() throws IOException, ParseException {
        System.out.println();
        System.out.println("Task4");


        tradingShop.sell(fileOrder);


        tradingShop.showInfo(tradingShop.getFruits());


        System.out.println();
        System.out.println("Shop MoneyBalance = " + tradingShop.getMoneyBalance());
    }

}
