import com.fxb.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class studentTest {
    public static void main(String[] args){
        Student student = new Student();
        student.setId(2);
        student.setName("student1");
        student.setAge(11);

        Configuration  configuration = new Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
