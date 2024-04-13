package Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Ligues")
public class Ligue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String nom;
    private int recompense;
    private String description;
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
    @ManyToOne
    private Organisateur organisateur;
    @Enumerated(EnumType.STRING)
    private FormatLigue format;
    @OneToOne(mappedBy = "ligue")
    private RègleClassement règleClassement;
    private String logo;
    @ManyToOne
    @JoinColumn(name = "buteur_id")
    private Joueur buteur;
    @ManyToOne
    @JoinColumn(name = "meilleur_joueur_id")
    private Joueur meilleurJoueur;
    private int nbreEquipes;
    private int duréeMatch;
    private int nbreEquipesParPoule;
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
    @OneToMany(mappedBy = "ligue")
    private List<Classement> classements;

}