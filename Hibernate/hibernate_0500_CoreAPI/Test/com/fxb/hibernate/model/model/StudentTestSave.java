package com.fxb.hibernate.model.model;

import com.fxb.hibernate.model.Scores;
import com.fxb.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class StudentTestSave {
    private static SessionFactory sessionFactory = null;
    @BeforeClass
    public static void beforeClass(){
        sessionFactory = new AnnotationConfiguration().configure("hibernate.xml").buildSessionFactory();
    }
    @Test
    public  void save(){
/*        StudentPk studentPk = new StudentPk();
        studentPk.setId(1);
        studentPk.setName("fxb");*/

        Student student = new Student();
        student.setId(5);
        student.setName("student3");

        student.setAge(33);
        student.setScore(Scores.C);



/*     Session session = sessionFactory.openSession(); //openSession()古老方法 永远打开新的session 手动close
      session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        */

      Session session = sessionFactory.getCurrentSession();      // 从上下文找 如果原来不在session 则创建一个session
                                                                    // 界定事务边界 自动close 事务自动提交
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();

/*      Session session1 = sessionFactory.getCurrentSession();
        System.out.println(session == session1);*/
    }
    @AfterClass
    public static void afterClass(){
        sessionFactory.close();
    }
}
