package com.mancheno.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadStudentDemo {
    public static void main(String[] args) throws Exception {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            Student tempStudent = new Student("Bill", "Geitc", "bill@mail.ru");
            System.out.println("begin transaction");
            //begin transaction
            session.beginTransaction();
            //save object
            System.out.println("save object");
            session.save(tempStudent);
            session.getTransaction().commit();
            System.out.println("Done!");
            //get student
            System.out.println(tempStudent.getId());
            //get new session
            System.out.println("Starting get object of DB with ID: " + tempStudent.getId());
            session = factory.getCurrentSession();
            session.beginTransaction();

            Student myStudent = session.get(Student.class, 10);
            System.out.println("Get complete " + myStudent);
            session.getTransaction().commit();
            System.out.println("Done!");
            List<Student> s = session.createQuery("from Student").getResultList();
        } finally {
            factory.close();
        }
    }
}