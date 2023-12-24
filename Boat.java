public class Boat extends Vehicle implements Swimmable{
    enum State {
        On, Off
    }
    private final int MAXSPEED; //максимальная скорость на воде
    private boolean isSailing; // флаг состояния движения по воде
    private int speed;
    private int currentFuelLevel;
    private State state = State.Off;

    public Boat(int id, String brand, String model, int year) {
        super(id, brand, model, year);
        this.MAXSPEED = 80;
        this.isSailing = false;
    }

    @Override
    void startEngine() {
        if(this.state == State.Off && currentFuelLevel > 0){
            System.out.println("Запуск двигателя");
            this.state = State.On;
        }
    }

    @Override
    void stopEngine() {
        if(this.state == State.On && speed == 0){
            System.out.println("Остановка двигателя");
            this.state = State.Off;
        }
    }

    @Override
    void accelerate(int speed) {
        if (this.state == State.On && currentFuelLevel > 0 && this.speed + speed <= MAXSPEED) {
            this.speed += speed;
            System.out.printf("Скорость %d\n", speed);
        }else{
            System.out.println("Превышение скорости");
        }
    }

    @Override
    void brake() {
        this.speed = 0;
        System.out.println("Прекращение движения");
    }

    @Override
    public void displayInfo() {
        System.out.printf("Boat id = %d, brand = %s, model = %s, year = %d",
                getId(), getBrand(), getModel(), getYear());
    }

    @Override
    void refuel(int liters) {
        this.currentFuelLevel += liters;
        System.out.println("Заправка топливом");
    }

    @Override
    public void startSwimming() {
        if(this.speed > 0 && this.currentFuelLevel > 0){
            System.out.println("Лодка плывет");
            this.isSailing = true;
        }
    }

    @Override
    public void stopSwimming() {
        if(isSailing){
            this.speed = 0;
            this.isSailing = false;
            System.out.println("Лодка не плывет");
        }
    }
    
}
