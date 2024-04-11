package Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="Equipes")
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipe_id")
    private long id;
    private String nom;
    private String abreviation;
    private Date dateCreation;
    private int nbreJoueurs;
    private String ville;
    private String pays;
    private String logo;
    @ManyToOne
    private Ligue ligue;
    @OneToMany(mappedBy = "equipe")
    private List<Joueur> joueurs;
}