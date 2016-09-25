import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Artist {

    /**
     * This is a main class for using by SQL Server. Bean-typed class.
     * @Id id - annotation for the hibernate's primary key - INTEGER;
     * String name - is for the db.name - VARCHAR(30);
     * String genre - is for the db.genre - VARCHAR(20).
     */


    @Id
    private int id;

    private String name;
    private String genre;

    /**
     * Constructor for every query
     */
    public Artist(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public Artist() {

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {

        this.genre = genre;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
