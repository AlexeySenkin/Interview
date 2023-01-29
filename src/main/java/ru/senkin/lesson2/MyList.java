package ru.senkin.lesson2;

public interface MyList<T> {
    void add(T value);
    void add(Integer index, T value);
    void remove();
    void remove(Integer index);
    T getItem(Integer index);
    void clear();


}
