package com.mancheno.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            System.out.println("---------------begin transaction---------------");
            session.beginTransaction();
            //query students
            List<Student> tempStudents = session.createQuery("from Student").getResultList();
            //display the students
            displayTheStudents(tempStudents);
            System.out.println("---------------Student with firstName is :Anuar---------------");
            tempStudents = session.createQuery("from Student s where  s.firstName ='Anuar'").getResultList();
            displayTheStudents(tempStudents);
            System.out.println("---------------Student with email like 'ar@mail' is :Anuar---------------");
            tempStudents = session.createQuery("from Student s where s.email LIKE '%ar@mail.ru'").getResultList();
            displayTheStudents(tempStudents);
            //commit transcation
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

    private static void displayTheStudents(List<Student> tempStudents) {
        for (Student tmp : tempStudents) {
            System.out.println(tmp);
        }
    }
}