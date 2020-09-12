package com.mancheno.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) throws Exception {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            //create 3 students
            Student tempStudent = new Student("John", "Lennon", "anuar@mail.ru");
            Student tempStudent2 = new Student("Bill", "lee", "anuar@mail.ru");
            Student tempStudent3 = new Student("Katy", "Siera", "anuar@mail.ru");
            System.out.println("begin transaction");
            session.beginTransaction();
            System.out.println("save 3 object");
            session.save(tempStudent);
            session.save(tempStudent2);
            session.save(tempStudent3);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}