import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;

public class HibernateBasicsTutorial {

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        ArtistService service = new ArtistService(session);


    }

}
