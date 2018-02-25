package ua.goit.java8.module82.task2;

import ua.goit.java8.module82.utils.Arrays;
import ua.goit.java8.module82.utils.SeriesRun;
import java.util.Scanner;


/**
 * Created by t.oleksiv on 14/09/2017.
 */
public class Main {
    public static boolean finishThreads = false;
    public static boolean finishThreadPool = false;

    public static void main(String[] args) throws InterruptedException {

        // вводимо кількість потоків
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть число N (кількість потоків): ");
        int n = sc.nextInt();
        sc.nextLine();

        long startTime = System.currentTimeMillis();
        // getArrayMultiThread (багатопоточний метод) працює довше
        //int[] array = getArrayMultiThread(80000000);

        // заповнюєм масив одним потоком
        Arrays arrays = new Arrays();
        int[] array = arrays.getArraySingleThread(80000000);
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Filling Array duration: " + duration);


        // Обчислюєм суму режимом Thread (кожний потік запускається по-черзі один після одного)
        System.out.println();
        System.out.println("******** Method \"Thread\" *********");

        SeriesRun seriesRunThread = new SeriesRun(n,array);

        // очікуєм на закінчення виконання попереднього набору потоків
        Thread thread = new Thread(()->{
            while (!finishThreads){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("*********** The END of Method \"Thread\" ***********");
        });
        thread.start();
        thread.join();

        // Обчислюєм суму режимом ThreadPool (кожний потік запускається по-черзі один після одного)
        System.out.println();
        System.out.println("******** Method \"ThreadPool\" *********");

        SeriesRun seriesRunThreadPool = new SeriesRun();
        seriesRunThreadPool.getThreadPool(n,array);

        // очікуєм на закінчення виконання попереднього набору потоків ThreadPool
        Thread threadPool = new Thread(()->{
            while (!finishThreadPool){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("*********** The END of Method \"ThreadPool\" ***********");
        });
        threadPool.start();
    }

}
