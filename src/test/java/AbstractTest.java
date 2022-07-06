import configuration.SessionFactoryUtil;
import entity.TransportCompany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import java.util.Date;

public abstract class AbstractTest {
    protected static SessionFactory sessionFactory = null;
    protected Session session = null;

    @BeforeAll
    static void setup(){
        try {
            sessionFactory = SessionFactoryUtil.getSessionFactory();
            System.out.println("SessionFactory created");

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    @BeforeEach
    void setupThis(){
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @AfterEach
    void tearThis(){
        session.getTransaction().commit();
    }

    @AfterAll
    static void tear(){
        sessionFactory.close();
    }
}
