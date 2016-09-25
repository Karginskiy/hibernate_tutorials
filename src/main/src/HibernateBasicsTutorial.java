import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;

import java.util.List;

/**
 * This class just checking the work of service.
 */

public class HibernateBasicsTutorial {

    public static void main(String[] args) {

        // Configuration instance from the hibernate.cfg.xml
        Configuration configuration = new Configuration().configure();
        // Create registry for the current settings
        // From this registry we are getting connections to your tables
        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        // Create session factory for the current config.
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        // Getting session from the factory
        Session session = sessionFactory.openSession();
        // Creating ArtistService for the taken session.
        ArtistService service = new ArtistService(session);

        // Testing the createArtist function.
        System.out.println("--- Create and persist artist ---");
        Transaction transaction = session.beginTransaction();
        Artist artist = service.createArtist(1, "John Lennon", "Rock");
        transaction.commit();
        System.out.println(String.format("Persisted: %s\n", artist));

        // Testing the findArtist function.
        System.out.println("--- Find artist ---");
        artist = service.findArtist(1);
        System.out.println(String.format("Found: %s\n", artist));

        // Testing the findAllArtist function.
        System.out.println("--- Find all artists ---");
        List<Artist> artists = service.findAllArtists();
        for (Artist currentArtist: artists)
        {
            System.out.println(String.format("Found: %s\n", currentArtist));
        }

        // Testing the changeArtistGenre function.
        System.out.println("--- Update artist ---");
        transaction = session.beginTransaction();
        artist = service.changeArtistGenre(1, "Indie Rock");
        transaction.commit();
        System.out.println(String.format("Updated: %s\n", artist));

        // Testing the removeArtist function.
        System.out.println("--- Remove artist ---");
        transaction = session.beginTransaction();
        service.removeArtist(1);
        transaction.commit();
        artist= service.findArtist(1);
        System.out.println(String.format("Found: %s\n", artist));

        // Closing session and factory
        session.close();
        sessionFactory.close();

    }

}
