abstract class Vehicle {
    private int id;
    private String brand;
    private String model;
    private int year; 

    public Vehicle(int id, String brand, String model, int year){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public int getId(){
        return id;
    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public int getYear(){
        return year;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setYear(int year){
        this.year = year;
    }

    abstract void startEngine();
    abstract void stopEngine();
    abstract void accelerate(int speed);
    abstract void brake();
    abstract void displayInfo();
    abstract void refuel(int liters);

}
