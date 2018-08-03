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

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
    public void testList(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Category> categories = (List<Category>)session.createQuery("from Category ").list();
        //list查询时会直接取出所有需要查询的对象
        for(Category c: categories){
            System.out.println(c.getId() + "--" + c.getName());
        }
        List<Category> categories1 = (List<Category>)session.createQuery("from Category ").list();
        //List再次访问的时候 还会再去访问数据库
        for(Category c: categories1){
            System.out.println(c.getId() + "--" + c.getName());
        }
        session.getTransaction().commit();
        session.close();
    }


    @Test
    public void testIterate(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Iterator<Category> categories = (Iterator<Category>)session.createQuery("from Category ").iterate();
        //Iterator第一次访问时 先取id（主键），等要用到的时候再根据id来取对象
        while(categories.hasNext()){
            Category category = categories.next();
            System.out.println(category.getId() + "--" + category.getName());
        }
        Iterator<Category> categories1 = (Iterator<Category>)session.createQuery("from Category ").iterate();
        //Iterator再次访问的时候 先回去访问session级的缓存 若不存在 再去想数据库访问
        while(categories1.hasNext()){
            Category category = categories1.next();
            System.out.println(category.getId() + "--" + category.getName());
        }
        session.getTransaction().commit();
        session.close();
    }


    @Test
    public void testCache1() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Category c = (Category)session.load(Category.class, 1);
        System.out.println(c.getName());

        //同个session  session级别的一级缓存
        Category c2 = (Category)session.load(Category.class, 1);
        System.out.println(c2.getName());
        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void testCache2() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Category c = (Category)session.load(Category.class, 1);
        System.out.println(c.getName());


        session.getTransaction().commit();
        session.close();
        //跨session
        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        Category c2 = (Category)session2.load(Category.class, 1);
        System.out.println(c2.getName());


        session2.getTransaction().commit();
        session2.close();
    }

    @Test
    public void testQueryCache() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Category> categories = (List<Category>)session.createQuery("from Category")
                .setCacheable(true).list();
        session.getTransaction().commit();
        session.close();
//在 hibernate.cfg.xml中设置开启缓存 <property name="cache.use_query_cache">true</property> 可跨越session
        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        List<Category> categories2 = (List<Category>)session2.createQuery("from Category")
                .setCacheable(true).list();
        for(Category c:categories2){
            System.out.println(c.getId() + "--" + c.getName());
        }
        session2.getTransaction().commit();
        session2.close();
    }

    @AfterClass
    public static void afterClass(){
        sessionFactory.close();
    }
}
