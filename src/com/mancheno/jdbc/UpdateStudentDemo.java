package com.mancheno.jdbc;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            // update email for all students
            System.out.println("Update email for all students");
            session.createQuery("update Student set email='student@gmail.com'").executeUpdate();
            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}