package com.ram.jmtt.zr.core.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
           //sessionFactory = new Configuration().configure().buildSessionFactory();

           sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
           
           System.out.println("-- Session factory [" + sessionFactory + "]");
           
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation (Выдернуть шнур, выдавить стекло) failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}