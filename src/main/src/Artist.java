import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Artist {

    @Id
    private int id;

    private String name;
    private String genre;

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
