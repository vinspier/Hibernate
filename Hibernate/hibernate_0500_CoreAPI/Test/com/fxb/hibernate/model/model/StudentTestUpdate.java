package com.fxb.hibernate.model.model;

import com.fxb.hibernate.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
public class StudentTestUpdate {
    private static SessionFactory sessionFactory = null;
    @BeforeClass
    public static void beforeClass(){
        sessionFactory = new AnnotationConfiguration().configure("hibernate.xml").buildSessionFactory();
    }

    @Test
    public void update(){
        Student student = new Student();  //更新全部字段  只设定所设置的字段内容 其他字段更新为空
        student.setId(3);
        student.setName("fxb");

        Session session =  sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
    }
    @Test
    public void update1(){
        Session session =  sessionFactory.getCurrentSession(); //更新全部 指定的字段更新 其他的字段也更新为原来的内容
        session.beginTransaction();
        Student student = (Student)session.get(Student.class,5);
        student.setName("fxb1");
        session.getTransaction().commit();
    }

    @Test
    public void update2(){
        Session session =  sessionFactory.getCurrentSession(); //只更新指定的字段
        session.beginTransaction();
        Query query = session.createQuery("update Student student set student.name='VinSpier' where student.id=5");
        query.executeUpdate();
        session.getTransaction().commit();
    }
    @AfterClass
    public static void afterClass(){
        sessionFactory.close();
    }
}
