package ru.senkin.lesson1.polymorphism;

public class Main {
    public static void main(String[] args) {

        Figure rectangle = new Rectangle("flat",10);
        System.out.println(rectangle);
        rectangle.colorize();

        Figure circle = new Circle("flat",10);
        System.out.println(circle);
        circle.colorize();

        Figure triangle = new Triangle("flat", 10,20,30);
        System.out.println(triangle);
        triangle.colorize();


    }
}
