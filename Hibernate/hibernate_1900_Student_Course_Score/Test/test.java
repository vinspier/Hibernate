import com.fxb.hibernate.Organization;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.OneToMany;

/**
 * Created by Administrator on 2017/7/30 0030.
 */
public class test {
    private static SessionFactory sessionFactory;
    @BeforeClass
    public static void beforeClass(){
        new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }


    @Test
    public void test(){
        Organization o = new Organization();
        o.setName("A");
        Organization o1 = new Organization();
        o1.setName("A1");
        Organization o2 = new Organization();
        o2.setName("A2");
        Organization o11 = new Organization();
        o11.setName("A1_B1");
        Organization o12= new Organization();
        o12.setName("A1_B2");

        o.getChildren().add(o1);
        o.getChildren().add(o2);
        o1.getChildren().add(o11);
        o1.getChildren().add(o12);
        o11.setParent(o1);
        o12.setParent(o1);
        o1.setParent(o);
        o2.setParent(o);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testLoad() {
        test();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Organization o = (Organization) session.load(Organization.class, 1);
        print(o, 0);
        session.getTransaction().commit();
        session.close();

    }

    private void print( Organization o, int level) {
        String preStr = "";
        for(int i=0; i<level; i++) {
            preStr += "----";
        }
        System.out.println(preStr + o.getName());
        for(Organization child : o.getChildren()) {
            print(child, level+1);
        }
    }

    @AfterClass
    public static void afterClass() {
        sessionFactory.close();
    }

}
