package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Title")
    private String title;
    @Column(name = "Description")
    private String description;
    @Column(name = "Year")
    private int year;
    @Column(name = "Artist")
    private String artist;
    @Column(name = "Price")
    private Double price;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Artist> artistList  = new HashSet<>();



    public Cd() {}

    public Cd(String title, String description, int year, String artist, Double price) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.artist = artist;
        this.price = price;
    }

    public Cd(String title, String description, int year, String artist, Double price, Set<Artist> artistList) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.artist = artist;
        this.price = price;
        this.artistList = artistList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(Set<Artist> artistList) {
        this.artistList = artistList;
    }

    @Override
    public String toString() {
        return "Cd{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", artist='" + artist + '\'' +
                ", price=" + price +
                '}';
    }
}
