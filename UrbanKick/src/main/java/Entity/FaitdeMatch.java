package Entity;

import javax.persistence.*;

@Entity
@Table(name="FaitsdeMatchs")
public class FaitdeMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int minute;
    @Enumerated(EnumType.STRING)
    private TypeFait typeFait;
    @ManyToOne
    @JoinColumn(name = "joueurA_id")
    private Joueur joueurA;
    @ManyToOne
    @JoinColumn(name = "joueurB_id")
    private Joueur joueurB;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;
}