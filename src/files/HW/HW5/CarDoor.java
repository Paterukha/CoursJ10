package files.HW.HW5;

public class CarDoor {

        // class variables
        private boolean doorOpened;
        private boolean windowOpened;

        // constructor1
        public CarDoor(){
            doorOpened = false;
            windowOpened = false;
        }

        // constructor2
        public CarDoor(boolean doorOpened, boolean windowOpened){
            this.doorOpened = doorOpened;
            this.windowOpened= windowOpened;
        }


        // methods
        public void openDoor(){
            doorOpened = true;
        }

        public void closeDoor(){
            doorOpened = false;
        }

        public void setDoor(){
            doorOpened = !doorOpened;
        }

        public void openWindow(){
            windowOpened = true;
        }

        public void closeWindow(){
            windowOpened = false;
        }

        public void setWindow(){
            windowOpened = !windowOpened;
        }

        public boolean getDoor(){
            return doorOpened;
        }

        public boolean getWindow(){
            return windowOpened;
        }

        public void showInfo(){
            System.out.println("Двери машини " + ((getDoor()?"открыты":"закриты")));
            System.out.println("Окна машини " + ((getWindow()?"открыты":"закриты")));
        }
}
