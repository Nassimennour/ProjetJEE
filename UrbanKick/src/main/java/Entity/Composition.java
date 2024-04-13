package Entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="Compositions")
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;
    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
    @Pattern(regexp = "\\d-(\\d-)*\\d", message = "formation non valide, veuillez entrer une formation valide")
    private String formation;
    @ManyToMany
    @JoinTable(
        name = "composition_joueurs",
        joinColumns = @JoinColumn(name = "composition_id"),
        inverseJoinColumns = @JoinColumn(name = "joueur_id")
    )
    @Size(max=11, message="La composition ne doit pas dépasser 11 joueurs titulaires")
    private List<Joueur> joueursTitulaires;
    @ManyToMany
    @JoinTable(
        name = "composition_joueurs_remplacants",
        joinColumns = @JoinColumn(name = "composition_id"),
        inverseJoinColumns = @JoinColumn(name = "joueur_id")
    )
    private List<Joueur> joueursRemplacants;
    @ManyToOne
    private Joueur capitaine;

}