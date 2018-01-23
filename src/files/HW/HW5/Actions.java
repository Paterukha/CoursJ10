package files.HW.HW5;

import java.util.Scanner;

public class Actions {
        private static Scanner sc = new Scanner(System.in);
        private static CarWheel carWheel = new CarWheel();
        private static CarDoor cardoor = new CarDoor();
        private static Car car = new Car(2017,"External",180,10,5,1,0);
        private static double minTireState = 1;     //мінімум по стертості серед шин

        public static double getMinTireState(){
            return minTireState;
        }

        public static void main(String[] args) {

            chooseMainTask();
        }

        public static void chooseMainTask(){
            System.out.println();
            System.out.println("Главное меню");
            System.out.println("Выбор объекта (1 - Машина, 2 - Двери, 3 - Колёса, другое - Выход из программы)");
            System.out.print("Сделайте выбор ");
            String n = sc.nextLine().trim();
            switch (n) {
                case "1":
                    chooseCarTask();
                    break;
                case "2":
                    chooseCarDoorTask();
                    break;
                case "3":
                    chooseCarWheelTask();
                    break;
                default:
                    System.out.println("Вы закончили выполнение программы.");
                    return;
            }
            chooseMainTask();
        }

        public static void chooseCarTask(){
            System.out.println();
            System.out.println("Меню \"Машина\".");
            System.out.println("Выбор задания (1 - Изменить текущую скорость, 2 - Посадить 1 пассажира, 3 - Высадить 1 пассажира, 4 - Высадить всех пассажиров, ");
            System.out.println("                        5 - Получить двери по индексу, 6 - Получить колесо по индексу, 7 - Снять все колёса, 8 - Установить новые колёса, ");
            System.out.println("                        9 - Вычислить возможную текущую скорость, 10 - Вывести всю информацию, другое - Выход в главное меню.)");
            System.out.print("Сделайте выбор: ");
            String n = sc.nextLine().trim();
            switch (n) {
                case "1":
                    System.out.print("Какую текущую скорость устаровить? Сделайт выбор: ");
                    int x = sc.nextInt();
                    sc.nextLine();
                    car.setCurrentSpeed(x);
                    System.out.println("Текущая скорость: " + car.getCurrentSpeed());
                    break;
                case "2":
                    car.takeOnePassenger();
                    System.out.println("Текущее количество пассажиров в машине: " + car.getNumberPassengersMoment());
                    break;
                case "3":
                    car.getoffOnePassenger();
                    System.out.println("Текущее количество пассажиров в машине: " + car.getNumberPassengersMoment());
                    break;
                case "4":
                    car.getoffAllPassengers();
                    System.out.println("Текущее количество пассажиров в машине: " + car.getNumberPassengersMoment());
                    break;
                case "5":
                    System.out.print("Какие двери получить? Введите индекс: ");
                    int i = sc.nextInt();
                    sc.nextLine();
                    CarDoor cd = car.getCarDoor(i);
                    if (cd != null){
                        System.out.println("Получили двери по индексу " + i + " : " + car.getCarDoor(i));
                        cd.showInfo();
                    }
                    break;
                case "6":
                    System.out.print("Какое колесо получить? Введите индекс: ");
                    int j = sc.nextInt();
                    sc.nextLine();
                    CarWheel cw = car.getCarWheel(j);
                    if (cw != null) {
                        System.out.println("Получили колесо по индексу " + j + " : " + cw);
                        cw.showInfo();
                    }
                    break;
                case "7":
                    car.getOffAllCarWheels();
                    System.out.println("Все колёса сняты.");
                    System.out.println("Текущее количество колёс на машине: " + car.getCurrentNumberOfWheels());
                    break;
                case "8":
                    System.out.print("Сколько колёс хотите установить? введите число: ");
                    int k = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Количество колёс до установки новых: " + car.getCurrentNumberOfWheels());
                    car.setNewWheels(k);
                    System.out.println("Текущее количество колёс: " + car.getCurrentNumberOfWheels());
                    break;
                case "9":
                    System.out.println("возможная текущая максимальная скорость: " + car.getCurrentMaxSpeed(minTireState));
                    break;
                case "10":
                    car.showInfoShort();
                    System.out.println("возможная текущая максимальная скорость: " + car.getCurrentMaxSpeed(minTireState));
                    break;
                default:
                    return;
            }
            chooseCarTask();
        }

        public static void chooseCarDoorTask(){

            System.out.println();
            System.out.println("Меню \"Двери\".");
            System.out.println("Выбор задания (1 - Открыть двери, 2 - Закрыть двери, 3 - Инверс состояние дверей, " +
                    "4 - Открыть окно, 5 - Закрыть окно, 6 - Інверс состояние окна, " +
                    "7 - Вывести всю информцию, другое - Выход в главное меню.)");
            System.out.print("Сделайте выбор: ");
            String n = sc.nextLine().trim();
            switch (n) {
                case "1":
                    cardoor.openDoor();
                    System.out.println("Открыли двери");
                    break;
                case "2":
                    cardoor.closeDoor();
                    System.out.println("Закрыли двери.");
                    break;
                case "3":
                    System.out.println("Состояние дверей перед инверс: " + ((cardoor.getDoor())?"открыты":"закрыты"));
                    cardoor.setDoor();
                    System.out.println("Состояние дверей после инверс: " + ((cardoor.getDoor())?"открыты":"закрыты"));
                    break;
                case "4":
                    cardoor.openWindow();
                    System.out.println("Открыли окно.");
                    break;
                case "5":
                    cardoor.closeWindow();
                    System.out.println("Закрыли окно.");
                    break;
                case "6":
                    System.out.println("Состояние окна перед инверс: " + ((cardoor.getWindow())?"открыто":"закрыто"));
                    cardoor.setWindow();
                    System.out.println("Состояние окна после инверс: " + ((cardoor.getWindow())?"открыто":"закрыто"));
                    break;
                case "7":
                    cardoor.showInfo();
                    break;
                default:
                    return;
            }
            chooseCarDoorTask();
        }

        public static void chooseCarWheelTask(){

            System.out.println();
            System.out.println("Меню \"Колёса\".");
            System.out.println("Выбор задания (1 - Поставить новую шину, 2 - Стереть шину на Х%, " +
                    "3 - Вывести состояние шины, 4 - Вывести информацию, другое - Выход в главное меню.)");
            System.out.print("Сделайте выбор: ");
            String n = sc.nextLine().trim();
            switch (n) {
                case "1":
                    carWheel.setNewTire();
                    System.out.println("Новая шина установлена");
                    break;
                case "2":
                    System.out.print("На сколько % стереть шину? Введите число [0,100]: ");
                    double x = sc.nextDouble();
                    sc.nextLine();
                    carWheel.abradeTire(x);
                    minTireState = (minTireState <= carWheel.getTireState())?minTireState:carWheel.getTireState();
                    System.out.println("Шина стёрта на " + x + "%");
                    carWheel.showInfo();
                    break;
                case "3":
                    System.out.println("Состояние шини - " + carWheel.getTireState() + " от новой.");
                    break;
                case "4":
                    carWheel.showInfo();
                    break;
                default:
                    return;
            }
            chooseCarWheelTask();
        }
}
