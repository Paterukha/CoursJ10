package files.HW.HW82.task1;

import java.util.concurrent.Callable;


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
                System.out.println("Введён недопустимый символ операции: " + operation);
                break;
        }
        return result;
    }
}
