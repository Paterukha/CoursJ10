package files.HW.HW5;

public class Car {

    // class variables
    private final int releaseDate;    //дата призводства(неизменна после создания объекта)
    private String engineType;      //тип двигателя
    private int maxSpeed;       //максимальная скорость машины(если новая)
    private int accelerationTime;      //время разгона до 100км/ч
    private int passengers;    //пассажировместимость
    private int numberPassengersMoment;  //кол-во пассажиров в данный момент
    private int currentSpeed;       //текущая скорость
    private CarDoor[] cardoors = new CarDoor[MAX_DOORS];     //массив 4 двери
    private CarWheel[] carwheels = new CarWheel[MAX_WHEELS];      //массив 10 колёс
    private int wheelCounter;       //текущее количесво колёс
    private static final int MAX_WHEELS = 10;     //максимальное кол-во колёс
    private static final int MAX_DOORS = 4;     //максимальное кол-во дверей


    // constructor1
    public Car(int releaseDate) {
        this.releaseDate = releaseDate;
        this.setCarDoors();
        this.setCarWheels();
    }

    // constructor2
    public Car(int releaseDate, String engineType, int maxSpeed, int runupTime,
               int passengers, int numberPassengersMoment, int currentSpeed) {
        this.releaseDate = releaseDate;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.accelerationTime = runupTime;
        this.passengers = passengers;
        this.numberPassengersMoment = numberPassengersMoment;
        this.currentSpeed = currentSpeed;
        this.setCarDoors();
        this.setCarWheels();
    }

    //methods
    //изменить текущую скорость
    public void setCurrentSpeed(int currentSpeed) {
        if ((currentSpeed <= maxSpeed) && (currentSpeed >= 0)) {
            this.currentSpeed = currentSpeed;
        } else {
            System.out.println("Невозможно установить данную скорость,не попадает в промежуток [0," + maxSpeed + "]");
        }
    }

    //получить текущую скорость
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    //посадить 1 пассажира в машину
    public void takeOnePassenger() {
        if (numberPassengersMoment >= passengers) {
            System.out.println("Невозможно взять пассажиров. Машина заполнена.");
        } else {
            numberPassengersMoment++;
        }
    }

    //получить текущее кол-во пассажиров в машине
    public int getNumberPassengersMoment() {
        return numberPassengersMoment;
    }

    //для проверки наличия пассажиров в машине
    private boolean checkPassengers() {
        return (numberPassengersMoment > 0);
    }

    //высадить 1 пассажира из машины
    public void getoffOnePassenger() {
        if (checkPassengers()) {
            numberPassengersMoment--;
        } else {
            System.out.println("Невозможно высадить пассажиров,отсутствуют в машине");
        }
    }

    //высадить всех пассажиров
    public void getoffAllPassengers() {
        if (checkPassengers()) {
            numberPassengersMoment = 0;
        } else {
            System.out.println("Невозможно высадить пассажиров, отсутствуют в машине");
        }
    }

    //инициализация дверей
    public void setCarDoors() {
        for (int i = 0; i < MAX_DOORS; i++) {
            cardoors[i] = new CarDoor();
        }
    }

    //инициализация колес
    public void setCarWheels() {
        wheelCounter = 4;
        for (int i = 0; i < wheelCounter; i++) {
            carwheels[i] = new CarWheel();
        }
    }

    //получить двери по индексу
    public CarDoor getCarDoor(int i) {
        if ((i >= 0) && (i <= MAX_DOORS - 1)) {
            return cardoors[i];
        } else {
            System.out.println("Дверей с таким индексом нет.");
            return null;
        }
    }

    //получить колесо по индексу
    public CarWheel getCarWheel(int i) {
        if ((i >= 0) && (i <= wheelCounter - 1)) {
            return carwheels[i];
        } else {
            System.out.println("Колёс с таким индексом нет");
            return null;
        }
    }

    //снять все колёса
    public void getOffAllCarWheels() {
        for (CarWheel carwheel : carwheels) {
            carwheel = null;
        }
        wheelCounter = 0;
    }

    //установить на машину Х новых колёс
    public void setNewWheels(int x) {
        if (x + wheelCounter > MAX_WHEELS) {
            System.out.println("Невозможно установить " + x + " колёс, будет  превышение макс. кол-ва " + MAX_WHEELS);
        } else {
            for (int i = 0; i < x; i++) {
                carwheels[wheelCounter + i] = new CarWheel();
            }
            wheelCounter += x;
        }
    }

    //вычислить возможную текущую макс. скорость
    public double getCurrentMaxSpeed(double minTWheel) {
        if ((numberPassengersMoment == 0) || (wheelCounter == 0)) {
            return 0;
        } else {
            return maxSpeed * minTWheel;
        }
    }

    //получить наиболее стертое колесо
    public double getMinTireWheel() {
        double result = carwheels[0].getTireState();
        for (int i = 0; i < wheelCounter; i++) {
            result = (carwheels[i].getTireState() < result) ? carwheels[i].getTireState() : result;
        }
        return result;
    }

    //получить текущее кол-во колёс
    public int getCurrentNumberOfWheels() {
        return wheelCounter;
    }

    //вывести всю информацию
    public void showInfo() {
        showInfoShort();
        System.out.println("Текущая возможная максимальная скорость: " + getCurrentMaxSpeed(getMinTireWheel()));
    }

    public void showInfoShort() {
        System.out.println("Дата производства машины: " + releaseDate);
        System.out.println("Тип двигателя: " + engineType);
        System.out.println("Максимальная скорость новой машины: " + maxSpeed);
        System.out.println("Время разгона до 100км/ч: " + accelerationTime);
        System.out.println("Пассажировместимость: " + passengers);
        System.out.println("Количество пассажиров в данный момент: " + numberPassengersMoment);
        System.out.println("Текущее количество колёс: " + wheelCounter);
        System.out.println("Текущая скорость: " + currentSpeed);
    }
}
