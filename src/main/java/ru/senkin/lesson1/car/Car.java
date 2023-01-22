package ru.senkin.lesson1.car;

import java.util.Objects;

abstract public class Car {
    private Engine engine;
    //ОШИБКА в исходном коде: отсутствует реазизация класса Engine,
    // поле без спецификатора доступа private

    private String color;
    private String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return engine.equals(car.engine) && color.equals(car.color) && name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engine, color, name);
    }

    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
