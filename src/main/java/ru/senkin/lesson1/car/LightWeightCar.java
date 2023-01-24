package ru.senkin.lesson1.car;

public class LightWeightCar extends Car implements CarProperties {
    @Override
    public void open() {
        System.out.println("LightWeightCar is open");
    }

    @Override
    public void start() {
        System.out.println("LightWeightCar is starting");
    }

    @Override
    public void move() {
        System.out.println("LightWeightCar is moving");
    }

    @Override
    public void stop(){
        System.out.println("LightWeightCar is stop");
    }

}
