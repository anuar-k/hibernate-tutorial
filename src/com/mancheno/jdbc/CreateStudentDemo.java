package com.mancheno.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            Student tempStudent = new Student("Anuar", "Kurmanbayev", "paul@mail.ru");

            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("save object");
            session.save(tempStudent);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}