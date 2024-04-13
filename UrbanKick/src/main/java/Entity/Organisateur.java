package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Organisateurs")
public class Organisateur extends Utilisateur {
    @Column(name="organisation")
    private String organisationName;
    private int experience;
    @OneToMany(mappedBy = "organisateur")
    private List<Ligue> ligues;
}