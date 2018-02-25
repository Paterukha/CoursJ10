package ua.goit.java8.module82.task1;

import java.util.concurrent.Callable;

/**
 * Created by t.oleksiv on 14/09/2017.
 */
public class OperationBoolean implements Callable<Boolean> {
    private String operation;
    private double a;
    private double b;

    public OperationBoolean(String operation, double a, double b){
        this.operation = operation;
        this.a = a;
        this.b = b;
    }
    @Override
    public Boolean call() throws Exception {
        boolean result = false;
        switch (operation){
            case "==":
                result = (a == b);
                break;
            case "<":
                result = (a < b);
                break;
            case ">":
                result = (a > b);
                break;
            default:
                result = false;
                System.out.println("Введено недопустимий символ операції: " + operation);
                break;
        }
        return result;
    }
}
