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
public class StudentTestDelete {
    private static SessionFactory sessionFactory = null;
    @BeforeClass
    public static void beforeClass(){
        sessionFactory = new AnnotationConfiguration().configure("hibernate.xml").buildSessionFactory();
    }

    @Test
    public void delete(){
        Student student = new Student();
        student.setId(3);

        Session session =  sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
    }
    @AfterClass
    public static void afterClass(){
        sessionFactory.close();
    }
}
