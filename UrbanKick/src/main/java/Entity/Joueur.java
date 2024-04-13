package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Joueurs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Joueur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
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