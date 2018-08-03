package com.fxb.hibernate.model.model;

import com.fxb.hibernate.model.Scores;
import com.fxb.hibernate.model.Student;
import com.fxb.hibernate.model.StudentPk;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class StudentTest {
    private static SessionFactory sessionFactory = null;
    @BeforeClass
    public static void beforeClass(){
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }
    @Test
    public  void save(){
/*        StudentPk studentPk = new StudentPk();
        studentPk.setId(1);
        studentPk.setName("fxb");*/
        Student student = new Student();
        student.setId(2);
        student.setName("student3");

        student.setAge(33);
        student.setScore(Scores.C);



        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();

    }
    @AfterClass
    public static void afterClass(){
        sessionFactory.close();
    }
}
