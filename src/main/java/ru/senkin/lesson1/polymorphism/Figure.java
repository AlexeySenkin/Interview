package ru.senkin.lesson1.polymorphism;

import java.util.Objects;

public abstract class Figure implements Colorize {
    private final String figureType;

    @Override
    public void colorize() {
        System.out.println("Figure is filling");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Objects.equals(figureType, figure.figureType);
    }

    public String getFigureType() {
        return figureType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(figureType);
    }

    public Figure(String figureType) {
        this.figureType = figureType;
    }
}
