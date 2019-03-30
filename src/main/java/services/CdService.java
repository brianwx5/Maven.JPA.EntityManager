package services;

import entities.Cd;

import javax.persistence.*;
import java.util.List;

public class CdService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CD_ArtistJPA");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction etx;

    public CdService(EntityManager em) {
        this.em = em;
        this.etx = em.getTransaction();
    }

    public Cd createArtist(Long id, String title, String description, int year, String artist, Double price) {
        etx.begin();
        Cd cd = new Cd();
        cd.setId(id);
        cd.setTitle(title);
        cd.setDescription(description);
        cd.setYear(year);
        cd.setArtist(artist);
        cd.setPrice(price);

        em.persist(cd);
        etx.commit();
        return cd;
    }

    public Cd findArtist(Long id) {
        etx.begin();
        Cd cd = em.find(Cd.class,id);
        System.out.println(cd.toString());
        return cd;
    }

    public void updateCdPrice(Long id, Double price) {
        etx.begin();
        Cd cd =em.find(Cd.class,id);
        cd.setPrice(price);
        etx.commit();
    }

    public void removeCd(Long id) {
        Cd cd = em.find(Cd.class,id);
        etx.begin();
        em.remove(cd);
        etx.commit();

    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CD_ArtistJPA");
        EntityManager em = emf.createEntityManager();
        CdService cdService = new CdService(em);

//        cdService.createArtist(1L,"The Lonely Wolf","Great Music",2019,"Brian",30.99);
//        cdService.findArtist(1l);
//        cdService.updateCdPrice(1L,12.99);
        cdService.removeCd(1L);
    }
}
