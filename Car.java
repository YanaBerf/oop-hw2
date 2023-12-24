public class Car extends Vehicle {
    enum State {
        On, Off
    }
    private  final int FUELCAPACITY; // емкость топливного бака
    private  int currentFuelLevel;
    private int speed;
    private State state = State.Off;
   // int liters;


    public Car(int id, String brand, String model, int year, int FUELCAPACITY, int currentFuelLevel, int speed){
        super(id, brand, model, year);
        this.FUELCAPACITY = FUELCAPACITY;
        this.currentFuelLevel = currentFuelLevel;
        this.speed = speed;
    }

    public Car(int id, String brand, String model, int year) {
        super(id, brand, model, year);
        this.FUELCAPACITY = 70;
        this.currentFuelLevel = 0;
    }

    @Override
    void displayInfo(){
        System.out.printf("Car id = %d, brand = %s, model = %s, year = %d, full-capacity = %d, current-capacity = %d",
         getId(), getBrand(), getModel(), getYear(), FUELCAPACITY, currentFuelLevel);
    }

    @Override
    void startEngine(){
        if(this.state == State.Off && this.currentFuelLevel != 0){
            this.state = State.On;
            System.out.println("Запуск двигателя");
        }else{
            System.out.println("Ошибка! Возможно топливо на нуле!");
        }
    }
    @Override
    void stopEngine(){
        if((this.state == State.On) || (this.state == State.On && this.currentFuelLevel == 0)){
            this.state = State.Off;
            System.out.println("Остановка двигателя");
           
        }else{
            System.out.println("Ошибка!");
        }

    }
    @Override
    void accelerate(int speed){
        if(this.state == State.On){
            this.speed += speed;
            System.out.printf("Движение со скоростью - %d км/ч\n", this.speed);
        }
    }
    @Override
    void brake(){
        if(this.state == State.On){
            this.speed = 0;
            System.out.println("Прекращение движения");
        }
    }
    
    @Override
    void refuel(int liters){
        if(currentFuelLevel + liters <= FUELCAPACITY){
            this.currentFuelLevel += liters;
            System.out.printf("Запрака топлива на %d литров\n", liters);
        }else{
            System.out.println("Из бака выливается топливо! ");
        }
    }
}
