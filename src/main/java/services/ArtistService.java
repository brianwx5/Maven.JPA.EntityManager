package services;

import entities.Artist;
import entities.Cd;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class ArtistService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CD_ArtistJPA");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction etx;

    public ArtistService(EntityManager em) {
        this.em = em;
        this.etx = em.getTransaction();
    }

    public Artist createArtist(String firstName, String lastName, String instruments, Set<Cd> cdSet) {
        etx.begin();
        Artist artist = new Artist();
        artist.setFirstName(firstName);
        artist.setLastName(lastName);
        artist.setInstruments(instruments);
        artist.setCdSet(cdSet);
        em.persist(artist);
        etx.commit();
        return artist;
    }

    public Artist findById(Long id) {
        Artist artist = em.find(Artist.class,id);
        System.out.println(artist.toString());
        return artist;
    }

    public List<Artist> findAll() {
        List<Artist> artistList;
        TypedQuery<Artist> query = em.createQuery("SELECT artist FROM Artist artist",Artist.class);
        artistList =query.getResultList();
        return artistList;
    }

    public void updateArtist(Long id, String instrument) {
        etx.begin();
        Artist artist = em.find(Artist.class,id);
        artist.setInstruments(instrument);
        etx.commit();
    }


    public void removeArtist(Long id) {
        Artist artist = em.find(Artist.class,id);
        etx.begin();
        em.remove(artist);
        etx.commit();
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CD_ArtistJPA");
        EntityManager em = emf.createEntityManager();
        ArtistService artistService = new ArtistService(em);

//        artistService.createArtist("Brian","James","Guitar");
//        artistService.findById(3l);
//        artistService.findAll();
//        System.out.println(artistService.findAll());
//        artistService.updateArtist(3l,"Piano");
//        artistService.removeArtist(3l);
    }

}
