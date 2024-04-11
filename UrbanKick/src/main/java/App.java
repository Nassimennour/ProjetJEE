import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    private static SessionFactory sessionFactory;

    public static void init() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
    }

    public static Session getSession() {
        if (sessionFactory == null) {
            init();
        }
        return sessionFactory.openSession();
    }
}