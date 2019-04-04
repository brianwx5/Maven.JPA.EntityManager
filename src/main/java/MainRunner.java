import entities.Artist;
import entities.Cd;
import services.CdService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class MainRunner {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CD_ArtistJPA");
        EntityManager em = emf.createEntityManager();

        CdService cdService = new CdService(em);
        Cd cd = createCd();

        //Create
        cdService.createCd(cd);
    }

    public static Cd createCd() {

        Set<Artist> artistSet = new HashSet<>();
        artistSet.add(new Artist("Brian","W","Guitar", new HashSet<>()));
        artistSet.add(new Artist("Cristina","McK","Singer", new HashSet<>()));
        artistSet.add(new Artist("El","B","Piano", new HashSet<>()));
        artistSet.add(new Artist("Sunnie","D","Bass", new HashSet<>()));
        artistSet.add(new Artist("Nirmala","Z","Drums", new HashSet<>()));

        return new Cd("The one cohort","Some music",2019,"Cohortiness",12.99,artistSet);
    }
}
