package ru.senkin.lesson1.polymorphism;

import java.util.Objects;

public class Rectangle extends Figure implements Colorize {
    private final Integer Length;

    @Override
    public void colorize() {
        System.out.println("Rectangle is filling");
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "Length=" + Length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(Length, rectangle.Length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Length);
    }

    public Integer getLength() {
        return Length;
    }

    public Rectangle(String figureType, Integer length) {
        super(figureType);
        Length = length;
    }
}
