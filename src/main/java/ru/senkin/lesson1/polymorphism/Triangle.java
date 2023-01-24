package ru.senkin.lesson1.polymorphism;

import java.util.Objects;

public class Triangle extends Figure implements Colorize {
    private final Integer A;
    private final Integer B;

    @Override
    public void colorize() {
        System.out.println("Triangle is filling");
    }

    private final Integer C;

    public Integer getA() {
        return A;
    }

    public Integer getB() {
        return B;
    }

    public Integer getC() {
        return C;
    }

    public Triangle(String figureType, Integer a, Integer b, Integer c) {
        super(figureType);
        A = a;
        B = b;
        C = c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(A, triangle.A) && Objects.equals(B, triangle.B) && Objects.equals(C, triangle.C);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), A, B, C);
    }
}
