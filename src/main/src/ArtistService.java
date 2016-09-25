import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * This class is a service with a CRUD-queries.
 * session - is an interface between a Java and Hibernate functionality.
 * @see ArtistService#ArtistService(Session)
 */

public class ArtistService {

    private Session session;

    /**
     * Constructor for the service's instance. Had a current session as an argument.
     * @param session - Session-typed. This param is the logical transaction.
     * @see ArtistService#createArtist(int, String, String)
     */
    public ArtistService(Session session) {
        this.session = session;
    }

    /**
     * This method is just a insert-query, just like <b>INSERT INTO table_name (col1, col2, col3) VALUES (id, name, genre)</b>
     * @param id - is for db's Primary Key
     * @param name - is for db's name VARCHAR
     * @param genre - is for db's genre VARCHAR
     * @return Artist-instance that was created.
     * @see ArtistService#removeArtist(int)
     */
    public Artist createArtist(int id, String name, String genre)
    {
        Artist artist = new Artist(id, name, genre);
        session.save(artist);
        return artist;
    }

    /**
     * This method is removing Artist for DB, just as you queries <b>DELETE FROM table_name WHERE table_name.id = id</b>.
     * @param id - is for db's Primary Key
     * @see ArtistService#changeArtistGenre(int, String)
     */
    public void removeArtist(int id)
    {
        Artist artist = (Artist) session.get(Artist.class, id);

        if (artist != null)
        {
            session.delete(artist);
        }
    }

    /**
     * This method is for changing Artist's genre in db by id. Just like <b>UPDATE table_name SET table_name.genre=genre
     *  WHERE table_name.id = id</b>.
     * @param id - is for queried Artist pk.
     * @param genre - new genre for this Artist.
     * @return - Artist instance that was changed.
     * @see ArtistService#findArtist(int)
     */
    public Artist changeArtistGenre(int id, String genre)
    {
        Artist artist = (Artist) session.get(Artist.class, id);

        if (artist != null)
        {
            artist.setGenre(genre);
        }

        return artist;
    }

    /**
     * This method is returning instance by pk. SELECT a FROM table_name WHERE table_name.id = id.
     * @param id - pk
     * @return - Artist instance that you've taken.
     * @see ArtistService#findAllArtists()
     */
    public Artist findArtist(int id)
    {
        return (Artist) session.get(Artist.class, id);
    }

    /**
     * This method is for getting all the instances from db.
     * @return - List<Artist>
     * @see ArtistService
     */
    public List<Artist> findAllArtists() {
        Query query = session.createQuery("SELECT a FROM Artist a");
        return query.list();
    }
}
