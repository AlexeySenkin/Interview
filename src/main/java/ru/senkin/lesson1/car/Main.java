package ru.senkin.lesson1.car;

public class Main {
    public static void main(String[] args) {

        Lorry lorry = new Lorry();
        lorry.setName("MAN");
        lorry.setEngine(new Engine("1"));
        lorry.setColor("red");
        System.out.println(lorry);
        System.out.println(lorry.getEngine());
        lorry.open();
        lorry.start();
        lorry.move();
        lorry.stop();

        LightWeightCar lightWeightCar = new LightWeightCar();
        lightWeightCar.setName("VOLVO");
        lightWeightCar.setEngine(new Engine("2"));
        lightWeightCar.setColor("black");
        System.out.println(lightWeightCar);
        System.out.println(lightWeightCar.getEngine());
        lightWeightCar.open();
        lightWeightCar.start();
        lightWeightCar.move();
        lightWeightCar.stop();

    }
}
