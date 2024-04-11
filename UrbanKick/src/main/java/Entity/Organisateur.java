package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Organisateurs")
public class Organisateur extends Utilisateur {
    @Column(name="organisation")
    private String organisationName;
    private int experience;

    @ElementCollection
    @CollectionTable(name = "organisateur_certifications", joinColumns = @JoinColumn(name = "organisateur_id"))
    @Column(name = "certification")
    private List<String> certifications;
}