package files.HW.HW8.libraries;

import java.util.Random;
import java.util.concurrent.Semaphore;


public class Library2 {
    private int peopleCount;
    private int maxAmount;
    private final Semaphore semaphore;
    private final Semaphore semaphoreDoor = new Semaphore(1,true);

    public Library2(int peopleCount, int maxAmount){
        this.peopleCount = peopleCount;
        this.maxAmount = maxAmount;
        semaphore = new Semaphore(maxAmount, true);
    }

    public void work() throws InterruptedException {
        for (int i = 1; i <= peopleCount; i++) {
            new Thread(new People(i)).start();
            Thread.sleep(400);
        }
    }

    public class People implements Runnable{
        private int peopleNumber;

        public People(int peopleNumber){
            this.peopleNumber = peopleNumber;
        }

        @Override
        public void run() {
            System.out.printf("Человек №%d подешёл ко входу в библиотеку.\n", peopleNumber);

            try {

                if (semaphore.availablePermits() == 0){
                    System.out.printf("Человек №%d ждёт возле входа в библиотеку.\n", peopleNumber);
                }
                semaphore.acquire();

                System.out.printf("Человек №%d подешёл к дверям на улице.\n", peopleNumber);

                if (semaphoreDoor.availablePermits() == 0){
                    System.out.printf("Человек №%d ждёт возле дверей на улице.\n", peopleNumber);
                }

                semaphoreDoor.acquire();
                System.out.printf("Человек №%d проходит через двери внутрь.\n", peopleNumber);
                Thread.sleep(500);
                System.out.printf("Человек №%d прошел через двери внутрь.\n", peopleNumber);
                semaphoreDoor.release();

                System.out.printf("Человек №%d зашёл в библиотеку.\n", peopleNumber);

                System.out.printf("Человек №%d читает книгу.\n", peopleNumber);
                Random rand = new Random();
                Thread.sleep(rand.nextInt(4001) + 1000);       //читаєм книгу

                System.out.printf("Человек №%d подошёл к дверям изнутри.\n", peopleNumber);

                if (semaphoreDoor.availablePermits() == 0){
                    System.out.printf("Человек №%d ждет возле дверей изнутри.\n", peopleNumber);
                }

                semaphoreDoor.acquire();
                System.out.printf("Человек №%d проходит через двери наружу.\n", peopleNumber);
                Thread.sleep(500);
                System.out.printf("Человек №%d прошёл через двери наружу.\n", peopleNumber);
                semaphoreDoor.release();

                semaphore.release();
                System.out.printf("Человек №%d вышел из библиотеки.\n", peopleNumber);
            } catch (InterruptedException e) {
            }

        }
    }

}
