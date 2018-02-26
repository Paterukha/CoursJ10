package files.HW.HW8;

import java.util.Scanner;


public class MyScanner {
    private int peopleCount;
    private int maxAmount;

    public MyScanner(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество посетителей библиотеки:");
        peopleCount = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите вместительность библиотеки:");
        maxAmount = scanner.nextInt();
        scanner.nextLine();
    }

    public int getPeopleCount(){
        return peopleCount;
    }

    public int getMaxAmount(){
        return maxAmount;
    }
}
