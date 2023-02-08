package ru.senkin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import ru.senkin.model.Student;

import java.util.List;
import java.util.Optional;

public class StudentRepository {

    private final EntityManagerFactory entityManagerFactory;

    public StudentRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public Optional<Student> findById(long id) {
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       try {
           Student student = entityManager.find(Student.class,id);
           return Optional.ofNullable(student);
       } finally {
           entityManager.close();
      }
    }

    public List<Student> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("select p from Student p", Student.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    public void save(Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            if (student.getId() == null) {
                entityManager.persist(student);
            } else {
                entityManager.merge(student);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        finally {
            entityManager.close();
        }
    }

    public void deleteById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("delete from Student p where p.id = " + id ).executeUpdate();
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }

    }

}
