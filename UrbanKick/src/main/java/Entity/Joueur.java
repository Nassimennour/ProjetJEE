package Entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Joueurs")
public class Joueur extends Utilisateur {
    @Enumerated(EnumType.STRING)
    private Position poste;
    @Min(0) @Max(99)
    @Column(name = "numero_maillot")
    private int numero;
    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
    @OneToMany(mappedBy = "hommeDuMatch")
    private List<Match> matchesAsHommeDuMatch;
    @OneToMany(mappedBy = "joueur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StatJoueur> stats;
    @OneToMany(mappedBy = "joueur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Commentaire> commentaires;
    @OneToMany(mappedBy = "buteur")
    private List<Ligue> liguesAsButeur;
    @OneToMany(mappedBy = "meilleurJoueur")
    private List<Ligue> liguesAsMeilleurJoueur;



}