import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;

import java.util.List;

public class HibernateBasicsTutorial {

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        ArtistService service = new ArtistService(session);

        System.out.println("--- Create and persist artist ---");
        Transaction transaction = session.beginTransaction();
        Artist artist = service.createArtist(1, "John Lennon", "Rock");
        transaction.commit();
        System.out.println(String.format("Persisted: %s\n", artist));

        System.out.println("--- Find artist ---");
        artist = service.findArtist(1);
        System.out.println(String.format("Found: %s\n", artist));

        System.out.println("--- Find all artists ---");
        List<Artist> artists = service.findAllArtists();
        for (Artist currentArtist: artists)
        {
            System.out.println(String.format("Found: %s\n", currentArtist));
        }

        System.out.println("--- Update artist ---");
        transaction = session.beginTransaction();
        artist = service.changeArtistGenre(1, "Indie Rock");
        transaction.commit();
        System.out.println(String.format("Updated: %s\n", artist));

        System.out.println("--- Remove artist ---");
        transaction = session.beginTransaction();
        service.removeArtist(1);
        transaction.commit();
        artist= service.findArtist(1);
        System.out.println(String.format("Found: %s\n", artist));

        session.close();
        sessionFactory.close();

    }

}
