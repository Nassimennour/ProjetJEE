package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="Equipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String nom;
    @NotNull
    @Size(min=2, max=5, message="L'abréviation doit contenir entre 2 et 5 caractères")
    private String abreviation;
    @PastOrPresent
    private Date dateCreation;
    @PositiveOrZero
    private int nbreJoueurs;
    private String ville;
    private String pays;
    private String logo;
    @ManyToOne
    private Ligue ligue;
    @OneToMany(mappedBy = "equipe", fetch = FetchType.LAZY)
    private List<Joueur> joueurs;
    @OneToMany(mappedBy = "equipe", fetch = FetchType.LAZY)
    private List<Classement> classements;
    @OneToMany(mappedBy = "equipeDomicile", fetch = FetchType.LAZY)
    private List<Match> matchesDomicile;
    @OneToMany(mappedBy = "equipeExterieur", fetch = FetchType.LAZY)
    private List<Match> matchesExterieur;
    @OneToMany(mappedBy = "equipe", fetch = FetchType.LAZY)
    private List<Commentaire> commentaires;
}