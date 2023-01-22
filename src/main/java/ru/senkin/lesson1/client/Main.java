package ru.senkin.lesson1.client;

public class Main {
    public static void main(String[] args) {

        Client client = Client.builder()
                .withFirstName("Alex")
                .withLastName("Senkin")
                .withMiddleName("")
                .withGender("male")
                .withAge(41)
                .withCountry("Russia")
                .withPhone("123456789")
                .withAddress("Ryazan")
                .build();

        System.out.println(client);


    }
}