package Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Ligues")
public class Ligue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ligue_id")
    private long id;
    private String nom;
    private int recompense;
    private Date dateDebut;
    private Date dateFin;
    private String ville;
    private String pays;
    @Enumerated(EnumType.STRING)
    private TypeLigue type;
    @Enumerated(EnumType.STRING)
    private Categorie categorie;
    @OneToOne
    private Equipe vainqueur;
    @OneToMany(mappedBy = "ligue")
    private List<Equipe> equipes;
    @OneToMany(mappedBy = "ligue")
    private List<Match> matches;
    private String logo;
    private int nbreEquipes;
    private int duréeMatch;
    private boolean horsJeu;
    private boolean cartons;
    private boolean prolongations;
    private boolean penalties;
    @ManyToMany
    @JoinTable(
        name = "ligue_regles",
        joinColumns = @JoinColumn(name = "ligue_id"),
        inverseJoinColumns = @JoinColumn(name = "regle_id")
    )
    private List<RègleDiscip> règlesDisciplinaires;

}