package ua.goit.java8.module82.utils;

import ua.goit.java8.module82.task2.Main;

import java.util.concurrent.*;


/**
 * Created by Taras on 15.09.2017.
 */
public class SeriesRun extends Thread {
    private int[] array;
    private int mainId;
    private Object waitObject;
    private int countThreads;
    private static long durationThreads = 0;
    private static int currentMax = 1;

    // 3 конструктори
    public SeriesRun(){}

    public SeriesRun(int countThreads, int[] array){
        this.countThreads = countThreads;
        this.array = array;
        work(countThreads,array);
    }

    public SeriesRun(int mainId, Object waitObject, int[] array, int countThreads){
        this.mainId = mainId;
        this.waitObject = waitObject;
        this.array = array;
        this.countThreads = countThreads;
    }
    // кінець конструкторів

    // метод для створення масиву потоків
    private void work(int countThreads, int[] array){
        durationThreads = 0;
        Object waitObject = new Object();
        for (int i = currentMax; i <= countThreads; i++){
            Thread thread = new SeriesRun(i,waitObject, array, countThreads);
            thread.start();
        }
    }

    // забезпечуєм виконання потоків у строгій послідовності один за одним
    public void run(){
        //System.out.println("Start run of thread: " + mainId);
        synchronized (waitObject){
            while (mainId > currentMax){
                try {
                    waitObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            currentMax++;
            try {
                calculateSum(array, mainId, false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("Finish thread: " + mainId);
            waitObject.notifyAll();
        }
    }

    // розпаралелюєм підрахунок суми на потоки в залежності від кількості ядер
    // цей метод використовується як для 1-го способу Thread так і для другого способу ThreadPool
    private double calculateSum(int[] array, int mainId, boolean isThreadPool) throws InterruptedException {
        System.out.println();
        System.out.println("********************* Thread # " + mainId + " ***************************");
        System.out.println("Calculating sum of sin(x) + cos(x) for the whole array ...");
        long startTime = System.currentTimeMillis();
        int coreCount = Runtime.getRuntime().availableProcessors();
        //System.out.println("Count of cores: " + coreCount);

        // викликаєм метод підрахунку суми через розпаралелені потоки
        Arrays arraysMultiple = new Arrays();
        double sum = arraysMultiple.getMultipleThreadsSum(array,coreCount);
        long duration = System.currentTimeMillis() - startTime;
        durationThreads += duration;
        System.out.println("Sum = " + sum);
        System.out.println("Calculating Sum duration: " + duration);
        System.out.println("********************* Finish Thread # " + mainId + "**********************");
        if (mainId == countThreads){
            System.out.println("Total duration of all threads: " + durationThreads);
            if (isThreadPool){
                Main.finishThreadPool = true;
            } else {
                Main.finishThreads = true;
            }
        }
        return sum;
    }

    // метод для запуску ThreadPool
    public void getThreadPool(int n, int[] array){
        durationThreads = 0;
        countThreads = n;
        ExecutorService threadPool = Executors.newFixedThreadPool(1);

        Callable<Double>[] callable = new Callable[n];
        for (int i = 0; i < callable.length; i++){
            final int x = i + 1;
            callable[i] = new Callable<Double>() {
                @Override
                public Double call() throws Exception {
                    return calculateSum(array, x, true);
                }
            };
        }

        FutureTask<Double>[] futureTask = new FutureTask[n];

        for (int i = 0; i < futureTask.length; i++){
            futureTask[i] = new FutureTask<Double>(callable[i]);
            threadPool.submit(futureTask[i]);

            try {
                futureTask[i].get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        threadPool.shutdown();
    }
}
