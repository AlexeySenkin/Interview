package ru.senkin;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import ru.senkin.model.Student;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        StudentRepository studentRepository = new StudentRepository(entityManagerFactory);

//        Первичное заполнение таблицы Students на 1000 строк
//        for (int i = 0; i < 1000; i++) {
//            String name = "Student " + i;
//            String mark = String.valueOf(i);
//            studentRepository.save(new Student(name,mark));
//        }

        Optional<Student> optionalStudent = studentRepository.findById(1L);
        if (optionalStudent.isPresent()) {
            System.out.println(optionalStudent);
        } else {
            System.out.println("Student By Id not found");
        }

        studentRepository.deleteById(2L);
        optionalStudent = studentRepository.findById(2L);
        if (optionalStudent.isPresent()) {
            System.out.println(optionalStudent);
        } else {
            System.out.println("Student By Id not found");
        }

        optionalStudent = studentRepository.findById(3L);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setMark("999999");
            studentRepository.save(student);
        } else {
            System.out.println("Student By Id not found");
        }
        optionalStudent = studentRepository.findById(3L);
        if (optionalStudent.isPresent()) {
            System.out.println(optionalStudent);
        } else {
            System.out.println("Student By Id not found");
        }

        System.out.println(studentRepository.findAll());


    }
}