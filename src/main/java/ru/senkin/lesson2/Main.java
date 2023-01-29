package ru.senkin.lesson2;

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
        integerMyLinkedList.remove(100);
        System.out.println(integerMyLinkedList);
        System.out.println(integerMyLinkedList.getItem(2));
        integerMyLinkedList.clear();
        System.out.println(integerMyLinkedList);




        //System.out.println("MyArrayList");

    }
}
