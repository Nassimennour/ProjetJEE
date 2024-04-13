package Entity;

import javax.persistence.*;

@Entity
@Table(name="Votes", uniqueConstraints = {@UniqueConstraint(columnNames = {"match_id", "utilisateur_id"})})
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
    @ManyToOne
    @JoinColumn(name = "joueur_id")
    private Joueur joueur;
}