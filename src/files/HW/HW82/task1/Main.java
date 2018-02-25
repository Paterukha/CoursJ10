package ua.goit.java8.module82.task1;

import ua.goit.java8.module82.utils.Operations;

import java.util.Scanner;

/**
 * Created by t.oleksiv on 14/09/2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть число А: ");
        double a = sc.nextDouble();
        sc.nextLine();
        System.out.print("Введіть число B: ");
        double b = sc.nextDouble();
        sc.nextLine();
        System.out.print("Введіть символ однієї з наступних операцій ( \"+\" ; \"-\" ; \"*\" ; \"/\" ; \"%\" ; \"==\" ; \"<\" ; \">\" ): ");
        String operation = sc.nextLine();
        Operations operationCurrent = new Operations();

        if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/") || operation.equals("%")){
            OperationDouble operationDouble = new OperationDouble(operation, a, b);
            System.out.println("Результат (" + a + " " + operation + " " + b + " ) = " + operationCurrent.getResult(operationDouble));
        } else if (operation.equals("==") || operation.equals("<") || operation.equals(">")){
            OperationBoolean operationBoolean = new OperationBoolean(operation, a, b);
            System.out.println("Результат (" + a + " " + operation + " " + b + " ) = " + operationCurrent.getResult(operationBoolean));
        } else {
            System.out.println("Введено недопустимий символ операції. Продовження роботи програми неможливе.");
        }
    }
}
