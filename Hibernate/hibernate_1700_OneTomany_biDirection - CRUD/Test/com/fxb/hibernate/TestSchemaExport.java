package com.fxb.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
public class TestSchemaExport {
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void beforeClass(){
/*
        new SchemaExport(new AnnotationConfiguration().configure()).create(false,true);
*/

        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    @Test
    public void save(){
        Student student = new Student();
        student.setName("fxb1");
        Student student2 = new Student();
        student2.setName("fxb2");
        Course course = new Course();
        course.getStudentSet().add(student);
        course.getStudentSet().add(student2);
        course.setName("Java");
        student.setCourse(course);
        student2.setCourse(course);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
    }
    @Test
    public void retrieve(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Course course = (Course) session.get(Course.class,5);
        for(Student s: course.getStudentSet()){
            System.out.println(s.getName());
        }
        session.getTransaction().commit();   //此时fetchType=eager，course-->student
                                               // 方式为eager 所以可以放到commit后面提取

    }

    @Test
    public void update(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = (Student)session.get(Student.class,4);

        student.setName("Ty");
        student.getCourse().setName("English");
        session.getTransaction().commit();
    }

    @Test
    public void delete(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
/*        Student student = (Student)session.get(Student.class,5);
          student.setCourse(null);
        session.delete(student);*/
        Query query = session.createQuery("delete from Student student where student.id=6");
        query.executeUpdate();
        session.getTransaction().commit();
    }

    @AfterClass
    public static void afterClass(){
        sessionFactory.close();
    }
}
