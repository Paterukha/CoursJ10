package ua.goit.java8.module82.utils;

import ua.goit.java8.module82.task1.OperationBoolean;
import ua.goit.java8.module82.task1.OperationDouble;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * Created by t.oleksiv on 14/09/2017.
 */
public class Operations {
    public double getResult(OperationDouble operationDouble){
        FutureTask<Double> futureTask = new FutureTask<Double>(operationDouble);

        Thread thread = new Thread(futureTask);
        System.out.println("Thread started...");
        thread.start();
        double result = 0;
        try {
            result = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Thread finished.");
        return result;
    }

    public boolean getResult(OperationBoolean operationBoolean){
        FutureTask<Boolean> futureTask = new FutureTask<Boolean>(operationBoolean);

        Thread thread = new Thread(futureTask);
        System.out.println("Thread started...");
        thread.start();
        boolean result = false;
        try {
            result = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Thread finished.");
        return result;
    }

}


