
public class Main{
    public static void main(String[] args) {
        Car car = new Car(1, "Kia", "Rio", 2010);
        car.refuel(5);
        car.stopEngine();
        car.startEngine();
        car.brake();
        car.accelerate(30);
        car.displayInfo();
    System.out.println();
    System.out.println();
        Aircraft aircraft = new Aircraft(1, "superjet", "100", 2012);
        aircraft.refuel(50);
        aircraft.startEngine();
        aircraft.accelerate(50);
        aircraft.takeOff();
        aircraft.land();
        aircraft.displayInfo();

    System.out.println();
    System.out.println();

        Boat boat = new Boat(4, "pell", "star", 1987);
        boat.refuel(10);
        boat.startEngine();
        boat.accelerate(90);
        boat.startSwimming();
        boat.brake();
        boat.stopSwimming();
        boat.stopEngine();


    }
}