package Entity;

import javax.persistence.*;

@Entity
@Table(name="Penalties")
public class Penalty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "joueur_id")
    private Joueur joueur;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;
    private boolean marque;
    private int ordre;
}