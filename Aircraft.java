
public class Aircraft extends Vehicle implements Flyable{
     enum State{
        On, Off
    }
    private int speed;
    private int currentFuelLevel;
    private int maxAltitude; //  макс высота полета
    private boolean isFlying; // флаг состояния полета
    private State state = State.Off;
   

    public Aircraft(int id, String brand, String model, int year){
        super(id, brand, model, year);
        //this.maxAltitude = maxAltitude;
        this.isFlying = false;

    }

    @Override
    void startEngine(){
        if(this.state == State.Off){
            this.state = State.On;
            this.speed = 0;
            System.out.println("Запуск двигателя");
        }else{
            System.out.println("Ошибка!");
        }
    }
    @Override
    void stopEngine(){
        if(this.state == State.On && isFlying == false){
            this.state = State.Off;
            System.out.println("Остановка двигателя");
        }else{
            System.out.println("Ошибка!");
        }
    }
    @Override
    void displayInfo(){
        System.out.printf("Plane id = %d, brand = %s, model = %s, year = %d, maxFlightAltitude = %d", 
        getId(), getBrand(), getModel(), getYear(), maxAltitude);
    }
    @Override
    public void takeOff(){
        accelerate(this.speed);
        if(this.state == State.On && this.speed != 0 && currentFuelLevel > 0){
            this.isFlying = true;
            this.maxAltitude = 1000;
            System.out.println("Взлет");
        }else{
            System.out.println("Ошибка!");
        }
    }
    @Override
    public void land(){
        if(isFlying){
            this.maxAltitude = 0;
            this.speed = 0;
        }
        this.isFlying = false;
        brake();
        stopEngine();
    }
    @Override
    void refuel(int liters){
        this.currentFuelLevel += liters;
        System.out.println("Запрака топливом");
    }
    @Override
    void accelerate(int speed) {
        if(this.state == State.On){
            this.speed += speed;
            System.out.printf("Набор скорости %d", this.speed);
        }
    }
    @Override
    void brake(){
        if(isFlying == false){
        System.out.println("Прекращение движения");
        }   
    }
}