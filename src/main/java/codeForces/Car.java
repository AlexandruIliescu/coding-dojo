package codeForces;

public class Car implements Comparable<Car>{

    private String brand;
    private int horsePower;
    private int range;

    public Car(String brand, int horsePower, int range) {
        this.brand = brand;
        this.horsePower = horsePower;
        this.range = range;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", horsePower=" + horsePower +
                ", range=" + range +
                '}';
    }

    @Override
    public int compareTo(Car car) {
        if(this.horsePower > car.getHorsePower()){
            return 1;
        } else
            return -1;
    }
}