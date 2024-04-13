package Util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    private static SessionFactory sessionFactory;

    public static void init() {
        try {
            if (sessionFactory == null) {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }
        } catch (HibernateException e) {
            System.out.println("Error creating SessionFactory");
            e.printStackTrace();
        }
    }

    public static Session getSession() {
        if (sessionFactory == null) {
            init();
        }
        return sessionFactory.openSession();
    }
}