package ru.senkin.lesson1.car;

public class Lorry extends Car implements CarProperties {
    //ОШИБКА в исходном коде: неверный синтаксис, замена на implements
    //  добавление  метода open, start


    @Override
    public void open() {
        System.out.println("Lorry is open");
    }

    @Override
    public void start() {
        System.out.println("Lorry is starting");
    }

    @Override
    public void move(){
        System.out.println("Lorry is moving");
    }
    @Override
    public void stop(){
        System.out.println("Lorry is stop");
    }


}

