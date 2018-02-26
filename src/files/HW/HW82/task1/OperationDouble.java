package files.HW.HW82.task1;

import java.util.concurrent.Callable;


public class OperationDouble implements Callable<Double> {
    private String operation;
    private double a;
    private double b;

    public OperationDouble(String operation, double a, double b){
        this.operation = operation;
        this.a = a;
        this.b = b;
    }
    @Override
    public Double call() throws Exception {
        double result = 0;
        switch (operation){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            case "%":
                result = a % b;
                break;
            default:
                result = 0;
                System.out.println("Введён недопустимый символ операции: " + operation);
                break;
        }
        return result;
    }
}
