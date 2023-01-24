package ru.senkin.lesson1.polymorphism;

import java.util.Objects;

public class Circle extends Figure implements Colorize {
    private final Integer Radius;

    @Override
    public void colorize() {
        System.out.println("Circle is filling");
    }

    @Override
    public String toString() {
        return "Circle{" +
                "Radius=" + Radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Objects.equals(Radius, circle.Radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Radius);
    }

    public Integer getRadius() {
        return Radius;
    }

    public Circle(String figureType, Integer radius) {
        super(figureType);
        Radius = radius;
    }
}
