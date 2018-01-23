package files.HW.HW5;

public class CarWheel {

        // class variables
        private double tirestate;    // [0,1]; 0 - out-of-date, 1 - new
        private static final double TIRESTATE_NEW = 1;
        private static final double TIRESTATE_OLD = 0;

        // constructor 1
        public CarWheel(){
            tirestate = 1;
        }

        // constructor2
        public CarWheel(double tirestate){
            if (checkTirestate(tirestate)){
                this.tirestate = tirestate;
            } else {
                System.out.println("Невозможно создать объект класса CarWheel");
            }
        }

        // method для проверки того, что значение находится внутри [0,1]
        private boolean checkTirestate(double tirestate){
            boolean result = ((tirestate >= TIRESTATE_OLD) && (tirestate <= TIRESTATE_NEW));
            if (!result) System.out.println("Неправильное значение изношенности \n" +
                    "Значение должно находиться внутри[0,1].");
            return result;
        }

        //methods
        public void setNewTire(){
            tirestate = TIRESTATE_NEW;
        }

        public void abradeTire(double x){
            if ((x >= 0) && (x <= 100)){
                tirestate *= (1 - (x / 100));
            } else {
                System.out.println("Невозможно выполнить, число должно находиться внутри [0,100]");
            }
        }

        public double getTireState(){
            return tirestate;
        }

        public void showInfo(){
            System.out.println("Состояние шины - " + getTireState() + " от новой.");
        }
}
