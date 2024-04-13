package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="StatsJoueurs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatJoueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int minutesJoues;
    private int nbreButs;
    private int nbrePassesD;
    private int nbreTirs;
    private int nbreArrets;
    private int cartonsJ;
    private int cartonsR;
    @ManyToOne
    @JoinColumn(name = "joueur_id")
    private Joueur joueur;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;
}
