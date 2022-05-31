package com.company;

public class Veh {
        private String name;
        private int currentSpeed;
        private int currentGear;
        private boolean isStart; //engineState

        public Veh(String name) {
            this.name = name;
            isStart = false;
            currentGear = 0;
            currentSpeed = 0;
        }

        public void start(){
            isStart = true;
        }

        public void turnOff(){
            if(currentGear == 0)
                isStart = false;
            else
                System.out.println("Error: Please set Gear to zero before Turning-Off Engine\n");
        }

        public void gearUp(){
            int gear = currentGear + 1;
            setCurrentGear(gear);
        }

        public void gearDown(){
            int gear = currentGear - 1;
            setCurrentGear(gear);
        }


        public void setCurrentGear(int gear){
            if(isStart) {
                if (gear >= 0 && gear <= 4) {
                    currentGear = gear;
                    setCurrentSpeed(gear);
                } else {
                    System.out.println("Error: Invalid Gear Min:0 & Max:4");
                }
            }
            else {
                System.out.println("Error: Please Turn On Engine First\n");
            }
        }

        public void setCurrentSpeed(int gear){
            switch(gear){
                case 0:
                    currentSpeed = 0;
                    break;
                case 1:
                    currentSpeed = 20;
                    break;
                case 2:
                    currentSpeed = 40;
                    break;
                case 3:
                    currentSpeed = 80;
                    break;
                case 4:
                    currentSpeed = 120;
                    break;
            }
        }

        public void display(){
            String engin_state = (isStart) ? "On":"Off";
            System.out.println("----------Car State Display-----------");
            System.out.println("Manufacturer Name: "+name+", Engine: "+engin_state+
                    "\nCurrent Gear: "+currentGear+", Current Speed: "+currentSpeed+" Km/h\n");
        }

    public static void main(String[] args) {
        Veh v = new Veh("Kia");
        v.display();
        v.gearUp();
        v.start();
        v.gearUp();
        v.display();

        v.gearUp();
        v.gearUp();
        v.gearUp();
        v.display();

        v.gearUp();

        v.turnOff();

        v.gearDown();
        v.gearDown();
        v.gearDown();
        v.gearDown();
        v.display();
        v.turnOff();

        v.display();
    }
}
