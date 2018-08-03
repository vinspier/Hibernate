package com.fxb.hibernate.model.model;

import com.fxb.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
public class StudentTestClear {
    private static SessionFactory sessionFactory = null;
    @BeforeClass
    public static void beforeClass(){
        sessionFactory = new AnnotationConfiguration().configure("hibernate.xml").buildSessionFactory();
    }

    @Test
    public void clear(){
        Session session =  sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = (Student) session.load(Student.class,2);
        System.out.println(student.getName());

        session.clear();

        Student student1 = (Student) session.load(Student.class,2);
        System.out.println(student1.getName());

        session.getTransaction().commit();
    }
    @AfterClass
    public static void afterClass(){
        sessionFactory.close();
    }
}
