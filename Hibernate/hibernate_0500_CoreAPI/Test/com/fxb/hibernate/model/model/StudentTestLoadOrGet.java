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
public class StudentTestLoadOrGet {
    private static SessionFactory sessionFactory = null;
    @BeforeClass
    public static void beforeClass(){
        sessionFactory = new AnnotationConfiguration().configure("hibernate.xml").buildSessionFactory();
    }

    @Test
    public void load(){
        Session session =  sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = (Student) session.load(Student.class,2);
        //load返回的是代理对象 等到真正的用到对象的内容的时才会发出sql语句
        // student.getName()
        System.out.println(student.getName());
        session.getTransaction().commit();
        System.out.println(student.getClass());
    }

    @Test
    public void get(){
        Session session =  sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = (Student) session.get(Student.class,2);
        //get直接从数据库加载 发出sql语句 不会延迟
        System.out.println(student.getName());
        session.getTransaction().commit();
        System.out.println(student.getClass());


    }

    @AfterClass
    public static void afterClass(){
        sessionFactory.close();
    }
}
