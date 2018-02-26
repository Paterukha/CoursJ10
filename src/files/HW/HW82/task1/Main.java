package files.HW.HW82.task1;



import files.HW.HW82.utils.Operations;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число А: ");
        double a = sc.nextDouble();
        sc.nextLine();
        System.out.print("Введите число B: ");
        double b = sc.nextDouble();
        sc.nextLine();
        System.out.print("Введите символ одной из следующих операций ( \"+\" ; \"-\" ; \"*\" ; \"/\" ; \"%\" ; \"==\" ; \"<\" ; \">\" ): ");
        String operation = sc.nextLine();
        Operations operationCurrent = new Operations();

        if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/") || operation.equals("%")){
            OperationDouble operationDouble = new OperationDouble(operation, a, b);
            System.out.println("Результат (" + a + " " + operation + " " + b + " ) = " + operationCurrent.getResult(operationDouble));
        } else if (operation.equals("==") || operation.equals("<") || operation.equals(">")){
            OperationBoolean operationBoolean = new OperationBoolean(operation, a, b);
            System.out.println("Результат (" + a + " " + operation + " " + b + " ) = " + operationCurrent.getResult(operationBoolean));
        } else {
            System.out.println("Введён недопустимый символ операции. Продолжение работы программы невозможно.");
        }
    }
}
