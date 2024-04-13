package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="matches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "stade_id")
    private Stade stade;
    @Enumerated(EnumType.STRING)
    private Resultat resultat;
    @ManyToOne
    private Ligue ligue;
    @ManyToOne
    private Equipe equipeDomicile;
    @ManyToOne
    private Equipe equipeExterieur;
    @ManyToOne
    @JoinColumn(name = "homme_du_match_id")
    private Joueur hommeDuMatch;
    private boolean prolongations;
    private boolean penalties;
    @OneToMany(mappedBy = "match")
    private List<Penalty> penaltiesTimeLine;
    @OneToMany(mappedBy = "match")
    private List<Composition> compositions;
    @ManyToOne
    private Tour tour;
    @OneToMany(mappedBy = "match")
    private List<FaitdeMatch> faitsdeMatchs;
    @OneToMany(mappedBy = "match")
    private List<StatJoueur> statsJoueurs;
    @OneToOne(mappedBy = "match")
    private StatsMatch statsMatch;
    @OneToMany(mappedBy = "match")
    private List<Commentaire> commentaires;
    @OneToMany(mappedBy = "match")
    private List<Pronostic> pronostics;
    @OneToMany(mappedBy = "match")
    private List<Vote> votes;

}