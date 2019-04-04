package services;

import entities.Artist;
import entities.Cd;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CdService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CD_ArtistJPA");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction etx;

    public CdService(EntityManager em) {
        this.em = em;
        this.etx = em.getTransaction();
    }

    public Cd createCd(String title, String description, int year, String artist, Double price, Set<Artist> artistSet) {
        etx.begin();
        Cd cd = new Cd();;
        cd.setTitle(title);
        cd.setDescription(description);
        cd.setYear(year);
        cd.setArtist(artist);
        cd.setPrice(price);
        cd.setArtistList(artistSet);
        em.persist(cd);
        etx.commit();
        return cd;
    }

    public Cd createCd(Cd cd) {
        etx.begin();
        em.persist(cd);
        etx.commit();
        return cd;
    }

    public Cd findCd(Long id) {
        etx.begin();
        Cd cd = em.find(Cd.class,id);
        System.out.println(cd.toString());
        return cd;
    }

    public List<Cd> findAllCd() {
        List<Cd> listOfCd;
        TypedQuery<Cd> query = em.createQuery("Select cddd FROM Cd cddd",Cd.class);
        listOfCd = query.getResultList();
        return listOfCd;
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

//        cdService.createCd("The Lonely Wolf","Great Music",2019,"Brian",30.99);
//        cdService.findCd(1l);
//        cdService.updateCdPrice(1L,12.99);
//        cdService.removeCd(1L);
        cdService.findAllCd();
        System.out.println(cdService.findAllCd());
    }
}
