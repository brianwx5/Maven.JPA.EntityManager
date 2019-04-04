package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
    @Column(name = "Instruments")
    private String instruments;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Cd> cdSet = new HashSet<>();



    public Artist() {}

    public Artist(String firstName, String lastName, String instruments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.instruments = instruments;
    }

    public Artist(String firstName, String lastName, String instruments, Set<Cd> cdSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.instruments = instruments;
        this.cdSet = cdSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInstruments() {
        return instruments;
    }

    public void setInstruments(String instruments) {
        this.instruments = instruments;
    }

    public Set<Cd> getCdSet() {
        return cdSet;
    }

    public void setCdSet(Set<Cd> cdSet) {
        this.cdSet = cdSet;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", instruments='" + instruments + '\'' +
                '}';
    }
}
