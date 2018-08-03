import com.fxb.hibernate.Course;
import com.fxb.hibernate.Score;
import com.fxb.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Administrator on 2017/7/30 0030.
 */
public class test{
    private static SessionFactory sessionFactory;
    @BeforeClass
    public static void beforeClass(){
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }


    @Test
    public void test(){

        Student student = new Student();
        student.setName("fxb");
        Course course = new Course();
        course.setName("java");
        Score score = new Score();
        score.setGrade(100);
        score.setStudent(student);
        score.setCourse(course);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.save(course);
        session.save(score);
        session.getTransaction().commit();
        session.close();
    }


    @Test
    public  void main(){
        new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);

    }

    @AfterClass
    public static void afterClass() {
        sessionFactory.close();
    }

}
