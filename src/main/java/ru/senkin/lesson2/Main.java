package ru.senkin.lesson2;

import ru.senkin.lesson2.myArrayList.MyArrayList;
import ru.senkin.lesson2.myLinkedList.MyLinkedList;


public class Main {
    public static void main(String[] args) {
        System.out.println("MyLinkedList");
        MyLinkedList<Integer> integerMyLinkedList= new MyLinkedList<>();
        System.out.println(integerMyLinkedList);
        integerMyLinkedList.add(100);
        System.out.println(integerMyLinkedList);
        integerMyLinkedList.add(200);
        System.out.println(integerMyLinkedList);
        integerMyLinkedList.add(300);
        System.out.println(integerMyLinkedList);
        integerMyLinkedList.add(400);
        System.out.println(integerMyLinkedList);
        integerMyLinkedList.add(500);
        System.out.println(integerMyLinkedList);
        integerMyLinkedList.add(0, 0);
        System.out.println(integerMyLinkedList);
        integerMyLinkedList.add(3, 250);
        System.out.println(integerMyLinkedList);
        integerMyLinkedList.add(10, 1000);
        System.out.println(integerMyLinkedList);
        integerMyLinkedList.remove();
        System.out.println(integerMyLinkedList);
        integerMyLinkedList.remove(7);
        System.out.println(integerMyLinkedList);
        System.out.println(integerMyLinkedList.getItem(2));
        integerMyLinkedList.clear();
        System.out.println(integerMyLinkedList);

        System.out.println("MyArrayList");

        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>();
        System.out.println(integerMyArrayList);
        integerMyArrayList.add(10);
        integerMyArrayList.add(20);
        integerMyArrayList.add(30);
        integerMyArrayList.add(40);
        integerMyArrayList.add(50);
        integerMyArrayList.add(60);
        integerMyArrayList.add(70);
        integerMyArrayList.add(80);
        integerMyArrayList.add(90);
        integerMyArrayList.add(100);
        System.out.println(integerMyArrayList);
        integerMyArrayList.add(110);
        System.out.println(integerMyArrayList);
        integerMyArrayList.add(5,99);
        System.out.println(integerMyArrayList);
        integerMyArrayList.remove();
        System.out.println(integerMyArrayList);
        integerMyArrayList.remove(5);
        System.out.println(integerMyArrayList);
        System.out.println(integerMyArrayList.getItem(5));
        integerMyArrayList.clear();
        System.out.println(integerMyArrayList);


    }
}
