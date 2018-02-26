package files.HW.HW82.utils;

import java.util.ArrayList;
import java.util.List;


public class Arrays {

    public ArrayList<Integer> getArrayList(int size) {
        System.out.println("Started filling ArrayList...");
        final ArrayList<Integer> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(i+1);
        }
        System.out.println("Finished filling ArrayList.");
        return result;
    }



    public int[] getArrayMultiThread(int size) throws InterruptedException {
        int coreCount = Runtime.getRuntime().availableProcessors();
        int length = size / coreCount;
        System.out.println("Started filling Array...");
        final int[] result = new int[size];

        List<Thread> threads = new ArrayList<>(coreCount);

        for(int i = 0; i < coreCount; i++) {
            final int left = length * i;
            final int right = left + length;

            Thread thread = new Thread(()->{
                for (int j = left; j < right; j++) {
                    result[j] = j+1;
                }
            });
            thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) thread.join();

        System.out.println("Finished filling Array.");
        return result;
    }


    public int[] getArraySingleThread(int size){
        System.out.println("Started filling Array...");
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = i+1;
        }
        System.out.println("Finished filling Array.");
        return result;
    }


    private double getSum(int[] array, int left, int right) {
        double sum = 0;
        for(int i = left; i < right; i++)
            sum += Math.sin(array[i]) + Math.cos(array[i]);
        return sum;
    }


    public double getMultipleThreadsSum(int[] array, int count) throws InterruptedException {
        List<Thread> threads = new ArrayList<>(count);
        final double[] sums = new double[count];

        for(int i = 0; i < count; i++) {
            int length = array.length / count;
            final int left = length * i;
            final int right = left + length;
            final int index = i;

            Thread thread = new Thread(()->{
                sums[index] = getSum(array, left, right);
            });
            thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) thread.join();

        double totalSum = 0;
        for (double sum : sums) totalSum += sum;

        return totalSum;
    }

}
