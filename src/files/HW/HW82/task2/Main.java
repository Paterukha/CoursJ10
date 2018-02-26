package files.HW.HW82.task2;


import files.HW.HW82.utils.Arrays;
import files.HW.HW82.utils.SeriesRun;

import java.util.Scanner;



public class Main {
    public static boolean finishThreads = false;
    public static boolean finishThreadPool = false;

    public static void main(String[] args) throws InterruptedException {



        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество потоков: ");
        int n = sc.nextInt();
        sc.nextLine();

        long startTime = System.currentTimeMillis();



        Arrays arrays = new Arrays();
        int[] array = arrays.getArraySingleThread(80000000);
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Filling Array duration: " + duration);



        System.out.println();
        System.out.println("******** Method \"Thread\" *********");

        SeriesRun seriesRunThread = new SeriesRun(n,array);


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


        System.out.println();
        System.out.println("******** Method \"ThreadPool\" *********");

        SeriesRun seriesRunThreadPool = new SeriesRun();
        seriesRunThreadPool.getThreadPool(n,array);


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
