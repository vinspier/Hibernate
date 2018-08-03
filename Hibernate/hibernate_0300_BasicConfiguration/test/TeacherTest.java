import com.fxb.hibernate.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class TeacherTest {
    @Test
    public void save(){
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
}
