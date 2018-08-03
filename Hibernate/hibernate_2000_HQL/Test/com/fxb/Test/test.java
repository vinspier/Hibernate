package com.fxb.Test;

import com.fxb.forum.Category;
import com.fxb.forum.Message;
import com.fxb.forum.Topic;
import com.sun.org.apache.regexp.internal.RESyntaxException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class test {
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void beforeClass(){
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }


    @Test
    public void testSchemaExport(){
        new SchemaExport(new AnnotationConfiguration().configure()).create(false,true);
    }

    @Test
    public void testSave(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        for(int i=0; i<10; i++){
            Category category = new Category();
            category.setName("C" + i);
            session.save(category);
        }
        for(int i=0; i<10; i++){
            Category category = new Category();
            category.setId(1);
           Topic topic = new Topic();
           topic.setCategory(category);
           topic.setTitle("t" + i);
           topic.setDate(new Date());
           session.save(topic);
        }
        for(int i=0; i<10; i++) {

            Topic topic = new Topic();
            topic.setId(1);
            Message message = new Message();
            message.setComment("m" + i);
            message.setTopic(topic);
            session.save(message);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void HQL_01(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
/*        Query query = session.createQuery("from Category");*/
/*        Query query = session.createQuery("from Category c order by c.name desc");*/
       /* select distinct c from Category c order by c.name desc*/
/*
        Query query = session.createQuery("from Category category where category.name > 'C6'");
*/
/*        Query q = session.createQuery("from Category c where c.id > ? and c.id < ?");
        q.setParameter(0, 2)
                .setParameter(1, 8);*/

/*        Query q = session.createQuery("from Category c order by c.name desc");
        q.setMaxResults(4);
        q.setFirstResult(2);*/

        Query query = session.createQuery("from Category c where c.id > :min and c.id < :max")
        		.setInteger("min", 2)
                .setInteger("max", 8);
        List<Category> categoryList = (List<Category>)query.list();
        for(Category category: categoryList){
            System.out.println(category.getId() + "----" +category.getName());
        }
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void HQL_02() {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query q = session.createQuery("select c.id,  c.name from Category c order by c.name desc");
            List<Object[]> categories = (List<Object[]>) q.list();
            for (Object[] o : categories) {
                System.out.println(o[0] + "-" + o[1]);
            }
            session.getTransaction().commit();
            session.close();
        }

    @Test //实现简单分页
    public void HQL_03(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Category c order by c.name desc ");
        query.setMaxResults(5);
        query.setFirstResult(3);
        List<Category> categories = (List<Category>)query.list();
        for(Category category: categories){
            System.out.println(category.getId() + "--" + category.getName());
        }
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void HQL_04() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query q = session.createQuery("select c.id,  c.name from Category c order by c.name ASC");
        List<Object[]> categories = (List<Object[]>)q.list();
        for(Object[] o : categories){
            System.out.println(o[0] + "-" + o[1]);
        }
        session.getTransaction().commit();
        session.close();
    }


    @Test
    public void HQL_05() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query q = session.createQuery(" from Topic t where t.category.id = 1");
        List<Topic> topics = (List<Topic>)q.list();
        for(Topic t : topics) {
            System.out.println(t.getTitle());
        }
        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void HQL_06() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Message m where m.topic.category.id = 1");

        for(Object o : q.list()) {
            Message m = (Message) o;
            System.out.println(m.getComment());
        }
        session.getTransaction().commit();
        session.close();
    }


/*    @Test
    public void HQL_07(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Message m = new Message();
        Query query = session.createQuery("select new com.fxb.forum.MessageInformation (m.id, m.cont, m.topic.title, m.topic.category.name) from Message ");
        session.getTransaction().commit();
        session.close();
    }*/
/*--------------------------------------------------------------------------------------------------------------------------------------------------------------*/

    //动手测试left right join
    //为什么不能直接写Category名，而必须写t.category
    //因为有可能存在多个成员变量（同一个类），需要指明用哪一个成员变量的连接条件来做连接

    @Test
    public void HQL_08(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query  query = session.createQuery("select t.title, c.name,c.id from Topic t join t.category c");
        for(Object o: query.list()){
            Object[] m = (Object[])o;
            System.out.println(m[0] + "--" + m[1] +"--" + m[2]);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void HQL_09(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query  query = session.createQuery("from Message m where m = :MessageToSearch");

/*
        Query q = session.createQuery("select count(*) from Message m");
        Query q1 = session.createQuery("select max(m.id), min(m.id), avg(m.id), sum(m.id) from Message m");
        Query q2 = session.createQuery("from Message m where m.id between 3 and 5");
        Query q3 = session.createQuery("from Message m where m.id in (3,4, 5)");
        Query q4 = session.createQuery("from Message m where m.comment is not null");
        */

        Message message = new Message();
        message.setId(2);
        query.setParameter("MessageToSearch",message);
        Message result = (Message)query.uniqueResult();
        System.out.println(result.getComment());
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void QBC(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Topic.class)
                .add(Restrictions.gt("id",2))
                .add(Restrictions.lt("id",8))
                .add(Restrictions.like("title","t_"))
                .createCriteria("category")
                .add(Restrictions.between("id",1,10))
                ;
        for(Object o: criteria.list()){
            Topic topic = (Topic)o;
            System.out.println(topic.getId() + "--" + topic.getTitle());
        }
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void QBE(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Topic topicExample = new Topic();
        topicExample.setTitle("t_");
        Example example = Example.create(topicExample)
                .ignoreCase().enableLike();
        Criteria criteria = session.createCriteria(Topic.class)
                .add(Restrictions.gt("id",2))
                .add(Restrictions.lt("id",8))
                .add(example);
        for(Object o: criteria.list()){
            Topic topic = (Topic)o;
            System.out.println(topic.getId() + "--" + topic.getTitle());
        }
        session.getTransaction().commit();
        session.close();
    }

    @AfterClass
    public static void afterClass(){
        sessionFactory.close();
    }
}
