package ru.senkin.lesson2.myArrayList;

import ru.senkin.lesson2.MyList;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> implements MyList<T> {
    private Integer size;

    private final Integer initSize = 10;

    private T[] array;

    public MyArrayList() {
        this.size = 0;
        this.array = (T[]) new Object[initSize];
    }

    @Override
    public void add(T value) {
        if (this.size >= this.array.length) {
            T[] ts = (T[]) new Object[this.initSize * 2];
            System.arraycopy(this.array, 0, ts,0, this.array.length);
            this.array = ts;
        }
        this.array[size] = value;
        this.size += 1;
    }

    @Override
    public void add(Integer index, T value) {
        if (index >= 0 && index <= this.array.length) {
            T[] ts = (T[]) new Object[this.size - index + 1];
            System.arraycopy(this.array, index - 1, ts,0, this.size - index + 1);
            this.array[index - 1] = value;
            System.arraycopy(ts, 0, this.array,index, ts.length);
            this.size += 1;
        }
    }

    @Override
    public void remove() {
        if (array.length > 0) {
            array[this.size - 1] = null;
            this.size -= 1;
        }
    }

    @Override
    public void remove(Integer index) {
        if (index > 0 && index <= this.size) {
            T[] ts = (T[]) new Object[this.size - index];
            System.arraycopy(this.array, index, ts,0, this.size - index);
            System.arraycopy(ts, 0, this.array, index - 1, ts.length);
            remove();
            arrayPack();
        }
    }

    @Override
    public T getItem(Integer index) {
        if (index < 0 || index > this.size) {
            return null;
        }
        return array[index - 1];
    }

    private void arrayPack() {
        if (this.size <= this.initSize) {
            T[] ts = (T[]) new Object[initSize];
            System.arraycopy(this.array, 0, ts,0, this.size);
            this.array = ts;
        }
    }

    @Override
    public void clear() {
        this.size = 0;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "size=" + size +
                ", initSize=" + initSize +
                ", arrayLength=" + array.length +
                ", array=" + Arrays.toString(array) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return Objects.equals(size, that.size) && Objects.equals(initSize, that.initSize) && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, initSize);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}
