package ru.senkin.lesson2.myLinkedList;
import ru.senkin.lesson2.MyList;

import java.util.Objects;

public class MyLinkedList<T> implements MyList<T> {
    private Integer size;
    private Node<T> first;
    private Node<T> last;

    public MyLinkedList() {
        this.size = 0;
    }
    @Override
    public void add(T value) {
        if (this.size == 0) {
            this.size = 1;
            this.first = new Node<>(value, null, null);
            this.last = this.first;
        } else {
            this.size += 1;
            this.last = new Node<>(value, null, last);
            this.last.getPrev().setNext(last);
        }
    }

    @Override
    public void add(Integer index, T value) {
        if (index < 0 || value == null) {
            return;
        }
        if (this.size == 0) {
            add(value);
        } else {
            if (index == 0) {
                this.first = new Node<>(value, this.first, null);
                this.size += 1;
            } else {
                Node<T> elementTNode = getNodeByIndex(index);
                if (elementTNode == null) {
                    add(value);
                } else {
                    Node<T> newElement = new Node<>(value, elementTNode, elementTNode.getPrev());
                    elementTNode.getPrev().setNext(newElement);
                    this.size += 1;
                }
            }
        }
    }

    @Override
    public void remove() {
        if (this.size == 0) {
            return;
        }
        this.last.getPrev().setNext(null);
        this.size -= 1;
    }

    @Override
    public void remove(Integer index) {
        if (index < 0 || this.size == 0 || index > this.size) {
            return;
        }
        if (index == 0) {
            this.first = this.first.getNext();
        } else {
            Node<T> elementTNode = getNodeByIndex(index);
            if (elementTNode != null) {
                elementTNode.getPrev().setNext(elementTNode.getNext());
            }
        }
        this.size -= 1;
    }

    @Override
    public T getItem(Integer index) {
        if (index < 0 || this.size == 0 || index > this.size) {
            return null;
        }
        return Objects.requireNonNull(getNodeByIndex(index)).getItem();
    }

    private Node<T> getNodeByIndex(Integer index) {
        int count = 1;
        Node<T> elementTNode = this.first;
        while (elementTNode != null & count < index) {
            count += 1;
            elementTNode = elementTNode.getNext();
        }
        return elementTNode;
    }

    @Override
    public void clear() {
        this.first = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        if (this.size == 0) return  "size = " + this.size;
        else {
            StringBuilder result = new StringBuilder("size = " + this.size + ": ");
            Node<T> elementTNode = this.first;
            while (elementTNode != null) {
                result.append("{").append(elementTNode.getItem().toString()).append("} ");
                elementTNode = elementTNode.getNext();
            }
            return result.toString();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        return Objects.equals(size, that.size) && Objects.equals(first, that.first) && Objects.equals(last, that.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, first, last);
    }
}
