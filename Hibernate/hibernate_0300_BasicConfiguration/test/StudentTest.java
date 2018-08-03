import com.fxb.hibernate.model.Student;
import com.fxb.hibernate.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class StudentTest {
    private static SessionFactory sessionFactory = null;
    @BeforeClass
    public static void beforeClass(){
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }
    @Test
    public  void studentSave(){
        Student student = new Student();
        student.setId(2);
        student.setName("student2");
        student.setAge(22);
        student.setDate(new Date());

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();

    }
    @Test
    public void teacherSave(){
        Teacher teacher = new Teacher();
        teacher.setId(2);
        teacher.setName("teacher2");
        teacher.setTitle("马士兵");

        Configuration configuration = new AnnotationConfiguration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
    //检验配置文件是否出错
/*    public static void main(String[] args){
        beforeClass();
    }*/
    @AfterClass
    public static void afterClass(){
        sessionFactory.close();
    }
}
