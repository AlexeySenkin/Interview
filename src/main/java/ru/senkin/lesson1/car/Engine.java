package ru.senkin.lesson1.car;

import java.util.Objects;

public class Engine {
    private final String model;

    public Engine(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return Objects.equals(model, engine.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }

    public String getModel() {
        return model;
    }
}
