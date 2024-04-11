package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Compositions")
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "composition_id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;
    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
    @ManyToMany
    @JoinTable(
        name = "composition_joueurs",
        joinColumns = @JoinColumn(name = "composition_id"),
        inverseJoinColumns = @JoinColumn(name = "joueur_id")
    )
    private List<Joueur> joueursTitulaires;
    @ManyToMany
    @JoinTable(
        name = "composition_joueurs_remplacants",
        joinColumns = @JoinColumn(name = "composition_id"),
        inverseJoinColumns = @JoinColumn(name = "joueur_id")
    )
    private List<Joueur> joueursRemplacants;
    @ManyToOne
    private Joueur capitaineDomicile;
    @ManyToOne
    private Joueur capitaineExterieur;


}