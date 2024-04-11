package Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="matches")
public class Match {
    @Id
    @Column(name = "match_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime date;
    private String lieu;
    @Enumerated(EnumType.STRING)
    private Resultat resultat;
    @ManyToOne
    private Ligue ligue;
    @ManyToOne
    @JoinColumn(name = "homme_du_match_id")
    private Joueur hommeDuMatch;
    private boolean prolongations;
    private boolean penalties;
    @OneToMany(mappedBy = "match")
    private List<Penalty> penaltiesTimeLine;
    @OneToMany(mappedBy = "match")
    private List<Composition> compositions;
}