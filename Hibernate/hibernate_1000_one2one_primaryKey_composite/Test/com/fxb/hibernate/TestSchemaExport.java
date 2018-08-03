package com.fxb.hibernate;

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
         sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }

     @Test
    public void testSchemaExport(){
        new SchemaExport(new AnnotationConfiguration().configure()).create(false,true);
    }
    @AfterClass
    public static void afterClass(){
        sessionFactory.close();
    }
}
