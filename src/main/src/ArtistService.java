import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class ArtistService {

    private Session session;

    public ArtistService(Session session) {
        this.session = session;
    }

    public Artist createArtist(int id, String name, String genre)
    {
        Artist artist = new Artist(id, name, genre);
        session.save(artist);
        return artist;
    }

    public void removeArtist(int id)
    {
        Artist artist = (Artist) session.get(Artist.class, id);

        if (artist != null)
        {
            session.delete(artist);
        }
    }

    public Artist changeArtistGenre(int id, String genre)
    {
        Artist artist = (Artist) session.get(Artist.class, id);

        if (artist != null)
        {
            artist.setGenre(genre);
        }

        return artist;
    }

    public Artist findArtist(int id)
    {
        return (Artist) session.get(Artist.class, id);
    }

    public List findAllArtists() {
        Query query = session.createQuery("SELECT a FROM Artist a");
        return query.list();
    }
}
